package net.myerichsen.hremvp.dbmodels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import net.myerichsen.hremvp.HreH2ConnectionPool;
import net.myerichsen.hremvp.MvpException;

/**
 * The persistent class for the COMMIT_LOGS database table
 *
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2019
 * @version 24. feb. 2019
 *
 */

public class CommitLogs {
	private static final String SELECT = "SELECT COMMIT_LOG_PID, "
			+ "CHANGED_TABLE_ID, CHANGED_RECORD_PID, "
			+ "CHANGED_TIMESTAMP, USERID_PID, COLUMN_NAME_LIST, "
			+ "COLUMN_DATA_LIST, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID FROM PUBLIC.COMMIT_LOGS WHERE COMMIT_LOG_PID = ?";
	private static final String SELECT_USERID_PID = "SELECT "
			+ "COMMIT_LOG_PID, CHANGED_TABLE_ID, CHANGED_RECORD_PID, "
			+ "CHANGED_TIMESTAMP, USERID_PID, COLUMN_NAME_LIST, "
			+ "COLUMN_DATA_LIST, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID FROM PUBLIC.COMMIT_LOGS WHERE USERID_PID = ? ORDER BY COMMIT_LOG_PID";
	private static final String SELECTALL = "SELECT COMMIT_LOG_PID, "
			+ "CHANGED_TABLE_ID, CHANGED_RECORD_PID, "
			+ "CHANGED_TIMESTAMP, USERID_PID, COLUMN_NAME_LIST, "
			+ "COLUMN_DATA_LIST, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID FROM PUBLIC.COMMIT_LOGS ORDER BY COMMIT_LOG_PID";
	private static final String SELECTMAX = "SELECT MAX(COMMIT_LOG_PID) FROM PUBLIC.COMMIT_LOGS";
	private static final String INSERT = "INSERT INTO PUBLIC.COMMIT_LOGS( "
			+ "COMMIT_LOG_PID, CHANGED_TABLE_ID, CHANGED_RECORD_PID, "
			+ "CHANGED_TIMESTAMP, USERID_PID, COLUMN_NAME_LIST, "
			+ "COLUMN_DATA_LIST, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String UPDATE = "UPDATE PUBLIC.COMMIT_LOGS SET "
			+ "CHANGED_TABLE_ID = ?, CHANGED_RECORD_PID = ?, "
			+ "CHANGED_TIMESTAMP = ?, USERID_PID = ?, "
			+ "COLUMN_NAME_LIST = ?, COLUMN_DATA_LIST = ?, "
			+ "INSERT_TSTMP = ?, UPDATE_TSTMP = ?, "
			+ "TABLE_ID = ? WHERE COMMIT_LOG_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.COMMIT_LOGS WHERE COMMIT_LOG_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.COMMIT_LOGS";

	private List<CommitLogs> modelList;

	private PreparedStatement ps;

	private ResultSet rs;

	private Connection conn;

	private int CommitLogPid;
	private int ChangedTableId;
	private int ChangedRecordPid;
	private Timestamp ChangedTimestamp;
	private int UseridPid;
	private String ColumnNameList;
	private String ColumnDataList;
	private Timestamp InsertTstmp;
	private Timestamp UpdateTstmp;
	private int TableId;
	private CommitLogs model;

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

	public List<CommitLogs> get() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new CommitLogs();
			model.setCommitLogPid(rs.getInt("COMMIT_LOG_PID"));
			model.setChangedTableId(rs.getInt("CHANGED_TABLE_ID"));
			model.setChangedRecordPid(rs.getInt("CHANGED_RECORD_PID"));
			model.setChangedTimestamp(rs.getTimestamp("CHANGED_TIMESTAMP"));
			model.setUseridPid(rs.getInt("USERID_PID"));
			model.setColumnNameList(rs.getString("COLUMN_NAME_LIST"));
			model.setColumnDataList(rs.getString("COLUMN_DATA_LIST"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
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
			setCommitLogPid(rs.getInt("COMMIT_LOG_PID"));
			setChangedTableId(rs.getInt("CHANGED_TABLE_ID"));
			setChangedRecordPid(rs.getInt("CHANGED_RECORD_PID"));
			setChangedTimestamp(rs.getTimestamp("CHANGED_TIMESTAMP"));
			setUseridPid(rs.getInt("USERID_PID"));
			setColumnNameList(rs.getString("COLUMN_NAME_LIST"));
			setColumnDataList(rs.getString("COLUMN_DATA_LIST"));
			setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			setTableId(rs.getInt("TABLE_ID"));
		} else {
			throw new MvpException("ID " + key + " not found");
		}
		conn.close();
	}

	/**
	 * Get the ChangedRecordPid field.
	 *
	 * @return Contents of the CHANGED_RECORD_PID column
	 */
	public int getChangedRecordPid() {
		return ChangedRecordPid;
	}

