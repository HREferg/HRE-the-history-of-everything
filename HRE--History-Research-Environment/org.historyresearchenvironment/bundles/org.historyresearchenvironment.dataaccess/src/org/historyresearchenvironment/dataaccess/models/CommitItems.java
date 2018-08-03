package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the COMMIT_ITEMS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class CommitItems extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "COMMIT_ITEM_PID, "
			+ "PARENT_CMT_PID, " + "TABLE_KEY, " + "RECORD_PID, "
			+ "PREV_CMT_PID FROM PUBLIC.COMMIT_ITEMS WHERE COMMIT_ITEM_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "COMMIT_ITEM_PID, " + "PARENT_CMT_PID, " + "TABLE_KEY, " + "RECORD_PID, "
			+ "PREV_CMT_PID FROM PUBLIC.COMMIT_ITEMS";

	private static final String INSERT = "INSERT INTO PUBLIC.COMMIT_ITEMS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "COMMIT_ITEM_PID, " + "PARENT_CMT_PID, " + "TABLE_KEY, " + "RECORD_PID, "
			+ "PREV_CMT_PID) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.COMMIT_ITEMSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "PARENT_CMT_PID = ?, " + "TABLE_KEY = ?, " + "RECORD_PID = ?, "
			+ "PREV_CMT_PID = ? WHERE COMMIT_ITEM_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.COMMIT_ITEMS WHERE COMMIT_ITEM_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.COMMIT_ITEMS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int CommitItemPid;
	private int ParentCmtPid;
	private short TableKey;
	private int RecordPid;
	private int PrevCmtPid;
	private CommitItems model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public CommitItems() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param CommitItemPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public CommitItems(int CommitItemPid) throws SQLException {
		super();
		this.CommitItemPid = CommitItemPid;
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
			model = new CommitItems();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setCommitItemPid(rs.getInt("COMMIT_ITEM_PID"));
			model.setParentCmtPid(rs.getInt("PARENT_CMT_PID"));
			model.setTableKey(rs.getShort("TABLE_KEY"));
			model.setRecordPid(rs.getInt("RECORD_PID"));
			model.setPrevCmtPid(rs.getInt("PREV_CMT_PID"));
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
			model.setCommitItemPid(rs.getInt("COMMIT_ITEM_PID"));
			model.setParentCmtPid(rs.getInt("PARENT_CMT_PID"));
			model.setTableKey(rs.getShort("TABLE_KEY"));
			model.setRecordPid(rs.getInt("RECORD_PID"));
			model.setPrevCmtPid(rs.getInt("PREV_CMT_PID"));
		}
		return this;
	}

	/**
	 * Get the CommitItemPid field.
	 *
	 * @return Contents of the COMMIT_ITEM_PID column
	 */
	public int getCommitItemPid() {
		return this.CommitItemPid;
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
	 * Get the ParentCmtPid field.
	 *
	 * @return Contents of the PARENT_CMT_PID column
	 */
	public int getParentCmtPid() {
		return this.ParentCmtPid;
	}

	/**
	 * Get the PrevCmtPid field.
	 *
	 * @return Contents of the PREV_CMT_PID column
	 */
	public int getPrevCmtPid() {
		return this.PrevCmtPid;
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
	 * Get the RecordPid field.
	 *
	 * @return Contents of the RECORD_PID column
	 */
	public int getRecordPid() {
		return this.RecordPid;
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
	 * Get the TableKey field.
	 *
	 * @return Contents of the TABLE_KEY column
	 */
	public short getTableKey() {
		return this.TableKey;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((CommitItems) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((CommitItems) model).setSetKey(rs.getShort("SET_KEY"));
		((CommitItems) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((CommitItems) model).setCommitItemPid(rs.getInt("COMMIT_ITEM_PID"));
		((CommitItems) model).setParentCmtPid(rs.getInt("PARENT_CMT_PID"));
		((CommitItems) model).setTableKey(rs.getShort("TABLE_KEY"));
		((CommitItems) model).setRecordPid(rs.getInt("RECORD_PID"));
		((CommitItems) model).setPrevCmtPid(rs.getInt("PREV_CMT_PID"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((CommitItems) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((CommitItems) model).setSetKey(rs.getShort("SET_KEY"));
		((CommitItems) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((CommitItems) model).setCommitItemPid(rs.getInt("COMMIT_ITEM_PID"));
		((CommitItems) model).setParentCmtPid(rs.getInt("PARENT_CMT_PID"));
		((CommitItems) model).setTableKey(rs.getShort("TABLE_KEY"));
		((CommitItems) model).setRecordPid(rs.getInt("RECORD_PID"));
		((CommitItems) model).setPrevCmtPid(rs.getInt("PREV_CMT_PID"));
		ps.executeUpdate();
	}

	/**
	 * Set the CommitItemPid field
	 *
	 * @param CommitItemPid
	 *            Contents of the COMMIT_ITEM_PID column
	 */
	public void setCommitItemPid(int CommitItemPid) {
		this.CommitItemPid = CommitItemPid;
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
	 * Set the ParentCmtPid field
	 *
	 * @param ParentCmtPid
	 *            Contents of the PARENT_CMT_PID column
	 */
	public void setParentCmtPid(int ParentCmtPid) {
		this.ParentCmtPid = ParentCmtPid;
	}

	/**
	 * Set the PrevCmtPid field
	 *
	 * @param PrevCmtPid
	 *            Contents of the PREV_CMT_PID column
	 */
	public void setPrevCmtPid(int PrevCmtPid) {
		this.PrevCmtPid = PrevCmtPid;
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
	 * Set the RecordPid field
	 *
	 * @param RecordPid
	 *            Contents of the RECORD_PID column
	 */
	public void setRecordPid(int RecordPid) {
		this.RecordPid = RecordPid;
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
	 * Set the TableKey field
	 *
	 * @param TableKey
	 *            Contents of the TABLE_KEY column
	 */
	public void setTableKey(short TableKey) {
		this.TableKey = TableKey;
	}

}
