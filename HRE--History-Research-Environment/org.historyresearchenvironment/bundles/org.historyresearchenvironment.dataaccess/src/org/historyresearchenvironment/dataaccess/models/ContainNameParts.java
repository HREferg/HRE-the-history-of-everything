package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the CONTAIN_NAME_PARTS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class ContainNameParts extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"CONTAIN_NAME_PART_PID, " +
"IS_SYSTEM, " +
"ELEMENT_TYPE_KEY, " +
"SHARED, " +
"LANG_CODE, " +
"TRANS FROM PUBLIC.CONTAIN_NAME_PARTS WHERE CONTAIN_NAME_PART_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"CONTAIN_NAME_PART_PID, " +  
"IS_SYSTEM, " +  
"ELEMENT_TYPE_KEY, " +  
"SHARED, " +  
"LANG_CODE, " +  
"TRANS FROM PUBLIC.CONTAIN_NAME_PARTS";

private static final String INSERT = "INSERT INTO PUBLIC.CONTAIN_NAME_PARTS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"CONTAIN_NAME_PART_PID, " +     
"IS_SYSTEM, " +     
"ELEMENT_TYPE_KEY, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.CONTAIN_NAME_PARTSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"ELEMENT_TYPE_KEY = ?, " + 
"SHARED = ?, " + 
"LANG_CODE = ?, " + 
"TRANS = ? WHERE CONTAIN_NAME_PART_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.CONTAIN_NAME_PARTS WHERE CONTAIN_NAME_PART_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.CONTAIN_NAME_PARTS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int ContainNamePartPid;
private boolean IsSystem;
private short ElementTypeKey;
private int Shared;
private String LangCode;
private String Trans;
private ContainNameParts model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public ContainNameParts() throws SQLException {
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
model = new ContainNameParts();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setContainNamePartPid(rs.getInt("CONTAIN_NAME_PART_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
model.setShared(rs.getInt("SHARED"));
model.setLangCode(rs.getString("LANG_CODE"));
model.setTrans(rs.getString("TRANS"));
modelList.add(model);
}
return modelList;
}

@Override
public ContainNameParts get(int key) throws SQLException {
model = new ContainNameParts();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setContainNamePartPid(rs.getInt("CONTAIN_NAME_PART_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
model.setShared(rs.getInt("SHARED"));
model.setLangCode(rs.getString("LANG_CODE"));
model.setTrans(rs.getString("TRANS"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((ContainNameParts) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ContainNameParts) model).setSetKey(rs.getShort("SET_KEY"));
((ContainNameParts) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ContainNameParts) model).setContainNamePartPid(rs.getInt("CONTAIN_NAME_PART_PID"));
((ContainNameParts) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((ContainNameParts) model).setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
((ContainNameParts) model).setShared(rs.getInt("SHARED"));
((ContainNameParts) model).setLangCode(rs.getString("LANG_CODE"));
((ContainNameParts) model).setTrans(rs.getString("TRANS"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((ContainNameParts) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ContainNameParts) model).setSetKey(rs.getShort("SET_KEY"));
((ContainNameParts) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ContainNameParts) model).setContainNamePartPid(rs.getInt("CONTAIN_NAME_PART_PID"));
((ContainNameParts) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((ContainNameParts) model).setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
((ContainNameParts) model).setShared(rs.getInt("SHARED"));
((ContainNameParts) model).setLangCode(rs.getString("LANG_CODE"));
((ContainNameParts) model).setTrans(rs.getString("TRANS"));
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
* Get the ContainNamePartPid field.
*
* @return Contents of the CONTAIN_NAME_PART_PID column
*/
public int getContainNamePartPid() {
return this.ContainNamePartPid;
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
* Get the ElementTypeKey field.
*
* @return Contents of the ELEMENT_TYPE_KEY column
*/
public short getElementTypeKey() {
return this.ElementTypeKey;
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
* Set the ContainNamePartPid field
*
* @param ContainNamePartPid Contents of the CONTAIN_NAME_PART_PID column
*/
public void setContainNamePartPid(int ContainNamePartPid) {
this.ContainNamePartPid = ContainNamePartPid;
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
* Set the ElementTypeKey field
*
* @param ElementTypeKey Contents of the ELEMENT_TYPE_KEY column
*/
public void setElementTypeKey(short ElementTypeKey) {
this.ElementTypeKey = ElementTypeKey;
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

