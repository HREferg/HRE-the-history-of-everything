package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the HINTERVAL_INTERVAL_TYPE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class HintervalIntervalTypeDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "HINTERVAL_INTERVAL_TYPE_DEFN_PID, " + "ORIGINAL_CALENDAR_KEY, " + "WHEN_WRITTEN, "
			+ "WHERE_WRITTEN_PID, " + "CAL_CHNG_START_YEAR, " + "CAL_CHNG_START_DAY, " + "CAL_CHNG_END_YEAR, "
			+ "CAL_CHNG_END_DAY, " + "DAYS_LOST, " + "USED_OLD_STYLE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.HINTERVAL_INTERVAL_TYPE_DEFNS WHERE HINTERVAL_INTERVAL_TYPE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "HINTERVAL_INTERVAL_TYPE_DEFN_PID, " + "ORIGINAL_CALENDAR_KEY, " + "WHEN_WRITTEN, "
			+ "WHERE_WRITTEN_PID, " + "CAL_CHNG_START_YEAR, " + "CAL_CHNG_START_DAY, " + "CAL_CHNG_END_YEAR, "
			+ "CAL_CHNG_END_DAY, " + "DAYS_LOST, " + "USED_OLD_STYLE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW FROM PUBLIC.HINTERVAL_INTERVAL_TYPE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.HINTERVAL_INTERVAL_TYPE_DEFNS( " + "RECORD_NUM, "
			+ "SET_KEY, " + "COMMIT_PID, " + "HINTERVAL_INTERVAL_TYPE_DEFN_PID, " + "ORIGINAL_CALENDAR_KEY, "
			+ "WHEN_WRITTEN, " + "WHERE_WRITTEN_PID, " + "CAL_CHNG_START_YEAR, " + "CAL_CHNG_START_DAY, "
			+ "CAL_CHNG_END_YEAR, " + "CAL_CHNG_END_DAY, " + "DAYS_LOST, " + "USED_OLD_STYLE, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.HINTERVAL_INTERVAL_TYPE_DEFNSSET " + "RECORD_NUM = ?, "
			+ "SET_KEY = ?, " + "COMMIT_PID = ?, " + "ORIGINAL_CALENDAR_KEY = ?, " + "WHEN_WRITTEN = ?, "
			+ "WHERE_WRITTEN_PID = ?, " + "CAL_CHNG_START_YEAR = ?, " + "CAL_CHNG_START_DAY = ?, "
			+ "CAL_CHNG_END_YEAR = ?, " + "CAL_CHNG_END_DAY = ?, " + "DAYS_LOST = ?, " + "USED_OLD_STYLE = ?, "
			+ "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE HINTERVAL_INTERVAL_TYPE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.HINTERVAL_INTERVAL_TYPE_DEFNS WHERE HINTERVAL_INTERVAL_TYPE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.HINTERVAL_INTERVAL_TYPE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int HintervalIntervalTypeDefnPid;
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
	private HintervalIntervalTypeDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public HintervalIntervalTypeDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param HintervalIntervalTypeDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public HintervalIntervalTypeDefns(int HintervalIntervalTypeDefnPid) throws SQLException {
		super();
		this.HintervalIntervalTypeDefnPid = HintervalIntervalTypeDefnPid;
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
			model = new HintervalIntervalTypeDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setHintervalIntervalTypeDefnPid(rs.getInt("HINTERVAL_INTERVAL_TYPE_DEFN_PID"));
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
			model.setHintervalIntervalTypeDefnPid(rs.getInt("HINTERVAL_INTERVAL_TYPE_DEFN_PID"));
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

	/**
	 * Get the CalChngEndDay field.
	 *
	 * @return Contents of the CAL_CHNG_END_DAY column
	 */
	public short getCalChngEndDay() {
		return this.CalChngEndDay;
	}

	/**
	 * Get the CalChngEndYear field.
	 *
	 * @return Contents of the CAL_CHNG_END_YEAR column
	 */
	public short getCalChngEndYear() {
		return this.CalChngEndYear;
	}

	/**
	 * Get the CalChngStartDay field.
	 *
	 * @return Contents of the CAL_CHNG_START_DAY column
	 */
	public short getCalChngStartDay() {
		return this.CalChngStartDay;
	}

	/**
	 * Get the CalChngStartYear field.
	 *
	 * @return Contents of the CAL_CHNG_START_YEAR column
	 */
	public short getCalChngStartYear() {
		return this.CalChngStartYear;
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
	 * Get the DaysLost field.
	 *
	 * @return Contents of the DAYS_LOST column
	 */
	public short getDaysLost() {
		return this.DaysLost;
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
	 * Get the HintervalIntervalTypeDefnPid field.
	 *
	 * @return Contents of the HINTERVAL_INTERVAL_TYPE_DEFN_PID column
	 */
	public int getHintervalIntervalTypeDefnPid() {
		return this.HintervalIntervalTypeDefnPid;
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
	 * Get the OriginalCalendarKey field.
	 *
	 * @return Contents of the ORIGINAL_CALENDAR_KEY column
	 */
	public short getOriginalCalendarKey() {
		return this.OriginalCalendarKey;
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
	 * Get the UsedOldStyle field.
	 *
	 * @return Contents of the USED_OLD_STYLE column
	 */
	public boolean getUsedOldStyle() {
		return this.UsedOldStyle;
	}

	/**
	 * Get the WhenWritten field.
	 *
	 * @return Contents of the WHEN_WRITTEN column
	 */
	public short getWhenWritten() {
		return this.WhenWritten;
	}

	/**
	 * Get the WhereWrittenPid field.
	 *
	 * @return Contents of the WHERE_WRITTEN_PID column
	 */
	public int getWhereWrittenPid() {
		return this.WhereWrittenPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((HintervalIntervalTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((HintervalIntervalTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((HintervalIntervalTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((HintervalIntervalTypeDefns) model)
				.setHintervalIntervalTypeDefnPid(rs.getInt("HINTERVAL_INTERVAL_TYPE_DEFN_PID"));
		((HintervalIntervalTypeDefns) model).setOriginalCalendarKey(rs.getShort("ORIGINAL_CALENDAR_KEY"));
		((HintervalIntervalTypeDefns) model).setWhenWritten(rs.getShort("WHEN_WRITTEN"));
		((HintervalIntervalTypeDefns) model).setWhereWrittenPid(rs.getInt("WHERE_WRITTEN_PID"));
		((HintervalIntervalTypeDefns) model).setCalChngStartYear(rs.getShort("CAL_CHNG_START_YEAR"));
		((HintervalIntervalTypeDefns) model).setCalChngStartDay(rs.getShort("CAL_CHNG_START_DAY"));
		((HintervalIntervalTypeDefns) model).setCalChngEndYear(rs.getShort("CAL_CHNG_END_YEAR"));
		((HintervalIntervalTypeDefns) model).setCalChngEndDay(rs.getShort("CAL_CHNG_END_DAY"));
		((HintervalIntervalTypeDefns) model).setDaysLost(rs.getShort("DAYS_LOST"));
		((HintervalIntervalTypeDefns) model).setUsedOldStyle(rs.getBoolean("USED_OLD_STYLE"));
		((HintervalIntervalTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((HintervalIntervalTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((HintervalIntervalTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((HintervalIntervalTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((HintervalIntervalTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((HintervalIntervalTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((HintervalIntervalTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((HintervalIntervalTypeDefns) model)
				.setHintervalIntervalTypeDefnPid(rs.getInt("HINTERVAL_INTERVAL_TYPE_DEFN_PID"));
		((HintervalIntervalTypeDefns) model).setOriginalCalendarKey(rs.getShort("ORIGINAL_CALENDAR_KEY"));
		((HintervalIntervalTypeDefns) model).setWhenWritten(rs.getShort("WHEN_WRITTEN"));
		((HintervalIntervalTypeDefns) model).setWhereWrittenPid(rs.getInt("WHERE_WRITTEN_PID"));
		((HintervalIntervalTypeDefns) model).setCalChngStartYear(rs.getShort("CAL_CHNG_START_YEAR"));
		((HintervalIntervalTypeDefns) model).setCalChngStartDay(rs.getShort("CAL_CHNG_START_DAY"));
		((HintervalIntervalTypeDefns) model).setCalChngEndYear(rs.getShort("CAL_CHNG_END_YEAR"));
		((HintervalIntervalTypeDefns) model).setCalChngEndDay(rs.getShort("CAL_CHNG_END_DAY"));
		((HintervalIntervalTypeDefns) model).setDaysLost(rs.getShort("DAYS_LOST"));
		((HintervalIntervalTypeDefns) model).setUsedOldStyle(rs.getBoolean("USED_OLD_STYLE"));
		((HintervalIntervalTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((HintervalIntervalTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((HintervalIntervalTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((HintervalIntervalTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	/**
	 * Set the CalChngEndDay field
	 *
	 * @param CalChngEndDay
	 *            Contents of the CAL_CHNG_END_DAY column
	 */
	public void setCalChngEndDay(short CalChngEndDay) {
		this.CalChngEndDay = CalChngEndDay;
	}

	/**
	 * Set the CalChngEndYear field
	 *
	 * @param CalChngEndYear
	 *            Contents of the CAL_CHNG_END_YEAR column
	 */
	public void setCalChngEndYear(short CalChngEndYear) {
		this.CalChngEndYear = CalChngEndYear;
	}

	/**
	 * Set the CalChngStartDay field
	 *
	 * @param CalChngStartDay
	 *            Contents of the CAL_CHNG_START_DAY column
	 */
	public void setCalChngStartDay(short CalChngStartDay) {
		this.CalChngStartDay = CalChngStartDay;
	}

	/**
	 * Set the CalChngStartYear field
	 *
	 * @param CalChngStartYear
	 *            Contents of the CAL_CHNG_START_YEAR column
	 */
	public void setCalChngStartYear(short CalChngStartYear) {
		this.CalChngStartYear = CalChngStartYear;
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
	 * Set the DaysLost field
	 *
	 * @param DaysLost
	 *            Contents of the DAYS_LOST column
	 */
	public void setDaysLost(short DaysLost) {
		this.DaysLost = DaysLost;
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
	 * Set the HintervalIntervalTypeDefnPid field
	 *
	 * @param HintervalIntervalTypeDefnPid
	 *            Contents of the HINTERVAL_INTERVAL_TYPE_DEFN_PID column
	 */
	public void setHintervalIntervalTypeDefnPid(int HintervalIntervalTypeDefnPid) {
		this.HintervalIntervalTypeDefnPid = HintervalIntervalTypeDefnPid;
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
	 * Set the OriginalCalendarKey field
	 *
	 * @param OriginalCalendarKey
	 *            Contents of the ORIGINAL_CALENDAR_KEY column
	 */
	public void setOriginalCalendarKey(short OriginalCalendarKey) {
		this.OriginalCalendarKey = OriginalCalendarKey;
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
	 * Set the UsedOldStyle field
	 *
	 * @param UsedOldStyle
	 *            Contents of the USED_OLD_STYLE column
	 */
	public void setUsedOldStyle(boolean UsedOldStyle) {
		this.UsedOldStyle = UsedOldStyle;
	}

	/**
	 * Set the WhenWritten field
	 *
	 * @param WhenWritten
	 *            Contents of the WHEN_WRITTEN column
	 */
	public void setWhenWritten(short WhenWritten) {
		this.WhenWritten = WhenWritten;
	}

	/**
	 * Set the WhereWrittenPid field
	 *
	 * @param WhereWrittenPid
	 *            Contents of the WHERE_WRITTEN_PID column
	 */
	public void setWhereWrittenPid(int WhereWrittenPid) {
		this.WhereWrittenPid = WhereWrittenPid;
	}

}
