package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the OCCASN_ASSOC_TAG_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class OccasnAssocTagDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"OCCASN_ASSOC_TAG_DEFN_PID, " +
"IS_USER_DEFN, " +
"OCCASN_SUB_TYPE_KEY, " +
"OCCASN_TAG_TYPE_KEY, " +
"ASSOC_TYPE_KEY, " +
"ASSOC_SUB_TYPE_KEY, " +
"ROLE_NAME_KEY, " +
"MIN_IN_ROLE, " +
"MAX_IN_ROLE, " +
"IS_REQUIRED_ROLE, " +
"GROUP_KEY, " +
"THEME_KEY, " +
"SENTCE_SET_PID, " +
"SENTCE_STYLE_TYPE_KEY, " +
"TAG_RULE_KEY, " +
"GEDCOM_TAG, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.OCCASN_ASSOC_TAG_DEFNS WHERE OCCASN_ASSOC_TAG_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"OCCASN_ASSOC_TAG_DEFN_PID, " +  
"IS_USER_DEFN, " +  
"OCCASN_SUB_TYPE_KEY, " +  
"OCCASN_TAG_TYPE_KEY, " +  
"ASSOC_TYPE_KEY, " +  
"ASSOC_SUB_TYPE_KEY, " +  
"ROLE_NAME_KEY, " +  
"MIN_IN_ROLE, " +  
"MAX_IN_ROLE, " +  
"IS_REQUIRED_ROLE, " +  
"GROUP_KEY, " +  
"THEME_KEY, " +  
"SENTCE_SET_PID, " +  
"SENTCE_STYLE_TYPE_KEY, " +  
"TAG_RULE_KEY, " +  
"GEDCOM_TAG, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.OCCASN_ASSOC_TAG_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.OCCASN_ASSOC_TAG_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"OCCASN_ASSOC_TAG_DEFN_PID, " +     
"IS_USER_DEFN, " +     
"OCCASN_SUB_TYPE_KEY, " +     
"OCCASN_TAG_TYPE_KEY, " +     
"ASSOC_TYPE_KEY, " +     
"ASSOC_SUB_TYPE_KEY, " +     
"ROLE_NAME_KEY, " +     
"MIN_IN_ROLE, " +     
"MAX_IN_ROLE, " +     
"IS_REQUIRED_ROLE, " +     
"GROUP_KEY, " +     
"THEME_KEY, " +     
"SENTCE_SET_PID, " +     
"SENTCE_STYLE_TYPE_KEY, " +     
"TAG_RULE_KEY, " +     
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

private static final String UPDATE = "UPDATE PUBLIC.OCCASN_ASSOC_TAG_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_USER_DEFN = ?, " + 
"OCCASN_SUB_TYPE_KEY = ?, " + 
"OCCASN_TAG_TYPE_KEY = ?, " + 
"ASSOC_TYPE_KEY = ?, " + 
"ASSOC_SUB_TYPE_KEY = ?, " + 
"ROLE_NAME_KEY = ?, " + 
"MIN_IN_ROLE = ?, " + 
"MAX_IN_ROLE = ?, " + 
"IS_REQUIRED_ROLE = ?, " + 
"GROUP_KEY = ?, " + 
"THEME_KEY = ?, " + 
"SENTCE_SET_PID = ?, " + 
"SENTCE_STYLE_TYPE_KEY = ?, " + 
"TAG_RULE_KEY = ?, " + 
"GEDCOM_TAG = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE OCCASN_ASSOC_TAG_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.OCCASN_ASSOC_TAG_DEFNS WHERE OCCASN_ASSOC_TAG_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASN_ASSOC_TAG_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int OccasnAssocTagDefnPid;
private boolean IsUserDefn;
private short OccasnSubTypeKey;
private short OccasnTagTypeKey;
private short AssocTypeKey;
private short AssocSubTypeKey;
private short RoleNameKey;
private short MinInRole;
private short MaxInRole;
private boolean IsRequiredRole;
private short GroupKey;
private short ThemeKey;
private int SentceSetPid;
private short SentceStyleTypeKey;
private short TagRuleKey;
private String GedcomTag;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private OccasnAssocTagDefns model;

public OccasnAssocTagDefns() throws SQLException {
}


