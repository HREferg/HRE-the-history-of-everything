package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the ENCODING_TYPE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class EncodingTypeDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "ENCODING_TYPE_DEFN_PID, " + "IS_IMPORT_TYPE, " + "IS_INTERNAL_TYPE, " + "IS_EXPORT_TYPE, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.ENCODING_TYPE_DEFNS WHERE ENCODING_TYPE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "ENCODING_TYPE_DEFN_PID, " + "IS_IMPORT_TYPE, " + "IS_INTERNAL_TYPE, " + "IS_EXPORT_TYPE, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.ENCODING_TYPE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.ENCODING_TYPE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "ENCODING_TYPE_DEFN_PID, " + "IS_IMPORT_TYPE, " + "IS_INTERNAL_TYPE, "
			+ "IS_EXPORT_TYPE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.ENCODING_TYPE_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_IMPORT_TYPE = ?, " + "IS_INTERNAL_TYPE = ?, " + "IS_EXPORT_TYPE = ?, "
			+ "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE ENCODING_TYPE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.ENCODING_TYPE_DEFNS WHERE ENCODING_TYPE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.ENCODING_TYPE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int EncodingTypeDefnPid;
	private boolean IsImportType;
	private boolean IsInternalType;
	private boolean IsExportType;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private EncodingTypeDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public EncodingTypeDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param EncodingTypeDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public EncodingTypeDefns(int EncodingTypeDefnPid) throws SQLException {
		super();
		this.EncodingTypeDefnPid = EncodingTypeDefnPid;
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
			model = new EncodingTypeDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setEncodingTypeDefnPid(rs.getInt("ENCODING_TYPE_DEFN_PID"));
			model.setIsImportType(rs.getBoolean("IS_IMPORT_TYPE"));
			model.setIsInternalType(rs.getBoolean("IS_INTERNAL_TYPE"));
			model.setIsExportType(rs.getBoolean("IS_EXPORT_TYPE"));
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
			model.setEncodingTypeDefnPid(rs.getInt("ENCODING_TYPE_DEFN_PID"));
			model.setIsImportType(rs.getBoolean("IS_IMPORT_TYPE"));
			model.setIsInternalType(rs.getBoolean("IS_INTERNAL_TYPE"));
			model.setIsExportType(rs.getBoolean("IS_EXPORT_TYPE"));
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
	 * Get the EncodingTypeDefnPid field.
	 *
	 * @return Contents of the ENCODING_TYPE_DEFN_PID column
	 */
	public int getEncodingTypeDefnPid() {
		return this.EncodingTypeDefnPid;
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
	 * Get the IsExportType field.
	 *
	 * @return Contents of the IS_EXPORT_TYPE column
	 */
	public boolean getIsExportType() {
		return this.IsExportType;
	}

	/**
	 * Get the IsImportType field.
	 *
	 * @return Contents of the IS_IMPORT_TYPE column
	 */
	public boolean getIsImportType() {
		return this.IsImportType;
	}

	/**
	 * Get the IsInternalType field.
	 *
	 * @return Contents of the IS_INTERNAL_TYPE column
	 */
	public boolean getIsInternalType() {
		return this.IsInternalType;
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
		((EncodingTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((EncodingTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((EncodingTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((EncodingTypeDefns) model).setEncodingTypeDefnPid(rs.getInt("ENCODING_TYPE_DEFN_PID"));
		((EncodingTypeDefns) model).setIsImportType(rs.getBoolean("IS_IMPORT_TYPE"));
		((EncodingTypeDefns) model).setIsInternalType(rs.getBoolean("IS_INTERNAL_TYPE"));
		((EncodingTypeDefns) model).setIsExportType(rs.getBoolean("IS_EXPORT_TYPE"));
		((EncodingTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((EncodingTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((EncodingTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((EncodingTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((EncodingTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((EncodingTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((EncodingTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((EncodingTypeDefns) model).setEncodingTypeDefnPid(rs.getInt("ENCODING_TYPE_DEFN_PID"));
		((EncodingTypeDefns) model).setIsImportType(rs.getBoolean("IS_IMPORT_TYPE"));
		((EncodingTypeDefns) model).setIsInternalType(rs.getBoolean("IS_INTERNAL_TYPE"));
		((EncodingTypeDefns) model).setIsExportType(rs.getBoolean("IS_EXPORT_TYPE"));
		((EncodingTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((EncodingTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((EncodingTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((EncodingTypeDefns) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the EncodingTypeDefnPid field
	 *
	 * @param EncodingTypeDefnPid
	 *            Contents of the ENCODING_TYPE_DEFN_PID column
	 */
	public void setEncodingTypeDefnPid(int EncodingTypeDefnPid) {
		this.EncodingTypeDefnPid = EncodingTypeDefnPid;
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
	 * Set the IsExportType field
	 *
	 * @param IsExportType
	 *            Contents of the IS_EXPORT_TYPE column
	 */
	public void setIsExportType(boolean IsExportType) {
		this.IsExportType = IsExportType;
	}

	/**
	 * Set the IsImportType field
	 *
	 * @param IsImportType
	 *            Contents of the IS_IMPORT_TYPE column
	 */
	public void setIsImportType(boolean IsImportType) {
		this.IsImportType = IsImportType;
	}

	/**
	 * Set the IsInternalType field
	 *
	 * @param IsInternalType
	 *            Contents of the IS_INTERNAL_TYPE column
	 */
	public void setIsInternalType(boolean IsInternalType) {
		this.IsInternalType = IsInternalType;
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
