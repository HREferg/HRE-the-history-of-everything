package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the GUI_LANGUAGES database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class GuiLanguages extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "GUI_LANGUAGE_PID, " + "REMINDER_KEY, " + "GUI_LANGUAGE, " + "DATA1_LANGUAGE, " + "DATA2_LANGUAGE, "
			+ "REPORT_LANGUAGE, " + "DFLT_LANGUAGE FROM PUBLIC.GUI_LANGUAGES WHERE GUI_LANGUAGE_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "GUI_LANGUAGE_PID, " + "REMINDER_KEY, " + "GUI_LANGUAGE, " + "DATA1_LANGUAGE, " + "DATA2_LANGUAGE, "
			+ "REPORT_LANGUAGE, " + "DFLT_LANGUAGE FROM PUBLIC.GUI_LANGUAGES";

	private static final String INSERT = "INSERT INTO PUBLIC.GUI_LANGUAGES( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "GUI_LANGUAGE_PID, " + "REMINDER_KEY, " + "GUI_LANGUAGE, " + "DATA1_LANGUAGE, "
			+ "DATA2_LANGUAGE, " + "REPORT_LANGUAGE, " + "DFLT_LANGUAGE) VALUES (?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.GUI_LANGUAGESSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "REMINDER_KEY = ?, " + "GUI_LANGUAGE = ?, " + "DATA1_LANGUAGE = ?, "
			+ "DATA2_LANGUAGE = ?, " + "REPORT_LANGUAGE = ?, " + "DFLT_LANGUAGE = ? WHERE GUI_LANGUAGE_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.GUI_LANGUAGES WHERE GUI_LANGUAGE_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.GUI_LANGUAGES";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int GuiLanguagePid;
	private short ReminderKey;
	private String GuiLanguage;
	private String Data1Language;
	private String Data2Language;
	private String ReportLanguage;
	private String DfltLanguage;
	private GuiLanguages model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public GuiLanguages() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param GuiLanguagePid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public GuiLanguages(int GuiLanguagePid) throws SQLException {
		super();
		this.GuiLanguagePid = GuiLanguagePid;
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
			model = new GuiLanguages();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setGuiLanguagePid(rs.getInt("GUI_LANGUAGE_PID"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setGuiLanguage(rs.getString("GUI_LANGUAGE"));
			model.setData1Language(rs.getString("DATA1_LANGUAGE"));
			model.setData2Language(rs.getString("DATA2_LANGUAGE"));
			model.setReportLanguage(rs.getString("REPORT_LANGUAGE"));
			model.setDfltLanguage(rs.getString("DFLT_LANGUAGE"));
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
			model.setGuiLanguagePid(rs.getInt("GUI_LANGUAGE_PID"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setGuiLanguage(rs.getString("GUI_LANGUAGE"));
			model.setData1Language(rs.getString("DATA1_LANGUAGE"));
			model.setData2Language(rs.getString("DATA2_LANGUAGE"));
			model.setReportLanguage(rs.getString("REPORT_LANGUAGE"));
			model.setDfltLanguage(rs.getString("DFLT_LANGUAGE"));
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
	 * Get the Data1Language field.
	 *
	 * @return Contents of the DATA1_LANGUAGE column
	 */
	public String getData1Language() {
		return this.Data1Language;
	}

	/**
	 * Get the Data2Language field.
	 *
	 * @return Contents of the DATA2_LANGUAGE column
	 */
	public String getData2Language() {
		return this.Data2Language;
	}

	/**
	 * Get the DfltLanguage field.
	 *
	 * @return Contents of the DFLT_LANGUAGE column
	 */
	public String getDfltLanguage() {
		return this.DfltLanguage;
	}

	/**
	 * Get the GuiLanguage field.
	 *
	 * @return Contents of the GUI_LANGUAGE column
	 */
	public String getGuiLanguage() {
		return this.GuiLanguage;
	}

	/**
	 * Get the GuiLanguagePid field.
	 *
	 * @return Contents of the GUI_LANGUAGE_PID column
	 */
	public int getGuiLanguagePid() {
		return this.GuiLanguagePid;
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
	 * Get the ReportLanguage field.
	 *
	 * @return Contents of the REPORT_LANGUAGE column
	 */
	public String getReportLanguage() {
		return this.ReportLanguage;
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
		((GuiLanguages) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((GuiLanguages) model).setSetKey(rs.getShort("SET_KEY"));
		((GuiLanguages) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((GuiLanguages) model).setGuiLanguagePid(rs.getInt("GUI_LANGUAGE_PID"));
		((GuiLanguages) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((GuiLanguages) model).setGuiLanguage(rs.getString("GUI_LANGUAGE"));
		((GuiLanguages) model).setData1Language(rs.getString("DATA1_LANGUAGE"));
		((GuiLanguages) model).setData2Language(rs.getString("DATA2_LANGUAGE"));
		((GuiLanguages) model).setReportLanguage(rs.getString("REPORT_LANGUAGE"));
		((GuiLanguages) model).setDfltLanguage(rs.getString("DFLT_LANGUAGE"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((GuiLanguages) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((GuiLanguages) model).setSetKey(rs.getShort("SET_KEY"));
		((GuiLanguages) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((GuiLanguages) model).setGuiLanguagePid(rs.getInt("GUI_LANGUAGE_PID"));
		((GuiLanguages) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((GuiLanguages) model).setGuiLanguage(rs.getString("GUI_LANGUAGE"));
		((GuiLanguages) model).setData1Language(rs.getString("DATA1_LANGUAGE"));
		((GuiLanguages) model).setData2Language(rs.getString("DATA2_LANGUAGE"));
		((GuiLanguages) model).setReportLanguage(rs.getString("REPORT_LANGUAGE"));
		((GuiLanguages) model).setDfltLanguage(rs.getString("DFLT_LANGUAGE"));
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
	 * Set the Data1Language field
	 *
	 * @param Data1Language
	 *            Contents of the DATA1_LANGUAGE column
	 */
	public void setData1Language(String Data1Language) {
		this.Data1Language = Data1Language;
	}

	/**
	 * Set the Data2Language field
	 *
	 * @param Data2Language
	 *            Contents of the DATA2_LANGUAGE column
	 */
	public void setData2Language(String Data2Language) {
		this.Data2Language = Data2Language;
	}

	/**
	 * Set the DfltLanguage field
	 *
	 * @param DfltLanguage
	 *            Contents of the DFLT_LANGUAGE column
	 */
	public void setDfltLanguage(String DfltLanguage) {
		this.DfltLanguage = DfltLanguage;
	}

	/**
	 * Set the GuiLanguage field
	 *
	 * @param GuiLanguage
	 *            Contents of the GUI_LANGUAGE column
	 */
	public void setGuiLanguage(String GuiLanguage) {
		this.GuiLanguage = GuiLanguage;
	}

	/**
	 * Set the GuiLanguagePid field
	 *
	 * @param GuiLanguagePid
	 *            Contents of the GUI_LANGUAGE_PID column
	 */
	public void setGuiLanguagePid(int GuiLanguagePid) {
		this.GuiLanguagePid = GuiLanguagePid;
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
	 * Set the ReportLanguage field
	 *
	 * @param ReportLanguage
	 *            Contents of the REPORT_LANGUAGE column
	 */
	public void setReportLanguage(String ReportLanguage) {
		this.ReportLanguage = ReportLanguage;
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
