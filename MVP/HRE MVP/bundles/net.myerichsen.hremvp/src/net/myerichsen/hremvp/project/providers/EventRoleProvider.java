package net.myerichsen.hremvp.project.providers;

import java.util.List;

import net.myerichsen.hremvp.IHREProvider;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.project.servers.EventRoleServer;

/**
 * Provides all data for an personEvent Role
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 19. jun. 2019
 *
 */
public class EventRoleProvider implements IHREProvider {
	private int EventRolePid;
	private int EventTypePid;
	private String Abbreviation;
	private final EventRoleServer server;

	/**
	 * Constructor
	 *
	 */
	public EventRoleProvider() {
		server = new EventRoleServer();
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
	 *
	 */
	public void get() {
		// TODO Auto-generated method stub

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
		setEventTypePid(server.getEventTypePid());
		setAbbreviation(server.getAbbreviation());
	}

	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return Abbreviation;
	}

	/**
	 * @return the eventRolePid
	 */
	public int getEventRolePid() {
		return EventRolePid;
	}

//	/**
//	 * @param key
//	 * @return
//	 * @throws MvpException
//	 * @throws Exception
//	 */
//	public List<List<String>> getNameList(int key)
//			throws Exception {
//		return server.getNameList(key);
//	}

	/**
	 * @return the eventTypePid
	 */
	public int getEventTypePid() {
		return EventTypePid;
	}

	public List<List<String>> getEventTypeStringList(int eventTypePid)
			throws Exception {
		return server.getEventTypeStringList(eventTypePid);
	}

	/**
	 * @return
	 */
	public int getLabelPid() {
		return server.getLabelPid();
	}

	/**
	 * @return stringList A list of lists of event Role pids, label pids,
	 *         abbreviations, generic labels and type pids
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		return server.getStringList();
	}

	/**
	 * @param labelPid
	 * @return stringList A list of lists of pid, abbreviation and label in the
	 *         active language
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList(int labelPid) throws Exception {
		return server.getStringList(labelPid);
	}

	public List<List<String>> getStringListByType(int eventTypePid)
			throws Exception {
		return server.getStringListByType(eventTypePid);
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
		server.setAbbreviation(Abbreviation);
		server.setEventTypePid(EventTypePid);
		return server.insert();
	}

	/**
	 * @param abbreviation
	 */
	public void setAbbreviation(String abbreviation) {
		Abbreviation = abbreviation;
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
		server.setEventRolePid(EventRolePid);
		server.setAbbreviation(Abbreviation);
		server.update();
	}
}
