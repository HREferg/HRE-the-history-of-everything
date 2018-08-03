package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the FIELD_VALID_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class FieldValidDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "FIELD_VALID_DEFN_PID, " + "VIEW_SCRIPT_GROUP_KEY, " + "VIEW_SCRIPT_PID, " + "MODIFY_SCRIPT_GROUP_KEY, "
			+ "MODIFY_SCRIPT_PID, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.FIELD_VALID_DEFNS WHERE FIELD_VALID_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "FIELD_VALID_DEFN_PID, " + "VIEW_SCRIPT_GROUP_KEY, " + "VIEW_SCRIPT_PID, " + "MODIFY_SCRIPT_GROUP_KEY, "
			+ "MODIFY_SCRIPT_PID, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.FIELD_VALID_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.FIELD_VALID_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "FIELD_VALID_DEFN_PID, " + "VIEW_SCRIPT_GROUP_KEY, " + "VIEW_SCRIPT_PID, "
			+ "MODIFY_SCRIPT_GROUP_KEY, " + "MODIFY_SCRIPT_PID, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.FIELD_VALID_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "VIEW_SCRIPT_GROUP_KEY = ?, " + "VIEW_SCRIPT_PID = ?, "
			+ "MODIFY_SCRIPT_GROUP_KEY = ?, " + "MODIFY_SCRIPT_PID = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, "
			+ "IS_DEFAULT = ?, " + "SHOW = ? WHERE FIELD_VALID_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.FIELD_VALID_DEFNS WHERE FIELD_VALID_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.FIELD_VALID_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int FieldValidDefnPid;
	private short ViewScriptGroupKey;
	private int ViewScriptPid;
	private short ModifyScriptGroupKey;
	private int ModifyScriptPid;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private FieldValidDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public FieldValidDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param FieldValidDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public FieldValidDefns(int FieldValidDefnPid) throws SQLException {
		super();
		this.FieldValidDefnPid = FieldValidDefnPid;
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
			model = new FieldValidDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setFieldValidDefnPid(rs.getInt("FIELD_VALID_DEFN_PID"));
			model.setViewScriptGroupKey(rs.getShort("VIEW_SCRIPT_GROUP_KEY"));
			model.setViewScriptPid(rs.getInt("VIEW_SCRIPT_PID"));
			model.setModifyScriptGroupKey(rs.getShort("MODIFY_SCRIPT_GROUP_KEY"));
			model.setModifyScriptPid(rs.getInt("MODIFY_SCRIPT_PID"));
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
			model.setFieldValidDefnPid(rs.getInt("FIELD_VALID_DEFN_PID"));
			model.setViewScriptGroupKey(rs.getShort("VIEW_SCRIPT_GROUP_KEY"));
			model.setViewScriptPid(rs.getInt("VIEW_SCRIPT_PID"));
			model.setModifyScriptGroupKey(rs.getShort("MODIFY_SCRIPT_GROUP_KEY"));
			model.setModifyScriptPid(rs.getInt("MODIFY_SCRIPT_PID"));
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
	 * Get the FieldValidDefnPid field.
	 *
	 * @return Contents of the FIELD_VALID_DEFN_PID column
	 */
	public int getFieldValidDefnPid() {
		return this.FieldValidDefnPid;
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
	 * Get the ModifyScriptGroupKey field.
	 *
	 * @return Contents of the MODIFY_SCRIPT_GROUP_KEY column
	 */
	public short getModifyScriptGroupKey() {
		return this.ModifyScriptGroupKey;
	}

	/**
	 * Get the ModifyScriptPid field.
	 *
	 * @return Contents of the MODIFY_SCRIPT_PID column
	 */
	public int getModifyScriptPid() {
		return this.ModifyScriptPid;
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
	 * Get the ViewScriptGroupKey field.
	 *
	 * @return Contents of the VIEW_SCRIPT_GROUP_KEY column
	 */
	public short getViewScriptGroupKey() {
		return this.ViewScriptGroupKey;
	}

	/**
	 * Get the ViewScriptPid field.
	 *
	 * @return Contents of the VIEW_SCRIPT_PID column
	 */
	public int getViewScriptPid() {
		return this.ViewScriptPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((FieldValidDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((FieldValidDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((FieldValidDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((FieldValidDefns) model).setFieldValidDefnPid(rs.getInt("FIELD_VALID_DEFN_PID"));
		((FieldValidDefns) model).setViewScriptGroupKey(rs.getShort("VIEW_SCRIPT_GROUP_KEY"));
		((FieldValidDefns) model).setViewScriptPid(rs.getInt("VIEW_SCRIPT_PID"));
		((FieldValidDefns) model).setModifyScriptGroupKey(rs.getShort("MODIFY_SCRIPT_GROUP_KEY"));
		((FieldValidDefns) model).setModifyScriptPid(rs.getInt("MODIFY_SCRIPT_PID"));
		((FieldValidDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((FieldValidDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((FieldValidDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((FieldValidDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((FieldValidDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((FieldValidDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((FieldValidDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((FieldValidDefns) model).setFieldValidDefnPid(rs.getInt("FIELD_VALID_DEFN_PID"));
		((FieldValidDefns) model).setViewScriptGroupKey(rs.getShort("VIEW_SCRIPT_GROUP_KEY"));
		((FieldValidDefns) model).setViewScriptPid(rs.getInt("VIEW_SCRIPT_PID"));
		((FieldValidDefns) model).setModifyScriptGroupKey(rs.getShort("MODIFY_SCRIPT_GROUP_KEY"));
		((FieldValidDefns) model).setModifyScriptPid(rs.getInt("MODIFY_SCRIPT_PID"));
		((FieldValidDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((FieldValidDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((FieldValidDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((FieldValidDefns) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the FieldValidDefnPid field
	 *
	 * @param FieldValidDefnPid
	 *            Contents of the FIELD_VALID_DEFN_PID column
	 */
	public void setFieldValidDefnPid(int FieldValidDefnPid) {
		this.FieldValidDefnPid = FieldValidDefnPid;
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
	 * Set the ModifyScriptGroupKey field
	 *
	 * @param ModifyScriptGroupKey
	 *            Contents of the MODIFY_SCRIPT_GROUP_KEY column
	 */
	public void setModifyScriptGroupKey(short ModifyScriptGroupKey) {
		this.ModifyScriptGroupKey = ModifyScriptGroupKey;
	}

	/**
	 * Set the ModifyScriptPid field
	 *
	 * @param ModifyScriptPid
	 *            Contents of the MODIFY_SCRIPT_PID column
	 */
	public void setModifyScriptPid(int ModifyScriptPid) {
		this.ModifyScriptPid = ModifyScriptPid;
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
	 * Set the ViewScriptGroupKey field
	 *
	 * @param ViewScriptGroupKey
	 *            Contents of the VIEW_SCRIPT_GROUP_KEY column
	 */
	public void setViewScriptGroupKey(short ViewScriptGroupKey) {
		this.ViewScriptGroupKey = ViewScriptGroupKey;
	}

	/**
	 * Set the ViewScriptPid field
	 *
	 * @param ViewScriptPid
	 *            Contents of the VIEW_SCRIPT_PID column
	 */
	public void setViewScriptPid(int ViewScriptPid) {
		this.ViewScriptPid = ViewScriptPid;
	}

}
