package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the HINTERVALS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class Hintervals extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"HINTERVAL_PID, " +
"IS_SYSTEM, " +
"IS_HUMAN_CALENDAR, " +
"HINTERVAL1, " +
"HINTERVAL2, " +
"SORT_HINTERVAL1, " +
"SORT_HINTERVAL2, " +
"ORIGINAL_TEXT, " +
"LANG_CODE, " +
"HINTERVAL_TYPE_KEY, " +
"NAMED_MEMO_PID, " +
"SURETY FROM PUBLIC.HINTERVALS WHERE HINTERVAL_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"HINTERVAL_PID, " +  
"IS_SYSTEM, " +  
"IS_HUMAN_CALENDAR, " +  
"HINTERVAL1, " +  
"HINTERVAL2, " +  
"SORT_HINTERVAL1, " +  
"SORT_HINTERVAL2, " +  
"ORIGINAL_TEXT, " +  
"LANG_CODE, " +  
"HINTERVAL_TYPE_KEY, " +  
"NAMED_MEMO_PID, " +  
"SURETY FROM PUBLIC.HINTERVALS";

private static final String INSERT = "INSERT INTO PUBLIC.HINTERVALS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"HINTERVAL_PID, " +     
"IS_SYSTEM, " +     
"IS_HUMAN_CALENDAR, " +     
"HINTERVAL1, " +     
"HINTERVAL2, " +     
"SORT_HINTERVAL1, " +     
"SORT_HINTERVAL2, " +     
"ORIGINAL_TEXT, " +     
"LANG_CODE, " +     
"HINTERVAL_TYPE_KEY, " +     
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

private static final String UPDATE = "UPDATE PUBLIC.HINTERVALSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"IS_HUMAN_CALENDAR = ?, " + 
"HINTERVAL1 = ?, " + 
"HINTERVAL2 = ?, " + 
"SORT_HINTERVAL1 = ?, " + 
"SORT_HINTERVAL2 = ?, " + 
"ORIGINAL_TEXT = ?, " + 
"LANG_CODE = ?, " + 
"HINTERVAL_TYPE_KEY = ?, " + 
"NAMED_MEMO_PID = ?, " + 
"SURETY = ? WHERE HINTERVAL_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.HINTERVALS WHERE HINTERVAL_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.HINTERVALS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int HintervalPid;
private boolean IsSystem;
private boolean IsHumanCalendar;
private long Hinterval1;
private long Hinterval2;
private long SortHinterval1;
private long SortHinterval2;
private String OriginalText;
private String LangCode;
private short HintervalTypeKey;
private int NamedMemoPid;
private String Surety;
private Hintervals model;

public Hintervals() throws SQLException {
}


