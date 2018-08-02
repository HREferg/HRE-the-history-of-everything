package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the LANGUAGE_DEFNS database table.
*
* @version 2018-08-02
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

public LanguageDefns() throws SQLException {
}


public LanguageDefns(int LanguageDefnPid) throws SQLException {
super();
this.LanguageDefnPid = LanguageDefnPid;
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
public AbstractHreDataModel get(int key) throws SQLException {
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
return this;
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

public int getRecordNum() {
return this.RecordNum;
}

public short getSetKey() {
return this.SetKey;
}

public int getCommitPid() {
return this.CommitPid;
}

public int getLanguageDefnPid() {
return this.LanguageDefnPid;
}

public String getLanguageCode() {
return this.LanguageCode;
}

public String getLanguageName() {
return this.LanguageName;
}

public boolean getIsGuiLang() {
return this.IsGuiLang;
}

public boolean getIsDataLang() {
return this.IsDataLang;
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

public void setLanguageDefnPid(int LanguageDefnPid) {
this.LanguageDefnPid = LanguageDefnPid;
}

public void setLanguageCode(String LanguageCode) {
this.LanguageCode = LanguageCode;
}

public void setLanguageName(String LanguageName) {
this.LanguageName = LanguageName;
}

public void setIsGuiLang(boolean IsGuiLang) {
this.IsGuiLang = IsGuiLang;
}

public void setIsDataLang(boolean IsDataLang) {
this.IsDataLang = IsDataLang;
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

