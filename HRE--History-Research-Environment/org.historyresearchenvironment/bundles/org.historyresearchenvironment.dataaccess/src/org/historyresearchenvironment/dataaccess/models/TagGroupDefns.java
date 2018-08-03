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

	public TagGroupDefns() throws SQLException {
	}

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

	public int getCommitPid() {
		return this.CommitPid;
	}

	public short getDisplayOrder() {
		return this.DisplayOrder;
	}

	public short getEntitySubTypeKey() {
		return this.EntitySubTypeKey;
	}

	public short getEntityTypeKey() {
		return this.EntityTypeKey;
	}

	public boolean getIsDefault() {
		return this.IsDefault;
	}

	public boolean getIsMajorGroup() {
		return this.IsMajorGroup;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public short getMajorGrpKey() {
		return this.MajorGrpKey;
	}

	public short getMinorGrpKey() {
		return this.MinorGrpKey;
	}

	public short getPluginKey() {
		return this.PluginKey;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getReminderKey() {
		return this.ReminderKey;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public boolean getShow() {
		return this.Show;
	}

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

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setEntitySubTypeKey(short EntitySubTypeKey) {
		this.EntitySubTypeKey = EntitySubTypeKey;
	}

	public void setEntityTypeKey(short EntityTypeKey) {
		this.EntityTypeKey = EntityTypeKey;
	}

	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
	}

	public void setIsMajorGroup(boolean IsMajorGroup) {
		this.IsMajorGroup = IsMajorGroup;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setMajorGrpKey(short MajorGrpKey) {
		this.MajorGrpKey = MajorGrpKey;
	}

	public void setMinorGrpKey(short MinorGrpKey) {
		this.MinorGrpKey = MinorGrpKey;
	}

	public void setPluginKey(short PluginKey) {
		this.PluginKey = PluginKey;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setReminderKey(short ReminderKey) {
		this.ReminderKey = ReminderKey;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setShow(boolean Show) {
		this.Show = Show;
	}

	public void setTagGroupDefnPid(int TagGroupDefnPid) {
		this.TagGroupDefnPid = TagGroupDefnPid;
	}

}
