package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the HDATE_CALENDAR_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class HdateCalendarDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"HDATE_CALENDAR_DEFN_PID, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.HDATE_CALENDAR_DEFNS WHERE HDATE_CALENDAR_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"HDATE_CALENDAR_DEFN_PID, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.HDATE_CALENDAR_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.HDATE_CALENDAR_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"HDATE_CALENDAR_DEFN_PID, " +     
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

private static final String UPDATE = "UPDATE PUBLIC.HDATE_CALENDAR_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE HDATE_CALENDAR_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.HDATE_CALENDAR_DEFNS WHERE HDATE_CALENDAR_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.HDATE_CALENDAR_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int HdateCalendarDefnPid;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private HdateCalendarDefns model;

public HdateCalendarDefns() throws SQLException {
}


public HdateCalendarDefns(int HdateCalendarDefnPid) throws SQLException {
super();
this.HdateCalendarDefnPid = HdateCalendarDefnPid;
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
model = new HdateCalendarDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setHdateCalendarDefnPid(rs.getInt("HDATE_CALENDAR_DEFN_PID"));
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
model.setHdateCalendarDefnPid(rs.getInt("HDATE_CALENDAR_DEFN_PID"));
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
((HdateCalendarDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((HdateCalendarDefns) model).setSetKey(rs.getShort("SET_KEY"));
((HdateCalendarDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((HdateCalendarDefns) model).setHdateCalendarDefnPid(rs.getInt("HDATE_CALENDAR_DEFN_PID"));
((HdateCalendarDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((HdateCalendarDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((HdateCalendarDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((HdateCalendarDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((HdateCalendarDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((HdateCalendarDefns) model).setSetKey(rs.getShort("SET_KEY"));
((HdateCalendarDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((HdateCalendarDefns) model).setHdateCalendarDefnPid(rs.getInt("HDATE_CALENDAR_DEFN_PID"));
((HdateCalendarDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((HdateCalendarDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((HdateCalendarDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((HdateCalendarDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getHdateCalendarDefnPid() {
return this.HdateCalendarDefnPid;
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

public void setHdateCalendarDefnPid(int HdateCalendarDefnPid) {
this.HdateCalendarDefnPid = HdateCalendarDefnPid;
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

