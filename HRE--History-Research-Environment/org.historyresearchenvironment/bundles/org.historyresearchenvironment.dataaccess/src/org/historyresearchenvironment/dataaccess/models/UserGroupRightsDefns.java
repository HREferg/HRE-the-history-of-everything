package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the USER_GROUP_RIGHTS_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class UserGroupRightsDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"USER_GROUP_RIGHTS_DEFN_PID, " +
"USER_GROUP_KEY, " +
"TABLE_KEY, " +
"CAN_VIEW_ALL, " +
"CAN_VIEW_SOME, " +
"CAN_EDIT_VIEW, " +
"CAN_DELETE_EDITABLE, " +
"LIMIT_FLAG_KEY, " +
"LIMIT_FLAG_VALUE, " +
"REMINDER_KEY FROM PUBLIC.USER_GROUP_RIGHTS_DEFNS WHERE USER_GROUP_RIGHTS_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"USER_GROUP_RIGHTS_DEFN_PID, " +  
"USER_GROUP_KEY, " +  
"TABLE_KEY, " +  
"CAN_VIEW_ALL, " +  
"CAN_VIEW_SOME, " +  
"CAN_EDIT_VIEW, " +  
"CAN_DELETE_EDITABLE, " +  
"LIMIT_FLAG_KEY, " +  
"LIMIT_FLAG_VALUE, " +  
"REMINDER_KEY FROM PUBLIC.USER_GROUP_RIGHTS_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.USER_GROUP_RIGHTS_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"USER_GROUP_RIGHTS_DEFN_PID, " +     
"USER_GROUP_KEY, " +     
"TABLE_KEY, " +     
"CAN_VIEW_ALL, " +     
"CAN_VIEW_SOME, " +     
"CAN_EDIT_VIEW, " +     
"CAN_DELETE_EDITABLE, " +     
"LIMIT_FLAG_KEY, " +     
"LIMIT_FLAG_VALUE, " +     
"REMINDER_KEY) VALUES (?, " +
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

