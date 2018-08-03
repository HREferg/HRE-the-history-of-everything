package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SUBSET_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SubsetDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "SUBSET_DEFN_PID, "
			+ "IS_SYSTEM, " + "SUBSET_TYPE_KEY, " + "SIZE, " + "STACK_INDEX, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW FROM PUBLIC.SUBSET_DEFNS WHERE SUBSET_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSET_DEFN_PID, " + "IS_SYSTEM, " + "SUBSET_TYPE_KEY, " + "SIZE, " + "STACK_INDEX, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.SUBSET_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.SUBSET_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SUBSET_DEFN_PID, " + "IS_SYSTEM, " + "SUBSET_TYPE_KEY, " + "SIZE, " + "STACK_INDEX, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SUBSET_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "SUBSET_TYPE_KEY = ?, " + "SIZE = ?, " + "STACK_INDEX = ?, "
			+ "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, " + "SHOW = ? WHERE SUBSET_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SUBSET_DEFNS WHERE SUBSET_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSET_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SubsetDefnPid;
	private boolean IsSystem;
	private short SubsetTypeKey;
	private int Size;
	private int StackIndex;
	private short ReminderKey;
	private int DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private SubsetDefns model;

	public SubsetDefns() throws SQLException {
	}

	public SubsetDefns(int SubsetDefnPid) throws SQLException {
		super();
		this.SubsetDefnPid = SubsetDefnPid;
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
			model = new SubsetDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSubsetDefnPid(rs.getInt("SUBSET_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setSubsetTypeKey(rs.getShort("SUBSET_TYPE_KEY"));
			model.setSize(rs.getInt("SIZE"));
			model.setStackIndex(rs.getInt("STACK_INDEX"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getInt("DISPLAY_ORDER"));
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
			model.setSubsetDefnPid(rs.getInt("SUBSET_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setSubsetTypeKey(rs.getShort("SUBSET_TYPE_KEY"));
			model.setSize(rs.getInt("SIZE"));
			model.setStackIndex(rs.getInt("STACK_INDEX"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getInt("DISPLAY_ORDER"));
			model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
			model.setShow(rs.getBoolean("SHOW"));
		}
		return this;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public int getDisplayOrder() {
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

	public short getSetKey() {
		return this.SetKey;
	}

	public boolean getShow() {
		return this.Show;
	}

	public int getSize() {
		return this.Size;
	}

	public int getStackIndex() {
		return this.StackIndex;
	}

	public int getSubsetDefnPid() {
		return this.SubsetDefnPid;
	}

	public short getSubsetTypeKey() {
		return this.SubsetTypeKey;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((SubsetDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubsetDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubsetDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubsetDefns) model).setSubsetDefnPid(rs.getInt("SUBSET_DEFN_PID"));
		((SubsetDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubsetDefns) model).setSubsetTypeKey(rs.getShort("SUBSET_TYPE_KEY"));
		((SubsetDefns) model).setSize(rs.getInt("SIZE"));
		((SubsetDefns) model).setStackIndex(rs.getInt("STACK_INDEX"));
		((SubsetDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubsetDefns) model).setDisplayOrder(rs.getInt("DISPLAY_ORDER"));
		((SubsetDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((SubsetDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SubsetDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubsetDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubsetDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubsetDefns) model).setSubsetDefnPid(rs.getInt("SUBSET_DEFN_PID"));
		((SubsetDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubsetDefns) model).setSubsetTypeKey(rs.getShort("SUBSET_TYPE_KEY"));
		((SubsetDefns) model).setSize(rs.getInt("SIZE"));
		((SubsetDefns) model).setStackIndex(rs.getInt("STACK_INDEX"));
		((SubsetDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubsetDefns) model).setDisplayOrder(rs.getInt("DISPLAY_ORDER"));
		((SubsetDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((SubsetDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDisplayOrder(int DisplayOrder) {
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

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setShow(boolean Show) {
		this.Show = Show;
	}

	public void setSize(int Size) {
		this.Size = Size;
	}

	public void setStackIndex(int StackIndex) {
		this.StackIndex = StackIndex;
	}

	public void setSubsetDefnPid(int SubsetDefnPid) {
		this.SubsetDefnPid = SubsetDefnPid;
	}

	public void setSubsetTypeKey(short SubsetTypeKey) {
		this.SubsetTypeKey = SubsetTypeKey;
	}

}
