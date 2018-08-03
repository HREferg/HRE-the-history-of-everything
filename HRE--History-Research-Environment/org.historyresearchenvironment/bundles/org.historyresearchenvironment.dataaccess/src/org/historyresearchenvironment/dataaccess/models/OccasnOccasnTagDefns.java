package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the OCCASN_OCCASN_TAG_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class OccasnOccasnTagDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_OCCASN_TAG_DEFN_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, " + "VIEW_DATA_SCRIPT_PID, "
			+ "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, " + "DELETE_DATA_SCRIPT_GROUP_KEY, "
			+ "DELETE_DATA_SCRIPT_PID, " + "A_OCCASN_SUB_TYPE_KEY, " + "B_OCCASN_SUB_TYPE_KEY, "
			+ "A_B_ROLE_NAME_PAIR_KEY, " + "A_SENTCE_SET_PID, " + "B_SENTCE_SET_PID, " + "TAG_GROUP_KEY, "
			+ "THEME_KEY, " + "GEDCOM_TAG, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.OCCASN_OCCASN_TAG_DEFNS WHERE OCCASN_OCCASN_TAG_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_OCCASN_TAG_DEFN_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, " + "VIEW_DATA_SCRIPT_PID, "
			+ "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, " + "DELETE_DATA_SCRIPT_GROUP_KEY, "
			+ "DELETE_DATA_SCRIPT_PID, " + "A_OCCASN_SUB_TYPE_KEY, " + "B_OCCASN_SUB_TYPE_KEY, "
			+ "A_B_ROLE_NAME_PAIR_KEY, " + "A_SENTCE_SET_PID, " + "B_SENTCE_SET_PID, " + "TAG_GROUP_KEY, "
			+ "THEME_KEY, " + "GEDCOM_TAG, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.OCCASN_OCCASN_TAG_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.OCCASN_OCCASN_TAG_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "OCCASN_OCCASN_TAG_DEFN_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, "
			+ "VIEW_DATA_SCRIPT_PID, " + "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, "
			+ "DELETE_DATA_SCRIPT_GROUP_KEY, " + "DELETE_DATA_SCRIPT_PID, " + "A_OCCASN_SUB_TYPE_KEY, "
			+ "B_OCCASN_SUB_TYPE_KEY, " + "A_B_ROLE_NAME_PAIR_KEY, " + "A_SENTCE_SET_PID, " + "B_SENTCE_SET_PID, "
			+ "TAG_GROUP_KEY, " + "THEME_KEY, " + "GEDCOM_TAG, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.OCCASN_OCCASN_TAG_DEFNSSET " + "RECORD_NUM = ?, "
			+ "SET_KEY = ?, " + "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "VIEW_DATA_SCRIPT_GROUP_KEY = ?, "
			+ "VIEW_DATA_SCRIPT_PID = ?, " + "MODIFY_DATA_SCRIPT_GROUP_KEY = ?, " + "MODIFY_DATA_SCRIPT_PID = ?, "
			+ "DELETE_DATA_SCRIPT_GROUP_KEY = ?, " + "DELETE_DATA_SCRIPT_PID = ?, " + "A_OCCASN_SUB_TYPE_KEY = ?, "
			+ "B_OCCASN_SUB_TYPE_KEY = ?, " + "A_B_ROLE_NAME_PAIR_KEY = ?, " + "A_SENTCE_SET_PID = ?, "
			+ "B_SENTCE_SET_PID = ?, " + "TAG_GROUP_KEY = ?, " + "THEME_KEY = ?, " + "GEDCOM_TAG = ?, "
			+ "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE OCCASN_OCCASN_TAG_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.OCCASN_OCCASN_TAG_DEFNS WHERE OCCASN_OCCASN_TAG_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASN_OCCASN_TAG_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int OccasnOccasnTagDefnPid;
	private boolean IsSystem;
	private short ViewDataScriptGroupKey;
	private int ViewDataScriptPid;
	private short ModifyDataScriptGroupKey;
	private int ModifyDataScriptPid;
	private short DeleteDataScriptGroupKey;
	private int DeleteDataScriptPid;
	private short AOccasnSubTypeKey;
	private short BOccasnSubTypeKey;
	private short ABRoleNamePairKey;
	private int ASentceSetPid;
	private int BSentceSetPid;
	private short TagGroupKey;
	private short ThemeKey;
	private String GedcomTag;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private OccasnOccasnTagDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public OccasnOccasnTagDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param OccasnOccasnTagDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public OccasnOccasnTagDefns(int OccasnOccasnTagDefnPid) throws SQLException {
		super();
		this.OccasnOccasnTagDefnPid = OccasnOccasnTagDefnPid;
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
			model = new OccasnOccasnTagDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setOccasnOccasnTagDefnPid(rs.getInt("OCCASN_OCCASN_TAG_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
			model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
			model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
			model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
			model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
			model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
			model.setAOccasnSubTypeKey(rs.getShort("A_OCCASN_SUB_TYPE_KEY"));
			model.setBOccasnSubTypeKey(rs.getShort("B_OCCASN_SUB_TYPE_KEY"));
			model.setABRoleNamePairKey(rs.getShort("A_B_ROLE_NAME_PAIR_KEY"));
			model.setASentceSetPid(rs.getInt("A_SENTCE_SET_PID"));
			model.setBSentceSetPid(rs.getInt("B_SENTCE_SET_PID"));
			model.setTagGroupKey(rs.getShort("TAG_GROUP_KEY"));
			model.setThemeKey(rs.getShort("THEME_KEY"));
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
			model.setOccasnOccasnTagDefnPid(rs.getInt("OCCASN_OCCASN_TAG_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
			model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
			model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
			model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
			model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
			model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
			model.setAOccasnSubTypeKey(rs.getShort("A_OCCASN_SUB_TYPE_KEY"));
			model.setBOccasnSubTypeKey(rs.getShort("B_OCCASN_SUB_TYPE_KEY"));
			model.setABRoleNamePairKey(rs.getShort("A_B_ROLE_NAME_PAIR_KEY"));
			model.setASentceSetPid(rs.getInt("A_SENTCE_SET_PID"));
			model.setBSentceSetPid(rs.getInt("B_SENTCE_SET_PID"));
			model.setTagGroupKey(rs.getShort("TAG_GROUP_KEY"));
			model.setThemeKey(rs.getShort("THEME_KEY"));
			model.setGedcomTag(rs.getString("GEDCOM_TAG"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
			model.setShow(rs.getBoolean("SHOW"));
		}
		return this;
	}

	/**
	 * Get the ABRoleNamePairKey field.
	 *
	 * @return Contents of the A_B_ROLE_NAME_PAIR_KEY column
	 */
	public short getABRoleNamePairKey() {
		return this.ABRoleNamePairKey;
	}

	/**
	 * Get the AOccasnSubTypeKey field.
	 *
	 * @return Contents of the A_OCCASN_SUB_TYPE_KEY column
	 */
	public short getAOccasnSubTypeKey() {
		return this.AOccasnSubTypeKey;
	}

	/**
	 * Get the ASentceSetPid field.
	 *
	 * @return Contents of the A_SENTCE_SET_PID column
	 */
	public int getASentceSetPid() {
		return this.ASentceSetPid;
	}

	/**
	 * Get the BOccasnSubTypeKey field.
	 *
	 * @return Contents of the B_OCCASN_SUB_TYPE_KEY column
	 */
	public short getBOccasnSubTypeKey() {
		return this.BOccasnSubTypeKey;
	}

	/**
	 * Get the BSentceSetPid field.
	 *
	 * @return Contents of the B_SENTCE_SET_PID column
	 */
	public int getBSentceSetPid() {
		return this.BSentceSetPid;
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
	 * Get the DeleteDataScriptGroupKey field.
	 *
	 * @return Contents of the DELETE_DATA_SCRIPT_GROUP_KEY column
	 */
	public short getDeleteDataScriptGroupKey() {
		return this.DeleteDataScriptGroupKey;
	}

	/**
	 * Get the DeleteDataScriptPid field.
	 *
	 * @return Contents of the DELETE_DATA_SCRIPT_PID column
	 */
	public int getDeleteDataScriptPid() {
		return this.DeleteDataScriptPid;
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
	 * Get the GedcomTag field.
	 *
	 * @return Contents of the GEDCOM_TAG column
	 */
	public String getGedcomTag() {
		return this.GedcomTag;
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
	 * Get the IsSystem field.
	 *
	 * @return Contents of the IS_SYSTEM column
	 */
	public boolean getIsSystem() {
		return this.IsSystem;
	}

	/**
	 * Get the ModifyDataScriptGroupKey field.
	 *
	 * @return Contents of the MODIFY_DATA_SCRIPT_GROUP_KEY column
	 */
	public short getModifyDataScriptGroupKey() {
		return this.ModifyDataScriptGroupKey;
	}

	/**
	 * Get the ModifyDataScriptPid field.
	 *
	 * @return Contents of the MODIFY_DATA_SCRIPT_PID column
	 */
	public int getModifyDataScriptPid() {
		return this.ModifyDataScriptPid;
	}

	/**
	 * Get the OccasnOccasnTagDefnPid field.
	 *
	 * @return Contents of the OCCASN_OCCASN_TAG_DEFN_PID column
	 */
	public int getOccasnOccasnTagDefnPid() {
		return this.OccasnOccasnTagDefnPid;
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
	 * Get the ReminderKey field.
	 *
	 * @return Contents of the REMINDER_KEY column
	 */
	public short getReminderKey() {
		return this.ReminderKey;
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
	 * Get the Show field.
	 *
	 * @return Contents of the SHOW column
	 */
	public boolean getShow() {
		return this.Show;
	}

	/**
	 * Get the TagGroupKey field.
	 *
	 * @return Contents of the TAG_GROUP_KEY column
	 */
	public short getTagGroupKey() {
		return this.TagGroupKey;
	}

	/**
	 * Get the ThemeKey field.
	 *
	 * @return Contents of the THEME_KEY column
	 */
	public short getThemeKey() {
		return this.ThemeKey;
	}

	/**
	 * Get the ViewDataScriptGroupKey field.
	 *
	 * @return Contents of the VIEW_DATA_SCRIPT_GROUP_KEY column
	 */
	public short getViewDataScriptGroupKey() {
		return this.ViewDataScriptGroupKey;
	}

	/**
	 * Get the ViewDataScriptPid field.
	 *
	 * @return Contents of the VIEW_DATA_SCRIPT_PID column
	 */
	public int getViewDataScriptPid() {
		return this.ViewDataScriptPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((OccasnOccasnTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((OccasnOccasnTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((OccasnOccasnTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((OccasnOccasnTagDefns) model).setOccasnOccasnTagDefnPid(rs.getInt("OCCASN_OCCASN_TAG_DEFN_PID"));
		((OccasnOccasnTagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((OccasnOccasnTagDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
		((OccasnOccasnTagDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
		((OccasnOccasnTagDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
		((OccasnOccasnTagDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
		((OccasnOccasnTagDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
		((OccasnOccasnTagDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
		((OccasnOccasnTagDefns) model).setAOccasnSubTypeKey(rs.getShort("A_OCCASN_SUB_TYPE_KEY"));
		((OccasnOccasnTagDefns) model).setBOccasnSubTypeKey(rs.getShort("B_OCCASN_SUB_TYPE_KEY"));
		((OccasnOccasnTagDefns) model).setABRoleNamePairKey(rs.getShort("A_B_ROLE_NAME_PAIR_KEY"));
		((OccasnOccasnTagDefns) model).setASentceSetPid(rs.getInt("A_SENTCE_SET_PID"));
		((OccasnOccasnTagDefns) model).setBSentceSetPid(rs.getInt("B_SENTCE_SET_PID"));
		((OccasnOccasnTagDefns) model).setTagGroupKey(rs.getShort("TAG_GROUP_KEY"));
		((OccasnOccasnTagDefns) model).setThemeKey(rs.getShort("THEME_KEY"));
		((OccasnOccasnTagDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
		((OccasnOccasnTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((OccasnOccasnTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((OccasnOccasnTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((OccasnOccasnTagDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((OccasnOccasnTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((OccasnOccasnTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((OccasnOccasnTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((OccasnOccasnTagDefns) model).setOccasnOccasnTagDefnPid(rs.getInt("OCCASN_OCCASN_TAG_DEFN_PID"));
		((OccasnOccasnTagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((OccasnOccasnTagDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
		((OccasnOccasnTagDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
		((OccasnOccasnTagDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
		((OccasnOccasnTagDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
		((OccasnOccasnTagDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
		((OccasnOccasnTagDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
		((OccasnOccasnTagDefns) model).setAOccasnSubTypeKey(rs.getShort("A_OCCASN_SUB_TYPE_KEY"));
		((OccasnOccasnTagDefns) model).setBOccasnSubTypeKey(rs.getShort("B_OCCASN_SUB_TYPE_KEY"));
		((OccasnOccasnTagDefns) model).setABRoleNamePairKey(rs.getShort("A_B_ROLE_NAME_PAIR_KEY"));
		((OccasnOccasnTagDefns) model).setASentceSetPid(rs.getInt("A_SENTCE_SET_PID"));
		((OccasnOccasnTagDefns) model).setBSentceSetPid(rs.getInt("B_SENTCE_SET_PID"));
		((OccasnOccasnTagDefns) model).setTagGroupKey(rs.getShort("TAG_GROUP_KEY"));
		((OccasnOccasnTagDefns) model).setThemeKey(rs.getShort("THEME_KEY"));
		((OccasnOccasnTagDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
		((OccasnOccasnTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((OccasnOccasnTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((OccasnOccasnTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((OccasnOccasnTagDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	/**
	 * Set the ABRoleNamePairKey field
	 *
	 * @param ABRoleNamePairKey
	 *            Contents of the A_B_ROLE_NAME_PAIR_KEY column
	 */
	public void setABRoleNamePairKey(short ABRoleNamePairKey) {
		this.ABRoleNamePairKey = ABRoleNamePairKey;
	}

	/**
	 * Set the AOccasnSubTypeKey field
	 *
	 * @param AOccasnSubTypeKey
	 *            Contents of the A_OCCASN_SUB_TYPE_KEY column
	 */
	public void setAOccasnSubTypeKey(short AOccasnSubTypeKey) {
		this.AOccasnSubTypeKey = AOccasnSubTypeKey;
	}

	/**
	 * Set the ASentceSetPid field
	 *
	 * @param ASentceSetPid
	 *            Contents of the A_SENTCE_SET_PID column
	 */
	public void setASentceSetPid(int ASentceSetPid) {
		this.ASentceSetPid = ASentceSetPid;
	}

	/**
	 * Set the BOccasnSubTypeKey field
	 *
	 * @param BOccasnSubTypeKey
	 *            Contents of the B_OCCASN_SUB_TYPE_KEY column
	 */
	public void setBOccasnSubTypeKey(short BOccasnSubTypeKey) {
		this.BOccasnSubTypeKey = BOccasnSubTypeKey;
	}

	/**
	 * Set the BSentceSetPid field
	 *
	 * @param BSentceSetPid
	 *            Contents of the B_SENTCE_SET_PID column
	 */
	public void setBSentceSetPid(int BSentceSetPid) {
		this.BSentceSetPid = BSentceSetPid;
	}

	/**
	 * Set the CommitPid field
	 *
	 * @param CommitPid
	 *            Contents of the COMMIT_PID column
	 */
	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	/**
	 * Set the DeleteDataScriptGroupKey field
	 *
	 * @param DeleteDataScriptGroupKey
	 *            Contents of the DELETE_DATA_SCRIPT_GROUP_KEY column
	 */
	public void setDeleteDataScriptGroupKey(short DeleteDataScriptGroupKey) {
		this.DeleteDataScriptGroupKey = DeleteDataScriptGroupKey;
	}

	/**
	 * Set the DeleteDataScriptPid field
	 *
	 * @param DeleteDataScriptPid
	 *            Contents of the DELETE_DATA_SCRIPT_PID column
	 */
	public void setDeleteDataScriptPid(int DeleteDataScriptPid) {
		this.DeleteDataScriptPid = DeleteDataScriptPid;
	}

	/**
	 * Set the DisplayOrder field
	 *
	 * @param DisplayOrder
	 *            Contents of the DISPLAY_ORDER column
	 */
	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	/**
	 * Set the GedcomTag field
	 *
	 * @param GedcomTag
	 *            Contents of the GEDCOM_TAG column
	 */
	public void setGedcomTag(String GedcomTag) {
		this.GedcomTag = GedcomTag;
	}

	/**
	 * Set the IsDefault field
	 *
	 * @param IsDefault
	 *            Contents of the IS_DEFAULT column
	 */
	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
	}

	/**
	 * Set the IsSystem field
	 *
	 * @param IsSystem
	 *            Contents of the IS_SYSTEM column
	 */
	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	/**
	 * Set the ModifyDataScriptGroupKey field
	 *
	 * @param ModifyDataScriptGroupKey
	 *            Contents of the MODIFY_DATA_SCRIPT_GROUP_KEY column
	 */
	public void setModifyDataScriptGroupKey(short ModifyDataScriptGroupKey) {
		this.ModifyDataScriptGroupKey = ModifyDataScriptGroupKey;
	}

	/**
	 * Set the ModifyDataScriptPid field
	 *
	 * @param ModifyDataScriptPid
	 *            Contents of the MODIFY_DATA_SCRIPT_PID column
	 */
	public void setModifyDataScriptPid(int ModifyDataScriptPid) {
		this.ModifyDataScriptPid = ModifyDataScriptPid;
	}

	/**
	 * Set the OccasnOccasnTagDefnPid field
	 *
	 * @param OccasnOccasnTagDefnPid
	 *            Contents of the OCCASN_OCCASN_TAG_DEFN_PID column
	 */
	public void setOccasnOccasnTagDefnPid(int OccasnOccasnTagDefnPid) {
		this.OccasnOccasnTagDefnPid = OccasnOccasnTagDefnPid;
	}

	/**
	 * Set the RecordNum field
	 *
	 * @param RecordNum
	 *            Contents of the RECORD_NUM column
	 */
	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	/**
	 * Set the ReminderKey field
	 *
	 * @param ReminderKey
	 *            Contents of the REMINDER_KEY column
	 */
	public void setReminderKey(short ReminderKey) {
		this.ReminderKey = ReminderKey;
	}

	/**
	 * Set the SetKey field
	 *
	 * @param SetKey
	 *            Contents of the SET_KEY column
	 */
	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	/**
	 * Set the Show field
	 *
	 * @param Show
	 *            Contents of the SHOW column
	 */
	public void setShow(boolean Show) {
		this.Show = Show;
	}

	/**
	 * Set the TagGroupKey field
	 *
	 * @param TagGroupKey
	 *            Contents of the TAG_GROUP_KEY column
	 */
	public void setTagGroupKey(short TagGroupKey) {
		this.TagGroupKey = TagGroupKey;
	}

	/**
	 * Set the ThemeKey field
	 *
	 * @param ThemeKey
	 *            Contents of the THEME_KEY column
	 */
	public void setThemeKey(short ThemeKey) {
		this.ThemeKey = ThemeKey;
	}

	/**
	 * Set the ViewDataScriptGroupKey field
	 *
	 * @param ViewDataScriptGroupKey
	 *            Contents of the VIEW_DATA_SCRIPT_GROUP_KEY column
	 */
	public void setViewDataScriptGroupKey(short ViewDataScriptGroupKey) {
		this.ViewDataScriptGroupKey = ViewDataScriptGroupKey;
	}

	/**
	 * Set the ViewDataScriptPid field
	 *
	 * @param ViewDataScriptPid
	 *            Contents of the VIEW_DATA_SCRIPT_PID column
	 */
	public void setViewDataScriptPid(int ViewDataScriptPid) {
		this.ViewDataScriptPid = ViewDataScriptPid;
	}

}
