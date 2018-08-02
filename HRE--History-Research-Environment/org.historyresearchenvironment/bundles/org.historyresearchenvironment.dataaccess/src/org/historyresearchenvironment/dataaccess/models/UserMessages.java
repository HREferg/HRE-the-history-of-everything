package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the USER_MESSAGES database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class UserMessages extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"USER_MESSAGE_PID, " +
"FROM_USER_PID, " +
"TO_USER_PID, " +
"TIME_SENT, " +
"MESSAGE, " +
"IS_READ, " +
"IS_ACKD, " +
"REPLIED FROM PUBLIC.USER_MESSAGES WHERE USER_MESSAGE_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"USER_MESSAGE_PID, " +  
"FROM_USER_PID, " +  
"TO_USER_PID, " +  
"TIME_SENT, " +  
"MESSAGE, " +  
"IS_READ, " +  
"IS_ACKD, " +  
"REPLIED FROM PUBLIC.USER_MESSAGES";

private static final String INSERT = "INSERT INTO PUBLIC.USER_MESSAGES( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"USER_MESSAGE_PID, " +     
"FROM_USER_PID, " +     
"TO_USER_PID, " +     
"TIME_SENT, " +     
"MESSAGE, " +     
"IS_READ, " +     
"IS_ACKD, " +     
"REPLIED) VALUES (?, " +
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

private static final String UPDATE = "UPDATE PUBLIC.USER_MESSAGESSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"FROM_USER_PID = ?, " + 
"TO_USER_PID = ?, " + 
"TIME_SENT = ?, " + 
"MESSAGE = ?, " + 
"IS_READ = ?, " + 
"IS_ACKD = ?, " + 
"REPLIED = ? WHERE USER_MESSAGE_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.USER_MESSAGES WHERE USER_MESSAGE_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.USER_MESSAGES";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int UserMessagePid;
private int FromUserPid;
private int ToUserPid;
private timestamp TimeSent;
private String Message;
private boolean IsRead;
private boolean IsAckd;
private boolean Replied;
private UserMessages model;

public UserMessages() throws SQLException {
}


public UserMessages(int UserMessagePid) throws SQLException {
super();
this.UserMessagePid = UserMessagePid;
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
model = new UserMessages();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setUserMessagePid(rs.getInt("USER_MESSAGE_PID"));
model.setFromUserPid(rs.getInt("FROM_USER_PID"));
model.setToUserPid(rs.getInt("TO_USER_PID"));
model.setTimeSent(rs.getTimestamp("TIME_SENT"));
model.setMessage(rs.getString("MESSAGE"));
model.setIsRead(rs.getBoolean("IS_READ"));
model.setIsAckd(rs.getBoolean("IS_ACKD"));
model.setReplied(rs.getBoolean("REPLIED"));
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
model.setUserMessagePid(rs.getInt("USER_MESSAGE_PID"));
model.setFromUserPid(rs.getInt("FROM_USER_PID"));
model.setToUserPid(rs.getInt("TO_USER_PID"));
model.setTimeSent(rs.getTimestamp("TIME_SENT"));
model.setMessage(rs.getString("MESSAGE"));
model.setIsRead(rs.getBoolean("IS_READ"));
model.setIsAckd(rs.getBoolean("IS_ACKD"));
model.setReplied(rs.getBoolean("REPLIED"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((UserMessages) model).setRecordNum(rs.getInt("RECORD_NUM"));
((UserMessages) model).setSetKey(rs.getShort("SET_KEY"));
((UserMessages) model).setCommitPid(rs.getInt("COMMIT_PID"));
((UserMessages) model).setUserMessagePid(rs.getInt("USER_MESSAGE_PID"));
((UserMessages) model).setFromUserPid(rs.getInt("FROM_USER_PID"));
((UserMessages) model).setToUserPid(rs.getInt("TO_USER_PID"));
((UserMessages) model).setTimeSent(rs.getTimestamp("TIME_SENT"));
((UserMessages) model).setMessage(rs.getString("MESSAGE"));
((UserMessages) model).setIsRead(rs.getBoolean("IS_READ"));
((UserMessages) model).setIsAckd(rs.getBoolean("IS_ACKD"));
((UserMessages) model).setReplied(rs.getBoolean("REPLIED"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((UserMessages) model).setRecordNum(rs.getInt("RECORD_NUM"));
((UserMessages) model).setSetKey(rs.getShort("SET_KEY"));
((UserMessages) model).setCommitPid(rs.getInt("COMMIT_PID"));
((UserMessages) model).setUserMessagePid(rs.getInt("USER_MESSAGE_PID"));
((UserMessages) model).setFromUserPid(rs.getInt("FROM_USER_PID"));
((UserMessages) model).setToUserPid(rs.getInt("TO_USER_PID"));
((UserMessages) model).setTimeSent(rs.getTimestamp("TIME_SENT"));
((UserMessages) model).setMessage(rs.getString("MESSAGE"));
((UserMessages) model).setIsRead(rs.getBoolean("IS_READ"));
((UserMessages) model).setIsAckd(rs.getBoolean("IS_ACKD"));
((UserMessages) model).setReplied(rs.getBoolean("REPLIED"));
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

public int getUserMessagePid() {
return this.UserMessagePid;
}

public int getFromUserPid() {
return this.FromUserPid;
}

public int getToUserPid() {
return this.ToUserPid;
}

public timestamp getTimeSent() {
return this.TimeSent;
}

public String getMessage() {
return this.Message;
}

public boolean getIsRead() {
return this.IsRead;
}

public boolean getIsAckd() {
return this.IsAckd;
}

public boolean getReplied() {
return this.Replied;
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

public void setUserMessagePid(int UserMessagePid) {
this.UserMessagePid = UserMessagePid;
}

public void setFromUserPid(int FromUserPid) {
this.FromUserPid = FromUserPid;
}

public void setToUserPid(int ToUserPid) {
this.ToUserPid = ToUserPid;
}

public void setTimeSent(timestamp TimeSent) {
this.TimeSent = TimeSent;
}

public void setMessage(String Message) {
this.Message = Message;
}

public void setIsRead(boolean IsRead) {
this.IsRead = IsRead;
}

public void setIsAckd(boolean IsAckd) {
this.IsAckd = IsAckd;
}

public void setReplied(boolean Replied) {
this.Replied = Replied;
}

}

