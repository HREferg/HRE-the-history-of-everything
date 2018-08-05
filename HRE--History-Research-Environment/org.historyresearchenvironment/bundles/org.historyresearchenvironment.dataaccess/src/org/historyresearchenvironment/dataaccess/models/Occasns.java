package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the OCCASNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class Occasns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"OCCASN_PID, " +
"IS_SYSTEM, " +
"TAG_TYPE_KEY, " +
"THEME_VISIBLE_ID, " +
"PARENT_PID, " +
"PARENT_SUB_TYPE_KEY, " +
"THEME_KEY, " +
"LOCAL_SENTCE_SET_PID, " +
"BEST_NAME_PID, " +
"BEST_IMAGE_PID, " +
"SURETY, " +
"SENTCE_TYPE_KEY, " +
"SENTCE_STYLE_KEY, " +
"BIO_PARENT_SET_PID, " +
"MEMO_SET_PID, " +
"FLAGS FROM PUBLIC.OCCASNS WHERE OCCASN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"OCCASN_PID, " +  
"IS_SYSTEM, " +  
"TAG_TYPE_KEY, " +  
"THEME_VISIBLE_ID, " +  
"PARENT_PID, " +  
"PARENT_SUB_TYPE_KEY, " +  
"THEME_KEY, " +  
"LOCAL_SENTCE_SET_PID, " +  
"BEST_NAME_PID, " +  
"BEST_IMAGE_PID, " +  
"SURETY, " +  
"SENTCE_TYPE_KEY, " +  
"SENTCE_STYLE_KEY, " +  
"BIO_PARENT_SET_PID, " +  
"MEMO_SET_PID, " +  
"FLAGS FROM PUBLIC.OCCASNS";

