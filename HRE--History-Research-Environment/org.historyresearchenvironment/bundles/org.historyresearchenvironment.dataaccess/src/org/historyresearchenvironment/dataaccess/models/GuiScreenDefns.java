package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the GUI_SCREEN_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class GuiScreenDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"GUI_SCREEN_DEFN_PID, " +
"PLUGIN_KEY, " +
"TOP_ELEMENT, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.GUI_SCREEN_DEFNS WHERE GUI_SCREEN_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"GUI_SCREEN_DEFN_PID, " +  
"PLUGIN_KEY, " +  
"TOP_ELEMENT, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.GUI_SCREEN_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.GUI_SCREEN_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"GUI_SCREEN_DEFN_PID, " +     
"PLUGIN_KEY, " +     
"TOP_ELEMENT, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.GUI_SCREEN_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"PLUGIN_KEY = ?, " + 
"TOP_ELEMENT = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE GUI_SCREEN_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.GUI_SCREEN_DEFNS WHERE GUI_SCREEN_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.GUI_SCREEN_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int GuiScreenDefnPid;
private short PluginKey;
private short TopElement;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private GuiScreenDefns model;

public GuiScreenDefns() throws SQLException {
}


public GuiScreenDefns(int GuiScreenDefnPid) throws SQLException {
super();
this.GuiScreenDefnPid = GuiScreenDefnPid;
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
model = new GuiScreenDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setGuiScreenDefnPid(rs.getInt("GUI_SCREEN_DEFN_PID"));
model.setPluginKey(rs.getShort("PLUGIN_KEY"));
model.setTopElement(rs.getShort("TOP_ELEMENT"));
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
model.setGuiScreenDefnPid(rs.getInt("GUI_SCREEN_DEFN_PID"));
model.setPluginKey(rs.getShort("PLUGIN_KEY"));
model.setTopElement(rs.getShort("TOP_ELEMENT"));
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
((GuiScreenDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((GuiScreenDefns) model).setSetKey(rs.getShort("SET_KEY"));
((GuiScreenDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((GuiScreenDefns) model).setGuiScreenDefnPid(rs.getInt("GUI_SCREEN_DEFN_PID"));
((GuiScreenDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
((GuiScreenDefns) model).setTopElement(rs.getShort("TOP_ELEMENT"));
((GuiScreenDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((GuiScreenDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((GuiScreenDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((GuiScreenDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((GuiScreenDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((GuiScreenDefns) model).setSetKey(rs.getShort("SET_KEY"));
((GuiScreenDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((GuiScreenDefns) model).setGuiScreenDefnPid(rs.getInt("GUI_SCREEN_DEFN_PID"));
((GuiScreenDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
((GuiScreenDefns) model).setTopElement(rs.getShort("TOP_ELEMENT"));
((GuiScreenDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((GuiScreenDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((GuiScreenDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((GuiScreenDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getGuiScreenDefnPid() {
return this.GuiScreenDefnPid;
}

public short getPluginKey() {
return this.PluginKey;
}

public short getTopElement() {
return this.TopElement;
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

public void setGuiScreenDefnPid(int GuiScreenDefnPid) {
this.GuiScreenDefnPid = GuiScreenDefnPid;
}

public void setPluginKey(short PluginKey) {
this.PluginKey = PluginKey;
}

public void setTopElement(short TopElement) {
this.TopElement = TopElement;
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

