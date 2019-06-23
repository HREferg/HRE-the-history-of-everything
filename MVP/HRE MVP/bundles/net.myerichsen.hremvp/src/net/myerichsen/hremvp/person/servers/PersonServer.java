package net.myerichsen.hremvp.person.servers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONStringer;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.Dictionary;
import net.myerichsen.hremvp.dbmodels.EventRoles;
import net.myerichsen.hremvp.dbmodels.EventTypes;
import net.myerichsen.hremvp.dbmodels.Events;
import net.myerichsen.hremvp.dbmodels.Hdates;
import net.myerichsen.hremvp.dbmodels.Parents;
import net.myerichsen.hremvp.dbmodels.Partners;
import net.myerichsen.hremvp.dbmodels.PersonEvents;
import net.myerichsen.hremvp.dbmodels.PersonNameParts;
import net.myerichsen.hremvp.dbmodels.PersonNames;
import net.myerichsen.hremvp.dbmodels.Persons;
import net.myerichsen.hremvp.dbmodels.Sexes;

/**
 * Business logic interface for {@link net.myerichsen.hremvp.dbmodels.Persons}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 26. apr. 2019
 */
public class PersonServer implements IHREServer {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private int personPid;
	private int birthDatePid;
	private int deathDatePid;
	private List<List<String>> nameList;
	private List<List<String>> personList;

	private final Persons person;
	Dictionary dictionary;

	/**
	 * Constructor
	 *
	 */
	public PersonServer() {
		person = new Persons();
		dictionary = new Dictionary();
		nameList = new ArrayList<>();
		personList = new ArrayList<>();
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
		// Delete all person_sexes
		final Sexes sex = new Sexes();

		for (final Sexes sexes : sex.getFKPersonPid(key)) {
			sex.delete(sexes.getSexesPid());
		}

		// Delete all person names
		final PersonNames name = new PersonNames();
		int namePid = 0;

		for (final PersonNames names : name.getFKPersonPid(key)) {
			namePid = names.getNamePid();

			// Delete all name parts
			final PersonNameParts part = new PersonNameParts();

			for (final PersonNameParts namePart : part.getFKNamePid(namePid)) {
				part.delete(namePart.getNamePartPid());
			}

			name.delete(namePid);
		}

		// Delete all person events and links
		final PersonEvents event = new PersonEvents();

		for (final PersonEvents events : event.getFKPersonPid(key)) {
			events.delete(events.getPersonEventPid());
		}

		// Delete all partner links
		Partners partner = new Partners();

		for (final Partners p : partner.getFKPartner1(key)) {
			partner.delete(p.getPartnerPid());
		}

		partner = new Partners();

		for (final Partners p : partner.getFKPartner2(key)) {
			partner.delete(p.getPartnerPid());
		}

		// Delete all parent links
		Parents parent = new Parents();

		for (final Parents p : parent.getFKChild(key)) {
			parent.delete(p.getParentPid());
		}

		// Delete all child links
		parent = new Parents();

		for (final Parents p : parent.getFKParent(key)) {
			parent.delete(p.getParentPid());
		}

		// Delete person
		person.delete(key);
	}

	/**
	 * Delete a row
	 *
	 * @param target Target
	 */
	@Override
	public void deleteRemote(String target) {

	}

