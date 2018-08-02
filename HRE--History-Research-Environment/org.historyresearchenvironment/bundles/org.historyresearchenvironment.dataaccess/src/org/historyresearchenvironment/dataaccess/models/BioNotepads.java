package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the BIO_NOTEPADS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class BioNotepads extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"BIO_NOTEPAD_PID, " +
"IS_SYSTEM, " +
"PARENT_PID, " +
"PARENT_SUB_TYPE_KEY, " +
"NOTEPAD_DEFN_KEY, " +
"NOTEPAD FROM PUBLIC.BIO_NOTEPADS WHERE BIO_NOTEPAD_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"BIO_NOTEPAD_PID, " +  
"IS_SYSTEM, " +  
"PARENT_PID, " +  
"PARENT_SUB_TYPE_KEY, " +  
"NOTEPAD_DEFN_KEY, " +  
"NOTEPAD FROM PUBLIC.BIO_NOTEPADS";

private static final String INSERT = "INSERT INTO PUBLIC.BIO_NOTEPADS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"BIO_NOTEPAD_PID, " +     
"IS_SYSTEM, " +     
"PARENT_PID, " +     
"PARENT_SUB_TYPE_KEY, " +     
"NOTEPAD_DEFN_KEY, " +     
"NOTEPAD) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.BIO_NOTEPADSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PARENT_PID = ?, " + 
"PARENT_SUB_TYPE_KEY = ?, " + 
"NOTEPAD_DEFN_KEY = ?, " + 
"NOTEPAD = ? WHERE BIO_NOTEPAD_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.BIO_NOTEPADS WHERE BIO_NOTEPAD_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.BIO_NOTEPADS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int BioNotepadPid;
private boolean IsSystem;
private int ParentPid;
private short ParentSubTypeKey;
private short NotepadDefnKey;
private String Notepad;
private BioNotepads model;

public BioNotepads() throws SQLException {
}


public BioNotepads(int BioNotepadPid) throws SQLException {
super();
this.BioNotepadPid = BioNotepadPid;
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
model = new BioNotepads();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setBioNotepadPid(rs.getInt("BIO_NOTEPAD_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentPid(rs.getInt("PARENT_PID"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setNotepadDefnKey(rs.getShort("NOTEPAD_DEFN_KEY"));
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
model.setBioNotepadPid(rs.getInt("BIO_NOTEPAD_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentPid(rs.getInt("PARENT_PID"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setNotepadDefnKey(rs.getShort("NOTEPAD_DEFN_KEY"));
model.setNotepad(rs.getString("NOTEPAD"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((BioNotepads) model).setRecordNum(rs.getInt("RECORD_NUM"));
((BioNotepads) model).setSetKey(rs.getShort("SET_KEY"));
((BioNotepads) model).setCommitPid(rs.getInt("COMMIT_PID"));
((BioNotepads) model).setBioNotepadPid(rs.getInt("BIO_NOTEPAD_PID"));
((BioNotepads) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((BioNotepads) model).setParentPid(rs.getInt("PARENT_PID"));
((BioNotepads) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((BioNotepads) model).setNotepadDefnKey(rs.getShort("NOTEPAD_DEFN_KEY"));
((BioNotepads) model).setNotepad(rs.getString("NOTEPAD"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((BioNotepads) model).setRecordNum(rs.getInt("RECORD_NUM"));
((BioNotepads) model).setSetKey(rs.getShort("SET_KEY"));
((BioNotepads) model).setCommitPid(rs.getInt("COMMIT_PID"));
((BioNotepads) model).setBioNotepadPid(rs.getInt("BIO_NOTEPAD_PID"));
((BioNotepads) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((BioNotepads) model).setParentPid(rs.getInt("PARENT_PID"));
((BioNotepads) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((BioNotepads) model).setNotepadDefnKey(rs.getShort("NOTEPAD_DEFN_KEY"));
((BioNotepads) model).setNotepad(rs.getString("NOTEPAD"));
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

public int getBioNotepadPid() {
return this.BioNotepadPid;
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

public short getNotepadDefnKey() {
return this.NotepadDefnKey;
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

public void setBioNotepadPid(int BioNotepadPid) {
this.BioNotepadPid = BioNotepadPid;
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

public void setNotepadDefnKey(short NotepadDefnKey) {
this.NotepadDefnKey = NotepadDefnKey;
}

public void setNotepad(String Notepad) {
this.Notepad = Notepad;
}

}

