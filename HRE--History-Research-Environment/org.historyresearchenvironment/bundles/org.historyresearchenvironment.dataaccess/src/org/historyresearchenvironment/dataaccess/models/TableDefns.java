package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the TABLE_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class TableDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"TABLE_DEFN_PID, " +
"PLUGIN_KEY, " +
"LAST_RECORD_PID, " +
"VERSION_NAME, " +
"SQL_NAME, " +
"STORAGE_TYPE_KEY, " +
"RECORD_VALID_KEY, " +
"HAS_FLAGS, " +
"HAS_NOTEPADS FROM PUBLIC.TABLE_DEFNS WHERE TABLE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"TABLE_DEFN_PID, " +  
"PLUGIN_KEY, " +  
"LAST_RECORD_PID, " +  
"VERSION_NAME, " +  
"SQL_NAME, " +  
"STORAGE_TYPE_KEY, " +  
"RECORD_VALID_KEY, " +  
"HAS_FLAGS, " +  
"HAS_NOTEPADS FROM PUBLIC.TABLE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.TABLE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"TABLE_DEFN_PID, " +     
"PLUGIN_KEY, " +     
"LAST_RECORD_PID, " +     
"VERSION_NAME, " +     
"SQL_NAME, " +     
"STORAGE_TYPE_KEY, " +     
"RECORD_VALID_KEY, " +     
"HAS_FLAGS, " +     
"HAS_NOTEPADS) VALUES (?, " +
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

private static final String UPDATE = "UPDATE PUBLIC.TABLE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"PLUGIN_KEY = ?, " + 
"LAST_RECORD_PID = ?, " + 
"VERSION_NAME = ?, " + 
"SQL_NAME = ?, " + 
"STORAGE_TYPE_KEY = ?, " + 
"RECORD_VALID_KEY = ?, " + 
"HAS_FLAGS = ?, " + 
"HAS_NOTEPADS = ? WHERE TABLE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.TABLE_DEFNS WHERE TABLE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.TABLE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int TableDefnPid;
private short PluginKey;
private int LastRecordPid;
private String VersionName;
private String SqlName;
private short StorageTypeKey;
private short RecordValidKey;
private boolean HasFlags;
private boolean HasNotepads;
private TableDefns model;

public TableDefns() throws SQLException {
}


public TableDefns(int TableDefnPid) throws SQLException {
super();
this.TableDefnPid = TableDefnPid;
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
model = new TableDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setTableDefnPid(rs.getInt("TABLE_DEFN_PID"));
model.setPluginKey(rs.getShort("PLUGIN_KEY"));
model.setLastRecordPid(rs.getInt("LAST_RECORD_PID"));
model.setVersionName(rs.getString("VERSION_NAME"));
model.setSqlName(rs.getString("SQL_NAME"));
model.setStorageTypeKey(rs.getShort("STORAGE_TYPE_KEY"));
model.setRecordValidKey(rs.getShort("RECORD_VALID_KEY"));
model.setHasFlags(rs.getBoolean("HAS_FLAGS"));
model.setHasNotepads(rs.getBoolean("HAS_NOTEPADS"));
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
model.setTableDefnPid(rs.getInt("TABLE_DEFN_PID"));
model.setPluginKey(rs.getShort("PLUGIN_KEY"));
model.setLastRecordPid(rs.getInt("LAST_RECORD_PID"));
model.setVersionName(rs.getString("VERSION_NAME"));
model.setSqlName(rs.getString("SQL_NAME"));
model.setStorageTypeKey(rs.getShort("STORAGE_TYPE_KEY"));
model.setRecordValidKey(rs.getShort("RECORD_VALID_KEY"));
model.setHasFlags(rs.getBoolean("HAS_FLAGS"));
model.setHasNotepads(rs.getBoolean("HAS_NOTEPADS"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((TableDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((TableDefns) model).setSetKey(rs.getShort("SET_KEY"));
((TableDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((TableDefns) model).setTableDefnPid(rs.getInt("TABLE_DEFN_PID"));
((TableDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
((TableDefns) model).setLastRecordPid(rs.getInt("LAST_RECORD_PID"));
((TableDefns) model).setVersionName(rs.getString("VERSION_NAME"));
((TableDefns) model).setSqlName(rs.getString("SQL_NAME"));
((TableDefns) model).setStorageTypeKey(rs.getShort("STORAGE_TYPE_KEY"));
((TableDefns) model).setRecordValidKey(rs.getShort("RECORD_VALID_KEY"));
((TableDefns) model).setHasFlags(rs.getBoolean("HAS_FLAGS"));
((TableDefns) model).setHasNotepads(rs.getBoolean("HAS_NOTEPADS"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((TableDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((TableDefns) model).setSetKey(rs.getShort("SET_KEY"));
((TableDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((TableDefns) model).setTableDefnPid(rs.getInt("TABLE_DEFN_PID"));
((TableDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
((TableDefns) model).setLastRecordPid(rs.getInt("LAST_RECORD_PID"));
((TableDefns) model).setVersionName(rs.getString("VERSION_NAME"));
((TableDefns) model).setSqlName(rs.getString("SQL_NAME"));
((TableDefns) model).setStorageTypeKey(rs.getShort("STORAGE_TYPE_KEY"));
((TableDefns) model).setRecordValidKey(rs.getShort("RECORD_VALID_KEY"));
((TableDefns) model).setHasFlags(rs.getBoolean("HAS_FLAGS"));
((TableDefns) model).setHasNotepads(rs.getBoolean("HAS_NOTEPADS"));
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

public int getTableDefnPid() {
return this.TableDefnPid;
}

public short getPluginKey() {
return this.PluginKey;
}

public int getLastRecordPid() {
return this.LastRecordPid;
}

public String getVersionName() {
return this.VersionName;
}

public String getSqlName() {
return this.SqlName;
}

public short getStorageTypeKey() {
return this.StorageTypeKey;
}

public short getRecordValidKey() {
return this.RecordValidKey;
}

public boolean getHasFlags() {
return this.HasFlags;
}

public boolean getHasNotepads() {
return this.HasNotepads;
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

public void setTableDefnPid(int TableDefnPid) {
this.TableDefnPid = TableDefnPid;
}

public void setPluginKey(short PluginKey) {
this.PluginKey = PluginKey;
}

public void setLastRecordPid(int LastRecordPid) {
this.LastRecordPid = LastRecordPid;
}

public void setVersionName(String VersionName) {
this.VersionName = VersionName;
}

public void setSqlName(String SqlName) {
this.SqlName = SqlName;
}

public void setStorageTypeKey(short StorageTypeKey) {
this.StorageTypeKey = StorageTypeKey;
}

public void setRecordValidKey(short RecordValidKey) {
this.RecordValidKey = RecordValidKey;
}

public void setHasFlags(boolean HasFlags) {
this.HasFlags = HasFlags;
}

public void setHasNotepads(boolean HasNotepads) {
this.HasNotepads = HasNotepads;
}

}

