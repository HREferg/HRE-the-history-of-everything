package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the CONTAIN_NAMES database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class ContainNames extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"CONTAIN_NAME_PID, " +
"IS_SYSTEM, " +
"PARENT_PID, " +
"PARENT_SUB_TYPE_KEY, " +
"NAME_TAG_KEY, " +
"NAME_STYLE_KEY, " +
"ELEMENTS_ENTERED, " +
"THIS_HDATE_PID, " +
"THIS_NAME_EVENT_PID, " +
"THIS_HDATE_INFERRED, " +
"NEXT_HDATE_PID, " +
"NEXT_NAME_EVENT_PID, " +
"NEXT_HDATE_INFERRED, " +
"THEME_KEY, " +
"SENTCE_SET_PID, " +
"SENTCE_TYPE_KEY, " +
"SENTCE_STYLE_KEY, " +
"MEMO_SET_PID FROM PUBLIC.CONTAIN_NAMES WHERE CONTAIN_NAME_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"CONTAIN_NAME_PID, " +  
"IS_SYSTEM, " +  
"PARENT_PID, " +  
"PARENT_SUB_TYPE_KEY, " +  
"NAME_TAG_KEY, " +  
"NAME_STYLE_KEY, " +  
"ELEMENTS_ENTERED, " +  
"THIS_HDATE_PID, " +  
"THIS_NAME_EVENT_PID, " +  
"THIS_HDATE_INFERRED, " +  
"NEXT_HDATE_PID, " +  
"NEXT_NAME_EVENT_PID, " +  
"NEXT_HDATE_INFERRED, " +  
"THEME_KEY, " +  
"SENTCE_SET_PID, " +  
"SENTCE_TYPE_KEY, " +  
"SENTCE_STYLE_KEY, " +  
"MEMO_SET_PID FROM PUBLIC.CONTAIN_NAMES";

