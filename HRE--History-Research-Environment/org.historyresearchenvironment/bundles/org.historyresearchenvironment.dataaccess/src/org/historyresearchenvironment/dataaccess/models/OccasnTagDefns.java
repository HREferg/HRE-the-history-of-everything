package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the OCCASN_TAG_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class OccasnTagDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"OCCASN_TAG_DEFN_PID, " +
"IS_SYSTEM, " +
"VIEW_DATA_SCRIPT_GROUP_KEY, " +
"VIEW_DATA_SCRIPT_PID, " +
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +
"MODIFY_DATA_SCRIPT_PID, " +
"DELETE_DATA_SCRIPT_GROUP_KEY, " +
"DELETE_DATA_SCRIPT_PID, " +
"IS_EVENT, " +
"MIN_NUM_LOCATION_ASSOC, " +
"HAS_PARENTS, " +
"MAX_NUM_LOCATION_ASSOC, " +
"MIN_NUM_HDATE_ASSOC, " +
"MAX_NUM_HDATE_ASSOC, " +
"MIN_NUM_KEY_ASSOC, " +
"MAX_NUM_KEY_ASSOC, " +
"DFLT_TAG_GROUP_KEY, " +
"DFLT_THEME_KEY, " +
"SENTCE_SET_TYPE_KEY, " +
"SENTCE_STYLE_TYPE_KEY, " +
"GLOBAL_SENTCE_SET_KEY, " +
"MEMO_SET_TYPE_KEY, " +
"GEDCOM_TAG, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.OCCASN_TAG_DEFNS WHERE OCCASN_TAG_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"OCCASN_TAG_DEFN_PID, " +  
"IS_SYSTEM, " +  
"VIEW_DATA_SCRIPT_GROUP_KEY, " +  
"VIEW_DATA_SCRIPT_PID, " +  
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +  
"MODIFY_DATA_SCRIPT_PID, " +  
"DELETE_DATA_SCRIPT_GROUP_KEY, " +  
"DELETE_DATA_SCRIPT_PID, " +  
"IS_EVENT, " +  
"MIN_NUM_LOCATION_ASSOC, " +  
"HAS_PARENTS, " +  
"MAX_NUM_LOCATION_ASSOC, " +  
"MIN_NUM_HDATE_ASSOC, " +  
"MAX_NUM_HDATE_ASSOC, " +  
"MIN_NUM_KEY_ASSOC, " +  
"MAX_NUM_KEY_ASSOC, " +  
"DFLT_TAG_GROUP_KEY, " +  
"DFLT_THEME_KEY, " +  
"SENTCE_SET_TYPE_KEY, " +  
"SENTCE_STYLE_TYPE_KEY, " +  
"GLOBAL_SENTCE_SET_KEY, " +  
"MEMO_SET_TYPE_KEY, " +  
"GEDCOM_TAG, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.OCCASN_TAG_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.OCCASN_TAG_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"OCCASN_TAG_DEFN_PID, " +     
"IS_SYSTEM, " +     
"VIEW_DATA_SCRIPT_GROUP_KEY, " +     
"VIEW_DATA_SCRIPT_PID, " +     
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +     
"MODIFY_DATA_SCRIPT_PID, " +     
"DELETE_DATA_SCRIPT_GROUP_KEY, " +     
"DELETE_DATA_SCRIPT_PID, " +     
"IS_EVENT, " +     
"MIN_NUM_LOCATION_ASSOC, " +     
"HAS_PARENTS, " +     
"MAX_NUM_LOCATION_ASSOC, " +     
"MIN_NUM_HDATE_ASSOC, " +     
"MAX_NUM_HDATE_ASSOC, " +     
"MIN_NUM_KEY_ASSOC, " +     
"MAX_NUM_KEY_ASSOC, " +     
"DFLT_TAG_GROUP_KEY, " +     
"DFLT_THEME_KEY, " +     
"SENTCE_SET_TYPE_KEY, " +     
"SENTCE_STYLE_TYPE_KEY, " +     
"GLOBAL_SENTCE_SET_KEY, " +     
"MEMO_SET_TYPE_KEY, " +     
"GEDCOM_TAG, " +     
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
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.OCCASN_TAG_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"VIEW_DATA_SCRIPT_GROUP_KEY = ?, " + 
"VIEW_DATA_SCRIPT_PID = ?, " + 
"MODIFY_DATA_SCRIPT_GROUP_KEY = ?, " + 
"MODIFY_DATA_SCRIPT_PID = ?, " + 
"DELETE_DATA_SCRIPT_GROUP_KEY = ?, " + 
"DELETE_DATA_SCRIPT_PID = ?, " + 
"IS_EVENT = ?, " + 
"MIN_NUM_LOCATION_ASSOC = ?, " + 
"HAS_PARENTS = ?, " + 
"MAX_NUM_LOCATION_ASSOC = ?, " + 
"MIN_NUM_HDATE_ASSOC = ?, " + 
"MAX_NUM_HDATE_ASSOC = ?, " + 
"MIN_NUM_KEY_ASSOC = ?, " + 
"MAX_NUM_KEY_ASSOC = ?, " + 
"DFLT_TAG_GROUP_KEY = ?, " + 
"DFLT_THEME_KEY = ?, " + 
"SENTCE_SET_TYPE_KEY = ?, " + 
"SENTCE_STYLE_TYPE_KEY = ?, " + 
"GLOBAL_SENTCE_SET_KEY = ?, " + 
"MEMO_SET_TYPE_KEY = ?, " + 
"GEDCOM_TAG = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE OCCASN_TAG_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.OCCASN_TAG_DEFNS WHERE OCCASN_TAG_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASN_TAG_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int OccasnTagDefnPid;
private boolean IsSystem;
private short ViewDataScriptGroupKey;
private int ViewDataScriptPid;
private short ModifyDataScriptGroupKey;
private int ModifyDataScriptPid;
private short DeleteDataScriptGroupKey;
private int DeleteDataScriptPid;
private boolean IsEvent;
private short MinNumLocationAssoc;
private boolean HasParents;
private short MaxNumLocationAssoc;
private short MinNumHdateAssoc;
private short MaxNumHdateAssoc;
private short MinNumKeyAssoc;
private short MaxNumKeyAssoc;
private short DfltTagGroupKey;
private short DfltThemeKey;
private short SentceSetTypeKey;
private short SentceStyleTypeKey;
private short GlobalSentceSetKey;
private short MemoSetTypeKey;
private String GedcomTag;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private OccasnTagDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public OccasnTagDefns() throws SQLException {
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
model = new OccasnTagDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOccasnTagDefnPid(rs.getInt("OCCASN_TAG_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
model.setIsEvent(rs.getBoolean("IS_EVENT"));
model.setMinNumLocationAssoc(rs.getShort("MIN_NUM_LOCATION_ASSOC"));
model.setHasParents(rs.getBoolean("HAS_PARENTS"));
model.setMaxNumLocationAssoc(rs.getShort("MAX_NUM_LOCATION_ASSOC"));
model.setMinNumHdateAssoc(rs.getShort("MIN_NUM_HDATE_ASSOC"));
model.setMaxNumHdateAssoc(rs.getShort("MAX_NUM_HDATE_ASSOC"));
model.setMinNumKeyAssoc(rs.getShort("MIN_NUM_KEY_ASSOC"));
model.setMaxNumKeyAssoc(rs.getShort("MAX_NUM_KEY_ASSOC"));
model.setDfltTagGroupKey(rs.getShort("DFLT_TAG_GROUP_KEY"));
model.setDfltThemeKey(rs.getShort("DFLT_THEME_KEY"));
model.setSentceSetTypeKey(rs.getShort("SENTCE_SET_TYPE_KEY"));
model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
model.setGlobalSentceSetKey(rs.getShort("GLOBAL_SENTCE_SET_KEY"));
model.setMemoSetTypeKey(rs.getShort("MEMO_SET_TYPE_KEY"));
model.setGedcomTag(rs.getString("GEDCOM_TAG"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public OccasnTagDefns get(int key) throws SQLException {
model = new OccasnTagDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOccasnTagDefnPid(rs.getInt("OCCASN_TAG_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
model.setIsEvent(rs.getBoolean("IS_EVENT"));
model.setMinNumLocationAssoc(rs.getShort("MIN_NUM_LOCATION_ASSOC"));
model.setHasParents(rs.getBoolean("HAS_PARENTS"));
model.setMaxNumLocationAssoc(rs.getShort("MAX_NUM_LOCATION_ASSOC"));
model.setMinNumHdateAssoc(rs.getShort("MIN_NUM_HDATE_ASSOC"));
model.setMaxNumHdateAssoc(rs.getShort("MAX_NUM_HDATE_ASSOC"));
model.setMinNumKeyAssoc(rs.getShort("MIN_NUM_KEY_ASSOC"));
model.setMaxNumKeyAssoc(rs.getShort("MAX_NUM_KEY_ASSOC"));
model.setDfltTagGroupKey(rs.getShort("DFLT_TAG_GROUP_KEY"));
model.setDfltThemeKey(rs.getShort("DFLT_THEME_KEY"));
model.setSentceSetTypeKey(rs.getShort("SENTCE_SET_TYPE_KEY"));
model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
model.setGlobalSentceSetKey(rs.getShort("GLOBAL_SENTCE_SET_KEY"));
model.setMemoSetTypeKey(rs.getShort("MEMO_SET_TYPE_KEY"));
model.setGedcomTag(rs.getString("GEDCOM_TAG"));
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
((OccasnTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OccasnTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
((OccasnTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OccasnTagDefns) model).setOccasnTagDefnPid(rs.getInt("OCCASN_TAG_DEFN_PID"));
((OccasnTagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((OccasnTagDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
((OccasnTagDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
((OccasnTagDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
((OccasnTagDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
((OccasnTagDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
((OccasnTagDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
((OccasnTagDefns) model).setIsEvent(rs.getBoolean("IS_EVENT"));
((OccasnTagDefns) model).setMinNumLocationAssoc(rs.getShort("MIN_NUM_LOCATION_ASSOC"));
((OccasnTagDefns) model).setHasParents(rs.getBoolean("HAS_PARENTS"));
((OccasnTagDefns) model).setMaxNumLocationAssoc(rs.getShort("MAX_NUM_LOCATION_ASSOC"));
((OccasnTagDefns) model).setMinNumHdateAssoc(rs.getShort("MIN_NUM_HDATE_ASSOC"));
((OccasnTagDefns) model).setMaxNumHdateAssoc(rs.getShort("MAX_NUM_HDATE_ASSOC"));
((OccasnTagDefns) model).setMinNumKeyAssoc(rs.getShort("MIN_NUM_KEY_ASSOC"));
((OccasnTagDefns) model).setMaxNumKeyAssoc(rs.getShort("MAX_NUM_KEY_ASSOC"));
((OccasnTagDefns) model).setDfltTagGroupKey(rs.getShort("DFLT_TAG_GROUP_KEY"));
((OccasnTagDefns) model).setDfltThemeKey(rs.getShort("DFLT_THEME_KEY"));
((OccasnTagDefns) model).setSentceSetTypeKey(rs.getShort("SENTCE_SET_TYPE_KEY"));
((OccasnTagDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
((OccasnTagDefns) model).setGlobalSentceSetKey(rs.getShort("GLOBAL_SENTCE_SET_KEY"));
((OccasnTagDefns) model).setMemoSetTypeKey(rs.getShort("MEMO_SET_TYPE_KEY"));
((OccasnTagDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
((OccasnTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((OccasnTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((OccasnTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((OccasnTagDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((OccasnTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OccasnTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
((OccasnTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OccasnTagDefns) model).setOccasnTagDefnPid(rs.getInt("OCCASN_TAG_DEFN_PID"));
((OccasnTagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((OccasnTagDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
((OccasnTagDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
((OccasnTagDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
((OccasnTagDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
((OccasnTagDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
((OccasnTagDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
((OccasnTagDefns) model).setIsEvent(rs.getBoolean("IS_EVENT"));
((OccasnTagDefns) model).setMinNumLocationAssoc(rs.getShort("MIN_NUM_LOCATION_ASSOC"));
((OccasnTagDefns) model).setHasParents(rs.getBoolean("HAS_PARENTS"));
((OccasnTagDefns) model).setMaxNumLocationAssoc(rs.getShort("MAX_NUM_LOCATION_ASSOC"));
((OccasnTagDefns) model).setMinNumHdateAssoc(rs.getShort("MIN_NUM_HDATE_ASSOC"));
((OccasnTagDefns) model).setMaxNumHdateAssoc(rs.getShort("MAX_NUM_HDATE_ASSOC"));
((OccasnTagDefns) model).setMinNumKeyAssoc(rs.getShort("MIN_NUM_KEY_ASSOC"));
((OccasnTagDefns) model).setMaxNumKeyAssoc(rs.getShort("MAX_NUM_KEY_ASSOC"));
((OccasnTagDefns) model).setDfltTagGroupKey(rs.getShort("DFLT_TAG_GROUP_KEY"));
((OccasnTagDefns) model).setDfltThemeKey(rs.getShort("DFLT_THEME_KEY"));
((OccasnTagDefns) model).setSentceSetTypeKey(rs.getShort("SENTCE_SET_TYPE_KEY"));
((OccasnTagDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
((OccasnTagDefns) model).setGlobalSentceSetKey(rs.getShort("GLOBAL_SENTCE_SET_KEY"));
((OccasnTagDefns) model).setMemoSetTypeKey(rs.getShort("MEMO_SET_TYPE_KEY"));
((OccasnTagDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
((OccasnTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((OccasnTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((OccasnTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((OccasnTagDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the OccasnTagDefnPid field.
*
* @return Contents of the OCCASN_TAG_DEFN_PID column
*/
public int getOccasnTagDefnPid() {
return this.OccasnTagDefnPid;
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
* Get the IsEvent field.
*
* @return Contents of the IS_EVENT column
*/
public boolean getIsEvent() {
return this.IsEvent;
}

/**
* Get the MinNumLocationAssoc field.
*
* @return Contents of the MIN_NUM_LOCATION_ASSOC column
*/
public short getMinNumLocationAssoc() {
return this.MinNumLocationAssoc;
}

/**
* Get the HasParents field.
*
* @return Contents of the HAS_PARENTS column
*/
public boolean getHasParents() {
return this.HasParents;
}

/**
* Get the MaxNumLocationAssoc field.
*
* @return Contents of the MAX_NUM_LOCATION_ASSOC column
*/
public short getMaxNumLocationAssoc() {
return this.MaxNumLocationAssoc;
}

/**
* Get the MinNumHdateAssoc field.
*
* @return Contents of the MIN_NUM_HDATE_ASSOC column
*/
public short getMinNumHdateAssoc() {
return this.MinNumHdateAssoc;
}

/**
* Get the MaxNumHdateAssoc field.
*
* @return Contents of the MAX_NUM_HDATE_ASSOC column
*/
public short getMaxNumHdateAssoc() {
return this.MaxNumHdateAssoc;
}

/**
* Get the MinNumKeyAssoc field.
*
* @return Contents of the MIN_NUM_KEY_ASSOC column
*/
public short getMinNumKeyAssoc() {
return this.MinNumKeyAssoc;
}

/**
* Get the MaxNumKeyAssoc field.
*
* @return Contents of the MAX_NUM_KEY_ASSOC column
*/
public short getMaxNumKeyAssoc() {
return this.MaxNumKeyAssoc;
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
* Get the GedcomTag field.
*
* @return Contents of the GEDCOM_TAG column
*/
public String getGedcomTag() {
return this.GedcomTag;
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
* Set the OccasnTagDefnPid field
*
* @param OccasnTagDefnPid Contents of the OCCASN_TAG_DEFN_PID column
*/
public void setOccasnTagDefnPid(int OccasnTagDefnPid) {
this.OccasnTagDefnPid = OccasnTagDefnPid;
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
* Set the IsEvent field
*
* @param IsEvent Contents of the IS_EVENT column
*/
public void setIsEvent(boolean IsEvent) {
this.IsEvent = IsEvent;
}

/**
* Set the MinNumLocationAssoc field
*
* @param MinNumLocationAssoc Contents of the MIN_NUM_LOCATION_ASSOC column
*/
public void setMinNumLocationAssoc(short MinNumLocationAssoc) {
this.MinNumLocationAssoc = MinNumLocationAssoc;
}

/**
* Set the HasParents field
*
* @param HasParents Contents of the HAS_PARENTS column
*/
public void setHasParents(boolean HasParents) {
this.HasParents = HasParents;
}

/**
* Set the MaxNumLocationAssoc field
*
* @param MaxNumLocationAssoc Contents of the MAX_NUM_LOCATION_ASSOC column
*/
public void setMaxNumLocationAssoc(short MaxNumLocationAssoc) {
this.MaxNumLocationAssoc = MaxNumLocationAssoc;
}

/**
* Set the MinNumHdateAssoc field
*
* @param MinNumHdateAssoc Contents of the MIN_NUM_HDATE_ASSOC column
*/
public void setMinNumHdateAssoc(short MinNumHdateAssoc) {
this.MinNumHdateAssoc = MinNumHdateAssoc;
}

/**
* Set the MaxNumHdateAssoc field
*
* @param MaxNumHdateAssoc Contents of the MAX_NUM_HDATE_ASSOC column
*/
public void setMaxNumHdateAssoc(short MaxNumHdateAssoc) {
this.MaxNumHdateAssoc = MaxNumHdateAssoc;
}

/**
* Set the MinNumKeyAssoc field
*
* @param MinNumKeyAssoc Contents of the MIN_NUM_KEY_ASSOC column
*/
public void setMinNumKeyAssoc(short MinNumKeyAssoc) {
this.MinNumKeyAssoc = MinNumKeyAssoc;
}

/**
* Set the MaxNumKeyAssoc field
*
* @param MaxNumKeyAssoc Contents of the MAX_NUM_KEY_ASSOC column
*/
public void setMaxNumKeyAssoc(short MaxNumKeyAssoc) {
this.MaxNumKeyAssoc = MaxNumKeyAssoc;
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
* Set the GedcomTag field
*
* @param GedcomTag Contents of the GEDCOM_TAG column
*/
public void setGedcomTag(String GedcomTag) {
this.GedcomTag = GedcomTag;
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

