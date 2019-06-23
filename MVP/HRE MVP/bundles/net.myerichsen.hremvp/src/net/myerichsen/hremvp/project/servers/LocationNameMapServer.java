package net.myerichsen.hremvp.project.servers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.Dictionary;
import net.myerichsen.hremvp.dbmodels.LocationNameMaps;

/**
 * Business logic interface for
 * {@link net.myerichsen.hremvp.dbmodels.LocationNameMaps}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 7. maj 2019
 *
 */
public class LocationNameMapServer implements IHREServer {
//	private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private int LocationNameMapPid;
	private int LocationNameStylePid;
	private int PartNo;
	private int LabelPid;
	private String styleLabel;

	private final LocationNameMaps map;

	/**
	 * Constructor
	 *
	 */
	public LocationNameMapServer() {
		map = new LocationNameMaps();
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
		map.delete(key);
	}

	/**
	 * @param key
	 * @return
	 * @throws Exception
	 * @throws MvpException
	 */
	public void deleteLocationNameStylePid(int key) throws Exception {
		final List<LocationNameMaps> fkLocationNameStylePid = map
				.getFKLocationNameStylePid(key);

		for (final LocationNameMaps locationNameMaps : fkLocationNameStylePid) {
			delete(locationNameMaps.getLocationNameMapPid());
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
	 * @param key The persistent id of the row
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public void get(int key) throws Exception {
		map.get(key);
		setLocationNameMapPid(map.getLocationNameMapPid());
		setLocationNameStylePid(map.getLocationNameStylePid());
		setPartNo(map.getPartNo());
		setLabelPid(map.getLabelPid());
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
	 * @see net.myerichsen.hremvp.IHREServer#getRemote(javax.servlet.http.
	 * HttpServletResponse, java.lang.String)
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

	/**
	 * @param locationNameStylePid
	 * @return lls A list of lists of location name map pid, label pid, part no,
	 *         label, a blank field, and dictionary pid
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList(int locationNameStylePid)
			throws Exception {
		final List<List<String>> lls = new ArrayList<>();

		if (locationNameStylePid == 0) {
			return lls;
		}

		List<String> stringList;

		final List<LocationNameMaps> fkNameStylePid = map
				.getFKLocationNameStylePid(locationNameStylePid);

		for (final LocationNameMaps personNameMaps : fkNameStylePid) {
			stringList = new ArrayList<>();
			stringList.add(
					Integer.toString(personNameMaps.getLocationNameMapPid()));
			final int labelPid = personNameMaps.getLabelPid();
			stringList.add(Integer.toString(labelPid));
			stringList.add(Integer.toString(personNameMaps.getPartNo()));

			final Dictionary dictionary = new Dictionary();
			final List<Dictionary> fkLabelPid = dictionary
					.getFKLabelPid(labelPid);
			stringList.add(fkLabelPid.get(0).getLabel());
			stringList.add("");
			stringList.add(
					Integer.toString(fkLabelPid.get(0).getDictionaryPid()));
			lls.add(stringList);
		}

		return lls;
	}

	/**
	 * @return the styleLabel
	 */
	public String getStyleLabel() {
		return styleLabel;
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
		map.setLocationNameMapPid(LocationNameMapPid);
		map.setLocationNameStylePid(LocationNameStylePid);
		map.setPartNo(PartNo);
		map.setLabelPid(LabelPid);
		return map.insert();
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
	 * @param styleLabel the styleLabel to set
	 */
	public void setStyleLabel(String styleLabel) {
		this.styleLabel = styleLabel;
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
		map.setLocationNameMapPid(LocationNameMapPid);
		map.setLocationNameStylePid(LocationNameStylePid);
		map.setPartNo(PartNo);
		map.setLabelPid(LabelPid);
		map.update();
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
