package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the DIGITAL_NOTEPADS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class DigitalNotepads extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"DIGITAL_NOTEPAD_PID, " +
"IS_SYSTEM, " +
"PARENT_PID, " +
"PARENT_SUB_TYPE_KEY, " +
"NOTEPAD_DEFN_PID, " +
"NOTEPAD FROM PUBLIC.DIGITAL_NOTEPADS WHERE DIGITAL_NOTEPAD_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"DIGITAL_NOTEPAD_PID, " +  
"IS_SYSTEM, " +  
"PARENT_PID, " +  
"PARENT_SUB_TYPE_KEY, " +  
"NOTEPAD_DEFN_PID, " +  
"NOTEPAD FROM PUBLIC.DIGITAL_NOTEPADS";

private static final String INSERT = "INSERT INTO PUBLIC.DIGITAL_NOTEPADS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"DIGITAL_NOTEPAD_PID, " +     
"IS_SYSTEM, " +     
"PARENT_PID, " +     
"PARENT_SUB_TYPE_KEY, " +     
"NOTEPAD_DEFN_PID, " +     
"NOTEPAD) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.DIGITAL_NOTEPADSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PARENT_PID = ?, " + 
"PARENT_SUB_TYPE_KEY = ?, " + 
"NOTEPAD_DEFN_PID = ?, " + 
"NOTEPAD = ? WHERE DIGITAL_NOTEPAD_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.DIGITAL_NOTEPADS WHERE DIGITAL_NOTEPAD_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.DIGITAL_NOTEPADS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int DigitalNotepadPid;
private boolean IsSystem;
private int ParentPid;
private short ParentSubTypeKey;
private short NotepadDefnPid;
private String Notepad;
private DigitalNotepads model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public DigitalNotepads() throws SQLException {
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
model = new DigitalNotepads();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setDigitalNotepadPid(rs.getInt("DIGITAL_NOTEPAD_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentPid(rs.getInt("PARENT_PID"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setNotepadDefnPid(rs.getShort("NOTEPAD_DEFN_PID"));
model.setNotepad(rs.getString("NOTEPAD"));
modelList.add(model);
}
return modelList;
}

@Override
public DigitalNotepads get(int key) throws SQLException {
model = new DigitalNotepads();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setDigitalNotepadPid(rs.getInt("DIGITAL_NOTEPAD_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentPid(rs.getInt("PARENT_PID"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setNotepadDefnPid(rs.getShort("NOTEPAD_DEFN_PID"));
model.setNotepad(rs.getString("NOTEPAD"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((DigitalNotepads) model).setRecordNum(rs.getInt("RECORD_NUM"));
((DigitalNotepads) model).setSetKey(rs.getShort("SET_KEY"));
((DigitalNotepads) model).setCommitPid(rs.getInt("COMMIT_PID"));
((DigitalNotepads) model).setDigitalNotepadPid(rs.getInt("DIGITAL_NOTEPAD_PID"));
((DigitalNotepads) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((DigitalNotepads) model).setParentPid(rs.getInt("PARENT_PID"));
((DigitalNotepads) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((DigitalNotepads) model).setNotepadDefnPid(rs.getShort("NOTEPAD_DEFN_PID"));
((DigitalNotepads) model).setNotepad(rs.getString("NOTEPAD"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((DigitalNotepads) model).setRecordNum(rs.getInt("RECORD_NUM"));
((DigitalNotepads) model).setSetKey(rs.getShort("SET_KEY"));
((DigitalNotepads) model).setCommitPid(rs.getInt("COMMIT_PID"));
((DigitalNotepads) model).setDigitalNotepadPid(rs.getInt("DIGITAL_NOTEPAD_PID"));
((DigitalNotepads) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((DigitalNotepads) model).setParentPid(rs.getInt("PARENT_PID"));
((DigitalNotepads) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((DigitalNotepads) model).setNotepadDefnPid(rs.getShort("NOTEPAD_DEFN_PID"));
((DigitalNotepads) model).setNotepad(rs.getString("NOTEPAD"));
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
* Get the DigitalNotepadPid field.
*
* @return Contents of the DIGITAL_NOTEPAD_PID column
*/
public int getDigitalNotepadPid() {
return this.DigitalNotepadPid;
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
* Get the ParentPid field.
*
* @return Contents of the PARENT_PID column
*/
public int getParentPid() {
return this.ParentPid;
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
* Get the NotepadDefnPid field.
*
* @return Contents of the NOTEPAD_DEFN_PID column
*/
public short getNotepadDefnPid() {
return this.NotepadDefnPid;
}

/**
* Get the Notepad field.
*
* @return Contents of the NOTEPAD column
*/
public String getNotepad() {
return this.Notepad;
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
* Set the DigitalNotepadPid field
*
* @param DigitalNotepadPid Contents of the DIGITAL_NOTEPAD_PID column
*/
public void setDigitalNotepadPid(int DigitalNotepadPid) {
this.DigitalNotepadPid = DigitalNotepadPid;
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
* Set the ParentPid field
*
* @param ParentPid Contents of the PARENT_PID column
*/
public void setParentPid(int ParentPid) {
this.ParentPid = ParentPid;
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
* Set the NotepadDefnPid field
*
* @param NotepadDefnPid Contents of the NOTEPAD_DEFN_PID column
*/
public void setNotepadDefnPid(short NotepadDefnPid) {
this.NotepadDefnPid = NotepadDefnPid;
}

/**
* Set the Notepad field
*
* @param Notepad Contents of the NOTEPAD column
*/
public void setNotepad(String Notepad) {
this.Notepad = Notepad;
}

}

