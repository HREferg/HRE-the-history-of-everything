package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the MESSAGE_TEMPLATE_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class MessageTemplateDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"MESSAGE_TEMPLATE_DEFN_PID, " +
"PLUGIN_KEY, " +
"REQUESTER_TYPE_KEY, " +
"REQUESTER_SUB_TYPE_KEY, " +
"REQUESTER_PID, " +
"SITE_KEY, " +
"IS_ERROR FROM PUBLIC.MESSAGE_TEMPLATE_DEFNS WHERE MESSAGE_TEMPLATE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"MESSAGE_TEMPLATE_DEFN_PID, " +  
"PLUGIN_KEY, " +  
"REQUESTER_TYPE_KEY, " +  
"REQUESTER_SUB_TYPE_KEY, " +  
"REQUESTER_PID, " +  
"SITE_KEY, " +  
"IS_ERROR FROM PUBLIC.MESSAGE_TEMPLATE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.MESSAGE_TEMPLATE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"MESSAGE_TEMPLATE_DEFN_PID, " +     
"PLUGIN_KEY, " +     
"REQUESTER_TYPE_KEY, " +     
"REQUESTER_SUB_TYPE_KEY, " +     
"REQUESTER_PID, " +     
"SITE_KEY, " +     
"IS_ERROR) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.MESSAGE_TEMPLATE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"PLUGIN_KEY = ?, " + 
"REQUESTER_TYPE_KEY = ?, " + 
"REQUESTER_SUB_TYPE_KEY = ?, " + 
"REQUESTER_PID = ?, " + 
"SITE_KEY = ?, " + 
"IS_ERROR = ? WHERE MESSAGE_TEMPLATE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.MESSAGE_TEMPLATE_DEFNS WHERE MESSAGE_TEMPLATE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.MESSAGE_TEMPLATE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int MessageTemplateDefnPid;
private short PluginKey;
private short RequesterTypeKey;
private short RequesterSubTypeKey;
private int RequesterPid;
private short SiteKey;
private boolean IsError;
private MessageTemplateDefns model;

public MessageTemplateDefns() throws SQLException {
}


public MessageTemplateDefns(int MessageTemplateDefnPid) throws SQLException {
super();
this.MessageTemplateDefnPid = MessageTemplateDefnPid;
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
model = new MessageTemplateDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setMessageTemplateDefnPid(rs.getInt("MESSAGE_TEMPLATE_DEFN_PID"));
model.setPluginKey(rs.getShort("PLUGIN_KEY"));
model.setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
model.setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
model.setRequesterPid(rs.getInt("REQUESTER_PID"));
model.setSiteKey(rs.getShort("SITE_KEY"));
model.setIsError(rs.getBoolean("IS_ERROR"));
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
model.setMessageTemplateDefnPid(rs.getInt("MESSAGE_TEMPLATE_DEFN_PID"));
model.setPluginKey(rs.getShort("PLUGIN_KEY"));
model.setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
model.setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
model.setRequesterPid(rs.getInt("REQUESTER_PID"));
model.setSiteKey(rs.getShort("SITE_KEY"));
model.setIsError(rs.getBoolean("IS_ERROR"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((MessageTemplateDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((MessageTemplateDefns) model).setSetKey(rs.getShort("SET_KEY"));
((MessageTemplateDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((MessageTemplateDefns) model).setMessageTemplateDefnPid(rs.getInt("MESSAGE_TEMPLATE_DEFN_PID"));
((MessageTemplateDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
((MessageTemplateDefns) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
((MessageTemplateDefns) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
((MessageTemplateDefns) model).setRequesterPid(rs.getInt("REQUESTER_PID"));
((MessageTemplateDefns) model).setSiteKey(rs.getShort("SITE_KEY"));
((MessageTemplateDefns) model).setIsError(rs.getBoolean("IS_ERROR"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((MessageTemplateDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((MessageTemplateDefns) model).setSetKey(rs.getShort("SET_KEY"));
((MessageTemplateDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((MessageTemplateDefns) model).setMessageTemplateDefnPid(rs.getInt("MESSAGE_TEMPLATE_DEFN_PID"));
((MessageTemplateDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
((MessageTemplateDefns) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
((MessageTemplateDefns) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
((MessageTemplateDefns) model).setRequesterPid(rs.getInt("REQUESTER_PID"));
((MessageTemplateDefns) model).setSiteKey(rs.getShort("SITE_KEY"));
((MessageTemplateDefns) model).setIsError(rs.getBoolean("IS_ERROR"));
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

public int getMessageTemplateDefnPid() {
return this.MessageTemplateDefnPid;
}

public short getPluginKey() {
return this.PluginKey;
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

public short getSiteKey() {
return this.SiteKey;
}

public boolean getIsError() {
return this.IsError;
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

public void setMessageTemplateDefnPid(int MessageTemplateDefnPid) {
this.MessageTemplateDefnPid = MessageTemplateDefnPid;
}

public void setPluginKey(short PluginKey) {
this.PluginKey = PluginKey;
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

public void setSiteKey(short SiteKey) {
this.SiteKey = SiteKey;
}

public void setIsError(boolean IsError) {
this.IsError = IsError;
}

}

