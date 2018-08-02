package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SENTENCE_SET_DEFNS database table.
*
* @version 2018-08-02
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

public SentenceSetDefns() throws SQLException {
}


public SentenceSetDefns(int SentenceSetDefnPid) throws SQLException {
super();
this.SentenceSetDefnPid = SentenceSetDefnPid;
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
public AbstractHreDataModel get(int key) throws SQLException {
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
return this;
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

public int getRecordNum() {
return this.RecordNum;
}

public short getSetKey() {
return this.SetKey;
}

public int getCommitPid() {
return this.CommitPid;
}

public int getSentenceSetDefnPid() {
return this.SentenceSetDefnPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public short getParentTagTypeKey() {
return this.ParentTagTypeKey;
}

public short getParentTagPid() {
return this.ParentTagPid;
}

public short getSentceStyleTypeKey() {
return this.SentceStyleTypeKey;
}

public short getReminderKey() {
return this.ReminderKey;
}

public short getDisplayOrder() {
return this.DisplayOrder;
}

public boolean getIsDefault() {
return this.IsDefault;
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

public void setSentenceSetDefnPid(int SentenceSetDefnPid) {
this.SentenceSetDefnPid = SentenceSetDefnPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setParentTagTypeKey(short ParentTagTypeKey) {
this.ParentTagTypeKey = ParentTagTypeKey;
}

public void setParentTagPid(short ParentTagPid) {
this.ParentTagPid = ParentTagPid;
}

public void setSentceStyleTypeKey(short SentceStyleTypeKey) {
this.SentceStyleTypeKey = SentceStyleTypeKey;
}

public void setReminderKey(short ReminderKey) {
this.ReminderKey = ReminderKey;
}

public void setDisplayOrder(short DisplayOrder) {
this.DisplayOrder = DisplayOrder;
}

public void setIsDefault(boolean IsDefault) {
this.IsDefault = IsDefault;
}

public void setShow(boolean Show) {
this.Show = Show;
}

}

