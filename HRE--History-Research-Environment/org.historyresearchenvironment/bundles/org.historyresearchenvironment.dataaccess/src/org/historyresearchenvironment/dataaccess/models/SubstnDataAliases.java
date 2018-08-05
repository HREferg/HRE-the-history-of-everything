package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSTN_DATA_ALIASES database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SubstnDataAliases extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SUBSTN_DATA_ALIAS_PID, " +
"IS_SYSTEM, " +
"IS_COMPLETE, " +
"IS_HEAD_ONLY, " +
"IS_HEAD_LINK_ONLY, " +
"IS_LINK_ONLY, " +
"IS_LINK_OUTPUT_ONLY, " +
"IS_OUTPUT_ONLY, " +
"TOP_STEP_KEY, " +
"REQUESTER_TYPE_KEY, " +
"REQUESTER_SUB_TYPE_KEY, " +
"OUTPUT_TYPE_KEY, " +
"OUTPUT_SUB_TYPE_KEY, " +
"PARAM_LIST_KEY, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"SHOW FROM PUBLIC.SUBSTN_DATA_ALIASES WHERE SUBSTN_DATA_ALIAS_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SUBSTN_DATA_ALIAS_PID, " +  
"IS_SYSTEM, " +  
"IS_COMPLETE, " +  
"IS_HEAD_ONLY, " +  
"IS_HEAD_LINK_ONLY, " +  
"IS_LINK_ONLY, " +  
"IS_LINK_OUTPUT_ONLY, " +  
"IS_OUTPUT_ONLY, " +  
"TOP_STEP_KEY, " +  
"REQUESTER_TYPE_KEY, " +  
"REQUESTER_SUB_TYPE_KEY, " +  
"OUTPUT_TYPE_KEY, " +  
"OUTPUT_SUB_TYPE_KEY, " +  
"PARAM_LIST_KEY, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"SHOW FROM PUBLIC.SUBSTN_DATA_ALIASES";

