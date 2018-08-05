package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the NAME_ELMNT_INPUT_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class NameElmntInputDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"NAME_ELMNT_INPUT_DEFN_PID, " +
"IS_SYSTEM, " +
"ENTITY_TYPE_KEY, " +
"ENTITY_SUB_TYPE_KEY, " +
"PARENT_NAME_STYLE_KEY, " +
"NAME_ELMNT_TYPE_KEY, " +
"DATA_TYPE_KEY, " +
"FIELD_RANK_ORDER, " +
"VALID_SCRIPT_GROUP_KEY, " +
"VALID_SCRIPT_KEY, " +
"LEFT_FIELD_ELMNT_KEY, " +
"RIGHT_FIELD_ELMNT_KEY, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"IS_DETAIL_ELMNT, " +
"SHOW FROM PUBLIC.NAME_ELMNT_INPUT_DEFNS WHERE NAME_ELMNT_INPUT_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"NAME_ELMNT_INPUT_DEFN_PID, " +  
"IS_SYSTEM, " +  
"ENTITY_TYPE_KEY, " +  
"ENTITY_SUB_TYPE_KEY, " +  
"PARENT_NAME_STYLE_KEY, " +  
"NAME_ELMNT_TYPE_KEY, " +  
"DATA_TYPE_KEY, " +  
"FIELD_RANK_ORDER, " +  
"VALID_SCRIPT_GROUP_KEY, " +  
"VALID_SCRIPT_KEY, " +  
"LEFT_FIELD_ELMNT_KEY, " +  
"RIGHT_FIELD_ELMNT_KEY, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"IS_DETAIL_ELMNT, " +  
"SHOW FROM PUBLIC.NAME_ELMNT_INPUT_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.NAME_ELMNT_INPUT_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"NAME_ELMNT_INPUT_DEFN_PID, " +     
"IS_SYSTEM, " +     
"ENTITY_TYPE_KEY, " +     
"ENTITY_SUB_TYPE_KEY, " +     
"PARENT_NAME_STYLE_KEY, " +     
"NAME_ELMNT_TYPE_KEY, " +     
"DATA_TYPE_KEY, " +     
"FIELD_RANK_ORDER, " +     
"VALID_SCRIPT_GROUP_KEY, " +     
"VALID_SCRIPT_KEY, " +     
"LEFT_FIELD_ELMNT_KEY, " +     
"RIGHT_FIELD_ELMNT_KEY, " +     
"REMINDER_KEY, " +     
"DISPLAY_ORDER, " +     
"IS_DEFAULT, " +     
"IS_DETAIL_ELMNT, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.NAME_ELMNT_INPUT_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"ENTITY_TYPE_KEY = ?, " + 
"ENTITY_SUB_TYPE_KEY = ?, " + 
"PARENT_NAME_STYLE_KEY = ?, " + 
"NAME_ELMNT_TYPE_KEY = ?, " + 
"DATA_TYPE_KEY = ?, " + 
"FIELD_RANK_ORDER = ?, " + 
"VALID_SCRIPT_GROUP_KEY = ?, " + 
"VALID_SCRIPT_KEY = ?, " + 
"LEFT_FIELD_ELMNT_KEY = ?, " + 
"RIGHT_FIELD_ELMNT_KEY = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"IS_DETAIL_ELMNT = ?, " + 
"SHOW = ? WHERE NAME_ELMNT_INPUT_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.NAME_ELMNT_INPUT_DEFNS WHERE NAME_ELMNT_INPUT_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.NAME_ELMNT_INPUT_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int NameElmntInputDefnPid;
private boolean IsSystem;
private short EntityTypeKey;
private short EntitySubTypeKey;
private short ParentNameStyleKey;
private short NameElmntTypeKey;
private short DataTypeKey;
private short FieldRankOrder;
private short ValidScriptGroupKey;
private short ValidScriptKey;
private short LeftFieldElmntKey;
private short RightFieldElmntKey;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean IsDetailElmnt;
private boolean Show;
private NameElmntInputDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public NameElmntInputDefns() throws SQLException {
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
model = new NameElmntInputDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setNameElmntInputDefnPid(rs.getInt("NAME_ELMNT_INPUT_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
model.setParentNameStyleKey(rs.getShort("PARENT_NAME_STYLE_KEY"));
model.setNameElmntTypeKey(rs.getShort("NAME_ELMNT_TYPE_KEY"));
model.setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
model.setFieldRankOrder(rs.getShort("FIELD_RANK_ORDER"));
model.setValidScriptGroupKey(rs.getShort("VALID_SCRIPT_GROUP_KEY"));
model.setValidScriptKey(rs.getShort("VALID_SCRIPT_KEY"));
model.setLeftFieldElmntKey(rs.getShort("LEFT_FIELD_ELMNT_KEY"));
model.setRightFieldElmntKey(rs.getShort("RIGHT_FIELD_ELMNT_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setIsDetailElmnt(rs.getBoolean("IS_DETAIL_ELMNT"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public NameElmntInputDefns get(int key) throws SQLException {
model = new NameElmntInputDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setNameElmntInputDefnPid(rs.getInt("NAME_ELMNT_INPUT_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
model.setParentNameStyleKey(rs.getShort("PARENT_NAME_STYLE_KEY"));
model.setNameElmntTypeKey(rs.getShort("NAME_ELMNT_TYPE_KEY"));
model.setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
model.setFieldRankOrder(rs.getShort("FIELD_RANK_ORDER"));
model.setValidScriptGroupKey(rs.getShort("VALID_SCRIPT_GROUP_KEY"));
model.setValidScriptKey(rs.getShort("VALID_SCRIPT_KEY"));
model.setLeftFieldElmntKey(rs.getShort("LEFT_FIELD_ELMNT_KEY"));
model.setRightFieldElmntKey(rs.getShort("RIGHT_FIELD_ELMNT_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setIsDetailElmnt(rs.getBoolean("IS_DETAIL_ELMNT"));
model.setShow(rs.getBoolean("SHOW"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((NameElmntInputDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((NameElmntInputDefns) model).setSetKey(rs.getShort("SET_KEY"));
((NameElmntInputDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((NameElmntInputDefns) model).setNameElmntInputDefnPid(rs.getInt("NAME_ELMNT_INPUT_DEFN_PID"));
((NameElmntInputDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((NameElmntInputDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
((NameElmntInputDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
((NameElmntInputDefns) model).setParentNameStyleKey(rs.getShort("PARENT_NAME_STYLE_KEY"));
((NameElmntInputDefns) model).setNameElmntTypeKey(rs.getShort("NAME_ELMNT_TYPE_KEY"));
((NameElmntInputDefns) model).setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
((NameElmntInputDefns) model).setFieldRankOrder(rs.getShort("FIELD_RANK_ORDER"));
((NameElmntInputDefns) model).setValidScriptGroupKey(rs.getShort("VALID_SCRIPT_GROUP_KEY"));
((NameElmntInputDefns) model).setValidScriptKey(rs.getShort("VALID_SCRIPT_KEY"));
((NameElmntInputDefns) model).setLeftFieldElmntKey(rs.getShort("LEFT_FIELD_ELMNT_KEY"));
((NameElmntInputDefns) model).setRightFieldElmntKey(rs.getShort("RIGHT_FIELD_ELMNT_KEY"));
((NameElmntInputDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((NameElmntInputDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((NameElmntInputDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((NameElmntInputDefns) model).setIsDetailElmnt(rs.getBoolean("IS_DETAIL_ELMNT"));
((NameElmntInputDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((NameElmntInputDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((NameElmntInputDefns) model).setSetKey(rs.getShort("SET_KEY"));
((NameElmntInputDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((NameElmntInputDefns) model).setNameElmntInputDefnPid(rs.getInt("NAME_ELMNT_INPUT_DEFN_PID"));
((NameElmntInputDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((NameElmntInputDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
((NameElmntInputDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
((NameElmntInputDefns) model).setParentNameStyleKey(rs.getShort("PARENT_NAME_STYLE_KEY"));
((NameElmntInputDefns) model).setNameElmntTypeKey(rs.getShort("NAME_ELMNT_TYPE_KEY"));
((NameElmntInputDefns) model).setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
((NameElmntInputDefns) model).setFieldRankOrder(rs.getShort("FIELD_RANK_ORDER"));
((NameElmntInputDefns) model).setValidScriptGroupKey(rs.getShort("VALID_SCRIPT_GROUP_KEY"));
((NameElmntInputDefns) model).setValidScriptKey(rs.getShort("VALID_SCRIPT_KEY"));
((NameElmntInputDefns) model).setLeftFieldElmntKey(rs.getShort("LEFT_FIELD_ELMNT_KEY"));
((NameElmntInputDefns) model).setRightFieldElmntKey(rs.getShort("RIGHT_FIELD_ELMNT_KEY"));
((NameElmntInputDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((NameElmntInputDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((NameElmntInputDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((NameElmntInputDefns) model).setIsDetailElmnt(rs.getBoolean("IS_DETAIL_ELMNT"));
((NameElmntInputDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the NameElmntInputDefnPid field.
*
* @return Contents of the NAME_ELMNT_INPUT_DEFN_PID column
*/
public int getNameElmntInputDefnPid() {
return this.NameElmntInputDefnPid;
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
* Get the EntityTypeKey field.
*
* @return Contents of the ENTITY_TYPE_KEY column
*/
public short getEntityTypeKey() {
return this.EntityTypeKey;
}

/**
* Get the EntitySubTypeKey field.
*
* @return Contents of the ENTITY_SUB_TYPE_KEY column
*/
public short getEntitySubTypeKey() {
return this.EntitySubTypeKey;
}

/**
* Get the ParentNameStyleKey field.
*
* @return Contents of the PARENT_NAME_STYLE_KEY column
*/
public short getParentNameStyleKey() {
return this.ParentNameStyleKey;
}

/**
* Get the NameElmntTypeKey field.
*
* @return Contents of the NAME_ELMNT_TYPE_KEY column
*/
public short getNameElmntTypeKey() {
return this.NameElmntTypeKey;
}

/**
* Get the DataTypeKey field.
*
* @return Contents of the DATA_TYPE_KEY column
*/
public short getDataTypeKey() {
return this.DataTypeKey;
}

/**
* Get the FieldRankOrder field.
*
* @return Contents of the FIELD_RANK_ORDER column
*/
public short getFieldRankOrder() {
return this.FieldRankOrder;
}

/**
* Get the ValidScriptGroupKey field.
*
* @return Contents of the VALID_SCRIPT_GROUP_KEY column
*/
public short getValidScriptGroupKey() {
return this.ValidScriptGroupKey;
}

/**
* Get the ValidScriptKey field.
*
* @return Contents of the VALID_SCRIPT_KEY column
*/
public short getValidScriptKey() {
return this.ValidScriptKey;
}

/**
* Get the LeftFieldElmntKey field.
*
* @return Contents of the LEFT_FIELD_ELMNT_KEY column
*/
public short getLeftFieldElmntKey() {
return this.LeftFieldElmntKey;
}

/**
* Get the RightFieldElmntKey field.
*
* @return Contents of the RIGHT_FIELD_ELMNT_KEY column
*/
public short getRightFieldElmntKey() {
return this.RightFieldElmntKey;
}

/**
* Get the ReminderKey field.
*
* @return Contents of the REMINDER_KEY column
*/
public short getReminderKey() {
return this.ReminderKey;
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
* Get the IsDetailElmnt field.
*
* @return Contents of the IS_DETAIL_ELMNT column
*/
public boolean getIsDetailElmnt() {
return this.IsDetailElmnt;
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
* Set the NameElmntInputDefnPid field
*
* @param NameElmntInputDefnPid Contents of the NAME_ELMNT_INPUT_DEFN_PID column
*/
public void setNameElmntInputDefnPid(int NameElmntInputDefnPid) {
this.NameElmntInputDefnPid = NameElmntInputDefnPid;
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
* Set the EntityTypeKey field
*
* @param EntityTypeKey Contents of the ENTITY_TYPE_KEY column
*/
public void setEntityTypeKey(short EntityTypeKey) {
this.EntityTypeKey = EntityTypeKey;
}

/**
* Set the EntitySubTypeKey field
*
* @param EntitySubTypeKey Contents of the ENTITY_SUB_TYPE_KEY column
*/
public void setEntitySubTypeKey(short EntitySubTypeKey) {
this.EntitySubTypeKey = EntitySubTypeKey;
}

/**
* Set the ParentNameStyleKey field
*
* @param ParentNameStyleKey Contents of the PARENT_NAME_STYLE_KEY column
*/
public void setParentNameStyleKey(short ParentNameStyleKey) {
this.ParentNameStyleKey = ParentNameStyleKey;
}

/**
* Set the NameElmntTypeKey field
*
* @param NameElmntTypeKey Contents of the NAME_ELMNT_TYPE_KEY column
*/
public void setNameElmntTypeKey(short NameElmntTypeKey) {
this.NameElmntTypeKey = NameElmntTypeKey;
}

/**
* Set the DataTypeKey field
*
* @param DataTypeKey Contents of the DATA_TYPE_KEY column
*/
public void setDataTypeKey(short DataTypeKey) {
this.DataTypeKey = DataTypeKey;
}

/**
* Set the FieldRankOrder field
*
* @param FieldRankOrder Contents of the FIELD_RANK_ORDER column
*/
public void setFieldRankOrder(short FieldRankOrder) {
this.FieldRankOrder = FieldRankOrder;
}

/**
* Set the ValidScriptGroupKey field
*
* @param ValidScriptGroupKey Contents of the VALID_SCRIPT_GROUP_KEY column
*/
public void setValidScriptGroupKey(short ValidScriptGroupKey) {
this.ValidScriptGroupKey = ValidScriptGroupKey;
}

/**
* Set the ValidScriptKey field
*
* @param ValidScriptKey Contents of the VALID_SCRIPT_KEY column
*/
public void setValidScriptKey(short ValidScriptKey) {
this.ValidScriptKey = ValidScriptKey;
}

/**
* Set the LeftFieldElmntKey field
*
* @param LeftFieldElmntKey Contents of the LEFT_FIELD_ELMNT_KEY column
*/
public void setLeftFieldElmntKey(short LeftFieldElmntKey) {
this.LeftFieldElmntKey = LeftFieldElmntKey;
}

/**
* Set the RightFieldElmntKey field
*
* @param RightFieldElmntKey Contents of the RIGHT_FIELD_ELMNT_KEY column
*/
public void setRightFieldElmntKey(short RightFieldElmntKey) {
this.RightFieldElmntKey = RightFieldElmntKey;
}

/**
* Set the ReminderKey field
*
* @param ReminderKey Contents of the REMINDER_KEY column
*/
public void setReminderKey(short ReminderKey) {
this.ReminderKey = ReminderKey;
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
* Set the IsDetailElmnt field
*
* @param IsDetailElmnt Contents of the IS_DETAIL_ELMNT column
*/
public void setIsDetailElmnt(boolean IsDetailElmnt) {
this.IsDetailElmnt = IsDetailElmnt;
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

