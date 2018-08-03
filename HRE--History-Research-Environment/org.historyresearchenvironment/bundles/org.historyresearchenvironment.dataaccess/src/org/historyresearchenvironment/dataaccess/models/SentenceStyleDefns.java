package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SENTENCE_STYLE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SentenceStyleDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SENTENCE_STYLE_DEFN_PID, " + "IS_SYSTEM, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.SENTENCE_STYLE_DEFNS WHERE SENTENCE_STYLE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SENTENCE_STYLE_DEFN_PID, " + "IS_SYSTEM, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.SENTENCE_STYLE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.SENTENCE_STYLE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SENTENCE_STYLE_DEFN_PID, " + "IS_SYSTEM, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SENTENCE_STYLE_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE SENTENCE_STYLE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SENTENCE_STYLE_DEFNS WHERE SENTENCE_STYLE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SENTENCE_STYLE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SentenceStyleDefnPid;
	private boolean IsSystem;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private SentenceStyleDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SentenceStyleDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param SentenceStyleDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SentenceStyleDefns(int SentenceStyleDefnPid) throws SQLException {
		super();
		this.SentenceStyleDefnPid = SentenceStyleDefnPid;
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
			model = new SentenceStyleDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSentenceStyleDefnPid(rs.getInt("SENTENCE_STYLE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
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
			model.setSentenceStyleDefnPid(rs.getInt("SENTENCE_STYLE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
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
	 * Get the IsSystem field.
	 *
	 * @return Contents of the IS_SYSTEM column
	 */
	public boolean getIsSystem() {
		return this.IsSystem;
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
	 * Get the SentenceStyleDefnPid field.
	 *
	 * @return Contents of the SENTENCE_STYLE_DEFN_PID column
	 */
	public int getSentenceStyleDefnPid() {
		return this.SentenceStyleDefnPid;
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
		((SentenceStyleDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SentenceStyleDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SentenceStyleDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SentenceStyleDefns) model).setSentenceStyleDefnPid(rs.getInt("SENTENCE_STYLE_DEFN_PID"));
		((SentenceStyleDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SentenceStyleDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SentenceStyleDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SentenceStyleDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((SentenceStyleDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SentenceStyleDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SentenceStyleDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SentenceStyleDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SentenceStyleDefns) model).setSentenceStyleDefnPid(rs.getInt("SENTENCE_STYLE_DEFN_PID"));
		((SentenceStyleDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((SentenceStyleDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SentenceStyleDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SentenceStyleDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((SentenceStyleDefns) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the IsSystem field
	 *
	 * @param IsSystem
	 *            Contents of the IS_SYSTEM column
	 */
	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
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
	 * Set the SentenceStyleDefnPid field
	 *
	 * @param SentenceStyleDefnPid
	 *            Contents of the SENTENCE_STYLE_DEFN_PID column
	 */
	public void setSentenceStyleDefnPid(int SentenceStyleDefnPid) {
		this.SentenceStyleDefnPid = SentenceStyleDefnPid;
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
