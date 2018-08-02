package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the CITN_TYPE_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class CitnTypeDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"CITN_TYPE_DEFN_PID, " +
"IS_SYSTEM, " +
"VIEW_DATA_SCRIPT_GROUP_KEY, " +
"VIEW_DATA_SCRIPT_PID, " +
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +
"MODIFY_DATA_SCRIPT_PID, " +
"DELETE_DATA_SCRIPT_GROUP_KEY, " +
"DELETE_DATA_SCRIPT_PID, " +
"CITING_TYPE_KEY, " +
"CITING_SUB_TYPE_KEY, " +
"GEDCOM_TAG, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.CITN_TYPE_DEFNS WHERE CITN_TYPE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"CITN_TYPE_DEFN_PID, " +  
"IS_SYSTEM, " +  
"VIEW_DATA_SCRIPT_GROUP_KEY, " +  
"VIEW_DATA_SCRIPT_PID, " +  
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +  
"MODIFY_DATA_SCRIPT_PID, " +  
"DELETE_DATA_SCRIPT_GROUP_KEY, " +  
"DELETE_DATA_SCRIPT_PID, " +  
"CITING_TYPE_KEY, " +  
"CITING_SUB_TYPE_KEY, " +  
"GEDCOM_TAG, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.CITN_TYPE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.CITN_TYPE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"CITN_TYPE_DEFN_PID, " +     
"IS_SYSTEM, " +     
"VIEW_DATA_SCRIPT_GROUP_KEY, " +     
"VIEW_DATA_SCRIPT_PID, " +     
"MODIFY_DATA_SCRIPT_GROUP_KEY, " +     
"MODIFY_DATA_SCRIPT_PID, " +     
"DELETE_DATA_SCRIPT_GROUP_KEY, " +     
"DELETE_DATA_SCRIPT_PID, " +     
"CITING_TYPE_KEY, " +     
"CITING_SUB_TYPE_KEY, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.CITN_TYPE_DEFNSSET " +
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
"CITING_TYPE_KEY = ?, " + 
"CITING_SUB_TYPE_KEY = ?, " + 
"GEDCOM_TAG = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE CITN_TYPE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.CITN_TYPE_DEFNS WHERE CITN_TYPE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.CITN_TYPE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int CitnTypeDefnPid;
private boolean IsSystem;
private short ViewDataScriptGroupKey;
private int ViewDataScriptPid;
private short ModifyDataScriptGroupKey;
private int ModifyDataScriptPid;
private short DeleteDataScriptGroupKey;
private int DeleteDataScriptPid;
private short CitingTypeKey;
private short CitingSubTypeKey;
private String GedcomTag;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private CitnTypeDefns model;

public CitnTypeDefns() throws SQLException {
}


public CitnTypeDefns(int CitnTypeDefnPid) throws SQLException {
super();
this.CitnTypeDefnPid = CitnTypeDefnPid;
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
model = new CitnTypeDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setCitnTypeDefnPid(rs.getInt("CITN_TYPE_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
model.setCitingTypeKey(rs.getShort("CITING_TYPE_KEY"));
model.setCitingSubTypeKey(rs.getShort("CITING_SUB_TYPE_KEY"));
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
model.setCitnTypeDefnPid(rs.getInt("CITN_TYPE_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
model.setCitingTypeKey(rs.getShort("CITING_TYPE_KEY"));
model.setCitingSubTypeKey(rs.getShort("CITING_SUB_TYPE_KEY"));
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
((CitnTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((CitnTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((CitnTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((CitnTypeDefns) model).setCitnTypeDefnPid(rs.getInt("CITN_TYPE_DEFN_PID"));
((CitnTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((CitnTypeDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
((CitnTypeDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
((CitnTypeDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
((CitnTypeDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
((CitnTypeDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
((CitnTypeDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
((CitnTypeDefns) model).setCitingTypeKey(rs.getShort("CITING_TYPE_KEY"));
((CitnTypeDefns) model).setCitingSubTypeKey(rs.getShort("CITING_SUB_TYPE_KEY"));
((CitnTypeDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
((CitnTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((CitnTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((CitnTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((CitnTypeDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((CitnTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((CitnTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((CitnTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((CitnTypeDefns) model).setCitnTypeDefnPid(rs.getInt("CITN_TYPE_DEFN_PID"));
((CitnTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((CitnTypeDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
((CitnTypeDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
((CitnTypeDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
((CitnTypeDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
((CitnTypeDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
((CitnTypeDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
((CitnTypeDefns) model).setCitingTypeKey(rs.getShort("CITING_TYPE_KEY"));
((CitnTypeDefns) model).setCitingSubTypeKey(rs.getShort("CITING_SUB_TYPE_KEY"));
((CitnTypeDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
((CitnTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((CitnTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((CitnTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((CitnTypeDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getCitnTypeDefnPid() {
return this.CitnTypeDefnPid;
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

public short getCitingTypeKey() {
return this.CitingTypeKey;
}

public short getCitingSubTypeKey() {
return this.CitingSubTypeKey;
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

public void setCitnTypeDefnPid(int CitnTypeDefnPid) {
this.CitnTypeDefnPid = CitnTypeDefnPid;
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

public void setCitingTypeKey(short CitingTypeKey) {
this.CitingTypeKey = CitingTypeKey;
}

public void setCitingSubTypeKey(short CitingSubTypeKey) {
this.CitingSubTypeKey = CitingSubTypeKey;
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

