package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSTN_TEMPLATE_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SubstnTemplateDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SUBSTN_TEMPLATE_DEFN_PID, " +
"IS_SYSTEM, " +
"IS_TEXT_LAYOUT, " +
"IS_TEXT_STYLE, " +
"SCRIPT_GROUP_KEY, " +
"SCRIPT_KEY, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"SHOW FROM PUBLIC.SUBSTN_TEMPLATE_DEFNS WHERE SUBSTN_TEMPLATE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SUBSTN_TEMPLATE_DEFN_PID, " +  
"IS_SYSTEM, " +  
"IS_TEXT_LAYOUT, " +  
"IS_TEXT_STYLE, " +  
"SCRIPT_GROUP_KEY, " +  
"SCRIPT_KEY, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"SHOW FROM PUBLIC.SUBSTN_TEMPLATE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_TEMPLATE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SUBSTN_TEMPLATE_DEFN_PID, " +     
"IS_SYSTEM, " +     
"IS_TEXT_LAYOUT, " +     
"IS_TEXT_STYLE, " +     
"SCRIPT_GROUP_KEY, " +     
"SCRIPT_KEY, " +     
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
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_TEMPLATE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"IS_TEXT_LAYOUT = ?, " + 
"IS_TEXT_STYLE = ?, " + 
"SCRIPT_GROUP_KEY = ?, " + 
"SCRIPT_KEY = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"SHOW = ? WHERE SUBSTN_TEMPLATE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_TEMPLATE_DEFNS WHERE SUBSTN_TEMPLATE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_TEMPLATE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SubstnTemplateDefnPid;
private boolean IsSystem;
private boolean IsTextLayout;
private boolean IsTextStyle;
private short ScriptGroupKey;
private short ScriptKey;
private short ReminderKey;
private short DisplayOrder;
private boolean Show;
private SubstnTemplateDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public SubstnTemplateDefns() throws SQLException {
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
model = new SubstnTemplateDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSubstnTemplateDefnPid(rs.getInt("SUBSTN_TEMPLATE_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setIsTextLayout(rs.getBoolean("IS_TEXT_LAYOUT"));
model.setIsTextStyle(rs.getBoolean("IS_TEXT_STYLE"));
model.setScriptGroupKey(rs.getShort("SCRIPT_GROUP_KEY"));
model.setScriptKey(rs.getShort("SCRIPT_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public SubstnTemplateDefns get(int key) throws SQLException {
model = new SubstnTemplateDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSubstnTemplateDefnPid(rs.getInt("SUBSTN_TEMPLATE_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setIsTextLayout(rs.getBoolean("IS_TEXT_LAYOUT"));
model.setIsTextStyle(rs.getBoolean("IS_TEXT_STYLE"));
model.setScriptGroupKey(rs.getShort("SCRIPT_GROUP_KEY"));
model.setScriptKey(rs.getShort("SCRIPT_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setShow(rs.getBoolean("SHOW"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((SubstnTemplateDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubstnTemplateDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SubstnTemplateDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubstnTemplateDefns) model).setSubstnTemplateDefnPid(rs.getInt("SUBSTN_TEMPLATE_DEFN_PID"));
((SubstnTemplateDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SubstnTemplateDefns) model).setIsTextLayout(rs.getBoolean("IS_TEXT_LAYOUT"));
((SubstnTemplateDefns) model).setIsTextStyle(rs.getBoolean("IS_TEXT_STYLE"));
((SubstnTemplateDefns) model).setScriptGroupKey(rs.getShort("SCRIPT_GROUP_KEY"));
((SubstnTemplateDefns) model).setScriptKey(rs.getShort("SCRIPT_KEY"));
((SubstnTemplateDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SubstnTemplateDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SubstnTemplateDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((SubstnTemplateDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubstnTemplateDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SubstnTemplateDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubstnTemplateDefns) model).setSubstnTemplateDefnPid(rs.getInt("SUBSTN_TEMPLATE_DEFN_PID"));
((SubstnTemplateDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SubstnTemplateDefns) model).setIsTextLayout(rs.getBoolean("IS_TEXT_LAYOUT"));
((SubstnTemplateDefns) model).setIsTextStyle(rs.getBoolean("IS_TEXT_STYLE"));
((SubstnTemplateDefns) model).setScriptGroupKey(rs.getShort("SCRIPT_GROUP_KEY"));
((SubstnTemplateDefns) model).setScriptKey(rs.getShort("SCRIPT_KEY"));
((SubstnTemplateDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SubstnTemplateDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SubstnTemplateDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the SubstnTemplateDefnPid field.
*
* @return Contents of the SUBSTN_TEMPLATE_DEFN_PID column
*/
public int getSubstnTemplateDefnPid() {
return this.SubstnTemplateDefnPid;
}

/**
* Get the IsSystem field.
*
* @return Contents of the IS_SYSTEM column
*/
public boolean getIsSystem() {
return this.IsSystem;
}

/**
* Get the IsTextLayout field.
*
* @return Contents of the IS_TEXT_LAYOUT column
*/
public boolean getIsTextLayout() {
return this.IsTextLayout;
}

/**
* Get the IsTextStyle field.
*
* @return Contents of the IS_TEXT_STYLE column
*/
public boolean getIsTextStyle() {
return this.IsTextStyle;
}

/**
* Get the ScriptGroupKey field.
*
* @return Contents of the SCRIPT_GROUP_KEY column
*/
public short getScriptGroupKey() {
return this.ScriptGroupKey;
}

/**
* Get the ScriptKey field.
*
* @return Contents of the SCRIPT_KEY column
*/
public short getScriptKey() {
return this.ScriptKey;
}

/**
* Get the ReminderKey field.
*
* @return Contents of the REMINDER_KEY column
*/
public short getReminderKey() {
return this.ReminderKey;
}

/**
* Get the DisplayOrder field.
*
* @return Contents of the DISPLAY_ORDER column
*/
public short getDisplayOrder() {
return this.DisplayOrder;
}

/**
* Get the Show field.
*
* @return Contents of the SHOW column
*/
public boolean getShow() {
return this.Show;
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
* Set the SubstnTemplateDefnPid field
*
* @param SubstnTemplateDefnPid Contents of the SUBSTN_TEMPLATE_DEFN_PID column
*/
public void setSubstnTemplateDefnPid(int SubstnTemplateDefnPid) {
this.SubstnTemplateDefnPid = SubstnTemplateDefnPid;
}

/**
* Set the IsSystem field
*
* @param IsSystem Contents of the IS_SYSTEM column
*/
public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

/**
* Set the IsTextLayout field
*
* @param IsTextLayout Contents of the IS_TEXT_LAYOUT column
*/
public void setIsTextLayout(boolean IsTextLayout) {
this.IsTextLayout = IsTextLayout;
}

/**
* Set the IsTextStyle field
*
* @param IsTextStyle Contents of the IS_TEXT_STYLE column
*/
public void setIsTextStyle(boolean IsTextStyle) {
this.IsTextStyle = IsTextStyle;
}

/**
* Set the ScriptGroupKey field
*
* @param ScriptGroupKey Contents of the SCRIPT_GROUP_KEY column
*/
public void setScriptGroupKey(short ScriptGroupKey) {
this.ScriptGroupKey = ScriptGroupKey;
}

/**
* Set the ScriptKey field
*
* @param ScriptKey Contents of the SCRIPT_KEY column
*/
public void setScriptKey(short ScriptKey) {
this.ScriptKey = ScriptKey;
}

/**
* Set the ReminderKey field
*
* @param ReminderKey Contents of the REMINDER_KEY column
*/
public void setReminderKey(short ReminderKey) {
this.ReminderKey = ReminderKey;
}

/**
* Set the DisplayOrder field
*
* @param DisplayOrder Contents of the DISPLAY_ORDER column
*/
public void setDisplayOrder(short DisplayOrder) {
this.DisplayOrder = DisplayOrder;
}

/**
* Set the Show field
*
* @param Show Contents of the SHOW column
*/
public void setShow(boolean Show) {
this.Show = Show;
}

}

