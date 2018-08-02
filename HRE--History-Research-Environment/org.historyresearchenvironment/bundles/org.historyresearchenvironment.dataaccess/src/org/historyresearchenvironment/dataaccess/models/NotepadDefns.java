package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the NOTEPAD_DEFNS database table.
*
* @version 2018-08-02
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

public NotepadDefns() throws SQLException {
}


public NotepadDefns(int NotepadDefnPid) throws SQLException {
super();
this.NotepadDefnPid = NotepadDefnPid;
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
public AbstractHreDataModel get(int key) throws SQLException {
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
return this;
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

public int getRecordNum() {
return this.RecordNum;
}

public short getSetKey() {
return this.SetKey;
}

public int getCommitPid() {
return this.CommitPid;
}

public int getNotepadDefnPid() {
return this.NotepadDefnPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public short getParentTypeKey() {
return this.ParentTypeKey;
}

public short getParentSubTypeKey() {
return this.ParentSubTypeKey;
}

public short getLength() {
return this.Length;
}

public short getUnitsKey() {
return this.UnitsKey;
}

public short getNotepadStorageKey() {
return this.NotepadStorageKey;
}

public short getFieldTypeKey() {
return this.FieldTypeKey;
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

public void setNotepadDefnPid(int NotepadDefnPid) {
this.NotepadDefnPid = NotepadDefnPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setParentTypeKey(short ParentTypeKey) {
this.ParentTypeKey = ParentTypeKey;
}

public void setParentSubTypeKey(short ParentSubTypeKey) {
this.ParentSubTypeKey = ParentSubTypeKey;
}

public void setLength(short Length) {
this.Length = Length;
}

public void setUnitsKey(short UnitsKey) {
this.UnitsKey = UnitsKey;
}

public void setNotepadStorageKey(short NotepadStorageKey) {
this.NotepadStorageKey = NotepadStorageKey;
}

public void setFieldTypeKey(short FieldTypeKey) {
this.FieldTypeKey = FieldTypeKey;
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

