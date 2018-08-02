package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSTN_PARAM_LISTS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SubstnParamLists extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SUBSTN_PARAM_LIST_PID, " +
"IS_SYSTEM, " +
"PARAM_SET_KEY, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"SHOW FROM PUBLIC.SUBSTN_PARAM_LISTS WHERE SUBSTN_PARAM_LIST_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SUBSTN_PARAM_LIST_PID, " +  
"IS_SYSTEM, " +  
"PARAM_SET_KEY, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"SHOW FROM PUBLIC.SUBSTN_PARAM_LISTS";

private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_PARAM_LISTS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SUBSTN_PARAM_LIST_PID, " +     
"IS_SYSTEM, " +     
"PARAM_SET_KEY, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_PARAM_LISTSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PARAM_SET_KEY = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"SHOW = ? WHERE SUBSTN_PARAM_LIST_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_PARAM_LISTS WHERE SUBSTN_PARAM_LIST_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_PARAM_LISTS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SubstnParamListPid;
private boolean IsSystem;
private short ParamSetKey;
private short ReminderKey;
private short DisplayOrder;
private boolean Show;
private SubstnParamLists model;

public SubstnParamLists() throws SQLException {
}


public SubstnParamLists(int SubstnParamListPid) throws SQLException {
super();
this.SubstnParamListPid = SubstnParamListPid;
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
model = new SubstnParamLists();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSubstnParamListPid(rs.getInt("SUBSTN_PARAM_LIST_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParamSetKey(rs.getShort("PARAM_SET_KEY"));
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
model.setSubstnParamListPid(rs.getInt("SUBSTN_PARAM_LIST_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParamSetKey(rs.getShort("PARAM_SET_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setShow(rs.getBoolean("SHOW"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((SubstnParamLists) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubstnParamLists) model).setSetKey(rs.getShort("SET_KEY"));
((SubstnParamLists) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubstnParamLists) model).setSubstnParamListPid(rs.getInt("SUBSTN_PARAM_LIST_PID"));
((SubstnParamLists) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SubstnParamLists) model).setParamSetKey(rs.getShort("PARAM_SET_KEY"));
((SubstnParamLists) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SubstnParamLists) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SubstnParamLists) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((SubstnParamLists) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubstnParamLists) model).setSetKey(rs.getShort("SET_KEY"));
((SubstnParamLists) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubstnParamLists) model).setSubstnParamListPid(rs.getInt("SUBSTN_PARAM_LIST_PID"));
((SubstnParamLists) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SubstnParamLists) model).setParamSetKey(rs.getShort("PARAM_SET_KEY"));
((SubstnParamLists) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SubstnParamLists) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SubstnParamLists) model).setShow(rs.getBoolean("SHOW"));
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

public int getSubstnParamListPid() {
return this.SubstnParamListPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public short getParamSetKey() {
return this.ParamSetKey;
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

public void setSubstnParamListPid(int SubstnParamListPid) {
this.SubstnParamListPid = SubstnParamListPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setParamSetKey(short ParamSetKey) {
this.ParamSetKey = ParamSetKey;
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

