package net.myerichsen.hremvp.project.providers;

import java.util.ArrayList;
import java.util.List;

import net.myerichsen.hremvp.IHREProvider;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.PersonNameMaps;
import net.myerichsen.hremvp.project.servers.PersonNameMapServer;

/**
 * Provides all data for a single map view part
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 13. apr. 2019
 *
 */
public class PersonNameMapProvider implements IHREProvider {
	// private static Logger LOGGER =
	// Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private int nameMapPid;
	private String label;
	private int partNo;
	private int nameStylePid;
	private String styleLabel;

	private final PersonNameMapServer server;

	/**
	 * Constructor
	 *
	 */
	public PersonNameMapProvider() {
		server = new PersonNameMapServer();
	}

	/**
	 * Delete a row
	 *
	 * @param key The persistent ID of the row
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors.
	 * @throws MvpException Application specific exception
	 */
	@Override
	public void delete(int key) throws Exception {
		server.delete(key);
	}

	/**
	 * @param personNameStylePid
	 * @throws MvpException
	 * @throws Exception
	 */
	public void deletePersonNameStylePid(int personNameStylePid)
			throws Exception {
		server.deletePersonNameStylePid(personNameStylePid);
	}

	/**
	 * Get a row
	 *
	 * @param key The persistent ID of the row
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors.
	 * @throws MvpException Application specific exception
	 */
	@Override
	public void get(int key) throws Exception {
		server.get(key);

		setLabel(server.getLabel());
		setNameMapPid(server.getNameMapPid());
		setNameStylePid(server.getNameStylePid());
		setPartNo(server.getPartNo());
		setStyleLabel(server.getStyleLabel());
	}

	/**
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public List<PersonNameMaps> getFKNameStylePid(int key) throws Exception {
		return server.getFKNameStylePid(key);
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return the nameMapPid
	 */
	public int getNameMapPid() {
		return nameMapPid;
	}

	/**
	 * @return the nameStylePid
	 */
	public int getNameStylePid() {
		return nameStylePid;
	}

	/**
	 * @return the partNo
	 */
	public int getPartNo() {
		return partNo;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#getStringList()
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		return new ArrayList<>();
	}

	/**
	 * @param personNameStylePid
	 * @return List A list of lists of name map pid, label pid, label and
	 *         dictionary pid
	 * @throws MvpException
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList(int personNameStylePid)
			throws Exception {
		return server.getStringList(personNameStylePid);
	}

	/**
	 * @return the styleLabel
	 */
	public String getStyleLabel() {
		return styleLabel;
	}

	/**
	 * Insert a row
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors.
	 *
	 */
	@Override
	public int insert() throws Exception {
		server.setLabel(label);
		server.setNameMapPid(nameMapPid);
		server.setNameStylePid(nameStylePid);
		server.setPartNo(partNo);
		return server.insert();
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @param nameMapPid the nameMapPid to set
	 */
	public void setNameMapPid(int nameMapPid) {
		this.nameMapPid = nameMapPid;
	}

	/**
	 * @param nameStylePid the nameStylePid to set
	 */
	public void setNameStylePid(int nameStylePid) {
		this.nameStylePid = nameStylePid;
	}

	/**
	 * @param partNo the partNo to set
	 */
	public void setPartNo(int partNo) {
		this.partNo = partNo;
	}

	/**
	 * @param styleLabel the styleLabel to set
	 */
	public void setStyleLabel(String styleLabel) {
		this.styleLabel = styleLabel;
	}

	/**
	 * Update a row
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors.
	 *
	 */
	@Override
	public void update() throws Exception {
		server.setLabel(label);
		server.setNameMapPid(nameMapPid);
		server.setNameStylePid(nameStylePid);
		server.setPartNo(partNo);
		server.update();
	}

}
