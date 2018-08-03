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

	public FieldTypeDefns() throws SQLException {
	}

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

	public int getCommitPid() {
		return this.CommitPid;
	}

	public short getDataTypePid() {
		return this.DataTypePid;
	}

	public short getDisplayOrder() {
		return this.DisplayOrder;
	}

	public short getEncodingKey() {
		return this.EncodingKey;
	}

	public int getFieldTypeDefnPid() {
		return this.FieldTypeDefnPid;
	}

	public int getInFormatPid() {
		return this.InFormatPid;
	}

	public boolean getIsDefault() {
		return this.IsDefault;
	}

	public double getMaxFloat() {
		return this.MaxFloat;
	}

	public long getMaxInteger() {
		return this.MaxInteger;
	}

	public int getMaxStringLen() {
		return this.MaxStringLen;
	}

	public double getMinFloat() {
		return this.MinFloat;
	}

	public long getMinInteger() {
		return this.MinInteger;
	}

	public int getMinStringLen() {
		return this.MinStringLen;
	}

	public short getOutFormatKey() {
		return this.OutFormatKey;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getReminderKey() {
		return this.ReminderKey;
	}

	public short getSetKey() {
		return this.SetKey;
	}

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

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDataTypePid(short DataTypePid) {
		this.DataTypePid = DataTypePid;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setEncodingKey(short EncodingKey) {
		this.EncodingKey = EncodingKey;
	}

	public void setFieldTypeDefnPid(int FieldTypeDefnPid) {
		this.FieldTypeDefnPid = FieldTypeDefnPid;
	}

	public void setInFormatPid(int InFormatPid) {
		this.InFormatPid = InFormatPid;
	}

	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
	}

	public void setMaxFloat(double MaxFloat) {
		this.MaxFloat = MaxFloat;
	}

	public void setMaxInteger(long MaxInteger) {
		this.MaxInteger = MaxInteger;
	}

	public void setMaxStringLen(int MaxStringLen) {
		this.MaxStringLen = MaxStringLen;
	}

	public void setMinFloat(double MinFloat) {
		this.MinFloat = MinFloat;
	}

	public void setMinInteger(long MinInteger) {
		this.MinInteger = MinInteger;
	}

	public void setMinStringLen(int MinStringLen) {
		this.MinStringLen = MinStringLen;
	}

	public void setOutFormatKey(short OutFormatKey) {
		this.OutFormatKey = OutFormatKey;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setReminderKey(short ReminderKey) {
		this.ReminderKey = ReminderKey;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setShow(boolean Show) {
		this.Show = Show;
	}

}
