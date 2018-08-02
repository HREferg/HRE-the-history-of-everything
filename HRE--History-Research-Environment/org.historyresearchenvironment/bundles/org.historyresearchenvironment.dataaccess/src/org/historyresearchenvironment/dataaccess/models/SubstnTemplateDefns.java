package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSTN_TEMPLATE_DEFNS database table.
*
* @version 2018-08-02
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

public SubstnTemplateDefns() throws SQLException {
}


public SubstnTemplateDefns(int SubstnTemplateDefnPid) throws SQLException {
super();
this.SubstnTemplateDefnPid = SubstnTemplateDefnPid;
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
public AbstractHreDataModel get(int key) throws SQLException {
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
return this;
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

public int getRecordNum() {
return this.RecordNum;
}

public short getSetKey() {
return this.SetKey;
}

public int getCommitPid() {
return this.CommitPid;
}

public int getSubstnTemplateDefnPid() {
return this.SubstnTemplateDefnPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public boolean getIsTextLayout() {
return this.IsTextLayout;
}

public boolean getIsTextStyle() {
return this.IsTextStyle;
}

public short getScriptGroupKey() {
return this.ScriptGroupKey;
}

public short getScriptKey() {
return this.ScriptKey;
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

public void setSubstnTemplateDefnPid(int SubstnTemplateDefnPid) {
this.SubstnTemplateDefnPid = SubstnTemplateDefnPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setIsTextLayout(boolean IsTextLayout) {
this.IsTextLayout = IsTextLayout;
}

public void setIsTextStyle(boolean IsTextStyle) {
this.IsTextStyle = IsTextStyle;
}

public void setScriptGroupKey(short ScriptGroupKey) {
this.ScriptGroupKey = ScriptGroupKey;
}

public void setScriptKey(short ScriptKey) {
this.ScriptKey = ScriptKey;
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

