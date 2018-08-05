package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the RECORD_VALID_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class RecordValidDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"RECORD_VALID_DEFN_PID, " +
"VIEW_SCRIPT_GROUP_KEY, " +
"VIEW_SCRIPT_PID, " +
"MODIFY_SCRIPT_GROUP_KEY, " +
"MODIFY_SCRIPT_PID, " +
"DELETE_SCRIPT_GROUP_KEY, " +
"DELETE_SCRIPT_PID, " +
"REMINDER, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.RECORD_VALID_DEFNS WHERE RECORD_VALID_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"RECORD_VALID_DEFN_PID, " +  
"VIEW_SCRIPT_GROUP_KEY, " +  
"VIEW_SCRIPT_PID, " +  
"MODIFY_SCRIPT_GROUP_KEY, " +  
"MODIFY_SCRIPT_PID, " +  
"DELETE_SCRIPT_GROUP_KEY, " +  
"DELETE_SCRIPT_PID, " +  
"REMINDER, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.RECORD_VALID_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.RECORD_VALID_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"RECORD_VALID_DEFN_PID, " +     
"VIEW_SCRIPT_GROUP_KEY, " +     
"VIEW_SCRIPT_PID, " +     
"MODIFY_SCRIPT_GROUP_KEY, " +     
"MODIFY_SCRIPT_PID, " +     
"DELETE_SCRIPT_GROUP_KEY, " +     
"DELETE_SCRIPT_PID, " +     
"REMINDER, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.RECORD_VALID_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"VIEW_SCRIPT_GROUP_KEY = ?, " + 
"VIEW_SCRIPT_PID = ?, " + 
"MODIFY_SCRIPT_GROUP_KEY = ?, " + 
"MODIFY_SCRIPT_PID = ?, " + 
"DELETE_SCRIPT_GROUP_KEY = ?, " + 
"DELETE_SCRIPT_PID = ?, " + 
"REMINDER = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE RECORD_VALID_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.RECORD_VALID_DEFNS WHERE RECORD_VALID_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.RECORD_VALID_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int RecordValidDefnPid;
private short ViewScriptGroupKey;
private int ViewScriptPid;
private short ModifyScriptGroupKey;
private int ModifyScriptPid;
private short DeleteScriptGroupKey;
private int DeleteScriptPid;
private short Reminder;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private RecordValidDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public RecordValidDefns() throws SQLException {
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
model = new RecordValidDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setRecordValidDefnPid(rs.getInt("RECORD_VALID_DEFN_PID"));
model.setViewScriptGroupKey(rs.getShort("VIEW_SCRIPT_GROUP_KEY"));
model.setViewScriptPid(rs.getInt("VIEW_SCRIPT_PID"));
model.setModifyScriptGroupKey(rs.getShort("MODIFY_SCRIPT_GROUP_KEY"));
model.setModifyScriptPid(rs.getInt("MODIFY_SCRIPT_PID"));
model.setDeleteScriptGroupKey(rs.getShort("DELETE_SCRIPT_GROUP_KEY"));
model.setDeleteScriptPid(rs.getInt("DELETE_SCRIPT_PID"));
model.setReminder(rs.getShort("REMINDER"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public RecordValidDefns get(int key) throws SQLException {
model = new RecordValidDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setRecordValidDefnPid(rs.getInt("RECORD_VALID_DEFN_PID"));
model.setViewScriptGroupKey(rs.getShort("VIEW_SCRIPT_GROUP_KEY"));
model.setViewScriptPid(rs.getInt("VIEW_SCRIPT_PID"));
model.setModifyScriptGroupKey(rs.getShort("MODIFY_SCRIPT_GROUP_KEY"));
model.setModifyScriptPid(rs.getInt("MODIFY_SCRIPT_PID"));
model.setDeleteScriptGroupKey(rs.getShort("DELETE_SCRIPT_GROUP_KEY"));
model.setDeleteScriptPid(rs.getInt("DELETE_SCRIPT_PID"));
model.setReminder(rs.getShort("REMINDER"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((RecordValidDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((RecordValidDefns) model).setSetKey(rs.getShort("SET_KEY"));
((RecordValidDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((RecordValidDefns) model).setRecordValidDefnPid(rs.getInt("RECORD_VALID_DEFN_PID"));
((RecordValidDefns) model).setViewScriptGroupKey(rs.getShort("VIEW_SCRIPT_GROUP_KEY"));
((RecordValidDefns) model).setViewScriptPid(rs.getInt("VIEW_SCRIPT_PID"));
((RecordValidDefns) model).setModifyScriptGroupKey(rs.getShort("MODIFY_SCRIPT_GROUP_KEY"));
((RecordValidDefns) model).setModifyScriptPid(rs.getInt("MODIFY_SCRIPT_PID"));
((RecordValidDefns) model).setDeleteScriptGroupKey(rs.getShort("DELETE_SCRIPT_GROUP_KEY"));
((RecordValidDefns) model).setDeleteScriptPid(rs.getInt("DELETE_SCRIPT_PID"));
((RecordValidDefns) model).setReminder(rs.getShort("REMINDER"));
((RecordValidDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((RecordValidDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((RecordValidDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((RecordValidDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((RecordValidDefns) model).setSetKey(rs.getShort("SET_KEY"));
((RecordValidDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((RecordValidDefns) model).setRecordValidDefnPid(rs.getInt("RECORD_VALID_DEFN_PID"));
((RecordValidDefns) model).setViewScriptGroupKey(rs.getShort("VIEW_SCRIPT_GROUP_KEY"));
((RecordValidDefns) model).setViewScriptPid(rs.getInt("VIEW_SCRIPT_PID"));
((RecordValidDefns) model).setModifyScriptGroupKey(rs.getShort("MODIFY_SCRIPT_GROUP_KEY"));
((RecordValidDefns) model).setModifyScriptPid(rs.getInt("MODIFY_SCRIPT_PID"));
((RecordValidDefns) model).setDeleteScriptGroupKey(rs.getShort("DELETE_SCRIPT_GROUP_KEY"));
((RecordValidDefns) model).setDeleteScriptPid(rs.getInt("DELETE_SCRIPT_PID"));
((RecordValidDefns) model).setReminder(rs.getShort("REMINDER"));
((RecordValidDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((RecordValidDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((RecordValidDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the RecordValidDefnPid field.
*
* @return Contents of the RECORD_VALID_DEFN_PID column
*/
public int getRecordValidDefnPid() {
return this.RecordValidDefnPid;
}

/**
* Get the ViewScriptGroupKey field.
*
* @return Contents of the VIEW_SCRIPT_GROUP_KEY column
*/
public short getViewScriptGroupKey() {
return this.ViewScriptGroupKey;
}

/**
* Get the ViewScriptPid field.
*
* @return Contents of the VIEW_SCRIPT_PID column
*/
public int getViewScriptPid() {
return this.ViewScriptPid;
}

/**
* Get the ModifyScriptGroupKey field.
*
* @return Contents of the MODIFY_SCRIPT_GROUP_KEY column
*/
public short getModifyScriptGroupKey() {
return this.ModifyScriptGroupKey;
}

/**
* Get the ModifyScriptPid field.
*
* @return Contents of the MODIFY_SCRIPT_PID column
*/
public int getModifyScriptPid() {
return this.ModifyScriptPid;
}

/**
* Get the DeleteScriptGroupKey field.
*
* @return Contents of the DELETE_SCRIPT_GROUP_KEY column
*/
public short getDeleteScriptGroupKey() {
return this.DeleteScriptGroupKey;
}

/**
* Get the DeleteScriptPid field.
*
* @return Contents of the DELETE_SCRIPT_PID column
*/
public int getDeleteScriptPid() {
return this.DeleteScriptPid;
}

/**
* Get the Reminder field.
*
* @return Contents of the REMINDER column
*/
public short getReminder() {
return this.Reminder;
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
* Get the IsDefault field.
*
* @return Contents of the IS_DEFAULT column
*/
public boolean getIsDefault() {
return this.IsDefault;
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
* Set the RecordValidDefnPid field
*
* @param RecordValidDefnPid Contents of the RECORD_VALID_DEFN_PID column
*/
public void setRecordValidDefnPid(int RecordValidDefnPid) {
this.RecordValidDefnPid = RecordValidDefnPid;
}

/**
* Set the ViewScriptGroupKey field
*
* @param ViewScriptGroupKey Contents of the VIEW_SCRIPT_GROUP_KEY column
*/
public void setViewScriptGroupKey(short ViewScriptGroupKey) {
this.ViewScriptGroupKey = ViewScriptGroupKey;
}

/**
* Set the ViewScriptPid field
*
* @param ViewScriptPid Contents of the VIEW_SCRIPT_PID column
*/
public void setViewScriptPid(int ViewScriptPid) {
this.ViewScriptPid = ViewScriptPid;
}

/**
* Set the ModifyScriptGroupKey field
*
* @param ModifyScriptGroupKey Contents of the MODIFY_SCRIPT_GROUP_KEY column
*/
public void setModifyScriptGroupKey(short ModifyScriptGroupKey) {
this.ModifyScriptGroupKey = ModifyScriptGroupKey;
}

/**
* Set the ModifyScriptPid field
*
* @param ModifyScriptPid Contents of the MODIFY_SCRIPT_PID column
*/
public void setModifyScriptPid(int ModifyScriptPid) {
this.ModifyScriptPid = ModifyScriptPid;
}

/**
* Set the DeleteScriptGroupKey field
*
* @param DeleteScriptGroupKey Contents of the DELETE_SCRIPT_GROUP_KEY column
*/
public void setDeleteScriptGroupKey(short DeleteScriptGroupKey) {
this.DeleteScriptGroupKey = DeleteScriptGroupKey;
}

/**
* Set the DeleteScriptPid field
*
* @param DeleteScriptPid Contents of the DELETE_SCRIPT_PID column
*/
public void setDeleteScriptPid(int DeleteScriptPid) {
this.DeleteScriptPid = DeleteScriptPid;
}

/**
* Set the Reminder field
*
* @param Reminder Contents of the REMINDER column
*/
public void setReminder(short Reminder) {
this.Reminder = Reminder;
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
* Set the IsDefault field
*
* @param IsDefault Contents of the IS_DEFAULT column
*/
public void setIsDefault(boolean IsDefault) {
this.IsDefault = IsDefault;
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

