package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSTN_FILTERS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SubstnFilters extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SUBSTN_FILTER_PID, " +
"IS_SYSTEM, " +
"SUBSTN_TYPE_KEY, " +
"PARENT_STEP_PID, " +
"SCRIPT_GROUP_KEY, " +
"SCRIPT_KEY, " +
"PARAMS_SET_KEY, " +
"THIS_PARAMS_KEY, " +
"DEFLT_PARAMS_KEY, " +
"NEXT_SORT_TERM_KEY, " +
"NEXT_STEP_KEY, " +
"DISPLAY_ORDER, " +
"SHOW FROM PUBLIC.SUBSTN_FILTERS WHERE SUBSTN_FILTER_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SUBSTN_FILTER_PID, " +  
"IS_SYSTEM, " +  
"SUBSTN_TYPE_KEY, " +  
"PARENT_STEP_PID, " +  
"SCRIPT_GROUP_KEY, " +  
"SCRIPT_KEY, " +  
"PARAMS_SET_KEY, " +  
"THIS_PARAMS_KEY, " +  
"DEFLT_PARAMS_KEY, " +  
"NEXT_SORT_TERM_KEY, " +  
"NEXT_STEP_KEY, " +  
"DISPLAY_ORDER, " +  
"SHOW FROM PUBLIC.SUBSTN_FILTERS";

