package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the BIO_NAMES database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class BioNames extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_PID, " + "COMMIT_PID, " + "BIO_NAME_PID, "
			+ "IS_SYSTEM, " + "PARENT_PID, " + "PARENT_SUB_TYPE_KEY, " + "NAME_TAG_KEY, " + "NAME_STYLE_KEY, "
			+ "ELEMENTS_ENTERED, " + "THIS_HDATE_PID, " + "THIS_NAME_EVENT_PID, " + "THIS_HDATE_INFERRED, "
			+ "NEXT_HDATE_PID, " + "NEXT_NAME_EVENT_PID, " + "NEXT_HDATE_INFERRED, " + "THEME_KEY, "
			+ "SENTCE_SET_KEY, " + "SENTCE_TYPE_KEY, " + "SENTCE_STYLE_KEY, "
			+ "MEMO_SET_PID FROM PUBLIC.BIO_NAMES WHERE BIO_NAME_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_PID, " + "COMMIT_PID, " + "BIO_NAME_PID, "
			+ "IS_SYSTEM, " + "PARENT_PID, " + "PARENT_SUB_TYPE_KEY, " + "NAME_TAG_KEY, " + "NAME_STYLE_KEY, "
			+ "ELEMENTS_ENTERED, " + "THIS_HDATE_PID, " + "THIS_NAME_EVENT_PID, " + "THIS_HDATE_INFERRED, "
			+ "NEXT_HDATE_PID, " + "NEXT_NAME_EVENT_PID, " + "NEXT_HDATE_INFERRED, " + "THEME_KEY, "
			+ "SENTCE_SET_KEY, " + "SENTCE_TYPE_KEY, " + "SENTCE_STYLE_KEY, " + "MEMO_SET_PID FROM PUBLIC.BIO_NAMES";

	private static final String INSERT = "INSERT INTO PUBLIC.BIO_NAMES( " + "RECORD_NUM, " + "SET_PID, "
			+ "COMMIT_PID, " + "BIO_NAME_PID, " + "IS_SYSTEM, " + "PARENT_PID, " + "PARENT_SUB_TYPE_KEY, "
			+ "NAME_TAG_KEY, " + "NAME_STYLE_KEY, " + "ELEMENTS_ENTERED, " + "THIS_HDATE_PID, "
			+ "THIS_NAME_EVENT_PID, " + "THIS_HDATE_INFERRED, " + "NEXT_HDATE_PID, " + "NEXT_NAME_EVENT_PID, "
			+ "NEXT_HDATE_INFERRED, " + "THEME_KEY, " + "SENTCE_SET_KEY, " + "SENTCE_TYPE_KEY, " + "SENTCE_STYLE_KEY, "
			+ "MEMO_SET_PID) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.BIO_NAMESSET " + "RECORD_NUM = ?, " + "SET_PID = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PARENT_PID = ?, " + "PARENT_SUB_TYPE_KEY = ?, "
			+ "NAME_TAG_KEY = ?, " + "NAME_STYLE_KEY = ?, " + "ELEMENTS_ENTERED = ?, " + "THIS_HDATE_PID = ?, "
			+ "THIS_NAME_EVENT_PID = ?, " + "THIS_HDATE_INFERRED = ?, " + "NEXT_HDATE_PID = ?, "
			+ "NEXT_NAME_EVENT_PID = ?, " + "NEXT_HDATE_INFERRED = ?, " + "THEME_KEY = ?, " + "SENTCE_SET_KEY = ?, "
			+ "SENTCE_TYPE_KEY = ?, " + "SENTCE_STYLE_KEY = ?, " + "MEMO_SET_PID = ? WHERE BIO_NAME_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.BIO_NAMES WHERE BIO_NAME_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.BIO_NAMES";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetPid;
	private int CommitPid;
	private int BioNamePid;
	private boolean IsSystem;
	private int ParentPid;
	private short ParentSubTypeKey;
	private short NameTagKey;
	private short NameStyleKey;
	private byte[] ElementsEntered;
	private int ThisHdatePid;
	private int ThisNameEventPid;
	private boolean ThisHdateInferred;
	private int NextHdatePid;
	private int NextNameEventPid;
	private boolean NextHdateInferred;
	private short ThemeKey;
	private short SentceSetKey;
	private short SentceTypeKey;
	private short SentceStyleKey;
	private int MemoSetPid;
	private BioNames model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public BioNames() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param BioNamePid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public BioNames(int BioNamePid) throws SQLException {
		super();
		this.BioNamePid = BioNamePid;
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
			model = new BioNames();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetPid(rs.getShort("SET_PID"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setBioNamePid(rs.getInt("BIO_NAME_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentPid(rs.getInt("PARENT_PID"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setNameTagKey(rs.getShort("NAME_TAG_KEY"));
			model.setNameStyleKey(rs.getShort("NAME_STYLE_KEY"));
			model.setElementsEntered(rs.getBytes("ELEMENTS_ENTERED"));
			model.setThisHdatePid(rs.getInt("THIS_HDATE_PID"));
			model.setThisNameEventPid(rs.getInt("THIS_NAME_EVENT_PID"));
			model.setThisHdateInferred(rs.getBoolean("THIS_HDATE_INFERRED"));
			model.setNextHdatePid(rs.getInt("NEXT_HDATE_PID"));
			model.setNextNameEventPid(rs.getInt("NEXT_NAME_EVENT_PID"));
			model.setNextHdateInferred(rs.getBoolean("NEXT_HDATE_INFERRED"));
			model.setThemeKey(rs.getShort("THEME_KEY"));
			model.setSentceSetKey(rs.getShort("SENTCE_SET_KEY"));
			model.setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
			model.setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
			model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
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
			model.setSetPid(rs.getShort("SET_PID"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setBioNamePid(rs.getInt("BIO_NAME_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentPid(rs.getInt("PARENT_PID"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setNameTagKey(rs.getShort("NAME_TAG_KEY"));
			model.setNameStyleKey(rs.getShort("NAME_STYLE_KEY"));
			model.setElementsEntered(rs.getBytes("ELEMENTS_ENTERED"));
			model.setThisHdatePid(rs.getInt("THIS_HDATE_PID"));
			model.setThisNameEventPid(rs.getInt("THIS_NAME_EVENT_PID"));
			model.setThisHdateInferred(rs.getBoolean("THIS_HDATE_INFERRED"));
			model.setNextHdatePid(rs.getInt("NEXT_HDATE_PID"));
			model.setNextNameEventPid(rs.getInt("NEXT_NAME_EVENT_PID"));
			model.setNextHdateInferred(rs.getBoolean("NEXT_HDATE_INFERRED"));
			model.setThemeKey(rs.getShort("THEME_KEY"));
			model.setSentceSetKey(rs.getShort("SENTCE_SET_KEY"));
			model.setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
			model.setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
			model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
		}
		return this;
	}

	/**
	 * Get the BioNamePid field.
	 *
	 * @return Contents of the BIO_NAME_PID column
	 */
	public int getBioNamePid() {
		return this.BioNamePid;
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
	 * Get the ElementsEntered field.
	 *
	 * @return Contents of the ELEMENTS_ENTERED column
	 */
	public byte[] getElementsEntered() {
		return this.ElementsEntered;
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
	 * Get the MemoSetPid field.
	 *
	 * @return Contents of the MEMO_SET_PID column
	 */
	public int getMemoSetPid() {
		return this.MemoSetPid;
	}

	/**
	 * Get the NameStyleKey field.
	 *
	 * @return Contents of the NAME_STYLE_KEY column
	 */
	public short getNameStyleKey() {
		return this.NameStyleKey;
	}

	/**
	 * Get the NameTagKey field.
	 *
	 * @return Contents of the NAME_TAG_KEY column
	 */
	public short getNameTagKey() {
		return this.NameTagKey;
	}

	/**
	 * Get the NextHdateInferred field.
	 *
	 * @return Contents of the NEXT_HDATE_INFERRED column
	 */
	public boolean getNextHdateInferred() {
		return this.NextHdateInferred;
	}

	/**
	 * Get the NextHdatePid field.
	 *
	 * @return Contents of the NEXT_HDATE_PID column
	 */
	public int getNextHdatePid() {
		return this.NextHdatePid;
	}

	/**
	 * Get the NextNameEventPid field.
	 *
	 * @return Contents of the NEXT_NAME_EVENT_PID column
	 */
	public int getNextNameEventPid() {
		return this.NextNameEventPid;
	}

	/**
	 * Get the ParentPid field.
	 *
	 * @return Contents of the PARENT_PID column
	 */
	public int getParentPid() {
		return this.ParentPid;
	}

	/**
	 * Get the ParentSubTypeKey field.
	 *
	 * @return Contents of the PARENT_SUB_TYPE_KEY column
	 */
	public short getParentSubTypeKey() {
		return this.ParentSubTypeKey;
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
	 * Get the SentceSetKey field.
	 *
	 * @return Contents of the SENTCE_SET_KEY column
	 */
	public short getSentceSetKey() {
		return this.SentceSetKey;
	}

	/**
	 * Get the SentceStyleKey field.
	 *
	 * @return Contents of the SENTCE_STYLE_KEY column
	 */
	public short getSentceStyleKey() {
		return this.SentceStyleKey;
	}

	/**
	 * Get the SentceTypeKey field.
	 *
	 * @return Contents of the SENTCE_TYPE_KEY column
	 */
	public short getSentceTypeKey() {
		return this.SentceTypeKey;
	}

	/**
	 * Get the SetPid field.
	 *
	 * @return Contents of the SET_PID column
	 */
	public short getSetPid() {
		return this.SetPid;
	}

	/**
	 * Get the ThemeKey field.
	 *
	 * @return Contents of the THEME_KEY column
	 */
	public short getThemeKey() {
		return this.ThemeKey;
	}

	/**
	 * Get the ThisHdateInferred field.
	 *
	 * @return Contents of the THIS_HDATE_INFERRED column
	 */
	public boolean getThisHdateInferred() {
		return this.ThisHdateInferred;
	}

	/**
	 * Get the ThisHdatePid field.
	 *
	 * @return Contents of the THIS_HDATE_PID column
	 */
	public int getThisHdatePid() {
		return this.ThisHdatePid;
	}

	/**
	 * Get the ThisNameEventPid field.
	 *
	 * @return Contents of the THIS_NAME_EVENT_PID column
	 */
	public int getThisNameEventPid() {
		return this.ThisNameEventPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((BioNames) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((BioNames) model).setSetPid(rs.getShort("SET_PID"));
		((BioNames) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((BioNames) model).setBioNamePid(rs.getInt("BIO_NAME_PID"));
		((BioNames) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((BioNames) model).setParentPid(rs.getInt("PARENT_PID"));
		((BioNames) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((BioNames) model).setNameTagKey(rs.getShort("NAME_TAG_KEY"));
		((BioNames) model).setNameStyleKey(rs.getShort("NAME_STYLE_KEY"));
		((BioNames) model).setElementsEntered(rs.getBytes("ELEMENTS_ENTERED"));
		((BioNames) model).setThisHdatePid(rs.getInt("THIS_HDATE_PID"));
		((BioNames) model).setThisNameEventPid(rs.getInt("THIS_NAME_EVENT_PID"));
		((BioNames) model).setThisHdateInferred(rs.getBoolean("THIS_HDATE_INFERRED"));
		((BioNames) model).setNextHdatePid(rs.getInt("NEXT_HDATE_PID"));
		((BioNames) model).setNextNameEventPid(rs.getInt("NEXT_NAME_EVENT_PID"));
		((BioNames) model).setNextHdateInferred(rs.getBoolean("NEXT_HDATE_INFERRED"));
		((BioNames) model).setThemeKey(rs.getShort("THEME_KEY"));
		((BioNames) model).setSentceSetKey(rs.getShort("SENTCE_SET_KEY"));
		((BioNames) model).setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
		((BioNames) model).setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
		((BioNames) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((BioNames) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((BioNames) model).setSetPid(rs.getShort("SET_PID"));
		((BioNames) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((BioNames) model).setBioNamePid(rs.getInt("BIO_NAME_PID"));
		((BioNames) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((BioNames) model).setParentPid(rs.getInt("PARENT_PID"));
		((BioNames) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((BioNames) model).setNameTagKey(rs.getShort("NAME_TAG_KEY"));
		((BioNames) model).setNameStyleKey(rs.getShort("NAME_STYLE_KEY"));
		((BioNames) model).setElementsEntered(rs.getBytes("ELEMENTS_ENTERED"));
		((BioNames) model).setThisHdatePid(rs.getInt("THIS_HDATE_PID"));
		((BioNames) model).setThisNameEventPid(rs.getInt("THIS_NAME_EVENT_PID"));
		((BioNames) model).setThisHdateInferred(rs.getBoolean("THIS_HDATE_INFERRED"));
		((BioNames) model).setNextHdatePid(rs.getInt("NEXT_HDATE_PID"));
		((BioNames) model).setNextNameEventPid(rs.getInt("NEXT_NAME_EVENT_PID"));
		((BioNames) model).setNextHdateInferred(rs.getBoolean("NEXT_HDATE_INFERRED"));
		((BioNames) model).setThemeKey(rs.getShort("THEME_KEY"));
		((BioNames) model).setSentceSetKey(rs.getShort("SENTCE_SET_KEY"));
		((BioNames) model).setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
		((BioNames) model).setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
		((BioNames) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
		ps.executeUpdate();
	}

	/**
	 * Set the BioNamePid field
	 *
	 * @param BioNamePid
	 *            Contents of the BIO_NAME_PID column
	 */
	public void setBioNamePid(int BioNamePid) {
		this.BioNamePid = BioNamePid;
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
	 * Set the ElementsEntered field
	 *
	 * @param ElementsEntered
	 *            Contents of the ELEMENTS_ENTERED column
	 */
	public void setElementsEntered(byte[] ElementsEntered) {
		this.ElementsEntered = ElementsEntered;
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
	 * Set the MemoSetPid field
	 *
	 * @param MemoSetPid
	 *            Contents of the MEMO_SET_PID column
	 */
	public void setMemoSetPid(int MemoSetPid) {
		this.MemoSetPid = MemoSetPid;
	}

	/**
	 * Set the NameStyleKey field
	 *
	 * @param NameStyleKey
	 *            Contents of the NAME_STYLE_KEY column
	 */
	public void setNameStyleKey(short NameStyleKey) {
		this.NameStyleKey = NameStyleKey;
	}

	/**
	 * Set the NameTagKey field
	 *
	 * @param NameTagKey
	 *            Contents of the NAME_TAG_KEY column
	 */
	public void setNameTagKey(short NameTagKey) {
		this.NameTagKey = NameTagKey;
	}

	/**
	 * Set the NextHdateInferred field
	 *
	 * @param NextHdateInferred
	 *            Contents of the NEXT_HDATE_INFERRED column
	 */
	public void setNextHdateInferred(boolean NextHdateInferred) {
		this.NextHdateInferred = NextHdateInferred;
	}

	/**
	 * Set the NextHdatePid field
	 *
	 * @param NextHdatePid
	 *            Contents of the NEXT_HDATE_PID column
	 */
	public void setNextHdatePid(int NextHdatePid) {
		this.NextHdatePid = NextHdatePid;
	}

	/**
	 * Set the NextNameEventPid field
	 *
	 * @param NextNameEventPid
	 *            Contents of the NEXT_NAME_EVENT_PID column
	 */
	public void setNextNameEventPid(int NextNameEventPid) {
		this.NextNameEventPid = NextNameEventPid;
	}

	/**
	 * Set the ParentPid field
	 *
	 * @param ParentPid
	 *            Contents of the PARENT_PID column
	 */
	public void setParentPid(int ParentPid) {
		this.ParentPid = ParentPid;
	}

	/**
	 * Set the ParentSubTypeKey field
	 *
	 * @param ParentSubTypeKey
	 *            Contents of the PARENT_SUB_TYPE_KEY column
	 */
	public void setParentSubTypeKey(short ParentSubTypeKey) {
		this.ParentSubTypeKey = ParentSubTypeKey;
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
	 * Set the SentceSetKey field
	 *
	 * @param SentceSetKey
	 *            Contents of the SENTCE_SET_KEY column
	 */
	public void setSentceSetKey(short SentceSetKey) {
		this.SentceSetKey = SentceSetKey;
	}

	/**
	 * Set the SentceStyleKey field
	 *
	 * @param SentceStyleKey
	 *            Contents of the SENTCE_STYLE_KEY column
	 */
	public void setSentceStyleKey(short SentceStyleKey) {
		this.SentceStyleKey = SentceStyleKey;
	}

	/**
	 * Set the SentceTypeKey field
	 *
	 * @param SentceTypeKey
	 *            Contents of the SENTCE_TYPE_KEY column
	 */
	public void setSentceTypeKey(short SentceTypeKey) {
		this.SentceTypeKey = SentceTypeKey;
	}

	/**
	 * Set the SetPid field
	 *
	 * @param SetPid
	 *            Contents of the SET_PID column
	 */
	public void setSetPid(short SetPid) {
		this.SetPid = SetPid;
	}

	/**
	 * Set the ThemeKey field
	 *
	 * @param ThemeKey
	 *            Contents of the THEME_KEY column
	 */
	public void setThemeKey(short ThemeKey) {
		this.ThemeKey = ThemeKey;
	}

	/**
	 * Set the ThisHdateInferred field
	 *
	 * @param ThisHdateInferred
	 *            Contents of the THIS_HDATE_INFERRED column
	 */
	public void setThisHdateInferred(boolean ThisHdateInferred) {
		this.ThisHdateInferred = ThisHdateInferred;
	}

	/**
	 * Set the ThisHdatePid field
	 *
	 * @param ThisHdatePid
	 *            Contents of the THIS_HDATE_PID column
	 */
	public void setThisHdatePid(int ThisHdatePid) {
		this.ThisHdatePid = ThisHdatePid;
	}

	/**
	 * Set the ThisNameEventPid field
	 *
	 * @param ThisNameEventPid
	 *            Contents of the THIS_NAME_EVENT_PID column
	 */
	public void setThisNameEventPid(int ThisNameEventPid) {
		this.ThisNameEventPid = ThisNameEventPid;
	}

}
