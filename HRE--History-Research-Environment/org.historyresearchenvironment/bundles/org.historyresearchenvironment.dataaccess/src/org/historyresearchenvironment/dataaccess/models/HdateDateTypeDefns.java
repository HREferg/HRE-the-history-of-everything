package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the HDATE_DATE_TYPE_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class HdateDateTypeDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"HDATE_DATE_TYPE_DEFN_PID, " +
"ORIGINAL_CALENDAR_KEY, " +
"WHEN_WRITTEN, " +
"WHERE_WRITTEN_PID, " +
"CAL_CHNG_START_YEAR, " +
"CAL_CHNG_START_DAY, " +
"CAL_CHNG_END_YEAR, " +
"CAL_CHNG_END_DAY, " +
"DAYS_LOST, " +
"USED_OLD_STYLE, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.HDATE_DATE_TYPE_DEFNS WHERE HDATE_DATE_TYPE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"HDATE_DATE_TYPE_DEFN_PID, " +  
"ORIGINAL_CALENDAR_KEY, " +  
"WHEN_WRITTEN, " +  
"WHERE_WRITTEN_PID, " +  
"CAL_CHNG_START_YEAR, " +  
"CAL_CHNG_START_DAY, " +  
"CAL_CHNG_END_YEAR, " +  
"CAL_CHNG_END_DAY, " +  
"DAYS_LOST, " +  
"USED_OLD_STYLE, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.HDATE_DATE_TYPE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.HDATE_DATE_TYPE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"HDATE_DATE_TYPE_DEFN_PID, " +     
"ORIGINAL_CALENDAR_KEY, " +     
"WHEN_WRITTEN, " +     
"WHERE_WRITTEN_PID, " +     
"CAL_CHNG_START_YEAR, " +     
"CAL_CHNG_START_DAY, " +     
"CAL_CHNG_END_YEAR, " +     
"CAL_CHNG_END_DAY, " +     
"DAYS_LOST, " +     
"USED_OLD_STYLE, " +     
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
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.HDATE_DATE_TYPE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"ORIGINAL_CALENDAR_KEY = ?, " + 
"WHEN_WRITTEN = ?, " + 
"WHERE_WRITTEN_PID = ?, " + 
"CAL_CHNG_START_YEAR = ?, " + 
"CAL_CHNG_START_DAY = ?, " + 
"CAL_CHNG_END_YEAR = ?, " + 
"CAL_CHNG_END_DAY = ?, " + 
"DAYS_LOST = ?, " + 
"USED_OLD_STYLE = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE HDATE_DATE_TYPE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.HDATE_DATE_TYPE_DEFNS WHERE HDATE_DATE_TYPE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.HDATE_DATE_TYPE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int HdateDateTypeDefnPid;
private short OriginalCalendarKey;
private short WhenWritten;
private int WhereWrittenPid;
private short CalChngStartYear;
private short CalChngStartDay;
private short CalChngEndYear;
private short CalChngEndDay;
private short DaysLost;
private boolean UsedOldStyle;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private HdateDateTypeDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public HdateDateTypeDefns() throws SQLException {
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
model = new HdateDateTypeDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setHdateDateTypeDefnPid(rs.getInt("HDATE_DATE_TYPE_DEFN_PID"));
model.setOriginalCalendarKey(rs.getShort("ORIGINAL_CALENDAR_KEY"));
model.setWhenWritten(rs.getShort("WHEN_WRITTEN"));
model.setWhereWrittenPid(rs.getInt("WHERE_WRITTEN_PID"));
model.setCalChngStartYear(rs.getShort("CAL_CHNG_START_YEAR"));
model.setCalChngStartDay(rs.getShort("CAL_CHNG_START_DAY"));
model.setCalChngEndYear(rs.getShort("CAL_CHNG_END_YEAR"));
model.setCalChngEndDay(rs.getShort("CAL_CHNG_END_DAY"));
model.setDaysLost(rs.getShort("DAYS_LOST"));
model.setUsedOldStyle(rs.getBoolean("USED_OLD_STYLE"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public HdateDateTypeDefns get(int key) throws SQLException {
model = new HdateDateTypeDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setHdateDateTypeDefnPid(rs.getInt("HDATE_DATE_TYPE_DEFN_PID"));
model.setOriginalCalendarKey(rs.getShort("ORIGINAL_CALENDAR_KEY"));
model.setWhenWritten(rs.getShort("WHEN_WRITTEN"));
model.setWhereWrittenPid(rs.getInt("WHERE_WRITTEN_PID"));
model.setCalChngStartYear(rs.getShort("CAL_CHNG_START_YEAR"));
model.setCalChngStartDay(rs.getShort("CAL_CHNG_START_DAY"));
model.setCalChngEndYear(rs.getShort("CAL_CHNG_END_YEAR"));
model.setCalChngEndDay(rs.getShort("CAL_CHNG_END_DAY"));
model.setDaysLost(rs.getShort("DAYS_LOST"));
model.setUsedOldStyle(rs.getBoolean("USED_OLD_STYLE"));
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
((HdateDateTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((HdateDateTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((HdateDateTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((HdateDateTypeDefns) model).setHdateDateTypeDefnPid(rs.getInt("HDATE_DATE_TYPE_DEFN_PID"));
((HdateDateTypeDefns) model).setOriginalCalendarKey(rs.getShort("ORIGINAL_CALENDAR_KEY"));
((HdateDateTypeDefns) model).setWhenWritten(rs.getShort("WHEN_WRITTEN"));
((HdateDateTypeDefns) model).setWhereWrittenPid(rs.getInt("WHERE_WRITTEN_PID"));
((HdateDateTypeDefns) model).setCalChngStartYear(rs.getShort("CAL_CHNG_START_YEAR"));
((HdateDateTypeDefns) model).setCalChngStartDay(rs.getShort("CAL_CHNG_START_DAY"));
((HdateDateTypeDefns) model).setCalChngEndYear(rs.getShort("CAL_CHNG_END_YEAR"));
((HdateDateTypeDefns) model).setCalChngEndDay(rs.getShort("CAL_CHNG_END_DAY"));
((HdateDateTypeDefns) model).setDaysLost(rs.getShort("DAYS_LOST"));
((HdateDateTypeDefns) model).setUsedOldStyle(rs.getBoolean("USED_OLD_STYLE"));
((HdateDateTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((HdateDateTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((HdateDateTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((HdateDateTypeDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((HdateDateTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((HdateDateTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((HdateDateTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((HdateDateTypeDefns) model).setHdateDateTypeDefnPid(rs.getInt("HDATE_DATE_TYPE_DEFN_PID"));
((HdateDateTypeDefns) model).setOriginalCalendarKey(rs.getShort("ORIGINAL_CALENDAR_KEY"));
((HdateDateTypeDefns) model).setWhenWritten(rs.getShort("WHEN_WRITTEN"));
((HdateDateTypeDefns) model).setWhereWrittenPid(rs.getInt("WHERE_WRITTEN_PID"));
((HdateDateTypeDefns) model).setCalChngStartYear(rs.getShort("CAL_CHNG_START_YEAR"));
((HdateDateTypeDefns) model).setCalChngStartDay(rs.getShort("CAL_CHNG_START_DAY"));
((HdateDateTypeDefns) model).setCalChngEndYear(rs.getShort("CAL_CHNG_END_YEAR"));
((HdateDateTypeDefns) model).setCalChngEndDay(rs.getShort("CAL_CHNG_END_DAY"));
((HdateDateTypeDefns) model).setDaysLost(rs.getShort("DAYS_LOST"));
((HdateDateTypeDefns) model).setUsedOldStyle(rs.getBoolean("USED_OLD_STYLE"));
((HdateDateTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((HdateDateTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((HdateDateTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((HdateDateTypeDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the HdateDateTypeDefnPid field.
*
* @return Contents of the HDATE_DATE_TYPE_DEFN_PID column
*/
public int getHdateDateTypeDefnPid() {
return this.HdateDateTypeDefnPid;
}

/**
* Get the OriginalCalendarKey field.
*
* @return Contents of the ORIGINAL_CALENDAR_KEY column
*/
public short getOriginalCalendarKey() {
return this.OriginalCalendarKey;
}

/**
* Get the WhenWritten field.
*
* @return Contents of the WHEN_WRITTEN column
*/
public short getWhenWritten() {
return this.WhenWritten;
}

/**
* Get the WhereWrittenPid field.
*
* @return Contents of the WHERE_WRITTEN_PID column
*/
public int getWhereWrittenPid() {
return this.WhereWrittenPid;
}

/**
* Get the CalChngStartYear field.
*
* @return Contents of the CAL_CHNG_START_YEAR column
*/
public short getCalChngStartYear() {
return this.CalChngStartYear;
}

/**
* Get the CalChngStartDay field.
*
* @return Contents of the CAL_CHNG_START_DAY column
*/
public short getCalChngStartDay() {
return this.CalChngStartDay;
}

/**
* Get the CalChngEndYear field.
*
* @return Contents of the CAL_CHNG_END_YEAR column
*/
public short getCalChngEndYear() {
return this.CalChngEndYear;
}

/**
* Get the CalChngEndDay field.
*
* @return Contents of the CAL_CHNG_END_DAY column
*/
public short getCalChngEndDay() {
return this.CalChngEndDay;
}

/**
* Get the DaysLost field.
*
* @return Contents of the DAYS_LOST column
*/
public short getDaysLost() {
return this.DaysLost;
}

/**
* Get the UsedOldStyle field.
*
* @return Contents of the USED_OLD_STYLE column
*/
public boolean getUsedOldStyle() {
return this.UsedOldStyle;
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
* Set the HdateDateTypeDefnPid field
*
* @param HdateDateTypeDefnPid Contents of the HDATE_DATE_TYPE_DEFN_PID column
*/
public void setHdateDateTypeDefnPid(int HdateDateTypeDefnPid) {
this.HdateDateTypeDefnPid = HdateDateTypeDefnPid;
}

/**
* Set the OriginalCalendarKey field
*
* @param OriginalCalendarKey Contents of the ORIGINAL_CALENDAR_KEY column
*/
public void setOriginalCalendarKey(short OriginalCalendarKey) {
this.OriginalCalendarKey = OriginalCalendarKey;
}

/**
* Set the WhenWritten field
*
* @param WhenWritten Contents of the WHEN_WRITTEN column
*/
public void setWhenWritten(short WhenWritten) {
this.WhenWritten = WhenWritten;
}

/**
* Set the WhereWrittenPid field
*
* @param WhereWrittenPid Contents of the WHERE_WRITTEN_PID column
*/
public void setWhereWrittenPid(int WhereWrittenPid) {
this.WhereWrittenPid = WhereWrittenPid;
}

/**
* Set the CalChngStartYear field
*
* @param CalChngStartYear Contents of the CAL_CHNG_START_YEAR column
*/
public void setCalChngStartYear(short CalChngStartYear) {
this.CalChngStartYear = CalChngStartYear;
}

/**
* Set the CalChngStartDay field
*
* @param CalChngStartDay Contents of the CAL_CHNG_START_DAY column
*/
public void setCalChngStartDay(short CalChngStartDay) {
this.CalChngStartDay = CalChngStartDay;
}

/**
* Set the CalChngEndYear field
*
* @param CalChngEndYear Contents of the CAL_CHNG_END_YEAR column
*/
public void setCalChngEndYear(short CalChngEndYear) {
this.CalChngEndYear = CalChngEndYear;
}

/**
* Set the CalChngEndDay field
*
* @param CalChngEndDay Contents of the CAL_CHNG_END_DAY column
*/
public void setCalChngEndDay(short CalChngEndDay) {
this.CalChngEndDay = CalChngEndDay;
}

/**
* Set the DaysLost field
*
* @param DaysLost Contents of the DAYS_LOST column
*/
public void setDaysLost(short DaysLost) {
this.DaysLost = DaysLost;
}

/**
* Set the UsedOldStyle field
*
* @param UsedOldStyle Contents of the USED_OLD_STYLE column
*/
public void setUsedOldStyle(boolean UsedOldStyle) {
this.UsedOldStyle = UsedOldStyle;
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

