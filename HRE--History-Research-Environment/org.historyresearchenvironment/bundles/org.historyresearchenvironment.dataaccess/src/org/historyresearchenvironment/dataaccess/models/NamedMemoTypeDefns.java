package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the NAMED_MEMO_TYPE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class NamedMemoTypeDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "NAMED_MEMO_TYPE_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_TAG_TYPE_KEY, " + "PARENT_TAG_TYPE_PID, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.NAMED_MEMO_TYPE_DEFNS WHERE NAMED_MEMO_TYPE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "NAMED_MEMO_TYPE_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_TAG_TYPE_KEY, " + "PARENT_TAG_TYPE_PID, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.NAMED_MEMO_TYPE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.NAMED_MEMO_TYPE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "NAMED_MEMO_TYPE_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_TAG_TYPE_KEY, "
			+ "PARENT_TAG_TYPE_PID, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.NAMED_MEMO_TYPE_DEFNSSET " + "RECORD_NUM = ?, "
			+ "SET_KEY = ?, " + "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PARENT_TAG_TYPE_KEY = ?, "
			+ "PARENT_TAG_TYPE_PID = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE NAMED_MEMO_TYPE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.NAMED_MEMO_TYPE_DEFNS WHERE NAMED_MEMO_TYPE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.NAMED_MEMO_TYPE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int NamedMemoTypeDefnPid;
	private boolean IsSystem;
	private short ParentTagTypeKey;
	private short ParentTagTypePid;
	private int ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private NamedMemoTypeDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public NamedMemoTypeDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param NamedMemoTypeDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public NamedMemoTypeDefns(int NamedMemoTypeDefnPid) throws SQLException {
		super();
		this.NamedMemoTypeDefnPid = NamedMemoTypeDefnPid;
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
			model = new NamedMemoTypeDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setNamedMemoTypeDefnPid(rs.getInt("NAMED_MEMO_TYPE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentTagTypeKey(rs.getShort("PARENT_TAG_TYPE_KEY"));
			model.setParentTagTypePid(rs.getShort("PARENT_TAG_TYPE_PID"));
			model.setReminderKey(rs.getInt("REMINDER_KEY"));
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
			model.setNamedMemoTypeDefnPid(rs.getInt("NAMED_MEMO_TYPE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentTagTypeKey(rs.getShort("PARENT_TAG_TYPE_KEY"));
			model.setParentTagTypePid(rs.getShort("PARENT_TAG_TYPE_PID"));
			model.setReminderKey(rs.getInt("REMINDER_KEY"));
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
	 * Get the NamedMemoTypeDefnPid field.
	 *
	 * @return Contents of the NAMED_MEMO_TYPE_DEFN_PID column
	 */
	public int getNamedMemoTypeDefnPid() {
		return this.NamedMemoTypeDefnPid;
	}

	/**
	 * Get the ParentTagTypeKey field.
	 *
	 * @return Contents of the PARENT_TAG_TYPE_KEY column
	 */
	public short getParentTagTypeKey() {
		return this.ParentTagTypeKey;
	}

	/**
	 * Get the ParentTagTypePid field.
	 *
	 * @return Contents of the PARENT_TAG_TYPE_PID column
	 */
	public short getParentTagTypePid() {
		return this.ParentTagTypePid;
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
	public int getReminderKey() {
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
		((NamedMemoTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((NamedMemoTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((NamedMemoTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((NamedMemoTypeDefns) model).setNamedMemoTypeDefnPid(rs.getInt("NAMED_MEMO_TYPE_DEFN_PID"));
		((NamedMemoTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((NamedMemoTypeDefns) model).setParentTagTypeKey(rs.getShort("PARENT_TAG_TYPE_KEY"));
		((NamedMemoTypeDefns) model).setParentTagTypePid(rs.getShort("PARENT_TAG_TYPE_PID"));
		((NamedMemoTypeDefns) model).setReminderKey(rs.getInt("REMINDER_KEY"));
		((NamedMemoTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((NamedMemoTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((NamedMemoTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((NamedMemoTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((NamedMemoTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((NamedMemoTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((NamedMemoTypeDefns) model).setNamedMemoTypeDefnPid(rs.getInt("NAMED_MEMO_TYPE_DEFN_PID"));
		((NamedMemoTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((NamedMemoTypeDefns) model).setParentTagTypeKey(rs.getShort("PARENT_TAG_TYPE_KEY"));
		((NamedMemoTypeDefns) model).setParentTagTypePid(rs.getShort("PARENT_TAG_TYPE_PID"));
		((NamedMemoTypeDefns) model).setReminderKey(rs.getInt("REMINDER_KEY"));
		((NamedMemoTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((NamedMemoTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((NamedMemoTypeDefns) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the NamedMemoTypeDefnPid field
	 *
	 * @param NamedMemoTypeDefnPid
	 *            Contents of the NAMED_MEMO_TYPE_DEFN_PID column
	 */
	public void setNamedMemoTypeDefnPid(int NamedMemoTypeDefnPid) {
		this.NamedMemoTypeDefnPid = NamedMemoTypeDefnPid;
	}

	/**
	 * Set the ParentTagTypeKey field
	 *
	 * @param ParentTagTypeKey
	 *            Contents of the PARENT_TAG_TYPE_KEY column
	 */
	public void setParentTagTypeKey(short ParentTagTypeKey) {
		this.ParentTagTypeKey = ParentTagTypeKey;
	}

	/**
	 * Set the ParentTagTypePid field
	 *
	 * @param ParentTagTypePid
	 *            Contents of the PARENT_TAG_TYPE_PID column
	 */
	public void setParentTagTypePid(short ParentTagTypePid) {
		this.ParentTagTypePid = ParentTagTypePid;
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
	public void setReminderKey(int ReminderKey) {
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
