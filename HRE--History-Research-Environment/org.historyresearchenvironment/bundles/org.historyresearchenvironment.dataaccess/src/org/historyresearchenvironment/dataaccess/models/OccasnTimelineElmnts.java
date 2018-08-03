package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the OCCASN_TIMELINE_ELMNTS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class OccasnTimelineElmnts extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_TIMELINE_ELMNT_PID, " + "IS_SYSTEM, " + "TIMELINE_PID, " + "OCCASN_PID, " + "SUB_TYPE_KEY, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.OCCASN_TIMELINE_ELMNTS WHERE OCCASN_TIMELINE_ELMNT_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_TIMELINE_ELMNT_PID, " + "IS_SYSTEM, " + "TIMELINE_PID, " + "OCCASN_PID, " + "SUB_TYPE_KEY, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.OCCASN_TIMELINE_ELMNTS";

	private static final String INSERT = "INSERT INTO PUBLIC.OCCASN_TIMELINE_ELMNTS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "OCCASN_TIMELINE_ELMNT_PID, " + "IS_SYSTEM, " + "TIMELINE_PID, " + "OCCASN_PID, "
			+ "SUB_TYPE_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.OCCASN_TIMELINE_ELMNTSSET " + "RECORD_NUM = ?, "
			+ "SET_KEY = ?, " + "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "TIMELINE_PID = ?, " + "OCCASN_PID = ?, "
			+ "SUB_TYPE_KEY = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE OCCASN_TIMELINE_ELMNT_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.OCCASN_TIMELINE_ELMNTS WHERE OCCASN_TIMELINE_ELMNT_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASN_TIMELINE_ELMNTS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int OccasnTimelineElmntPid;
	private boolean IsSystem;
	private short TimelinePid;
	private int OccasnPid;
	private short SubTypeKey;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private OccasnTimelineElmnts model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public OccasnTimelineElmnts() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param OccasnTimelineElmntPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public OccasnTimelineElmnts(int OccasnTimelineElmntPid) throws SQLException {
		super();
		this.OccasnTimelineElmntPid = OccasnTimelineElmntPid;
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
			model = new OccasnTimelineElmnts();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setOccasnTimelineElmntPid(rs.getInt("OCCASN_TIMELINE_ELMNT_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setTimelinePid(rs.getShort("TIMELINE_PID"));
			model.setOccasnPid(rs.getInt("OCCASN_PID"));
			model.setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
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
			model.setOccasnTimelineElmntPid(rs.getInt("OCCASN_TIMELINE_ELMNT_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setTimelinePid(rs.getShort("TIMELINE_PID"));
			model.setOccasnPid(rs.getInt("OCCASN_PID"));
			model.setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
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
	 * Get the IsDefault field.
	 *
	 * @return Contents of the IS_DEFAULT column
	 */
	public boolean getIsDefault() {
		return this.IsDefault;
	}

	/**
	 * Get the IsSystem field.
	 *
	 * @return Contents of the IS_SYSTEM column
	 */
	public boolean getIsSystem() {
		return this.IsSystem;
	}

	/**
	 * Get the OccasnPid field.
	 *
	 * @return Contents of the OCCASN_PID column
	 */
	public int getOccasnPid() {
		return this.OccasnPid;
	}

	/**
	 * Get the OccasnTimelineElmntPid field.
	 *
	 * @return Contents of the OCCASN_TIMELINE_ELMNT_PID column
	 */
	public int getOccasnTimelineElmntPid() {
		return this.OccasnTimelineElmntPid;
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
	 * Get the SubTypeKey field.
	 *
	 * @return Contents of the SUB_TYPE_KEY column
	 */
	public short getSubTypeKey() {
		return this.SubTypeKey;
	}

	/**
	 * Get the TimelinePid field.
	 *
	 * @return Contents of the TIMELINE_PID column
	 */
	public short getTimelinePid() {
		return this.TimelinePid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((OccasnTimelineElmnts) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((OccasnTimelineElmnts) model).setSetKey(rs.getShort("SET_KEY"));
		((OccasnTimelineElmnts) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((OccasnTimelineElmnts) model).setOccasnTimelineElmntPid(rs.getInt("OCCASN_TIMELINE_ELMNT_PID"));
		((OccasnTimelineElmnts) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((OccasnTimelineElmnts) model).setTimelinePid(rs.getShort("TIMELINE_PID"));
		((OccasnTimelineElmnts) model).setOccasnPid(rs.getInt("OCCASN_PID"));
		((OccasnTimelineElmnts) model).setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
		((OccasnTimelineElmnts) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((OccasnTimelineElmnts) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((OccasnTimelineElmnts) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((OccasnTimelineElmnts) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((OccasnTimelineElmnts) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((OccasnTimelineElmnts) model).setSetKey(rs.getShort("SET_KEY"));
		((OccasnTimelineElmnts) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((OccasnTimelineElmnts) model).setOccasnTimelineElmntPid(rs.getInt("OCCASN_TIMELINE_ELMNT_PID"));
		((OccasnTimelineElmnts) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((OccasnTimelineElmnts) model).setTimelinePid(rs.getShort("TIMELINE_PID"));
		((OccasnTimelineElmnts) model).setOccasnPid(rs.getInt("OCCASN_PID"));
		((OccasnTimelineElmnts) model).setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
		((OccasnTimelineElmnts) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((OccasnTimelineElmnts) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((OccasnTimelineElmnts) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((OccasnTimelineElmnts) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the IsDefault field
	 *
	 * @param IsDefault
	 *            Contents of the IS_DEFAULT column
	 */
	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
	}

	/**
	 * Set the IsSystem field
	 *
	 * @param IsSystem
	 *            Contents of the IS_SYSTEM column
	 */
	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	/**
	 * Set the OccasnPid field
	 *
	 * @param OccasnPid
	 *            Contents of the OCCASN_PID column
	 */
	public void setOccasnPid(int OccasnPid) {
		this.OccasnPid = OccasnPid;
	}

	/**
	 * Set the OccasnTimelineElmntPid field
	 *
	 * @param OccasnTimelineElmntPid
	 *            Contents of the OCCASN_TIMELINE_ELMNT_PID column
	 */
	public void setOccasnTimelineElmntPid(int OccasnTimelineElmntPid) {
		this.OccasnTimelineElmntPid = OccasnTimelineElmntPid;
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
	 * Set the SubTypeKey field
	 *
	 * @param SubTypeKey
	 *            Contents of the SUB_TYPE_KEY column
	 */
	public void setSubTypeKey(short SubTypeKey) {
		this.SubTypeKey = SubTypeKey;
	}

	/**
	 * Set the TimelinePid field
	 *
	 * @param TimelinePid
	 *            Contents of the TIMELINE_PID column
	 */
	public void setTimelinePid(short TimelinePid) {
		this.TimelinePid = TimelinePid;
	}

}
