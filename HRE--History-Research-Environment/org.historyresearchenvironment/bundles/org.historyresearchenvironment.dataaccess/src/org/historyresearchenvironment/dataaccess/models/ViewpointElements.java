package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the VIEWPOINT_ELEMENTS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class ViewpointElements extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"VIEWPOINT_ELEMENT_PID, " +
"VIEWPOINT_PID, " +
"SCREEN_CONFIG_PID, " +
"IS_MASTER, " +
"IS_SECOND_COPY, " +
"AUTO_UPDATE, " +
"SHOW_ON_OPEN FROM PUBLIC.VIEWPOINT_ELEMENTS WHERE VIEWPOINT_ELEMENT_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"VIEWPOINT_ELEMENT_PID, " +  
"VIEWPOINT_PID, " +  
"SCREEN_CONFIG_PID, " +  
"IS_MASTER, " +  
"IS_SECOND_COPY, " +  
"AUTO_UPDATE, " +  
"SHOW_ON_OPEN FROM PUBLIC.VIEWPOINT_ELEMENTS";

private static final String INSERT = "INSERT INTO PUBLIC.VIEWPOINT_ELEMENTS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"VIEWPOINT_ELEMENT_PID, " +     
"VIEWPOINT_PID, " +     
"SCREEN_CONFIG_PID, " +     
"IS_MASTER, " +     
"IS_SECOND_COPY, " +     
"AUTO_UPDATE, " +     
"SHOW_ON_OPEN) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.VIEWPOINT_ELEMENTSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"VIEWPOINT_PID = ?, " + 
"SCREEN_CONFIG_PID = ?, " + 
"IS_MASTER = ?, " + 
"IS_SECOND_COPY = ?, " + 
"AUTO_UPDATE = ?, " + 
"SHOW_ON_OPEN = ? WHERE VIEWPOINT_ELEMENT_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.VIEWPOINT_ELEMENTS WHERE VIEWPOINT_ELEMENT_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.VIEWPOINT_ELEMENTS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int ViewpointElementPid;
private int ViewpointPid;
private short ScreenConfigPid;
private boolean IsMaster;
private boolean IsSecondCopy;
private boolean AutoUpdate;
private boolean ShowOnOpen;
private ViewpointElements model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public ViewpointElements() throws SQLException {
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
model = new ViewpointElements();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setViewpointElementPid(rs.getInt("VIEWPOINT_ELEMENT_PID"));
model.setViewpointPid(rs.getInt("VIEWPOINT_PID"));
model.setScreenConfigPid(rs.getShort("SCREEN_CONFIG_PID"));
model.setIsMaster(rs.getBoolean("IS_MASTER"));
model.setIsSecondCopy(rs.getBoolean("IS_SECOND_COPY"));
model.setAutoUpdate(rs.getBoolean("AUTO_UPDATE"));
model.setShowOnOpen(rs.getBoolean("SHOW_ON_OPEN"));
modelList.add(model);
}
return modelList;
}

