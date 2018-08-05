package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the LABEL_TRANS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class LabelTrans extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"LABEL_TRAN_PID, " +
"IS_USER_DATA, " +
"TABLE_KEY, " +
"FIELD_KEY, " +
"RECORD_PID, " +
"SORT_ORDER, " +
"LANG_CODE, " +
"ABBREV, " +
"NAME, " +
"DESCRIPTION, " +
"STEP_PID FROM PUBLIC.LABEL_TRANS WHERE LABEL_TRAN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"LABEL_TRAN_PID, " +  
"IS_USER_DATA, " +  
"TABLE_KEY, " +  
"FIELD_KEY, " +  
"RECORD_PID, " +  
"SORT_ORDER, " +  
"LANG_CODE, " +  
"ABBREV, " +  
"NAME, " +  
"DESCRIPTION, " +  
"STEP_PID FROM PUBLIC.LABEL_TRANS";

private static final String INSERT = "INSERT INTO PUBLIC.LABEL_TRANS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"LABEL_TRAN_PID, " +     
"IS_USER_DATA, " +     
"TABLE_KEY, " +     
"FIELD_KEY, " +     
"RECORD_PID, " +     
"SORT_ORDER, " +     
"LANG_CODE, " +     
"ABBREV, " +     
"NAME, " +     
"DESCRIPTION, " +     
"STEP_PID) VALUES (?, " +
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

private static final String UPDATE = "UPDATE PUBLIC.LABEL_TRANSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_USER_DATA = ?, " + 
"TABLE_KEY = ?, " + 
"FIELD_KEY = ?, " + 
"RECORD_PID = ?, " + 
"SORT_ORDER = ?, " + 
"LANG_CODE = ?, " + 
"ABBREV = ?, " + 
"NAME = ?, " + 
"DESCRIPTION = ?, " + 
"STEP_PID = ? WHERE LABEL_TRAN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.LABEL_TRANS WHERE LABEL_TRAN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.LABEL_TRANS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int LabelTranPid;
private boolean IsUserData;
private short TableKey;
private short FieldKey;
private int RecordPid;
private short SortOrder;
private String LangCode;
private String Abbrev;
private String Name;
private String Description;
private int StepPid;
private LabelTrans model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public LabelTrans() throws SQLException {
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
model = new LabelTrans();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setLabelTranPid(rs.getInt("LABEL_TRAN_PID"));
model.setIsUserData(rs.getBoolean("IS_USER_DATA"));
model.setTableKey(rs.getShort("TABLE_KEY"));
model.setFieldKey(rs.getShort("FIELD_KEY"));
model.setRecordPid(rs.getInt("RECORD_PID"));
model.setSortOrder(rs.getShort("SORT_ORDER"));
model.setLangCode(rs.getString("LANG_CODE"));
model.setAbbrev(rs.getString("ABBREV"));
model.setName(rs.getString("NAME"));
model.setDescription(rs.getString("DESCRIPTION"));
model.setStepPid(rs.getInt("STEP_PID"));
modelList.add(model);
}
return modelList;
}

