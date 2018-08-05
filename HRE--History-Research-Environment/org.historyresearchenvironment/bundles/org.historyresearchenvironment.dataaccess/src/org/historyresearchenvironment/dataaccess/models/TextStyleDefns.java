package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the TEXT_STYLE_DEFNS database table.
*
* @version 2018-08-05
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

/**
* No-arg Constructor
*
* @throws SQLException If database access has failed
*/

public TextStyleDefns() throws SQLException {
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
public TextStyleDefns get(int key) throws SQLException {
model = new TextStyleDefns();
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
return model;
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
* Get the TextStyleDefnPid field.
*
* @return Contents of the TEXT_STYLE_DEFN_PID column
*/
public int getTextStyleDefnPid() {
return this.TextStyleDefnPid;
}

/**
* Get the IsUserDefn field.
*
* @return Contents of the IS_USER_DEFN column
*/
public boolean getIsUserDefn() {
return this.IsUserDefn;
}

/**
* Get the FontName field.
*
* @return Contents of the FONT_NAME column
*/
public String getFontName() {
return this.FontName;
}

/**
* Get the FontSize field.
*
* @return Contents of the FONT_SIZE column
*/
public short getFontSize() {
return this.FontSize;
}

/**
* Get the FontIsBold field.
*
* @return Contents of the FONT_IS_BOLD column
*/
public boolean getFontIsBold() {
return this.FontIsBold;
}

/**
* Get the FontIsItalic field.
*
* @return Contents of the FONT_IS_ITALIC column
*/
public boolean getFontIsItalic() {
return this.FontIsItalic;
}

/**
* Get the FontUnderlined field.
*
* @return Contents of the FONT_UNDERLINED column
*/
public boolean getFontUnderlined() {
return this.FontUnderlined;
}

/**
* Get the FontColor field.
*
* @return Contents of the FONT_COLOR column
*/
public short getFontColor() {
return this.FontColor;
}

/**
* Get the HighlightColor field.
*
* @return Contents of the HIGHLIGHT_COLOR column
*/
public short getHighlightColor() {
return this.HighlightColor;
}

/**
* Get the TextLinkKey field.
*
* @return Contents of the TEXT_LINK_KEY column
*/
public short getTextLinkKey() {
return this.TextLinkKey;
}

/**
* Get the Marker1LinkKey field.
*
* @return Contents of the MARKER1_LINK_KEY column
*/
public short getMarker1LinkKey() {
return this.Marker1LinkKey;
}

/**
* Get the Marker2LinkKey field.
*
* @return Contents of the MARKER2_LINK_KEY column
*/
public short getMarker2LinkKey() {
return this.Marker2LinkKey;
}

/**
* Get the Marker3LinkKey field.
*
* @return Contents of the MARKER3_LINK_KEY column
*/
public short getMarker3LinkKey() {
return this.Marker3LinkKey;
}

/**
* Get the Marker4LinkKey field.
*
* @return Contents of the MARKER4_LINK_KEY column
*/
public short getMarker4LinkKey() {
return this.Marker4LinkKey;
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
* Get the DisplayOrder field.
*
* @return Contents of the DISPLAY_ORDER column
*/
public short getDisplayOrder() {
return this.DisplayOrder;
}

/**
* Get the IsDefault field.
*
* @return Contents of the IS_DEFAULT column
*/
public boolean getIsDefault() {
return this.IsDefault;
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
* Set the TextStyleDefnPid field
*
* @param TextStyleDefnPid Contents of the TEXT_STYLE_DEFN_PID column
*/
public void setTextStyleDefnPid(int TextStyleDefnPid) {
this.TextStyleDefnPid = TextStyleDefnPid;
}

/**
* Set the IsUserDefn field
*
* @param IsUserDefn Contents of the IS_USER_DEFN column
*/
public void setIsUserDefn(boolean IsUserDefn) {
this.IsUserDefn = IsUserDefn;
}

/**
* Set the FontName field
*
* @param FontName Contents of the FONT_NAME column
*/
public void setFontName(String FontName) {
this.FontName = FontName;
}

/**
* Set the FontSize field
*
* @param FontSize Contents of the FONT_SIZE column
*/
public void setFontSize(short FontSize) {
this.FontSize = FontSize;
}

/**
* Set the FontIsBold field
*
* @param FontIsBold Contents of the FONT_IS_BOLD column
*/
public void setFontIsBold(boolean FontIsBold) {
this.FontIsBold = FontIsBold;
}

/**
* Set the FontIsItalic field
*
* @param FontIsItalic Contents of the FONT_IS_ITALIC column
*/
public void setFontIsItalic(boolean FontIsItalic) {
this.FontIsItalic = FontIsItalic;
}

/**
* Set the FontUnderlined field
*
* @param FontUnderlined Contents of the FONT_UNDERLINED column
*/
public void setFontUnderlined(boolean FontUnderlined) {
this.FontUnderlined = FontUnderlined;
}

/**
* Set the FontColor field
*
* @param FontColor Contents of the FONT_COLOR column
*/
public void setFontColor(short FontColor) {
this.FontColor = FontColor;
}

/**
* Set the HighlightColor field
*
* @param HighlightColor Contents of the HIGHLIGHT_COLOR column
*/
public void setHighlightColor(short HighlightColor) {
this.HighlightColor = HighlightColor;
}

/**
* Set the TextLinkKey field
*
* @param TextLinkKey Contents of the TEXT_LINK_KEY column
*/
public void setTextLinkKey(short TextLinkKey) {
this.TextLinkKey = TextLinkKey;
}

/**
* Set the Marker1LinkKey field
*
* @param Marker1LinkKey Contents of the MARKER1_LINK_KEY column
*/
public void setMarker1LinkKey(short Marker1LinkKey) {
this.Marker1LinkKey = Marker1LinkKey;
}

/**
* Set the Marker2LinkKey field
*
* @param Marker2LinkKey Contents of the MARKER2_LINK_KEY column
*/
public void setMarker2LinkKey(short Marker2LinkKey) {
this.Marker2LinkKey = Marker2LinkKey;
}

/**
* Set the Marker3LinkKey field
*
* @param Marker3LinkKey Contents of the MARKER3_LINK_KEY column
*/
public void setMarker3LinkKey(short Marker3LinkKey) {
this.Marker3LinkKey = Marker3LinkKey;
}

/**
* Set the Marker4LinkKey field
*
* @param Marker4LinkKey Contents of the MARKER4_LINK_KEY column
*/
public void setMarker4LinkKey(short Marker4LinkKey) {
this.Marker4LinkKey = Marker4LinkKey;
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
* Set the DisplayOrder field
*
* @param DisplayOrder Contents of the DISPLAY_ORDER column
*/
public void setDisplayOrder(short DisplayOrder) {
this.DisplayOrder = DisplayOrder;
}

/**
* Set the IsDefault field
*
* @param IsDefault Contents of the IS_DEFAULT column
*/
public void setIsDefault(boolean IsDefault) {
this.IsDefault = IsDefault;
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

