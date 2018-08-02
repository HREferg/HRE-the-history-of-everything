package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the SUBSTN_SYNTAX_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class SubstnSyntaxDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"SUBSTN_SYNTAX_DEFN_PID, " +
"ENCLOSES_MARKUP, " +
"INTERNAL_BEGIN_MARK, " +
"VISIBLE_BEGIN_MARK, " +
"INTERNAL_END_MARK, " +
"VISIBLE_END_MARK, " +
"INTERNAL_BEGIN_TRUE, " +
"VISIBLE_BEGIN_TRUE, " +
"INTERNAL_END_TRUE, " +
"VISIBLE_END_TRUE, " +
"INTERNAL_DIVIDER_MARK, " +
"VISIBLE_DIVIDER_MARK, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"SHOW FROM PUBLIC.SUBSTN_SYNTAX_DEFNS WHERE SUBSTN_SYNTAX_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"SUBSTN_SYNTAX_DEFN_PID, " +  
"ENCLOSES_MARKUP, " +  
"INTERNAL_BEGIN_MARK, " +  
"VISIBLE_BEGIN_MARK, " +  
"INTERNAL_END_MARK, " +  
"VISIBLE_END_MARK, " +  
"INTERNAL_BEGIN_TRUE, " +  
"VISIBLE_BEGIN_TRUE, " +  
"INTERNAL_END_TRUE, " +  
"VISIBLE_END_TRUE, " +  
"INTERNAL_DIVIDER_MARK, " +  
"VISIBLE_DIVIDER_MARK, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"SHOW FROM PUBLIC.SUBSTN_SYNTAX_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_SYNTAX_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"SUBSTN_SYNTAX_DEFN_PID, " +     
"ENCLOSES_MARKUP, " +     
"INTERNAL_BEGIN_MARK, " +     
"VISIBLE_BEGIN_MARK, " +     
"INTERNAL_END_MARK, " +     
"VISIBLE_END_MARK, " +     
"INTERNAL_BEGIN_TRUE, " +     
"VISIBLE_BEGIN_TRUE, " +     
"INTERNAL_END_TRUE, " +     
"VISIBLE_END_TRUE, " +     
"INTERNAL_DIVIDER_MARK, " +     
"VISIBLE_DIVIDER_MARK, " +     
"REMINDER_KEY, " +     
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
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_SYNTAX_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"ENCLOSES_MARKUP = ?, " + 
"INTERNAL_BEGIN_MARK = ?, " + 
"VISIBLE_BEGIN_MARK = ?, " + 
"INTERNAL_END_MARK = ?, " + 
"VISIBLE_END_MARK = ?, " + 
"INTERNAL_BEGIN_TRUE = ?, " + 
"VISIBLE_BEGIN_TRUE = ?, " + 
"INTERNAL_END_TRUE = ?, " + 
"VISIBLE_END_TRUE = ?, " + 
"INTERNAL_DIVIDER_MARK = ?, " + 
"VISIBLE_DIVIDER_MARK = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"SHOW = ? WHERE SUBSTN_SYNTAX_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_SYNTAX_DEFNS WHERE SUBSTN_SYNTAX_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_SYNTAX_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int SubstnSyntaxDefnPid;
private boolean EnclosesMarkup;
private String InternalBeginMark;
private String VisibleBeginMark;
private String InternalEndMark;
private String VisibleEndMark;
private String InternalBeginTrue;
private String VisibleBeginTrue;
private String InternalEndTrue;
private String VisibleEndTrue;
private String InternalDividerMark;
private String VisibleDividerMark;
private short ReminderKey;
private short DisplayOrder;
private boolean Show;
private SubstnSyntaxDefns model;

public SubstnSyntaxDefns() throws SQLException {
}


