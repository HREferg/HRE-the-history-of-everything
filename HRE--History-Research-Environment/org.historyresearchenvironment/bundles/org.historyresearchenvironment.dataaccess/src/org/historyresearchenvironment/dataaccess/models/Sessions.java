package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SESSIONS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class Sessions extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SESSION_PID, " +
"PROJECT_PID, " +
"USER_PID, " +
"TIME_OPENED, " +
"TIME_CLOSED, " +
"COMMIT_NUM FROM PUBLIC.SESSIONS WHERE SESSION_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SESSION_PID, " +  
"PROJECT_PID, " +  
"USER_PID, " +  
"TIME_OPENED, " +  
"TIME_CLOSED, " +  
"COMMIT_NUM FROM PUBLIC.SESSIONS";

private static final String INSERT = "INSERT INTO PUBLIC.SESSIONS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SESSION_PID, " +     
"PROJECT_PID, " +     
"USER_PID, " +     
"TIME_OPENED, " +     
"TIME_CLOSED, " +     
"COMMIT_NUM) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SESSIONSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"PROJECT_PID = ?, " + 
"USER_PID = ?, " + 
"TIME_OPENED = ?, " + 
"TIME_CLOSED = ?, " + 
"COMMIT_NUM = ? WHERE SESSION_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SESSIONS WHERE SESSION_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SESSIONS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SessionPid;
private int ProjectPid;
private int UserPid;
private Timestamp TimeOpened;
private Timestamp TimeClosed;
private int CommitNum;
private Sessions model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public Sessions() throws SQLException {
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
model = new Sessions();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSessionPid(rs.getInt("SESSION_PID"));
model.setProjectPid(rs.getInt("PROJECT_PID"));
model.setUserPid(rs.getInt("USER_PID"));
model.setTimeOpened(rs.getTimestamp("TIME_OPENED"));
model.setTimeClosed(rs.getTimestamp("TIME_CLOSED"));
model.setCommitNum(rs.getInt("COMMIT_NUM"));
modelList.add(model);
}
return modelList;
}

@Override
public Sessions get(int key) throws SQLException {
model = new Sessions();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSessionPid(rs.getInt("SESSION_PID"));
model.setProjectPid(rs.getInt("PROJECT_PID"));
model.setUserPid(rs.getInt("USER_PID"));
model.setTimeOpened(rs.getTimestamp("TIME_OPENED"));
			model.setTimeClosed(rs.getTimestamp("TIME_CLOSED"));
model.setCommitNum(rs.getInt("COMMIT_NUM"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((Sessions) model).setRecordNum(rs.getInt("RECORD_NUM"));
((Sessions) model).setSetKey(rs.getShort("SET_KEY"));
((Sessions) model).setCommitPid(rs.getInt("COMMIT_PID"));
((Sessions) model).setSessionPid(rs.getInt("SESSION_PID"));
((Sessions) model).setProjectPid(rs.getInt("PROJECT_PID"));
((Sessions) model).setUserPid(rs.getInt("USER_PID"));
((Sessions) model).setTimeOpened(rs.getTimestamp("TIME_OPENED"));
((Sessions) model).setTimeClosed(rs.getTimestamp("TIME_CLOSED"));
((Sessions) model).setCommitNum(rs.getInt("COMMIT_NUM"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((Sessions) model).setRecordNum(rs.getInt("RECORD_NUM"));
((Sessions) model).setSetKey(rs.getShort("SET_KEY"));
((Sessions) model).setCommitPid(rs.getInt("COMMIT_PID"));
((Sessions) model).setSessionPid(rs.getInt("SESSION_PID"));
((Sessions) model).setProjectPid(rs.getInt("PROJECT_PID"));
((Sessions) model).setUserPid(rs.getInt("USER_PID"));
((Sessions) model).setTimeOpened(rs.getTimestamp("TIME_OPENED"));
((Sessions) model).setTimeClosed(rs.getTimestamp("TIME_CLOSED"));
((Sessions) model).setCommitNum(rs.getInt("COMMIT_NUM"));
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
* Get the SessionPid field.
*
* @return Contents of the SESSION_PID column
*/
public int getSessionPid() {
return this.SessionPid;
}

/**
* Get the ProjectPid field.
*
* @return Contents of the PROJECT_PID column
*/
public int getProjectPid() {
return this.ProjectPid;
}

/**
* Get the UserPid field.
*
* @return Contents of the USER_PID column
*/
public int getUserPid() {
return this.UserPid;
}

/**
* Get the TimeOpened field.
*
* @return Contents of the TIME_OPENED column
*/
public Timestamp getTimeOpened() {
return this.TimeOpened;
}

/**
* Get the TimeClosed field.
*
* @return Contents of the TIME_CLOSED column
*/
public Timestamp getTimeClosed() {
return this.TimeClosed;
}

/**
* Get the CommitNum field.
*
* @return Contents of the COMMIT_NUM column
*/
public int getCommitNum() {
return this.CommitNum;
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
* Set the SessionPid field
*
* @param SessionPid Contents of the SESSION_PID column
*/
public void setSessionPid(int SessionPid) {
this.SessionPid = SessionPid;
}

/**
* Set the ProjectPid field
*
* @param ProjectPid Contents of the PROJECT_PID column
*/
public void setProjectPid(int ProjectPid) {
this.ProjectPid = ProjectPid;
}

/**
* Set the UserPid field
*
* @param UserPid Contents of the USER_PID column
*/
public void setUserPid(int UserPid) {
this.UserPid = UserPid;
}

/**
* Set the TimeOpened field
*
* @param TimeOpened Contents of the TIME_OPENED column
*/
public void setTimeOpened(Timestamp TimeOpened) {
this.TimeOpened = TimeOpened;
}

/**
* Set the TimeClosed field
*
* @param TimeClosed Contents of the TIME_CLOSED column
*/
public void setTimeClosed(Timestamp TimeClosed) {
this.TimeClosed = TimeClosed;
}

/**
* Set the CommitNum field
*
* @param CommitNum Contents of the COMMIT_NUM column
*/
public void setCommitNum(int CommitNum) {
this.CommitNum = CommitNum;
}

}

