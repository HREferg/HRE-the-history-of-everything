package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the PUBLISH_TYPE_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class PublishTypeDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"PUBLISH_TYPE_DEFN_PID, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.PUBLISH_TYPE_DEFNS WHERE PUBLISH_TYPE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"PUBLISH_TYPE_DEFN_PID, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.PUBLISH_TYPE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.PUBLISH_TYPE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"PUBLISH_TYPE_DEFN_PID, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.PUBLISH_TYPE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE PUBLISH_TYPE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.PUBLISH_TYPE_DEFNS WHERE PUBLISH_TYPE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.PUBLISH_TYPE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int PublishTypeDefnPid;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private PublishTypeDefns model;

public PublishTypeDefns() throws SQLException {
}


public PublishTypeDefns(int PublishTypeDefnPid) throws SQLException {
super();
this.PublishTypeDefnPid = PublishTypeDefnPid;
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
model = new PublishTypeDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setPublishTypeDefnPid(rs.getInt("PUBLISH_TYPE_DEFN_PID"));
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
model.setPublishTypeDefnPid(rs.getInt("PUBLISH_TYPE_DEFN_PID"));
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
((PublishTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((PublishTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((PublishTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((PublishTypeDefns) model).setPublishTypeDefnPid(rs.getInt("PUBLISH_TYPE_DEFN_PID"));
((PublishTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((PublishTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((PublishTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((PublishTypeDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((PublishTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((PublishTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((PublishTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((PublishTypeDefns) model).setPublishTypeDefnPid(rs.getInt("PUBLISH_TYPE_DEFN_PID"));
((PublishTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((PublishTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((PublishTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((PublishTypeDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getPublishTypeDefnPid() {
return this.PublishTypeDefnPid;
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

public void setPublishTypeDefnPid(int PublishTypeDefnPid) {
this.PublishTypeDefnPid = PublishTypeDefnPid;
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

