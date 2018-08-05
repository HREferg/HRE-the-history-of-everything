package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the BIO_KIN_TERM_TRANS database table.
*
* @version 2018-08-05
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class BioKinTermTrans extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"BIO_KIN_TERM_TRAN_PID, " +
"KIN_ETHNICITY_KEY, " +
"KIN_TERM_HAS_SUBSTN, " +
"LANG_CODE, " +
"KIN_TERM FROM PUBLIC.BIO_KIN_TERM_TRANS WHERE BIO_KIN_TERM_TRAN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"BIO_KIN_TERM_TRAN_PID, " +  
"KIN_ETHNICITY_KEY, " +  
"KIN_TERM_HAS_SUBSTN, " +  
"LANG_CODE, " +  
"KIN_TERM FROM PUBLIC.BIO_KIN_TERM_TRANS";

private static final String INSERT = "INSERT INTO PUBLIC.BIO_KIN_TERM_TRANS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"BIO_KIN_TERM_TRAN_PID, " +     
"KIN_ETHNICITY_KEY, " +     
"KIN_TERM_HAS_SUBSTN, " +     
"LANG_CODE, " +     
"KIN_TERM) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.BIO_KIN_TERM_TRANSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"KIN_ETHNICITY_KEY = ?, " + 
"KIN_TERM_HAS_SUBSTN = ?, " + 
"LANG_CODE = ?, " + 
"KIN_TERM = ? WHERE BIO_KIN_TERM_TRAN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.BIO_KIN_TERM_TRANS WHERE BIO_KIN_TERM_TRAN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.BIO_KIN_TERM_TRANS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int BioKinTermTranPid;
private short KinEthnicityKey;
private boolean KinTermHasSubstn;
private String LangCode;
private String KinTerm;
private BioKinTermTrans model;

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public BioKinTermTrans() throws SQLException {
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
model = new BioKinTermTrans();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setBioKinTermTranPid(rs.getInt("BIO_KIN_TERM_TRAN_PID"));
model.setKinEthnicityKey(rs.getShort("KIN_ETHNICITY_KEY"));
model.setKinTermHasSubstn(rs.getBoolean("KIN_TERM_HAS_SUBSTN"));
model.setLangCode(rs.getString("LANG_CODE"));
model.setKinTerm(rs.getString("KIN_TERM"));
modelList.add(model);
}
return modelList;
}

@Override
public BioKinTermTrans get(int key) throws SQLException {
model = new BioKinTermTrans();
ps = conn.prepareStatement(SELECT);
ps.setInt(1, (int) key);
rs = ps.executeQuery();
if (rs.next()) {
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setBioKinTermTranPid(rs.getInt("BIO_KIN_TERM_TRAN_PID"));
model.setKinEthnicityKey(rs.getShort("KIN_ETHNICITY_KEY"));
model.setKinTermHasSubstn(rs.getBoolean("KIN_TERM_HAS_SUBSTN"));
model.setLangCode(rs.getString("LANG_CODE"));
model.setKinTerm(rs.getString("KIN_TERM"));
}
return model;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((BioKinTermTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
((BioKinTermTrans) model).setSetKey(rs.getShort("SET_KEY"));
((BioKinTermTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
((BioKinTermTrans) model).setBioKinTermTranPid(rs.getInt("BIO_KIN_TERM_TRAN_PID"));
((BioKinTermTrans) model).setKinEthnicityKey(rs.getShort("KIN_ETHNICITY_KEY"));
((BioKinTermTrans) model).setKinTermHasSubstn(rs.getBoolean("KIN_TERM_HAS_SUBSTN"));
((BioKinTermTrans) model).setLangCode(rs.getString("LANG_CODE"));
((BioKinTermTrans) model).setKinTerm(rs.getString("KIN_TERM"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((BioKinTermTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
((BioKinTermTrans) model).setSetKey(rs.getShort("SET_KEY"));
((BioKinTermTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
((BioKinTermTrans) model).setBioKinTermTranPid(rs.getInt("BIO_KIN_TERM_TRAN_PID"));
((BioKinTermTrans) model).setKinEthnicityKey(rs.getShort("KIN_ETHNICITY_KEY"));
((BioKinTermTrans) model).setKinTermHasSubstn(rs.getBoolean("KIN_TERM_HAS_SUBSTN"));
((BioKinTermTrans) model).setLangCode(rs.getString("LANG_CODE"));
((BioKinTermTrans) model).setKinTerm(rs.getString("KIN_TERM"));
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
* Get the BioKinTermTranPid field.
*
* @return Contents of the BIO_KIN_TERM_TRAN_PID column
*/
public int getBioKinTermTranPid() {
return this.BioKinTermTranPid;
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
* Get the KinTermHasSubstn field.
*
* @return Contents of the KIN_TERM_HAS_SUBSTN column
*/
public boolean getKinTermHasSubstn() {
return this.KinTermHasSubstn;
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
* Get the KinTerm field.
*
* @return Contents of the KIN_TERM column
*/
public String getKinTerm() {
return this.KinTerm;
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
* Set the BioKinTermTranPid field
*
* @param BioKinTermTranPid Contents of the BIO_KIN_TERM_TRAN_PID column
*/
public void setBioKinTermTranPid(int BioKinTermTranPid) {
this.BioKinTermTranPid = BioKinTermTranPid;
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
* Set the KinTermHasSubstn field
*
* @param KinTermHasSubstn Contents of the KIN_TERM_HAS_SUBSTN column
*/
public void setKinTermHasSubstn(boolean KinTermHasSubstn) {
this.KinTermHasSubstn = KinTermHasSubstn;
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
* Set the KinTerm field
*
* @param KinTerm Contents of the KIN_TERM column
*/
public void setKinTerm(String KinTerm) {
this.KinTerm = KinTerm;
}

}

