package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the COMMIT_LOGS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class CommitLogs extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"COMMIT_LOG_PID, " +
"COMMENCED, " +
"COMPLETED, " +
"USER_PID, " +
"CLIENT_PID, " +
"NUM_TABLES FROM PUBLIC.COMMIT_LOGS WHERE COMMIT_LOG_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"COMMIT_LOG_PID, " +  
"COMMENCED, " +  
"COMPLETED, " +  
"USER_PID, " +  
"CLIENT_PID, " +  
"NUM_TABLES FROM PUBLIC.COMMIT_LOGS";

private static final String INSERT = "INSERT INTO PUBLIC.COMMIT_LOGS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"COMMIT_LOG_PID, " +     
"COMMENCED, " +     
"COMPLETED, " +     
"USER_PID, " +     
"CLIENT_PID, " +     
"NUM_TABLES) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.COMMIT_LOGSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"COMMENCED = ?, " + 
"COMPLETED = ?, " + 
"USER_PID = ?, " + 
"CLIENT_PID = ?, " + 
"NUM_TABLES = ? WHERE COMMIT_LOG_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.COMMIT_LOGS WHERE COMMIT_LOG_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.COMMIT_LOGS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int CommitLogPid;
private timestamp Commenced;
private timestamp Completed;
private int UserPid;
private int ClientPid;
private short NumTables;
private CommitLogs model;

public CommitLogs() throws SQLException {
}


public CommitLogs(int CommitLogPid) throws SQLException {
super();
this.CommitLogPid = CommitLogPid;
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
model = new CommitLogs();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setCommitLogPid(rs.getInt("COMMIT_LOG_PID"));
model.setCommenced(rs.getTimestamp("COMMENCED"));
model.setCompleted(rs.getTimestamp("COMPLETED"));
model.setUserPid(rs.getInt("USER_PID"));
model.setClientPid(rs.getInt("CLIENT_PID"));
model.setNumTables(rs.getShort("NUM_TABLES"));
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
model.setCommitLogPid(rs.getInt("COMMIT_LOG_PID"));
model.setCommenced(rs.getTimestamp("COMMENCED"));
model.setCompleted(rs.getTimestamp("COMPLETED"));
model.setUserPid(rs.getInt("USER_PID"));
model.setClientPid(rs.getInt("CLIENT_PID"));
model.setNumTables(rs.getShort("NUM_TABLES"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((CommitLogs) model).setRecordNum(rs.getInt("RECORD_NUM"));
((CommitLogs) model).setSetKey(rs.getShort("SET_KEY"));
((CommitLogs) model).setCommitPid(rs.getInt("COMMIT_PID"));
((CommitLogs) model).setCommitLogPid(rs.getInt("COMMIT_LOG_PID"));
((CommitLogs) model).setCommenced(rs.getTimestamp("COMMENCED"));
((CommitLogs) model).setCompleted(rs.getTimestamp("COMPLETED"));
((CommitLogs) model).setUserPid(rs.getInt("USER_PID"));
((CommitLogs) model).setClientPid(rs.getInt("CLIENT_PID"));
((CommitLogs) model).setNumTables(rs.getShort("NUM_TABLES"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((CommitLogs) model).setRecordNum(rs.getInt("RECORD_NUM"));
((CommitLogs) model).setSetKey(rs.getShort("SET_KEY"));
((CommitLogs) model).setCommitPid(rs.getInt("COMMIT_PID"));
((CommitLogs) model).setCommitLogPid(rs.getInt("COMMIT_LOG_PID"));
((CommitLogs) model).setCommenced(rs.getTimestamp("COMMENCED"));
((CommitLogs) model).setCompleted(rs.getTimestamp("COMPLETED"));
((CommitLogs) model).setUserPid(rs.getInt("USER_PID"));
((CommitLogs) model).setClientPid(rs.getInt("CLIENT_PID"));
((CommitLogs) model).setNumTables(rs.getShort("NUM_TABLES"));
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

public int getCommitLogPid() {
return this.CommitLogPid;
}

public timestamp getCommenced() {
return this.Commenced;
}

public timestamp getCompleted() {
return this.Completed;
}

public int getUserPid() {
return this.UserPid;
}

public int getClientPid() {
return this.ClientPid;
}

public short getNumTables() {
return this.NumTables;
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

public void setCommitLogPid(int CommitLogPid) {
this.CommitLogPid = CommitLogPid;
}

public void setCommenced(timestamp Commenced) {
this.Commenced = Commenced;
}

public void setCompleted(timestamp Completed) {
this.Completed = Completed;
}

public void setUserPid(int UserPid) {
this.UserPid = UserPid;
}

public void setClientPid(int ClientPid) {
this.ClientPid = ClientPid;
}

public void setNumTables(short NumTables) {
this.NumTables = NumTables;
}

}

