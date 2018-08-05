package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the OCCASN_NAME_MAPS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class OccasnNameMaps extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"OCCASN_NAME_MAP_PID, " +
"IS_SYSTEM, " +
"PARENT_NAME_PID, " +
"PARENT_SUB_TYPE_KEY, " +
"ELEMENT_TYPE_KEY, " +
"SHARED, " +
"INFERRED_SHARED FROM PUBLIC.OCCASN_NAME_MAPS WHERE OCCASN_NAME_MAP_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"OCCASN_NAME_MAP_PID, " +  
"IS_SYSTEM, " +  
"PARENT_NAME_PID, " +  
"PARENT_SUB_TYPE_KEY, " +  
"ELEMENT_TYPE_KEY, " +  
"SHARED, " +  
"INFERRED_SHARED FROM PUBLIC.OCCASN_NAME_MAPS";

private static final String INSERT = "INSERT INTO PUBLIC.OCCASN_NAME_MAPS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"OCCASN_NAME_MAP_PID, " +     
"IS_SYSTEM, " +     
"PARENT_NAME_PID, " +     
"PARENT_SUB_TYPE_KEY, " +     
"ELEMENT_TYPE_KEY, " +     
"SHARED, " +     
"INFERRED_SHARED) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.OCCASN_NAME_MAPSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PARENT_NAME_PID = ?, " + 
"PARENT_SUB_TYPE_KEY = ?, " + 
"ELEMENT_TYPE_KEY = ?, " + 
"SHARED = ?, " + 
"INFERRED_SHARED = ? WHERE OCCASN_NAME_MAP_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.OCCASN_NAME_MAPS WHERE OCCASN_NAME_MAP_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASN_NAME_MAPS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int OccasnNameMapPid;
private boolean IsSystem;
private int ParentNamePid;
private short ParentSubTypeKey;
private short ElementTypeKey;
private int Shared;
private int InferredShared;
private OccasnNameMaps model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public OccasnNameMaps() throws SQLException {
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
model = new OccasnNameMaps();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOccasnNameMapPid(rs.getInt("OCCASN_NAME_MAP_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentNamePid(rs.getInt("PARENT_NAME_PID"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
model.setShared(rs.getInt("SHARED"));
model.setInferredShared(rs.getInt("INFERRED_SHARED"));
modelList.add(model);
}
return modelList;
}

@Override
public OccasnNameMaps get(int key) throws SQLException {
model = new OccasnNameMaps();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOccasnNameMapPid(rs.getInt("OCCASN_NAME_MAP_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentNamePid(rs.getInt("PARENT_NAME_PID"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
model.setShared(rs.getInt("SHARED"));
model.setInferredShared(rs.getInt("INFERRED_SHARED"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((OccasnNameMaps) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OccasnNameMaps) model).setSetKey(rs.getShort("SET_KEY"));
((OccasnNameMaps) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OccasnNameMaps) model).setOccasnNameMapPid(rs.getInt("OCCASN_NAME_MAP_PID"));
((OccasnNameMaps) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((OccasnNameMaps) model).setParentNamePid(rs.getInt("PARENT_NAME_PID"));
((OccasnNameMaps) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((OccasnNameMaps) model).setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
((OccasnNameMaps) model).setShared(rs.getInt("SHARED"));
((OccasnNameMaps) model).setInferredShared(rs.getInt("INFERRED_SHARED"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((OccasnNameMaps) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OccasnNameMaps) model).setSetKey(rs.getShort("SET_KEY"));
((OccasnNameMaps) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OccasnNameMaps) model).setOccasnNameMapPid(rs.getInt("OCCASN_NAME_MAP_PID"));
((OccasnNameMaps) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((OccasnNameMaps) model).setParentNamePid(rs.getInt("PARENT_NAME_PID"));
((OccasnNameMaps) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((OccasnNameMaps) model).setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
((OccasnNameMaps) model).setShared(rs.getInt("SHARED"));
((OccasnNameMaps) model).setInferredShared(rs.getInt("INFERRED_SHARED"));
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
* Get the OccasnNameMapPid field.
*
* @return Contents of the OCCASN_NAME_MAP_PID column
*/
public int getOccasnNameMapPid() {
return this.OccasnNameMapPid;
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
* Get the ParentNamePid field.
*
* @return Contents of the PARENT_NAME_PID column
*/
public int getParentNamePid() {
return this.ParentNamePid;
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
* Get the InferredShared field.
*
* @return Contents of the INFERRED_SHARED column
*/
public int getInferredShared() {
return this.InferredShared;
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
* Set the OccasnNameMapPid field
*
* @param OccasnNameMapPid Contents of the OCCASN_NAME_MAP_PID column
*/
public void setOccasnNameMapPid(int OccasnNameMapPid) {
this.OccasnNameMapPid = OccasnNameMapPid;
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
* Set the ParentNamePid field
*
* @param ParentNamePid Contents of the PARENT_NAME_PID column
*/
public void setParentNamePid(int ParentNamePid) {
this.ParentNamePid = ParentNamePid;
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
* Set the InferredShared field
*
* @param InferredShared Contents of the INFERRED_SHARED column
*/
public void setInferredShared(int InferredShared) {
this.InferredShared = InferredShared;
}

}

