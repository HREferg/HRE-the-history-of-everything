package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the OCCASNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class Occasns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "OCCASN_PID, "
			+ "IS_SYSTEM, " + "TAG_TYPE_KEY, " + "THEME_VISIBLE_ID, " + "PARENT_PID, " + "PARENT_SUB_TYPE_KEY, "
			+ "THEME_KEY, " + "LOCAL_SENTCE_SET_PID, " + "BEST_NAME_PID, " + "BEST_IMAGE_PID, " + "SURETY, "
			+ "SENTCE_TYPE_KEY, " + "SENTCE_STYLE_KEY, " + "BIO_PARENT_SET_PID, " + "MEMO_SET_PID, "
			+ "FLAGS FROM PUBLIC.OCCASNS WHERE OCCASN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "OCCASN_PID, "
			+ "IS_SYSTEM, " + "TAG_TYPE_KEY, " + "THEME_VISIBLE_ID, " + "PARENT_PID, " + "PARENT_SUB_TYPE_KEY, "
			+ "THEME_KEY, " + "LOCAL_SENTCE_SET_PID, " + "BEST_NAME_PID, " + "BEST_IMAGE_PID, " + "SURETY, "
			+ "SENTCE_TYPE_KEY, " + "SENTCE_STYLE_KEY, " + "BIO_PARENT_SET_PID, " + "MEMO_SET_PID, "
			+ "FLAGS FROM PUBLIC.OCCASNS";

	private static final String INSERT = "INSERT INTO PUBLIC.OCCASNS( " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_PID, " + "IS_SYSTEM, " + "TAG_TYPE_KEY, " + "THEME_VISIBLE_ID, " + "PARENT_PID, "
			+ "PARENT_SUB_TYPE_KEY, " + "THEME_KEY, " + "LOCAL_SENTCE_SET_PID, " + "BEST_NAME_PID, "
			+ "BEST_IMAGE_PID, " + "SURETY, " + "SENTCE_TYPE_KEY, " + "SENTCE_STYLE_KEY, " + "BIO_PARENT_SET_PID, "
			+ "MEMO_SET_PID, " + "FLAGS) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.OCCASNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "TAG_TYPE_KEY = ?, " + "THEME_VISIBLE_ID = ?, "
			+ "PARENT_PID = ?, " + "PARENT_SUB_TYPE_KEY = ?, " + "THEME_KEY = ?, " + "LOCAL_SENTCE_SET_PID = ?, "
			+ "BEST_NAME_PID = ?, " + "BEST_IMAGE_PID = ?, " + "SURETY = ?, " + "SENTCE_TYPE_KEY = ?, "
			+ "SENTCE_STYLE_KEY = ?, " + "BIO_PARENT_SET_PID = ?, " + "MEMO_SET_PID = ?, "
			+ "FLAGS = ? WHERE OCCASN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.OCCASNS WHERE OCCASN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int OccasnPid;
	private boolean IsSystem;
	private short TagTypeKey;
	private int ThemeVisibleId;
	private int ParentPid;
	private short ParentSubTypeKey;
	private short ThemeKey;
	private int LocalSentceSetPid;
	private int BestNamePid;
	private int BestImagePid;
	private String Surety;
	private short SentceTypeKey;
	private short SentceStyleKey;
	private int BioParentSetPid;
	private int MemoSetPid;
	private byte[] Flags;
	private Occasns model;

	public Occasns() throws SQLException {
	}

	public Occasns(int OccasnPid) throws SQLException {
		super();
		this.OccasnPid = OccasnPid;
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
			model = new Occasns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setOccasnPid(rs.getInt("OCCASN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setTagTypeKey(rs.getShort("TAG_TYPE_KEY"));
			model.setThemeVisibleId(rs.getInt("THEME_VISIBLE_ID"));
			model.setParentPid(rs.getInt("PARENT_PID"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setThemeKey(rs.getShort("THEME_KEY"));
			model.setLocalSentceSetPid(rs.getInt("LOCAL_SENTCE_SET_PID"));
			model.setBestNamePid(rs.getInt("BEST_NAME_PID"));
			model.setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
			model.setSurety(rs.getString("SURETY"));
			model.setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
			model.setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
			model.setBioParentSetPid(rs.getInt("BIO_PARENT_SET_PID"));
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
			model.setOccasnPid(rs.getInt("OCCASN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setTagTypeKey(rs.getShort("TAG_TYPE_KEY"));
			model.setThemeVisibleId(rs.getInt("THEME_VISIBLE_ID"));
			model.setParentPid(rs.getInt("PARENT_PID"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setThemeKey(rs.getShort("THEME_KEY"));
			model.setLocalSentceSetPid(rs.getInt("LOCAL_SENTCE_SET_PID"));
			model.setBestNamePid(rs.getInt("BEST_NAME_PID"));
			model.setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
			model.setSurety(rs.getString("SURETY"));
			model.setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
			model.setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
			model.setBioParentSetPid(rs.getInt("BIO_PARENT_SET_PID"));
			model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
			model.setFlags(rs.getBytes("FLAGS"));
		}
		return this;
	}

	public int getBestImagePid() {
		return this.BestImagePid;
	}

	public int getBestNamePid() {
		return this.BestNamePid;
	}

	public int getBioParentSetPid() {
		return this.BioParentSetPid;
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

	public int getLocalSentceSetPid() {
		return this.LocalSentceSetPid;
	}

	public int getMemoSetPid() {
		return this.MemoSetPid;
	}

	public int getOccasnPid() {
		return this.OccasnPid;
	}

	public int getParentPid() {
		return this.ParentPid;
	}

	public short getParentSubTypeKey() {
		return this.ParentSubTypeKey;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getSentceStyleKey() {
		return this.SentceStyleKey;
	}

	public short getSentceTypeKey() {
		return this.SentceTypeKey;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public String getSurety() {
		return this.Surety;
	}

	public short getTagTypeKey() {
		return this.TagTypeKey;
	}

	public short getThemeKey() {
		return this.ThemeKey;
	}

	public int getThemeVisibleId() {
		return this.ThemeVisibleId;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((Occasns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Occasns) model).setSetKey(rs.getShort("SET_KEY"));
		((Occasns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Occasns) model).setOccasnPid(rs.getInt("OCCASN_PID"));
		((Occasns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((Occasns) model).setTagTypeKey(rs.getShort("TAG_TYPE_KEY"));
		((Occasns) model).setThemeVisibleId(rs.getInt("THEME_VISIBLE_ID"));
		((Occasns) model).setParentPid(rs.getInt("PARENT_PID"));
		((Occasns) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((Occasns) model).setThemeKey(rs.getShort("THEME_KEY"));
		((Occasns) model).setLocalSentceSetPid(rs.getInt("LOCAL_SENTCE_SET_PID"));
		((Occasns) model).setBestNamePid(rs.getInt("BEST_NAME_PID"));
		((Occasns) model).setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
		((Occasns) model).setSurety(rs.getString("SURETY"));
		((Occasns) model).setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
		((Occasns) model).setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
		((Occasns) model).setBioParentSetPid(rs.getInt("BIO_PARENT_SET_PID"));
		((Occasns) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
		((Occasns) model).setFlags(rs.getBytes("FLAGS"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((Occasns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Occasns) model).setSetKey(rs.getShort("SET_KEY"));
		((Occasns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Occasns) model).setOccasnPid(rs.getInt("OCCASN_PID"));
		((Occasns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((Occasns) model).setTagTypeKey(rs.getShort("TAG_TYPE_KEY"));
		((Occasns) model).setThemeVisibleId(rs.getInt("THEME_VISIBLE_ID"));
		((Occasns) model).setParentPid(rs.getInt("PARENT_PID"));
		((Occasns) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((Occasns) model).setThemeKey(rs.getShort("THEME_KEY"));
		((Occasns) model).setLocalSentceSetPid(rs.getInt("LOCAL_SENTCE_SET_PID"));
		((Occasns) model).setBestNamePid(rs.getInt("BEST_NAME_PID"));
		((Occasns) model).setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
		((Occasns) model).setSurety(rs.getString("SURETY"));
		((Occasns) model).setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
		((Occasns) model).setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
		((Occasns) model).setBioParentSetPid(rs.getInt("BIO_PARENT_SET_PID"));
		((Occasns) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
		((Occasns) model).setFlags(rs.getBytes("FLAGS"));
		ps.executeUpdate();
	}

	public void setBestImagePid(int BestImagePid) {
		this.BestImagePid = BestImagePid;
	}

	public void setBestNamePid(int BestNamePid) {
		this.BestNamePid = BestNamePid;
	}

	public void setBioParentSetPid(int BioParentSetPid) {
		this.BioParentSetPid = BioParentSetPid;
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

	public void setLocalSentceSetPid(int LocalSentceSetPid) {
		this.LocalSentceSetPid = LocalSentceSetPid;
	}

	public void setMemoSetPid(int MemoSetPid) {
		this.MemoSetPid = MemoSetPid;
	}

	public void setOccasnPid(int OccasnPid) {
		this.OccasnPid = OccasnPid;
	}

	public void setParentPid(int ParentPid) {
		this.ParentPid = ParentPid;
	}

	public void setParentSubTypeKey(short ParentSubTypeKey) {
		this.ParentSubTypeKey = ParentSubTypeKey;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setSentceStyleKey(short SentceStyleKey) {
		this.SentceStyleKey = SentceStyleKey;
	}

	public void setSentceTypeKey(short SentceTypeKey) {
		this.SentceTypeKey = SentceTypeKey;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setSurety(String Surety) {
		this.Surety = Surety;
	}

	public void setTagTypeKey(short TagTypeKey) {
		this.TagTypeKey = TagTypeKey;
	}

	public void setThemeKey(short ThemeKey) {
		this.ThemeKey = ThemeKey;
	}

	public void setThemeVisibleId(int ThemeVisibleId) {
		this.ThemeVisibleId = ThemeVisibleId;
	}

}
