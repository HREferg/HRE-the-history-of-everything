package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSTN_COMMON_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SubstnCommonDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SUBSTN_COMMON_DEFN_PID, " +
"IS_SYSTEM, " +
"IS_DATA_RETRIEVAL, " +
"IS_VALUE_COMPARE, " +
"TOP_STEP_KEY, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"SHOW FROM PUBLIC.SUBSTN_COMMON_DEFNS WHERE SUBSTN_COMMON_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SUBSTN_COMMON_DEFN_PID, " +  
"IS_SYSTEM, " +  
"IS_DATA_RETRIEVAL, " +  
"IS_VALUE_COMPARE, " +  
"TOP_STEP_KEY, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"SHOW FROM PUBLIC.SUBSTN_COMMON_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_COMMON_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SUBSTN_COMMON_DEFN_PID, " +     
"IS_SYSTEM, " +     
"IS_DATA_RETRIEVAL, " +     
"IS_VALUE_COMPARE, " +     
"TOP_STEP_KEY, " +     
"REMINDER_KEY, " +     
"DISPLAY_ORDER, " +     
"SHOW) VALUES (?, " +
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

private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_COMMON_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"IS_DATA_RETRIEVAL = ?, " + 
"IS_VALUE_COMPARE = ?, " + 
"TOP_STEP_KEY = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"SHOW = ? WHERE SUBSTN_COMMON_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_COMMON_DEFNS WHERE SUBSTN_COMMON_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_COMMON_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SubstnCommonDefnPid;
private boolean IsSystem;
private boolean IsDataRetrieval;
private boolean IsValueCompare;
private short TopStepKey;
private short ReminderKey;
private short DisplayOrder;
private boolean Show;
private SubstnCommonDefns model;

public SubstnCommonDefns() throws SQLException {
}


public SubstnCommonDefns(int SubstnCommonDefnPid) throws SQLException {
super();
this.SubstnCommonDefnPid = SubstnCommonDefnPid;
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
model = new SubstnCommonDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSubstnCommonDefnPid(rs.getInt("SUBSTN_COMMON_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setIsDataRetrieval(rs.getBoolean("IS_DATA_RETRIEVAL"));
model.setIsValueCompare(rs.getBoolean("IS_VALUE_COMPARE"));
model.setTopStepKey(rs.getShort("TOP_STEP_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setShow(rs.getBoolean("SHOW"));
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
model.setSubstnCommonDefnPid(rs.getInt("SUBSTN_COMMON_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setIsDataRetrieval(rs.getBoolean("IS_DATA_RETRIEVAL"));
model.setIsValueCompare(rs.getBoolean("IS_VALUE_COMPARE"));
model.setTopStepKey(rs.getShort("TOP_STEP_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setShow(rs.getBoolean("SHOW"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((SubstnCommonDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubstnCommonDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SubstnCommonDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubstnCommonDefns) model).setSubstnCommonDefnPid(rs.getInt("SUBSTN_COMMON_DEFN_PID"));
((SubstnCommonDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SubstnCommonDefns) model).setIsDataRetrieval(rs.getBoolean("IS_DATA_RETRIEVAL"));
((SubstnCommonDefns) model).setIsValueCompare(rs.getBoolean("IS_VALUE_COMPARE"));
((SubstnCommonDefns) model).setTopStepKey(rs.getShort("TOP_STEP_KEY"));
((SubstnCommonDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SubstnCommonDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SubstnCommonDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((SubstnCommonDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubstnCommonDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SubstnCommonDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubstnCommonDefns) model).setSubstnCommonDefnPid(rs.getInt("SUBSTN_COMMON_DEFN_PID"));
((SubstnCommonDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SubstnCommonDefns) model).setIsDataRetrieval(rs.getBoolean("IS_DATA_RETRIEVAL"));
((SubstnCommonDefns) model).setIsValueCompare(rs.getBoolean("IS_VALUE_COMPARE"));
((SubstnCommonDefns) model).setTopStepKey(rs.getShort("TOP_STEP_KEY"));
((SubstnCommonDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SubstnCommonDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SubstnCommonDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getSubstnCommonDefnPid() {
return this.SubstnCommonDefnPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public boolean getIsDataRetrieval() {
return this.IsDataRetrieval;
}

public boolean getIsValueCompare() {
return this.IsValueCompare;
}

public short getTopStepKey() {
return this.TopStepKey;
}

public short getReminderKey() {
return this.ReminderKey;
}

public short getDisplayOrder() {
return this.DisplayOrder;
}

public boolean getShow() {
return this.Show;
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

public void setSubstnCommonDefnPid(int SubstnCommonDefnPid) {
this.SubstnCommonDefnPid = SubstnCommonDefnPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setIsDataRetrieval(boolean IsDataRetrieval) {
this.IsDataRetrieval = IsDataRetrieval;
}

public void setIsValueCompare(boolean IsValueCompare) {
this.IsValueCompare = IsValueCompare;
}

public void setTopStepKey(short TopStepKey) {
this.TopStepKey = TopStepKey;
}

public void setReminderKey(short ReminderKey) {
this.ReminderKey = ReminderKey;
}

public void setDisplayOrder(short DisplayOrder) {
this.DisplayOrder = DisplayOrder;
}

public void setShow(boolean Show) {
this.Show = Show;
}

}

