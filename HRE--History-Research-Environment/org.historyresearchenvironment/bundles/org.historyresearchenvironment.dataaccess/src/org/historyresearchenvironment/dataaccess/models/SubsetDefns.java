package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SUBSET_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SubsetDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "SUBSET_DEFN_PID, "
			+ "IS_SYSTEM, " + "SUBSET_TYPE_KEY, " + "SIZE, " + "STACK_INDEX, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW FROM PUBLIC.SUBSET_DEFNS WHERE SUBSET_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSET_DEFN_PID, " + "IS_SYSTEM, " + "SUBSET_TYPE_KEY, " + "SIZE, " + "STACK_INDEX, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.SUBSET_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.SUBSET_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SUBSET_DEFN_PID, " + "IS_SYSTEM, " + "SUBSET_TYPE_KEY, " + "SIZE, " + "STACK_INDEX, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SUBSET_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "SUBSET_TYPE_KEY = ?, " + "SIZE = ?, " + "STACK_INDEX = ?, "
			+ "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, " + "SHOW = ? WHERE SUBSET_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SUBSET_DEFNS WHERE SUBSET_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSET_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SubsetDefnPid;
	private boolean IsSystem;
	private short SubsetTypeKey;
	private int Size;
	private int StackIndex;
	private short ReminderKey;
	private int DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private SubsetDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SubsetDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param SubsetDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SubsetDefns(int SubsetDefnPid) throws SQLException {
		super();
		this.SubsetDefnPid = SubsetDefnPid;
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
			model = new SubsetDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSubsetDefnPid(rs.getInt("SUBSET_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setSubsetTypeKey(rs.getShort("SUBSET_TYPE_KEY"));
			model.setSize(rs.getInt("SIZE"));
			model.setStackIndex(rs.getInt("STACK_INDEX"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getInt("DISPLAY_ORDER"));
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
			model.setSubsetDefnPid(rs.getInt("SUBSET_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setSubsetTypeKey(rs.getShort("SUBSET_TYPE_KEY"));
			model.setSize(rs.getInt("SIZE"));
			model.setStackIndex(rs.getInt("STACK_INDEX"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getInt("DISPLAY_ORDER"));
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
	public int getDisplayOrder() {
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
	 * Get the Size field.
	 *
	 * @return Contents of the SIZE column
	 */
	public int getSize() {
		return this.Size;
	}

	/**
	 * Get the StackIndex field.
	 *
	 * @return Contents of the STACK_INDEX column
	 */
	public int getStackIndex() {
		return this.StackIndex;
	}

	/**
	 * Get the SubsetDefnPid field.
	 *
	 * @return Contents of the SUBSET_DEFN_PID column
	 */
	public int getSubsetDefnPid() {
		return this.SubsetDefnPid;
	}

	/**
	 * Get the SubsetTypeKey field.
	 *
	 * @return Contents of the SUBSET_TYPE_KEY column
	 */
	public short getSubsetTypeKey() {
		return this.SubsetTypeKey;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((SubsetDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubsetDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubsetDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubsetDefns) model).setSubsetDefnPid(rs.getInt("SUBSET_DEFN_PID"));
		((SubsetDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubsetDefns) model).setSubsetTypeKey(rs.getShort("SUBSET_TYPE_KEY"));
		((SubsetDefns) model).setSize(rs.getInt("SIZE"));
		((SubsetDefns) model).setStackIndex(rs.getInt("STACK_INDEX"));
		((SubsetDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubsetDefns) model).setDisplayOrder(rs.getInt("DISPLAY_ORDER"));
		((SubsetDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((SubsetDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SubsetDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubsetDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubsetDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubsetDefns) model).setSubsetDefnPid(rs.getInt("SUBSET_DEFN_PID"));
		((SubsetDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SubsetDefns) model).setSubsetTypeKey(rs.getShort("SUBSET_TYPE_KEY"));
		((SubsetDefns) model).setSize(rs.getInt("SIZE"));
		((SubsetDefns) model).setStackIndex(rs.getInt("STACK_INDEX"));
		((SubsetDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubsetDefns) model).setDisplayOrder(rs.getInt("DISPLAY_ORDER"));
		((SubsetDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((SubsetDefns) model).setShow(rs.getBoolean("SHOW"));
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
	public void setDisplayOrder(int DisplayOrder) {
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
	 * Set the Size field
	 *
	 * @param Size
	 *            Contents of the SIZE column
	 */
	public void setSize(int Size) {
		this.Size = Size;
	}

	/**
	 * Set the StackIndex field
	 *
	 * @param StackIndex
	 *            Contents of the STACK_INDEX column
	 */
	public void setStackIndex(int StackIndex) {
		this.StackIndex = StackIndex;
	}

	/**
	 * Set the SubsetDefnPid field
	 *
	 * @param SubsetDefnPid
	 *            Contents of the SUBSET_DEFN_PID column
	 */
	public void setSubsetDefnPid(int SubsetDefnPid) {
		this.SubsetDefnPid = SubsetDefnPid;
	}

	/**
	 * Set the SubsetTypeKey field
	 *
	 * @param SubsetTypeKey
	 *            Contents of the SUBSET_TYPE_KEY column
	 */
	public void setSubsetTypeKey(short SubsetTypeKey) {
		this.SubsetTypeKey = SubsetTypeKey;
	}

}
