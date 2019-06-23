package net.myerichsen.hremvp.project.servers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.json.JSONStringer;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.Dictionary;
import net.myerichsen.hremvp.dbmodels.EventRoles;
import net.myerichsen.hremvp.dbmodels.Languages;

/**
 * Business logic interface for {@link net.myerichsen.hremvp.dbmodels.Events}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 23. jun. 2019
 *
 */
public class EventRoleServer implements IHREServer {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private int EventRolePid;
	private int EventTypePid;
	private String abbreviation;

	private final EventRoles eventRole;

	/**
	 * Constructor
	 *
	 */
	public EventRoleServer() {
		eventRole = new EventRoles();
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
		eventRole.delete(key);
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
		eventRole.get(key);
		setEventTypePid(eventRole.getEventTypePid());
		setAbbreviation(eventRole.getAbbreviation());
	}

	/**
	 * @return
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @return the eventRolePid
	 */
	public int getEventRolePid() {
		return EventRolePid;
	}

	/**
	 * @return the eventTypePid
	 */
	public int getEventTypePid() {
		return EventTypePid;
	}

	/**
	 * @param eventTypePid
	 * @return
	 * @throws Exception
	 */
	public List<List<String>> getEventTypeStringList(int eventTypePid)
			throws Exception {
		final List<List<String>> lls = new ArrayList<>();
		List<String> stringList;
		int labelPid;

		final List<EventRoles> fkEventTypePid = eventRole
				.getFKEventTypePid(eventTypePid);

		for (final EventRoles eventRoles : fkEventTypePid) {
			stringList = new ArrayList<>();
			stringList.add(Integer.toString(eventRoles.getEventRolePid()));

			labelPid = eventRoles.getLabelPid();
			stringList.add(Integer.toString(labelPid));
			stringList.add(eventRoles.getAbbreviation());

			lls.add(stringList);
		}
		return lls;
	}

	/**
	 * @return
	 */
	public int getLabelPid() {
		return eventRole.getLabelPid();
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
			js.key("eventroles");
			js.array();

			final List<List<String>> stringList = getStringList();

			for (final List<String> list : stringList) {
				js.object();
				js.key("pid");
				js.value(list.get(0));
				js.key("name");
				js.value(list.get(2));
				js.key("endpoint");
				js.value(request.getRequestURL() + list.get(0));
				js.endObject();
			}

			js.endArray();
			js.endObject();
			return js.toString();
		}

		if (targetSize == 2) {
			js.key("eventrole");
			js.object();

			final List<String> stringList = getStringList(
					Integer.parseInt(targetParts[1])).get(0);

			js.key("pid");
			js.value(stringList.get(0));
			js.key("abbreviation");
			js.value(stringList.get(2));
			js.key("label");
			js.value(stringList.get(3));

			LOGGER.log(Level.FINE, "{0}", js);

			js.endObject();
		}

		js.endObject();
		return js.toString();
	}

	/**
	 * @return stringList A list of lists of event Role pids, label pids,
	 *         abbreviations, generic labels and event type pids
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		List<String> stringList;
		List<Dictionary> fkLabelPid;
		String label = "";

		final IPreferenceStore store = new ScopedPreferenceStore(
				InstanceScope.INSTANCE, "net.myerichsen.hremvp");
		final String guiLanguage = store.getString("GUILANGUAGE");
		final List<List<String>> lls = new ArrayList<>();
		final Dictionary dictionary = new Dictionary();

		final List<EventRoles> list = eventRole.get();

		for (final EventRoles st : list) {
			stringList = new ArrayList<>();
			stringList.add(Integer.toString(st.getEventRolePid()));
			stringList.add(Integer.toString(st.getLabelPid()));
			stringList.add(st.getAbbreviation());

			fkLabelPid = dictionary.getFKLabelPid(st.getLabelPid());

			for (final Dictionary d : fkLabelPid) {
				if (guiLanguage.equals(d.getIsoCode())) {
					label = d.getLabel();
				}
			}

			stringList.add(label);
			stringList.add(Integer.toString(st.getEventTypePid()));
			lls.add(stringList);
		}
		return lls;
	}

	/**
	 * @param labelPid
	 * @param abbreviation
	 * @return stringList A list of lists of event Role pids, label pids, iso
	 *         codes and generic labels
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList(int labelPid) throws Exception {
		final List<List<String>> lls = new ArrayList<>();

		if (labelPid == 0) {
			return lls;
		}

		String eventRolePidString = "1";
		final List<EventRoles> list = eventRole.get();

		for (final EventRoles eventRoles : list) {
			if (eventRoles.getLabelPid() == labelPid) {
				eventRolePidString = Integer
						.toString(eventRoles.getEventRolePid());
			}
		}

		List<String> stringList;
		String label = "";

		final Dictionary dictionary = new Dictionary();
		final List<Dictionary> fkLabelPid = dictionary.getFKLabelPid(labelPid);

		final Languages language = new Languages();

		for (final Languages l : language.get()) {
			stringList = new ArrayList<>();
			stringList.add(eventRolePidString);
			stringList.add(Integer.toString(labelPid));
			stringList.add(l.getIsocode());

			for (final Dictionary d : fkLabelPid) {
				if (l.getIsocode().equals(d.getIsoCode())) {
					label = d.getLabel();
					break;
				}
			}

			stringList.add(label);
			lls.add(stringList);
		}
		return lls;
	}

	/**
	 * @param eventTypePid
	 * @return
	 * @throws Exception
	 */
	public List<List<String>> getStringListByType(int eventTypePid)
			throws Exception {
		final List<List<String>> lls = new ArrayList<>();

		if (eventTypePid == 0) {
			return lls;
		}

		List<String> stringList;

		final List<EventRoles> list = eventRole.getFKEventTypePid(eventTypePid);

		for (EventRoles eventRoles : list) {
			stringList = new ArrayList<>();
			stringList.add(Integer.toString(eventRoles.getEventRolePid()));
			stringList.add(eventRoles.getAbbreviation());
			lls.add(stringList);
		}
		return lls;
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
		eventRole.setAbbreviation(abbreviation);
		final Dictionary dictionary = new Dictionary();
		eventRole.setLabelPid(dictionary.getNextLabelPid());
		eventRole.setEventTypePid(EventTypePid);
		return eventRole.insert();
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
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * @param eventRolePid the eventRolePid to set
	 */
	public void setEventRolePid(int eventRolePid) {
		EventRolePid = eventRolePid;
	}

	/**
	 * @param eventTypePid the eventTypePid to set
	 */
	public void setEventTypePid(int eventTypePid) {
		EventTypePid = eventTypePid;
	}

	/**
	 * @param labelPid the labelPid to set
	 */
	public void setLabelPid(int labelPid) {
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
		eventRole.setEventRolePid(EventRolePid);
		eventRole.setAbbreviation(abbreviation);
		eventRole.update();
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
