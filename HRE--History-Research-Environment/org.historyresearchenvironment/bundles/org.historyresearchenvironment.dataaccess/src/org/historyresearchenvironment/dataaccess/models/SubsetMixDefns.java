package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSET_MIX_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SubsetMixDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SUBSET_MIX_DEFN_PID, " +
"SUBSET_PID, " +
"USE_ORDER, " +
"REFER1_PID, " +
"REFER2_PID FROM PUBLIC.SUBSET_MIX_DEFNS WHERE SUBSET_MIX_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SUBSET_MIX_DEFN_PID, " +  
"SUBSET_PID, " +  
"USE_ORDER, " +  
"REFER1_PID, " +  
"REFER2_PID FROM PUBLIC.SUBSET_MIX_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.SUBSET_MIX_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SUBSET_MIX_DEFN_PID, " +     
"SUBSET_PID, " +     
"USE_ORDER, " +     
"REFER1_PID, " +     
"REFER2_PID) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SUBSET_MIX_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"SUBSET_PID = ?, " + 
"USE_ORDER = ?, " + 
"REFER1_PID = ?, " + 
"REFER2_PID = ? WHERE SUBSET_MIX_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SUBSET_MIX_DEFNS WHERE SUBSET_MIX_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSET_MIX_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SubsetMixDefnPid;
private int SubsetPid;
private int UseOrder;
private int Refer1Pid;
private int Refer2Pid;
private SubsetMixDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public SubsetMixDefns() throws SQLException {
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
model = new SubsetMixDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSubsetMixDefnPid(rs.getInt("SUBSET_MIX_DEFN_PID"));
model.setSubsetPid(rs.getInt("SUBSET_PID"));
model.setUseOrder(rs.getInt("USE_ORDER"));
model.setRefer1Pid(rs.getInt("REFER1_PID"));
model.setRefer2Pid(rs.getInt("REFER2_PID"));
modelList.add(model);
}
return modelList;
}

@Override
public SubsetMixDefns get(int key) throws SQLException {
model = new SubsetMixDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSubsetMixDefnPid(rs.getInt("SUBSET_MIX_DEFN_PID"));
model.setSubsetPid(rs.getInt("SUBSET_PID"));
model.setUseOrder(rs.getInt("USE_ORDER"));
model.setRefer1Pid(rs.getInt("REFER1_PID"));
model.setRefer2Pid(rs.getInt("REFER2_PID"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((SubsetMixDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubsetMixDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SubsetMixDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubsetMixDefns) model).setSubsetMixDefnPid(rs.getInt("SUBSET_MIX_DEFN_PID"));
((SubsetMixDefns) model).setSubsetPid(rs.getInt("SUBSET_PID"));
((SubsetMixDefns) model).setUseOrder(rs.getInt("USE_ORDER"));
((SubsetMixDefns) model).setRefer1Pid(rs.getInt("REFER1_PID"));
((SubsetMixDefns) model).setRefer2Pid(rs.getInt("REFER2_PID"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((SubsetMixDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubsetMixDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SubsetMixDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubsetMixDefns) model).setSubsetMixDefnPid(rs.getInt("SUBSET_MIX_DEFN_PID"));
((SubsetMixDefns) model).setSubsetPid(rs.getInt("SUBSET_PID"));
((SubsetMixDefns) model).setUseOrder(rs.getInt("USE_ORDER"));
((SubsetMixDefns) model).setRefer1Pid(rs.getInt("REFER1_PID"));
((SubsetMixDefns) model).setRefer2Pid(rs.getInt("REFER2_PID"));
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
* Get the SubsetMixDefnPid field.
*
* @return Contents of the SUBSET_MIX_DEFN_PID column
*/
public int getSubsetMixDefnPid() {
return this.SubsetMixDefnPid;
}

/**
* Get the SubsetPid field.
*
* @return Contents of the SUBSET_PID column
*/
public int getSubsetPid() {
return this.SubsetPid;
}

/**
* Get the UseOrder field.
*
* @return Contents of the USE_ORDER column
*/
public int getUseOrder() {
return this.UseOrder;
}

/**
* Get the Refer1Pid field.
*
* @return Contents of the REFER1_PID column
*/
public int getRefer1Pid() {
return this.Refer1Pid;
}

/**
* Get the Refer2Pid field.
*
* @return Contents of the REFER2_PID column
*/
public int getRefer2Pid() {
return this.Refer2Pid;
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
* Set the SubsetMixDefnPid field
*
* @param SubsetMixDefnPid Contents of the SUBSET_MIX_DEFN_PID column
*/
public void setSubsetMixDefnPid(int SubsetMixDefnPid) {
this.SubsetMixDefnPid = SubsetMixDefnPid;
}

/**
* Set the SubsetPid field
*
* @param SubsetPid Contents of the SUBSET_PID column
*/
public void setSubsetPid(int SubsetPid) {
this.SubsetPid = SubsetPid;
}

/**
* Set the UseOrder field
*
* @param UseOrder Contents of the USE_ORDER column
*/
public void setUseOrder(int UseOrder) {
this.UseOrder = UseOrder;
}

/**
* Set the Refer1Pid field
*
* @param Refer1Pid Contents of the REFER1_PID column
*/
public void setRefer1Pid(int Refer1Pid) {
this.Refer1Pid = Refer1Pid;
}

/**
* Set the Refer2Pid field
*
* @param Refer2Pid Contents of the REFER2_PID column
*/
public void setRefer2Pid(int Refer2Pid) {
this.Refer2Pid = Refer2Pid;
}

}

