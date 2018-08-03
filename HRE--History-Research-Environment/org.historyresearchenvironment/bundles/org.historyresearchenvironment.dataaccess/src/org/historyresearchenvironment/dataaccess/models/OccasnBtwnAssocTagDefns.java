package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the OCCASN_BTWN_ASSOC_TAG_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class OccasnBtwnAssocTagDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_BTWN_ASSOC_TAG_DEFN_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, "
			+ "VIEW_DATA_SCRIPT_PID, " + "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, "
			+ "DELETE_DATA_SCRIPT_GROUP_KEY, " + "DELETE_DATA_SCRIPT_PID, " + "OCCASN_SUB_TYPE_KEY, "
			+ "ASSOC_A_TYPE_KEY, " + "ASSOC_A_SUB_TYPE_KEY, " + "ASSOC_B_TYPE_KEY, " + "ASSOC_B_SUB_TYPE_KEY, "
			+ "ROLE_PAIR_KEY, " + "TAG_GROUP_KEY, " + "THEME_KEY, " + "SENTCE_STYLE_TYPE_KEY, "
			+ "A_SUBJ_SENTCE_SET_KEY, " + "B_SUBJ_SENTCE_SET_KEY, " + "GEDCOM_TAG, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.OCCASN_BTWN_ASSOC_TAG_DEFNS WHERE OCCASN_BTWN_ASSOC_TAG_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_BTWN_ASSOC_TAG_DEFN_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, "
			+ "VIEW_DATA_SCRIPT_PID, " + "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, "
			+ "DELETE_DATA_SCRIPT_GROUP_KEY, " + "DELETE_DATA_SCRIPT_PID, " + "OCCASN_SUB_TYPE_KEY, "
			+ "ASSOC_A_TYPE_KEY, " + "ASSOC_A_SUB_TYPE_KEY, " + "ASSOC_B_TYPE_KEY, " + "ASSOC_B_SUB_TYPE_KEY, "
			+ "ROLE_PAIR_KEY, " + "TAG_GROUP_KEY, " + "THEME_KEY, " + "SENTCE_STYLE_TYPE_KEY, "
			+ "A_SUBJ_SENTCE_SET_KEY, " + "B_SUBJ_SENTCE_SET_KEY, " + "GEDCOM_TAG, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.OCCASN_BTWN_ASSOC_TAG_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.OCCASN_BTWN_ASSOC_TAG_DEFNS( " + "RECORD_NUM, "
			+ "SET_KEY, " + "COMMIT_PID, " + "OCCASN_BTWN_ASSOC_TAG_DEFN_PID, " + "IS_SYSTEM, "
			+ "VIEW_DATA_SCRIPT_GROUP_KEY, " + "VIEW_DATA_SCRIPT_PID, " + "MODIFY_DATA_SCRIPT_GROUP_KEY, "
			+ "MODIFY_DATA_SCRIPT_PID, " + "DELETE_DATA_SCRIPT_GROUP_KEY, " + "DELETE_DATA_SCRIPT_PID, "
			+ "OCCASN_SUB_TYPE_KEY, " + "ASSOC_A_TYPE_KEY, " + "ASSOC_A_SUB_TYPE_KEY, " + "ASSOC_B_TYPE_KEY, "
			+ "ASSOC_B_SUB_TYPE_KEY, " + "ROLE_PAIR_KEY, " + "TAG_GROUP_KEY, " + "THEME_KEY, "
			+ "SENTCE_STYLE_TYPE_KEY, " + "A_SUBJ_SENTCE_SET_KEY, " + "B_SUBJ_SENTCE_SET_KEY, " + "GEDCOM_TAG, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.OCCASN_BTWN_ASSOC_TAG_DEFNSSET " + "RECORD_NUM = ?, "
			+ "SET_KEY = ?, " + "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "VIEW_DATA_SCRIPT_GROUP_KEY = ?, "
			+ "VIEW_DATA_SCRIPT_PID = ?, " + "MODIFY_DATA_SCRIPT_GROUP_KEY = ?, " + "MODIFY_DATA_SCRIPT_PID = ?, "
			+ "DELETE_DATA_SCRIPT_GROUP_KEY = ?, " + "DELETE_DATA_SCRIPT_PID = ?, " + "OCCASN_SUB_TYPE_KEY = ?, "
			+ "ASSOC_A_TYPE_KEY = ?, " + "ASSOC_A_SUB_TYPE_KEY = ?, " + "ASSOC_B_TYPE_KEY = ?, "
			+ "ASSOC_B_SUB_TYPE_KEY = ?, " + "ROLE_PAIR_KEY = ?, " + "TAG_GROUP_KEY = ?, " + "THEME_KEY = ?, "
			+ "SENTCE_STYLE_TYPE_KEY = ?, " + "A_SUBJ_SENTCE_SET_KEY = ?, " + "B_SUBJ_SENTCE_SET_KEY = ?, "
			+ "GEDCOM_TAG = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE OCCASN_BTWN_ASSOC_TAG_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.OCCASN_BTWN_ASSOC_TAG_DEFNS WHERE OCCASN_BTWN_ASSOC_TAG_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASN_BTWN_ASSOC_TAG_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int OccasnBtwnAssocTagDefnPid;
	private boolean IsSystem;
	private short ViewDataScriptGroupKey;
	private int ViewDataScriptPid;
	private short ModifyDataScriptGroupKey;
	private int ModifyDataScriptPid;
	private short DeleteDataScriptGroupKey;
	private int DeleteDataScriptPid;
	private short OccasnSubTypeKey;
	private short AssocATypeKey;
	private short AssocASubTypeKey;
	private short AssocBTypeKey;
	private short AssocBSubTypeKey;
	private short RolePairKey;
	private short TagGroupKey;
	private short ThemeKey;
	private short SentceStyleTypeKey;
	private int ASubjSentceSetKey;
	private int BSubjSentceSetKey;
	private String GedcomTag;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private OccasnBtwnAssocTagDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public OccasnBtwnAssocTagDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param OccasnBtwnAssocTagDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public OccasnBtwnAssocTagDefns(int OccasnBtwnAssocTagDefnPid) throws SQLException {
		super();
		this.OccasnBtwnAssocTagDefnPid = OccasnBtwnAssocTagDefnPid;
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
			model = new OccasnBtwnAssocTagDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setOccasnBtwnAssocTagDefnPid(rs.getInt("OCCASN_BTWN_ASSOC_TAG_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
			model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
			model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
			model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
			model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
			model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
			model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
			model.setAssocATypeKey(rs.getShort("ASSOC_A_TYPE_KEY"));
			model.setAssocASubTypeKey(rs.getShort("ASSOC_A_SUB_TYPE_KEY"));
			model.setAssocBTypeKey(rs.getShort("ASSOC_B_TYPE_KEY"));
			model.setAssocBSubTypeKey(rs.getShort("ASSOC_B_SUB_TYPE_KEY"));
			model.setRolePairKey(rs.getShort("ROLE_PAIR_KEY"));
			model.setTagGroupKey(rs.getShort("TAG_GROUP_KEY"));
			model.setThemeKey(rs.getShort("THEME_KEY"));
			model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
			model.setASubjSentceSetKey(rs.getInt("A_SUBJ_SENTCE_SET_KEY"));
			model.setBSubjSentceSetKey(rs.getInt("B_SUBJ_SENTCE_SET_KEY"));
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
			model.setOccasnBtwnAssocTagDefnPid(rs.getInt("OCCASN_BTWN_ASSOC_TAG_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
			model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
			model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
			model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
			model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
			model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
			model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
			model.setAssocATypeKey(rs.getShort("ASSOC_A_TYPE_KEY"));
			model.setAssocASubTypeKey(rs.getShort("ASSOC_A_SUB_TYPE_KEY"));
			model.setAssocBTypeKey(rs.getShort("ASSOC_B_TYPE_KEY"));
			model.setAssocBSubTypeKey(rs.getShort("ASSOC_B_SUB_TYPE_KEY"));
			model.setRolePairKey(rs.getShort("ROLE_PAIR_KEY"));
			model.setTagGroupKey(rs.getShort("TAG_GROUP_KEY"));
			model.setThemeKey(rs.getShort("THEME_KEY"));
			model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
			model.setASubjSentceSetKey(rs.getInt("A_SUBJ_SENTCE_SET_KEY"));
			model.setBSubjSentceSetKey(rs.getInt("B_SUBJ_SENTCE_SET_KEY"));
			model.setGedcomTag(rs.getString("GEDCOM_TAG"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
			model.setShow(rs.getBoolean("SHOW"));
		}
		return this;
	}

	/**
	 * Get the AssocASubTypeKey field.
	 *
	 * @return Contents of the ASSOC_A_SUB_TYPE_KEY column
	 */
	public short getAssocASubTypeKey() {
		return this.AssocASubTypeKey;
	}

	/**
	 * Get the AssocATypeKey field.
	 *
	 * @return Contents of the ASSOC_A_TYPE_KEY column
	 */
	public short getAssocATypeKey() {
		return this.AssocATypeKey;
	}

	/**
	 * Get the AssocBSubTypeKey field.
	 *
	 * @return Contents of the ASSOC_B_SUB_TYPE_KEY column
	 */
	public short getAssocBSubTypeKey() {
		return this.AssocBSubTypeKey;
	}

	/**
	 * Get the AssocBTypeKey field.
	 *
	 * @return Contents of the ASSOC_B_TYPE_KEY column
	 */
	public short getAssocBTypeKey() {
		return this.AssocBTypeKey;
	}

	/**
	 * Get the ASubjSentceSetKey field.
	 *
	 * @return Contents of the A_SUBJ_SENTCE_SET_KEY column
	 */
	public int getASubjSentceSetKey() {
		return this.ASubjSentceSetKey;
	}

	/**
	 * Get the BSubjSentceSetKey field.
	 *
	 * @return Contents of the B_SUBJ_SENTCE_SET_KEY column
	 */
	public int getBSubjSentceSetKey() {
		return this.BSubjSentceSetKey;
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
	 * Get the OccasnBtwnAssocTagDefnPid field.
	 *
	 * @return Contents of the OCCASN_BTWN_ASSOC_TAG_DEFN_PID column
	 */
	public int getOccasnBtwnAssocTagDefnPid() {
		return this.OccasnBtwnAssocTagDefnPid;
	}

	/**
	 * Get the OccasnSubTypeKey field.
	 *
	 * @return Contents of the OCCASN_SUB_TYPE_KEY column
	 */
	public short getOccasnSubTypeKey() {
		return this.OccasnSubTypeKey;
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
	 * Get the RolePairKey field.
	 *
	 * @return Contents of the ROLE_PAIR_KEY column
	 */
	public short getRolePairKey() {
		return this.RolePairKey;
	}

	/**
	 * Get the SentceStyleTypeKey field.
	 *
	 * @return Contents of the SENTCE_STYLE_TYPE_KEY column
	 */
	public short getSentceStyleTypeKey() {
		return this.SentceStyleTypeKey;
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
		((OccasnBtwnAssocTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((OccasnBtwnAssocTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((OccasnBtwnAssocTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((OccasnBtwnAssocTagDefns) model).setOccasnBtwnAssocTagDefnPid(rs.getInt("OCCASN_BTWN_ASSOC_TAG_DEFN_PID"));
		((OccasnBtwnAssocTagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((OccasnBtwnAssocTagDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
		((OccasnBtwnAssocTagDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
		((OccasnBtwnAssocTagDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
		((OccasnBtwnAssocTagDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
		((OccasnBtwnAssocTagDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
		((OccasnBtwnAssocTagDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
		((OccasnBtwnAssocTagDefns) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
		((OccasnBtwnAssocTagDefns) model).setAssocATypeKey(rs.getShort("ASSOC_A_TYPE_KEY"));
		((OccasnBtwnAssocTagDefns) model).setAssocASubTypeKey(rs.getShort("ASSOC_A_SUB_TYPE_KEY"));
		((OccasnBtwnAssocTagDefns) model).setAssocBTypeKey(rs.getShort("ASSOC_B_TYPE_KEY"));
		((OccasnBtwnAssocTagDefns) model).setAssocBSubTypeKey(rs.getShort("ASSOC_B_SUB_TYPE_KEY"));
		((OccasnBtwnAssocTagDefns) model).setRolePairKey(rs.getShort("ROLE_PAIR_KEY"));
		((OccasnBtwnAssocTagDefns) model).setTagGroupKey(rs.getShort("TAG_GROUP_KEY"));
		((OccasnBtwnAssocTagDefns) model).setThemeKey(rs.getShort("THEME_KEY"));
		((OccasnBtwnAssocTagDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
		((OccasnBtwnAssocTagDefns) model).setASubjSentceSetKey(rs.getInt("A_SUBJ_SENTCE_SET_KEY"));
		((OccasnBtwnAssocTagDefns) model).setBSubjSentceSetKey(rs.getInt("B_SUBJ_SENTCE_SET_KEY"));
		((OccasnBtwnAssocTagDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
		((OccasnBtwnAssocTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((OccasnBtwnAssocTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((OccasnBtwnAssocTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((OccasnBtwnAssocTagDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((OccasnBtwnAssocTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((OccasnBtwnAssocTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((OccasnBtwnAssocTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((OccasnBtwnAssocTagDefns) model).setOccasnBtwnAssocTagDefnPid(rs.getInt("OCCASN_BTWN_ASSOC_TAG_DEFN_PID"));
		((OccasnBtwnAssocTagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((OccasnBtwnAssocTagDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
		((OccasnBtwnAssocTagDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
		((OccasnBtwnAssocTagDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
		((OccasnBtwnAssocTagDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
		((OccasnBtwnAssocTagDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
		((OccasnBtwnAssocTagDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
		((OccasnBtwnAssocTagDefns) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
		((OccasnBtwnAssocTagDefns) model).setAssocATypeKey(rs.getShort("ASSOC_A_TYPE_KEY"));
		((OccasnBtwnAssocTagDefns) model).setAssocASubTypeKey(rs.getShort("ASSOC_A_SUB_TYPE_KEY"));
		((OccasnBtwnAssocTagDefns) model).setAssocBTypeKey(rs.getShort("ASSOC_B_TYPE_KEY"));
		((OccasnBtwnAssocTagDefns) model).setAssocBSubTypeKey(rs.getShort("ASSOC_B_SUB_TYPE_KEY"));
		((OccasnBtwnAssocTagDefns) model).setRolePairKey(rs.getShort("ROLE_PAIR_KEY"));
		((OccasnBtwnAssocTagDefns) model).setTagGroupKey(rs.getShort("TAG_GROUP_KEY"));
		((OccasnBtwnAssocTagDefns) model).setThemeKey(rs.getShort("THEME_KEY"));
		((OccasnBtwnAssocTagDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
		((OccasnBtwnAssocTagDefns) model).setASubjSentceSetKey(rs.getInt("A_SUBJ_SENTCE_SET_KEY"));
		((OccasnBtwnAssocTagDefns) model).setBSubjSentceSetKey(rs.getInt("B_SUBJ_SENTCE_SET_KEY"));
		((OccasnBtwnAssocTagDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
		((OccasnBtwnAssocTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((OccasnBtwnAssocTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((OccasnBtwnAssocTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((OccasnBtwnAssocTagDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	/**
	 * Set the AssocASubTypeKey field
	 *
	 * @param AssocASubTypeKey
	 *            Contents of the ASSOC_A_SUB_TYPE_KEY column
	 */
	public void setAssocASubTypeKey(short AssocASubTypeKey) {
		this.AssocASubTypeKey = AssocASubTypeKey;
	}

	/**
	 * Set the AssocATypeKey field
	 *
	 * @param AssocATypeKey
	 *            Contents of the ASSOC_A_TYPE_KEY column
	 */
	public void setAssocATypeKey(short AssocATypeKey) {
		this.AssocATypeKey = AssocATypeKey;
	}

	/**
	 * Set the AssocBSubTypeKey field
	 *
	 * @param AssocBSubTypeKey
	 *            Contents of the ASSOC_B_SUB_TYPE_KEY column
	 */
	public void setAssocBSubTypeKey(short AssocBSubTypeKey) {
		this.AssocBSubTypeKey = AssocBSubTypeKey;
	}

	/**
	 * Set the AssocBTypeKey field
	 *
	 * @param AssocBTypeKey
	 *            Contents of the ASSOC_B_TYPE_KEY column
	 */
	public void setAssocBTypeKey(short AssocBTypeKey) {
		this.AssocBTypeKey = AssocBTypeKey;
	}

	/**
	 * Set the ASubjSentceSetKey field
	 *
	 * @param ASubjSentceSetKey
	 *            Contents of the A_SUBJ_SENTCE_SET_KEY column
	 */
	public void setASubjSentceSetKey(int ASubjSentceSetKey) {
		this.ASubjSentceSetKey = ASubjSentceSetKey;
	}

	/**
	 * Set the BSubjSentceSetKey field
	 *
	 * @param BSubjSentceSetKey
	 *            Contents of the B_SUBJ_SENTCE_SET_KEY column
	 */
	public void setBSubjSentceSetKey(int BSubjSentceSetKey) {
		this.BSubjSentceSetKey = BSubjSentceSetKey;
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
	 * Set the OccasnBtwnAssocTagDefnPid field
	 *
	 * @param OccasnBtwnAssocTagDefnPid
	 *            Contents of the OCCASN_BTWN_ASSOC_TAG_DEFN_PID column
	 */
	public void setOccasnBtwnAssocTagDefnPid(int OccasnBtwnAssocTagDefnPid) {
		this.OccasnBtwnAssocTagDefnPid = OccasnBtwnAssocTagDefnPid;
	}

	/**
	 * Set the OccasnSubTypeKey field
	 *
	 * @param OccasnSubTypeKey
	 *            Contents of the OCCASN_SUB_TYPE_KEY column
	 */
	public void setOccasnSubTypeKey(short OccasnSubTypeKey) {
		this.OccasnSubTypeKey = OccasnSubTypeKey;
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
	 * Set the RolePairKey field
	 *
	 * @param RolePairKey
	 *            Contents of the ROLE_PAIR_KEY column
	 */
	public void setRolePairKey(short RolePairKey) {
		this.RolePairKey = RolePairKey;
	}

	/**
	 * Set the SentceStyleTypeKey field
	 *
	 * @param SentceStyleTypeKey
	 *            Contents of the SENTCE_STYLE_TYPE_KEY column
	 */
	public void setSentceStyleTypeKey(short SentceStyleTypeKey) {
		this.SentceStyleTypeKey = SentceStyleTypeKey;
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
