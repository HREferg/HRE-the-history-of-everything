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

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SubstnParamSetDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param SubstnParamSetDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

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

	/**
	 * Get the CommitPid field.
	 *
	 * @return Contents of the COMMIT_PID column
	 */
	public int getCommitPid() {
		return this.CommitPid;
	}

	/**
	 * Get the DeleteDataScriptGroupKey field.
	 *
	 * @return Contents of the DELETE_DATA_SCRIPT_GROUP_KEY column
	 */
	public short getDeleteDataScriptGroupKey() {
		return this.DeleteDataScriptGroupKey;
	}

	/**
	 * Get the DeleteDataScriptPid field.
	 *
	 * @return Contents of the DELETE_DATA_SCRIPT_PID column
	 */
	public int getDeleteDataScriptPid() {
		return this.DeleteDataScriptPid;
	}

	/**
	 * Get the DisplayOrder field.
	 *
	 * @return Contents of the DISPLAY_ORDER column
	 */
	public short getDisplayOrder() {
		return this.DisplayOrder;
	}

	/**
	 * Get the EvalDataScriptGroupKey field.
	 *
	 * @return Contents of the EVAL_DATA_SCRIPT_GROUP_KEY column
	 */
	public short getEvalDataScriptGroupKey() {
		return this.EvalDataScriptGroupKey;
	}

	/**
	 * Get the EvalDataScriptPid field.
	 *
	 * @return Contents of the EVAL_DATA_SCRIPT_PID column
	 */
	public int getEvalDataScriptPid() {
		return this.EvalDataScriptPid;
	}

	/**
	 * Get the IsSystem field.
	 *
	 * @return Contents of the IS_SYSTEM column
	 */
	public boolean getIsSystem() {
		return this.IsSystem;
	}

	/**
	 * Get the ModifyDataScriptGroupKey field.
	 *
	 * @return Contents of the MODIFY_DATA_SCRIPT_GROUP_KEY column
	 */
	public short getModifyDataScriptGroupKey() {
		return this.ModifyDataScriptGroupKey;
	}

	/**
	 * Get the ModifyDataScriptPid field.
	 *
	 * @return Contents of the MODIFY_DATA_SCRIPT_PID column
	 */
	public int getModifyDataScriptPid() {
		return this.ModifyDataScriptPid;
	}

	/**
	 * Get the ParamSetKey field.
	 *
	 * @return Contents of the PARAM_SET_KEY column
	 */
	public short getParamSetKey() {
		return this.ParamSetKey;
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
	 * Get the ReminderKey field.
	 *
	 * @return Contents of the REMINDER_KEY column
	 */
	public short getReminderKey() {
		return this.ReminderKey;
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
	 * Get the Show field.
	 *
	 * @return Contents of the SHOW column
	 */
	public boolean getShow() {
		return this.Show;
	}

	/**
	 * Get the SubstnParamSetDefnPid field.
	 *
	 * @return Contents of the SUBSTN_PARAM_SET_DEFN_PID column
	 */
	public int getSubstnParamSetDefnPid() {
		return this.SubstnParamSetDefnPid;
	}

	/**
	 * Get the ViewDataScriptGroupKey field.
	 *
	 * @return Contents of the VIEW_DATA_SCRIPT_GROUP_KEY column
	 */
	public short getViewDataScriptGroupKey() {
		return this.ViewDataScriptGroupKey;
	}

	/**
	 * Get the ViewDataScriptPid field.
	 *
	 * @return Contents of the VIEW_DATA_SCRIPT_PID column
	 */
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
	 * Set the DeleteDataScriptGroupKey field
	 *
	 * @param DeleteDataScriptGroupKey
	 *            Contents of the DELETE_DATA_SCRIPT_GROUP_KEY column
	 */
	public void setDeleteDataScriptGroupKey(short DeleteDataScriptGroupKey) {
		this.DeleteDataScriptGroupKey = DeleteDataScriptGroupKey;
	}

	/**
	 * Set the DeleteDataScriptPid field
	 *
	 * @param DeleteDataScriptPid
	 *            Contents of the DELETE_DATA_SCRIPT_PID column
	 */
	public void setDeleteDataScriptPid(int DeleteDataScriptPid) {
		this.DeleteDataScriptPid = DeleteDataScriptPid;
	}

	/**
	 * Set the DisplayOrder field
	 *
	 * @param DisplayOrder
	 *            Contents of the DISPLAY_ORDER column
	 */
	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	/**
	 * Set the EvalDataScriptGroupKey field
	 *
	 * @param EvalDataScriptGroupKey
	 *            Contents of the EVAL_DATA_SCRIPT_GROUP_KEY column
	 */
	public void setEvalDataScriptGroupKey(short EvalDataScriptGroupKey) {
		this.EvalDataScriptGroupKey = EvalDataScriptGroupKey;
	}

	/**
	 * Set the EvalDataScriptPid field
	 *
	 * @param EvalDataScriptPid
	 *            Contents of the EVAL_DATA_SCRIPT_PID column
	 */
	public void setEvalDataScriptPid(int EvalDataScriptPid) {
		this.EvalDataScriptPid = EvalDataScriptPid;
	}

	/**
	 * Set the IsSystem field
	 *
	 * @param IsSystem
	 *            Contents of the IS_SYSTEM column
	 */
	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	/**
	 * Set the ModifyDataScriptGroupKey field
	 *
	 * @param ModifyDataScriptGroupKey
	 *            Contents of the MODIFY_DATA_SCRIPT_GROUP_KEY column
	 */
	public void setModifyDataScriptGroupKey(short ModifyDataScriptGroupKey) {
		this.ModifyDataScriptGroupKey = ModifyDataScriptGroupKey;
	}

	/**
	 * Set the ModifyDataScriptPid field
	 *
	 * @param ModifyDataScriptPid
	 *            Contents of the MODIFY_DATA_SCRIPT_PID column
	 */
	public void setModifyDataScriptPid(int ModifyDataScriptPid) {
		this.ModifyDataScriptPid = ModifyDataScriptPid;
	}

	/**
	 * Set the ParamSetKey field
	 *
	 * @param ParamSetKey
	 *            Contents of the PARAM_SET_KEY column
	 */
	public void setParamSetKey(short ParamSetKey) {
		this.ParamSetKey = ParamSetKey;
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
	 * Set the ReminderKey field
	 *
	 * @param ReminderKey
	 *            Contents of the REMINDER_KEY column
	 */
	public void setReminderKey(short ReminderKey) {
		this.ReminderKey = ReminderKey;
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
	 * Set the Show field
	 *
	 * @param Show
	 *            Contents of the SHOW column
	 */
	public void setShow(boolean Show) {
		this.Show = Show;
	}

	/**
	 * Set the SubstnParamSetDefnPid field
	 *
	 * @param SubstnParamSetDefnPid
	 *            Contents of the SUBSTN_PARAM_SET_DEFN_PID column
	 */
	public void setSubstnParamSetDefnPid(int SubstnParamSetDefnPid) {
		this.SubstnParamSetDefnPid = SubstnParamSetDefnPid;
	}

	/**
	 * Set the ViewDataScriptGroupKey field
	 *
	 * @param ViewDataScriptGroupKey
	 *            Contents of the VIEW_DATA_SCRIPT_GROUP_KEY column
	 */
	public void setViewDataScriptGroupKey(short ViewDataScriptGroupKey) {
		this.ViewDataScriptGroupKey = ViewDataScriptGroupKey;
	}

	/**
	 * Set the ViewDataScriptPid field
	 *
	 * @param ViewDataScriptPid
	 *            Contents of the VIEW_DATA_SCRIPT_PID column
	 */
	public void setViewDataScriptPid(int ViewDataScriptPid) {
		this.ViewDataScriptPid = ViewDataScriptPid;
	}

}
