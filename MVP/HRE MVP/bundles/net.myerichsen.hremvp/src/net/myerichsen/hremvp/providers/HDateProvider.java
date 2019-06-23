package net.myerichsen.hremvp.providers;

import java.sql.Date;
import java.util.List;

import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.servers.HDateServer;

/**
 * Provides all data for a single historical date
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 16. mar. 2019
 *
 */
public class HDateProvider {
	private int HdatePid;
	private int TableId;
	private String OriginalText;
	private Date Date;
	private Date SortDate;
	private String Surety;

	private final HDateServer server;

	/**
	 * Constructor
	 *
	 */
	public HDateProvider() {
		server = new HDateServer();
	}

	/**
	 * Delete a row
	 *
	 * @param key The persistent ID of the row
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	public void delete(int key) throws Exception {
		server.delete(key);
	}

	/**
	 * Get all rows
	 *
	 * @return A list of lists of strings with pids and labels
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	public List<List<String>> get() throws Exception {
		return server.get();
	}

	/**
	 * Get a row
	 *
	 * @param key The persistent ID of the row
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	public void get(int key) throws Exception {
		server.get(key);
		setTableId(server.getTableId());
		setOriginalText(server.getOriginalText());
		setDate(server.getDate());
		setSortDate(server.getSortDate());
		setSurety(server.getSurety());
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
	public Date getSortDate() {
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
		server.setTableId(getTableId());
		server.setOriginalText(getOriginalText());
		server.setDate(getDate());
		server.setSortDate(getSortDate());
		server.setSurety(getSurety());
		return server.insert();
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
		server.setTableId(getTableId());
		server.setOriginalText(getOriginalText());
		server.setDate(getDate());
		server.setSortDate(getSortDate());
		server.setSurety(getSurety());
		server.update();
	}

}