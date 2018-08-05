package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the OCCASN_OCCASNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class OccasnOccasns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"OCCASN_OCCASN_PID, " +
"IS_SYSTEM, " +
"OCCASN_OCCASN_TAG_KEY, " +
"A_OCCASN_SUB_TYPE_KEY, " +
"A_OCCASN_PID, " +
"B_OCCASN_SUB_TYPE_KEY, " +
"B_OCCASN_PID, " +
"THEME_KEY, " +
"SENTCE_STYLE_KEY, " +
"A_B_SENTCE_SET_PID, " +
"B_A_SENTCE_SET_PID, " +
"MEMO_SET_PID, " +
"DISPLAY_ORDER, " +
"FLAGS FROM PUBLIC.OCCASN_OCCASNS WHERE OCCASN_OCCASN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"OCCASN_OCCASN_PID, " +  
"IS_SYSTEM, " +  
"OCCASN_OCCASN_TAG_KEY, " +  
"A_OCCASN_SUB_TYPE_KEY, " +  
"A_OCCASN_PID, " +  
"B_OCCASN_SUB_TYPE_KEY, " +  
"B_OCCASN_PID, " +  
"THEME_KEY, " +  
"SENTCE_STYLE_KEY, " +  
"A_B_SENTCE_SET_PID, " +  
"B_A_SENTCE_SET_PID, " +  
"MEMO_SET_PID, " +  
"DISPLAY_ORDER, " +  
"FLAGS FROM PUBLIC.OCCASN_OCCASNS";