public Hintervals(int HintervalPid) throws SQLException {
super();
this.HintervalPid = HintervalPid;
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
model = new Hintervals();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setHintervalPid(rs.getInt("HINTERVAL_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setIsHumanCalendar(rs.getBoolean("IS_HUMAN_CALENDAR"));
model.setHinterval1(rs.getLong("HINTERVAL1"));
model.setHinterval2(rs.getLong("HINTERVAL2"));
model.setSortHinterval1(rs.getLong("SORT_HINTERVAL1"));
model.setSortHinterval2(rs.getLong("SORT_HINTERVAL2"));
model.setOriginalText(rs.getString("ORIGINAL_TEXT"));
model.setLangCode(rs.getString("LANG_CODE"));
model.setHintervalTypeKey(rs.getShort("HINTERVAL_TYPE_KEY"));
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
model.setHintervalPid(rs.getInt("HINTERVAL_PID"));
model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
model.setIsHumanCalendar(rs.getBoolean("IS_HUMAN_CALENDAR"));
model.setHinterval1(rs.getLong("HINTERVAL1"));
model.setHinterval2(rs.getLong("HINTERVAL2"));
model.setSortHinterval1(rs.getLong("SORT_HINTERVAL1"));
model.setSortHinterval2(rs.getLong("SORT_HINTERVAL2"));
model.setOriginalText(rs.getString("ORIGINAL_TEXT"));
model.setLangCode(rs.getString("LANG_CODE"));
model.setHintervalTypeKey(rs.getShort("HINTERVAL_TYPE_KEY"));
model.setNamedMemoPid(rs.getInt("NAMED_MEMO_PID"));
model.setSurety(rs.getString("SURETY"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((Hintervals) model).setRecordNum(rs.getInt("RECORD_NUM"));
((Hintervals) model).setSetKey(rs.getShort("SET_KEY"));
((Hintervals) model).setCommitPid(rs.getInt("COMMIT_PID"));
((Hintervals) model).setHintervalPid(rs.getInt("HINTERVAL_PID"));
((Hintervals) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((Hintervals) model).setIsHumanCalendar(rs.getBoolean("IS_HUMAN_CALENDAR"));
((Hintervals) model).setHinterval1(rs.getLong("HINTERVAL1"));
((Hintervals) model).setHinterval2(rs.getLong("HINTERVAL2"));
((Hintervals) model).setSortHinterval1(rs.getLong("SORT_HINTERVAL1"));
((Hintervals) model).setSortHinterval2(rs.getLong("SORT_HINTERVAL2"));
((Hintervals) model).setOriginalText(rs.getString("ORIGINAL_TEXT"));
((Hintervals) model).setLangCode(rs.getString("LANG_CODE"));
((Hintervals) model).setHintervalTypeKey(rs.getShort("HINTERVAL_TYPE_KEY"));
((Hintervals) model).setNamedMemoPid(rs.getInt("NAMED_MEMO_PID"));
((Hintervals) model).setSurety(rs.getString("SURETY"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((Hintervals) model).setRecordNum(rs.getInt("RECORD_NUM"));
((Hintervals) model).setSetKey(rs.getShort("SET_KEY"));
((Hintervals) model).setCommitPid(rs.getInt("COMMIT_PID"));
((Hintervals) model).setHintervalPid(rs.getInt("HINTERVAL_PID"));
((Hintervals) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
((Hintervals) model).setIsHumanCalendar(rs.getBoolean("IS_HUMAN_CALENDAR"));
((Hintervals) model).setHinterval1(rs.getLong("HINTERVAL1"));
((Hintervals) model).setHinterval2(rs.getLong("HINTERVAL2"));
((Hintervals) model).setSortHinterval1(rs.getLong("SORT_HINTERVAL1"));
((Hintervals) model).setSortHinterval2(rs.getLong("SORT_HINTERVAL2"));
((Hintervals) model).setOriginalText(rs.getString("ORIGINAL_TEXT"));
((Hintervals) model).setLangCode(rs.getString("LANG_CODE"));
((Hintervals) model).setHintervalTypeKey(rs.getShort("HINTERVAL_TYPE_KEY"));
((Hintervals) model).setNamedMemoPid(rs.getInt("NAMED_MEMO_PID"));
((Hintervals) model).setSurety(rs.getString("SURETY"));
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

public int getHintervalPid() {
return this.HintervalPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public boolean getIsHumanCalendar() {
return this.IsHumanCalendar;
}

public long getHinterval1() {
return this.Hinterval1;
}

public long getHinterval2() {
return this.Hinterval2;
}

public long getSortHinterval1() {
return this.SortHinterval1;
}

public long getSortHinterval2() {
return this.SortHinterval2;
}

public String getOriginalText() {
return this.OriginalText;
}

public String getLangCode() {
return this.LangCode;
}

public short getHintervalTypeKey() {
return this.HintervalTypeKey;
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

public void setHintervalPid(int HintervalPid) {
this.HintervalPid = HintervalPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setIsHumanCalendar(boolean IsHumanCalendar) {
this.IsHumanCalendar = IsHumanCalendar;
}

public void setHinterval1(long Hinterval1) {
this.Hinterval1 = Hinterval1;
}

public void setHinterval2(long Hinterval2) {
this.Hinterval2 = Hinterval2;
}

public void setSortHinterval1(long SortHinterval1) {
this.SortHinterval1 = SortHinterval1;
}

public void setSortHinterval2(long SortHinterval2) {
this.SortHinterval2 = SortHinterval2;
}

public void setOriginalText(String OriginalText) {
this.OriginalText = OriginalText;
}

public void setLangCode(String LangCode) {
this.LangCode = LangCode;
}

public void setHintervalTypeKey(short HintervalTypeKey) {
this.HintervalTypeKey = HintervalTypeKey;
}

public void setNamedMemoPid(int NamedMemoPid) {
this.NamedMemoPid = NamedMemoPid;
}

public void setSurety(String Surety) {
this.Surety = Surety;
}

}

