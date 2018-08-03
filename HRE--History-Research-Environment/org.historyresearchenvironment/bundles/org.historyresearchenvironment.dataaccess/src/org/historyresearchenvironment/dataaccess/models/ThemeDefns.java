package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the THEME_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class ThemeDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "THEME_DEFN_PID, "
			+ "IS_SYSTEM, " + "PLUGIN_KEY, " + "ENTITY_TYPE_KEY, " + "ENTITY_SUB_TYPE_KEY, " + "IS_MAIN_THEME, "
			+ "MAIN_THEME_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.THEME_DEFNS WHERE THEME_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "THEME_DEFN_PID, " + "IS_SYSTEM, " + "PLUGIN_KEY, " + "ENTITY_TYPE_KEY, " + "ENTITY_SUB_TYPE_KEY, "
			+ "IS_MAIN_THEME, " + "MAIN_THEME_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.THEME_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.THEME_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "THEME_DEFN_PID, " + "IS_SYSTEM, " + "PLUGIN_KEY, " + "ENTITY_TYPE_KEY, "
			+ "ENTITY_SUB_TYPE_KEY, " + "IS_MAIN_THEME, " + "MAIN_THEME_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.THEME_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PLUGIN_KEY = ?, " + "ENTITY_TYPE_KEY = ?, "
			+ "ENTITY_SUB_TYPE_KEY = ?, " + "IS_MAIN_THEME = ?, " + "MAIN_THEME_KEY = ?, " + "REMINDER_KEY = ?, "
			+ "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, " + "SHOW = ? WHERE THEME_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.THEME_DEFNS WHERE THEME_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.THEME_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int ThemeDefnPid;
	private boolean IsSystem;
	private short PluginKey;
	private short EntityTypeKey;
	private short EntitySubTypeKey;
	private boolean IsMainTheme;
	private short MainThemeKey;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private ThemeDefns model;

	public ThemeDefns() throws SQLException {
	}

	public ThemeDefns(int ThemeDefnPid) throws SQLException {
		super();
		this.ThemeDefnPid = ThemeDefnPid;
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
			model = new ThemeDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setThemeDefnPid(rs.getInt("THEME_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
			model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
			model.setIsMainTheme(rs.getBoolean("IS_MAIN_THEME"));
			model.setMainThemeKey(rs.getShort("MAIN_THEME_KEY"));
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
			model.setThemeDefnPid(rs.getInt("THEME_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
			model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
			model.setIsMainTheme(rs.getBoolean("IS_MAIN_THEME"));
			model.setMainThemeKey(rs.getShort("MAIN_THEME_KEY"));
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

	public boolean getIsMainTheme() {
		return this.IsMainTheme;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public short getMainThemeKey() {
		return this.MainThemeKey;
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

	public int getThemeDefnPid() {
		return this.ThemeDefnPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((ThemeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((ThemeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((ThemeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((ThemeDefns) model).setThemeDefnPid(rs.getInt("THEME_DEFN_PID"));
		((ThemeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((ThemeDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((ThemeDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
		((ThemeDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
		((ThemeDefns) model).setIsMainTheme(rs.getBoolean("IS_MAIN_THEME"));
		((ThemeDefns) model).setMainThemeKey(rs.getShort("MAIN_THEME_KEY"));
		((ThemeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((ThemeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((ThemeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((ThemeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((ThemeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((ThemeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((ThemeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((ThemeDefns) model).setThemeDefnPid(rs.getInt("THEME_DEFN_PID"));
		((ThemeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((ThemeDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((ThemeDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
		((ThemeDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
		((ThemeDefns) model).setIsMainTheme(rs.getBoolean("IS_MAIN_THEME"));
		((ThemeDefns) model).setMainThemeKey(rs.getShort("MAIN_THEME_KEY"));
		((ThemeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((ThemeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((ThemeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((ThemeDefns) model).setShow(rs.getBoolean("SHOW"));
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

	public void setIsMainTheme(boolean IsMainTheme) {
		this.IsMainTheme = IsMainTheme;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setMainThemeKey(short MainThemeKey) {
		this.MainThemeKey = MainThemeKey;
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

	public void setThemeDefnPid(int ThemeDefnPid) {
		this.ThemeDefnPid = ThemeDefnPid;
	}

}
