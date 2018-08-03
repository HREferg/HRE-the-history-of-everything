package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the COMMIT_LOGS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class CommitLogs extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "COMMIT_LOG_PID, "
			+ "COMMENCED, " + "COMPLETED, " + "USER_PID, " + "CLIENT_PID, "
			+ "NUM_TABLES FROM PUBLIC.COMMIT_LOGS WHERE COMMIT_LOG_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "COMMIT_LOG_PID, " + "COMMENCED, " + "COMPLETED, " + "USER_PID, " + "CLIENT_PID, "
			+ "NUM_TABLES FROM PUBLIC.COMMIT_LOGS";

	private static final String INSERT = "INSERT INTO PUBLIC.COMMIT_LOGS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "COMMIT_LOG_PID, " + "COMMENCED, " + "COMPLETED, " + "USER_PID, " + "CLIENT_PID, "
			+ "NUM_TABLES) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.COMMIT_LOGSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "COMMENCED = ?, " + "COMPLETED = ?, " + "USER_PID = ?, " + "CLIENT_PID = ?, "
			+ "NUM_TABLES = ? WHERE COMMIT_LOG_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.COMMIT_LOGS WHERE COMMIT_LOG_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.COMMIT_LOGS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int CommitLogPid;
	private Timestamp Commenced;
	private Timestamp Completed;
	private int UserPid;
	private int ClientPid;
	private short NumTables;
	private CommitLogs model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public CommitLogs() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param CommitLogPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public CommitLogs(int CommitLogPid) throws SQLException {
		super();
		this.CommitLogPid = CommitLogPid;
	}

	@Override
	public void delete() throws SQLException {
		ps = conn.prepareStatement(DELETEALL);
		ps.executeUpdate();
	}

	@Override
	public void delete(int key) throws SQLException {
		ps = conn.prepareStatement(DELETE);
		ps.setInt(1, key);
		ps.executeUpdate();
	}

	@Override
	public List<AbstractHreDataModel> get() throws SQLException {
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<AbstractHreDataModel>();
		while (rs.next()) {
			model = new CommitLogs();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setCommitLogPid(rs.getInt("COMMIT_LOG_PID"));
			model.setCommenced(rs.getTimestamp("COMMENCED"));
			model.setCompleted(rs.getTimestamp("COMPLETED"));
			model.setUserPid(rs.getInt("USER_PID"));
			model.setClientPid(rs.getInt("CLIENT_PID"));
			model.setNumTables(rs.getShort("NUM_TABLES"));
			modelList.add(model);
		}
		return modelList;
	}

	@Override
	public AbstractHreDataModel get(int key) throws SQLException {
		ps = conn.prepareStatement(SELECT);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		if (rs.next()) {
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setCommitLogPid(rs.getInt("COMMIT_LOG_PID"));
			model.setCommenced(rs.getTimestamp("COMMENCED"));
			model.setCompleted(rs.getTimestamp("COMPLETED"));
			model.setUserPid(rs.getInt("USER_PID"));
			model.setClientPid(rs.getInt("CLIENT_PID"));
			model.setNumTables(rs.getShort("NUM_TABLES"));
		}
		return this;
	}

	/**
	 * Get the ClientPid field.
	 *
	 * @return Contents of the CLIENT_PID column
	 */
	public int getClientPid() {
		return this.ClientPid;
	}

	/**
	 * Get the Commenced field.
	 *
	 * @return Contents of the COMMENCED column
	 */
	public Timestamp getCommenced() {
		return this.Commenced;
	}

	/**
	 * Get the CommitLogPid field.
	 *
	 * @return Contents of the COMMIT_LOG_PID column
	 */
	public int getCommitLogPid() {
		return this.CommitLogPid;
	}

	/**
	 * Get the CommitPid field.
	 *
	 * @return Contents of the COMMIT_PID column
	 */
	public int getCommitPid() {
		return this.CommitPid;
	}

	/**
	 * Get the Completed field.
	 *
	 * @return Contents of the COMPLETED column
	 */
	public Timestamp getCompleted() {
		return this.Completed;
	}

	/**
	 * Get the NumTables field.
	 *
	 * @return Contents of the NUM_TABLES column
	 */
	public short getNumTables() {
		return this.NumTables;
	}

	/**
	 * Get the RecordNum field.
	 *
	 * @return Contents of the RECORD_NUM column
	 */
	public int getRecordNum() {
		return this.RecordNum;
	}

	/**
	 * Get the SetKey field.
	 *
	 * @return Contents of the SET_KEY column
	 */
	public short getSetKey() {
		return this.SetKey;
	}

	/**
	 * Get the UserPid field.
	 *
	 * @return Contents of the USER_PID column
	 */
	public int getUserPid() {
		return this.UserPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((CommitLogs) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((CommitLogs) model).setSetKey(rs.getShort("SET_KEY"));
		((CommitLogs) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((CommitLogs) model).setCommitLogPid(rs.getInt("COMMIT_LOG_PID"));
		((CommitLogs) model).setCommenced(rs.getTimestamp("COMMENCED"));
		((CommitLogs) model).setCompleted(rs.getTimestamp("COMPLETED"));
		((CommitLogs) model).setUserPid(rs.getInt("USER_PID"));
		((CommitLogs) model).setClientPid(rs.getInt("CLIENT_PID"));
		((CommitLogs) model).setNumTables(rs.getShort("NUM_TABLES"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((CommitLogs) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((CommitLogs) model).setSetKey(rs.getShort("SET_KEY"));
		((CommitLogs) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((CommitLogs) model).setCommitLogPid(rs.getInt("COMMIT_LOG_PID"));
		((CommitLogs) model).setCommenced(rs.getTimestamp("COMMENCED"));
		((CommitLogs) model).setCompleted(rs.getTimestamp("COMPLETED"));
		((CommitLogs) model).setUserPid(rs.getInt("USER_PID"));
		((CommitLogs) model).setClientPid(rs.getInt("CLIENT_PID"));
		((CommitLogs) model).setNumTables(rs.getShort("NUM_TABLES"));
		ps.executeUpdate();
	}

	/**
	 * Set the ClientPid field
	 *
	 * @param ClientPid
	 *            Contents of the CLIENT_PID column
	 */
	public void setClientPid(int ClientPid) {
		this.ClientPid = ClientPid;
	}

	/**
	 * Set the Commenced field
	 *
	 * @param Commenced
	 *            Contents of the COMMENCED column
	 */
	public void setCommenced(Timestamp Commenced) {
		this.Commenced = Commenced;
	}

	/**
	 * Set the CommitLogPid field
	 *
	 * @param CommitLogPid
	 *            Contents of the COMMIT_LOG_PID column
	 */
	public void setCommitLogPid(int CommitLogPid) {
		this.CommitLogPid = CommitLogPid;
	}

	/**
	 * Set the CommitPid field
	 *
	 * @param CommitPid
	 *            Contents of the COMMIT_PID column
	 */
	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	/**
	 * Set the Completed field
	 *
	 * @param Completed
	 *            Contents of the COMPLETED column
	 */
	public void setCompleted(Timestamp Completed) {
		this.Completed = Completed;
	}

	/**
	 * Set the NumTables field
	 *
	 * @param NumTables
	 *            Contents of the NUM_TABLES column
	 */
	public void setNumTables(short NumTables) {
		this.NumTables = NumTables;
	}

	/**
	 * Set the RecordNum field
	 *
	 * @param RecordNum
	 *            Contents of the RECORD_NUM column
	 */
	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	/**
	 * Set the SetKey field
	 *
	 * @param SetKey
	 *            Contents of the SET_KEY column
	 */
	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	/**
	 * Set the UserPid field
	 *
	 * @param UserPid
	 *            Contents of the USER_PID column
	 */
	public void setUserPid(int UserPid) {
		this.UserPid = UserPid;
	}

}
