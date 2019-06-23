package net.myerichsen.hremvp.event.servers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONStringer;

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.EventTypes;
import net.myerichsen.hremvp.dbmodels.Events;
import net.myerichsen.hremvp.dbmodels.Hdates;
import net.myerichsen.hremvp.dbmodels.LocationEvents;
import net.myerichsen.hremvp.location.servers.LocationServer;

/**
 * Business logic interface for {@link net.myerichsen.hremvp.dbmodels.Events}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 12. maj 2019
 *
 */
public class EventServer implements IHREServer {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private int EventPid;
	private int TableId;
	private int FromDatePid;
	private String FromDateLabel;
	private String FromDateOriginal;
	private int ToDatePid;
	private String ToDateLabel;
	private String ToDateOriginal;
	private int EventNamePid;
	private String EventName;
	private int EventTypePid;
	private String EventType;
	private int LanguagePid;
	private String Language;
	private String IsoCode;

	private List<List<String>> personList;
	private List<List<String>> locationList;

	private final Events event;

	/**
	 * Constructor
	 *
	 */
	public EventServer() {
		event = new Events();
		personList = new ArrayList<>();
		locationList = new ArrayList<>();
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
		event.delete(key);
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
	 *
	 */
	@Override
	public void get(int key) throws Exception {
		event.get(key);
		setEventPid(event.getEventPid());

		final Hdates fromDate = new Hdates();
		setFromDatePid(event.getFromDatePid());
		try {
			fromDate.get(FromDatePid);
			setFromDateLabel(fromDate.getDate().toString());
			setFromDateOriginal(fromDate.getOriginalText());
		} catch (final Exception e) {
			setFromDateLabel("");
			setFromDateOriginal("");
		}

		final Hdates toDate = new Hdates();
		setToDatePid(event.getToDatePid());
		try {
			toDate.get(ToDatePid);
			setToDateLabel(toDate.getDate().toString());
			setToDateOriginal(toDate.getOriginalText());
		} catch (final Exception e) {
			setToDateLabel("");
			setToDateOriginal("");
		}

		setEventTypePid(event.getEventTypePid());
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return EventName;
	}

	/**
	 * @return the eventNamePid
	 */
	public int getEventNamePid() {
		return EventNamePid;
	}

	/**
	 * @return the eventPid
	 */
	public int getEventPid() {
		return EventPid;
	}

	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return EventType;
	}

	/**
	 * @return the eventTypePid
	 */
	public int getEventTypePid() {
		return EventTypePid;
	}

	/**
	 * @return the fromDateLabel
	 */
	public String getFromDateLabel() {
		return FromDateLabel;
	}

	/**
	 * @return the fromDateOriginal
	 */
	public String getFromDateOriginal() {
		return FromDateOriginal;
	}

	/**
	 * @return the fromDatePid
	 */
	public int getFromDatePid() {
		return FromDatePid;
	}

	/**
	 * @return the isoCode
	 */
	public String getIsoCode() {
		return IsoCode;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return Language;
	}

	/**
	 * @return the languagePid
	 */
	public int getLanguagePid() {
		return LanguagePid;
	}

	/**
	 * @return the locationList
	 */
	public List<List<String>> getLocationList() {
		return locationList;
	}

	/**
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public List<String> getLocationList(int key) throws Exception {
		LocationServer ls;

		final List<String> locationStringList = new ArrayList<>();

		final LocationEvents locationEvents = new LocationEvents();
		final List<LocationEvents> leList = locationEvents.getFKEventPid(key);

		try {
			for (final LocationEvents le : leList) {
				ls = new LocationServer();
				ls.get(le.getLocationPid());

				locationStringList.add(ls.getPrimaryName());
			}
		} catch (final MvpException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

		return locationStringList;
	}

	/**
	 * @return the personList
	 */
	public List<List<String>> getPersonList() {
		return personList;
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
		final String[] targetParts = target.split("/");
		final int targetSize = targetParts.length;

		final JSONStringer js = new JSONStringer();
		js.object();

		if (targetSize == 0) {
			js.key("events");
			js.array();

			final List<List<String>> stringList = getStringList();

			for (final List<String> list : stringList) {
				js.object();
				js.key("pid");
				js.value(list.get(0));
				js.key("fromdate");
				js.value(list.get(1));
				js.key("todate");
				js.value(list.get(2));
				js.key("eventtypepid");
				js.value(list.get(3));
				js.key("name");
				js.value(list.get(4));
				js.key("endpoint");
				js.value(request.getRequestURL() + list.get(0));
				js.endObject();
			}

			js.endArray();

		} else {

			js.key("event");
			js.object();

			final List<String> list = getStringList(
					Integer.parseInt(targetParts[targetSize - 1])).get(0);

			js.key("pid");
			js.value(list.get(0));
			js.key("fromdate");
			js.value(list.get(1));
			js.key("todate");
			js.value(list.get(2));
			js.key("eventtypepid");
			js.value(list.get(3));
			js.key("name");
			js.value(list.get(4));

			LOGGER.log(Level.FINE, "{0}", js);

			js.endObject();
		}

		js.endObject();
		return js.toString();
	}

