package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the OCCASN_TAG_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class OccasnTagDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_TAG_DEFN_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, " + "VIEW_DATA_SCRIPT_PID, "
			+ "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, " + "DELETE_DATA_SCRIPT_GROUP_KEY, "
			+ "DELETE_DATA_SCRIPT_PID, " + "IS_EVENT, " + "MIN_NUM_LOCATION_ASSOC, " + "HAS_PARENTS, "
			+ "MAX_NUM_LOCATION_ASSOC, " + "MIN_NUM_HDATE_ASSOC, " + "MAX_NUM_HDATE_ASSOC, " + "MIN_NUM_KEY_ASSOC, "
			+ "MAX_NUM_KEY_ASSOC, " + "DFLT_TAG_GROUP_KEY, " + "DFLT_THEME_KEY, " + "SENTCE_SET_TYPE_KEY, "
			+ "SENTCE_STYLE_TYPE_KEY, " + "GLOBAL_SENTCE_SET_KEY, " + "MEMO_SET_TYPE_KEY, " + "GEDCOM_TAG, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.OCCASN_TAG_DEFNS WHERE OCCASN_TAG_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_TAG_DEFN_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, " + "VIEW_DATA_SCRIPT_PID, "
			+ "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, " + "DELETE_DATA_SCRIPT_GROUP_KEY, "
			+ "DELETE_DATA_SCRIPT_PID, " + "IS_EVENT, " + "MIN_NUM_LOCATION_ASSOC, " + "HAS_PARENTS, "
			+ "MAX_NUM_LOCATION_ASSOC, " + "MIN_NUM_HDATE_ASSOC, " + "MAX_NUM_HDATE_ASSOC, " + "MIN_NUM_KEY_ASSOC, "
			+ "MAX_NUM_KEY_ASSOC, " + "DFLT_TAG_GROUP_KEY, " + "DFLT_THEME_KEY, " + "SENTCE_SET_TYPE_KEY, "
			+ "SENTCE_STYLE_TYPE_KEY, " + "GLOBAL_SENTCE_SET_KEY, " + "MEMO_SET_TYPE_KEY, " + "GEDCOM_TAG, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.OCCASN_TAG_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.OCCASN_TAG_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "OCCASN_TAG_DEFN_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, "
			+ "VIEW_DATA_SCRIPT_PID, " + "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, "
			+ "DELETE_DATA_SCRIPT_GROUP_KEY, " + "DELETE_DATA_SCRIPT_PID, " + "IS_EVENT, " + "MIN_NUM_LOCATION_ASSOC, "
			+ "HAS_PARENTS, " + "MAX_NUM_LOCATION_ASSOC, " + "MIN_NUM_HDATE_ASSOC, " + "MAX_NUM_HDATE_ASSOC, "
			+ "MIN_NUM_KEY_ASSOC, " + "MAX_NUM_KEY_ASSOC, " + "DFLT_TAG_GROUP_KEY, " + "DFLT_THEME_KEY, "
			+ "SENTCE_SET_TYPE_KEY, " + "SENTCE_STYLE_TYPE_KEY, " + "GLOBAL_SENTCE_SET_KEY, " + "MEMO_SET_TYPE_KEY, "
			+ "GEDCOM_TAG, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.OCCASN_TAG_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "VIEW_DATA_SCRIPT_GROUP_KEY = ?, " + "VIEW_DATA_SCRIPT_PID = ?, "
			+ "MODIFY_DATA_SCRIPT_GROUP_KEY = ?, " + "MODIFY_DATA_SCRIPT_PID = ?, "
			+ "DELETE_DATA_SCRIPT_GROUP_KEY = ?, " + "DELETE_DATA_SCRIPT_PID = ?, " + "IS_EVENT = ?, "
			+ "MIN_NUM_LOCATION_ASSOC = ?, " + "HAS_PARENTS = ?, " + "MAX_NUM_LOCATION_ASSOC = ?, "
			+ "MIN_NUM_HDATE_ASSOC = ?, " + "MAX_NUM_HDATE_ASSOC = ?, " + "MIN_NUM_KEY_ASSOC = ?, "
			+ "MAX_NUM_KEY_ASSOC = ?, " + "DFLT_TAG_GROUP_KEY = ?, " + "DFLT_THEME_KEY = ?, "
			+ "SENTCE_SET_TYPE_KEY = ?, " + "SENTCE_STYLE_TYPE_KEY = ?, " + "GLOBAL_SENTCE_SET_KEY = ?, "
			+ "MEMO_SET_TYPE_KEY = ?, " + "GEDCOM_TAG = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, "
			+ "IS_DEFAULT = ?, " + "SHOW = ? WHERE OCCASN_TAG_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.OCCASN_TAG_DEFNS WHERE OCCASN_TAG_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASN_TAG_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int OccasnTagDefnPid;
	private boolean IsSystem;
	private short ViewDataScriptGroupKey;
	private int ViewDataScriptPid;
	private short ModifyDataScriptGroupKey;
	private int ModifyDataScriptPid;
	private short DeleteDataScriptGroupKey;
	private int DeleteDataScriptPid;
	private boolean IsEvent;
	private short MinNumLocationAssoc;
	private boolean HasParents;
	private short MaxNumLocationAssoc;
	private short MinNumHdateAssoc;
	private short MaxNumHdateAssoc;
	private short MinNumKeyAssoc;
	private short MaxNumKeyAssoc;
	private short DfltTagGroupKey;
	private short DfltThemeKey;
	private short SentceSetTypeKey;
	private short SentceStyleTypeKey;
	private short GlobalSentceSetKey;
	private short MemoSetTypeKey;
	private String GedcomTag;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private OccasnTagDefns model;

	public OccasnTagDefns() throws SQLException {
	}

	public OccasnTagDefns(int OccasnTagDefnPid) throws SQLException {
		super();
		this.OccasnTagDefnPid = OccasnTagDefnPid;
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
			model = new OccasnTagDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setOccasnTagDefnPid(rs.getInt("OCCASN_TAG_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
			model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
			model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
			model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
			model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
			model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
			model.setIsEvent(rs.getBoolean("IS_EVENT"));
			model.setMinNumLocationAssoc(rs.getShort("MIN_NUM_LOCATION_ASSOC"));
			model.setHasParents(rs.getBoolean("HAS_PARENTS"));
			model.setMaxNumLocationAssoc(rs.getShort("MAX_NUM_LOCATION_ASSOC"));
			model.setMinNumHdateAssoc(rs.getShort("MIN_NUM_HDATE_ASSOC"));
			model.setMaxNumHdateAssoc(rs.getShort("MAX_NUM_HDATE_ASSOC"));
			model.setMinNumKeyAssoc(rs.getShort("MIN_NUM_KEY_ASSOC"));
			model.setMaxNumKeyAssoc(rs.getShort("MAX_NUM_KEY_ASSOC"));
			model.setDfltTagGroupKey(rs.getShort("DFLT_TAG_GROUP_KEY"));
			model.setDfltThemeKey(rs.getShort("DFLT_THEME_KEY"));
			model.setSentceSetTypeKey(rs.getShort("SENTCE_SET_TYPE_KEY"));
			model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
			model.setGlobalSentceSetKey(rs.getShort("GLOBAL_SENTCE_SET_KEY"));
			model.setMemoSetTypeKey(rs.getShort("MEMO_SET_TYPE_KEY"));
			model.setGedcomTag(rs.getString("GEDCOM_TAG"));
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
		ps.setInt(1, key);
		rs = ps.executeQuery();
		if (rs.next()) {
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setOccasnTagDefnPid(rs.getInt("OCCASN_TAG_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
			model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
			model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
			model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
			model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
			model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
			model.setIsEvent(rs.getBoolean("IS_EVENT"));
			model.setMinNumLocationAssoc(rs.getShort("MIN_NUM_LOCATION_ASSOC"));
			model.setHasParents(rs.getBoolean("HAS_PARENTS"));
			model.setMaxNumLocationAssoc(rs.getShort("MAX_NUM_LOCATION_ASSOC"));
			model.setMinNumHdateAssoc(rs.getShort("MIN_NUM_HDATE_ASSOC"));
			model.setMaxNumHdateAssoc(rs.getShort("MAX_NUM_HDATE_ASSOC"));
			model.setMinNumKeyAssoc(rs.getShort("MIN_NUM_KEY_ASSOC"));
			model.setMaxNumKeyAssoc(rs.getShort("MAX_NUM_KEY_ASSOC"));
			model.setDfltTagGroupKey(rs.getShort("DFLT_TAG_GROUP_KEY"));
			model.setDfltThemeKey(rs.getShort("DFLT_THEME_KEY"));
			model.setSentceSetTypeKey(rs.getShort("SENTCE_SET_TYPE_KEY"));
			model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
			model.setGlobalSentceSetKey(rs.getShort("GLOBAL_SENTCE_SET_KEY"));
			model.setMemoSetTypeKey(rs.getShort("MEMO_SET_TYPE_KEY"));
			model.setGedcomTag(rs.getString("GEDCOM_TAG"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
			model.setShow(rs.getBoolean("SHOW"));
		}
		return this;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public short getDeleteDataScriptGroupKey() {
		return this.DeleteDataScriptGroupKey;
	}

	public int getDeleteDataScriptPid() {
		return this.DeleteDataScriptPid;
	}

	public short getDfltTagGroupKey() {
		return this.DfltTagGroupKey;
	}

	public short getDfltThemeKey() {
		return this.DfltThemeKey;
	}

	public short getDisplayOrder() {
		return this.DisplayOrder;
	}

	public String getGedcomTag() {
		return this.GedcomTag;
	}

	public short getGlobalSentceSetKey() {
		return this.GlobalSentceSetKey;
	}

	public boolean getHasParents() {
		return this.HasParents;
	}

	public boolean getIsDefault() {
		return this.IsDefault;
	}

	public boolean getIsEvent() {
		return this.IsEvent;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public short getMaxNumHdateAssoc() {
		return this.MaxNumHdateAssoc;
	}

	public short getMaxNumKeyAssoc() {
		return this.MaxNumKeyAssoc;
	}

	public short getMaxNumLocationAssoc() {
		return this.MaxNumLocationAssoc;
	}

	public short getMemoSetTypeKey() {
		return this.MemoSetTypeKey;
	}

	public short getMinNumHdateAssoc() {
		return this.MinNumHdateAssoc;
	}

	public short getMinNumKeyAssoc() {
		return this.MinNumKeyAssoc;
	}

	public short getMinNumLocationAssoc() {
		return this.MinNumLocationAssoc;
	}

	public short getModifyDataScriptGroupKey() {
		return this.ModifyDataScriptGroupKey;
	}

	public int getModifyDataScriptPid() {
		return this.ModifyDataScriptPid;
	}

	public int getOccasnTagDefnPid() {
		return this.OccasnTagDefnPid;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getReminderKey() {
		return this.ReminderKey;
	}

	public short getSentceSetTypeKey() {
		return this.SentceSetTypeKey;
	}

	public short getSentceStyleTypeKey() {
		return this.SentceStyleTypeKey;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public boolean getShow() {
		return this.Show;
	}

	public short getViewDataScriptGroupKey() {
		return this.ViewDataScriptGroupKey;
	}

	public int getViewDataScriptPid() {
		return this.ViewDataScriptPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((OccasnTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((OccasnTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((OccasnTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((OccasnTagDefns) model).setOccasnTagDefnPid(rs.getInt("OCCASN_TAG_DEFN_PID"));
		((OccasnTagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((OccasnTagDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
		((OccasnTagDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
		((OccasnTagDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
		((OccasnTagDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
		((OccasnTagDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
		((OccasnTagDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
		((OccasnTagDefns) model).setIsEvent(rs.getBoolean("IS_EVENT"));
		((OccasnTagDefns) model).setMinNumLocationAssoc(rs.getShort("MIN_NUM_LOCATION_ASSOC"));
		((OccasnTagDefns) model).setHasParents(rs.getBoolean("HAS_PARENTS"));
		((OccasnTagDefns) model).setMaxNumLocationAssoc(rs.getShort("MAX_NUM_LOCATION_ASSOC"));
		((OccasnTagDefns) model).setMinNumHdateAssoc(rs.getShort("MIN_NUM_HDATE_ASSOC"));
		((OccasnTagDefns) model).setMaxNumHdateAssoc(rs.getShort("MAX_NUM_HDATE_ASSOC"));
		((OccasnTagDefns) model).setMinNumKeyAssoc(rs.getShort("MIN_NUM_KEY_ASSOC"));
		((OccasnTagDefns) model).setMaxNumKeyAssoc(rs.getShort("MAX_NUM_KEY_ASSOC"));
		((OccasnTagDefns) model).setDfltTagGroupKey(rs.getShort("DFLT_TAG_GROUP_KEY"));
		((OccasnTagDefns) model).setDfltThemeKey(rs.getShort("DFLT_THEME_KEY"));
		((OccasnTagDefns) model).setSentceSetTypeKey(rs.getShort("SENTCE_SET_TYPE_KEY"));
		((OccasnTagDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
		((OccasnTagDefns) model).setGlobalSentceSetKey(rs.getShort("GLOBAL_SENTCE_SET_KEY"));
		((OccasnTagDefns) model).setMemoSetTypeKey(rs.getShort("MEMO_SET_TYPE_KEY"));
		((OccasnTagDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
		((OccasnTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((OccasnTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((OccasnTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((OccasnTagDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((OccasnTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((OccasnTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((OccasnTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((OccasnTagDefns) model).setOccasnTagDefnPid(rs.getInt("OCCASN_TAG_DEFN_PID"));
		((OccasnTagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((OccasnTagDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
		((OccasnTagDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
		((OccasnTagDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
		((OccasnTagDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
		((OccasnTagDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
		((OccasnTagDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
		((OccasnTagDefns) model).setIsEvent(rs.getBoolean("IS_EVENT"));
		((OccasnTagDefns) model).setMinNumLocationAssoc(rs.getShort("MIN_NUM_LOCATION_ASSOC"));
		((OccasnTagDefns) model).setHasParents(rs.getBoolean("HAS_PARENTS"));
		((OccasnTagDefns) model).setMaxNumLocationAssoc(rs.getShort("MAX_NUM_LOCATION_ASSOC"));
		((OccasnTagDefns) model).setMinNumHdateAssoc(rs.getShort("MIN_NUM_HDATE_ASSOC"));
		((OccasnTagDefns) model).setMaxNumHdateAssoc(rs.getShort("MAX_NUM_HDATE_ASSOC"));
		((OccasnTagDefns) model).setMinNumKeyAssoc(rs.getShort("MIN_NUM_KEY_ASSOC"));
		((OccasnTagDefns) model).setMaxNumKeyAssoc(rs.getShort("MAX_NUM_KEY_ASSOC"));
		((OccasnTagDefns) model).setDfltTagGroupKey(rs.getShort("DFLT_TAG_GROUP_KEY"));
		((OccasnTagDefns) model).setDfltThemeKey(rs.getShort("DFLT_THEME_KEY"));
		((OccasnTagDefns) model).setSentceSetTypeKey(rs.getShort("SENTCE_SET_TYPE_KEY"));
		((OccasnTagDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
		((OccasnTagDefns) model).setGlobalSentceSetKey(rs.getShort("GLOBAL_SENTCE_SET_KEY"));
		((OccasnTagDefns) model).setMemoSetTypeKey(rs.getShort("MEMO_SET_TYPE_KEY"));
		((OccasnTagDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
		((OccasnTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((OccasnTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((OccasnTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((OccasnTagDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDeleteDataScriptGroupKey(short DeleteDataScriptGroupKey) {
		this.DeleteDataScriptGroupKey = DeleteDataScriptGroupKey;
	}

	public void setDeleteDataScriptPid(int DeleteDataScriptPid) {
		this.DeleteDataScriptPid = DeleteDataScriptPid;
	}

	public void setDfltTagGroupKey(short DfltTagGroupKey) {
		this.DfltTagGroupKey = DfltTagGroupKey;
	}

	public void setDfltThemeKey(short DfltThemeKey) {
		this.DfltThemeKey = DfltThemeKey;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setGedcomTag(String GedcomTag) {
		this.GedcomTag = GedcomTag;
	}

	public void setGlobalSentceSetKey(short GlobalSentceSetKey) {
		this.GlobalSentceSetKey = GlobalSentceSetKey;
	}

	public void setHasParents(boolean HasParents) {
		this.HasParents = HasParents;
	}

	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
	}

	public void setIsEvent(boolean IsEvent) {
		this.IsEvent = IsEvent;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setMaxNumHdateAssoc(short MaxNumHdateAssoc) {
		this.MaxNumHdateAssoc = MaxNumHdateAssoc;
	}

	public void setMaxNumKeyAssoc(short MaxNumKeyAssoc) {
		this.MaxNumKeyAssoc = MaxNumKeyAssoc;
	}

	public void setMaxNumLocationAssoc(short MaxNumLocationAssoc) {
		this.MaxNumLocationAssoc = MaxNumLocationAssoc;
	}

	public void setMemoSetTypeKey(short MemoSetTypeKey) {
		this.MemoSetTypeKey = MemoSetTypeKey;
	}

	public void setMinNumHdateAssoc(short MinNumHdateAssoc) {
		this.MinNumHdateAssoc = MinNumHdateAssoc;
	}

	public void setMinNumKeyAssoc(short MinNumKeyAssoc) {
		this.MinNumKeyAssoc = MinNumKeyAssoc;
	}

	public void setMinNumLocationAssoc(short MinNumLocationAssoc) {
		this.MinNumLocationAssoc = MinNumLocationAssoc;
	}

	public void setModifyDataScriptGroupKey(short ModifyDataScriptGroupKey) {
		this.ModifyDataScriptGroupKey = ModifyDataScriptGroupKey;
	}

	public void setModifyDataScriptPid(int ModifyDataScriptPid) {
		this.ModifyDataScriptPid = ModifyDataScriptPid;
	}

	public void setOccasnTagDefnPid(int OccasnTagDefnPid) {
		this.OccasnTagDefnPid = OccasnTagDefnPid;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setReminderKey(short ReminderKey) {
		this.ReminderKey = ReminderKey;
	}

	public void setSentceSetTypeKey(short SentceSetTypeKey) {
		this.SentceSetTypeKey = SentceSetTypeKey;
	}

	public void setSentceStyleTypeKey(short SentceStyleTypeKey) {
		this.SentceStyleTypeKey = SentceStyleTypeKey;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setShow(boolean Show) {
		this.Show = Show;
	}

	public void setViewDataScriptGroupKey(short ViewDataScriptGroupKey) {
		this.ViewDataScriptGroupKey = ViewDataScriptGroupKey;
	}

	public void setViewDataScriptPid(int ViewDataScriptPid) {
		this.ViewDataScriptPid = ViewDataScriptPid;
	}

}
