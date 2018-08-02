package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSTN_STEPS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SubstnSteps extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SUBSTN_STEP_PID, " +
"IS_SYSTEM, " +
"PARENT_IS_DATA_ALIAS, " +
"OWNER_TYPE_KEY, " +
"OWNER_SUB_TYPE_KEY, " +
"OWNER_PID, " +
"PARENT_STEP_PID, " +
"PLAIN_TEXT, " +
"NORMAL_START_STEP_PID, " +
"FALSE_START_STEP_PID, " +
"ERROR_STEP_PID, " +
"PRIOR_STEP_PID, " +
"NEXT_STEP_PID, " +
"IS_TEMPLATE_STEP_TYPE, " +
"IS_FILTER_STEP_TYPE, " +
"STEP_TYPE_KEY, " +
"PARAM_LIST_KEY FROM PUBLIC.SUBSTN_STEPS WHERE SUBSTN_STEP_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SUBSTN_STEP_PID, " +  
"IS_SYSTEM, " +  
"PARENT_IS_DATA_ALIAS, " +  
"OWNER_TYPE_KEY, " +  
"OWNER_SUB_TYPE_KEY, " +  
"OWNER_PID, " +  
"PARENT_STEP_PID, " +  
"PLAIN_TEXT, " +  
"NORMAL_START_STEP_PID, " +  
"FALSE_START_STEP_PID, " +  
"ERROR_STEP_PID, " +  
"PRIOR_STEP_PID, " +  
"NEXT_STEP_PID, " +  
"IS_TEMPLATE_STEP_TYPE, " +  
"IS_FILTER_STEP_TYPE, " +  
"STEP_TYPE_KEY, " +  
"PARAM_LIST_KEY FROM PUBLIC.SUBSTN_STEPS";

private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_STEPS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SUBSTN_STEP_PID, " +     
"IS_SYSTEM, " +     
"PARENT_IS_DATA_ALIAS, " +     
"OWNER_TYPE_KEY, " +     
"OWNER_SUB_TYPE_KEY, " +     
"OWNER_PID, " +     
"PARENT_STEP_PID, " +     
"PLAIN_TEXT, " +     
"NORMAL_START_STEP_PID, " +     
"FALSE_START_STEP_PID, " +     
"ERROR_STEP_PID, " +     
"PRIOR_STEP_PID, " +     
"NEXT_STEP_PID, " +     
"IS_TEMPLATE_STEP_TYPE, " +     
"IS_FILTER_STEP_TYPE, " +     
"STEP_TYPE_KEY, " +     
"PARAM_LIST_KEY) VALUES (?, " +
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
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_STEPSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PARENT_IS_DATA_ALIAS = ?, " + 
"OWNER_TYPE_KEY = ?, " + 
"OWNER_SUB_TYPE_KEY = ?, " + 
"OWNER_PID = ?, " + 
"PARENT_STEP_PID = ?, " + 
"PLAIN_TEXT = ?, " + 
"NORMAL_START_STEP_PID = ?, " + 
"FALSE_START_STEP_PID = ?, " + 
"ERROR_STEP_PID = ?, " + 
"PRIOR_STEP_PID = ?, " + 
"NEXT_STEP_PID = ?, " + 
"IS_TEMPLATE_STEP_TYPE = ?, " + 
"IS_FILTER_STEP_TYPE = ?, " + 
"STEP_TYPE_KEY = ?, " + 
"PARAM_LIST_KEY = ? WHERE SUBSTN_STEP_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_STEPS WHERE SUBSTN_STEP_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_STEPS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SubstnStepPid;
private boolean IsSystem;
private boolean ParentIsDataAlias;
private short OwnerTypeKey;
private int OwnerSubTypeKey;
private int OwnerPid;
private int ParentStepPid;
private String PlainText;
private int NormalStartStepPid;
private int FalseStartStepPid;
private int ErrorStepPid;
private int PriorStepPid;
private int NextStepPid;
private boolean IsTemplateStepType;
private boolean IsFilterStepType;
private short StepTypeKey;
private short ParamListKey;
private SubstnSteps model;

public SubstnSteps() throws SQLException {
}


