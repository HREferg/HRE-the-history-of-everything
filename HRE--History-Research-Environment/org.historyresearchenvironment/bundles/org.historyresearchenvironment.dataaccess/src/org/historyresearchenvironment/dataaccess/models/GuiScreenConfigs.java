package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the GUI_SCREEN_CONFIGS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class GuiScreenConfigs extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "GUI_SCREEN_CONFIG_PID, " + "PLUGIN_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.GUI_SCREEN_CONFIGS WHERE GUI_SCREEN_CONFIG_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "GUI_SCREEN_CONFIG_PID, " + "PLUGIN_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.GUI_SCREEN_CONFIGS";

	private static final String INSERT = "INSERT INTO PUBLIC.GUI_SCREEN_CONFIGS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "GUI_SCREEN_CONFIG_PID, " + "PLUGIN_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.GUI_SCREEN_CONFIGSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "PLUGIN_KEY = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, "
			+ "IS_DEFAULT = ?, " + "SHOW = ? WHERE GUI_SCREEN_CONFIG_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.GUI_SCREEN_CONFIGS WHERE GUI_SCREEN_CONFIG_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.GUI_SCREEN_CONFIGS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int GuiScreenConfigPid;
	private short PluginKey;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private GuiScreenConfigs model;

	public GuiScreenConfigs() throws SQLException {
	}

	public GuiScreenConfigs(int GuiScreenConfigPid) throws SQLException {
		super();
		this.GuiScreenConfigPid = GuiScreenConfigPid;
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
			model = new GuiScreenConfigs();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setGuiScreenConfigPid(rs.getInt("GUI_SCREEN_CONFIG_PID"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
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
			model.setGuiScreenConfigPid(rs.getInt("GUI_SCREEN_CONFIG_PID"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
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

	public int getGuiScreenConfigPid() {
		return this.GuiScreenConfigPid;
	}

	public boolean getIsDefault() {
		return this.IsDefault;
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

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((GuiScreenConfigs) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((GuiScreenConfigs) model).setSetKey(rs.getShort("SET_KEY"));
		((GuiScreenConfigs) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((GuiScreenConfigs) model).setGuiScreenConfigPid(rs.getInt("GUI_SCREEN_CONFIG_PID"));
		((GuiScreenConfigs) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((GuiScreenConfigs) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((GuiScreenConfigs) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((GuiScreenConfigs) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((GuiScreenConfigs) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((GuiScreenConfigs) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((GuiScreenConfigs) model).setSetKey(rs.getShort("SET_KEY"));
		((GuiScreenConfigs) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((GuiScreenConfigs) model).setGuiScreenConfigPid(rs.getInt("GUI_SCREEN_CONFIG_PID"));
		((GuiScreenConfigs) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((GuiScreenConfigs) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((GuiScreenConfigs) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((GuiScreenConfigs) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((GuiScreenConfigs) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setGuiScreenConfigPid(int GuiScreenConfigPid) {
		this.GuiScreenConfigPid = GuiScreenConfigPid;
	}

	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
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

}
