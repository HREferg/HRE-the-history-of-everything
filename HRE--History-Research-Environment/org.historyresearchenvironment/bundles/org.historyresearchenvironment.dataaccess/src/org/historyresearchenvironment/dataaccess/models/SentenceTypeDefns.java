package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SENTENCE_TYPE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SentenceTypeDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SENTENCE_TYPE_DEFN_PID, " + "IS_SYSTEM, " + "REQUESTER_TYPE_KEY, " + "REQUESTER_SUB_TYPE_KEY, "
			+ "REQUESTER_TYPE_PID, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.SENTENCE_TYPE_DEFNS WHERE SENTENCE_TYPE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SENTENCE_TYPE_DEFN_PID, " + "IS_SYSTEM, " + "REQUESTER_TYPE_KEY, " + "REQUESTER_SUB_TYPE_KEY, "
			+ "REQUESTER_TYPE_PID, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.SENTENCE_TYPE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.SENTENCE_TYPE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SENTENCE_TYPE_DEFN_PID, " + "IS_SYSTEM, " + "REQUESTER_TYPE_KEY, "
			+ "REQUESTER_SUB_TYPE_KEY, " + "REQUESTER_TYPE_PID, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SENTENCE_TYPE_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "REQUESTER_TYPE_KEY = ?, " + "REQUESTER_SUB_TYPE_KEY = ?, "
			+ "REQUESTER_TYPE_PID = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE SENTENCE_TYPE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SENTENCE_TYPE_DEFNS WHERE SENTENCE_TYPE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SENTENCE_TYPE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SentenceTypeDefnPid;
	private boolean IsSystem;
	private short RequesterTypeKey;
	private short RequesterSubTypeKey;
	private short RequesterTypePid;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private SentenceTypeDefns model;

	public SentenceTypeDefns() throws SQLException {
	}

	public SentenceTypeDefns(int SentenceTypeDefnPid) throws SQLException {
		super();
		this.SentenceTypeDefnPid = SentenceTypeDefnPid;
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
			model = new SentenceTypeDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSentenceTypeDefnPid(rs.getInt("SENTENCE_TYPE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
			model.setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
			model.setRequesterTypePid(rs.getShort("REQUESTER_TYPE_PID"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
			model.setShow(rs.getBoolean("SHOW"));
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
			model.setSentenceTypeDefnPid(rs.getInt("SENTENCE_TYPE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
			model.setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
			model.setRequesterTypePid(rs.getShort("REQUESTER_TYPE_PID"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
			model.setShow(rs.getBoolean("SHOW"));
		}
		return this;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public short getDisplayOrder() {
		return this.DisplayOrder;
	}

	public boolean getIsDefault() {
		return this.IsDefault;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getReminderKey() {
		return this.ReminderKey;
	}

	public short getRequesterSubTypeKey() {
		return this.RequesterSubTypeKey;
	}

	public short getRequesterTypeKey() {
		return this.RequesterTypeKey;
	}

	public short getRequesterTypePid() {
		return this.RequesterTypePid;
	}

	public int getSentenceTypeDefnPid() {
		return this.SentenceTypeDefnPid;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public boolean getShow() {
		return this.Show;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((SentenceTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SentenceTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SentenceTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SentenceTypeDefns) model).setSentenceTypeDefnPid(rs.getInt("SENTENCE_TYPE_DEFN_PID"));
		((SentenceTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SentenceTypeDefns) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
		((SentenceTypeDefns) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
		((SentenceTypeDefns) model).setRequesterTypePid(rs.getShort("REQUESTER_TYPE_PID"));
		((SentenceTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SentenceTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SentenceTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((SentenceTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SentenceTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SentenceTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SentenceTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SentenceTypeDefns) model).setSentenceTypeDefnPid(rs.getInt("SENTENCE_TYPE_DEFN_PID"));
		((SentenceTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SentenceTypeDefns) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
		((SentenceTypeDefns) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
		((SentenceTypeDefns) model).setRequesterTypePid(rs.getShort("REQUESTER_TYPE_PID"));
		((SentenceTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SentenceTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SentenceTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((SentenceTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setReminderKey(short ReminderKey) {
		this.ReminderKey = ReminderKey;
	}

	public void setRequesterSubTypeKey(short RequesterSubTypeKey) {
		this.RequesterSubTypeKey = RequesterSubTypeKey;
	}

	public void setRequesterTypeKey(short RequesterTypeKey) {
		this.RequesterTypeKey = RequesterTypeKey;
	}

	public void setRequesterTypePid(short RequesterTypePid) {
		this.RequesterTypePid = RequesterTypePid;
	}

	public void setSentenceTypeDefnPid(int SentenceTypeDefnPid) {
		this.SentenceTypeDefnPid = SentenceTypeDefnPid;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setShow(boolean Show) {
		this.Show = Show;
	}

}
