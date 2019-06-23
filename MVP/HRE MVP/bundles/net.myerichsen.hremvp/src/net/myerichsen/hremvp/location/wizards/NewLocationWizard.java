package net.myerichsen.hremvp.location.wizards;

import java.math.BigDecimal;
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
import net.myerichsen.hremvp.location.providers.LocationProvider;

/**
 * Wizard to add a new location
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 22. apr. 2019
 *
 */
public class NewLocationWizard extends Wizard {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private final IEclipseContext context;
	private NewLocationWizardPage1 page1;
	private NewLocationWizardPage2 page2;
	private NewLocationWizardPage3 page3;
	private NewLocationWizardPage4 page4;
	private int locationPid;

	// Page 1
	private int locationNameStylePid = 0;
	private int nameFromDatePid = 0;
	private int nameToDatePid = 0;
	private String preposition = "";
	private Boolean isPrimaryLocationName = true;
	// Page 2
	private String locationName;
	private List<String> locationNamePartList = new ArrayList<>();
	private Double xCoordinate = 0D;
	private Double yCoordinate = 0D;
	// Page 3
	private int fromDatePid = 0;
	private int toDatePid = 0;
	private Double zCoordinate = 0D;
	private Boolean isPrimaryLocation = true;

	/**
	 * Constructor
	 *
	 * @param context The Eclipse Context
	 *
	 */
	public NewLocationWizard(IEclipseContext context) {
		setWindowTitle("New Location");
		setForcePreviousAndNextButtons(true);
		this.context = context;
	}

	/**
	 *
	 */
	public void addBackPages() {
		page3 = new NewLocationWizardPage3(context);
		addPage(page3);
		page4 = new NewLocationWizardPage4();
		addPage(page4);
	}

	/**
	 *
	 */
	public void addPage2() {
		page2 = new NewLocationWizardPage2(context);
		addPage(page2);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		page1 = new NewLocationWizardPage1(context);
		addPage(page1);
	}

	/**
	 * @return the fromDatePid
	 */
	public int getFromDatePid() {
		return fromDatePid;
	}

	/**
	 * @return the isPrimaryLocation
	 */
	public Boolean getIsPrimaryLocation() {
		return isPrimaryLocation;
	}

	/**
	 * @return the isPrimaryLocationName
	 */
	public Boolean getIsPrimaryLocationName() {
		return isPrimaryLocationName;
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
	 * @return the locationPid
	 */
	public int getLocationPid() {
		return locationPid;
	}

	/**
	 * @return the nameFromDatePid
	 */
	public int getNameFromDatepid() {
		return nameFromDatePid;
	}

	/**
	 * @return the nameToDatePid
	 */
	public int getNameToDatePid() {
		return nameToDatePid;
	}

	/**
	 * @return the page1
	 */
	public NewLocationWizardPage1 getPage1() {
		return page1;
	}

	/**
	 * @return the page2
	 */
	public NewLocationWizardPage2 getPage2() {
		return page2;
	}

	/**
	 * @return the page3
	 */
	public NewLocationWizardPage3 getPage3() {
		return page3;
	}

	/**
	 * @return the page4
	 */
	public NewLocationWizardPage4 getPage4() {
		return page4;
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

	/**
	 * @return the xCoordinate
	 */
	public Double getxCoordinate() {
		return xCoordinate;
	}

	/**
	 * @return the yCoordinate
	 */
	public Double getyCoordinate() {
		return yCoordinate;
	}

	/**
	 * @return the zCoordinate
	 */
	public Double getzCoordinate() {
		return zCoordinate;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		if (page3 == null) {
			return false;
		}

		final IEventBroker eventBroker = context.get(IEventBroker.class);

		try {
			final LocationProvider lp = new LocationProvider();
			lp.setFromDatePid(fromDatePid);
			lp.setToDatePid(toDatePid);
			lp.setxCoordinate(BigDecimal.valueOf(xCoordinate));
			lp.setyCoordinate(BigDecimal.valueOf(yCoordinate));
			lp.setzCoordinate(BigDecimal.valueOf(zCoordinate));
			lp.setPrimaryLocation(isPrimaryLocation);

			locationPid = lp.insert();
			LOGGER.log(Level.INFO, "Inserted location {0}", locationPid);

			final LocationNameProvider lnp = new LocationNameProvider();
			lnp.setLocationPid(locationPid);
			lnp.setFromDatePid(nameFromDatePid);
			lnp.setToDatePid(nameToDatePid);
			lnp.setPrimaryLocationName(isPrimaryLocationName);
			lnp.setLocationNameStylePid(locationNameStylePid);
			lnp.setPrimaryLocationName(isPrimaryLocationName);
			lnp.setPreposition(preposition);

			final int locationNamePid = lnp.insert();
			LOGGER.log(Level.INFO, "Inserted location name {0}",
					locationNamePid);

			LocationNamePartProvider lnpp;

			for (int i = 0; i < locationNamePartList.size(); i++) {
				lnpp = new LocationNamePartProvider();
				lnpp.setLocationNamePid(locationNamePid);
				lnpp.setPartNo(i + 1);
				lnpp.setLabel(locationNamePartList.get(i));

				final int locationNamePartPid = lnpp.insert();
				LOGGER.log(Level.INFO, "Inserted location name part {0}",
						locationNamePartPid);
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
	 * @param isPrimaryLocation the isPrimaryLocation to set
	 */
	public void setIsPrimaryLocation(Boolean isPrimaryLocation) {
		this.isPrimaryLocation = isPrimaryLocation;
	}

	/**
	 * @param isPrimaryLocationName the isPrimaryLocationName to set
	 */
	public void setIsPrimaryLocationName(Boolean isPrimaryLocationName) {
		this.isPrimaryLocationName = isPrimaryLocationName;
	}

	/**
	 * @param string
	 */
	public void setLocationName(String string) {
		locationName = string;

	}

	/**
	 * @param stringList the locationNamePartList to set
	 */
	public void setLocationNamePartList(List<String> stringList) {
		locationNamePartList = stringList;
	}

	/**
	 * @param locationNameStyle the locationNameStyle to set
	 */
	public void setLocationNameStylePid(int locationNameStylePid) {
		this.locationNameStylePid = locationNameStylePid;
	}

	/**
	 * @param locationPid the locationPid to set
	 */
	public void setLocationPid(int locationPid) {
		this.locationPid = locationPid;
	}

	/**
	 * @param nameFromDatepid the nameFromDatepid to set
	 */
	public void setNameFromDatePid(int nameFromDatePid) {
		this.nameFromDatePid = nameFromDatePid;
	}

	/**
	 * @param nameToDatePid the nameToDatePid to set
	 */
	public void setNameToDatePid(int nameToDatePid) {
		this.nameToDatePid = nameToDatePid;
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

	/**
	 * @param xCoordinate the xCoordinate to set
	 */
	public void setxCoordinate(Double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	/**
	 * @param yCoordinate the yCoordinate to set
	 */
	public void setyCoordinate(Double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	/**
	 * @param zCoordinate the zCoordinate to set
	 */
	public void setzCoordinate(Double zCoordinate) {
		this.zCoordinate = zCoordinate;
	}

}
