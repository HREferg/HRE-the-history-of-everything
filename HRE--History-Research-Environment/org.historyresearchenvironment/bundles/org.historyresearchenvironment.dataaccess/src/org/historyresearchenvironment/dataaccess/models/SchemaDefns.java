package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SCHEMA_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SchemaDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "SCHEMA_DEFN_PID, "
			+ "VERSION_NAME, " + "MAIN_PCKG_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.SCHEMA_DEFNS WHERE SCHEMA_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SCHEMA_DEFN_PID, " + "VERSION_NAME, " + "MAIN_PCKG_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW FROM PUBLIC.SCHEMA_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.SCHEMA_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SCHEMA_DEFN_PID, " + "VERSION_NAME, " + "MAIN_PCKG_KEY, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SCHEMA_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "VERSION_NAME = ?, " + "MAIN_PCKG_KEY = ?, " + "REMINDER_KEY = ?, "
			+ "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, " + "SHOW = ? WHERE SCHEMA_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SCHEMA_DEFNS WHERE SCHEMA_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SCHEMA_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SchemaDefnPid;
	private String VersionName;
	private short MainPckgKey;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private SchemaDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SchemaDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param SchemaDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SchemaDefns(int SchemaDefnPid) throws SQLException {
		super();
		this.SchemaDefnPid = SchemaDefnPid;
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
			model = new SchemaDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSchemaDefnPid(rs.getInt("SCHEMA_DEFN_PID"));
			model.setVersionName(rs.getString("VERSION_NAME"));
			model.setMainPckgKey(rs.getShort("MAIN_PCKG_KEY"));
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
			model.setSchemaDefnPid(rs.getInt("SCHEMA_DEFN_PID"));
			model.setVersionName(rs.getString("VERSION_NAME"));
			model.setMainPckgKey(rs.getShort("MAIN_PCKG_KEY"));
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
	 * Get the MainPckgKey field.
	 *
	 * @return Contents of the MAIN_PCKG_KEY column
	 */
	public short getMainPckgKey() {
		return this.MainPckgKey;
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
	 * Get the SchemaDefnPid field.
	 *
	 * @return Contents of the SCHEMA_DEFN_PID column
	 */
	public int getSchemaDefnPid() {
		return this.SchemaDefnPid;
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
	 * Get the VersionName field.
	 *
	 * @return Contents of the VERSION_NAME column
	 */
	public String getVersionName() {
		return this.VersionName;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((SchemaDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SchemaDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SchemaDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SchemaDefns) model).setSchemaDefnPid(rs.getInt("SCHEMA_DEFN_PID"));
		((SchemaDefns) model).setVersionName(rs.getString("VERSION_NAME"));
		((SchemaDefns) model).setMainPckgKey(rs.getShort("MAIN_PCKG_KEY"));
		((SchemaDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SchemaDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SchemaDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((SchemaDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SchemaDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SchemaDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SchemaDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SchemaDefns) model).setSchemaDefnPid(rs.getInt("SCHEMA_DEFN_PID"));
		((SchemaDefns) model).setVersionName(rs.getString("VERSION_NAME"));
		((SchemaDefns) model).setMainPckgKey(rs.getShort("MAIN_PCKG_KEY"));
		((SchemaDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SchemaDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SchemaDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((SchemaDefns) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the MainPckgKey field
	 *
	 * @param MainPckgKey
	 *            Contents of the MAIN_PCKG_KEY column
	 */
	public void setMainPckgKey(short MainPckgKey) {
		this.MainPckgKey = MainPckgKey;
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
	 * Set the SchemaDefnPid field
	 *
	 * @param SchemaDefnPid
	 *            Contents of the SCHEMA_DEFN_PID column
	 */
	public void setSchemaDefnPid(int SchemaDefnPid) {
		this.SchemaDefnPid = SchemaDefnPid;
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
	 * Set the VersionName field
	 *
	 * @param VersionName
	 *            Contents of the VERSION_NAME column
	 */
	public void setVersionName(String VersionName) {
		this.VersionName = VersionName;
	}

}
