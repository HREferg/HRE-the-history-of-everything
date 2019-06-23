package net.myerichsen.hremvp.location.providers;

import java.util.List;

import net.myerichsen.hremvp.IHREProvider;
import net.myerichsen.hremvp.location.servers.LocationEventServer;

/**
 * Provides all events for a location
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 30. apr. 2019
 *
 */
public class LocationEventProvider implements IHREProvider {
	private int LocationEventsPid;
	private int EventPid;
	private int LocationPid;
	private boolean PrimaryEvent;
	private boolean PrimaryLocation;

	private final LocationEventServer server;

	/**
	 * Constructor
	 *
	 */
	public LocationEventProvider() {
		server = new LocationEventServer();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#delete(int)
	 */
	@Override
	public void delete(int key) throws Exception {
		server.delete(key);
	}

	/**
	 * @param locationPid
	 * @throws Exception
	 */
	public void deleteAllEventLinksForLocation(int locationPid)
			throws Exception {
		server.deleteAllEventLinksForLocation(locationPid);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#get(int)
	 */
	@Override
	public void get(int key) throws Exception {
		server.get(key);
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
		return LocationPid;
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
	 * @param eventPid
	 * @return
	 * @throws Exception
	 */
	public List<List<String>> getLocationStringListByEvent(int eventPid)
			throws Exception {
		return server.getLocationStringListByEvent(eventPid);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#insert()
	 */
	@Override
	public int insert() throws Exception {
		server.setEventPid(EventPid);
		server.setLocationPid(LocationPid);
		server.setPrimaryEvent(PrimaryEvent);
		server.setPrimaryLocation(PrimaryLocation);
		return server.insert();
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
		LocationPid = locationPid;
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
	 * @see net.myerichsen.hremvp.IHREProvider#update()
	 */
	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub

	}
}