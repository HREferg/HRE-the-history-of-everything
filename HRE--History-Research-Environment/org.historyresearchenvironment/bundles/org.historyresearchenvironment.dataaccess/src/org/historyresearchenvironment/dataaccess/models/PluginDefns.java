package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the PLUGIN_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class PluginDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"PLUGIN_DEFN_PID, " +
"IS_NATIVE, " +
"VERSON_NAME, " +
"PARENT_PCKG_KEY, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.PLUGIN_DEFNS WHERE PLUGIN_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"PLUGIN_DEFN_PID, " +  
"IS_NATIVE, " +  
"VERSON_NAME, " +  
"PARENT_PCKG_KEY, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.PLUGIN_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.PLUGIN_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"PLUGIN_DEFN_PID, " +     
"IS_NATIVE, " +     
"VERSON_NAME, " +     
"PARENT_PCKG_KEY, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.PLUGIN_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_NATIVE = ?, " + 
"VERSON_NAME = ?, " + 
"PARENT_PCKG_KEY = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE PLUGIN_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.PLUGIN_DEFNS WHERE PLUGIN_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.PLUGIN_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int PluginDefnPid;
private boolean IsNative;
private String VersonName;
private short ParentPckgKey;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private PluginDefns model;

public PluginDefns() throws SQLException {
}


public PluginDefns(int PluginDefnPid) throws SQLException {
super();
this.PluginDefnPid = PluginDefnPid;
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
model = new PluginDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setPluginDefnPid(rs.getInt("PLUGIN_DEFN_PID"));
model.setIsNative(rs.getBoolean("IS_NATIVE"));
model.setVersonName(rs.getString("VERSON_NAME"));
model.setParentPckgKey(rs.getShort("PARENT_PCKG_KEY"));
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
model.setPluginDefnPid(rs.getInt("PLUGIN_DEFN_PID"));
model.setIsNative(rs.getBoolean("IS_NATIVE"));
model.setVersonName(rs.getString("VERSON_NAME"));
model.setParentPckgKey(rs.getShort("PARENT_PCKG_KEY"));
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
((PluginDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((PluginDefns) model).setSetKey(rs.getShort("SET_KEY"));
((PluginDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((PluginDefns) model).setPluginDefnPid(rs.getInt("PLUGIN_DEFN_PID"));
((PluginDefns) model).setIsNative(rs.getBoolean("IS_NATIVE"));
((PluginDefns) model).setVersonName(rs.getString("VERSON_NAME"));
((PluginDefns) model).setParentPckgKey(rs.getShort("PARENT_PCKG_KEY"));
((PluginDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((PluginDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((PluginDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((PluginDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((PluginDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((PluginDefns) model).setSetKey(rs.getShort("SET_KEY"));
((PluginDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((PluginDefns) model).setPluginDefnPid(rs.getInt("PLUGIN_DEFN_PID"));
((PluginDefns) model).setIsNative(rs.getBoolean("IS_NATIVE"));
((PluginDefns) model).setVersonName(rs.getString("VERSON_NAME"));
((PluginDefns) model).setParentPckgKey(rs.getShort("PARENT_PCKG_KEY"));
((PluginDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((PluginDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((PluginDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((PluginDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getPluginDefnPid() {
return this.PluginDefnPid;
}

public boolean getIsNative() {
return this.IsNative;
}

public String getVersonName() {
return this.VersonName;
}

public short getParentPckgKey() {
return this.ParentPckgKey;
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

public void setPluginDefnPid(int PluginDefnPid) {
this.PluginDefnPid = PluginDefnPid;
}

public void setIsNative(boolean IsNative) {
this.IsNative = IsNative;
}

public void setVersonName(String VersonName) {
this.VersonName = VersonName;
}

public void setParentPckgKey(short ParentPckgKey) {
this.ParentPckgKey = ParentPckgKey;
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

