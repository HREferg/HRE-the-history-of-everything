package net.myerichsen.hremvp.location.providers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.myerichsen.hremvp.IHREProvider;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.location.servers.LocationServer;

/**
 * Provides all data for a single location
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 17. apr. 2019
 *
 */
public class LocationProvider implements IHREProvider {
	private int locationPid;
	private int fromDatePid;
	private int toDatePid;
	private boolean primaryLocation;
	private BigDecimal xCoordinate;
	private BigDecimal yCoordinate;
	private BigDecimal zCoordinate;
	private final LocationServer server;

	/**
	 * Constructor
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 *
	 */
	public LocationProvider() throws Exception {
		server = new LocationServer();
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
		setLocationPid(key);
		setPrimaryLocation(server.isPrimaryLocation());
		setToDatePid(server.getToDatePid());
		setxCoordinate(server.getxCoordinate());
		setyCoordinate(server.getyCoordinate());
		setzCoordinate(server.getzCoordinate());
		setNameList(server.getNameList());
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
		return server.getNameList();
	}

	/**
	 * Get the primary name of the location
	 *
	 * @return name The primary name of the location
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 */
	public String getPrimaryName() throws Exception {
		return server.getPrimaryName();
	}

	/**
	 * Get all rows
	 *
	 * @return A list of lists of strings with pids and labels
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
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
		// TODO Auto-generated method stub
		return new ArrayList<>();
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
		server.setFromDatePid(fromDatePid);
		server.setLocationPid(locationPid);
		server.setPrimaryLocation(primaryLocation);
		server.setToDatePid(toDatePid);
		server.setxCoordinate(xCoordinate);
		server.setyCoordinate(yCoordinate);
		server.setzCoordinate(zCoordinate);
		return server.insert();
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
	 * @param nameList the nameList to set
	 */
	public void setNameList(List<List<String>> nameList) {
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
		server.setFromDatePid(fromDatePid);
		server.setLocationPid(locationPid);
		server.setPrimaryLocation(primaryLocation);
		server.setToDatePid(toDatePid);
		server.setxCoordinate(xCoordinate);
		server.setyCoordinate(yCoordinate);
		server.setzCoordinate(zCoordinate);
		server.update();
	}

}