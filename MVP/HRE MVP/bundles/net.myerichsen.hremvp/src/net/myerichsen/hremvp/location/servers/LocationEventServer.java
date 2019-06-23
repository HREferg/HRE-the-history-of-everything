package net.myerichsen.hremvp.location.servers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.EventTypes;
import net.myerichsen.hremvp.dbmodels.Events;
import net.myerichsen.hremvp.dbmodels.LocationEvents;

/**
 * Business logic interface for
 * {@link net.myerichsen.hremvp.dbmodels.LocationEvents}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 3. jun. 2019
 *
 */
public class LocationEventServer implements IHREServer {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private int LocationEventsPid;
	private int EventPid;
	private int locationPid;
	private boolean PrimaryEvent;
	private boolean PrimaryLocation;

	private final LocationEvents locationEvent;

	/**
	 * Constructor
	 *
	 */
	public LocationEventServer() {
		super();
		locationEvent = new LocationEvents();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#delete(int)
	 */
	@Override
	public void delete(int key) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * @param locationPid The persistent id of the location
	 * @throws Exception Any exception
	 */
	public void deleteAllEventLinksForLocation(int locationPid)
			throws Exception {
		final List<LocationEvents> fkLocationPid = locationEvent
				.getFKLocationPid(locationPid);

		for (final LocationEvents event : fkLocationPid) {
			locationEvent.delete(event.getLocationEventsPid());
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

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#get(int)
	 */
	@Override
	public void get(int key) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the eventPid
	 */
	public int getEventPid() {
		return EventPid;
	}

	/**
	 * @return the locationEventsPid
	 */
	public int getLocationEventsPid() {
		return LocationEventsPid;
	}

	/**
	 * @return the locationPid
	 */
	public int getLocationPid() {
		return locationPid;
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

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getStringList(int)
	 */
	@Override
	public List<List<String>> getStringList(int key) throws Exception {
		final List<List<String>> lls = new ArrayList<>();
		LocationServer ls;
		List<String> locationStringList;

		if (key == 0) {
//			locationStringList = new ArrayList<>();
//			locationStringList.add("0");
//			locationStringList.add("");
//			lls.add(locationStringList);
			return lls;
		}

		this.locationPid = key;

		final LocationEvents locationEvents = new LocationEvents();
		final List<LocationEvents> leList = locationEvents
				.getFKLocationPid(key);

		try {
			for (final LocationEvents le : leList) {
				locationStringList = new ArrayList<>();
				ls = new LocationServer();
				locationPid = le.getLocationPid();
				ls.get(locationPid);
				locationStringList.add(Integer.toString(locationPid));
				locationStringList.add(ls.getPrimaryName());

				Events event = new Events();
				EventPid = le.getEventPid();
				locationStringList.add(Integer.toString(EventPid));

				event.get(EventPid);
				EventTypes et = new EventTypes();
				et.get(event.getEventTypePid());
				locationStringList.add(et.getAbbreviation());

				lls.add(locationStringList);
			}
		} catch (final MvpException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

		return lls;
	}

	/**
	 * @param eventPid The persistent ID of the event
	 * @return A list of lists of strings of pids and labels
	 * @throws Exception Any exception
	 */
	public List<List<String>> getLocationStringListByEvent(int eventPid)
			throws Exception {
		return new LocationServer().getStringList(eventPid);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#insert()
	 */
	@Override
	public int insert() throws Exception {
		locationEvent.setEventPid(EventPid);
		locationEvent.setLocationPid(locationPid);
		locationEvent.setPrimaryEvent(PrimaryEvent);
		locationEvent.setPrimaryLocation(PrimaryLocation);
		return locationEvent.insert();
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
	 * @return the primaryEvent
	 */
	public boolean isPrimaryEvent() {
		return PrimaryEvent;
	}

	/**
	 * @return the primaryLocation
	 */
	public boolean isPrimaryLocation() {
		return PrimaryLocation;
	}

	/**
	 * @param eventPid the eventPid to set
	 */
	public void setEventPid(int eventPid) {
		EventPid = eventPid;
	}

	/**
	 * @param locationEventsPid the locationEventsPid to set
	 */
	public void setLocationEventsPid(int locationEventsPid) {
		LocationEventsPid = locationEventsPid;
	}

	/**
	 * @param locationPid the locationPid to set
	 */
	public void setLocationPid(int locationPid) {
		this.locationPid = locationPid;
	}

	/**
	 * @param primaryEvent the primaryEvent to set
	 */
	public void setPrimaryEvent(boolean primaryEvent) {
		PrimaryEvent = primaryEvent;
	}

	/**
	 * @param primaryLocation the primaryLocation to set
	 */
	public void setPrimaryLocation(boolean primaryLocation) {
		PrimaryLocation = primaryLocation;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#update()
	 */
	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub

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
