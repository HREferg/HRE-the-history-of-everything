package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the CONTAINS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class Contains extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"CONTAIN_PID, " +
"IS_SYSTEM, " +
"VISIBLE_ID, " +
"SUB_TYPE_KEY, " +
"BEST_NAME_PID, " +
"BEST_CREATE_PID, " +
"BEST_DESTROY_PID, " +
"BEST_IMAGE_PID, " +
"SURETY, " +
"FLAGS FROM PUBLIC.CONTAINS WHERE CONTAIN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"CONTAIN_PID, " +  
"IS_SYSTEM, " +  
"VISIBLE_ID, " +  
"SUB_TYPE_KEY, " +  
"BEST_NAME_PID, " +  
"BEST_CREATE_PID, " +  
"BEST_DESTROY_PID, " +  
"BEST_IMAGE_PID, " +  
"SURETY, " +  
"FLAGS FROM PUBLIC.CONTAINS";

private static final String INSERT = "INSERT INTO PUBLIC.CONTAINS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"CONTAIN_PID, " +     
"IS_SYSTEM, " +     
"VISIBLE_ID, " +     
"SUB_TYPE_KEY, " +     
"BEST_NAME_PID, " +     
"BEST_CREATE_PID, " +     
"BEST_DESTROY_PID, " +     
"BEST_IMAGE_PID, " +     
"SURETY, " +     
"FLAGS) VALUES (?, " +
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

