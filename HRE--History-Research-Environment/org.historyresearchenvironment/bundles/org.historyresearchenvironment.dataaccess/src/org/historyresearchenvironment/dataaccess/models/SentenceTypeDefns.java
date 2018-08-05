package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SENTENCE_TYPE_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SentenceTypeDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SENTENCE_TYPE_DEFN_PID, " +
"IS_SYSTEM, " +
"REQUESTER_TYPE_KEY, " +
"REQUESTER_SUB_TYPE_KEY, " +
"REQUESTER_TYPE_PID, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.SENTENCE_TYPE_DEFNS WHERE SENTENCE_TYPE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SENTENCE_TYPE_DEFN_PID, " +  
"IS_SYSTEM, " +  
"REQUESTER_TYPE_KEY, " +  
"REQUESTER_SUB_TYPE_KEY, " +  
"REQUESTER_TYPE_PID, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.SENTENCE_TYPE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.SENTENCE_TYPE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SENTENCE_TYPE_DEFN_PID, " +     
"IS_SYSTEM, " +     
"REQUESTER_TYPE_KEY, " +     
"REQUESTER_SUB_TYPE_KEY, " +     
"REQUESTER_TYPE_PID, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SENTENCE_TYPE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"REQUESTER_TYPE_KEY = ?, " + 
"REQUESTER_SUB_TYPE_KEY = ?, " + 
"REQUESTER_TYPE_PID = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE SENTENCE_TYPE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SENTENCE_TYPE_DEFNS WHERE SENTENCE_TYPE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SENTENCE_TYPE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SentenceTypeDefnPid;
private boolean IsSystem;
private short RequesterTypeKey;
private short RequesterSubTypeKey;
private short RequesterTypePid;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private SentenceTypeDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public SentenceTypeDefns() throws SQLException {
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
model = new SentenceTypeDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSentenceTypeDefnPid(rs.getInt("SENTENCE_TYPE_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
model.setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
model.setRequesterTypePid(rs.getShort("REQUESTER_TYPE_PID"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public SentenceTypeDefns get(int key) throws SQLException {
model = new SentenceTypeDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSentenceTypeDefnPid(rs.getInt("SENTENCE_TYPE_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
model.setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
model.setRequesterTypePid(rs.getShort("REQUESTER_TYPE_PID"));
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
((SentenceTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SentenceTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SentenceTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SentenceTypeDefns) model).setSentenceTypeDefnPid(rs.getInt("SENTENCE_TYPE_DEFN_PID"));
((SentenceTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SentenceTypeDefns) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
((SentenceTypeDefns) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
((SentenceTypeDefns) model).setRequesterTypePid(rs.getShort("REQUESTER_TYPE_PID"));
((SentenceTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SentenceTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SentenceTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((SentenceTypeDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((SentenceTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SentenceTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SentenceTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SentenceTypeDefns) model).setSentenceTypeDefnPid(rs.getInt("SENTENCE_TYPE_DEFN_PID"));
((SentenceTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SentenceTypeDefns) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
((SentenceTypeDefns) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
((SentenceTypeDefns) model).setRequesterTypePid(rs.getShort("REQUESTER_TYPE_PID"));
((SentenceTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SentenceTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SentenceTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((SentenceTypeDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the SentenceTypeDefnPid field.
*
* @return Contents of the SENTENCE_TYPE_DEFN_PID column
*/
public int getSentenceTypeDefnPid() {
return this.SentenceTypeDefnPid;
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
* Get the RequesterTypePid field.
*
* @return Contents of the REQUESTER_TYPE_PID column
*/
public short getRequesterTypePid() {
return this.RequesterTypePid;
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
* Set the SentenceTypeDefnPid field
*
* @param SentenceTypeDefnPid Contents of the SENTENCE_TYPE_DEFN_PID column
*/
public void setSentenceTypeDefnPid(int SentenceTypeDefnPid) {
this.SentenceTypeDefnPid = SentenceTypeDefnPid;
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
* Set the RequesterTypePid field
*
* @param RequesterTypePid Contents of the REQUESTER_TYPE_PID column
*/
public void setRequesterTypePid(short RequesterTypePid) {
this.RequesterTypePid = RequesterTypePid;
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

