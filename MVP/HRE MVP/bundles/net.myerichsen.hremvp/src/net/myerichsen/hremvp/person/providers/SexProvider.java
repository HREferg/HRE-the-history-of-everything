package net.myerichsen.hremvp.person.providers;

import java.util.List;

import net.myerichsen.hremvp.IHREProvider;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.person.servers.SexServer;

/**
 * Provide all data for a sex
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 23. apr. 2019
 *
 */
public class SexProvider implements IHREProvider {
	private int sexesPid;
	private int personPid;
	private int sexTypePid;
	private int fromDatePid;
	private int toDatePid;
	private boolean primarySex;
	private String sexTypeLabel;
	private String abbreviation;
	private int languagePid;
	private String isocode;

	private final SexServer server;

	/**
	 * Constructor
	 *
	 */
	public SexProvider() {
		server = new SexServer();
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
		server.delete(key);
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
		server.get(key);
		setSexesPid(server.getSexesPid());
		setPersonPid(server.getPersonPid());
		setSexTypePid(server.getSexTypePid());
		setPrimarySex(server.isPrimarySex());
		setFromDatePid(server.getFromDatePid());
		setToDatePid(server.getToDatePid());
		setAbbreviation(server.getAbbreviation());
		setSexTypeLabel(server.getSexTypeLabel());
		setIsocode(server.getIsocode());
	}

	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @return the fromDatePid
	 */
	public int getFromDatePid() {
		return fromDatePid;
	}

	/**
	 * @return the isocode
	 */
	public String getIsocode() {
		return isocode;
	}

//	/**
//	 * @return the languageLabel
//	 */
//	public String getLanguageLabel() {
//		return languageLabel;
//	}

	/**
	 * @return the languagePid
	 */
	public int getLanguagePid() {
		return languagePid;
	}

	/**
	 * @return the personPid
	 */
	public int getPersonPid() {
		return personPid;
	}

	/**
	 * @return the sexesPid
	 */
	public int getSexesPid() {
		return sexesPid;
	}

	/**
	 * @return the sexTypeLabel
	 */
	public String getSexTypeLabel() {
		return sexTypeLabel;
	}

	/**
	 * @return the sexTypePid
	 */
	public int getSexTypePid() {
		return sexTypePid;
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
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 * @return
	 */
	@Override
	public int insert() throws Exception {
		server.setSexesPid(sexesPid);
		server.setPersonPid(personPid);
		server.setSexTypePid(sexTypePid);
		server.setFromDatePid(fromDatePid);
		server.setToDatePid(toDatePid);
		server.setPrimarySex(primarySex);
		return server.insert();
	}

	/**
	 * @return the primarySex
	 */
	public boolean isPrimarySex() {
		return primarySex;
	}

	/**
	 * @param sexPid
	 * @throws Exception
	 */
	public void removeSex(int sexPid) throws Exception {
		server.removeSex(sexPid);
	}

	/**
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * @param i
	 */
	public void setFromDatePid(int i) {
		fromDatePid = i;
	}

	/**
	 * @param isocode the isocode to set
	 */
	public void setIsocode(String isocode) {
		this.isocode = isocode;
	}

	/**
	 * @param languagePid the languagePid to set
	 */
	public void setLanguagePid(int languagePid) {
		this.languagePid = languagePid;
	}

	/**
	 * @param personPid the personPid to set
	 */
	public void setPersonPid(int personPid) {
		this.personPid = personPid;
	}

	/**
	 * @param primarySex the primarySex to set
	 */
	public void setPrimarySex(boolean primarySex) {
		this.primarySex = primarySex;
	}

	/**
	 * @param sexesPid the sexesPid to set
	 */
	public void setSexesPid(int sexesPid) {
		this.sexesPid = sexesPid;
	}

	/**
	 * @param sexTypeLabel the sexTypeLabel to set
	 */
	public void setSexTypeLabel(String sexTypeLabel) {
		this.sexTypeLabel = sexTypeLabel;
	}

	/**
	 * @param sexTypePid the sexTypePid to set
	 */
	public void setSexTypePid(int sexTypePid) {
		this.sexTypePid = sexTypePid;
	}

	/**
	 * @param toDatePid the toDatePid to set
	 */
	public void setToDatePid(int toDatePid) {
		this.toDatePid = toDatePid;
	}

	/**
	 * Update a row
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 */
	@Override
	public void update() throws Exception {
		server.setSexesPid(sexesPid);
		server.setPersonPid(personPid);
		server.setSexTypePid(sexTypePid);
		server.setFromDatePid(fromDatePid);
		server.setToDatePid(toDatePid);
		server.setPrimarySex(primarySex);
		server.update();
	}
}
