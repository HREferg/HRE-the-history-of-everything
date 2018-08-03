package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the FIELD_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class FieldDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "FIELD_DEFN_PID, "
			+ "VERSION_NAME, " + "SQL_NAME, " + "SQL_TYPE, " + "DATA_TYPE_KEY, " + "ENCODE_TYPE_KEY, "
			+ "FIELD_FORMAT_KEY, " + "FIELD_VALID_KEY, " + "FIELD_RECENT_PID, " + "MAX_RECENT, " + "MAX_FIXED, "
			+ "LEFT_FIELD_PID, " + "RIGHT_FIELD_PID, " + "HAS_AUTO_FILLIN, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW FROM PUBLIC.FIELD_DEFNS WHERE FIELD_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "FIELD_DEFN_PID, " + "VERSION_NAME, " + "SQL_NAME, " + "SQL_TYPE, " + "DATA_TYPE_KEY, "
			+ "ENCODE_TYPE_KEY, " + "FIELD_FORMAT_KEY, " + "FIELD_VALID_KEY, " + "FIELD_RECENT_PID, " + "MAX_RECENT, "
			+ "MAX_FIXED, " + "LEFT_FIELD_PID, " + "RIGHT_FIELD_PID, " + "HAS_AUTO_FILLIN, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.FIELD_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.FIELD_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "FIELD_DEFN_PID, " + "VERSION_NAME, " + "SQL_NAME, " + "SQL_TYPE, " + "DATA_TYPE_KEY, "
			+ "ENCODE_TYPE_KEY, " + "FIELD_FORMAT_KEY, " + "FIELD_VALID_KEY, " + "FIELD_RECENT_PID, " + "MAX_RECENT, "
			+ "MAX_FIXED, " + "LEFT_FIELD_PID, " + "RIGHT_FIELD_PID, " + "HAS_AUTO_FILLIN, " + "REMINDER_KEY, "
			+ "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?)";

	private static final String UPDATE = "UPDATE PUBLIC.FIELD_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "VERSION_NAME = ?, " + "SQL_NAME = ?, " + "SQL_TYPE = ?, " + "DATA_TYPE_KEY = ?, "
			+ "ENCODE_TYPE_KEY = ?, " + "FIELD_FORMAT_KEY = ?, " + "FIELD_VALID_KEY = ?, " + "FIELD_RECENT_PID = ?, "
			+ "MAX_RECENT = ?, " + "MAX_FIXED = ?, " + "LEFT_FIELD_PID = ?, " + "RIGHT_FIELD_PID = ?, "
			+ "HAS_AUTO_FILLIN = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE FIELD_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.FIELD_DEFNS WHERE FIELD_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.FIELD_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private int SetKey;
	private int CommitPid;
	private int FieldDefnPid;
	private String VersionName;
	private String SqlName;
	private String SqlType;
	private short DataTypeKey;
	private short EncodeTypeKey;
	private short FieldFormatKey;
	private short FieldValidKey;
	private int FieldRecentPid;
	private short MaxRecent;
	private short MaxFixed;
	private int LeftFieldPid;
	private int RightFieldPid;
	private boolean HasAutoFillin;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private FieldDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public FieldDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param FieldDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public FieldDefns(int FieldDefnPid) throws SQLException {
		super();
		this.FieldDefnPid = FieldDefnPid;
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
			model = new FieldDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getInt("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setFieldDefnPid(rs.getInt("FIELD_DEFN_PID"));
			model.setVersionName(rs.getString("VERSION_NAME"));
			model.setSqlName(rs.getString("SQL_NAME"));
			model.setSqlType(rs.getString("SQL_TYPE"));
			model.setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
			model.setEncodeTypeKey(rs.getShort("ENCODE_TYPE_KEY"));
			model.setFieldFormatKey(rs.getShort("FIELD_FORMAT_KEY"));
			model.setFieldValidKey(rs.getShort("FIELD_VALID_KEY"));
			model.setFieldRecentPid(rs.getInt("FIELD_RECENT_PID"));
			model.setMaxRecent(rs.getShort("MAX_RECENT"));
			model.setMaxFixed(rs.getShort("MAX_FIXED"));
			model.setLeftFieldPid(rs.getInt("LEFT_FIELD_PID"));
			model.setRightFieldPid(rs.getInt("RIGHT_FIELD_PID"));
			model.setHasAutoFillin(rs.getBoolean("HAS_AUTO_FILLIN"));
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
			model.setSetKey(rs.getInt("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setFieldDefnPid(rs.getInt("FIELD_DEFN_PID"));
			model.setVersionName(rs.getString("VERSION_NAME"));
			model.setSqlName(rs.getString("SQL_NAME"));
			model.setSqlType(rs.getString("SQL_TYPE"));
			model.setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
			model.setEncodeTypeKey(rs.getShort("ENCODE_TYPE_KEY"));
			model.setFieldFormatKey(rs.getShort("FIELD_FORMAT_KEY"));
			model.setFieldValidKey(rs.getShort("FIELD_VALID_KEY"));
			model.setFieldRecentPid(rs.getInt("FIELD_RECENT_PID"));
			model.setMaxRecent(rs.getShort("MAX_RECENT"));
			model.setMaxFixed(rs.getShort("MAX_FIXED"));
			model.setLeftFieldPid(rs.getInt("LEFT_FIELD_PID"));
			model.setRightFieldPid(rs.getInt("RIGHT_FIELD_PID"));
			model.setHasAutoFillin(rs.getBoolean("HAS_AUTO_FILLIN"));
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
	 * Get the DataTypeKey field.
	 *
	 * @return Contents of the DATA_TYPE_KEY column
	 */
	public short getDataTypeKey() {
		return this.DataTypeKey;
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
	 * Get the EncodeTypeKey field.
	 *
	 * @return Contents of the ENCODE_TYPE_KEY column
	 */
	public short getEncodeTypeKey() {
		return this.EncodeTypeKey;
	}

	/**
	 * Get the FieldDefnPid field.
	 *
	 * @return Contents of the FIELD_DEFN_PID column
	 */
	public int getFieldDefnPid() {
		return this.FieldDefnPid;
	}

	/**
	 * Get the FieldFormatKey field.
	 *
	 * @return Contents of the FIELD_FORMAT_KEY column
	 */
	public short getFieldFormatKey() {
		return this.FieldFormatKey;
	}

	/**
	 * Get the FieldRecentPid field.
	 *
	 * @return Contents of the FIELD_RECENT_PID column
	 */
	public int getFieldRecentPid() {
		return this.FieldRecentPid;
	}

	/**
	 * Get the FieldValidKey field.
	 *
	 * @return Contents of the FIELD_VALID_KEY column
	 */
	public short getFieldValidKey() {
		return this.FieldValidKey;
	}

	/**
	 * Get the HasAutoFillin field.
	 *
	 * @return Contents of the HAS_AUTO_FILLIN column
	 */
	public boolean getHasAutoFillin() {
		return this.HasAutoFillin;
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
	 * Get the LeftFieldPid field.
	 *
	 * @return Contents of the LEFT_FIELD_PID column
	 */
	public int getLeftFieldPid() {
		return this.LeftFieldPid;
	}

	/**
	 * Get the MaxFixed field.
	 *
	 * @return Contents of the MAX_FIXED column
	 */
	public short getMaxFixed() {
		return this.MaxFixed;
	}

	/**
	 * Get the MaxRecent field.
	 *
	 * @return Contents of the MAX_RECENT column
	 */
	public short getMaxRecent() {
		return this.MaxRecent;
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
	 * Get the RightFieldPid field.
	 *
	 * @return Contents of the RIGHT_FIELD_PID column
	 */
	public int getRightFieldPid() {
		return this.RightFieldPid;
	}

	/**
	 * Get the SetKey field.
	 *
	 * @return Contents of the SET_KEY column
	 */
	public int getSetKey() {
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
	 * Get the SqlName field.
	 *
	 * @return Contents of the SQL_NAME column
	 */
	public String getSqlName() {
		return this.SqlName;
	}

	/**
	 * Get the SqlType field.
	 *
	 * @return Contents of the SQL_TYPE column
	 */
	public String getSqlType() {
		return this.SqlType;
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
		((FieldDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((FieldDefns) model).setSetKey(rs.getInt("SET_KEY"));
		((FieldDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((FieldDefns) model).setFieldDefnPid(rs.getInt("FIELD_DEFN_PID"));
		((FieldDefns) model).setVersionName(rs.getString("VERSION_NAME"));
		((FieldDefns) model).setSqlName(rs.getString("SQL_NAME"));
		((FieldDefns) model).setSqlType(rs.getString("SQL_TYPE"));
		((FieldDefns) model).setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
		((FieldDefns) model).setEncodeTypeKey(rs.getShort("ENCODE_TYPE_KEY"));
		((FieldDefns) model).setFieldFormatKey(rs.getShort("FIELD_FORMAT_KEY"));
		((FieldDefns) model).setFieldValidKey(rs.getShort("FIELD_VALID_KEY"));
		((FieldDefns) model).setFieldRecentPid(rs.getInt("FIELD_RECENT_PID"));
		((FieldDefns) model).setMaxRecent(rs.getShort("MAX_RECENT"));
		((FieldDefns) model).setMaxFixed(rs.getShort("MAX_FIXED"));
		((FieldDefns) model).setLeftFieldPid(rs.getInt("LEFT_FIELD_PID"));
		((FieldDefns) model).setRightFieldPid(rs.getInt("RIGHT_FIELD_PID"));
		((FieldDefns) model).setHasAutoFillin(rs.getBoolean("HAS_AUTO_FILLIN"));
		((FieldDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((FieldDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((FieldDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((FieldDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((FieldDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((FieldDefns) model).setSetKey(rs.getInt("SET_KEY"));
		((FieldDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((FieldDefns) model).setFieldDefnPid(rs.getInt("FIELD_DEFN_PID"));
		((FieldDefns) model).setVersionName(rs.getString("VERSION_NAME"));
		((FieldDefns) model).setSqlName(rs.getString("SQL_NAME"));
		((FieldDefns) model).setSqlType(rs.getString("SQL_TYPE"));
		((FieldDefns) model).setDataTypeKey(rs.getShort("DATA_TYPE_KEY"));
		((FieldDefns) model).setEncodeTypeKey(rs.getShort("ENCODE_TYPE_KEY"));
		((FieldDefns) model).setFieldFormatKey(rs.getShort("FIELD_FORMAT_KEY"));
		((FieldDefns) model).setFieldValidKey(rs.getShort("FIELD_VALID_KEY"));
		((FieldDefns) model).setFieldRecentPid(rs.getInt("FIELD_RECENT_PID"));
		((FieldDefns) model).setMaxRecent(rs.getShort("MAX_RECENT"));
		((FieldDefns) model).setMaxFixed(rs.getShort("MAX_FIXED"));
		((FieldDefns) model).setLeftFieldPid(rs.getInt("LEFT_FIELD_PID"));
		((FieldDefns) model).setRightFieldPid(rs.getInt("RIGHT_FIELD_PID"));
		((FieldDefns) model).setHasAutoFillin(rs.getBoolean("HAS_AUTO_FILLIN"));
		((FieldDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((FieldDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((FieldDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((FieldDefns) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the DataTypeKey field
	 *
	 * @param DataTypeKey
	 *            Contents of the DATA_TYPE_KEY column
	 */
	public void setDataTypeKey(short DataTypeKey) {
		this.DataTypeKey = DataTypeKey;
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
	 * Set the EncodeTypeKey field
	 *
	 * @param EncodeTypeKey
	 *            Contents of the ENCODE_TYPE_KEY column
	 */
	public void setEncodeTypeKey(short EncodeTypeKey) {
		this.EncodeTypeKey = EncodeTypeKey;
	}

	/**
	 * Set the FieldDefnPid field
	 *
	 * @param FieldDefnPid
	 *            Contents of the FIELD_DEFN_PID column
	 */
	public void setFieldDefnPid(int FieldDefnPid) {
		this.FieldDefnPid = FieldDefnPid;
	}

	/**
	 * Set the FieldFormatKey field
	 *
	 * @param FieldFormatKey
	 *            Contents of the FIELD_FORMAT_KEY column
	 */
	public void setFieldFormatKey(short FieldFormatKey) {
		this.FieldFormatKey = FieldFormatKey;
	}

	/**
	 * Set the FieldRecentPid field
	 *
	 * @param FieldRecentPid
	 *            Contents of the FIELD_RECENT_PID column
	 */
	public void setFieldRecentPid(int FieldRecentPid) {
		this.FieldRecentPid = FieldRecentPid;
	}

	/**
	 * Set the FieldValidKey field
	 *
	 * @param FieldValidKey
	 *            Contents of the FIELD_VALID_KEY column
	 */
	public void setFieldValidKey(short FieldValidKey) {
		this.FieldValidKey = FieldValidKey;
	}

	/**
	 * Set the HasAutoFillin field
	 *
	 * @param HasAutoFillin
	 *            Contents of the HAS_AUTO_FILLIN column
	 */
	public void setHasAutoFillin(boolean HasAutoFillin) {
		this.HasAutoFillin = HasAutoFillin;
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
	 * Set the LeftFieldPid field
	 *
	 * @param LeftFieldPid
	 *            Contents of the LEFT_FIELD_PID column
	 */
	public void setLeftFieldPid(int LeftFieldPid) {
		this.LeftFieldPid = LeftFieldPid;
	}

	/**
	 * Set the MaxFixed field
	 *
	 * @param MaxFixed
	 *            Contents of the MAX_FIXED column
	 */
	public void setMaxFixed(short MaxFixed) {
		this.MaxFixed = MaxFixed;
	}

	/**
	 * Set the MaxRecent field
	 *
	 * @param MaxRecent
	 *            Contents of the MAX_RECENT column
	 */
	public void setMaxRecent(short MaxRecent) {
		this.MaxRecent = MaxRecent;
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
	 * Set the RightFieldPid field
	 *
	 * @param RightFieldPid
	 *            Contents of the RIGHT_FIELD_PID column
	 */
	public void setRightFieldPid(int RightFieldPid) {
		this.RightFieldPid = RightFieldPid;
	}

	/**
	 * Set the SetKey field
	 *
	 * @param SetKey
	 *            Contents of the SET_KEY column
	 */
	public void setSetKey(int SetKey) {
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
	 * Set the SqlName field
	 *
	 * @param SqlName
	 *            Contents of the SQL_NAME column
	 */
	public void setSqlName(String SqlName) {
		this.SqlName = SqlName;
	}

	/**
	 * Set the SqlType field
	 *
	 * @param SqlType
	 *            Contents of the SQL_TYPE column
	 */
	public void setSqlType(String SqlType) {
		this.SqlType = SqlType;
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
