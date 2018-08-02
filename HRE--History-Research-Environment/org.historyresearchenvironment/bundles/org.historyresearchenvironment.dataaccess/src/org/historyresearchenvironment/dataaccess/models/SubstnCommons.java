package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSTN_COMMONS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SubstnCommons extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SUBSTN_COMMON_PID, " +
"IS_SYSTEM, " +
"SUBSTN_TYPE_KEY, " +
"PARENT_STEP_PID, " +
"SCRIPT_GROUP_KEY, " +
"SCRIPT_KEY, " +
"PARAMS_SET_KEY, " +
"THIS_PARAMS_KEY, " +
"DEFLT_PARAMS_KEY, " +
"DISPLAY_ORDER, " +
"SHOW FROM PUBLIC.SUBSTN_COMMONS WHERE SUBSTN_COMMON_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SUBSTN_COMMON_PID, " +  
"IS_SYSTEM, " +  
"SUBSTN_TYPE_KEY, " +  
"PARENT_STEP_PID, " +  
"SCRIPT_GROUP_KEY, " +  
"SCRIPT_KEY, " +  
"PARAMS_SET_KEY, " +  
"THIS_PARAMS_KEY, " +  
"DEFLT_PARAMS_KEY, " +  
"DISPLAY_ORDER, " +  
"SHOW FROM PUBLIC.SUBSTN_COMMONS";

private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_COMMONS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SUBSTN_COMMON_PID, " +     
"IS_SYSTEM, " +     
"SUBSTN_TYPE_KEY, " +     
"PARENT_STEP_PID, " +     
"SCRIPT_GROUP_KEY, " +     
"SCRIPT_KEY, " +     
"PARAMS_SET_KEY, " +     
"THIS_PARAMS_KEY, " +     
"DEFLT_PARAMS_KEY, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_COMMONSSET " +
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
"DISPLAY_ORDER = ?, " + 
"SHOW = ? WHERE SUBSTN_COMMON_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_COMMONS WHERE SUBSTN_COMMON_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_COMMONS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SubstnCommonPid;
private boolean IsSystem;
private short SubstnTypeKey;
private int ParentStepPid;
private short ScriptGroupKey;
private short ScriptKey;
private short ParamsSetKey;
private short ThisParamsKey;
private short DefltParamsKey;
private short DisplayOrder;
private boolean Show;
private SubstnCommons model;

public SubstnCommons() throws SQLException {
}


