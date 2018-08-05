package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SENTENCE_SET_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SentenceSetDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SENTENCE_SET_DEFN_PID, " +
"IS_SYSTEM, " +
"PARENT_TAG_TYPE_KEY, " +
"PARENT_TAG_PID, " +
"SENTCE_STYLE_TYPE_KEY, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.SENTENCE_SET_DEFNS WHERE SENTENCE_SET_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SENTENCE_SET_DEFN_PID, " +  
"IS_SYSTEM, " +  
"PARENT_TAG_TYPE_KEY, " +  
"PARENT_TAG_PID, " +  
"SENTCE_STYLE_TYPE_KEY, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.SENTENCE_SET_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.SENTENCE_SET_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SENTENCE_SET_DEFN_PID, " +     
"IS_SYSTEM, " +     
"PARENT_TAG_TYPE_KEY, " +     
"PARENT_TAG_PID, " +     
"SENTCE_STYLE_TYPE_KEY, " +     
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

private static final String UPDATE = "UPDATE PUBLIC.SENTENCE_SET_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PARENT_TAG_TYPE_KEY = ?, " + 
"PARENT_TAG_PID = ?, " + 
"SENTCE_STYLE_TYPE_KEY = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE SENTENCE_SET_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SENTENCE_SET_DEFNS WHERE SENTENCE_SET_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SENTENCE_SET_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SentenceSetDefnPid;
private boolean IsSystem;
private short ParentTagTypeKey;
private short ParentTagPid;
private short SentceStyleTypeKey;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private SentenceSetDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public SentenceSetDefns() throws SQLException {
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
model = new SentenceSetDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSentenceSetDefnPid(rs.getInt("SENTENCE_SET_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentTagTypeKey(rs.getShort("PARENT_TAG_TYPE_KEY"));
model.setParentTagPid(rs.getShort("PARENT_TAG_PID"));
model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public SentenceSetDefns get(int key) throws SQLException {
model = new SentenceSetDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSentenceSetDefnPid(rs.getInt("SENTENCE_SET_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentTagTypeKey(rs.getShort("PARENT_TAG_TYPE_KEY"));
model.setParentTagPid(rs.getShort("PARENT_TAG_PID"));
model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
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
((SentenceSetDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SentenceSetDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SentenceSetDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SentenceSetDefns) model).setSentenceSetDefnPid(rs.getInt("SENTENCE_SET_DEFN_PID"));
((SentenceSetDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SentenceSetDefns) model).setParentTagTypeKey(rs.getShort("PARENT_TAG_TYPE_KEY"));
((SentenceSetDefns) model).setParentTagPid(rs.getShort("PARENT_TAG_PID"));
((SentenceSetDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
((SentenceSetDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SentenceSetDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SentenceSetDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((SentenceSetDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((SentenceSetDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SentenceSetDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SentenceSetDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SentenceSetDefns) model).setSentenceSetDefnPid(rs.getInt("SENTENCE_SET_DEFN_PID"));
((SentenceSetDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SentenceSetDefns) model).setParentTagTypeKey(rs.getShort("PARENT_TAG_TYPE_KEY"));
((SentenceSetDefns) model).setParentTagPid(rs.getShort("PARENT_TAG_PID"));
((SentenceSetDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
((SentenceSetDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SentenceSetDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SentenceSetDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((SentenceSetDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the SentenceSetDefnPid field.
*
* @return Contents of the SENTENCE_SET_DEFN_PID column
*/
public int getSentenceSetDefnPid() {
return this.SentenceSetDefnPid;
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
* Get the ParentTagTypeKey field.
*
* @return Contents of the PARENT_TAG_TYPE_KEY column
*/
public short getParentTagTypeKey() {
return this.ParentTagTypeKey;
}

/**
* Get the ParentTagPid field.
*
* @return Contents of the PARENT_TAG_PID column
*/
public short getParentTagPid() {
return this.ParentTagPid;
}

/**
* Get the SentceStyleTypeKey field.
*
* @return Contents of the SENTCE_STYLE_TYPE_KEY column
*/
public short getSentceStyleTypeKey() {
return this.SentceStyleTypeKey;
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
* Set the SentenceSetDefnPid field
*
* @param SentenceSetDefnPid Contents of the SENTENCE_SET_DEFN_PID column
*/
public void setSentenceSetDefnPid(int SentenceSetDefnPid) {
this.SentenceSetDefnPid = SentenceSetDefnPid;
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
* Set the ParentTagTypeKey field
*
* @param ParentTagTypeKey Contents of the PARENT_TAG_TYPE_KEY column
*/
public void setParentTagTypeKey(short ParentTagTypeKey) {
this.ParentTagTypeKey = ParentTagTypeKey;
}

/**
* Set the ParentTagPid field
*
* @param ParentTagPid Contents of the PARENT_TAG_PID column
*/
public void setParentTagPid(short ParentTagPid) {
this.ParentTagPid = ParentTagPid;
}

/**
* Set the SentceStyleTypeKey field
*
* @param SentceStyleTypeKey Contents of the SENTCE_STYLE_TYPE_KEY column
*/
public void setSentceStyleTypeKey(short SentceStyleTypeKey) {
this.SentceStyleTypeKey = SentceStyleTypeKey;
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

