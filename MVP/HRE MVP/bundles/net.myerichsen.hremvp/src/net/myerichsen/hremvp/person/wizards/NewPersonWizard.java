package net.myerichsen.hremvp.person.wizards;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.wizard.Wizard;

import net.myerichsen.hremvp.person.providers.ParentProvider;
import net.myerichsen.hremvp.person.providers.PartnerProvider;
import net.myerichsen.hremvp.person.providers.PersonEventProvider;
import net.myerichsen.hremvp.person.providers.PersonNamePartProvider;
import net.myerichsen.hremvp.person.providers.PersonNameProvider;
import net.myerichsen.hremvp.person.providers.PersonProvider;
import net.myerichsen.hremvp.person.providers.SexProvider;

/**
 * Wizard to add a new person with sex, name, parents, partner, child and events
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 8. jun. 2019
 *
 */
public class NewPersonWizard extends Wizard {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;
	private final IEventBroker eventBroker;

	private NewPersonWizardPage1 page1;
	private NewPersonWizardPage2 page2;
	private NewPersonWizardPage3 page3;
	private NewPersonWizardPage4 page4;
	private NewPersonWizardPage5 page5;

	// Page 1
	private int personPid = 0;
	private int birthDatePid = 0;
	private int deathDatePid = 0;
	private int sexTypePid = 0;

	// Page 2
	private String personName;
	private int personNameStylePid = 0;
	private int fromDatePid = 0;
	private int toDatePid = 0;
	private Boolean primaryName;

	// Page 4
	private int fatherPid = 0;
	private int motherPid = 0;
	private int partnerPid = 0;
	private int childPid = 0;
	private int partnerFromDatePid = 0;
	private int partnerToDatePid = 0;
	private int fatherRolePid;
	private int motherRolePid;
	private int childRolePid;
	private int partnerRolePid;

	// Page 5
	private List<List<String>> eventList = new ArrayList<>();

	/**
	 * Constructor
	 *
	 * @param context The Eclipse Context
	 *
	 */
	public NewPersonWizard(IEclipseContext context) {
		setWindowTitle("New Person");
		setForcePreviousAndNextButtons(true);
		this.context = context;
		eventBroker = context.get(IEventBroker.class);
	}

