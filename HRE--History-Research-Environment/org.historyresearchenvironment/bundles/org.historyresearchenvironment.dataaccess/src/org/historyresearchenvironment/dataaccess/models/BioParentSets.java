package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the BIO_PARENT_SETS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class BioParentSets extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"BIO_PARENT_SET_PID, " +
"IS_SYSTEM, " +
"VISIBLE_ID, " +
"BIO_SUB_TYPE_KEY, " +
"OCCASN_SUB_TYPE_KEY, " +
"OCCASN_PID, " +
"SPERM_PROVIDER_PID, " +
"EGG_PROVIDER_PID, " +
"MITO_PROVIDER_PID, " +
"UTERUS_PROVIDER_PID, " +
"SOCIAL_PARENT1_PID, " +
"SOCIAL_PARENT2_PID FROM PUBLIC.BIO_PARENT_SETS WHERE BIO_PARENT_SET_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"BIO_PARENT_SET_PID, " +  
"IS_SYSTEM, " +  
"VISIBLE_ID, " +  
"BIO_SUB_TYPE_KEY, " +  
"OCCASN_SUB_TYPE_KEY, " +  
"OCCASN_PID, " +  
"SPERM_PROVIDER_PID, " +  
"EGG_PROVIDER_PID, " +  
"MITO_PROVIDER_PID, " +  
"UTERUS_PROVIDER_PID, " +  
"SOCIAL_PARENT1_PID, " +  
"SOCIAL_PARENT2_PID FROM PUBLIC.BIO_PARENT_SETS";