public SubstnCommons(int SubstnCommonPid) throws SQLException {
super();
this.SubstnCommonPid = SubstnCommonPid;
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
model = new SubstnCommons();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSubstnCommonPid(rs.getInt("SUBSTN_COMMON_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setSubstnTypeKey(rs.getShort("SUBSTN_TYPE_KEY"));
model.setParentStepPid(rs.getInt("PARENT_STEP_PID"));
model.setScriptGroupKey(rs.getShort("SCRIPT_GROUP_KEY"));
model.setScriptKey(rs.getShort("SCRIPT_KEY"));
model.setParamsSetKey(rs.getShort("PARAMS_SET_KEY"));
model.setThisParamsKey(rs.getShort("THIS_PARAMS_KEY"));
model.setDefltParamsKey(rs.getShort("DEFLT_PARAMS_KEY"));
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
model.setSubstnCommonPid(rs.getInt("SUBSTN_COMMON_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setSubstnTypeKey(rs.getShort("SUBSTN_TYPE_KEY"));
model.setParentStepPid(rs.getInt("PARENT_STEP_PID"));
model.setScriptGroupKey(rs.getShort("SCRIPT_GROUP_KEY"));
model.setScriptKey(rs.getShort("SCRIPT_KEY"));
model.setParamsSetKey(rs.getShort("PARAMS_SET_KEY"));
model.setThisParamsKey(rs.getShort("THIS_PARAMS_KEY"));
model.setDefltParamsKey(rs.getShort("DEFLT_PARAMS_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setShow(rs.getBoolean("SHOW"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((SubstnCommons) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubstnCommons) model).setSetKey(rs.getShort("SET_KEY"));
((SubstnCommons) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubstnCommons) model).setSubstnCommonPid(rs.getInt("SUBSTN_COMMON_PID"));
((SubstnCommons) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SubstnCommons) model).setSubstnTypeKey(rs.getShort("SUBSTN_TYPE_KEY"));
((SubstnCommons) model).setParentStepPid(rs.getInt("PARENT_STEP_PID"));
((SubstnCommons) model).setScriptGroupKey(rs.getShort("SCRIPT_GROUP_KEY"));
((SubstnCommons) model).setScriptKey(rs.getShort("SCRIPT_KEY"));
((SubstnCommons) model).setParamsSetKey(rs.getShort("PARAMS_SET_KEY"));
((SubstnCommons) model).setThisParamsKey(rs.getShort("THIS_PARAMS_KEY"));
((SubstnCommons) model).setDefltParamsKey(rs.getShort("DEFLT_PARAMS_KEY"));
((SubstnCommons) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SubstnCommons) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((SubstnCommons) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubstnCommons) model).setSetKey(rs.getShort("SET_KEY"));
((SubstnCommons) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubstnCommons) model).setSubstnCommonPid(rs.getInt("SUBSTN_COMMON_PID"));
((SubstnCommons) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SubstnCommons) model).setSubstnTypeKey(rs.getShort("SUBSTN_TYPE_KEY"));
((SubstnCommons) model).setParentStepPid(rs.getInt("PARENT_STEP_PID"));
((SubstnCommons) model).setScriptGroupKey(rs.getShort("SCRIPT_GROUP_KEY"));
((SubstnCommons) model).setScriptKey(rs.getShort("SCRIPT_KEY"));
((SubstnCommons) model).setParamsSetKey(rs.getShort("PARAMS_SET_KEY"));
((SubstnCommons) model).setThisParamsKey(rs.getShort("THIS_PARAMS_KEY"));
((SubstnCommons) model).setDefltParamsKey(rs.getShort("DEFLT_PARAMS_KEY"));
((SubstnCommons) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SubstnCommons) model).setShow(rs.getBoolean("SHOW"));
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

public int getSubstnCommonPid() {
return this.SubstnCommonPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public short getSubstnTypeKey() {
return this.SubstnTypeKey;
}

public int getParentStepPid() {
return this.ParentStepPid;
}

public short getScriptGroupKey() {
return this.ScriptGroupKey;
}

public short getScriptKey() {
return this.ScriptKey;
}

public short getParamsSetKey() {
return this.ParamsSetKey;
}

public short getThisParamsKey() {
return this.ThisParamsKey;
}

public short getDefltParamsKey() {
return this.DefltParamsKey;
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

public void setSubstnCommonPid(int SubstnCommonPid) {
this.SubstnCommonPid = SubstnCommonPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setSubstnTypeKey(short SubstnTypeKey) {
this.SubstnTypeKey = SubstnTypeKey;
}

public void setParentStepPid(int ParentStepPid) {
this.ParentStepPid = ParentStepPid;
}

public void setScriptGroupKey(short ScriptGroupKey) {
this.ScriptGroupKey = ScriptGroupKey;
}

public void setScriptKey(short ScriptKey) {
this.ScriptKey = ScriptKey;
}

public void setParamsSetKey(short ParamsSetKey) {
this.ParamsSetKey = ParamsSetKey;
}

public void setThisParamsKey(short ThisParamsKey) {
this.ThisParamsKey = ThisParamsKey;
}

public void setDefltParamsKey(short DefltParamsKey) {
this.DefltParamsKey = DefltParamsKey;
}

public void setDisplayOrder(short DisplayOrder) {
this.DisplayOrder = DisplayOrder;
}

public void setShow(boolean Show) {
this.Show = Show;
}

}

