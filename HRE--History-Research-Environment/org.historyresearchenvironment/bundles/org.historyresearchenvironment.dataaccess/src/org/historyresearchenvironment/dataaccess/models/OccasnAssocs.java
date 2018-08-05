package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the OCCASN_ASSOCS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class OccasnAssocs extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"OCCASN_ASSOC_PID, " +
"IS_SYSTEM, " +
"OCCASN_ASSOC_TAG_KEY, " +
"OCCASN_SUB_TYPE_KEY, " +
"OCCASN_PID, " +
"ASSOC_TYPE_KEY, " +
"ASSOC_SUB_TYPE_KEY, " +
"ASSOC_TYPE_PID, " +
"ASSOC_NAME_USED_PID, " +
"THEME_KEY, " +
"LOCAL_SENTCE_SET_PID, " +
"SENTCE_STYLE_KEY, " +
"MEMO_SET_PID, " +
"DISPLAY_ORDER, " +
"SHOW FROM PUBLIC.OCCASN_ASSOCS WHERE OCCASN_ASSOC_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"OCCASN_ASSOC_PID, " +  
"IS_SYSTEM, " +  
"OCCASN_ASSOC_TAG_KEY, " +  
"OCCASN_SUB_TYPE_KEY, " +  
"OCCASN_PID, " +  
"ASSOC_TYPE_KEY, " +  
"ASSOC_SUB_TYPE_KEY, " +  
"ASSOC_TYPE_PID, " +  
"ASSOC_NAME_USED_PID, " +  
"THEME_KEY, " +  
"LOCAL_SENTCE_SET_PID, " +  
"SENTCE_STYLE_KEY, " +  
"MEMO_SET_PID, " +  
"DISPLAY_ORDER, " +  
"SHOW FROM PUBLIC.OCCASN_ASSOCS";

private static final String INSERT = "INSERT INTO PUBLIC.OCCASN_ASSOCS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"OCCASN_ASSOC_PID, " +     
"IS_SYSTEM, " +     
"OCCASN_ASSOC_TAG_KEY, " +     
"OCCASN_SUB_TYPE_KEY, " +     
"OCCASN_PID, " +     
"ASSOC_TYPE_KEY, " +     
"ASSOC_SUB_TYPE_KEY, " +     
"ASSOC_TYPE_PID, " +     
"ASSOC_NAME_USED_PID, " +     
"THEME_KEY, " +     
"LOCAL_SENTCE_SET_PID, " +     
"SENTCE_STYLE_KEY, " +     
"MEMO_SET_PID, " +     
"DISPLAY_ORDER, " +     
"SHOW) VALUES (?, " +
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