	/**
	 * Get all rows
	 *
	 * @return A list of lists of strings of pids and labels
	 * @throws SQLException
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	public List<Persons> get() throws SQLException {
		return person.get();
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
		person.get(key);
		setBirthDatePid(person.getBirthDatePid());
		setPersonPid(key);
		setDeathDatePid(person.getDeathDatePid());

		// Get all names of the person
		final List<PersonNames> ln = new PersonNames().getFKPersonPid(key);
		PersonNames name;

		final PersonNameServer pns = new PersonNameServer();
		nameList = new ArrayList<>();

		List<String> ls;

		// For each name get pid, name string and primary flag
		for (int i = 0; i < ln.size(); i++) {
			ls = new ArrayList<>();
			name = ln.get(i);
			ls.add(Integer.toString(name.getNamePid()));
			pns.get(name.getNamePid());
			ls.add(pns.getNameStrings()[i]);
			ls.add(Boolean.toString(name.isPrimaryName()));

			nameList.add(ls);
		}

	}

	/**
	 * Get all names for the person
	 *
	 * @return A list of lists of strings of pids and labels
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	public List<List<String>> getAllNames() throws Exception {
		final List<List<String>> allNamesList = new ArrayList<>();
		List<String> stringList;

		final List<Persons> lnsl = person.get();

		List<PersonNames> ln;
		PersonNames name;
		final PersonNameServer ns = new PersonNameServer();
		for (final Persons p : lnsl) {
			// Get all names of each person
			ln = new PersonNames().getFKPersonPid(p.getPersonPid());

			nameList = new ArrayList<>();

			// For each name get pid, name string, and primary flag
			for (int i = 0; i < ln.size(); i++) {
				stringList = new ArrayList<>();
				name = ln.get(i);
				if (name.isPrimaryName()) {
					stringList.add(Integer.toString(name.getNamePid()));
					ns.get(name.getNamePid());
					stringList.add(ns.getNameStrings()[i]);
					allNamesList.add(stringList);
					break;
				}
			}
		}

		return allNamesList;
	}

	/**
	 * Recursive call for ancestors
	 *
	 * @param key
	 * @param childPid
	 * @param generations
	 * @return List of lists of id, child id and primary name
	 * @throws Exception
	 * @throws MvpException
	 */
	public List<List<String>> getAncestorList(int key, int childPid,
			int generations) throws Exception {
		final List<List<String>> ancestorList = new ArrayList<>();
		final PersonNameServer pnp = new PersonNameServer();

		final Parents parentRelation = new Parents();
		final List<Parents> fkChild = parentRelation.getFKChild(key);

		final List<String> ls = new ArrayList<>();
		ls.add(Integer.toString(key));
		ls.add(Integer.toString(childPid));
		ls.add(pnp.getPrimaryNameString(key));
		ancestorList.add(ls);

		if (generations-- > 0) {
			for (final Parents parent : fkChild) {
				ancestorList.addAll(
						getAncestorList(parent.getParent(), key, generations));
			}
		}

		return ancestorList;
	}

	/**
	 * @return the birthDatePid
	 */
	public int getBirthDatePid() {
		return person.getBirthDatePid();
	}

	/**
	 * @param key
	 * @return the list of children
	 * @throws Exception
	 */

	/**
	 * @return the deathDatePid
	 */
	public int getDeathDatePid() {
		return person.getDeathDatePid();
	}

	/**
	 * Recursive call for descendants
	 *
	 * @param key
	 * @param parentPid
	 * @param generations
	 * @return
	 * @throws Exception
	 * @throws MvpException
	 */
	public List<List<String>> getDescendantList(int key, int parentPid,
			int generations) throws Exception {
		final List<List<String>> descendantList = new ArrayList<>();
		final PersonNameServer pnp = new PersonNameServer();

		final Parents parentRelation = new Parents();
		final List<Parents> fkParent = parentRelation.getFKParent(key);

		final List<String> ls = new ArrayList<>();
		ls.add(Integer.toString(key));
		ls.add(Integer.toString(parentPid));
		ls.add(pnp.getPrimaryNameString(key));
		descendantList.add(ls);

		if (generations-- > 0) {
			for (final Parents parent : fkParent) {
				descendantList.addAll(
						getDescendantList(parent.getChild(), key, generations));
			}
		}

		return descendantList;
	}

	/**
	 * @return the nameList
	 */
	public List<List<String>> getNameList() {
		return nameList;
	}

	/**
	 * List all persons.
	 *
	 * @return List of lists of pid, primary name string, birth date and death
	 *         date
	 * @throws Exception
	 */
	public List<List<String>> getPersonList() throws Exception {
		List<String> ls;
		final PersonNameServer pns = new PersonNameServer();

		personList.clear();
		final Hdates hdates = new Hdates();
		String s;
		int personPid2;

		for (final Persons p : get()) {
			ls = new ArrayList<>();
			personPid2 = p.getPersonPid();
			ls.add(Integer.toString(personPid2));
			ls.add(pns.getPrimaryNameString(personPid2));
			s = "";
			if (p.getBirthDatePid() > 0) {
				hdates.get(p.getBirthDatePid());
				s = hdates.getDate().toString();
			}
			ls.add(s);
			s = "";
			if (p.getDeathDatePid() > 0) {
				hdates.get(p.getDeathDatePid());
				s = hdates.getDate().toString();
			}
			ls.add(s);
			personList.add(ls);
		}

		return personList;
	}

