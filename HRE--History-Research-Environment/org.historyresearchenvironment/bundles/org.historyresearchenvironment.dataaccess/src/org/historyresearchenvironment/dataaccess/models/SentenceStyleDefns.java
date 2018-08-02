package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SENTENCE_STYLE_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SentenceStyleDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SENTENCE_STYLE_DEFN_PID, " +
"IS_SYSTEM, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.SENTENCE_STYLE_DEFNS WHERE SENTENCE_STYLE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SENTENCE_STYLE_DEFN_PID, " +  
"IS_SYSTEM, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.SENTENCE_STYLE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.SENTENCE_STYLE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SENTENCE_STYLE_DEFN_PID, " +     
"IS_SYSTEM, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SENTENCE_STYLE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE SENTENCE_STYLE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SENTENCE_STYLE_DEFNS WHERE SENTENCE_STYLE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SENTENCE_STYLE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SentenceStyleDefnPid;
private boolean IsSystem;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private SentenceStyleDefns model;

public SentenceStyleDefns() throws SQLException {
}


public SentenceStyleDefns(int SentenceStyleDefnPid) throws SQLException {
super();
this.SentenceStyleDefnPid = SentenceStyleDefnPid;
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
model = new SentenceStyleDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSentenceStyleDefnPid(rs.getInt("SENTENCE_STYLE_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
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
model.setSentenceStyleDefnPid(rs.getInt("SENTENCE_STYLE_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
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
((SentenceStyleDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SentenceStyleDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SentenceStyleDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SentenceStyleDefns) model).setSentenceStyleDefnPid(rs.getInt("SENTENCE_STYLE_DEFN_PID"));
((SentenceStyleDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SentenceStyleDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SentenceStyleDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SentenceStyleDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((SentenceStyleDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((SentenceStyleDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SentenceStyleDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SentenceStyleDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SentenceStyleDefns) model).setSentenceStyleDefnPid(rs.getInt("SENTENCE_STYLE_DEFN_PID"));
((SentenceStyleDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SentenceStyleDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SentenceStyleDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SentenceStyleDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((SentenceStyleDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getSentenceStyleDefnPid() {
return this.SentenceStyleDefnPid;
}

public boolean getIsSystem() {
return this.IsSystem;
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

public void setSentenceStyleDefnPid(int SentenceStyleDefnPid) {
this.SentenceStyleDefnPid = SentenceStyleDefnPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
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

