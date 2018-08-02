package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the BIO_KIN_TERM_DEFNS database table.
*
* @version 2018-08-02
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

public BioKinTermDefns() throws SQLException {
}


public BioKinTermDefns(int BioKinTermDefnPid) throws SQLException {
super();
this.BioKinTermDefnPid = BioKinTermDefnPid;
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
public AbstractHreDataModel get(int key) throws SQLException {
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
return this;
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

public int getRecordNum() {
return this.RecordNum;
}

public short getSetKey() {
return this.SetKey;
}

public int getCommitPid() {
return this.CommitPid;
}

public int getBioKinTermDefnPid() {
return this.BioKinTermDefnPid;
}

public boolean getCurrentIsFemale() {
return this.CurrentIsFemale;
}

public boolean getFocusIsFemale() {
return this.FocusIsFemale;
}

public short getThisGeneration() {
return this.ThisGeneration;
}

public short getRemovedGeneration() {
return this.RemovedGeneration;
}

public short getKinEthnicityKey() {
return this.KinEthnicityKey;
}

public String getAncestorKinCode() {
return this.AncestorKinCode;
}

public String getDescendantKinCode() {
return this.DescendantKinCode;
}

public short getKinTermTransKey() {
return this.KinTermTransKey;
}

public short getReminderKey() {
return this.ReminderKey;
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

public void setBioKinTermDefnPid(int BioKinTermDefnPid) {
this.BioKinTermDefnPid = BioKinTermDefnPid;
}

public void setCurrentIsFemale(boolean CurrentIsFemale) {
this.CurrentIsFemale = CurrentIsFemale;
}

public void setFocusIsFemale(boolean FocusIsFemale) {
this.FocusIsFemale = FocusIsFemale;
}

public void setThisGeneration(short ThisGeneration) {
this.ThisGeneration = ThisGeneration;
}

public void setRemovedGeneration(short RemovedGeneration) {
this.RemovedGeneration = RemovedGeneration;
}

public void setKinEthnicityKey(short KinEthnicityKey) {
this.KinEthnicityKey = KinEthnicityKey;
}

public void setAncestorKinCode(String AncestorKinCode) {
this.AncestorKinCode = AncestorKinCode;
}

public void setDescendantKinCode(String DescendantKinCode) {
this.DescendantKinCode = DescendantKinCode;
}

public void setKinTermTransKey(short KinTermTransKey) {
this.KinTermTransKey = KinTermTransKey;
}

public void setReminderKey(short ReminderKey) {
this.ReminderKey = ReminderKey;
}

public void setShow(boolean Show) {
this.Show = Show;
}

}

