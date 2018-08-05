package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the PACKAGE_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class PackageDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"PACKAGE_DEFN_PID, " +
"IS_NATIVE, " +
"VERSON_NAME, " +
"PARENT_SCHEMA_KEY, " +
"REMINDER_KEY, " +
"IS_MAIN_PCKG, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.PACKAGE_DEFNS WHERE PACKAGE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"PACKAGE_DEFN_PID, " +  
"IS_NATIVE, " +  
"VERSON_NAME, " +  
"PARENT_SCHEMA_KEY, " +  
"REMINDER_KEY, " +  
"IS_MAIN_PCKG, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.PACKAGE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.PACKAGE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"PACKAGE_DEFN_PID, " +     
"IS_NATIVE, " +     
"VERSON_NAME, " +     
"PARENT_SCHEMA_KEY, " +     
"REMINDER_KEY, " +     
"IS_MAIN_PCKG, " +     
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

private static final String UPDATE = "UPDATE PUBLIC.PACKAGE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_NATIVE = ?, " + 
"VERSON_NAME = ?, " + 
"PARENT_SCHEMA_KEY = ?, " + 
"REMINDER_KEY = ?, " + 
"IS_MAIN_PCKG = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE PACKAGE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.PACKAGE_DEFNS WHERE PACKAGE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.PACKAGE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int PackageDefnPid;
private boolean IsNative;
private String VersonName;
private short ParentSchemaKey;
private short ReminderKey;
private boolean IsMainPckg;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private PackageDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public PackageDefns() throws SQLException {
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
model = new PackageDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setPackageDefnPid(rs.getInt("PACKAGE_DEFN_PID"));
model.setIsNative(rs.getBoolean("IS_NATIVE"));
model.setVersonName(rs.getString("VERSON_NAME"));
model.setParentSchemaKey(rs.getShort("PARENT_SCHEMA_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setIsMainPckg(rs.getBoolean("IS_MAIN_PCKG"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public PackageDefns get(int key) throws SQLException {
model = new PackageDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setPackageDefnPid(rs.getInt("PACKAGE_DEFN_PID"));
model.setIsNative(rs.getBoolean("IS_NATIVE"));
model.setVersonName(rs.getString("VERSON_NAME"));
model.setParentSchemaKey(rs.getShort("PARENT_SCHEMA_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setIsMainPckg(rs.getBoolean("IS_MAIN_PCKG"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((PackageDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((PackageDefns) model).setSetKey(rs.getShort("SET_KEY"));
((PackageDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((PackageDefns) model).setPackageDefnPid(rs.getInt("PACKAGE_DEFN_PID"));
((PackageDefns) model).setIsNative(rs.getBoolean("IS_NATIVE"));
((PackageDefns) model).setVersonName(rs.getString("VERSON_NAME"));
((PackageDefns) model).setParentSchemaKey(rs.getShort("PARENT_SCHEMA_KEY"));
((PackageDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((PackageDefns) model).setIsMainPckg(rs.getBoolean("IS_MAIN_PCKG"));
((PackageDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((PackageDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((PackageDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((PackageDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((PackageDefns) model).setSetKey(rs.getShort("SET_KEY"));
((PackageDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((PackageDefns) model).setPackageDefnPid(rs.getInt("PACKAGE_DEFN_PID"));
((PackageDefns) model).setIsNative(rs.getBoolean("IS_NATIVE"));
((PackageDefns) model).setVersonName(rs.getString("VERSON_NAME"));
((PackageDefns) model).setParentSchemaKey(rs.getShort("PARENT_SCHEMA_KEY"));
((PackageDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((PackageDefns) model).setIsMainPckg(rs.getBoolean("IS_MAIN_PCKG"));
((PackageDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((PackageDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((PackageDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the PackageDefnPid field.
*
* @return Contents of the PACKAGE_DEFN_PID column
*/
public int getPackageDefnPid() {
return this.PackageDefnPid;
}

/**
* Get the IsNative field.
*
* @return Contents of the IS_NATIVE column
*/
public boolean getIsNative() {
return this.IsNative;
}

/**
* Get the VersonName field.
*
* @return Contents of the VERSON_NAME column
*/
public String getVersonName() {
return this.VersonName;
}

/**
* Get the ParentSchemaKey field.
*
* @return Contents of the PARENT_SCHEMA_KEY column
*/
public short getParentSchemaKey() {
return this.ParentSchemaKey;
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
* Get the IsMainPckg field.
*
* @return Contents of the IS_MAIN_PCKG column
*/
public boolean getIsMainPckg() {
return this.IsMainPckg;
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
* Set the PackageDefnPid field
*
* @param PackageDefnPid Contents of the PACKAGE_DEFN_PID column
*/
public void setPackageDefnPid(int PackageDefnPid) {
this.PackageDefnPid = PackageDefnPid;
}

/**
* Set the IsNative field
*
* @param IsNative Contents of the IS_NATIVE column
*/
public void setIsNative(boolean IsNative) {
this.IsNative = IsNative;
}

/**
* Set the VersonName field
*
* @param VersonName Contents of the VERSON_NAME column
*/
public void setVersonName(String VersonName) {
this.VersonName = VersonName;
}

/**
* Set the ParentSchemaKey field
*
* @param ParentSchemaKey Contents of the PARENT_SCHEMA_KEY column
*/
public void setParentSchemaKey(short ParentSchemaKey) {
this.ParentSchemaKey = ParentSchemaKey;
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
* Set the IsMainPckg field
*
* @param IsMainPckg Contents of the IS_MAIN_PCKG column
*/
public void setIsMainPckg(boolean IsMainPckg) {
this.IsMainPckg = IsMainPckg;
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

