package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the NAME_TEMPLATE_TYPE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class NameTemplateTypeDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_PID, " + "COMMIT_PID, "
			+ "NAME_TEMPLATE_TYPE_DEFN_PID, " + "IS_SYSTEM, " + "ENTITY_TYPE_KEY, " + "ENTITY_SUB_TYPE_KEY, "
			+ "SORTING_ONLY, " + "IS_MANDATORY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.NAME_TEMPLATE_TYPE_DEFNS WHERE NAME_TEMPLATE_TYPE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_PID, " + "COMMIT_PID, "
			+ "NAME_TEMPLATE_TYPE_DEFN_PID, " + "IS_SYSTEM, " + "ENTITY_TYPE_KEY, " + "ENTITY_SUB_TYPE_KEY, "
			+ "SORTING_ONLY, " + "IS_MANDATORY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.NAME_TEMPLATE_TYPE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.NAME_TEMPLATE_TYPE_DEFNS( " + "RECORD_NUM, " + "SET_PID, "
			+ "COMMIT_PID, " + "NAME_TEMPLATE_TYPE_DEFN_PID, " + "IS_SYSTEM, " + "ENTITY_TYPE_KEY, "
			+ "ENTITY_SUB_TYPE_KEY, " + "SORTING_ONLY, " + "IS_MANDATORY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.NAME_TEMPLATE_TYPE_DEFNSSET " + "RECORD_NUM = ?, "
			+ "SET_PID = ?, " + "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "ENTITY_TYPE_KEY = ?, "
			+ "ENTITY_SUB_TYPE_KEY = ?, " + "SORTING_ONLY = ?, " + "IS_MANDATORY = ?, " + "REMINDER_KEY = ?, "
			+ "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, " + "SHOW = ? WHERE NAME_TEMPLATE_TYPE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.NAME_TEMPLATE_TYPE_DEFNS WHERE NAME_TEMPLATE_TYPE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.NAME_TEMPLATE_TYPE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetPid;
	private int CommitPid;
	private int NameTemplateTypeDefnPid;
	private boolean IsSystem;
	private short EntityTypeKey;
	private short EntitySubTypeKey;
	private boolean SortingOnly;
	private boolean IsMandatory;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private NameTemplateTypeDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public NameTemplateTypeDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param NameTemplateTypeDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public NameTemplateTypeDefns(int NameTemplateTypeDefnPid) throws SQLException {
		super();
		this.NameTemplateTypeDefnPid = NameTemplateTypeDefnPid;
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
			model = new NameTemplateTypeDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetPid(rs.getShort("SET_PID"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setNameTemplateTypeDefnPid(rs.getInt("NAME_TEMPLATE_TYPE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
			model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
			model.setSortingOnly(rs.getBoolean("SORTING_ONLY"));
			model.setIsMandatory(rs.getBoolean("IS_MANDATORY"));
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
			model.setSetPid(rs.getShort("SET_PID"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setNameTemplateTypeDefnPid(rs.getInt("NAME_TEMPLATE_TYPE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
			model.setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
			model.setSortingOnly(rs.getBoolean("SORTING_ONLY"));
			model.setIsMandatory(rs.getBoolean("IS_MANDATORY"));
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
	 * Get the EntitySubTypeKey field.
	 *
	 * @return Contents of the ENTITY_SUB_TYPE_KEY column
	 */
	public short getEntitySubTypeKey() {
		return this.EntitySubTypeKey;
	}

	/**
	 * Get the EntityTypeKey field.
	 *
	 * @return Contents of the ENTITY_TYPE_KEY column
	 */
	public short getEntityTypeKey() {
		return this.EntityTypeKey;
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
	 * Get the IsMandatory field.
	 *
	 * @return Contents of the IS_MANDATORY column
	 */
	public boolean getIsMandatory() {
		return this.IsMandatory;
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
	 * Get the NameTemplateTypeDefnPid field.
	 *
	 * @return Contents of the NAME_TEMPLATE_TYPE_DEFN_PID column
	 */
	public int getNameTemplateTypeDefnPid() {
		return this.NameTemplateTypeDefnPid;
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
	 * Get the SetPid field.
	 *
	 * @return Contents of the SET_PID column
	 */
	public short getSetPid() {
		return this.SetPid;
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
	 * Get the SortingOnly field.
	 *
	 * @return Contents of the SORTING_ONLY column
	 */
	public boolean getSortingOnly() {
		return this.SortingOnly;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((NameTemplateTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((NameTemplateTypeDefns) model).setSetPid(rs.getShort("SET_PID"));
		((NameTemplateTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((NameTemplateTypeDefns) model).setNameTemplateTypeDefnPid(rs.getInt("NAME_TEMPLATE_TYPE_DEFN_PID"));
		((NameTemplateTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((NameTemplateTypeDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
		((NameTemplateTypeDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
		((NameTemplateTypeDefns) model).setSortingOnly(rs.getBoolean("SORTING_ONLY"));
		((NameTemplateTypeDefns) model).setIsMandatory(rs.getBoolean("IS_MANDATORY"));
		((NameTemplateTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((NameTemplateTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((NameTemplateTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((NameTemplateTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((NameTemplateTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((NameTemplateTypeDefns) model).setSetPid(rs.getShort("SET_PID"));
		((NameTemplateTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((NameTemplateTypeDefns) model).setNameTemplateTypeDefnPid(rs.getInt("NAME_TEMPLATE_TYPE_DEFN_PID"));
		((NameTemplateTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((NameTemplateTypeDefns) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
		((NameTemplateTypeDefns) model).setEntitySubTypeKey(rs.getShort("ENTITY_SUB_TYPE_KEY"));
		((NameTemplateTypeDefns) model).setSortingOnly(rs.getBoolean("SORTING_ONLY"));
		((NameTemplateTypeDefns) model).setIsMandatory(rs.getBoolean("IS_MANDATORY"));
		((NameTemplateTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((NameTemplateTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((NameTemplateTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((NameTemplateTypeDefns) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the EntitySubTypeKey field
	 *
	 * @param EntitySubTypeKey
	 *            Contents of the ENTITY_SUB_TYPE_KEY column
	 */
	public void setEntitySubTypeKey(short EntitySubTypeKey) {
		this.EntitySubTypeKey = EntitySubTypeKey;
	}

	/**
	 * Set the EntityTypeKey field
	 *
	 * @param EntityTypeKey
	 *            Contents of the ENTITY_TYPE_KEY column
	 */
	public void setEntityTypeKey(short EntityTypeKey) {
		this.EntityTypeKey = EntityTypeKey;
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
	 * Set the IsMandatory field
	 *
	 * @param IsMandatory
	 *            Contents of the IS_MANDATORY column
	 */
	public void setIsMandatory(boolean IsMandatory) {
		this.IsMandatory = IsMandatory;
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
	 * Set the NameTemplateTypeDefnPid field
	 *
	 * @param NameTemplateTypeDefnPid
	 *            Contents of the NAME_TEMPLATE_TYPE_DEFN_PID column
	 */
	public void setNameTemplateTypeDefnPid(int NameTemplateTypeDefnPid) {
		this.NameTemplateTypeDefnPid = NameTemplateTypeDefnPid;
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
	 * Set the SetPid field
	 *
	 * @param SetPid
	 *            Contents of the SET_PID column
	 */
	public void setSetPid(short SetPid) {
		this.SetPid = SetPid;
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
	 * Set the SortingOnly field
	 *
	 * @param SortingOnly
	 *            Contents of the SORTING_ONLY column
	 */
	public void setSortingOnly(boolean SortingOnly) {
		this.SortingOnly = SortingOnly;
	}

}
