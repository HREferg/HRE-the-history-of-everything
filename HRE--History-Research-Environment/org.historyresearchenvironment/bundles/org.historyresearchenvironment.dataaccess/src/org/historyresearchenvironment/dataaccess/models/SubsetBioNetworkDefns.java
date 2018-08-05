package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSET_BIO_NETWORK_DEFNS database table.
*
* @version 2018-08-05
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

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public SubsetBioNetworkDefns() throws SQLException {
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
public SubsetBioNetworkDefns get(int key) throws SQLException {
model = new SubsetBioNetworkDefns();
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
return model;
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
* Get the SubsetBioNetworkDefnPid field.
*
* @return Contents of the SUBSET_BIO_NETWORK_DEFN_PID column
*/
public int getSubsetBioNetworkDefnPid() {
return this.SubsetBioNetworkDefnPid;
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
* Get the BioPid field.
*
* @return Contents of the BIO_PID column
*/
public int getBioPid() {
return this.BioPid;
}

/**
* Get the ParentSetPid field.
*
* @return Contents of the PARENT_SET_PID column
*/
public int getParentSetPid() {
return this.ParentSetPid;
}

/**
* Get the ThisGeneration field.
*
* @return Contents of the THIS_GENERATION column
*/
public short getThisGeneration() {
return this.ThisGeneration;
}

/**
* Get the MinGeneration field.
*
* @return Contents of the MIN_GENERATION column
*/
public short getMinGeneration() {
return this.MinGeneration;
}

/**
* Get the IsAncestralLink field.
*
* @return Contents of the IS_ANCESTRAL_LINK column
*/
public boolean getIsAncestralLink() {
return this.IsAncestralLink;
}

/**
* Get the IsViaFemaleAncestor field.
*
* @return Contents of the IS_VIA_FEMALE_ANCESTOR column
*/
public boolean getIsViaFemaleAncestor() {
return this.IsViaFemaleAncestor;
}

/**
* Get the KinCode field.
*
* @return Contents of the KIN_CODE column
*/
public short getKinCode() {
return this.KinCode;
}

/**
* Get the CommonParentSetPid field.
*
* @return Contents of the COMMON_PARENT_SET_PID column
*/
public int getCommonParentSetPid() {
return this.CommonParentSetPid;
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
* Set the SubsetBioNetworkDefnPid field
*
* @param SubsetBioNetworkDefnPid Contents of the SUBSET_BIO_NETWORK_DEFN_PID column
*/
public void setSubsetBioNetworkDefnPid(int SubsetBioNetworkDefnPid) {
this.SubsetBioNetworkDefnPid = SubsetBioNetworkDefnPid;
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
* Set the BioPid field
*
* @param BioPid Contents of the BIO_PID column
*/
public void setBioPid(int BioPid) {
this.BioPid = BioPid;
}

/**
* Set the ParentSetPid field
*
* @param ParentSetPid Contents of the PARENT_SET_PID column
*/
public void setParentSetPid(int ParentSetPid) {
this.ParentSetPid = ParentSetPid;
}

/**
* Set the ThisGeneration field
*
* @param ThisGeneration Contents of the THIS_GENERATION column
*/
public void setThisGeneration(short ThisGeneration) {
this.ThisGeneration = ThisGeneration;
}

/**
* Set the MinGeneration field
*
* @param MinGeneration Contents of the MIN_GENERATION column
*/
public void setMinGeneration(short MinGeneration) {
this.MinGeneration = MinGeneration;
}

/**
* Set the IsAncestralLink field
*
* @param IsAncestralLink Contents of the IS_ANCESTRAL_LINK column
*/
public void setIsAncestralLink(boolean IsAncestralLink) {
this.IsAncestralLink = IsAncestralLink;
}

/**
* Set the IsViaFemaleAncestor field
*
* @param IsViaFemaleAncestor Contents of the IS_VIA_FEMALE_ANCESTOR column
*/
public void setIsViaFemaleAncestor(boolean IsViaFemaleAncestor) {
this.IsViaFemaleAncestor = IsViaFemaleAncestor;
}

/**
* Set the KinCode field
*
* @param KinCode Contents of the KIN_CODE column
*/
public void setKinCode(short KinCode) {
this.KinCode = KinCode;
}

/**
* Set the CommonParentSetPid field
*
* @param CommonParentSetPid Contents of the COMMON_PARENT_SET_PID column
*/
public void setCommonParentSetPid(int CommonParentSetPid) {
this.CommonParentSetPid = CommonParentSetPid;
}

}