	/**
	 *
	 */
	public void addBackPages() {
		page3 = new NewPersonWizardPage3();
		addPage(page3);
		page4 = new NewPersonWizardPage4(context);
		addPage(page4);
		page5 = new NewPersonWizardPage5(context);
		addPage(page5);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		page1 = new NewPersonWizardPage1(context);
		addPage(page1);
		page2 = new NewPersonWizardPage2(context);
		addPage(page2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		return ((getContainer().getCurrentPage() != page1)
				&& (getContainer().getCurrentPage() != page2));
	}

	/**
	 * @return the birthDatePid
	 */
	public int getBirthDatePid() {
		return birthDatePid;
	}

	/**
	 * @return the childPid
	 */
	public int getChildPid() {
		return childPid;
	}

	/**
	 * @return the childRolePid
	 */
	public int getChildRolePid() {
		return childRolePid;
	}

	/**
	 * @return the deathDatePid
	 */
	public int getDeathDatePid() {
		return deathDatePid;
	}

	/**
	 * @return the eventList
	 */
	public List<List<String>> getEventList() {
		return eventList;
	}

	/**
	 * @return the fatherPid
	 */
	public int getFatherPid() {
		return fatherPid;
	}

	/**
	 * @return the fatherRolePid
	 */
	public int getFatherRolePid() {
		return fatherRolePid;
	}

	/**
	 * @return the fromDatePid
	 */
	public int getFromDatePid() {
		return fromDatePid;
	}

	/**
	 * @return the motherPid
	 */
	public int getMotherPid() {
		return motherPid;
	}

	/**
	 * @return the motherRolePid
	 */
	public int getMotherRolePid() {
		return motherRolePid;
	}

	/**
	 * @return the page1
	 */
	public NewPersonWizardPage1 getPage1() {
		return page1;
	}

	/**
	 * @return the page2
	 */
	public NewPersonWizardPage2 getPage2() {
		return page2;
	}

	/**
	 * @return the page3
	 */
	public NewPersonWizardPage3 getPage3() {
		return page3;
	}

	/**
	 * @return the page4
	 */
	public NewPersonWizardPage4 getPage4() {
		return page4;
	}

	/**
	 * @return the page5
	 */
	public NewPersonWizardPage5 getPage5() {
		return page5;
	}

	/**
	 * @return the partnerFromDatePid
	 */
	public int getPartnerFromDatePid() {
		return partnerFromDatePid;
	}

	/**
	 * @return the partnerPid
	 */
	public int getPartnerPid() {
		return partnerPid;
	}

	/**
	 * @return the partnerRolePid
	 */
	public int getPartnerRolePid() {
		return partnerRolePid;
	}

	/**
	 * @return the partnerToDatePid
	 */
	public int getPartnerToDatePid() {
		return partnerToDatePid;
	}

	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * @return the personNameStylePid
	 */
	public int getPersonNameStylePid() {
		return personNameStylePid;
	}

	/**
	 * @return the personPid
	 */
	public int getPersonPid() {
		return personPid;
	}

	/**
	 * @return the sexTypePid
	 */
	public int getSexTypePid() {
		return sexTypePid;
	}

	/**
	 * @return the toDatePid
	 */
	public int getToDatePid() {
		return toDatePid;
	}

	/**
	 * @return the primaryName
	 */
	public Boolean isPrimaryName() {
		return primaryName;
	}

	/**
	 * /* (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		context.get(IEventBroker.class);

		try {
			// Page 1
			// Create a new person
			final PersonProvider personProvider = new PersonProvider();
			personProvider.setBirthDatePid(birthDatePid);
			personProvider.setDeathDatePid(deathDatePid);
			personPid = personProvider.insert();
			LOGGER.log(Level.FINE, "Inserted person {0}",
					Integer.toString(personPid));

			// Create a sex for the person
			final SexProvider sexProvider = new SexProvider();
			sexProvider.setPersonPid(personPid);
			sexProvider.setSexTypePid(sexTypePid);
			sexProvider.setPrimarySex(true);
			final int sexPid = sexProvider.insert();
			LOGGER.log(Level.FINE, "Inserted sex {0}",
					Integer.toString(sexPid));

			// Page 2
			// Create a new name
			final PersonNameProvider personNameProvider = new PersonNameProvider();
			personNameProvider.setPersonPid(personPid);
			personNameProvider.setNameStylePid(personNameStylePid);
			personNameProvider.setFromDatePid(fromDatePid);
			personNameProvider.setToDatePid(toDatePid);
			personNameProvider.setPrimaryName(true);
			final int namePid = personNameProvider.insert();
			LOGGER.log(Level.FINE, "Inserted name {0}",
					Integer.toString(namePid));

			// Page 3
			// Create name parts
			PersonNamePartProvider pnpp;
			String string;
			int namePartPid;
			final List<List<String>> lls = page3.getLls();

			if (lls == null) {
				page3.setErrorMessage("Please enter a name");
				return false;
			}

			// Create each name part
			for (int i = 0; i < lls.size(); i++) {
				string = lls.get(i).get(5);

				if (string != null) {
					pnpp = new PersonNamePartProvider();
					pnpp.setNamePid(namePid);
					pnpp.setLabel(string);
					pnpp.setPartNo(i + 1);
					namePartPid = pnpp.insert();
					LOGGER.log(Level.FINE, "Inserted name part {0}: {1}",
							new Object[] { namePartPid, string });
				}
			}

			// Page 4
			ParentProvider parentProvider;
			int parentPid;

			// Create father
			if (fatherPid != 0) {
				parentProvider = new ParentProvider();
				parentProvider.setChild(personPid);
				parentProvider.setParent(fatherPid);
				parentProvider.setParentRolePid(fatherRolePid);
				parentProvider.setPrimaryParent(true);
				parentPid = parentProvider.insert();
				LOGGER.log(Level.FINE, "Inserted father pid {0}",
						Integer.toString(parentPid));
			}

			// Create mother
			if (motherPid != 0) {
				parentProvider = new ParentProvider();
				parentProvider.setChild(personPid);
				parentProvider.setParent(motherPid);
				parentProvider.setParentRolePid(motherRolePid);
				parentProvider.setPrimaryParent(true);
				parentPid = parentProvider.insert();
				LOGGER.log(Level.FINE, "Inserted mother pid {0}",
						Integer.toString(parentPid));
			}

			// Create child
			if (childPid != 0) {
				parentProvider = new ParentProvider();
				parentProvider.setParent(personPid);
				parentProvider.setChild(childPid);
				parentProvider.setParentRolePid(childRolePid);
				parentProvider.setPrimaryParent(true);
				parentPid = parentProvider.insert();
				LOGGER.log(Level.FINE, "Inserted child pid {0}",
						Integer.toString(parentPid));
			}

			// Create partner
			if (partnerPid != 0) {
				final PartnerProvider partnerProvider = new PartnerProvider();
				partnerProvider.setPartner1(personPid);
				partnerProvider.setPartner2(partnerPid);
				partnerProvider.setPrimaryPartner(true);
				partnerProvider.setPartnerRolePid(partnerRolePid);
				partnerProvider.setFromDatePid(partnerFromDatePid);
				partnerProvider.setToDatePid(partnerToDatePid);
				partnerProvider.insert();
				LOGGER.log(Level.FINE, "Inserted partner pid {0}",
						Integer.toString(partnerPid));
			}

			// Page 5
			// Create a personEvent to link events to person
			for (final List<String> list : eventList) {
				final PersonEventProvider pep = new PersonEventProvider();
				pep.setEventPid(Integer.parseInt(list.get(0)));
				pep.setPersonPid(personPid);
				pep.setPrimaryEvent(true);
				pep.setPrimaryPerson(true);
				pep.setEventRolePid(Integer.parseInt(list.get(3)));
				final int personEventPid = pep.insert();
				LOGGER.log(Level.FINE, "Inserted person-event pid {0}",
						Integer.toString(personEventPid));
			}
			personProvider.get(personPid);
			eventBroker.post("MESSAGE", personProvider.getPrimaryName()
					+ " inserted in the database as no. " + personPid);
			eventBroker.post(
					net.myerichsen.hremvp.Constants.PERSON_PID_UPDATE_TOPIC,
					personPid);
			eventBroker.post(
					net.myerichsen.hremvp.Constants.PERSON_NAME_PID_UPDATE_TOPIC,
					namePid);
			return true;
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			eventBroker.post("MESSAGE", e.getMessage());
		}
		return false;
	}

	/**
	 * @param birthDatePid the birthDatePid to set
	 */
	public void setBirthDatePid(int birthDatePid) {
		this.birthDatePid = birthDatePid;
	}

	/**
	 * @param childPid the childPid to set
	 */
	public void setChildPid(int childPid) {
		this.childPid = childPid;
	}

	/**
	 * @param childRolePid the childRolePid to set
	 */
	public void setChildRolePid(int childRolePid) {
		this.childRolePid = childRolePid;
	}

	/**
	 * @param deathDatePid the deathDatePid to set
	 */
	public void setDeathDatePid(int deathDatePid) {
		this.deathDatePid = deathDatePid;
	}

	/**
	 * @param eventList the eventList to set
	 */
	public void setEventList(List<List<String>> eventList) {
		this.eventList = eventList;
	}

	/**
	 * @param fatherPid the fatherPid to set
	 */
	public void setFatherPid(int fatherPid) {
		this.fatherPid = fatherPid;
	}

	/**
	 * @param fatherRolePid the fatherRolePid to set
	 */
	public void setFatherRolePid(int fatherRolePid) {
		this.fatherRolePid = fatherRolePid;
	}

	/**
	 * @param fromDatePid the fromDatePid to set
	 */
	public void setFromDatePid(int fromDatePid) {
		this.fromDatePid = fromDatePid;
	}

	/**
	 * @param motherPid the motherPid to set
	 */
	public void setMotherPid(int motherPid) {
		this.motherPid = motherPid;
	}

	/**
	 * @param motherRolePid the motherRolePid to set
	 */
	public void setMotherRolePid(int motherRolePid) {
		this.motherRolePid = motherRolePid;
	}

	/**
	 * @param partnerFromDatePid the partnerFromDatePid to set
	 */
	public void setPartnerFromDatePid(int partnerFromDatePid) {
		this.partnerFromDatePid = partnerFromDatePid;
	}

	/**
	 * @param partnerPid the partnerPid to set
	 */
	public void setPartnerPid(int partnerPid) {
		this.partnerPid = partnerPid;
	}

	/**
	 * @param partnerRolePid the partnerRolePid to set
	 */
	public void setPartnerRolePid(int partnerRolePid) {
		this.partnerRolePid = partnerRolePid;
	}

	/**
	 * @param partnerToDatePid the partnerToDatePid to set
	 */
	public void setPartnerToDatePid(int partnerToDatePid) {
		this.partnerToDatePid = partnerToDatePid;
	}

	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/**
	 * @param personNameStylePid the personNameStylePid to set
	 */
	public void setPersonNameStylePid(int personNameStylePid) {
		this.personNameStylePid = personNameStylePid;
	}

	/**
	 * @param personPid the personPid to set
	 */
	public void setPersonPid(int personPid) {
		this.personPid = personPid;
	}

	/**
	 * @param primaryName the primaryName to set
	 */
	public void setPrimaryName(Boolean primaryName) {
		this.primaryName = primaryName;
	}

	/**
	 * @param sexTypePid the sexTypePid to set
	 */
	public void setSexTypePid(int sexTypePid) {
		this.sexTypePid = sexTypePid;
	}

	/**
	 * @param toDatePid the toDatePid to set
	 */
	public void setToDatePid(int toDatePid) {
		this.toDatePid = toDatePid;
	}
}