package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the TEXT_STYLE_DEFNS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class TextStyleDefns extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"TEXT_STYLE_DEFN_PID, " +
"IS_USER_DEFN, " +
"FONT_NAME, " +
"FONT_SIZE, " +
"FONT_IS_BOLD, " +
"FONT_IS_ITALIC, " +
"FONT_UNDERLINED, " +
"FONT_COLOR, " +
"HIGHLIGHT_COLOR, " +
"TEXT_LINK_KEY, " +
"MARKER1_LINK_KEY, " +
"MARKER2_LINK_KEY, " +
"MARKER3_LINK_KEY, " +
"MARKER4_LINK_KEY, " +
"REMINDER_KEY, " +
"DISPLAY_ORDER, " +
"IS_DEFAULT, " +
"SHOW FROM PUBLIC.TEXT_STYLE_DEFNS WHERE TEXT_STYLE_DEFN_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"TEXT_STYLE_DEFN_PID, " +  
"IS_USER_DEFN, " +  
"FONT_NAME, " +  
"FONT_SIZE, " +  
"FONT_IS_BOLD, " +  
"FONT_IS_ITALIC, " +  
"FONT_UNDERLINED, " +  
"FONT_COLOR, " +  
"HIGHLIGHT_COLOR, " +  
"TEXT_LINK_KEY, " +  
"MARKER1_LINK_KEY, " +  
"MARKER2_LINK_KEY, " +  
"MARKER3_LINK_KEY, " +  
"MARKER4_LINK_KEY, " +  
"REMINDER_KEY, " +  
"DISPLAY_ORDER, " +  
"IS_DEFAULT, " +  
"SHOW FROM PUBLIC.TEXT_STYLE_DEFNS";

private static final String INSERT = "INSERT INTO PUBLIC.TEXT_STYLE_DEFNS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"TEXT_STYLE_DEFN_PID, " +     
"IS_USER_DEFN, " +     
"FONT_NAME, " +     
"FONT_SIZE, " +     
"FONT_IS_BOLD, " +     
"FONT_IS_ITALIC, " +     
"FONT_UNDERLINED, " +     
"FONT_COLOR, " +     
"HIGHLIGHT_COLOR, " +     
"TEXT_LINK_KEY, " +     
"MARKER1_LINK_KEY, " +     
"MARKER2_LINK_KEY, " +     
"MARKER3_LINK_KEY, " +     
"MARKER4_LINK_KEY, " +     
"REMINDER_KEY, " +     
"DISPLAY_ORDER, " +     
"IS_DEFAULT, " +     
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
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.TEXT_STYLE_DEFNSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_USER_DEFN = ?, " + 
"FONT_NAME = ?, " + 
"FONT_SIZE = ?, " + 
"FONT_IS_BOLD = ?, " + 
"FONT_IS_ITALIC = ?, " + 
"FONT_UNDERLINED = ?, " + 
"FONT_COLOR = ?, " + 
"HIGHLIGHT_COLOR = ?, " + 
"TEXT_LINK_KEY = ?, " + 
"MARKER1_LINK_KEY = ?, " + 
"MARKER2_LINK_KEY = ?, " + 
"MARKER3_LINK_KEY = ?, " + 
"MARKER4_LINK_KEY = ?, " + 
"REMINDER_KEY = ?, " + 
"DISPLAY_ORDER = ?, " + 
"IS_DEFAULT = ?, " + 
"SHOW = ? WHERE TEXT_STYLE_DEFN_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.TEXT_STYLE_DEFNS WHERE TEXT_STYLE_DEFN_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.TEXT_STYLE_DEFNS";

private int RecordNum;
private short SetKey;
private int CommitPid;
private int TextStyleDefnPid;
private boolean IsUserDefn;
private String FontName;
private short FontSize;
private boolean FontIsBold;
private boolean FontIsItalic;
private boolean FontUnderlined;
private short FontColor;
private short HighlightColor;
private short TextLinkKey;
private short Marker1LinkKey;
private short Marker2LinkKey;
private short Marker3LinkKey;
private short Marker4LinkKey;
private short ReminderKey;
private short DisplayOrder;
private boolean IsDefault;
private boolean Show;
private TextStyleDefns model;

public TextStyleDefns() throws SQLException {
}