private static final String INSERT = "INSERT INTO PUBLIC.OCCASN_OCCASNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"OCCASN_OCCASN_PID, " +     
"IS_SYSTEM, " +     
"OCCASN_OCCASN_TAG_KEY, " +     
"A_OCCASN_SUB_TYPE_KEY, " +     
"A_OCCASN_PID, " +     
"B_OCCASN_SUB_TYPE_KEY, " +     
"B_OCCASN_PID, " +     
"THEME_KEY, " +     
"SENTCE_STYLE_KEY, " +     
"A_B_SENTCE_SET_PID, " +     
"B_A_SENTCE_SET_PID, " +     
"MEMO_SET_PID, " +     
"DISPLAY_ORDER, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.OCCASN_OCCASNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"OCCASN_OCCASN_TAG_KEY = ?, " + 
"A_OCCASN_SUB_TYPE_KEY = ?, " + 
"A_OCCASN_PID = ?, " + 
"B_OCCASN_SUB_TYPE_KEY = ?, " + 
"B_OCCASN_PID = ?, " + 
"THEME_KEY = ?, " + 
"SENTCE_STYLE_KEY = ?, " + 
"A_B_SENTCE_SET_PID = ?, " + 
"B_A_SENTCE_SET_PID = ?, " + 
"MEMO_SET_PID = ?, " + 
"DISPLAY_ORDER = ?, " + 
"FLAGS = ? WHERE OCCASN_OCCASN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.OCCASN_OCCASNS WHERE OCCASN_OCCASN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASN_OCCASNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int OccasnOccasnPid;
private boolean IsSystem;
private short OccasnOccasnTagKey;
private short AOccasnSubTypeKey;
private int AOccasnPid;
private short BOccasnSubTypeKey;
private int BOccasnPid;
private short ThemeKey;
private short SentceStyleKey;
private int ABSentceSetPid;
private int BASentceSetPid;
private int MemoSetPid;
private short DisplayOrder;
private byte[] Flags;
private OccasnOccasns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public OccasnOccasns() throws SQLException {
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
model = new OccasnOccasns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOccasnOccasnPid(rs.getInt("OCCASN_OCCASN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setOccasnOccasnTagKey(rs.getShort("OCCASN_OCCASN_TAG_KEY"));
model.setAOccasnSubTypeKey(rs.getShort("A_OCCASN_SUB_TYPE_KEY"));
model.setAOccasnPid(rs.getInt("A_OCCASN_PID"));
model.setBOccasnSubTypeKey(rs.getShort("B_OCCASN_SUB_TYPE_KEY"));
model.setBOccasnPid(rs.getInt("B_OCCASN_PID"));
model.setThemeKey(rs.getShort("THEME_KEY"));
model.setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
model.setABSentceSetPid(rs.getInt("A_B_SENTCE_SET_PID"));
model.setBASentceSetPid(rs.getInt("B_A_SENTCE_SET_PID"));
model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setFlags(rs.getBytes("FLAGS"));
modelList.add(model);
}
return modelList;
}

@Override
public OccasnOccasns get(int key) throws SQLException {
model = new OccasnOccasns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOccasnOccasnPid(rs.getInt("OCCASN_OCCASN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setOccasnOccasnTagKey(rs.getShort("OCCASN_OCCASN_TAG_KEY"));
model.setAOccasnSubTypeKey(rs.getShort("A_OCCASN_SUB_TYPE_KEY"));
model.setAOccasnPid(rs.getInt("A_OCCASN_PID"));
model.setBOccasnSubTypeKey(rs.getShort("B_OCCASN_SUB_TYPE_KEY"));
model.setBOccasnPid(rs.getInt("B_OCCASN_PID"));
model.setThemeKey(rs.getShort("THEME_KEY"));
model.setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
model.setABSentceSetPid(rs.getInt("A_B_SENTCE_SET_PID"));
model.setBASentceSetPid(rs.getInt("B_A_SENTCE_SET_PID"));
model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setFlags(rs.getBytes("FLAGS"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((OccasnOccasns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OccasnOccasns) model).setSetKey(rs.getShort("SET_KEY"));
((OccasnOccasns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OccasnOccasns) model).setOccasnOccasnPid(rs.getInt("OCCASN_OCCASN_PID"));
((OccasnOccasns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((OccasnOccasns) model).setOccasnOccasnTagKey(rs.getShort("OCCASN_OCCASN_TAG_KEY"));
((OccasnOccasns) model).setAOccasnSubTypeKey(rs.getShort("A_OCCASN_SUB_TYPE_KEY"));
((OccasnOccasns) model).setAOccasnPid(rs.getInt("A_OCCASN_PID"));
((OccasnOccasns) model).setBOccasnSubTypeKey(rs.getShort("B_OCCASN_SUB_TYPE_KEY"));
((OccasnOccasns) model).setBOccasnPid(rs.getInt("B_OCCASN_PID"));
((OccasnOccasns) model).setThemeKey(rs.getShort("THEME_KEY"));
((OccasnOccasns) model).setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
((OccasnOccasns) model).setABSentceSetPid(rs.getInt("A_B_SENTCE_SET_PID"));
((OccasnOccasns) model).setBASentceSetPid(rs.getInt("B_A_SENTCE_SET_PID"));
((OccasnOccasns) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
((OccasnOccasns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((OccasnOccasns) model).setFlags(rs.getBytes("FLAGS"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((OccasnOccasns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OccasnOccasns) model).setSetKey(rs.getShort("SET_KEY"));
((OccasnOccasns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OccasnOccasns) model).setOccasnOccasnPid(rs.getInt("OCCASN_OCCASN_PID"));
((OccasnOccasns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((OccasnOccasns) model).setOccasnOccasnTagKey(rs.getShort("OCCASN_OCCASN_TAG_KEY"));
((OccasnOccasns) model).setAOccasnSubTypeKey(rs.getShort("A_OCCASN_SUB_TYPE_KEY"));
((OccasnOccasns) model).setAOccasnPid(rs.getInt("A_OCCASN_PID"));
((OccasnOccasns) model).setBOccasnSubTypeKey(rs.getShort("B_OCCASN_SUB_TYPE_KEY"));
((OccasnOccasns) model).setBOccasnPid(rs.getInt("B_OCCASN_PID"));
((OccasnOccasns) model).setThemeKey(rs.getShort("THEME_KEY"));
((OccasnOccasns) model).setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
((OccasnOccasns) model).setABSentceSetPid(rs.getInt("A_B_SENTCE_SET_PID"));
((OccasnOccasns) model).setBASentceSetPid(rs.getInt("B_A_SENTCE_SET_PID"));
((OccasnOccasns) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
((OccasnOccasns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((OccasnOccasns) model).setFlags(rs.getBytes("FLAGS"));
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
* Get the OccasnOccasnPid field.
*
* @return Contents of the OCCASN_OCCASN_PID column
*/
public int getOccasnOccasnPid() {
return this.OccasnOccasnPid;
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
* Get the OccasnOccasnTagKey field.
*
* @return Contents of the OCCASN_OCCASN_TAG_KEY column
*/
public short getOccasnOccasnTagKey() {
return this.OccasnOccasnTagKey;
}

/**
* Get the AOccasnSubTypeKey field.
*
* @return Contents of the A_OCCASN_SUB_TYPE_KEY column
*/
public short getAOccasnSubTypeKey() {
return this.AOccasnSubTypeKey;
}

/**
* Get the AOccasnPid field.
*
* @return Contents of the A_OCCASN_PID column
*/
public int getAOccasnPid() {
return this.AOccasnPid;
}

/**
* Get the BOccasnSubTypeKey field.
*
* @return Contents of the B_OCCASN_SUB_TYPE_KEY column
*/
public short getBOccasnSubTypeKey() {
return this.BOccasnSubTypeKey;
}

/**
* Get the BOccasnPid field.
*
* @return Contents of the B_OCCASN_PID column
*/
public int getBOccasnPid() {
return this.BOccasnPid;
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
* Get the SentceStyleKey field.
*
* @return Contents of the SENTCE_STYLE_KEY column
*/
public short getSentceStyleKey() {
return this.SentceStyleKey;
}

/**
* Get the ABSentceSetPid field.
*
* @return Contents of the A_B_SENTCE_SET_PID column
*/
public int getABSentceSetPid() {
return this.ABSentceSetPid;
}

/**
* Get the BASentceSetPid field.
*
* @return Contents of the B_A_SENTCE_SET_PID column
*/
public int getBASentceSetPid() {
return this.BASentceSetPid;
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
* Set the OccasnOccasnPid field
*
* @param OccasnOccasnPid Contents of the OCCASN_OCCASN_PID column
*/
public void setOccasnOccasnPid(int OccasnOccasnPid) {
this.OccasnOccasnPid = OccasnOccasnPid;
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
* Set the OccasnOccasnTagKey field
*
* @param OccasnOccasnTagKey Contents of the OCCASN_OCCASN_TAG_KEY column
*/
public void setOccasnOccasnTagKey(short OccasnOccasnTagKey) {
this.OccasnOccasnTagKey = OccasnOccasnTagKey;
}

/**
* Set the AOccasnSubTypeKey field
*
* @param AOccasnSubTypeKey Contents of the A_OCCASN_SUB_TYPE_KEY column
*/
public void setAOccasnSubTypeKey(short AOccasnSubTypeKey) {
this.AOccasnSubTypeKey = AOccasnSubTypeKey;
}

/**
* Set the AOccasnPid field
*
* @param AOccasnPid Contents of the A_OCCASN_PID column
*/
public void setAOccasnPid(int AOccasnPid) {
this.AOccasnPid = AOccasnPid;
}

/**
* Set the BOccasnSubTypeKey field
*
* @param BOccasnSubTypeKey Contents of the B_OCCASN_SUB_TYPE_KEY column
*/
public void setBOccasnSubTypeKey(short BOccasnSubTypeKey) {
this.BOccasnSubTypeKey = BOccasnSubTypeKey;
}

/**
* Set the BOccasnPid field
*
* @param BOccasnPid Contents of the B_OCCASN_PID column
*/
public void setBOccasnPid(int BOccasnPid) {
this.BOccasnPid = BOccasnPid;
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
* Set the SentceStyleKey field
*
* @param SentceStyleKey Contents of the SENTCE_STYLE_KEY column
*/
public void setSentceStyleKey(short SentceStyleKey) {
this.SentceStyleKey = SentceStyleKey;
}

/**
* Set the ABSentceSetPid field
*
* @param ABSentceSetPid Contents of the A_B_SENTCE_SET_PID column
*/
public void setABSentceSetPid(int ABSentceSetPid) {
this.ABSentceSetPid = ABSentceSetPid;
}

/**
* Set the BASentceSetPid field
*
* @param BASentceSetPid Contents of the B_A_SENTCE_SET_PID column
*/
public void setBASentceSetPid(int BASentceSetPid) {
this.BASentceSetPid = BASentceSetPid;
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
* Set the Flags field
*
* @param Flags Contents of the FLAGS column
*/
public void setFlags(byte[] Flags) {
this.Flags = Flags;
}

}

