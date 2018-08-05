package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSTN_STEPS database table.
*
* @version 2018-08-05
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

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public SubstnSteps() throws SQLException {
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
public SubstnSteps get(int key) throws SQLException {
model = new SubstnSteps();
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
return model;
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
* Get the SubstnStepPid field.
*
* @return Contents of the SUBSTN_STEP_PID column
*/
public int getSubstnStepPid() {
return this.SubstnStepPid;
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
* Get the ParentIsDataAlias field.
*
* @return Contents of the PARENT_IS_DATA_ALIAS column
*/
public boolean getParentIsDataAlias() {
return this.ParentIsDataAlias;
}

/**
* Get the OwnerTypeKey field.
*
* @return Contents of the OWNER_TYPE_KEY column
*/
public short getOwnerTypeKey() {
return this.OwnerTypeKey;
}

/**
* Get the OwnerSubTypeKey field.
*
* @return Contents of the OWNER_SUB_TYPE_KEY column
*/
public int getOwnerSubTypeKey() {
return this.OwnerSubTypeKey;
}

/**
* Get the OwnerPid field.
*
* @return Contents of the OWNER_PID column
*/
public int getOwnerPid() {
return this.OwnerPid;
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
* Get the PlainText field.
*
* @return Contents of the PLAIN_TEXT column
*/
public String getPlainText() {
return this.PlainText;
}

/**
* Get the NormalStartStepPid field.
*
* @return Contents of the NORMAL_START_STEP_PID column
*/
public int getNormalStartStepPid() {
return this.NormalStartStepPid;
}

/**
* Get the FalseStartStepPid field.
*
* @return Contents of the FALSE_START_STEP_PID column
*/
public int getFalseStartStepPid() {
return this.FalseStartStepPid;
}

/**
* Get the ErrorStepPid field.
*
* @return Contents of the ERROR_STEP_PID column
*/
public int getErrorStepPid() {
return this.ErrorStepPid;
}

/**
* Get the PriorStepPid field.
*
* @return Contents of the PRIOR_STEP_PID column
*/
public int getPriorStepPid() {
return this.PriorStepPid;
}

/**
* Get the NextStepPid field.
*
* @return Contents of the NEXT_STEP_PID column
*/
public int getNextStepPid() {
return this.NextStepPid;
}

/**
* Get the IsTemplateStepType field.
*
* @return Contents of the IS_TEMPLATE_STEP_TYPE column
*/
public boolean getIsTemplateStepType() {
return this.IsTemplateStepType;
}

/**
* Get the IsFilterStepType field.
*
* @return Contents of the IS_FILTER_STEP_TYPE column
*/
public boolean getIsFilterStepType() {
return this.IsFilterStepType;
}

/**
* Get the StepTypeKey field.
*
* @return Contents of the STEP_TYPE_KEY column
*/
public short getStepTypeKey() {
return this.StepTypeKey;
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
* Set the SubstnStepPid field
*
* @param SubstnStepPid Contents of the SUBSTN_STEP_PID column
*/
public void setSubstnStepPid(int SubstnStepPid) {
this.SubstnStepPid = SubstnStepPid;
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
* Set the ParentIsDataAlias field
*
* @param ParentIsDataAlias Contents of the PARENT_IS_DATA_ALIAS column
*/
public void setParentIsDataAlias(boolean ParentIsDataAlias) {
this.ParentIsDataAlias = ParentIsDataAlias;
}

/**
* Set the OwnerTypeKey field
*
* @param OwnerTypeKey Contents of the OWNER_TYPE_KEY column
*/
public void setOwnerTypeKey(short OwnerTypeKey) {
this.OwnerTypeKey = OwnerTypeKey;
}

/**
* Set the OwnerSubTypeKey field
*
* @param OwnerSubTypeKey Contents of the OWNER_SUB_TYPE_KEY column
*/
public void setOwnerSubTypeKey(int OwnerSubTypeKey) {
this.OwnerSubTypeKey = OwnerSubTypeKey;
}

/**
* Set the OwnerPid field
*
* @param OwnerPid Contents of the OWNER_PID column
*/
public void setOwnerPid(int OwnerPid) {
this.OwnerPid = OwnerPid;
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
* Set the PlainText field
*
* @param PlainText Contents of the PLAIN_TEXT column
*/
public void setPlainText(String PlainText) {
this.PlainText = PlainText;
}

/**
* Set the NormalStartStepPid field
*
* @param NormalStartStepPid Contents of the NORMAL_START_STEP_PID column
*/
public void setNormalStartStepPid(int NormalStartStepPid) {
this.NormalStartStepPid = NormalStartStepPid;
}

/**
* Set the FalseStartStepPid field
*
* @param FalseStartStepPid Contents of the FALSE_START_STEP_PID column
*/
public void setFalseStartStepPid(int FalseStartStepPid) {
this.FalseStartStepPid = FalseStartStepPid;
}

/**
* Set the ErrorStepPid field
*
* @param ErrorStepPid Contents of the ERROR_STEP_PID column
*/
public void setErrorStepPid(int ErrorStepPid) {
this.ErrorStepPid = ErrorStepPid;
}

/**
* Set the PriorStepPid field
*
* @param PriorStepPid Contents of the PRIOR_STEP_PID column
*/
public void setPriorStepPid(int PriorStepPid) {
this.PriorStepPid = PriorStepPid;
}

/**
* Set the NextStepPid field
*
* @param NextStepPid Contents of the NEXT_STEP_PID column
*/
public void setNextStepPid(int NextStepPid) {
this.NextStepPid = NextStepPid;
}

/**
* Set the IsTemplateStepType field
*
* @param IsTemplateStepType Contents of the IS_TEMPLATE_STEP_TYPE column
*/
public void setIsTemplateStepType(boolean IsTemplateStepType) {
this.IsTemplateStepType = IsTemplateStepType;
}

/**
* Set the IsFilterStepType field
*
* @param IsFilterStepType Contents of the IS_FILTER_STEP_TYPE column
*/
public void setIsFilterStepType(boolean IsFilterStepType) {
this.IsFilterStepType = IsFilterStepType;
}

/**
* Set the StepTypeKey field
*
* @param StepTypeKey Contents of the STEP_TYPE_KEY column
*/
public void setStepTypeKey(short StepTypeKey) {
this.StepTypeKey = StepTypeKey;
}

/**
* Set the ParamListKey field
*
* @param ParamListKey Contents of the PARAM_LIST_KEY column
*/
public void setParamListKey(short ParamListKey) {
this.ParamListKey = ParamListKey;
}

}

