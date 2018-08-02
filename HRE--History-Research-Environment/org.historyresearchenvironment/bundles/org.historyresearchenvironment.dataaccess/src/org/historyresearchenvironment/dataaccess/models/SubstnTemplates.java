package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSTN_TEMPLATES database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SubstnTemplates extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SUBSTN_TEMPLATE_PID, " +
"IS_SYSTEM, " +
"LAYOUT_STYLE_CLASS_KEY, " +
"PARENT_STEP_PID, " +
"SCRIPT_GROUP_KEY, " +
"SCRIPT_KEY, " +
"PARAMS_SET_KEY, " +
"THIS_PARAMS_KEY, " +
"DEFLT_PARAMS_KEY, " +
"DISPLAY_ORDER, " +
"SHOW FROM PUBLIC.SUBSTN_TEMPLATES WHERE SUBSTN_TEMPLATE_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SUBSTN_TEMPLATE_PID, " +  
"IS_SYSTEM, " +  
"LAYOUT_STYLE_CLASS_KEY, " +  
"PARENT_STEP_PID, " +  
"SCRIPT_GROUP_KEY, " +  
"SCRIPT_KEY, " +  
"PARAMS_SET_KEY, " +  
"THIS_PARAMS_KEY, " +  
"DEFLT_PARAMS_KEY, " +  
"DISPLAY_ORDER, " +  
"SHOW FROM PUBLIC.SUBSTN_TEMPLATES";

