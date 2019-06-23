package net.myerichsen.hremvp.location.servers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.LocationNameMaps;
import net.myerichsen.hremvp.dbmodels.LocationNameParts;
import net.myerichsen.hremvp.dbmodels.LocationNameStyles;
import net.myerichsen.hremvp.dbmodels.LocationNames;
import net.myerichsen.hremvp.providers.HDateProvider;

/**
 * Business logic interface for
 * {@link net.myerichsen.hremvp.dbmodels.LocationNames}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 21. apr. 2019
 *
 */
public class LocationNameServer implements IHREServer {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private int locationNamePid;
	private int locationPid;
	private int fromDatePid;
	private int toDatePid;
	private boolean primaryLocationName;
	private int locationNameStylePid;
	private String locationNameStyleLabel;
	private String preposition;
	private List<LocationNameMaps> mapList;
	private List<LocationNameParts> partList;

	private final LocationNames name;
	private final LocationNameStyles style;

	/**
	 * Constructor
	 *
	 */
	public LocationNameServer() {
		name = new LocationNames();
		style = new LocationNameStyles();
		mapList = new ArrayList<>();
		partList = new ArrayList<>();
	}

	/**
	 * Delete a row
	 *
	 * @param key The persistent ID of the location
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 *
	 */
	@Override
	public void delete(int key) throws Exception {
		name.delete(key);
	}