private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_FILTERS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SUBSTN_FILTER_PID, " +     
"IS_SYSTEM, " +     
"SUBSTN_TYPE_KEY, " +     
"PARENT_STEP_PID, " +     
"SCRIPT_GROUP_KEY, " +     
"SCRIPT_KEY, " +     
"PARAMS_SET_KEY, " +     
"THIS_PARAMS_KEY, " +     
"DEFLT_PARAMS_KEY, " +     
"NEXT_SORT_TERM_KEY, " +     
"NEXT_STEP_KEY, " +     
"DISPLAY_ORDER, " +     
"SHOW) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_FILTERSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"SUBSTN_TYPE_KEY = ?, " + 
"PARENT_STEP_PID = ?, " + 
"SCRIPT_GROUP_KEY = ?, " + 
"SCRIPT_KEY = ?, " + 
"PARAMS_SET_KEY = ?, " + 
"THIS_PARAMS_KEY = ?, " + 
"DEFLT_PARAMS_KEY = ?, " + 
"NEXT_SORT_TERM_KEY = ?, " + 
"NEXT_STEP_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"SHOW = ? WHERE SUBSTN_FILTER_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_FILTERS WHERE SUBSTN_FILTER_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_FILTERS";

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

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public SubstnFilters() throws SQLException {
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
public SubstnFilters get(int key) throws SQLException {
model = new SubstnFilters();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
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
return model;
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
* Get the CommitPid field.
*
* @return Contents of the COMMIT_PID column
*/
public int getCommitPid() {
return this.CommitPid;
}

/**
* Get the SubstnFilterPid field.
*
* @return Contents of the SUBSTN_FILTER_PID column
*/
public int getSubstnFilterPid() {
return this.SubstnFilterPid;
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
* Get the SubstnTypeKey field.
*
* @return Contents of the SUBSTN_TYPE_KEY column
*/
public short getSubstnTypeKey() {
return this.SubstnTypeKey;
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
* Get the ScriptGroupKey field.
*
* @return Contents of the SCRIPT_GROUP_KEY column
*/
public short getScriptGroupKey() {
return this.ScriptGroupKey;
}

/**
* Get the ScriptKey field.
*
* @return Contents of the SCRIPT_KEY column
*/
public short getScriptKey() {
return this.ScriptKey;
}

/**
* Get the ParamsSetKey field.
*
* @return Contents of the PARAMS_SET_KEY column
*/
public short getParamsSetKey() {
return this.ParamsSetKey;
}

/**
* Get the ThisParamsKey field.
*
* @return Contents of the THIS_PARAMS_KEY column
*/
public short getThisParamsKey() {
return this.ThisParamsKey;
}

/**
* Get the DefltParamsKey field.
*
* @return Contents of the DEFLT_PARAMS_KEY column
*/
public short getDefltParamsKey() {
return this.DefltParamsKey;
}

/**
* Get the NextSortTermKey field.
*
* @return Contents of the NEXT_SORT_TERM_KEY column
*/
public short getNextSortTermKey() {
return this.NextSortTermKey;
}

/**
* Get the NextStepKey field.
*
* @return Contents of the NEXT_STEP_KEY column
*/
public short getNextStepKey() {
return this.NextStepKey;
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
* Get the Show field.
*
* @return Contents of the SHOW column
*/
public boolean getShow() {
return this.Show;
}

/**
* Set the RecordNum field
*
* @param RecordNum Contents of the RECORD_NUM column
*/
public void setRecordNum(int RecordNum) {
this.RecordNum = RecordNum;
}

/**
* Set the SetKey field
*
* @param SetKey Contents of the SET_KEY column
*/
public void setSetKey(short SetKey) {
this.SetKey = SetKey;
}

/**
* Set the CommitPid field
*
* @param CommitPid Contents of the COMMIT_PID column
*/
public void setCommitPid(int CommitPid) {
this.CommitPid = CommitPid;
}

/**
* Set the SubstnFilterPid field
*
* @param SubstnFilterPid Contents of the SUBSTN_FILTER_PID column
*/
public void setSubstnFilterPid(int SubstnFilterPid) {
this.SubstnFilterPid = SubstnFilterPid;
}

/**
* Set the IsSystem field
*
* @param IsSystem Contents of the IS_SYSTEM column
*/
public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

/**
* Set the SubstnTypeKey field
*
* @param SubstnTypeKey Contents of the SUBSTN_TYPE_KEY column
*/
public void setSubstnTypeKey(short SubstnTypeKey) {
this.SubstnTypeKey = SubstnTypeKey;
}

/**
* Set the ParentStepPid field
*
* @param ParentStepPid Contents of the PARENT_STEP_PID column
*/
public void setParentStepPid(int ParentStepPid) {
this.ParentStepPid = ParentStepPid;
}

/**
* Set the ScriptGroupKey field
*
* @param ScriptGroupKey Contents of the SCRIPT_GROUP_KEY column
*/
public void setScriptGroupKey(short ScriptGroupKey) {
this.ScriptGroupKey = ScriptGroupKey;
}

/**
* Set the ScriptKey field
*
* @param ScriptKey Contents of the SCRIPT_KEY column
*/
public void setScriptKey(short ScriptKey) {
this.ScriptKey = ScriptKey;
}

/**
* Set the ParamsSetKey field
*
* @param ParamsSetKey Contents of the PARAMS_SET_KEY column
*/
public void setParamsSetKey(short ParamsSetKey) {
this.ParamsSetKey = ParamsSetKey;
}

/**
* Set the ThisParamsKey field
*
* @param ThisParamsKey Contents of the THIS_PARAMS_KEY column
*/
public void setThisParamsKey(short ThisParamsKey) {
this.ThisParamsKey = ThisParamsKey;
}

/**
* Set the DefltParamsKey field
*
* @param DefltParamsKey Contents of the DEFLT_PARAMS_KEY column
*/
public void setDefltParamsKey(short DefltParamsKey) {
this.DefltParamsKey = DefltParamsKey;
}

/**
* Set the NextSortTermKey field
*
* @param NextSortTermKey Contents of the NEXT_SORT_TERM_KEY column
*/
public void setNextSortTermKey(short NextSortTermKey) {
this.NextSortTermKey = NextSortTermKey;
}

/**
* Set the NextStepKey field
*
* @param NextStepKey Contents of the NEXT_STEP_KEY column
*/
public void setNextStepKey(short NextStepKey) {
this.NextStepKey = NextStepKey;
}

/**
* Set the DisplayOrder field
*
* @param DisplayOrder Contents of the DISPLAY_ORDER column
*/
public void setDisplayOrder(short DisplayOrder) {
this.DisplayOrder = DisplayOrder;
}

/**
* Set the Show field
*
* @param Show Contents of the SHOW column
*/
public void setShow(boolean Show) {
this.Show = Show;
}

}