private static final String UPDATE = "UPDATE PUBLIC.OCCASN_ASSOCSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"OCCASN_ASSOC_TAG_KEY = ?, " + 
"OCCASN_SUB_TYPE_KEY = ?, " + 
"OCCASN_PID = ?, " + 
"ASSOC_TYPE_KEY = ?, " + 
"ASSOC_SUB_TYPE_KEY = ?, " + 
"ASSOC_TYPE_PID = ?, " + 
"ASSOC_NAME_USED_PID = ?, " + 
"THEME_KEY = ?, " + 
"LOCAL_SENTCE_SET_PID = ?, " + 
"SENTCE_STYLE_KEY = ?, " + 
"MEMO_SET_PID = ?, " + 
"DISPLAY_ORDER = ?, " + 
"SHOW = ? WHERE OCCASN_ASSOC_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.OCCASN_ASSOCS WHERE OCCASN_ASSOC_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASN_ASSOCS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int OccasnAssocPid;
private boolean IsSystem;
private short OccasnAssocTagKey;
private short OccasnSubTypeKey;
private int OccasnPid;
private short AssocTypeKey;
private short AssocSubTypeKey;
private int AssocTypePid;
private int AssocNameUsedPid;
private int ThemeKey;
private int LocalSentceSetPid;
private short SentceStyleKey;
private int MemoSetPid;
private short DisplayOrder;
private boolean Show;
private OccasnAssocs model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public OccasnAssocs() throws SQLException {
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
model = new OccasnAssocs();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOccasnAssocPid(rs.getInt("OCCASN_ASSOC_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setOccasnAssocTagKey(rs.getShort("OCCASN_ASSOC_TAG_KEY"));
model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
model.setOccasnPid(rs.getInt("OCCASN_PID"));
model.setAssocTypeKey(rs.getShort("ASSOC_TYPE_KEY"));
model.setAssocSubTypeKey(rs.getShort("ASSOC_SUB_TYPE_KEY"));
model.setAssocTypePid(rs.getInt("ASSOC_TYPE_PID"));
model.setAssocNameUsedPid(rs.getInt("ASSOC_NAME_USED_PID"));
model.setThemeKey(rs.getInt("THEME_KEY"));
model.setLocalSentceSetPid(rs.getInt("LOCAL_SENTCE_SET_PID"));
model.setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public OccasnAssocs get(int key) throws SQLException {
model = new OccasnAssocs();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOccasnAssocPid(rs.getInt("OCCASN_ASSOC_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setOccasnAssocTagKey(rs.getShort("OCCASN_ASSOC_TAG_KEY"));
model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
model.setOccasnPid(rs.getInt("OCCASN_PID"));
model.setAssocTypeKey(rs.getShort("ASSOC_TYPE_KEY"));
model.setAssocSubTypeKey(rs.getShort("ASSOC_SUB_TYPE_KEY"));
model.setAssocTypePid(rs.getInt("ASSOC_TYPE_PID"));
model.setAssocNameUsedPid(rs.getInt("ASSOC_NAME_USED_PID"));
model.setThemeKey(rs.getInt("THEME_KEY"));
model.setLocalSentceSetPid(rs.getInt("LOCAL_SENTCE_SET_PID"));
model.setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setShow(rs.getBoolean("SHOW"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((OccasnAssocs) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OccasnAssocs) model).setSetKey(rs.getShort("SET_KEY"));
((OccasnAssocs) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OccasnAssocs) model).setOccasnAssocPid(rs.getInt("OCCASN_ASSOC_PID"));
((OccasnAssocs) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((OccasnAssocs) model).setOccasnAssocTagKey(rs.getShort("OCCASN_ASSOC_TAG_KEY"));
((OccasnAssocs) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
((OccasnAssocs) model).setOccasnPid(rs.getInt("OCCASN_PID"));
((OccasnAssocs) model).setAssocTypeKey(rs.getShort("ASSOC_TYPE_KEY"));
((OccasnAssocs) model).setAssocSubTypeKey(rs.getShort("ASSOC_SUB_TYPE_KEY"));
((OccasnAssocs) model).setAssocTypePid(rs.getInt("ASSOC_TYPE_PID"));
((OccasnAssocs) model).setAssocNameUsedPid(rs.getInt("ASSOC_NAME_USED_PID"));
((OccasnAssocs) model).setThemeKey(rs.getInt("THEME_KEY"));
((OccasnAssocs) model).setLocalSentceSetPid(rs.getInt("LOCAL_SENTCE_SET_PID"));
((OccasnAssocs) model).setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
((OccasnAssocs) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
((OccasnAssocs) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((OccasnAssocs) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((OccasnAssocs) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OccasnAssocs) model).setSetKey(rs.getShort("SET_KEY"));
((OccasnAssocs) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OccasnAssocs) model).setOccasnAssocPid(rs.getInt("OCCASN_ASSOC_PID"));
((OccasnAssocs) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((OccasnAssocs) model).setOccasnAssocTagKey(rs.getShort("OCCASN_ASSOC_TAG_KEY"));
((OccasnAssocs) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
((OccasnAssocs) model).setOccasnPid(rs.getInt("OCCASN_PID"));
((OccasnAssocs) model).setAssocTypeKey(rs.getShort("ASSOC_TYPE_KEY"));
((OccasnAssocs) model).setAssocSubTypeKey(rs.getShort("ASSOC_SUB_TYPE_KEY"));
((OccasnAssocs) model).setAssocTypePid(rs.getInt("ASSOC_TYPE_PID"));
((OccasnAssocs) model).setAssocNameUsedPid(rs.getInt("ASSOC_NAME_USED_PID"));
((OccasnAssocs) model).setThemeKey(rs.getInt("THEME_KEY"));
((OccasnAssocs) model).setLocalSentceSetPid(rs.getInt("LOCAL_SENTCE_SET_PID"));
((OccasnAssocs) model).setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
((OccasnAssocs) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
((OccasnAssocs) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((OccasnAssocs) model).setShow(rs.getBoolean("SHOW"));
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
* Get the OccasnAssocPid field.
*
* @return Contents of the OCCASN_ASSOC_PID column
*/
public int getOccasnAssocPid() {
return this.OccasnAssocPid;
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
* Get the OccasnAssocTagKey field.
*
* @return Contents of the OCCASN_ASSOC_TAG_KEY column
*/
public short getOccasnAssocTagKey() {
return this.OccasnAssocTagKey;
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
* Get the AssocTypeKey field.
*
* @return Contents of the ASSOC_TYPE_KEY column
*/
public short getAssocTypeKey() {
return this.AssocTypeKey;
}

/**
* Get the AssocSubTypeKey field.
*
* @return Contents of the ASSOC_SUB_TYPE_KEY column
*/
public short getAssocSubTypeKey() {
return this.AssocSubTypeKey;
}

/**
* Get the AssocTypePid field.
*
* @return Contents of the ASSOC_TYPE_PID column
*/
public int getAssocTypePid() {
return this.AssocTypePid;
}

/**
* Get the AssocNameUsedPid field.
*
* @return Contents of the ASSOC_NAME_USED_PID column
*/
public int getAssocNameUsedPid() {
return this.AssocNameUsedPid;
}

/**
* Get the ThemeKey field.
*
* @return Contents of the THEME_KEY column
*/
public int getThemeKey() {
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
* Get the SentceStyleKey field.
*
* @return Contents of the SENTCE_STYLE_KEY column
*/
public short getSentceStyleKey() {
return this.SentceStyleKey;
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
* Get the DisplayOrder field.
*
* @return Contents of the DISPLAY_ORDER column
*/
public short getDisplayOrder() {
return this.DisplayOrder;
}

/**
* Get the Show field.
*
* @return Contents of the SHOW column
*/
public boolean getShow() {
return this.Show;
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
* Set the OccasnAssocPid field
*
* @param OccasnAssocPid Contents of the OCCASN_ASSOC_PID column
*/
public void setOccasnAssocPid(int OccasnAssocPid) {
this.OccasnAssocPid = OccasnAssocPid;
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
* Set the OccasnAssocTagKey field
*
* @param OccasnAssocTagKey Contents of the OCCASN_ASSOC_TAG_KEY column
*/
public void setOccasnAssocTagKey(short OccasnAssocTagKey) {
this.OccasnAssocTagKey = OccasnAssocTagKey;
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
* Set the AssocTypeKey field
*
* @param AssocTypeKey Contents of the ASSOC_TYPE_KEY column
*/
public void setAssocTypeKey(short AssocTypeKey) {
this.AssocTypeKey = AssocTypeKey;
}

/**
* Set the AssocSubTypeKey field
*
* @param AssocSubTypeKey Contents of the ASSOC_SUB_TYPE_KEY column
*/
public void setAssocSubTypeKey(short AssocSubTypeKey) {
this.AssocSubTypeKey = AssocSubTypeKey;
}

/**
* Set the AssocTypePid field
*
* @param AssocTypePid Contents of the ASSOC_TYPE_PID column
*/
public void setAssocTypePid(int AssocTypePid) {
this.AssocTypePid = AssocTypePid;
}

/**
* Set the AssocNameUsedPid field
*
* @param AssocNameUsedPid Contents of the ASSOC_NAME_USED_PID column
*/
public void setAssocNameUsedPid(int AssocNameUsedPid) {
this.AssocNameUsedPid = AssocNameUsedPid;
}

/**
* Set the ThemeKey field
*
* @param ThemeKey Contents of the THEME_KEY column
*/
public void setThemeKey(int ThemeKey) {
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
* Set the SentceStyleKey field
*
* @param SentceStyleKey Contents of the SENTCE_STYLE_KEY column
*/
public void setSentceStyleKey(short SentceStyleKey) {
this.SentceStyleKey = SentceStyleKey;
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
* Set the DisplayOrder field
*
* @param DisplayOrder Contents of the DISPLAY_ORDER column
*/
public void setDisplayOrder(short DisplayOrder) {
this.DisplayOrder = DisplayOrder;
}

/**
* Set the Show field
*
* @param Show Contents of the SHOW column
*/
public void setShow(boolean Show) {
this.Show = Show;
}

}

