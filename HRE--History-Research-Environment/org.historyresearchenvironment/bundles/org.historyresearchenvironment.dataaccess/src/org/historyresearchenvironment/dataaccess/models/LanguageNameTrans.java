package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the LANGUAGE_NAME_TRANS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class LanguageNameTrans extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"LANGUAGE_NAME_TRAN_PID, " +
"TO_LANGUAGE, " +
"FROM_LANGUAGE, " +
"TRANSLATION FROM PUBLIC.LANGUAGE_NAME_TRANS WHERE LANGUAGE_NAME_TRAN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"LANGUAGE_NAME_TRAN_PID, " +  
"TO_LANGUAGE, " +  
"FROM_LANGUAGE, " +  
"TRANSLATION FROM PUBLIC.LANGUAGE_NAME_TRANS";

private static final String INSERT = "INSERT INTO PUBLIC.LANGUAGE_NAME_TRANS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"LANGUAGE_NAME_TRAN_PID, " +     
"TO_LANGUAGE, " +     
"FROM_LANGUAGE, " +     
"TRANSLATION) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.LANGUAGE_NAME_TRANSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"TO_LANGUAGE = ?, " + 
"FROM_LANGUAGE = ?, " + 
"TRANSLATION = ? WHERE LANGUAGE_NAME_TRAN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.LANGUAGE_NAME_TRANS WHERE LANGUAGE_NAME_TRAN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.LANGUAGE_NAME_TRANS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int LanguageNameTranPid;
private String ToLanguage;
private String FromLanguage;
private String Translation;
private LanguageNameTrans model;

public LanguageNameTrans() throws SQLException {
}


public LanguageNameTrans(int LanguageNameTranPid) throws SQLException {
super();
this.LanguageNameTranPid = LanguageNameTranPid;
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
model = new LanguageNameTrans();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setLanguageNameTranPid(rs.getInt("LANGUAGE_NAME_TRAN_PID"));
model.setToLanguage(rs.getString("TO_LANGUAGE"));
model.setFromLanguage(rs.getString("FROM_LANGUAGE"));
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
model.setLanguageNameTranPid(rs.getInt("LANGUAGE_NAME_TRAN_PID"));
model.setToLanguage(rs.getString("TO_LANGUAGE"));
model.setFromLanguage(rs.getString("FROM_LANGUAGE"));
model.setTranslation(rs.getString("TRANSLATION"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((LanguageNameTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
((LanguageNameTrans) model).setSetKey(rs.getShort("SET_KEY"));
((LanguageNameTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
((LanguageNameTrans) model).setLanguageNameTranPid(rs.getInt("LANGUAGE_NAME_TRAN_PID"));
((LanguageNameTrans) model).setToLanguage(rs.getString("TO_LANGUAGE"));
((LanguageNameTrans) model).setFromLanguage(rs.getString("FROM_LANGUAGE"));
((LanguageNameTrans) model).setTranslation(rs.getString("TRANSLATION"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((LanguageNameTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
((LanguageNameTrans) model).setSetKey(rs.getShort("SET_KEY"));
((LanguageNameTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
((LanguageNameTrans) model).setLanguageNameTranPid(rs.getInt("LANGUAGE_NAME_TRAN_PID"));
((LanguageNameTrans) model).setToLanguage(rs.getString("TO_LANGUAGE"));
((LanguageNameTrans) model).setFromLanguage(rs.getString("FROM_LANGUAGE"));
((LanguageNameTrans) model).setTranslation(rs.getString("TRANSLATION"));
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

public int getLanguageNameTranPid() {
return this.LanguageNameTranPid;
}

public String getToLanguage() {
return this.ToLanguage;
}

public String getFromLanguage() {
return this.FromLanguage;
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

public void setLanguageNameTranPid(int LanguageNameTranPid) {
this.LanguageNameTranPid = LanguageNameTranPid;
}

public void setToLanguage(String ToLanguage) {
this.ToLanguage = ToLanguage;
}

public void setFromLanguage(String FromLanguage) {
this.FromLanguage = FromLanguage;
}

public void setTranslation(String Translation) {
this.Translation = Translation;
}

}

