package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the BIO_KIN_TERM_DEFNS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class BioKinTermDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"BIO_KIN_TERM_DEFN_PID, " +
"CURRENT_IS_FEMALE, " +
"FOCUS_IS_FEMALE, " +
"THIS_GENERATION, " +
"REMOVED_GENERATION, " +
"KIN_ETHNICITY_KEY, " +
"ANCESTOR_KIN_CODE, " +
"DESCENDANT_KIN_CODE, " +
"KIN_TERM_TRANS_KEY, " +
"REMINDER_KEY, " +
"SHOW FROM PUBLIC.BIO_KIN_TERM_DEFNS WHERE BIO_KIN_TERM_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"BIO_KIN_TERM_DEFN_PID, " +  
"CURRENT_IS_FEMALE, " +  
"FOCUS_IS_FEMALE, " +  
"THIS_GENERATION, " +  
"REMOVED_GENERATION, " +  
"KIN_ETHNICITY_KEY, " +  
"ANCESTOR_KIN_CODE, " +  
"DESCENDANT_KIN_CODE, " +  
"KIN_TERM_TRANS_KEY, " +  
"REMINDER_KEY, " +  
"SHOW FROM PUBLIC.BIO_KIN_TERM_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.BIO_KIN_TERM_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"BIO_KIN_TERM_DEFN_PID, " +     
"CURRENT_IS_FEMALE, " +     
"FOCUS_IS_FEMALE, " +     
"THIS_GENERATION, " +     
"REMOVED_GENERATION, " +     
"KIN_ETHNICITY_KEY, " +     
"ANCESTOR_KIN_CODE, " +     
"DESCENDANT_KIN_CODE, " +     
"KIN_TERM_TRANS_KEY, " +     
"REMINDER_KEY, " +     
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