public OccasnAssocTagDefns(int OccasnAssocTagDefnPid) throws SQLException {
super();
this.OccasnAssocTagDefnPid = OccasnAssocTagDefnPid;
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
model = new OccasnAssocTagDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOccasnAssocTagDefnPid(rs.getInt("OCCASN_ASSOC_TAG_DEFN_PID"));
model.setIsUserDefn(rs.getBoolean("IS_USER_DEFN"));
model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
model.setOccasnTagTypeKey(rs.getShort("OCCASN_TAG_TYPE_KEY"));
model.setAssocTypeKey(rs.getShort("ASSOC_TYPE_KEY"));
model.setAssocSubTypeKey(rs.getShort("ASSOC_SUB_TYPE_KEY"));
model.setRoleNameKey(rs.getShort("ROLE_NAME_KEY"));
model.setMinInRole(rs.getShort("MIN_IN_ROLE"));
model.setMaxInRole(rs.getShort("MAX_IN_ROLE"));
model.setIsRequiredRole(rs.getBoolean("IS_REQUIRED_ROLE"));
model.setGroupKey(rs.getShort("GROUP_KEY"));
model.setThemeKey(rs.getShort("THEME_KEY"));
model.setSentceSetPid(rs.getInt("SENTCE_SET_PID"));
model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
model.setTagRuleKey(rs.getShort("TAG_RULE_KEY"));
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
model.setOccasnAssocTagDefnPid(rs.getInt("OCCASN_ASSOC_TAG_DEFN_PID"));
model.setIsUserDefn(rs.getBoolean("IS_USER_DEFN"));
model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
model.setOccasnTagTypeKey(rs.getShort("OCCASN_TAG_TYPE_KEY"));
model.setAssocTypeKey(rs.getShort("ASSOC_TYPE_KEY"));
model.setAssocSubTypeKey(rs.getShort("ASSOC_SUB_TYPE_KEY"));
model.setRoleNameKey(rs.getShort("ROLE_NAME_KEY"));
model.setMinInRole(rs.getShort("MIN_IN_ROLE"));
model.setMaxInRole(rs.getShort("MAX_IN_ROLE"));
model.setIsRequiredRole(rs.getBoolean("IS_REQUIRED_ROLE"));
model.setGroupKey(rs.getShort("GROUP_KEY"));
model.setThemeKey(rs.getShort("THEME_KEY"));
model.setSentceSetPid(rs.getInt("SENTCE_SET_PID"));
model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
model.setTagRuleKey(rs.getShort("TAG_RULE_KEY"));
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
((OccasnAssocTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OccasnAssocTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
((OccasnAssocTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OccasnAssocTagDefns) model).setOccasnAssocTagDefnPid(rs.getInt("OCCASN_ASSOC_TAG_DEFN_PID"));
((OccasnAssocTagDefns) model).setIsUserDefn(rs.getBoolean("IS_USER_DEFN"));
((OccasnAssocTagDefns) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
((OccasnAssocTagDefns) model).setOccasnTagTypeKey(rs.getShort("OCCASN_TAG_TYPE_KEY"));
((OccasnAssocTagDefns) model).setAssocTypeKey(rs.getShort("ASSOC_TYPE_KEY"));
((OccasnAssocTagDefns) model).setAssocSubTypeKey(rs.getShort("ASSOC_SUB_TYPE_KEY"));
((OccasnAssocTagDefns) model).setRoleNameKey(rs.getShort("ROLE_NAME_KEY"));
((OccasnAssocTagDefns) model).setMinInRole(rs.getShort("MIN_IN_ROLE"));
((OccasnAssocTagDefns) model).setMaxInRole(rs.getShort("MAX_IN_ROLE"));
((OccasnAssocTagDefns) model).setIsRequiredRole(rs.getBoolean("IS_REQUIRED_ROLE"));
((OccasnAssocTagDefns) model).setGroupKey(rs.getShort("GROUP_KEY"));
((OccasnAssocTagDefns) model).setThemeKey(rs.getShort("THEME_KEY"));
((OccasnAssocTagDefns) model).setSentceSetPid(rs.getInt("SENTCE_SET_PID"));
((OccasnAssocTagDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
((OccasnAssocTagDefns) model).setTagRuleKey(rs.getShort("TAG_RULE_KEY"));
((OccasnAssocTagDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
((OccasnAssocTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((OccasnAssocTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((OccasnAssocTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((OccasnAssocTagDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((OccasnAssocTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OccasnAssocTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
((OccasnAssocTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OccasnAssocTagDefns) model).setOccasnAssocTagDefnPid(rs.getInt("OCCASN_ASSOC_TAG_DEFN_PID"));
((OccasnAssocTagDefns) model).setIsUserDefn(rs.getBoolean("IS_USER_DEFN"));
((OccasnAssocTagDefns) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
((OccasnAssocTagDefns) model).setOccasnTagTypeKey(rs.getShort("OCCASN_TAG_TYPE_KEY"));
((OccasnAssocTagDefns) model).setAssocTypeKey(rs.getShort("ASSOC_TYPE_KEY"));
((OccasnAssocTagDefns) model).setAssocSubTypeKey(rs.getShort("ASSOC_SUB_TYPE_KEY"));
((OccasnAssocTagDefns) model).setRoleNameKey(rs.getShort("ROLE_NAME_KEY"));
((OccasnAssocTagDefns) model).setMinInRole(rs.getShort("MIN_IN_ROLE"));
((OccasnAssocTagDefns) model).setMaxInRole(rs.getShort("MAX_IN_ROLE"));
((OccasnAssocTagDefns) model).setIsRequiredRole(rs.getBoolean("IS_REQUIRED_ROLE"));
((OccasnAssocTagDefns) model).setGroupKey(rs.getShort("GROUP_KEY"));
((OccasnAssocTagDefns) model).setThemeKey(rs.getShort("THEME_KEY"));
((OccasnAssocTagDefns) model).setSentceSetPid(rs.getInt("SENTCE_SET_PID"));
((OccasnAssocTagDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
((OccasnAssocTagDefns) model).setTagRuleKey(rs.getShort("TAG_RULE_KEY"));
((OccasnAssocTagDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
((OccasnAssocTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((OccasnAssocTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((OccasnAssocTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((OccasnAssocTagDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getOccasnAssocTagDefnPid() {
return this.OccasnAssocTagDefnPid;
}

public boolean getIsUserDefn() {
return this.IsUserDefn;
}

public short getOccasnSubTypeKey() {
return this.OccasnSubTypeKey;
}

public short getOccasnTagTypeKey() {
return this.OccasnTagTypeKey;
}

public short getAssocTypeKey() {
return this.AssocTypeKey;
}

public short getAssocSubTypeKey() {
return this.AssocSubTypeKey;
}

public short getRoleNameKey() {
return this.RoleNameKey;
}

public short getMinInRole() {
return this.MinInRole;
}

public short getMaxInRole() {
return this.MaxInRole;
}

public boolean getIsRequiredRole() {
return this.IsRequiredRole;
}

public short getGroupKey() {
return this.GroupKey;
}

public short getThemeKey() {
return this.ThemeKey;
}

public int getSentceSetPid() {
return this.SentceSetPid;
}

public short getSentceStyleTypeKey() {
return this.SentceStyleTypeKey;
}

public short getTagRuleKey() {
return this.TagRuleKey;
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

public void setOccasnAssocTagDefnPid(int OccasnAssocTagDefnPid) {
this.OccasnAssocTagDefnPid = OccasnAssocTagDefnPid;
}

public void setIsUserDefn(boolean IsUserDefn) {
this.IsUserDefn = IsUserDefn;
}

public void setOccasnSubTypeKey(short OccasnSubTypeKey) {
this.OccasnSubTypeKey = OccasnSubTypeKey;
}

public void setOccasnTagTypeKey(short OccasnTagTypeKey) {
this.OccasnTagTypeKey = OccasnTagTypeKey;
}

public void setAssocTypeKey(short AssocTypeKey) {
this.AssocTypeKey = AssocTypeKey;
}

public void setAssocSubTypeKey(short AssocSubTypeKey) {
this.AssocSubTypeKey = AssocSubTypeKey;
}

public void setRoleNameKey(short RoleNameKey) {
this.RoleNameKey = RoleNameKey;
}

public void setMinInRole(short MinInRole) {
this.MinInRole = MinInRole;
}

public void setMaxInRole(short MaxInRole) {
this.MaxInRole = MaxInRole;
}

public void setIsRequiredRole(boolean IsRequiredRole) {
this.IsRequiredRole = IsRequiredRole;
}

public void setGroupKey(short GroupKey) {
this.GroupKey = GroupKey;
}

public void setThemeKey(short ThemeKey) {
this.ThemeKey = ThemeKey;
}

public void setSentceSetPid(int SentceSetPid) {
this.SentceSetPid = SentceSetPid;
}

public void setSentceStyleTypeKey(short SentceStyleTypeKey) {
this.SentceStyleTypeKey = SentceStyleTypeKey;
}

public void setTagRuleKey(short TagRuleKey) {
this.TagRuleKey = TagRuleKey;
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

