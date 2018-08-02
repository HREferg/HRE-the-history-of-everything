package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SCRIPT_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class ScriptDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SCRIPT_DEFN_PID, " +
"IS_SYSTEM, " +
"ACTION_TYPE_KEY, " +
"INPUT_FOCUS_TYPE_KEY, " +
"INPUT_SUB_TYPE_KEY, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.SCRIPT_DEFNS WHERE SCRIPT_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SCRIPT_DEFN_PID, " +  
"IS_SYSTEM, " +  
"ACTION_TYPE_KEY, " +  
"INPUT_FOCUS_TYPE_KEY, " +  
"INPUT_SUB_TYPE_KEY, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.SCRIPT_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.SCRIPT_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SCRIPT_DEFN_PID, " +     
"IS_SYSTEM, " +     
"ACTION_TYPE_KEY, " +     
"INPUT_FOCUS_TYPE_KEY, " +     
"INPUT_SUB_TYPE_KEY, " +     
"REMINDER_KEY, " +     
"DISPLAY_ORDER, " +     
"IS_DEFAULT, " +     
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
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SCRIPT_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"ACTION_TYPE_KEY = ?, " + 
"INPUT_FOCUS_TYPE_KEY = ?, " + 
"INPUT_SUB_TYPE_KEY = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE SCRIPT_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SCRIPT_DEFNS WHERE SCRIPT_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SCRIPT_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int ScriptDefnPid;
private boolean IsSystem;
private short ActionTypeKey;
private short InputFocusTypeKey;
private short InputSubTypeKey;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private ScriptDefns model;

public ScriptDefns() throws SQLException {
}


public ScriptDefns(int ScriptDefnPid) throws SQLException {
super();
this.ScriptDefnPid = ScriptDefnPid;
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
model = new ScriptDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setScriptDefnPid(rs.getInt("SCRIPT_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setActionTypeKey(rs.getShort("ACTION_TYPE_KEY"));
model.setInputFocusTypeKey(rs.getShort("INPUT_FOCUS_TYPE_KEY"));
model.setInputSubTypeKey(rs.getShort("INPUT_SUB_TYPE_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
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
model.setScriptDefnPid(rs.getInt("SCRIPT_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setActionTypeKey(rs.getShort("ACTION_TYPE_KEY"));
model.setInputFocusTypeKey(rs.getShort("INPUT_FOCUS_TYPE_KEY"));
model.setInputSubTypeKey(rs.getShort("INPUT_SUB_TYPE_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((ScriptDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ScriptDefns) model).setSetKey(rs.getShort("SET_KEY"));
((ScriptDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ScriptDefns) model).setScriptDefnPid(rs.getInt("SCRIPT_DEFN_PID"));
((ScriptDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((ScriptDefns) model).setActionTypeKey(rs.getShort("ACTION_TYPE_KEY"));
((ScriptDefns) model).setInputFocusTypeKey(rs.getShort("INPUT_FOCUS_TYPE_KEY"));
((ScriptDefns) model).setInputSubTypeKey(rs.getShort("INPUT_SUB_TYPE_KEY"));
((ScriptDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((ScriptDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((ScriptDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((ScriptDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((ScriptDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ScriptDefns) model).setSetKey(rs.getShort("SET_KEY"));
((ScriptDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ScriptDefns) model).setScriptDefnPid(rs.getInt("SCRIPT_DEFN_PID"));
((ScriptDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((ScriptDefns) model).setActionTypeKey(rs.getShort("ACTION_TYPE_KEY"));
((ScriptDefns) model).setInputFocusTypeKey(rs.getShort("INPUT_FOCUS_TYPE_KEY"));
((ScriptDefns) model).setInputSubTypeKey(rs.getShort("INPUT_SUB_TYPE_KEY"));
((ScriptDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((ScriptDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((ScriptDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((ScriptDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getScriptDefnPid() {
return this.ScriptDefnPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public short getActionTypeKey() {
return this.ActionTypeKey;
}

public short getInputFocusTypeKey() {
return this.InputFocusTypeKey;
}

public short getInputSubTypeKey() {
return this.InputSubTypeKey;
}

public short getReminderKey() {
return this.ReminderKey;
}

public short getDisplayOrder() {
return this.DisplayOrder;
}

public boolean getIsDefault() {
return this.IsDefault;
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

public void setScriptDefnPid(int ScriptDefnPid) {
this.ScriptDefnPid = ScriptDefnPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setActionTypeKey(short ActionTypeKey) {
this.ActionTypeKey = ActionTypeKey;
}

public void setInputFocusTypeKey(short InputFocusTypeKey) {
this.InputFocusTypeKey = InputFocusTypeKey;
}

public void setInputSubTypeKey(short InputSubTypeKey) {
this.InputSubTypeKey = InputSubTypeKey;
}

public void setReminderKey(short ReminderKey) {
this.ReminderKey = ReminderKey;
}

public void setDisplayOrder(short DisplayOrder) {
this.DisplayOrder = DisplayOrder;
}

public void setIsDefault(boolean IsDefault) {
this.IsDefault = IsDefault;
}

public void setShow(boolean Show) {
this.Show = Show;
}

}

