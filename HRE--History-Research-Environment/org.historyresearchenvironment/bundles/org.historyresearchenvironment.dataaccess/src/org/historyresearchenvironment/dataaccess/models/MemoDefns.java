package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the MEMO_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class MemoDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "MEMO_DEFN_PID, "
			+ "IS_SYSTEM, " + "PLUGIN_KEY, " + "MEMO_SET_KEY, " + "REQUESTER_TYPE_KEY, " + "REQUESTER_SUB_TYPE_KEY, "
			+ "REQUESTER_PID, " + "PUBLISH_TYPE_KEY FROM PUBLIC.MEMO_DEFNS WHERE MEMO_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "MEMO_DEFN_PID, " + "IS_SYSTEM, " + "PLUGIN_KEY, " + "MEMO_SET_KEY, " + "REQUESTER_TYPE_KEY, "
			+ "REQUESTER_SUB_TYPE_KEY, " + "REQUESTER_PID, " + "PUBLISH_TYPE_KEY FROM PUBLIC.MEMO_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.MEMO_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "MEMO_DEFN_PID, " + "IS_SYSTEM, " + "PLUGIN_KEY, " + "MEMO_SET_KEY, "
			+ "REQUESTER_TYPE_KEY, " + "REQUESTER_SUB_TYPE_KEY, " + "REQUESTER_PID, " + "PUBLISH_TYPE_KEY) VALUES (?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.MEMO_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PLUGIN_KEY = ?, " + "MEMO_SET_KEY = ?, "
			+ "REQUESTER_TYPE_KEY = ?, " + "REQUESTER_SUB_TYPE_KEY = ?, " + "REQUESTER_PID = ?, "
			+ "PUBLISH_TYPE_KEY = ? WHERE MEMO_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.MEMO_DEFNS WHERE MEMO_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.MEMO_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int MemoDefnPid;
	private boolean IsSystem;
	private short PluginKey;
	private short MemoSetKey;
	private short RequesterTypeKey;
	private short RequesterSubTypeKey;
	private int RequesterPid;
	private short PublishTypeKey;
	private MemoDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public MemoDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param MemoDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public MemoDefns(int MemoDefnPid) throws SQLException {
		super();
		this.MemoDefnPid = MemoDefnPid;
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
			model = new MemoDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setMemoDefnPid(rs.getInt("MEMO_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setMemoSetKey(rs.getShort("MEMO_SET_KEY"));
			model.setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
			model.setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
			model.setRequesterPid(rs.getInt("REQUESTER_PID"));
			model.setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
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
			model.setMemoDefnPid(rs.getInt("MEMO_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setMemoSetKey(rs.getShort("MEMO_SET_KEY"));
			model.setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
			model.setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
			model.setRequesterPid(rs.getInt("REQUESTER_PID"));
			model.setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
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
	 * Get the IsSystem field.
	 *
	 * @return Contents of the IS_SYSTEM column
	 */
	public boolean getIsSystem() {
		return this.IsSystem;
	}

	/**
	 * Get the MemoDefnPid field.
	 *
	 * @return Contents of the MEMO_DEFN_PID column
	 */
	public int getMemoDefnPid() {
		return this.MemoDefnPid;
	}

	/**
	 * Get the MemoSetKey field.
	 *
	 * @return Contents of the MEMO_SET_KEY column
	 */
	public short getMemoSetKey() {
		return this.MemoSetKey;
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
	 * Get the PublishTypeKey field.
	 *
	 * @return Contents of the PUBLISH_TYPE_KEY column
	 */
	public short getPublishTypeKey() {
		return this.PublishTypeKey;
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
	 * Get the RequesterPid field.
	 *
	 * @return Contents of the REQUESTER_PID column
	 */
	public int getRequesterPid() {
		return this.RequesterPid;
	}

	/**
	 * Get the RequesterSubTypeKey field.
	 *
	 * @return Contents of the REQUESTER_SUB_TYPE_KEY column
	 */
	public short getRequesterSubTypeKey() {
		return this.RequesterSubTypeKey;
	}

	/**
	 * Get the RequesterTypeKey field.
	 *
	 * @return Contents of the REQUESTER_TYPE_KEY column
	 */
	public short getRequesterTypeKey() {
		return this.RequesterTypeKey;
	}

	/**
	 * Get the SetKey field.
	 *
	 * @return Contents of the SET_KEY column
	 */
	public short getSetKey() {
		return this.SetKey;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((MemoDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((MemoDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((MemoDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((MemoDefns) model).setMemoDefnPid(rs.getInt("MEMO_DEFN_PID"));
		((MemoDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((MemoDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((MemoDefns) model).setMemoSetKey(rs.getShort("MEMO_SET_KEY"));
		((MemoDefns) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
		((MemoDefns) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
		((MemoDefns) model).setRequesterPid(rs.getInt("REQUESTER_PID"));
		((MemoDefns) model).setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((MemoDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((MemoDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((MemoDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((MemoDefns) model).setMemoDefnPid(rs.getInt("MEMO_DEFN_PID"));
		((MemoDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((MemoDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((MemoDefns) model).setMemoSetKey(rs.getShort("MEMO_SET_KEY"));
		((MemoDefns) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
		((MemoDefns) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
		((MemoDefns) model).setRequesterPid(rs.getInt("REQUESTER_PID"));
		((MemoDefns) model).setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
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
	 * Set the IsSystem field
	 *
	 * @param IsSystem
	 *            Contents of the IS_SYSTEM column
	 */
	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	/**
	 * Set the MemoDefnPid field
	 *
	 * @param MemoDefnPid
	 *            Contents of the MEMO_DEFN_PID column
	 */
	public void setMemoDefnPid(int MemoDefnPid) {
		this.MemoDefnPid = MemoDefnPid;
	}

	/**
	 * Set the MemoSetKey field
	 *
	 * @param MemoSetKey
	 *            Contents of the MEMO_SET_KEY column
	 */
	public void setMemoSetKey(short MemoSetKey) {
		this.MemoSetKey = MemoSetKey;
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
	 * Set the PublishTypeKey field
	 *
	 * @param PublishTypeKey
	 *            Contents of the PUBLISH_TYPE_KEY column
	 */
	public void setPublishTypeKey(short PublishTypeKey) {
		this.PublishTypeKey = PublishTypeKey;
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
	 * Set the RequesterPid field
	 *
	 * @param RequesterPid
	 *            Contents of the REQUESTER_PID column
	 */
	public void setRequesterPid(int RequesterPid) {
		this.RequesterPid = RequesterPid;
	}

	/**
	 * Set the RequesterSubTypeKey field
	 *
	 * @param RequesterSubTypeKey
	 *            Contents of the REQUESTER_SUB_TYPE_KEY column
	 */
	public void setRequesterSubTypeKey(short RequesterSubTypeKey) {
		this.RequesterSubTypeKey = RequesterSubTypeKey;
	}

	/**
	 * Set the RequesterTypeKey field
	 *
	 * @param RequesterTypeKey
	 *            Contents of the REQUESTER_TYPE_KEY column
	 */
	public void setRequesterTypeKey(short RequesterTypeKey) {
		this.RequesterTypeKey = RequesterTypeKey;
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

}
