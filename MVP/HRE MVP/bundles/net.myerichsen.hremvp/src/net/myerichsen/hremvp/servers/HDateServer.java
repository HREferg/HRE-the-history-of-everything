package net.myerichsen.hremvp.servers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.Hdates;

/**
 * Business logic interface for {@link net.myerichsen.hremvp.dbmodels.HDates}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 14. apr. 2019
 *
 */
public class HDateServer {
	private int HdatePid;
	private int TableId;
	private String OriginalText;
	private Date Date;
	private Date SortDate;
	private String Surety;

	private final Hdates hDate;

	/**
	 * Constructor
	 *
	 */
	public HDateServer() {
		hDate = new Hdates();
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
	public void delete(int key) throws Exception {
		hDate.delete(key);
	}

	/**
	 * Get all rows
	 *
	 * @return A list of lists of strings of pids and labels
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	public List<List<String>> get() throws Exception {
		final List<List<String>> lls = new ArrayList<>();
		List<String> stringList;

		final List<Hdates> hdateList = hDate.get();

		for (final Hdates hdate : hdateList) {
			stringList = new ArrayList<>();
			stringList.add(Integer.toString(hdate.getHdatePid()));
			stringList.add(hdate.getDate().toString());
			stringList.add(hdate.getOriginalText());
			lls.add(stringList);
		}

		return lls;
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
	public void get(int key) throws Exception {
		hDate.get(key);
		setTableId(hDate.getTableId());
		setOriginalText(hDate.getOriginalText());
		setDate(hDate.getDate());
		setSortDate(hDate.getSortDate());
		setSurety(hDate.getSurety());
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return Date;
	}

	/**
	 * @return the hdatePid
	 */
	public int getHdatePid() {
		return HdatePid;
	}

	/**
	 * @return the originalText
	 */
	public String getOriginalText() {
		return OriginalText;
	}

	/**
	 * @return the sortDate
	 */
	public java.sql.Date getSortDate() {
		return SortDate;
	}

	/**
	 * @return the surety
	 */
	public String getSurety() {
		return Surety;
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
	public int insert() throws Exception {
		hDate.setOriginalText(getOriginalText());
		hDate.setDate(getDate());
		hDate.setSortDate(getSortDate());
		hDate.setSurety(getSurety());

		return hDate.insert();
	}

	/**
	 * @param date2 the date to set
	 */
	public void setDate(Date date2) {
		Date = date2;
	}

	/**
	 * @param hdatePid the hdatePid to set
	 */
	public void setHdatePid(int hdatePid) {
		HdatePid = hdatePid;
	}

	/**
	 * @param originalText the originalText to set
	 */
	public void setOriginalText(String originalText) {
		OriginalText = originalText;
	}

	/**
	 * @param date2 the sortDate to set
	 */
	public void setSortDate(Date date2) {
		SortDate = date2;
	}

	/**
	 * @param surety the surety to set
	 */
	public void setSurety(String surety) {
		Surety = surety;
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
	public void update() throws Exception {
		hDate.setTableId(getTableId());
		hDate.setOriginalText(getOriginalText());
		hDate.setDate(getDate());
		hDate.setSortDate(getSortDate());
		hDate.setSurety(getSurety());
		hDate.update();
	}
}
