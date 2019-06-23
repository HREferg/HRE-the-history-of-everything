package net.myerichsen.hremvp.event.wizards;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.wizard.Wizard;

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.event.providers.EventProvider;
import net.myerichsen.hremvp.location.providers.LocationEventProvider;
import net.myerichsen.hremvp.person.providers.PersonEventProvider;

/**
 * Wizard to add a new event
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 21. apr. 2019
 *
 */
public class NewEventWizard extends Wizard {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;

	private NewEventWizardPage1 page1;
	private NewEventWizardPage2 page2;
	private NewEventWizardPage3 page3;

	// Page 1
	private int eventTypePid = 0;
	private String eventName = "";
	private int languagePid = 0;
	private int fromDatePid = 0;
	private int toDatePid = 0;

	// Page 2
	private int locationPid = 0;
	private Boolean primaryLocation = true;
	private Boolean primaryLocationEvent = true;

	// Page 3
	private int personPid = 0;
	private int eventRolePid = 0;
	private Boolean primaryPerson = true;
	private Boolean primaryPersonEvent = true;

	private final IEventBroker eventBroker;

	/**
	 * Constructor
	 *
	 * @param context The Eclipse Context
	 *
	 */
	public NewEventWizard(IEclipseContext context) {
		setWindowTitle("New Event");
		setForcePreviousAndNextButtons(true);
		this.context = context;
		eventBroker = context.get(IEventBroker.class);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		page1 = new NewEventWizardPage1(context);
		addPage(page1);
		page2 = new NewEventWizardPage2(context);
		addPage(page2);
		page3 = new NewEventWizardPage3(context);
		addPage(page3);
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @return the eventRolePid
	 */
	public int getEventRolePid() {
		return eventRolePid;
	}

	/**
	 * @return the eventTypePid
	 */
	public int getEventTypePid() {
		return eventTypePid;
	}

	/**
	 * @return the fromDatePid
	 */
	public int getFromDatePid() {
		return fromDatePid;
	}

	/**
	 * @return the primaryLocation
	 */
	public Boolean getIsPrimaryLocation() {
		return primaryLocation;
	}

	/**
	 * @return the primaryLocationEvent
	 */
	public Boolean getIsPrimaryLocationEvent() {
		return primaryLocationEvent;
	}

	/**
	 * @return the primaryPerson
	 */
	public Boolean getIsPrimaryPerson() {
		return primaryPerson;
	}

	/**
	 * @return the primaryPersonEvent
	 */
	public Boolean getIsPrimaryPersonEvent() {
		return primaryPersonEvent;
	}

	/**
	 * @return the languagePid
	 */
	public int getLanguagePid() {
		return languagePid;
	}

	/**
	 * @return the locationPid
	 */
	public int getLocationPid() {
		return locationPid;
	}

	/**
	 * @return the page1
	 */
	public NewEventWizardPage1 getPage1() {
		return page1;
	}

	/**
	 * @return the page2
	 */
	public NewEventWizardPage2 getPage2() {
		return page2;
	}

	/**
	 * @return the page3
	 */
	public NewEventWizardPage3 getPage3() {
		return page3;
	}

	/**
	 * @return the personPid
	 */
	public int getPersonPid() {
		return personPid;
	}

	/**
	 * @return the toDatePid
	 */
	public int getToDatePid() {
		return toDatePid;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		try {
			final EventProvider provider = new EventProvider();
			provider.setFromDatePid(fromDatePid);
			provider.setToDatePid(toDatePid);
			provider.setEventName(eventName);
			provider.setEventTypePid(eventTypePid);
			final int eventPid = provider.insert();
			LOGGER.log(Level.INFO, "Inserted event pid {0}", eventPid);

			if (locationPid != 0) {
				final LocationEventProvider lep = new LocationEventProvider();
				lep.setEventPid(eventPid);
				lep.setLocationPid(locationPid);
				lep.setPrimaryLocation(primaryLocation);
				lep.setPrimaryEvent(primaryLocationEvent);
				final int locationEventsPid = lep.insert();
				LOGGER.log(Level.INFO, "Inserted location event {0}",
						locationEventsPid);
			}

			if (personPid != 0) {
				final PersonEventProvider pep = new PersonEventProvider();
				pep.setEventPid(eventPid);
				pep.setPersonPid(personPid);
				pep.setEventRolePid(eventRolePid);
				pep.setPrimaryPerson(primaryPerson);
				pep.setPrimaryEvent(primaryPersonEvent);
				final int personEventPid = pep.insert();
				LOGGER.log(Level.INFO, "Inserted person event pid {0}",
						personEventPid);
			}

			eventBroker.post("MESSAGE",
					eventName + " inserted in the database as no. " + eventPid);
			eventBroker.post(Constants.EVENT_PID_UPDATE_TOPIC, eventPid);
			return true;
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return false;
	}

	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @param eventRolePid the eventRolePid to set
	 */
	public void setEventRolePid(int eventRolePid) {
		this.eventRolePid = eventRolePid;
	}

	/**
	 * @param eventTypePid the eventTypePid to set
	 */
	public void setEventTypePid(int eventTypePid) {
		this.eventTypePid = eventTypePid;
	}

	/**
	 * @param fromDatePid the fromDatePid to set
	 */
	public void setFromDatePid(int fromDatePid) {
		this.fromDatePid = fromDatePid;
	}

	/**
	 * @param primaryPersonEvent the primaryPersonEvent to set
	 */
	public void setIsPrimaryPersonEvent(Boolean isPrimaryPersonEvent) {
		primaryPersonEvent = isPrimaryPersonEvent;
	}

	/**
	 * @param languagePid the languagePid to set
	 */
	public void setLanguagePid(int languagePid) {
		this.languagePid = languagePid;
	}

	/**
	 * @param locationPid the locationPid to set
	 */
	public void setLocationPid(int locationPid) {
		this.locationPid = locationPid;
	}

	/**
	 * @param page1 the page1 to set
	 */
	public void setPage1(NewEventWizardPage1 page1) {
		this.page1 = page1;
	}

	/**
	 * @param page2 the page2 to set
	 */
	public void setPage2(NewEventWizardPage2 page2) {
		this.page2 = page2;
	}

	/**
	 * @param page3 the page3 to set
	 */
	public void setPage3(NewEventWizardPage3 page3) {
		this.page3 = page3;
	}

	/**
	 * @param personPid the personPid to set
	 */
	public void setPersonPid(int personPid) {
		this.personPid = personPid;
	}

	/**
	 * @param primaryLocation the primaryLocation to set
	 */
	public void setPrimaryLocation(Boolean primaryLocation) {
		this.primaryLocation = primaryLocation;
	}

	/**
	 * @param primaryLocationEvent the primaryLocationEvent to set
	 */
	public void setPrimaryLocationEvent(Boolean primaryLocationEvent) {
		this.primaryLocationEvent = primaryLocationEvent;
	}

	/**
	 * @param primaryPerson the primaryPerson to set
	 */
	public void setPrimaryPerson(Boolean primaryPerson) {
		this.primaryPerson = primaryPerson;
	}

	/**
	 * @param toDatePid the toDatePid to set
	 */
	public void setToDatePid(int toDatePid) {
		this.toDatePid = toDatePid;
	}

}
