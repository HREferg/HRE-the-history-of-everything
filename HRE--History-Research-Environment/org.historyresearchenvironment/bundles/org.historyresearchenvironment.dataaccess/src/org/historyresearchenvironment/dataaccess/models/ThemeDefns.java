package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the THEME_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class ThemeDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"THEME_DEFN_PID, " +
"IS_SYSTEM, " +
"PLUGIN_KEY, " +
"ENTITY_TYPE_KEY, " +
"ENTITY_SUB_TYPE_KEY, " +
"IS_MAIN_THEME, " +
"MAIN_THEME_KEY, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.THEME_DEFNS WHERE THEME_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"THEME_DEFN_PID, " +  
"IS_SYSTEM, " +  
"PLUGIN_KEY, " +  
"ENTITY_TYPE_KEY, " +  
"ENTITY_SUB_TYPE_KEY, " +  
"IS_MAIN_THEME, " +  
"MAIN_THEME_KEY, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.THEME_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.THEME_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"THEME_DEFN_PID, " +     
"IS_SYSTEM, " +     
"PLUGIN_KEY, " +     
"ENTITY_TYPE_KEY, " +     
"ENTITY_SUB_TYPE_KEY, " +     
"IS_MAIN_THEME, " +     
"MAIN_THEME_KEY, " +     
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

private static final String UPDATE = "UPDATE PUBLIC.THEME_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PLUGIN_KEY = ?, " + 
"ENTITY_TYPE_KEY = ?, " + 
"ENTITY_SUB_TYPE_KEY = ?, " + 
"IS_MAIN_THEME = ?, " + 
"MAIN_THEME_KEY = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE THEME_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.THEME_DEFNS WHERE THEME_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.THEME_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int ThemeDefnPid;
private boolean IsSystem;
private short PluginKey;
private short EntityTypeKey;
private short EntitySubTypeKey;
private boolean IsMainTheme;
private short MainThemeKey;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private ThemeDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public ThemeDefns() throws SQLException {
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
model = new ThemeDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setThemeDefnPid(rs.getInt("THEME_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setPluginKey(rs.getShort("PLUGIN_KEY"));
model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
model.setIsMainTheme(rs.getBoolean("IS_MAIN_THEME"));
model.setMainThemeKey(rs.getShort("MAIN_THEME_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public ThemeDefns get(int key) throws SQLException {
model = new ThemeDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setThemeDefnPid(rs.getInt("THEME_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setPluginKey(rs.getShort("PLUGIN_KEY"));
model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
model.setIsMainTheme(rs.getBoolean("IS_MAIN_THEME"));
model.setMainThemeKey(rs.getShort("MAIN_THEME_KEY"));
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
((ThemeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ThemeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((ThemeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ThemeDefns) model).setThemeDefnPid(rs.getInt("THEME_DEFN_PID"));
((ThemeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((ThemeDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
((ThemeDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
((ThemeDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
((ThemeDefns) model).setIsMainTheme(rs.getBoolean("IS_MAIN_THEME"));
((ThemeDefns) model).setMainThemeKey(rs.getShort("MAIN_THEME_KEY"));
((ThemeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((ThemeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((ThemeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((ThemeDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((ThemeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ThemeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((ThemeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ThemeDefns) model).setThemeDefnPid(rs.getInt("THEME_DEFN_PID"));
((ThemeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((ThemeDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
((ThemeDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
((ThemeDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
((ThemeDefns) model).setIsMainTheme(rs.getBoolean("IS_MAIN_THEME"));
((ThemeDefns) model).setMainThemeKey(rs.getShort("MAIN_THEME_KEY"));
((ThemeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((ThemeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((ThemeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((ThemeDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the ThemeDefnPid field.
*
* @return Contents of the THEME_DEFN_PID column
*/
public int getThemeDefnPid() {
return this.ThemeDefnPid;
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
* Get the PluginKey field.
*
* @return Contents of the PLUGIN_KEY column
*/
public short getPluginKey() {
return this.PluginKey;
}

/**
* Get the EntityTypeKey field.
*
* @return Contents of the ENTITY_TYPE_KEY column
*/
public short getEntityTypeKey() {
return this.EntityTypeKey;
}

/**
* Get the EntitySubTypeKey field.
*
* @return Contents of the ENTITY_SUB_TYPE_KEY column
*/
public short getEntitySubTypeKey() {
return this.EntitySubTypeKey;
}

/**
* Get the IsMainTheme field.
*
* @return Contents of the IS_MAIN_THEME column
*/
public boolean getIsMainTheme() {
return this.IsMainTheme;
}

/**
* Get the MainThemeKey field.
*
* @return Contents of the MAIN_THEME_KEY column
*/
public short getMainThemeKey() {
return this.MainThemeKey;
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
* Set the ThemeDefnPid field
*
* @param ThemeDefnPid Contents of the THEME_DEFN_PID column
*/
public void setThemeDefnPid(int ThemeDefnPid) {
this.ThemeDefnPid = ThemeDefnPid;
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
* Set the PluginKey field
*
* @param PluginKey Contents of the PLUGIN_KEY column
*/
public void setPluginKey(short PluginKey) {
this.PluginKey = PluginKey;
}

/**
* Set the EntityTypeKey field
*
* @param EntityTypeKey Contents of the ENTITY_TYPE_KEY column
*/
public void setEntityTypeKey(short EntityTypeKey) {
this.EntityTypeKey = EntityTypeKey;
}

/**
* Set the EntitySubTypeKey field
*
* @param EntitySubTypeKey Contents of the ENTITY_SUB_TYPE_KEY column
*/
public void setEntitySubTypeKey(short EntitySubTypeKey) {
this.EntitySubTypeKey = EntitySubTypeKey;
}

/**
* Set the IsMainTheme field
*
* @param IsMainTheme Contents of the IS_MAIN_THEME column
*/
public void setIsMainTheme(boolean IsMainTheme) {
this.IsMainTheme = IsMainTheme;
}

/**
* Set the MainThemeKey field
*
* @param MainThemeKey Contents of the MAIN_THEME_KEY column
*/
public void setMainThemeKey(short MainThemeKey) {
this.MainThemeKey = MainThemeKey;
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