public TextStyleDefns(int TextStyleDefnPid) throws SQLException {
super();
this.TextStyleDefnPid = TextStyleDefnPid;
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
model = new TextStyleDefns();
model.setRecordNum(rs.getInt("RECORD_NUM"));
model.setSetKey(rs.getShort("SET_KEY"));
model.setCommitPid(rs.getInt("COMMIT_PID"));
model.setTextStyleDefnPid(rs.getInt("TEXT_STYLE_DEFN_PID"));
model.setIsUserDefn(rs.getBoolean("IS_USER_DEFN"));
model.setFontName(rs.getString("FONT_NAME"));
model.setFontSize(rs.getShort("FONT_SIZE"));
model.setFontIsBold(rs.getBoolean("FONT_IS_BOLD"));
model.setFontIsItalic(rs.getBoolean("FONT_IS_ITALIC"));
model.setFontUnderlined(rs.getBoolean("FONT_UNDERLINED"));
model.setFontColor(rs.getShort("FONT_COLOR"));
model.setHighlightColor(rs.getShort("HIGHLIGHT_COLOR"));
model.setTextLinkKey(rs.getShort("TEXT_LINK_KEY"));
model.setMarker1LinkKey(rs.getShort("MARKER1_LINK_KEY"));
model.setMarker2LinkKey(rs.getShort("MARKER2_LINK_KEY"));
model.setMarker3LinkKey(rs.getShort("MARKER3_LINK_KEY"));
model.setMarker4LinkKey(rs.getShort("MARKER4_LINK_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
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
model.setTextStyleDefnPid(rs.getInt("TEXT_STYLE_DEFN_PID"));
model.setIsUserDefn(rs.getBoolean("IS_USER_DEFN"));
model.setFontName(rs.getString("FONT_NAME"));
model.setFontSize(rs.getShort("FONT_SIZE"));
model.setFontIsBold(rs.getBoolean("FONT_IS_BOLD"));
model.setFontIsItalic(rs.getBoolean("FONT_IS_ITALIC"));
model.setFontUnderlined(rs.getBoolean("FONT_UNDERLINED"));
model.setFontColor(rs.getShort("FONT_COLOR"));
model.setHighlightColor(rs.getShort("HIGHLIGHT_COLOR"));
model.setTextLinkKey(rs.getShort("TEXT_LINK_KEY"));
model.setMarker1LinkKey(rs.getShort("MARKER1_LINK_KEY"));
model.setMarker2LinkKey(rs.getShort("MARKER2_LINK_KEY"));
model.setMarker3LinkKey(rs.getShort("MARKER3_LINK_KEY"));
model.setMarker4LinkKey(rs.getShort("MARKER4_LINK_KEY"));
model.setReminderKey(rs.getShort("REMINDER_KEY"));
model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
model.setShow(rs.getBoolean("SHOW"));
}
return this;
}

@Override
public void post(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(INSERT);
((TextStyleDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((TextStyleDefns) model).setSetKey(rs.getShort("SET_KEY"));
((TextStyleDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((TextStyleDefns) model).setTextStyleDefnPid(rs.getInt("TEXT_STYLE_DEFN_PID"));
((TextStyleDefns) model).setIsUserDefn(rs.getBoolean("IS_USER_DEFN"));
((TextStyleDefns) model).setFontName(rs.getString("FONT_NAME"));
((TextStyleDefns) model).setFontSize(rs.getShort("FONT_SIZE"));
((TextStyleDefns) model).setFontIsBold(rs.getBoolean("FONT_IS_BOLD"));
((TextStyleDefns) model).setFontIsItalic(rs.getBoolean("FONT_IS_ITALIC"));
((TextStyleDefns) model).setFontUnderlined(rs.getBoolean("FONT_UNDERLINED"));
((TextStyleDefns) model).setFontColor(rs.getShort("FONT_COLOR"));
((TextStyleDefns) model).setHighlightColor(rs.getShort("HIGHLIGHT_COLOR"));
((TextStyleDefns) model).setTextLinkKey(rs.getShort("TEXT_LINK_KEY"));
((TextStyleDefns) model).setMarker1LinkKey(rs.getShort("MARKER1_LINK_KEY"));
((TextStyleDefns) model).setMarker2LinkKey(rs.getShort("MARKER2_LINK_KEY"));
((TextStyleDefns) model).setMarker3LinkKey(rs.getShort("MARKER3_LINK_KEY"));
((TextStyleDefns) model).setMarker4LinkKey(rs.getShort("MARKER4_LINK_KEY"));
((TextStyleDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((TextStyleDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((TextStyleDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((TextStyleDefns) model).setShow(rs.getBoolean("SHOW"));
ps.executeUpdate();
}

@Override
public void put(AbstractHreDataModel model) throws SQLException {
ps = conn.prepareStatement(UPDATE);
((TextStyleDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
((TextStyleDefns) model).setSetKey(rs.getShort("SET_KEY"));
((TextStyleDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
((TextStyleDefns) model).setTextStyleDefnPid(rs.getInt("TEXT_STYLE_DEFN_PID"));
((TextStyleDefns) model).setIsUserDefn(rs.getBoolean("IS_USER_DEFN"));
((TextStyleDefns) model).setFontName(rs.getString("FONT_NAME"));
((TextStyleDefns) model).setFontSize(rs.getShort("FONT_SIZE"));
((TextStyleDefns) model).setFontIsBold(rs.getBoolean("FONT_IS_BOLD"));
((TextStyleDefns) model).setFontIsItalic(rs.getBoolean("FONT_IS_ITALIC"));
((TextStyleDefns) model).setFontUnderlined(rs.getBoolean("FONT_UNDERLINED"));
((TextStyleDefns) model).setFontColor(rs.getShort("FONT_COLOR"));
((TextStyleDefns) model).setHighlightColor(rs.getShort("HIGHLIGHT_COLOR"));
((TextStyleDefns) model).setTextLinkKey(rs.getShort("TEXT_LINK_KEY"));
((TextStyleDefns) model).setMarker1LinkKey(rs.getShort("MARKER1_LINK_KEY"));
((TextStyleDefns) model).setMarker2LinkKey(rs.getShort("MARKER2_LINK_KEY"));
((TextStyleDefns) model).setMarker3LinkKey(rs.getShort("MARKER3_LINK_KEY"));
((TextStyleDefns) model).setMarker4LinkKey(rs.getShort("MARKER4_LINK_KEY"));
((TextStyleDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
((TextStyleDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
((TextStyleDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
((TextStyleDefns) model).setShow(rs.getBoolean("SHOW"));
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

public int getTextStyleDefnPid() {
return this.TextStyleDefnPid;
}

public boolean getIsUserDefn() {
return this.IsUserDefn;
}

public String getFontName() {
return this.FontName;
}

public short getFontSize() {
return this.FontSize;
}

public boolean getFontIsBold() {
return this.FontIsBold;
}

public boolean getFontIsItalic() {
return this.FontIsItalic;
}

public boolean getFontUnderlined() {
return this.FontUnderlined;
}

public short getFontColor() {
return this.FontColor;
}

public short getHighlightColor() {
return this.HighlightColor;
}

public short getTextLinkKey() {
return this.TextLinkKey;
}

public short getMarker1LinkKey() {
return this.Marker1LinkKey;
}

public short getMarker2LinkKey() {
return this.Marker2LinkKey;
}

public short getMarker3LinkKey() {
return this.Marker3LinkKey;
}

public short getMarker4LinkKey() {
return this.Marker4LinkKey;
}

public short getReminderKey() {
return this.ReminderKey;
}

public short getDisplayOrder() {
return this.DisplayOrder;
}

public boolean getIsDefault() {
return this.IsDefault;
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

public void setTextStyleDefnPid(int TextStyleDefnPid) {
this.TextStyleDefnPid = TextStyleDefnPid;
}

public void setIsUserDefn(boolean IsUserDefn) {
this.IsUserDefn = IsUserDefn;
}

public void setFontName(String FontName) {
this.FontName = FontName;
}

public void setFontSize(short FontSize) {
this.FontSize = FontSize;
}

public void setFontIsBold(boolean FontIsBold) {
this.FontIsBold = FontIsBold;
}

public void setFontIsItalic(boolean FontIsItalic) {
this.FontIsItalic = FontIsItalic;
}

public void setFontUnderlined(boolean FontUnderlined) {
this.FontUnderlined = FontUnderlined;
}

public void setFontColor(short FontColor) {
this.FontColor = FontColor;
}

public void setHighlightColor(short HighlightColor) {
this.HighlightColor = HighlightColor;
}

public void setTextLinkKey(short TextLinkKey) {
this.TextLinkKey = TextLinkKey;
}

public void setMarker1LinkKey(short Marker1LinkKey) {
this.Marker1LinkKey = Marker1LinkKey;
}

public void setMarker2LinkKey(short Marker2LinkKey) {
this.Marker2LinkKey = Marker2LinkKey;
}

public void setMarker3LinkKey(short Marker3LinkKey) {
this.Marker3LinkKey = Marker3LinkKey;
}

public void setMarker4LinkKey(short Marker4LinkKey) {
this.Marker4LinkKey = Marker4LinkKey;
}

public void setReminderKey(short ReminderKey) {
this.ReminderKey = ReminderKey;
}

public void setDisplayOrder(short DisplayOrder) {
this.DisplayOrder = DisplayOrder;
}

public void setIsDefault(boolean IsDefault) {
this.IsDefault = IsDefault;
}

public void setShow(boolean Show) {
this.Show = Show;
}

}

