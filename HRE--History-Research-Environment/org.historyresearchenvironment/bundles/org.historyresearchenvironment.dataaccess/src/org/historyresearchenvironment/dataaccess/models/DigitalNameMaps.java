package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the DIGITAL_NAME_MAPS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class DigitalNameMaps extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"DIGITAL_NAME_MAP_PID, " +
"IS_SYSTEM, " +
"PARENT_NAME_PID, " +
"PARENT_SUB_TYPE_KEY, " +
"ELEMENT_TYPE_KEY, " +
"SHARED, " +
"INFERRED_SHARED FROM PUBLIC.DIGITAL_NAME_MAPS WHERE DIGITAL_NAME_MAP_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"DIGITAL_NAME_MAP_PID, " +  
"IS_SYSTEM, " +  
"PARENT_NAME_PID, " +  
"PARENT_SUB_TYPE_KEY, " +  
"ELEMENT_TYPE_KEY, " +  
"SHARED, " +  
"INFERRED_SHARED FROM PUBLIC.DIGITAL_NAME_MAPS";

private static final String INSERT = "INSERT INTO PUBLIC.DIGITAL_NAME_MAPS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"DIGITAL_NAME_MAP_PID, " +     
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

private static final String UPDATE = "UPDATE PUBLIC.DIGITAL_NAME_MAPSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PARENT_NAME_PID = ?, " + 
"PARENT_SUB_TYPE_KEY = ?, " + 
"ELEMENT_TYPE_KEY = ?, " + 
"SHARED = ?, " + 
"INFERRED_SHARED = ? WHERE DIGITAL_NAME_MAP_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.DIGITAL_NAME_MAPS WHERE DIGITAL_NAME_MAP_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.DIGITAL_NAME_MAPS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int DigitalNameMapPid;
private boolean IsSystem;
private int ParentNamePid;
private short ParentSubTypeKey;
private int ElementTypeKey;
private int Shared;
private int InferredShared;
private DigitalNameMaps model;

public DigitalNameMaps() throws SQLException {
}


public DigitalNameMaps(int DigitalNameMapPid) throws SQLException {
super();
this.DigitalNameMapPid = DigitalNameMapPid;
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
model = new DigitalNameMaps();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setDigitalNameMapPid(rs.getInt("DIGITAL_NAME_MAP_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentNamePid(rs.getInt("PARENT_NAME_PID"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setElementTypeKey(rs.getInt("ELEMENT_TYPE_KEY"));
model.setShared(rs.getInt("SHARED"));
model.setInferredShared(rs.getInt("INFERRED_SHARED"));
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
model.setDigitalNameMapPid(rs.getInt("DIGITAL_NAME_MAP_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentNamePid(rs.getInt("PARENT_NAME_PID"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setElementTypeKey(rs.getInt("ELEMENT_TYPE_KEY"));
model.setShared(rs.getInt("SHARED"));
model.setInferredShared(rs.getInt("INFERRED_SHARED"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((DigitalNameMaps) model).setRecordNum(rs.getInt("RECORD_NUM"));
((DigitalNameMaps) model).setSetKey(rs.getShort("SET_KEY"));
((DigitalNameMaps) model).setCommitPid(rs.getInt("COMMIT_PID"));
((DigitalNameMaps) model).setDigitalNameMapPid(rs.getInt("DIGITAL_NAME_MAP_PID"));
((DigitalNameMaps) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((DigitalNameMaps) model).setParentNamePid(rs.getInt("PARENT_NAME_PID"));
((DigitalNameMaps) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((DigitalNameMaps) model).setElementTypeKey(rs.getInt("ELEMENT_TYPE_KEY"));
((DigitalNameMaps) model).setShared(rs.getInt("SHARED"));
((DigitalNameMaps) model).setInferredShared(rs.getInt("INFERRED_SHARED"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((DigitalNameMaps) model).setRecordNum(rs.getInt("RECORD_NUM"));
((DigitalNameMaps) model).setSetKey(rs.getShort("SET_KEY"));
((DigitalNameMaps) model).setCommitPid(rs.getInt("COMMIT_PID"));
((DigitalNameMaps) model).setDigitalNameMapPid(rs.getInt("DIGITAL_NAME_MAP_PID"));
((DigitalNameMaps) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((DigitalNameMaps) model).setParentNamePid(rs.getInt("PARENT_NAME_PID"));
((DigitalNameMaps) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((DigitalNameMaps) model).setElementTypeKey(rs.getInt("ELEMENT_TYPE_KEY"));
((DigitalNameMaps) model).setShared(rs.getInt("SHARED"));
((DigitalNameMaps) model).setInferredShared(rs.getInt("INFERRED_SHARED"));
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

public int getDigitalNameMapPid() {
return this.DigitalNameMapPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public int getParentNamePid() {
return this.ParentNamePid;
}

public short getParentSubTypeKey() {
return this.ParentSubTypeKey;
}

public int getElementTypeKey() {
return this.ElementTypeKey;
}

public int getShared() {
return this.Shared;
}

public int getInferredShared() {
return this.InferredShared;
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

public void setDigitalNameMapPid(int DigitalNameMapPid) {
this.DigitalNameMapPid = DigitalNameMapPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setParentNamePid(int ParentNamePid) {
this.ParentNamePid = ParentNamePid;
}

public void setParentSubTypeKey(short ParentSubTypeKey) {
this.ParentSubTypeKey = ParentSubTypeKey;
}

public void setElementTypeKey(int ElementTypeKey) {
this.ElementTypeKey = ElementTypeKey;
}

public void setShared(int Shared) {
this.Shared = Shared;
}

public void setInferredShared(int InferredShared) {
this.InferredShared = InferredShared;
}

}

