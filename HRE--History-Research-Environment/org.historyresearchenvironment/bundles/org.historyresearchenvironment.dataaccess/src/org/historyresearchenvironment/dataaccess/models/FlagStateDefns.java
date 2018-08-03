package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the FLAG_STATE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class FlagStateDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "FLAG_STATE_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_TYPE_KEY, " + "PARENT_SUB_TYPE_KEY, "
			+ "PARENT_FLAG_SLOT, " + "STATE_VALUE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.FLAG_STATE_DEFNS WHERE FLAG_STATE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "FLAG_STATE_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_TYPE_KEY, " + "PARENT_SUB_TYPE_KEY, "
			+ "PARENT_FLAG_SLOT, " + "STATE_VALUE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.FLAG_STATE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.FLAG_STATE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "FLAG_STATE_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_TYPE_KEY, " + "PARENT_SUB_TYPE_KEY, "
			+ "PARENT_FLAG_SLOT, " + "STATE_VALUE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.FLAG_STATE_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PARENT_TYPE_KEY = ?, " + "PARENT_SUB_TYPE_KEY = ?, "
			+ "PARENT_FLAG_SLOT = ?, " + "STATE_VALUE = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, "
			+ "IS_DEFAULT = ?, " + "SHOW = ? WHERE FLAG_STATE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.FLAG_STATE_DEFNS WHERE FLAG_STATE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.FLAG_STATE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int FlagStateDefnPid;
	private boolean IsSystem;
	private short ParentTypeKey;
	private short ParentSubTypeKey;
	private short ParentFlagSlot;
	private short StateValue;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private FlagStateDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public FlagStateDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param FlagStateDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public FlagStateDefns(int FlagStateDefnPid) throws SQLException {
		super();
		this.FlagStateDefnPid = FlagStateDefnPid;
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
			model = new FlagStateDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setFlagStateDefnPid(rs.getInt("FLAG_STATE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setParentFlagSlot(rs.getShort("PARENT_FLAG_SLOT"));
			model.setStateValue(rs.getShort("STATE_VALUE"));
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
			model.setFlagStateDefnPid(rs.getInt("FLAG_STATE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setParentFlagSlot(rs.getShort("PARENT_FLAG_SLOT"));
			model.setStateValue(rs.getShort("STATE_VALUE"));
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
	 * Get the FlagStateDefnPid field.
	 *
	 * @return Contents of the FLAG_STATE_DEFN_PID column
	 */
	public int getFlagStateDefnPid() {
		return this.FlagStateDefnPid;
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
	 * Get the ParentFlagSlot field.
	 *
	 * @return Contents of the PARENT_FLAG_SLOT column
	 */
	public short getParentFlagSlot() {
		return this.ParentFlagSlot;
	}

	/**
	 * Get the ParentSubTypeKey field.
	 *
	 * @return Contents of the PARENT_SUB_TYPE_KEY column
	 */
	public short getParentSubTypeKey() {
		return this.ParentSubTypeKey;
	}

	/**
	 * Get the ParentTypeKey field.
	 *
	 * @return Contents of the PARENT_TYPE_KEY column
	 */
	public short getParentTypeKey() {
		return this.ParentTypeKey;
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
	 * Get the StateValue field.
	 *
	 * @return Contents of the STATE_VALUE column
	 */
	public short getStateValue() {
		return this.StateValue;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((FlagStateDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((FlagStateDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((FlagStateDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((FlagStateDefns) model).setFlagStateDefnPid(rs.getInt("FLAG_STATE_DEFN_PID"));
		((FlagStateDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((FlagStateDefns) model).setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
		((FlagStateDefns) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((FlagStateDefns) model).setParentFlagSlot(rs.getShort("PARENT_FLAG_SLOT"));
		((FlagStateDefns) model).setStateValue(rs.getShort("STATE_VALUE"));
		((FlagStateDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((FlagStateDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((FlagStateDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((FlagStateDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((FlagStateDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((FlagStateDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((FlagStateDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((FlagStateDefns) model).setFlagStateDefnPid(rs.getInt("FLAG_STATE_DEFN_PID"));
		((FlagStateDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((FlagStateDefns) model).setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
		((FlagStateDefns) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((FlagStateDefns) model).setParentFlagSlot(rs.getShort("PARENT_FLAG_SLOT"));
		((FlagStateDefns) model).setStateValue(rs.getShort("STATE_VALUE"));
		((FlagStateDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((FlagStateDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((FlagStateDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((FlagStateDefns) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the FlagStateDefnPid field
	 *
	 * @param FlagStateDefnPid
	 *            Contents of the FLAG_STATE_DEFN_PID column
	 */
	public void setFlagStateDefnPid(int FlagStateDefnPid) {
		this.FlagStateDefnPid = FlagStateDefnPid;
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
	 * Set the ParentFlagSlot field
	 *
	 * @param ParentFlagSlot
	 *            Contents of the PARENT_FLAG_SLOT column
	 */
	public void setParentFlagSlot(short ParentFlagSlot) {
		this.ParentFlagSlot = ParentFlagSlot;
	}

	/**
	 * Set the ParentSubTypeKey field
	 *
	 * @param ParentSubTypeKey
	 *            Contents of the PARENT_SUB_TYPE_KEY column
	 */
	public void setParentSubTypeKey(short ParentSubTypeKey) {
		this.ParentSubTypeKey = ParentSubTypeKey;
	}

	/**
	 * Set the ParentTypeKey field
	 *
	 * @param ParentTypeKey
	 *            Contents of the PARENT_TYPE_KEY column
	 */
	public void setParentTypeKey(short ParentTypeKey) {
		this.ParentTypeKey = ParentTypeKey;
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
	 * Set the StateValue field
	 *
	 * @param StateValue
	 *            Contents of the STATE_VALUE column
	 */
	public void setStateValue(short StateValue) {
		this.StateValue = StateValue;
	}

}
