package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the LANGUAGE_USES database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class LanguageUses extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"LANGUAGE_USE_PID, " +
"GUI_LANGUAGE, " +
"DATA1_LANGUAGE, " +
"DATA2_LANGUAGE, " +
"REPORT_LANGUAGE, " +
"DFLT_LANGUAGE FROM PUBLIC.LANGUAGE_USES WHERE LANGUAGE_USE_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"LANGUAGE_USE_PID, " +  
"GUI_LANGUAGE, " +  
"DATA1_LANGUAGE, " +  
"DATA2_LANGUAGE, " +  
"REPORT_LANGUAGE, " +  
"DFLT_LANGUAGE FROM PUBLIC.LANGUAGE_USES";

private static final String INSERT = "INSERT INTO PUBLIC.LANGUAGE_USES( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"LANGUAGE_USE_PID, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.LANGUAGE_USESSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"GUI_LANGUAGE = ?, " + 
"DATA1_LANGUAGE = ?, " + 
"DATA2_LANGUAGE = ?, " + 
"REPORT_LANGUAGE = ?, " + 
"DFLT_LANGUAGE = ? WHERE LANGUAGE_USE_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.LANGUAGE_USES WHERE LANGUAGE_USE_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.LANGUAGE_USES";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int LanguageUsePid;
private String GuiLanguage;
private String Data1Language;
private String Data2Language;
private String ReportLanguage;
private String DfltLanguage;
private LanguageUses model;

public LanguageUses() throws SQLException {
}


public LanguageUses(int LanguageUsePid) throws SQLException {
super();
this.LanguageUsePid = LanguageUsePid;
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
model = new LanguageUses();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setLanguageUsePid(rs.getInt("LANGUAGE_USE_PID"));
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
model.setLanguageUsePid(rs.getInt("LANGUAGE_USE_PID"));
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
((LanguageUses) model).setRecordNum(rs.getInt("RECORD_NUM"));
((LanguageUses) model).setSetKey(rs.getShort("SET_KEY"));
((LanguageUses) model).setCommitPid(rs.getInt("COMMIT_PID"));
((LanguageUses) model).setLanguageUsePid(rs.getInt("LANGUAGE_USE_PID"));
((LanguageUses) model).setGuiLanguage(rs.getString("GUI_LANGUAGE"));
((LanguageUses) model).setData1Language(rs.getString("DATA1_LANGUAGE"));
((LanguageUses) model).setData2Language(rs.getString("DATA2_LANGUAGE"));
((LanguageUses) model).setReportLanguage(rs.getString("REPORT_LANGUAGE"));
((LanguageUses) model).setDfltLanguage(rs.getString("DFLT_LANGUAGE"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((LanguageUses) model).setRecordNum(rs.getInt("RECORD_NUM"));
((LanguageUses) model).setSetKey(rs.getShort("SET_KEY"));
((LanguageUses) model).setCommitPid(rs.getInt("COMMIT_PID"));
((LanguageUses) model).setLanguageUsePid(rs.getInt("LANGUAGE_USE_PID"));
((LanguageUses) model).setGuiLanguage(rs.getString("GUI_LANGUAGE"));
((LanguageUses) model).setData1Language(rs.getString("DATA1_LANGUAGE"));
((LanguageUses) model).setData2Language(rs.getString("DATA2_LANGUAGE"));
((LanguageUses) model).setReportLanguage(rs.getString("REPORT_LANGUAGE"));
((LanguageUses) model).setDfltLanguage(rs.getString("DFLT_LANGUAGE"));
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

public int getLanguageUsePid() {
return this.LanguageUsePid;
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

public void setLanguageUsePid(int LanguageUsePid) {
this.LanguageUsePid = LanguageUsePid;
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

