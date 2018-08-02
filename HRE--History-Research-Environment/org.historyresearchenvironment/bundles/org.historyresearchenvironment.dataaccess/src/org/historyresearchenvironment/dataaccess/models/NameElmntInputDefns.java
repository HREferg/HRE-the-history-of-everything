package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the NAME_ELMNT_INPUT_DEFNS database table.
*
* @version 2018-08-02
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

public NameElmntInputDefns() throws SQLException {
}


public NameElmntInputDefns(int NameElmntInputDefnPid) throws SQLException {
super();
this.NameElmntInputDefnPid = NameElmntInputDefnPid;
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
public AbstractHreDataModel get(int key) throws SQLException {
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
return this;
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

public int getRecordNum() {
return this.RecordNum;
}

public short getSetKey() {
return this.SetKey;
}

public int getCommitPid() {
return this.CommitPid;
}

public int getNameElmntInputDefnPid() {
return this.NameElmntInputDefnPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public short getEntityTypeKey() {
return this.EntityTypeKey;
}

public short getEntitySubTypeKey() {
return this.EntitySubTypeKey;
}

public short getParentNameStyleKey() {
return this.ParentNameStyleKey;
}

public short getNameElmntTypeKey() {
return this.NameElmntTypeKey;
}

public short getDataTypeKey() {
return this.DataTypeKey;
}

public short getFieldRankOrder() {
return this.FieldRankOrder;
}

public short getValidScriptGroupKey() {
return this.ValidScriptGroupKey;
}

public short getValidScriptKey() {
return this.ValidScriptKey;
}

public short getLeftFieldElmntKey() {
return this.LeftFieldElmntKey;
}

public short getRightFieldElmntKey() {
return this.RightFieldElmntKey;
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

public boolean getIsDetailElmnt() {
return this.IsDetailElmnt;
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

public void setNameElmntInputDefnPid(int NameElmntInputDefnPid) {
this.NameElmntInputDefnPid = NameElmntInputDefnPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setEntityTypeKey(short EntityTypeKey) {
this.EntityTypeKey = EntityTypeKey;
}

public void setEntitySubTypeKey(short EntitySubTypeKey) {
this.EntitySubTypeKey = EntitySubTypeKey;
}

public void setParentNameStyleKey(short ParentNameStyleKey) {
this.ParentNameStyleKey = ParentNameStyleKey;
}

public void setNameElmntTypeKey(short NameElmntTypeKey) {
this.NameElmntTypeKey = NameElmntTypeKey;
}

public void setDataTypeKey(short DataTypeKey) {
this.DataTypeKey = DataTypeKey;
}

public void setFieldRankOrder(short FieldRankOrder) {
this.FieldRankOrder = FieldRankOrder;
}

public void setValidScriptGroupKey(short ValidScriptGroupKey) {
this.ValidScriptGroupKey = ValidScriptGroupKey;
}

public void setValidScriptKey(short ValidScriptKey) {
this.ValidScriptKey = ValidScriptKey;
}

public void setLeftFieldElmntKey(short LeftFieldElmntKey) {
this.LeftFieldElmntKey = LeftFieldElmntKey;
}

public void setRightFieldElmntKey(short RightFieldElmntKey) {
this.RightFieldElmntKey = RightFieldElmntKey;
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

public void setIsDetailElmnt(boolean IsDetailElmnt) {
this.IsDetailElmnt = IsDetailElmnt;
}

public void setShow(boolean Show) {
this.Show = Show;
}

}