public SubstnSteps(int SubstnStepPid) throws SQLException {
super();
this.SubstnStepPid = SubstnStepPid;
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
model = new SubstnSteps();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSubstnStepPid(rs.getInt("SUBSTN_STEP_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentIsDataAlias(rs.getBoolean("PARENT_IS_DATA_ALIAS"));
model.setOwnerTypeKey(rs.getShort("OWNER_TYPE_KEY"));
model.setOwnerSubTypeKey(rs.getInt("OWNER_SUB_TYPE_KEY"));
model.setOwnerPid(rs.getInt("OWNER_PID"));
model.setParentStepPid(rs.getInt("PARENT_STEP_PID"));
model.setPlainText(rs.getString("PLAIN_TEXT"));
model.setNormalStartStepPid(rs.getInt("NORMAL_START_STEP_PID"));
model.setFalseStartStepPid(rs.getInt("FALSE_START_STEP_PID"));
model.setErrorStepPid(rs.getInt("ERROR_STEP_PID"));
model.setPriorStepPid(rs.getInt("PRIOR_STEP_PID"));
model.setNextStepPid(rs.getInt("NEXT_STEP_PID"));
model.setIsTemplateStepType(rs.getBoolean("IS_TEMPLATE_STEP_TYPE"));
model.setIsFilterStepType(rs.getBoolean("IS_FILTER_STEP_TYPE"));
model.setStepTypeKey(rs.getShort("STEP_TYPE_KEY"));
model.setParamListKey(rs.getShort("PARAM_LIST_KEY"));
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
model.setSubstnStepPid(rs.getInt("SUBSTN_STEP_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentIsDataAlias(rs.getBoolean("PARENT_IS_DATA_ALIAS"));
model.setOwnerTypeKey(rs.getShort("OWNER_TYPE_KEY"));
model.setOwnerSubTypeKey(rs.getInt("OWNER_SUB_TYPE_KEY"));
model.setOwnerPid(rs.getInt("OWNER_PID"));
model.setParentStepPid(rs.getInt("PARENT_STEP_PID"));
model.setPlainText(rs.getString("PLAIN_TEXT"));
model.setNormalStartStepPid(rs.getInt("NORMAL_START_STEP_PID"));
model.setFalseStartStepPid(rs.getInt("FALSE_START_STEP_PID"));
model.setErrorStepPid(rs.getInt("ERROR_STEP_PID"));
model.setPriorStepPid(rs.getInt("PRIOR_STEP_PID"));
model.setNextStepPid(rs.getInt("NEXT_STEP_PID"));
model.setIsTemplateStepType(rs.getBoolean("IS_TEMPLATE_STEP_TYPE"));
model.setIsFilterStepType(rs.getBoolean("IS_FILTER_STEP_TYPE"));
model.setStepTypeKey(rs.getShort("STEP_TYPE_KEY"));
model.setParamListKey(rs.getShort("PARAM_LIST_KEY"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((SubstnSteps) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubstnSteps) model).setSetKey(rs.getShort("SET_KEY"));
((SubstnSteps) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubstnSteps) model).setSubstnStepPid(rs.getInt("SUBSTN_STEP_PID"));
((SubstnSteps) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SubstnSteps) model).setParentIsDataAlias(rs.getBoolean("PARENT_IS_DATA_ALIAS"));
((SubstnSteps) model).setOwnerTypeKey(rs.getShort("OWNER_TYPE_KEY"));
((SubstnSteps) model).setOwnerSubTypeKey(rs.getInt("OWNER_SUB_TYPE_KEY"));
((SubstnSteps) model).setOwnerPid(rs.getInt("OWNER_PID"));
((SubstnSteps) model).setParentStepPid(rs.getInt("PARENT_STEP_PID"));
((SubstnSteps) model).setPlainText(rs.getString("PLAIN_TEXT"));
((SubstnSteps) model).setNormalStartStepPid(rs.getInt("NORMAL_START_STEP_PID"));
((SubstnSteps) model).setFalseStartStepPid(rs.getInt("FALSE_START_STEP_PID"));
((SubstnSteps) model).setErrorStepPid(rs.getInt("ERROR_STEP_PID"));
((SubstnSteps) model).setPriorStepPid(rs.getInt("PRIOR_STEP_PID"));
((SubstnSteps) model).setNextStepPid(rs.getInt("NEXT_STEP_PID"));
((SubstnSteps) model).setIsTemplateStepType(rs.getBoolean("IS_TEMPLATE_STEP_TYPE"));
((SubstnSteps) model).setIsFilterStepType(rs.getBoolean("IS_FILTER_STEP_TYPE"));
((SubstnSteps) model).setStepTypeKey(rs.getShort("STEP_TYPE_KEY"));
((SubstnSteps) model).setParamListKey(rs.getShort("PARAM_LIST_KEY"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((SubstnSteps) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubstnSteps) model).setSetKey(rs.getShort("SET_KEY"));
((SubstnSteps) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubstnSteps) model).setSubstnStepPid(rs.getInt("SUBSTN_STEP_PID"));
((SubstnSteps) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SubstnSteps) model).setParentIsDataAlias(rs.getBoolean("PARENT_IS_DATA_ALIAS"));
((SubstnSteps) model).setOwnerTypeKey(rs.getShort("OWNER_TYPE_KEY"));
((SubstnSteps) model).setOwnerSubTypeKey(rs.getInt("OWNER_SUB_TYPE_KEY"));
((SubstnSteps) model).setOwnerPid(rs.getInt("OWNER_PID"));
((SubstnSteps) model).setParentStepPid(rs.getInt("PARENT_STEP_PID"));
((SubstnSteps) model).setPlainText(rs.getString("PLAIN_TEXT"));
((SubstnSteps) model).setNormalStartStepPid(rs.getInt("NORMAL_START_STEP_PID"));
((SubstnSteps) model).setFalseStartStepPid(rs.getInt("FALSE_START_STEP_PID"));
((SubstnSteps) model).setErrorStepPid(rs.getInt("ERROR_STEP_PID"));
((SubstnSteps) model).setPriorStepPid(rs.getInt("PRIOR_STEP_PID"));
((SubstnSteps) model).setNextStepPid(rs.getInt("NEXT_STEP_PID"));
((SubstnSteps) model).setIsTemplateStepType(rs.getBoolean("IS_TEMPLATE_STEP_TYPE"));
((SubstnSteps) model).setIsFilterStepType(rs.getBoolean("IS_FILTER_STEP_TYPE"));
((SubstnSteps) model).setStepTypeKey(rs.getShort("STEP_TYPE_KEY"));
((SubstnSteps) model).setParamListKey(rs.getShort("PARAM_LIST_KEY"));
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

public int getSubstnStepPid() {
return this.SubstnStepPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public boolean getParentIsDataAlias() {
return this.ParentIsDataAlias;
}

public short getOwnerTypeKey() {
return this.OwnerTypeKey;
}

public int getOwnerSubTypeKey() {
return this.OwnerSubTypeKey;
}

public int getOwnerPid() {
return this.OwnerPid;
}

public int getParentStepPid() {
return this.ParentStepPid;
}

public String getPlainText() {
return this.PlainText;
}

public int getNormalStartStepPid() {
return this.NormalStartStepPid;
}

public int getFalseStartStepPid() {
return this.FalseStartStepPid;
}

public int getErrorStepPid() {
return this.ErrorStepPid;
}

public int getPriorStepPid() {
return this.PriorStepPid;
}

public int getNextStepPid() {
return this.NextStepPid;
}

public boolean getIsTemplateStepType() {
return this.IsTemplateStepType;
}

public boolean getIsFilterStepType() {
return this.IsFilterStepType;
}

public short getStepTypeKey() {
return this.StepTypeKey;
}

public short getParamListKey() {
return this.ParamListKey;
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

public void setSubstnStepPid(int SubstnStepPid) {
this.SubstnStepPid = SubstnStepPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setParentIsDataAlias(boolean ParentIsDataAlias) {
this.ParentIsDataAlias = ParentIsDataAlias;
}

public void setOwnerTypeKey(short OwnerTypeKey) {
this.OwnerTypeKey = OwnerTypeKey;
}

public void setOwnerSubTypeKey(int OwnerSubTypeKey) {
this.OwnerSubTypeKey = OwnerSubTypeKey;
}

public void setOwnerPid(int OwnerPid) {
this.OwnerPid = OwnerPid;
}

public void setParentStepPid(int ParentStepPid) {
this.ParentStepPid = ParentStepPid;
}

public void setPlainText(String PlainText) {
this.PlainText = PlainText;
}

public void setNormalStartStepPid(int NormalStartStepPid) {
this.NormalStartStepPid = NormalStartStepPid;
}

public void setFalseStartStepPid(int FalseStartStepPid) {
this.FalseStartStepPid = FalseStartStepPid;
}

public void setErrorStepPid(int ErrorStepPid) {
this.ErrorStepPid = ErrorStepPid;
}

public void setPriorStepPid(int PriorStepPid) {
this.PriorStepPid = PriorStepPid;
}

public void setNextStepPid(int NextStepPid) {
this.NextStepPid = NextStepPid;
}

public void setIsTemplateStepType(boolean IsTemplateStepType) {
this.IsTemplateStepType = IsTemplateStepType;
}

public void setIsFilterStepType(boolean IsFilterStepType) {
this.IsFilterStepType = IsFilterStepType;
}

public void setStepTypeKey(short StepTypeKey) {
this.StepTypeKey = StepTypeKey;
}

public void setParamListKey(short ParamListKey) {
this.ParamListKey = ParamListKey;
}

}

