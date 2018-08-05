package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the OUTPUT_TEMPLATE_TRANS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class OutputTemplateTrans extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"OUTPUT_TEMPLATE_TRAN_PID, " +
"IS_SYSTEM, " +
"PLUGIN_KEY, " +
"ENTITY_TYPE_KEY, " +
"SUB_TYPE_KEY, " +
"SENTCE_STYLE_TYPE_KEY, " +
"NAME_STYLE_KEY, " +
"TEMPLATE_TYPE_KEY, " +
"LANG_CODE, " +
"TEMPLATE FROM PUBLIC.OUTPUT_TEMPLATE_TRANS WHERE OUTPUT_TEMPLATE_TRAN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"OUTPUT_TEMPLATE_TRAN_PID, " +  
"IS_SYSTEM, " +  
"PLUGIN_KEY, " +  
"ENTITY_TYPE_KEY, " +  
"SUB_TYPE_KEY, " +  
"SENTCE_STYLE_TYPE_KEY, " +  
"NAME_STYLE_KEY, " +  
"TEMPLATE_TYPE_KEY, " +  
"LANG_CODE, " +  
"TEMPLATE FROM PUBLIC.OUTPUT_TEMPLATE_TRANS";

private static final String INSERT = "INSERT INTO PUBLIC.OUTPUT_TEMPLATE_TRANS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"OUTPUT_TEMPLATE_TRAN_PID, " +     
"IS_SYSTEM, " +     
"PLUGIN_KEY, " +     
"ENTITY_TYPE_KEY, " +     
"SUB_TYPE_KEY, " +     
"SENTCE_STYLE_TYPE_KEY, " +     
"NAME_STYLE_KEY, " +     
"TEMPLATE_TYPE_KEY, " +     
"LANG_CODE, " +     
"TEMPLATE) VALUES (?, " +
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

