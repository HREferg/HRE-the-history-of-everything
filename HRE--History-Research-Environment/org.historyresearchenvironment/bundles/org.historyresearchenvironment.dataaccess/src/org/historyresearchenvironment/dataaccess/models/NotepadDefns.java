package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the NOTEPAD_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class NotepadDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"NOTEPAD_DEFN_PID, " +
"IS_SYSTEM, " +
"PARENT_TYPE_KEY, " +
"PARENT_SUB_TYPE_KEY, " +
"LENGTH, " +
"UNITS_KEY, " +
"NOTEPAD_STORAGE_KEY, " +
"FIELD_TYPE_KEY, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.NOTEPAD_DEFNS WHERE NOTEPAD_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"NOTEPAD_DEFN_PID, " +  
"IS_SYSTEM, " +  
"PARENT_TYPE_KEY, " +  
"PARENT_SUB_TYPE_KEY, " +  
"LENGTH, " +  
"UNITS_KEY, " +  
"NOTEPAD_STORAGE_KEY, " +  
"FIELD_TYPE_KEY, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.NOTEPAD_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.NOTEPAD_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"NOTEPAD_DEFN_PID, " +     
"IS_SYSTEM, " +     
"PARENT_TYPE_KEY, " +     
"PARENT_SUB_TYPE_KEY, " +     
"LENGTH, " +     
"UNITS_KEY, " +     
"NOTEPAD_STORAGE_KEY, " +     
"FIELD_TYPE_KEY, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.NOTEPAD_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PARENT_TYPE_KEY = ?, " + 
"PARENT_SUB_TYPE_KEY = ?, " + 
"LENGTH = ?, " + 
"UNITS_KEY = ?, " + 
"NOTEPAD_STORAGE_KEY = ?, " + 
"FIELD_TYPE_KEY = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE NOTEPAD_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.NOTEPAD_DEFNS WHERE NOTEPAD_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.NOTEPAD_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int NotepadDefnPid;
private boolean IsSystem;
private short ParentTypeKey;
private short ParentSubTypeKey;
private short Length;
private short UnitsKey;
private short NotepadStorageKey;
private short FieldTypeKey;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private NotepadDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public NotepadDefns() throws SQLException {
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
model = new NotepadDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setNotepadDefnPid(rs.getInt("NOTEPAD_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setLength(rs.getShort("LENGTH"));
model.setUnitsKey(rs.getShort("UNITS_KEY"));
model.setNotepadStorageKey(rs.getShort("NOTEPAD_STORAGE_KEY"));
model.setFieldTypeKey(rs.getShort("FIELD_TYPE_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public NotepadDefns get(int key) throws SQLException {
model = new NotepadDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setNotepadDefnPid(rs.getInt("NOTEPAD_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setLength(rs.getShort("LENGTH"));
model.setUnitsKey(rs.getShort("UNITS_KEY"));
model.setNotepadStorageKey(rs.getShort("NOTEPAD_STORAGE_KEY"));
model.setFieldTypeKey(rs.getShort("FIELD_TYPE_KEY"));
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
((NotepadDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((NotepadDefns) model).setSetKey(rs.getShort("SET_KEY"));
((NotepadDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((NotepadDefns) model).setNotepadDefnPid(rs.getInt("NOTEPAD_DEFN_PID"));
((NotepadDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((NotepadDefns) model).setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
((NotepadDefns) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((NotepadDefns) model).setLength(rs.getShort("LENGTH"));
((NotepadDefns) model).setUnitsKey(rs.getShort("UNITS_KEY"));
((NotepadDefns) model).setNotepadStorageKey(rs.getShort("NOTEPAD_STORAGE_KEY"));
((NotepadDefns) model).setFieldTypeKey(rs.getShort("FIELD_TYPE_KEY"));
((NotepadDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((NotepadDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((NotepadDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((NotepadDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((NotepadDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((NotepadDefns) model).setSetKey(rs.getShort("SET_KEY"));
((NotepadDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((NotepadDefns) model).setNotepadDefnPid(rs.getInt("NOTEPAD_DEFN_PID"));
((NotepadDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((NotepadDefns) model).setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
((NotepadDefns) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((NotepadDefns) model).setLength(rs.getShort("LENGTH"));
((NotepadDefns) model).setUnitsKey(rs.getShort("UNITS_KEY"));
((NotepadDefns) model).setNotepadStorageKey(rs.getShort("NOTEPAD_STORAGE_KEY"));
((NotepadDefns) model).setFieldTypeKey(rs.getShort("FIELD_TYPE_KEY"));
((NotepadDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((NotepadDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((NotepadDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((NotepadDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the NotepadDefnPid field.
*
* @return Contents of the NOTEPAD_DEFN_PID column
*/
public int getNotepadDefnPid() {
return this.NotepadDefnPid;
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
* Get the ParentTypeKey field.
*
* @return Contents of the PARENT_TYPE_KEY column
*/
public short getParentTypeKey() {
return this.ParentTypeKey;
}

/**
* Get the ParentSubTypeKey field.
*
* @return Contents of the PARENT_SUB_TYPE_KEY column
*/
public short getParentSubTypeKey() {
return this.ParentSubTypeKey;
}

/**
* Get the Length field.
*
* @return Contents of the LENGTH column
*/
public short getLength() {
return this.Length;
}

/**
* Get the UnitsKey field.
*
* @return Contents of the UNITS_KEY column
*/
public short getUnitsKey() {
return this.UnitsKey;
}

/**
* Get the NotepadStorageKey field.
*
* @return Contents of the NOTEPAD_STORAGE_KEY column
*/
public short getNotepadStorageKey() {
return this.NotepadStorageKey;
}

/**
* Get the FieldTypeKey field.
*
* @return Contents of the FIELD_TYPE_KEY column
*/
public short getFieldTypeKey() {
return this.FieldTypeKey;
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
* Set the NotepadDefnPid field
*
* @param NotepadDefnPid Contents of the NOTEPAD_DEFN_PID column
*/
public void setNotepadDefnPid(int NotepadDefnPid) {
this.NotepadDefnPid = NotepadDefnPid;
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
* Set the ParentTypeKey field
*
* @param ParentTypeKey Contents of the PARENT_TYPE_KEY column
*/
public void setParentTypeKey(short ParentTypeKey) {
this.ParentTypeKey = ParentTypeKey;
}

/**
* Set the ParentSubTypeKey field
*
* @param ParentSubTypeKey Contents of the PARENT_SUB_TYPE_KEY column
*/
public void setParentSubTypeKey(short ParentSubTypeKey) {
this.ParentSubTypeKey = ParentSubTypeKey;
}

/**
* Set the Length field
*
* @param Length Contents of the LENGTH column
*/
public void setLength(short Length) {
this.Length = Length;
}

/**
* Set the UnitsKey field
*
* @param UnitsKey Contents of the UNITS_KEY column
*/
public void setUnitsKey(short UnitsKey) {
this.UnitsKey = UnitsKey;
}

/**
* Set the NotepadStorageKey field
*
* @param NotepadStorageKey Contents of the NOTEPAD_STORAGE_KEY column
*/
public void setNotepadStorageKey(short NotepadStorageKey) {
this.NotepadStorageKey = NotepadStorageKey;
}

/**
* Set the FieldTypeKey field
*
* @param FieldTypeKey Contents of the FIELD_TYPE_KEY column
*/
public void setFieldTypeKey(short FieldTypeKey) {
this.FieldTypeKey = FieldTypeKey;
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

