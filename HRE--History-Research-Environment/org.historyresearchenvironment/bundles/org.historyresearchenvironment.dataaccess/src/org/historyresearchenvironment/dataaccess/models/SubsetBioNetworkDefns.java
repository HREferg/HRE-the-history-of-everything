package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSET_BIO_NETWORK_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SubsetBioNetworkDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SUBSET_BIO_NETWORK_DEFN_PID, " +
"SUBSET_PID, " +
"USE_ORDER, " +
"BIO_PID, " +
"PARENT_SET_PID, " +
"THIS_GENERATION, " +
"MIN_GENERATION, " +
"IS_ANCESTRAL_LINK, " +
"IS_VIA_FEMALE_ANCESTOR, " +
"KIN_CODE, " +
"COMMON_PARENT_SET_PID FROM PUBLIC.SUBSET_BIO_NETWORK_DEFNS WHERE SUBSET_BIO_NETWORK_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SUBSET_BIO_NETWORK_DEFN_PID, " +  
"SUBSET_PID, " +  
"USE_ORDER, " +  
"BIO_PID, " +  
"PARENT_SET_PID, " +  
"THIS_GENERATION, " +  
"MIN_GENERATION, " +  
"IS_ANCESTRAL_LINK, " +  
"IS_VIA_FEMALE_ANCESTOR, " +  
"KIN_CODE, " +  
"COMMON_PARENT_SET_PID FROM PUBLIC.SUBSET_BIO_NETWORK_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.SUBSET_BIO_NETWORK_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SUBSET_BIO_NETWORK_DEFN_PID, " +     
"SUBSET_PID, " +     
"USE_ORDER, " +     
"BIO_PID, " +     
"PARENT_SET_PID, " +     
"THIS_GENERATION, " +     
"MIN_GENERATION, " +     
"IS_ANCESTRAL_LINK, " +     
"IS_VIA_FEMALE_ANCESTOR, " +     
"KIN_CODE, " +     
"COMMON_PARENT_SET_PID) VALUES (?, " +
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
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SUBSET_BIO_NETWORK_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"SUBSET_PID = ?, " + 
"USE_ORDER = ?, " + 
"BIO_PID = ?, " + 
"PARENT_SET_PID = ?, " + 
"THIS_GENERATION = ?, " + 
"MIN_GENERATION = ?, " + 
"IS_ANCESTRAL_LINK = ?, " + 
"IS_VIA_FEMALE_ANCESTOR = ?, " + 
"KIN_CODE = ?, " + 
"COMMON_PARENT_SET_PID = ? WHERE SUBSET_BIO_NETWORK_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SUBSET_BIO_NETWORK_DEFNS WHERE SUBSET_BIO_NETWORK_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSET_BIO_NETWORK_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SubsetBioNetworkDefnPid;
private int SubsetPid;
private int UseOrder;
private int BioPid;
private int ParentSetPid;
private short ThisGeneration;
private short MinGeneration;
private boolean IsAncestralLink;
private boolean IsViaFemaleAncestor;
private short KinCode;
private int CommonParentSetPid;
private SubsetBioNetworkDefns model;

public SubsetBioNetworkDefns() throws SQLException {
}


