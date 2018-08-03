package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SUBSTN_COMMON_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SubstnCommonDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSTN_COMMON_DEFN_PID, " + "IS_SYSTEM, " + "IS_DATA_RETRIEVAL, " + "IS_VALUE_COMPARE, "
			+ "TOP_STEP_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "SHOW FROM PUBLIC.SUBSTN_COMMON_DEFNS WHERE SUBSTN_COMMON_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSTN_COMMON_DEFN_PID, " + "IS_SYSTEM, " + "IS_DATA_RETRIEVAL, " + "IS_VALUE_COMPARE, "
			+ "TOP_STEP_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "SHOW FROM PUBLIC.SUBSTN_COMMON_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_COMMON_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SUBSTN_COMMON_DEFN_PID, " + "IS_SYSTEM, " + "IS_DATA_RETRIEVAL, " + "IS_VALUE_COMPARE, "
			+ "TOP_STEP_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_COMMON_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "IS_DATA_RETRIEVAL = ?, " + "IS_VALUE_COMPARE = ?, "
			+ "TOP_STEP_KEY = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, "
			+ "SHOW = ? WHERE SUBSTN_COMMON_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_COMMON_DEFNS WHERE SUBSTN_COMMON_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_COMMON_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SubstnCommonDefnPid;
	private boolean IsSystem;
	private boolean IsDataRetrieval;
	private boolean IsValueCompare;
	private short TopStepKey;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean Show;
	private SubstnCommonDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SubstnCommonDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param SubstnCommonDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SubstnCommonDefns(int SubstnCommonDefnPid) throws SQLException {
		super();
		this.SubstnCommonDefnPid = SubstnCommonDefnPid;
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
			model = new SubstnCommonDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSubstnCommonDefnPid(rs.getInt("SUBSTN_COMMON_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setIsDataRetrieval(rs.getBoolean("IS_DATA_RETRIEVAL"));
			model.setIsValueCompare(rs.getBoolean("IS_VALUE_COMPARE"));
			model.setTopStepKey(rs.getShort("TOP_STEP_KEY"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
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
			model.setSubstnCommonDefnPid(rs.getInt("SUBSTN_COMMON_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setIsDataRetrieval(rs.getBoolean("IS_DATA_RETRIEVAL"));
			model.setIsValueCompare(rs.getBoolean("IS_VALUE_COMPARE"));
			model.setTopStepKey(rs.getShort("TOP_STEP_KEY"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
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
	 * Get the IsDataRetrieval field.
	 *
	 * @return Contents of the IS_DATA_RETRIEVAL column
	 */
	public boolean getIsDataRetrieval() {
		return this.IsDataRetrieval;
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
	 * Get the IsValueCompare field.
	 *
	 * @return Contents of the IS_VALUE_COMPARE column
	 */
	public boolean getIsValueCompare() {
		return this.IsValueCompare;
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
	 * Get the SubstnCommonDefnPid field.
	 *
	 * @return Contents of the SUBSTN_COMMON_DEFN_PID column
	 */
	public int getSubstnCommonDefnPid() {
		return this.SubstnCommonDefnPid;
	}

	/**
	 * Get the TopStepKey field.
	 *
	 * @return Contents of the TOP_STEP_KEY column
	 */
	public short getTopStepKey() {
		return this.TopStepKey;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((SubstnCommonDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubstnCommonDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubstnCommonDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubstnCommonDefns) model).setSubstnCommonDefnPid(rs.getInt("SUBSTN_COMMON_DEFN_PID"));
		((SubstnCommonDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubstnCommonDefns) model).setIsDataRetrieval(rs.getBoolean("IS_DATA_RETRIEVAL"));
		((SubstnCommonDefns) model).setIsValueCompare(rs.getBoolean("IS_VALUE_COMPARE"));
		((SubstnCommonDefns) model).setTopStepKey(rs.getShort("TOP_STEP_KEY"));
		((SubstnCommonDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubstnCommonDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubstnCommonDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SubstnCommonDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubstnCommonDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubstnCommonDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubstnCommonDefns) model).setSubstnCommonDefnPid(rs.getInt("SUBSTN_COMMON_DEFN_PID"));
		((SubstnCommonDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubstnCommonDefns) model).setIsDataRetrieval(rs.getBoolean("IS_DATA_RETRIEVAL"));
		((SubstnCommonDefns) model).setIsValueCompare(rs.getBoolean("IS_VALUE_COMPARE"));
		((SubstnCommonDefns) model).setTopStepKey(rs.getShort("TOP_STEP_KEY"));
		((SubstnCommonDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubstnCommonDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubstnCommonDefns) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the IsDataRetrieval field
	 *
	 * @param IsDataRetrieval
	 *            Contents of the IS_DATA_RETRIEVAL column
	 */
	public void setIsDataRetrieval(boolean IsDataRetrieval) {
		this.IsDataRetrieval = IsDataRetrieval;
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
	 * Set the IsValueCompare field
	 *
	 * @param IsValueCompare
	 *            Contents of the IS_VALUE_COMPARE column
	 */
	public void setIsValueCompare(boolean IsValueCompare) {
		this.IsValueCompare = IsValueCompare;
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
	 * Set the SubstnCommonDefnPid field
	 *
	 * @param SubstnCommonDefnPid
	 *            Contents of the SUBSTN_COMMON_DEFN_PID column
	 */
	public void setSubstnCommonDefnPid(int SubstnCommonDefnPid) {
		this.SubstnCommonDefnPid = SubstnCommonDefnPid;
	}

	/**
	 * Set the TopStepKey field
	 *
	 * @param TopStepKey
	 *            Contents of the TOP_STEP_KEY column
	 */
	public void setTopStepKey(short TopStepKey) {
		this.TopStepKey = TopStepKey;
	}

}