private static final String UPDATE = "UPDATE PUBLIC.BIO_KIN_TERM_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"CURRENT_IS_FEMALE = ?, " + 
"FOCUS_IS_FEMALE = ?, " + 
"THIS_GENERATION = ?, " + 
"REMOVED_GENERATION = ?, " + 
"KIN_ETHNICITY_KEY = ?, " + 
"ANCESTOR_KIN_CODE = ?, " + 
"DESCENDANT_KIN_CODE = ?, " + 
"KIN_TERM_TRANS_KEY = ?, " + 
"REMINDER_KEY = ?, " + 
"SHOW = ? WHERE BIO_KIN_TERM_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.BIO_KIN_TERM_DEFNS WHERE BIO_KIN_TERM_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.BIO_KIN_TERM_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int BioKinTermDefnPid;
private boolean CurrentIsFemale;
private boolean FocusIsFemale;
private short ThisGeneration;
private short RemovedGeneration;
private short KinEthnicityKey;
private String AncestorKinCode;
private String DescendantKinCode;
private short KinTermTransKey;
private short ReminderKey;
private boolean Show;
private BioKinTermDefns model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public BioKinTermDefns() throws SQLException {
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
model = new BioKinTermDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setBioKinTermDefnPid(rs.getInt("BIO_KIN_TERM_DEFN_PID"));
model.setCurrentIsFemale(rs.getBoolean("CURRENT_IS_FEMALE"));
model.setFocusIsFemale(rs.getBoolean("FOCUS_IS_FEMALE"));
model.setThisGeneration(rs.getShort("THIS_GENERATION"));
model.setRemovedGeneration(rs.getShort("REMOVED_GENERATION"));
model.setKinEthnicityKey(rs.getShort("KIN_ETHNICITY_KEY"));
model.setAncestorKinCode(rs.getString("ANCESTOR_KIN_CODE"));
model.setDescendantKinCode(rs.getString("DESCENDANT_KIN_CODE"));
model.setKinTermTransKey(rs.getShort("KIN_TERM_TRANS_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setShow(rs.getBoolean("SHOW"));
modelList.add(model);
}
return modelList;
}

@Override
public BioKinTermDefns get(int key) throws SQLException {
model = new BioKinTermDefns();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setBioKinTermDefnPid(rs.getInt("BIO_KIN_TERM_DEFN_PID"));
model.setCurrentIsFemale(rs.getBoolean("CURRENT_IS_FEMALE"));
model.setFocusIsFemale(rs.getBoolean("FOCUS_IS_FEMALE"));
model.setThisGeneration(rs.getShort("THIS_GENERATION"));
model.setRemovedGeneration(rs.getShort("REMOVED_GENERATION"));
model.setKinEthnicityKey(rs.getShort("KIN_ETHNICITY_KEY"));
model.setAncestorKinCode(rs.getString("ANCESTOR_KIN_CODE"));
model.setDescendantKinCode(rs.getString("DESCENDANT_KIN_CODE"));
model.setKinTermTransKey(rs.getShort("KIN_TERM_TRANS_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setShow(rs.getBoolean("SHOW"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((BioKinTermDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((BioKinTermDefns) model).setSetKey(rs.getShort("SET_KEY"));
((BioKinTermDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((BioKinTermDefns) model).setBioKinTermDefnPid(rs.getInt("BIO_KIN_TERM_DEFN_PID"));
((BioKinTermDefns) model).setCurrentIsFemale(rs.getBoolean("CURRENT_IS_FEMALE"));
((BioKinTermDefns) model).setFocusIsFemale(rs.getBoolean("FOCUS_IS_FEMALE"));
((BioKinTermDefns) model).setThisGeneration(rs.getShort("THIS_GENERATION"));
((BioKinTermDefns) model).setRemovedGeneration(rs.getShort("REMOVED_GENERATION"));
((BioKinTermDefns) model).setKinEthnicityKey(rs.getShort("KIN_ETHNICITY_KEY"));
((BioKinTermDefns) model).setAncestorKinCode(rs.getString("ANCESTOR_KIN_CODE"));
((BioKinTermDefns) model).setDescendantKinCode(rs.getString("DESCENDANT_KIN_CODE"));
((BioKinTermDefns) model).setKinTermTransKey(rs.getShort("KIN_TERM_TRANS_KEY"));
((BioKinTermDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((BioKinTermDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((BioKinTermDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((BioKinTermDefns) model).setSetKey(rs.getShort("SET_KEY"));
((BioKinTermDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((BioKinTermDefns) model).setBioKinTermDefnPid(rs.getInt("BIO_KIN_TERM_DEFN_PID"));
((BioKinTermDefns) model).setCurrentIsFemale(rs.getBoolean("CURRENT_IS_FEMALE"));
((BioKinTermDefns) model).setFocusIsFemale(rs.getBoolean("FOCUS_IS_FEMALE"));
((BioKinTermDefns) model).setThisGeneration(rs.getShort("THIS_GENERATION"));
((BioKinTermDefns) model).setRemovedGeneration(rs.getShort("REMOVED_GENERATION"));
((BioKinTermDefns) model).setKinEthnicityKey(rs.getShort("KIN_ETHNICITY_KEY"));
((BioKinTermDefns) model).setAncestorKinCode(rs.getString("ANCESTOR_KIN_CODE"));
((BioKinTermDefns) model).setDescendantKinCode(rs.getString("DESCENDANT_KIN_CODE"));
((BioKinTermDefns) model).setKinTermTransKey(rs.getShort("KIN_TERM_TRANS_KEY"));
((BioKinTermDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((BioKinTermDefns) model).setShow(rs.getBoolean("SHOW"));
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
* Get the BioKinTermDefnPid field.
*
* @return Contents of the BIO_KIN_TERM_DEFN_PID column
*/
public int getBioKinTermDefnPid() {
return this.BioKinTermDefnPid;
}

/**
* Get the CurrentIsFemale field.
*
* @return Contents of the CURRENT_IS_FEMALE column
*/
public boolean getCurrentIsFemale() {
return this.CurrentIsFemale;
}

/**
* Get the FocusIsFemale field.
*
* @return Contents of the FOCUS_IS_FEMALE column
*/
public boolean getFocusIsFemale() {
return this.FocusIsFemale;
}

/**
* Get the ThisGeneration field.
*
* @return Contents of the THIS_GENERATION column
*/
public short getThisGeneration() {
return this.ThisGeneration;
}

/**
* Get the RemovedGeneration field.
*
* @return Contents of the REMOVED_GENERATION column
*/
public short getRemovedGeneration() {
return this.RemovedGeneration;
}

/**
* Get the KinEthnicityKey field.
*
* @return Contents of the KIN_ETHNICITY_KEY column
*/
public short getKinEthnicityKey() {
return this.KinEthnicityKey;
}

/**
* Get the AncestorKinCode field.
*
* @return Contents of the ANCESTOR_KIN_CODE column
*/
public String getAncestorKinCode() {
return this.AncestorKinCode;
}

/**
* Get the DescendantKinCode field.
*
* @return Contents of the DESCENDANT_KIN_CODE column
*/
public String getDescendantKinCode() {
return this.DescendantKinCode;
}

/**
* Get the KinTermTransKey field.
*
* @return Contents of the KIN_TERM_TRANS_KEY column
*/
public short getKinTermTransKey() {
return this.KinTermTransKey;
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
* Set the BioKinTermDefnPid field
*
* @param BioKinTermDefnPid Contents of the BIO_KIN_TERM_DEFN_PID column
*/
public void setBioKinTermDefnPid(int BioKinTermDefnPid) {
this.BioKinTermDefnPid = BioKinTermDefnPid;
}

/**
* Set the CurrentIsFemale field
*
* @param CurrentIsFemale Contents of the CURRENT_IS_FEMALE column
*/
public void setCurrentIsFemale(boolean CurrentIsFemale) {
this.CurrentIsFemale = CurrentIsFemale;
}

/**
* Set the FocusIsFemale field
*
* @param FocusIsFemale Contents of the FOCUS_IS_FEMALE column
*/
public void setFocusIsFemale(boolean FocusIsFemale) {
this.FocusIsFemale = FocusIsFemale;
}

/**
* Set the ThisGeneration field
*
* @param ThisGeneration Contents of the THIS_GENERATION column
*/
public void setThisGeneration(short ThisGeneration) {
this.ThisGeneration = ThisGeneration;
}

/**
* Set the RemovedGeneration field
*
* @param RemovedGeneration Contents of the REMOVED_GENERATION column
*/
public void setRemovedGeneration(short RemovedGeneration) {
this.RemovedGeneration = RemovedGeneration;
}

/**
* Set the KinEthnicityKey field
*
* @param KinEthnicityKey Contents of the KIN_ETHNICITY_KEY column
*/
public void setKinEthnicityKey(short KinEthnicityKey) {
this.KinEthnicityKey = KinEthnicityKey;
}

/**
* Set the AncestorKinCode field
*
* @param AncestorKinCode Contents of the ANCESTOR_KIN_CODE column
*/
public void setAncestorKinCode(String AncestorKinCode) {
this.AncestorKinCode = AncestorKinCode;
}

/**
* Set the DescendantKinCode field
*
* @param DescendantKinCode Contents of the DESCENDANT_KIN_CODE column
*/
public void setDescendantKinCode(String DescendantKinCode) {
this.DescendantKinCode = DescendantKinCode;
}

/**
* Set the KinTermTransKey field
*
* @param KinTermTransKey Contents of the KIN_TERM_TRANS_KEY column
*/
public void setKinTermTransKey(short KinTermTransKey) {
this.KinTermTransKey = KinTermTransKey;
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
* Set the Show field
*
* @param Show Contents of the SHOW column
*/
public void setShow(boolean Show) {
this.Show = Show;
}

}

