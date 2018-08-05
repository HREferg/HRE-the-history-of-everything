package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the DISPLAY_TYPE_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class DisplayTypeDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"DISPLAY_TYPE_DEFN_PID, " +
"SCREEN_COUNT, " +
"WIDTH, " +
"HEIGHT, " +
"HAS_KEYBOARD, " +
"TOUCH_SCREEN, " +
"AUTO_ROTATE, " +
"HAS_INTERNET, " +
"HAS_SERVER, " +
"REMINDER, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.DISPLAY_TYPE_DEFNS WHERE DISPLAY_TYPE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"DISPLAY_TYPE_DEFN_PID, " +  
"SCREEN_COUNT, " +  
"WIDTH, " +  
"HEIGHT, " +  
"HAS_KEYBOARD, " +  
"TOUCH_SCREEN, " +  
"AUTO_ROTATE, " +  
"HAS_INTERNET, " +  
"HAS_SERVER, " +  
"REMINDER, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.DISPLAY_TYPE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.DISPLAY_TYPE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"DISPLAY_TYPE_DEFN_PID, " +     
"SCREEN_COUNT, " +     
"WIDTH, " +     
"HEIGHT, " +     
"HAS_KEYBOARD, " +     
"TOUCH_SCREEN, " +     
"AUTO_ROTATE, " +     
"HAS_INTERNET, " +     
"HAS_SERVER, " +     
"REMINDER, " +     
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

