package net.myerichsen.hremvp.location.providers;

import java.util.List;

import net.myerichsen.hremvp.IHREProvider;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.location.servers.LocationNamePartServer;

/**
 * Provides all data for a single part view part
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 21. apr. 2019
 *
 */
public class LocationNamePartProvider implements IHREProvider {
	// private static Logger LOGGER =
	// Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private int locationNamePartPid;
	private int locationNamePid;
	private String locationName;
	private String mapLabel;
	private String label;
	private int partNo;

	private final LocationNamePartServer server;

	/**
	 * Constructor
	 *
	 */
	public LocationNamePartProvider() {
		server = new LocationNamePartServer();
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
	public void deleteAllNamePartsForLocationName(int locationPid)
			throws Exception {
		server.deleteAllNamePartsForLocationName(locationPid);

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

		setLabel(server.getLabel());
		setLocationNamePartPid(server.getLocationNamePartPid());
		setLocationNamePid(server.getLocationNamePid());
		setMapLabel(server.getMapLabel());
		setLocationName(server.getLocationName());
		setPartNo(server.getPartNo());
	}

	/**
	 * @param locationNamePid
	 * @return
	 * @throws Exception
	 */
	public List<Integer> getFKLocationNamePid(int locationNamePid)
			throws Exception {
		return server.getFKLocationNamePid(locationNamePid);
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * @return the locationNamePartPid
	 */
	public int getLocationNamePartPid() {
		return locationNamePartPid;
	}

	/**
	 * @return the locationNamePid
	 */
	public int getLocationNamePid() {
		return locationNamePid;
	}

	/**
	 * @return the mapLabel
	 */
	public String getMapLabel() {
		return mapLabel;
	}

	/**
	 * @return the partNo
	 */
	public int getPartNo() {
		return partNo;
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
	 * Insert a row
	 *
	 * @return int The persistent ID of the inserted row
	 *
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 *
	 */
	@Override
	public int insert() throws Exception {
		server.setLabel(label);
		server.setLocationName(locationName);
		server.setLocationNamePartPid(locationNamePartPid);
		server.setLocationNamePid(locationNamePid);
		server.setMapLabel(mapLabel);
		server.setPartNo(partNo);
		return server.insert();
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * @param locationNamePartPid the locationNamePartPid to set
	 */
	public void setLocationNamePartPid(int locationNamePartPid) {
		this.locationNamePartPid = locationNamePartPid;
	}

	/**
	 * @param locationNamePid the locationNamePid to set
	 */
	public void setLocationNamePid(int locationNamePid) {
		this.locationNamePid = locationNamePid;
	}

	/**
	 * @param mapLabel the mapLabel to set
	 */
	public void setMapLabel(String mapLabel) {
		this.mapLabel = mapLabel;
	}

	/**
	 * @param partNo the partNo to set
	 */
	public void setPartNo(int partNo) {
		this.partNo = partNo;
	}

	/**
	 * Update a row
	 *
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 *
	 */
	@Override
	public void update() throws Exception {
		server.setLabel(label);
		server.setLocationName(locationName);
		server.setLocationNamePartPid(locationNamePartPid);
		server.setLocationNamePid(locationNamePid);
		server.setMapLabel(mapLabel);
		server.setPartNo(partNo);
		server.update();
	}
}
