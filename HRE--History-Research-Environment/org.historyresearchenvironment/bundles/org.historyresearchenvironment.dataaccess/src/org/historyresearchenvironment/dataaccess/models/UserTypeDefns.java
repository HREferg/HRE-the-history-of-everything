package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the USER_TYPE_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class UserTypeDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"USER_TYPE_DEFN_PID, " +
"IS_USER_DEFN, " +
"POOR_EYESIGHT, " +
"IS_COLORBLIND, " +
"MIN_MOUSE_USE, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.USER_TYPE_DEFNS WHERE USER_TYPE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"USER_TYPE_DEFN_PID, " +  
"IS_USER_DEFN, " +  
"POOR_EYESIGHT, " +  
"IS_COLORBLIND, " +  
"MIN_MOUSE_USE, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.USER_TYPE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.USER_TYPE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"USER_TYPE_DEFN_PID, " +     
"IS_USER_DEFN, " +     
"POOR_EYESIGHT, " +     
"IS_COLORBLIND, " +     
"MIN_MOUSE_USE, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.USER_TYPE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_USER_DEFN = ?, " + 
"POOR_EYESIGHT = ?, " + 
"IS_COLORBLIND = ?, " + 
"MIN_MOUSE_USE = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE USER_TYPE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.USER_TYPE_DEFNS WHERE USER_TYPE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.USER_TYPE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int UserTypeDefnPid;
private boolean IsUserDefn;
private boolean PoorEyesight;
private boolean IsColorblind;
private boolean MinMouseUse;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private UserTypeDefns model;

public UserTypeDefns() throws SQLException {
}


public UserTypeDefns(int UserTypeDefnPid) throws SQLException {
super();
this.UserTypeDefnPid = UserTypeDefnPid;
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
model = new UserTypeDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setUserTypeDefnPid(rs.getInt("USER_TYPE_DEFN_PID"));
model.setIsUserDefn(rs.getBoolean("IS_USER_DEFN"));
model.setPoorEyesight(rs.getBoolean("POOR_EYESIGHT"));
model.setIsColorblind(rs.getBoolean("IS_COLORBLIND"));
model.setMinMouseUse(rs.getBoolean("MIN_MOUSE_USE"));
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
model.setUserTypeDefnPid(rs.getInt("USER_TYPE_DEFN_PID"));
model.setIsUserDefn(rs.getBoolean("IS_USER_DEFN"));
model.setPoorEyesight(rs.getBoolean("POOR_EYESIGHT"));
model.setIsColorblind(rs.getBoolean("IS_COLORBLIND"));
model.setMinMouseUse(rs.getBoolean("MIN_MOUSE_USE"));
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
((UserTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((UserTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((UserTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((UserTypeDefns) model).setUserTypeDefnPid(rs.getInt("USER_TYPE_DEFN_PID"));
((UserTypeDefns) model).setIsUserDefn(rs.getBoolean("IS_USER_DEFN"));
((UserTypeDefns) model).setPoorEyesight(rs.getBoolean("POOR_EYESIGHT"));
((UserTypeDefns) model).setIsColorblind(rs.getBoolean("IS_COLORBLIND"));
((UserTypeDefns) model).setMinMouseUse(rs.getBoolean("MIN_MOUSE_USE"));
((UserTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((UserTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((UserTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((UserTypeDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((UserTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((UserTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((UserTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((UserTypeDefns) model).setUserTypeDefnPid(rs.getInt("USER_TYPE_DEFN_PID"));
((UserTypeDefns) model).setIsUserDefn(rs.getBoolean("IS_USER_DEFN"));
((UserTypeDefns) model).setPoorEyesight(rs.getBoolean("POOR_EYESIGHT"));
((UserTypeDefns) model).setIsColorblind(rs.getBoolean("IS_COLORBLIND"));
((UserTypeDefns) model).setMinMouseUse(rs.getBoolean("MIN_MOUSE_USE"));
((UserTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((UserTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((UserTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((UserTypeDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getUserTypeDefnPid() {
return this.UserTypeDefnPid;
}

public boolean getIsUserDefn() {
return this.IsUserDefn;
}

public boolean getPoorEyesight() {
return this.PoorEyesight;
}

public boolean getIsColorblind() {
return this.IsColorblind;
}

public boolean getMinMouseUse() {
return this.MinMouseUse;
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

public void setUserTypeDefnPid(int UserTypeDefnPid) {
this.UserTypeDefnPid = UserTypeDefnPid;
}

public void setIsUserDefn(boolean IsUserDefn) {
this.IsUserDefn = IsUserDefn;
}

public void setPoorEyesight(boolean PoorEyesight) {
this.PoorEyesight = PoorEyesight;
}

public void setIsColorblind(boolean IsColorblind) {
this.IsColorblind = IsColorblind;
}

public void setMinMouseUse(boolean MinMouseUse) {
this.MinMouseUse = MinMouseUse;
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

