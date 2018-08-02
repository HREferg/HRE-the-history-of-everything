package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the GUI_LANGUAGES database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class GuiLanguages extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"GUI_LANGUAGE_PID, " +
"REMINDER_KEY, " +
"GUI_LANGUAGE, " +
"DATA1_LANGUAGE, " +
"DATA2_LANGUAGE, " +
"REPORT_LANGUAGE, " +
"DFLT_LANGUAGE FROM PUBLIC.GUI_LANGUAGES WHERE GUI_LANGUAGE_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"GUI_LANGUAGE_PID, " +  
"REMINDER_KEY, " +  
"GUI_LANGUAGE, " +  
"DATA1_LANGUAGE, " +  
"DATA2_LANGUAGE, " +  
"REPORT_LANGUAGE, " +  
"DFLT_LANGUAGE FROM PUBLIC.GUI_LANGUAGES";

private static final String INSERT = "INSERT INTO PUBLIC.GUI_LANGUAGES( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"GUI_LANGUAGE_PID, " +     
"REMINDER_KEY, " +     
"GUI_LANGUAGE, " +     
"DATA1_LANGUAGE, " +     
"DATA2_LANGUAGE, " +     
"REPORT_LANGUAGE, " +     
"DFLT_LANGUAGE) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.GUI_LANGUAGESSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"REMINDER_KEY = ?, " + 
"GUI_LANGUAGE = ?, " + 
"DATA1_LANGUAGE = ?, " + 
"DATA2_LANGUAGE = ?, " + 
"REPORT_LANGUAGE = ?, " + 
"DFLT_LANGUAGE = ? WHERE GUI_LANGUAGE_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.GUI_LANGUAGES WHERE GUI_LANGUAGE_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.GUI_LANGUAGES";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int GuiLanguagePid;
private short ReminderKey;
private String GuiLanguage;
private String Data1Language;
private String Data2Language;
private String ReportLanguage;
private String DfltLanguage;
private GuiLanguages model;

public GuiLanguages() throws SQLException {
}


public GuiLanguages(int GuiLanguagePid) throws SQLException {
super();
this.GuiLanguagePid = GuiLanguagePid;
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
model = new GuiLanguages();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setGuiLanguagePid(rs.getInt("GUI_LANGUAGE_PID"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setGuiLanguage(rs.getString("GUI_LANGUAGE"));
model.setData1Language(rs.getString("DATA1_LANGUAGE"));
model.setData2Language(rs.getString("DATA2_LANGUAGE"));
model.setReportLanguage(rs.getString("REPORT_LANGUAGE"));
model.setDfltLanguage(rs.getString("DFLT_LANGUAGE"));
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
model.setGuiLanguagePid(rs.getInt("GUI_LANGUAGE_PID"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setGuiLanguage(rs.getString("GUI_LANGUAGE"));
model.setData1Language(rs.getString("DATA1_LANGUAGE"));
model.setData2Language(rs.getString("DATA2_LANGUAGE"));
model.setReportLanguage(rs.getString("REPORT_LANGUAGE"));
model.setDfltLanguage(rs.getString("DFLT_LANGUAGE"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((GuiLanguages) model).setRecordNum(rs.getInt("RECORD_NUM"));
((GuiLanguages) model).setSetKey(rs.getShort("SET_KEY"));
((GuiLanguages) model).setCommitPid(rs.getInt("COMMIT_PID"));
((GuiLanguages) model).setGuiLanguagePid(rs.getInt("GUI_LANGUAGE_PID"));
((GuiLanguages) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((GuiLanguages) model).setGuiLanguage(rs.getString("GUI_LANGUAGE"));
((GuiLanguages) model).setData1Language(rs.getString("DATA1_LANGUAGE"));
((GuiLanguages) model).setData2Language(rs.getString("DATA2_LANGUAGE"));
((GuiLanguages) model).setReportLanguage(rs.getString("REPORT_LANGUAGE"));
((GuiLanguages) model).setDfltLanguage(rs.getString("DFLT_LANGUAGE"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((GuiLanguages) model).setRecordNum(rs.getInt("RECORD_NUM"));
((GuiLanguages) model).setSetKey(rs.getShort("SET_KEY"));
((GuiLanguages) model).setCommitPid(rs.getInt("COMMIT_PID"));
((GuiLanguages) model).setGuiLanguagePid(rs.getInt("GUI_LANGUAGE_PID"));
((GuiLanguages) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((GuiLanguages) model).setGuiLanguage(rs.getString("GUI_LANGUAGE"));
((GuiLanguages) model).setData1Language(rs.getString("DATA1_LANGUAGE"));
((GuiLanguages) model).setData2Language(rs.getString("DATA2_LANGUAGE"));
((GuiLanguages) model).setReportLanguage(rs.getString("REPORT_LANGUAGE"));
((GuiLanguages) model).setDfltLanguage(rs.getString("DFLT_LANGUAGE"));
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

public int getGuiLanguagePid() {
return this.GuiLanguagePid;
}

public short getReminderKey() {
return this.ReminderKey;
}

public String getGuiLanguage() {
return this.GuiLanguage;
}

public String getData1Language() {
return this.Data1Language;
}

public String getData2Language() {
return this.Data2Language;
}

public String getReportLanguage() {
return this.ReportLanguage;
}

public String getDfltLanguage() {
return this.DfltLanguage;
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

public void setGuiLanguagePid(int GuiLanguagePid) {
this.GuiLanguagePid = GuiLanguagePid;
}

public void setReminderKey(short ReminderKey) {
this.ReminderKey = ReminderKey;
}

public void setGuiLanguage(String GuiLanguage) {
this.GuiLanguage = GuiLanguage;
}

public void setData1Language(String Data1Language) {
this.Data1Language = Data1Language;
}

public void setData2Language(String Data2Language) {
this.Data2Language = Data2Language;
}

public void setReportLanguage(String ReportLanguage) {
this.ReportLanguage = ReportLanguage;
}

public void setDfltLanguage(String DfltLanguage) {
this.DfltLanguage = DfltLanguage;
}

}

