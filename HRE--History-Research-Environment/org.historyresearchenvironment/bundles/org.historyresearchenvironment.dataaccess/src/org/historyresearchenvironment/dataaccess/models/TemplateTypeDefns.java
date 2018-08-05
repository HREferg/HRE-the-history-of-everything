package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the TEMPLATE_TYPE_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class TemplateTypeDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"TEMPLATE_TYPE_DEFN_PID, " +
"IS_SYSTEM, " +
"IS_MANDATORY, " +
"ENTITY_TYPE_KEY, " +
"ENTITY_SUB_TYPE_KEY, " +
"PUBLISH_TYPE_KEY, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.TEMPLATE_TYPE_DEFNS WHERE TEMPLATE_TYPE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"TEMPLATE_TYPE_DEFN_PID, " +  
"IS_SYSTEM, " +  
"IS_MANDATORY, " +  
"ENTITY_TYPE_KEY, " +  
"ENTITY_SUB_TYPE_KEY, " +  
"PUBLISH_TYPE_KEY, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.TEMPLATE_TYPE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.TEMPLATE_TYPE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"TEMPLATE_TYPE_DEFN_PID, " +     
"IS_SYSTEM, " +     
"IS_MANDATORY, " +     
"ENTITY_TYPE_KEY, " +     
"ENTITY_SUB_TYPE_KEY, " +     
"PUBLISH_TYPE_KEY, " +     
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
"?)";

private static final String UPDATE = "UPDATE PUBLIC.TEMPLATE_TYPE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"IS_MANDATORY = ?, " + 
"ENTITY_TYPE_KEY = ?, " + 
"ENTITY_SUB_TYPE_KEY = ?, " + 
"PUBLISH_TYPE_KEY = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE TEMPLATE_TYPE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.TEMPLATE_TYPE_DEFNS WHERE TEMPLATE_TYPE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.TEMPLATE_TYPE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int TemplateTypeDefnPid;
private boolean IsSystem;
private boolean IsMandatory;
private short EntityTypeKey;
private short EntitySubTypeKey;
private short PublishTypeKey;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private TemplateTypeDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public TemplateTypeDefns() throws SQLException {
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
model = new TemplateTypeDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setTemplateTypeDefnPid(rs.getInt("TEMPLATE_TYPE_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setIsMandatory(rs.getBoolean("IS_MANDATORY"));
model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
model.setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public TemplateTypeDefns get(int key) throws SQLException {
model = new TemplateTypeDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setTemplateTypeDefnPid(rs.getInt("TEMPLATE_TYPE_DEFN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setIsMandatory(rs.getBoolean("IS_MANDATORY"));
model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
model.setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((TemplateTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((TemplateTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((TemplateTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((TemplateTypeDefns) model).setTemplateTypeDefnPid(rs.getInt("TEMPLATE_TYPE_DEFN_PID"));
((TemplateTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((TemplateTypeDefns) model).setIsMandatory(rs.getBoolean("IS_MANDATORY"));
((TemplateTypeDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
((TemplateTypeDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
((TemplateTypeDefns) model).setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
((TemplateTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((TemplateTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((TemplateTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((TemplateTypeDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((TemplateTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((TemplateTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
((TemplateTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((TemplateTypeDefns) model).setTemplateTypeDefnPid(rs.getInt("TEMPLATE_TYPE_DEFN_PID"));
((TemplateTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((TemplateTypeDefns) model).setIsMandatory(rs.getBoolean("IS_MANDATORY"));
((TemplateTypeDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
((TemplateTypeDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
((TemplateTypeDefns) model).setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
((TemplateTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((TemplateTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((TemplateTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((TemplateTypeDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the TemplateTypeDefnPid field.
*
* @return Contents of the TEMPLATE_TYPE_DEFN_PID column
*/
public int getTemplateTypeDefnPid() {
return this.TemplateTypeDefnPid;
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
* Get the IsMandatory field.
*
* @return Contents of the IS_MANDATORY column
*/
public boolean getIsMandatory() {
return this.IsMandatory;
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
* Get the PublishTypeKey field.
*
* @return Contents of the PUBLISH_TYPE_KEY column
*/
public short getPublishTypeKey() {
return this.PublishTypeKey;
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
* Set the TemplateTypeDefnPid field
*
* @param TemplateTypeDefnPid Contents of the TEMPLATE_TYPE_DEFN_PID column
*/
public void setTemplateTypeDefnPid(int TemplateTypeDefnPid) {
this.TemplateTypeDefnPid = TemplateTypeDefnPid;
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
* Set the IsMandatory field
*
* @param IsMandatory Contents of the IS_MANDATORY column
*/
public void setIsMandatory(boolean IsMandatory) {
this.IsMandatory = IsMandatory;
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
* Set the PublishTypeKey field
*
* @param PublishTypeKey Contents of the PUBLISH_TYPE_KEY column
*/
public void setPublishTypeKey(short PublishTypeKey) {
this.PublishTypeKey = PublishTypeKey;
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
* Set the Show field
*
* @param Show Contents of the SHOW column
*/
public void setShow(boolean Show) {
this.Show = Show;
}

}

