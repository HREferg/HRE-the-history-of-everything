package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the FIELD_TYPE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class FieldTypeDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "FIELD_TYPE_DEFN_PID, " + "DATA_TYPE_PID, " + "IN_FORMAT_PID, " + "OUT_FORMAT_KEY, " + "MIN_INTEGER, "
			+ "MAX_INTEGER, " + "MIN_FLOAT, " + "MAX_FLOAT, " + "MAX_STRING_LEN, " + "MIN_STRING_LEN, "
			+ "ENCODING_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.FIELD_TYPE_DEFNS WHERE FIELD_TYPE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "FIELD_TYPE_DEFN_PID, " + "DATA_TYPE_PID, " + "IN_FORMAT_PID, " + "OUT_FORMAT_KEY, " + "MIN_INTEGER, "
			+ "MAX_INTEGER, " + "MIN_FLOAT, " + "MAX_FLOAT, " + "MAX_STRING_LEN, " + "MIN_STRING_LEN, "
			+ "ENCODING_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.FIELD_TYPE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.FIELD_TYPE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "FIELD_TYPE_DEFN_PID, " + "DATA_TYPE_PID, " + "IN_FORMAT_PID, " + "OUT_FORMAT_KEY, "
			+ "MIN_INTEGER, " + "MAX_INTEGER, " + "MIN_FLOAT, " + "MAX_FLOAT, " + "MAX_STRING_LEN, "
			+ "MIN_STRING_LEN, " + "ENCODING_KEY, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.FIELD_TYPE_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "DATA_TYPE_PID = ?, " + "IN_FORMAT_PID = ?, " + "OUT_FORMAT_KEY = ?, "
			+ "MIN_INTEGER = ?, " + "MAX_INTEGER = ?, " + "MIN_FLOAT = ?, " + "MAX_FLOAT = ?, " + "MAX_STRING_LEN = ?, "
			+ "MIN_STRING_LEN = ?, " + "ENCODING_KEY = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, "
			+ "IS_DEFAULT = ?, " + "SHOW = ? WHERE FIELD_TYPE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.FIELD_TYPE_DEFNS WHERE FIELD_TYPE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.FIELD_TYPE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int FieldTypeDefnPid;
	private short DataTypePid;
	private int InFormatPid;
	private short OutFormatKey;
	private long MinInteger;
	private long MaxInteger;
	private double MinFloat;
	private double MaxFloat;
	private int MaxStringLen;
	private int MinStringLen;
	private short EncodingKey;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private FieldTypeDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public FieldTypeDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param FieldTypeDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public FieldTypeDefns(int FieldTypeDefnPid) throws SQLException {
		super();
		this.FieldTypeDefnPid = FieldTypeDefnPid;
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
			model = new FieldTypeDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setFieldTypeDefnPid(rs.getInt("FIELD_TYPE_DEFN_PID"));
			model.setDataTypePid(rs.getShort("DATA_TYPE_PID"));
			model.setInFormatPid(rs.getInt("IN_FORMAT_PID"));
			model.setOutFormatKey(rs.getShort("OUT_FORMAT_KEY"));
			model.setMinInteger(rs.getLong("MIN_INTEGER"));
			model.setMaxInteger(rs.getLong("MAX_INTEGER"));
			model.setMinFloat(rs.getDouble("MIN_FLOAT"));
			model.setMaxFloat(rs.getDouble("MAX_FLOAT"));
			model.setMaxStringLen(rs.getInt("MAX_STRING_LEN"));
			model.setMinStringLen(rs.getInt("MIN_STRING_LEN"));
			model.setEncodingKey(rs.getShort("ENCODING_KEY"));
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
			model.setFieldTypeDefnPid(rs.getInt("FIELD_TYPE_DEFN_PID"));
			model.setDataTypePid(rs.getShort("DATA_TYPE_PID"));
			model.setInFormatPid(rs.getInt("IN_FORMAT_PID"));
			model.setOutFormatKey(rs.getShort("OUT_FORMAT_KEY"));
			model.setMinInteger(rs.getLong("MIN_INTEGER"));
			model.setMaxInteger(rs.getLong("MAX_INTEGER"));
			model.setMinFloat(rs.getDouble("MIN_FLOAT"));
			model.setMaxFloat(rs.getDouble("MAX_FLOAT"));
			model.setMaxStringLen(rs.getInt("MAX_STRING_LEN"));
			model.setMinStringLen(rs.getInt("MIN_STRING_LEN"));
			model.setEncodingKey(rs.getShort("ENCODING_KEY"));
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
	 * Get the DataTypePid field.
	 *
	 * @return Contents of the DATA_TYPE_PID column
	 */
	public short getDataTypePid() {
		return this.DataTypePid;
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
	 * Get the EncodingKey field.
	 *
	 * @return Contents of the ENCODING_KEY column
	 */
	public short getEncodingKey() {
		return this.EncodingKey;
	}

	/**
	 * Get the FieldTypeDefnPid field.
	 *
	 * @return Contents of the FIELD_TYPE_DEFN_PID column
	 */
	public int getFieldTypeDefnPid() {
		return this.FieldTypeDefnPid;
	}

	/**
	 * Get the InFormatPid field.
	 *
	 * @return Contents of the IN_FORMAT_PID column
	 */
	public int getInFormatPid() {
		return this.InFormatPid;
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
	 * Get the MaxFloat field.
	 *
	 * @return Contents of the MAX_FLOAT column
	 */
	public double getMaxFloat() {
		return this.MaxFloat;
	}

	/**
	 * Get the MaxInteger field.
	 *
	 * @return Contents of the MAX_INTEGER column
	 */
	public long getMaxInteger() {
		return this.MaxInteger;
	}

	/**
	 * Get the MaxStringLen field.
	 *
	 * @return Contents of the MAX_STRING_LEN column
	 */
	public int getMaxStringLen() {
		return this.MaxStringLen;
	}

	/**
	 * Get the MinFloat field.
	 *
	 * @return Contents of the MIN_FLOAT column
	 */
	public double getMinFloat() {
		return this.MinFloat;
	}

	/**
	 * Get the MinInteger field.
	 *
	 * @return Contents of the MIN_INTEGER column
	 */
	public long getMinInteger() {
		return this.MinInteger;
	}

	/**
	 * Get the MinStringLen field.
	 *
	 * @return Contents of the MIN_STRING_LEN column
	 */
	public int getMinStringLen() {
		return this.MinStringLen;
	}

	/**
	 * Get the OutFormatKey field.
	 *
	 * @return Contents of the OUT_FORMAT_KEY column
	 */
	public short getOutFormatKey() {
		return this.OutFormatKey;
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
		((FieldTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((FieldTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((FieldTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((FieldTypeDefns) model).setFieldTypeDefnPid(rs.getInt("FIELD_TYPE_DEFN_PID"));
		((FieldTypeDefns) model).setDataTypePid(rs.getShort("DATA_TYPE_PID"));
		((FieldTypeDefns) model).setInFormatPid(rs.getInt("IN_FORMAT_PID"));
		((FieldTypeDefns) model).setOutFormatKey(rs.getShort("OUT_FORMAT_KEY"));
		((FieldTypeDefns) model).setMinInteger(rs.getLong("MIN_INTEGER"));
		((FieldTypeDefns) model).setMaxInteger(rs.getLong("MAX_INTEGER"));
		((FieldTypeDefns) model).setMinFloat(rs.getDouble("MIN_FLOAT"));
		((FieldTypeDefns) model).setMaxFloat(rs.getDouble("MAX_FLOAT"));
		((FieldTypeDefns) model).setMaxStringLen(rs.getInt("MAX_STRING_LEN"));
		((FieldTypeDefns) model).setMinStringLen(rs.getInt("MIN_STRING_LEN"));
		((FieldTypeDefns) model).setEncodingKey(rs.getShort("ENCODING_KEY"));
		((FieldTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((FieldTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((FieldTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((FieldTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((FieldTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((FieldTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((FieldTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((FieldTypeDefns) model).setFieldTypeDefnPid(rs.getInt("FIELD_TYPE_DEFN_PID"));
		((FieldTypeDefns) model).setDataTypePid(rs.getShort("DATA_TYPE_PID"));
		((FieldTypeDefns) model).setInFormatPid(rs.getInt("IN_FORMAT_PID"));
		((FieldTypeDefns) model).setOutFormatKey(rs.getShort("OUT_FORMAT_KEY"));
		((FieldTypeDefns) model).setMinInteger(rs.getLong("MIN_INTEGER"));
		((FieldTypeDefns) model).setMaxInteger(rs.getLong("MAX_INTEGER"));
		((FieldTypeDefns) model).setMinFloat(rs.getDouble("MIN_FLOAT"));
		((FieldTypeDefns) model).setMaxFloat(rs.getDouble("MAX_FLOAT"));
		((FieldTypeDefns) model).setMaxStringLen(rs.getInt("MAX_STRING_LEN"));
		((FieldTypeDefns) model).setMinStringLen(rs.getInt("MIN_STRING_LEN"));
		((FieldTypeDefns) model).setEncodingKey(rs.getShort("ENCODING_KEY"));
		((FieldTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((FieldTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((FieldTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((FieldTypeDefns) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the DataTypePid field
	 *
	 * @param DataTypePid
	 *            Contents of the DATA_TYPE_PID column
	 */
	public void setDataTypePid(short DataTypePid) {
		this.DataTypePid = DataTypePid;
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
	 * Set the EncodingKey field
	 *
	 * @param EncodingKey
	 *            Contents of the ENCODING_KEY column
	 */
	public void setEncodingKey(short EncodingKey) {
		this.EncodingKey = EncodingKey;
	}

	/**
	 * Set the FieldTypeDefnPid field
	 *
	 * @param FieldTypeDefnPid
	 *            Contents of the FIELD_TYPE_DEFN_PID column
	 */
	public void setFieldTypeDefnPid(int FieldTypeDefnPid) {
		this.FieldTypeDefnPid = FieldTypeDefnPid;
	}

	/**
	 * Set the InFormatPid field
	 *
	 * @param InFormatPid
	 *            Contents of the IN_FORMAT_PID column
	 */
	public void setInFormatPid(int InFormatPid) {
		this.InFormatPid = InFormatPid;
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
	 * Set the MaxFloat field
	 *
	 * @param MaxFloat
	 *            Contents of the MAX_FLOAT column
	 */
	public void setMaxFloat(double MaxFloat) {
		this.MaxFloat = MaxFloat;
	}

	/**
	 * Set the MaxInteger field
	 *
	 * @param MaxInteger
	 *            Contents of the MAX_INTEGER column
	 */
	public void setMaxInteger(long MaxInteger) {
		this.MaxInteger = MaxInteger;
	}

	/**
	 * Set the MaxStringLen field
	 *
	 * @param MaxStringLen
	 *            Contents of the MAX_STRING_LEN column
	 */
	public void setMaxStringLen(int MaxStringLen) {
		this.MaxStringLen = MaxStringLen;
	}

	/**
	 * Set the MinFloat field
	 *
	 * @param MinFloat
	 *            Contents of the MIN_FLOAT column
	 */
	public void setMinFloat(double MinFloat) {
		this.MinFloat = MinFloat;
	}

	/**
	 * Set the MinInteger field
	 *
	 * @param MinInteger
	 *            Contents of the MIN_INTEGER column
	 */
	public void setMinInteger(long MinInteger) {
		this.MinInteger = MinInteger;
	}

	/**
	 * Set the MinStringLen field
	 *
	 * @param MinStringLen
	 *            Contents of the MIN_STRING_LEN column
	 */
	public void setMinStringLen(int MinStringLen) {
		this.MinStringLen = MinStringLen;
	}

	/**
	 * Set the OutFormatKey field
	 *
	 * @param OutFormatKey
	 *            Contents of the OUT_FORMAT_KEY column
	 */
	public void setOutFormatKey(short OutFormatKey) {
		this.OutFormatKey = OutFormatKey;
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
