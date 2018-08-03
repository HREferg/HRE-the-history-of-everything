package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the VIEWPOINT_CONFIGS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class ViewpointConfigs extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "VIEWPOINT_CONFIG_PID, " + "VIEWPOINT_TYPE_KEY, " + "VIEWPOINT_SUB_TYPE_KEY, " + "DISPLAY_TYPE_KEY, "
			+ "LEFT_EDGE, " + "TOP_EDGE, " + "WIDTH, " + "HEIGHT, " + "LAST_OPENED, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.VIEWPOINT_CONFIGS WHERE VIEWPOINT_CONFIG_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "VIEWPOINT_CONFIG_PID, " + "VIEWPOINT_TYPE_KEY, " + "VIEWPOINT_SUB_TYPE_KEY, " + "DISPLAY_TYPE_KEY, "
			+ "LEFT_EDGE, " + "TOP_EDGE, " + "WIDTH, " + "HEIGHT, " + "LAST_OPENED, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.VIEWPOINT_CONFIGS";

	private static final String INSERT = "INSERT INTO PUBLIC.VIEWPOINT_CONFIGS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "VIEWPOINT_CONFIG_PID, " + "VIEWPOINT_TYPE_KEY, " + "VIEWPOINT_SUB_TYPE_KEY, "
			+ "DISPLAY_TYPE_KEY, " + "LEFT_EDGE, " + "TOP_EDGE, " + "WIDTH, " + "HEIGHT, " + "LAST_OPENED, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.VIEWPOINT_CONFIGSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "VIEWPOINT_TYPE_KEY = ?, " + "VIEWPOINT_SUB_TYPE_KEY = ?, "
			+ "DISPLAY_TYPE_KEY = ?, " + "LEFT_EDGE = ?, " + "TOP_EDGE = ?, " + "WIDTH = ?, " + "HEIGHT = ?, "
			+ "LAST_OPENED = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE VIEWPOINT_CONFIG_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.VIEWPOINT_CONFIGS WHERE VIEWPOINT_CONFIG_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.VIEWPOINT_CONFIGS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int ViewpointConfigPid;
	private short ViewpointTypeKey;
	private short ViewpointSubTypeKey;
	private short DisplayTypeKey;
	private int LeftEdge;
	private int TopEdge;
	private int Width;
	private int Height;
	private Timestamp LastOpened;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private ViewpointConfigs model;

	public ViewpointConfigs() throws SQLException {
	}

	public ViewpointConfigs(int ViewpointConfigPid) throws SQLException {
		super();
		this.ViewpointConfigPid = ViewpointConfigPid;
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
			model = new ViewpointConfigs();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setViewpointConfigPid(rs.getInt("VIEWPOINT_CONFIG_PID"));
			model.setViewpointTypeKey(rs.getShort("VIEWPOINT_TYPE_KEY"));
			model.setViewpointSubTypeKey(rs.getShort("VIEWPOINT_SUB_TYPE_KEY"));
			model.setDisplayTypeKey(rs.getShort("DISPLAY_TYPE_KEY"));
			model.setLeftEdge(rs.getInt("LEFT_EDGE"));
			model.setTopEdge(rs.getInt("TOP_EDGE"));
			model.setWidth(rs.getInt("WIDTH"));
			model.setHeight(rs.getInt("HEIGHT"));
			model.setLastOpened(rs.getTimestamp("LAST_OPENED"));
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
			model.setViewpointConfigPid(rs.getInt("VIEWPOINT_CONFIG_PID"));
			model.setViewpointTypeKey(rs.getShort("VIEWPOINT_TYPE_KEY"));
			model.setViewpointSubTypeKey(rs.getShort("VIEWPOINT_SUB_TYPE_KEY"));
			model.setDisplayTypeKey(rs.getShort("DISPLAY_TYPE_KEY"));
			model.setLeftEdge(rs.getInt("LEFT_EDGE"));
			model.setTopEdge(rs.getInt("TOP_EDGE"));
			model.setWidth(rs.getInt("WIDTH"));
			model.setHeight(rs.getInt("HEIGHT"));
			model.setLastOpened(rs.getTimestamp("LAST_OPENED"));
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

	public short getDisplayTypeKey() {
		return this.DisplayTypeKey;
	}

	public int getHeight() {
		return this.Height;
	}

	public boolean getIsDefault() {
		return this.IsDefault;
	}

	public Timestamp getLastOpened() {
		return this.LastOpened;
	}

	public int getLeftEdge() {
		return this.LeftEdge;
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

	public int getTopEdge() {
		return this.TopEdge;
	}

	public int getViewpointConfigPid() {
		return this.ViewpointConfigPid;
	}

	public short getViewpointSubTypeKey() {
		return this.ViewpointSubTypeKey;
	}

	public short getViewpointTypeKey() {
		return this.ViewpointTypeKey;
	}

	public int getWidth() {
		return this.Width;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((ViewpointConfigs) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((ViewpointConfigs) model).setSetKey(rs.getShort("SET_KEY"));
		((ViewpointConfigs) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((ViewpointConfigs) model).setViewpointConfigPid(rs.getInt("VIEWPOINT_CONFIG_PID"));
		((ViewpointConfigs) model).setViewpointTypeKey(rs.getShort("VIEWPOINT_TYPE_KEY"));
		((ViewpointConfigs) model).setViewpointSubTypeKey(rs.getShort("VIEWPOINT_SUB_TYPE_KEY"));
		((ViewpointConfigs) model).setDisplayTypeKey(rs.getShort("DISPLAY_TYPE_KEY"));
		((ViewpointConfigs) model).setLeftEdge(rs.getInt("LEFT_EDGE"));
		((ViewpointConfigs) model).setTopEdge(rs.getInt("TOP_EDGE"));
		((ViewpointConfigs) model).setWidth(rs.getInt("WIDTH"));
		((ViewpointConfigs) model).setHeight(rs.getInt("HEIGHT"));
		((ViewpointConfigs) model).setLastOpened(rs.getTimestamp("LAST_OPENED"));
		((ViewpointConfigs) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((ViewpointConfigs) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((ViewpointConfigs) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((ViewpointConfigs) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((ViewpointConfigs) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((ViewpointConfigs) model).setSetKey(rs.getShort("SET_KEY"));
		((ViewpointConfigs) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((ViewpointConfigs) model).setViewpointConfigPid(rs.getInt("VIEWPOINT_CONFIG_PID"));
		((ViewpointConfigs) model).setViewpointTypeKey(rs.getShort("VIEWPOINT_TYPE_KEY"));
		((ViewpointConfigs) model).setViewpointSubTypeKey(rs.getShort("VIEWPOINT_SUB_TYPE_KEY"));
		((ViewpointConfigs) model).setDisplayTypeKey(rs.getShort("DISPLAY_TYPE_KEY"));
		((ViewpointConfigs) model).setLeftEdge(rs.getInt("LEFT_EDGE"));
		((ViewpointConfigs) model).setTopEdge(rs.getInt("TOP_EDGE"));
		((ViewpointConfigs) model).setWidth(rs.getInt("WIDTH"));
		((ViewpointConfigs) model).setHeight(rs.getInt("HEIGHT"));
		((ViewpointConfigs) model).setLastOpened(rs.getTimestamp("LAST_OPENED"));
		((ViewpointConfigs) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((ViewpointConfigs) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((ViewpointConfigs) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((ViewpointConfigs) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setDisplayTypeKey(short DisplayTypeKey) {
		this.DisplayTypeKey = DisplayTypeKey;
	}

	public void setHeight(int Height) {
		this.Height = Height;
	}

	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
	}

	public void setLastOpened(Timestamp LastOpened) {
		this.LastOpened = LastOpened;
	}

	public void setLeftEdge(int LeftEdge) {
		this.LeftEdge = LeftEdge;
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

	public void setTopEdge(int TopEdge) {
		this.TopEdge = TopEdge;
	}

	public void setViewpointConfigPid(int ViewpointConfigPid) {
		this.ViewpointConfigPid = ViewpointConfigPid;
	}

	public void setViewpointSubTypeKey(short ViewpointSubTypeKey) {
		this.ViewpointSubTypeKey = ViewpointSubTypeKey;
	}

	public void setViewpointTypeKey(short ViewpointTypeKey) {
		this.ViewpointTypeKey = ViewpointTypeKey;
	}

	public void setWidth(int Width) {
		this.Width = Width;
	}

}
