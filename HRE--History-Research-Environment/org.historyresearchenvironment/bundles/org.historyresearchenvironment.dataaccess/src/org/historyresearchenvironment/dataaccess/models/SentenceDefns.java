package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SENTENCE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SentenceDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SENTENCE_TEMPLATE_DEFN_PID, " + "IS_SYSTEM, " + "PLUGIN_KEY, " + "SENTENCE_SET_KEY, "
			+ "SENTCE_STYLE_TYPE_KEY, " + "REQUESTER_TYPE_KEY, " + "REQUESTER_SUB_TYPE_KEY, " + "REQUESTER_PID, "
			+ "PUBLISH_TYPE_KEY FROM PUBLIC.SENTENCE_DEFNS WHERE SENTENCE_TEMPLATE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SENTENCE_TEMPLATE_DEFN_PID, " + "IS_SYSTEM, " + "PLUGIN_KEY, " + "SENTENCE_SET_KEY, "
			+ "SENTCE_STYLE_TYPE_KEY, " + "REQUESTER_TYPE_KEY, " + "REQUESTER_SUB_TYPE_KEY, " + "REQUESTER_PID, "
			+ "PUBLISH_TYPE_KEY FROM PUBLIC.SENTENCE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.SENTENCE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SENTENCE_TEMPLATE_DEFN_PID, " + "IS_SYSTEM, " + "PLUGIN_KEY, " + "SENTENCE_SET_KEY, "
			+ "SENTCE_STYLE_TYPE_KEY, " + "REQUESTER_TYPE_KEY, " + "REQUESTER_SUB_TYPE_KEY, " + "REQUESTER_PID, "
			+ "PUBLISH_TYPE_KEY) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SENTENCE_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PLUGIN_KEY = ?, " + "SENTENCE_SET_KEY = ?, "
			+ "SENTCE_STYLE_TYPE_KEY = ?, " + "REQUESTER_TYPE_KEY = ?, " + "REQUESTER_SUB_TYPE_KEY = ?, "
			+ "REQUESTER_PID = ?, " + "PUBLISH_TYPE_KEY = ? WHERE SENTENCE_TEMPLATE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SENTENCE_DEFNS WHERE SENTENCE_TEMPLATE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SENTENCE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SentenceTemplateDefnPid;
	private boolean IsSystem;
	private short PluginKey;
	private short SentenceSetKey;
	private short SentceStyleTypeKey;
	private short RequesterTypeKey;
	private short RequesterSubTypeKey;
	private int RequesterPid;
	private short PublishTypeKey;
	private SentenceDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SentenceDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param SentenceTemplateDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SentenceDefns(int SentenceTemplateDefnPid) throws SQLException {
		super();
		this.SentenceTemplateDefnPid = SentenceTemplateDefnPid;
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
			model = new SentenceDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSentenceTemplateDefnPid(rs.getInt("SENTENCE_TEMPLATE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setSentenceSetKey(rs.getShort("SENTENCE_SET_KEY"));
			model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
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
			model.setSentenceTemplateDefnPid(rs.getInt("SENTENCE_TEMPLATE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setSentenceSetKey(rs.getShort("SENTENCE_SET_KEY"));
			model.setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
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
	 * Get the SentceStyleTypeKey field.
	 *
	 * @return Contents of the SENTCE_STYLE_TYPE_KEY column
	 */
	public short getSentceStyleTypeKey() {
		return this.SentceStyleTypeKey;
	}

	/**
	 * Get the SentenceSetKey field.
	 *
	 * @return Contents of the SENTENCE_SET_KEY column
	 */
	public short getSentenceSetKey() {
		return this.SentenceSetKey;
	}

	/**
	 * Get the SentenceTemplateDefnPid field.
	 *
	 * @return Contents of the SENTENCE_TEMPLATE_DEFN_PID column
	 */
	public int getSentenceTemplateDefnPid() {
		return this.SentenceTemplateDefnPid;
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
		((SentenceDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SentenceDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SentenceDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SentenceDefns) model).setSentenceTemplateDefnPid(rs.getInt("SENTENCE_TEMPLATE_DEFN_PID"));
		((SentenceDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SentenceDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((SentenceDefns) model).setSentenceSetKey(rs.getShort("SENTENCE_SET_KEY"));
		((SentenceDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
		((SentenceDefns) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
		((SentenceDefns) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
		((SentenceDefns) model).setRequesterPid(rs.getInt("REQUESTER_PID"));
		((SentenceDefns) model).setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SentenceDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SentenceDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SentenceDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SentenceDefns) model).setSentenceTemplateDefnPid(rs.getInt("SENTENCE_TEMPLATE_DEFN_PID"));
		((SentenceDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SentenceDefns) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((SentenceDefns) model).setSentenceSetKey(rs.getShort("SENTENCE_SET_KEY"));
		((SentenceDefns) model).setSentceStyleTypeKey(rs.getShort("SENTCE_STYLE_TYPE_KEY"));
		((SentenceDefns) model).setRequesterTypeKey(rs.getShort("REQUESTER_TYPE_KEY"));
		((SentenceDefns) model).setRequesterSubTypeKey(rs.getShort("REQUESTER_SUB_TYPE_KEY"));
		((SentenceDefns) model).setRequesterPid(rs.getInt("REQUESTER_PID"));
		((SentenceDefns) model).setPublishTypeKey(rs.getShort("PUBLISH_TYPE_KEY"));
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
	 * Set the SentceStyleTypeKey field
	 *
	 * @param SentceStyleTypeKey
	 *            Contents of the SENTCE_STYLE_TYPE_KEY column
	 */
	public void setSentceStyleTypeKey(short SentceStyleTypeKey) {
		this.SentceStyleTypeKey = SentceStyleTypeKey;
	}

	/**
	 * Set the SentenceSetKey field
	 *
	 * @param SentenceSetKey
	 *            Contents of the SENTENCE_SET_KEY column
	 */
	public void setSentenceSetKey(short SentenceSetKey) {
		this.SentenceSetKey = SentenceSetKey;
	}

	/**
	 * Set the SentenceTemplateDefnPid field
	 *
	 * @param SentenceTemplateDefnPid
	 *            Contents of the SENTENCE_TEMPLATE_DEFN_PID column
	 */
	public void setSentenceTemplateDefnPid(int SentenceTemplateDefnPid) {
		this.SentenceTemplateDefnPid = SentenceTemplateDefnPid;
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