private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_DATA_ALIASES( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SUBSTN_DATA_ALIAS_PID, " +     
"IS_SYSTEM, " +     
"IS_COMPLETE, " +     
"IS_HEAD_ONLY, " +     
"IS_HEAD_LINK_ONLY, " +     
"IS_LINK_ONLY, " +     
"IS_LINK_OUTPUT_ONLY, " +     
"IS_OUTPUT_ONLY, " +     
"TOP_STEP_KEY, " +     
"REQUESTER_TYPE_KEY, " +     
"REQUESTER_SUB_TYPE_KEY, " +     
"OUTPUT_TYPE_KEY, " +     
"OUTPUT_SUB_TYPE_KEY, " +     
"PARAM_LIST_KEY, " +     
"REMINDER_KEY, " +     
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
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_DATA_ALIASESSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"IS_COMPLETE = ?, " + 
"IS_HEAD_ONLY = ?, " + 
"IS_HEAD_LINK_ONLY = ?, " + 
"IS_LINK_ONLY = ?, " + 
"IS_LINK_OUTPUT_ONLY = ?, " + 
"IS_OUTPUT_ONLY = ?, " + 
"TOP_STEP_KEY = ?, " + 
"REQUESTER_TYPE_KEY = ?, " + 
"REQUESTER_SUB_TYPE_KEY = ?, " + 
"OUTPUT_TYPE_KEY = ?, " + 
"OUTPUT_SUB_TYPE_KEY = ?, " + 
"PARAM_LIST_KEY = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"SHOW = ? WHERE SUBSTN_DATA_ALIAS_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_DATA_ALIASES WHERE SUBSTN_DATA_ALIAS_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_DATA_ALIASES";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SubstnDataAliasPid;
private boolean IsSystem;
private boolean IsComplete;
private boolean IsHeadOnly;
private boolean IsHeadLinkOnly;
private boolean IsLinkOnly;
private boolean IsLinkOutputOnly;
private boolean IsOutputOnly;
private short TopStepKey;
private short RequesterTypeKey;
private short RequesterSubTypeKey;
private short OutputTypeKey;
private short OutputSubTypeKey;
private short ParamListKey;
private short ReminderKey;
private short DisplayOrder;
private boolean Show;
private SubstnDataAliases model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public SubstnDataAliases() throws SQLException {
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
model = new SubstnDataAliases();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSubstnDataAliasPid(rs.getInt("SUBSTN_DATA_ALIAS_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setIsComplete(rs.getBoolean("IS_COMPLETE"));
model.setIsHeadOnly(rs.getBoolean("IS_HEAD_ONLY"));
model.setIsHeadLinkOnly(rs.getBoolean("IS_HEAD_LINK_ONLY"));
model.setIsLinkOnly(rs.getBoolean("IS_LINK_ONLY"));
model.setIsLinkOutputOnly(rs.getBoolean("IS_LINK_OUTPUT_ONLY"));
model.setIsOutputOnly(rs.getBoolean("IS_OUTPUT_ONLY"));
model.setTopStepKey(rs.getShort("TOP_STEP_KEY"));
model.setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
model.setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
model.setOutputTypeKey(rs.getShort("OUTPUT_TYPE_KEY"));
model.setOutputSubTypeKey(rs.getShort("OUTPUT_SUB_TYPE_KEY"));
model.setParamListKey(rs.getShort("PARAM_LIST_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public SubstnDataAliases get(int key) throws SQLException {
model = new SubstnDataAliases();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSubstnDataAliasPid(rs.getInt("SUBSTN_DATA_ALIAS_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setIsComplete(rs.getBoolean("IS_COMPLETE"));
model.setIsHeadOnly(rs.getBoolean("IS_HEAD_ONLY"));
model.setIsHeadLinkOnly(rs.getBoolean("IS_HEAD_LINK_ONLY"));
model.setIsLinkOnly(rs.getBoolean("IS_LINK_ONLY"));
model.setIsLinkOutputOnly(rs.getBoolean("IS_LINK_OUTPUT_ONLY"));
model.setIsOutputOnly(rs.getBoolean("IS_OUTPUT_ONLY"));
model.setTopStepKey(rs.getShort("TOP_STEP_KEY"));
model.setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
model.setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
model.setOutputTypeKey(rs.getShort("OUTPUT_TYPE_KEY"));
model.setOutputSubTypeKey(rs.getShort("OUTPUT_SUB_TYPE_KEY"));
model.setParamListKey(rs.getShort("PARAM_LIST_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setShow(rs.getBoolean("SHOW"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((SubstnDataAliases) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubstnDataAliases) model).setSetKey(rs.getShort("SET_KEY"));
((SubstnDataAliases) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubstnDataAliases) model).setSubstnDataAliasPid(rs.getInt("SUBSTN_DATA_ALIAS_PID"));
((SubstnDataAliases) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SubstnDataAliases) model).setIsComplete(rs.getBoolean("IS_COMPLETE"));
((SubstnDataAliases) model).setIsHeadOnly(rs.getBoolean("IS_HEAD_ONLY"));
((SubstnDataAliases) model).setIsHeadLinkOnly(rs.getBoolean("IS_HEAD_LINK_ONLY"));
((SubstnDataAliases) model).setIsLinkOnly(rs.getBoolean("IS_LINK_ONLY"));
((SubstnDataAliases) model).setIsLinkOutputOnly(rs.getBoolean("IS_LINK_OUTPUT_ONLY"));
((SubstnDataAliases) model).setIsOutputOnly(rs.getBoolean("IS_OUTPUT_ONLY"));
((SubstnDataAliases) model).setTopStepKey(rs.getShort("TOP_STEP_KEY"));
((SubstnDataAliases) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
((SubstnDataAliases) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
((SubstnDataAliases) model).setOutputTypeKey(rs.getShort("OUTPUT_TYPE_KEY"));
((SubstnDataAliases) model).setOutputSubTypeKey(rs.getShort("OUTPUT_SUB_TYPE_KEY"));
((SubstnDataAliases) model).setParamListKey(rs.getShort("PARAM_LIST_KEY"));
((SubstnDataAliases) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SubstnDataAliases) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SubstnDataAliases) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((SubstnDataAliases) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubstnDataAliases) model).setSetKey(rs.getShort("SET_KEY"));
((SubstnDataAliases) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubstnDataAliases) model).setSubstnDataAliasPid(rs.getInt("SUBSTN_DATA_ALIAS_PID"));
((SubstnDataAliases) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SubstnDataAliases) model).setIsComplete(rs.getBoolean("IS_COMPLETE"));
((SubstnDataAliases) model).setIsHeadOnly(rs.getBoolean("IS_HEAD_ONLY"));
((SubstnDataAliases) model).setIsHeadLinkOnly(rs.getBoolean("IS_HEAD_LINK_ONLY"));
((SubstnDataAliases) model).setIsLinkOnly(rs.getBoolean("IS_LINK_ONLY"));
((SubstnDataAliases) model).setIsLinkOutputOnly(rs.getBoolean("IS_LINK_OUTPUT_ONLY"));
((SubstnDataAliases) model).setIsOutputOnly(rs.getBoolean("IS_OUTPUT_ONLY"));
((SubstnDataAliases) model).setTopStepKey(rs.getShort("TOP_STEP_KEY"));
((SubstnDataAliases) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
((SubstnDataAliases) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
((SubstnDataAliases) model).setOutputTypeKey(rs.getShort("OUTPUT_TYPE_KEY"));
((SubstnDataAliases) model).setOutputSubTypeKey(rs.getShort("OUTPUT_SUB_TYPE_KEY"));
((SubstnDataAliases) model).setParamListKey(rs.getShort("PARAM_LIST_KEY"));
((SubstnDataAliases) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SubstnDataAliases) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SubstnDataAliases) model).setShow(rs.getBoolean("SHOW"));
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
* Get the SubstnDataAliasPid field.
*
* @return Contents of the SUBSTN_DATA_ALIAS_PID column
*/
public int getSubstnDataAliasPid() {
return this.SubstnDataAliasPid;
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
* Get the IsComplete field.
*
* @return Contents of the IS_COMPLETE column
*/
public boolean getIsComplete() {
return this.IsComplete;
}

/**
* Get the IsHeadOnly field.
*
* @return Contents of the IS_HEAD_ONLY column
*/
public boolean getIsHeadOnly() {
return this.IsHeadOnly;
}

/**
* Get the IsHeadLinkOnly field.
*
* @return Contents of the IS_HEAD_LINK_ONLY column
*/
public boolean getIsHeadLinkOnly() {
return this.IsHeadLinkOnly;
}

/**
* Get the IsLinkOnly field.
*
* @return Contents of the IS_LINK_ONLY column
*/
public boolean getIsLinkOnly() {
return this.IsLinkOnly;
}

/**
* Get the IsLinkOutputOnly field.
*
* @return Contents of the IS_LINK_OUTPUT_ONLY column
*/
public boolean getIsLinkOutputOnly() {
return this.IsLinkOutputOnly;
}

/**
* Get the IsOutputOnly field.
*
* @return Contents of the IS_OUTPUT_ONLY column
*/
public boolean getIsOutputOnly() {
return this.IsOutputOnly;
}

/**
* Get the TopStepKey field.
*
* @return Contents of the TOP_STEP_KEY column
*/
public short getTopStepKey() {
return this.TopStepKey;
}

/**
* Get the RequesterTypeKey field.
*
* @return Contents of the REQUESTER_TYPE_KEY column
*/
public short getRequesterTypeKey() {
return this.RequesterTypeKey;
}

/**
* Get the RequesterSubTypeKey field.
*
* @return Contents of the REQUESTER_SUB_TYPE_KEY column
*/
public short getRequesterSubTypeKey() {
return this.RequesterSubTypeKey;
}

/**
* Get the OutputTypeKey field.
*
* @return Contents of the OUTPUT_TYPE_KEY column
*/
public short getOutputTypeKey() {
return this.OutputTypeKey;
}

/**
* Get the OutputSubTypeKey field.
*
* @return Contents of the OUTPUT_SUB_TYPE_KEY column
*/
public short getOutputSubTypeKey() {
return this.OutputSubTypeKey;
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
* Get the ReminderKey field.
*
* @return Contents of the REMINDER_KEY column
*/
public short getReminderKey() {
return this.ReminderKey;
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
* Set the SubstnDataAliasPid field
*
* @param SubstnDataAliasPid Contents of the SUBSTN_DATA_ALIAS_PID column
*/
public void setSubstnDataAliasPid(int SubstnDataAliasPid) {
this.SubstnDataAliasPid = SubstnDataAliasPid;
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
* Set the IsComplete field
*
* @param IsComplete Contents of the IS_COMPLETE column
*/
public void setIsComplete(boolean IsComplete) {
this.IsComplete = IsComplete;
}

/**
* Set the IsHeadOnly field
*
* @param IsHeadOnly Contents of the IS_HEAD_ONLY column
*/
public void setIsHeadOnly(boolean IsHeadOnly) {
this.IsHeadOnly = IsHeadOnly;
}

/**
* Set the IsHeadLinkOnly field
*
* @param IsHeadLinkOnly Contents of the IS_HEAD_LINK_ONLY column
*/
public void setIsHeadLinkOnly(boolean IsHeadLinkOnly) {
this.IsHeadLinkOnly = IsHeadLinkOnly;
}

/**
* Set the IsLinkOnly field
*
* @param IsLinkOnly Contents of the IS_LINK_ONLY column
*/
public void setIsLinkOnly(boolean IsLinkOnly) {
this.IsLinkOnly = IsLinkOnly;
}

/**
* Set the IsLinkOutputOnly field
*
* @param IsLinkOutputOnly Contents of the IS_LINK_OUTPUT_ONLY column
*/
public void setIsLinkOutputOnly(boolean IsLinkOutputOnly) {
this.IsLinkOutputOnly = IsLinkOutputOnly;
}

/**
* Set the IsOutputOnly field
*
* @param IsOutputOnly Contents of the IS_OUTPUT_ONLY column
*/
public void setIsOutputOnly(boolean IsOutputOnly) {
this.IsOutputOnly = IsOutputOnly;
}

/**
* Set the TopStepKey field
*
* @param TopStepKey Contents of the TOP_STEP_KEY column
*/
public void setTopStepKey(short TopStepKey) {
this.TopStepKey = TopStepKey;
}

/**
* Set the RequesterTypeKey field
*
* @param RequesterTypeKey Contents of the REQUESTER_TYPE_KEY column
*/
public void setRequesterTypeKey(short RequesterTypeKey) {
this.RequesterTypeKey = RequesterTypeKey;
}

/**
* Set the RequesterSubTypeKey field
*
* @param RequesterSubTypeKey Contents of the REQUESTER_SUB_TYPE_KEY column
*/
public void setRequesterSubTypeKey(short RequesterSubTypeKey) {
this.RequesterSubTypeKey = RequesterSubTypeKey;
}

/**
* Set the OutputTypeKey field
*
* @param OutputTypeKey Contents of the OUTPUT_TYPE_KEY column
*/
public void setOutputTypeKey(short OutputTypeKey) {
this.OutputTypeKey = OutputTypeKey;
}

/**
* Set the OutputSubTypeKey field
*
* @param OutputSubTypeKey Contents of the OUTPUT_SUB_TYPE_KEY column
*/
public void setOutputSubTypeKey(short OutputSubTypeKey) {
this.OutputSubTypeKey = OutputSubTypeKey;
}

/**
* Set the ParamListKey field
*
* @param ParamListKey Contents of the PARAM_LIST_KEY column
*/
public void setParamListKey(short ParamListKey) {
this.ParamListKey = ParamListKey;
}

/**
* Set the ReminderKey field
*
* @param ReminderKey Contents of the REMINDER_KEY column
*/
public void setReminderKey(short ReminderKey) {
this.ReminderKey = ReminderKey;
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