	/**
	 * @param locationPid The persistent id of the location
	 * @throws Exception Any exception
	 */
	public void deleteAllNamesForLocation(int locationPid) throws Exception {
		final List<LocationNames> fkLocationPid = name
				.getFKLocationPid(locationPid);

		for (final LocationNames locationNames : fkLocationPid) {
			name.delete(locationNames.getLocationNamePid());
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#deleteRemote(java.lang.String)
	 */
	@Override
	public void deleteRemote(String target) {
		// TODO Auto-generated method stub

	}

	/**
	 * Get a row
	 *
	 * @param key The persistent id of the location
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 *
	 */
	@Override
	public void get(int key) throws Exception {
		name.get(key);
		setFromDatePid(name.getFromDatePid());
		setLocationNamePid(key);
		setLocationNameStylePid(name.getLocationNameStylePid());
		setPrimaryLocationName(name.isPrimaryLocationName());
		setLocationPid(name.getLocationPid());
		setToDatePid(name.getToDatePid());
		setPreposition(name.getPreposition());

		style.get(locationNameStylePid);
		setLocationNameStyleLabel("style.getLabelPid()");

		LOGGER.log(Level.FINE, "Location PID: {0}", name.getLocationPid());
		LOGGER.log(Level.FINE, "Location name PID: {0}", key);
		LOGGER.log(Level.FINE, "Location name style PID: {0}",
				name.getLocationNameStylePid());
	}

	/**
	 * @param locationPid The persistent id of the location
	 * @return A list of location name pids
	 * @throws Exception
	 */
	public List<Integer> getFKLocationPid(int locationPid) throws Exception {
		final List<LocationNames> fkLocationPid = name
				.getFKLocationPid(locationPid);
		final List<Integer> li = new ArrayList<>();

		for (final LocationNames locationNames : fkLocationPid) {
			li.add(locationNames.getLocationNamePid());
		}
		return li;
	}

	/**
	 * @return the fromDate
	 */
	public int getFromDatePid() {
		return fromDatePid;
	}

	/**
	 * @return the locationNamePid
	 */
	public int getLocationNamePid() {
		return locationNamePid;
	}

	/**
	 * @return the locationNameStyleLabel
	 */
	public String getLocationNameStyleLabel() {
		return locationNameStyleLabel;
	}

	/**
	 * @return the locationNameStylePid
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
	 * @return the mapList
	 */
	public List<LocationNameMaps> getMapList() {
		return mapList;
	}

	/**
	 * @return the partList
	 */
	public List<LocationNameParts> getPartList() {
		return partList;
	}

	/**
	 * @return the preposition
	 */
	public String getPreposition() {
		return preposition;
	}

	/**
	 * Get a string of name parts for the primary name of a location
	 *
	 * @param locationPid The persistent ID of the location
	 * @return s The primary name
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 */
	public String getPrimaryNameString(int locationPid) throws Exception {
		final StringBuilder sb = new StringBuilder();
		LocationNames aName;

		final List<LocationNames> nameList = new LocationNames()
				.getFKLocationPid(locationPid);

		for (int i = 0; i < nameList.size(); i++) {
			aName = nameList.get(i);

			if (aName.isPrimaryLocationName()) {
				final List<LocationNameParts> lnp = new LocationNameParts()
						.getFKLocationNamePid(aName.getLocationNamePid());

				// Concatenate non-null name parts
				for (final LocationNameParts PersonNameParts : lnp) {
					if ((PersonNameParts.getLocationNamePid() == aName
							.getLocationNamePid())
							&& (PersonNameParts.getLabel() != null)
							&& !(PersonNameParts.getLabel().equals(""))) {
						sb.append(PersonNameParts.getLabel() + " ");
					}
				}
				break;
			}
		}

		return sb.toString().trim();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getRemote(javax.servlet.http.
	 * HttpServletrequest, java.lang.String)
	 */
	@Override
	public String getRemote(HttpServletRequest request, String target)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getStringList()
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getStringList(int)
	 */
	@Override
	public List<List<String>> getStringList(int key) throws Exception {
		List<String> stringList;
		StringBuilder sb;
		int pid;
		int datePid;
		String s;

		final HDateProvider hdp = new HDateProvider();
		final List<List<String>> lls = new ArrayList<>();

		if (key == 0) {
			return lls;
		}

		for (final LocationNames locationNames : name.getFKLocationPid(key)) {
			stringList = new ArrayList<>();

			pid = locationNames.getLocationNamePid();
			stringList.add(Integer.toString(pid));
			LOGGER.log(Level.FINE, "Pid: {0}", pid);

			sb = new StringBuilder();
			// Concatenate non-null name parts
			for (final LocationNameParts PersonNameParts : new LocationNameParts()
					.getFKLocationNamePid(pid)) {
				if ((PersonNameParts.getLocationNamePid() == pid)
						&& (PersonNameParts.getLabel() != null)) {
					sb.append(PersonNameParts.getLabel() + " ");
				}
			}
			stringList.add(sb.toString());
			LOGGER.log(Level.FINE, "{0}", sb);

			stringList.add(
					Boolean.toString(locationNames.isPrimaryLocationName()));
			s = "";
			datePid = locationNames.getFromDatePid();
			if (datePid != 0) {
				hdp.get(datePid);
				s = hdp.getDate().toString();
			}
			stringList.add(s);

			s = "";
			datePid = locationNames.getToDatePid();
			if (datePid != 0) {
				hdp.get(datePid);
				s = hdp.getDate().toString();
			}
			stringList.add(s);

			lls.add(stringList);
		}
		return lls;
	}

	/**
	 * @return the toDate
	 */
	public int getToDatePid() {
		return toDatePid;
	}

	/**
	 * Insert a row
	 *
	 * @return int The persistent ID of the inserted location
	 *
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public int insert() throws Exception {
		name.setFromDatePid(fromDatePid);
		name.setLocationNameStylePid(locationNameStylePid);
		name.setLocationPid(locationPid);
		name.setPrimaryLocationName(primaryLocationName);
		name.setToDatePid(toDatePid);
		name.setPreposition(preposition);
		return name.insert();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#insertRemote(javax.servlet.http.
	 * HttpServletRequest)
	 */
	@Override
	public void insertRemote(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the primaryLocationName
	 */
	public boolean isPrimaryLocationName() {
		return primaryLocationName;
	}

	/**
	 * @param fromDatePid
	 */
	public void setFromDatePid(int fromDatePid) {
		this.fromDatePid = fromDatePid;
	}

	/**
	 * @param key
	 */
	public void setLocationNamePid(int locationNamePid) {
		this.locationNamePid = locationNamePid;

	}

	/**
	 * @param locationNameStyleLabel the locationNameStyleLabel to set
	 */
	public void setLocationNameStyleLabel(String locationNameStyleLabel) {
		this.locationNameStyleLabel = locationNameStyleLabel;
	}

	/**
	 * @param locationNameStylePid the locationNameStylePid to set
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
	 * @param mapList the mapList to set
	 */
	public void setMapList(List<LocationNameMaps> mapList) {
		this.mapList = mapList;
	}

	/**
	 * @param partList the partList to set
	 */
	public void setPartList(List<LocationNameParts> partList) {
		this.partList = partList;
	}

	/**
	 * @param preposition the preposition to set
	 */
	public void setPreposition(String preposition) {
		this.preposition = preposition;
	}

	/**
	 * @param primaryLocationName the primaryLocationName to set
	 */
	public void setPrimaryLocationName(boolean primaryLocationName) {
		this.primaryLocationName = primaryLocationName;
	}

	/**
	 * @param toDatePid the toDate to set
	 */
	public void setToDatePid(int toDatePid) {
		this.toDatePid = toDatePid;
	}

	/**
	 * Update a row
	 *
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public void update() throws Exception {
		name.setFromDatePid(fromDatePid);
		name.setLocationNamePid(locationNamePid);
		name.setLocationNameStylePid(locationNameStylePid);
		name.setLocationPid(locationPid);
		name.setPrimaryLocationName(primaryLocationName);
		name.setToDatePid(toDatePid);
		name.setPreposition(preposition);
		name.update();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#updateRemote(javax.servlet.http.
	 * HttpServletRequest)
	 */
	@Override
	public void updateRemote(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

}
