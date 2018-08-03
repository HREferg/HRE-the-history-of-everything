package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SUBSTN_PARAM_LISTS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SubstnParamLists extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSTN_PARAM_LIST_PID, " + "IS_SYSTEM, " + "PARAM_SET_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "SHOW FROM PUBLIC.SUBSTN_PARAM_LISTS WHERE SUBSTN_PARAM_LIST_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSTN_PARAM_LIST_PID, " + "IS_SYSTEM, " + "PARAM_SET_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "SHOW FROM PUBLIC.SUBSTN_PARAM_LISTS";

	private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_PARAM_LISTS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SUBSTN_PARAM_LIST_PID, " + "IS_SYSTEM, " + "PARAM_SET_KEY, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_PARAM_LISTSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PARAM_SET_KEY = ?, " + "REMINDER_KEY = ?, "
			+ "DISPLAY_ORDER = ?, " + "SHOW = ? WHERE SUBSTN_PARAM_LIST_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_PARAM_LISTS WHERE SUBSTN_PARAM_LIST_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_PARAM_LISTS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SubstnParamListPid;
	private boolean IsSystem;
	private short ParamSetKey;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean Show;
	private SubstnParamLists model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SubstnParamLists() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param SubstnParamListPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SubstnParamLists(int SubstnParamListPid) throws SQLException {
		super();
		this.SubstnParamListPid = SubstnParamListPid;
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
			model = new SubstnParamLists();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSubstnParamListPid(rs.getInt("SUBSTN_PARAM_LIST_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParamSetKey(rs.getShort("PARAM_SET_KEY"));
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
			model.setSubstnParamListPid(rs.getInt("SUBSTN_PARAM_LIST_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParamSetKey(rs.getShort("PARAM_SET_KEY"));
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
	 * Get the IsSystem field.
	 *
	 * @return Contents of the IS_SYSTEM column
	 */
	public boolean getIsSystem() {
		return this.IsSystem;
	}

	/**
	 * Get the ParamSetKey field.
	 *
	 * @return Contents of the PARAM_SET_KEY column
	 */
	public short getParamSetKey() {
		return this.ParamSetKey;
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
	 * Get the SubstnParamListPid field.
	 *
	 * @return Contents of the SUBSTN_PARAM_LIST_PID column
	 */
	public int getSubstnParamListPid() {
		return this.SubstnParamListPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((SubstnParamLists) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubstnParamLists) model).setSetKey(rs.getShort("SET_KEY"));
		((SubstnParamLists) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubstnParamLists) model).setSubstnParamListPid(rs.getInt("SUBSTN_PARAM_LIST_PID"));
		((SubstnParamLists) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubstnParamLists) model).setParamSetKey(rs.getShort("PARAM_SET_KEY"));
		((SubstnParamLists) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubstnParamLists) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubstnParamLists) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SubstnParamLists) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubstnParamLists) model).setSetKey(rs.getShort("SET_KEY"));
		((SubstnParamLists) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubstnParamLists) model).setSubstnParamListPid(rs.getInt("SUBSTN_PARAM_LIST_PID"));
		((SubstnParamLists) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubstnParamLists) model).setParamSetKey(rs.getShort("PARAM_SET_KEY"));
		((SubstnParamLists) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubstnParamLists) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubstnParamLists) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the IsSystem field
	 *
	 * @param IsSystem
	 *            Contents of the IS_SYSTEM column
	 */
	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	/**
	 * Set the ParamSetKey field
	 *
	 * @param ParamSetKey
	 *            Contents of the PARAM_SET_KEY column
	 */
	public void setParamSetKey(short ParamSetKey) {
		this.ParamSetKey = ParamSetKey;
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
	 * Set the SubstnParamListPid field
	 *
	 * @param SubstnParamListPid
	 *            Contents of the SUBSTN_PARAM_LIST_PID column
	 */
	public void setSubstnParamListPid(int SubstnParamListPid) {
		this.SubstnParamListPid = SubstnParamListPid;
	}

}
