package net.myerichsen.hremvp.project.providers;

import java.util.List;

import net.myerichsen.hremvp.IHREProvider;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.project.servers.EventTypeServer;

/**
 * Provides all data for an personEvent type
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 4. mar. 2019
 *
 */
public class EventTypeProvider implements IHREProvider {
	private int EventTypePid;
	private String Abbreviation;
	private int TableId;
	private final EventTypeServer server;

	/**
	 * Constructor
	 *
	 */
	public EventTypeProvider() {
		server = new EventTypeServer();
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

//	/**
//	 * Get all rows
//	 *
//	 * @return A list of lists of strings with pids and labels
//	 * @throws Exception An exception that provides information on a database
//	 *                      access error or other errors
//	 * @throws MvpException Application specific exception
//	 */
//	@Override
//	public List<List<String>> get() throws Exception {
//		return server.get();
//	}

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
	 * @return the eventTypePid
	 */
	public int getEventTypePid() {
		return EventTypePid;
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
	 * @return
	 */
	public int getLabelPid() {
		return server.getLabelPid();
	}

	/**
	 * @return stringList A list of lists of event type pids, label pids,
	 *         abbreviations and generic labels
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
		server.setAbbreviation(Abbreviation);
		return server.insert();
	}

	/**
	 * @param abbreviation
	 */
	public void setAbbreviation(String abbreviation) {
		Abbreviation = abbreviation;
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
		server.setEventTypePid(EventTypePid);
		server.setAbbreviation(Abbreviation);
		server.update();
	}

}
