package net.myerichsen.hremvp.dbmodels;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import net.myerichsen.hremvp.HreH2ConnectionPool;
import net.myerichsen.hremvp.MvpException;

/**
 * The persistent class for the HDATES database table
 *
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2019
 * @version 27. mar. 2019
 *
 */

public class Hdates {
	private static final String SELECT = "SELECT HDATE_PID, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, "
			+ "ORIGINAL_TEXT, DATE, SORT_DATE, "
			+ "SURETY FROM PUBLIC.HDATES WHERE HDATE_PID = ?";
	private static final String SELECTALL = "SELECT HDATE_PID, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, "
			+ "ORIGINAL_TEXT, DATE, SORT_DATE, "
			+ "SURETY FROM PUBLIC.HDATES ORDER BY DATE";
	private static final String SELECTMAX = "SELECT MAX(HDATE_PID) FROM PUBLIC.HDATES";
	private static final String INSERT = "INSERT INTO PUBLIC.HDATES( "
			+ "HDATE_PID, INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, "
			+ "ORIGINAL_TEXT, DATE, SORT_DATE, SURETY) VALUES ("
			+ "?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE PUBLIC.HDATES SET "
			+ "UPDATE_TSTMP = CURRENT_TIMESTAMP, "
			+ "ORIGINAL_TEXT = ?, DATE = ?, SORT_DATE = ?, "
			+ "SURETY = ? WHERE HDATE_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.HDATES WHERE HDATE_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.HDATES";

	private List<Hdates> modelList;

	private PreparedStatement ps;

	private ResultSet rs;

	private Connection conn;

	private int HdatePid;
	private Timestamp InsertTstmp;
	private Timestamp UpdateTstmp;
	private int TableId;
	private String OriginalText;
	private Date Date;
	private Date SortDate;
	private String Surety;
	private Hdates model;

	public void delete() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(DELETEALL);
		ps.executeUpdate();
		conn.close();
	}

	public void delete(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(DELETE);
		ps.setInt(1, key);
		if (ps.executeUpdate() == 0) {
			conn.close();
			throw new MvpException("ID " + key + " not found");
		}
		conn.close();
	}

	public List<Hdates> get() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Hdates();
			model.setHdatePid(rs.getInt("HDATE_PID"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setOriginalText(rs.getString("ORIGINAL_TEXT"));
			model.setDate(rs.getDate("DATE"));
			model.setSortDate(rs.getDate("SORT_DATE"));
			model.setSurety(rs.getString("SURETY"));
			modelList.add(model);
		}
		conn.close();
		return modelList;
	}

	public void get(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		if (rs.next()) {
			setHdatePid(rs.getInt("HDATE_PID"));
			setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			setTableId(rs.getInt("TABLE_ID"));
			setOriginalText(rs.getString("ORIGINAL_TEXT"));
			setDate(rs.getDate("DATE"));
			setSortDate(rs.getDate("SORT_DATE"));
			setSurety(rs.getString("SURETY"));
		} else {
			throw new MvpException("ID " + key + " not found");
		}
		conn.close();
	}

	/**
	 * Get the Date field.
	 *
	 * @return Contents of the DATE column
	 */
	public Date getDate() {
		return Date;
	}

	/**
	 * Get the HdatePid field.
	 *
	 * @return Contents of the HDATE_PID column
	 */
	public int getHdatePid() {
		return HdatePid;
	}

	/**
	 * Get the InsertTstmp field.
	 *
	 * @return Contents of the INSERT_TSTMP column
	 */
	public Timestamp getInsertTstmp() {
		return InsertTstmp;
	}

	/**
	 * Get the OriginalText field.
	 *
	 * @return Contents of the ORIGINAL_TEXT column
	 */
	public String getOriginalText() {
		return OriginalText;
	}

	/**
	 * Get the SortDate field.
	 *
	 * @return Contents of the SORT_DATE column
	 */
	public Date getSortDate() {
		return SortDate;
	}

	/**
	 * Get the Surety field.
	 *
	 * @return Contents of the SURETY column
	 */
	public String getSurety() {
		return Surety;
	}

	/**
	 * Get the TableId field.
	 *
	 * @return Contents of the TABLE_ID column
	 */
	public int getTableId() {
		return TableId;
	}

	/**
	 * Get the UpdateTstmp field.
	 *
	 * @return Contents of the UPDATE_TSTMP column
	 */
	public Timestamp getUpdateTstmp() {
		return UpdateTstmp;
	}

	public int insert() throws Exception {
		int maxPid = 0;
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTMAX);
		rs = ps.executeQuery();
		if (rs.next()) {
			maxPid = rs.getInt(1);
		}
		maxPid++;

		ps = conn.prepareStatement(INSERT);
		ps.setInt(1, maxPid);
		ps.setString(2, getOriginalText());
		ps.setDate(3, getDate());
		ps.setDate(4, getSortDate());
		ps.setString(5, getSurety());
		ps.executeUpdate();
		conn.close();
		return maxPid;
	}

	/**
	 * Set the Date field
	 *
	 * @param Date Contents of the DATE column
	 */
	public void setDate(java.sql.Date Date) {
		this.Date = Date;
	}

	/**
	 * Set the HdatePid field
	 *
	 * @param HdatePid Contents of the HDATE_PID column
	 */
	public void setHdatePid(int HdatePid) {
		this.HdatePid = HdatePid;
	}

	/**
	 * Set the InsertTstmp field
	 *
	 * @param InsertTstmp Contents of the INSERT_TSTMP column
	 */
	public void setInsertTstmp(Timestamp InsertTstmp) {
		this.InsertTstmp = InsertTstmp;
	}

	/**
	 * Set the OriginalText field
	 *
	 * @param OriginalText Contents of the ORIGINAL_TEXT column
	 */
	public void setOriginalText(String OriginalText) {
		this.OriginalText = OriginalText;
	}

	/**
	 * Set the SortDate field
	 *
	 * @param SortDate Contents of the SORT_DATE column
	 */
	public void setSortDate(java.sql.Date SortDate) {
		this.SortDate = SortDate;
	}

	/**
	 * Set the Surety field
	 *
	 * @param Surety Contents of the SURETY column
	 */
	public void setSurety(String Surety) {
		this.Surety = Surety;
	}

	/**
	 * Set the TableId field
	 *
	 * @param TableId Contents of the TABLE_ID column
	 */
	public void setTableId(int TableId) {
		this.TableId = TableId;
	}

	/**
	 * Set the UpdateTstmp field
	 *
	 * @param UpdateTstmp Contents of the UPDATE_TSTMP column
	 */
	public void setUpdateTstmp(Timestamp UpdateTstmp) {
		this.UpdateTstmp = UpdateTstmp;
	}

	public void update() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(UPDATE);
		ps.setString(1, getOriginalText());
		ps.setDate(2, getDate());
		ps.setDate(3, getSortDate());
		ps.setString(4, getSurety());
		ps.setInt(5, getHdatePid());
		ps.executeUpdate();
		conn.close();
	}

}
