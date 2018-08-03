package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SUBSTN_PARAM_VALUES database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SubstnParamValues extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSTN_PARAM_VALUE_PID, " + "IS_SYSTEM, " + "PARENT_STEP_PID, " + "PARAM_LIST_KEY, " + "PARAM_SET_KEY, "
			+ "PARAM_NAME_KEY, " + "VALUE_IS_DATA_ALIAS, " + "VALUE_IS_OTHER_ALIAS, " + "ALIAS_KEY, "
			+ "DEFLT_PARAM_STEP_PID, " + "DISPLAY_ORDER, "
			+ "SHOW FROM PUBLIC.SUBSTN_PARAM_VALUES WHERE SUBSTN_PARAM_VALUE_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSTN_PARAM_VALUE_PID, " + "IS_SYSTEM, " + "PARENT_STEP_PID, " + "PARAM_LIST_KEY, " + "PARAM_SET_KEY, "
			+ "PARAM_NAME_KEY, " + "VALUE_IS_DATA_ALIAS, " + "VALUE_IS_OTHER_ALIAS, " + "ALIAS_KEY, "
			+ "DEFLT_PARAM_STEP_PID, " + "DISPLAY_ORDER, " + "SHOW FROM PUBLIC.SUBSTN_PARAM_VALUES";

	private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_PARAM_VALUES( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SUBSTN_PARAM_VALUE_PID, " + "IS_SYSTEM, " + "PARENT_STEP_PID, " + "PARAM_LIST_KEY, "
			+ "PARAM_SET_KEY, " + "PARAM_NAME_KEY, " + "VALUE_IS_DATA_ALIAS, " + "VALUE_IS_OTHER_ALIAS, "
			+ "ALIAS_KEY, " + "DEFLT_PARAM_STEP_PID, " + "DISPLAY_ORDER, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_PARAM_VALUESSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PARENT_STEP_PID = ?, " + "PARAM_LIST_KEY = ?, "
			+ "PARAM_SET_KEY = ?, " + "PARAM_NAME_KEY = ?, " + "VALUE_IS_DATA_ALIAS = ?, "
			+ "VALUE_IS_OTHER_ALIAS = ?, " + "ALIAS_KEY = ?, " + "DEFLT_PARAM_STEP_PID = ?, " + "DISPLAY_ORDER = ?, "
			+ "SHOW = ? WHERE SUBSTN_PARAM_VALUE_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_PARAM_VALUES WHERE SUBSTN_PARAM_VALUE_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_PARAM_VALUES";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SubstnParamValuePid;
	private boolean IsSystem;
	private int ParentStepPid;
	private short ParamListKey;
	private short ParamSetKey;
	private short ParamNameKey;
	private boolean ValueIsDataAlias;
	private boolean ValueIsOtherAlias;
	private short AliasKey;
	private int DefltParamStepPid;
	private short DisplayOrder;
	private boolean Show;
	private SubstnParamValues model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SubstnParamValues() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param SubstnParamValuePid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SubstnParamValues(int SubstnParamValuePid) throws SQLException {
		super();
		this.SubstnParamValuePid = SubstnParamValuePid;
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
			model = new SubstnParamValues();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSubstnParamValuePid(rs.getInt("SUBSTN_PARAM_VALUE_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentStepPid(rs.getInt("PARENT_STEP_PID"));
			model.setParamListKey(rs.getShort("PARAM_LIST_KEY"));
			model.setParamSetKey(rs.getShort("PARAM_SET_KEY"));
			model.setParamNameKey(rs.getShort("PARAM_NAME_KEY"));
			model.setValueIsDataAlias(rs.getBoolean("VALUE_IS_DATA_ALIAS"));
			model.setValueIsOtherAlias(rs.getBoolean("VALUE_IS_OTHER_ALIAS"));
			model.setAliasKey(rs.getShort("ALIAS_KEY"));
			model.setDefltParamStepPid(rs.getInt("DEFLT_PARAM_STEP_PID"));
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
			model.setSubstnParamValuePid(rs.getInt("SUBSTN_PARAM_VALUE_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentStepPid(rs.getInt("PARENT_STEP_PID"));
			model.setParamListKey(rs.getShort("PARAM_LIST_KEY"));
			model.setParamSetKey(rs.getShort("PARAM_SET_KEY"));
			model.setParamNameKey(rs.getShort("PARAM_NAME_KEY"));
			model.setValueIsDataAlias(rs.getBoolean("VALUE_IS_DATA_ALIAS"));
			model.setValueIsOtherAlias(rs.getBoolean("VALUE_IS_OTHER_ALIAS"));
			model.setAliasKey(rs.getShort("ALIAS_KEY"));
			model.setDefltParamStepPid(rs.getInt("DEFLT_PARAM_STEP_PID"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setShow(rs.getBoolean("SHOW"));
		}
		return this;
	}

	/**
	 * Get the AliasKey field.
	 *
	 * @return Contents of the ALIAS_KEY column
	 */
	public short getAliasKey() {
		return this.AliasKey;
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
	 * Get the DefltParamStepPid field.
	 *
	 * @return Contents of the DEFLT_PARAM_STEP_PID column
	 */
	public int getDefltParamStepPid() {
		return this.DefltParamStepPid;
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
	 * Get the IsSystem field.
	 *
	 * @return Contents of the IS_SYSTEM column
	 */
	public boolean getIsSystem() {
		return this.IsSystem;
	}

	/**
	 * Get the ParamListKey field.
	 *
	 * @return Contents of the PARAM_LIST_KEY column
	 */
	public short getParamListKey() {
		return this.ParamListKey;
	}

	/**
	 * Get the ParamNameKey field.
	 *
	 * @return Contents of the PARAM_NAME_KEY column
	 */
	public short getParamNameKey() {
		return this.ParamNameKey;
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
	 * Get the ParentStepPid field.
	 *
	 * @return Contents of the PARENT_STEP_PID column
	 */
	public int getParentStepPid() {
		return this.ParentStepPid;
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
	 * Get the SubstnParamValuePid field.
	 *
	 * @return Contents of the SUBSTN_PARAM_VALUE_PID column
	 */
	public int getSubstnParamValuePid() {
		return this.SubstnParamValuePid;
	}

	/**
	 * Get the ValueIsDataAlias field.
	 *
	 * @return Contents of the VALUE_IS_DATA_ALIAS column
	 */
	public boolean getValueIsDataAlias() {
		return this.ValueIsDataAlias;
	}

	/**
	 * Get the ValueIsOtherAlias field.
	 *
	 * @return Contents of the VALUE_IS_OTHER_ALIAS column
	 */
	public boolean getValueIsOtherAlias() {
		return this.ValueIsOtherAlias;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((SubstnParamValues) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubstnParamValues) model).setSetKey(rs.getShort("SET_KEY"));
		((SubstnParamValues) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubstnParamValues) model).setSubstnParamValuePid(rs.getInt("SUBSTN_PARAM_VALUE_PID"));
		((SubstnParamValues) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubstnParamValues) model).setParentStepPid(rs.getInt("PARENT_STEP_PID"));
		((SubstnParamValues) model).setParamListKey(rs.getShort("PARAM_LIST_KEY"));
		((SubstnParamValues) model).setParamSetKey(rs.getShort("PARAM_SET_KEY"));
		((SubstnParamValues) model).setParamNameKey(rs.getShort("PARAM_NAME_KEY"));
		((SubstnParamValues) model).setValueIsDataAlias(rs.getBoolean("VALUE_IS_DATA_ALIAS"));
		((SubstnParamValues) model).setValueIsOtherAlias(rs.getBoolean("VALUE_IS_OTHER_ALIAS"));
		((SubstnParamValues) model).setAliasKey(rs.getShort("ALIAS_KEY"));
		((SubstnParamValues) model).setDefltParamStepPid(rs.getInt("DEFLT_PARAM_STEP_PID"));
		((SubstnParamValues) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubstnParamValues) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SubstnParamValues) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubstnParamValues) model).setSetKey(rs.getShort("SET_KEY"));
		((SubstnParamValues) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubstnParamValues) model).setSubstnParamValuePid(rs.getInt("SUBSTN_PARAM_VALUE_PID"));
		((SubstnParamValues) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubstnParamValues) model).setParentStepPid(rs.getInt("PARENT_STEP_PID"));
		((SubstnParamValues) model).setParamListKey(rs.getShort("PARAM_LIST_KEY"));
		((SubstnParamValues) model).setParamSetKey(rs.getShort("PARAM_SET_KEY"));
		((SubstnParamValues) model).setParamNameKey(rs.getShort("PARAM_NAME_KEY"));
		((SubstnParamValues) model).setValueIsDataAlias(rs.getBoolean("VALUE_IS_DATA_ALIAS"));
		((SubstnParamValues) model).setValueIsOtherAlias(rs.getBoolean("VALUE_IS_OTHER_ALIAS"));
		((SubstnParamValues) model).setAliasKey(rs.getShort("ALIAS_KEY"));
		((SubstnParamValues) model).setDefltParamStepPid(rs.getInt("DEFLT_PARAM_STEP_PID"));
		((SubstnParamValues) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubstnParamValues) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	/**
	 * Set the AliasKey field
	 *
	 * @param AliasKey
	 *            Contents of the ALIAS_KEY column
	 */
	public void setAliasKey(short AliasKey) {
		this.AliasKey = AliasKey;
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
	 * Set the DefltParamStepPid field
	 *
	 * @param DefltParamStepPid
	 *            Contents of the DEFLT_PARAM_STEP_PID column
	 */
	public void setDefltParamStepPid(int DefltParamStepPid) {
		this.DefltParamStepPid = DefltParamStepPid;
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
	 * Set the IsSystem field
	 *
	 * @param IsSystem
	 *            Contents of the IS_SYSTEM column
	 */
	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	/**
	 * Set the ParamListKey field
	 *
	 * @param ParamListKey
	 *            Contents of the PARAM_LIST_KEY column
	 */
	public void setParamListKey(short ParamListKey) {
		this.ParamListKey = ParamListKey;
	}

	/**
	 * Set the ParamNameKey field
	 *
	 * @param ParamNameKey
	 *            Contents of the PARAM_NAME_KEY column
	 */
	public void setParamNameKey(short ParamNameKey) {
		this.ParamNameKey = ParamNameKey;
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
	 * Set the ParentStepPid field
	 *
	 * @param ParentStepPid
	 *            Contents of the PARENT_STEP_PID column
	 */
	public void setParentStepPid(int ParentStepPid) {
		this.ParentStepPid = ParentStepPid;
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
	 * Set the SubstnParamValuePid field
	 *
	 * @param SubstnParamValuePid
	 *            Contents of the SUBSTN_PARAM_VALUE_PID column
	 */
	public void setSubstnParamValuePid(int SubstnParamValuePid) {
		this.SubstnParamValuePid = SubstnParamValuePid;
	}

	/**
	 * Set the ValueIsDataAlias field
	 *
	 * @param ValueIsDataAlias
	 *            Contents of the VALUE_IS_DATA_ALIAS column
	 */
	public void setValueIsDataAlias(boolean ValueIsDataAlias) {
		this.ValueIsDataAlias = ValueIsDataAlias;
	}

	/**
	 * Set the ValueIsOtherAlias field
	 *
	 * @param ValueIsOtherAlias
	 *            Contents of the VALUE_IS_OTHER_ALIAS column
	 */
	public void setValueIsOtherAlias(boolean ValueIsOtherAlias) {
		this.ValueIsOtherAlias = ValueIsOtherAlias;
	}

}
