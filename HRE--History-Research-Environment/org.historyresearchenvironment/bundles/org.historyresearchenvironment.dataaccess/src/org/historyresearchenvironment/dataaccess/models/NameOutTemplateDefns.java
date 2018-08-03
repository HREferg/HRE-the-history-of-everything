package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the NAME_OUT_TEMPLATE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class NameOutTemplateDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "NAME_OUT_TEMPLATE_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_NAME_STYLE_TYPE_KEY, " + "TEMPLATE_TYPE_KEY, "
			+ "SORTING_ONLY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.NAME_OUT_TEMPLATE_DEFNS WHERE NAME_OUT_TEMPLATE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "NAME_OUT_TEMPLATE_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_NAME_STYLE_TYPE_KEY, " + "TEMPLATE_TYPE_KEY, "
			+ "SORTING_ONLY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.NAME_OUT_TEMPLATE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.NAME_OUT_TEMPLATE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "NAME_OUT_TEMPLATE_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_NAME_STYLE_TYPE_KEY, "
			+ "TEMPLATE_TYPE_KEY, " + "SORTING_ONLY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?)";

	private static final String UPDATE = "UPDATE PUBLIC.NAME_OUT_TEMPLATE_DEFNSSET " + "RECORD_NUM = ?, "
			+ "SET_KEY = ?, " + "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PARENT_NAME_STYLE_TYPE_KEY = ?, "
			+ "TEMPLATE_TYPE_KEY = ?, " + "SORTING_ONLY = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, "
			+ "IS_DEFAULT = ?, " + "SHOW = ? WHERE NAME_OUT_TEMPLATE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.NAME_OUT_TEMPLATE_DEFNS WHERE NAME_OUT_TEMPLATE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.NAME_OUT_TEMPLATE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int NameOutTemplateDefnPid;
	private boolean IsSystem;
	private short ParentNameStyleTypeKey;
	private short TemplateTypeKey;
	private boolean SortingOnly;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private NameOutTemplateDefns model;

	public NameOutTemplateDefns() throws SQLException {
	}

	public NameOutTemplateDefns(int NameOutTemplateDefnPid) throws SQLException {
		super();
		this.NameOutTemplateDefnPid = NameOutTemplateDefnPid;
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
			model = new NameOutTemplateDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setNameOutTemplateDefnPid(rs.getInt("NAME_OUT_TEMPLATE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentNameStyleTypeKey(rs.getShort("PARENT_NAME_STYLE_TYPE_KEY"));
			model.setTemplateTypeKey(rs.getShort("TEMPLATE_TYPE_KEY"));
			model.setSortingOnly(rs.getBoolean("SORTING_ONLY"));
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
			model.setNameOutTemplateDefnPid(rs.getInt("NAME_OUT_TEMPLATE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentNameStyleTypeKey(rs.getShort("PARENT_NAME_STYLE_TYPE_KEY"));
			model.setTemplateTypeKey(rs.getShort("TEMPLATE_TYPE_KEY"));
			model.setSortingOnly(rs.getBoolean("SORTING_ONLY"));
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

	public boolean getIsDefault() {
		return this.IsDefault;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public int getNameOutTemplateDefnPid() {
		return this.NameOutTemplateDefnPid;
	}

	public short getParentNameStyleTypeKey() {
		return this.ParentNameStyleTypeKey;
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

	public boolean getSortingOnly() {
		return this.SortingOnly;
	}

	public short getTemplateTypeKey() {
		return this.TemplateTypeKey;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((NameOutTemplateDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((NameOutTemplateDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((NameOutTemplateDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((NameOutTemplateDefns) model).setNameOutTemplateDefnPid(rs.getInt("NAME_OUT_TEMPLATE_DEFN_PID"));
		((NameOutTemplateDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((NameOutTemplateDefns) model).setParentNameStyleTypeKey(rs.getShort("PARENT_NAME_STYLE_TYPE_KEY"));
		((NameOutTemplateDefns) model).setTemplateTypeKey(rs.getShort("TEMPLATE_TYPE_KEY"));
		((NameOutTemplateDefns) model).setSortingOnly(rs.getBoolean("SORTING_ONLY"));
		((NameOutTemplateDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((NameOutTemplateDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((NameOutTemplateDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((NameOutTemplateDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((NameOutTemplateDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((NameOutTemplateDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((NameOutTemplateDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((NameOutTemplateDefns) model).setNameOutTemplateDefnPid(rs.getInt("NAME_OUT_TEMPLATE_DEFN_PID"));
		((NameOutTemplateDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((NameOutTemplateDefns) model).setParentNameStyleTypeKey(rs.getShort("PARENT_NAME_STYLE_TYPE_KEY"));
		((NameOutTemplateDefns) model).setTemplateTypeKey(rs.getShort("TEMPLATE_TYPE_KEY"));
		((NameOutTemplateDefns) model).setSortingOnly(rs.getBoolean("SORTING_ONLY"));
		((NameOutTemplateDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((NameOutTemplateDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((NameOutTemplateDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((NameOutTemplateDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setNameOutTemplateDefnPid(int NameOutTemplateDefnPid) {
		this.NameOutTemplateDefnPid = NameOutTemplateDefnPid;
	}

	public void setParentNameStyleTypeKey(short ParentNameStyleTypeKey) {
		this.ParentNameStyleTypeKey = ParentNameStyleTypeKey;
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

	public void setSortingOnly(boolean SortingOnly) {
		this.SortingOnly = SortingOnly;
	}

	public void setTemplateTypeKey(short TemplateTypeKey) {
		this.TemplateTypeKey = TemplateTypeKey;
	}

}
