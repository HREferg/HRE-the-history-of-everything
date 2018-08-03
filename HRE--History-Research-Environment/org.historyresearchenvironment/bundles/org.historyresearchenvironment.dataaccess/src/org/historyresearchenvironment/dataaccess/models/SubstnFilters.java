package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SUBSTN_FILTERS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SubstnFilters extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSTN_FILTER_PID, " + "IS_SYSTEM, " + "SUBSTN_TYPE_KEY, " + "PARENT_STEP_PID, " + "SCRIPT_GROUP_KEY, "
			+ "SCRIPT_KEY, " + "PARAMS_SET_KEY, " + "THIS_PARAMS_KEY, " + "DEFLT_PARAMS_KEY, " + "NEXT_SORT_TERM_KEY, "
			+ "NEXT_STEP_KEY, " + "DISPLAY_ORDER, " + "SHOW FROM PUBLIC.SUBSTN_FILTERS WHERE SUBSTN_FILTER_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSTN_FILTER_PID, " + "IS_SYSTEM, " + "SUBSTN_TYPE_KEY, " + "PARENT_STEP_PID, " + "SCRIPT_GROUP_KEY, "
			+ "SCRIPT_KEY, " + "PARAMS_SET_KEY, " + "THIS_PARAMS_KEY, " + "DEFLT_PARAMS_KEY, " + "NEXT_SORT_TERM_KEY, "
			+ "NEXT_STEP_KEY, " + "DISPLAY_ORDER, " + "SHOW FROM PUBLIC.SUBSTN_FILTERS";

	private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_FILTERS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SUBSTN_FILTER_PID, " + "IS_SYSTEM, " + "SUBSTN_TYPE_KEY, " + "PARENT_STEP_PID, "
			+ "SCRIPT_GROUP_KEY, " + "SCRIPT_KEY, " + "PARAMS_SET_KEY, " + "THIS_PARAMS_KEY, " + "DEFLT_PARAMS_KEY, "
			+ "NEXT_SORT_TERM_KEY, " + "NEXT_STEP_KEY, " + "DISPLAY_ORDER, " + "SHOW) VALUES (?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_FILTERSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "SUBSTN_TYPE_KEY = ?, " + "PARENT_STEP_PID = ?, "
			+ "SCRIPT_GROUP_KEY = ?, " + "SCRIPT_KEY = ?, " + "PARAMS_SET_KEY = ?, " + "THIS_PARAMS_KEY = ?, "
			+ "DEFLT_PARAMS_KEY = ?, " + "NEXT_SORT_TERM_KEY = ?, " + "NEXT_STEP_KEY = ?, " + "DISPLAY_ORDER = ?, "
			+ "SHOW = ? WHERE SUBSTN_FILTER_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_FILTERS WHERE SUBSTN_FILTER_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_FILTERS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SubstnFilterPid;
	private boolean IsSystem;
	private short SubstnTypeKey;
	private int ParentStepPid;
	private short ScriptGroupKey;
	private short ScriptKey;
	private short ParamsSetKey;
	private short ThisParamsKey;
	private short DefltParamsKey;
	private short NextSortTermKey;
	private short NextStepKey;
	private short DisplayOrder;
	private boolean Show;
	private SubstnFilters model;

	public SubstnFilters() throws SQLException {
	}

	public SubstnFilters(int SubstnFilterPid) throws SQLException {
		super();
		this.SubstnFilterPid = SubstnFilterPid;
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
			model = new SubstnFilters();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSubstnFilterPid(rs.getInt("SUBSTN_FILTER_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setSubstnTypeKey(rs.getShort("SUBSTN_TYPE_KEY"));
			model.setParentStepPid(rs.getInt("PARENT_STEP_PID"));
			model.setScriptGroupKey(rs.getShort("SCRIPT_GROUP_KEY"));
			model.setScriptKey(rs.getShort("SCRIPT_KEY"));
			model.setParamsSetKey(rs.getShort("PARAMS_SET_KEY"));
			model.setThisParamsKey(rs.getShort("THIS_PARAMS_KEY"));
			model.setDefltParamsKey(rs.getShort("DEFLT_PARAMS_KEY"));
			model.setNextSortTermKey(rs.getShort("NEXT_SORT_TERM_KEY"));
			model.setNextStepKey(rs.getShort("NEXT_STEP_KEY"));
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
			model.setSubstnFilterPid(rs.getInt("SUBSTN_FILTER_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setSubstnTypeKey(rs.getShort("SUBSTN_TYPE_KEY"));
			model.setParentStepPid(rs.getInt("PARENT_STEP_PID"));
			model.setScriptGroupKey(rs.getShort("SCRIPT_GROUP_KEY"));
			model.setScriptKey(rs.getShort("SCRIPT_KEY"));
			model.setParamsSetKey(rs.getShort("PARAMS_SET_KEY"));
			model.setThisParamsKey(rs.getShort("THIS_PARAMS_KEY"));
			model.setDefltParamsKey(rs.getShort("DEFLT_PARAMS_KEY"));
			model.setNextSortTermKey(rs.getShort("NEXT_SORT_TERM_KEY"));
			model.setNextStepKey(rs.getShort("NEXT_STEP_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setShow(rs.getBoolean("SHOW"));
		}
		return this;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public short getDefltParamsKey() {
		return this.DefltParamsKey;
	}

	public short getDisplayOrder() {
		return this.DisplayOrder;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public short getNextSortTermKey() {
		return this.NextSortTermKey;
	}

	public short getNextStepKey() {
		return this.NextStepKey;
	}

	public short getParamsSetKey() {
		return this.ParamsSetKey;
	}

	public int getParentStepPid() {
		return this.ParentStepPid;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getScriptGroupKey() {
		return this.ScriptGroupKey;
	}

	public short getScriptKey() {
		return this.ScriptKey;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public boolean getShow() {
		return this.Show;
	}

	public int getSubstnFilterPid() {
		return this.SubstnFilterPid;
	}

	public short getSubstnTypeKey() {
		return this.SubstnTypeKey;
	}

	public short getThisParamsKey() {
		return this.ThisParamsKey;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((SubstnFilters) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubstnFilters) model).setSetKey(rs.getShort("SET_KEY"));
		((SubstnFilters) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubstnFilters) model).setSubstnFilterPid(rs.getInt("SUBSTN_FILTER_PID"));
		((SubstnFilters) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubstnFilters) model).setSubstnTypeKey(rs.getShort("SUBSTN_TYPE_KEY"));
		((SubstnFilters) model).setParentStepPid(rs.getInt("PARENT_STEP_PID"));
		((SubstnFilters) model).setScriptGroupKey(rs.getShort("SCRIPT_GROUP_KEY"));
		((SubstnFilters) model).setScriptKey(rs.getShort("SCRIPT_KEY"));
		((SubstnFilters) model).setParamsSetKey(rs.getShort("PARAMS_SET_KEY"));
		((SubstnFilters) model).setThisParamsKey(rs.getShort("THIS_PARAMS_KEY"));
		((SubstnFilters) model).setDefltParamsKey(rs.getShort("DEFLT_PARAMS_KEY"));
		((SubstnFilters) model).setNextSortTermKey(rs.getShort("NEXT_SORT_TERM_KEY"));
		((SubstnFilters) model).setNextStepKey(rs.getShort("NEXT_STEP_KEY"));
		((SubstnFilters) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubstnFilters) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SubstnFilters) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubstnFilters) model).setSetKey(rs.getShort("SET_KEY"));
		((SubstnFilters) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubstnFilters) model).setSubstnFilterPid(rs.getInt("SUBSTN_FILTER_PID"));
		((SubstnFilters) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubstnFilters) model).setSubstnTypeKey(rs.getShort("SUBSTN_TYPE_KEY"));
		((SubstnFilters) model).setParentStepPid(rs.getInt("PARENT_STEP_PID"));
		((SubstnFilters) model).setScriptGroupKey(rs.getShort("SCRIPT_GROUP_KEY"));
		((SubstnFilters) model).setScriptKey(rs.getShort("SCRIPT_KEY"));
		((SubstnFilters) model).setParamsSetKey(rs.getShort("PARAMS_SET_KEY"));
		((SubstnFilters) model).setThisParamsKey(rs.getShort("THIS_PARAMS_KEY"));
		((SubstnFilters) model).setDefltParamsKey(rs.getShort("DEFLT_PARAMS_KEY"));
		((SubstnFilters) model).setNextSortTermKey(rs.getShort("NEXT_SORT_TERM_KEY"));
		((SubstnFilters) model).setNextStepKey(rs.getShort("NEXT_STEP_KEY"));
		((SubstnFilters) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubstnFilters) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDefltParamsKey(short DefltParamsKey) {
		this.DefltParamsKey = DefltParamsKey;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setNextSortTermKey(short NextSortTermKey) {
		this.NextSortTermKey = NextSortTermKey;
	}

	public void setNextStepKey(short NextStepKey) {
		this.NextStepKey = NextStepKey;
	}

	public void setParamsSetKey(short ParamsSetKey) {
		this.ParamsSetKey = ParamsSetKey;
	}

	public void setParentStepPid(int ParentStepPid) {
		this.ParentStepPid = ParentStepPid;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setScriptGroupKey(short ScriptGroupKey) {
		this.ScriptGroupKey = ScriptGroupKey;
	}

	public void setScriptKey(short ScriptKey) {
		this.ScriptKey = ScriptKey;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setShow(boolean Show) {
		this.Show = Show;
	}

	public void setSubstnFilterPid(int SubstnFilterPid) {
		this.SubstnFilterPid = SubstnFilterPid;
	}

	public void setSubstnTypeKey(short SubstnTypeKey) {
		this.SubstnTypeKey = SubstnTypeKey;
	}

	public void setThisParamsKey(short ThisParamsKey) {
		this.ThisParamsKey = ThisParamsKey;
	}

}
