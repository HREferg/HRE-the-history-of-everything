package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the TABLE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class TableDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "TABLE_DEFN_PID, "
			+ "PLUGIN_KEY, " + "LAST_RECORD_PID, " + "VERSION_NAME, " + "SQL_NAME, " + "STORAGE_TYPE_KEY, "
			+ "RECORD_VALID_KEY, " + "HAS_FLAGS, " + "HAS_NOTEPADS FROM PUBLIC.TABLE_DEFNS WHERE TABLE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "TABLE_DEFN_PID, " + "PLUGIN_KEY, " + "LAST_RECORD_PID, " + "VERSION_NAME, " + "SQL_NAME, "
			+ "STORAGE_TYPE_KEY, " + "RECORD_VALID_KEY, " + "HAS_FLAGS, " + "HAS_NOTEPADS FROM PUBLIC.TABLE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.TABLE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "TABLE_DEFN_PID, " + "PLUGIN_KEY, " + "LAST_RECORD_PID, " + "VERSION_NAME, "
			+ "SQL_NAME, " + "STORAGE_TYPE_KEY, " + "RECORD_VALID_KEY, " + "HAS_FLAGS, " + "HAS_NOTEPADS) VALUES (?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.TABLE_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "PLUGIN_KEY = ?, " + "LAST_RECORD_PID = ?, " + "VERSION_NAME = ?, "
			+ "SQL_NAME = ?, " + "STORAGE_TYPE_KEY = ?, " + "RECORD_VALID_KEY = ?, " + "HAS_FLAGS = ?, "
			+ "HAS_NOTEPADS = ? WHERE TABLE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.TABLE_DEFNS WHERE TABLE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.TABLE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int TableDefnPid;
	private short PluginKey;
	private int LastRecordPid;
	private String VersionName;
	private String SqlName;
	private short StorageTypeKey;
	private short RecordValidKey;
	private boolean HasFlags;
	private boolean HasNotepads;
	private TableDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public TableDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param TableDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public TableDefns(int TableDefnPid) throws SQLException {
		super();
		this.TableDefnPid = TableDefnPid;
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
			model = new TableDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setTableDefnPid(rs.getInt("TABLE_DEFN_PID"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setLastRecordPid(rs.getInt("LAST_RECORD_PID"));
			model.setVersionName(rs.getString("VERSION_NAME"));
			model.setSqlName(rs.getString("SQL_NAME"));
			model.setStorageTypeKey(rs.getShort("STORAGE_TYPE_KEY"));
			model.setRecordValidKey(rs.getShort("RECORD_VALID_KEY"));
			model.setHasFlags(rs.getBoolean("HAS_FLAGS"));
			model.setHasNotepads(rs.getBoolean("HAS_NOTEPADS"));
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
			model.setTableDefnPid(rs.getInt("TABLE_DEFN_PID"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setLastRecordPid(rs.getInt("LAST_RECORD_PID"));
			model.setVersionName(rs.getString("VERSION_NAME"));
			model.setSqlName(rs.getString("SQL_NAME"));
			model.setStorageTypeKey(rs.getShort("STORAGE_TYPE_KEY"));
			model.setRecordValidKey(rs.getShort("RECORD_VALID_KEY"));
			model.setHasFlags(rs.getBoolean("HAS_FLAGS"));
			model.setHasNotepads(rs.getBoolean("HAS_NOTEPADS"));
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
	 * Get the HasFlags field.
	 *
	 * @return Contents of the HAS_FLAGS column
	 */
	public boolean getHasFlags() {
		return this.HasFlags;
	}

	/**
	 * Get the HasNotepads field.
	 *
	 * @return Contents of the HAS_NOTEPADS column
	 */
	public boolean getHasNotepads() {
		return this.HasNotepads;
	}

	/**
	 * Get the LastRecordPid field.
	 *
	 * @return Contents of the LAST_RECORD_PID column
	 */
	public int getLastRecordPid() {
		return this.LastRecordPid;
	}

	/**
	 * Get the PluginKey field.
	 *
	 * @return Contents of the PLUGIN_KEY column
	 */
	public short getPluginKey() {
		return this.PluginKey;
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
	 * Get the RecordValidKey field.
	 *
	 * @return Contents of the RECORD_VALID_KEY column
	 */
	public short getRecordValidKey() {
		return this.RecordValidKey;
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
	 * Get the SqlName field.
	 *
	 * @return Contents of the SQL_NAME column
	 */
	public String getSqlName() {
		return this.SqlName;
	}

	/**
	 * Get the StorageTypeKey field.
	 *
	 * @return Contents of the STORAGE_TYPE_KEY column
	 */
	public short getStorageTypeKey() {
		return this.StorageTypeKey;
	}

	/**
	 * Get the TableDefnPid field.
	 *
	 * @return Contents of the TABLE_DEFN_PID column
	 */
	public int getTableDefnPid() {
		return this.TableDefnPid;
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
		((TableDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((TableDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((TableDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((TableDefns) model).setTableDefnPid(rs.getInt("TABLE_DEFN_PID"));
		((TableDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((TableDefns) model).setLastRecordPid(rs.getInt("LAST_RECORD_PID"));
		((TableDefns) model).setVersionName(rs.getString("VERSION_NAME"));
		((TableDefns) model).setSqlName(rs.getString("SQL_NAME"));
		((TableDefns) model).setStorageTypeKey(rs.getShort("STORAGE_TYPE_KEY"));
		((TableDefns) model).setRecordValidKey(rs.getShort("RECORD_VALID_KEY"));
		((TableDefns) model).setHasFlags(rs.getBoolean("HAS_FLAGS"));
		((TableDefns) model).setHasNotepads(rs.getBoolean("HAS_NOTEPADS"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((TableDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((TableDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((TableDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((TableDefns) model).setTableDefnPid(rs.getInt("TABLE_DEFN_PID"));
		((TableDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((TableDefns) model).setLastRecordPid(rs.getInt("LAST_RECORD_PID"));
		((TableDefns) model).setVersionName(rs.getString("VERSION_NAME"));
		((TableDefns) model).setSqlName(rs.getString("SQL_NAME"));
		((TableDefns) model).setStorageTypeKey(rs.getShort("STORAGE_TYPE_KEY"));
		((TableDefns) model).setRecordValidKey(rs.getShort("RECORD_VALID_KEY"));
		((TableDefns) model).setHasFlags(rs.getBoolean("HAS_FLAGS"));
		((TableDefns) model).setHasNotepads(rs.getBoolean("HAS_NOTEPADS"));
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
	 * Set the HasFlags field
	 *
	 * @param HasFlags
	 *            Contents of the HAS_FLAGS column
	 */
	public void setHasFlags(boolean HasFlags) {
		this.HasFlags = HasFlags;
	}

	/**
	 * Set the HasNotepads field
	 *
	 * @param HasNotepads
	 *            Contents of the HAS_NOTEPADS column
	 */
	public void setHasNotepads(boolean HasNotepads) {
		this.HasNotepads = HasNotepads;
	}

	/**
	 * Set the LastRecordPid field
	 *
	 * @param LastRecordPid
	 *            Contents of the LAST_RECORD_PID column
	 */
	public void setLastRecordPid(int LastRecordPid) {
		this.LastRecordPid = LastRecordPid;
	}

	/**
	 * Set the PluginKey field
	 *
	 * @param PluginKey
	 *            Contents of the PLUGIN_KEY column
	 */
	public void setPluginKey(short PluginKey) {
		this.PluginKey = PluginKey;
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
	 * Set the RecordValidKey field
	 *
	 * @param RecordValidKey
	 *            Contents of the RECORD_VALID_KEY column
	 */
	public void setRecordValidKey(short RecordValidKey) {
		this.RecordValidKey = RecordValidKey;
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
	 * Set the SqlName field
	 *
	 * @param SqlName
	 *            Contents of the SQL_NAME column
	 */
	public void setSqlName(String SqlName) {
		this.SqlName = SqlName;
	}

	/**
	 * Set the StorageTypeKey field
	 *
	 * @param StorageTypeKey
	 *            Contents of the STORAGE_TYPE_KEY column
	 */
	public void setStorageTypeKey(short StorageTypeKey) {
		this.StorageTypeKey = StorageTypeKey;
	}

	/**
	 * Set the TableDefnPid field
	 *
	 * @param TableDefnPid
	 *            Contents of the TABLE_DEFN_PID column
	 */
	public void setTableDefnPid(int TableDefnPid) {
		this.TableDefnPid = TableDefnPid;
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
