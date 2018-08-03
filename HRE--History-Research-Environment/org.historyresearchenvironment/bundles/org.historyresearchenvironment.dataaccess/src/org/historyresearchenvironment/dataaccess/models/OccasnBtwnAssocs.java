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

	public OccasnBtwnAssocs() throws SQLException {
	}

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

	public int getABSentceSetPid() {
		return this.ABSentceSetPid;
	}

	public int getAEntityPid() {
		return this.AEntityPid;
	}

	public short getAEntitySubTypeKey() {
		return this.AEntitySubTypeKey;
	}

	public short getAEntityTypeKey() {
		return this.AEntityTypeKey;
	}

	public int getBASentceSetPid() {
		return this.BASentceSetPid;
	}

	public int getBEntityPid() {
		return this.BEntityPid;
	}

	public short getBEntitySubTypeKey() {
		return this.BEntitySubTypeKey;
	}

	public short getBEntityTypeKey() {
		return this.BEntityTypeKey;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public byte[] getFlags() {
		return this.Flags;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public int getMemoSetPid() {
		return this.MemoSetPid;
	}

	public int getOccasnBtwnAssocPid() {
		return this.OccasnBtwnAssocPid;
	}

	public short getOccasnBtwnAssocTagKey() {
		return this.OccasnBtwnAssocTagKey;
	}

	public short getOccasnSubTypeKey() {
		return this.OccasnSubTypeKey;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getSentceStyleKey() {
		return this.SentceStyleKey;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public short getThemeKey() {
		return this.ThemeKey;
	}

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

	public void setABSentceSetPid(int ABSentceSetPid) {
		this.ABSentceSetPid = ABSentceSetPid;
	}

	public void setAEntityPid(int AEntityPid) {
		this.AEntityPid = AEntityPid;
	}

	public void setAEntitySubTypeKey(short AEntitySubTypeKey) {
		this.AEntitySubTypeKey = AEntitySubTypeKey;
	}

	public void setAEntityTypeKey(short AEntityTypeKey) {
		this.AEntityTypeKey = AEntityTypeKey;
	}

	public void setBASentceSetPid(int BASentceSetPid) {
		this.BASentceSetPid = BASentceSetPid;
	}

	public void setBEntityPid(int BEntityPid) {
		this.BEntityPid = BEntityPid;
	}

	public void setBEntitySubTypeKey(short BEntitySubTypeKey) {
		this.BEntitySubTypeKey = BEntitySubTypeKey;
	}

	public void setBEntityTypeKey(short BEntityTypeKey) {
		this.BEntityTypeKey = BEntityTypeKey;
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setFlags(byte[] Flags) {
		this.Flags = Flags;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setMemoSetPid(int MemoSetPid) {
		this.MemoSetPid = MemoSetPid;
	}

	public void setOccasnBtwnAssocPid(int OccasnBtwnAssocPid) {
		this.OccasnBtwnAssocPid = OccasnBtwnAssocPid;
	}

	public void setOccasnBtwnAssocTagKey(short OccasnBtwnAssocTagKey) {
		this.OccasnBtwnAssocTagKey = OccasnBtwnAssocTagKey;
	}

	public void setOccasnSubTypeKey(short OccasnSubTypeKey) {
		this.OccasnSubTypeKey = OccasnSubTypeKey;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setSentceStyleKey(short SentceStyleKey) {
		this.SentceStyleKey = SentceStyleKey;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setThemeKey(short ThemeKey) {
		this.ThemeKey = ThemeKey;
	}

	public void setThisOccasnPid(int ThisOccasnPid) {
		this.ThisOccasnPid = ThisOccasnPid;
	}

}
