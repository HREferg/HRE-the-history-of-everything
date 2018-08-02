package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the MEMO_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class MemoDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"MEMO_DEFN_PID, " +
"IS_SYSTEM, " +
"PLUGIN_KEY, " +
"MEMO_SET_KEY, " +
"REQUESTER_TYPE_KEY, " +
"REQUESTER_SUB_TYPE_KEY, " +
"REQUESTER_PID, " +
"PUBLISH_TYPE_KEY FROM PUBLIC.MEMO_DEFNS WHERE MEMO_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"MEMO_DEFN_PID, " +  
"IS_SYSTEM, " +  
"PLUGIN_KEY, " +  
"MEMO_SET_KEY, " +  
"REQUESTER_TYPE_KEY, " +  
"REQUESTER_SUB_TYPE_KEY, " +  
"REQUESTER_PID, " +  
"PUBLISH_TYPE_KEY FROM PUBLIC.MEMO_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.MEMO_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"MEMO_DEFN_PID, " +     
"IS_SYSTEM, " +     
"PLUGIN_KEY, " +     
"MEMO_SET_KEY, " +     
"REQUESTER_TYPE_KEY, " +     
"REQUESTER_SUB_TYPE_KEY, " +     
"REQUESTER_PID, " +     
"PUBLISH_TYPE_KEY) VALUES (?, " +
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

private static final String UPDATE = "UPDATE PUBLIC.MEMO_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PLUGIN_KEY = ?, " + 
"MEMO_SET_KEY = ?, " + 
"REQUESTER_TYPE_KEY = ?, " + 
"REQUESTER_SUB_TYPE_KEY = ?, " + 
"REQUESTER_PID = ?, " + 
"PUBLISH_TYPE_KEY = ? WHERE MEMO_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.MEMO_DEFNS WHERE MEMO_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.MEMO_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int MemoDefnPid;
private boolean IsSystem;
private short PluginKey;
private short MemoSetKey;
private short RequesterTypeKey;
private short RequesterSubTypeKey;
private int RequesterPid;
private short PublishTypeKey;
private MemoDefns model;

public MemoDefns() throws SQLException {
}


public MemoDefns(int MemoDefnPid) throws SQLException {
super();
this.MemoDefnPid = MemoDefnPid;
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
model = new MemoDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setMemoDefnPid(rs.getInt("MEMO_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setPluginKey(rs.getShort("PLUGIN_KEY"));
model.setMemoSetKey(rs.getShort("MEMO_SET_KEY"));
model.setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
model.setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
model.setRequesterPid(rs.getInt("REQUESTER_PID"));
model.setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
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
model.setMemoDefnPid(rs.getInt("MEMO_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setPluginKey(rs.getShort("PLUGIN_KEY"));
model.setMemoSetKey(rs.getShort("MEMO_SET_KEY"));
model.setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
model.setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
model.setRequesterPid(rs.getInt("REQUESTER_PID"));
model.setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((MemoDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((MemoDefns) model).setSetKey(rs.getShort("SET_KEY"));
((MemoDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((MemoDefns) model).setMemoDefnPid(rs.getInt("MEMO_DEFN_PID"));
((MemoDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((MemoDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
((MemoDefns) model).setMemoSetKey(rs.getShort("MEMO_SET_KEY"));
((MemoDefns) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
((MemoDefns) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
((MemoDefns) model).setRequesterPid(rs.getInt("REQUESTER_PID"));
((MemoDefns) model).setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((MemoDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((MemoDefns) model).setSetKey(rs.getShort("SET_KEY"));
((MemoDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((MemoDefns) model).setMemoDefnPid(rs.getInt("MEMO_DEFN_PID"));
((MemoDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((MemoDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
((MemoDefns) model).setMemoSetKey(rs.getShort("MEMO_SET_KEY"));
((MemoDefns) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
((MemoDefns) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
((MemoDefns) model).setRequesterPid(rs.getInt("REQUESTER_PID"));
((MemoDefns) model).setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
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

public int getMemoDefnPid() {
return this.MemoDefnPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public short getPluginKey() {
return this.PluginKey;
}

public short getMemoSetKey() {
return this.MemoSetKey;
}

public short getRequesterTypeKey() {
return this.RequesterTypeKey;
}

public short getRequesterSubTypeKey() {
return this.RequesterSubTypeKey;
}

public int getRequesterPid() {
return this.RequesterPid;
}

public short getPublishTypeKey() {
return this.PublishTypeKey;
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

public void setMemoDefnPid(int MemoDefnPid) {
this.MemoDefnPid = MemoDefnPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setPluginKey(short PluginKey) {
this.PluginKey = PluginKey;
}

public void setMemoSetKey(short MemoSetKey) {
this.MemoSetKey = MemoSetKey;
}

public void setRequesterTypeKey(short RequesterTypeKey) {
this.RequesterTypeKey = RequesterTypeKey;
}

public void setRequesterSubTypeKey(short RequesterSubTypeKey) {
this.RequesterSubTypeKey = RequesterSubTypeKey;
}

public void setRequesterPid(int RequesterPid) {
this.RequesterPid = RequesterPid;
}

public void setPublishTypeKey(short PublishTypeKey) {
this.PublishTypeKey = PublishTypeKey;
}

}

