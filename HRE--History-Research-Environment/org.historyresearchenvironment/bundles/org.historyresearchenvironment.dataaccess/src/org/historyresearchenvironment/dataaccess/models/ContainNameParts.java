package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the CONTAIN_NAME_PARTS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class ContainNameParts extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "CONTAIN_NAME_PART_PID, " + "IS_SYSTEM, " + "ELEMENT_TYPE_KEY, " + "SHARED, " + "LANG_CODE, "
			+ "TRANS FROM PUBLIC.CONTAIN_NAME_PARTS WHERE CONTAIN_NAME_PART_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "CONTAIN_NAME_PART_PID, " + "IS_SYSTEM, " + "ELEMENT_TYPE_KEY, " + "SHARED, " + "LANG_CODE, "
			+ "TRANS FROM PUBLIC.CONTAIN_NAME_PARTS";

	private static final String INSERT = "INSERT INTO PUBLIC.CONTAIN_NAME_PARTS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "CONTAIN_NAME_PART_PID, " + "IS_SYSTEM, " + "ELEMENT_TYPE_KEY, " + "SHARED, "
			+ "LANG_CODE, " + "TRANS) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.CONTAIN_NAME_PARTSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "ELEMENT_TYPE_KEY = ?, " + "SHARED = ?, " + "LANG_CODE = ?, "
			+ "TRANS = ? WHERE CONTAIN_NAME_PART_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.CONTAIN_NAME_PARTS WHERE CONTAIN_NAME_PART_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.CONTAIN_NAME_PARTS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int ContainNamePartPid;
	private boolean IsSystem;
	private short ElementTypeKey;
	private int Shared;
	private String LangCode;
	private String Trans;
	private ContainNameParts model;

	public ContainNameParts() throws SQLException {
	}

	public ContainNameParts(int ContainNamePartPid) throws SQLException {
		super();
		this.ContainNamePartPid = ContainNamePartPid;
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
			model = new ContainNameParts();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setContainNamePartPid(rs.getInt("CONTAIN_NAME_PART_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
			model.setShared(rs.getInt("SHARED"));
			model.setLangCode(rs.getString("LANG_CODE"));
			model.setTrans(rs.getString("TRANS"));
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
			model.setContainNamePartPid(rs.getInt("CONTAIN_NAME_PART_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
			model.setShared(rs.getInt("SHARED"));
			model.setLangCode(rs.getString("LANG_CODE"));
			model.setTrans(rs.getString("TRANS"));
		}
		return this;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public int getContainNamePartPid() {
		return this.ContainNamePartPid;
	}

	public short getElementTypeKey() {
		return this.ElementTypeKey;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public String getLangCode() {
		return this.LangCode;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public int getShared() {
		return this.Shared;
	}

	public String getTrans() {
		return this.Trans;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((ContainNameParts) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((ContainNameParts) model).setSetKey(rs.getShort("SET_KEY"));
		((ContainNameParts) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((ContainNameParts) model).setContainNamePartPid(rs.getInt("CONTAIN_NAME_PART_PID"));
		((ContainNameParts) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((ContainNameParts) model).setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
		((ContainNameParts) model).setShared(rs.getInt("SHARED"));
		((ContainNameParts) model).setLangCode(rs.getString("LANG_CODE"));
		((ContainNameParts) model).setTrans(rs.getString("TRANS"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((ContainNameParts) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((ContainNameParts) model).setSetKey(rs.getShort("SET_KEY"));
		((ContainNameParts) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((ContainNameParts) model).setContainNamePartPid(rs.getInt("CONTAIN_NAME_PART_PID"));
		((ContainNameParts) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((ContainNameParts) model).setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
		((ContainNameParts) model).setShared(rs.getInt("SHARED"));
		((ContainNameParts) model).setLangCode(rs.getString("LANG_CODE"));
		((ContainNameParts) model).setTrans(rs.getString("TRANS"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setContainNamePartPid(int ContainNamePartPid) {
		this.ContainNamePartPid = ContainNamePartPid;
	}

	public void setElementTypeKey(short ElementTypeKey) {
		this.ElementTypeKey = ElementTypeKey;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setLangCode(String LangCode) {
		this.LangCode = LangCode;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setShared(int Shared) {
		this.Shared = Shared;
	}

	public void setTrans(String Trans) {
		this.Trans = Trans;
	}

}
