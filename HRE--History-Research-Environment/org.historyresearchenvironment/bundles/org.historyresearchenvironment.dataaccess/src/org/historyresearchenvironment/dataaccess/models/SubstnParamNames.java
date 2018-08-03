package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SUBSTN_PARAM_NAMES database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SubstnParamNames extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSTN_PARAM_NAME_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, " + "VIEW_DATA_SCRIPT_PID, "
			+ "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, " + "DELETE_DATA_SCRIPT_GROUP_KEY, "
			+ "DELETE_DATA_SCRIPT_PID, " + "EVAL_DATA_SCRIPT_GROUP_KEY, " + "EVAL_DATA_SCRIPT_PID, " + "PARAM_SET_KEY, "
			+ "DATA_TYPE_KEY, " + "MUST_BE_ENTERED, " + "DEFLT_VALUE, " + "DISPLAY_ORDER, "
			+ "SHOW FROM PUBLIC.SUBSTN_PARAM_NAMES WHERE SUBSTN_PARAM_NAME_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSTN_PARAM_NAME_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, " + "VIEW_DATA_SCRIPT_PID, "
			+ "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, " + "DELETE_DATA_SCRIPT_GROUP_KEY, "
			+ "DELETE_DATA_SCRIPT_PID, " + "EVAL_DATA_SCRIPT_GROUP_KEY, " + "EVAL_DATA_SCRIPT_PID, " + "PARAM_SET_KEY, "
			+ "DATA_TYPE_KEY, " + "MUST_BE_ENTERED, " + "DEFLT_VALUE, " + "DISPLAY_ORDER, "
			+ "SHOW FROM PUBLIC.SUBSTN_PARAM_NAMES";

	private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_PARAM_NAMES( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SUBSTN_PARAM_NAME_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, "
			+ "VIEW_DATA_SCRIPT_PID, " + "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, "
			+ "DELETE_DATA_SCRIPT_GROUP_KEY, " + "DELETE_DATA_SCRIPT_PID, " + "EVAL_DATA_SCRIPT_GROUP_KEY, "
			+ "EVAL_DATA_SCRIPT_PID, " + "PARAM_SET_KEY, " + "DATA_TYPE_KEY, " + "MUST_BE_ENTERED, " + "DEFLT_VALUE, "
			+ "DISPLAY_ORDER, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_PARAM_NAMESSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "VIEW_DATA_SCRIPT_GROUP_KEY = ?, " + "VIEW_DATA_SCRIPT_PID = ?, "
			+ "MODIFY_DATA_SCRIPT_GROUP_KEY = ?, " + "MODIFY_DATA_SCRIPT_PID = ?, "
			+ "DELETE_DATA_SCRIPT_GROUP_KEY = ?, " + "DELETE_DATA_SCRIPT_PID = ?, " + "EVAL_DATA_SCRIPT_GROUP_KEY = ?, "
			+ "EVAL_DATA_SCRIPT_PID = ?, " + "PARAM_SET_KEY = ?, " + "DATA_TYPE_KEY = ?, " + "MUST_BE_ENTERED = ?, "
			+ "DEFLT_VALUE = ?, " + "DISPLAY_ORDER = ?, " + "SHOW = ? WHERE SUBSTN_PARAM_NAME_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_PARAM_NAMES WHERE SUBSTN_PARAM_NAME_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_PARAM_NAMES";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SubstnParamNamePid;
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
	private short DataTypeKey;
	private boolean MustBeEntered;
	private String DefltValue;
	private short DisplayOrder;
	private boolean Show;
	private SubstnParamNames model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SubstnParamNames() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param SubstnParamNamePid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SubstnParamNames(int SubstnParamNamePid) throws SQLException {
		super();
		this.SubstnParamNamePid = SubstnParamNamePid;
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
			model = new SubstnParamNames();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSubstnParamNamePid(rs.getInt("SUBSTN_PARAM_NAME_PID"));
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
			model.setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
			model.setMustBeEntered(rs.getBoolean("MUST_BE_ENTERED"));
			model.setDefltValue(rs.getString("DEFLT_VALUE"));
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
			model.setSubstnParamNamePid(rs.getInt("SUBSTN_PARAM_NAME_PID"));
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
			model.setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
			model.setMustBeEntered(rs.getBoolean("MUST_BE_ENTERED"));
			model.setDefltValue(rs.getString("DEFLT_VALUE"));
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
	 * Get the DataTypeKey field.
	 *
	 * @return Contents of the DATA_TYPE_KEY column
	 */
	public short getDataTypeKey() {
		return this.DataTypeKey;
	}

	/**
	 * Get the DefltValue field.
	 *
	 * @return Contents of the DEFLT_VALUE column
	 */
	public String getDefltValue() {
		return this.DefltValue;
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
	 * Get the MustBeEntered field.
	 *
	 * @return Contents of the MUST_BE_ENTERED column
	 */
	public boolean getMustBeEntered() {
		return this.MustBeEntered;
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
	 * Get the SubstnParamNamePid field.
	 *
	 * @return Contents of the SUBSTN_PARAM_NAME_PID column
	 */
	public int getSubstnParamNamePid() {
		return this.SubstnParamNamePid;
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
		((SubstnParamNames) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubstnParamNames) model).setSetKey(rs.getShort("SET_KEY"));
		((SubstnParamNames) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubstnParamNames) model).setSubstnParamNamePid(rs.getInt("SUBSTN_PARAM_NAME_PID"));
		((SubstnParamNames) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubstnParamNames) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
		((SubstnParamNames) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
		((SubstnParamNames) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
		((SubstnParamNames) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
		((SubstnParamNames) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
		((SubstnParamNames) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
		((SubstnParamNames) model).setEvalDataScriptGroupKey(rs.getShort("EVAL_DATA_SCRIPT_GROUP_KEY"));
		((SubstnParamNames) model).setEvalDataScriptPid(rs.getInt("EVAL_DATA_SCRIPT_PID"));
		((SubstnParamNames) model).setParamSetKey(rs.getShort("PARAM_SET_KEY"));
		((SubstnParamNames) model).setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
		((SubstnParamNames) model).setMustBeEntered(rs.getBoolean("MUST_BE_ENTERED"));
		((SubstnParamNames) model).setDefltValue(rs.getString("DEFLT_VALUE"));
		((SubstnParamNames) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubstnParamNames) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SubstnParamNames) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubstnParamNames) model).setSetKey(rs.getShort("SET_KEY"));
		((SubstnParamNames) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubstnParamNames) model).setSubstnParamNamePid(rs.getInt("SUBSTN_PARAM_NAME_PID"));
		((SubstnParamNames) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubstnParamNames) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
		((SubstnParamNames) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
		((SubstnParamNames) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
		((SubstnParamNames) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
		((SubstnParamNames) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
		((SubstnParamNames) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
		((SubstnParamNames) model).setEvalDataScriptGroupKey(rs.getShort("EVAL_DATA_SCRIPT_GROUP_KEY"));
		((SubstnParamNames) model).setEvalDataScriptPid(rs.getInt("EVAL_DATA_SCRIPT_PID"));
		((SubstnParamNames) model).setParamSetKey(rs.getShort("PARAM_SET_KEY"));
		((SubstnParamNames) model).setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
		((SubstnParamNames) model).setMustBeEntered(rs.getBoolean("MUST_BE_ENTERED"));
		((SubstnParamNames) model).setDefltValue(rs.getString("DEFLT_VALUE"));
		((SubstnParamNames) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubstnParamNames) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the DataTypeKey field
	 *
	 * @param DataTypeKey
	 *            Contents of the DATA_TYPE_KEY column
	 */
	public void setDataTypeKey(short DataTypeKey) {
		this.DataTypeKey = DataTypeKey;
	}

	/**
	 * Set the DefltValue field
	 *
	 * @param DefltValue
	 *            Contents of the DEFLT_VALUE column
	 */
	public void setDefltValue(String DefltValue) {
		this.DefltValue = DefltValue;
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
	 * Set the MustBeEntered field
	 *
	 * @param MustBeEntered
	 *            Contents of the MUST_BE_ENTERED column
	 */
	public void setMustBeEntered(boolean MustBeEntered) {
		this.MustBeEntered = MustBeEntered;
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
	 * Set the SubstnParamNamePid field
	 *
	 * @param SubstnParamNamePid
	 *            Contents of the SUBSTN_PARAM_NAME_PID column
	 */
	public void setSubstnParamNamePid(int SubstnParamNamePid) {
		this.SubstnParamNamePid = SubstnParamNamePid;
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