public SubstnSyntaxDefns(int SubstnSyntaxDefnPid) throws SQLException {
super();
this.SubstnSyntaxDefnPid = SubstnSyntaxDefnPid;
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
model = new SubstnSyntaxDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setSubstnSyntaxDefnPid(rs.getInt("SUBSTN_SYNTAX_DEFN_PID"));
model.setEnclosesMarkup(rs.getBoolean("ENCLOSES_MARKUP"));
model.setInternalBeginMark(rs.getString("INTERNAL_BEGIN_MARK"));
model.setVisibleBeginMark(rs.getString("VISIBLE_BEGIN_MARK"));
model.setInternalEndMark(rs.getString("INTERNAL_END_MARK"));
model.setVisibleEndMark(rs.getString("VISIBLE_END_MARK"));
model.setInternalBeginTrue(rs.getString("INTERNAL_BEGIN_TRUE"));
model.setVisibleBeginTrue(rs.getString("VISIBLE_BEGIN_TRUE"));
model.setInternalEndTrue(rs.getString("INTERNAL_END_TRUE"));
model.setVisibleEndTrue(rs.getString("VISIBLE_END_TRUE"));
model.setInternalDividerMark(rs.getString("INTERNAL_DIVIDER_MARK"));
model.setVisibleDividerMark(rs.getString("VISIBLE_DIVIDER_MARK"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
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
model.setSubstnSyntaxDefnPid(rs.getInt("SUBSTN_SYNTAX_DEFN_PID"));
model.setEnclosesMarkup(rs.getBoolean("ENCLOSES_MARKUP"));
model.setInternalBeginMark(rs.getString("INTERNAL_BEGIN_MARK"));
model.setVisibleBeginMark(rs.getString("VISIBLE_BEGIN_MARK"));
model.setInternalEndMark(rs.getString("INTERNAL_END_MARK"));
model.setVisibleEndMark(rs.getString("VISIBLE_END_MARK"));
model.setInternalBeginTrue(rs.getString("INTERNAL_BEGIN_TRUE"));
model.setVisibleBeginTrue(rs.getString("VISIBLE_BEGIN_TRUE"));
model.setInternalEndTrue(rs.getString("INTERNAL_END_TRUE"));
model.setVisibleEndTrue(rs.getString("VISIBLE_END_TRUE"));
model.setInternalDividerMark(rs.getString("INTERNAL_DIVIDER_MARK"));
model.setVisibleDividerMark(rs.getString("VISIBLE_DIVIDER_MARK"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setShow(rs.getBoolean("SHOW"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((SubstnSyntaxDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubstnSyntaxDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SubstnSyntaxDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubstnSyntaxDefns) model).setSubstnSyntaxDefnPid(rs.getInt("SUBSTN_SYNTAX_DEFN_PID"));
((SubstnSyntaxDefns) model).setEnclosesMarkup(rs.getBoolean("ENCLOSES_MARKUP"));
((SubstnSyntaxDefns) model).setInternalBeginMark(rs.getString("INTERNAL_BEGIN_MARK"));
((SubstnSyntaxDefns) model).setVisibleBeginMark(rs.getString("VISIBLE_BEGIN_MARK"));
((SubstnSyntaxDefns) model).setInternalEndMark(rs.getString("INTERNAL_END_MARK"));
((SubstnSyntaxDefns) model).setVisibleEndMark(rs.getString("VISIBLE_END_MARK"));
((SubstnSyntaxDefns) model).setInternalBeginTrue(rs.getString("INTERNAL_BEGIN_TRUE"));
((SubstnSyntaxDefns) model).setVisibleBeginTrue(rs.getString("VISIBLE_BEGIN_TRUE"));
((SubstnSyntaxDefns) model).setInternalEndTrue(rs.getString("INTERNAL_END_TRUE"));
((SubstnSyntaxDefns) model).setVisibleEndTrue(rs.getString("VISIBLE_END_TRUE"));
((SubstnSyntaxDefns) model).setInternalDividerMark(rs.getString("INTERNAL_DIVIDER_MARK"));
((SubstnSyntaxDefns) model).setVisibleDividerMark(rs.getString("VISIBLE_DIVIDER_MARK"));
((SubstnSyntaxDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SubstnSyntaxDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SubstnSyntaxDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((SubstnSyntaxDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((SubstnSyntaxDefns) model).setSetKey(rs.getShort("SET_KEY"));
((SubstnSyntaxDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((SubstnSyntaxDefns) model).setSubstnSyntaxDefnPid(rs.getInt("SUBSTN_SYNTAX_DEFN_PID"));
((SubstnSyntaxDefns) model).setEnclosesMarkup(rs.getBoolean("ENCLOSES_MARKUP"));
((SubstnSyntaxDefns) model).setInternalBeginMark(rs.getString("INTERNAL_BEGIN_MARK"));
((SubstnSyntaxDefns) model).setVisibleBeginMark(rs.getString("VISIBLE_BEGIN_MARK"));
((SubstnSyntaxDefns) model).setInternalEndMark(rs.getString("INTERNAL_END_MARK"));
((SubstnSyntaxDefns) model).setVisibleEndMark(rs.getString("VISIBLE_END_MARK"));
((SubstnSyntaxDefns) model).setInternalBeginTrue(rs.getString("INTERNAL_BEGIN_TRUE"));
((SubstnSyntaxDefns) model).setVisibleBeginTrue(rs.getString("VISIBLE_BEGIN_TRUE"));
((SubstnSyntaxDefns) model).setInternalEndTrue(rs.getString("INTERNAL_END_TRUE"));
((SubstnSyntaxDefns) model).setVisibleEndTrue(rs.getString("VISIBLE_END_TRUE"));
((SubstnSyntaxDefns) model).setInternalDividerMark(rs.getString("INTERNAL_DIVIDER_MARK"));
((SubstnSyntaxDefns) model).setVisibleDividerMark(rs.getString("VISIBLE_DIVIDER_MARK"));
((SubstnSyntaxDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((SubstnSyntaxDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((SubstnSyntaxDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getSubstnSyntaxDefnPid() {
return this.SubstnSyntaxDefnPid;
}

public boolean getEnclosesMarkup() {
return this.EnclosesMarkup;
}

public String getInternalBeginMark() {
return this.InternalBeginMark;
}

public String getVisibleBeginMark() {
return this.VisibleBeginMark;
}

public String getInternalEndMark() {
return this.InternalEndMark;
}

public String getVisibleEndMark() {
return this.VisibleEndMark;
}

public String getInternalBeginTrue() {
return this.InternalBeginTrue;
}

public String getVisibleBeginTrue() {
return this.VisibleBeginTrue;
}

public String getInternalEndTrue() {
return this.InternalEndTrue;
}

public String getVisibleEndTrue() {
return this.VisibleEndTrue;
}

public String getInternalDividerMark() {
return this.InternalDividerMark;
}

public String getVisibleDividerMark() {
return this.VisibleDividerMark;
}

public short getReminderKey() {
return this.ReminderKey;
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

public void setSubstnSyntaxDefnPid(int SubstnSyntaxDefnPid) {
this.SubstnSyntaxDefnPid = SubstnSyntaxDefnPid;
}

public void setEnclosesMarkup(boolean EnclosesMarkup) {
this.EnclosesMarkup = EnclosesMarkup;
}

public void setInternalBeginMark(String InternalBeginMark) {
this.InternalBeginMark = InternalBeginMark;
}

public void setVisibleBeginMark(String VisibleBeginMark) {
this.VisibleBeginMark = VisibleBeginMark;
}

public void setInternalEndMark(String InternalEndMark) {
this.InternalEndMark = InternalEndMark;
}

public void setVisibleEndMark(String VisibleEndMark) {
this.VisibleEndMark = VisibleEndMark;
}

public void setInternalBeginTrue(String InternalBeginTrue) {
this.InternalBeginTrue = InternalBeginTrue;
}

public void setVisibleBeginTrue(String VisibleBeginTrue) {
this.VisibleBeginTrue = VisibleBeginTrue;
}

public void setInternalEndTrue(String InternalEndTrue) {
this.InternalEndTrue = InternalEndTrue;
}

public void setVisibleEndTrue(String VisibleEndTrue) {
this.VisibleEndTrue = VisibleEndTrue;
}

public void setInternalDividerMark(String InternalDividerMark) {
this.InternalDividerMark = InternalDividerMark;
}

public void setVisibleDividerMark(String VisibleDividerMark) {
this.VisibleDividerMark = VisibleDividerMark;
}

public void setReminderKey(short ReminderKey) {
this.ReminderKey = ReminderKey;
}

public void setDisplayOrder(short DisplayOrder) {
this.DisplayOrder = DisplayOrder;
}

public void setShow(boolean Show) {
this.Show = Show;
}

}

