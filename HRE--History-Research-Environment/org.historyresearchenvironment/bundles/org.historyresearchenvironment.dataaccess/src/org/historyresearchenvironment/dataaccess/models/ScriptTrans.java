package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SCRIPT_TRANS database table.
*
* @version 2018-08-02
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

public ScriptTrans() throws SQLException {
}


public ScriptTrans(int ScriptTranPid) throws SQLException {
super();
this.ScriptTranPid = ScriptTranPid;
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
public AbstractHreDataModel get(int key) throws SQLException {
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
return this;
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

public int getRecordNum() {
return this.RecordNum;
}

public short getSetKey() {
return this.SetKey;
}

public int getCommitPid() {
return this.CommitPid;
}

public int getScriptTranPid() {
return this.ScriptTranPid;
}

public int getParentPid() {
return this.ParentPid;
}

public String getLangCode() {
return this.LangCode;
}

public String getScript() {
return this.Script;
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

public void setScriptTranPid(int ScriptTranPid) {
this.ScriptTranPid = ScriptTranPid;
}

public void setParentPid(int ParentPid) {
this.ParentPid = ParentPid;
}

public void setLangCode(String LangCode) {
this.LangCode = LangCode;
}

public void setScript(String Script) {
this.Script = Script;
}

}

