package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the OCCASN_ASSOCS database table.
*
* @version 2018-08-02
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

public OccasnAssocs() throws SQLException {
}


public OccasnAssocs(int OccasnAssocPid) throws SQLException {
super();
this.OccasnAssocPid = OccasnAssocPid;
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
public AbstractHreDataModel get(int key) throws SQLException {
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
return this;
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

public int getRecordNum() {
return this.RecordNum;
}

public short getSetKey() {
return this.SetKey;
}

public int getCommitPid() {
return this.CommitPid;
}

public int getOccasnAssocPid() {
return this.OccasnAssocPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public short getOccasnAssocTagKey() {
return this.OccasnAssocTagKey;
}

public short getOccasnSubTypeKey() {
return this.OccasnSubTypeKey;
}

public int getOccasnPid() {
return this.OccasnPid;
}

public short getAssocTypeKey() {
return this.AssocTypeKey;
}

public short getAssocSubTypeKey() {
return this.AssocSubTypeKey;
}

public int getAssocTypePid() {
return this.AssocTypePid;
}

public int getAssocNameUsedPid() {
return this.AssocNameUsedPid;
}

public int getThemeKey() {
return this.ThemeKey;
}

public int getLocalSentceSetPid() {
return this.LocalSentceSetPid;
}

public short getSentceStyleKey() {
return this.SentceStyleKey;
}

public int getMemoSetPid() {
return this.MemoSetPid;
}

public short getDisplayOrder() {
return this.DisplayOrder;
}

public boolean getShow() {
return this.Show;
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

public void setOccasnAssocPid(int OccasnAssocPid) {
this.OccasnAssocPid = OccasnAssocPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setOccasnAssocTagKey(short OccasnAssocTagKey) {
this.OccasnAssocTagKey = OccasnAssocTagKey;
}

public void setOccasnSubTypeKey(short OccasnSubTypeKey) {
this.OccasnSubTypeKey = OccasnSubTypeKey;
}

public void setOccasnPid(int OccasnPid) {
this.OccasnPid = OccasnPid;
}

public void setAssocTypeKey(short AssocTypeKey) {
this.AssocTypeKey = AssocTypeKey;
}

public void setAssocSubTypeKey(short AssocSubTypeKey) {
this.AssocSubTypeKey = AssocSubTypeKey;
}

public void setAssocTypePid(int AssocTypePid) {
this.AssocTypePid = AssocTypePid;
}

public void setAssocNameUsedPid(int AssocNameUsedPid) {
this.AssocNameUsedPid = AssocNameUsedPid;
}

public void setThemeKey(int ThemeKey) {
this.ThemeKey = ThemeKey;
}

public void setLocalSentceSetPid(int LocalSentceSetPid) {
this.LocalSentceSetPid = LocalSentceSetPid;
}

public void setSentceStyleKey(short SentceStyleKey) {
this.SentceStyleKey = SentceStyleKey;
}

public void setMemoSetPid(int MemoSetPid) {
this.MemoSetPid = MemoSetPid;
}

public void setDisplayOrder(short DisplayOrder) {
this.DisplayOrder = DisplayOrder;
}

public void setShow(boolean Show) {
this.Show = Show;
}

}

