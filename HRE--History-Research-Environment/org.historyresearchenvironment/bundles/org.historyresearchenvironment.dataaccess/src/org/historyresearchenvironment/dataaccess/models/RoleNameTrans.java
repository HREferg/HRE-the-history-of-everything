package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the ROLE_NAME_TRANS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class RoleNameTrans extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "ROLE_NAME_TRAN_PID, " + "IS_SYSTEM, " + "PLUGIN_KEY, " + "TAG_KEY, " + "LANG_CODE, "
			+ "ROLE FROM PUBLIC.ROLE_NAME_TRANS WHERE ROLE_NAME_TRAN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "ROLE_NAME_TRAN_PID, " + "IS_SYSTEM, " + "PLUGIN_KEY, " + "TAG_KEY, " + "LANG_CODE, "
			+ "ROLE FROM PUBLIC.ROLE_NAME_TRANS";

	private static final String INSERT = "INSERT INTO PUBLIC.ROLE_NAME_TRANS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "ROLE_NAME_TRAN_PID, " + "IS_SYSTEM, " + "PLUGIN_KEY, " + "TAG_KEY, " + "LANG_CODE, "
			+ "ROLE) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.ROLE_NAME_TRANSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PLUGIN_KEY = ?, " + "TAG_KEY = ?, " + "LANG_CODE = ?, "
			+ "ROLE = ? WHERE ROLE_NAME_TRAN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.ROLE_NAME_TRANS WHERE ROLE_NAME_TRAN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.ROLE_NAME_TRANS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int RoleNameTranPid;
	private boolean IsSystem;
	private short PluginKey;
	private short TagKey;
	private String LangCode;
	private String Role;
	private RoleNameTrans model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public RoleNameTrans() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param RoleNameTranPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public RoleNameTrans(int RoleNameTranPid) throws SQLException {
		super();
		this.RoleNameTranPid = RoleNameTranPid;
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
			model = new RoleNameTrans();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setRoleNameTranPid(rs.getInt("ROLE_NAME_TRAN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setTagKey(rs.getShort("TAG_KEY"));
			model.setLangCode(rs.getString("LANG_CODE"));
			model.setRole(rs.getString("ROLE"));
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
			model.setRoleNameTranPid(rs.getInt("ROLE_NAME_TRAN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setTagKey(rs.getShort("TAG_KEY"));
			model.setLangCode(rs.getString("LANG_CODE"));
			model.setRole(rs.getString("ROLE"));
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
	 * Get the PluginKey field.
	 *
	 * @return Contents of the PLUGIN_KEY column
	 */
	public short getPluginKey() {
		return this.PluginKey;
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
	 * Get the Role field.
	 *
	 * @return Contents of the ROLE column
	 */
	public String getRole() {
		return this.Role;
	}

	/**
	 * Get the RoleNameTranPid field.
	 *
	 * @return Contents of the ROLE_NAME_TRAN_PID column
	 */
	public int getRoleNameTranPid() {
		return this.RoleNameTranPid;
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
	 * Get the TagKey field.
	 *
	 * @return Contents of the TAG_KEY column
	 */
	public short getTagKey() {
		return this.TagKey;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((RoleNameTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((RoleNameTrans) model).setSetKey(rs.getShort("SET_KEY"));
		((RoleNameTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((RoleNameTrans) model).setRoleNameTranPid(rs.getInt("ROLE_NAME_TRAN_PID"));
		((RoleNameTrans) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((RoleNameTrans) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((RoleNameTrans) model).setTagKey(rs.getShort("TAG_KEY"));
		((RoleNameTrans) model).setLangCode(rs.getString("LANG_CODE"));
		((RoleNameTrans) model).setRole(rs.getString("ROLE"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((RoleNameTrans) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((RoleNameTrans) model).setSetKey(rs.getShort("SET_KEY"));
		((RoleNameTrans) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((RoleNameTrans) model).setRoleNameTranPid(rs.getInt("ROLE_NAME_TRAN_PID"));
		((RoleNameTrans) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((RoleNameTrans) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((RoleNameTrans) model).setTagKey(rs.getShort("TAG_KEY"));
		((RoleNameTrans) model).setLangCode(rs.getString("LANG_CODE"));
		((RoleNameTrans) model).setRole(rs.getString("ROLE"));
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
	 * Set the PluginKey field
	 *
	 * @param PluginKey
	 *            Contents of the PLUGIN_KEY column
	 */
	public void setPluginKey(short PluginKey) {
		this.PluginKey = PluginKey;
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
	 * Set the Role field
	 *
	 * @param Role
	 *            Contents of the ROLE column
	 */
	public void setRole(String Role) {
		this.Role = Role;
	}

	/**
	 * Set the RoleNameTranPid field
	 *
	 * @param RoleNameTranPid
	 *            Contents of the ROLE_NAME_TRAN_PID column
	 */
	public void setRoleNameTranPid(int RoleNameTranPid) {
		this.RoleNameTranPid = RoleNameTranPid;
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
	 * Set the TagKey field
	 *
	 * @param TagKey
	 *            Contents of the TAG_KEY column
	 */
	public void setTagKey(short TagKey) {
		this.TagKey = TagKey;
	}

}
