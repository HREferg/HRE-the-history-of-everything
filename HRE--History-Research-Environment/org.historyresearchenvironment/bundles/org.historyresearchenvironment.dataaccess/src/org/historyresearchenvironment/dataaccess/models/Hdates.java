package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the HDATES database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class Hdates extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"HDATE_PID, " +
"IS_SYSTEM, " +
"IS_HUMAN_CALENDAR, " +
"HDATE1, " +
"HDATE2, " +
"SORT_HDATE1, " +
"SORT_HDATE2, " +
"ORIGINAL_TEXT, " +
"LANG_CODE, " +
"HDATE_TYPE_KEY, " +
"NAMED_MEMO_PID, " +
"SURETY FROM PUBLIC.HDATES WHERE HDATE_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"HDATE_PID, " +  
"IS_SYSTEM, " +  
"IS_HUMAN_CALENDAR, " +  
"HDATE1, " +  
"HDATE2, " +  
"SORT_HDATE1, " +  
"SORT_HDATE2, " +  
"ORIGINAL_TEXT, " +  
"LANG_CODE, " +  
"HDATE_TYPE_KEY, " +  
"NAMED_MEMO_PID, " +  
"SURETY FROM PUBLIC.HDATES";

private static final String INSERT = "INSERT INTO PUBLIC.HDATES( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"HDATE_PID, " +     
"IS_SYSTEM, " +     
"IS_HUMAN_CALENDAR, " +     
"HDATE1, " +     
"HDATE2, " +     
"SORT_HDATE1, " +     
"SORT_HDATE2, " +     
"ORIGINAL_TEXT, " +     
"LANG_CODE, " +     
"HDATE_TYPE_KEY, " +     
"NAMED_MEMO_PID, " +     
"SURETY) VALUES (?, " +
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

private static final String UPDATE = "UPDATE PUBLIC.HDATESSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"IS_HUMAN_CALENDAR = ?, " + 
"HDATE1 = ?, " + 
"HDATE2 = ?, " + 
"SORT_HDATE1 = ?, " + 
"SORT_HDATE2 = ?, " + 
"ORIGINAL_TEXT = ?, " + 
"LANG_CODE = ?, " + 
"HDATE_TYPE_KEY = ?, " + 
"NAMED_MEMO_PID = ?, " + 
"SURETY = ? WHERE HDATE_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.HDATES WHERE HDATE_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.HDATES";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int HdatePid;
private boolean IsSystem;
private boolean IsHumanCalendar;
private long Hdate1;
private long Hdate2;
private long SortHdate1;
private long SortHdate2;
private String OriginalText;
private String LangCode;
private short HdateTypeKey;
private int NamedMemoPid;
private String Surety;
private Hdates model;

public Hdates() throws SQLException {
}


