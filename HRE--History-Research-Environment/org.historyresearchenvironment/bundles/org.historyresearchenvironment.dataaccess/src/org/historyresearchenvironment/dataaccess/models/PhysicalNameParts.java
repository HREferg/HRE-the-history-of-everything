package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the PHYSICAL_NAME_PARTS database table.
*
* @version 2018-08-05
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

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public PhysicalNameParts() throws SQLException {
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
public PhysicalNameParts get(int key) throws SQLException {
model = new PhysicalNameParts();
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
return model;
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
* Get the PhysicalNamePartPid field.
*
* @return Contents of the PHYSICAL_NAME_PART_PID column
*/
public int getPhysicalNamePartPid() {
return this.PhysicalNamePartPid;
}

/**
* Get the ElementPid field.
*
* @return Contents of the ELEMENT_PID column
*/
public short getElementPid() {
return this.ElementPid;
}

/**
* Get the ThisNameEventPid field.
*
* @return Contents of the THIS_NAME_EVENT_PID column
*/
public int getThisNameEventPid() {
return this.ThisNameEventPid;
}

/**
* Get the NextNameEventPid field.
*
* @return Contents of the NEXT_NAME_EVENT_PID column
*/
public int getNextNameEventPid() {
return this.NextNameEventPid;
}

/**
* Get the Shared field.
*
* @return Contents of the SHARED column
*/
public int getShared() {
return this.Shared;
}

/**
* Get the LangCode field.
*
* @return Contents of the LANG_CODE column
*/
public String getLangCode() {
return this.LangCode;
}

/**
* Get the Trans field.
*
* @return Contents of the TRANS column
*/
public String getTrans() {
return this.Trans;
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
* Set the PhysicalNamePartPid field
*
* @param PhysicalNamePartPid Contents of the PHYSICAL_NAME_PART_PID column
*/
public void setPhysicalNamePartPid(int PhysicalNamePartPid) {
this.PhysicalNamePartPid = PhysicalNamePartPid;
}

/**
* Set the ElementPid field
*
* @param ElementPid Contents of the ELEMENT_PID column
*/
public void setElementPid(short ElementPid) {
this.ElementPid = ElementPid;
}

/**
* Set the ThisNameEventPid field
*
* @param ThisNameEventPid Contents of the THIS_NAME_EVENT_PID column
*/
public void setThisNameEventPid(int ThisNameEventPid) {
this.ThisNameEventPid = ThisNameEventPid;
}

/**
* Set the NextNameEventPid field
*
* @param NextNameEventPid Contents of the NEXT_NAME_EVENT_PID column
*/
public void setNextNameEventPid(int NextNameEventPid) {
this.NextNameEventPid = NextNameEventPid;
}

/**
* Set the Shared field
*
* @param Shared Contents of the SHARED column
*/
public void setShared(int Shared) {
this.Shared = Shared;
}

/**
* Set the LangCode field
*
* @param LangCode Contents of the LANG_CODE column
*/
public void setLangCode(String LangCode) {
this.LangCode = LangCode;
}

/**
* Set the Trans field
*
* @param Trans Contents of the TRANS column
*/
public void setTrans(String Trans) {
this.Trans = Trans;
}

}

