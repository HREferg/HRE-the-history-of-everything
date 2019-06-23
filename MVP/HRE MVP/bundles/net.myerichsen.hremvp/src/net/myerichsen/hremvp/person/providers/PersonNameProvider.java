package net.myerichsen.hremvp.person.providers;

import java.util.ArrayList;
import java.util.List;

import net.myerichsen.hremvp.IHREProvider;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.person.servers.PersonNameServer;

/**
 * Provides all data for a single name for a person
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 4. jun. 2019
 *
 */
public class PersonNameProvider implements IHREProvider {
//	private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private int namePid;
	private int personPid;
	private int nameType;
	private String nameTypeLabel;
	private int fromDatePid;
	private int toDatePid;
	private boolean primaryName;
	private int nameStylePid;
	private List<List<String>> nameList;

	private final PersonNameServer server;

	/**
	 * Constructor
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 *
	 */
	public PersonNameProvider() {
		server = new PersonNameServer();
		nameList = new ArrayList<>();
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
		setNamePid(key);
		setPersonPid(server.getPersonPid());
		setNameType(server.getNameType());
		setNameTypeLabel(server.getNameTypeLabel());
		setFromDatePid(server.getFromDate());
		setToDatePid(server.getToDate());
		setPrimaryName(server.isPrimaryName());
		setNameStylePid(server.getNameStylePid());
		setNameList(server.getNameList());
	}

	/**
	 * @return the fromDatePid
	 */
	public int getFromDatePid() {
		return fromDatePid;
	}

	/**
	 * @return the nameList
	 */
	public List<List<String>> getNameList() {
		return nameList;
	}

	/**
	 * @return the namePid
	 */
	public int getNamePid() {
		return namePid;
	}

	/**
	 * Get a string of name parts for each name
	 *
	 * @return sa A list of name strings
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 */
	public String[] getNameStrings() throws Exception {
		return server.getNameStrings();
	}

	/**
	 * @return the nameStylePid
	 */
	public int getNameStylePid() {
		return nameStylePid;
	}

	/**
	 * @return the nameType
	 */
	public int getNameType() {
		return nameType;
	}

	/**
	 * @return the nameTypeLabel
	 */
	public String getNameTypeLabel() {
		return nameTypeLabel;
	}

	/**
	 * @return the personPid
	 */
	public int getPersonPid() {
		return personPid;
	}

	/**
	 * Get a string of name parts for the primary name of a person
	 *
	 * @param personPid The persistent PID of the person
	 * @return s The name
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 */
	public String getPrimaryNameString(int personPid) throws Exception {
		return server.getPrimaryNameString(personPid);
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
	 * @return the toDatePid
	 */
	public int getToDatePid() {
		return toDatePid;
	}

	/**
	 * Insert a row
	 *
	 * @return
	 *
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public int insert() throws Exception {
		server.setPersonPid(personPid);
		server.setNameType(nameType);
		server.setFromDatePid(fromDatePid);
		server.setToDatePid(toDatePid);
		server.setPrimaryName(primaryName);
		server.setNameStylePid(nameStylePid);
		return server.insert();
	}

	/**
	 * @return the primaryName
	 */
	public boolean isPrimaryName() {
		return primaryName;
	}

	/**
	 * @param data.fromDatePid the fromDatePid to set
	 */
	public void setFromDatePid(int i) {
		fromDatePid = i;
	}

	/**
	 * @param nameList the nameList to set
	 */
	public void setNameList(List<List<String>> nameList) {
		this.nameList = nameList;
	}

	/**
	 * @param namePid the namePid to set
	 */
	public void setNamePid(int namePid) {
		this.namePid = namePid;
	}

	/**
	 * @param nameStylePid the nameStylePid to set
	 */
	public void setNameStylePid(int nameStylePid) {
		this.nameStylePid = nameStylePid;
	}

	/**
	 * @param nameType the nameType to set
	 */
	public void setNameType(int nameType) {
		this.nameType = nameType;
	}

	/**
	 * @param nameTypeLabel the nameTypeLabel to set
	 */
	public void setNameTypeLabel(String nameTypeLabel) {
		this.nameTypeLabel = nameTypeLabel;
	}

	/**
	 * @param personPid the personPid to set
	 */
	public void setPersonPid(int personPid) {
		this.personPid = personPid;
	}

	/**
	 * @param primaryName the primaryName to set
	 */
	public void setPrimaryName(boolean primaryName) {
		this.primaryName = primaryName;
	}

	/**
	 * @param data.toDatePid the toDatePid to set
	 */
	public void setToDatePid(int toDate) {
		toDatePid = toDate;
	}

	/**
	 * Insert a row
	 *
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public void update() throws Exception {
		server.setNamePid(namePid);
		server.setPersonPid(personPid);
		server.setNameType(nameType);
		server.setNameTypeLabel(nameTypeLabel);
		server.setFromDatePid(fromDatePid);
		server.setFromDatePid(toDatePid);
		server.setPrimaryName(primaryName);
		server.setNameStylePid(nameStylePid);
		server.update();
	}

}