@Override
public ViewpointElements get(int key) throws SQLException {
model = new ViewpointElements();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setViewpointElementPid(rs.getInt("VIEWPOINT_ELEMENT_PID"));
model.setViewpointPid(rs.getInt("VIEWPOINT_PID"));
model.setScreenConfigPid(rs.getShort("SCREEN_CONFIG_PID"));
model.setIsMaster(rs.getBoolean("IS_MASTER"));
model.setIsSecondCopy(rs.getBoolean("IS_SECOND_COPY"));
model.setAutoUpdate(rs.getBoolean("AUTO_UPDATE"));
model.setShowOnOpen(rs.getBoolean("SHOW_ON_OPEN"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((ViewpointElements) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ViewpointElements) model).setSetKey(rs.getShort("SET_KEY"));
((ViewpointElements) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ViewpointElements) model).setViewpointElementPid(rs.getInt("VIEWPOINT_ELEMENT_PID"));
((ViewpointElements) model).setViewpointPid(rs.getInt("VIEWPOINT_PID"));
((ViewpointElements) model).setScreenConfigPid(rs.getShort("SCREEN_CONFIG_PID"));
((ViewpointElements) model).setIsMaster(rs.getBoolean("IS_MASTER"));
((ViewpointElements) model).setIsSecondCopy(rs.getBoolean("IS_SECOND_COPY"));
((ViewpointElements) model).setAutoUpdate(rs.getBoolean("AUTO_UPDATE"));
((ViewpointElements) model).setShowOnOpen(rs.getBoolean("SHOW_ON_OPEN"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((ViewpointElements) model).setRecordNum(rs.getInt("RECORD_NUM"));
((ViewpointElements) model).setSetKey(rs.getShort("SET_KEY"));
((ViewpointElements) model).setCommitPid(rs.getInt("COMMIT_PID"));
((ViewpointElements) model).setViewpointElementPid(rs.getInt("VIEWPOINT_ELEMENT_PID"));
((ViewpointElements) model).setViewpointPid(rs.getInt("VIEWPOINT_PID"));
((ViewpointElements) model).setScreenConfigPid(rs.getShort("SCREEN_CONFIG_PID"));
((ViewpointElements) model).setIsMaster(rs.getBoolean("IS_MASTER"));
((ViewpointElements) model).setIsSecondCopy(rs.getBoolean("IS_SECOND_COPY"));
((ViewpointElements) model).setAutoUpdate(rs.getBoolean("AUTO_UPDATE"));
((ViewpointElements) model).setShowOnOpen(rs.getBoolean("SHOW_ON_OPEN"));
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
* Get the ViewpointElementPid field.
*
* @return Contents of the VIEWPOINT_ELEMENT_PID column
*/
public int getViewpointElementPid() {
return this.ViewpointElementPid;
}

/**
* Get the ViewpointPid field.
*
* @return Contents of the VIEWPOINT_PID column
*/
public int getViewpointPid() {
return this.ViewpointPid;
}

/**
* Get the ScreenConfigPid field.
*
* @return Contents of the SCREEN_CONFIG_PID column
*/
public short getScreenConfigPid() {
return this.ScreenConfigPid;
}

/**
* Get the IsMaster field.
*
* @return Contents of the IS_MASTER column
*/
public boolean getIsMaster() {
return this.IsMaster;
}

/**
* Get the IsSecondCopy field.
*
* @return Contents of the IS_SECOND_COPY column
*/
public boolean getIsSecondCopy() {
return this.IsSecondCopy;
}

/**
* Get the AutoUpdate field.
*
* @return Contents of the AUTO_UPDATE column
*/
public boolean getAutoUpdate() {
return this.AutoUpdate;
}

/**
* Get the ShowOnOpen field.
*
* @return Contents of the SHOW_ON_OPEN column
*/
public boolean getShowOnOpen() {
return this.ShowOnOpen;
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
* Set the ViewpointElementPid field
*
* @param ViewpointElementPid Contents of the VIEWPOINT_ELEMENT_PID column
*/
public void setViewpointElementPid(int ViewpointElementPid) {
this.ViewpointElementPid = ViewpointElementPid;
}

/**
* Set the ViewpointPid field
*
* @param ViewpointPid Contents of the VIEWPOINT_PID column
*/
public void setViewpointPid(int ViewpointPid) {
this.ViewpointPid = ViewpointPid;
}

/**
* Set the ScreenConfigPid field
*
* @param ScreenConfigPid Contents of the SCREEN_CONFIG_PID column
*/
public void setScreenConfigPid(short ScreenConfigPid) {
this.ScreenConfigPid = ScreenConfigPid;
}

/**
* Set the IsMaster field
*
* @param IsMaster Contents of the IS_MASTER column
*/
public void setIsMaster(boolean IsMaster) {
this.IsMaster = IsMaster;
}

/**
* Set the IsSecondCopy field
*
* @param IsSecondCopy Contents of the IS_SECOND_COPY column
*/
public void setIsSecondCopy(boolean IsSecondCopy) {
this.IsSecondCopy = IsSecondCopy;
}

/**
* Set the AutoUpdate field
*
* @param AutoUpdate Contents of the AUTO_UPDATE column
*/
public void setAutoUpdate(boolean AutoUpdate) {
this.AutoUpdate = AutoUpdate;
}

/**
* Set the ShowOnOpen field
*
* @param ShowOnOpen Contents of the SHOW_ON_OPEN column
*/
public void setShowOnOpen(boolean ShowOnOpen) {
this.ShowOnOpen = ShowOnOpen;
}

}

