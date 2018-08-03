package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the MEMO_SET_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class MemoSetDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "MEMO_SET_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_TAG_TYPE_KEY, " + "PARENT_TAG_PID, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.MEMO_SET_DEFNS WHERE MEMO_SET_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "MEMO_SET_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_TAG_TYPE_KEY, " + "PARENT_TAG_PID, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.MEMO_SET_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.MEMO_SET_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "MEMO_SET_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_TAG_TYPE_KEY, " + "PARENT_TAG_PID, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.MEMO_SET_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PARENT_TAG_TYPE_KEY = ?, " + "PARENT_TAG_PID = ?, "
			+ "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE MEMO_SET_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.MEMO_SET_DEFNS WHERE MEMO_SET_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.MEMO_SET_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int MemoSetDefnPid;
	private boolean IsSystem;
	private short ParentTagTypeKey;
	private short ParentTagPid;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private MemoSetDefns model;

	public MemoSetDefns() throws SQLException {
	}

	public MemoSetDefns(int MemoSetDefnPid) throws SQLException {
		super();
		this.MemoSetDefnPid = MemoSetDefnPid;
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
			model = new MemoSetDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setMemoSetDefnPid(rs.getInt("MEMO_SET_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentTagTypeKey(rs.getShort("PARENT_TAG_TYPE_KEY"));
			model.setParentTagPid(rs.getShort("PARENT_TAG_PID"));
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
			model.setMemoSetDefnPid(rs.getInt("MEMO_SET_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentTagTypeKey(rs.getShort("PARENT_TAG_TYPE_KEY"));
			model.setParentTagPid(rs.getShort("PARENT_TAG_PID"));
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

	public int getMemoSetDefnPid() {
		return this.MemoSetDefnPid;
	}

	public short getParentTagPid() {
		return this.ParentTagPid;
	}

	public short getParentTagTypeKey() {
		return this.ParentTagTypeKey;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getReminderKey() {
		return this.ReminderKey;
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
		((MemoSetDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((MemoSetDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((MemoSetDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((MemoSetDefns) model).setMemoSetDefnPid(rs.getInt("MEMO_SET_DEFN_PID"));
		((MemoSetDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((MemoSetDefns) model).setParentTagTypeKey(rs.getShort("PARENT_TAG_TYPE_KEY"));
		((MemoSetDefns) model).setParentTagPid(rs.getShort("PARENT_TAG_PID"));
		((MemoSetDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((MemoSetDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((MemoSetDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((MemoSetDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((MemoSetDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((MemoSetDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((MemoSetDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((MemoSetDefns) model).setMemoSetDefnPid(rs.getInt("MEMO_SET_DEFN_PID"));
		((MemoSetDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((MemoSetDefns) model).setParentTagTypeKey(rs.getShort("PARENT_TAG_TYPE_KEY"));
		((MemoSetDefns) model).setParentTagPid(rs.getShort("PARENT_TAG_PID"));
		((MemoSetDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((MemoSetDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((MemoSetDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((MemoSetDefns) model).setShow(rs.getBoolean("SHOW"));
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

	public void setMemoSetDefnPid(int MemoSetDefnPid) {
		this.MemoSetDefnPid = MemoSetDefnPid;
	}

	public void setParentTagPid(short ParentTagPid) {
		this.ParentTagPid = ParentTagPid;
	}

	public void setParentTagTypeKey(short ParentTagTypeKey) {
		this.ParentTagTypeKey = ParentTagTypeKey;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setReminderKey(short ReminderKey) {
		this.ReminderKey = ReminderKey;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setShow(boolean Show) {
		this.Show = Show;
	}

}
