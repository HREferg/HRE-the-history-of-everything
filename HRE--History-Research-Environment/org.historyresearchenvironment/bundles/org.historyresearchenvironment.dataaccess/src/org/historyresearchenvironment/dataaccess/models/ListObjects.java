package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the LIST_OBJECTS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class ListObjects extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"LIST_OBJECT_PID, " +
"IS_SYSTEM, " +
"PARENT_OBJ_SET_KEY, " +
"USE_ORDER, " +
"OBJECT_ALIAS, " +
"USE_ALIAS_LABEL, " +
"MARGIN_LABEL, " +
"LABEL_STYLE_KEY, " +
"CELL_STYLE_KEY, " +
"CELL_MIN_WIDTH, " +
"CELL_MIN_HEIGHT, " +
"CELL_NOW_WIDTH, " +
"CELL_NOW_HEIGHT, " +
"ACCENT_KEY, " +
"ACCENT_ALIAS FROM PUBLIC.LIST_OBJECTS WHERE LIST_OBJECT_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"LIST_OBJECT_PID, " +  
"IS_SYSTEM, " +  
"PARENT_OBJ_SET_KEY, " +  
"USE_ORDER, " +  
"OBJECT_ALIAS, " +  
"USE_ALIAS_LABEL, " +  
"MARGIN_LABEL, " +  
"LABEL_STYLE_KEY, " +  
"CELL_STYLE_KEY, " +  
"CELL_MIN_WIDTH, " +  
"CELL_MIN_HEIGHT, " +  
"CELL_NOW_WIDTH, " +  
"CELL_NOW_HEIGHT, " +  
"ACCENT_KEY, " +  
"ACCENT_ALIAS FROM PUBLIC.LIST_OBJECTS";

private static final String INSERT = "INSERT INTO PUBLIC.LIST_OBJECTS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"LIST_OBJECT_PID, " +     
"IS_SYSTEM, " +     
"PARENT_OBJ_SET_KEY, " +     
"USE_ORDER, " +     
"OBJECT_ALIAS, " +     
"USE_ALIAS_LABEL, " +     
"MARGIN_LABEL, " +     
"LABEL_STYLE_KEY, " +     
"CELL_STYLE_KEY, " +     
"CELL_MIN_WIDTH, " +     
"CELL_MIN_HEIGHT, " +     
"CELL_NOW_WIDTH, " +     
"CELL_NOW_HEIGHT, " +     
"ACCENT_KEY, " +     
"ACCENT_ALIAS) VALUES (?, " +
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

