package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the OCCASN_BTWN_ASSOC_TAG_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class OccasnBtwnAssocTagDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"OCCASN_BTWN_ASSOC_TAG_DEFN_PID, " +
"IS_SYSTEM, " +
"VIEW_DATA_SCRIPT_GROUP_KEY, " +
"VIEW_DATA_SCRIPT_PID, " +
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +
"MODIFY_DATA_SCRIPT_PID, " +
"DELETE_DATA_SCRIPT_GROUP_KEY, " +
"DELETE_DATA_SCRIPT_PID, " +
"OCCASN_SUB_TYPE_KEY, " +
"ASSOC_A_TYPE_KEY, " +
"ASSOC_A_SUB_TYPE_KEY, " +
"ASSOC_B_TYPE_KEY, " +
"ASSOC_B_SUB_TYPE_KEY, " +
"ROLE_PAIR_KEY, " +
"TAG_GROUP_KEY, " +
"THEME_KEY, " +
"SENTCE_STYLE_TYPE_KEY, " +
"A_SUBJ_SENTCE_SET_KEY, " +
"B_SUBJ_SENTCE_SET_KEY, " +
"GEDCOM_TAG, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.OCCASN_BTWN_ASSOC_TAG_DEFNS WHERE OCCASN_BTWN_ASSOC_TAG_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"OCCASN_BTWN_ASSOC_TAG_DEFN_PID, " +  
"IS_SYSTEM, " +  
"VIEW_DATA_SCRIPT_GROUP_KEY, " +  
"VIEW_DATA_SCRIPT_PID, " +  
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +  
"MODIFY_DATA_SCRIPT_PID, " +  
"DELETE_DATA_SCRIPT_GROUP_KEY, " +  
"DELETE_DATA_SCRIPT_PID, " +  
"OCCASN_SUB_TYPE_KEY, " +  
"ASSOC_A_TYPE_KEY, " +  
"ASSOC_A_SUB_TYPE_KEY, " +  
"ASSOC_B_TYPE_KEY, " +  
"ASSOC_B_SUB_TYPE_KEY, " +  
"ROLE_PAIR_KEY, " +  
"TAG_GROUP_KEY, " +  
"THEME_KEY, " +  
"SENTCE_STYLE_TYPE_KEY, " +  
"A_SUBJ_SENTCE_SET_KEY, " +  
"B_SUBJ_SENTCE_SET_KEY, " +  
"GEDCOM_TAG, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.OCCASN_BTWN_ASSOC_TAG_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.OCCASN_BTWN_ASSOC_TAG_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"OCCASN_BTWN_ASSOC_TAG_DEFN_PID, " +     
"IS_SYSTEM, " +     
"VIEW_DATA_SCRIPT_GROUP_KEY, " +     
"VIEW_DATA_SCRIPT_PID, " +     
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +     
"MODIFY_DATA_SCRIPT_PID, " +     
"DELETE_DATA_SCRIPT_GROUP_KEY, " +     
"DELETE_DATA_SCRIPT_PID, " +     
"OCCASN_SUB_TYPE_KEY, " +     
"ASSOC_A_TYPE_KEY, " +     
"ASSOC_A_SUB_TYPE_KEY, " +     
"ASSOC_B_TYPE_KEY, " +     
"ASSOC_B_SUB_TYPE_KEY, " +     
"ROLE_PAIR_KEY, " +     
"TAG_GROUP_KEY, " +     
"THEME_KEY, " +     
"SENTCE_STYLE_TYPE_KEY, " +     
"A_SUBJ_SENTCE_SET_KEY, " +     
"B_SUBJ_SENTCE_SET_KEY, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.OCCASN_BTWN_ASSOC_TAG_DEFNSSET " +
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
"OCCASN_SUB_TYPE_KEY = ?, " + 
"ASSOC_A_TYPE_KEY = ?, " + 
"ASSOC_A_SUB_TYPE_KEY = ?, " + 
"ASSOC_B_TYPE_KEY = ?, " + 
"ASSOC_B_SUB_TYPE_KEY = ?, " + 
"ROLE_PAIR_KEY = ?, " + 
"TAG_GROUP_KEY = ?, " + 
"THEME_KEY = ?, " + 
"SENTCE_STYLE_TYPE_KEY = ?, " + 
"A_SUBJ_SENTCE_SET_KEY = ?, " + 
"B_SUBJ_SENTCE_SET_KEY = ?, " + 
"GEDCOM_TAG = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE OCCASN_BTWN_ASSOC_TAG_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.OCCASN_BTWN_ASSOC_TAG_DEFNS WHERE OCCASN_BTWN_ASSOC_TAG_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASN_BTWN_ASSOC_TAG_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int OccasnBtwnAssocTagDefnPid;
private boolean IsSystem;
private short ViewDataScriptGroupKey;
private int ViewDataScriptPid;
private short ModifyDataScriptGroupKey;
private int ModifyDataScriptPid;
private short DeleteDataScriptGroupKey;
private int DeleteDataScriptPid;
private short OccasnSubTypeKey;
private short AssocATypeKey;
private short AssocASubTypeKey;
private short AssocBTypeKey;
private short AssocBSubTypeKey;
private short RolePairKey;
private short TagGroupKey;
private short ThemeKey;
private short SentceStyleTypeKey;
private int ASubjSentceSetKey;
private int BSubjSentceSetKey;
private String GedcomTag;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private OccasnBtwnAssocTagDefns model;

