package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SUBSTN_DATA_ALIASES database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SubstnDataAliases extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSTN_DATA_ALIAS_PID, " + "IS_SYSTEM, " + "IS_COMPLETE, " + "IS_HEAD_ONLY, " + "IS_HEAD_LINK_ONLY, "
			+ "IS_LINK_ONLY, " + "IS_LINK_OUTPUT_ONLY, " + "IS_OUTPUT_ONLY, " + "TOP_STEP_KEY, "
			+ "REQUESTER_TYPE_KEY, " + "REQUESTER_SUB_TYPE_KEY, " + "OUTPUT_TYPE_KEY, " + "OUTPUT_SUB_TYPE_KEY, "
			+ "PARAM_LIST_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "SHOW FROM PUBLIC.SUBSTN_DATA_ALIASES WHERE SUBSTN_DATA_ALIAS_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSTN_DATA_ALIAS_PID, " + "IS_SYSTEM, " + "IS_COMPLETE, " + "IS_HEAD_ONLY, " + "IS_HEAD_LINK_ONLY, "
			+ "IS_LINK_ONLY, " + "IS_LINK_OUTPUT_ONLY, " + "IS_OUTPUT_ONLY, " + "TOP_STEP_KEY, "
			+ "REQUESTER_TYPE_KEY, " + "REQUESTER_SUB_TYPE_KEY, " + "OUTPUT_TYPE_KEY, " + "OUTPUT_SUB_TYPE_KEY, "
			+ "PARAM_LIST_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "SHOW FROM PUBLIC.SUBSTN_DATA_ALIASES";

	private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_DATA_ALIASES( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SUBSTN_DATA_ALIAS_PID, " + "IS_SYSTEM, " + "IS_COMPLETE, " + "IS_HEAD_ONLY, "
			+ "IS_HEAD_LINK_ONLY, " + "IS_LINK_ONLY, " + "IS_LINK_OUTPUT_ONLY, " + "IS_OUTPUT_ONLY, " + "TOP_STEP_KEY, "
			+ "REQUESTER_TYPE_KEY, " + "REQUESTER_SUB_TYPE_KEY, " + "OUTPUT_TYPE_KEY, " + "OUTPUT_SUB_TYPE_KEY, "
			+ "PARAM_LIST_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_DATA_ALIASESSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "IS_COMPLETE = ?, " + "IS_HEAD_ONLY = ?, "
			+ "IS_HEAD_LINK_ONLY = ?, " + "IS_LINK_ONLY = ?, " + "IS_LINK_OUTPUT_ONLY = ?, " + "IS_OUTPUT_ONLY = ?, "
			+ "TOP_STEP_KEY = ?, " + "REQUESTER_TYPE_KEY = ?, " + "REQUESTER_SUB_TYPE_KEY = ?, "
			+ "OUTPUT_TYPE_KEY = ?, " + "OUTPUT_SUB_TYPE_KEY = ?, " + "PARAM_LIST_KEY = ?, " + "REMINDER_KEY = ?, "
			+ "DISPLAY_ORDER = ?, " + "SHOW = ? WHERE SUBSTN_DATA_ALIAS_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_DATA_ALIASES WHERE SUBSTN_DATA_ALIAS_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_DATA_ALIASES";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SubstnDataAliasPid;
	private boolean IsSystem;
	private boolean IsComplete;
	private boolean IsHeadOnly;
	private boolean IsHeadLinkOnly;
	private boolean IsLinkOnly;
	private boolean IsLinkOutputOnly;
	private boolean IsOutputOnly;
	private short TopStepKey;
	private short RequesterTypeKey;
	private short RequesterSubTypeKey;
	private short OutputTypeKey;
	private short OutputSubTypeKey;
	private short ParamListKey;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean Show;
	private SubstnDataAliases model;

	public SubstnDataAliases() throws SQLException {
	}

	public SubstnDataAliases(int SubstnDataAliasPid) throws SQLException {
		super();
		this.SubstnDataAliasPid = SubstnDataAliasPid;
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
			model = new SubstnDataAliases();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSubstnDataAliasPid(rs.getInt("SUBSTN_DATA_ALIAS_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setIsComplete(rs.getBoolean("IS_COMPLETE"));
			model.setIsHeadOnly(rs.getBoolean("IS_HEAD_ONLY"));
			model.setIsHeadLinkOnly(rs.getBoolean("IS_HEAD_LINK_ONLY"));
			model.setIsLinkOnly(rs.getBoolean("IS_LINK_ONLY"));
			model.setIsLinkOutputOnly(rs.getBoolean("IS_LINK_OUTPUT_ONLY"));
			model.setIsOutputOnly(rs.getBoolean("IS_OUTPUT_ONLY"));
			model.setTopStepKey(rs.getShort("TOP_STEP_KEY"));
			model.setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
			model.setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
			model.setOutputTypeKey(rs.getShort("OUTPUT_TYPE_KEY"));
			model.setOutputSubTypeKey(rs.getShort("OUTPUT_SUB_TYPE_KEY"));
			model.setParamListKey(rs.getShort("PARAM_LIST_KEY"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
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
			model.setSubstnDataAliasPid(rs.getInt("SUBSTN_DATA_ALIAS_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setIsComplete(rs.getBoolean("IS_COMPLETE"));
			model.setIsHeadOnly(rs.getBoolean("IS_HEAD_ONLY"));
			model.setIsHeadLinkOnly(rs.getBoolean("IS_HEAD_LINK_ONLY"));
			model.setIsLinkOnly(rs.getBoolean("IS_LINK_ONLY"));
			model.setIsLinkOutputOnly(rs.getBoolean("IS_LINK_OUTPUT_ONLY"));
			model.setIsOutputOnly(rs.getBoolean("IS_OUTPUT_ONLY"));
			model.setTopStepKey(rs.getShort("TOP_STEP_KEY"));
			model.setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
			model.setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
			model.setOutputTypeKey(rs.getShort("OUTPUT_TYPE_KEY"));
			model.setOutputSubTypeKey(rs.getShort("OUTPUT_SUB_TYPE_KEY"));
			model.setParamListKey(rs.getShort("PARAM_LIST_KEY"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
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

	public boolean getIsComplete() {
		return this.IsComplete;
	}

	public boolean getIsHeadLinkOnly() {
		return this.IsHeadLinkOnly;
	}

	public boolean getIsHeadOnly() {
		return this.IsHeadOnly;
	}

	public boolean getIsLinkOnly() {
		return this.IsLinkOnly;
	}

	public boolean getIsLinkOutputOnly() {
		return this.IsLinkOutputOnly;
	}

	public boolean getIsOutputOnly() {
		return this.IsOutputOnly;
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

	public short getParamListKey() {
		return this.ParamListKey;
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

	public short getSetKey() {
		return this.SetKey;
	}

	public boolean getShow() {
		return this.Show;
	}

	public int getSubstnDataAliasPid() {
		return this.SubstnDataAliasPid;
	}

	public short getTopStepKey() {
		return this.TopStepKey;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((SubstnDataAliases) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubstnDataAliases) model).setSetKey(rs.getShort("SET_KEY"));
		((SubstnDataAliases) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubstnDataAliases) model).setSubstnDataAliasPid(rs.getInt("SUBSTN_DATA_ALIAS_PID"));
		((SubstnDataAliases) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubstnDataAliases) model).setIsComplete(rs.getBoolean("IS_COMPLETE"));
		((SubstnDataAliases) model).setIsHeadOnly(rs.getBoolean("IS_HEAD_ONLY"));
		((SubstnDataAliases) model).setIsHeadLinkOnly(rs.getBoolean("IS_HEAD_LINK_ONLY"));
		((SubstnDataAliases) model).setIsLinkOnly(rs.getBoolean("IS_LINK_ONLY"));
		((SubstnDataAliases) model).setIsLinkOutputOnly(rs.getBoolean("IS_LINK_OUTPUT_ONLY"));
		((SubstnDataAliases) model).setIsOutputOnly(rs.getBoolean("IS_OUTPUT_ONLY"));
		((SubstnDataAliases) model).setTopStepKey(rs.getShort("TOP_STEP_KEY"));
		((SubstnDataAliases) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
		((SubstnDataAliases) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
		((SubstnDataAliases) model).setOutputTypeKey(rs.getShort("OUTPUT_TYPE_KEY"));
		((SubstnDataAliases) model).setOutputSubTypeKey(rs.getShort("OUTPUT_SUB_TYPE_KEY"));
		((SubstnDataAliases) model).setParamListKey(rs.getShort("PARAM_LIST_KEY"));
		((SubstnDataAliases) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubstnDataAliases) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubstnDataAliases) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SubstnDataAliases) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubstnDataAliases) model).setSetKey(rs.getShort("SET_KEY"));
		((SubstnDataAliases) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubstnDataAliases) model).setSubstnDataAliasPid(rs.getInt("SUBSTN_DATA_ALIAS_PID"));
		((SubstnDataAliases) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubstnDataAliases) model).setIsComplete(rs.getBoolean("IS_COMPLETE"));
		((SubstnDataAliases) model).setIsHeadOnly(rs.getBoolean("IS_HEAD_ONLY"));
		((SubstnDataAliases) model).setIsHeadLinkOnly(rs.getBoolean("IS_HEAD_LINK_ONLY"));
		((SubstnDataAliases) model).setIsLinkOnly(rs.getBoolean("IS_LINK_ONLY"));
		((SubstnDataAliases) model).setIsLinkOutputOnly(rs.getBoolean("IS_LINK_OUTPUT_ONLY"));
		((SubstnDataAliases) model).setIsOutputOnly(rs.getBoolean("IS_OUTPUT_ONLY"));
		((SubstnDataAliases) model).setTopStepKey(rs.getShort("TOP_STEP_KEY"));
		((SubstnDataAliases) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
		((SubstnDataAliases) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
		((SubstnDataAliases) model).setOutputTypeKey(rs.getShort("OUTPUT_TYPE_KEY"));
		((SubstnDataAliases) model).setOutputSubTypeKey(rs.getShort("OUTPUT_SUB_TYPE_KEY"));
		((SubstnDataAliases) model).setParamListKey(rs.getShort("PARAM_LIST_KEY"));
		((SubstnDataAliases) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubstnDataAliases) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubstnDataAliases) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setIsComplete(boolean IsComplete) {
		this.IsComplete = IsComplete;
	}

	public void setIsHeadLinkOnly(boolean IsHeadLinkOnly) {
		this.IsHeadLinkOnly = IsHeadLinkOnly;
	}

	public void setIsHeadOnly(boolean IsHeadOnly) {
		this.IsHeadOnly = IsHeadOnly;
	}

	public void setIsLinkOnly(boolean IsLinkOnly) {
		this.IsLinkOnly = IsLinkOnly;
	}

	public void setIsLinkOutputOnly(boolean IsLinkOutputOnly) {
		this.IsLinkOutputOnly = IsLinkOutputOnly;
	}

	public void setIsOutputOnly(boolean IsOutputOnly) {
		this.IsOutputOnly = IsOutputOnly;
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

	public void setParamListKey(short ParamListKey) {
		this.ParamListKey = ParamListKey;
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

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setShow(boolean Show) {
		this.Show = Show;
	}

	public void setSubstnDataAliasPid(int SubstnDataAliasPid) {
		this.SubstnDataAliasPid = SubstnDataAliasPid;
	}

	public void setTopStepKey(short TopStepKey) {
		this.TopStepKey = TopStepKey;
	}

}