@Override
public LabelTrans get(int key) throws SQLException {
model = new LabelTrans();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setLabelTranPid(rs.getInt("LABEL_TRAN_PID"));
model.setIsUserData(rs.getBoolean("IS_USER_DATA"));
model.setTableKey(rs.getShort("TABLE_KEY"));
model.setFieldKey(rs.getShort("FIELD_KEY"));
model.setRecordPid(rs.getInt("RECORD_PID"));
model.setSortOrder(rs.getShort("SORT_ORDER"));
model.setLangCode(rs.getString("LANG_CODE"));
model.setAbbrev(rs.getString("ABBREV"));
model.setName(rs.getString("NAME"));
model.setDescription(rs.getString("DESCRIPTION"));
model.setStepPid(rs.getInt("STEP_PID"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((LabelTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
((LabelTrans) model).setSetKey(rs.getShort("SET_KEY"));
((LabelTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
((LabelTrans) model).setLabelTranPid(rs.getInt("LABEL_TRAN_PID"));
((LabelTrans) model).setIsUserData(rs.getBoolean("IS_USER_DATA"));
((LabelTrans) model).setTableKey(rs.getShort("TABLE_KEY"));
((LabelTrans) model).setFieldKey(rs.getShort("FIELD_KEY"));
((LabelTrans) model).setRecordPid(rs.getInt("RECORD_PID"));
((LabelTrans) model).setSortOrder(rs.getShort("SORT_ORDER"));
((LabelTrans) model).setLangCode(rs.getString("LANG_CODE"));
((LabelTrans) model).setAbbrev(rs.getString("ABBREV"));
((LabelTrans) model).setName(rs.getString("NAME"));
((LabelTrans) model).setDescription(rs.getString("DESCRIPTION"));
((LabelTrans) model).setStepPid(rs.getInt("STEP_PID"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((LabelTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
((LabelTrans) model).setSetKey(rs.getShort("SET_KEY"));
((LabelTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
((LabelTrans) model).setLabelTranPid(rs.getInt("LABEL_TRAN_PID"));
((LabelTrans) model).setIsUserData(rs.getBoolean("IS_USER_DATA"));
((LabelTrans) model).setTableKey(rs.getShort("TABLE_KEY"));
((LabelTrans) model).setFieldKey(rs.getShort("FIELD_KEY"));
((LabelTrans) model).setRecordPid(rs.getInt("RECORD_PID"));
((LabelTrans) model).setSortOrder(rs.getShort("SORT_ORDER"));
((LabelTrans) model).setLangCode(rs.getString("LANG_CODE"));
((LabelTrans) model).setAbbrev(rs.getString("ABBREV"));
((LabelTrans) model).setName(rs.getString("NAME"));
((LabelTrans) model).setDescription(rs.getString("DESCRIPTION"));
((LabelTrans) model).setStepPid(rs.getInt("STEP_PID"));
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
* Get the LabelTranPid field.
*
* @return Contents of the LABEL_TRAN_PID column
*/
public int getLabelTranPid() {
return this.LabelTranPid;
}

/**
* Get the IsUserData field.
*
* @return Contents of the IS_USER_DATA column
*/
public boolean getIsUserData() {
return this.IsUserData;
}

/**
* Get the TableKey field.
*
* @return Contents of the TABLE_KEY column
*/
public short getTableKey() {
return this.TableKey;
}

/**
* Get the FieldKey field.
*
* @return Contents of the FIELD_KEY column
*/
public short getFieldKey() {
return this.FieldKey;
}

/**
* Get the RecordPid field.
*
* @return Contents of the RECORD_PID column
*/
public int getRecordPid() {
return this.RecordPid;
}

/**
* Get the SortOrder field.
*
* @return Contents of the SORT_ORDER column
*/
public short getSortOrder() {
return this.SortOrder;
}

/**
* Get the LangCode field.
*
* @return Contents of the LANG_CODE column
*/
public String getLangCode() {
return this.LangCode;
}

/**
* Get the Abbrev field.
*
* @return Contents of the ABBREV column
*/
public String getAbbrev() {
return this.Abbrev;
}

/**
* Get the Name field.
*
* @return Contents of the NAME column
*/
public String getName() {
return this.Name;
}

/**
* Get the Description field.
*
* @return Contents of the DESCRIPTION column
*/
public String getDescription() {
return this.Description;
}

/**
* Get the StepPid field.
*
* @return Contents of the STEP_PID column
*/
public int getStepPid() {
return this.StepPid;
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
* Set the LabelTranPid field
*
* @param LabelTranPid Contents of the LABEL_TRAN_PID column
*/
public void setLabelTranPid(int LabelTranPid) {
this.LabelTranPid = LabelTranPid;
}

/**
* Set the IsUserData field
*
* @param IsUserData Contents of the IS_USER_DATA column
*/
public void setIsUserData(boolean IsUserData) {
this.IsUserData = IsUserData;
}

/**
* Set the TableKey field
*
* @param TableKey Contents of the TABLE_KEY column
*/
public void setTableKey(short TableKey) {
this.TableKey = TableKey;
}

/**
* Set the FieldKey field
*
* @param FieldKey Contents of the FIELD_KEY column
*/
public void setFieldKey(short FieldKey) {
this.FieldKey = FieldKey;
}

/**
* Set the RecordPid field
*
* @param RecordPid Contents of the RECORD_PID column
*/
public void setRecordPid(int RecordPid) {
this.RecordPid = RecordPid;
}

/**
* Set the SortOrder field
*
* @param SortOrder Contents of the SORT_ORDER column
*/
public void setSortOrder(short SortOrder) {
this.SortOrder = SortOrder;
}

/**
* Set the LangCode field
*
* @param LangCode Contents of the LANG_CODE column
*/
public void setLangCode(String LangCode) {
this.LangCode = LangCode;
}

/**
* Set the Abbrev field
*
* @param Abbrev Contents of the ABBREV column
*/
public void setAbbrev(String Abbrev) {
this.Abbrev = Abbrev;
}

/**
* Set the Name field
*
* @param Name Contents of the NAME column
*/
public void setName(String Name) {
this.Name = Name;
}

/**
* Set the Description field
*
* @param Description Contents of the DESCRIPTION column
*/
public void setDescription(String Description) {
this.Description = Description;
}

/**
* Set the StepPid field
*
* @param StepPid Contents of the STEP_PID column
*/
public void setStepPid(int StepPid) {
this.StepPid = StepPid;
}

}