private static final String UPDATE = "UPDATE PUBLIC.CONTAINSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"VISIBLE_ID = ?, " + 
"SUB_TYPE_KEY = ?, " + 
"BEST_NAME_PID = ?, " + 
"BEST_CREATE_PID = ?, " + 
"BEST_DESTROY_PID = ?, " + 
"BEST_IMAGE_PID = ?, " + 
"SURETY = ?, " + 
"FLAGS = ? WHERE CONTAIN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.CONTAINS WHERE CONTAIN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.CONTAINS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int ContainPid;
private boolean IsSystem;
private int VisibleId;
private short SubTypeKey;
private int BestNamePid;
private int BestCreatePid;
private int BestDestroyPid;
private int BestImagePid;
private String Surety;
private byte[] Flags;
private Contains model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public Contains() throws SQLException {
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
model = new Contains();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setContainPid(rs.getInt("CONTAIN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setVisibleId(rs.getInt("VISIBLE_ID"));
model.setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
model.setBestNamePid(rs.getInt("BEST_NAME_PID"));
model.setBestCreatePid(rs.getInt("BEST_CREATE_PID"));
model.setBestDestroyPid(rs.getInt("BEST_DESTROY_PID"));
model.setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
model.setSurety(rs.getString("SURETY"));
model.setFlags(rs.getBytes("FLAGS"));
modelList.add(model);
}
return modelList;
}

@Override
public Contains get(int key) throws SQLException {
model = new Contains();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setContainPid(rs.getInt("CONTAIN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setVisibleId(rs.getInt("VISIBLE_ID"));
model.setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
model.setBestNamePid(rs.getInt("BEST_NAME_PID"));
model.setBestCreatePid(rs.getInt("BEST_CREATE_PID"));
model.setBestDestroyPid(rs.getInt("BEST_DESTROY_PID"));
model.setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
model.setSurety(rs.getString("SURETY"));
model.setFlags(rs.getBytes("FLAGS"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((Contains) model).setRecordNum(rs.getInt("RECORD_NUM"));
((Contains) model).setSetKey(rs.getShort("SET_KEY"));
((Contains) model).setCommitPid(rs.getInt("COMMIT_PID"));
((Contains) model).setContainPid(rs.getInt("CONTAIN_PID"));
((Contains) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((Contains) model).setVisibleId(rs.getInt("VISIBLE_ID"));
((Contains) model).setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
((Contains) model).setBestNamePid(rs.getInt("BEST_NAME_PID"));
((Contains) model).setBestCreatePid(rs.getInt("BEST_CREATE_PID"));
((Contains) model).setBestDestroyPid(rs.getInt("BEST_DESTROY_PID"));
((Contains) model).setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
((Contains) model).setSurety(rs.getString("SURETY"));
((Contains) model).setFlags(rs.getBytes("FLAGS"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((Contains) model).setRecordNum(rs.getInt("RECORD_NUM"));
((Contains) model).setSetKey(rs.getShort("SET_KEY"));
((Contains) model).setCommitPid(rs.getInt("COMMIT_PID"));
((Contains) model).setContainPid(rs.getInt("CONTAIN_PID"));
((Contains) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((Contains) model).setVisibleId(rs.getInt("VISIBLE_ID"));
((Contains) model).setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
((Contains) model).setBestNamePid(rs.getInt("BEST_NAME_PID"));
((Contains) model).setBestCreatePid(rs.getInt("BEST_CREATE_PID"));
((Contains) model).setBestDestroyPid(rs.getInt("BEST_DESTROY_PID"));
((Contains) model).setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
((Contains) model).setSurety(rs.getString("SURETY"));
((Contains) model).setFlags(rs.getBytes("FLAGS"));
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
* Get the ContainPid field.
*
* @return Contents of the CONTAIN_PID column
*/
public int getContainPid() {
return this.ContainPid;
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
* Get the VisibleId field.
*
* @return Contents of the VISIBLE_ID column
*/
public int getVisibleId() {
return this.VisibleId;
}

/**
* Get the SubTypeKey field.
*
* @return Contents of the SUB_TYPE_KEY column
*/
public short getSubTypeKey() {
return this.SubTypeKey;
}

/**
* Get the BestNamePid field.
*
* @return Contents of the BEST_NAME_PID column
*/
public int getBestNamePid() {
return this.BestNamePid;
}

/**
* Get the BestCreatePid field.
*
* @return Contents of the BEST_CREATE_PID column
*/
public int getBestCreatePid() {
return this.BestCreatePid;
}

/**
* Get the BestDestroyPid field.
*
* @return Contents of the BEST_DESTROY_PID column
*/
public int getBestDestroyPid() {
return this.BestDestroyPid;
}

/**
* Get the BestImagePid field.
*
* @return Contents of the BEST_IMAGE_PID column
*/
public int getBestImagePid() {
return this.BestImagePid;
}

/**
* Get the Surety field.
*
* @return Contents of the SURETY column
*/
public String getSurety() {
return this.Surety;
}

/**
* Get the Flags field.
*
* @return Contents of the FLAGS column
*/
public byte[] getFlags() {
return this.Flags;
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
* Set the ContainPid field
*
* @param ContainPid Contents of the CONTAIN_PID column
*/
public void setContainPid(int ContainPid) {
this.ContainPid = ContainPid;
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
* Set the VisibleId field
*
* @param VisibleId Contents of the VISIBLE_ID column
*/
public void setVisibleId(int VisibleId) {
this.VisibleId = VisibleId;
}

/**
* Set the SubTypeKey field
*
* @param SubTypeKey Contents of the SUB_TYPE_KEY column
*/
public void setSubTypeKey(short SubTypeKey) {
this.SubTypeKey = SubTypeKey;
}

/**
* Set the BestNamePid field
*
* @param BestNamePid Contents of the BEST_NAME_PID column
*/
public void setBestNamePid(int BestNamePid) {
this.BestNamePid = BestNamePid;
}

/**
* Set the BestCreatePid field
*
* @param BestCreatePid Contents of the BEST_CREATE_PID column
*/
public void setBestCreatePid(int BestCreatePid) {
this.BestCreatePid = BestCreatePid;
}

/**
* Set the BestDestroyPid field
*
* @param BestDestroyPid Contents of the BEST_DESTROY_PID column
*/
public void setBestDestroyPid(int BestDestroyPid) {
this.BestDestroyPid = BestDestroyPid;
}

/**
* Set the BestImagePid field
*
* @param BestImagePid Contents of the BEST_IMAGE_PID column
*/
public void setBestImagePid(int BestImagePid) {
this.BestImagePid = BestImagePid;
}

/**
* Set the Surety field
*
* @param Surety Contents of the SURETY column
*/
public void setSurety(String Surety) {
this.Surety = Surety;
}

/**
* Set the Flags field
*
* @param Flags Contents of the FLAGS column
*/
public void setFlags(byte[] Flags) {
this.Flags = Flags;
}

}

