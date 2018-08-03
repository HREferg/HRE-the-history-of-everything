package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the CONTAIN_NAMES database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class ContainNames extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "CONTAIN_NAME_PID, " + "IS_SYSTEM, " + "PARENT_PID, " + "PARENT_SUB_TYPE_KEY, " + "NAME_TAG_KEY, "
			+ "NAME_STYLE_KEY, " + "ELEMENTS_ENTERED, " + "THIS_HDATE_PID, " + "THIS_NAME_EVENT_PID, "
			+ "THIS_HDATE_INFERRED, " + "NEXT_HDATE_PID, " + "NEXT_NAME_EVENT_PID, " + "NEXT_HDATE_INFERRED, "
			+ "THEME_KEY, " + "SENTCE_SET_PID, " + "SENTCE_TYPE_KEY, " + "SENTCE_STYLE_KEY, "
			+ "MEMO_SET_PID FROM PUBLIC.CONTAIN_NAMES WHERE CONTAIN_NAME_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "CONTAIN_NAME_PID, " + "IS_SYSTEM, " + "PARENT_PID, " + "PARENT_SUB_TYPE_KEY, " + "NAME_TAG_KEY, "
			+ "NAME_STYLE_KEY, " + "ELEMENTS_ENTERED, " + "THIS_HDATE_PID, " + "THIS_NAME_EVENT_PID, "
			+ "THIS_HDATE_INFERRED, " + "NEXT_HDATE_PID, " + "NEXT_NAME_EVENT_PID, " + "NEXT_HDATE_INFERRED, "
			+ "THEME_KEY, " + "SENTCE_SET_PID, " + "SENTCE_TYPE_KEY, " + "SENTCE_STYLE_KEY, "
			+ "MEMO_SET_PID FROM PUBLIC.CONTAIN_NAMES";

	private static final String INSERT = "INSERT INTO PUBLIC.CONTAIN_NAMES( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "CONTAIN_NAME_PID, " + "IS_SYSTEM, " + "PARENT_PID, " + "PARENT_SUB_TYPE_KEY, "
			+ "NAME_TAG_KEY, " + "NAME_STYLE_KEY, " + "ELEMENTS_ENTERED, " + "THIS_HDATE_PID, "
			+ "THIS_NAME_EVENT_PID, " + "THIS_HDATE_INFERRED, " + "NEXT_HDATE_PID, " + "NEXT_NAME_EVENT_PID, "
			+ "NEXT_HDATE_INFERRED, " + "THEME_KEY, " + "SENTCE_SET_PID, " + "SENTCE_TYPE_KEY, " + "SENTCE_STYLE_KEY, "
			+ "MEMO_SET_PID) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.CONTAIN_NAMESSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PARENT_PID = ?, " + "PARENT_SUB_TYPE_KEY = ?, "
			+ "NAME_TAG_KEY = ?, " + "NAME_STYLE_KEY = ?, " + "ELEMENTS_ENTERED = ?, " + "THIS_HDATE_PID = ?, "
			+ "THIS_NAME_EVENT_PID = ?, " + "THIS_HDATE_INFERRED = ?, " + "NEXT_HDATE_PID = ?, "
			+ "NEXT_NAME_EVENT_PID = ?, " + "NEXT_HDATE_INFERRED = ?, " + "THEME_KEY = ?, " + "SENTCE_SET_PID = ?, "
			+ "SENTCE_TYPE_KEY = ?, " + "SENTCE_STYLE_KEY = ?, " + "MEMO_SET_PID = ? WHERE CONTAIN_NAME_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.CONTAIN_NAMES WHERE CONTAIN_NAME_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.CONTAIN_NAMES";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int ContainNamePid;
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
	private int SentceSetPid;
	private short SentceTypeKey;
	private short SentceStyleKey;
	private int MemoSetPid;
	private ContainNames model;

	public ContainNames() throws SQLException {
	}

	public ContainNames(int ContainNamePid) throws SQLException {
		super();
		this.ContainNamePid = ContainNamePid;
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
			model = new ContainNames();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setContainNamePid(rs.getInt("CONTAIN_NAME_PID"));
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
			model.setSentceSetPid(rs.getInt("SENTCE_SET_PID"));
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
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setContainNamePid(rs.getInt("CONTAIN_NAME_PID"));
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
			model.setSentceSetPid(rs.getInt("SENTCE_SET_PID"));
			model.setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
			model.setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
			model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
		}
		return this;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public int getContainNamePid() {
		return this.ContainNamePid;
	}

	public byte[] getElementsEntered() {
		return this.ElementsEntered;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public int getMemoSetPid() {
		return this.MemoSetPid;
	}

	public short getNameStyleKey() {
		return this.NameStyleKey;
	}

	public short getNameTagKey() {
		return this.NameTagKey;
	}

	public boolean getNextHdateInferred() {
		return this.NextHdateInferred;
	}

	public int getNextHdatePid() {
		return this.NextHdatePid;
	}

	public int getNextNameEventPid() {
		return this.NextNameEventPid;
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

	public int getSentceSetPid() {
		return this.SentceSetPid;
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

	public short getThemeKey() {
		return this.ThemeKey;
	}

	public boolean getThisHdateInferred() {
		return this.ThisHdateInferred;
	}

	public int getThisHdatePid() {
		return this.ThisHdatePid;
	}

	public int getThisNameEventPid() {
		return this.ThisNameEventPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((ContainNames) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((ContainNames) model).setSetKey(rs.getShort("SET_KEY"));
		((ContainNames) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((ContainNames) model).setContainNamePid(rs.getInt("CONTAIN_NAME_PID"));
		((ContainNames) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((ContainNames) model).setParentPid(rs.getInt("PARENT_PID"));
		((ContainNames) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((ContainNames) model).setNameTagKey(rs.getShort("NAME_TAG_KEY"));
		((ContainNames) model).setNameStyleKey(rs.getShort("NAME_STYLE_KEY"));
		((ContainNames) model).setElementsEntered(rs.getBytes("ELEMENTS_ENTERED"));
		((ContainNames) model).setThisHdatePid(rs.getInt("THIS_HDATE_PID"));
		((ContainNames) model).setThisNameEventPid(rs.getInt("THIS_NAME_EVENT_PID"));
		((ContainNames) model).setThisHdateInferred(rs.getBoolean("THIS_HDATE_INFERRED"));
		((ContainNames) model).setNextHdatePid(rs.getInt("NEXT_HDATE_PID"));
		((ContainNames) model).setNextNameEventPid(rs.getInt("NEXT_NAME_EVENT_PID"));
		((ContainNames) model).setNextHdateInferred(rs.getBoolean("NEXT_HDATE_INFERRED"));
		((ContainNames) model).setThemeKey(rs.getShort("THEME_KEY"));
		((ContainNames) model).setSentceSetPid(rs.getInt("SENTCE_SET_PID"));
		((ContainNames) model).setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
		((ContainNames) model).setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
		((ContainNames) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((ContainNames) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((ContainNames) model).setSetKey(rs.getShort("SET_KEY"));
		((ContainNames) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((ContainNames) model).setContainNamePid(rs.getInt("CONTAIN_NAME_PID"));
		((ContainNames) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((ContainNames) model).setParentPid(rs.getInt("PARENT_PID"));
		((ContainNames) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((ContainNames) model).setNameTagKey(rs.getShort("NAME_TAG_KEY"));
		((ContainNames) model).setNameStyleKey(rs.getShort("NAME_STYLE_KEY"));
		((ContainNames) model).setElementsEntered(rs.getBytes("ELEMENTS_ENTERED"));
		((ContainNames) model).setThisHdatePid(rs.getInt("THIS_HDATE_PID"));
		((ContainNames) model).setThisNameEventPid(rs.getInt("THIS_NAME_EVENT_PID"));
		((ContainNames) model).setThisHdateInferred(rs.getBoolean("THIS_HDATE_INFERRED"));
		((ContainNames) model).setNextHdatePid(rs.getInt("NEXT_HDATE_PID"));
		((ContainNames) model).setNextNameEventPid(rs.getInt("NEXT_NAME_EVENT_PID"));
		((ContainNames) model).setNextHdateInferred(rs.getBoolean("NEXT_HDATE_INFERRED"));
		((ContainNames) model).setThemeKey(rs.getShort("THEME_KEY"));
		((ContainNames) model).setSentceSetPid(rs.getInt("SENTCE_SET_PID"));
		((ContainNames) model).setSentceTypeKey(rs.getShort("SENTCE_TYPE_KEY"));
		((ContainNames) model).setSentceStyleKey(rs.getShort("SENTCE_STYLE_KEY"));
		((ContainNames) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setContainNamePid(int ContainNamePid) {
		this.ContainNamePid = ContainNamePid;
	}

	public void setElementsEntered(byte[] ElementsEntered) {
		this.ElementsEntered = ElementsEntered;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setMemoSetPid(int MemoSetPid) {
		this.MemoSetPid = MemoSetPid;
	}

	public void setNameStyleKey(short NameStyleKey) {
		this.NameStyleKey = NameStyleKey;
	}

	public void setNameTagKey(short NameTagKey) {
		this.NameTagKey = NameTagKey;
	}

	public void setNextHdateInferred(boolean NextHdateInferred) {
		this.NextHdateInferred = NextHdateInferred;
	}

	public void setNextHdatePid(int NextHdatePid) {
		this.NextHdatePid = NextHdatePid;
	}

	public void setNextNameEventPid(int NextNameEventPid) {
		this.NextNameEventPid = NextNameEventPid;
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

	public void setSentceSetPid(int SentceSetPid) {
		this.SentceSetPid = SentceSetPid;
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

	public void setThemeKey(short ThemeKey) {
		this.ThemeKey = ThemeKey;
	}

	public void setThisHdateInferred(boolean ThisHdateInferred) {
		this.ThisHdateInferred = ThisHdateInferred;
	}

	public void setThisHdatePid(int ThisHdatePid) {
		this.ThisHdatePid = ThisHdatePid;
	}

	public void setThisNameEventPid(int ThisNameEventPid) {
		this.ThisNameEventPid = ThisNameEventPid;
	}

}