	/**
	 * Get the ChangedTableId field.
	 *
	 * @return Contents of the CHANGED_TABLE_ID column
	 */
	public int getChangedTableId() {
		return ChangedTableId;
	}

	/**
	 * Get the ChangedTimestamp field.
	 *
	 * @return Contents of the CHANGED_TIMESTAMP column
	 */
	public Timestamp getChangedTimestamp() {
		return ChangedTimestamp;
	}

	/**
	 * Get the ColumnDataList field.
	 *
	 * @return Contents of the COLUMN_DATA_LIST column
	 */
	public String getColumnDataList() {
		return ColumnDataList;
	}

	/**
	 * Get the ColumnNameList field.
	 *
	 * @return Contents of the COLUMN_NAME_LIST column
	 */
	public String getColumnNameList() {
		return ColumnNameList;
	}

	/**
	 * Get the CommitLogPid field.
	 *
	 * @return Contents of the COMMIT_LOG_PID column
	 */
	public int getCommitLogPid() {
		return CommitLogPid;
	}

	public List<CommitLogs> getFKUseridPid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_USERID_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new CommitLogs();
			model.setCommitLogPid(rs.getInt("COMMIT_LOG_PID"));
			model.setChangedTableId(rs.getInt("CHANGED_TABLE_ID"));
			model.setChangedRecordPid(rs.getInt("CHANGED_RECORD_PID"));
			model.setChangedTimestamp(rs.getTimestamp("CHANGED_TIMESTAMP"));
			model.setUseridPid(rs.getInt("USERID_PID"));
			model.setColumnNameList(rs.getString("COLUMN_NAME_LIST"));
			model.setColumnDataList(rs.getString("COLUMN_DATA_LIST"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			modelList.add(model);
		}
		conn.close();
		return modelList;
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

	/**
	 * Get the UseridPid field.
	 *
	 * @return Contents of the USERID_PID column
	 */
	public int getUseridPid() {
		return UseridPid;
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
		ps.setInt(2, getChangedTableId());
		ps.setInt(3, getChangedRecordPid());
		ps.setTimestamp(4, getChangedTimestamp());
		ps.setInt(5, getUseridPid());
		ps.setString(6, getColumnNameList());
		ps.setString(7, getColumnDataList());
		ps.setTimestamp(8, getInsertTstmp());
		ps.setTimestamp(9, getUpdateTstmp());
		ps.setInt(10, getTableId());
		ps.executeUpdate();
		conn.close();
		return maxPid;
	}

	/**
	 * Set the ChangedRecordPid field
	 *
	 * @param ChangedRecordPid Contents of the CHANGED_RECORD_PID column
	 */
	public void setChangedRecordPid(int ChangedRecordPid) {
		this.ChangedRecordPid = ChangedRecordPid;
	}

	/**
	 * Set the ChangedTableId field
	 *
	 * @param ChangedTableId Contents of the CHANGED_TABLE_ID column
	 */
	public void setChangedTableId(int ChangedTableId) {
		this.ChangedTableId = ChangedTableId;
	}

	/**
	 * Set the ChangedTimestamp field
	 *
	 * @param ChangedTimestamp Contents of the CHANGED_TIMESTAMP column
	 */
	public void setChangedTimestamp(Timestamp ChangedTimestamp) {
		this.ChangedTimestamp = ChangedTimestamp;
	}

	/**
	 * Set the ColumnDataList field
	 *
	 * @param ColumnDataList Contents of the COLUMN_DATA_LIST column
	 */
	public void setColumnDataList(String ColumnDataList) {
		this.ColumnDataList = ColumnDataList;
	}

	/**
	 * Set the ColumnNameList field
	 *
	 * @param ColumnNameList Contents of the COLUMN_NAME_LIST column
	 */
	public void setColumnNameList(String ColumnNameList) {
		this.ColumnNameList = ColumnNameList;
	}

	/**
	 * Set the CommitLogPid field
	 *
	 * @param CommitLogPid Contents of the COMMIT_LOG_PID column
	 */
	public void setCommitLogPid(int CommitLogPid) {
		this.CommitLogPid = CommitLogPid;
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

	/**
	 * Set the UseridPid field
	 *
	 * @param UseridPid Contents of the USERID_PID column
	 */
	public void setUseridPid(int UseridPid) {
		this.UseridPid = UseridPid;
	}

	public void update() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(UPDATE);
		ps.setInt(1, getChangedTableId());
		ps.setInt(2, getChangedRecordPid());
		ps.setTimestamp(3, getChangedTimestamp());
		ps.setInt(4, getUseridPid());
		ps.setString(5, getColumnNameList());
		ps.setString(6, getColumnDataList());
		ps.setTimestamp(7, getInsertTstmp());
		ps.setTimestamp(8, getUpdateTstmp());
		ps.setInt(9, getTableId());
		ps.setInt(10, getCommitLogPid());
		ps.executeUpdate();
		conn.close();
	}

}
