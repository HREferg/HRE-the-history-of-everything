package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the OCCASN_OCCASN_TAG_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class OccasnOccasnTagDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"OCCASN_OCCASN_TAG_DEFN_PID, " +
"IS_SYSTEM, " +
"VIEW_DATA_SCRIPT_GROUP_KEY, " +
"VIEW_DATA_SCRIPT_PID, " +
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +
"MODIFY_DATA_SCRIPT_PID, " +
"DELETE_DATA_SCRIPT_GROUP_KEY, " +
"DELETE_DATA_SCRIPT_PID, " +
"A_OCCASN_SUB_TYPE_KEY, " +
"B_OCCASN_SUB_TYPE_KEY, " +
"A_B_ROLE_NAME_PAIR_KEY, " +
"A_SENTCE_SET_PID, " +
"B_SENTCE_SET_PID, " +
"TAG_GROUP_KEY, " +
"THEME_KEY, " +
"GEDCOM_TAG, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.OCCASN_OCCASN_TAG_DEFNS WHERE OCCASN_OCCASN_TAG_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"OCCASN_OCCASN_TAG_DEFN_PID, " +  
"IS_SYSTEM, " +  
"VIEW_DATA_SCRIPT_GROUP_KEY, " +  
"VIEW_DATA_SCRIPT_PID, " +  
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +  
"MODIFY_DATA_SCRIPT_PID, " +  
"DELETE_DATA_SCRIPT_GROUP_KEY, " +  
"DELETE_DATA_SCRIPT_PID, " +  
"A_OCCASN_SUB_TYPE_KEY, " +  
"B_OCCASN_SUB_TYPE_KEY, " +  
"A_B_ROLE_NAME_PAIR_KEY, " +  
"A_SENTCE_SET_PID, " +  
"B_SENTCE_SET_PID, " +  
"TAG_GROUP_KEY, " +  
"THEME_KEY, " +  
"GEDCOM_TAG, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.OCCASN_OCCASN_TAG_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.OCCASN_OCCASN_TAG_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"OCCASN_OCCASN_TAG_DEFN_PID, " +     
"IS_SYSTEM, " +     
"VIEW_DATA_SCRIPT_GROUP_KEY, " +     
"VIEW_DATA_SCRIPT_PID, " +     
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +     
"MODIFY_DATA_SCRIPT_PID, " +     
"DELETE_DATA_SCRIPT_GROUP_KEY, " +     
"DELETE_DATA_SCRIPT_PID, " +     
"A_OCCASN_SUB_TYPE_KEY, " +     
"B_OCCASN_SUB_TYPE_KEY, " +     
"A_B_ROLE_NAME_PAIR_KEY, " +     
"A_SENTCE_SET_PID, " +     
"B_SENTCE_SET_PID, " +     
"TAG_GROUP_KEY, " +     
"THEME_KEY, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.OCCASN_OCCASN_TAG_DEFNSSET " +
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
"A_OCCASN_SUB_TYPE_KEY = ?, " + 
"B_OCCASN_SUB_TYPE_KEY = ?, " + 
"A_B_ROLE_NAME_PAIR_KEY = ?, " + 
"A_SENTCE_SET_PID = ?, " + 
"B_SENTCE_SET_PID = ?, " + 
"TAG_GROUP_KEY = ?, " + 
"THEME_KEY = ?, " + 
"GEDCOM_TAG = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE OCCASN_OCCASN_TAG_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.OCCASN_OCCASN_TAG_DEFNS WHERE OCCASN_OCCASN_TAG_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASN_OCCASN_TAG_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int OccasnOccasnTagDefnPid;
private boolean IsSystem;
private short ViewDataScriptGroupKey;
private int ViewDataScriptPid;
private short ModifyDataScriptGroupKey;
private int ModifyDataScriptPid;
private short DeleteDataScriptGroupKey;
private int DeleteDataScriptPid;
private short AOccasnSubTypeKey;
private short BOccasnSubTypeKey;
private short ABRoleNamePairKey;
private int ASentceSetPid;
private int BSentceSetPid;
private short TagGroupKey;
private short ThemeKey;
private String GedcomTag;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private OccasnOccasnTagDefns model;

public OccasnOccasnTagDefns() throws SQLException {
}