private static final String INSERT = "INSERT INTO PUBLIC.BIO_PARENT_SETS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"BIO_PARENT_SET_PID, " +     
"IS_SYSTEM, " +     
"VISIBLE_ID, " +     
"BIO_SUB_TYPE_KEY, " +     
"OCCASN_SUB_TYPE_KEY, " +     
"OCCASN_PID, " +     
"SPERM_PROVIDER_PID, " +     
"EGG_PROVIDER_PID, " +     
"MITO_PROVIDER_PID, " +     
"UTERUS_PROVIDER_PID, " +     
"SOCIAL_PARENT1_PID, " +     
"SOCIAL_PARENT2_PID) VALUES (?, " +
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
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.BIO_PARENT_SETSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"VISIBLE_ID = ?, " + 
"BIO_SUB_TYPE_KEY = ?, " + 
"OCCASN_SUB_TYPE_KEY = ?, " + 
"OCCASN_PID = ?, " + 
"SPERM_PROVIDER_PID = ?, " + 
"EGG_PROVIDER_PID = ?, " + 
"MITO_PROVIDER_PID = ?, " + 
"UTERUS_PROVIDER_PID = ?, " + 
"SOCIAL_PARENT1_PID = ?, " + 
"SOCIAL_PARENT2_PID = ? WHERE BIO_PARENT_SET_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.BIO_PARENT_SETS WHERE BIO_PARENT_SET_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.BIO_PARENT_SETS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int BioParentSetPid;
private boolean IsSystem;
private int VisibleId;
private short BioSubTypeKey;
private short OccasnSubTypeKey;
private int OccasnPid;
private int SpermProviderPid;
private int EggProviderPid;
private int MitoProviderPid;
private int UterusProviderPid;
private int SocialParent1Pid;
private int SocialParent2Pid;
private BioParentSets model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public BioParentSets() throws SQLException {
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
model = new BioParentSets();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setBioParentSetPid(rs.getInt("BIO_PARENT_SET_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setVisibleId(rs.getInt("VISIBLE_ID"));
model.setBioSubTypeKey(rs.getShort("BIO_SUB_TYPE_KEY"));
model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
model.setOccasnPid(rs.getInt("OCCASN_PID"));
model.setSpermProviderPid(rs.getInt("SPERM_PROVIDER_PID"));
model.setEggProviderPid(rs.getInt("EGG_PROVIDER_PID"));
model.setMitoProviderPid(rs.getInt("MITO_PROVIDER_PID"));
model.setUterusProviderPid(rs.getInt("UTERUS_PROVIDER_PID"));
model.setSocialParent1Pid(rs.getInt("SOCIAL_PARENT1_PID"));
model.setSocialParent2Pid(rs.getInt("SOCIAL_PARENT2_PID"));
modelList.add(model);
}
return modelList;
}

@Override
public BioParentSets get(int key) throws SQLException {
model = new BioParentSets();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setBioParentSetPid(rs.getInt("BIO_PARENT_SET_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setVisibleId(rs.getInt("VISIBLE_ID"));
model.setBioSubTypeKey(rs.getShort("BIO_SUB_TYPE_KEY"));
model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
model.setOccasnPid(rs.getInt("OCCASN_PID"));
model.setSpermProviderPid(rs.getInt("SPERM_PROVIDER_PID"));
model.setEggProviderPid(rs.getInt("EGG_PROVIDER_PID"));
model.setMitoProviderPid(rs.getInt("MITO_PROVIDER_PID"));
model.setUterusProviderPid(rs.getInt("UTERUS_PROVIDER_PID"));
model.setSocialParent1Pid(rs.getInt("SOCIAL_PARENT1_PID"));
model.setSocialParent2Pid(rs.getInt("SOCIAL_PARENT2_PID"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((BioParentSets) model).setRecordNum(rs.getInt("RECORD_NUM"));
((BioParentSets) model).setSetKey(rs.getShort("SET_KEY"));
((BioParentSets) model).setCommitPid(rs.getInt("COMMIT_PID"));
((BioParentSets) model).setBioParentSetPid(rs.getInt("BIO_PARENT_SET_PID"));
((BioParentSets) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((BioParentSets) model).setVisibleId(rs.getInt("VISIBLE_ID"));
((BioParentSets) model).setBioSubTypeKey(rs.getShort("BIO_SUB_TYPE_KEY"));
((BioParentSets) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
((BioParentSets) model).setOccasnPid(rs.getInt("OCCASN_PID"));
((BioParentSets) model).setSpermProviderPid(rs.getInt("SPERM_PROVIDER_PID"));
((BioParentSets) model).setEggProviderPid(rs.getInt("EGG_PROVIDER_PID"));
((BioParentSets) model).setMitoProviderPid(rs.getInt("MITO_PROVIDER_PID"));
((BioParentSets) model).setUterusProviderPid(rs.getInt("UTERUS_PROVIDER_PID"));
((BioParentSets) model).setSocialParent1Pid(rs.getInt("SOCIAL_PARENT1_PID"));
((BioParentSets) model).setSocialParent2Pid(rs.getInt("SOCIAL_PARENT2_PID"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((BioParentSets) model).setRecordNum(rs.getInt("RECORD_NUM"));
((BioParentSets) model).setSetKey(rs.getShort("SET_KEY"));
((BioParentSets) model).setCommitPid(rs.getInt("COMMIT_PID"));
((BioParentSets) model).setBioParentSetPid(rs.getInt("BIO_PARENT_SET_PID"));
((BioParentSets) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((BioParentSets) model).setVisibleId(rs.getInt("VISIBLE_ID"));
((BioParentSets) model).setBioSubTypeKey(rs.getShort("BIO_SUB_TYPE_KEY"));
((BioParentSets) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
((BioParentSets) model).setOccasnPid(rs.getInt("OCCASN_PID"));
((BioParentSets) model).setSpermProviderPid(rs.getInt("SPERM_PROVIDER_PID"));
((BioParentSets) model).setEggProviderPid(rs.getInt("EGG_PROVIDER_PID"));
((BioParentSets) model).setMitoProviderPid(rs.getInt("MITO_PROVIDER_PID"));
((BioParentSets) model).setUterusProviderPid(rs.getInt("UTERUS_PROVIDER_PID"));
((BioParentSets) model).setSocialParent1Pid(rs.getInt("SOCIAL_PARENT1_PID"));
((BioParentSets) model).setSocialParent2Pid(rs.getInt("SOCIAL_PARENT2_PID"));
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
* Get the BioParentSetPid field.
*
* @return Contents of the BIO_PARENT_SET_PID column
*/
public int getBioParentSetPid() {
return this.BioParentSetPid;
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
* Get the BioSubTypeKey field.
*
* @return Contents of the BIO_SUB_TYPE_KEY column
*/
public short getBioSubTypeKey() {
return this.BioSubTypeKey;
}

/**
* Get the OccasnSubTypeKey field.
*
* @return Contents of the OCCASN_SUB_TYPE_KEY column
*/
public short getOccasnSubTypeKey() {
return this.OccasnSubTypeKey;
}

/**
* Get the OccasnPid field.
*
* @return Contents of the OCCASN_PID column
*/
public int getOccasnPid() {
return this.OccasnPid;
}

/**
* Get the SpermProviderPid field.
*
* @return Contents of the SPERM_PROVIDER_PID column
*/
public int getSpermProviderPid() {
return this.SpermProviderPid;
}

/**
* Get the EggProviderPid field.
*
* @return Contents of the EGG_PROVIDER_PID column
*/
public int getEggProviderPid() {
return this.EggProviderPid;
}

/**
* Get the MitoProviderPid field.
*
* @return Contents of the MITO_PROVIDER_PID column
*/
public int getMitoProviderPid() {
return this.MitoProviderPid;
}

/**
* Get the UterusProviderPid field.
*
* @return Contents of the UTERUS_PROVIDER_PID column
*/
public int getUterusProviderPid() {
return this.UterusProviderPid;
}

/**
* Get the SocialParent1Pid field.
*
* @return Contents of the SOCIAL_PARENT1_PID column
*/
public int getSocialParent1Pid() {
return this.SocialParent1Pid;
}

/**
* Get the SocialParent2Pid field.
*
* @return Contents of the SOCIAL_PARENT2_PID column
*/
public int getSocialParent2Pid() {
return this.SocialParent2Pid;
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
* Set the BioParentSetPid field
*
* @param BioParentSetPid Contents of the BIO_PARENT_SET_PID column
*/
public void setBioParentSetPid(int BioParentSetPid) {
this.BioParentSetPid = BioParentSetPid;
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
* Set the BioSubTypeKey field
*
* @param BioSubTypeKey Contents of the BIO_SUB_TYPE_KEY column
*/
public void setBioSubTypeKey(short BioSubTypeKey) {
this.BioSubTypeKey = BioSubTypeKey;
}

/**
* Set the OccasnSubTypeKey field
*
* @param OccasnSubTypeKey Contents of the OCCASN_SUB_TYPE_KEY column
*/
public void setOccasnSubTypeKey(short OccasnSubTypeKey) {
this.OccasnSubTypeKey = OccasnSubTypeKey;
}

/**
* Set the OccasnPid field
*
* @param OccasnPid Contents of the OCCASN_PID column
*/
public void setOccasnPid(int OccasnPid) {
this.OccasnPid = OccasnPid;
}

/**
* Set the SpermProviderPid field
*
* @param SpermProviderPid Contents of the SPERM_PROVIDER_PID column
*/
public void setSpermProviderPid(int SpermProviderPid) {
this.SpermProviderPid = SpermProviderPid;
}

/**
* Set the EggProviderPid field
*
* @param EggProviderPid Contents of the EGG_PROVIDER_PID column
*/
public void setEggProviderPid(int EggProviderPid) {
this.EggProviderPid = EggProviderPid;
}

/**
* Set the MitoProviderPid field
*
* @param MitoProviderPid Contents of the MITO_PROVIDER_PID column
*/
public void setMitoProviderPid(int MitoProviderPid) {
this.MitoProviderPid = MitoProviderPid;
}

/**
* Set the UterusProviderPid field
*
* @param UterusProviderPid Contents of the UTERUS_PROVIDER_PID column
*/
public void setUterusProviderPid(int UterusProviderPid) {
this.UterusProviderPid = UterusProviderPid;
}

/**
* Set the SocialParent1Pid field
*
* @param SocialParent1Pid Contents of the SOCIAL_PARENT1_PID column
*/
public void setSocialParent1Pid(int SocialParent1Pid) {
this.SocialParent1Pid = SocialParent1Pid;
}

/**
* Set the SocialParent2Pid field
*
* @param SocialParent2Pid Contents of the SOCIAL_PARENT2_PID column
*/
public void setSocialParent2Pid(int SocialParent2Pid) {
this.SocialParent2Pid = SocialParent2Pid;
}

}

