package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SCRIPT_TRANS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class ScriptTrans extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SCRIPT_TRAN_PID, " +
"PARENT_PID, " +
"LANG_CODE, " +
"SCRIPT FROM PUBLIC.SCRIPT_TRANS WHERE SCRIPT_TRAN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SCRIPT_TRAN_PID, " +  
"PARENT_PID, " +  
"LANG_CODE, " +  
"SCRIPT FROM PUBLIC.SCRIPT_TRANS";

private static final String INSERT = "INSERT INTO PUBLIC.SCRIPT_TRANS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SCRIPT_TRAN_PID, " +     
"PARENT_PID, " +     
"LANG_CODE, " +     
"SCRIPT) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SCRIPT_TRANSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"PARENT_PID = ?, " + 
"LANG_CODE = ?, " + 
"SCRIPT = ? WHERE SCRIPT_TRAN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SCRIPT_TRANS WHERE SCRIPT_TRAN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SCRIPT_TRANS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int ScriptTranPid;
private int ParentPid;
private String LangCode;
private String Script;
private ScriptTrans model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public ScriptTrans() throws SQLException {
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
model = new ScriptTrans();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setScriptTranPid(rs.getInt("SCRIPT_TRAN_PID"));
model.setParentPid(rs.getInt("PARENT_PID"));
model.setLangCode(rs.getString("LANG_CODE"));
model.setScript(rs.getString("SCRIPT"));
modelList.add(model);
}
return modelList;
}

@Override
public ScriptTrans get(int key) throws SQLException {
model = new ScriptTrans();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setScriptTranPid(rs.getInt("SCRIPT_TRAN_PID"));
model.setParentPid(rs.getInt("PARENT_PID"));
model.setLangCode(rs.getString("LANG_CODE"));
model.setScript(rs.getString("SCRIPT"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((ScriptTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ScriptTrans) model).setSetKey(rs.getShort("SET_KEY"));
((ScriptTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ScriptTrans) model).setScriptTranPid(rs.getInt("SCRIPT_TRAN_PID"));
((ScriptTrans) model).setParentPid(rs.getInt("PARENT_PID"));
((ScriptTrans) model).setLangCode(rs.getString("LANG_CODE"));
((ScriptTrans) model).setScript(rs.getString("SCRIPT"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((ScriptTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ScriptTrans) model).setSetKey(rs.getShort("SET_KEY"));
((ScriptTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ScriptTrans) model).setScriptTranPid(rs.getInt("SCRIPT_TRAN_PID"));
((ScriptTrans) model).setParentPid(rs.getInt("PARENT_PID"));
((ScriptTrans) model).setLangCode(rs.getString("LANG_CODE"));
((ScriptTrans) model).setScript(rs.getString("SCRIPT"));
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
* Get the ScriptTranPid field.
*
* @return Contents of the SCRIPT_TRAN_PID column
*/
public int getScriptTranPid() {
return this.ScriptTranPid;
}

/**
* Get the ParentPid field.
*
* @return Contents of the PARENT_PID column
*/
public int getParentPid() {
return this.ParentPid;
}

/**
* Get the LangCode field.
*
* @return Contents of the LANG_CODE column
*/
public String getLangCode() {
return this.LangCode;
}

/**
* Get the Script field.
*
* @return Contents of the SCRIPT column
*/
public String getScript() {
return this.Script;
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
* Set the ScriptTranPid field
*
* @param ScriptTranPid Contents of the SCRIPT_TRAN_PID column
*/
public void setScriptTranPid(int ScriptTranPid) {
this.ScriptTranPid = ScriptTranPid;
}

/**
* Set the ParentPid field
*
* @param ParentPid Contents of the PARENT_PID column
*/
public void setParentPid(int ParentPid) {
this.ParentPid = ParentPid;
}

/**
* Set the LangCode field
*
* @param LangCode Contents of the LANG_CODE column
*/
public void setLangCode(String LangCode) {
this.LangCode = LangCode;
}

/**
* Set the Script field
*
* @param Script Contents of the SCRIPT column
*/
public void setScript(String Script) {
this.Script = Script;
}

}

