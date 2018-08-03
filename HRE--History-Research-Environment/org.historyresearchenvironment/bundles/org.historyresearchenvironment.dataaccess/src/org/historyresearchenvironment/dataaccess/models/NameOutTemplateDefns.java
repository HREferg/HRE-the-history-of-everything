package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the NAME_OUT_TEMPLATE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class NameOutTemplateDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "NAME_OUT_TEMPLATE_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_NAME_STYLE_TYPE_KEY, " + "TEMPLATE_TYPE_KEY, "
			+ "SORTING_ONLY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.NAME_OUT_TEMPLATE_DEFNS WHERE NAME_OUT_TEMPLATE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "NAME_OUT_TEMPLATE_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_NAME_STYLE_TYPE_KEY, " + "TEMPLATE_TYPE_KEY, "
			+ "SORTING_ONLY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.NAME_OUT_TEMPLATE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.NAME_OUT_TEMPLATE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "NAME_OUT_TEMPLATE_DEFN_PID, " + "IS_SYSTEM, " + "PARENT_NAME_STYLE_TYPE_KEY, "
			+ "TEMPLATE_TYPE_KEY, " + "SORTING_ONLY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?)";

	private static final String UPDATE = "UPDATE PUBLIC.NAME_OUT_TEMPLATE_DEFNSSET " + "RECORD_NUM = ?, "
			+ "SET_KEY = ?, " + "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PARENT_NAME_STYLE_TYPE_KEY = ?, "
			+ "TEMPLATE_TYPE_KEY = ?, " + "SORTING_ONLY = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, "
			+ "IS_DEFAULT = ?, " + "SHOW = ? WHERE NAME_OUT_TEMPLATE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.NAME_OUT_TEMPLATE_DEFNS WHERE NAME_OUT_TEMPLATE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.NAME_OUT_TEMPLATE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int NameOutTemplateDefnPid;
	private boolean IsSystem;
	private short ParentNameStyleTypeKey;
	private short TemplateTypeKey;
	private boolean SortingOnly;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private NameOutTemplateDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public NameOutTemplateDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param NameOutTemplateDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public NameOutTemplateDefns(int NameOutTemplateDefnPid) throws SQLException {
		super();
		this.NameOutTemplateDefnPid = NameOutTemplateDefnPid;
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
			model = new NameOutTemplateDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setNameOutTemplateDefnPid(rs.getInt("NAME_OUT_TEMPLATE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentNameStyleTypeKey(rs.getShort("PARENT_NAME_STYLE_TYPE_KEY"));
			model.setTemplateTypeKey(rs.getShort("TEMPLATE_TYPE_KEY"));
			model.setSortingOnly(rs.getBoolean("SORTING_ONLY"));
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
			model.setNameOutTemplateDefnPid(rs.getInt("NAME_OUT_TEMPLATE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentNameStyleTypeKey(rs.getShort("PARENT_NAME_STYLE_TYPE_KEY"));
			model.setTemplateTypeKey(rs.getShort("TEMPLATE_TYPE_KEY"));
			model.setSortingOnly(rs.getBoolean("SORTING_ONLY"));
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
	 * Get the NameOutTemplateDefnPid field.
	 *
	 * @return Contents of the NAME_OUT_TEMPLATE_DEFN_PID column
	 */
	public int getNameOutTemplateDefnPid() {
		return this.NameOutTemplateDefnPid;
	}

	/**
	 * Get the ParentNameStyleTypeKey field.
	 *
	 * @return Contents of the PARENT_NAME_STYLE_TYPE_KEY column
	 */
	public short getParentNameStyleTypeKey() {
		return this.ParentNameStyleTypeKey;
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
	 * Get the SortingOnly field.
	 *
	 * @return Contents of the SORTING_ONLY column
	 */
	public boolean getSortingOnly() {
		return this.SortingOnly;
	}

	/**
	 * Get the TemplateTypeKey field.
	 *
	 * @return Contents of the TEMPLATE_TYPE_KEY column
	 */
	public short getTemplateTypeKey() {
		return this.TemplateTypeKey;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((NameOutTemplateDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((NameOutTemplateDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((NameOutTemplateDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((NameOutTemplateDefns) model).setNameOutTemplateDefnPid(rs.getInt("NAME_OUT_TEMPLATE_DEFN_PID"));
		((NameOutTemplateDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((NameOutTemplateDefns) model).setParentNameStyleTypeKey(rs.getShort("PARENT_NAME_STYLE_TYPE_KEY"));
		((NameOutTemplateDefns) model).setTemplateTypeKey(rs.getShort("TEMPLATE_TYPE_KEY"));
		((NameOutTemplateDefns) model).setSortingOnly(rs.getBoolean("SORTING_ONLY"));
		((NameOutTemplateDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((NameOutTemplateDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((NameOutTemplateDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((NameOutTemplateDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((NameOutTemplateDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((NameOutTemplateDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((NameOutTemplateDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((NameOutTemplateDefns) model).setNameOutTemplateDefnPid(rs.getInt("NAME_OUT_TEMPLATE_DEFN_PID"));
		((NameOutTemplateDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((NameOutTemplateDefns) model).setParentNameStyleTypeKey(rs.getShort("PARENT_NAME_STYLE_TYPE_KEY"));
		((NameOutTemplateDefns) model).setTemplateTypeKey(rs.getShort("TEMPLATE_TYPE_KEY"));
		((NameOutTemplateDefns) model).setSortingOnly(rs.getBoolean("SORTING_ONLY"));
		((NameOutTemplateDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((NameOutTemplateDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((NameOutTemplateDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((NameOutTemplateDefns) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the NameOutTemplateDefnPid field
	 *
	 * @param NameOutTemplateDefnPid
	 *            Contents of the NAME_OUT_TEMPLATE_DEFN_PID column
	 */
	public void setNameOutTemplateDefnPid(int NameOutTemplateDefnPid) {
		this.NameOutTemplateDefnPid = NameOutTemplateDefnPid;
	}

	/**
	 * Set the ParentNameStyleTypeKey field
	 *
	 * @param ParentNameStyleTypeKey
	 *            Contents of the PARENT_NAME_STYLE_TYPE_KEY column
	 */
	public void setParentNameStyleTypeKey(short ParentNameStyleTypeKey) {
		this.ParentNameStyleTypeKey = ParentNameStyleTypeKey;
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
	 * Set the SortingOnly field
	 *
	 * @param SortingOnly
	 *            Contents of the SORTING_ONLY column
	 */
	public void setSortingOnly(boolean SortingOnly) {
		this.SortingOnly = SortingOnly;
	}

	/**
	 * Set the TemplateTypeKey field
	 *
	 * @param TemplateTypeKey
	 *            Contents of the TEMPLATE_TYPE_KEY column
	 */
	public void setTemplateTypeKey(short TemplateTypeKey) {
		this.TemplateTypeKey = TemplateTypeKey;
	}

}
