package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSET_SINGLE_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SubsetSingleDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SUBSET_SINGLE_DEFN_PID, " +
"SUBSET_PID, " +
"USE_ORDER, " +
"REFER_PID, " +
"COUNT FROM PUBLIC.SUBSET_SINGLE_DEFNS WHERE SUBSET_SINGLE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SUBSET_SINGLE_DEFN_PID, " +  
"SUBSET_PID, " +  
"USE_ORDER, " +  
"REFER_PID, " +  
"COUNT FROM PUBLIC.SUBSET_SINGLE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.SUBSET_SINGLE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SUBSET_SINGLE_DEFN_PID, " +     
"SUBSET_PID, " +     
"USE_ORDER, " +     
"REFER_PID, " +     
"COUNT) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SUBSET_SINGLE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"SUBSET_PID = ?, " + 
"USE_ORDER = ?, " + 
"REFER_PID = ?, " + 
"COUNT = ? WHERE SUBSET_SINGLE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SUBSET_SINGLE_DEFNS WHERE SUBSET_SINGLE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSET_SINGLE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SubsetSingleDefnPid;
private int SubsetPid;
private int UseOrder;
private int ReferPid;
private int Count;
private SubsetSingleDefns model;

public SubsetSingleDefns() throws SQLException {
}


public SubsetSingleDefns(int SubsetSingleDefnPid) throws SQLException {
super();
this.SubsetSingleDefnPid = SubsetSingleDefnPid;
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
model = new SubsetSingleDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSubsetSingleDefnPid(rs.getInt("SUBSET_SINGLE_DEFN_PID"));
model.setSubsetPid(rs.getInt("SUBSET_PID"));
model.setUseOrder(rs.getInt("USE_ORDER"));
model.setReferPid(rs.getInt("REFER_PID"));
model.setCount(rs.getInt("COUNT"));
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
model.setSubsetSingleDefnPid(rs.getInt("SUBSET_SINGLE_DEFN_PID"));
model.setSubsetPid(rs.getInt("SUBSET_PID"));
model.setUseOrder(rs.getInt("USE_ORDER"));
model.setReferPid(rs.getInt("REFER_PID"));
model.setCount(rs.getInt("COUNT"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((SubsetSingleDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubsetSingleDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SubsetSingleDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubsetSingleDefns) model).setSubsetSingleDefnPid(rs.getInt("SUBSET_SINGLE_DEFN_PID"));
((SubsetSingleDefns) model).setSubsetPid(rs.getInt("SUBSET_PID"));
((SubsetSingleDefns) model).setUseOrder(rs.getInt("USE_ORDER"));
((SubsetSingleDefns) model).setReferPid(rs.getInt("REFER_PID"));
((SubsetSingleDefns) model).setCount(rs.getInt("COUNT"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((SubsetSingleDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubsetSingleDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SubsetSingleDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubsetSingleDefns) model).setSubsetSingleDefnPid(rs.getInt("SUBSET_SINGLE_DEFN_PID"));
((SubsetSingleDefns) model).setSubsetPid(rs.getInt("SUBSET_PID"));
((SubsetSingleDefns) model).setUseOrder(rs.getInt("USE_ORDER"));
((SubsetSingleDefns) model).setReferPid(rs.getInt("REFER_PID"));
((SubsetSingleDefns) model).setCount(rs.getInt("COUNT"));
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

public int getSubsetSingleDefnPid() {
return this.SubsetSingleDefnPid;
}

public int getSubsetPid() {
return this.SubsetPid;
}

public int getUseOrder() {
return this.UseOrder;
}

public int getReferPid() {
return this.ReferPid;
}

public int getCount() {
return this.Count;
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

public void setSubsetSingleDefnPid(int SubsetSingleDefnPid) {
this.SubsetSingleDefnPid = SubsetSingleDefnPid;
}

public void setSubsetPid(int SubsetPid) {
this.SubsetPid = SubsetPid;
}

public void setUseOrder(int UseOrder) {
this.UseOrder = UseOrder;
}

public void setReferPid(int ReferPid) {
this.ReferPid = ReferPid;
}

public void setCount(int Count) {
this.Count = Count;
}

}

