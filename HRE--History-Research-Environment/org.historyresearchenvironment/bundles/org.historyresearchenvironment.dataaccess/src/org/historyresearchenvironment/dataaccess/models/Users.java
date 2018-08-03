package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the USERS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class Users extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "USER_PID, "
			+ "LOGON_NAME, " + "USER_NAME, " + "PASSWORD, " + "EMAIL, " + "USER_TYPE_PID, "
			+ "USER_GROUP_PID FROM PUBLIC.USERS WHERE USER_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "USER_PID, "
			+ "LOGON_NAME, " + "USER_NAME, " + "PASSWORD, " + "EMAIL, " + "USER_TYPE_PID, "
			+ "USER_GROUP_PID FROM PUBLIC.USERS";

	private static final String INSERT = "INSERT INTO PUBLIC.USERS( " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "USER_PID, " + "LOGON_NAME, " + "USER_NAME, " + "PASSWORD, " + "EMAIL, " + "USER_TYPE_PID, "
			+ "USER_GROUP_PID) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.USERSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "LOGON_NAME = ?, " + "USER_NAME = ?, " + "PASSWORD = ?, " + "EMAIL = ?, "
			+ "USER_TYPE_PID = ?, " + "USER_GROUP_PID = ? WHERE USER_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.USERS WHERE USER_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.USERS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int UserPid;
	private String LogonName;
	private String UserName;
	private String Password;
	private String Email;
	private int UserTypePid;
	private int UserGroupPid;
	private Users model;

	public Users() throws SQLException {
	}

	public Users(int UserPid) throws SQLException {
		super();
		this.UserPid = UserPid;
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
			model = new Users();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setUserPid(rs.getInt("USER_PID"));
			model.setLogonName(rs.getString("LOGON_NAME"));
			model.setUserName(rs.getString("USER_NAME"));
			model.setPassword(rs.getString("PASSWORD"));
			model.setEmail(rs.getString("EMAIL"));
			model.setUserTypePid(rs.getInt("USER_TYPE_PID"));
			model.setUserGroupPid(rs.getInt("USER_GROUP_PID"));
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
			model.setUserPid(rs.getInt("USER_PID"));
			model.setLogonName(rs.getString("LOGON_NAME"));
			model.setUserName(rs.getString("USER_NAME"));
			model.setPassword(rs.getString("PASSWORD"));
			model.setEmail(rs.getString("EMAIL"));
			model.setUserTypePid(rs.getInt("USER_TYPE_PID"));
			model.setUserGroupPid(rs.getInt("USER_GROUP_PID"));
		}
		return this;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public String getEmail() {
		return this.Email;
	}

	public String getLogonName() {
		return this.LogonName;
	}

	public String getPassword() {
		return this.Password;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public int getUserGroupPid() {
		return this.UserGroupPid;
	}

	public String getUserName() {
		return this.UserName;
	}

	public int getUserPid() {
		return this.UserPid;
	}

	public int getUserTypePid() {
		return this.UserTypePid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((Users) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Users) model).setSetKey(rs.getShort("SET_KEY"));
		((Users) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Users) model).setUserPid(rs.getInt("USER_PID"));
		((Users) model).setLogonName(rs.getString("LOGON_NAME"));
		((Users) model).setUserName(rs.getString("USER_NAME"));
		((Users) model).setPassword(rs.getString("PASSWORD"));
		((Users) model).setEmail(rs.getString("EMAIL"));
		((Users) model).setUserTypePid(rs.getInt("USER_TYPE_PID"));
		((Users) model).setUserGroupPid(rs.getInt("USER_GROUP_PID"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((Users) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Users) model).setSetKey(rs.getShort("SET_KEY"));
		((Users) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Users) model).setUserPid(rs.getInt("USER_PID"));
		((Users) model).setLogonName(rs.getString("LOGON_NAME"));
		((Users) model).setUserName(rs.getString("USER_NAME"));
		((Users) model).setPassword(rs.getString("PASSWORD"));
		((Users) model).setEmail(rs.getString("EMAIL"));
		((Users) model).setUserTypePid(rs.getInt("USER_TYPE_PID"));
		((Users) model).setUserGroupPid(rs.getInt("USER_GROUP_PID"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public void setLogonName(String LogonName) {
		this.LogonName = LogonName;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setUserGroupPid(int UserGroupPid) {
		this.UserGroupPid = UserGroupPid;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public void setUserPid(int UserPid) {
		this.UserPid = UserPid;
	}

	public void setUserTypePid(int UserTypePid) {
		this.UserTypePid = UserTypePid;
	}

}
