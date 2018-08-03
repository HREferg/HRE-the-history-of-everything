package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the OCCASN_TIMELINE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class OccasnTimelineDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_TIMELINE_DEFN_PID, " + "IS_SYSTEM, " + "OCCASN_SUB_TYPE_KEY, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.OCCASN_TIMELINE_DEFNS WHERE OCCASN_TIMELINE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_TIMELINE_DEFN_PID, " + "IS_SYSTEM, " + "OCCASN_SUB_TYPE_KEY, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.OCCASN_TIMELINE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.OCCASN_TIMELINE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "OCCASN_TIMELINE_DEFN_PID, " + "IS_SYSTEM, " + "OCCASN_SUB_TYPE_KEY, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.OCCASN_TIMELINE_DEFNSSET " + "RECORD_NUM = ?, "
			+ "SET_KEY = ?, " + "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "OCCASN_SUB_TYPE_KEY = ?, "
			+ "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE OCCASN_TIMELINE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.OCCASN_TIMELINE_DEFNS WHERE OCCASN_TIMELINE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASN_TIMELINE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int OccasnTimelineDefnPid;
	private boolean IsSystem;
	private short OccasnSubTypeKey;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private OccasnTimelineDefns model;

	public OccasnTimelineDefns() throws SQLException {
	}

	public OccasnTimelineDefns(int OccasnTimelineDefnPid) throws SQLException {
		super();
		this.OccasnTimelineDefnPid = OccasnTimelineDefnPid;
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
			model = new OccasnTimelineDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setOccasnTimelineDefnPid(rs.getInt("OCCASN_TIMELINE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
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
			model.setOccasnTimelineDefnPid(rs.getInt("OCCASN_TIMELINE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
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

	public short getOccasnSubTypeKey() {
		return this.OccasnSubTypeKey;
	}

	public int getOccasnTimelineDefnPid() {
		return this.OccasnTimelineDefnPid;
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
		((OccasnTimelineDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((OccasnTimelineDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((OccasnTimelineDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((OccasnTimelineDefns) model).setOccasnTimelineDefnPid(rs.getInt("OCCASN_TIMELINE_DEFN_PID"));
		((OccasnTimelineDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((OccasnTimelineDefns) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
		((OccasnTimelineDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((OccasnTimelineDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((OccasnTimelineDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((OccasnTimelineDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((OccasnTimelineDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((OccasnTimelineDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((OccasnTimelineDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((OccasnTimelineDefns) model).setOccasnTimelineDefnPid(rs.getInt("OCCASN_TIMELINE_DEFN_PID"));
		((OccasnTimelineDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((OccasnTimelineDefns) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
		((OccasnTimelineDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((OccasnTimelineDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((OccasnTimelineDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((OccasnTimelineDefns) model).setShow(rs.getBoolean("SHOW"));
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

	public void setOccasnSubTypeKey(short OccasnSubTypeKey) {
		this.OccasnSubTypeKey = OccasnSubTypeKey;
	}

	public void setOccasnTimelineDefnPid(int OccasnTimelineDefnPid) {
		this.OccasnTimelineDefnPid = OccasnTimelineDefnPid;
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
