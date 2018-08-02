package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the FIELD_VALID_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class FieldValidDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"FIELD_VALID_DEFN_PID, " +
"VIEW_SCRIPT_GROUP_KEY, " +
"VIEW_SCRIPT_PID, " +
"MODIFY_SCRIPT_GROUP_KEY, " +
"MODIFY_SCRIPT_PID, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.FIELD_VALID_DEFNS WHERE FIELD_VALID_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"FIELD_VALID_DEFN_PID, " +  
"VIEW_SCRIPT_GROUP_KEY, " +  
"VIEW_SCRIPT_PID, " +  
"MODIFY_SCRIPT_GROUP_KEY, " +  
"MODIFY_SCRIPT_PID, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.FIELD_VALID_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.FIELD_VALID_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"FIELD_VALID_DEFN_PID, " +     
"VIEW_SCRIPT_GROUP_KEY, " +     
"VIEW_SCRIPT_PID, " +     
"MODIFY_SCRIPT_GROUP_KEY, " +     
"MODIFY_SCRIPT_PID, " +     
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

private static final String UPDATE = "UPDATE PUBLIC.FIELD_VALID_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"VIEW_SCRIPT_GROUP_KEY = ?, " + 
"VIEW_SCRIPT_PID = ?, " + 
"MODIFY_SCRIPT_GROUP_KEY = ?, " + 
"MODIFY_SCRIPT_PID = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE FIELD_VALID_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.FIELD_VALID_DEFNS WHERE FIELD_VALID_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.FIELD_VALID_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int FieldValidDefnPid;
private short ViewScriptGroupKey;
private int ViewScriptPid;
private short ModifyScriptGroupKey;
private int ModifyScriptPid;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private FieldValidDefns model;

public FieldValidDefns() throws SQLException {
}


public FieldValidDefns(int FieldValidDefnPid) throws SQLException {
super();
this.FieldValidDefnPid = FieldValidDefnPid;
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
model = new FieldValidDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setFieldValidDefnPid(rs.getInt("FIELD_VALID_DEFN_PID"));
model.setViewScriptGroupKey(rs.getShort("VIEW_SCRIPT_GROUP_KEY"));
model.setViewScriptPid(rs.getInt("VIEW_SCRIPT_PID"));
model.setModifyScriptGroupKey(rs.getShort("MODIFY_SCRIPT_GROUP_KEY"));
model.setModifyScriptPid(rs.getInt("MODIFY_SCRIPT_PID"));
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
model.setFieldValidDefnPid(rs.getInt("FIELD_VALID_DEFN_PID"));
model.setViewScriptGroupKey(rs.getShort("VIEW_SCRIPT_GROUP_KEY"));
model.setViewScriptPid(rs.getInt("VIEW_SCRIPT_PID"));
model.setModifyScriptGroupKey(rs.getShort("MODIFY_SCRIPT_GROUP_KEY"));
model.setModifyScriptPid(rs.getInt("MODIFY_SCRIPT_PID"));
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
((FieldValidDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((FieldValidDefns) model).setSetKey(rs.getShort("SET_KEY"));
((FieldValidDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((FieldValidDefns) model).setFieldValidDefnPid(rs.getInt("FIELD_VALID_DEFN_PID"));
((FieldValidDefns) model).setViewScriptGroupKey(rs.getShort("VIEW_SCRIPT_GROUP_KEY"));
((FieldValidDefns) model).setViewScriptPid(rs.getInt("VIEW_SCRIPT_PID"));
((FieldValidDefns) model).setModifyScriptGroupKey(rs.getShort("MODIFY_SCRIPT_GROUP_KEY"));
((FieldValidDefns) model).setModifyScriptPid(rs.getInt("MODIFY_SCRIPT_PID"));
((FieldValidDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((FieldValidDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((FieldValidDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((FieldValidDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((FieldValidDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((FieldValidDefns) model).setSetKey(rs.getShort("SET_KEY"));
((FieldValidDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((FieldValidDefns) model).setFieldValidDefnPid(rs.getInt("FIELD_VALID_DEFN_PID"));
((FieldValidDefns) model).setViewScriptGroupKey(rs.getShort("VIEW_SCRIPT_GROUP_KEY"));
((FieldValidDefns) model).setViewScriptPid(rs.getInt("VIEW_SCRIPT_PID"));
((FieldValidDefns) model).setModifyScriptGroupKey(rs.getShort("MODIFY_SCRIPT_GROUP_KEY"));
((FieldValidDefns) model).setModifyScriptPid(rs.getInt("MODIFY_SCRIPT_PID"));
((FieldValidDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((FieldValidDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((FieldValidDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((FieldValidDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getFieldValidDefnPid() {
return this.FieldValidDefnPid;
}

public short getViewScriptGroupKey() {
return this.ViewScriptGroupKey;
}

public int getViewScriptPid() {
return this.ViewScriptPid;
}

public short getModifyScriptGroupKey() {
return this.ModifyScriptGroupKey;
}

public int getModifyScriptPid() {
return this.ModifyScriptPid;
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

public void setFieldValidDefnPid(int FieldValidDefnPid) {
this.FieldValidDefnPid = FieldValidDefnPid;
}

public void setViewScriptGroupKey(short ViewScriptGroupKey) {
this.ViewScriptGroupKey = ViewScriptGroupKey;
}

public void setViewScriptPid(int ViewScriptPid) {
this.ViewScriptPid = ViewScriptPid;
}

public void setModifyScriptGroupKey(short ModifyScriptGroupKey) {
this.ModifyScriptGroupKey = ModifyScriptGroupKey;
}

public void setModifyScriptPid(int ModifyScriptPid) {
this.ModifyScriptPid = ModifyScriptPid;
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