	/**
	 * Get all rows
	 *
	 * @return A list of strings of pids and labels
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		final List<List<String>> lls = new ArrayList<>();
		List<String> stringList;

		// Event pid, from date, to date, event type pid, event type label
		for (final Events thisEvent : event.get()) {
			stringList = new ArrayList<>();
			stringList.add(Integer.toString(thisEvent.getEventPid()));

			final Hdates hdate = new Hdates();

			FromDatePid = thisEvent.getToDatePid();
			if (FromDatePid > 0) {
				hdate.get(FromDatePid);
				stringList.add(hdate.getDate().toString());
			} else {
				stringList.add("");
			}

			ToDatePid = thisEvent.getToDatePid();
			if (ToDatePid > 0) {
				hdate.get(ToDatePid);
				stringList.add(hdate.getDate().toString());
			} else {
				stringList.add("");
			}

			final EventTypes eventType = new EventTypes();
			eventType.get(thisEvent.getEventTypePid());
			stringList.add(Integer.toString(EventTypePid));
			stringList.add(eventType.getAbbreviation());
			stringList.add(Integer.toString(FromDatePid));
			stringList.add(Integer.toString(ToDatePid));

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
		List<String> stringList;

		if (key == 0) {
			return lls;
		}

		event.get(key);

		stringList = new ArrayList<>();
		stringList.add(Integer.toString(key));

		final Hdates hdate = new Hdates();

		FromDatePid = event.getToDatePid();
		if (FromDatePid > 0) {
			hdate.get(FromDatePid);
			stringList.add(hdate.getDate().toString());
		} else {
			stringList.add("");
		}

		ToDatePid = event.getToDatePid();
		if (ToDatePid > 0) {
			hdate.get(ToDatePid);
			stringList.add(hdate.getDate().toString());
		} else {
			stringList.add("");
		}

		final EventTypes eventType = new EventTypes();
		final int eventTypePid2 = event.getEventTypePid();
		eventType.get(event.getEventTypePid());
		stringList.add(Integer.toString(eventTypePid2));
		stringList.add(eventType.getAbbreviation());
		stringList.add(Integer.toString(FromDatePid));
		stringList.add(Integer.toString(ToDatePid));

		lls.add(stringList);

		return lls;
	}

	/**
	 * @return the tableId
	 */
	public int getTableId() {
		return TableId;
	}

	/**
	 * @return the toDateLabel
	 */
	public String getToDateLabel() {
		return ToDateLabel;
	}

	/**
	 * @return the toDateOriginal
	 */
	public String getToDateOriginal() {
		return ToDateOriginal;
	}

	/**
	 * @return the toDatePid
	 */
	public int getToDatePid() {
		return ToDatePid;
	}

	/**
	 * Insert a row
	 *
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public int insert() throws Exception {
		event.setEventPid(EventPid);
		event.setTableId(Constants.EVENTS_TABLE_ID);
		event.setFromDatePid(FromDatePid);
		event.setToDatePid(ToDatePid);
		event.setEventTypePid(EventTypePid);
		return event.insert();
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
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		EventName = eventName;
	}

	/**
	 * @param eventNamePid the eventNamePid to set
	 */
	public void setEventNamePid(int eventNamePid) {
		EventNamePid = eventNamePid;
	}

	/**
	 * @param eventPid the eventPid to set
	 */
	public void setEventPid(int eventPid) {
		EventPid = eventPid;
	}

	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(String eventType) {
		EventType = eventType;
	}

	/**
	 * @param eventTypePid the eventTypePid to set
	 */
	public void setEventTypePid(int eventTypePid) {
		EventTypePid = eventTypePid;
	}

	/**
	 * @param fromDateLabel the fromDateLabel to set
	 */
	public void setFromDateLabel(String fromDateLabel) {
		FromDateLabel = fromDateLabel;
	}

	/**
	 * @param fromDateOriginal the fromDateOriginal to set
	 */
	public void setFromDateOriginal(String fromDateOriginal) {
		FromDateOriginal = fromDateOriginal;
	}

	/**
	 * @param fromDatePid the fromDatePid to set
	 */
	public void setFromDatePid(int fromDatePid) {
		FromDatePid = fromDatePid;
	}

	/**
	 * @param isoCode the isoCode to set
	 */
	public void setIsoCode(String isoCode) {
		IsoCode = isoCode;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		Language = language;
	}

	/**
	 * @param languagePid the languagePid to set
	 */
	public void setLanguagePid(int languagePid) {
		LanguagePid = languagePid;
	}

	/**
	 * @param locationList the locationList to set
	 */
	public void setLocationList(List<List<String>> locationList) {
		this.locationList = locationList;
	}

	/**
	 * @param personList the personList to set
	 */
	public void setPersonList(List<List<String>> personList) {
		this.personList = personList;
	}

	/**
	 * @param tableId the tableId to set
	 */
	public void setTableId(int tableId) {
		TableId = tableId;
	}

	/**
	 * @param toDateLabel the toDateLabel to set
	 */
	public void setToDateLabel(String toDateLabel) {
		ToDateLabel = toDateLabel;
	}

	/**
	 * @param toDateOriginal the toDateOriginal to set
	 */
	public void setToDateOriginal(String toDateOriginal) {
		ToDateOriginal = toDateOriginal;
	}

	/**
	 * @param toDatePid the toDatePid to set
	 */
	public void setToDatePid(int toDatePid) {
		ToDatePid = toDatePid;
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
		event.setEventPid(EventPid);
		event.setTableId(Constants.EVENTS_TABLE_ID);
		event.setFromDatePid(FromDatePid);
		event.setToDatePid(ToDatePid);
//		event.setEventNamePid(EventNamePid);
		event.update();
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