private static final String UPDATE = "UPDATE PUBLIC.USER_GROUP_RIGHTS_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"USER_GROUP_KEY = ?, " + 
"TABLE_KEY = ?, " + 
"CAN_VIEW_ALL = ?, " + 
"CAN_VIEW_SOME = ?, " + 
"CAN_EDIT_VIEW = ?, " + 
"CAN_DELETE_EDITABLE = ?, " + 
"LIMIT_FLAG_KEY = ?, " + 
"LIMIT_FLAG_VALUE = ?, " + 
"REMINDER_KEY = ? WHERE USER_GROUP_RIGHTS_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.USER_GROUP_RIGHTS_DEFNS WHERE USER_GROUP_RIGHTS_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.USER_GROUP_RIGHTS_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int UserGroupRightsDefnPid;
private short UserGroupKey;
private short TableKey;
private boolean CanViewAll;
private boolean CanViewSome;
private boolean CanEditView;
private boolean CanDeleteEditable;
private short LimitFlagKey;
private short LimitFlagValue;
private short ReminderKey;
private UserGroupRightsDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public UserGroupRightsDefns() throws SQLException {
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
model = new UserGroupRightsDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setUserGroupRightsDefnPid(rs.getInt("USER_GROUP_RIGHTS_DEFN_PID"));
model.setUserGroupKey(rs.getShort("USER_GROUP_KEY"));
model.setTableKey(rs.getShort("TABLE_KEY"));
model.setCanViewAll(rs.getBoolean("CAN_VIEW_ALL"));
model.setCanViewSome(rs.getBoolean("CAN_VIEW_SOME"));
model.setCanEditView(rs.getBoolean("CAN_EDIT_VIEW"));
model.setCanDeleteEditable(rs.getBoolean("CAN_DELETE_EDITABLE"));
model.setLimitFlagKey(rs.getShort("LIMIT_FLAG_KEY"));
model.setLimitFlagValue(rs.getShort("LIMIT_FLAG_VALUE"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
modelList.add(model);
}
return modelList;
}

@Override
public UserGroupRightsDefns get(int key) throws SQLException {
model = new UserGroupRightsDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setUserGroupRightsDefnPid(rs.getInt("USER_GROUP_RIGHTS_DEFN_PID"));
model.setUserGroupKey(rs.getShort("USER_GROUP_KEY"));
model.setTableKey(rs.getShort("TABLE_KEY"));
model.setCanViewAll(rs.getBoolean("CAN_VIEW_ALL"));
model.setCanViewSome(rs.getBoolean("CAN_VIEW_SOME"));
model.setCanEditView(rs.getBoolean("CAN_EDIT_VIEW"));
model.setCanDeleteEditable(rs.getBoolean("CAN_DELETE_EDITABLE"));
model.setLimitFlagKey(rs.getShort("LIMIT_FLAG_KEY"));
model.setLimitFlagValue(rs.getShort("LIMIT_FLAG_VALUE"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((UserGroupRightsDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((UserGroupRightsDefns) model).setSetKey(rs.getShort("SET_KEY"));
((UserGroupRightsDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((UserGroupRightsDefns) model).setUserGroupRightsDefnPid(rs.getInt("USER_GROUP_RIGHTS_DEFN_PID"));
((UserGroupRightsDefns) model).setUserGroupKey(rs.getShort("USER_GROUP_KEY"));
((UserGroupRightsDefns) model).setTableKey(rs.getShort("TABLE_KEY"));
((UserGroupRightsDefns) model).setCanViewAll(rs.getBoolean("CAN_VIEW_ALL"));
((UserGroupRightsDefns) model).setCanViewSome(rs.getBoolean("CAN_VIEW_SOME"));
((UserGroupRightsDefns) model).setCanEditView(rs.getBoolean("CAN_EDIT_VIEW"));
((UserGroupRightsDefns) model).setCanDeleteEditable(rs.getBoolean("CAN_DELETE_EDITABLE"));
((UserGroupRightsDefns) model).setLimitFlagKey(rs.getShort("LIMIT_FLAG_KEY"));
((UserGroupRightsDefns) model).setLimitFlagValue(rs.getShort("LIMIT_FLAG_VALUE"));
((UserGroupRightsDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((UserGroupRightsDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((UserGroupRightsDefns) model).setSetKey(rs.getShort("SET_KEY"));
((UserGroupRightsDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((UserGroupRightsDefns) model).setUserGroupRightsDefnPid(rs.getInt("USER_GROUP_RIGHTS_DEFN_PID"));
((UserGroupRightsDefns) model).setUserGroupKey(rs.getShort("USER_GROUP_KEY"));
((UserGroupRightsDefns) model).setTableKey(rs.getShort("TABLE_KEY"));
((UserGroupRightsDefns) model).setCanViewAll(rs.getBoolean("CAN_VIEW_ALL"));
((UserGroupRightsDefns) model).setCanViewSome(rs.getBoolean("CAN_VIEW_SOME"));
((UserGroupRightsDefns) model).setCanEditView(rs.getBoolean("CAN_EDIT_VIEW"));
((UserGroupRightsDefns) model).setCanDeleteEditable(rs.getBoolean("CAN_DELETE_EDITABLE"));
((UserGroupRightsDefns) model).setLimitFlagKey(rs.getShort("LIMIT_FLAG_KEY"));
((UserGroupRightsDefns) model).setLimitFlagValue(rs.getShort("LIMIT_FLAG_VALUE"));
((UserGroupRightsDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
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
* Get the UserGroupRightsDefnPid field.
*
* @return Contents of the USER_GROUP_RIGHTS_DEFN_PID column
*/
public int getUserGroupRightsDefnPid() {
return this.UserGroupRightsDefnPid;
}

/**
* Get the UserGroupKey field.
*
* @return Contents of the USER_GROUP_KEY column
*/
public short getUserGroupKey() {
return this.UserGroupKey;
}

/**
* Get the TableKey field.
*
* @return Contents of the TABLE_KEY column
*/
public short getTableKey() {
return this.TableKey;
}

/**
* Get the CanViewAll field.
*
* @return Contents of the CAN_VIEW_ALL column
*/
public boolean getCanViewAll() {
return this.CanViewAll;
}

/**
* Get the CanViewSome field.
*
* @return Contents of the CAN_VIEW_SOME column
*/
public boolean getCanViewSome() {
return this.CanViewSome;
}

/**
* Get the CanEditView field.
*
* @return Contents of the CAN_EDIT_VIEW column
*/
public boolean getCanEditView() {
return this.CanEditView;
}

/**
* Get the CanDeleteEditable field.
*
* @return Contents of the CAN_DELETE_EDITABLE column
*/
public boolean getCanDeleteEditable() {
return this.CanDeleteEditable;
}

/**
* Get the LimitFlagKey field.
*
* @return Contents of the LIMIT_FLAG_KEY column
*/
public short getLimitFlagKey() {
return this.LimitFlagKey;
}

/**
* Get the LimitFlagValue field.
*
* @return Contents of the LIMIT_FLAG_VALUE column
*/
public short getLimitFlagValue() {
return this.LimitFlagValue;
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
* Set the UserGroupRightsDefnPid field
*
* @param UserGroupRightsDefnPid Contents of the USER_GROUP_RIGHTS_DEFN_PID column
*/
public void setUserGroupRightsDefnPid(int UserGroupRightsDefnPid) {
this.UserGroupRightsDefnPid = UserGroupRightsDefnPid;
}

/**
* Set the UserGroupKey field
*
* @param UserGroupKey Contents of the USER_GROUP_KEY column
*/
public void setUserGroupKey(short UserGroupKey) {
this.UserGroupKey = UserGroupKey;
}

/**
* Set the TableKey field
*
* @param TableKey Contents of the TABLE_KEY column
*/
public void setTableKey(short TableKey) {
this.TableKey = TableKey;
}

/**
* Set the CanViewAll field
*
* @param CanViewAll Contents of the CAN_VIEW_ALL column
*/
public void setCanViewAll(boolean CanViewAll) {
this.CanViewAll = CanViewAll;
}

/**
* Set the CanViewSome field
*
* @param CanViewSome Contents of the CAN_VIEW_SOME column
*/
public void setCanViewSome(boolean CanViewSome) {
this.CanViewSome = CanViewSome;
}

/**
* Set the CanEditView field
*
* @param CanEditView Contents of the CAN_EDIT_VIEW column
*/
public void setCanEditView(boolean CanEditView) {
this.CanEditView = CanEditView;
}

/**
* Set the CanDeleteEditable field
*
* @param CanDeleteEditable Contents of the CAN_DELETE_EDITABLE column
*/
public void setCanDeleteEditable(boolean CanDeleteEditable) {
this.CanDeleteEditable = CanDeleteEditable;
}

/**
* Set the LimitFlagKey field
*
* @param LimitFlagKey Contents of the LIMIT_FLAG_KEY column
*/
public void setLimitFlagKey(short LimitFlagKey) {
this.LimitFlagKey = LimitFlagKey;
}

/**
* Set the LimitFlagValue field
*
* @param LimitFlagValue Contents of the LIMIT_FLAG_VALUE column
*/
public void setLimitFlagValue(short LimitFlagValue) {
this.LimitFlagValue = LimitFlagValue;
}

/**
* Set the ReminderKey field
*
* @param ReminderKey Contents of the REMINDER_KEY column
*/
public void setReminderKey(short ReminderKey) {
this.ReminderKey = ReminderKey;
}

}

