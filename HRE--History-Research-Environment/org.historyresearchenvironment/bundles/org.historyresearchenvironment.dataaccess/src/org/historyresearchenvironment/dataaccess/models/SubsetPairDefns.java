package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SUBSET_PAIR_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SubsetPairDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "SUBSET_PAIR_PID, "
			+ "SUBSET_PID, " + "USE_ORDER, " + "REFER1_PID, "
			+ "REFER2_PID FROM PUBLIC.SUBSET_PAIR_DEFNS WHERE SUBSET_PAIR_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSET_PAIR_PID, " + "SUBSET_PID, " + "USE_ORDER, " + "REFER1_PID, "
			+ "REFER2_PID FROM PUBLIC.SUBSET_PAIR_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.SUBSET_PAIR_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SUBSET_PAIR_PID, " + "SUBSET_PID, " + "USE_ORDER, " + "REFER1_PID, "
			+ "REFER2_PID) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SUBSET_PAIR_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "SUBSET_PID = ?, " + "USE_ORDER = ?, " + "REFER1_PID = ?, "
			+ "REFER2_PID = ? WHERE SUBSET_PAIR_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SUBSET_PAIR_DEFNS WHERE SUBSET_PAIR_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSET_PAIR_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SubsetPairPid;
	private int SubsetPid;
	private int UseOrder;
	private int Refer1Pid;
	private int Refer2Pid;
	private SubsetPairDefns model;

	public SubsetPairDefns() throws SQLException {
	}

	public SubsetPairDefns(int SubsetPairPid) throws SQLException {
		super();
		this.SubsetPairPid = SubsetPairPid;
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
			model = new SubsetPairDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSubsetPairPid(rs.getInt("SUBSET_PAIR_PID"));
			model.setSubsetPid(rs.getInt("SUBSET_PID"));
			model.setUseOrder(rs.getInt("USE_ORDER"));
			model.setRefer1Pid(rs.getInt("REFER1_PID"));
			model.setRefer2Pid(rs.getInt("REFER2_PID"));
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
			model.setSubsetPairPid(rs.getInt("SUBSET_PAIR_PID"));
			model.setSubsetPid(rs.getInt("SUBSET_PID"));
			model.setUseOrder(rs.getInt("USE_ORDER"));
			model.setRefer1Pid(rs.getInt("REFER1_PID"));
			model.setRefer2Pid(rs.getInt("REFER2_PID"));
		}
		return this;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public int getRefer1Pid() {
		return this.Refer1Pid;
	}

	public int getRefer2Pid() {
		return this.Refer2Pid;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public int getSubsetPairPid() {
		return this.SubsetPairPid;
	}

	public int getSubsetPid() {
		return this.SubsetPid;
	}

	public int getUseOrder() {
		return this.UseOrder;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((SubsetPairDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubsetPairDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubsetPairDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubsetPairDefns) model).setSubsetPairPid(rs.getInt("SUBSET_PAIR_PID"));
		((SubsetPairDefns) model).setSubsetPid(rs.getInt("SUBSET_PID"));
		((SubsetPairDefns) model).setUseOrder(rs.getInt("USE_ORDER"));
		((SubsetPairDefns) model).setRefer1Pid(rs.getInt("REFER1_PID"));
		((SubsetPairDefns) model).setRefer2Pid(rs.getInt("REFER2_PID"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SubsetPairDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubsetPairDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubsetPairDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubsetPairDefns) model).setSubsetPairPid(rs.getInt("SUBSET_PAIR_PID"));
		((SubsetPairDefns) model).setSubsetPid(rs.getInt("SUBSET_PID"));
		((SubsetPairDefns) model).setUseOrder(rs.getInt("USE_ORDER"));
		((SubsetPairDefns) model).setRefer1Pid(rs.getInt("REFER1_PID"));
		((SubsetPairDefns) model).setRefer2Pid(rs.getInt("REFER2_PID"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setRefer1Pid(int Refer1Pid) {
		this.Refer1Pid = Refer1Pid;
	}

	public void setRefer2Pid(int Refer2Pid) {
		this.Refer2Pid = Refer2Pid;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setSubsetPairPid(int SubsetPairPid) {
		this.SubsetPairPid = SubsetPairPid;
	}

	public void setSubsetPid(int SubsetPid) {
		this.SubsetPid = SubsetPid;
	}

	public void setUseOrder(int UseOrder) {
		this.UseOrder = UseOrder;
	}

}
