package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the LANGUAGE_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class LanguageDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"LANGUAGE_DEFN_PID, " +
"LANGUAGE_CODE, " +
"LANGUAGE_NAME, " +
"IS_GUI_LANG, " +
"IS_DATA_LANG, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.LANGUAGE_DEFNS WHERE LANGUAGE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"LANGUAGE_DEFN_PID, " +  
"LANGUAGE_CODE, " +  
"LANGUAGE_NAME, " +  
"IS_GUI_LANG, " +  
"IS_DATA_LANG, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.LANGUAGE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.LANGUAGE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"LANGUAGE_DEFN_PID, " +     
"LANGUAGE_CODE, " +     
"LANGUAGE_NAME, " +     
"IS_GUI_LANG, " +     
"IS_DATA_LANG, " +     
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

private static final String UPDATE = "UPDATE PUBLIC.LANGUAGE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"LANGUAGE_CODE = ?, " + 
"LANGUAGE_NAME = ?, " + 
"IS_GUI_LANG = ?, " + 
"IS_DATA_LANG = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE LANGUAGE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.LANGUAGE_DEFNS WHERE LANGUAGE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.LANGUAGE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int LanguageDefnPid;
private String LanguageCode;
private String LanguageName;
private boolean IsGuiLang;
private boolean IsDataLang;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private LanguageDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public LanguageDefns() throws SQLException {
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
model = new LanguageDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setLanguageDefnPid(rs.getInt("LANGUAGE_DEFN_PID"));
model.setLanguageCode(rs.getString("LANGUAGE_CODE"));
model.setLanguageName(rs.getString("LANGUAGE_NAME"));
model.setIsGuiLang(rs.getBoolean("IS_GUI_LANG"));
model.setIsDataLang(rs.getBoolean("IS_DATA_LANG"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public LanguageDefns get(int key) throws SQLException {
model = new LanguageDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setLanguageDefnPid(rs.getInt("LANGUAGE_DEFN_PID"));
model.setLanguageCode(rs.getString("LANGUAGE_CODE"));
model.setLanguageName(rs.getString("LANGUAGE_NAME"));
model.setIsGuiLang(rs.getBoolean("IS_GUI_LANG"));
model.setIsDataLang(rs.getBoolean("IS_DATA_LANG"));
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
((LanguageDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((LanguageDefns) model).setSetKey(rs.getShort("SET_KEY"));
((LanguageDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((LanguageDefns) model).setLanguageDefnPid(rs.getInt("LANGUAGE_DEFN_PID"));
((LanguageDefns) model).setLanguageCode(rs.getString("LANGUAGE_CODE"));
((LanguageDefns) model).setLanguageName(rs.getString("LANGUAGE_NAME"));
((LanguageDefns) model).setIsGuiLang(rs.getBoolean("IS_GUI_LANG"));
((LanguageDefns) model).setIsDataLang(rs.getBoolean("IS_DATA_LANG"));
((LanguageDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((LanguageDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((LanguageDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((LanguageDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((LanguageDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((LanguageDefns) model).setSetKey(rs.getShort("SET_KEY"));
((LanguageDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((LanguageDefns) model).setLanguageDefnPid(rs.getInt("LANGUAGE_DEFN_PID"));
((LanguageDefns) model).setLanguageCode(rs.getString("LANGUAGE_CODE"));
((LanguageDefns) model).setLanguageName(rs.getString("LANGUAGE_NAME"));
((LanguageDefns) model).setIsGuiLang(rs.getBoolean("IS_GUI_LANG"));
((LanguageDefns) model).setIsDataLang(rs.getBoolean("IS_DATA_LANG"));
((LanguageDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((LanguageDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((LanguageDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((LanguageDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the LanguageDefnPid field.
*
* @return Contents of the LANGUAGE_DEFN_PID column
*/
public int getLanguageDefnPid() {
return this.LanguageDefnPid;
}

/**
* Get the LanguageCode field.
*
* @return Contents of the LANGUAGE_CODE column
*/
public String getLanguageCode() {
return this.LanguageCode;
}

/**
* Get the LanguageName field.
*
* @return Contents of the LANGUAGE_NAME column
*/
public String getLanguageName() {
return this.LanguageName;
}

/**
* Get the IsGuiLang field.
*
* @return Contents of the IS_GUI_LANG column
*/
public boolean getIsGuiLang() {
return this.IsGuiLang;
}

/**
* Get the IsDataLang field.
*
* @return Contents of the IS_DATA_LANG column
*/
public boolean getIsDataLang() {
return this.IsDataLang;
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
* Set the LanguageDefnPid field
*
* @param LanguageDefnPid Contents of the LANGUAGE_DEFN_PID column
*/
public void setLanguageDefnPid(int LanguageDefnPid) {
this.LanguageDefnPid = LanguageDefnPid;
}

/**
* Set the LanguageCode field
*
* @param LanguageCode Contents of the LANGUAGE_CODE column
*/
public void setLanguageCode(String LanguageCode) {
this.LanguageCode = LanguageCode;
}

/**
* Set the LanguageName field
*
* @param LanguageName Contents of the LANGUAGE_NAME column
*/
public void setLanguageName(String LanguageName) {
this.LanguageName = LanguageName;
}

/**
* Set the IsGuiLang field
*
* @param IsGuiLang Contents of the IS_GUI_LANG column
*/
public void setIsGuiLang(boolean IsGuiLang) {
this.IsGuiLang = IsGuiLang;
}

/**
* Set the IsDataLang field
*
* @param IsDataLang Contents of the IS_DATA_LANG column
*/
public void setIsDataLang(boolean IsDataLang) {
this.IsDataLang = IsDataLang;
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

