package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SUBSET_SINGLE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SubsetSingleDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSET_SINGLE_DEFN_PID, " + "SUBSET_PID, " + "USE_ORDER, " + "REFER_PID, "
			+ "COUNT FROM PUBLIC.SUBSET_SINGLE_DEFNS WHERE SUBSET_SINGLE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSET_SINGLE_DEFN_PID, " + "SUBSET_PID, " + "USE_ORDER, " + "REFER_PID, "
			+ "COUNT FROM PUBLIC.SUBSET_SINGLE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.SUBSET_SINGLE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SUBSET_SINGLE_DEFN_PID, " + "SUBSET_PID, " + "USE_ORDER, " + "REFER_PID, "
			+ "COUNT) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SUBSET_SINGLE_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "SUBSET_PID = ?, " + "USE_ORDER = ?, " + "REFER_PID = ?, "
			+ "COUNT = ? WHERE SUBSET_SINGLE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SUBSET_SINGLE_DEFNS WHERE SUBSET_SINGLE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSET_SINGLE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SubsetSingleDefnPid;
	private int SubsetPid;
	private int UseOrder;
	private int ReferPid;
	private int Count;
	private SubsetSingleDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SubsetSingleDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param SubsetSingleDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SubsetSingleDefns(int SubsetSingleDefnPid) throws SQLException {
		super();
		this.SubsetSingleDefnPid = SubsetSingleDefnPid;
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
			model = new SubsetSingleDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSubsetSingleDefnPid(rs.getInt("SUBSET_SINGLE_DEFN_PID"));
			model.setSubsetPid(rs.getInt("SUBSET_PID"));
			model.setUseOrder(rs.getInt("USE_ORDER"));
			model.setReferPid(rs.getInt("REFER_PID"));
			model.setCount(rs.getInt("COUNT"));
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
			model.setSubsetSingleDefnPid(rs.getInt("SUBSET_SINGLE_DEFN_PID"));
			model.setSubsetPid(rs.getInt("SUBSET_PID"));
			model.setUseOrder(rs.getInt("USE_ORDER"));
			model.setReferPid(rs.getInt("REFER_PID"));
			model.setCount(rs.getInt("COUNT"));
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
	 * Get the Count field.
	 *
	 * @return Contents of the COUNT column
	 */
	public int getCount() {
		return this.Count;
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
	 * Get the ReferPid field.
	 *
	 * @return Contents of the REFER_PID column
	 */
	public int getReferPid() {
		return this.ReferPid;
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
	 * Get the SubsetPid field.
	 *
	 * @return Contents of the SUBSET_PID column
	 */
	public int getSubsetPid() {
		return this.SubsetPid;
	}

	/**
	 * Get the SubsetSingleDefnPid field.
	 *
	 * @return Contents of the SUBSET_SINGLE_DEFN_PID column
	 */
	public int getSubsetSingleDefnPid() {
		return this.SubsetSingleDefnPid;
	}

	/**
	 * Get the UseOrder field.
	 *
	 * @return Contents of the USE_ORDER column
	 */
	public int getUseOrder() {
		return this.UseOrder;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((SubsetSingleDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubsetSingleDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubsetSingleDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubsetSingleDefns) model).setSubsetSingleDefnPid(rs.getInt("SUBSET_SINGLE_DEFN_PID"));
		((SubsetSingleDefns) model).setSubsetPid(rs.getInt("SUBSET_PID"));
		((SubsetSingleDefns) model).setUseOrder(rs.getInt("USE_ORDER"));
		((SubsetSingleDefns) model).setReferPid(rs.getInt("REFER_PID"));
		((SubsetSingleDefns) model).setCount(rs.getInt("COUNT"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SubsetSingleDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubsetSingleDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubsetSingleDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubsetSingleDefns) model).setSubsetSingleDefnPid(rs.getInt("SUBSET_SINGLE_DEFN_PID"));
		((SubsetSingleDefns) model).setSubsetPid(rs.getInt("SUBSET_PID"));
		((SubsetSingleDefns) model).setUseOrder(rs.getInt("USE_ORDER"));
		((SubsetSingleDefns) model).setReferPid(rs.getInt("REFER_PID"));
		((SubsetSingleDefns) model).setCount(rs.getInt("COUNT"));
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
	 * Set the Count field
	 *
	 * @param Count
	 *            Contents of the COUNT column
	 */
	public void setCount(int Count) {
		this.Count = Count;
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
	 * Set the ReferPid field
	 *
	 * @param ReferPid
	 *            Contents of the REFER_PID column
	 */
	public void setReferPid(int ReferPid) {
		this.ReferPid = ReferPid;
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
	 * Set the SubsetPid field
	 *
	 * @param SubsetPid
	 *            Contents of the SUBSET_PID column
	 */
	public void setSubsetPid(int SubsetPid) {
		this.SubsetPid = SubsetPid;
	}

	/**
	 * Set the SubsetSingleDefnPid field
	 *
	 * @param SubsetSingleDefnPid
	 *            Contents of the SUBSET_SINGLE_DEFN_PID column
	 */
	public void setSubsetSingleDefnPid(int SubsetSingleDefnPid) {
		this.SubsetSingleDefnPid = SubsetSingleDefnPid;
	}

	/**
	 * Set the UseOrder field
	 *
	 * @param UseOrder
	 *            Contents of the USE_ORDER column
	 */
	public void setUseOrder(int UseOrder) {
		this.UseOrder = UseOrder;
	}

}
