package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the NAME_ELMNT_TYPE_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class NameElmntTypeDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"NAME_ELMNT_TYPE_DEFN_PID, " +
"IS_SYSTEM, " +
"DATA_TYPE_KEY, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.NAME_ELMNT_TYPE_DEFNS WHERE NAME_ELMNT_TYPE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"NAME_ELMNT_TYPE_DEFN_PID, " +  
"IS_SYSTEM, " +  
"DATA_TYPE_KEY, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.NAME_ELMNT_TYPE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.NAME_ELMNT_TYPE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"NAME_ELMNT_TYPE_DEFN_PID, " +     
"IS_SYSTEM, " +     
"DATA_TYPE_KEY, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.NAME_ELMNT_TYPE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"DATA_TYPE_KEY = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE NAME_ELMNT_TYPE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.NAME_ELMNT_TYPE_DEFNS WHERE NAME_ELMNT_TYPE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.NAME_ELMNT_TYPE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int NameElmntTypeDefnPid;
private boolean IsSystem;
private short DataTypeKey;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private NameElmntTypeDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public NameElmntTypeDefns() throws SQLException {
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
model = new NameElmntTypeDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setNameElmntTypeDefnPid(rs.getInt("NAME_ELMNT_TYPE_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public NameElmntTypeDefns get(int key) throws SQLException {
model = new NameElmntTypeDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setNameElmntTypeDefnPid(rs.getInt("NAME_ELMNT_TYPE_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
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
((NameElmntTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((NameElmntTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((NameElmntTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((NameElmntTypeDefns) model).setNameElmntTypeDefnPid(rs.getInt("NAME_ELMNT_TYPE_DEFN_PID"));
((NameElmntTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((NameElmntTypeDefns) model).setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
((NameElmntTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((NameElmntTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((NameElmntTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((NameElmntTypeDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((NameElmntTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((NameElmntTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((NameElmntTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((NameElmntTypeDefns) model).setNameElmntTypeDefnPid(rs.getInt("NAME_ELMNT_TYPE_DEFN_PID"));
((NameElmntTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((NameElmntTypeDefns) model).setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
((NameElmntTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((NameElmntTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((NameElmntTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((NameElmntTypeDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the NameElmntTypeDefnPid field.
*
* @return Contents of the NAME_ELMNT_TYPE_DEFN_PID column
*/
public int getNameElmntTypeDefnPid() {
return this.NameElmntTypeDefnPid;
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
* Get the DataTypeKey field.
*
* @return Contents of the DATA_TYPE_KEY column
*/
public short getDataTypeKey() {
return this.DataTypeKey;
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
* Set the NameElmntTypeDefnPid field
*
* @param NameElmntTypeDefnPid Contents of the NAME_ELMNT_TYPE_DEFN_PID column
*/
public void setNameElmntTypeDefnPid(int NameElmntTypeDefnPid) {
this.NameElmntTypeDefnPid = NameElmntTypeDefnPid;
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
* Set the DataTypeKey field
*
* @param DataTypeKey Contents of the DATA_TYPE_KEY column
*/
public void setDataTypeKey(short DataTypeKey) {
this.DataTypeKey = DataTypeKey;
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

