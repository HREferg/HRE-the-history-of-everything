package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the USER_MESSAGES database table.
*
* @version 2018-08-05
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
private Timestamp TimeSent;
private String Message;
private boolean IsRead;
private boolean IsAckd;
private boolean Replied;
private UserMessages model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public UserMessages() throws SQLException {
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
public UserMessages get(int key) throws SQLException {
model = new UserMessages();
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
return model;
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
* Get the UserMessagePid field.
*
* @return Contents of the USER_MESSAGE_PID column
*/
public int getUserMessagePid() {
return this.UserMessagePid;
}

/**
* Get the FromUserPid field.
*
* @return Contents of the FROM_USER_PID column
*/
public int getFromUserPid() {
return this.FromUserPid;
}

/**
* Get the ToUserPid field.
*
* @return Contents of the TO_USER_PID column
*/
public int getToUserPid() {
return this.ToUserPid;
}

/**
* Get the TimeSent field.
*
* @return Contents of the TIME_SENT column
*/
public Timestamp getTimeSent() {
return this.TimeSent;
}

/**
* Get the Message field.
*
* @return Contents of the MESSAGE column
*/
public String getMessage() {
return this.Message;
}

/**
* Get the IsRead field.
*
* @return Contents of the IS_READ column
*/
public boolean getIsRead() {
return this.IsRead;
}

/**
* Get the IsAckd field.
*
* @return Contents of the IS_ACKD column
*/
public boolean getIsAckd() {
return this.IsAckd;
}

/**
* Get the Replied field.
*
* @return Contents of the REPLIED column
*/
public boolean getReplied() {
return this.Replied;
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
* Set the UserMessagePid field
*
* @param UserMessagePid Contents of the USER_MESSAGE_PID column
*/
public void setUserMessagePid(int UserMessagePid) {
this.UserMessagePid = UserMessagePid;
}

/**
* Set the FromUserPid field
*
* @param FromUserPid Contents of the FROM_USER_PID column
*/
public void setFromUserPid(int FromUserPid) {
this.FromUserPid = FromUserPid;
}

/**
* Set the ToUserPid field
*
* @param ToUserPid Contents of the TO_USER_PID column
*/
public void setToUserPid(int ToUserPid) {
this.ToUserPid = ToUserPid;
}

/**
* Set the TimeSent field
*
* @param TimeSent Contents of the TIME_SENT column
*/
public void setTimeSent(Timestamp TimeSent) {
this.TimeSent = TimeSent;
}

/**
* Set the Message field
*
* @param Message Contents of the MESSAGE column
*/
public void setMessage(String Message) {
this.Message = Message;
}

/**
* Set the IsRead field
*
* @param IsRead Contents of the IS_READ column
*/
public void setIsRead(boolean IsRead) {
this.IsRead = IsRead;
}

/**
* Set the IsAckd field
*
* @param IsAckd Contents of the IS_ACKD column
*/
public void setIsAckd(boolean IsAckd) {
this.IsAckd = IsAckd;
}

/**
* Set the Replied field
*
* @param Replied Contents of the REPLIED column
*/
public void setReplied(boolean Replied) {
this.Replied = Replied;
}

}

