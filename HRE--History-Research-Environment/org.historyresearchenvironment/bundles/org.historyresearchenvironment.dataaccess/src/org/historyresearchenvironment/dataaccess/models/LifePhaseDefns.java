package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the LIFE_PHASE_DEFNS database table.
*
* @version 2018-08-05
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

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public LifePhaseDefns() throws SQLException {
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
public LifePhaseDefns get(int key) throws SQLException {
model = new LifePhaseDefns();
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
return model;
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
* Get the LifePhaseDefnPid field.
*
* @return Contents of the LIFE_PHASE_DEFN_PID column
*/
public int getLifePhaseDefnPid() {
return this.LifePhaseDefnPid;
}

/**
* Get the PluginKey field.
*
* @return Contents of the PLUGIN_KEY column
*/
public short getPluginKey() {
return this.PluginKey;
}

/**
* Get the EntityTypeKey field.
*
* @return Contents of the ENTITY_TYPE_KEY column
*/
public short getEntityTypeKey() {
return this.EntityTypeKey;
}

/**
* Get the EntitySubTypeKey field.
*
* @return Contents of the ENTITY_SUB_TYPE_KEY column
*/
public short getEntitySubTypeKey() {
return this.EntitySubTypeKey;
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
* Get the IsDefault field.
*
* @return Contents of the IS_DEFAULT column
*/
public boolean getIsDefault() {
return this.IsDefault;
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
* Set the LifePhaseDefnPid field
*
* @param LifePhaseDefnPid Contents of the LIFE_PHASE_DEFN_PID column
*/
public void setLifePhaseDefnPid(int LifePhaseDefnPid) {
this.LifePhaseDefnPid = LifePhaseDefnPid;
}

/**
* Set the PluginKey field
*
* @param PluginKey Contents of the PLUGIN_KEY column
*/
public void setPluginKey(short PluginKey) {
this.PluginKey = PluginKey;
}

/**
* Set the EntityTypeKey field
*
* @param EntityTypeKey Contents of the ENTITY_TYPE_KEY column
*/
public void setEntityTypeKey(short EntityTypeKey) {
this.EntityTypeKey = EntityTypeKey;
}

/**
* Set the EntitySubTypeKey field
*
* @param EntitySubTypeKey Contents of the ENTITY_SUB_TYPE_KEY column
*/
public void setEntitySubTypeKey(short EntitySubTypeKey) {
this.EntitySubTypeKey = EntitySubTypeKey;
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
* Set the IsDefault field
*
* @param IsDefault Contents of the IS_DEFAULT column
*/
public void setIsDefault(boolean IsDefault) {
this.IsDefault = IsDefault;
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

