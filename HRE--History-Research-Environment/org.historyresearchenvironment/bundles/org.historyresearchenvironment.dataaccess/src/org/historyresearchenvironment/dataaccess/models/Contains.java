package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the CONTAINS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class Contains extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "CONTAIN_PID, "
			+ "IS_SYSTEM, " + "VISIBLE_ID, " + "SUB_TYPE_KEY, " + "BEST_NAME_PID, " + "BEST_CREATE_PID, "
			+ "BEST_DESTROY_PID, " + "BEST_IMAGE_PID, " + "SURETY, "
			+ "FLAGS FROM PUBLIC.CONTAINS WHERE CONTAIN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "CONTAIN_PID, "
			+ "IS_SYSTEM, " + "VISIBLE_ID, " + "SUB_TYPE_KEY, " + "BEST_NAME_PID, " + "BEST_CREATE_PID, "
			+ "BEST_DESTROY_PID, " + "BEST_IMAGE_PID, " + "SURETY, " + "FLAGS FROM PUBLIC.CONTAINS";

	private static final String INSERT = "INSERT INTO PUBLIC.CONTAINS( " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "CONTAIN_PID, " + "IS_SYSTEM, " + "VISIBLE_ID, " + "SUB_TYPE_KEY, " + "BEST_NAME_PID, "
			+ "BEST_CREATE_PID, " + "BEST_DESTROY_PID, " + "BEST_IMAGE_PID, " + "SURETY, " + "FLAGS) VALUES (?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.CONTAINSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "VISIBLE_ID = ?, " + "SUB_TYPE_KEY = ?, " + "BEST_NAME_PID = ?, "
			+ "BEST_CREATE_PID = ?, " + "BEST_DESTROY_PID = ?, " + "BEST_IMAGE_PID = ?, " + "SURETY = ?, "
			+ "FLAGS = ? WHERE CONTAIN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.CONTAINS WHERE CONTAIN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.CONTAINS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int ContainPid;
	private boolean IsSystem;
	private int VisibleId;
	private short SubTypeKey;
	private int BestNamePid;
	private int BestCreatePid;
	private int BestDestroyPid;
	private int BestImagePid;
	private String Surety;
	private byte[] Flags;
	private Contains model;

	public Contains() throws SQLException {
	}

	public Contains(int ContainPid) throws SQLException {
		super();
		this.ContainPid = ContainPid;
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
			model = new Contains();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setContainPid(rs.getInt("CONTAIN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setVisibleId(rs.getInt("VISIBLE_ID"));
			model.setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
			model.setBestNamePid(rs.getInt("BEST_NAME_PID"));
			model.setBestCreatePid(rs.getInt("BEST_CREATE_PID"));
			model.setBestDestroyPid(rs.getInt("BEST_DESTROY_PID"));
			model.setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
			model.setSurety(rs.getString("SURETY"));
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
			model.setContainPid(rs.getInt("CONTAIN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setVisibleId(rs.getInt("VISIBLE_ID"));
			model.setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
			model.setBestNamePid(rs.getInt("BEST_NAME_PID"));
			model.setBestCreatePid(rs.getInt("BEST_CREATE_PID"));
			model.setBestDestroyPid(rs.getInt("BEST_DESTROY_PID"));
			model.setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
			model.setSurety(rs.getString("SURETY"));
			model.setFlags(rs.getBytes("FLAGS"));
		}
		return this;
	}

	public int getBestCreatePid() {
		return this.BestCreatePid;
	}

	public int getBestDestroyPid() {
		return this.BestDestroyPid;
	}

	public int getBestImagePid() {
		return this.BestImagePid;
	}

	public int getBestNamePid() {
		return this.BestNamePid;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public int getContainPid() {
		return this.ContainPid;
	}

	public byte[] getFlags() {
		return this.Flags;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public short getSubTypeKey() {
		return this.SubTypeKey;
	}

	public String getSurety() {
		return this.Surety;
	}

	public int getVisibleId() {
		return this.VisibleId;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((Contains) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Contains) model).setSetKey(rs.getShort("SET_KEY"));
		((Contains) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Contains) model).setContainPid(rs.getInt("CONTAIN_PID"));
		((Contains) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((Contains) model).setVisibleId(rs.getInt("VISIBLE_ID"));
		((Contains) model).setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
		((Contains) model).setBestNamePid(rs.getInt("BEST_NAME_PID"));
		((Contains) model).setBestCreatePid(rs.getInt("BEST_CREATE_PID"));
		((Contains) model).setBestDestroyPid(rs.getInt("BEST_DESTROY_PID"));
		((Contains) model).setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
		((Contains) model).setSurety(rs.getString("SURETY"));
		((Contains) model).setFlags(rs.getBytes("FLAGS"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((Contains) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Contains) model).setSetKey(rs.getShort("SET_KEY"));
		((Contains) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Contains) model).setContainPid(rs.getInt("CONTAIN_PID"));
		((Contains) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((Contains) model).setVisibleId(rs.getInt("VISIBLE_ID"));
		((Contains) model).setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
		((Contains) model).setBestNamePid(rs.getInt("BEST_NAME_PID"));
		((Contains) model).setBestCreatePid(rs.getInt("BEST_CREATE_PID"));
		((Contains) model).setBestDestroyPid(rs.getInt("BEST_DESTROY_PID"));
		((Contains) model).setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
		((Contains) model).setSurety(rs.getString("SURETY"));
		((Contains) model).setFlags(rs.getBytes("FLAGS"));
		ps.executeUpdate();
	}

	public void setBestCreatePid(int BestCreatePid) {
		this.BestCreatePid = BestCreatePid;
	}

	public void setBestDestroyPid(int BestDestroyPid) {
		this.BestDestroyPid = BestDestroyPid;
	}

	public void setBestImagePid(int BestImagePid) {
		this.BestImagePid = BestImagePid;
	}

	public void setBestNamePid(int BestNamePid) {
		this.BestNamePid = BestNamePid;
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setContainPid(int ContainPid) {
		this.ContainPid = ContainPid;
	}

	public void setFlags(byte[] Flags) {
		this.Flags = Flags;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setSubTypeKey(short SubTypeKey) {
		this.SubTypeKey = SubTypeKey;
	}

	public void setSurety(String Surety) {
		this.Surety = Surety;
	}

	public void setVisibleId(int VisibleId) {
		this.VisibleId = VisibleId;
	}

}
