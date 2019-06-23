package net.myerichsen.hremvp.location.wizards;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.wizard.Wizard;

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.location.providers.LocationNamePartProvider;
import net.myerichsen.hremvp.location.providers.LocationNameProvider;

/**
 * Wizard to add a new location name
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 17. apr. 2019
 *
 */
public class NewLocationNameWizard extends Wizard {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;

	private NewLocationNameWizardPage1 page1;
	private NewLocationNameWizardPage2 page2;

	private int locationNameStylePid = 0;
	private int fromDatePid = 0;
	private int toDatePid = 0;
	private String preposition = "";
	private Boolean isPrimaryLocationName = false;
	private String locationName;
	private List<String> locationNamePartList = new ArrayList<>();
	private int locationPid = 0;

	/**
	 * Constructor
	 *
	 * @param locationPid
	 * @param context     The Eclipse Context
	 *
	 */
	public NewLocationNameWizard(int locationPid, IEclipseContext context) {
		setWindowTitle("New Location Name");
		setForcePreviousAndNextButtons(true);
		this.context = context;
		this.locationPid = locationPid;
	}

	/**
	 *
	 */
	public void addPage2() {
		page2 = new NewLocationNameWizardPage2(context);
		addPage(page2);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		page1 = new NewLocationNameWizardPage1(context);
		addPage(page1);
	}

	/**
	 * @return the fromDatePid
	 */
	public int getFromDatePid() {
		return fromDatePid;
	}

	/**
	 * @return the isPrimaryLocationName
	 */
	public Boolean getIsPrimaryLocationName() {
		return isPrimaryLocationName;
	}

	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * @return the locationNamePartList
	 */
	public List<String> getLocationNamePartList() {
		return locationNamePartList;
	}

	/**
	 * @return the locationNameStyle
	 */
	public int getLocationNameStylePid() {
		return locationNameStylePid;
	}

	/**
	 * @return the page1
	 */
	public NewLocationNameWizardPage1 getPage1() {
		return page1;
	}

	/**
	 * @return the page2
	 */
	public NewLocationNameWizardPage2 getPage2() {
		return page2;
	}

	/**
	 * @return the preposition
	 */
	public String getPreposition() {
		return preposition;
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
		String label;

		if (page2 == null) {
			return false;
		}

		final IEventBroker eventBroker = context.get(IEventBroker.class);

		try {
			final LocationNameProvider lnp = new LocationNameProvider();
			lnp.setLocationPid(locationPid);
			lnp.setLocationNameStylePid(locationNameStylePid);
			lnp.setFromDatePid(fromDatePid);
			lnp.setToDatePid(toDatePid);
			lnp.setPreposition(preposition);
			lnp.setPrimaryLocationName(isPrimaryLocationName);
			final int locationNamePid = lnp.insert();
			LOGGER.log(Level.INFO, "Inserted location name {0}",
					locationNamePid);

			LocationNamePartProvider lnpp;

			for (int i = 0; i < locationNamePartList.size(); i++) {
				lnpp = new LocationNamePartProvider();
				lnpp.setLocationNamePid(locationNamePid);
				lnpp.setPartNo(i + 1);
				label = locationNamePartList.get(i);
				lnpp.setLabel(label);

				final int locationNamePartPid = lnpp.insert();
				LOGGER.log(Level.INFO, "Inserted location name part {0}: {1}",
						new Object[] { locationNamePartPid, label });
			}

			eventBroker.post("MESSAGE", locationName
					+ " inserted in the database as no. " + locationPid);
			eventBroker.post(Constants.LOCATION_PID_UPDATE_TOPIC, locationPid);
			eventBroker.post(Constants.LOCATION_NAME_PID_UPDATE_TOPIC,
					locationNamePid);
			return true;
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			eventBroker.post("MESSAGE", e.getMessage());
		}
		return false;
	}

	/**
	 * @param fromDatePid the fromDatePid to set
	 */
	public void setFromDatePid(int fromDatePid) {
		this.fromDatePid = fromDatePid;
	}

	/**
	 * @param isPrimaryLocationName the isPrimaryLocationName to set
	 */
	public void setIsPrimaryLocationName(Boolean isPrimaryLocationName) {
		this.isPrimaryLocationName = isPrimaryLocationName;
	}

	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * @param locationNamePartList the locationNamePartList to set
	 */
	public void setLocationNamePartList(List<String> locationNamePartList) {
		this.locationNamePartList = locationNamePartList;
	}

	/**
	 * @param locationNameStyle the locationNameStyle to set
	 */
	public void setLocationNameStylePid(int locationNameStylePid) {
		this.locationNameStylePid = locationNameStylePid;
	}

	/**
	 * @param preposition the preposition to set
	 */
	public void setPreposition(String preposition) {
		this.preposition = preposition;
	}

	/**
	 * @param toDatePid the toDatePid to set
	 */
	public void setToDatePid(int toDatePid) {
		this.toDatePid = toDatePid;
	}

}
