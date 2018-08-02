package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the ENCODING_TYPE_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class EncodingTypeDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"ENCODING_TYPE_DEFN_PID, " +
"IS_IMPORT_TYPE, " +
"IS_INTERNAL_TYPE, " +
"IS_EXPORT_TYPE, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.ENCODING_TYPE_DEFNS WHERE ENCODING_TYPE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"ENCODING_TYPE_DEFN_PID, " +  
"IS_IMPORT_TYPE, " +  
"IS_INTERNAL_TYPE, " +  
"IS_EXPORT_TYPE, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.ENCODING_TYPE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.ENCODING_TYPE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"ENCODING_TYPE_DEFN_PID, " +     
"IS_IMPORT_TYPE, " +     
"IS_INTERNAL_TYPE, " +     
"IS_EXPORT_TYPE, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.ENCODING_TYPE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_IMPORT_TYPE = ?, " + 
"IS_INTERNAL_TYPE = ?, " + 
"IS_EXPORT_TYPE = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE ENCODING_TYPE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.ENCODING_TYPE_DEFNS WHERE ENCODING_TYPE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.ENCODING_TYPE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int EncodingTypeDefnPid;
private boolean IsImportType;
private boolean IsInternalType;
private boolean IsExportType;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private EncodingTypeDefns model;

public EncodingTypeDefns() throws SQLException {
}


public EncodingTypeDefns(int EncodingTypeDefnPid) throws SQLException {
super();
this.EncodingTypeDefnPid = EncodingTypeDefnPid;
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
model = new EncodingTypeDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setEncodingTypeDefnPid(rs.getInt("ENCODING_TYPE_DEFN_PID"));
model.setIsImportType(rs.getBoolean("IS_IMPORT_TYPE"));
model.setIsInternalType(rs.getBoolean("IS_INTERNAL_TYPE"));
model.setIsExportType(rs.getBoolean("IS_EXPORT_TYPE"));
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
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setEncodingTypeDefnPid(rs.getInt("ENCODING_TYPE_DEFN_PID"));
model.setIsImportType(rs.getBoolean("IS_IMPORT_TYPE"));
model.setIsInternalType(rs.getBoolean("IS_INTERNAL_TYPE"));
model.setIsExportType(rs.getBoolean("IS_EXPORT_TYPE"));
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
((EncodingTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((EncodingTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((EncodingTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((EncodingTypeDefns) model).setEncodingTypeDefnPid(rs.getInt("ENCODING_TYPE_DEFN_PID"));
((EncodingTypeDefns) model).setIsImportType(rs.getBoolean("IS_IMPORT_TYPE"));
((EncodingTypeDefns) model).setIsInternalType(rs.getBoolean("IS_INTERNAL_TYPE"));
((EncodingTypeDefns) model).setIsExportType(rs.getBoolean("IS_EXPORT_TYPE"));
((EncodingTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((EncodingTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((EncodingTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((EncodingTypeDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((EncodingTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((EncodingTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((EncodingTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((EncodingTypeDefns) model).setEncodingTypeDefnPid(rs.getInt("ENCODING_TYPE_DEFN_PID"));
((EncodingTypeDefns) model).setIsImportType(rs.getBoolean("IS_IMPORT_TYPE"));
((EncodingTypeDefns) model).setIsInternalType(rs.getBoolean("IS_INTERNAL_TYPE"));
((EncodingTypeDefns) model).setIsExportType(rs.getBoolean("IS_EXPORT_TYPE"));
((EncodingTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((EncodingTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((EncodingTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((EncodingTypeDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getEncodingTypeDefnPid() {
return this.EncodingTypeDefnPid;
}

public boolean getIsImportType() {
return this.IsImportType;
}

public boolean getIsInternalType() {
return this.IsInternalType;
}

public boolean getIsExportType() {
return this.IsExportType;
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

public void setSetKey(short SetKey) {
this.SetKey = SetKey;
}

public void setCommitPid(int CommitPid) {
this.CommitPid = CommitPid;
}

public void setEncodingTypeDefnPid(int EncodingTypeDefnPid) {
this.EncodingTypeDefnPid = EncodingTypeDefnPid;
}

public void setIsImportType(boolean IsImportType) {
this.IsImportType = IsImportType;
}

public void setIsInternalType(boolean IsInternalType) {
this.IsInternalType = IsInternalType;
}

public void setIsExportType(boolean IsExportType) {
this.IsExportType = IsExportType;
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

