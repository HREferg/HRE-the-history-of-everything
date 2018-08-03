package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the TEMPLATE_TYPE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class TemplateTypeDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "TEMPLATE_TYPE_DEFN_PID, " + "IS_SYSTEM, " + "IS_MANDATORY, " + "ENTITY_TYPE_KEY, "
			+ "ENTITY_SUB_TYPE_KEY, " + "PUBLISH_TYPE_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.TEMPLATE_TYPE_DEFNS WHERE TEMPLATE_TYPE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "TEMPLATE_TYPE_DEFN_PID, " + "IS_SYSTEM, " + "IS_MANDATORY, " + "ENTITY_TYPE_KEY, "
			+ "ENTITY_SUB_TYPE_KEY, " + "PUBLISH_TYPE_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.TEMPLATE_TYPE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.TEMPLATE_TYPE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "TEMPLATE_TYPE_DEFN_PID, " + "IS_SYSTEM, " + "IS_MANDATORY, " + "ENTITY_TYPE_KEY, "
			+ "ENTITY_SUB_TYPE_KEY, " + "PUBLISH_TYPE_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.TEMPLATE_TYPE_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "IS_MANDATORY = ?, " + "ENTITY_TYPE_KEY = ?, "
			+ "ENTITY_SUB_TYPE_KEY = ?, " + "PUBLISH_TYPE_KEY = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, "
			+ "IS_DEFAULT = ?, " + "SHOW = ? WHERE TEMPLATE_TYPE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.TEMPLATE_TYPE_DEFNS WHERE TEMPLATE_TYPE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.TEMPLATE_TYPE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int TemplateTypeDefnPid;
	private boolean IsSystem;
	private boolean IsMandatory;
	private short EntityTypeKey;
	private short EntitySubTypeKey;
	private short PublishTypeKey;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private TemplateTypeDefns model;

	public TemplateTypeDefns() throws SQLException {
	}

	public TemplateTypeDefns(int TemplateTypeDefnPid) throws SQLException {
		super();
		this.TemplateTypeDefnPid = TemplateTypeDefnPid;
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
			model = new TemplateTypeDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setTemplateTypeDefnPid(rs.getInt("TEMPLATE_TYPE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setIsMandatory(rs.getBoolean("IS_MANDATORY"));
			model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
			model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
			model.setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
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
			model.setTemplateTypeDefnPid(rs.getInt("TEMPLATE_TYPE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setIsMandatory(rs.getBoolean("IS_MANDATORY"));
			model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
			model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
			model.setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
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

	public boolean getIsMandatory() {
		return this.IsMandatory;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public short getPublishTypeKey() {
		return this.PublishTypeKey;
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

	public int getTemplateTypeDefnPid() {
		return this.TemplateTypeDefnPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((TemplateTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((TemplateTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((TemplateTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((TemplateTypeDefns) model).setTemplateTypeDefnPid(rs.getInt("TEMPLATE_TYPE_DEFN_PID"));
		((TemplateTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((TemplateTypeDefns) model).setIsMandatory(rs.getBoolean("IS_MANDATORY"));
		((TemplateTypeDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
		((TemplateTypeDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
		((TemplateTypeDefns) model).setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
		((TemplateTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((TemplateTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((TemplateTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((TemplateTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((TemplateTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((TemplateTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((TemplateTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((TemplateTypeDefns) model).setTemplateTypeDefnPid(rs.getInt("TEMPLATE_TYPE_DEFN_PID"));
		((TemplateTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((TemplateTypeDefns) model).setIsMandatory(rs.getBoolean("IS_MANDATORY"));
		((TemplateTypeDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
		((TemplateTypeDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
		((TemplateTypeDefns) model).setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
		((TemplateTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((TemplateTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((TemplateTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((TemplateTypeDefns) model).setShow(rs.getBoolean("SHOW"));
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

	public void setIsMandatory(boolean IsMandatory) {
		this.IsMandatory = IsMandatory;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setPublishTypeKey(short PublishTypeKey) {
		this.PublishTypeKey = PublishTypeKey;
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

	public void setTemplateTypeDefnPid(int TemplateTypeDefnPid) {
		this.TemplateTypeDefnPid = TemplateTypeDefnPid;
	}

}
