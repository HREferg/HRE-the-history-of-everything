package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the OCCASN_NOTEPADS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class OccasnNotepads extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEYD, " +
"COMMIT_PID, " +
"OCCASN_NOTEPAD_PID, " +
"IS_SYSTEM, " +
"PARENT_PID, " +
"PARENT_SUB_TYPE_KEY, " +
"NOTEPAD_DEFN_PID, " +
"NOTEPAD FROM PUBLIC.OCCASN_NOTEPADS WHERE OCCASN_NOTEPAD_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEYD, " +  
"COMMIT_PID, " +  
"OCCASN_NOTEPAD_PID, " +  
"IS_SYSTEM, " +  
"PARENT_PID, " +  
"PARENT_SUB_TYPE_KEY, " +  
"NOTEPAD_DEFN_PID, " +  
"NOTEPAD FROM PUBLIC.OCCASN_NOTEPADS";

private static final String INSERT = "INSERT INTO PUBLIC.OCCASN_NOTEPADS( " +
"RECORD_NUM, " +     
"SET_KEYD, " +     
"COMMIT_PID, " +     
"OCCASN_NOTEPAD_PID, " +     
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

private static final String UPDATE = "UPDATE PUBLIC.OCCASN_NOTEPADSSET " +
"RECORD_NUM = ?, " + 
"SET_KEYD = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PARENT_PID = ?, " + 
"PARENT_SUB_TYPE_KEY = ?, " + 
"NOTEPAD_DEFN_PID = ?, " + 
"NOTEPAD = ? WHERE OCCASN_NOTEPAD_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.OCCASN_NOTEPADS WHERE OCCASN_NOTEPAD_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASN_NOTEPADS";

private int RecordNum;
private short SetKeyd;
private int CommitPid;
private int OccasnNotepadPid;
private boolean IsSystem;
private int ParentPid;
private short ParentSubTypeKey;
private short NotepadDefnPid;
private String Notepad;
private OccasnNotepads model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public OccasnNotepads() throws SQLException {
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
model = new OccasnNotepads();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKeyd(rs.getShort("SET_KEYD"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOccasnNotepadPid(rs.getInt("OCCASN_NOTEPAD_PID"));
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
public OccasnNotepads get(int key) throws SQLException {
model = new OccasnNotepads();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKeyd(rs.getShort("SET_KEYD"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOccasnNotepadPid(rs.getInt("OCCASN_NOTEPAD_PID"));
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
((OccasnNotepads) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OccasnNotepads) model).setSetKeyd(rs.getShort("SET_KEYD"));
((OccasnNotepads) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OccasnNotepads) model).setOccasnNotepadPid(rs.getInt("OCCASN_NOTEPAD_PID"));
((OccasnNotepads) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((OccasnNotepads) model).setParentPid(rs.getInt("PARENT_PID"));
((OccasnNotepads) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((OccasnNotepads) model).setNotepadDefnPid(rs.getShort("NOTEPAD_DEFN_PID"));
((OccasnNotepads) model).setNotepad(rs.getString("NOTEPAD"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((OccasnNotepads) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OccasnNotepads) model).setSetKeyd(rs.getShort("SET_KEYD"));
((OccasnNotepads) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OccasnNotepads) model).setOccasnNotepadPid(rs.getInt("OCCASN_NOTEPAD_PID"));
((OccasnNotepads) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((OccasnNotepads) model).setParentPid(rs.getInt("PARENT_PID"));
((OccasnNotepads) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((OccasnNotepads) model).setNotepadDefnPid(rs.getShort("NOTEPAD_DEFN_PID"));
((OccasnNotepads) model).setNotepad(rs.getString("NOTEPAD"));
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
* Get the SetKeyd field.
*
* @return Contents of the SET_KEYD column
*/
public short getSetKeyd() {
return this.SetKeyd;
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
* Get the OccasnNotepadPid field.
*
* @return Contents of the OCCASN_NOTEPAD_PID column
*/
public int getOccasnNotepadPid() {
return this.OccasnNotepadPid;
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
* Set the SetKeyd field
*
* @param SetKeyd Contents of the SET_KEYD column
*/
public void setSetKeyd(short SetKeyd) {
this.SetKeyd = SetKeyd;
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
* Set the OccasnNotepadPid field
*
* @param OccasnNotepadPid Contents of the OCCASN_NOTEPAD_PID column
*/
public void setOccasnNotepadPid(int OccasnNotepadPid) {
this.OccasnNotepadPid = OccasnNotepadPid;
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

