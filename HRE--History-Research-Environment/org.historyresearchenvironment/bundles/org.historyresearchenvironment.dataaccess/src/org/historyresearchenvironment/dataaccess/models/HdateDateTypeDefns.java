package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the HDATE_DATE_TYPE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class HdateDateTypeDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "HDATE_DATE_TYPE_DEFN_PID, " + "ORIGINAL_CALENDAR_KEY, " + "WHEN_WRITTEN, " + "WHERE_WRITTEN_PID, "
			+ "CAL_CHNG_START_YEAR, " + "CAL_CHNG_START_DAY, " + "CAL_CHNG_END_YEAR, " + "CAL_CHNG_END_DAY, "
			+ "DAYS_LOST, " + "USED_OLD_STYLE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.HDATE_DATE_TYPE_DEFNS WHERE HDATE_DATE_TYPE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "HDATE_DATE_TYPE_DEFN_PID, " + "ORIGINAL_CALENDAR_KEY, " + "WHEN_WRITTEN, " + "WHERE_WRITTEN_PID, "
			+ "CAL_CHNG_START_YEAR, " + "CAL_CHNG_START_DAY, " + "CAL_CHNG_END_YEAR, " + "CAL_CHNG_END_DAY, "
			+ "DAYS_LOST, " + "USED_OLD_STYLE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.HDATE_DATE_TYPE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.HDATE_DATE_TYPE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "HDATE_DATE_TYPE_DEFN_PID, " + "ORIGINAL_CALENDAR_KEY, " + "WHEN_WRITTEN, "
			+ "WHERE_WRITTEN_PID, " + "CAL_CHNG_START_YEAR, " + "CAL_CHNG_START_DAY, " + "CAL_CHNG_END_YEAR, "
			+ "CAL_CHNG_END_DAY, " + "DAYS_LOST, " + "USED_OLD_STYLE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.HDATE_DATE_TYPE_DEFNSSET " + "RECORD_NUM = ?, "
			+ "SET_KEY = ?, " + "COMMIT_PID = ?, " + "ORIGINAL_CALENDAR_KEY = ?, " + "WHEN_WRITTEN = ?, "
			+ "WHERE_WRITTEN_PID = ?, " + "CAL_CHNG_START_YEAR = ?, " + "CAL_CHNG_START_DAY = ?, "
			+ "CAL_CHNG_END_YEAR = ?, " + "CAL_CHNG_END_DAY = ?, " + "DAYS_LOST = ?, " + "USED_OLD_STYLE = ?, "
			+ "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE HDATE_DATE_TYPE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.HDATE_DATE_TYPE_DEFNS WHERE HDATE_DATE_TYPE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.HDATE_DATE_TYPE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int HdateDateTypeDefnPid;
	private short OriginalCalendarKey;
	private short WhenWritten;
	private int WhereWrittenPid;
	private short CalChngStartYear;
	private short CalChngStartDay;
	private short CalChngEndYear;
	private short CalChngEndDay;
	private short DaysLost;
	private boolean UsedOldStyle;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private HdateDateTypeDefns model;

	public HdateDateTypeDefns() throws SQLException {
	}

	public HdateDateTypeDefns(int HdateDateTypeDefnPid) throws SQLException {
		super();
		this.HdateDateTypeDefnPid = HdateDateTypeDefnPid;
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
			model = new HdateDateTypeDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setHdateDateTypeDefnPid(rs.getInt("HDATE_DATE_TYPE_DEFN_PID"));
			model.setOriginalCalendarKey(rs.getShort("ORIGINAL_CALENDAR_KEY"));
			model.setWhenWritten(rs.getShort("WHEN_WRITTEN"));
			model.setWhereWrittenPid(rs.getInt("WHERE_WRITTEN_PID"));
			model.setCalChngStartYear(rs.getShort("CAL_CHNG_START_YEAR"));
			model.setCalChngStartDay(rs.getShort("CAL_CHNG_START_DAY"));
			model.setCalChngEndYear(rs.getShort("CAL_CHNG_END_YEAR"));
			model.setCalChngEndDay(rs.getShort("CAL_CHNG_END_DAY"));
			model.setDaysLost(rs.getShort("DAYS_LOST"));
			model.setUsedOldStyle(rs.getBoolean("USED_OLD_STYLE"));
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
			model.setHdateDateTypeDefnPid(rs.getInt("HDATE_DATE_TYPE_DEFN_PID"));
			model.setOriginalCalendarKey(rs.getShort("ORIGINAL_CALENDAR_KEY"));
			model.setWhenWritten(rs.getShort("WHEN_WRITTEN"));
			model.setWhereWrittenPid(rs.getInt("WHERE_WRITTEN_PID"));
			model.setCalChngStartYear(rs.getShort("CAL_CHNG_START_YEAR"));
			model.setCalChngStartDay(rs.getShort("CAL_CHNG_START_DAY"));
			model.setCalChngEndYear(rs.getShort("CAL_CHNG_END_YEAR"));
			model.setCalChngEndDay(rs.getShort("CAL_CHNG_END_DAY"));
			model.setDaysLost(rs.getShort("DAYS_LOST"));
			model.setUsedOldStyle(rs.getBoolean("USED_OLD_STYLE"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
			model.setShow(rs.getBoolean("SHOW"));
		}
		return this;
	}

	public short getCalChngEndDay() {
		return this.CalChngEndDay;
	}

	public short getCalChngEndYear() {
		return this.CalChngEndYear;
	}

	public short getCalChngStartDay() {
		return this.CalChngStartDay;
	}

	public short getCalChngStartYear() {
		return this.CalChngStartYear;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public short getDaysLost() {
		return this.DaysLost;
	}

	public short getDisplayOrder() {
		return this.DisplayOrder;
	}

	public int getHdateDateTypeDefnPid() {
		return this.HdateDateTypeDefnPid;
	}

	public boolean getIsDefault() {
		return this.IsDefault;
	}

	public short getOriginalCalendarKey() {
		return this.OriginalCalendarKey;
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

	public boolean getUsedOldStyle() {
		return this.UsedOldStyle;
	}

	public short getWhenWritten() {
		return this.WhenWritten;
	}

	public int getWhereWrittenPid() {
		return this.WhereWrittenPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((HdateDateTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((HdateDateTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((HdateDateTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((HdateDateTypeDefns) model).setHdateDateTypeDefnPid(rs.getInt("HDATE_DATE_TYPE_DEFN_PID"));
		((HdateDateTypeDefns) model).setOriginalCalendarKey(rs.getShort("ORIGINAL_CALENDAR_KEY"));
		((HdateDateTypeDefns) model).setWhenWritten(rs.getShort("WHEN_WRITTEN"));
		((HdateDateTypeDefns) model).setWhereWrittenPid(rs.getInt("WHERE_WRITTEN_PID"));
		((HdateDateTypeDefns) model).setCalChngStartYear(rs.getShort("CAL_CHNG_START_YEAR"));
		((HdateDateTypeDefns) model).setCalChngStartDay(rs.getShort("CAL_CHNG_START_DAY"));
		((HdateDateTypeDefns) model).setCalChngEndYear(rs.getShort("CAL_CHNG_END_YEAR"));
		((HdateDateTypeDefns) model).setCalChngEndDay(rs.getShort("CAL_CHNG_END_DAY"));
		((HdateDateTypeDefns) model).setDaysLost(rs.getShort("DAYS_LOST"));
		((HdateDateTypeDefns) model).setUsedOldStyle(rs.getBoolean("USED_OLD_STYLE"));
		((HdateDateTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((HdateDateTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((HdateDateTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((HdateDateTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((HdateDateTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((HdateDateTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((HdateDateTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((HdateDateTypeDefns) model).setHdateDateTypeDefnPid(rs.getInt("HDATE_DATE_TYPE_DEFN_PID"));
		((HdateDateTypeDefns) model).setOriginalCalendarKey(rs.getShort("ORIGINAL_CALENDAR_KEY"));
		((HdateDateTypeDefns) model).setWhenWritten(rs.getShort("WHEN_WRITTEN"));
		((HdateDateTypeDefns) model).setWhereWrittenPid(rs.getInt("WHERE_WRITTEN_PID"));
		((HdateDateTypeDefns) model).setCalChngStartYear(rs.getShort("CAL_CHNG_START_YEAR"));
		((HdateDateTypeDefns) model).setCalChngStartDay(rs.getShort("CAL_CHNG_START_DAY"));
		((HdateDateTypeDefns) model).setCalChngEndYear(rs.getShort("CAL_CHNG_END_YEAR"));
		((HdateDateTypeDefns) model).setCalChngEndDay(rs.getShort("CAL_CHNG_END_DAY"));
		((HdateDateTypeDefns) model).setDaysLost(rs.getShort("DAYS_LOST"));
		((HdateDateTypeDefns) model).setUsedOldStyle(rs.getBoolean("USED_OLD_STYLE"));
		((HdateDateTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((HdateDateTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((HdateDateTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((HdateDateTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	public void setCalChngEndDay(short CalChngEndDay) {
		this.CalChngEndDay = CalChngEndDay;
	}

	public void setCalChngEndYear(short CalChngEndYear) {
		this.CalChngEndYear = CalChngEndYear;
	}

	public void setCalChngStartDay(short CalChngStartDay) {
		this.CalChngStartDay = CalChngStartDay;
	}

	public void setCalChngStartYear(short CalChngStartYear) {
		this.CalChngStartYear = CalChngStartYear;
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDaysLost(short DaysLost) {
		this.DaysLost = DaysLost;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setHdateDateTypeDefnPid(int HdateDateTypeDefnPid) {
		this.HdateDateTypeDefnPid = HdateDateTypeDefnPid;
	}

	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
	}

	public void setOriginalCalendarKey(short OriginalCalendarKey) {
		this.OriginalCalendarKey = OriginalCalendarKey;
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

	public void setUsedOldStyle(boolean UsedOldStyle) {
		this.UsedOldStyle = UsedOldStyle;
	}

	public void setWhenWritten(short WhenWritten) {
		this.WhenWritten = WhenWritten;
	}

	public void setWhereWrittenPid(int WhereWrittenPid) {
		this.WhereWrittenPid = WhereWrittenPid;
	}

}