	/**
	 * @return the personPid
	 */
	public int getPersonPid() {
		return personPid;
	}

	/**
	 * @return The primary name
	 * @throws Exception
	 */
	public String getPrimaryName() throws Exception {
		final PersonNameServer pns = new PersonNameServer();
		return pns.getPrimaryNameString(personPid);
	}

	/**
	 * Get a row remotely
	 *
	 * @param response Response
	 * @param target   Target
	 * @return js JSON String
	 * @throws Exception Any exception
	 *
	 */
	@Override
	public String getRemote(HttpServletRequest request, String target)
			throws Exception {
		LOGGER.log(Level.FINE, "Target {0}", target);

		final String[] targetParts = target.split("/");
		final int targetSize = targetParts.length;

		final JSONStringer js = new JSONStringer();
		js.object();

		if (targetSize == 0) {
			js.key("persons");
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
			js.endObject();
			return js.toString();
		}

		if (targetSize == 2) {
			js.key("person");
			js.object();

			final List<String> stringList = getStringList(
					Integer.parseInt(targetParts[1])).get(0);

			js.key("pid");
			js.value(stringList.get(0));
			js.key("name");
			js.value(stringList.get(1));
			js.key("fromdate");
			js.value(stringList.get(2));
			js.key("todate");
			js.value(stringList.get(3));
			js.key("primaryname");
			js.value(stringList.get(4));

			LOGGER.log(Level.FINE, "{0}", js);

			js.endObject();
		}

		if (targetSize == 3) {
			if (targetParts[2].equals("events")) {
				js.key("events");
				js.array();

				final List<String> stringList = getStringList(
						Integer.parseInt(targetParts[1])).get(0);
				final PersonEvents pe = new PersonEvents();
				final List<PersonEvents> fkPersonPid = pe
						.getFKPersonPid(Integer.parseInt(stringList.get(0)));

				Events e;
				EventTypes et;
				EventRoles er;
				Hdates hdates;

				for (final PersonEvents personEvents : fkPersonPid) {
					js.object();
					js.key("personeventpid");
					js.value(personEvents.getPersonEventPid());

					js.key("eventpid");
					e = new Events();
					e.get(personEvents.getEventPid());
					js.value(e.getEventPid());

					js.key("fromdate");
					hdates = new Hdates();
					hdates.get(e.getFromDatePid());
					js.value(hdates.getDate().toString());

					js.key("todate");
					hdates.get(e.getFromDatePid());
					js.value(hdates.getDate().toString());

					js.key("type");
					et = new EventTypes();
					et.get(e.getEventTypePid());
					dictionary = new Dictionary();
					final List<Dictionary> fkLabelPid = dictionary
							.getFKLabelPid(et.getLabelPid());
					js.value(fkLabelPid.get(0).getLabel());

					js.key("role");
					er = new EventRoles();
					er.get(personEvents.getEventRolePid());
					js.value(er.getAbbreviation());

					js.endObject();
				}

				LOGGER.log(Level.FINE, "{0}", js);

				js.endArray();
			}
		}

		js.endObject();
		return js.toString();
	}

	/**
	 * @return the siblingList
	 * @throws Exception
	 */
	public List<List<String>> getSiblingList(int personPid) throws Exception {
		final List<List<String>> siblingList = new ArrayList<>();
		List<String> ls;

		if (personPid == 0) {
			return siblingList;
		}

		final PersonNameServer pns = new PersonNameServer();
		final List<Parents> fkParent = new Parents().getFKChild(personPid);

		for (final Parents parents : fkParent) {
			LOGGER.log(Level.INFO, "Parent id: " + parents.getParentPid());
			final List<Parents> fkChild = new Parents()
					.getFKParent(parents.getParentPid());
			final TreeSet<Integer> childList = new TreeSet<>();

			for (final Parents parents4 : fkChild) {
				LOGGER.log(Level.INFO, "Child id: " + parents4.getChild());
				childList.add(parents4.getChild());
				childList.remove(personPid);
			}

			for (final int child : childList) {
				ls = new ArrayList<>();
				ls.add(Integer.toString(child));
				ls.add(pns.getPrimaryNameString(child));

				siblingList.add(ls);
			}
		}
		return siblingList;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getStringList()
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		final List<List<String>> lls = new ArrayList<>();
		List<String> stringList;
		final PersonNameServer pns = new PersonNameServer();

		final List<Persons> list = person.get();

		for (final Persons persons : list) {
			stringList = new ArrayList<>();
			final int personPid2 = persons.getPersonPid();
			stringList.add(Integer.toString(personPid2));
			stringList.add(pns.getPrimaryNameString(personPid2));
			lls.add(stringList);
		}
		return lls;
	}

