package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SESSIONS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class Sessions extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "SESSION_PID, "
			+ "PROJECT_PID, " + "USER_PID, " + "TIME_OPENED, " + "TIME_CLOSED, "
			+ "COMMIT_NUM FROM PUBLIC.SESSIONS WHERE SESSION_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "SESSION_PID, "
			+ "PROJECT_PID, " + "USER_PID, " + "TIME_OPENED, " + "TIME_CLOSED, " + "COMMIT_NUM FROM PUBLIC.SESSIONS";

	private static final String INSERT = "INSERT INTO PUBLIC.SESSIONS( " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SESSION_PID, " + "PROJECT_PID, " + "USER_PID, " + "TIME_OPENED, " + "TIME_CLOSED, "
			+ "COMMIT_NUM) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SESSIONSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "PROJECT_PID = ?, " + "USER_PID = ?, " + "TIME_OPENED = ?, " + "TIME_CLOSED = ?, "
			+ "COMMIT_NUM = ? WHERE SESSION_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SESSIONS WHERE SESSION_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SESSIONS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SessionPid;
	private int ProjectPid;
	private int UserPid;
	private Timestamp TimeOpened;
	private Timestamp TimeClosed;
	private int CommitNum;
	private Sessions model;

	public Sessions() throws SQLException {
	}

	public Sessions(int SessionPid) throws SQLException {
		super();
		this.SessionPid = SessionPid;
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
			model = new Sessions();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSessionPid(rs.getInt("SESSION_PID"));
			model.setProjectPid(rs.getInt("PROJECT_PID"));
			model.setUserPid(rs.getInt("USER_PID"));
			model.setTimeOpened(rs.getTimestamp("TIME_OPENED"));
			model.setTimeClosed(rs.getTimestamp("TIME_CLOSED"));
			model.setCommitNum(rs.getInt("COMMIT_NUM"));
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
			model.setSessionPid(rs.getInt("SESSION_PID"));
			model.setProjectPid(rs.getInt("PROJECT_PID"));
			model.setUserPid(rs.getInt("USER_PID"));
			model.setTimeOpened(rs.getTimestamp("TIME_OPENED"));
			model.setTimeClosed(rs.getTimestamp("TIME_CLOSED"));
			model.setCommitNum(rs.getInt("COMMIT_NUM"));
		}
		return this;
	}

	public int getCommitNum() {
		return this.CommitNum;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public int getProjectPid() {
		return this.ProjectPid;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public int getSessionPid() {
		return this.SessionPid;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public Timestamp getTimeClosed() {
		return this.TimeClosed;
	}

	public Timestamp getTimeOpened() {
		return this.TimeOpened;
	}

	public int getUserPid() {
		return this.UserPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((Sessions) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Sessions) model).setSetKey(rs.getShort("SET_KEY"));
		((Sessions) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Sessions) model).setSessionPid(rs.getInt("SESSION_PID"));
		((Sessions) model).setProjectPid(rs.getInt("PROJECT_PID"));
		((Sessions) model).setUserPid(rs.getInt("USER_PID"));
		((Sessions) model).setTimeOpened(rs.getTimestamp("TIME_OPENED"));
		((Sessions) model).setTimeClosed(rs.getTimestamp("TIME_CLOSED"));
		((Sessions) model).setCommitNum(rs.getInt("COMMIT_NUM"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((Sessions) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Sessions) model).setSetKey(rs.getShort("SET_KEY"));
		((Sessions) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Sessions) model).setSessionPid(rs.getInt("SESSION_PID"));
		((Sessions) model).setProjectPid(rs.getInt("PROJECT_PID"));
		((Sessions) model).setUserPid(rs.getInt("USER_PID"));
		((Sessions) model).setTimeOpened(rs.getTimestamp("TIME_OPENED"));
		((Sessions) model).setTimeClosed(rs.getTimestamp("TIME_CLOSED"));
		((Sessions) model).setCommitNum(rs.getInt("COMMIT_NUM"));
		ps.executeUpdate();
	}

	public void setCommitNum(int CommitNum) {
		this.CommitNum = CommitNum;
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setProjectPid(int ProjectPid) {
		this.ProjectPid = ProjectPid;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setSessionPid(int SessionPid) {
		this.SessionPid = SessionPid;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setTimeClosed(Timestamp TimeClosed) {
		this.TimeClosed = TimeClosed;
	}

	public void setTimeOpened(Timestamp TimeOpened) {
		this.TimeOpened = TimeOpened;
	}

	public void setUserPid(int UserPid) {
		this.UserPid = UserPid;
	}

}
