package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the LABEL_TRANS database table.
*
* @version 2018-08-02
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

public LabelTrans() throws SQLException {
}


public LabelTrans(int LabelTranPid) throws SQLException {
super();
this.LabelTranPid = LabelTranPid;
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
public AbstractHreDataModel get(int key) throws SQLException {
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
return this;
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

public int getRecordNum() {
return this.RecordNum;
}

public short getSetKey() {
return this.SetKey;
}

public int getCommitPid() {
return this.CommitPid;
}

public int getLabelTranPid() {
return this.LabelTranPid;
}

public boolean getIsUserData() {
return this.IsUserData;
}

public short getTableKey() {
return this.TableKey;
}

public short getFieldKey() {
return this.FieldKey;
}

public int getRecordPid() {
return this.RecordPid;
}

public short getSortOrder() {
return this.SortOrder;
}

public String getLangCode() {
return this.LangCode;
}

public String getAbbrev() {
return this.Abbrev;
}

public String getName() {
return this.Name;
}

public String getDescription() {
return this.Description;
}

public int getStepPid() {
return this.StepPid;
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

public void setLabelTranPid(int LabelTranPid) {
this.LabelTranPid = LabelTranPid;
}

public void setIsUserData(boolean IsUserData) {
this.IsUserData = IsUserData;
}

public void setTableKey(short TableKey) {
this.TableKey = TableKey;
}

public void setFieldKey(short FieldKey) {
this.FieldKey = FieldKey;
}

public void setRecordPid(int RecordPid) {
this.RecordPid = RecordPid;
}

public void setSortOrder(short SortOrder) {
this.SortOrder = SortOrder;
}

public void setLangCode(String LangCode) {
this.LangCode = LangCode;
}

public void setAbbrev(String Abbrev) {
this.Abbrev = Abbrev;
}

public void setName(String Name) {
this.Name = Name;
}

public void setDescription(String Description) {
this.Description = Description;
}

public void setStepPid(int StepPid) {
this.StepPid = StepPid;
}

}

