package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the FIELD_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class FieldDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"FIELD_DEFN_PID, " +
"VERSION_NAME, " +
"SQL_NAME, " +
"SQL_TYPE, " +
"DATA_TYPE_KEY, " +
"ENCODE_TYPE_KEY, " +
"FIELD_FORMAT_KEY, " +
"FIELD_VALID_KEY, " +
"FIELD_RECENT_PID, " +
"MAX_RECENT, " +
"MAX_FIXED, " +
"LEFT_FIELD_PID, " +
"RIGHT_FIELD_PID, " +
"HAS_AUTO_FILLIN, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.FIELD_DEFNS WHERE FIELD_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"FIELD_DEFN_PID, " +  
"VERSION_NAME, " +  
"SQL_NAME, " +  
"SQL_TYPE, " +  
"DATA_TYPE_KEY, " +  
"ENCODE_TYPE_KEY, " +  
"FIELD_FORMAT_KEY, " +  
"FIELD_VALID_KEY, " +  
"FIELD_RECENT_PID, " +  
"MAX_RECENT, " +  
"MAX_FIXED, " +  
"LEFT_FIELD_PID, " +  
"RIGHT_FIELD_PID, " +  
"HAS_AUTO_FILLIN, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.FIELD_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.FIELD_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"FIELD_DEFN_PID, " +     
"VERSION_NAME, " +     
"SQL_NAME, " +     
"SQL_TYPE, " +     
"DATA_TYPE_KEY, " +     
"ENCODE_TYPE_KEY, " +     
"FIELD_FORMAT_KEY, " +     
"FIELD_VALID_KEY, " +     
"FIELD_RECENT_PID, " +     
"MAX_RECENT, " +     
"MAX_FIXED, " +     
"LEFT_FIELD_PID, " +     
"RIGHT_FIELD_PID, " +     
"HAS_AUTO_FILLIN, " +     
"REMINDER_KEY, " +     
"DISPLAY_ORDER, " +     
"IS_DEFAULT, " +     
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
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.FIELD_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"VERSION_NAME = ?, " + 
"SQL_NAME = ?, " + 
"SQL_TYPE = ?, " + 
"DATA_TYPE_KEY = ?, " + 
"ENCODE_TYPE_KEY = ?, " + 
"FIELD_FORMAT_KEY = ?, " + 
"FIELD_VALID_KEY = ?, " + 
"FIELD_RECENT_PID = ?, " + 
"MAX_RECENT = ?, " + 
"MAX_FIXED = ?, " + 
"LEFT_FIELD_PID = ?, " + 
"RIGHT_FIELD_PID = ?, " + 
"HAS_AUTO_FILLIN = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE FIELD_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.FIELD_DEFNS WHERE FIELD_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.FIELD_DEFNS";

private int RecordNum;
private int SetKey;
private int CommitPid;
private int FieldDefnPid;
private String VersionName;
private String SqlName;
private String SqlType;
private short DataTypeKey;
private short EncodeTypeKey;
private short FieldFormatKey;
private short FieldValidKey;
private int FieldRecentPid;
private short MaxRecent;
private short MaxFixed;
private int LeftFieldPid;
private int RightFieldPid;
private boolean HasAutoFillin;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private FieldDefns model;

public FieldDefns() throws SQLException {
}


