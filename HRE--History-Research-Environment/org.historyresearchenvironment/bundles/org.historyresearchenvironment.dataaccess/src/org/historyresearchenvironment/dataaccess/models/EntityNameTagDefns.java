package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the ENTITY_NAME_TAG_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class EntityNameTagDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"ENTITY_NAME_TAG_DEFN_PID, " +
"IS_SYSTEM, " +
"PLUGIN_PID, " +
"VIEW_DATA_SCRIPT_GROUP_KEY, " +
"VIEW_DATA_SCRIPT_PID, " +
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +
"MODIFY_DATA_SCRIPT_PID, " +
"DELETE_DATA_SCRIPT_GROUP_KEY, " +
"DELETE_DATA_SCRIPT_PID, " +
"ENTITY_TYPE_KEY, " +
"ENTITY_SUB_TYPE_KEY, " +
"DFLT_SENTCE_SET_KEY, " +
"DFLT_TAG_GROUP_KEY, " +
"DFLT_THEME_KEY, " +
"SENTCE_SET_TYPE_KEY, " +
"SENTCE_STYLE_TYPE_KEY, " +
"GLOBAL_SENTCE_SET_KEY, " +
"MEMO_SET_TYPE_KEY, " +
"HAS_MULTI_PART, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.ENTITY_NAME_TAG_DEFNS WHERE ENTITY_NAME_TAG_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"ENTITY_NAME_TAG_DEFN_PID, " +  
"IS_SYSTEM, " +  
"PLUGIN_PID, " +  
"VIEW_DATA_SCRIPT_GROUP_KEY, " +  
"VIEW_DATA_SCRIPT_PID, " +  
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +  
"MODIFY_DATA_SCRIPT_PID, " +  
"DELETE_DATA_SCRIPT_GROUP_KEY, " +  
"DELETE_DATA_SCRIPT_PID, " +  
"ENTITY_TYPE_KEY, " +  
"ENTITY_SUB_TYPE_KEY, " +  
"DFLT_SENTCE_SET_KEY, " +  
"DFLT_TAG_GROUP_KEY, " +  
"DFLT_THEME_KEY, " +  
"SENTCE_SET_TYPE_KEY, " +  
"SENTCE_STYLE_TYPE_KEY, " +  
"GLOBAL_SENTCE_SET_KEY, " +  
"MEMO_SET_TYPE_KEY, " +  
"HAS_MULTI_PART, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.ENTITY_NAME_TAG_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.ENTITY_NAME_TAG_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"ENTITY_NAME_TAG_DEFN_PID, " +     
"IS_SYSTEM, " +     
"PLUGIN_PID, " +     
"VIEW_DATA_SCRIPT_GROUP_KEY, " +     
"VIEW_DATA_SCRIPT_PID, " +     
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +     
"MODIFY_DATA_SCRIPT_PID, " +     
"DELETE_DATA_SCRIPT_GROUP_KEY, " +     
"DELETE_DATA_SCRIPT_PID, " +     
"ENTITY_TYPE_KEY, " +     
"ENTITY_SUB_TYPE_KEY, " +     
"DFLT_SENTCE_SET_KEY, " +     
"DFLT_TAG_GROUP_KEY, " +     
"DFLT_THEME_KEY, " +     
"SENTCE_SET_TYPE_KEY, " +     
"SENTCE_STYLE_TYPE_KEY, " +     
"GLOBAL_SENTCE_SET_KEY, " +     
"MEMO_SET_TYPE_KEY, " +     
"HAS_MULTI_PART, " +     
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
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.ENTITY_NAME_TAG_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PLUGIN_PID = ?, " + 
"VIEW_DATA_SCRIPT_GROUP_KEY = ?, " + 
"VIEW_DATA_SCRIPT_PID = ?, " + 
"MODIFY_DATA_SCRIPT_GROUP_KEY = ?, " + 
"MODIFY_DATA_SCRIPT_PID = ?, " + 
"DELETE_DATA_SCRIPT_GROUP_KEY = ?, " + 
"DELETE_DATA_SCRIPT_PID = ?, " + 
"ENTITY_TYPE_KEY = ?, " + 
"ENTITY_SUB_TYPE_KEY = ?, " + 
"DFLT_SENTCE_SET_KEY = ?, " + 
"DFLT_TAG_GROUP_KEY = ?, " + 
"DFLT_THEME_KEY = ?, " + 
"SENTCE_SET_TYPE_KEY = ?, " + 
"SENTCE_STYLE_TYPE_KEY = ?, " + 
"GLOBAL_SENTCE_SET_KEY = ?, " + 
"MEMO_SET_TYPE_KEY = ?, " + 
"HAS_MULTI_PART = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE ENTITY_NAME_TAG_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.ENTITY_NAME_TAG_DEFNS WHERE ENTITY_NAME_TAG_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.ENTITY_NAME_TAG_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int EntityNameTagDefnPid;
private boolean IsSystem;
private short PluginPid;
private short ViewDataScriptGroupKey;
private int ViewDataScriptPid;
private short ModifyDataScriptGroupKey;
private int ModifyDataScriptPid;
private short DeleteDataScriptGroupKey;
private int DeleteDataScriptPid;
private short EntityTypeKey;
private short EntitySubTypeKey;
private short DfltSentceSetKey;
private short DfltTagGroupKey;
private short DfltThemeKey;
private short SentceSetTypeKey;
private short SentceStyleTypeKey;
private short GlobalSentceSetKey;
private short MemoSetTypeKey;
private boolean HasMultiPart;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private EntityNameTagDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public EntityNameTagDefns() throws SQLException {
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
model = new EntityNameTagDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setEntityNameTagDefnPid(rs.getInt("ENTITY_NAME_TAG_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setPluginPid(rs.getShort("PLUGIN_PID"));
model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
model.setDfltSentceSetKey(rs.getShort("DFLT_SENTCE_SET_KEY"));
model.setDfltTagGroupKey(rs.getShort("DFLT_TAG_GROUP_KEY"));
model.setDfltThemeKey(rs.getShort("DFLT_THEME_KEY"));
model.setSentceSetTypeKey(rs.getShort("SENTCE_SET_TYPE_KEY"));
model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
model.setGlobalSentceSetKey(rs.getShort("GLOBAL_SENTCE_SET_KEY"));
model.setMemoSetTypeKey(rs.getShort("MEMO_SET_TYPE_KEY"));
model.setHasMultiPart(rs.getBoolean("HAS_MULTI_PART"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public EntityNameTagDefns get(int key) throws SQLException {
model = new EntityNameTagDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setEntityNameTagDefnPid(rs.getInt("ENTITY_NAME_TAG_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setPluginPid(rs.getShort("PLUGIN_PID"));
model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
model.setDfltSentceSetKey(rs.getShort("DFLT_SENTCE_SET_KEY"));
model.setDfltTagGroupKey(rs.getShort("DFLT_TAG_GROUP_KEY"));
model.setDfltThemeKey(rs.getShort("DFLT_THEME_KEY"));
model.setSentceSetTypeKey(rs.getShort("SENTCE_SET_TYPE_KEY"));
model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
model.setGlobalSentceSetKey(rs.getShort("GLOBAL_SENTCE_SET_KEY"));
model.setMemoSetTypeKey(rs.getShort("MEMO_SET_TYPE_KEY"));
model.setHasMultiPart(rs.getBoolean("HAS_MULTI_PART"));
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
((EntityNameTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((EntityNameTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
((EntityNameTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((EntityNameTagDefns) model).setEntityNameTagDefnPid(rs.getInt("ENTITY_NAME_TAG_DEFN_PID"));
((EntityNameTagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((EntityNameTagDefns) model).setPluginPid(rs.getShort("PLUGIN_PID"));
((EntityNameTagDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
((EntityNameTagDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
((EntityNameTagDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
((EntityNameTagDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
((EntityNameTagDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
((EntityNameTagDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
((EntityNameTagDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
((EntityNameTagDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
((EntityNameTagDefns) model).setDfltSentceSetKey(rs.getShort("DFLT_SENTCE_SET_KEY"));
((EntityNameTagDefns) model).setDfltTagGroupKey(rs.getShort("DFLT_TAG_GROUP_KEY"));
((EntityNameTagDefns) model).setDfltThemeKey(rs.getShort("DFLT_THEME_KEY"));
((EntityNameTagDefns) model).setSentceSetTypeKey(rs.getShort("SENTCE_SET_TYPE_KEY"));
((EntityNameTagDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
((EntityNameTagDefns) model).setGlobalSentceSetKey(rs.getShort("GLOBAL_SENTCE_SET_KEY"));
((EntityNameTagDefns) model).setMemoSetTypeKey(rs.getShort("MEMO_SET_TYPE_KEY"));
((EntityNameTagDefns) model).setHasMultiPart(rs.getBoolean("HAS_MULTI_PART"));
((EntityNameTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((EntityNameTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((EntityNameTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((EntityNameTagDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((EntityNameTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((EntityNameTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
((EntityNameTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((EntityNameTagDefns) model).setEntityNameTagDefnPid(rs.getInt("ENTITY_NAME_TAG_DEFN_PID"));
((EntityNameTagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((EntityNameTagDefns) model).setPluginPid(rs.getShort("PLUGIN_PID"));
((EntityNameTagDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
((EntityNameTagDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
((EntityNameTagDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
((EntityNameTagDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
((EntityNameTagDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
((EntityNameTagDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
((EntityNameTagDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
((EntityNameTagDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
((EntityNameTagDefns) model).setDfltSentceSetKey(rs.getShort("DFLT_SENTCE_SET_KEY"));
((EntityNameTagDefns) model).setDfltTagGroupKey(rs.getShort("DFLT_TAG_GROUP_KEY"));
((EntityNameTagDefns) model).setDfltThemeKey(rs.getShort("DFLT_THEME_KEY"));
((EntityNameTagDefns) model).setSentceSetTypeKey(rs.getShort("SENTCE_SET_TYPE_KEY"));
((EntityNameTagDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
((EntityNameTagDefns) model).setGlobalSentceSetKey(rs.getShort("GLOBAL_SENTCE_SET_KEY"));
((EntityNameTagDefns) model).setMemoSetTypeKey(rs.getShort("MEMO_SET_TYPE_KEY"));
((EntityNameTagDefns) model).setHasMultiPart(rs.getBoolean("HAS_MULTI_PART"));
((EntityNameTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((EntityNameTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((EntityNameTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((EntityNameTagDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the EntityNameTagDefnPid field.
*
* @return Contents of the ENTITY_NAME_TAG_DEFN_PID column
*/
public int getEntityNameTagDefnPid() {
return this.EntityNameTagDefnPid;
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
* Get the PluginPid field.
*
* @return Contents of the PLUGIN_PID column
*/
public short getPluginPid() {
return this.PluginPid;
}

/**
* Get the ViewDataScriptGroupKey field.
*
* @return Contents of the VIEW_DATA_SCRIPT_GROUP_KEY column
*/
public short getViewDataScriptGroupKey() {
return this.ViewDataScriptGroupKey;
}

/**
* Get the ViewDataScriptPid field.
*
* @return Contents of the VIEW_DATA_SCRIPT_PID column
*/
public int getViewDataScriptPid() {
return this.ViewDataScriptPid;
}

/**
* Get the ModifyDataScriptGroupKey field.
*
* @return Contents of the MODIFY_DATA_SCRIPT_GROUP_KEY column
*/
public short getModifyDataScriptGroupKey() {
return this.ModifyDataScriptGroupKey;
}

/**
* Get the ModifyDataScriptPid field.
*
* @return Contents of the MODIFY_DATA_SCRIPT_PID column
*/
public int getModifyDataScriptPid() {
return this.ModifyDataScriptPid;
}

/**
* Get the DeleteDataScriptGroupKey field.
*
* @return Contents of the DELETE_DATA_SCRIPT_GROUP_KEY column
*/
public short getDeleteDataScriptGroupKey() {
return this.DeleteDataScriptGroupKey;
}

/**
* Get the DeleteDataScriptPid field.
*
* @return Contents of the DELETE_DATA_SCRIPT_PID column
*/
public int getDeleteDataScriptPid() {
return this.DeleteDataScriptPid;
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
* Get the DfltSentceSetKey field.
*
* @return Contents of the DFLT_SENTCE_SET_KEY column
*/
public short getDfltSentceSetKey() {
return this.DfltSentceSetKey;
}

/**
* Get the DfltTagGroupKey field.
*
* @return Contents of the DFLT_TAG_GROUP_KEY column
*/
public short getDfltTagGroupKey() {
return this.DfltTagGroupKey;
}

/**
* Get the DfltThemeKey field.
*
* @return Contents of the DFLT_THEME_KEY column
*/
public short getDfltThemeKey() {
return this.DfltThemeKey;
}

/**
* Get the SentceSetTypeKey field.
*
* @return Contents of the SENTCE_SET_TYPE_KEY column
*/
public short getSentceSetTypeKey() {
return this.SentceSetTypeKey;
}

/**
* Get the SentceStyleTypeKey field.
*
* @return Contents of the SENTCE_STYLE_TYPE_KEY column
*/
public short getSentceStyleTypeKey() {
return this.SentceStyleTypeKey;
}

/**
* Get the GlobalSentceSetKey field.
*
* @return Contents of the GLOBAL_SENTCE_SET_KEY column
*/
public short getGlobalSentceSetKey() {
return this.GlobalSentceSetKey;
}

/**
* Get the MemoSetTypeKey field.
*
* @return Contents of the MEMO_SET_TYPE_KEY column
*/
public short getMemoSetTypeKey() {
return this.MemoSetTypeKey;
}

/**
* Get the HasMultiPart field.
*
* @return Contents of the HAS_MULTI_PART column
*/
public boolean getHasMultiPart() {
return this.HasMultiPart;
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
* Set the EntityNameTagDefnPid field
*
* @param EntityNameTagDefnPid Contents of the ENTITY_NAME_TAG_DEFN_PID column
*/
public void setEntityNameTagDefnPid(int EntityNameTagDefnPid) {
this.EntityNameTagDefnPid = EntityNameTagDefnPid;
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
* Set the PluginPid field
*
* @param PluginPid Contents of the PLUGIN_PID column
*/
public void setPluginPid(short PluginPid) {
this.PluginPid = PluginPid;
}

/**
* Set the ViewDataScriptGroupKey field
*
* @param ViewDataScriptGroupKey Contents of the VIEW_DATA_SCRIPT_GROUP_KEY column
*/
public void setViewDataScriptGroupKey(short ViewDataScriptGroupKey) {
this.ViewDataScriptGroupKey = ViewDataScriptGroupKey;
}

/**
* Set the ViewDataScriptPid field
*
* @param ViewDataScriptPid Contents of the VIEW_DATA_SCRIPT_PID column
*/
public void setViewDataScriptPid(int ViewDataScriptPid) {
this.ViewDataScriptPid = ViewDataScriptPid;
}

/**
* Set the ModifyDataScriptGroupKey field
*
* @param ModifyDataScriptGroupKey Contents of the MODIFY_DATA_SCRIPT_GROUP_KEY column
*/
public void setModifyDataScriptGroupKey(short ModifyDataScriptGroupKey) {
this.ModifyDataScriptGroupKey = ModifyDataScriptGroupKey;
}

/**
* Set the ModifyDataScriptPid field
*
* @param ModifyDataScriptPid Contents of the MODIFY_DATA_SCRIPT_PID column
*/
public void setModifyDataScriptPid(int ModifyDataScriptPid) {
this.ModifyDataScriptPid = ModifyDataScriptPid;
}

/**
* Set the DeleteDataScriptGroupKey field
*
* @param DeleteDataScriptGroupKey Contents of the DELETE_DATA_SCRIPT_GROUP_KEY column
*/
public void setDeleteDataScriptGroupKey(short DeleteDataScriptGroupKey) {
this.DeleteDataScriptGroupKey = DeleteDataScriptGroupKey;
}

/**
* Set the DeleteDataScriptPid field
*
* @param DeleteDataScriptPid Contents of the DELETE_DATA_SCRIPT_PID column
*/
public void setDeleteDataScriptPid(int DeleteDataScriptPid) {
this.DeleteDataScriptPid = DeleteDataScriptPid;
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
* Set the DfltSentceSetKey field
*
* @param DfltSentceSetKey Contents of the DFLT_SENTCE_SET_KEY column
*/
public void setDfltSentceSetKey(short DfltSentceSetKey) {
this.DfltSentceSetKey = DfltSentceSetKey;
}

/**
* Set the DfltTagGroupKey field
*
* @param DfltTagGroupKey Contents of the DFLT_TAG_GROUP_KEY column
*/
public void setDfltTagGroupKey(short DfltTagGroupKey) {
this.DfltTagGroupKey = DfltTagGroupKey;
}

/**
* Set the DfltThemeKey field
*
* @param DfltThemeKey Contents of the DFLT_THEME_KEY column
*/
public void setDfltThemeKey(short DfltThemeKey) {
this.DfltThemeKey = DfltThemeKey;
}

/**
* Set the SentceSetTypeKey field
*
* @param SentceSetTypeKey Contents of the SENTCE_SET_TYPE_KEY column
*/
public void setSentceSetTypeKey(short SentceSetTypeKey) {
this.SentceSetTypeKey = SentceSetTypeKey;
}

/**
* Set the SentceStyleTypeKey field
*
* @param SentceStyleTypeKey Contents of the SENTCE_STYLE_TYPE_KEY column
*/
public void setSentceStyleTypeKey(short SentceStyleTypeKey) {
this.SentceStyleTypeKey = SentceStyleTypeKey;
}

/**
* Set the GlobalSentceSetKey field
*
* @param GlobalSentceSetKey Contents of the GLOBAL_SENTCE_SET_KEY column
*/
public void setGlobalSentceSetKey(short GlobalSentceSetKey) {
this.GlobalSentceSetKey = GlobalSentceSetKey;
}

/**
* Set the MemoSetTypeKey field
*
* @param MemoSetTypeKey Contents of the MEMO_SET_TYPE_KEY column
*/
public void setMemoSetTypeKey(short MemoSetTypeKey) {
this.MemoSetTypeKey = MemoSetTypeKey;
}

/**
* Set the HasMultiPart field
*
* @param HasMultiPart Contents of the HAS_MULTI_PART column
*/
public void setHasMultiPart(boolean HasMultiPart) {
this.HasMultiPart = HasMultiPart;
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

