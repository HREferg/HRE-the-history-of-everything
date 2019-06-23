package net.myerichsen.hremvp.location.servers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONStringer;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.Hdates;
import net.myerichsen.hremvp.dbmodels.LocationNameParts;
import net.myerichsen.hremvp.dbmodels.LocationNames;
import net.myerichsen.hremvp.dbmodels.Locations;

/**
 * Business logic interface for {@link net.myerichsen.hremvp.dbmodels.Locations}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 7. maj 2019
 *
 */
public class LocationServer implements IHREServer {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private int locationPid;
	private int fromDatePid;
	private int toDatePid;
	private boolean primaryLocation;
	private BigDecimal xCoordinate;
	private BigDecimal yCoordinate;
	private BigDecimal zCoordinate;
	private List<List<String>> nameList;

	private final Locations location;

	/**
	 * Constructor
	 *
	 */
	public LocationServer() {
		location = new Locations();
		nameList = new ArrayList<>();
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
		location.delete(key);
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
	 */
	@Override
	public void get(int key) throws Exception {
		location.get(key);
		setFromDatePid(location.getFromDatePid());
		setLocationPid(key);
		setPrimaryLocation(location.isPrimaryLocation());
		setToDatePid(location.getToDatePid());
		setxCoordinate(location.getXCoordinate());
		setyCoordinate(location.getYCoordinate());
		setzCoordinate(location.getZCoordinate());

		nameList = new ArrayList<>();

		final List<LocationNames> lnl = new LocationNames()
				.getFKLocationPid(key);

		final LocationNameServer lns = new LocationNameServer();
		List<String> sl;
		int pid;

		for (int i = 0; i < lnl.size(); i++) {
			sl = new ArrayList<>();
			pid = lnl.get(i).getLocationNamePid();
			sl.add(Integer.toString(pid));
			lns.get(pid);
//			sl.add(lns.getNameStrings()[i]);
			sl.add("deprecated");
			sl.add(Boolean.toString(lns.isPrimaryLocationName()));
			sl.add(Integer.toString(lns.getToDatePid()));
			sl.add(Integer.toString(lns.getFromDatePid()));
			nameList.add(sl);
		}
	}

	/**
	 * @return the fromDatePid
	 */
	public int getFromDatePid() {
		return fromDatePid;
	}

	/**
	 * @return the locationPid
	 */
	public int getLocationPid() {
		return locationPid;
	}

	/**
	 * @return the nameList
	 * @throws Exception
	 */
	public List<List<String>> getNameList() throws Exception {
		List<String> sl;
		int pid;
		nameList = new ArrayList<>();
		final LocationNameServer lns = new LocationNameServer();
		final List<Locations> ll = location.get();

		for (final Locations locations : ll) {
			sl = new ArrayList<>();

			pid = locations.getLocationPid();
			sl.add(Integer.toString(pid));
			sl.add(lns.getPrimaryNameString(pid));
			sl.add(Boolean.toString(lns.isPrimaryLocationName()));
			sl.add(Integer.toString(lns.getToDatePid()));
			sl.add(Integer.toString(lns.getFromDatePid()));
			nameList.add(sl);
		}
		return nameList;
	}

	/**
	 * @return the primary name of the location
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 */
	public String getPrimaryName() throws Exception {
		final StringBuilder sb = new StringBuilder();
		final LocationNameParts part = new LocationNameParts();
		List<LocationNameParts> partList;
		final List<LocationNames> lnl = new LocationNames()
				.getFKLocationPid(locationPid);

		for (final LocationNames name : lnl) {
			if (name.isPrimaryLocationName()) {
				partList = part.getFKLocationNamePid(name.getLocationNamePid());

				for (int i = 0; i < partList.size(); i++) {
					if (partList.get(i) != null) {
						sb.append(partList.get(i).getLabel() + ", ");
					}
				}
				break;
			}
		}
		return sb.toString();
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
		final String[] targetParts = target.split("/");
		final int targetSize = targetParts.length;

		final JSONStringer js = new JSONStringer();
		js.object();

		if (targetSize == 0) {
			js.key("locations");
			js.array();

			final List<List<String>> stringList = getStringList();

			for (final List<String> list : stringList) {
				js.object();
				js.key("pid");
				js.value(list.get(0));
				js.key("name");
				js.value(list.get(1));
				js.key("endpoint");
				js.value(request.getRequestURL() + list.get(0));
				js.endObject();
			}

			js.endArray();

		} else {

			js.key("location");
			js.object();

			final List<String> stringList = getStringList(
					Integer.parseInt(targetParts[targetSize - 1])).get(0);

			js.key("pid");
			js.value(stringList.get(0));
			js.key("name");
			js.value(stringList.get(1));
			js.key("fromdate");
			js.value(stringList.get(2));
			js.key("todate");
			js.value(stringList.get(3));

			LOGGER.log(Level.FINE, "{0}", js);

			js.endObject();
		}

		js.endObject();
		return js.toString();

	}

	/**
	 * Get all rows
	 *
	 * @return A list of lists of strings of pids and labels
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		final List<List<String>> lls = new ArrayList<>();
		List<String> stringList;

		final List<Locations> lnsl = location.get();

		StringBuilder sb;
		final LocationNameParts part = new LocationNameParts();
		List<LocationNameParts> partList;
		int lp;

		for (final Locations loc : lnsl) {
			stringList = new ArrayList<>();
			sb = new StringBuilder();
			lp = loc.getLocationPid();
			stringList.add(Integer.toString(lp));

			final List<LocationNames> lnl = new LocationNames()
					.getFKLocationPid(lp);

			for (final LocationNames name : lnl) {
				if (name.isPrimaryLocationName()) {
					partList = part
							.getFKLocationNamePid(name.getLocationNamePid());

					for (int i = 0; i < partList.size(); i++) {
						if ((partList.get(i) != null) && (partList.get(i)
								.getLabel().trim().length() > 0)) {
							sb.append(partList.get(i).getLabel() + ", ");
						}
					}
					break;
				}
			}

			LOGGER.log(Level.FINE, "{0}", sb);
			stringList.add(sb.toString());
			lls.add(stringList);
		}

		return lls;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getStringList(int)
	 */
	@Override
	public List<List<String>> getStringList(int key) throws Exception {
		final List<List<String>> lls = new ArrayList<>();
		
		if (key == 0) {
			return lls;
		}

		final LocationNameParts part = new LocationNameParts();
		List<LocationNameParts> partList;

		final Locations loc = new Locations();
		loc.get(key);

		final List<String> stringList = new ArrayList<>();
		final StringBuilder sb = new StringBuilder();
		stringList.add(Integer.toString(key));

		final List<LocationNames> lnl = new LocationNames()
				.getFKLocationPid(key);

		for (final LocationNames name : lnl) {
			if (name.isPrimaryLocationName()) {
				partList = part.getFKLocationNamePid(name.getLocationNamePid());

				for (int i = 0; i < partList.size(); i++) {
					if ((partList.get(i) != null) && (partList.get(i).getLabel()
							.trim().length() > 0)) {
						sb.append(partList.get(i).getLabel() + ", ");
					}
				}
				break;
			}
		}

		LOGGER.log(Level.FINE, "{0}", sb);
		stringList.add(sb.toString());

		final Hdates hdate = new Hdates();

		int datePid = loc.getFromDatePid();

		if (datePid == 0) {
			stringList.add("");
		} else {
			hdate.get(datePid);
			stringList.add(hdate.getDate().toString());
		}

		datePid = loc.getToDatePid();

		if (datePid == 0) {
			stringList.add("");
		} else {
			hdate.get(datePid);
			stringList.add(hdate.getDate().toString());
		}

		lls.add(stringList);

		return lls;

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
	public BigDecimal getxCoordinate() {
		return xCoordinate;
	}

	/**
	 * @return the yCoordinate
	 */
	public BigDecimal getyCoordinate() {
		return yCoordinate;
	}

	/**
	 * @return the zCoordinate
	 */
	public BigDecimal getzCoordinate() {
		return zCoordinate;
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
		location.setFromDatePid(fromDatePid);
		location.setLocationPid(locationPid);
		location.setPrimaryLocation(primaryLocation);
		location.setToDatePid(toDatePid);
		location.setXCoordinate(xCoordinate);
		location.setYCoordinate(yCoordinate);
		location.setZCoordinate(zCoordinate);
		return location.insert();
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
	 * @return the primaryLocation
	 */
	public boolean isPrimaryLocation() {
		return primaryLocation;
	}

	/**
	 * @param fromDatePid the fromDatePid to set
	 */
	public void setFromDatePid(int fromDatePid) {
		this.fromDatePid = fromDatePid;
	}

	/**
	 * @param locationPid the locationPid to set
	 */
	public void setLocationPid(int locationPid) {
		this.locationPid = locationPid;
	}

	/**
	 * @param primaryLocation the primaryLocation to set
	 */
	public void setPrimaryLocation(boolean primaryLocation) {
		this.primaryLocation = primaryLocation;
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
	public void setxCoordinate(BigDecimal xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	/**
	 * @param yCoordinate the yCoordinate to set
	 */
	public void setyCoordinate(BigDecimal yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	/**
	 * @param zCoordinate the zCoordinate to set
	 */
	public void setzCoordinate(BigDecimal zCoordinate) {
		this.zCoordinate = zCoordinate;
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
		location.setFromDatePid(fromDatePid);
		location.setLocationPid(locationPid);
		location.setPrimaryLocation(primaryLocation);
		location.setToDatePid(toDatePid);
		location.setXCoordinate(xCoordinate);
		location.setYCoordinate(yCoordinate);
		location.setZCoordinate(zCoordinate);
		location.update();
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