private static final String INSERT = "INSERT INTO PUBLIC.OCCASNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"OCCASN_PID, " +     
"IS_SYSTEM, " +     
"TAG_TYPE_KEY, " +     
"THEME_VISIBLE_ID, " +     
"PARENT_PID, " +     
"PARENT_SUB_TYPE_KEY, " +     
"THEME_KEY, " +     
"LOCAL_SENTCE_SET_PID, " +     
"BEST_NAME_PID, " +     
"BEST_IMAGE_PID, " +     
"SURETY, " +     
"SENTCE_TYPE_KEY, " +     
"SENTCE_STYLE_KEY, " +     
"BIO_PARENT_SET_PID, " +     
"MEMO_SET_PID, " +     
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
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.OCCASNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"TAG_TYPE_KEY = ?, " + 
"THEME_VISIBLE_ID = ?, " + 
"PARENT_PID = ?, " + 
"PARENT_SUB_TYPE_KEY = ?, " + 
"THEME_KEY = ?, " + 
"LOCAL_SENTCE_SET_PID = ?, " + 
"BEST_NAME_PID = ?, " + 
"BEST_IMAGE_PID = ?, " + 
"SURETY = ?, " + 
"SENTCE_TYPE_KEY = ?, " + 
"SENTCE_STYLE_KEY = ?, " + 
"BIO_PARENT_SET_PID = ?, " + 
"MEMO_SET_PID = ?, " + 
"FLAGS = ? WHERE OCCASN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.OCCASNS WHERE OCCASN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int OccasnPid;
private boolean IsSystem;
private short TagTypeKey;
private int ThemeVisibleId;
private int ParentPid;
private short ParentSubTypeKey;
private short ThemeKey;
private int LocalSentceSetPid;
private int BestNamePid;
private int BestImagePid;
private String Surety;
private short SentceTypeKey;
private short SentceStyleKey;
private int BioParentSetPid;
private int MemoSetPid;
private byte[] Flags;
private Occasns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public Occasns() throws SQLException {
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
model = new Occasns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOccasnPid(rs.getInt("OCCASN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setTagTypeKey(rs.getShort("TAG_TYPE_KEY"));
model.setThemeVisibleId(rs.getInt("THEME_VISIBLE_ID"));
model.setParentPid(rs.getInt("PARENT_PID"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setThemeKey(rs.getShort("THEME_KEY"));
model.setLocalSentceSetPid(rs.getInt("LOCAL_SENTCE_SET_PID"));
model.setBestNamePid(rs.getInt("BEST_NAME_PID"));
model.setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
model.setSurety(rs.getString("SURETY"));
model.setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
model.setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
model.setBioParentSetPid(rs.getInt("BIO_PARENT_SET_PID"));
model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
model.setFlags(rs.getBytes("FLAGS"));
modelList.add(model);
}
return modelList;
}

@Override
public Occasns get(int key) throws SQLException {
model = new Occasns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOccasnPid(rs.getInt("OCCASN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setTagTypeKey(rs.getShort("TAG_TYPE_KEY"));
model.setThemeVisibleId(rs.getInt("THEME_VISIBLE_ID"));
model.setParentPid(rs.getInt("PARENT_PID"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setThemeKey(rs.getShort("THEME_KEY"));
model.setLocalSentceSetPid(rs.getInt("LOCAL_SENTCE_SET_PID"));
model.setBestNamePid(rs.getInt("BEST_NAME_PID"));
model.setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
model.setSurety(rs.getString("SURETY"));
model.setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
model.setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
model.setBioParentSetPid(rs.getInt("BIO_PARENT_SET_PID"));
model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
model.setFlags(rs.getBytes("FLAGS"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((Occasns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((Occasns) model).setSetKey(rs.getShort("SET_KEY"));
((Occasns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((Occasns) model).setOccasnPid(rs.getInt("OCCASN_PID"));
((Occasns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((Occasns) model).setTagTypeKey(rs.getShort("TAG_TYPE_KEY"));
((Occasns) model).setThemeVisibleId(rs.getInt("THEME_VISIBLE_ID"));
((Occasns) model).setParentPid(rs.getInt("PARENT_PID"));
((Occasns) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((Occasns) model).setThemeKey(rs.getShort("THEME_KEY"));
((Occasns) model).setLocalSentceSetPid(rs.getInt("LOCAL_SENTCE_SET_PID"));
((Occasns) model).setBestNamePid(rs.getInt("BEST_NAME_PID"));
((Occasns) model).setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
((Occasns) model).setSurety(rs.getString("SURETY"));
((Occasns) model).setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
((Occasns) model).setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
((Occasns) model).setBioParentSetPid(rs.getInt("BIO_PARENT_SET_PID"));
((Occasns) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
((Occasns) model).setFlags(rs.getBytes("FLAGS"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((Occasns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((Occasns) model).setSetKey(rs.getShort("SET_KEY"));
((Occasns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((Occasns) model).setOccasnPid(rs.getInt("OCCASN_PID"));
((Occasns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((Occasns) model).setTagTypeKey(rs.getShort("TAG_TYPE_KEY"));
((Occasns) model).setThemeVisibleId(rs.getInt("THEME_VISIBLE_ID"));
((Occasns) model).setParentPid(rs.getInt("PARENT_PID"));
((Occasns) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((Occasns) model).setThemeKey(rs.getShort("THEME_KEY"));
((Occasns) model).setLocalSentceSetPid(rs.getInt("LOCAL_SENTCE_SET_PID"));
((Occasns) model).setBestNamePid(rs.getInt("BEST_NAME_PID"));
((Occasns) model).setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
((Occasns) model).setSurety(rs.getString("SURETY"));
((Occasns) model).setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
((Occasns) model).setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
((Occasns) model).setBioParentSetPid(rs.getInt("BIO_PARENT_SET_PID"));
((Occasns) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
((Occasns) model).setFlags(rs.getBytes("FLAGS"));
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
* Get the OccasnPid field.
*
* @return Contents of the OCCASN_PID column
*/
public int getOccasnPid() {
return this.OccasnPid;
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
* Get the TagTypeKey field.
*
* @return Contents of the TAG_TYPE_KEY column
*/
public short getTagTypeKey() {
return this.TagTypeKey;
}

/**
* Get the ThemeVisibleId field.
*
* @return Contents of the THEME_VISIBLE_ID column
*/
public int getThemeVisibleId() {
return this.ThemeVisibleId;
}

/**
* Get the ParentPid field.
*
* @return Contents of the PARENT_PID column
*/
public int getParentPid() {
return this.ParentPid;
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
* Get the ThemeKey field.
*
* @return Contents of the THEME_KEY column
*/
public short getThemeKey() {
return this.ThemeKey;
}

/**
* Get the LocalSentceSetPid field.
*
* @return Contents of the LOCAL_SENTCE_SET_PID column
*/
public int getLocalSentceSetPid() {
return this.LocalSentceSetPid;
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
* Get the SentceTypeKey field.
*
* @return Contents of the SENTCE_TYPE_KEY column
*/
public short getSentceTypeKey() {
return this.SentceTypeKey;
}

/**
* Get the SentceStyleKey field.
*
* @return Contents of the SENTCE_STYLE_KEY column
*/
public short getSentceStyleKey() {
return this.SentceStyleKey;
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
* Get the MemoSetPid field.
*
* @return Contents of the MEMO_SET_PID column
*/
public int getMemoSetPid() {
return this.MemoSetPid;
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
* Set the OccasnPid field
*
* @param OccasnPid Contents of the OCCASN_PID column
*/
public void setOccasnPid(int OccasnPid) {
this.OccasnPid = OccasnPid;
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
* Set the TagTypeKey field
*
* @param TagTypeKey Contents of the TAG_TYPE_KEY column
*/
public void setTagTypeKey(short TagTypeKey) {
this.TagTypeKey = TagTypeKey;
}

/**
* Set the ThemeVisibleId field
*
* @param ThemeVisibleId Contents of the THEME_VISIBLE_ID column
*/
public void setThemeVisibleId(int ThemeVisibleId) {
this.ThemeVisibleId = ThemeVisibleId;
}

/**
* Set the ParentPid field
*
* @param ParentPid Contents of the PARENT_PID column
*/
public void setParentPid(int ParentPid) {
this.ParentPid = ParentPid;
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
* Set the ThemeKey field
*
* @param ThemeKey Contents of the THEME_KEY column
*/
public void setThemeKey(short ThemeKey) {
this.ThemeKey = ThemeKey;
}

/**
* Set the LocalSentceSetPid field
*
* @param LocalSentceSetPid Contents of the LOCAL_SENTCE_SET_PID column
*/
public void setLocalSentceSetPid(int LocalSentceSetPid) {
this.LocalSentceSetPid = LocalSentceSetPid;
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
* Set the SentceTypeKey field
*
* @param SentceTypeKey Contents of the SENTCE_TYPE_KEY column
*/
public void setSentceTypeKey(short SentceTypeKey) {
this.SentceTypeKey = SentceTypeKey;
}

/**
* Set the SentceStyleKey field
*
* @param SentceStyleKey Contents of the SENTCE_STYLE_KEY column
*/
public void setSentceStyleKey(short SentceStyleKey) {
this.SentceStyleKey = SentceStyleKey;
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
* Set the MemoSetPid field
*
* @param MemoSetPid Contents of the MEMO_SET_PID column
*/
public void setMemoSetPid(int MemoSetPid) {
this.MemoSetPid = MemoSetPid;
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

