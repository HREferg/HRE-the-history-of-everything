package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the TAG_GROUP_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class TagGroupDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "TAG_GROUP_DEFN_PID, " + "IS_SYSTEM, " + "PLUGIN_KEY, " + "ENTITY_TYPE_KEY, " + "ENTITY_SUB_TYPE_KEY, "
			+ "IS_MAJOR_GROUP, " + "MAJOR_GRP_KEY, " + "MINOR_GRP_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW FROM PUBLIC.TAG_GROUP_DEFNS WHERE TAG_GROUP_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "TAG_GROUP_DEFN_PID, " + "IS_SYSTEM, " + "PLUGIN_KEY, " + "ENTITY_TYPE_KEY, " + "ENTITY_SUB_TYPE_KEY, "
			+ "IS_MAJOR_GROUP, " + "MAJOR_GRP_KEY, " + "MINOR_GRP_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW FROM PUBLIC.TAG_GROUP_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.TAG_GROUP_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "TAG_GROUP_DEFN_PID, " + "IS_SYSTEM, " + "PLUGIN_KEY, " + "ENTITY_TYPE_KEY, "
			+ "ENTITY_SUB_TYPE_KEY, " + "IS_MAJOR_GROUP, " + "MAJOR_GRP_KEY, " + "MINOR_GRP_KEY, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.TAG_GROUP_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PLUGIN_KEY = ?, " + "ENTITY_TYPE_KEY = ?, "
			+ "ENTITY_SUB_TYPE_KEY = ?, " + "IS_MAJOR_GROUP = ?, " + "MAJOR_GRP_KEY = ?, " + "MINOR_GRP_KEY = ?, "
			+ "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE TAG_GROUP_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.TAG_GROUP_DEFNS WHERE TAG_GROUP_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.TAG_GROUP_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int TagGroupDefnPid;
	private boolean IsSystem;
	private short PluginKey;
	private short EntityTypeKey;
	private short EntitySubTypeKey;
	private boolean IsMajorGroup;
	private short MajorGrpKey;
	private short MinorGrpKey;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private TagGroupDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public TagGroupDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param TagGroupDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public TagGroupDefns(int TagGroupDefnPid) throws SQLException {
		super();
		this.TagGroupDefnPid = TagGroupDefnPid;
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
			model = new TagGroupDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setTagGroupDefnPid(rs.getInt("TAG_GROUP_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
			model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
			model.setIsMajorGroup(rs.getBoolean("IS_MAJOR_GROUP"));
			model.setMajorGrpKey(rs.getShort("MAJOR_GRP_KEY"));
			model.setMinorGrpKey(rs.getShort("MINOR_GRP_KEY"));
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
			model.setTagGroupDefnPid(rs.getInt("TAG_GROUP_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
			model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
			model.setIsMajorGroup(rs.getBoolean("IS_MAJOR_GROUP"));
			model.setMajorGrpKey(rs.getShort("MAJOR_GRP_KEY"));
			model.setMinorGrpKey(rs.getShort("MINOR_GRP_KEY"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
			model.setShow(rs.getBoolean("SHOW"));
		}
		return this;
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
	 * Get the EntitySubTypeKey field.
	 *
	 * @return Contents of the ENTITY_SUB_TYPE_KEY column
	 */
	public short getEntitySubTypeKey() {
		return this.EntitySubTypeKey;
	}

	/**
	 * Get the EntityTypeKey field.
	 *
	 * @return Contents of the ENTITY_TYPE_KEY column
	 */
	public short getEntityTypeKey() {
		return this.EntityTypeKey;
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
	 * Get the IsMajorGroup field.
	 *
	 * @return Contents of the IS_MAJOR_GROUP column
	 */
	public boolean getIsMajorGroup() {
		return this.IsMajorGroup;
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
	 * Get the MajorGrpKey field.
	 *
	 * @return Contents of the MAJOR_GRP_KEY column
	 */
	public short getMajorGrpKey() {
		return this.MajorGrpKey;
	}

	/**
	 * Get the MinorGrpKey field.
	 *
	 * @return Contents of the MINOR_GRP_KEY column
	 */
	public short getMinorGrpKey() {
		return this.MinorGrpKey;
	}

	/**
	 * Get the PluginKey field.
	 *
	 * @return Contents of the PLUGIN_KEY column
	 */
	public short getPluginKey() {
		return this.PluginKey;
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
	 * Get the TagGroupDefnPid field.
	 *
	 * @return Contents of the TAG_GROUP_DEFN_PID column
	 */
	public int getTagGroupDefnPid() {
		return this.TagGroupDefnPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((TagGroupDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((TagGroupDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((TagGroupDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((TagGroupDefns) model).setTagGroupDefnPid(rs.getInt("TAG_GROUP_DEFN_PID"));
		((TagGroupDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((TagGroupDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((TagGroupDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
		((TagGroupDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
		((TagGroupDefns) model).setIsMajorGroup(rs.getBoolean("IS_MAJOR_GROUP"));
		((TagGroupDefns) model).setMajorGrpKey(rs.getShort("MAJOR_GRP_KEY"));
		((TagGroupDefns) model).setMinorGrpKey(rs.getShort("MINOR_GRP_KEY"));
		((TagGroupDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((TagGroupDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((TagGroupDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((TagGroupDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((TagGroupDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((TagGroupDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((TagGroupDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((TagGroupDefns) model).setTagGroupDefnPid(rs.getInt("TAG_GROUP_DEFN_PID"));
		((TagGroupDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((TagGroupDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((TagGroupDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
		((TagGroupDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
		((TagGroupDefns) model).setIsMajorGroup(rs.getBoolean("IS_MAJOR_GROUP"));
		((TagGroupDefns) model).setMajorGrpKey(rs.getShort("MAJOR_GRP_KEY"));
		((TagGroupDefns) model).setMinorGrpKey(rs.getShort("MINOR_GRP_KEY"));
		((TagGroupDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((TagGroupDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((TagGroupDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((TagGroupDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
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
	 * Set the EntitySubTypeKey field
	 *
	 * @param EntitySubTypeKey
	 *            Contents of the ENTITY_SUB_TYPE_KEY column
	 */
	public void setEntitySubTypeKey(short EntitySubTypeKey) {
		this.EntitySubTypeKey = EntitySubTypeKey;
	}

	/**
	 * Set the EntityTypeKey field
	 *
	 * @param EntityTypeKey
	 *            Contents of the ENTITY_TYPE_KEY column
	 */
	public void setEntityTypeKey(short EntityTypeKey) {
		this.EntityTypeKey = EntityTypeKey;
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
	 * Set the IsMajorGroup field
	 *
	 * @param IsMajorGroup
	 *            Contents of the IS_MAJOR_GROUP column
	 */
	public void setIsMajorGroup(boolean IsMajorGroup) {
		this.IsMajorGroup = IsMajorGroup;
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
	 * Set the MajorGrpKey field
	 *
	 * @param MajorGrpKey
	 *            Contents of the MAJOR_GRP_KEY column
	 */
	public void setMajorGrpKey(short MajorGrpKey) {
		this.MajorGrpKey = MajorGrpKey;
	}

	/**
	 * Set the MinorGrpKey field
	 *
	 * @param MinorGrpKey
	 *            Contents of the MINOR_GRP_KEY column
	 */
	public void setMinorGrpKey(short MinorGrpKey) {
		this.MinorGrpKey = MinorGrpKey;
	}

	/**
	 * Set the PluginKey field
	 *
	 * @param PluginKey
	 *            Contents of the PLUGIN_KEY column
	 */
	public void setPluginKey(short PluginKey) {
		this.PluginKey = PluginKey;
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
	 * Set the TagGroupDefnPid field
	 *
	 * @param TagGroupDefnPid
	 *            Contents of the TAG_GROUP_DEFN_PID column
	 */
	public void setTagGroupDefnPid(int TagGroupDefnPid) {
		this.TagGroupDefnPid = TagGroupDefnPid;
	}

}