private static final String INSERT = "INSERT INTO PUBLIC.CONTAIN_NAMES( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"CONTAIN_NAME_PID, " +     
"IS_SYSTEM, " +     
"PARENT_PID, " +     
"PARENT_SUB_TYPE_KEY, " +     
"NAME_TAG_KEY, " +     
"NAME_STYLE_KEY, " +     
"ELEMENTS_ENTERED, " +     
"THIS_HDATE_PID, " +     
"THIS_NAME_EVENT_PID, " +     
"THIS_HDATE_INFERRED, " +     
"NEXT_HDATE_PID, " +     
"NEXT_NAME_EVENT_PID, " +     
"NEXT_HDATE_INFERRED, " +     
"THEME_KEY, " +     
"SENTCE_SET_PID, " +     
"SENTCE_TYPE_KEY, " +     
"SENTCE_STYLE_KEY, " +     
"MEMO_SET_PID) VALUES (?, " +
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
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.CONTAIN_NAMESSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PARENT_PID = ?, " + 
"PARENT_SUB_TYPE_KEY = ?, " + 
"NAME_TAG_KEY = ?, " + 
"NAME_STYLE_KEY = ?, " + 
"ELEMENTS_ENTERED = ?, " + 
"THIS_HDATE_PID = ?, " + 
"THIS_NAME_EVENT_PID = ?, " + 
"THIS_HDATE_INFERRED = ?, " + 
"NEXT_HDATE_PID = ?, " + 
"NEXT_NAME_EVENT_PID = ?, " + 
"NEXT_HDATE_INFERRED = ?, " + 
"THEME_KEY = ?, " + 
"SENTCE_SET_PID = ?, " + 
"SENTCE_TYPE_KEY = ?, " + 
"SENTCE_STYLE_KEY = ?, " + 
"MEMO_SET_PID = ? WHERE CONTAIN_NAME_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.CONTAIN_NAMES WHERE CONTAIN_NAME_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.CONTAIN_NAMES";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int ContainNamePid;
private boolean IsSystem;
private int ParentPid;
private short ParentSubTypeKey;
private short NameTagKey;
private short NameStyleKey;
private byte[] ElementsEntered;
private int ThisHdatePid;
private int ThisNameEventPid;
private boolean ThisHdateInferred;
private int NextHdatePid;
private int NextNameEventPid;
private boolean NextHdateInferred;
private short ThemeKey;
private int SentceSetPid;
private short SentceTypeKey;
private short SentceStyleKey;
private int MemoSetPid;
private ContainNames model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public ContainNames() throws SQLException {
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
model = new ContainNames();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setContainNamePid(rs.getInt("CONTAIN_NAME_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentPid(rs.getInt("PARENT_PID"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setNameTagKey(rs.getShort("NAME_TAG_KEY"));
model.setNameStyleKey(rs.getShort("NAME_STYLE_KEY"));
model.setElementsEntered(rs.getBytes("ELEMENTS_ENTERED"));
model.setThisHdatePid(rs.getInt("THIS_HDATE_PID"));
model.setThisNameEventPid(rs.getInt("THIS_NAME_EVENT_PID"));
model.setThisHdateInferred(rs.getBoolean("THIS_HDATE_INFERRED"));
model.setNextHdatePid(rs.getInt("NEXT_HDATE_PID"));
model.setNextNameEventPid(rs.getInt("NEXT_NAME_EVENT_PID"));
model.setNextHdateInferred(rs.getBoolean("NEXT_HDATE_INFERRED"));
model.setThemeKey(rs.getShort("THEME_KEY"));
model.setSentceSetPid(rs.getInt("SENTCE_SET_PID"));
model.setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
model.setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
modelList.add(model);
}
return modelList;
}

@Override
public ContainNames get(int key) throws SQLException {
model = new ContainNames();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setContainNamePid(rs.getInt("CONTAIN_NAME_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentPid(rs.getInt("PARENT_PID"));
model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
model.setNameTagKey(rs.getShort("NAME_TAG_KEY"));
model.setNameStyleKey(rs.getShort("NAME_STYLE_KEY"));
model.setElementsEntered(rs.getBytes("ELEMENTS_ENTERED"));
model.setThisHdatePid(rs.getInt("THIS_HDATE_PID"));
model.setThisNameEventPid(rs.getInt("THIS_NAME_EVENT_PID"));
model.setThisHdateInferred(rs.getBoolean("THIS_HDATE_INFERRED"));
model.setNextHdatePid(rs.getInt("NEXT_HDATE_PID"));
model.setNextNameEventPid(rs.getInt("NEXT_NAME_EVENT_PID"));
model.setNextHdateInferred(rs.getBoolean("NEXT_HDATE_INFERRED"));
model.setThemeKey(rs.getShort("THEME_KEY"));
model.setSentceSetPid(rs.getInt("SENTCE_SET_PID"));
model.setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
model.setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((ContainNames) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ContainNames) model).setSetKey(rs.getShort("SET_KEY"));
((ContainNames) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ContainNames) model).setContainNamePid(rs.getInt("CONTAIN_NAME_PID"));
((ContainNames) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((ContainNames) model).setParentPid(rs.getInt("PARENT_PID"));
((ContainNames) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((ContainNames) model).setNameTagKey(rs.getShort("NAME_TAG_KEY"));
((ContainNames) model).setNameStyleKey(rs.getShort("NAME_STYLE_KEY"));
((ContainNames) model).setElementsEntered(rs.getBytes("ELEMENTS_ENTERED"));
((ContainNames) model).setThisHdatePid(rs.getInt("THIS_HDATE_PID"));
((ContainNames) model).setThisNameEventPid(rs.getInt("THIS_NAME_EVENT_PID"));
((ContainNames) model).setThisHdateInferred(rs.getBoolean("THIS_HDATE_INFERRED"));
((ContainNames) model).setNextHdatePid(rs.getInt("NEXT_HDATE_PID"));
((ContainNames) model).setNextNameEventPid(rs.getInt("NEXT_NAME_EVENT_PID"));
((ContainNames) model).setNextHdateInferred(rs.getBoolean("NEXT_HDATE_INFERRED"));
((ContainNames) model).setThemeKey(rs.getShort("THEME_KEY"));
((ContainNames) model).setSentceSetPid(rs.getInt("SENTCE_SET_PID"));
((ContainNames) model).setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
((ContainNames) model).setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
((ContainNames) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((ContainNames) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ContainNames) model).setSetKey(rs.getShort("SET_KEY"));
((ContainNames) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ContainNames) model).setContainNamePid(rs.getInt("CONTAIN_NAME_PID"));
((ContainNames) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((ContainNames) model).setParentPid(rs.getInt("PARENT_PID"));
((ContainNames) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
((ContainNames) model).setNameTagKey(rs.getShort("NAME_TAG_KEY"));
((ContainNames) model).setNameStyleKey(rs.getShort("NAME_STYLE_KEY"));
((ContainNames) model).setElementsEntered(rs.getBytes("ELEMENTS_ENTERED"));
((ContainNames) model).setThisHdatePid(rs.getInt("THIS_HDATE_PID"));
((ContainNames) model).setThisNameEventPid(rs.getInt("THIS_NAME_EVENT_PID"));
((ContainNames) model).setThisHdateInferred(rs.getBoolean("THIS_HDATE_INFERRED"));
((ContainNames) model).setNextHdatePid(rs.getInt("NEXT_HDATE_PID"));
((ContainNames) model).setNextNameEventPid(rs.getInt("NEXT_NAME_EVENT_PID"));
((ContainNames) model).setNextHdateInferred(rs.getBoolean("NEXT_HDATE_INFERRED"));
((ContainNames) model).setThemeKey(rs.getShort("THEME_KEY"));
((ContainNames) model).setSentceSetPid(rs.getInt("SENTCE_SET_PID"));
((ContainNames) model).setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
((ContainNames) model).setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
((ContainNames) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
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
* Get the ContainNamePid field.
*
* @return Contents of the CONTAIN_NAME_PID column
*/
public int getContainNamePid() {
return this.ContainNamePid;
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
* Get the NameTagKey field.
*
* @return Contents of the NAME_TAG_KEY column
*/
public short getNameTagKey() {
return this.NameTagKey;
}

/**
* Get the NameStyleKey field.
*
* @return Contents of the NAME_STYLE_KEY column
*/
public short getNameStyleKey() {
return this.NameStyleKey;
}

/**
* Get the ElementsEntered field.
*
* @return Contents of the ELEMENTS_ENTERED column
*/
public byte[] getElementsEntered() {
return this.ElementsEntered;
}

/**
* Get the ThisHdatePid field.
*
* @return Contents of the THIS_HDATE_PID column
*/
public int getThisHdatePid() {
return this.ThisHdatePid;
}

/**
* Get the ThisNameEventPid field.
*
* @return Contents of the THIS_NAME_EVENT_PID column
*/
public int getThisNameEventPid() {
return this.ThisNameEventPid;
}

/**
* Get the ThisHdateInferred field.
*
* @return Contents of the THIS_HDATE_INFERRED column
*/
public boolean getThisHdateInferred() {
return this.ThisHdateInferred;
}

/**
* Get the NextHdatePid field.
*
* @return Contents of the NEXT_HDATE_PID column
*/
public int getNextHdatePid() {
return this.NextHdatePid;
}

/**
* Get the NextNameEventPid field.
*
* @return Contents of the NEXT_NAME_EVENT_PID column
*/
public int getNextNameEventPid() {
return this.NextNameEventPid;
}

/**
* Get the NextHdateInferred field.
*
* @return Contents of the NEXT_HDATE_INFERRED column
*/
public boolean getNextHdateInferred() {
return this.NextHdateInferred;
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
* Get the SentceSetPid field.
*
* @return Contents of the SENTCE_SET_PID column
*/
public int getSentceSetPid() {
return this.SentceSetPid;
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
* Get the MemoSetPid field.
*
* @return Contents of the MEMO_SET_PID column
*/
public int getMemoSetPid() {
return this.MemoSetPid;
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
* Set the ContainNamePid field
*
* @param ContainNamePid Contents of the CONTAIN_NAME_PID column
*/
public void setContainNamePid(int ContainNamePid) {
this.ContainNamePid = ContainNamePid;
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
* Set the NameTagKey field
*
* @param NameTagKey Contents of the NAME_TAG_KEY column
*/
public void setNameTagKey(short NameTagKey) {
this.NameTagKey = NameTagKey;
}

/**
* Set the NameStyleKey field
*
* @param NameStyleKey Contents of the NAME_STYLE_KEY column
*/
public void setNameStyleKey(short NameStyleKey) {
this.NameStyleKey = NameStyleKey;
}

/**
* Set the ElementsEntered field
*
* @param ElementsEntered Contents of the ELEMENTS_ENTERED column
*/
public void setElementsEntered(byte[] ElementsEntered) {
this.ElementsEntered = ElementsEntered;
}

/**
* Set the ThisHdatePid field
*
* @param ThisHdatePid Contents of the THIS_HDATE_PID column
*/
public void setThisHdatePid(int ThisHdatePid) {
this.ThisHdatePid = ThisHdatePid;
}

/**
* Set the ThisNameEventPid field
*
* @param ThisNameEventPid Contents of the THIS_NAME_EVENT_PID column
*/
public void setThisNameEventPid(int ThisNameEventPid) {
this.ThisNameEventPid = ThisNameEventPid;
}

/**
* Set the ThisHdateInferred field
*
* @param ThisHdateInferred Contents of the THIS_HDATE_INFERRED column
*/
public void setThisHdateInferred(boolean ThisHdateInferred) {
this.ThisHdateInferred = ThisHdateInferred;
}

/**
* Set the NextHdatePid field
*
* @param NextHdatePid Contents of the NEXT_HDATE_PID column
*/
public void setNextHdatePid(int NextHdatePid) {
this.NextHdatePid = NextHdatePid;
}

/**
* Set the NextNameEventPid field
*
* @param NextNameEventPid Contents of the NEXT_NAME_EVENT_PID column
*/
public void setNextNameEventPid(int NextNameEventPid) {
this.NextNameEventPid = NextNameEventPid;
}

/**
* Set the NextHdateInferred field
*
* @param NextHdateInferred Contents of the NEXT_HDATE_INFERRED column
*/
public void setNextHdateInferred(boolean NextHdateInferred) {
this.NextHdateInferred = NextHdateInferred;
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
* Set the SentceSetPid field
*
* @param SentceSetPid Contents of the SENTCE_SET_PID column
*/
public void setSentceSetPid(int SentceSetPid) {
this.SentceSetPid = SentceSetPid;
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
* Set the MemoSetPid field
*
* @param MemoSetPid Contents of the MEMO_SET_PID column
*/
public void setMemoSetPid(int MemoSetPid) {
this.MemoSetPid = MemoSetPid;
}

}

