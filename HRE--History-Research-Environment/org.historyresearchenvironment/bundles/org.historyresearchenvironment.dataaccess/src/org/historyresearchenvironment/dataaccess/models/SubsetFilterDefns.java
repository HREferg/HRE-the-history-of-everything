package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SUBSET_FILTER_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SubsetFilterDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSET_FILTER_DEFN_PID, " + "IS_SYSTEM, " + "INPUT_TYPE_KEY, " + "INPUT_SUB_TYPE_KEY, "
			+ "OUTPUT_TYPE_KEY, " + "OUTPUT_SUB_TYPE_KEY, " + "START_STEP_PID, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW FROM PUBLIC.SUBSET_FILTER_DEFNS WHERE SUBSET_FILTER_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSET_FILTER_DEFN_PID, " + "IS_SYSTEM, " + "INPUT_TYPE_KEY, " + "INPUT_SUB_TYPE_KEY, "
			+ "OUTPUT_TYPE_KEY, " + "OUTPUT_SUB_TYPE_KEY, " + "START_STEP_PID, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW FROM PUBLIC.SUBSET_FILTER_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.SUBSET_FILTER_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SUBSET_FILTER_DEFN_PID, " + "IS_SYSTEM, " + "INPUT_TYPE_KEY, " + "INPUT_SUB_TYPE_KEY, "
			+ "OUTPUT_TYPE_KEY, " + "OUTPUT_SUB_TYPE_KEY, " + "START_STEP_PID, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SUBSET_FILTER_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "INPUT_TYPE_KEY = ?, " + "INPUT_SUB_TYPE_KEY = ?, "
			+ "OUTPUT_TYPE_KEY = ?, " + "OUTPUT_SUB_TYPE_KEY = ?, " + "START_STEP_PID = ?, " + "REMINDER_KEY = ?, "
			+ "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, " + "SHOW = ? WHERE SUBSET_FILTER_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SUBSET_FILTER_DEFNS WHERE SUBSET_FILTER_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSET_FILTER_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SubsetFilterDefnPid;
	private boolean IsSystem;
	private short InputTypeKey;
	private short InputSubTypeKey;
	private short OutputTypeKey;
	private short OutputSubTypeKey;
	private short StartStepPid;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private SubsetFilterDefns model;

	public SubsetFilterDefns() throws SQLException {
	}

	public SubsetFilterDefns(int SubsetFilterDefnPid) throws SQLException {
		super();
		this.SubsetFilterDefnPid = SubsetFilterDefnPid;
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
			model = new SubsetFilterDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSubsetFilterDefnPid(rs.getInt("SUBSET_FILTER_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setInputTypeKey(rs.getShort("INPUT_TYPE_KEY"));
			model.setInputSubTypeKey(rs.getShort("INPUT_SUB_TYPE_KEY"));
			model.setOutputTypeKey(rs.getShort("OUTPUT_TYPE_KEY"));
			model.setOutputSubTypeKey(rs.getShort("OUTPUT_SUB_TYPE_KEY"));
			model.setStartStepPid(rs.getShort("START_STEP_PID"));
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
			model.setSubsetFilterDefnPid(rs.getInt("SUBSET_FILTER_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setInputTypeKey(rs.getShort("INPUT_TYPE_KEY"));
			model.setInputSubTypeKey(rs.getShort("INPUT_SUB_TYPE_KEY"));
			model.setOutputTypeKey(rs.getShort("OUTPUT_TYPE_KEY"));
			model.setOutputSubTypeKey(rs.getShort("OUTPUT_SUB_TYPE_KEY"));
			model.setStartStepPid(rs.getShort("START_STEP_PID"));
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

	public short getInputSubTypeKey() {
		return this.InputSubTypeKey;
	}

	public short getInputTypeKey() {
		return this.InputTypeKey;
	}

	public boolean getIsDefault() {
		return this.IsDefault;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public short getOutputSubTypeKey() {
		return this.OutputSubTypeKey;
	}

	public short getOutputTypeKey() {
		return this.OutputTypeKey;
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

	public short getStartStepPid() {
		return this.StartStepPid;
	}

	public int getSubsetFilterDefnPid() {
		return this.SubsetFilterDefnPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((SubsetFilterDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubsetFilterDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubsetFilterDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubsetFilterDefns) model).setSubsetFilterDefnPid(rs.getInt("SUBSET_FILTER_DEFN_PID"));
		((SubsetFilterDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubsetFilterDefns) model).setInputTypeKey(rs.getShort("INPUT_TYPE_KEY"));
		((SubsetFilterDefns) model).setInputSubTypeKey(rs.getShort("INPUT_SUB_TYPE_KEY"));
		((SubsetFilterDefns) model).setOutputTypeKey(rs.getShort("OUTPUT_TYPE_KEY"));
		((SubsetFilterDefns) model).setOutputSubTypeKey(rs.getShort("OUTPUT_SUB_TYPE_KEY"));
		((SubsetFilterDefns) model).setStartStepPid(rs.getShort("START_STEP_PID"));
		((SubsetFilterDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubsetFilterDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubsetFilterDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((SubsetFilterDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SubsetFilterDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubsetFilterDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubsetFilterDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubsetFilterDefns) model).setSubsetFilterDefnPid(rs.getInt("SUBSET_FILTER_DEFN_PID"));
		((SubsetFilterDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubsetFilterDefns) model).setInputTypeKey(rs.getShort("INPUT_TYPE_KEY"));
		((SubsetFilterDefns) model).setInputSubTypeKey(rs.getShort("INPUT_SUB_TYPE_KEY"));
		((SubsetFilterDefns) model).setOutputTypeKey(rs.getShort("OUTPUT_TYPE_KEY"));
		((SubsetFilterDefns) model).setOutputSubTypeKey(rs.getShort("OUTPUT_SUB_TYPE_KEY"));
		((SubsetFilterDefns) model).setStartStepPid(rs.getShort("START_STEP_PID"));
		((SubsetFilterDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubsetFilterDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubsetFilterDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((SubsetFilterDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setInputSubTypeKey(short InputSubTypeKey) {
		this.InputSubTypeKey = InputSubTypeKey;
	}

	public void setInputTypeKey(short InputTypeKey) {
		this.InputTypeKey = InputTypeKey;
	}

	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setOutputSubTypeKey(short OutputSubTypeKey) {
		this.OutputSubTypeKey = OutputSubTypeKey;
	}

	public void setOutputTypeKey(short OutputTypeKey) {
		this.OutputTypeKey = OutputTypeKey;
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

	public void setStartStepPid(short StartStepPid) {
		this.StartStepPid = StartStepPid;
	}

	public void setSubsetFilterDefnPid(int SubsetFilterDefnPid) {
		this.SubsetFilterDefnPid = SubsetFilterDefnPid;
	}

}