public OccasnOccasnTagDefns(int OccasnOccasnTagDefnPid) throws SQLException {
super();
this.OccasnOccasnTagDefnPid = OccasnOccasnTagDefnPid;
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
model = new OccasnOccasnTagDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOccasnOccasnTagDefnPid(rs.getInt("OCCASN_OCCASN_TAG_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
model.setAOccasnSubTypeKey(rs.getShort("A_OCCASN_SUB_TYPE_KEY"));
model.setBOccasnSubTypeKey(rs.getShort("B_OCCASN_SUB_TYPE_KEY"));
model.setABRoleNamePairKey(rs.getShort("A_B_ROLE_NAME_PAIR_KEY"));
model.setASentceSetPid(rs.getInt("A_SENTCE_SET_PID"));
model.setBSentceSetPid(rs.getInt("B_SENTCE_SET_PID"));
model.setTagGroupKey(rs.getShort("TAG_GROUP_KEY"));
model.setThemeKey(rs.getShort("THEME_KEY"));
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
public AbstractHreDataModel get(int key) throws SQLException {
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOccasnOccasnTagDefnPid(rs.getInt("OCCASN_OCCASN_TAG_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
model.setAOccasnSubTypeKey(rs.getShort("A_OCCASN_SUB_TYPE_KEY"));
model.setBOccasnSubTypeKey(rs.getShort("B_OCCASN_SUB_TYPE_KEY"));
model.setABRoleNamePairKey(rs.getShort("A_B_ROLE_NAME_PAIR_KEY"));
model.setASentceSetPid(rs.getInt("A_SENTCE_SET_PID"));
model.setBSentceSetPid(rs.getInt("B_SENTCE_SET_PID"));
model.setTagGroupKey(rs.getShort("TAG_GROUP_KEY"));
model.setThemeKey(rs.getShort("THEME_KEY"));
model.setGedcomTag(rs.getString("GEDCOM_TAG"));
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
((OccasnOccasnTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OccasnOccasnTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
((OccasnOccasnTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OccasnOccasnTagDefns) model).setOccasnOccasnTagDefnPid(rs.getInt("OCCASN_OCCASN_TAG_DEFN_PID"));
((OccasnOccasnTagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((OccasnOccasnTagDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
((OccasnOccasnTagDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
((OccasnOccasnTagDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
((OccasnOccasnTagDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
((OccasnOccasnTagDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
((OccasnOccasnTagDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
((OccasnOccasnTagDefns) model).setAOccasnSubTypeKey(rs.getShort("A_OCCASN_SUB_TYPE_KEY"));
((OccasnOccasnTagDefns) model).setBOccasnSubTypeKey(rs.getShort("B_OCCASN_SUB_TYPE_KEY"));
((OccasnOccasnTagDefns) model).setABRoleNamePairKey(rs.getShort("A_B_ROLE_NAME_PAIR_KEY"));
((OccasnOccasnTagDefns) model).setASentceSetPid(rs.getInt("A_SENTCE_SET_PID"));
((OccasnOccasnTagDefns) model).setBSentceSetPid(rs.getInt("B_SENTCE_SET_PID"));
((OccasnOccasnTagDefns) model).setTagGroupKey(rs.getShort("TAG_GROUP_KEY"));
((OccasnOccasnTagDefns) model).setThemeKey(rs.getShort("THEME_KEY"));
((OccasnOccasnTagDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
((OccasnOccasnTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((OccasnOccasnTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((OccasnOccasnTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((OccasnOccasnTagDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((OccasnOccasnTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OccasnOccasnTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
((OccasnOccasnTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OccasnOccasnTagDefns) model).setOccasnOccasnTagDefnPid(rs.getInt("OCCASN_OCCASN_TAG_DEFN_PID"));
((OccasnOccasnTagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((OccasnOccasnTagDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
((OccasnOccasnTagDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
((OccasnOccasnTagDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
((OccasnOccasnTagDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
((OccasnOccasnTagDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
((OccasnOccasnTagDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
((OccasnOccasnTagDefns) model).setAOccasnSubTypeKey(rs.getShort("A_OCCASN_SUB_TYPE_KEY"));
((OccasnOccasnTagDefns) model).setBOccasnSubTypeKey(rs.getShort("B_OCCASN_SUB_TYPE_KEY"));
((OccasnOccasnTagDefns) model).setABRoleNamePairKey(rs.getShort("A_B_ROLE_NAME_PAIR_KEY"));
((OccasnOccasnTagDefns) model).setASentceSetPid(rs.getInt("A_SENTCE_SET_PID"));
((OccasnOccasnTagDefns) model).setBSentceSetPid(rs.getInt("B_SENTCE_SET_PID"));
((OccasnOccasnTagDefns) model).setTagGroupKey(rs.getShort("TAG_GROUP_KEY"));
((OccasnOccasnTagDefns) model).setThemeKey(rs.getShort("THEME_KEY"));
((OccasnOccasnTagDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
((OccasnOccasnTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((OccasnOccasnTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((OccasnOccasnTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((OccasnOccasnTagDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getOccasnOccasnTagDefnPid() {
return this.OccasnOccasnTagDefnPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public short getViewDataScriptGroupKey() {
return this.ViewDataScriptGroupKey;
}

public int getViewDataScriptPid() {
return this.ViewDataScriptPid;
}

public short getModifyDataScriptGroupKey() {
return this.ModifyDataScriptGroupKey;
}

public int getModifyDataScriptPid() {
return this.ModifyDataScriptPid;
}

public short getDeleteDataScriptGroupKey() {
return this.DeleteDataScriptGroupKey;
}

public int getDeleteDataScriptPid() {
return this.DeleteDataScriptPid;
}

public short getAOccasnSubTypeKey() {
return this.AOccasnSubTypeKey;
}

public short getBOccasnSubTypeKey() {
return this.BOccasnSubTypeKey;
}

public short getABRoleNamePairKey() {
return this.ABRoleNamePairKey;
}

public int getASentceSetPid() {
return this.ASentceSetPid;
}

public int getBSentceSetPid() {
return this.BSentceSetPid;
}

public short getTagGroupKey() {
return this.TagGroupKey;
}

public short getThemeKey() {
return this.ThemeKey;
}

public String getGedcomTag() {
return this.GedcomTag;
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

public void setOccasnOccasnTagDefnPid(int OccasnOccasnTagDefnPid) {
this.OccasnOccasnTagDefnPid = OccasnOccasnTagDefnPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setViewDataScriptGroupKey(short ViewDataScriptGroupKey) {
this.ViewDataScriptGroupKey = ViewDataScriptGroupKey;
}

public void setViewDataScriptPid(int ViewDataScriptPid) {
this.ViewDataScriptPid = ViewDataScriptPid;
}

public void setModifyDataScriptGroupKey(short ModifyDataScriptGroupKey) {
this.ModifyDataScriptGroupKey = ModifyDataScriptGroupKey;
}

public void setModifyDataScriptPid(int ModifyDataScriptPid) {
this.ModifyDataScriptPid = ModifyDataScriptPid;
}

public void setDeleteDataScriptGroupKey(short DeleteDataScriptGroupKey) {
this.DeleteDataScriptGroupKey = DeleteDataScriptGroupKey;
}

public void setDeleteDataScriptPid(int DeleteDataScriptPid) {
this.DeleteDataScriptPid = DeleteDataScriptPid;
}

public void setAOccasnSubTypeKey(short AOccasnSubTypeKey) {
this.AOccasnSubTypeKey = AOccasnSubTypeKey;
}

public void setBOccasnSubTypeKey(short BOccasnSubTypeKey) {
this.BOccasnSubTypeKey = BOccasnSubTypeKey;
}

public void setABRoleNamePairKey(short ABRoleNamePairKey) {
this.ABRoleNamePairKey = ABRoleNamePairKey;
}

public void setASentceSetPid(int ASentceSetPid) {
this.ASentceSetPid = ASentceSetPid;
}

public void setBSentceSetPid(int BSentceSetPid) {
this.BSentceSetPid = BSentceSetPid;
}

public void setTagGroupKey(short TagGroupKey) {
this.TagGroupKey = TagGroupKey;
}

public void setThemeKey(short ThemeKey) {
this.ThemeKey = ThemeKey;
}

public void setGedcomTag(String GedcomTag) {
this.GedcomTag = GedcomTag;
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

