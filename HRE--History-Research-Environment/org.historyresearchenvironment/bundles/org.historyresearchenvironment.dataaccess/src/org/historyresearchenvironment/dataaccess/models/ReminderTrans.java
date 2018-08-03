package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the REMINDER_TRANS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class ReminderTrans extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "REMINDER_TRAN_PID, " + "PLUGIN_KEY, " + "IS_WHOLE_SCREEN, " + "SCREEN_KEY, " + "SCREEN_PID, "
			+ "ENTITY_TYPE_KEY, " + "SUB_TYPE_KEY, " + "LANG_CODE, " + "ENCODING_KEY, "
			+ "REMINDER FROM PUBLIC.REMINDER_TRANS WHERE REMINDER_TRAN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "REMINDER_TRAN_PID, " + "PLUGIN_KEY, " + "IS_WHOLE_SCREEN, " + "SCREEN_KEY, " + "SCREEN_PID, "
			+ "ENTITY_TYPE_KEY, " + "SUB_TYPE_KEY, " + "LANG_CODE, " + "ENCODING_KEY, "
			+ "REMINDER FROM PUBLIC.REMINDER_TRANS";

	private static final String INSERT = "INSERT INTO PUBLIC.REMINDER_TRANS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "REMINDER_TRAN_PID, " + "PLUGIN_KEY, " + "IS_WHOLE_SCREEN, " + "SCREEN_KEY, "
			+ "SCREEN_PID, " + "ENTITY_TYPE_KEY, " + "SUB_TYPE_KEY, " + "LANG_CODE, " + "ENCODING_KEY, "
			+ "REMINDER) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.REMINDER_TRANSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "PLUGIN_KEY = ?, " + "IS_WHOLE_SCREEN = ?, " + "SCREEN_KEY = ?, "
			+ "SCREEN_PID = ?, " + "ENTITY_TYPE_KEY = ?, " + "SUB_TYPE_KEY = ?, " + "LANG_CODE = ?, "
			+ "ENCODING_KEY = ?, " + "REMINDER = ? WHERE REMINDER_TRAN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.REMINDER_TRANS WHERE REMINDER_TRAN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.REMINDER_TRANS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int ReminderTranPid;
	private short PluginKey;
	private boolean IsWholeScreen;
	private short ScreenKey;
	private short ScreenPid;
	private short EntityTypeKey;
	private short SubTypeKey;
	private String LangCode;
	private short EncodingKey;
	private String Reminder;
	private ReminderTrans model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public ReminderTrans() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param ReminderTranPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public ReminderTrans(int ReminderTranPid) throws SQLException {
		super();
		this.ReminderTranPid = ReminderTranPid;
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
			model = new ReminderTrans();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setReminderTranPid(rs.getInt("REMINDER_TRAN_PID"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setIsWholeScreen(rs.getBoolean("IS_WHOLE_SCREEN"));
			model.setScreenKey(rs.getShort("SCREEN_KEY"));
			model.setScreenPid(rs.getShort("SCREEN_PID"));
			model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
			model.setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
			model.setLangCode(rs.getString("LANG_CODE"));
			model.setEncodingKey(rs.getShort("ENCODING_KEY"));
			model.setReminder(rs.getString("REMINDER"));
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
			model.setReminderTranPid(rs.getInt("REMINDER_TRAN_PID"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setIsWholeScreen(rs.getBoolean("IS_WHOLE_SCREEN"));
			model.setScreenKey(rs.getShort("SCREEN_KEY"));
			model.setScreenPid(rs.getShort("SCREEN_PID"));
			model.setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
			model.setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
			model.setLangCode(rs.getString("LANG_CODE"));
			model.setEncodingKey(rs.getShort("ENCODING_KEY"));
			model.setReminder(rs.getString("REMINDER"));
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
	 * Get the EncodingKey field.
	 *
	 * @return Contents of the ENCODING_KEY column
	 */
	public short getEncodingKey() {
		return this.EncodingKey;
	}

	/**
	 * Get the EntityTypeKey field.
	 *
	 * @return Contents of the ENTITY_TYPE_KEY column
	 */
	public short getEntityTypeKey() {
		return this.EntityTypeKey;
	}

	/**
	 * Get the IsWholeScreen field.
	 *
	 * @return Contents of the IS_WHOLE_SCREEN column
	 */
	public boolean getIsWholeScreen() {
		return this.IsWholeScreen;
	}

	/**
	 * Get the LangCode field.
	 *
	 * @return Contents of the LANG_CODE column
	 */
	public String getLangCode() {
		return this.LangCode;
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
	 * Get the Reminder field.
	 *
	 * @return Contents of the REMINDER column
	 */
	public String getReminder() {
		return this.Reminder;
	}

	/**
	 * Get the ReminderTranPid field.
	 *
	 * @return Contents of the REMINDER_TRAN_PID column
	 */
	public int getReminderTranPid() {
		return this.ReminderTranPid;
	}

	/**
	 * Get the ScreenKey field.
	 *
	 * @return Contents of the SCREEN_KEY column
	 */
	public short getScreenKey() {
		return this.ScreenKey;
	}

	/**
	 * Get the ScreenPid field.
	 *
	 * @return Contents of the SCREEN_PID column
	 */
	public short getScreenPid() {
		return this.ScreenPid;
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
	 * Get the SubTypeKey field.
	 *
	 * @return Contents of the SUB_TYPE_KEY column
	 */
	public short getSubTypeKey() {
		return this.SubTypeKey;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((ReminderTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((ReminderTrans) model).setSetKey(rs.getShort("SET_KEY"));
		((ReminderTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((ReminderTrans) model).setReminderTranPid(rs.getInt("REMINDER_TRAN_PID"));
		((ReminderTrans) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((ReminderTrans) model).setIsWholeScreen(rs.getBoolean("IS_WHOLE_SCREEN"));
		((ReminderTrans) model).setScreenKey(rs.getShort("SCREEN_KEY"));
		((ReminderTrans) model).setScreenPid(rs.getShort("SCREEN_PID"));
		((ReminderTrans) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
		((ReminderTrans) model).setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
		((ReminderTrans) model).setLangCode(rs.getString("LANG_CODE"));
		((ReminderTrans) model).setEncodingKey(rs.getShort("ENCODING_KEY"));
		((ReminderTrans) model).setReminder(rs.getString("REMINDER"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((ReminderTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((ReminderTrans) model).setSetKey(rs.getShort("SET_KEY"));
		((ReminderTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((ReminderTrans) model).setReminderTranPid(rs.getInt("REMINDER_TRAN_PID"));
		((ReminderTrans) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((ReminderTrans) model).setIsWholeScreen(rs.getBoolean("IS_WHOLE_SCREEN"));
		((ReminderTrans) model).setScreenKey(rs.getShort("SCREEN_KEY"));
		((ReminderTrans) model).setScreenPid(rs.getShort("SCREEN_PID"));
		((ReminderTrans) model).setEntityTypeKey(rs.getShort("ENTITY_TYPE_KEY"));
		((ReminderTrans) model).setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
		((ReminderTrans) model).setLangCode(rs.getString("LANG_CODE"));
		((ReminderTrans) model).setEncodingKey(rs.getShort("ENCODING_KEY"));
		((ReminderTrans) model).setReminder(rs.getString("REMINDER"));
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
	 * Set the EncodingKey field
	 *
	 * @param EncodingKey
	 *            Contents of the ENCODING_KEY column
	 */
	public void setEncodingKey(short EncodingKey) {
		this.EncodingKey = EncodingKey;
	}

	/**
	 * Set the EntityTypeKey field
	 *
	 * @param EntityTypeKey
	 *            Contents of the ENTITY_TYPE_KEY column
	 */
	public void setEntityTypeKey(short EntityTypeKey) {
		this.EntityTypeKey = EntityTypeKey;
	}

	/**
	 * Set the IsWholeScreen field
	 *
	 * @param IsWholeScreen
	 *            Contents of the IS_WHOLE_SCREEN column
	 */
	public void setIsWholeScreen(boolean IsWholeScreen) {
		this.IsWholeScreen = IsWholeScreen;
	}

	/**
	 * Set the LangCode field
	 *
	 * @param LangCode
	 *            Contents of the LANG_CODE column
	 */
	public void setLangCode(String LangCode) {
		this.LangCode = LangCode;
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
	 * Set the Reminder field
	 *
	 * @param Reminder
	 *            Contents of the REMINDER column
	 */
	public void setReminder(String Reminder) {
		this.Reminder = Reminder;
	}

	/**
	 * Set the ReminderTranPid field
	 *
	 * @param ReminderTranPid
	 *            Contents of the REMINDER_TRAN_PID column
	 */
	public void setReminderTranPid(int ReminderTranPid) {
		this.ReminderTranPid = ReminderTranPid;
	}

	/**
	 * Set the ScreenKey field
	 *
	 * @param ScreenKey
	 *            Contents of the SCREEN_KEY column
	 */
	public void setScreenKey(short ScreenKey) {
		this.ScreenKey = ScreenKey;
	}

	/**
	 * Set the ScreenPid field
	 *
	 * @param ScreenPid
	 *            Contents of the SCREEN_PID column
	 */
	public void setScreenPid(short ScreenPid) {
		this.ScreenPid = ScreenPid;
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
	 * Set the SubTypeKey field
	 *
	 * @param SubTypeKey
	 *            Contents of the SUB_TYPE_KEY column
	 */
	public void setSubTypeKey(short SubTypeKey) {
		this.SubTypeKey = SubTypeKey;
	}

}
