package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the ROLE_PAIR_NAME_TRANS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class RolePairNameTrans extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "ROLE_PAIR_NAME_TRAN_PID, " + "IS_SYSTEM, " + "PLUGIN_KEY, " + "TAG_KEY, " + "LANG_CODE, "
			+ "ROLE_A_TO_B, " + "ROLE_B_TO_A FROM PUBLIC.ROLE_PAIR_NAME_TRANS WHERE ROLE_PAIR_NAME_TRAN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "ROLE_PAIR_NAME_TRAN_PID, " + "IS_SYSTEM, " + "PLUGIN_KEY, " + "TAG_KEY, " + "LANG_CODE, "
			+ "ROLE_A_TO_B, " + "ROLE_B_TO_A FROM PUBLIC.ROLE_PAIR_NAME_TRANS";

	private static final String INSERT = "INSERT INTO PUBLIC.ROLE_PAIR_NAME_TRANS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "ROLE_PAIR_NAME_TRAN_PID, " + "IS_SYSTEM, " + "PLUGIN_KEY, " + "TAG_KEY, "
			+ "LANG_CODE, " + "ROLE_A_TO_B, " + "ROLE_B_TO_A) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.ROLE_PAIR_NAME_TRANSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PLUGIN_KEY = ?, " + "TAG_KEY = ?, " + "LANG_CODE = ?, "
			+ "ROLE_A_TO_B = ?, " + "ROLE_B_TO_A = ? WHERE ROLE_PAIR_NAME_TRAN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.ROLE_PAIR_NAME_TRANS WHERE ROLE_PAIR_NAME_TRAN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.ROLE_PAIR_NAME_TRANS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int RolePairNameTranPid;
	private boolean IsSystem;
	private short PluginKey;
	private short TagKey;
	private String LangCode;
	private String RoleAToB;
	private String RoleBToA;
	private RolePairNameTrans model;

	public RolePairNameTrans() throws SQLException {
	}

	public RolePairNameTrans(int RolePairNameTranPid) throws SQLException {
		super();
		this.RolePairNameTranPid = RolePairNameTranPid;
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
			model = new RolePairNameTrans();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setRolePairNameTranPid(rs.getInt("ROLE_PAIR_NAME_TRAN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setTagKey(rs.getShort("TAG_KEY"));
			model.setLangCode(rs.getString("LANG_CODE"));
			model.setRoleAToB(rs.getString("ROLE_A_TO_B"));
			model.setRoleBToA(rs.getString("ROLE_B_TO_A"));
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
			model.setRolePairNameTranPid(rs.getInt("ROLE_PAIR_NAME_TRAN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setTagKey(rs.getShort("TAG_KEY"));
			model.setLangCode(rs.getString("LANG_CODE"));
			model.setRoleAToB(rs.getString("ROLE_A_TO_B"));
			model.setRoleBToA(rs.getString("ROLE_B_TO_A"));
		}
		return this;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public String getLangCode() {
		return this.LangCode;
	}

	public short getPluginKey() {
		return this.PluginKey;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public String getRoleAToB() {
		return this.RoleAToB;
	}

	public String getRoleBToA() {
		return this.RoleBToA;
	}

	public int getRolePairNameTranPid() {
		return this.RolePairNameTranPid;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public short getTagKey() {
		return this.TagKey;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((RolePairNameTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((RolePairNameTrans) model).setSetKey(rs.getShort("SET_KEY"));
		((RolePairNameTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((RolePairNameTrans) model).setRolePairNameTranPid(rs.getInt("ROLE_PAIR_NAME_TRAN_PID"));
		((RolePairNameTrans) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((RolePairNameTrans) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((RolePairNameTrans) model).setTagKey(rs.getShort("TAG_KEY"));
		((RolePairNameTrans) model).setLangCode(rs.getString("LANG_CODE"));
		((RolePairNameTrans) model).setRoleAToB(rs.getString("ROLE_A_TO_B"));
		((RolePairNameTrans) model).setRoleBToA(rs.getString("ROLE_B_TO_A"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((RolePairNameTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((RolePairNameTrans) model).setSetKey(rs.getShort("SET_KEY"));
		((RolePairNameTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((RolePairNameTrans) model).setRolePairNameTranPid(rs.getInt("ROLE_PAIR_NAME_TRAN_PID"));
		((RolePairNameTrans) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((RolePairNameTrans) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((RolePairNameTrans) model).setTagKey(rs.getShort("TAG_KEY"));
		((RolePairNameTrans) model).setLangCode(rs.getString("LANG_CODE"));
		((RolePairNameTrans) model).setRoleAToB(rs.getString("ROLE_A_TO_B"));
		((RolePairNameTrans) model).setRoleBToA(rs.getString("ROLE_B_TO_A"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setLangCode(String LangCode) {
		this.LangCode = LangCode;
	}

	public void setPluginKey(short PluginKey) {
		this.PluginKey = PluginKey;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setRoleAToB(String RoleAToB) {
		this.RoleAToB = RoleAToB;
	}

	public void setRoleBToA(String RoleBToA) {
		this.RoleBToA = RoleBToA;
	}

	public void setRolePairNameTranPid(int RolePairNameTranPid) {
		this.RolePairNameTranPid = RolePairNameTranPid;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setTagKey(short TagKey) {
		this.TagKey = TagKey;
	}

}