private static final String UPDATE = "UPDATE PUBLIC.OUTPUT_TEMPLATE_TRANSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PLUGIN_KEY = ?, " + 
"ENTITY_TYPE_KEY = ?, " + 
"SUB_TYPE_KEY = ?, " + 
"SENTCE_STYLE_TYPE_KEY = ?, " + 
"NAME_STYLE_KEY = ?, " + 
"TEMPLATE_TYPE_KEY = ?, " + 
"LANG_CODE = ?, " + 
"TEMPLATE = ? WHERE OUTPUT_TEMPLATE_TRAN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.OUTPUT_TEMPLATE_TRANS WHERE OUTPUT_TEMPLATE_TRAN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.OUTPUT_TEMPLATE_TRANS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int OutputTemplateTranPid;
private boolean IsSystem;
private short PluginKey;
private short EntityTypeKey;
private short SubTypeKey;
private short SentceStyleTypeKey;
private short NameStyleKey;
private short TemplateTypeKey;
private String LangCode;
private String Template;
private OutputTemplateTrans model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public OutputTemplateTrans() throws SQLException {
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
model = new OutputTemplateTrans();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOutputTemplateTranPid(rs.getInt("OUTPUT_TEMPLATE_TRAN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setPluginKey(rs.getShort("PLUGIN_KEY"));
model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
model.setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
model.setNameStyleKey(rs.getShort("NAME_STYLE_KEY"));
model.setTemplateTypeKey(rs.getShort("TEMPLATE_TYPE_KEY"));
model.setLangCode(rs.getString("LANG_CODE"));
model.setTemplate(rs.getString("TEMPLATE"));
modelList.add(model);
}
return modelList;
}

@Override
public OutputTemplateTrans get(int key) throws SQLException {
model = new OutputTemplateTrans();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setOutputTemplateTranPid(rs.getInt("OUTPUT_TEMPLATE_TRAN_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setPluginKey(rs.getShort("PLUGIN_KEY"));
model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
model.setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
model.setNameStyleKey(rs.getShort("NAME_STYLE_KEY"));
model.setTemplateTypeKey(rs.getShort("TEMPLATE_TYPE_KEY"));
model.setLangCode(rs.getString("LANG_CODE"));
model.setTemplate(rs.getString("TEMPLATE"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((OutputTemplateTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OutputTemplateTrans) model).setSetKey(rs.getShort("SET_KEY"));
((OutputTemplateTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OutputTemplateTrans) model).setOutputTemplateTranPid(rs.getInt("OUTPUT_TEMPLATE_TRAN_PID"));
((OutputTemplateTrans) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((OutputTemplateTrans) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
((OutputTemplateTrans) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
((OutputTemplateTrans) model).setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
((OutputTemplateTrans) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
((OutputTemplateTrans) model).setNameStyleKey(rs.getShort("NAME_STYLE_KEY"));
((OutputTemplateTrans) model).setTemplateTypeKey(rs.getShort("TEMPLATE_TYPE_KEY"));
((OutputTemplateTrans) model).setLangCode(rs.getString("LANG_CODE"));
((OutputTemplateTrans) model).setTemplate(rs.getString("TEMPLATE"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((OutputTemplateTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
((OutputTemplateTrans) model).setSetKey(rs.getShort("SET_KEY"));
((OutputTemplateTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
((OutputTemplateTrans) model).setOutputTemplateTranPid(rs.getInt("OUTPUT_TEMPLATE_TRAN_PID"));
((OutputTemplateTrans) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((OutputTemplateTrans) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
((OutputTemplateTrans) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
((OutputTemplateTrans) model).setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
((OutputTemplateTrans) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
((OutputTemplateTrans) model).setNameStyleKey(rs.getShort("NAME_STYLE_KEY"));
((OutputTemplateTrans) model).setTemplateTypeKey(rs.getShort("TEMPLATE_TYPE_KEY"));
((OutputTemplateTrans) model).setLangCode(rs.getString("LANG_CODE"));
((OutputTemplateTrans) model).setTemplate(rs.getString("TEMPLATE"));
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
* Get the OutputTemplateTranPid field.
*
* @return Contents of the OUTPUT_TEMPLATE_TRAN_PID column
*/
public int getOutputTemplateTranPid() {
return this.OutputTemplateTranPid;
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
* Get the PluginKey field.
*
* @return Contents of the PLUGIN_KEY column
*/
public short getPluginKey() {
return this.PluginKey;
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
* Get the SubTypeKey field.
*
* @return Contents of the SUB_TYPE_KEY column
*/
public short getSubTypeKey() {
return this.SubTypeKey;
}

/**
* Get the SentceStyleTypeKey field.
*
* @return Contents of the SENTCE_STYLE_TYPE_KEY column
*/
public short getSentceStyleTypeKey() {
return this.SentceStyleTypeKey;
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
* Get the TemplateTypeKey field.
*
* @return Contents of the TEMPLATE_TYPE_KEY column
*/
public short getTemplateTypeKey() {
return this.TemplateTypeKey;
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
* Get the Template field.
*
* @return Contents of the TEMPLATE column
*/
public String getTemplate() {
return this.Template;
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
* Set the OutputTemplateTranPid field
*
* @param OutputTemplateTranPid Contents of the OUTPUT_TEMPLATE_TRAN_PID column
*/
public void setOutputTemplateTranPid(int OutputTemplateTranPid) {
this.OutputTemplateTranPid = OutputTemplateTranPid;
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
* Set the PluginKey field
*
* @param PluginKey Contents of the PLUGIN_KEY column
*/
public void setPluginKey(short PluginKey) {
this.PluginKey = PluginKey;
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
* Set the SubTypeKey field
*
* @param SubTypeKey Contents of the SUB_TYPE_KEY column
*/
public void setSubTypeKey(short SubTypeKey) {
this.SubTypeKey = SubTypeKey;
}

/**
* Set the SentceStyleTypeKey field
*
* @param SentceStyleTypeKey Contents of the SENTCE_STYLE_TYPE_KEY column
*/
public void setSentceStyleTypeKey(short SentceStyleTypeKey) {
this.SentceStyleTypeKey = SentceStyleTypeKey;
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
* Set the TemplateTypeKey field
*
* @param TemplateTypeKey Contents of the TEMPLATE_TYPE_KEY column
*/
public void setTemplateTypeKey(short TemplateTypeKey) {
this.TemplateTypeKey = TemplateTypeKey;
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
* Set the Template field
*
* @param Template Contents of the TEMPLATE column
*/
public void setTemplate(String Template) {
this.Template = Template;
}

}

