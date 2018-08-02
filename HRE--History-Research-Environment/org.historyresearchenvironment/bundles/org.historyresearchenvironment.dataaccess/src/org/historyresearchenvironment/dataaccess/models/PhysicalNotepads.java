package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the PHYSICAL_NOTEPADS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class PhysicalNotepads extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"PHYSICAL_NOTEPAD_PID, " +
"IS_SYSTEM, " +
"PARENT_PID, " +
"PARENT_SUB_TYPE_KEY, " +
"NOTEPAD_DEFN_PID, " +
"NOTEPAD FROM PUBLIC.PHYSICAL_NOTEPADS WHERE PHYSICAL_NOTEPAD_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"PHYSICAL_NOTEPAD_PID, " +  
"IS_SYSTEM, " +  
"PARENT_PID, " +  
"PARENT_SUB_TYPE_KEY, " +  
"NOTEPAD_DEFN_PID, " +  
"NOTEPAD FROM PUBLIC.PHYSICAL_NOTEPADS";

private static final String INSERT = "INSERT INTO PUBLIC.PHYSICAL_NOTEPADS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"PHYSICAL_NOTEPAD_PID, " +     
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

private static final String UPDATE = "UPDATE PUBLIC.PHYSICAL_NOTEPADSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PARENT_PID = ?, " + 
"PARENT_SUB_TYPE_KEY = ?, " + 
"NOTEPAD_DEFN_PID = ?, " + 
"NOTEPAD = ? WHERE PHYSICAL_NOTEPAD_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.PHYSICAL_NOTEPADS WHERE PHYSICAL_NOTEPAD_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.PHYSICAL_NOTEPADS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int PhysicalNotepadPid;
private boolean IsSystem;
private int ParentPid;
private short ParentSubTypeKey;
private short NotepadDefnPid;
private String Notepad;
private PhysicalNotepads model;

public PhysicalNotepads() throws SQLException {
}


public PhysicalNotepads(int PhysicalNotepadPid) throws SQLException {
super();
this.PhysicalNotepadPid = PhysicalNotepadPid;
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
model = new PhysicalNotepads();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setPhysicalNotepadPid(rs.getInt("PHYSICAL_NOTEPAD_PID"));
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
public AbstractHreDataModel get(int key) throws SQLException {
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setPhysicalNotepadPid(rs.getInt("PHYSICAL_NOTEPAD_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentPid(rs.getInt("PARENT_PID"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setNotepadDefnPid(rs.getShort("NOTEPAD_DEFN_PID"));
model.setNotepad(rs.getString("NOTEPAD"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((PhysicalNotepads) model).setRecordNum(rs.getInt("RECORD_NUM"));
((PhysicalNotepads) model).setSetKey(rs.getShort("SET_KEY"));
((PhysicalNotepads) model).setCommitPid(rs.getInt("COMMIT_PID"));
((PhysicalNotepads) model).setPhysicalNotepadPid(rs.getInt("PHYSICAL_NOTEPAD_PID"));
((PhysicalNotepads) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((PhysicalNotepads) model).setParentPid(rs.getInt("PARENT_PID"));
((PhysicalNotepads) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((PhysicalNotepads) model).setNotepadDefnPid(rs.getShort("NOTEPAD_DEFN_PID"));
((PhysicalNotepads) model).setNotepad(rs.getString("NOTEPAD"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((PhysicalNotepads) model).setRecordNum(rs.getInt("RECORD_NUM"));
((PhysicalNotepads) model).setSetKey(rs.getShort("SET_KEY"));
((PhysicalNotepads) model).setCommitPid(rs.getInt("COMMIT_PID"));
((PhysicalNotepads) model).setPhysicalNotepadPid(rs.getInt("PHYSICAL_NOTEPAD_PID"));
((PhysicalNotepads) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((PhysicalNotepads) model).setParentPid(rs.getInt("PARENT_PID"));
((PhysicalNotepads) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((PhysicalNotepads) model).setNotepadDefnPid(rs.getShort("NOTEPAD_DEFN_PID"));
((PhysicalNotepads) model).setNotepad(rs.getString("NOTEPAD"));
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

public int getPhysicalNotepadPid() {
return this.PhysicalNotepadPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public int getParentPid() {
return this.ParentPid;
}

public short getParentSubTypeKey() {
return this.ParentSubTypeKey;
}

public short getNotepadDefnPid() {
return this.NotepadDefnPid;
}

public String getNotepad() {
return this.Notepad;
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

public void setPhysicalNotepadPid(int PhysicalNotepadPid) {
this.PhysicalNotepadPid = PhysicalNotepadPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setParentPid(int ParentPid) {
this.ParentPid = ParentPid;
}

public void setParentSubTypeKey(short ParentSubTypeKey) {
this.ParentSubTypeKey = ParentSubTypeKey;
}

public void setNotepadDefnPid(short NotepadDefnPid) {
this.NotepadDefnPid = NotepadDefnPid;
}

public void setNotepad(String Notepad) {
this.Notepad = Notepad;
}

}

