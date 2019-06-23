package net.myerichsen.hremvp.location.servers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.Dictionary;
import net.myerichsen.hremvp.dbmodels.LocationNameMaps;
import net.myerichsen.hremvp.dbmodels.LocationNameParts;
import net.myerichsen.hremvp.dbmodels.LocationNames;

/**
 * Business logic interface for
 * {@link net.myerichsen.hremvp.dbmodels.LocationNameParts}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 21. apr. 2019
 */
public class LocationNamePartServer implements IHREServer {
	// private static Logger LOGGER =
	// Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private int locationNamePartPid;
	private int locationNamePid;
	private String locationName;
	private String mapLabel;
	private String label;
	private int partNo;

	private final LocationNameParts part;

	/**
	 * Constructor
	 *
	 */
	public LocationNamePartServer() {
		part = new LocationNameParts();
	}

	/**
	 * Delete a row
	 *
	 * @param key The persistent ID of the row
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 *
	 */
	@Override
	public void delete(int key) throws Exception {
		part.delete(key);
	}

	/**
	 * @param locationNamePid The persistent id of the location name
	 * @throws Exception Any exception
	 */
	public void deleteAllNamePartsForLocationName(int locationNamePid)
			throws Exception {
		final List<LocationNameParts> fkLocationNamePid = part
				.getFKLocationNamePid(locationNamePid);

		for (final LocationNameParts locationNameParts : fkLocationNamePid) {
			part.delete(locationNameParts.getLocationNamePartPid());
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
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 *
	 */
	@Override
	public void get(int key) throws Exception {
		part.get(key);
		setLabel(part.getLabel());
		setLocationNamePartPid(part.getLocationNamePartPid());
		setLocationNamePid(part.getLocationNamePid());
		setPartNo(part.getPartNo());

		// Get location name
		final StringBuilder sb = new StringBuilder();
		final List<LocationNameParts> partList = new LocationNameParts()
				.getFKLocationNamePid(locationNamePid);

		for (final LocationNameParts locationNameParts : partList) {
			if (locationNameParts.getLocationNamePid() == locationNamePid) {
				sb.append(locationNameParts.getLabel() + " ");
			}
		}

		setLocationName(sb.toString().trim());

		// Get map label
		setMapLabel("Label");
		final LocationNames name = new LocationNames();
		name.get(locationNamePid);
	}

	/**
	 * @param locationNamePid The persistent id of the location name
	 * @return A list of persistent ids of the location name parts
	 * @throws Exception Any exception
	 */
	public List<Integer> getFKLocationNamePid(int locationNamePid)
			throws Exception {
		final List<Integer> li = new ArrayList<>();

		final List<LocationNameParts> fkLocationNamePid = part
				.getFKLocationNamePid(locationNamePid);

		for (final LocationNameParts locationNameParts : fkLocationNamePid) {
			li.add(locationNameParts.getLocationNamePartPid());
		}
		return li;
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
		final List<List<String>> lls = new ArrayList<>();

		if (key == 0) {
			return lls;
		}

		final Dictionary dictionary = new Dictionary();
		final LocationNames ln = new LocationNames();
		ln.get(key);

		final List<LocationNameMaps> lnm = new LocationNameMaps()
				.getFKLocationNameStylePid(ln.getLocationNameStylePid());

		final List<LocationNameParts> lnp = part.getFKLocationNamePid(key);
		int labelPid;
		List<Dictionary> fkLabelPid;

		for (int i = 0; i < lnm.size(); i++) {
			stringList = new ArrayList<>();
			stringList
					.add(Integer.toString(lnp.get(i).getLocationNamePartPid()));
			stringList.add(Integer.toString(lnp.get(i).getPartNo()));

			labelPid = lnm.get(i).getLabelPid();
			fkLabelPid = dictionary.getFKLabelPid(labelPid);
			stringList.add(fkLabelPid.get(0).getLabel());
			stringList.add(lnp.get(i).getLabel());
			lls.add(stringList);
		}
		return lls;
	}

	/**
	 * Insert a row. Checks if a matching part number exists in
	 * {@link net.myerichsen.hremvp.dbmodels.LocationNameMaps}
	 *
	 * @return int Persistent ID of the inserted row
	 *
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public int insert() throws Exception {
		part.setLabel(label);
		part.setLocationNamePartPid(locationNamePartPid);
		part.setLocationNamePid(locationNamePid);
		part.setPartNo(partNo);
		return part.insert();
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
	 * Update a row. Checks if a matching part number exists in
	 * {@link net.myerichsen.hremvp.dbmodels.LocationNameMaps}
	 *
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public void update() throws Exception {
		part.setLabel(label);
		part.setLocationNamePartPid(locationNamePartPid);
		part.setLocationNamePid(locationNamePid);
		part.setPartNo(partNo);
		part.update();
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