public Hdates(int HdatePid) throws SQLException {
super();
this.HdatePid = HdatePid;
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
model = new Hdates();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setHdatePid(rs.getInt("HDATE_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setIsHumanCalendar(rs.getBoolean("IS_HUMAN_CALENDAR"));
model.setHdate1(rs.getLong("HDATE1"));
model.setHdate2(rs.getLong("HDATE2"));
model.setSortHdate1(rs.getLong("SORT_HDATE1"));
model.setSortHdate2(rs.getLong("SORT_HDATE2"));
model.setOriginalText(rs.getString("ORIGINAL_TEXT"));
model.setLangCode(rs.getString("LANG_CODE"));
model.setHdateTypeKey(rs.getShort("HDATE_TYPE_KEY"));
model.setNamedMemoPid(rs.getInt("NAMED_MEMO_PID"));
model.setSurety(rs.getString("SURETY"));
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
model.setHdatePid(rs.getInt("HDATE_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setIsHumanCalendar(rs.getBoolean("IS_HUMAN_CALENDAR"));
model.setHdate1(rs.getLong("HDATE1"));
model.setHdate2(rs.getLong("HDATE2"));
model.setSortHdate1(rs.getLong("SORT_HDATE1"));
model.setSortHdate2(rs.getLong("SORT_HDATE2"));
model.setOriginalText(rs.getString("ORIGINAL_TEXT"));
model.setLangCode(rs.getString("LANG_CODE"));
model.setHdateTypeKey(rs.getShort("HDATE_TYPE_KEY"));
model.setNamedMemoPid(rs.getInt("NAMED_MEMO_PID"));
model.setSurety(rs.getString("SURETY"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((Hdates) model).setRecordNum(rs.getInt("RECORD_NUM"));
((Hdates) model).setSetKey(rs.getShort("SET_KEY"));
((Hdates) model).setCommitPid(rs.getInt("COMMIT_PID"));
((Hdates) model).setHdatePid(rs.getInt("HDATE_PID"));
((Hdates) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((Hdates) model).setIsHumanCalendar(rs.getBoolean("IS_HUMAN_CALENDAR"));
((Hdates) model).setHdate1(rs.getLong("HDATE1"));
((Hdates) model).setHdate2(rs.getLong("HDATE2"));
((Hdates) model).setSortHdate1(rs.getLong("SORT_HDATE1"));
((Hdates) model).setSortHdate2(rs.getLong("SORT_HDATE2"));
((Hdates) model).setOriginalText(rs.getString("ORIGINAL_TEXT"));
((Hdates) model).setLangCode(rs.getString("LANG_CODE"));
((Hdates) model).setHdateTypeKey(rs.getShort("HDATE_TYPE_KEY"));
((Hdates) model).setNamedMemoPid(rs.getInt("NAMED_MEMO_PID"));
((Hdates) model).setSurety(rs.getString("SURETY"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((Hdates) model).setRecordNum(rs.getInt("RECORD_NUM"));
((Hdates) model).setSetKey(rs.getShort("SET_KEY"));
((Hdates) model).setCommitPid(rs.getInt("COMMIT_PID"));
((Hdates) model).setHdatePid(rs.getInt("HDATE_PID"));
((Hdates) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((Hdates) model).setIsHumanCalendar(rs.getBoolean("IS_HUMAN_CALENDAR"));
((Hdates) model).setHdate1(rs.getLong("HDATE1"));
((Hdates) model).setHdate2(rs.getLong("HDATE2"));
((Hdates) model).setSortHdate1(rs.getLong("SORT_HDATE1"));
((Hdates) model).setSortHdate2(rs.getLong("SORT_HDATE2"));
((Hdates) model).setOriginalText(rs.getString("ORIGINAL_TEXT"));
((Hdates) model).setLangCode(rs.getString("LANG_CODE"));
((Hdates) model).setHdateTypeKey(rs.getShort("HDATE_TYPE_KEY"));
((Hdates) model).setNamedMemoPid(rs.getInt("NAMED_MEMO_PID"));
((Hdates) model).setSurety(rs.getString("SURETY"));
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

public int getHdatePid() {
return this.HdatePid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public boolean getIsHumanCalendar() {
return this.IsHumanCalendar;
}

public long getHdate1() {
return this.Hdate1;
}

public long getHdate2() {
return this.Hdate2;
}

public long getSortHdate1() {
return this.SortHdate1;
}

public long getSortHdate2() {
return this.SortHdate2;
}

public String getOriginalText() {
return this.OriginalText;
}

public String getLangCode() {
return this.LangCode;
}

public short getHdateTypeKey() {
return this.HdateTypeKey;
}

public int getNamedMemoPid() {
return this.NamedMemoPid;
}

public String getSurety() {
return this.Surety;
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

public void setHdatePid(int HdatePid) {
this.HdatePid = HdatePid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setIsHumanCalendar(boolean IsHumanCalendar) {
this.IsHumanCalendar = IsHumanCalendar;
}

public void setHdate1(long Hdate1) {
this.Hdate1 = Hdate1;
}

public void setHdate2(long Hdate2) {
this.Hdate2 = Hdate2;
}

public void setSortHdate1(long SortHdate1) {
this.SortHdate1 = SortHdate1;
}

public void setSortHdate2(long SortHdate2) {
this.SortHdate2 = SortHdate2;
}

public void setOriginalText(String OriginalText) {
this.OriginalText = OriginalText;
}

public void setLangCode(String LangCode) {
this.LangCode = LangCode;
}

public void setHdateTypeKey(short HdateTypeKey) {
this.HdateTypeKey = HdateTypeKey;
}

public void setNamedMemoPid(int NamedMemoPid) {
this.NamedMemoPid = NamedMemoPid;
}

public void setSurety(String Surety) {
this.Surety = Surety;
}

}

