package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the CITATIONS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class Citations extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"CITATION_PID, " +
"IS_SYSTEM, " +
"CITN_TYPE_KEY, " +
"CITING_PID, " +
"SOURCE_SUB_TYPE_KEY, " +
"SOURCE_PID, " +
"MEMO_SET_PID, " +
"SURETY, " +
"FLAGS FROM PUBLIC.CITATIONS WHERE CITATION_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"CITATION_PID, " +  
"IS_SYSTEM, " +  
"CITN_TYPE_KEY, " +  
"CITING_PID, " +  
"SOURCE_SUB_TYPE_KEY, " +  
"SOURCE_PID, " +  
"MEMO_SET_PID, " +  
"SURETY, " +  
"FLAGS FROM PUBLIC.CITATIONS";

private static final String INSERT = "INSERT INTO PUBLIC.CITATIONS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"CITATION_PID, " +     
"IS_SYSTEM, " +     
"CITN_TYPE_KEY, " +     
"CITING_PID, " +     
"SOURCE_SUB_TYPE_KEY, " +     
"SOURCE_PID, " +     
"MEMO_SET_PID, " +     
"SURETY, " +     
"FLAGS) VALUES (?, " +
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

private static final String UPDATE = "UPDATE PUBLIC.CITATIONSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"CITN_TYPE_KEY = ?, " + 
"CITING_PID = ?, " + 
"SOURCE_SUB_TYPE_KEY = ?, " + 
"SOURCE_PID = ?, " + 
"MEMO_SET_PID = ?, " + 
"SURETY = ?, " + 
"FLAGS = ? WHERE CITATION_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.CITATIONS WHERE CITATION_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.CITATIONS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int CitationPid;
private boolean IsSystem;
private short CitnTypeKey;
private int CitingPid;
private short SourceSubTypeKey;
private int SourcePid;
private int MemoSetPid;
private String Surety;
private String Flags;
private Citations model;

public Citations() throws SQLException {
}


public Citations(int CitationPid) throws SQLException {
super();
this.CitationPid = CitationPid;
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
model = new Citations();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setCitationPid(rs.getInt("CITATION_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setCitnTypeKey(rs.getShort("CITN_TYPE_KEY"));
model.setCitingPid(rs.getInt("CITING_PID"));
model.setSourceSubTypeKey(rs.getShort("SOURCE_SUB_TYPE_KEY"));
model.setSourcePid(rs.getInt("SOURCE_PID"));
model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
model.setSurety(rs.getString("SURETY"));
model.setFlags(rs.getString("FLAGS"));
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
model.setCitationPid(rs.getInt("CITATION_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setCitnTypeKey(rs.getShort("CITN_TYPE_KEY"));
model.setCitingPid(rs.getInt("CITING_PID"));
model.setSourceSubTypeKey(rs.getShort("SOURCE_SUB_TYPE_KEY"));
model.setSourcePid(rs.getInt("SOURCE_PID"));
model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
model.setSurety(rs.getString("SURETY"));
model.setFlags(rs.getString("FLAGS"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((Citations) model).setRecordNum(rs.getInt("RECORD_NUM"));
((Citations) model).setSetKey(rs.getShort("SET_KEY"));
((Citations) model).setCommitPid(rs.getInt("COMMIT_PID"));
((Citations) model).setCitationPid(rs.getInt("CITATION_PID"));
((Citations) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((Citations) model).setCitnTypeKey(rs.getShort("CITN_TYPE_KEY"));
((Citations) model).setCitingPid(rs.getInt("CITING_PID"));
((Citations) model).setSourceSubTypeKey(rs.getShort("SOURCE_SUB_TYPE_KEY"));
((Citations) model).setSourcePid(rs.getInt("SOURCE_PID"));
((Citations) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
((Citations) model).setSurety(rs.getString("SURETY"));
((Citations) model).setFlags(rs.getString("FLAGS"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((Citations) model).setRecordNum(rs.getInt("RECORD_NUM"));
((Citations) model).setSetKey(rs.getShort("SET_KEY"));
((Citations) model).setCommitPid(rs.getInt("COMMIT_PID"));
((Citations) model).setCitationPid(rs.getInt("CITATION_PID"));
((Citations) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((Citations) model).setCitnTypeKey(rs.getShort("CITN_TYPE_KEY"));
((Citations) model).setCitingPid(rs.getInt("CITING_PID"));
((Citations) model).setSourceSubTypeKey(rs.getShort("SOURCE_SUB_TYPE_KEY"));
((Citations) model).setSourcePid(rs.getInt("SOURCE_PID"));
((Citations) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
((Citations) model).setSurety(rs.getString("SURETY"));
((Citations) model).setFlags(rs.getString("FLAGS"));
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

public int getCitationPid() {
return this.CitationPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public short getCitnTypeKey() {
return this.CitnTypeKey;
}

public int getCitingPid() {
return this.CitingPid;
}

public short getSourceSubTypeKey() {
return this.SourceSubTypeKey;
}

public int getSourcePid() {
return this.SourcePid;
}

public int getMemoSetPid() {
return this.MemoSetPid;
}

public String getSurety() {
return this.Surety;
}

public String getFlags() {
return this.Flags;
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

public void setCitationPid(int CitationPid) {
this.CitationPid = CitationPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setCitnTypeKey(short CitnTypeKey) {
this.CitnTypeKey = CitnTypeKey;
}

public void setCitingPid(int CitingPid) {
this.CitingPid = CitingPid;
}

public void setSourceSubTypeKey(short SourceSubTypeKey) {
this.SourceSubTypeKey = SourceSubTypeKey;
}

public void setSourcePid(int SourcePid) {
this.SourcePid = SourcePid;
}

public void setMemoSetPid(int MemoSetPid) {
this.MemoSetPid = MemoSetPid;
}

public void setSurety(String Surety) {
this.Surety = Surety;
}

public void setFlags(String Flags) {
this.Flags = Flags;
}

}