public OccasnBtwnAssocTagDefns() throws SQLException {
}


public OccasnBtwnAssocTagDefns(int OccasnBtwnAssocTagDefnPid) throws SQLException {
super();
this.OccasnBtwnAssocTagDefnPid = OccasnBtwnAssocTagDefnPid;
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
model = new OccasnBtwnAssocTagDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOccasnBtwnAssocTagDefnPid(rs.getInt("OCCASN_BTWN_ASSOC_TAG_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
model.setAssocATypeKey(rs.getShort("ASSOC_A_TYPE_KEY"));
model.setAssocASubTypeKey(rs.getShort("ASSOC_A_SUB_TYPE_KEY"));
model.setAssocBTypeKey(rs.getShort("ASSOC_B_TYPE_KEY"));
model.setAssocBSubTypeKey(rs.getShort("ASSOC_B_SUB_TYPE_KEY"));
model.setRolePairKey(rs.getShort("ROLE_PAIR_KEY"));
model.setTagGroupKey(rs.getShort("TAG_GROUP_KEY"));
model.setThemeKey(rs.getShort("THEME_KEY"));
model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
model.setASubjSentceSetKey(rs.getInt("A_SUBJ_SENTCE_SET_KEY"));
model.setBSubjSentceSetKey(rs.getInt("B_SUBJ_SENTCE_SET_KEY"));
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
model.setOccasnBtwnAssocTagDefnPid(rs.getInt("OCCASN_BTWN_ASSOC_TAG_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
model.setAssocATypeKey(rs.getShort("ASSOC_A_TYPE_KEY"));
model.setAssocASubTypeKey(rs.getShort("ASSOC_A_SUB_TYPE_KEY"));
model.setAssocBTypeKey(rs.getShort("ASSOC_B_TYPE_KEY"));
model.setAssocBSubTypeKey(rs.getShort("ASSOC_B_SUB_TYPE_KEY"));
model.setRolePairKey(rs.getShort("ROLE_PAIR_KEY"));
model.setTagGroupKey(rs.getShort("TAG_GROUP_KEY"));
model.setThemeKey(rs.getShort("THEME_KEY"));
model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
model.setASubjSentceSetKey(rs.getInt("A_SUBJ_SENTCE_SET_KEY"));
model.setBSubjSentceSetKey(rs.getInt("B_SUBJ_SENTCE_SET_KEY"));
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
((OccasnBtwnAssocTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OccasnBtwnAssocTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
((OccasnBtwnAssocTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OccasnBtwnAssocTagDefns) model).setOccasnBtwnAssocTagDefnPid(rs.getInt("OCCASN_BTWN_ASSOC_TAG_DEFN_PID"));
((OccasnBtwnAssocTagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((OccasnBtwnAssocTagDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
((OccasnBtwnAssocTagDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
((OccasnBtwnAssocTagDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
((OccasnBtwnAssocTagDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
((OccasnBtwnAssocTagDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
((OccasnBtwnAssocTagDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
((OccasnBtwnAssocTagDefns) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
((OccasnBtwnAssocTagDefns) model).setAssocATypeKey(rs.getShort("ASSOC_A_TYPE_KEY"));
((OccasnBtwnAssocTagDefns) model).setAssocASubTypeKey(rs.getShort("ASSOC_A_SUB_TYPE_KEY"));
((OccasnBtwnAssocTagDefns) model).setAssocBTypeKey(rs.getShort("ASSOC_B_TYPE_KEY"));
((OccasnBtwnAssocTagDefns) model).setAssocBSubTypeKey(rs.getShort("ASSOC_B_SUB_TYPE_KEY"));
((OccasnBtwnAssocTagDefns) model).setRolePairKey(rs.getShort("ROLE_PAIR_KEY"));
((OccasnBtwnAssocTagDefns) model).setTagGroupKey(rs.getShort("TAG_GROUP_KEY"));
((OccasnBtwnAssocTagDefns) model).setThemeKey(rs.getShort("THEME_KEY"));
((OccasnBtwnAssocTagDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
((OccasnBtwnAssocTagDefns) model).setASubjSentceSetKey(rs.getInt("A_SUBJ_SENTCE_SET_KEY"));
((OccasnBtwnAssocTagDefns) model).setBSubjSentceSetKey(rs.getInt("B_SUBJ_SENTCE_SET_KEY"));
((OccasnBtwnAssocTagDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
((OccasnBtwnAssocTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((OccasnBtwnAssocTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((OccasnBtwnAssocTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((OccasnBtwnAssocTagDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((OccasnBtwnAssocTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OccasnBtwnAssocTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
((OccasnBtwnAssocTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OccasnBtwnAssocTagDefns) model).setOccasnBtwnAssocTagDefnPid(rs.getInt("OCCASN_BTWN_ASSOC_TAG_DEFN_PID"));
((OccasnBtwnAssocTagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((OccasnBtwnAssocTagDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
((OccasnBtwnAssocTagDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
((OccasnBtwnAssocTagDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
((OccasnBtwnAssocTagDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
((OccasnBtwnAssocTagDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
((OccasnBtwnAssocTagDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
((OccasnBtwnAssocTagDefns) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
((OccasnBtwnAssocTagDefns) model).setAssocATypeKey(rs.getShort("ASSOC_A_TYPE_KEY"));
((OccasnBtwnAssocTagDefns) model).setAssocASubTypeKey(rs.getShort("ASSOC_A_SUB_TYPE_KEY"));
((OccasnBtwnAssocTagDefns) model).setAssocBTypeKey(rs.getShort("ASSOC_B_TYPE_KEY"));
((OccasnBtwnAssocTagDefns) model).setAssocBSubTypeKey(rs.getShort("ASSOC_B_SUB_TYPE_KEY"));
((OccasnBtwnAssocTagDefns) model).setRolePairKey(rs.getShort("ROLE_PAIR_KEY"));
((OccasnBtwnAssocTagDefns) model).setTagGroupKey(rs.getShort("TAG_GROUP_KEY"));
((OccasnBtwnAssocTagDefns) model).setThemeKey(rs.getShort("THEME_KEY"));
((OccasnBtwnAssocTagDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
((OccasnBtwnAssocTagDefns) model).setASubjSentceSetKey(rs.getInt("A_SUBJ_SENTCE_SET_KEY"));
((OccasnBtwnAssocTagDefns) model).setBSubjSentceSetKey(rs.getInt("B_SUBJ_SENTCE_SET_KEY"));
((OccasnBtwnAssocTagDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
((OccasnBtwnAssocTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((OccasnBtwnAssocTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((OccasnBtwnAssocTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((OccasnBtwnAssocTagDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getOccasnBtwnAssocTagDefnPid() {
return this.OccasnBtwnAssocTagDefnPid;
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

public short getOccasnSubTypeKey() {
return this.OccasnSubTypeKey;
}

public short getAssocATypeKey() {
return this.AssocATypeKey;
}

public short getAssocASubTypeKey() {
return this.AssocASubTypeKey;
}

public short getAssocBTypeKey() {
return this.AssocBTypeKey;
}

public short getAssocBSubTypeKey() {
return this.AssocBSubTypeKey;
}

public short getRolePairKey() {
return this.RolePairKey;
}

public short getTagGroupKey() {
return this.TagGroupKey;
}

public short getThemeKey() {
return this.ThemeKey;
}

public short getSentceStyleTypeKey() {
return this.SentceStyleTypeKey;
}

public int getASubjSentceSetKey() {
return this.ASubjSentceSetKey;
}

public int getBSubjSentceSetKey() {
return this.BSubjSentceSetKey;
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

public void setOccasnBtwnAssocTagDefnPid(int OccasnBtwnAssocTagDefnPid) {
this.OccasnBtwnAssocTagDefnPid = OccasnBtwnAssocTagDefnPid;
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

public void setOccasnSubTypeKey(short OccasnSubTypeKey) {
this.OccasnSubTypeKey = OccasnSubTypeKey;
}

public void setAssocATypeKey(short AssocATypeKey) {
this.AssocATypeKey = AssocATypeKey;
}

public void setAssocASubTypeKey(short AssocASubTypeKey) {
this.AssocASubTypeKey = AssocASubTypeKey;
}

public void setAssocBTypeKey(short AssocBTypeKey) {
this.AssocBTypeKey = AssocBTypeKey;
}

public void setAssocBSubTypeKey(short AssocBSubTypeKey) {
this.AssocBSubTypeKey = AssocBSubTypeKey;
}

public void setRolePairKey(short RolePairKey) {
this.RolePairKey = RolePairKey;
}

public void setTagGroupKey(short TagGroupKey) {
this.TagGroupKey = TagGroupKey;
}

public void setThemeKey(short ThemeKey) {
this.ThemeKey = ThemeKey;
}

public void setSentceStyleTypeKey(short SentceStyleTypeKey) {
this.SentceStyleTypeKey = SentceStyleTypeKey;
}

public void setASubjSentceSetKey(int ASubjSentceSetKey) {
this.ASubjSentceSetKey = ASubjSentceSetKey;
}

public void setBSubjSentceSetKey(int BSubjSentceSetKey) {
this.BSubjSentceSetKey = BSubjSentceSetKey;
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

