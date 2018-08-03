package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the PLUGIN_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class PluginDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "PLUGIN_DEFN_PID, "
			+ "IS_NATIVE, " + "VERSON_NAME, " + "PARENT_PCKG_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW FROM PUBLIC.PLUGIN_DEFNS WHERE PLUGIN_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "PLUGIN_DEFN_PID, " + "IS_NATIVE, " + "VERSON_NAME, " + "PARENT_PCKG_KEY, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.PLUGIN_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.PLUGIN_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "PLUGIN_DEFN_PID, " + "IS_NATIVE, " + "VERSON_NAME, " + "PARENT_PCKG_KEY, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.PLUGIN_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_NATIVE = ?, " + "VERSON_NAME = ?, " + "PARENT_PCKG_KEY = ?, "
			+ "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, " + "SHOW = ? WHERE PLUGIN_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.PLUGIN_DEFNS WHERE PLUGIN_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.PLUGIN_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int PluginDefnPid;
	private boolean IsNative;
	private String VersonName;
	private short ParentPckgKey;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private PluginDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public PluginDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param PluginDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public PluginDefns(int PluginDefnPid) throws SQLException {
		super();
		this.PluginDefnPid = PluginDefnPid;
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
			model = new PluginDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setPluginDefnPid(rs.getInt("PLUGIN_DEFN_PID"));
			model.setIsNative(rs.getBoolean("IS_NATIVE"));
			model.setVersonName(rs.getString("VERSON_NAME"));
			model.setParentPckgKey(rs.getShort("PARENT_PCKG_KEY"));
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
			model.setPluginDefnPid(rs.getInt("PLUGIN_DEFN_PID"));
			model.setIsNative(rs.getBoolean("IS_NATIVE"));
			model.setVersonName(rs.getString("VERSON_NAME"));
			model.setParentPckgKey(rs.getShort("PARENT_PCKG_KEY"));
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
	 * Get the IsNative field.
	 *
	 * @return Contents of the IS_NATIVE column
	 */
	public boolean getIsNative() {
		return this.IsNative;
	}

	/**
	 * Get the ParentPckgKey field.
	 *
	 * @return Contents of the PARENT_PCKG_KEY column
	 */
	public short getParentPckgKey() {
		return this.ParentPckgKey;
	}

	/**
	 * Get the PluginDefnPid field.
	 *
	 * @return Contents of the PLUGIN_DEFN_PID column
	 */
	public int getPluginDefnPid() {
		return this.PluginDefnPid;
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
	 * Get the VersonName field.
	 *
	 * @return Contents of the VERSON_NAME column
	 */
	public String getVersonName() {
		return this.VersonName;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((PluginDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((PluginDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((PluginDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((PluginDefns) model).setPluginDefnPid(rs.getInt("PLUGIN_DEFN_PID"));
		((PluginDefns) model).setIsNative(rs.getBoolean("IS_NATIVE"));
		((PluginDefns) model).setVersonName(rs.getString("VERSON_NAME"));
		((PluginDefns) model).setParentPckgKey(rs.getShort("PARENT_PCKG_KEY"));
		((PluginDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((PluginDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((PluginDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((PluginDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((PluginDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((PluginDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((PluginDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((PluginDefns) model).setPluginDefnPid(rs.getInt("PLUGIN_DEFN_PID"));
		((PluginDefns) model).setIsNative(rs.getBoolean("IS_NATIVE"));
		((PluginDefns) model).setVersonName(rs.getString("VERSON_NAME"));
		((PluginDefns) model).setParentPckgKey(rs.getShort("PARENT_PCKG_KEY"));
		((PluginDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((PluginDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((PluginDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((PluginDefns) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the IsNative field
	 *
	 * @param IsNative
	 *            Contents of the IS_NATIVE column
	 */
	public void setIsNative(boolean IsNative) {
		this.IsNative = IsNative;
	}

	/**
	 * Set the ParentPckgKey field
	 *
	 * @param ParentPckgKey
	 *            Contents of the PARENT_PCKG_KEY column
	 */
	public void setParentPckgKey(short ParentPckgKey) {
		this.ParentPckgKey = ParentPckgKey;
	}

	/**
	 * Set the PluginDefnPid field
	 *
	 * @param PluginDefnPid
	 *            Contents of the PLUGIN_DEFN_PID column
	 */
	public void setPluginDefnPid(int PluginDefnPid) {
		this.PluginDefnPid = PluginDefnPid;
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
	 * Set the VersonName field
	 *
	 * @param VersonName
	 *            Contents of the VERSON_NAME column
	 */
	public void setVersonName(String VersonName) {
		this.VersonName = VersonName;
	}

}
