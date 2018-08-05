package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the LIST_SORTS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class ListSorts extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"LIST_SORT_PID, " +
"IS_SYSTEM, " +
"PARENT_SORT_SET_KEY, " +
"USE_ORDER, " +
"SORT_ALIAS, " +
"SORT_HIGH_LAST, " +
"EMPTY_SORT_HIGH FROM PUBLIC.LIST_SORTS WHERE LIST_SORT_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"LIST_SORT_PID, " +  
"IS_SYSTEM, " +  
"PARENT_SORT_SET_KEY, " +  
"USE_ORDER, " +  
"SORT_ALIAS, " +  
"SORT_HIGH_LAST, " +  
"EMPTY_SORT_HIGH FROM PUBLIC.LIST_SORTS";

private static final String INSERT = "INSERT INTO PUBLIC.LIST_SORTS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"LIST_SORT_PID, " +     
"IS_SYSTEM, " +     
"PARENT_SORT_SET_KEY, " +     
"USE_ORDER, " +     
"SORT_ALIAS, " +     
"SORT_HIGH_LAST, " +     
"EMPTY_SORT_HIGH) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.LIST_SORTSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"PARENT_SORT_SET_KEY = ?, " + 
"USE_ORDER = ?, " + 
"SORT_ALIAS = ?, " + 
"SORT_HIGH_LAST = ?, " + 
"EMPTY_SORT_HIGH = ? WHERE LIST_SORT_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.LIST_SORTS WHERE LIST_SORT_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.LIST_SORTS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int ListSortPid;
private boolean IsSystem;
private short ParentSortSetKey;
private short UseOrder;
private String SortAlias;
private boolean SortHighLast;
private boolean EmptySortHigh;
private ListSorts model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public ListSorts() throws SQLException {
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
model = new ListSorts();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setListSortPid(rs.getInt("LIST_SORT_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentSortSetKey(rs.getShort("PARENT_SORT_SET_KEY"));
model.setUseOrder(rs.getShort("USE_ORDER"));
model.setSortAlias(rs.getString("SORT_ALIAS"));
model.setSortHighLast(rs.getBoolean("SORT_HIGH_LAST"));
model.setEmptySortHigh(rs.getBoolean("EMPTY_SORT_HIGH"));
modelList.add(model);
}
return modelList;
}

@Override
public ListSorts get(int key) throws SQLException {
model = new ListSorts();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setListSortPid(rs.getInt("LIST_SORT_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setParentSortSetKey(rs.getShort("PARENT_SORT_SET_KEY"));
model.setUseOrder(rs.getShort("USE_ORDER"));
model.setSortAlias(rs.getString("SORT_ALIAS"));
model.setSortHighLast(rs.getBoolean("SORT_HIGH_LAST"));
model.setEmptySortHigh(rs.getBoolean("EMPTY_SORT_HIGH"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((ListSorts) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ListSorts) model).setSetKey(rs.getShort("SET_KEY"));
((ListSorts) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ListSorts) model).setListSortPid(rs.getInt("LIST_SORT_PID"));
((ListSorts) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((ListSorts) model).setParentSortSetKey(rs.getShort("PARENT_SORT_SET_KEY"));
((ListSorts) model).setUseOrder(rs.getShort("USE_ORDER"));
((ListSorts) model).setSortAlias(rs.getString("SORT_ALIAS"));
((ListSorts) model).setSortHighLast(rs.getBoolean("SORT_HIGH_LAST"));
((ListSorts) model).setEmptySortHigh(rs.getBoolean("EMPTY_SORT_HIGH"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((ListSorts) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ListSorts) model).setSetKey(rs.getShort("SET_KEY"));
((ListSorts) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ListSorts) model).setListSortPid(rs.getInt("LIST_SORT_PID"));
((ListSorts) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((ListSorts) model).setParentSortSetKey(rs.getShort("PARENT_SORT_SET_KEY"));
((ListSorts) model).setUseOrder(rs.getShort("USE_ORDER"));
((ListSorts) model).setSortAlias(rs.getString("SORT_ALIAS"));
((ListSorts) model).setSortHighLast(rs.getBoolean("SORT_HIGH_LAST"));
((ListSorts) model).setEmptySortHigh(rs.getBoolean("EMPTY_SORT_HIGH"));
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
* Get the ListSortPid field.
*
* @return Contents of the LIST_SORT_PID column
*/
public int getListSortPid() {
return this.ListSortPid;
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
* Get the ParentSortSetKey field.
*
* @return Contents of the PARENT_SORT_SET_KEY column
*/
public short getParentSortSetKey() {
return this.ParentSortSetKey;
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
* Get the SortAlias field.
*
* @return Contents of the SORT_ALIAS column
*/
public String getSortAlias() {
return this.SortAlias;
}

/**
* Get the SortHighLast field.
*
* @return Contents of the SORT_HIGH_LAST column
*/
public boolean getSortHighLast() {
return this.SortHighLast;
}

/**
* Get the EmptySortHigh field.
*
* @return Contents of the EMPTY_SORT_HIGH column
*/
public boolean getEmptySortHigh() {
return this.EmptySortHigh;
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
* Set the ListSortPid field
*
* @param ListSortPid Contents of the LIST_SORT_PID column
*/
public void setListSortPid(int ListSortPid) {
this.ListSortPid = ListSortPid;
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
* Set the ParentSortSetKey field
*
* @param ParentSortSetKey Contents of the PARENT_SORT_SET_KEY column
*/
public void setParentSortSetKey(short ParentSortSetKey) {
this.ParentSortSetKey = ParentSortSetKey;
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
* Set the SortAlias field
*
* @param SortAlias Contents of the SORT_ALIAS column
*/
public void setSortAlias(String SortAlias) {
this.SortAlias = SortAlias;
}

/**
* Set the SortHighLast field
*
* @param SortHighLast Contents of the SORT_HIGH_LAST column
*/
public void setSortHighLast(boolean SortHighLast) {
this.SortHighLast = SortHighLast;
}

/**
* Set the EmptySortHigh field
*
* @param EmptySortHigh Contents of the EMPTY_SORT_HIGH column
*/
public void setEmptySortHigh(boolean EmptySortHigh) {
this.EmptySortHigh = EmptySortHigh;
}

}

