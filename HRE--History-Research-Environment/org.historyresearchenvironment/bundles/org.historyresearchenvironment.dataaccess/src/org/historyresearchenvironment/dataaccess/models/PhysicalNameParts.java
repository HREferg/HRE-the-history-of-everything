package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the PHYSICAL_NAME_PARTS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class PhysicalNameParts extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"PHYSICAL_NAME_PART_PID, " +
"ELEMENT_PID, " +
"THIS_NAME_EVENT_PID, " +
"NEXT_NAME_EVENT_PID, " +
"SHARED, " +
"LANG_CODE, " +
"TRANS FROM PUBLIC.PHYSICAL_NAME_PARTS WHERE PHYSICAL_NAME_PART_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"PHYSICAL_NAME_PART_PID, " +  
"ELEMENT_PID, " +  
"THIS_NAME_EVENT_PID, " +  
"NEXT_NAME_EVENT_PID, " +  
"SHARED, " +  
"LANG_CODE, " +  
"TRANS FROM PUBLIC.PHYSICAL_NAME_PARTS";

private static final String INSERT = "INSERT INTO PUBLIC.PHYSICAL_NAME_PARTS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"PHYSICAL_NAME_PART_PID, " +     
"ELEMENT_PID, " +     
"THIS_NAME_EVENT_PID, " +     
"NEXT_NAME_EVENT_PID, " +     
"SHARED, " +     
"LANG_CODE, " +     
"TRANS) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.PHYSICAL_NAME_PARTSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"ELEMENT_PID = ?, " + 
"THIS_NAME_EVENT_PID = ?, " + 
"NEXT_NAME_EVENT_PID = ?, " + 
"SHARED = ?, " + 
"LANG_CODE = ?, " + 
"TRANS = ? WHERE PHYSICAL_NAME_PART_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.PHYSICAL_NAME_PARTS WHERE PHYSICAL_NAME_PART_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.PHYSICAL_NAME_PARTS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int PhysicalNamePartPid;
private short ElementPid;
private int ThisNameEventPid;
private int NextNameEventPid;
private int Shared;
private String LangCode;
private String Trans;
private PhysicalNameParts model;

public PhysicalNameParts() throws SQLException {
}


public PhysicalNameParts(int PhysicalNamePartPid) throws SQLException {
super();
this.PhysicalNamePartPid = PhysicalNamePartPid;
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
model = new PhysicalNameParts();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setPhysicalNamePartPid(rs.getInt("PHYSICAL_NAME_PART_PID"));
model.setElementPid(rs.getShort("ELEMENT_PID"));
model.setThisNameEventPid(rs.getInt("THIS_NAME_EVENT_PID"));
model.setNextNameEventPid(rs.getInt("NEXT_NAME_EVENT_PID"));
model.setShared(rs.getInt("SHARED"));
model.setLangCode(rs.getString("LANG_CODE"));
model.setTrans(rs.getString("TRANS"));
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
model.setPhysicalNamePartPid(rs.getInt("PHYSICAL_NAME_PART_PID"));
model.setElementPid(rs.getShort("ELEMENT_PID"));
model.setThisNameEventPid(rs.getInt("THIS_NAME_EVENT_PID"));
model.setNextNameEventPid(rs.getInt("NEXT_NAME_EVENT_PID"));
model.setShared(rs.getInt("SHARED"));
model.setLangCode(rs.getString("LANG_CODE"));
model.setTrans(rs.getString("TRANS"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((PhysicalNameParts) model).setRecordNum(rs.getInt("RECORD_NUM"));
((PhysicalNameParts) model).setSetKey(rs.getShort("SET_KEY"));
((PhysicalNameParts) model).setCommitPid(rs.getInt("COMMIT_PID"));
((PhysicalNameParts) model).setPhysicalNamePartPid(rs.getInt("PHYSICAL_NAME_PART_PID"));
((PhysicalNameParts) model).setElementPid(rs.getShort("ELEMENT_PID"));
((PhysicalNameParts) model).setThisNameEventPid(rs.getInt("THIS_NAME_EVENT_PID"));
((PhysicalNameParts) model).setNextNameEventPid(rs.getInt("NEXT_NAME_EVENT_PID"));
((PhysicalNameParts) model).setShared(rs.getInt("SHARED"));
((PhysicalNameParts) model).setLangCode(rs.getString("LANG_CODE"));
((PhysicalNameParts) model).setTrans(rs.getString("TRANS"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((PhysicalNameParts) model).setRecordNum(rs.getInt("RECORD_NUM"));
((PhysicalNameParts) model).setSetKey(rs.getShort("SET_KEY"));
((PhysicalNameParts) model).setCommitPid(rs.getInt("COMMIT_PID"));
((PhysicalNameParts) model).setPhysicalNamePartPid(rs.getInt("PHYSICAL_NAME_PART_PID"));
((PhysicalNameParts) model).setElementPid(rs.getShort("ELEMENT_PID"));
((PhysicalNameParts) model).setThisNameEventPid(rs.getInt("THIS_NAME_EVENT_PID"));
((PhysicalNameParts) model).setNextNameEventPid(rs.getInt("NEXT_NAME_EVENT_PID"));
((PhysicalNameParts) model).setShared(rs.getInt("SHARED"));
((PhysicalNameParts) model).setLangCode(rs.getString("LANG_CODE"));
((PhysicalNameParts) model).setTrans(rs.getString("TRANS"));
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

public int getPhysicalNamePartPid() {
return this.PhysicalNamePartPid;
}

public short getElementPid() {
return this.ElementPid;
}

public int getThisNameEventPid() {
return this.ThisNameEventPid;
}

public int getNextNameEventPid() {
return this.NextNameEventPid;
}

public int getShared() {
return this.Shared;
}

public String getLangCode() {
return this.LangCode;
}

public String getTrans() {
return this.Trans;
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

public void setPhysicalNamePartPid(int PhysicalNamePartPid) {
this.PhysicalNamePartPid = PhysicalNamePartPid;
}

public void setElementPid(short ElementPid) {
this.ElementPid = ElementPid;
}

public void setThisNameEventPid(int ThisNameEventPid) {
this.ThisNameEventPid = ThisNameEventPid;
}

public void setNextNameEventPid(int NextNameEventPid) {
this.NextNameEventPid = NextNameEventPid;
}

public void setShared(int Shared) {
this.Shared = Shared;
}

public void setLangCode(String LangCode) {
this.LangCode = LangCode;
}

public void setTrans(String Trans) {
this.Trans = Trans;
}

}

