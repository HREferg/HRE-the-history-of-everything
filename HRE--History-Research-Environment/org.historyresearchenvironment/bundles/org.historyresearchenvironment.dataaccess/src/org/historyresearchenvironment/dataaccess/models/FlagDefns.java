package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the FLAG_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class FlagDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "FLAG_DEFN_PID, "
			+ "IS_SYSTEM, " + "PARENT_TYPE_KEY, " + "PARENT_SUB_TYPE_KEY, " + "FLAG_SLOT, " + "STATES, "
			+ "DFLT_STATE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.FLAG_DEFNS WHERE FLAG_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "FLAG_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_TYPE_KEY, " + "PARENT_SUB_TYPE_KEY, " + "FLAG_SLOT, "
			+ "STATES, " + "DFLT_STATE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.FLAG_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.FLAG_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "FLAG_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_TYPE_KEY, " + "PARENT_SUB_TYPE_KEY, "
			+ "FLAG_SLOT, " + "STATES, " + "DFLT_STATE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.FLAG_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PARENT_TYPE_KEY = ?, " + "PARENT_SUB_TYPE_KEY = ?, "
			+ "FLAG_SLOT = ?, " + "STATES = ?, " + "DFLT_STATE = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, "
			+ "IS_DEFAULT = ?, " + "SHOW = ? WHERE FLAG_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.FLAG_DEFNS WHERE FLAG_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.FLAG_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int FlagDefnPid;
	private boolean IsSystem;
	private short ParentTypeKey;
	private short ParentSubTypeKey;
	private short FlagSlot;
	private short States;
	private short DfltState;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private FlagDefns model;

	public FlagDefns() throws SQLException {
	}

	public FlagDefns(int FlagDefnPid) throws SQLException {
		super();
		this.FlagDefnPid = FlagDefnPid;
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
			model = new FlagDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setFlagDefnPid(rs.getInt("FLAG_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setFlagSlot(rs.getShort("FLAG_SLOT"));
			model.setStates(rs.getShort("STATES"));
			model.setDfltState(rs.getShort("DFLT_STATE"));
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
			model.setFlagDefnPid(rs.getInt("FLAG_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setFlagSlot(rs.getShort("FLAG_SLOT"));
			model.setStates(rs.getShort("STATES"));
			model.setDfltState(rs.getShort("DFLT_STATE"));
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

	public short getDfltState() {
		return this.DfltState;
	}

	public short getDisplayOrder() {
		return this.DisplayOrder;
	}

	public int getFlagDefnPid() {
		return this.FlagDefnPid;
	}

	public short getFlagSlot() {
		return this.FlagSlot;
	}

	public boolean getIsDefault() {
		return this.IsDefault;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public short getParentSubTypeKey() {
		return this.ParentSubTypeKey;
	}

	public short getParentTypeKey() {
		return this.ParentTypeKey;
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

	public short getStates() {
		return this.States;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((FlagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((FlagDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((FlagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((FlagDefns) model).setFlagDefnPid(rs.getInt("FLAG_DEFN_PID"));
		((FlagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((FlagDefns) model).setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
		((FlagDefns) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((FlagDefns) model).setFlagSlot(rs.getShort("FLAG_SLOT"));
		((FlagDefns) model).setStates(rs.getShort("STATES"));
		((FlagDefns) model).setDfltState(rs.getShort("DFLT_STATE"));
		((FlagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((FlagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((FlagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((FlagDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((FlagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((FlagDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((FlagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((FlagDefns) model).setFlagDefnPid(rs.getInt("FLAG_DEFN_PID"));
		((FlagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((FlagDefns) model).setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
		((FlagDefns) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((FlagDefns) model).setFlagSlot(rs.getShort("FLAG_SLOT"));
		((FlagDefns) model).setStates(rs.getShort("STATES"));
		((FlagDefns) model).setDfltState(rs.getShort("DFLT_STATE"));
		((FlagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((FlagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((FlagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((FlagDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDfltState(short DfltState) {
		this.DfltState = DfltState;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setFlagDefnPid(int FlagDefnPid) {
		this.FlagDefnPid = FlagDefnPid;
	}

	public void setFlagSlot(short FlagSlot) {
		this.FlagSlot = FlagSlot;
	}

	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setParentSubTypeKey(short ParentSubTypeKey) {
		this.ParentSubTypeKey = ParentSubTypeKey;
	}

	public void setParentTypeKey(short ParentTypeKey) {
		this.ParentTypeKey = ParentTypeKey;
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

	public void setStates(short States) {
		this.States = States;
	}

}
