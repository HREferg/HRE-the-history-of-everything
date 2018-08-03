package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the DISPLAY_TYPE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class DisplayTypeDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "DISPLAY_TYPE_DEFN_PID, " + "SCREEN_COUNT, " + "WIDTH, " + "HEIGHT, " + "HAS_KEYBOARD, "
			+ "TOUCH_SCREEN, " + "AUTO_ROTATE, " + "HAS_INTERNET, " + "HAS_SERVER, " + "REMINDER, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW FROM PUBLIC.DISPLAY_TYPE_DEFNS WHERE DISPLAY_TYPE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "DISPLAY_TYPE_DEFN_PID, " + "SCREEN_COUNT, " + "WIDTH, " + "HEIGHT, " + "HAS_KEYBOARD, "
			+ "TOUCH_SCREEN, " + "AUTO_ROTATE, " + "HAS_INTERNET, " + "HAS_SERVER, " + "REMINDER, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW FROM PUBLIC.DISPLAY_TYPE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.DISPLAY_TYPE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "DISPLAY_TYPE_DEFN_PID, " + "SCREEN_COUNT, " + "WIDTH, " + "HEIGHT, " + "HAS_KEYBOARD, "
			+ "TOUCH_SCREEN, " + "AUTO_ROTATE, " + "HAS_INTERNET, " + "HAS_SERVER, " + "REMINDER, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.DISPLAY_TYPE_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "SCREEN_COUNT = ?, " + "WIDTH = ?, " + "HEIGHT = ?, " + "HAS_KEYBOARD = ?, "
			+ "TOUCH_SCREEN = ?, " + "AUTO_ROTATE = ?, " + "HAS_INTERNET = ?, " + "HAS_SERVER = ?, " + "REMINDER = ?, "
			+ "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, " + "SHOW = ? WHERE DISPLAY_TYPE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.DISPLAY_TYPE_DEFNS WHERE DISPLAY_TYPE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.DISPLAY_TYPE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int DisplayTypeDefnPid;
	private short ScreenCount;
	private int Width;
	private int Height;
	private boolean HasKeyboard;
	private boolean TouchScreen;
	private boolean AutoRotate;
	private boolean HasInternet;
	private boolean HasServer;
	private short Reminder;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private DisplayTypeDefns model;

	public DisplayTypeDefns() throws SQLException {
	}

	public DisplayTypeDefns(int DisplayTypeDefnPid) throws SQLException {
		super();
		this.DisplayTypeDefnPid = DisplayTypeDefnPid;
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
			model = new DisplayTypeDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setDisplayTypeDefnPid(rs.getInt("DISPLAY_TYPE_DEFN_PID"));
			model.setScreenCount(rs.getShort("SCREEN_COUNT"));
			model.setWidth(rs.getInt("WIDTH"));
			model.setHeight(rs.getInt("HEIGHT"));
			model.setHasKeyboard(rs.getBoolean("HAS_KEYBOARD"));
			model.setTouchScreen(rs.getBoolean("TOUCH_SCREEN"));
			model.setAutoRotate(rs.getBoolean("AUTO_ROTATE"));
			model.setHasInternet(rs.getBoolean("HAS_INTERNET"));
			model.setHasServer(rs.getBoolean("HAS_SERVER"));
			model.setReminder(rs.getShort("REMINDER"));
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
			model.setDisplayTypeDefnPid(rs.getInt("DISPLAY_TYPE_DEFN_PID"));
			model.setScreenCount(rs.getShort("SCREEN_COUNT"));
			model.setWidth(rs.getInt("WIDTH"));
			model.setHeight(rs.getInt("HEIGHT"));
			model.setHasKeyboard(rs.getBoolean("HAS_KEYBOARD"));
			model.setTouchScreen(rs.getBoolean("TOUCH_SCREEN"));
			model.setAutoRotate(rs.getBoolean("AUTO_ROTATE"));
			model.setHasInternet(rs.getBoolean("HAS_INTERNET"));
			model.setHasServer(rs.getBoolean("HAS_SERVER"));
			model.setReminder(rs.getShort("REMINDER"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
			model.setShow(rs.getBoolean("SHOW"));
		}
		return this;
	}

	public boolean getAutoRotate() {
		return this.AutoRotate;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public short getDisplayOrder() {
		return this.DisplayOrder;
	}

	public int getDisplayTypeDefnPid() {
		return this.DisplayTypeDefnPid;
	}

	public boolean getHasInternet() {
		return this.HasInternet;
	}

	public boolean getHasKeyboard() {
		return this.HasKeyboard;
	}

	public boolean getHasServer() {
		return this.HasServer;
	}

	public int getHeight() {
		return this.Height;
	}

	public boolean getIsDefault() {
		return this.IsDefault;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getReminder() {
		return this.Reminder;
	}

	public short getScreenCount() {
		return this.ScreenCount;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public boolean getShow() {
		return this.Show;
	}

	public boolean getTouchScreen() {
		return this.TouchScreen;
	}

	public int getWidth() {
		return this.Width;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((DisplayTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((DisplayTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((DisplayTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((DisplayTypeDefns) model).setDisplayTypeDefnPid(rs.getInt("DISPLAY_TYPE_DEFN_PID"));
		((DisplayTypeDefns) model).setScreenCount(rs.getShort("SCREEN_COUNT"));
		((DisplayTypeDefns) model).setWidth(rs.getInt("WIDTH"));
		((DisplayTypeDefns) model).setHeight(rs.getInt("HEIGHT"));
		((DisplayTypeDefns) model).setHasKeyboard(rs.getBoolean("HAS_KEYBOARD"));
		((DisplayTypeDefns) model).setTouchScreen(rs.getBoolean("TOUCH_SCREEN"));
		((DisplayTypeDefns) model).setAutoRotate(rs.getBoolean("AUTO_ROTATE"));
		((DisplayTypeDefns) model).setHasInternet(rs.getBoolean("HAS_INTERNET"));
		((DisplayTypeDefns) model).setHasServer(rs.getBoolean("HAS_SERVER"));
		((DisplayTypeDefns) model).setReminder(rs.getShort("REMINDER"));
		((DisplayTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((DisplayTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((DisplayTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((DisplayTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((DisplayTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((DisplayTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((DisplayTypeDefns) model).setDisplayTypeDefnPid(rs.getInt("DISPLAY_TYPE_DEFN_PID"));
		((DisplayTypeDefns) model).setScreenCount(rs.getShort("SCREEN_COUNT"));
		((DisplayTypeDefns) model).setWidth(rs.getInt("WIDTH"));
		((DisplayTypeDefns) model).setHeight(rs.getInt("HEIGHT"));
		((DisplayTypeDefns) model).setHasKeyboard(rs.getBoolean("HAS_KEYBOARD"));
		((DisplayTypeDefns) model).setTouchScreen(rs.getBoolean("TOUCH_SCREEN"));
		((DisplayTypeDefns) model).setAutoRotate(rs.getBoolean("AUTO_ROTATE"));
		((DisplayTypeDefns) model).setHasInternet(rs.getBoolean("HAS_INTERNET"));
		((DisplayTypeDefns) model).setHasServer(rs.getBoolean("HAS_SERVER"));
		((DisplayTypeDefns) model).setReminder(rs.getShort("REMINDER"));
		((DisplayTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((DisplayTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((DisplayTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	public void setAutoRotate(boolean AutoRotate) {
		this.AutoRotate = AutoRotate;
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setDisplayTypeDefnPid(int DisplayTypeDefnPid) {
		this.DisplayTypeDefnPid = DisplayTypeDefnPid;
	}

	public void setHasInternet(boolean HasInternet) {
		this.HasInternet = HasInternet;
	}

	public void setHasKeyboard(boolean HasKeyboard) {
		this.HasKeyboard = HasKeyboard;
	}

	public void setHasServer(boolean HasServer) {
		this.HasServer = HasServer;
	}

	public void setHeight(int Height) {
		this.Height = Height;
	}

	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setReminder(short Reminder) {
		this.Reminder = Reminder;
	}

	public void setScreenCount(short ScreenCount) {
		this.ScreenCount = ScreenCount;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setShow(boolean Show) {
		this.Show = Show;
	}

	public void setTouchScreen(boolean TouchScreen) {
		this.TouchScreen = TouchScreen;
	}

	public void setWidth(int Width) {
		this.Width = Width;
	}

}
