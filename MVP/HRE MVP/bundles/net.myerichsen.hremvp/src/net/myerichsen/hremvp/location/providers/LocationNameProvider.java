package net.myerichsen.hremvp.location.providers;

import java.util.List;

import net.myerichsen.hremvp.IHREProvider;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.LocationNameMaps;
import net.myerichsen.hremvp.dbmodels.LocationNameParts;
import net.myerichsen.hremvp.location.servers.LocationNameServer;

/**
 * Provides all data for a single name for a location
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 17. apr. 2019
 *
 */
public class LocationNameProvider implements IHREProvider {
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

	private final LocationNameServer server;

	/**
	 * Constructor
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 *
	 */
	public LocationNameProvider() throws Exception {
		server = new LocationNameServer();
	}

	/**
	 * Delete a row
	 *
	 * @param key The persistent ID of the row
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public void delete(int key) throws Exception {
		server.delete(key);
	}

	/**
	 * @param locationPid
	 * @throws Exception
	 */
	public void deleteAllNamesForLocation(int locationPid) throws Exception {
		server.deleteAllNamesForLocation(locationPid);
	}

	/**
	 * Get a row
	 *
	 * @param key The persistent ID of the row
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public void get(int key) throws Exception {
		server.get(key);

		setFromDatePid(server.getFromDatePid());
		setLocationNamePid(key);
		setLocationNameStylePid(server.getLocationNameStylePid());
		setLocationNameStyleLabel(server.getLocationNameStyleLabel());
		setPrimaryLocationName(server.isPrimaryLocationName());
		setLocationPid(server.getLocationPid());
		setToDatePid(server.getToDatePid());
		setPreposition(server.getPreposition());
		setMapList(server.getMapList());
		setPartList(server.getPartList());
	}

	/**
	 * @param locationPid
	 * @return A list of location name pids
	 * @throws Exception
	 */
	public List<Integer> getFKLocationPid(int locationPid) throws Exception {
		return server.getFKLocationPid(locationPid);
	}

	/**
	 * @return the fromDatePid
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

//	/**
//	 * Get a string of name parts for each name
//	 *
//	 * @return sa An array of strings
//	 * @throws Exception An exception that provides information on a database
//	 *                   access error or other errors
//	 */
//	public String[] getNameStrings() throws Exception {
//		return server.getNameStrings();
//	}

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
		return server.getPrimaryNameString(locationPid);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#getStringList()
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		return server.getStringList();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#getStringList(int)
	 */
	@Override
	public List<List<String>> getStringList(int key) throws Exception {
		return server.getStringList(key);
	}

	/**
	 * @return the toDatePid
	 */
	public int getToDatePid() {
		return toDatePid;
	}

	/**
	 * Insert a row
	 *
	 * @return int The persistent ID of the inserted row
	 *
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public int insert() throws Exception {
		server.setFromDatePid(fromDatePid);
		server.setLocationNameStylePid(locationNameStylePid);
		server.setLocationPid(locationPid);
		server.setPrimaryLocationName(primaryLocationName);
		server.setToDatePid(toDatePid);
		server.setPreposition(preposition);
		return server.insert();
	}

	/**
	 * @return the primaryLocationName
	 */
	public boolean isPrimaryLocationName() {
		return primaryLocationName;
	}

	/**
	 * @param fromDatePid the fromDatePid to set
	 */
	public void setFromDatePid(int fromDatePid) {
		this.fromDatePid = fromDatePid;
	}

	/**
	 * @param locationNamePid the locationNamePid to set
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
	 * @param toDatePid the toDatePid to set
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
		server.setFromDatePid(fromDatePid);
		server.setLocationNamePid(locationNamePid);
		server.setLocationNameStylePid(locationNameStylePid);
		server.setLocationPid(locationPid);
		server.setPrimaryLocationName(primaryLocationName);
		server.setToDatePid(toDatePid);
		server.setPreposition(preposition);
		server.update();
	}
}
