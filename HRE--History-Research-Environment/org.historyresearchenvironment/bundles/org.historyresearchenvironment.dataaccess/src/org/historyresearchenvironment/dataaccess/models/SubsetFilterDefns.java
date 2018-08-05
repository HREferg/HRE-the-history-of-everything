package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSET_FILTER_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SubsetFilterDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SUBSET_FILTER_DEFN_PID, " +
"IS_SYSTEM, " +
"INPUT_TYPE_KEY, " +
"INPUT_SUB_TYPE_KEY, " +
"OUTPUT_TYPE_KEY, " +
"OUTPUT_SUB_TYPE_KEY, " +
"START_STEP_PID, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.SUBSET_FILTER_DEFNS WHERE SUBSET_FILTER_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SUBSET_FILTER_DEFN_PID, " +  
"IS_SYSTEM, " +  
"INPUT_TYPE_KEY, " +  
"INPUT_SUB_TYPE_KEY, " +  
"OUTPUT_TYPE_KEY, " +  
"OUTPUT_SUB_TYPE_KEY, " +  
"START_STEP_PID, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.SUBSET_FILTER_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.SUBSET_FILTER_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SUBSET_FILTER_DEFN_PID, " +     
"IS_SYSTEM, " +     
"INPUT_TYPE_KEY, " +     
"INPUT_SUB_TYPE_KEY, " +     
"OUTPUT_TYPE_KEY, " +     
"OUTPUT_SUB_TYPE_KEY, " +     
"START_STEP_PID, " +     
"REMINDER_KEY, " +     
"DISPLAY_ORDER, " +     
"IS_DEFAULT, " +     
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

private static final String UPDATE = "UPDATE PUBLIC.SUBSET_FILTER_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"INPUT_TYPE_KEY = ?, " + 
"INPUT_SUB_TYPE_KEY = ?, " + 
"OUTPUT_TYPE_KEY = ?, " + 
"OUTPUT_SUB_TYPE_KEY = ?, " + 
"START_STEP_PID = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE SUBSET_FILTER_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SUBSET_FILTER_DEFNS WHERE SUBSET_FILTER_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSET_FILTER_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SubsetFilterDefnPid;
private boolean IsSystem;
private short InputTypeKey;
private short InputSubTypeKey;
private short OutputTypeKey;
private short OutputSubTypeKey;
private short StartStepPid;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private SubsetFilterDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public SubsetFilterDefns() throws SQLException {
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
model = new SubsetFilterDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSubsetFilterDefnPid(rs.getInt("SUBSET_FILTER_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setInputTypeKey(rs.getShort("INPUT_TYPE_KEY"));
model.setInputSubTypeKey(rs.getShort("INPUT_SUB_TYPE_KEY"));
model.setOutputTypeKey(rs.getShort("OUTPUT_TYPE_KEY"));
model.setOutputSubTypeKey(rs.getShort("OUTPUT_SUB_TYPE_KEY"));
model.setStartStepPid(rs.getShort("START_STEP_PID"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public SubsetFilterDefns get(int key) throws SQLException {
model = new SubsetFilterDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSubsetFilterDefnPid(rs.getInt("SUBSET_FILTER_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setInputTypeKey(rs.getShort("INPUT_TYPE_KEY"));
model.setInputSubTypeKey(rs.getShort("INPUT_SUB_TYPE_KEY"));
model.setOutputTypeKey(rs.getShort("OUTPUT_TYPE_KEY"));
model.setOutputSubTypeKey(rs.getShort("OUTPUT_SUB_TYPE_KEY"));
model.setStartStepPid(rs.getShort("START_STEP_PID"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((SubsetFilterDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubsetFilterDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SubsetFilterDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubsetFilterDefns) model).setSubsetFilterDefnPid(rs.getInt("SUBSET_FILTER_DEFN_PID"));
((SubsetFilterDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SubsetFilterDefns) model).setInputTypeKey(rs.getShort("INPUT_TYPE_KEY"));
((SubsetFilterDefns) model).setInputSubTypeKey(rs.getShort("INPUT_SUB_TYPE_KEY"));
((SubsetFilterDefns) model).setOutputTypeKey(rs.getShort("OUTPUT_TYPE_KEY"));
((SubsetFilterDefns) model).setOutputSubTypeKey(rs.getShort("OUTPUT_SUB_TYPE_KEY"));
((SubsetFilterDefns) model).setStartStepPid(rs.getShort("START_STEP_PID"));
((SubsetFilterDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SubsetFilterDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SubsetFilterDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((SubsetFilterDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((SubsetFilterDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubsetFilterDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SubsetFilterDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubsetFilterDefns) model).setSubsetFilterDefnPid(rs.getInt("SUBSET_FILTER_DEFN_PID"));
((SubsetFilterDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SubsetFilterDefns) model).setInputTypeKey(rs.getShort("INPUT_TYPE_KEY"));
((SubsetFilterDefns) model).setInputSubTypeKey(rs.getShort("INPUT_SUB_TYPE_KEY"));
((SubsetFilterDefns) model).setOutputTypeKey(rs.getShort("OUTPUT_TYPE_KEY"));
((SubsetFilterDefns) model).setOutputSubTypeKey(rs.getShort("OUTPUT_SUB_TYPE_KEY"));
((SubsetFilterDefns) model).setStartStepPid(rs.getShort("START_STEP_PID"));
((SubsetFilterDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SubsetFilterDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SubsetFilterDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((SubsetFilterDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the SubsetFilterDefnPid field.
*
* @return Contents of the SUBSET_FILTER_DEFN_PID column
*/
public int getSubsetFilterDefnPid() {
return this.SubsetFilterDefnPid;
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
* Get the InputTypeKey field.
*
* @return Contents of the INPUT_TYPE_KEY column
*/
public short getInputTypeKey() {
return this.InputTypeKey;
}

/**
* Get the InputSubTypeKey field.
*
* @return Contents of the INPUT_SUB_TYPE_KEY column
*/
public short getInputSubTypeKey() {
return this.InputSubTypeKey;
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
* Get the StartStepPid field.
*
* @return Contents of the START_STEP_PID column
*/
public short getStartStepPid() {
return this.StartStepPid;
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
* Get the IsDefault field.
*
* @return Contents of the IS_DEFAULT column
*/
public boolean getIsDefault() {
return this.IsDefault;
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
* Set the SubsetFilterDefnPid field
*
* @param SubsetFilterDefnPid Contents of the SUBSET_FILTER_DEFN_PID column
*/
public void setSubsetFilterDefnPid(int SubsetFilterDefnPid) {
this.SubsetFilterDefnPid = SubsetFilterDefnPid;
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
* Set the InputTypeKey field
*
* @param InputTypeKey Contents of the INPUT_TYPE_KEY column
*/
public void setInputTypeKey(short InputTypeKey) {
this.InputTypeKey = InputTypeKey;
}

/**
* Set the InputSubTypeKey field
*
* @param InputSubTypeKey Contents of the INPUT_SUB_TYPE_KEY column
*/
public void setInputSubTypeKey(short InputSubTypeKey) {
this.InputSubTypeKey = InputSubTypeKey;
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
* Set the StartStepPid field
*
* @param StartStepPid Contents of the START_STEP_PID column
*/
public void setStartStepPid(short StartStepPid) {
this.StartStepPid = StartStepPid;
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
* Set the IsDefault field
*
* @param IsDefault Contents of the IS_DEFAULT column
*/
public void setIsDefault(boolean IsDefault) {
this.IsDefault = IsDefault;
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