	/**
	 * Get a list of all names for the person (Copied to
	 * {@link net.myerichsen.hremvp.person.servers.PersonNameServer})
	 *
	 * @param key
	 * @return
	 * @throws MvpException
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList(int key) throws Exception {
		final List<List<String>> lls = new ArrayList<>();
		List<String> stringList;

		if (key == 0) {
			stringList = new ArrayList<>();
			stringList.add("0");
			stringList.add("");
			stringList.add("");
			stringList.add("");
			stringList.add("false");
			lls.add(stringList);
			return lls;
		}

		final PersonNames name = new PersonNames();
		int namePid = 0;
		StringBuilder sb;

		for (final PersonNames names : name.getFKPersonPid(key)) {
			stringList = new ArrayList<>();

			namePid = names.getNamePid();
			stringList.add(Integer.toString(namePid));

			sb = new StringBuilder();
			final PersonNameParts part = new PersonNameParts();

			for (final PersonNameParts namePart : part.getFKNamePid(namePid)) {
				sb.append(namePart.getLabel() + " ");
			}
			stringList.add(sb.toString().trim());

			final Hdates date = new Hdates();

			int datePid = names.getFromDatePid();

			if (datePid == 0) {
				stringList.add("");
			} else {
				date.get(datePid);
				stringList.add(date.getDate().toString());
			}

			datePid = names.getToDatePid();

			if (datePid == 0) {
				stringList.add("");
			} else {
				date.get(datePid);
				stringList.add(date.getDate().toString());
			}

			stringList.add(Boolean.toString(name.isPrimaryName()));

			lls.add(stringList);
		}

		return lls;
	}

	/**
	 * Insert a row
	 *
	 * @return The pid of the row
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public int insert() throws Exception {
		person.setBirthDatePid(birthDatePid);
		person.setDeathDatePid(deathDatePid);
		person.setPersonPid(personPid);
		return person.insert();
	}

	/**
	 * Insert a row
	 *
	 * @param request Request
	 */
	@Override
	public void insertRemote(HttpServletRequest request) {

	}

	/**
	 * @param parentPid
	 * @param childPid
	 * @throws MvpException
	 * @throws Exception
	 */
	public void removeChild(int parentPid, int childPid) throws Exception {
		final Parents parent = new Parents();

		for (final Parents p : parent.getFKParent(parentPid)) {
			if (p.getChild() == childPid) {
				parent.delete(p.getParentPid());
			}
		}
	}

	/**
	 * @param eventPid
	 * @throws MvpException
	 * @throws Exception
	 */
	public void removeEvent(int eventPid) throws Exception {
		final PersonEvents personEvent = new PersonEvents();
		personEvent.getFKEventPid(eventPid);
		personEvent.delete(personEvent.getPersonEventPid());

		final Events event = new Events();
		event.delete(eventPid);
	}

	/**
	 * @param i the birthDatePid to set
	 */
	public void setBirthDatePid(int i) {
		birthDatePid = i;
	}

	/**
	 * @param childrenList the childrenList to set
	 */
	public void setChildrenList(List<List<String>> childrenList) {
	}

	/**
	 * @param i the deathDatePid to set
	 */
	public void setDeathDatePid(int i) {
		deathDatePid = i;
	}

	/**
	 * @param nameList the nameList to set
	 */
	public void setNameList(List<List<String>> nameList) {
		this.nameList = nameList;
	}

	/**
	 * @param personList the personList to set
	 */
	public void setPersonList(List<List<String>> personList) {
		this.personList = personList;
	}

	/**
	 * @param personPid the personPid to set
	 */
	public void setPersonPid(int personPid) {
		this.personPid = personPid;
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
		person.setBirthDatePid(birthDatePid);
		person.setDeathDatePid(deathDatePid);
		person.setPersonPid(personPid);
		person.update();
	}

	/**
	 * Update a row remotely
	 *
	 * @param request Request
	 */
	@Override
	public void updateRemote(HttpServletRequest request) {
	}
}