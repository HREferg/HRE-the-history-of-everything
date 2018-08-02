package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSTN_PARAM_NAMES database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SubstnParamNames extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SUBSTN_PARAM_NAME_PID, " +
"IS_SYSTEM, " +
"VIEW_DATA_SCRIPT_GROUP_KEY, " +
"VIEW_DATA_SCRIPT_PID, " +
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +
"MODIFY_DATA_SCRIPT_PID, " +
"DELETE_DATA_SCRIPT_GROUP_KEY, " +
"DELETE_DATA_SCRIPT_PID, " +
"EVAL_DATA_SCRIPT_GROUP_KEY, " +
"EVAL_DATA_SCRIPT_PID, " +
"PARAM_SET_KEY, " +
"DATA_TYPE_KEY, " +
"MUST_BE_ENTERED, " +
"DEFLT_VALUE, " +
"DISPLAY_ORDER, " +
"SHOW FROM PUBLIC.SUBSTN_PARAM_NAMES WHERE SUBSTN_PARAM_NAME_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SUBSTN_PARAM_NAME_PID, " +  
"IS_SYSTEM, " +  
"VIEW_DATA_SCRIPT_GROUP_KEY, " +  
"VIEW_DATA_SCRIPT_PID, " +  
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +  
"MODIFY_DATA_SCRIPT_PID, " +  
"DELETE_DATA_SCRIPT_GROUP_KEY, " +  
"DELETE_DATA_SCRIPT_PID, " +  
"EVAL_DATA_SCRIPT_GROUP_KEY, " +  
"EVAL_DATA_SCRIPT_PID, " +  
"PARAM_SET_KEY, " +  
"DATA_TYPE_KEY, " +  
"MUST_BE_ENTERED, " +  
"DEFLT_VALUE, " +  
"DISPLAY_ORDER, " +  
"SHOW FROM PUBLIC.SUBSTN_PARAM_NAMES";

private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_PARAM_NAMES( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SUBSTN_PARAM_NAME_PID, " +     
"IS_SYSTEM, " +     
"VIEW_DATA_SCRIPT_GROUP_KEY, " +     
"VIEW_DATA_SCRIPT_PID, " +     
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +     
"MODIFY_DATA_SCRIPT_PID, " +     
"DELETE_DATA_SCRIPT_GROUP_KEY, " +     
"DELETE_DATA_SCRIPT_PID, " +     
"EVAL_DATA_SCRIPT_GROUP_KEY, " +     
"EVAL_DATA_SCRIPT_PID, " +     
"PARAM_SET_KEY, " +     
"DATA_TYPE_KEY, " +     
"MUST_BE_ENTERED, " +     
"DEFLT_VALUE, " +     
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
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_PARAM_NAMESSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"VIEW_DATA_SCRIPT_GROUP_KEY = ?, " + 
"VIEW_DATA_SCRIPT_PID = ?, " + 
"MODIFY_DATA_SCRIPT_GROUP_KEY = ?, " + 
"MODIFY_DATA_SCRIPT_PID = ?, " + 
"DELETE_DATA_SCRIPT_GROUP_KEY = ?, " + 
"DELETE_DATA_SCRIPT_PID = ?, " + 
"EVAL_DATA_SCRIPT_GROUP_KEY = ?, " + 
"EVAL_DATA_SCRIPT_PID = ?, " + 
"PARAM_SET_KEY = ?, " + 
"DATA_TYPE_KEY = ?, " + 
"MUST_BE_ENTERED = ?, " + 
"DEFLT_VALUE = ?, " + 
"DISPLAY_ORDER = ?, " + 
"SHOW = ? WHERE SUBSTN_PARAM_NAME_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_PARAM_NAMES WHERE SUBSTN_PARAM_NAME_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_PARAM_NAMES";

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

public SubstnParamNames() throws SQLException {
}


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
ps.setInt(1, (int) key);
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

public int getRecordNum() {
return this.RecordNum;
}

public short getSetKey() {
return this.SetKey;
}

public int getCommitPid() {
return this.CommitPid;
}

public int getSubstnParamNamePid() {
return this.SubstnParamNamePid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public short getViewDataScriptGroupKey() {
return this.ViewDataScriptGroupKey;
}

public int getViewDataScriptPid() {
return this.ViewDataScriptPid;
}

public short getModifyDataScriptGroupKey() {
return this.ModifyDataScriptGroupKey;
}

public int getModifyDataScriptPid() {
return this.ModifyDataScriptPid;
}

public short getDeleteDataScriptGroupKey() {
return this.DeleteDataScriptGroupKey;
}

public int getDeleteDataScriptPid() {
return this.DeleteDataScriptPid;
}

public short getEvalDataScriptGroupKey() {
return this.EvalDataScriptGroupKey;
}

public int getEvalDataScriptPid() {
return this.EvalDataScriptPid;
}

public short getParamSetKey() {
return this.ParamSetKey;
}

public short getDataTypeKey() {
return this.DataTypeKey;
}

public boolean getMustBeEntered() {
return this.MustBeEntered;
}

public String getDefltValue() {
return this.DefltValue;
}

public short getDisplayOrder() {
return this.DisplayOrder;
}

public boolean getShow() {
return this.Show;
}

public void setRecordNum(int RecordNum) {
this.RecordNum = RecordNum;
}

public void setSetKey(short SetKey) {
this.SetKey = SetKey;
}

public void setCommitPid(int CommitPid) {
this.CommitPid = CommitPid;
}

public void setSubstnParamNamePid(int SubstnParamNamePid) {
this.SubstnParamNamePid = SubstnParamNamePid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setViewDataScriptGroupKey(short ViewDataScriptGroupKey) {
this.ViewDataScriptGroupKey = ViewDataScriptGroupKey;
}

public void setViewDataScriptPid(int ViewDataScriptPid) {
this.ViewDataScriptPid = ViewDataScriptPid;
}

public void setModifyDataScriptGroupKey(short ModifyDataScriptGroupKey) {
this.ModifyDataScriptGroupKey = ModifyDataScriptGroupKey;
}

public void setModifyDataScriptPid(int ModifyDataScriptPid) {
this.ModifyDataScriptPid = ModifyDataScriptPid;
}

public void setDeleteDataScriptGroupKey(short DeleteDataScriptGroupKey) {
this.DeleteDataScriptGroupKey = DeleteDataScriptGroupKey;
}

public void setDeleteDataScriptPid(int DeleteDataScriptPid) {
this.DeleteDataScriptPid = DeleteDataScriptPid;
}

public void setEvalDataScriptGroupKey(short EvalDataScriptGroupKey) {
this.EvalDataScriptGroupKey = EvalDataScriptGroupKey;
}

public void setEvalDataScriptPid(int EvalDataScriptPid) {
this.EvalDataScriptPid = EvalDataScriptPid;
}

public void setParamSetKey(short ParamSetKey) {
this.ParamSetKey = ParamSetKey;
}

public void setDataTypeKey(short DataTypeKey) {
this.DataTypeKey = DataTypeKey;
}

public void setMustBeEntered(boolean MustBeEntered) {
this.MustBeEntered = MustBeEntered;
}

public void setDefltValue(String DefltValue) {
this.DefltValue = DefltValue;
}

public void setDisplayOrder(short DisplayOrder) {
this.DisplayOrder = DisplayOrder;
}

public void setShow(boolean Show) {
this.Show = Show;
}

}

