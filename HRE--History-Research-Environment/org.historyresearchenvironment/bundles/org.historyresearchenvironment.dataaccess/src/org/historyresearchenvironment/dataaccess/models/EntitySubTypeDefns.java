package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the ENTITY_SUB_TYPE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class EntitySubTypeDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "ENTITY_SUB_TYPE_PID, " + "IS_SYSTEM, " + "BASE_ENTITY_TYPE_KEY, " + "BASE_ENTITY_SUB_TYPE_KEY, "
			+ "PARENT_SUB_TYPE_KEY, " + "GROUP_OF_TYPE_KEY, " + "GROUP_OF_SUB_TYPE_KEY, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.ENTITY_SUB_TYPE_DEFNS WHERE ENTITY_SUB_TYPE_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "ENTITY_SUB_TYPE_PID, " + "IS_SYSTEM, " + "BASE_ENTITY_TYPE_KEY, " + "BASE_ENTITY_SUB_TYPE_KEY, "
			+ "PARENT_SUB_TYPE_KEY, " + "GROUP_OF_TYPE_KEY, " + "GROUP_OF_SUB_TYPE_KEY, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.ENTITY_SUB_TYPE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.ENTITY_SUB_TYPE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "ENTITY_SUB_TYPE_PID, " + "IS_SYSTEM, " + "BASE_ENTITY_TYPE_KEY, "
			+ "BASE_ENTITY_SUB_TYPE_KEY, " + "PARENT_SUB_TYPE_KEY, " + "GROUP_OF_TYPE_KEY, " + "GROUP_OF_SUB_TYPE_KEY, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.ENTITY_SUB_TYPE_DEFNSSET " + "RECORD_NUM = ?, "
			+ "SET_KEY = ?, " + "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "BASE_ENTITY_TYPE_KEY = ?, "
			+ "BASE_ENTITY_SUB_TYPE_KEY = ?, " + "PARENT_SUB_TYPE_KEY = ?, " + "GROUP_OF_TYPE_KEY = ?, "
			+ "GROUP_OF_SUB_TYPE_KEY = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE ENTITY_SUB_TYPE_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.ENTITY_SUB_TYPE_DEFNS WHERE ENTITY_SUB_TYPE_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.ENTITY_SUB_TYPE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int EntitySubTypePid;
	private boolean IsSystem;
	private short BaseEntityTypeKey;
	private short BaseEntitySubTypeKey;
	private short ParentSubTypeKey;
	private short GroupOfTypeKey;
	private short GroupOfSubTypeKey;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private EntitySubTypeDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public EntitySubTypeDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param EntitySubTypePid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public EntitySubTypeDefns(int EntitySubTypePid) throws SQLException {
		super();
		this.EntitySubTypePid = EntitySubTypePid;
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
			model = new EntitySubTypeDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setEntitySubTypePid(rs.getInt("ENTITY_SUB_TYPE_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setBaseEntityTypeKey(rs.getShort("BASE_ENTITY_TYPE_KEY"));
			model.setBaseEntitySubTypeKey(rs.getShort("BASE_ENTITY_SUB_TYPE_KEY"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setGroupOfTypeKey(rs.getShort("GROUP_OF_TYPE_KEY"));
			model.setGroupOfSubTypeKey(rs.getShort("GROUP_OF_SUB_TYPE_KEY"));
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
			model.setEntitySubTypePid(rs.getInt("ENTITY_SUB_TYPE_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setBaseEntityTypeKey(rs.getShort("BASE_ENTITY_TYPE_KEY"));
			model.setBaseEntitySubTypeKey(rs.getShort("BASE_ENTITY_SUB_TYPE_KEY"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setGroupOfTypeKey(rs.getShort("GROUP_OF_TYPE_KEY"));
			model.setGroupOfSubTypeKey(rs.getShort("GROUP_OF_SUB_TYPE_KEY"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
			model.setShow(rs.getBoolean("SHOW"));
		}
		return this;
	}

	/**
	 * Get the BaseEntitySubTypeKey field.
	 *
	 * @return Contents of the BASE_ENTITY_SUB_TYPE_KEY column
	 */
	public short getBaseEntitySubTypeKey() {
		return this.BaseEntitySubTypeKey;
	}

	/**
	 * Get the BaseEntityTypeKey field.
	 *
	 * @return Contents of the BASE_ENTITY_TYPE_KEY column
	 */
	public short getBaseEntityTypeKey() {
		return this.BaseEntityTypeKey;
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
	 * Get the EntitySubTypePid field.
	 *
	 * @return Contents of the ENTITY_SUB_TYPE_PID column
	 */
	public int getEntitySubTypePid() {
		return this.EntitySubTypePid;
	}

	/**
	 * Get the GroupOfSubTypeKey field.
	 *
	 * @return Contents of the GROUP_OF_SUB_TYPE_KEY column
	 */
	public short getGroupOfSubTypeKey() {
		return this.GroupOfSubTypeKey;
	}

	/**
	 * Get the GroupOfTypeKey field.
	 *
	 * @return Contents of the GROUP_OF_TYPE_KEY column
	 */
	public short getGroupOfTypeKey() {
		return this.GroupOfTypeKey;
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
		((EntitySubTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((EntitySubTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((EntitySubTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((EntitySubTypeDefns) model).setEntitySubTypePid(rs.getInt("ENTITY_SUB_TYPE_PID"));
		((EntitySubTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((EntitySubTypeDefns) model).setBaseEntityTypeKey(rs.getShort("BASE_ENTITY_TYPE_KEY"));
		((EntitySubTypeDefns) model).setBaseEntitySubTypeKey(rs.getShort("BASE_ENTITY_SUB_TYPE_KEY"));
		((EntitySubTypeDefns) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((EntitySubTypeDefns) model).setGroupOfTypeKey(rs.getShort("GROUP_OF_TYPE_KEY"));
		((EntitySubTypeDefns) model).setGroupOfSubTypeKey(rs.getShort("GROUP_OF_SUB_TYPE_KEY"));
		((EntitySubTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((EntitySubTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((EntitySubTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((EntitySubTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((EntitySubTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((EntitySubTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((EntitySubTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((EntitySubTypeDefns) model).setEntitySubTypePid(rs.getInt("ENTITY_SUB_TYPE_PID"));
		((EntitySubTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((EntitySubTypeDefns) model).setBaseEntityTypeKey(rs.getShort("BASE_ENTITY_TYPE_KEY"));
		((EntitySubTypeDefns) model).setBaseEntitySubTypeKey(rs.getShort("BASE_ENTITY_SUB_TYPE_KEY"));
		((EntitySubTypeDefns) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((EntitySubTypeDefns) model).setGroupOfTypeKey(rs.getShort("GROUP_OF_TYPE_KEY"));
		((EntitySubTypeDefns) model).setGroupOfSubTypeKey(rs.getShort("GROUP_OF_SUB_TYPE_KEY"));
		((EntitySubTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((EntitySubTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((EntitySubTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((EntitySubTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	/**
	 * Set the BaseEntitySubTypeKey field
	 *
	 * @param BaseEntitySubTypeKey
	 *            Contents of the BASE_ENTITY_SUB_TYPE_KEY column
	 */
	public void setBaseEntitySubTypeKey(short BaseEntitySubTypeKey) {
		this.BaseEntitySubTypeKey = BaseEntitySubTypeKey;
	}

	/**
	 * Set the BaseEntityTypeKey field
	 *
	 * @param BaseEntityTypeKey
	 *            Contents of the BASE_ENTITY_TYPE_KEY column
	 */
	public void setBaseEntityTypeKey(short BaseEntityTypeKey) {
		this.BaseEntityTypeKey = BaseEntityTypeKey;
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
	 * Set the EntitySubTypePid field
	 *
	 * @param EntitySubTypePid
	 *            Contents of the ENTITY_SUB_TYPE_PID column
	 */
	public void setEntitySubTypePid(int EntitySubTypePid) {
		this.EntitySubTypePid = EntitySubTypePid;
	}

	/**
	 * Set the GroupOfSubTypeKey field
	 *
	 * @param GroupOfSubTypeKey
	 *            Contents of the GROUP_OF_SUB_TYPE_KEY column
	 */
	public void setGroupOfSubTypeKey(short GroupOfSubTypeKey) {
		this.GroupOfSubTypeKey = GroupOfSubTypeKey;
	}

	/**
	 * Set the GroupOfTypeKey field
	 *
	 * @param GroupOfTypeKey
	 *            Contents of the GROUP_OF_TYPE_KEY column
	 */
	public void setGroupOfTypeKey(short GroupOfTypeKey) {
		this.GroupOfTypeKey = GroupOfTypeKey;
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
