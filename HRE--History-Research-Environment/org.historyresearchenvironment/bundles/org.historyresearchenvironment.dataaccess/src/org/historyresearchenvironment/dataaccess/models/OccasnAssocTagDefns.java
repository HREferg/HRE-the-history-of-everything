package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the OCCASN_ASSOC_TAG_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class OccasnAssocTagDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_ASSOC_TAG_DEFN_PID, " + "IS_USER_DEFN, " + "OCCASN_SUB_TYPE_KEY, " + "OCCASN_TAG_TYPE_KEY, "
			+ "ASSOC_TYPE_KEY, " + "ASSOC_SUB_TYPE_KEY, " + "ROLE_NAME_KEY, " + "MIN_IN_ROLE, " + "MAX_IN_ROLE, "
			+ "IS_REQUIRED_ROLE, " + "GROUP_KEY, " + "THEME_KEY, " + "SENTCE_SET_PID, " + "SENTCE_STYLE_TYPE_KEY, "
			+ "TAG_RULE_KEY, " + "GEDCOM_TAG, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.OCCASN_ASSOC_TAG_DEFNS WHERE OCCASN_ASSOC_TAG_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_ASSOC_TAG_DEFN_PID, " + "IS_USER_DEFN, " + "OCCASN_SUB_TYPE_KEY, " + "OCCASN_TAG_TYPE_KEY, "
			+ "ASSOC_TYPE_KEY, " + "ASSOC_SUB_TYPE_KEY, " + "ROLE_NAME_KEY, " + "MIN_IN_ROLE, " + "MAX_IN_ROLE, "
			+ "IS_REQUIRED_ROLE, " + "GROUP_KEY, " + "THEME_KEY, " + "SENTCE_SET_PID, " + "SENTCE_STYLE_TYPE_KEY, "
			+ "TAG_RULE_KEY, " + "GEDCOM_TAG, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.OCCASN_ASSOC_TAG_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.OCCASN_ASSOC_TAG_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "OCCASN_ASSOC_TAG_DEFN_PID, " + "IS_USER_DEFN, " + "OCCASN_SUB_TYPE_KEY, "
			+ "OCCASN_TAG_TYPE_KEY, " + "ASSOC_TYPE_KEY, " + "ASSOC_SUB_TYPE_KEY, " + "ROLE_NAME_KEY, "
			+ "MIN_IN_ROLE, " + "MAX_IN_ROLE, " + "IS_REQUIRED_ROLE, " + "GROUP_KEY, " + "THEME_KEY, "
			+ "SENTCE_SET_PID, " + "SENTCE_STYLE_TYPE_KEY, " + "TAG_RULE_KEY, " + "GEDCOM_TAG, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.OCCASN_ASSOC_TAG_DEFNSSET " + "RECORD_NUM = ?, "
			+ "SET_KEY = ?, " + "COMMIT_PID = ?, " + "IS_USER_DEFN = ?, " + "OCCASN_SUB_TYPE_KEY = ?, "
			+ "OCCASN_TAG_TYPE_KEY = ?, " + "ASSOC_TYPE_KEY = ?, " + "ASSOC_SUB_TYPE_KEY = ?, " + "ROLE_NAME_KEY = ?, "
			+ "MIN_IN_ROLE = ?, " + "MAX_IN_ROLE = ?, " + "IS_REQUIRED_ROLE = ?, " + "GROUP_KEY = ?, "
			+ "THEME_KEY = ?, " + "SENTCE_SET_PID = ?, " + "SENTCE_STYLE_TYPE_KEY = ?, " + "TAG_RULE_KEY = ?, "
			+ "GEDCOM_TAG = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE OCCASN_ASSOC_TAG_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.OCCASN_ASSOC_TAG_DEFNS WHERE OCCASN_ASSOC_TAG_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASN_ASSOC_TAG_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int OccasnAssocTagDefnPid;
	private boolean IsUserDefn;
	private short OccasnSubTypeKey;
	private short OccasnTagTypeKey;
	private short AssocTypeKey;
	private short AssocSubTypeKey;
	private short RoleNameKey;
	private short MinInRole;
	private short MaxInRole;
	private boolean IsRequiredRole;
	private short GroupKey;
	private short ThemeKey;
	private int SentceSetPid;
	private short SentceStyleTypeKey;
	private short TagRuleKey;
	private String GedcomTag;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private OccasnAssocTagDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public OccasnAssocTagDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param OccasnAssocTagDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public OccasnAssocTagDefns(int OccasnAssocTagDefnPid) throws SQLException {
		super();
		this.OccasnAssocTagDefnPid = OccasnAssocTagDefnPid;
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
			model = new OccasnAssocTagDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setOccasnAssocTagDefnPid(rs.getInt("OCCASN_ASSOC_TAG_DEFN_PID"));
			model.setIsUserDefn(rs.getBoolean("IS_USER_DEFN"));
			model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
			model.setOccasnTagTypeKey(rs.getShort("OCCASN_TAG_TYPE_KEY"));
			model.setAssocTypeKey(rs.getShort("ASSOC_TYPE_KEY"));
			model.setAssocSubTypeKey(rs.getShort("ASSOC_SUB_TYPE_KEY"));
			model.setRoleNameKey(rs.getShort("ROLE_NAME_KEY"));
			model.setMinInRole(rs.getShort("MIN_IN_ROLE"));
			model.setMaxInRole(rs.getShort("MAX_IN_ROLE"));
			model.setIsRequiredRole(rs.getBoolean("IS_REQUIRED_ROLE"));
			model.setGroupKey(rs.getShort("GROUP_KEY"));
			model.setThemeKey(rs.getShort("THEME_KEY"));
			model.setSentceSetPid(rs.getInt("SENTCE_SET_PID"));
			model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
			model.setTagRuleKey(rs.getShort("TAG_RULE_KEY"));
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
			model.setOccasnAssocTagDefnPid(rs.getInt("OCCASN_ASSOC_TAG_DEFN_PID"));
			model.setIsUserDefn(rs.getBoolean("IS_USER_DEFN"));
			model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
			model.setOccasnTagTypeKey(rs.getShort("OCCASN_TAG_TYPE_KEY"));
			model.setAssocTypeKey(rs.getShort("ASSOC_TYPE_KEY"));
			model.setAssocSubTypeKey(rs.getShort("ASSOC_SUB_TYPE_KEY"));
			model.setRoleNameKey(rs.getShort("ROLE_NAME_KEY"));
			model.setMinInRole(rs.getShort("MIN_IN_ROLE"));
			model.setMaxInRole(rs.getShort("MAX_IN_ROLE"));
			model.setIsRequiredRole(rs.getBoolean("IS_REQUIRED_ROLE"));
			model.setGroupKey(rs.getShort("GROUP_KEY"));
			model.setThemeKey(rs.getShort("THEME_KEY"));
			model.setSentceSetPid(rs.getInt("SENTCE_SET_PID"));
			model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
			model.setTagRuleKey(rs.getShort("TAG_RULE_KEY"));
			model.setGedcomTag(rs.getString("GEDCOM_TAG"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
			model.setShow(rs.getBoolean("SHOW"));
		}
		return this;
	}

	/**
	 * Get the AssocSubTypeKey field.
	 *
	 * @return Contents of the ASSOC_SUB_TYPE_KEY column
	 */
	public short getAssocSubTypeKey() {
		return this.AssocSubTypeKey;
	}

	/**
	 * Get the AssocTypeKey field.
	 *
	 * @return Contents of the ASSOC_TYPE_KEY column
	 */
	public short getAssocTypeKey() {
		return this.AssocTypeKey;
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
	 * Get the GroupKey field.
	 *
	 * @return Contents of the GROUP_KEY column
	 */
	public short getGroupKey() {
		return this.GroupKey;
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
	 * Get the IsRequiredRole field.
	 *
	 * @return Contents of the IS_REQUIRED_ROLE column
	 */
	public boolean getIsRequiredRole() {
		return this.IsRequiredRole;
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
	 * Get the MaxInRole field.
	 *
	 * @return Contents of the MAX_IN_ROLE column
	 */
	public short getMaxInRole() {
		return this.MaxInRole;
	}

	/**
	 * Get the MinInRole field.
	 *
	 * @return Contents of the MIN_IN_ROLE column
	 */
	public short getMinInRole() {
		return this.MinInRole;
	}

	/**
	 * Get the OccasnAssocTagDefnPid field.
	 *
	 * @return Contents of the OCCASN_ASSOC_TAG_DEFN_PID column
	 */
	public int getOccasnAssocTagDefnPid() {
		return this.OccasnAssocTagDefnPid;
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
	 * Get the OccasnTagTypeKey field.
	 *
	 * @return Contents of the OCCASN_TAG_TYPE_KEY column
	 */
	public short getOccasnTagTypeKey() {
		return this.OccasnTagTypeKey;
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
	 * Get the RoleNameKey field.
	 *
	 * @return Contents of the ROLE_NAME_KEY column
	 */
	public short getRoleNameKey() {
		return this.RoleNameKey;
	}

	/**
	 * Get the SentceSetPid field.
	 *
	 * @return Contents of the SENTCE_SET_PID column
	 */
	public int getSentceSetPid() {
		return this.SentceSetPid;
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
	 * Get the TagRuleKey field.
	 *
	 * @return Contents of the TAG_RULE_KEY column
	 */
	public short getTagRuleKey() {
		return this.TagRuleKey;
	}

	/**
	 * Get the ThemeKey field.
	 *
	 * @return Contents of the THEME_KEY column
	 */
	public short getThemeKey() {
		return this.ThemeKey;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((OccasnAssocTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((OccasnAssocTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((OccasnAssocTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((OccasnAssocTagDefns) model).setOccasnAssocTagDefnPid(rs.getInt("OCCASN_ASSOC_TAG_DEFN_PID"));
		((OccasnAssocTagDefns) model).setIsUserDefn(rs.getBoolean("IS_USER_DEFN"));
		((OccasnAssocTagDefns) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
		((OccasnAssocTagDefns) model).setOccasnTagTypeKey(rs.getShort("OCCASN_TAG_TYPE_KEY"));
		((OccasnAssocTagDefns) model).setAssocTypeKey(rs.getShort("ASSOC_TYPE_KEY"));
		((OccasnAssocTagDefns) model).setAssocSubTypeKey(rs.getShort("ASSOC_SUB_TYPE_KEY"));
		((OccasnAssocTagDefns) model).setRoleNameKey(rs.getShort("ROLE_NAME_KEY"));
		((OccasnAssocTagDefns) model).setMinInRole(rs.getShort("MIN_IN_ROLE"));
		((OccasnAssocTagDefns) model).setMaxInRole(rs.getShort("MAX_IN_ROLE"));
		((OccasnAssocTagDefns) model).setIsRequiredRole(rs.getBoolean("IS_REQUIRED_ROLE"));
		((OccasnAssocTagDefns) model).setGroupKey(rs.getShort("GROUP_KEY"));
		((OccasnAssocTagDefns) model).setThemeKey(rs.getShort("THEME_KEY"));
		((OccasnAssocTagDefns) model).setSentceSetPid(rs.getInt("SENTCE_SET_PID"));
		((OccasnAssocTagDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
		((OccasnAssocTagDefns) model).setTagRuleKey(rs.getShort("TAG_RULE_KEY"));
		((OccasnAssocTagDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
		((OccasnAssocTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((OccasnAssocTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((OccasnAssocTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((OccasnAssocTagDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((OccasnAssocTagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((OccasnAssocTagDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((OccasnAssocTagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((OccasnAssocTagDefns) model).setOccasnAssocTagDefnPid(rs.getInt("OCCASN_ASSOC_TAG_DEFN_PID"));
		((OccasnAssocTagDefns) model).setIsUserDefn(rs.getBoolean("IS_USER_DEFN"));
		((OccasnAssocTagDefns) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
		((OccasnAssocTagDefns) model).setOccasnTagTypeKey(rs.getShort("OCCASN_TAG_TYPE_KEY"));
		((OccasnAssocTagDefns) model).setAssocTypeKey(rs.getShort("ASSOC_TYPE_KEY"));
		((OccasnAssocTagDefns) model).setAssocSubTypeKey(rs.getShort("ASSOC_SUB_TYPE_KEY"));
		((OccasnAssocTagDefns) model).setRoleNameKey(rs.getShort("ROLE_NAME_KEY"));
		((OccasnAssocTagDefns) model).setMinInRole(rs.getShort("MIN_IN_ROLE"));
		((OccasnAssocTagDefns) model).setMaxInRole(rs.getShort("MAX_IN_ROLE"));
		((OccasnAssocTagDefns) model).setIsRequiredRole(rs.getBoolean("IS_REQUIRED_ROLE"));
		((OccasnAssocTagDefns) model).setGroupKey(rs.getShort("GROUP_KEY"));
		((OccasnAssocTagDefns) model).setThemeKey(rs.getShort("THEME_KEY"));
		((OccasnAssocTagDefns) model).setSentceSetPid(rs.getInt("SENTCE_SET_PID"));
		((OccasnAssocTagDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
		((OccasnAssocTagDefns) model).setTagRuleKey(rs.getShort("TAG_RULE_KEY"));
		((OccasnAssocTagDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
		((OccasnAssocTagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((OccasnAssocTagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((OccasnAssocTagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((OccasnAssocTagDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	/**
	 * Set the AssocSubTypeKey field
	 *
	 * @param AssocSubTypeKey
	 *            Contents of the ASSOC_SUB_TYPE_KEY column
	 */
	public void setAssocSubTypeKey(short AssocSubTypeKey) {
		this.AssocSubTypeKey = AssocSubTypeKey;
	}

	/**
	 * Set the AssocTypeKey field
	 *
	 * @param AssocTypeKey
	 *            Contents of the ASSOC_TYPE_KEY column
	 */
	public void setAssocTypeKey(short AssocTypeKey) {
		this.AssocTypeKey = AssocTypeKey;
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
	 * Set the GroupKey field
	 *
	 * @param GroupKey
	 *            Contents of the GROUP_KEY column
	 */
	public void setGroupKey(short GroupKey) {
		this.GroupKey = GroupKey;
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
	 * Set the IsRequiredRole field
	 *
	 * @param IsRequiredRole
	 *            Contents of the IS_REQUIRED_ROLE column
	 */
	public void setIsRequiredRole(boolean IsRequiredRole) {
		this.IsRequiredRole = IsRequiredRole;
	}

	/**
	 * Set the IsUserDefn field
	 *
	 * @param IsUserDefn
	 *            Contents of the IS_USER_DEFN column
	 */
	public void setIsUserDefn(boolean IsUserDefn) {
		this.IsUserDefn = IsUserDefn;
	}

	/**
	 * Set the MaxInRole field
	 *
	 * @param MaxInRole
	 *            Contents of the MAX_IN_ROLE column
	 */
	public void setMaxInRole(short MaxInRole) {
		this.MaxInRole = MaxInRole;
	}

	/**
	 * Set the MinInRole field
	 *
	 * @param MinInRole
	 *            Contents of the MIN_IN_ROLE column
	 */
	public void setMinInRole(short MinInRole) {
		this.MinInRole = MinInRole;
	}

	/**
	 * Set the OccasnAssocTagDefnPid field
	 *
	 * @param OccasnAssocTagDefnPid
	 *            Contents of the OCCASN_ASSOC_TAG_DEFN_PID column
	 */
	public void setOccasnAssocTagDefnPid(int OccasnAssocTagDefnPid) {
		this.OccasnAssocTagDefnPid = OccasnAssocTagDefnPid;
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
	 * Set the OccasnTagTypeKey field
	 *
	 * @param OccasnTagTypeKey
	 *            Contents of the OCCASN_TAG_TYPE_KEY column
	 */
	public void setOccasnTagTypeKey(short OccasnTagTypeKey) {
		this.OccasnTagTypeKey = OccasnTagTypeKey;
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
	 * Set the RoleNameKey field
	 *
	 * @param RoleNameKey
	 *            Contents of the ROLE_NAME_KEY column
	 */
	public void setRoleNameKey(short RoleNameKey) {
		this.RoleNameKey = RoleNameKey;
	}

	/**
	 * Set the SentceSetPid field
	 *
	 * @param SentceSetPid
	 *            Contents of the SENTCE_SET_PID column
	 */
	public void setSentceSetPid(int SentceSetPid) {
		this.SentceSetPid = SentceSetPid;
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
	 * Set the TagRuleKey field
	 *
	 * @param TagRuleKey
	 *            Contents of the TAG_RULE_KEY column
	 */
	public void setTagRuleKey(short TagRuleKey) {
		this.TagRuleKey = TagRuleKey;
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

}