private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_TEMPLATES( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SUBSTN_TEMPLATE_PID, " +     
"IS_SYSTEM, " +     
"LAYOUT_STYLE_CLASS_KEY, " +     
"PARENT_STEP_PID, " +     
"SCRIPT_GROUP_KEY, " +     
"SCRIPT_KEY, " +     
"PARAMS_SET_KEY, " +     
"THIS_PARAMS_KEY, " +     
"DEFLT_PARAMS_KEY, " +     
"DISPLAY_ORDER, " +     
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

private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_TEMPLATESSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"LAYOUT_STYLE_CLASS_KEY = ?, " + 
"PARENT_STEP_PID = ?, " + 
"SCRIPT_GROUP_KEY = ?, " + 
"SCRIPT_KEY = ?, " + 
"PARAMS_SET_KEY = ?, " + 
"THIS_PARAMS_KEY = ?, " + 
"DEFLT_PARAMS_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"SHOW = ? WHERE SUBSTN_TEMPLATE_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_TEMPLATES WHERE SUBSTN_TEMPLATE_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_TEMPLATES";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SubstnTemplatePid;
private boolean IsSystem;
private short LayoutStyleClassKey;
private int ParentStepPid;
private short ScriptGroupKey;
private short ScriptKey;
private short ParamsSetKey;
private short ThisParamsKey;
private short DefltParamsKey;
private short DisplayOrder;
private boolean Show;
private SubstnTemplates model;

public SubstnTemplates() throws SQLException {
}


public SubstnTemplates(int SubstnTemplatePid) throws SQLException {
super();
this.SubstnTemplatePid = SubstnTemplatePid;
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
model = new SubstnTemplates();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSubstnTemplatePid(rs.getInt("SUBSTN_TEMPLATE_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setLayoutStyleClassKey(rs.getShort("LAYOUT_STYLE_CLASS_KEY"));
model.setParentStepPid(rs.getInt("PARENT_STEP_PID"));
model.setScriptGroupKey(rs.getShort("SCRIPT_GROUP_KEY"));
model.setScriptKey(rs.getShort("SCRIPT_KEY"));
model.setParamsSetKey(rs.getShort("PARAMS_SET_KEY"));
model.setThisParamsKey(rs.getShort("THIS_PARAMS_KEY"));
model.setDefltParamsKey(rs.getShort("DEFLT_PARAMS_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
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
model.setSubstnTemplatePid(rs.getInt("SUBSTN_TEMPLATE_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setLayoutStyleClassKey(rs.getShort("LAYOUT_STYLE_CLASS_KEY"));
model.setParentStepPid(rs.getInt("PARENT_STEP_PID"));
model.setScriptGroupKey(rs.getShort("SCRIPT_GROUP_KEY"));
model.setScriptKey(rs.getShort("SCRIPT_KEY"));
model.setParamsSetKey(rs.getShort("PARAMS_SET_KEY"));
model.setThisParamsKey(rs.getShort("THIS_PARAMS_KEY"));
model.setDefltParamsKey(rs.getShort("DEFLT_PARAMS_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setShow(rs.getBoolean("SHOW"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((SubstnTemplates) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubstnTemplates) model).setSetKey(rs.getShort("SET_KEY"));
((SubstnTemplates) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubstnTemplates) model).setSubstnTemplatePid(rs.getInt("SUBSTN_TEMPLATE_PID"));
((SubstnTemplates) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SubstnTemplates) model).setLayoutStyleClassKey(rs.getShort("LAYOUT_STYLE_CLASS_KEY"));
((SubstnTemplates) model).setParentStepPid(rs.getInt("PARENT_STEP_PID"));
((SubstnTemplates) model).setScriptGroupKey(rs.getShort("SCRIPT_GROUP_KEY"));
((SubstnTemplates) model).setScriptKey(rs.getShort("SCRIPT_KEY"));
((SubstnTemplates) model).setParamsSetKey(rs.getShort("PARAMS_SET_KEY"));
((SubstnTemplates) model).setThisParamsKey(rs.getShort("THIS_PARAMS_KEY"));
((SubstnTemplates) model).setDefltParamsKey(rs.getShort("DEFLT_PARAMS_KEY"));
((SubstnTemplates) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SubstnTemplates) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((SubstnTemplates) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubstnTemplates) model).setSetKey(rs.getShort("SET_KEY"));
((SubstnTemplates) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubstnTemplates) model).setSubstnTemplatePid(rs.getInt("SUBSTN_TEMPLATE_PID"));
((SubstnTemplates) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((SubstnTemplates) model).setLayoutStyleClassKey(rs.getShort("LAYOUT_STYLE_CLASS_KEY"));
((SubstnTemplates) model).setParentStepPid(rs.getInt("PARENT_STEP_PID"));
((SubstnTemplates) model).setScriptGroupKey(rs.getShort("SCRIPT_GROUP_KEY"));
((SubstnTemplates) model).setScriptKey(rs.getShort("SCRIPT_KEY"));
((SubstnTemplates) model).setParamsSetKey(rs.getShort("PARAMS_SET_KEY"));
((SubstnTemplates) model).setThisParamsKey(rs.getShort("THIS_PARAMS_KEY"));
((SubstnTemplates) model).setDefltParamsKey(rs.getShort("DEFLT_PARAMS_KEY"));
((SubstnTemplates) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SubstnTemplates) model).setShow(rs.getBoolean("SHOW"));
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

public int getSubstnTemplatePid() {
return this.SubstnTemplatePid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public short getLayoutStyleClassKey() {
return this.LayoutStyleClassKey;
}

public int getParentStepPid() {
return this.ParentStepPid;
}

public short getScriptGroupKey() {
return this.ScriptGroupKey;
}

public short getScriptKey() {
return this.ScriptKey;
}

public short getParamsSetKey() {
return this.ParamsSetKey;
}

public short getThisParamsKey() {
return this.ThisParamsKey;
}

public short getDefltParamsKey() {
return this.DefltParamsKey;
}

public short getDisplayOrder() {
return this.DisplayOrder;
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

public void setSubstnTemplatePid(int SubstnTemplatePid) {
this.SubstnTemplatePid = SubstnTemplatePid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setLayoutStyleClassKey(short LayoutStyleClassKey) {
this.LayoutStyleClassKey = LayoutStyleClassKey;
}

public void setParentStepPid(int ParentStepPid) {
this.ParentStepPid = ParentStepPid;
}

public void setScriptGroupKey(short ScriptGroupKey) {
this.ScriptGroupKey = ScriptGroupKey;
}

public void setScriptKey(short ScriptKey) {
this.ScriptKey = ScriptKey;
}

public void setParamsSetKey(short ParamsSetKey) {
this.ParamsSetKey = ParamsSetKey;
}

public void setThisParamsKey(short ThisParamsKey) {
this.ThisParamsKey = ThisParamsKey;
}

public void setDefltParamsKey(short DefltParamsKey) {
this.DefltParamsKey = DefltParamsKey;
}

public void setDisplayOrder(short DisplayOrder) {
this.DisplayOrder = DisplayOrder;
}

public void setShow(boolean Show) {
this.Show = Show;
}

}

