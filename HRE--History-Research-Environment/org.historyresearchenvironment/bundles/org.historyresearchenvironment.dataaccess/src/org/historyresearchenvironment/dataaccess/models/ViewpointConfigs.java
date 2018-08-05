package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the VIEWPOINT_CONFIGS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class ViewpointConfigs extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"VIEWPOINT_CONFIG_PID, " +
"VIEWPOINT_TYPE_KEY, " +
"VIEWPOINT_SUB_TYPE_KEY, " +
"DISPLAY_TYPE_KEY, " +
"LEFT_EDGE, " +
"TOP_EDGE, " +
"WIDTH, " +
"HEIGHT, " +
"LAST_OPENED, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.VIEWPOINT_CONFIGS WHERE VIEWPOINT_CONFIG_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"VIEWPOINT_CONFIG_PID, " +  
"VIEWPOINT_TYPE_KEY, " +  
"VIEWPOINT_SUB_TYPE_KEY, " +  
"DISPLAY_TYPE_KEY, " +  
"LEFT_EDGE, " +  
"TOP_EDGE, " +  
"WIDTH, " +  
"HEIGHT, " +  
"LAST_OPENED, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.VIEWPOINT_CONFIGS";

private static final String INSERT = "INSERT INTO PUBLIC.VIEWPOINT_CONFIGS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"VIEWPOINT_CONFIG_PID, " +     
"VIEWPOINT_TYPE_KEY, " +     
"VIEWPOINT_SUB_TYPE_KEY, " +     
"DISPLAY_TYPE_KEY, " +     
"LEFT_EDGE, " +     
"TOP_EDGE, " +     
"WIDTH, " +     
"HEIGHT, " +     
"LAST_OPENED, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.VIEWPOINT_CONFIGSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"VIEWPOINT_TYPE_KEY = ?, " + 
"VIEWPOINT_SUB_TYPE_KEY = ?, " + 
"DISPLAY_TYPE_KEY = ?, " + 
"LEFT_EDGE = ?, " + 
"TOP_EDGE = ?, " + 
"WIDTH = ?, " + 
"HEIGHT = ?, " + 
"LAST_OPENED = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE VIEWPOINT_CONFIG_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.VIEWPOINT_CONFIGS WHERE VIEWPOINT_CONFIG_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.VIEWPOINT_CONFIGS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int ViewpointConfigPid;
private short ViewpointTypeKey;
private short ViewpointSubTypeKey;
private short DisplayTypeKey;
private int LeftEdge;
private int TopEdge;
private int Width;
private int Height;
private Timestamp LastOpened;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private ViewpointConfigs model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public ViewpointConfigs() throws SQLException {
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
model = new ViewpointConfigs();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setViewpointConfigPid(rs.getInt("VIEWPOINT_CONFIG_PID"));
model.setViewpointTypeKey(rs.getShort("VIEWPOINT_TYPE_KEY"));
model.setViewpointSubTypeKey(rs.getShort("VIEWPOINT_SUB_TYPE_KEY"));
model.setDisplayTypeKey(rs.getShort("DISPLAY_TYPE_KEY"));
model.setLeftEdge(rs.getInt("LEFT_EDGE"));
model.setTopEdge(rs.getInt("TOP_EDGE"));
model.setWidth(rs.getInt("WIDTH"));
model.setHeight(rs.getInt("HEIGHT"));
model.setLastOpened(rs.getTimestamp("LAST_OPENED"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public ViewpointConfigs get(int key) throws SQLException {
model = new ViewpointConfigs();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setViewpointConfigPid(rs.getInt("VIEWPOINT_CONFIG_PID"));
model.setViewpointTypeKey(rs.getShort("VIEWPOINT_TYPE_KEY"));
model.setViewpointSubTypeKey(rs.getShort("VIEWPOINT_SUB_TYPE_KEY"));
model.setDisplayTypeKey(rs.getShort("DISPLAY_TYPE_KEY"));
model.setLeftEdge(rs.getInt("LEFT_EDGE"));
model.setTopEdge(rs.getInt("TOP_EDGE"));
model.setWidth(rs.getInt("WIDTH"));
model.setHeight(rs.getInt("HEIGHT"));
			model.setLastOpened(rs.getTimestamp("LAST_OPENED"));
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
((ViewpointConfigs) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ViewpointConfigs) model).setSetKey(rs.getShort("SET_KEY"));
((ViewpointConfigs) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ViewpointConfigs) model).setViewpointConfigPid(rs.getInt("VIEWPOINT_CONFIG_PID"));
((ViewpointConfigs) model).setViewpointTypeKey(rs.getShort("VIEWPOINT_TYPE_KEY"));
((ViewpointConfigs) model).setViewpointSubTypeKey(rs.getShort("VIEWPOINT_SUB_TYPE_KEY"));
((ViewpointConfigs) model).setDisplayTypeKey(rs.getShort("DISPLAY_TYPE_KEY"));
((ViewpointConfigs) model).setLeftEdge(rs.getInt("LEFT_EDGE"));
((ViewpointConfigs) model).setTopEdge(rs.getInt("TOP_EDGE"));
((ViewpointConfigs) model).setWidth(rs.getInt("WIDTH"));
((ViewpointConfigs) model).setHeight(rs.getInt("HEIGHT"));
((ViewpointConfigs) model).setLastOpened(rs.getTimestamp("LAST_OPENED"));
((ViewpointConfigs) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((ViewpointConfigs) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((ViewpointConfigs) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((ViewpointConfigs) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((ViewpointConfigs) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ViewpointConfigs) model).setSetKey(rs.getShort("SET_KEY"));
((ViewpointConfigs) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ViewpointConfigs) model).setViewpointConfigPid(rs.getInt("VIEWPOINT_CONFIG_PID"));
((ViewpointConfigs) model).setViewpointTypeKey(rs.getShort("VIEWPOINT_TYPE_KEY"));
((ViewpointConfigs) model).setViewpointSubTypeKey(rs.getShort("VIEWPOINT_SUB_TYPE_KEY"));
((ViewpointConfigs) model).setDisplayTypeKey(rs.getShort("DISPLAY_TYPE_KEY"));
((ViewpointConfigs) model).setLeftEdge(rs.getInt("LEFT_EDGE"));
((ViewpointConfigs) model).setTopEdge(rs.getInt("TOP_EDGE"));
((ViewpointConfigs) model).setWidth(rs.getInt("WIDTH"));
((ViewpointConfigs) model).setHeight(rs.getInt("HEIGHT"));
((ViewpointConfigs) model).setLastOpened(rs.getTimestamp("LAST_OPENED"));
((ViewpointConfigs) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((ViewpointConfigs) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((ViewpointConfigs) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((ViewpointConfigs) model).setShow(rs.getBoolean("SHOW"));
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
* Get the ViewpointConfigPid field.
*
* @return Contents of the VIEWPOINT_CONFIG_PID column
*/
public int getViewpointConfigPid() {
return this.ViewpointConfigPid;
}

/**
* Get the ViewpointTypeKey field.
*
* @return Contents of the VIEWPOINT_TYPE_KEY column
*/
public short getViewpointTypeKey() {
return this.ViewpointTypeKey;
}

/**
* Get the ViewpointSubTypeKey field.
*
* @return Contents of the VIEWPOINT_SUB_TYPE_KEY column
*/
public short getViewpointSubTypeKey() {
return this.ViewpointSubTypeKey;
}

/**
* Get the DisplayTypeKey field.
*
* @return Contents of the DISPLAY_TYPE_KEY column
*/
public short getDisplayTypeKey() {
return this.DisplayTypeKey;
}

/**
* Get the LeftEdge field.
*
* @return Contents of the LEFT_EDGE column
*/
public int getLeftEdge() {
return this.LeftEdge;
}

/**
* Get the TopEdge field.
*
* @return Contents of the TOP_EDGE column
*/
public int getTopEdge() {
return this.TopEdge;
}

/**
* Get the Width field.
*
* @return Contents of the WIDTH column
*/
public int getWidth() {
return this.Width;
}

/**
* Get the Height field.
*
* @return Contents of the HEIGHT column
*/
public int getHeight() {
return this.Height;
}

/**
* Get the LastOpened field.
*
* @return Contents of the LAST_OPENED column
*/
public Timestamp getLastOpened() {
return this.LastOpened;
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
* Set the ViewpointConfigPid field
*
* @param ViewpointConfigPid Contents of the VIEWPOINT_CONFIG_PID column
*/
public void setViewpointConfigPid(int ViewpointConfigPid) {
this.ViewpointConfigPid = ViewpointConfigPid;
}

/**
* Set the ViewpointTypeKey field
*
* @param ViewpointTypeKey Contents of the VIEWPOINT_TYPE_KEY column
*/
public void setViewpointTypeKey(short ViewpointTypeKey) {
this.ViewpointTypeKey = ViewpointTypeKey;
}

/**
* Set the ViewpointSubTypeKey field
*
* @param ViewpointSubTypeKey Contents of the VIEWPOINT_SUB_TYPE_KEY column
*/
public void setViewpointSubTypeKey(short ViewpointSubTypeKey) {
this.ViewpointSubTypeKey = ViewpointSubTypeKey;
}

/**
* Set the DisplayTypeKey field
*
* @param DisplayTypeKey Contents of the DISPLAY_TYPE_KEY column
*/
public void setDisplayTypeKey(short DisplayTypeKey) {
this.DisplayTypeKey = DisplayTypeKey;
}

/**
* Set the LeftEdge field
*
* @param LeftEdge Contents of the LEFT_EDGE column
*/
public void setLeftEdge(int LeftEdge) {
this.LeftEdge = LeftEdge;
}

/**
* Set the TopEdge field
*
* @param TopEdge Contents of the TOP_EDGE column
*/
public void setTopEdge(int TopEdge) {
this.TopEdge = TopEdge;
}

/**
* Set the Width field
*
* @param Width Contents of the WIDTH column
*/
public void setWidth(int Width) {
this.Width = Width;
}

/**
* Set the Height field
*
* @param Height Contents of the HEIGHT column
*/
public void setHeight(int Height) {
this.Height = Height;
}

/**
* Set the LastOpened field
*
* @param LastOpened Contents of the LAST_OPENED column
*/
public void setLastOpened(Timestamp LastOpened) {
this.LastOpened = LastOpened;
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

