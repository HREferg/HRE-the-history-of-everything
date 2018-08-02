package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the OUTPUT_TEMPLATE_TRANS database table.
*
* @version 2018-08-02
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

public OutputTemplateTrans() throws SQLException {
}


public OutputTemplateTrans(int OutputTemplateTranPid) throws SQLException {
super();
this.OutputTemplateTranPid = OutputTemplateTranPid;
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
public AbstractHreDataModel get(int key) throws SQLException {
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
return this;
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

public int getRecordNum() {
return this.RecordNum;
}

public short getSetKey() {
return this.SetKey;
}

public int getCommitPid() {
return this.CommitPid;
}

public int getOutputTemplateTranPid() {
return this.OutputTemplateTranPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public short getPluginKey() {
return this.PluginKey;
}

public short getEntityTypeKey() {
return this.EntityTypeKey;
}

public short getSubTypeKey() {
return this.SubTypeKey;
}

public short getSentceStyleTypeKey() {
return this.SentceStyleTypeKey;
}

public short getNameStyleKey() {
return this.NameStyleKey;
}

public short getTemplateTypeKey() {
return this.TemplateTypeKey;
}

public String getLangCode() {
return this.LangCode;
}

public String getTemplate() {
return this.Template;
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

public void setOutputTemplateTranPid(int OutputTemplateTranPid) {
this.OutputTemplateTranPid = OutputTemplateTranPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setPluginKey(short PluginKey) {
this.PluginKey = PluginKey;
}

public void setEntityTypeKey(short EntityTypeKey) {
this.EntityTypeKey = EntityTypeKey;
}

public void setSubTypeKey(short SubTypeKey) {
this.SubTypeKey = SubTypeKey;
}

public void setSentceStyleTypeKey(short SentceStyleTypeKey) {
this.SentceStyleTypeKey = SentceStyleTypeKey;
}

public void setNameStyleKey(short NameStyleKey) {
this.NameStyleKey = NameStyleKey;
}

public void setTemplateTypeKey(short TemplateTypeKey) {
this.TemplateTypeKey = TemplateTypeKey;
}

public void setLangCode(String LangCode) {
this.LangCode = LangCode;
}

public void setTemplate(String Template) {
this.Template = Template;
}

}

