package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the LIFE_PHASE_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class LifePhaseDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"LIFE_PHASE_DEFN_PID, " +
"PLUGIN_KEY, " +
"ENTITY_TYPE_KEY, " +
"ENTITY_SUB_TYPE_KEY, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.LIFE_PHASE_DEFNS WHERE LIFE_PHASE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"LIFE_PHASE_DEFN_PID, " +  
"PLUGIN_KEY, " +  
"ENTITY_TYPE_KEY, " +  
"ENTITY_SUB_TYPE_KEY, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.LIFE_PHASE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.LIFE_PHASE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"LIFE_PHASE_DEFN_PID, " +     
"PLUGIN_KEY, " +     
"ENTITY_TYPE_KEY, " +     
"ENTITY_SUB_TYPE_KEY, " +     
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

private static final String UPDATE = "UPDATE PUBLIC.LIFE_PHASE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"PLUGIN_KEY = ?, " + 
"ENTITY_TYPE_KEY = ?, " + 
"ENTITY_SUB_TYPE_KEY = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE LIFE_PHASE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.LIFE_PHASE_DEFNS WHERE LIFE_PHASE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.LIFE_PHASE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int LifePhaseDefnPid;
private short PluginKey;
private short EntityTypeKey;
private short EntitySubTypeKey;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private LifePhaseDefns model;

public LifePhaseDefns() throws SQLException {
}


public LifePhaseDefns(int LifePhaseDefnPid) throws SQLException {
super();
this.LifePhaseDefnPid = LifePhaseDefnPid;
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
model = new LifePhaseDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setLifePhaseDefnPid(rs.getInt("LIFE_PHASE_DEFN_PID"));
model.setPluginKey(rs.getShort("PLUGIN_KEY"));
model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
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
model.setLifePhaseDefnPid(rs.getInt("LIFE_PHASE_DEFN_PID"));
model.setPluginKey(rs.getShort("PLUGIN_KEY"));
model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
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
((LifePhaseDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((LifePhaseDefns) model).setSetKey(rs.getShort("SET_KEY"));
((LifePhaseDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((LifePhaseDefns) model).setLifePhaseDefnPid(rs.getInt("LIFE_PHASE_DEFN_PID"));
((LifePhaseDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
((LifePhaseDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
((LifePhaseDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
((LifePhaseDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((LifePhaseDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((LifePhaseDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((LifePhaseDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((LifePhaseDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((LifePhaseDefns) model).setSetKey(rs.getShort("SET_KEY"));
((LifePhaseDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((LifePhaseDefns) model).setLifePhaseDefnPid(rs.getInt("LIFE_PHASE_DEFN_PID"));
((LifePhaseDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
((LifePhaseDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
((LifePhaseDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
((LifePhaseDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((LifePhaseDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((LifePhaseDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((LifePhaseDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getLifePhaseDefnPid() {
return this.LifePhaseDefnPid;
}

public short getPluginKey() {
return this.PluginKey;
}

public short getEntityTypeKey() {
return this.EntityTypeKey;
}

public short getEntitySubTypeKey() {
return this.EntitySubTypeKey;
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

public void setLifePhaseDefnPid(int LifePhaseDefnPid) {
this.LifePhaseDefnPid = LifePhaseDefnPid;
}

public void setPluginKey(short PluginKey) {
this.PluginKey = PluginKey;
}

public void setEntityTypeKey(short EntityTypeKey) {
this.EntityTypeKey = EntityTypeKey;
}

public void setEntitySubTypeKey(short EntitySubTypeKey) {
this.EntitySubTypeKey = EntitySubTypeKey;
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

