package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the USER_GROUP_RIGHTS_DEFNS database table.
*
* @version 2018-08-02
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

public UserGroupRightsDefns() throws SQLException {
}


public UserGroupRightsDefns(int UserGroupRightsDefnPid) throws SQLException {
super();
this.UserGroupRightsDefnPid = UserGroupRightsDefnPid;
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
public AbstractHreDataModel get(int key) throws SQLException {
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
return this;
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

public int getRecordNum() {
return this.RecordNum;
}

public short getSetKey() {
return this.SetKey;
}

public int getCommitPid() {
return this.CommitPid;
}

public int getUserGroupRightsDefnPid() {
return this.UserGroupRightsDefnPid;
}

public short getUserGroupKey() {
return this.UserGroupKey;
}

public short getTableKey() {
return this.TableKey;
}

public boolean getCanViewAll() {
return this.CanViewAll;
}

public boolean getCanViewSome() {
return this.CanViewSome;
}

public boolean getCanEditView() {
return this.CanEditView;
}

public boolean getCanDeleteEditable() {
return this.CanDeleteEditable;
}

public short getLimitFlagKey() {
return this.LimitFlagKey;
}

public short getLimitFlagValue() {
return this.LimitFlagValue;
}

public short getReminderKey() {
return this.ReminderKey;
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

public void setUserGroupRightsDefnPid(int UserGroupRightsDefnPid) {
this.UserGroupRightsDefnPid = UserGroupRightsDefnPid;
}

public void setUserGroupKey(short UserGroupKey) {
this.UserGroupKey = UserGroupKey;
}

public void setTableKey(short TableKey) {
this.TableKey = TableKey;
}

public void setCanViewAll(boolean CanViewAll) {
this.CanViewAll = CanViewAll;
}

public void setCanViewSome(boolean CanViewSome) {
this.CanViewSome = CanViewSome;
}

public void setCanEditView(boolean CanEditView) {
this.CanEditView = CanEditView;
}

public void setCanDeleteEditable(boolean CanDeleteEditable) {
this.CanDeleteEditable = CanDeleteEditable;
}

public void setLimitFlagKey(short LimitFlagKey) {
this.LimitFlagKey = LimitFlagKey;
}

public void setLimitFlagValue(short LimitFlagValue) {
this.LimitFlagValue = LimitFlagValue;
}

public void setReminderKey(short ReminderKey) {
this.ReminderKey = ReminderKey;
}

}

