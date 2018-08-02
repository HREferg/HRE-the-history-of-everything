package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the FLAG_STATE_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class FlagStateDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"FLAG_STATE_DEFN_PID, " +
"IS_SYSTEM, " +
"PARENT_TYPE_KEY, " +
"PARENT_SUB_TYPE_KEY, " +
"PARENT_FLAG_SLOT, " +
"STATE_VALUE, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.FLAG_STATE_DEFNS WHERE FLAG_STATE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"FLAG_STATE_DEFN_PID, " +  
"IS_SYSTEM, " +  
"PARENT_TYPE_KEY, " +  
"PARENT_SUB_TYPE_KEY, " +  
"PARENT_FLAG_SLOT, " +  
"STATE_VALUE, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.FLAG_STATE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.FLAG_STATE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"FLAG_STATE_DEFN_PID, " +     
"IS_SYSTEM, " +     
"PARENT_TYPE_KEY, " +     
"PARENT_SUB_TYPE_KEY, " +     
"PARENT_FLAG_SLOT, " +     
"STATE_VALUE, " +     
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
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.FLAG_STATE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PARENT_TYPE_KEY = ?, " + 
"PARENT_SUB_TYPE_KEY = ?, " + 
"PARENT_FLAG_SLOT = ?, " + 
"STATE_VALUE = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE FLAG_STATE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.FLAG_STATE_DEFNS WHERE FLAG_STATE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.FLAG_STATE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int FlagStateDefnPid;
private boolean IsSystem;
private short ParentTypeKey;
private short ParentSubTypeKey;
private short ParentFlagSlot;
private short StateValue;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private FlagStateDefns model;

public FlagStateDefns() throws SQLException {
}


public FlagStateDefns(int FlagStateDefnPid) throws SQLException {
super();
this.FlagStateDefnPid = FlagStateDefnPid;
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
model = new FlagStateDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setFlagStateDefnPid(rs.getInt("FLAG_STATE_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setParentFlagSlot(rs.getShort("PARENT_FLAG_SLOT"));
model.setStateValue(rs.getShort("STATE_VALUE"));
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
model.setFlagStateDefnPid(rs.getInt("FLAG_STATE_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setParentFlagSlot(rs.getShort("PARENT_FLAG_SLOT"));
model.setStateValue(rs.getShort("STATE_VALUE"));
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
((FlagStateDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((FlagStateDefns) model).setSetKey(rs.getShort("SET_KEY"));
((FlagStateDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((FlagStateDefns) model).setFlagStateDefnPid(rs.getInt("FLAG_STATE_DEFN_PID"));
((FlagStateDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((FlagStateDefns) model).setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
((FlagStateDefns) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((FlagStateDefns) model).setParentFlagSlot(rs.getShort("PARENT_FLAG_SLOT"));
((FlagStateDefns) model).setStateValue(rs.getShort("STATE_VALUE"));
((FlagStateDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((FlagStateDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((FlagStateDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((FlagStateDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((FlagStateDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((FlagStateDefns) model).setSetKey(rs.getShort("SET_KEY"));
((FlagStateDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((FlagStateDefns) model).setFlagStateDefnPid(rs.getInt("FLAG_STATE_DEFN_PID"));
((FlagStateDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((FlagStateDefns) model).setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
((FlagStateDefns) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((FlagStateDefns) model).setParentFlagSlot(rs.getShort("PARENT_FLAG_SLOT"));
((FlagStateDefns) model).setStateValue(rs.getShort("STATE_VALUE"));
((FlagStateDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((FlagStateDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((FlagStateDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((FlagStateDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getFlagStateDefnPid() {
return this.FlagStateDefnPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public short getParentTypeKey() {
return this.ParentTypeKey;
}

public short getParentSubTypeKey() {
return this.ParentSubTypeKey;
}

public short getParentFlagSlot() {
return this.ParentFlagSlot;
}

public short getStateValue() {
return this.StateValue;
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

public void setFlagStateDefnPid(int FlagStateDefnPid) {
this.FlagStateDefnPid = FlagStateDefnPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setParentTypeKey(short ParentTypeKey) {
this.ParentTypeKey = ParentTypeKey;
}

public void setParentSubTypeKey(short ParentSubTypeKey) {
this.ParentSubTypeKey = ParentSubTypeKey;
}

public void setParentFlagSlot(short ParentFlagSlot) {
this.ParentFlagSlot = ParentFlagSlot;
}

public void setStateValue(short StateValue) {
this.StateValue = StateValue;
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

