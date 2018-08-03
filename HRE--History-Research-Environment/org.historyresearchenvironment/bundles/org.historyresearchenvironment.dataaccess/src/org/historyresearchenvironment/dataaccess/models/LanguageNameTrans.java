package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the LANGUAGE_NAME_TRANS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class LanguageNameTrans extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "LANGUAGE_NAME_TRAN_PID, " + "TO_LANGUAGE, " + "FROM_LANGUAGE, "
			+ "TRANSLATION FROM PUBLIC.LANGUAGE_NAME_TRANS WHERE LANGUAGE_NAME_TRAN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "LANGUAGE_NAME_TRAN_PID, " + "TO_LANGUAGE, " + "FROM_LANGUAGE, "
			+ "TRANSLATION FROM PUBLIC.LANGUAGE_NAME_TRANS";

	private static final String INSERT = "INSERT INTO PUBLIC.LANGUAGE_NAME_TRANS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "LANGUAGE_NAME_TRAN_PID, " + "TO_LANGUAGE, " + "FROM_LANGUAGE, "
			+ "TRANSLATION) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.LANGUAGE_NAME_TRANSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "TO_LANGUAGE = ?, " + "FROM_LANGUAGE = ?, "
			+ "TRANSLATION = ? WHERE LANGUAGE_NAME_TRAN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.LANGUAGE_NAME_TRANS WHERE LANGUAGE_NAME_TRAN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.LANGUAGE_NAME_TRANS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int LanguageNameTranPid;
	private String ToLanguage;
	private String FromLanguage;
	private String Translation;
	private LanguageNameTrans model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public LanguageNameTrans() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param LanguageNameTranPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public LanguageNameTrans(int LanguageNameTranPid) throws SQLException {
		super();
		this.LanguageNameTranPid = LanguageNameTranPid;
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
			model = new LanguageNameTrans();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setLanguageNameTranPid(rs.getInt("LANGUAGE_NAME_TRAN_PID"));
			model.setToLanguage(rs.getString("TO_LANGUAGE"));
			model.setFromLanguage(rs.getString("FROM_LANGUAGE"));
			model.setTranslation(rs.getString("TRANSLATION"));
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
			model.setLanguageNameTranPid(rs.getInt("LANGUAGE_NAME_TRAN_PID"));
			model.setToLanguage(rs.getString("TO_LANGUAGE"));
			model.setFromLanguage(rs.getString("FROM_LANGUAGE"));
			model.setTranslation(rs.getString("TRANSLATION"));
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
	 * Get the FromLanguage field.
	 *
	 * @return Contents of the FROM_LANGUAGE column
	 */
	public String getFromLanguage() {
		return this.FromLanguage;
	}

	/**
	 * Get the LanguageNameTranPid field.
	 *
	 * @return Contents of the LANGUAGE_NAME_TRAN_PID column
	 */
	public int getLanguageNameTranPid() {
		return this.LanguageNameTranPid;
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
	 * Get the SetKey field.
	 *
	 * @return Contents of the SET_KEY column
	 */
	public short getSetKey() {
		return this.SetKey;
	}

	/**
	 * Get the ToLanguage field.
	 *
	 * @return Contents of the TO_LANGUAGE column
	 */
	public String getToLanguage() {
		return this.ToLanguage;
	}

	/**
	 * Get the Translation field.
	 *
	 * @return Contents of the TRANSLATION column
	 */
	public String getTranslation() {
		return this.Translation;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((LanguageNameTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((LanguageNameTrans) model).setSetKey(rs.getShort("SET_KEY"));
		((LanguageNameTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((LanguageNameTrans) model).setLanguageNameTranPid(rs.getInt("LANGUAGE_NAME_TRAN_PID"));
		((LanguageNameTrans) model).setToLanguage(rs.getString("TO_LANGUAGE"));
		((LanguageNameTrans) model).setFromLanguage(rs.getString("FROM_LANGUAGE"));
		((LanguageNameTrans) model).setTranslation(rs.getString("TRANSLATION"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((LanguageNameTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((LanguageNameTrans) model).setSetKey(rs.getShort("SET_KEY"));
		((LanguageNameTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((LanguageNameTrans) model).setLanguageNameTranPid(rs.getInt("LANGUAGE_NAME_TRAN_PID"));
		((LanguageNameTrans) model).setToLanguage(rs.getString("TO_LANGUAGE"));
		((LanguageNameTrans) model).setFromLanguage(rs.getString("FROM_LANGUAGE"));
		((LanguageNameTrans) model).setTranslation(rs.getString("TRANSLATION"));
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
	 * Set the FromLanguage field
	 *
	 * @param FromLanguage
	 *            Contents of the FROM_LANGUAGE column
	 */
	public void setFromLanguage(String FromLanguage) {
		this.FromLanguage = FromLanguage;
	}

	/**
	 * Set the LanguageNameTranPid field
	 *
	 * @param LanguageNameTranPid
	 *            Contents of the LANGUAGE_NAME_TRAN_PID column
	 */
	public void setLanguageNameTranPid(int LanguageNameTranPid) {
		this.LanguageNameTranPid = LanguageNameTranPid;
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
	 * Set the SetKey field
	 *
	 * @param SetKey
	 *            Contents of the SET_KEY column
	 */
	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	/**
	 * Set the ToLanguage field
	 *
	 * @param ToLanguage
	 *            Contents of the TO_LANGUAGE column
	 */
	public void setToLanguage(String ToLanguage) {
		this.ToLanguage = ToLanguage;
	}

	/**
	 * Set the Translation field
	 *
	 * @param Translation
	 *            Contents of the TRANSLATION column
	 */
	public void setTranslation(String Translation) {
		this.Translation = Translation;
	}

}
