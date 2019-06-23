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
import net.myerichsen.hremvp.dbmodels.EventTypes;
import net.myerichsen.hremvp.dbmodels.Languages;

/**
 * Business logic interface for {@link net.myerichsen.hremvp.dbmodels.Events}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 27. apr. 2019
 *
 */
public class EventTypeServer implements IHREServer {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private int EventTypePid;
	private String abbreviation;
	private int TableId = 17;

	private final EventTypes eventType;

	/**
	 * Constructor
	 *
	 */
	public EventTypeServer() {
		eventType = new EventTypes();
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
		eventType.delete(key);
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
	 * Get all rows
	 *
	 * @return
	 * @throws Exception
	 */
	public List<EventTypes> get() throws Exception {
		return eventType.get();
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
		eventType.get(key);
		setEventTypePid(eventType.getEventTypePid());
		setAbbreviation(eventType.getAbbreviation());
	}

	/**
	 * @return
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @return the eventTypePid
	 */
	public int getEventTypePid() {
		return EventTypePid;
	}

	/**
	 * @return
	 */
	public int getLabelPid() {
		return eventType.getLabelPid();
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
			js.key("eventtypes");
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
			js.key("eventtype");
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

//	/**
//	 * @param key
//	 * @return
//	 * @throws Exception
//	 * @throws MvpException
//	 */
//	public List<List<String>> getNameList(int key)
//			throws Exception {
//		List<String> stringList;
//
//		final List<List<String>> lls = new ArrayList<>();
//		final EventNames names = new EventNames();
//		final List<EventNames> eventNameList = names.getFKEventTypePid(key);
//		new Languages();
//
//		for (final EventNames eventNames : eventNameList) {
//			stringList = new ArrayList<>();
//			stringList.add(Integer.toString(eventNames.getEventTypePid()));
//			stringList.add(eventNames.getLabel());
//
////			language.get(eventNames.getLanguagePid());
////			stringList.add(language.getLabel());
////			stringList.add(language.getIsocode());
//			lls.add(stringList);
//		}
//
//		return lls;
//	}

	/**
	 * @return stringList A list of lists of event type pids, label pids,
	 *         abbreviations and generic labels
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

		final List<EventTypes> list = eventType.get();

		for (final EventTypes st : list) {
			stringList = new ArrayList<>();
			stringList.add(Integer.toString(st.getEventTypePid()));
			stringList.add(Integer.toString(st.getLabelPid()));
			stringList.add(st.getAbbreviation());

			fkLabelPid = dictionary.getFKLabelPid(st.getLabelPid());

			for (final Dictionary d : fkLabelPid) {
				if (guiLanguage.equals(d.getIsoCode())) {
					label = d.getLabel();
				}
			}

			stringList.add(label);
			lls.add(stringList);
		}
		return lls;
	}

	/**
	 * @param labelPid
	 * @param abbreviation
	 * @return stringList A list of lists of event type pids, label pids, iso
	 *         codes and generic labels
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList(int labelPid) throws Exception {
		final List<List<String>> lls = new ArrayList<>();

		if (labelPid == 0) {
			return lls;
		}

		String eventTypePidString = "1";
		final List<EventTypes> list = eventType.get();

		for (final EventTypes eventTypes : list) {
			if (eventTypes.getLabelPid() == labelPid) {
				eventTypePidString = Integer
						.toString(eventTypes.getEventTypePid());
			}
		}

		List<String> stringList;
		String label = "";

		final Dictionary dictionary = new Dictionary();
		final List<Dictionary> fkLabelPid = dictionary.getFKLabelPid(labelPid);

		final Languages language = new Languages();

		for (final Languages l : language.get()) {
			stringList = new ArrayList<>();
			stringList.add(eventTypePidString);
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
	 * @return the tableId
	 */
	public int getTableId() {
		return TableId;
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
		eventType.setAbbreviation(abbreviation);
		final Dictionary dictionary = new Dictionary();
		eventType.setLabelPid(dictionary.getNextLabelPid());
		eventType.setTableId(TableId);
		return eventType.insert();
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
	 * @param tableId the tableId to set
	 */
	public void setTableId(int tableId) {
		TableId = tableId;
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
		eventType.setEventTypePid(EventTypePid);
		eventType.setTableId(TableId);
		eventType.update();
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
