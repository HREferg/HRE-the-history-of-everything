package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the HINTERVALS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class Hintervals extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "HINTERVAL_PID, "
			+ "IS_SYSTEM, " + "IS_HUMAN_CALENDAR, " + "HINTERVAL1, " + "HINTERVAL2, " + "SORT_HINTERVAL1, "
			+ "SORT_HINTERVAL2, " + "ORIGINAL_TEXT, " + "LANG_CODE, " + "HINTERVAL_TYPE_KEY, " + "NAMED_MEMO_PID, "
			+ "SURETY FROM PUBLIC.HINTERVALS WHERE HINTERVAL_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "HINTERVAL_PID, " + "IS_SYSTEM, " + "IS_HUMAN_CALENDAR, " + "HINTERVAL1, " + "HINTERVAL2, "
			+ "SORT_HINTERVAL1, " + "SORT_HINTERVAL2, " + "ORIGINAL_TEXT, " + "LANG_CODE, " + "HINTERVAL_TYPE_KEY, "
			+ "NAMED_MEMO_PID, " + "SURETY FROM PUBLIC.HINTERVALS";

	private static final String INSERT = "INSERT INTO PUBLIC.HINTERVALS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "HINTERVAL_PID, " + "IS_SYSTEM, " + "IS_HUMAN_CALENDAR, " + "HINTERVAL1, "
			+ "HINTERVAL2, " + "SORT_HINTERVAL1, " + "SORT_HINTERVAL2, " + "ORIGINAL_TEXT, " + "LANG_CODE, "
			+ "HINTERVAL_TYPE_KEY, " + "NAMED_MEMO_PID, " + "SURETY) VALUES (?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.HINTERVALSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "IS_HUMAN_CALENDAR = ?, " + "HINTERVAL1 = ?, "
			+ "HINTERVAL2 = ?, " + "SORT_HINTERVAL1 = ?, " + "SORT_HINTERVAL2 = ?, " + "ORIGINAL_TEXT = ?, "
			+ "LANG_CODE = ?, " + "HINTERVAL_TYPE_KEY = ?, " + "NAMED_MEMO_PID = ?, "
			+ "SURETY = ? WHERE HINTERVAL_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.HINTERVALS WHERE HINTERVAL_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.HINTERVALS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int HintervalPid;
	private boolean IsSystem;
	private boolean IsHumanCalendar;
	private long Hinterval1;
	private long Hinterval2;
	private long SortHinterval1;
	private long SortHinterval2;
	private String OriginalText;
	private String LangCode;
	private short HintervalTypeKey;
	private int NamedMemoPid;
	private String Surety;
	private Hintervals model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public Hintervals() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param HintervalPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public Hintervals(int HintervalPid) throws SQLException {
		super();
		this.HintervalPid = HintervalPid;
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
			model = new Hintervals();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setHintervalPid(rs.getInt("HINTERVAL_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setIsHumanCalendar(rs.getBoolean("IS_HUMAN_CALENDAR"));
			model.setHinterval1(rs.getLong("HINTERVAL1"));
			model.setHinterval2(rs.getLong("HINTERVAL2"));
			model.setSortHinterval1(rs.getLong("SORT_HINTERVAL1"));
			model.setSortHinterval2(rs.getLong("SORT_HINTERVAL2"));
			model.setOriginalText(rs.getString("ORIGINAL_TEXT"));
			model.setLangCode(rs.getString("LANG_CODE"));
			model.setHintervalTypeKey(rs.getShort("HINTERVAL_TYPE_KEY"));
			model.setNamedMemoPid(rs.getInt("NAMED_MEMO_PID"));
			model.setSurety(rs.getString("SURETY"));
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
			model.setHintervalPid(rs.getInt("HINTERVAL_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setIsHumanCalendar(rs.getBoolean("IS_HUMAN_CALENDAR"));
			model.setHinterval1(rs.getLong("HINTERVAL1"));
			model.setHinterval2(rs.getLong("HINTERVAL2"));
			model.setSortHinterval1(rs.getLong("SORT_HINTERVAL1"));
			model.setSortHinterval2(rs.getLong("SORT_HINTERVAL2"));
			model.setOriginalText(rs.getString("ORIGINAL_TEXT"));
			model.setLangCode(rs.getString("LANG_CODE"));
			model.setHintervalTypeKey(rs.getShort("HINTERVAL_TYPE_KEY"));
			model.setNamedMemoPid(rs.getInt("NAMED_MEMO_PID"));
			model.setSurety(rs.getString("SURETY"));
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
	 * Get the Hinterval1 field.
	 *
	 * @return Contents of the HINTERVAL1 column
	 */
	public long getHinterval1() {
		return this.Hinterval1;
	}

	/**
	 * Get the Hinterval2 field.
	 *
	 * @return Contents of the HINTERVAL2 column
	 */
	public long getHinterval2() {
		return this.Hinterval2;
	}

	/**
	 * Get the HintervalPid field.
	 *
	 * @return Contents of the HINTERVAL_PID column
	 */
	public int getHintervalPid() {
		return this.HintervalPid;
	}

	/**
	 * Get the HintervalTypeKey field.
	 *
	 * @return Contents of the HINTERVAL_TYPE_KEY column
	 */
	public short getHintervalTypeKey() {
		return this.HintervalTypeKey;
	}

	/**
	 * Get the IsHumanCalendar field.
	 *
	 * @return Contents of the IS_HUMAN_CALENDAR column
	 */
	public boolean getIsHumanCalendar() {
		return this.IsHumanCalendar;
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
	 * Get the LangCode field.
	 *
	 * @return Contents of the LANG_CODE column
	 */
	public String getLangCode() {
		return this.LangCode;
	}

	/**
	 * Get the NamedMemoPid field.
	 *
	 * @return Contents of the NAMED_MEMO_PID column
	 */
	public int getNamedMemoPid() {
		return this.NamedMemoPid;
	}

	/**
	 * Get the OriginalText field.
	 *
	 * @return Contents of the ORIGINAL_TEXT column
	 */
	public String getOriginalText() {
		return this.OriginalText;
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
	 * Get the SortHinterval1 field.
	 *
	 * @return Contents of the SORT_HINTERVAL1 column
	 */
	public long getSortHinterval1() {
		return this.SortHinterval1;
	}

	/**
	 * Get the SortHinterval2 field.
	 *
	 * @return Contents of the SORT_HINTERVAL2 column
	 */
	public long getSortHinterval2() {
		return this.SortHinterval2;
	}

	/**
	 * Get the Surety field.
	 *
	 * @return Contents of the SURETY column
	 */
	public String getSurety() {
		return this.Surety;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((Hintervals) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Hintervals) model).setSetKey(rs.getShort("SET_KEY"));
		((Hintervals) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Hintervals) model).setHintervalPid(rs.getInt("HINTERVAL_PID"));
		((Hintervals) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((Hintervals) model).setIsHumanCalendar(rs.getBoolean("IS_HUMAN_CALENDAR"));
		((Hintervals) model).setHinterval1(rs.getLong("HINTERVAL1"));
		((Hintervals) model).setHinterval2(rs.getLong("HINTERVAL2"));
		((Hintervals) model).setSortHinterval1(rs.getLong("SORT_HINTERVAL1"));
		((Hintervals) model).setSortHinterval2(rs.getLong("SORT_HINTERVAL2"));
		((Hintervals) model).setOriginalText(rs.getString("ORIGINAL_TEXT"));
		((Hintervals) model).setLangCode(rs.getString("LANG_CODE"));
		((Hintervals) model).setHintervalTypeKey(rs.getShort("HINTERVAL_TYPE_KEY"));
		((Hintervals) model).setNamedMemoPid(rs.getInt("NAMED_MEMO_PID"));
		((Hintervals) model).setSurety(rs.getString("SURETY"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((Hintervals) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Hintervals) model).setSetKey(rs.getShort("SET_KEY"));
		((Hintervals) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Hintervals) model).setHintervalPid(rs.getInt("HINTERVAL_PID"));
		((Hintervals) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((Hintervals) model).setIsHumanCalendar(rs.getBoolean("IS_HUMAN_CALENDAR"));
		((Hintervals) model).setHinterval1(rs.getLong("HINTERVAL1"));
		((Hintervals) model).setHinterval2(rs.getLong("HINTERVAL2"));
		((Hintervals) model).setSortHinterval1(rs.getLong("SORT_HINTERVAL1"));
		((Hintervals) model).setSortHinterval2(rs.getLong("SORT_HINTERVAL2"));
		((Hintervals) model).setOriginalText(rs.getString("ORIGINAL_TEXT"));
		((Hintervals) model).setLangCode(rs.getString("LANG_CODE"));
		((Hintervals) model).setHintervalTypeKey(rs.getShort("HINTERVAL_TYPE_KEY"));
		((Hintervals) model).setNamedMemoPid(rs.getInt("NAMED_MEMO_PID"));
		((Hintervals) model).setSurety(rs.getString("SURETY"));
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
	 * Set the Hinterval1 field
	 *
	 * @param Hinterval1
	 *            Contents of the HINTERVAL1 column
	 */
	public void setHinterval1(long Hinterval1) {
		this.Hinterval1 = Hinterval1;
	}

	/**
	 * Set the Hinterval2 field
	 *
	 * @param Hinterval2
	 *            Contents of the HINTERVAL2 column
	 */
	public void setHinterval2(long Hinterval2) {
		this.Hinterval2 = Hinterval2;
	}

	/**
	 * Set the HintervalPid field
	 *
	 * @param HintervalPid
	 *            Contents of the HINTERVAL_PID column
	 */
	public void setHintervalPid(int HintervalPid) {
		this.HintervalPid = HintervalPid;
	}

	/**
	 * Set the HintervalTypeKey field
	 *
	 * @param HintervalTypeKey
	 *            Contents of the HINTERVAL_TYPE_KEY column
	 */
	public void setHintervalTypeKey(short HintervalTypeKey) {
		this.HintervalTypeKey = HintervalTypeKey;
	}

	/**
	 * Set the IsHumanCalendar field
	 *
	 * @param IsHumanCalendar
	 *            Contents of the IS_HUMAN_CALENDAR column
	 */
	public void setIsHumanCalendar(boolean IsHumanCalendar) {
		this.IsHumanCalendar = IsHumanCalendar;
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
	 * Set the LangCode field
	 *
	 * @param LangCode
	 *            Contents of the LANG_CODE column
	 */
	public void setLangCode(String LangCode) {
		this.LangCode = LangCode;
	}

	/**
	 * Set the NamedMemoPid field
	 *
	 * @param NamedMemoPid
	 *            Contents of the NAMED_MEMO_PID column
	 */
	public void setNamedMemoPid(int NamedMemoPid) {
		this.NamedMemoPid = NamedMemoPid;
	}

	/**
	 * Set the OriginalText field
	 *
	 * @param OriginalText
	 *            Contents of the ORIGINAL_TEXT column
	 */
	public void setOriginalText(String OriginalText) {
		this.OriginalText = OriginalText;
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
	 * Set the SortHinterval1 field
	 *
	 * @param SortHinterval1
	 *            Contents of the SORT_HINTERVAL1 column
	 */
	public void setSortHinterval1(long SortHinterval1) {
		this.SortHinterval1 = SortHinterval1;
	}

	/**
	 * Set the SortHinterval2 field
	 *
	 * @param SortHinterval2
	 *            Contents of the SORT_HINTERVAL2 column
	 */
	public void setSortHinterval2(long SortHinterval2) {
		this.SortHinterval2 = SortHinterval2;
	}

	/**
	 * Set the Surety field
	 *
	 * @param Surety
	 *            Contents of the SURETY column
	 */
	public void setSurety(String Surety) {
		this.Surety = Surety;
	}

}
