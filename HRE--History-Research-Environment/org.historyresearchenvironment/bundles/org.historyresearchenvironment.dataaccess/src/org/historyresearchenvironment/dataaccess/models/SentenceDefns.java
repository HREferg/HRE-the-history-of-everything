package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SENTENCE_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SentenceDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SENTENCE_TEMPLATE_DEFN_PID, " +
"IS_SYSTEM, " +
"PLUGIN_KEY, " +
"SENTENCE_SET_KEY, " +
"SENTCE_STYLE_TYPE_KEY, " +
"REQUESTER_TYPE_KEY, " +
"REQUESTER_SUB_TYPE_KEY, " +
"REQUESTER_PID, " +
"PUBLISH_TYPE_KEY FROM PUBLIC.SENTENCE_DEFNS WHERE SENTENCE_TEMPLATE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SENTENCE_TEMPLATE_DEFN_PID, " +  
"IS_SYSTEM, " +  
"PLUGIN_KEY, " +  
"SENTENCE_SET_KEY, " +  
"SENTCE_STYLE_TYPE_KEY, " +  
"REQUESTER_TYPE_KEY, " +  
"REQUESTER_SUB_TYPE_KEY, " +  
"REQUESTER_PID, " +  
"PUBLISH_TYPE_KEY FROM PUBLIC.SENTENCE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.SENTENCE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SENTENCE_TEMPLATE_DEFN_PID, " +     
"IS_SYSTEM, " +     
"PLUGIN_KEY, " +     
"SENTENCE_SET_KEY, " +     
"SENTCE_STYLE_TYPE_KEY, " +     
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
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SENTENCE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PLUGIN_KEY = ?, " + 
"SENTENCE_SET_KEY = ?, " + 
"SENTCE_STYLE_TYPE_KEY = ?, " + 
"REQUESTER_TYPE_KEY = ?, " + 
"REQUESTER_SUB_TYPE_KEY = ?, " + 
"REQUESTER_PID = ?, " + 
"PUBLISH_TYPE_KEY = ? WHERE SENTENCE_TEMPLATE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SENTENCE_DEFNS WHERE SENTENCE_TEMPLATE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SENTENCE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SentenceTemplateDefnPid;
private boolean IsSystem;
private short PluginKey;
private short SentenceSetKey;
private short SentceStyleTypeKey;
private short RequesterTypeKey;
private short RequesterSubTypeKey;
private int RequesterPid;
private short PublishTypeKey;
private SentenceDefns model;

public SentenceDefns() throws SQLException {
}


public SentenceDefns(int SentenceTemplateDefnPid) throws SQLException {
super();
this.SentenceTemplateDefnPid = SentenceTemplateDefnPid;
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
model = new SentenceDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSentenceTemplateDefnPid(rs.getInt("SENTENCE_TEMPLATE_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setPluginKey(rs.getShort("PLUGIN_KEY"));
model.setSentenceSetKey(rs.getShort("SENTENCE_SET_KEY"));
model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
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
model.setSentenceTemplateDefnPid(rs.getInt("SENTENCE_TEMPLATE_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setPluginKey(rs.getShort("PLUGIN_KEY"));
model.setSentenceSetKey(rs.getShort("SENTENCE_SET_KEY"));
model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
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
((SentenceDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SentenceDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SentenceDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SentenceDefns) model).setSentenceTemplateDefnPid(rs.getInt("SENTENCE_TEMPLATE_DEFN_PID"));
((SentenceDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SentenceDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
((SentenceDefns) model).setSentenceSetKey(rs.getShort("SENTENCE_SET_KEY"));
((SentenceDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
((SentenceDefns) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
((SentenceDefns) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
((SentenceDefns) model).setRequesterPid(rs.getInt("REQUESTER_PID"));
((SentenceDefns) model).setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((SentenceDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SentenceDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SentenceDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SentenceDefns) model).setSentenceTemplateDefnPid(rs.getInt("SENTENCE_TEMPLATE_DEFN_PID"));
((SentenceDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SentenceDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
((SentenceDefns) model).setSentenceSetKey(rs.getShort("SENTENCE_SET_KEY"));
((SentenceDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
((SentenceDefns) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
((SentenceDefns) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
((SentenceDefns) model).setRequesterPid(rs.getInt("REQUESTER_PID"));
((SentenceDefns) model).setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
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

public int getSentenceTemplateDefnPid() {
return this.SentenceTemplateDefnPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public short getPluginKey() {
return this.PluginKey;
}

public short getSentenceSetKey() {
return this.SentenceSetKey;
}

public short getSentceStyleTypeKey() {
return this.SentceStyleTypeKey;
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

public void setSentenceTemplateDefnPid(int SentenceTemplateDefnPid) {
this.SentenceTemplateDefnPid = SentenceTemplateDefnPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setPluginKey(short PluginKey) {
this.PluginKey = PluginKey;
}

public void setSentenceSetKey(short SentenceSetKey) {
this.SentenceSetKey = SentenceSetKey;
}

public void setSentceStyleTypeKey(short SentceStyleTypeKey) {
this.SentceStyleTypeKey = SentceStyleTypeKey;
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

