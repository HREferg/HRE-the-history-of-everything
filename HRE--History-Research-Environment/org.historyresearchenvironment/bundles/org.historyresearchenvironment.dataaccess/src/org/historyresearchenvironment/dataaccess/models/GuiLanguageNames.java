package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the GUI_LANGUAGE_NAMES database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class GuiLanguageNames extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"GUI_LANGUAGE_NAME_PID, " +
"FROM_LANGUAGE, " +
"TO_LANGUAGE, " +
"TRANSLATION FROM PUBLIC.GUI_LANGUAGE_NAMES WHERE GUI_LANGUAGE_NAME_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"GUI_LANGUAGE_NAME_PID, " +  
"FROM_LANGUAGE, " +  
"TO_LANGUAGE, " +  
"TRANSLATION FROM PUBLIC.GUI_LANGUAGE_NAMES";

private static final String INSERT = "INSERT INTO PUBLIC.GUI_LANGUAGE_NAMES( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"GUI_LANGUAGE_NAME_PID, " +     
"FROM_LANGUAGE, " +     
"TO_LANGUAGE, " +     
"TRANSLATION) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.GUI_LANGUAGE_NAMESSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"FROM_LANGUAGE = ?, " + 
"TO_LANGUAGE = ?, " + 
"TRANSLATION = ? WHERE GUI_LANGUAGE_NAME_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.GUI_LANGUAGE_NAMES WHERE GUI_LANGUAGE_NAME_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.GUI_LANGUAGE_NAMES";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int GuiLanguageNamePid;
private String FromLanguage;
private String ToLanguage;
private String Translation;
private GuiLanguageNames model;

public GuiLanguageNames() throws SQLException {
}


public GuiLanguageNames(int GuiLanguageNamePid) throws SQLException {
super();
this.GuiLanguageNamePid = GuiLanguageNamePid;
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
model = new GuiLanguageNames();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setGuiLanguageNamePid(rs.getInt("GUI_LANGUAGE_NAME_PID"));
model.setFromLanguage(rs.getString("FROM_LANGUAGE"));
model.setToLanguage(rs.getString("TO_LANGUAGE"));
model.setTranslation(rs.getString("TRANSLATION"));
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
model.setGuiLanguageNamePid(rs.getInt("GUI_LANGUAGE_NAME_PID"));
model.setFromLanguage(rs.getString("FROM_LANGUAGE"));
model.setToLanguage(rs.getString("TO_LANGUAGE"));
model.setTranslation(rs.getString("TRANSLATION"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((GuiLanguageNames) model).setRecordNum(rs.getInt("RECORD_NUM"));
((GuiLanguageNames) model).setSetKey(rs.getShort("SET_KEY"));
((GuiLanguageNames) model).setCommitPid(rs.getInt("COMMIT_PID"));
((GuiLanguageNames) model).setGuiLanguageNamePid(rs.getInt("GUI_LANGUAGE_NAME_PID"));
((GuiLanguageNames) model).setFromLanguage(rs.getString("FROM_LANGUAGE"));
((GuiLanguageNames) model).setToLanguage(rs.getString("TO_LANGUAGE"));
((GuiLanguageNames) model).setTranslation(rs.getString("TRANSLATION"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((GuiLanguageNames) model).setRecordNum(rs.getInt("RECORD_NUM"));
((GuiLanguageNames) model).setSetKey(rs.getShort("SET_KEY"));
((GuiLanguageNames) model).setCommitPid(rs.getInt("COMMIT_PID"));
((GuiLanguageNames) model).setGuiLanguageNamePid(rs.getInt("GUI_LANGUAGE_NAME_PID"));
((GuiLanguageNames) model).setFromLanguage(rs.getString("FROM_LANGUAGE"));
((GuiLanguageNames) model).setToLanguage(rs.getString("TO_LANGUAGE"));
((GuiLanguageNames) model).setTranslation(rs.getString("TRANSLATION"));
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

public int getGuiLanguageNamePid() {
return this.GuiLanguageNamePid;
}

public String getFromLanguage() {
return this.FromLanguage;
}

public String getToLanguage() {
return this.ToLanguage;
}

public String getTranslation() {
return this.Translation;
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

public void setGuiLanguageNamePid(int GuiLanguageNamePid) {
this.GuiLanguageNamePid = GuiLanguageNamePid;
}

public void setFromLanguage(String FromLanguage) {
this.FromLanguage = FromLanguage;
}

public void setToLanguage(String ToLanguage) {
this.ToLanguage = ToLanguage;
}

public void setTranslation(String Translation) {
this.Translation = Translation;
}

}