public FieldDefns(int FieldDefnPid) throws SQLException {
super();
this.FieldDefnPid = FieldDefnPid;
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
model = new FieldDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getInt("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setFieldDefnPid(rs.getInt("FIELD_DEFN_PID"));
model.setVersionName(rs.getString("VERSION_NAME"));
model.setSqlName(rs.getString("SQL_NAME"));
model.setSqlType(rs.getString("SQL_TYPE"));
model.setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
model.setEncodeTypeKey(rs.getShort("ENCODE_TYPE_KEY"));
model.setFieldFormatKey(rs.getShort("FIELD_FORMAT_KEY"));
model.setFieldValidKey(rs.getShort("FIELD_VALID_KEY"));
model.setFieldRecentPid(rs.getInt("FIELD_RECENT_PID"));
model.setMaxRecent(rs.getShort("MAX_RECENT"));
model.setMaxFixed(rs.getShort("MAX_FIXED"));
model.setLeftFieldPid(rs.getInt("LEFT_FIELD_PID"));
model.setRightFieldPid(rs.getInt("RIGHT_FIELD_PID"));
model.setHasAutoFillin(rs.getBoolean("HAS_AUTO_FILLIN"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
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
model.setSetKey(rs.getInt("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setFieldDefnPid(rs.getInt("FIELD_DEFN_PID"));
model.setVersionName(rs.getString("VERSION_NAME"));
model.setSqlName(rs.getString("SQL_NAME"));
model.setSqlType(rs.getString("SQL_TYPE"));
model.setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
model.setEncodeTypeKey(rs.getShort("ENCODE_TYPE_KEY"));
model.setFieldFormatKey(rs.getShort("FIELD_FORMAT_KEY"));
model.setFieldValidKey(rs.getShort("FIELD_VALID_KEY"));
model.setFieldRecentPid(rs.getInt("FIELD_RECENT_PID"));
model.setMaxRecent(rs.getShort("MAX_RECENT"));
model.setMaxFixed(rs.getShort("MAX_FIXED"));
model.setLeftFieldPid(rs.getInt("LEFT_FIELD_PID"));
model.setRightFieldPid(rs.getInt("RIGHT_FIELD_PID"));
model.setHasAutoFillin(rs.getBoolean("HAS_AUTO_FILLIN"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((FieldDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((FieldDefns) model).setSetKey(rs.getInt("SET_KEY"));
((FieldDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((FieldDefns) model).setFieldDefnPid(rs.getInt("FIELD_DEFN_PID"));
((FieldDefns) model).setVersionName(rs.getString("VERSION_NAME"));
((FieldDefns) model).setSqlName(rs.getString("SQL_NAME"));
((FieldDefns) model).setSqlType(rs.getString("SQL_TYPE"));
((FieldDefns) model).setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
((FieldDefns) model).setEncodeTypeKey(rs.getShort("ENCODE_TYPE_KEY"));
((FieldDefns) model).setFieldFormatKey(rs.getShort("FIELD_FORMAT_KEY"));
((FieldDefns) model).setFieldValidKey(rs.getShort("FIELD_VALID_KEY"));
((FieldDefns) model).setFieldRecentPid(rs.getInt("FIELD_RECENT_PID"));
((FieldDefns) model).setMaxRecent(rs.getShort("MAX_RECENT"));
((FieldDefns) model).setMaxFixed(rs.getShort("MAX_FIXED"));
((FieldDefns) model).setLeftFieldPid(rs.getInt("LEFT_FIELD_PID"));
((FieldDefns) model).setRightFieldPid(rs.getInt("RIGHT_FIELD_PID"));
((FieldDefns) model).setHasAutoFillin(rs.getBoolean("HAS_AUTO_FILLIN"));
((FieldDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((FieldDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((FieldDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((FieldDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((FieldDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((FieldDefns) model).setSetKey(rs.getInt("SET_KEY"));
((FieldDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((FieldDefns) model).setFieldDefnPid(rs.getInt("FIELD_DEFN_PID"));
((FieldDefns) model).setVersionName(rs.getString("VERSION_NAME"));
((FieldDefns) model).setSqlName(rs.getString("SQL_NAME"));
((FieldDefns) model).setSqlType(rs.getString("SQL_TYPE"));
((FieldDefns) model).setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
((FieldDefns) model).setEncodeTypeKey(rs.getShort("ENCODE_TYPE_KEY"));
((FieldDefns) model).setFieldFormatKey(rs.getShort("FIELD_FORMAT_KEY"));
((FieldDefns) model).setFieldValidKey(rs.getShort("FIELD_VALID_KEY"));
((FieldDefns) model).setFieldRecentPid(rs.getInt("FIELD_RECENT_PID"));
((FieldDefns) model).setMaxRecent(rs.getShort("MAX_RECENT"));
((FieldDefns) model).setMaxFixed(rs.getShort("MAX_FIXED"));
((FieldDefns) model).setLeftFieldPid(rs.getInt("LEFT_FIELD_PID"));
((FieldDefns) model).setRightFieldPid(rs.getInt("RIGHT_FIELD_PID"));
((FieldDefns) model).setHasAutoFillin(rs.getBoolean("HAS_AUTO_FILLIN"));
((FieldDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((FieldDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((FieldDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((FieldDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

public int getRecordNum() {
return this.RecordNum;
}

public int getSetKey() {
return this.SetKey;
}

public int getCommitPid() {
return this.CommitPid;
}

public int getFieldDefnPid() {
return this.FieldDefnPid;
}

public String getVersionName() {
return this.VersionName;
}

public String getSqlName() {
return this.SqlName;
}

public String getSqlType() {
return this.SqlType;
}

public short getDataTypeKey() {
return this.DataTypeKey;
}

public short getEncodeTypeKey() {
return this.EncodeTypeKey;
}

public short getFieldFormatKey() {
return this.FieldFormatKey;
}

public short getFieldValidKey() {
return this.FieldValidKey;
}

public int getFieldRecentPid() {
return this.FieldRecentPid;
}

public short getMaxRecent() {
return this.MaxRecent;
}

public short getMaxFixed() {
return this.MaxFixed;
}

public int getLeftFieldPid() {
return this.LeftFieldPid;
}

public int getRightFieldPid() {
return this.RightFieldPid;
}

public boolean getHasAutoFillin() {
return this.HasAutoFillin;
}

public short getReminderKey() {
return this.ReminderKey;
}

public short getDisplayOrder() {
return this.DisplayOrder;
}

public boolean getIsDefault() {
return this.IsDefault;
}

public boolean getShow() {
return this.Show;
}

public void setRecordNum(int RecordNum) {
this.RecordNum = RecordNum;
}

public void setSetKey(int SetKey) {
this.SetKey = SetKey;
}

public void setCommitPid(int CommitPid) {
this.CommitPid = CommitPid;
}

public void setFieldDefnPid(int FieldDefnPid) {
this.FieldDefnPid = FieldDefnPid;
}

public void setVersionName(String VersionName) {
this.VersionName = VersionName;
}

public void setSqlName(String SqlName) {
this.SqlName = SqlName;
}

public void setSqlType(String SqlType) {
this.SqlType = SqlType;
}

public void setDataTypeKey(short DataTypeKey) {
this.DataTypeKey = DataTypeKey;
}

public void setEncodeTypeKey(short EncodeTypeKey) {
this.EncodeTypeKey = EncodeTypeKey;
}

public void setFieldFormatKey(short FieldFormatKey) {
this.FieldFormatKey = FieldFormatKey;
}

public void setFieldValidKey(short FieldValidKey) {
this.FieldValidKey = FieldValidKey;
}

public void setFieldRecentPid(int FieldRecentPid) {
this.FieldRecentPid = FieldRecentPid;
}

public void setMaxRecent(short MaxRecent) {
this.MaxRecent = MaxRecent;
}

public void setMaxFixed(short MaxFixed) {
this.MaxFixed = MaxFixed;
}

public void setLeftFieldPid(int LeftFieldPid) {
this.LeftFieldPid = LeftFieldPid;
}

public void setRightFieldPid(int RightFieldPid) {
this.RightFieldPid = RightFieldPid;
}

public void setHasAutoFillin(boolean HasAutoFillin) {
this.HasAutoFillin = HasAutoFillin;
}

public void setReminderKey(short ReminderKey) {
this.ReminderKey = ReminderKey;
}

public void setDisplayOrder(short DisplayOrder) {
this.DisplayOrder = DisplayOrder;
}

public void setIsDefault(boolean IsDefault) {
this.IsDefault = IsDefault;
}

public void setShow(boolean Show) {
this.Show = Show;
}

}