public SubsetBioNetworkDefns(int SubsetBioNetworkDefnPid) throws SQLException {
super();
this.SubsetBioNetworkDefnPid = SubsetBioNetworkDefnPid;
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
model = new SubsetBioNetworkDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSubsetBioNetworkDefnPid(rs.getInt("SUBSET_BIO_NETWORK_DEFN_PID"));
model.setSubsetPid(rs.getInt("SUBSET_PID"));
model.setUseOrder(rs.getInt("USE_ORDER"));
model.setBioPid(rs.getInt("BIO_PID"));
model.setParentSetPid(rs.getInt("PARENT_SET_PID"));
model.setThisGeneration(rs.getShort("THIS_GENERATION"));
model.setMinGeneration(rs.getShort("MIN_GENERATION"));
model.setIsAncestralLink(rs.getBoolean("IS_ANCESTRAL_LINK"));
model.setIsViaFemaleAncestor(rs.getBoolean("IS_VIA_FEMALE_ANCESTOR"));
model.setKinCode(rs.getShort("KIN_CODE"));
model.setCommonParentSetPid(rs.getInt("COMMON_PARENT_SET_PID"));
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
model.setSubsetBioNetworkDefnPid(rs.getInt("SUBSET_BIO_NETWORK_DEFN_PID"));
model.setSubsetPid(rs.getInt("SUBSET_PID"));
model.setUseOrder(rs.getInt("USE_ORDER"));
model.setBioPid(rs.getInt("BIO_PID"));
model.setParentSetPid(rs.getInt("PARENT_SET_PID"));
model.setThisGeneration(rs.getShort("THIS_GENERATION"));
model.setMinGeneration(rs.getShort("MIN_GENERATION"));
model.setIsAncestralLink(rs.getBoolean("IS_ANCESTRAL_LINK"));
model.setIsViaFemaleAncestor(rs.getBoolean("IS_VIA_FEMALE_ANCESTOR"));
model.setKinCode(rs.getShort("KIN_CODE"));
model.setCommonParentSetPid(rs.getInt("COMMON_PARENT_SET_PID"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((SubsetBioNetworkDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubsetBioNetworkDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SubsetBioNetworkDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubsetBioNetworkDefns) model).setSubsetBioNetworkDefnPid(rs.getInt("SUBSET_BIO_NETWORK_DEFN_PID"));
((SubsetBioNetworkDefns) model).setSubsetPid(rs.getInt("SUBSET_PID"));
((SubsetBioNetworkDefns) model).setUseOrder(rs.getInt("USE_ORDER"));
((SubsetBioNetworkDefns) model).setBioPid(rs.getInt("BIO_PID"));
((SubsetBioNetworkDefns) model).setParentSetPid(rs.getInt("PARENT_SET_PID"));
((SubsetBioNetworkDefns) model).setThisGeneration(rs.getShort("THIS_GENERATION"));
((SubsetBioNetworkDefns) model).setMinGeneration(rs.getShort("MIN_GENERATION"));
((SubsetBioNetworkDefns) model).setIsAncestralLink(rs.getBoolean("IS_ANCESTRAL_LINK"));
((SubsetBioNetworkDefns) model).setIsViaFemaleAncestor(rs.getBoolean("IS_VIA_FEMALE_ANCESTOR"));
((SubsetBioNetworkDefns) model).setKinCode(rs.getShort("KIN_CODE"));
((SubsetBioNetworkDefns) model).setCommonParentSetPid(rs.getInt("COMMON_PARENT_SET_PID"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((SubsetBioNetworkDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubsetBioNetworkDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SubsetBioNetworkDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubsetBioNetworkDefns) model).setSubsetBioNetworkDefnPid(rs.getInt("SUBSET_BIO_NETWORK_DEFN_PID"));
((SubsetBioNetworkDefns) model).setSubsetPid(rs.getInt("SUBSET_PID"));
((SubsetBioNetworkDefns) model).setUseOrder(rs.getInt("USE_ORDER"));
((SubsetBioNetworkDefns) model).setBioPid(rs.getInt("BIO_PID"));
((SubsetBioNetworkDefns) model).setParentSetPid(rs.getInt("PARENT_SET_PID"));
((SubsetBioNetworkDefns) model).setThisGeneration(rs.getShort("THIS_GENERATION"));
((SubsetBioNetworkDefns) model).setMinGeneration(rs.getShort("MIN_GENERATION"));
((SubsetBioNetworkDefns) model).setIsAncestralLink(rs.getBoolean("IS_ANCESTRAL_LINK"));
((SubsetBioNetworkDefns) model).setIsViaFemaleAncestor(rs.getBoolean("IS_VIA_FEMALE_ANCESTOR"));
((SubsetBioNetworkDefns) model).setKinCode(rs.getShort("KIN_CODE"));
((SubsetBioNetworkDefns) model).setCommonParentSetPid(rs.getInt("COMMON_PARENT_SET_PID"));
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

public int getSubsetBioNetworkDefnPid() {
return this.SubsetBioNetworkDefnPid;
}

public int getSubsetPid() {
return this.SubsetPid;
}

public int getUseOrder() {
return this.UseOrder;
}

public int getBioPid() {
return this.BioPid;
}

public int getParentSetPid() {
return this.ParentSetPid;
}

public short getThisGeneration() {
return this.ThisGeneration;
}

public short getMinGeneration() {
return this.MinGeneration;
}

public boolean getIsAncestralLink() {
return this.IsAncestralLink;
}

public boolean getIsViaFemaleAncestor() {
return this.IsViaFemaleAncestor;
}

public short getKinCode() {
return this.KinCode;
}

public int getCommonParentSetPid() {
return this.CommonParentSetPid;
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

public void setSubsetBioNetworkDefnPid(int SubsetBioNetworkDefnPid) {
this.SubsetBioNetworkDefnPid = SubsetBioNetworkDefnPid;
}

public void setSubsetPid(int SubsetPid) {
this.SubsetPid = SubsetPid;
}

public void setUseOrder(int UseOrder) {
this.UseOrder = UseOrder;
}

public void setBioPid(int BioPid) {
this.BioPid = BioPid;
}

public void setParentSetPid(int ParentSetPid) {
this.ParentSetPid = ParentSetPid;
}

public void setThisGeneration(short ThisGeneration) {
this.ThisGeneration = ThisGeneration;
}

public void setMinGeneration(short MinGeneration) {
this.MinGeneration = MinGeneration;
}

public void setIsAncestralLink(boolean IsAncestralLink) {
this.IsAncestralLink = IsAncestralLink;
}

public void setIsViaFemaleAncestor(boolean IsViaFemaleAncestor) {
this.IsViaFemaleAncestor = IsViaFemaleAncestor;
}

public void setKinCode(short KinCode) {
this.KinCode = KinCode;
}

public void setCommonParentSetPid(int CommonParentSetPid) {
this.CommonParentSetPid = CommonParentSetPid;
}

}

