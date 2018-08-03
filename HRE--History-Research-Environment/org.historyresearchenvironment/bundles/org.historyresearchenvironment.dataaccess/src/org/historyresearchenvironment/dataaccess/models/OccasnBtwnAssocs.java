package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the OCCASN_BTWN_ASSOCS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class OccasnBtwnAssocs extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_BTWN_ASSOC_PID, " + "IS_SYSTEM, " + "OCCASN_BTWN_ASSOC_TAG_KEY, " + "OCCASN_SUB_TYPE_KEY, "
			+ "THIS_OCCASN_PID, " + "A_ENTITY_TYPE_KEY, " + "A_ENTITY_SUB_TYPE_KEY, " + "A_ENTITY_PID, "
			+ "B_ENTITY_TYPE_KEY, " + "B_ENTITY_SUB_TYPE_KEY, " + "B_ENTITY_PID, " + "THEME_KEY, "
			+ "SENTCE_STYLE_KEY, " + "A_B_SENTCE_SET_PID, " + "B_A_SENTCE_SET_PID, " + "MEMO_SET_PID, "
			+ "FLAGS FROM PUBLIC.OCCASN_BTWN_ASSOCS WHERE OCCASN_BTWN_ASSOC_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_BTWN_ASSOC_PID, " + "IS_SYSTEM, " + "OCCASN_BTWN_ASSOC_TAG_KEY, " + "OCCASN_SUB_TYPE_KEY, "
			+ "THIS_OCCASN_PID, " + "A_ENTITY_TYPE_KEY, " + "A_ENTITY_SUB_TYPE_KEY, " + "A_ENTITY_PID, "
			+ "B_ENTITY_TYPE_KEY, " + "B_ENTITY_SUB_TYPE_KEY, " + "B_ENTITY_PID, " + "THEME_KEY, "
			+ "SENTCE_STYLE_KEY, " + "A_B_SENTCE_SET_PID, " + "B_A_SENTCE_SET_PID, " + "MEMO_SET_PID, "
			+ "FLAGS FROM PUBLIC.OCCASN_BTWN_ASSOCS";

	private static final String INSERT = "INSERT INTO PUBLIC.OCCASN_BTWN_ASSOCS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "OCCASN_BTWN_ASSOC_PID, " + "IS_SYSTEM, " + "OCCASN_BTWN_ASSOC_TAG_KEY, "
			+ "OCCASN_SUB_TYPE_KEY, " + "THIS_OCCASN_PID, " + "A_ENTITY_TYPE_KEY, " + "A_ENTITY_SUB_TYPE_KEY, "
			+ "A_ENTITY_PID, " + "B_ENTITY_TYPE_KEY, " + "B_ENTITY_SUB_TYPE_KEY, " + "B_ENTITY_PID, " + "THEME_KEY, "
			+ "SENTCE_STYLE_KEY, " + "A_B_SENTCE_SET_PID, " + "B_A_SENTCE_SET_PID, " + "MEMO_SET_PID, "
			+ "FLAGS) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.OCCASN_BTWN_ASSOCSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "OCCASN_BTWN_ASSOC_TAG_KEY = ?, " + "OCCASN_SUB_TYPE_KEY = ?, "
			+ "THIS_OCCASN_PID = ?, " + "A_ENTITY_TYPE_KEY = ?, " + "A_ENTITY_SUB_TYPE_KEY = ?, " + "A_ENTITY_PID = ?, "
			+ "B_ENTITY_TYPE_KEY = ?, " + "B_ENTITY_SUB_TYPE_KEY = ?, " + "B_ENTITY_PID = ?, " + "THEME_KEY = ?, "
			+ "SENTCE_STYLE_KEY = ?, " + "A_B_SENTCE_SET_PID = ?, " + "B_A_SENTCE_SET_PID = ?, " + "MEMO_SET_PID = ?, "
			+ "FLAGS = ? WHERE OCCASN_BTWN_ASSOC_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.OCCASN_BTWN_ASSOCS WHERE OCCASN_BTWN_ASSOC_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASN_BTWN_ASSOCS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int OccasnBtwnAssocPid;
	private boolean IsSystem;
	private short OccasnBtwnAssocTagKey;
	private short OccasnSubTypeKey;
	private int ThisOccasnPid;
	private short AEntityTypeKey;
	private short AEntitySubTypeKey;
	private int AEntityPid;
	private short BEntityTypeKey;
	private short BEntitySubTypeKey;
	private int BEntityPid;
	private short ThemeKey;
	private short SentceStyleKey;
	private int ABSentceSetPid;
	private int BASentceSetPid;
	private int MemoSetPid;
	private byte[] Flags;
	private OccasnBtwnAssocs model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public OccasnBtwnAssocs() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param OccasnBtwnAssocPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public OccasnBtwnAssocs(int OccasnBtwnAssocPid) throws SQLException {
		super();
		this.OccasnBtwnAssocPid = OccasnBtwnAssocPid;
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
			model = new OccasnBtwnAssocs();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setOccasnBtwnAssocPid(rs.getInt("OCCASN_BTWN_ASSOC_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setOccasnBtwnAssocTagKey(rs.getShort("OCCASN_BTWN_ASSOC_TAG_KEY"));
			model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
			model.setThisOccasnPid(rs.getInt("THIS_OCCASN_PID"));
			model.setAEntityTypeKey(rs.getShort("A_ENTITY_TYPE_KEY"));
			model.setAEntitySubTypeKey(rs.getShort("A_ENTITY_SUB_TYPE_KEY"));
			model.setAEntityPid(rs.getInt("A_ENTITY_PID"));
			model.setBEntityTypeKey(rs.getShort("B_ENTITY_TYPE_KEY"));
			model.setBEntitySubTypeKey(rs.getShort("B_ENTITY_SUB_TYPE_KEY"));
			model.setBEntityPid(rs.getInt("B_ENTITY_PID"));
			model.setThemeKey(rs.getShort("THEME_KEY"));
			model.setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
			model.setABSentceSetPid(rs.getInt("A_B_SENTCE_SET_PID"));
			model.setBASentceSetPid(rs.getInt("B_A_SENTCE_SET_PID"));
			model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
			model.setFlags(rs.getBytes("FLAGS"));
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
			model.setOccasnBtwnAssocPid(rs.getInt("OCCASN_BTWN_ASSOC_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setOccasnBtwnAssocTagKey(rs.getShort("OCCASN_BTWN_ASSOC_TAG_KEY"));
			model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
			model.setThisOccasnPid(rs.getInt("THIS_OCCASN_PID"));
			model.setAEntityTypeKey(rs.getShort("A_ENTITY_TYPE_KEY"));
			model.setAEntitySubTypeKey(rs.getShort("A_ENTITY_SUB_TYPE_KEY"));
			model.setAEntityPid(rs.getInt("A_ENTITY_PID"));
			model.setBEntityTypeKey(rs.getShort("B_ENTITY_TYPE_KEY"));
			model.setBEntitySubTypeKey(rs.getShort("B_ENTITY_SUB_TYPE_KEY"));
			model.setBEntityPid(rs.getInt("B_ENTITY_PID"));
			model.setThemeKey(rs.getShort("THEME_KEY"));
			model.setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
			model.setABSentceSetPid(rs.getInt("A_B_SENTCE_SET_PID"));
			model.setBASentceSetPid(rs.getInt("B_A_SENTCE_SET_PID"));
			model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
			model.setFlags(rs.getBytes("FLAGS"));
		}
		return this;
	}

	/**
	 * Get the ABSentceSetPid field.
	 *
	 * @return Contents of the A_B_SENTCE_SET_PID column
	 */
	public int getABSentceSetPid() {
		return this.ABSentceSetPid;
	}

	/**
	 * Get the AEntityPid field.
	 *
	 * @return Contents of the A_ENTITY_PID column
	 */
	public int getAEntityPid() {
		return this.AEntityPid;
	}

	/**
	 * Get the AEntitySubTypeKey field.
	 *
	 * @return Contents of the A_ENTITY_SUB_TYPE_KEY column
	 */
	public short getAEntitySubTypeKey() {
		return this.AEntitySubTypeKey;
	}

	/**
	 * Get the AEntityTypeKey field.
	 *
	 * @return Contents of the A_ENTITY_TYPE_KEY column
	 */
	public short getAEntityTypeKey() {
		return this.AEntityTypeKey;
	}

	/**
	 * Get the BASentceSetPid field.
	 *
	 * @return Contents of the B_A_SENTCE_SET_PID column
	 */
	public int getBASentceSetPid() {
		return this.BASentceSetPid;
	}

	/**
	 * Get the BEntityPid field.
	 *
	 * @return Contents of the B_ENTITY_PID column
	 */
	public int getBEntityPid() {
		return this.BEntityPid;
	}

	/**
	 * Get the BEntitySubTypeKey field.
	 *
	 * @return Contents of the B_ENTITY_SUB_TYPE_KEY column
	 */
	public short getBEntitySubTypeKey() {
		return this.BEntitySubTypeKey;
	}

	/**
	 * Get the BEntityTypeKey field.
	 *
	 * @return Contents of the B_ENTITY_TYPE_KEY column
	 */
	public short getBEntityTypeKey() {
		return this.BEntityTypeKey;
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
	 * Get the Flags field.
	 *
	 * @return Contents of the FLAGS column
	 */
	public byte[] getFlags() {
		return this.Flags;
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
	 * Get the OccasnBtwnAssocPid field.
	 *
	 * @return Contents of the OCCASN_BTWN_ASSOC_PID column
	 */
	public int getOccasnBtwnAssocPid() {
		return this.OccasnBtwnAssocPid;
	}

	/**
	 * Get the OccasnBtwnAssocTagKey field.
	 *
	 * @return Contents of the OCCASN_BTWN_ASSOC_TAG_KEY column
	 */
	public short getOccasnBtwnAssocTagKey() {
		return this.OccasnBtwnAssocTagKey;
	}

	/**
	 * Get the OccasnSubTypeKey field.
	 *
	 * @return Contents of the OCCASN_SUB_TYPE_KEY column
	 */
	public short getOccasnSubTypeKey() {
		return this.OccasnSubTypeKey;
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
	 * Get the SentceStyleKey field.
	 *
	 * @return Contents of the SENTCE_STYLE_KEY column
	 */
	public short getSentceStyleKey() {
		return this.SentceStyleKey;
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
	 * Get the ThemeKey field.
	 *
	 * @return Contents of the THEME_KEY column
	 */
	public short getThemeKey() {
		return this.ThemeKey;
	}

	/**
	 * Get the ThisOccasnPid field.
	 *
	 * @return Contents of the THIS_OCCASN_PID column
	 */
	public int getThisOccasnPid() {
		return this.ThisOccasnPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((OccasnBtwnAssocs) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((OccasnBtwnAssocs) model).setSetKey(rs.getShort("SET_KEY"));
		((OccasnBtwnAssocs) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((OccasnBtwnAssocs) model).setOccasnBtwnAssocPid(rs.getInt("OCCASN_BTWN_ASSOC_PID"));
		((OccasnBtwnAssocs) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((OccasnBtwnAssocs) model).setOccasnBtwnAssocTagKey(rs.getShort("OCCASN_BTWN_ASSOC_TAG_KEY"));
		((OccasnBtwnAssocs) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
		((OccasnBtwnAssocs) model).setThisOccasnPid(rs.getInt("THIS_OCCASN_PID"));
		((OccasnBtwnAssocs) model).setAEntityTypeKey(rs.getShort("A_ENTITY_TYPE_KEY"));
		((OccasnBtwnAssocs) model).setAEntitySubTypeKey(rs.getShort("A_ENTITY_SUB_TYPE_KEY"));
		((OccasnBtwnAssocs) model).setAEntityPid(rs.getInt("A_ENTITY_PID"));
		((OccasnBtwnAssocs) model).setBEntityTypeKey(rs.getShort("B_ENTITY_TYPE_KEY"));
		((OccasnBtwnAssocs) model).setBEntitySubTypeKey(rs.getShort("B_ENTITY_SUB_TYPE_KEY"));
		((OccasnBtwnAssocs) model).setBEntityPid(rs.getInt("B_ENTITY_PID"));
		((OccasnBtwnAssocs) model).setThemeKey(rs.getShort("THEME_KEY"));
		((OccasnBtwnAssocs) model).setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
		((OccasnBtwnAssocs) model).setABSentceSetPid(rs.getInt("A_B_SENTCE_SET_PID"));
		((OccasnBtwnAssocs) model).setBASentceSetPid(rs.getInt("B_A_SENTCE_SET_PID"));
		((OccasnBtwnAssocs) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
		((OccasnBtwnAssocs) model).setFlags(rs.getBytes("FLAGS"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((OccasnBtwnAssocs) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((OccasnBtwnAssocs) model).setSetKey(rs.getShort("SET_KEY"));
		((OccasnBtwnAssocs) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((OccasnBtwnAssocs) model).setOccasnBtwnAssocPid(rs.getInt("OCCASN_BTWN_ASSOC_PID"));
		((OccasnBtwnAssocs) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((OccasnBtwnAssocs) model).setOccasnBtwnAssocTagKey(rs.getShort("OCCASN_BTWN_ASSOC_TAG_KEY"));
		((OccasnBtwnAssocs) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
		((OccasnBtwnAssocs) model).setThisOccasnPid(rs.getInt("THIS_OCCASN_PID"));
		((OccasnBtwnAssocs) model).setAEntityTypeKey(rs.getShort("A_ENTITY_TYPE_KEY"));
		((OccasnBtwnAssocs) model).setAEntitySubTypeKey(rs.getShort("A_ENTITY_SUB_TYPE_KEY"));
		((OccasnBtwnAssocs) model).setAEntityPid(rs.getInt("A_ENTITY_PID"));
		((OccasnBtwnAssocs) model).setBEntityTypeKey(rs.getShort("B_ENTITY_TYPE_KEY"));
		((OccasnBtwnAssocs) model).setBEntitySubTypeKey(rs.getShort("B_ENTITY_SUB_TYPE_KEY"));
		((OccasnBtwnAssocs) model).setBEntityPid(rs.getInt("B_ENTITY_PID"));
		((OccasnBtwnAssocs) model).setThemeKey(rs.getShort("THEME_KEY"));
		((OccasnBtwnAssocs) model).setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
		((OccasnBtwnAssocs) model).setABSentceSetPid(rs.getInt("A_B_SENTCE_SET_PID"));
		((OccasnBtwnAssocs) model).setBASentceSetPid(rs.getInt("B_A_SENTCE_SET_PID"));
		((OccasnBtwnAssocs) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
		((OccasnBtwnAssocs) model).setFlags(rs.getBytes("FLAGS"));
		ps.executeUpdate();
	}

	/**
	 * Set the ABSentceSetPid field
	 *
	 * @param ABSentceSetPid
	 *            Contents of the A_B_SENTCE_SET_PID column
	 */
	public void setABSentceSetPid(int ABSentceSetPid) {
		this.ABSentceSetPid = ABSentceSetPid;
	}

	/**
	 * Set the AEntityPid field
	 *
	 * @param AEntityPid
	 *            Contents of the A_ENTITY_PID column
	 */
	public void setAEntityPid(int AEntityPid) {
		this.AEntityPid = AEntityPid;
	}

	/**
	 * Set the AEntitySubTypeKey field
	 *
	 * @param AEntitySubTypeKey
	 *            Contents of the A_ENTITY_SUB_TYPE_KEY column
	 */
	public void setAEntitySubTypeKey(short AEntitySubTypeKey) {
		this.AEntitySubTypeKey = AEntitySubTypeKey;
	}

	/**
	 * Set the AEntityTypeKey field
	 *
	 * @param AEntityTypeKey
	 *            Contents of the A_ENTITY_TYPE_KEY column
	 */
	public void setAEntityTypeKey(short AEntityTypeKey) {
		this.AEntityTypeKey = AEntityTypeKey;
	}

	/**
	 * Set the BASentceSetPid field
	 *
	 * @param BASentceSetPid
	 *            Contents of the B_A_SENTCE_SET_PID column
	 */
	public void setBASentceSetPid(int BASentceSetPid) {
		this.BASentceSetPid = BASentceSetPid;
	}

	/**
	 * Set the BEntityPid field
	 *
	 * @param BEntityPid
	 *            Contents of the B_ENTITY_PID column
	 */
	public void setBEntityPid(int BEntityPid) {
		this.BEntityPid = BEntityPid;
	}

	/**
	 * Set the BEntitySubTypeKey field
	 *
	 * @param BEntitySubTypeKey
	 *            Contents of the B_ENTITY_SUB_TYPE_KEY column
	 */
	public void setBEntitySubTypeKey(short BEntitySubTypeKey) {
		this.BEntitySubTypeKey = BEntitySubTypeKey;
	}

	/**
	 * Set the BEntityTypeKey field
	 *
	 * @param BEntityTypeKey
	 *            Contents of the B_ENTITY_TYPE_KEY column
	 */
	public void setBEntityTypeKey(short BEntityTypeKey) {
		this.BEntityTypeKey = BEntityTypeKey;
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
	 * Set the Flags field
	 *
	 * @param Flags
	 *            Contents of the FLAGS column
	 */
	public void setFlags(byte[] Flags) {
		this.Flags = Flags;
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
	 * Set the OccasnBtwnAssocPid field
	 *
	 * @param OccasnBtwnAssocPid
	 *            Contents of the OCCASN_BTWN_ASSOC_PID column
	 */
	public void setOccasnBtwnAssocPid(int OccasnBtwnAssocPid) {
		this.OccasnBtwnAssocPid = OccasnBtwnAssocPid;
	}

	/**
	 * Set the OccasnBtwnAssocTagKey field
	 *
	 * @param OccasnBtwnAssocTagKey
	 *            Contents of the OCCASN_BTWN_ASSOC_TAG_KEY column
	 */
	public void setOccasnBtwnAssocTagKey(short OccasnBtwnAssocTagKey) {
		this.OccasnBtwnAssocTagKey = OccasnBtwnAssocTagKey;
	}

	/**
	 * Set the OccasnSubTypeKey field
	 *
	 * @param OccasnSubTypeKey
	 *            Contents of the OCCASN_SUB_TYPE_KEY column
	 */
	public void setOccasnSubTypeKey(short OccasnSubTypeKey) {
		this.OccasnSubTypeKey = OccasnSubTypeKey;
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
	 * Set the SentceStyleKey field
	 *
	 * @param SentceStyleKey
	 *            Contents of the SENTCE_STYLE_KEY column
	 */
	public void setSentceStyleKey(short SentceStyleKey) {
		this.SentceStyleKey = SentceStyleKey;
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
	 * Set the ThemeKey field
	 *
	 * @param ThemeKey
	 *            Contents of the THEME_KEY column
	 */
	public void setThemeKey(short ThemeKey) {
		this.ThemeKey = ThemeKey;
	}

	/**
	 * Set the ThisOccasnPid field
	 *
	 * @param ThisOccasnPid
	 *            Contents of the THIS_OCCASN_PID column
	 */
	public void setThisOccasnPid(int ThisOccasnPid) {
		this.ThisOccasnPid = ThisOccasnPid;
	}

}