private static final String UPDATE = "UPDATE PUBLIC.LIST_OBJECTSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PARENT_OBJ_SET_KEY = ?, " + 
"USE_ORDER = ?, " + 
"OBJECT_ALIAS = ?, " + 
"USE_ALIAS_LABEL = ?, " + 
"MARGIN_LABEL = ?, " + 
"LABEL_STYLE_KEY = ?, " + 
"CELL_STYLE_KEY = ?, " + 
"CELL_MIN_WIDTH = ?, " + 
"CELL_MIN_HEIGHT = ?, " + 
"CELL_NOW_WIDTH = ?, " + 
"CELL_NOW_HEIGHT = ?, " + 
"ACCENT_KEY = ?, " + 
"ACCENT_ALIAS = ? WHERE LIST_OBJECT_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.LIST_OBJECTS WHERE LIST_OBJECT_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.LIST_OBJECTS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int ListObjectPid;
private boolean IsSystem;
private short ParentObjSetKey;
private short UseOrder;
private String ObjectAlias;
private boolean UseAliasLabel;
private String MarginLabel;
private short LabelStyleKey;
private short CellStyleKey;
private short CellMinWidth;
private short CellMinHeight;
private short CellNowWidth;
private short CellNowHeight;
private short AccentKey;
private String AccentAlias;
private ListObjects model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public ListObjects() throws SQLException {
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
model = new ListObjects();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setListObjectPid(rs.getInt("LIST_OBJECT_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentObjSetKey(rs.getShort("PARENT_OBJ_SET_KEY"));
model.setUseOrder(rs.getShort("USE_ORDER"));
model.setObjectAlias(rs.getString("OBJECT_ALIAS"));
model.setUseAliasLabel(rs.getBoolean("USE_ALIAS_LABEL"));
model.setMarginLabel(rs.getString("MARGIN_LABEL"));
model.setLabelStyleKey(rs.getShort("LABEL_STYLE_KEY"));
model.setCellStyleKey(rs.getShort("CELL_STYLE_KEY"));
model.setCellMinWidth(rs.getShort("CELL_MIN_WIDTH"));
model.setCellMinHeight(rs.getShort("CELL_MIN_HEIGHT"));
model.setCellNowWidth(rs.getShort("CELL_NOW_WIDTH"));
model.setCellNowHeight(rs.getShort("CELL_NOW_HEIGHT"));
model.setAccentKey(rs.getShort("ACCENT_KEY"));
model.setAccentAlias(rs.getString("ACCENT_ALIAS"));
modelList.add(model);
}
return modelList;
}

@Override
public ListObjects get(int key) throws SQLException {
model = new ListObjects();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setListObjectPid(rs.getInt("LIST_OBJECT_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentObjSetKey(rs.getShort("PARENT_OBJ_SET_KEY"));
model.setUseOrder(rs.getShort("USE_ORDER"));
model.setObjectAlias(rs.getString("OBJECT_ALIAS"));
model.setUseAliasLabel(rs.getBoolean("USE_ALIAS_LABEL"));
model.setMarginLabel(rs.getString("MARGIN_LABEL"));
model.setLabelStyleKey(rs.getShort("LABEL_STYLE_KEY"));
model.setCellStyleKey(rs.getShort("CELL_STYLE_KEY"));
model.setCellMinWidth(rs.getShort("CELL_MIN_WIDTH"));
model.setCellMinHeight(rs.getShort("CELL_MIN_HEIGHT"));
model.setCellNowWidth(rs.getShort("CELL_NOW_WIDTH"));
model.setCellNowHeight(rs.getShort("CELL_NOW_HEIGHT"));
model.setAccentKey(rs.getShort("ACCENT_KEY"));
model.setAccentAlias(rs.getString("ACCENT_ALIAS"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((ListObjects) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ListObjects) model).setSetKey(rs.getShort("SET_KEY"));
((ListObjects) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ListObjects) model).setListObjectPid(rs.getInt("LIST_OBJECT_PID"));
((ListObjects) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((ListObjects) model).setParentObjSetKey(rs.getShort("PARENT_OBJ_SET_KEY"));
((ListObjects) model).setUseOrder(rs.getShort("USE_ORDER"));
((ListObjects) model).setObjectAlias(rs.getString("OBJECT_ALIAS"));
((ListObjects) model).setUseAliasLabel(rs.getBoolean("USE_ALIAS_LABEL"));
((ListObjects) model).setMarginLabel(rs.getString("MARGIN_LABEL"));
((ListObjects) model).setLabelStyleKey(rs.getShort("LABEL_STYLE_KEY"));
((ListObjects) model).setCellStyleKey(rs.getShort("CELL_STYLE_KEY"));
((ListObjects) model).setCellMinWidth(rs.getShort("CELL_MIN_WIDTH"));
((ListObjects) model).setCellMinHeight(rs.getShort("CELL_MIN_HEIGHT"));
((ListObjects) model).setCellNowWidth(rs.getShort("CELL_NOW_WIDTH"));
((ListObjects) model).setCellNowHeight(rs.getShort("CELL_NOW_HEIGHT"));
((ListObjects) model).setAccentKey(rs.getShort("ACCENT_KEY"));
((ListObjects) model).setAccentAlias(rs.getString("ACCENT_ALIAS"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((ListObjects) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ListObjects) model).setSetKey(rs.getShort("SET_KEY"));
((ListObjects) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ListObjects) model).setListObjectPid(rs.getInt("LIST_OBJECT_PID"));
((ListObjects) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((ListObjects) model).setParentObjSetKey(rs.getShort("PARENT_OBJ_SET_KEY"));
((ListObjects) model).setUseOrder(rs.getShort("USE_ORDER"));
((ListObjects) model).setObjectAlias(rs.getString("OBJECT_ALIAS"));
((ListObjects) model).setUseAliasLabel(rs.getBoolean("USE_ALIAS_LABEL"));
((ListObjects) model).setMarginLabel(rs.getString("MARGIN_LABEL"));
((ListObjects) model).setLabelStyleKey(rs.getShort("LABEL_STYLE_KEY"));
((ListObjects) model).setCellStyleKey(rs.getShort("CELL_STYLE_KEY"));
((ListObjects) model).setCellMinWidth(rs.getShort("CELL_MIN_WIDTH"));
((ListObjects) model).setCellMinHeight(rs.getShort("CELL_MIN_HEIGHT"));
((ListObjects) model).setCellNowWidth(rs.getShort("CELL_NOW_WIDTH"));
((ListObjects) model).setCellNowHeight(rs.getShort("CELL_NOW_HEIGHT"));
((ListObjects) model).setAccentKey(rs.getShort("ACCENT_KEY"));
((ListObjects) model).setAccentAlias(rs.getString("ACCENT_ALIAS"));
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
* Get the ListObjectPid field.
*
* @return Contents of the LIST_OBJECT_PID column
*/
public int getListObjectPid() {
return this.ListObjectPid;
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
* Get the ParentObjSetKey field.
*
* @return Contents of the PARENT_OBJ_SET_KEY column
*/
public short getParentObjSetKey() {
return this.ParentObjSetKey;
}

/**
* Get the UseOrder field.
*
* @return Contents of the USE_ORDER column
*/
public short getUseOrder() {
return this.UseOrder;
}

/**
* Get the ObjectAlias field.
*
* @return Contents of the OBJECT_ALIAS column
*/
public String getObjectAlias() {
return this.ObjectAlias;
}

/**
* Get the UseAliasLabel field.
*
* @return Contents of the USE_ALIAS_LABEL column
*/
public boolean getUseAliasLabel() {
return this.UseAliasLabel;
}

/**
* Get the MarginLabel field.
*
* @return Contents of the MARGIN_LABEL column
*/
public String getMarginLabel() {
return this.MarginLabel;
}

/**
* Get the LabelStyleKey field.
*
* @return Contents of the LABEL_STYLE_KEY column
*/
public short getLabelStyleKey() {
return this.LabelStyleKey;
}

/**
* Get the CellStyleKey field.
*
* @return Contents of the CELL_STYLE_KEY column
*/
public short getCellStyleKey() {
return this.CellStyleKey;
}

/**
* Get the CellMinWidth field.
*
* @return Contents of the CELL_MIN_WIDTH column
*/
public short getCellMinWidth() {
return this.CellMinWidth;
}

/**
* Get the CellMinHeight field.
*
* @return Contents of the CELL_MIN_HEIGHT column
*/
public short getCellMinHeight() {
return this.CellMinHeight;
}

/**
* Get the CellNowWidth field.
*
* @return Contents of the CELL_NOW_WIDTH column
*/
public short getCellNowWidth() {
return this.CellNowWidth;
}

/**
* Get the CellNowHeight field.
*
* @return Contents of the CELL_NOW_HEIGHT column
*/
public short getCellNowHeight() {
return this.CellNowHeight;
}

/**
* Get the AccentKey field.
*
* @return Contents of the ACCENT_KEY column
*/
public short getAccentKey() {
return this.AccentKey;
}

/**
* Get the AccentAlias field.
*
* @return Contents of the ACCENT_ALIAS column
*/
public String getAccentAlias() {
return this.AccentAlias;
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
* Set the ListObjectPid field
*
* @param ListObjectPid Contents of the LIST_OBJECT_PID column
*/
public void setListObjectPid(int ListObjectPid) {
this.ListObjectPid = ListObjectPid;
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
* Set the ParentObjSetKey field
*
* @param ParentObjSetKey Contents of the PARENT_OBJ_SET_KEY column
*/
public void setParentObjSetKey(short ParentObjSetKey) {
this.ParentObjSetKey = ParentObjSetKey;
}

/**
* Set the UseOrder field
*
* @param UseOrder Contents of the USE_ORDER column
*/
public void setUseOrder(short UseOrder) {
this.UseOrder = UseOrder;
}

/**
* Set the ObjectAlias field
*
* @param ObjectAlias Contents of the OBJECT_ALIAS column
*/
public void setObjectAlias(String ObjectAlias) {
this.ObjectAlias = ObjectAlias;
}

/**
* Set the UseAliasLabel field
*
* @param UseAliasLabel Contents of the USE_ALIAS_LABEL column
*/
public void setUseAliasLabel(boolean UseAliasLabel) {
this.UseAliasLabel = UseAliasLabel;
}

/**
* Set the MarginLabel field
*
* @param MarginLabel Contents of the MARGIN_LABEL column
*/
public void setMarginLabel(String MarginLabel) {
this.MarginLabel = MarginLabel;
}

/**
* Set the LabelStyleKey field
*
* @param LabelStyleKey Contents of the LABEL_STYLE_KEY column
*/
public void setLabelStyleKey(short LabelStyleKey) {
this.LabelStyleKey = LabelStyleKey;
}

/**
* Set the CellStyleKey field
*
* @param CellStyleKey Contents of the CELL_STYLE_KEY column
*/
public void setCellStyleKey(short CellStyleKey) {
this.CellStyleKey = CellStyleKey;
}

/**
* Set the CellMinWidth field
*
* @param CellMinWidth Contents of the CELL_MIN_WIDTH column
*/
public void setCellMinWidth(short CellMinWidth) {
this.CellMinWidth = CellMinWidth;
}

/**
* Set the CellMinHeight field
*
* @param CellMinHeight Contents of the CELL_MIN_HEIGHT column
*/
public void setCellMinHeight(short CellMinHeight) {
this.CellMinHeight = CellMinHeight;
}

/**
* Set the CellNowWidth field
*
* @param CellNowWidth Contents of the CELL_NOW_WIDTH column
*/
public void setCellNowWidth(short CellNowWidth) {
this.CellNowWidth = CellNowWidth;
}

/**
* Set the CellNowHeight field
*
* @param CellNowHeight Contents of the CELL_NOW_HEIGHT column
*/
public void setCellNowHeight(short CellNowHeight) {
this.CellNowHeight = CellNowHeight;
}

/**
* Set the AccentKey field
*
* @param AccentKey Contents of the ACCENT_KEY column
*/
public void setAccentKey(short AccentKey) {
this.AccentKey = AccentKey;
}

/**
* Set the AccentAlias field
*
* @param AccentAlias Contents of the ACCENT_ALIAS column
*/
public void setAccentAlias(String AccentAlias) {
this.AccentAlias = AccentAlias;
}

}

