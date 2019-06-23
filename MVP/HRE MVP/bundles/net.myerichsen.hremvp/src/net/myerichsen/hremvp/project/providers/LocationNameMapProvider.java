package net.myerichsen.hremvp.project.providers;

import java.util.List;

import net.myerichsen.hremvp.IHREProvider;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.project.servers.LocationNameMapServer;

/**
 * Provides all data for a single map view part
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 22. apr. 2019
 *
 */
public class LocationNameMapProvider implements IHREProvider {
//	private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private int LocationNameMapPid;
	private int LocationNameStylePid;
	private int PartNo;
	private int LabelPid;

	private final LocationNameMapServer server;

	/**
	 * Constructor
	 *
	 */
	public LocationNameMapProvider() {
		server = new LocationNameMapServer();
	}

	/**
	 * Delete a row
	 *
	 * @param key The persistent ID of the row
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors.
	 * @throws MvpException Application specific exception
	 */
	@Override
	public void delete(int key) throws Exception {
		server.delete(key);
	}

	/**
	 * @param key
	 * @throws Exception
	 * @throws MvpException
	 */
	public void deleteLocationNameStylePid(int key) throws Exception {
		server.deleteLocationNameStylePid(key);
	}

	/**
	 * Get a row
	 *
	 * @param key The persistent ID of the row
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors.
	 * @throws MvpException Application specific exception
	 */
	@Override
	public void get(int key) throws Exception {
		server.get(key);
		setLocationNameMapPid(server.getLocationNameMapPid());
		setLocationNameStylePid(server.getLocationNameStylePid());
		setPartNo(server.getPartNo());
		setLabelPid(server.getLabelPid());
	}

	/**
	 * @return the labelPid
	 */
	public int getLabelPid() {
		return LabelPid;
	}

	/**
	 * @return the locationNameMapPid
	 */
	public int getLocationNameMapPid() {
		return LocationNameMapPid;
	}

	/**
	 * @return the locationNameStylePid
	 */
	public int getLocationNameStylePid() {
		return LocationNameStylePid;
	}

	/**
	 * @return the partNo
	 */
	public int getPartNo() {
		return PartNo;
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

	/**
	 * @param locationNameStylePid
	 * @return lls A list of lists of location name map pid, label pid, part no,
	 *         label, a blank field, and dictionary pid
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList(int locationNameStylePid)
			throws Exception {
		return server.getStringList(locationNameStylePid);
	}

	/**
	 * Insert a row
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors.
	 *
	 */
	@Override
	public int insert() throws Exception {
		server.setLocationNameMapPid(LocationNameMapPid);
		server.setLocationNameStylePid(LocationNameStylePid);
		server.setPartNo(PartNo);
		server.setLabelPid(LabelPid);
		return server.insert();
	}

	/**
	 * @param labelPid the labelPid to set
	 */
	public void setLabelPid(int labelPid) {
		LabelPid = labelPid;
	}

	/**
	 * @param locationNameMapPid the locationNameMapPid to set
	 */
	public void setLocationNameMapPid(int locationNameMapPid) {
		LocationNameMapPid = locationNameMapPid;
	}

	/**
	 * @param locationNameStylePid the locationNameStylePid to set
	 */
	public void setLocationNameStylePid(int locationNameStylePid) {
		LocationNameStylePid = locationNameStylePid;
	}

	/**
	 * @param partNo the partNo to set
	 */
	public void setPartNo(int partNo) {
		PartNo = partNo;
	}

	/**
	 * Update a row
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors.
	 *
	 */
	@Override
	public void update() throws Exception {
		server.setLocationNameMapPid(LocationNameMapPid);
		server.setLocationNameStylePid(LocationNameStylePid);
		server.setPartNo(PartNo);
		server.setLabelPid(LabelPid);
		server.update();
	}

}