private static final String UPDATE = "UPDATE PUBLIC.DISPLAY_TYPE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"SCREEN_COUNT = ?, " + 
"WIDTH = ?, " + 
"HEIGHT = ?, " + 
"HAS_KEYBOARD = ?, " + 
"TOUCH_SCREEN = ?, " + 
"AUTO_ROTATE = ?, " + 
"HAS_INTERNET = ?, " + 
"HAS_SERVER = ?, " + 
"REMINDER = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE DISPLAY_TYPE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.DISPLAY_TYPE_DEFNS WHERE DISPLAY_TYPE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.DISPLAY_TYPE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int DisplayTypeDefnPid;
private short ScreenCount;
private int Width;
private int Height;
private boolean HasKeyboard;
private boolean TouchScreen;
private boolean AutoRotate;
private boolean HasInternet;
private boolean HasServer;
private short Reminder;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private DisplayTypeDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public DisplayTypeDefns() throws SQLException {
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
model = new DisplayTypeDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setDisplayTypeDefnPid(rs.getInt("DISPLAY_TYPE_DEFN_PID"));
model.setScreenCount(rs.getShort("SCREEN_COUNT"));
model.setWidth(rs.getInt("WIDTH"));
model.setHeight(rs.getInt("HEIGHT"));
model.setHasKeyboard(rs.getBoolean("HAS_KEYBOARD"));
model.setTouchScreen(rs.getBoolean("TOUCH_SCREEN"));
model.setAutoRotate(rs.getBoolean("AUTO_ROTATE"));
model.setHasInternet(rs.getBoolean("HAS_INTERNET"));
model.setHasServer(rs.getBoolean("HAS_SERVER"));
model.setReminder(rs.getShort("REMINDER"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public DisplayTypeDefns get(int key) throws SQLException {
model = new DisplayTypeDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setDisplayTypeDefnPid(rs.getInt("DISPLAY_TYPE_DEFN_PID"));
model.setScreenCount(rs.getShort("SCREEN_COUNT"));
model.setWidth(rs.getInt("WIDTH"));
model.setHeight(rs.getInt("HEIGHT"));
model.setHasKeyboard(rs.getBoolean("HAS_KEYBOARD"));
model.setTouchScreen(rs.getBoolean("TOUCH_SCREEN"));
model.setAutoRotate(rs.getBoolean("AUTO_ROTATE"));
model.setHasInternet(rs.getBoolean("HAS_INTERNET"));
model.setHasServer(rs.getBoolean("HAS_SERVER"));
model.setReminder(rs.getShort("REMINDER"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((DisplayTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((DisplayTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((DisplayTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((DisplayTypeDefns) model).setDisplayTypeDefnPid(rs.getInt("DISPLAY_TYPE_DEFN_PID"));
((DisplayTypeDefns) model).setScreenCount(rs.getShort("SCREEN_COUNT"));
((DisplayTypeDefns) model).setWidth(rs.getInt("WIDTH"));
((DisplayTypeDefns) model).setHeight(rs.getInt("HEIGHT"));
((DisplayTypeDefns) model).setHasKeyboard(rs.getBoolean("HAS_KEYBOARD"));
((DisplayTypeDefns) model).setTouchScreen(rs.getBoolean("TOUCH_SCREEN"));
((DisplayTypeDefns) model).setAutoRotate(rs.getBoolean("AUTO_ROTATE"));
((DisplayTypeDefns) model).setHasInternet(rs.getBoolean("HAS_INTERNET"));
((DisplayTypeDefns) model).setHasServer(rs.getBoolean("HAS_SERVER"));
((DisplayTypeDefns) model).setReminder(rs.getShort("REMINDER"));
((DisplayTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((DisplayTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((DisplayTypeDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((DisplayTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((DisplayTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((DisplayTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((DisplayTypeDefns) model).setDisplayTypeDefnPid(rs.getInt("DISPLAY_TYPE_DEFN_PID"));
((DisplayTypeDefns) model).setScreenCount(rs.getShort("SCREEN_COUNT"));
((DisplayTypeDefns) model).setWidth(rs.getInt("WIDTH"));
((DisplayTypeDefns) model).setHeight(rs.getInt("HEIGHT"));
((DisplayTypeDefns) model).setHasKeyboard(rs.getBoolean("HAS_KEYBOARD"));
((DisplayTypeDefns) model).setTouchScreen(rs.getBoolean("TOUCH_SCREEN"));
((DisplayTypeDefns) model).setAutoRotate(rs.getBoolean("AUTO_ROTATE"));
((DisplayTypeDefns) model).setHasInternet(rs.getBoolean("HAS_INTERNET"));
((DisplayTypeDefns) model).setHasServer(rs.getBoolean("HAS_SERVER"));
((DisplayTypeDefns) model).setReminder(rs.getShort("REMINDER"));
((DisplayTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((DisplayTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((DisplayTypeDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the DisplayTypeDefnPid field.
*
* @return Contents of the DISPLAY_TYPE_DEFN_PID column
*/
public int getDisplayTypeDefnPid() {
return this.DisplayTypeDefnPid;
}

/**
* Get the ScreenCount field.
*
* @return Contents of the SCREEN_COUNT column
*/
public short getScreenCount() {
return this.ScreenCount;
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
* Get the HasKeyboard field.
*
* @return Contents of the HAS_KEYBOARD column
*/
public boolean getHasKeyboard() {
return this.HasKeyboard;
}

/**
* Get the TouchScreen field.
*
* @return Contents of the TOUCH_SCREEN column
*/
public boolean getTouchScreen() {
return this.TouchScreen;
}

/**
* Get the AutoRotate field.
*
* @return Contents of the AUTO_ROTATE column
*/
public boolean getAutoRotate() {
return this.AutoRotate;
}

/**
* Get the HasInternet field.
*
* @return Contents of the HAS_INTERNET column
*/
public boolean getHasInternet() {
return this.HasInternet;
}

/**
* Get the HasServer field.
*
* @return Contents of the HAS_SERVER column
*/
public boolean getHasServer() {
return this.HasServer;
}

/**
* Get the Reminder field.
*
* @return Contents of the REMINDER column
*/
public short getReminder() {
return this.Reminder;
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
* Set the DisplayTypeDefnPid field
*
* @param DisplayTypeDefnPid Contents of the DISPLAY_TYPE_DEFN_PID column
*/
public void setDisplayTypeDefnPid(int DisplayTypeDefnPid) {
this.DisplayTypeDefnPid = DisplayTypeDefnPid;
}

/**
* Set the ScreenCount field
*
* @param ScreenCount Contents of the SCREEN_COUNT column
*/
public void setScreenCount(short ScreenCount) {
this.ScreenCount = ScreenCount;
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
* Set the HasKeyboard field
*
* @param HasKeyboard Contents of the HAS_KEYBOARD column
*/
public void setHasKeyboard(boolean HasKeyboard) {
this.HasKeyboard = HasKeyboard;
}

/**
* Set the TouchScreen field
*
* @param TouchScreen Contents of the TOUCH_SCREEN column
*/
public void setTouchScreen(boolean TouchScreen) {
this.TouchScreen = TouchScreen;
}

/**
* Set the AutoRotate field
*
* @param AutoRotate Contents of the AUTO_ROTATE column
*/
public void setAutoRotate(boolean AutoRotate) {
this.AutoRotate = AutoRotate;
}

/**
* Set the HasInternet field
*
* @param HasInternet Contents of the HAS_INTERNET column
*/
public void setHasInternet(boolean HasInternet) {
this.HasInternet = HasInternet;
}

/**
* Set the HasServer field
*
* @param HasServer Contents of the HAS_SERVER column
*/
public void setHasServer(boolean HasServer) {
this.HasServer = HasServer;
}

/**
* Set the Reminder field
*
* @param Reminder Contents of the REMINDER column
*/
public void setReminder(short Reminder) {
this.Reminder = Reminder;
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

