package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SUBSTN_PARAM_SET_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SubstnParamSetDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSTN_PARAM_SET_DEFN_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, " + "VIEW_DATA_SCRIPT_PID, "
			+ "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, " + "DELETE_DATA_SCRIPT_GROUP_KEY, "
			+ "DELETE_DATA_SCRIPT_PID, " + "EVAL_DATA_SCRIPT_GROUP_KEY, " + "EVAL_DATA_SCRIPT_PID, " + "PARAM_SET_KEY, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "SHOW FROM PUBLIC.SUBSTN_PARAM_SET_DEFNS WHERE SUBSTN_PARAM_SET_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSTN_PARAM_SET_DEFN_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, " + "VIEW_DATA_SCRIPT_PID, "
			+ "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, " + "DELETE_DATA_SCRIPT_GROUP_KEY, "
			+ "DELETE_DATA_SCRIPT_PID, " + "EVAL_DATA_SCRIPT_GROUP_KEY, " + "EVAL_DATA_SCRIPT_PID, " + "PARAM_SET_KEY, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "SHOW FROM PUBLIC.SUBSTN_PARAM_SET_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_PARAM_SET_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SUBSTN_PARAM_SET_DEFN_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, "
			+ "VIEW_DATA_SCRIPT_PID, " + "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, "
			+ "DELETE_DATA_SCRIPT_GROUP_KEY, " + "DELETE_DATA_SCRIPT_PID, " + "EVAL_DATA_SCRIPT_GROUP_KEY, "
			+ "EVAL_DATA_SCRIPT_PID, " + "PARAM_SET_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "SHOW) VALUES (?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_PARAM_SET_DEFNSSET " + "RECORD_NUM = ?, "
			+ "SET_KEY = ?, " + "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "VIEW_DATA_SCRIPT_GROUP_KEY = ?, "
			+ "VIEW_DATA_SCRIPT_PID = ?, " + "MODIFY_DATA_SCRIPT_GROUP_KEY = ?, " + "MODIFY_DATA_SCRIPT_PID = ?, "
			+ "DELETE_DATA_SCRIPT_GROUP_KEY = ?, " + "DELETE_DATA_SCRIPT_PID = ?, " + "EVAL_DATA_SCRIPT_GROUP_KEY = ?, "
			+ "EVAL_DATA_SCRIPT_PID = ?, " + "PARAM_SET_KEY = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, "
			+ "SHOW = ? WHERE SUBSTN_PARAM_SET_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_PARAM_SET_DEFNS WHERE SUBSTN_PARAM_SET_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_PARAM_SET_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SubstnParamSetDefnPid;
	private boolean IsSystem;
	private short ViewDataScriptGroupKey;
	private int ViewDataScriptPid;
	private short ModifyDataScriptGroupKey;
	private int ModifyDataScriptPid;
	private short DeleteDataScriptGroupKey;
	private int DeleteDataScriptPid;
	private short EvalDataScriptGroupKey;
	private int EvalDataScriptPid;
	private short ParamSetKey;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean Show;
	private SubstnParamSetDefns model;

	public SubstnParamSetDefns() throws SQLException {
	}

	public SubstnParamSetDefns(int SubstnParamSetDefnPid) throws SQLException {
		super();
		this.SubstnParamSetDefnPid = SubstnParamSetDefnPid;
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
			model = new SubstnParamSetDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSubstnParamSetDefnPid(rs.getInt("SUBSTN_PARAM_SET_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
			model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
			model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
			model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
			model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
			model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
			model.setEvalDataScriptGroupKey(rs.getShort("EVAL_DATA_SCRIPT_GROUP_KEY"));
			model.setEvalDataScriptPid(rs.getInt("EVAL_DATA_SCRIPT_PID"));
			model.setParamSetKey(rs.getShort("PARAM_SET_KEY"));
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
			model.setSubstnParamSetDefnPid(rs.getInt("SUBSTN_PARAM_SET_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
			model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
			model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
			model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
			model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
			model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
			model.setEvalDataScriptGroupKey(rs.getShort("EVAL_DATA_SCRIPT_GROUP_KEY"));
			model.setEvalDataScriptPid(rs.getInt("EVAL_DATA_SCRIPT_PID"));
			model.setParamSetKey(rs.getShort("PARAM_SET_KEY"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setShow(rs.getBoolean("SHOW"));
		}
		return this;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public short getDeleteDataScriptGroupKey() {
		return this.DeleteDataScriptGroupKey;
	}

	public int getDeleteDataScriptPid() {
		return this.DeleteDataScriptPid;
	}

	public short getDisplayOrder() {
		return this.DisplayOrder;
	}

	public short getEvalDataScriptGroupKey() {
		return this.EvalDataScriptGroupKey;
	}

	public int getEvalDataScriptPid() {
		return this.EvalDataScriptPid;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public short getModifyDataScriptGroupKey() {
		return this.ModifyDataScriptGroupKey;
	}

	public int getModifyDataScriptPid() {
		return this.ModifyDataScriptPid;
	}

	public short getParamSetKey() {
		return this.ParamSetKey;
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

	public int getSubstnParamSetDefnPid() {
		return this.SubstnParamSetDefnPid;
	}

	public short getViewDataScriptGroupKey() {
		return this.ViewDataScriptGroupKey;
	}

	public int getViewDataScriptPid() {
		return this.ViewDataScriptPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((SubstnParamSetDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubstnParamSetDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubstnParamSetDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubstnParamSetDefns) model).setSubstnParamSetDefnPid(rs.getInt("SUBSTN_PARAM_SET_DEFN_PID"));
		((SubstnParamSetDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubstnParamSetDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
		((SubstnParamSetDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
		((SubstnParamSetDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
		((SubstnParamSetDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
		((SubstnParamSetDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
		((SubstnParamSetDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
		((SubstnParamSetDefns) model).setEvalDataScriptGroupKey(rs.getShort("EVAL_DATA_SCRIPT_GROUP_KEY"));
		((SubstnParamSetDefns) model).setEvalDataScriptPid(rs.getInt("EVAL_DATA_SCRIPT_PID"));
		((SubstnParamSetDefns) model).setParamSetKey(rs.getShort("PARAM_SET_KEY"));
		((SubstnParamSetDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubstnParamSetDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubstnParamSetDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SubstnParamSetDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubstnParamSetDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubstnParamSetDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubstnParamSetDefns) model).setSubstnParamSetDefnPid(rs.getInt("SUBSTN_PARAM_SET_DEFN_PID"));
		((SubstnParamSetDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubstnParamSetDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
		((SubstnParamSetDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
		((SubstnParamSetDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
		((SubstnParamSetDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
		((SubstnParamSetDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
		((SubstnParamSetDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
		((SubstnParamSetDefns) model).setEvalDataScriptGroupKey(rs.getShort("EVAL_DATA_SCRIPT_GROUP_KEY"));
		((SubstnParamSetDefns) model).setEvalDataScriptPid(rs.getInt("EVAL_DATA_SCRIPT_PID"));
		((SubstnParamSetDefns) model).setParamSetKey(rs.getShort("PARAM_SET_KEY"));
		((SubstnParamSetDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubstnParamSetDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubstnParamSetDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDeleteDataScriptGroupKey(short DeleteDataScriptGroupKey) {
		this.DeleteDataScriptGroupKey = DeleteDataScriptGroupKey;
	}

	public void setDeleteDataScriptPid(int DeleteDataScriptPid) {
		this.DeleteDataScriptPid = DeleteDataScriptPid;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setEvalDataScriptGroupKey(short EvalDataScriptGroupKey) {
		this.EvalDataScriptGroupKey = EvalDataScriptGroupKey;
	}

	public void setEvalDataScriptPid(int EvalDataScriptPid) {
		this.EvalDataScriptPid = EvalDataScriptPid;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setModifyDataScriptGroupKey(short ModifyDataScriptGroupKey) {
		this.ModifyDataScriptGroupKey = ModifyDataScriptGroupKey;
	}

	public void setModifyDataScriptPid(int ModifyDataScriptPid) {
		this.ModifyDataScriptPid = ModifyDataScriptPid;
	}

	public void setParamSetKey(short ParamSetKey) {
		this.ParamSetKey = ParamSetKey;
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

	public void setSubstnParamSetDefnPid(int SubstnParamSetDefnPid) {
		this.SubstnParamSetDefnPid = SubstnParamSetDefnPid;
	}

	public void setViewDataScriptGroupKey(short ViewDataScriptGroupKey) {
		this.ViewDataScriptGroupKey = ViewDataScriptGroupKey;
	}

	public void setViewDataScriptPid(int ViewDataScriptPid) {
		this.ViewDataScriptPid = ViewDataScriptPid;
	}

}
