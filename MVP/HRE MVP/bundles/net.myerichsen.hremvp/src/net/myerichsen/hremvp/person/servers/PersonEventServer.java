package net.myerichsen.hremvp.person.servers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.EventRoles;
import net.myerichsen.hremvp.dbmodels.Events;
import net.myerichsen.hremvp.dbmodels.Hdates;
import net.myerichsen.hremvp.dbmodels.PersonEvents;

/**
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 * @version 24. maj 2019
 *
 */
public class PersonEventServer implements IHREServer {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private int PersonEventPid;
	private int EventPid;
	private int PersonPid;
	private int EventRolePid;
	private boolean PrimaryPerson;
	private boolean PrimaryEvent;

	PersonEvents personEvent;

	/**
	 * Constructor
	 *
	 */
	public PersonEventServer() {
		personEvent = new PersonEvents();
	}

	/**
	 * @param key
	 * @throws MvpException
	 * @throws Exception
	 */
	@Override
	public void delete(int key) throws Exception {
		personEvent.delete(key);
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
	 * @see net.myerichsen.hremvp.servers.IHREServer#get(int)
	 */
	@Override
	public void get(int key) throws Exception {

	}

	/**
	 * @return the eventPid
	 */
	public int getEventPid() {
		return EventPid;
	}

	/**
	 * @return the eventRolePid
	 */
	public int getEventRolePid() {
		return EventRolePid;
	}

	/**
	 * @return the personEventPid
	 */
	public int getPersonEventPid() {
		return PersonEventPid;
	}

	/**
	 * @return the personPid
	 */
	public int getPersonPid() {
		return PersonPid;
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
	public List<List<String>> getStringList(int personPid) throws Exception {
		final List<List<String>> lls = new ArrayList<>();

		if (personPid == 0) {
			return lls;
		}

		// FIXME Return Event id, from date, to date and abbrev
		List<String> personStringList;

		try {
			for (final PersonEvents pe : new PersonEvents()
					.getFKPersonPid(personPid)) {
				personStringList = new ArrayList<>();

				EventPid = pe.getEventPid();
				personStringList.add(Integer.toString(EventPid));

				Events event = new Events();
				event.get(EventPid);

				Hdates hdate = new Hdates();
				hdate.get(event.getFromDatePid());
				personStringList.add(hdate.getDate().toString());

				hdate.get(event.getToDatePid());
				personStringList.add(hdate.getDate().toString());

				EventRolePid = pe.getEventRolePid();
				personStringList.add(Integer.toString(EventRolePid));

				final EventRoles role = new EventRoles();
				role.get(EventRolePid);
				personStringList.add(role.getAbbreviation());
				lls.add(personStringList);
			}
		} catch (final MvpException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

		return lls;
	}

	/**
	 * @param eventPid
	 * @return
	 * @throws Exception
	 */
	public List<List<String>> getStringListByEvent(int eventPid)
			throws Exception {
		final List<List<String>> lls = new ArrayList<>();
		PersonServer ls;

		if (eventPid == 0) {
			return lls;
		}

		List<String> personStringList;

		try {
			for (final PersonEvents pe : new PersonEvents()
					.getFKEventPid(eventPid)) {
				personStringList = new ArrayList<>();

				ls = new PersonServer();
				PersonPid = pe.getPersonPid();
				ls.get(PersonPid);
				personStringList.add(Integer.toString(PersonPid));

				personStringList.add(Integer.toString(pe.getPersonEventPid()));

				personStringList.add(ls.getPrimaryName());

				EventRolePid = pe.getEventRolePid();
				personStringList.add(Integer.toString(EventRolePid));

				final EventRoles role = new EventRoles();
				role.get(EventRolePid);
				personStringList.add(role.getAbbreviation());
				lls.add(personStringList);
			}
		} catch (final MvpException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

		return lls;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	@Override
	public int insert() throws Exception {
		personEvent.setEventPid(EventPid);
		personEvent.setEventRolePid(EventRolePid);
		personEvent.setPersonPid(PersonPid);
		personEvent.setPrimaryEvent(isPrimaryEvent());
		personEvent.setPrimaryPerson(isPrimaryPerson());
		return personEvent.insert();
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
	 * @return the primaryPerson
	 */
	public boolean isPrimaryPerson() {
		return PrimaryPerson;
	}

	/**
	 * @param eventPid the eventPid to set
	 */
	public void setEventPid(int eventPid) {
		EventPid = eventPid;
	}

	/**
	 * @param eventRolePid the eventRolePid to set
	 */
	public void setEventRolePid(int eventRolePid) {
		EventRolePid = eventRolePid;
	}

	/**
	 * @param personEventPid the personEventPid to set
	 */
	public void setPersonEventPid(int personEventPid) {
		PersonEventPid = personEventPid;
	}

	/**
	 * @param personPid the personPid to set
	 */
	public void setPersonPid(int personPid) {
		PersonPid = personPid;
	}

	/**
	 * @param primaryEvent the primaryEvent to set
	 */
	public void setPrimaryEvent(boolean primaryEvent) {
		PrimaryEvent = primaryEvent;
	}

	/**
	 * @param primaryPerson the primaryPerson to set
	 */
	public void setPrimaryPerson(boolean primaryPerson) {
		PrimaryPerson = primaryPerson;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.servers.IHREServer#update()
	 */
	@Override
	public void update() throws Exception {

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
