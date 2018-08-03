package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the HDATE_CALENDAR_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class HdateCalendarDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "HDATE_CALENDAR_DEFN_PID, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.HDATE_CALENDAR_DEFNS WHERE HDATE_CALENDAR_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "HDATE_CALENDAR_DEFN_PID, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.HDATE_CALENDAR_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.HDATE_CALENDAR_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "HDATE_CALENDAR_DEFN_PID, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.HDATE_CALENDAR_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE HDATE_CALENDAR_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.HDATE_CALENDAR_DEFNS WHERE HDATE_CALENDAR_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.HDATE_CALENDAR_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int HdateCalendarDefnPid;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private HdateCalendarDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public HdateCalendarDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param HdateCalendarDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public HdateCalendarDefns(int HdateCalendarDefnPid) throws SQLException {
		super();
		this.HdateCalendarDefnPid = HdateCalendarDefnPid;
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
			model = new HdateCalendarDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setHdateCalendarDefnPid(rs.getInt("HDATE_CALENDAR_DEFN_PID"));
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
			model.setHdateCalendarDefnPid(rs.getInt("HDATE_CALENDAR_DEFN_PID"));
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
	 * Get the HdateCalendarDefnPid field.
	 *
	 * @return Contents of the HDATE_CALENDAR_DEFN_PID column
	 */
	public int getHdateCalendarDefnPid() {
		return this.HdateCalendarDefnPid;
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

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((HdateCalendarDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((HdateCalendarDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((HdateCalendarDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((HdateCalendarDefns) model).setHdateCalendarDefnPid(rs.getInt("HDATE_CALENDAR_DEFN_PID"));
		((HdateCalendarDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((HdateCalendarDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((HdateCalendarDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((HdateCalendarDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((HdateCalendarDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((HdateCalendarDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((HdateCalendarDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((HdateCalendarDefns) model).setHdateCalendarDefnPid(rs.getInt("HDATE_CALENDAR_DEFN_PID"));
		((HdateCalendarDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((HdateCalendarDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((HdateCalendarDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((HdateCalendarDefns) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the HdateCalendarDefnPid field
	 *
	 * @param HdateCalendarDefnPid
	 *            Contents of the HDATE_CALENDAR_DEFN_PID column
	 */
	public void setHdateCalendarDefnPid(int HdateCalendarDefnPid) {
		this.HdateCalendarDefnPid = HdateCalendarDefnPid;
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

}
