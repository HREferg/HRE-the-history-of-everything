package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the FLAG_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class FlagDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "FLAG_DEFN_PID, "
			+ "IS_SYSTEM, " + "PARENT_TYPE_KEY, " + "PARENT_SUB_TYPE_KEY, " + "FLAG_SLOT, " + "STATES, "
			+ "DFLT_STATE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.FLAG_DEFNS WHERE FLAG_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "FLAG_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_TYPE_KEY, " + "PARENT_SUB_TYPE_KEY, " + "FLAG_SLOT, "
			+ "STATES, " + "DFLT_STATE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.FLAG_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.FLAG_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "FLAG_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_TYPE_KEY, " + "PARENT_SUB_TYPE_KEY, "
			+ "FLAG_SLOT, " + "STATES, " + "DFLT_STATE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.FLAG_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PARENT_TYPE_KEY = ?, " + "PARENT_SUB_TYPE_KEY = ?, "
			+ "FLAG_SLOT = ?, " + "STATES = ?, " + "DFLT_STATE = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, "
			+ "IS_DEFAULT = ?, " + "SHOW = ? WHERE FLAG_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.FLAG_DEFNS WHERE FLAG_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.FLAG_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int FlagDefnPid;
	private boolean IsSystem;
	private short ParentTypeKey;
	private short ParentSubTypeKey;
	private short FlagSlot;
	private short States;
	private short DfltState;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private FlagDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public FlagDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param FlagDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public FlagDefns(int FlagDefnPid) throws SQLException {
		super();
		this.FlagDefnPid = FlagDefnPid;
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
			model = new FlagDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setFlagDefnPid(rs.getInt("FLAG_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setFlagSlot(rs.getShort("FLAG_SLOT"));
			model.setStates(rs.getShort("STATES"));
			model.setDfltState(rs.getShort("DFLT_STATE"));
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
			model.setFlagDefnPid(rs.getInt("FLAG_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setFlagSlot(rs.getShort("FLAG_SLOT"));
			model.setStates(rs.getShort("STATES"));
			model.setDfltState(rs.getShort("DFLT_STATE"));
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
	 * Get the DfltState field.
	 *
	 * @return Contents of the DFLT_STATE column
	 */
	public short getDfltState() {
		return this.DfltState;
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
	 * Get the FlagDefnPid field.
	 *
	 * @return Contents of the FLAG_DEFN_PID column
	 */
	public int getFlagDefnPid() {
		return this.FlagDefnPid;
	}

	/**
	 * Get the FlagSlot field.
	 *
	 * @return Contents of the FLAG_SLOT column
	 */
	public short getFlagSlot() {
		return this.FlagSlot;
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
	 * Get the States field.
	 *
	 * @return Contents of the STATES column
	 */
	public short getStates() {
		return this.States;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((FlagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((FlagDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((FlagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((FlagDefns) model).setFlagDefnPid(rs.getInt("FLAG_DEFN_PID"));
		((FlagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((FlagDefns) model).setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
		((FlagDefns) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((FlagDefns) model).setFlagSlot(rs.getShort("FLAG_SLOT"));
		((FlagDefns) model).setStates(rs.getShort("STATES"));
		((FlagDefns) model).setDfltState(rs.getShort("DFLT_STATE"));
		((FlagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((FlagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((FlagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((FlagDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((FlagDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((FlagDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((FlagDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((FlagDefns) model).setFlagDefnPid(rs.getInt("FLAG_DEFN_PID"));
		((FlagDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((FlagDefns) model).setParentTypeKey(rs.getShort("PARENT_TYPE_KEY"));
		((FlagDefns) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((FlagDefns) model).setFlagSlot(rs.getShort("FLAG_SLOT"));
		((FlagDefns) model).setStates(rs.getShort("STATES"));
		((FlagDefns) model).setDfltState(rs.getShort("DFLT_STATE"));
		((FlagDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((FlagDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((FlagDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((FlagDefns) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the DfltState field
	 *
	 * @param DfltState
	 *            Contents of the DFLT_STATE column
	 */
	public void setDfltState(short DfltState) {
		this.DfltState = DfltState;
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
	 * Set the FlagDefnPid field
	 *
	 * @param FlagDefnPid
	 *            Contents of the FLAG_DEFN_PID column
	 */
	public void setFlagDefnPid(int FlagDefnPid) {
		this.FlagDefnPid = FlagDefnPid;
	}

	/**
	 * Set the FlagSlot field
	 *
	 * @param FlagSlot
	 *            Contents of the FLAG_SLOT column
	 */
	public void setFlagSlot(short FlagSlot) {
		this.FlagSlot = FlagSlot;
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
	 * Set the States field
	 *
	 * @param States
	 *            Contents of the STATES column
	 */
	public void setStates(short States) {
		this.States = States;
	}

}
