package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the FIELD_RECENTS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class FieldRecents extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "FIELD_RECENT_PID, " + "TABLE_KEY, " + "FIELD_PID, " + "RECENT01_PID, " + "RECENT02_PID, "
			+ "RECENT03_PID, " + "RECENT04_PID, " + "RECENT05_PID, " + "RECENT06_PID, " + "RECENT07_PID, "
			+ "RECENT08_PID, " + "RECENT09_PID, " + "RECENT10_PID, " + "RECENT11_PID, " + "RECENT12_PID, "
			+ "RECENT13_PID, " + "RECENT14_PID, " + "RECENT15_PID, " + "FIXED01_PID, " + "FIXED02_PID, "
			+ "FIXED03_PID, " + "FIXED04_PID, " + "FIXED05_PID FROM PUBLIC.FIELD_RECENTS WHERE FIELD_RECENT_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "FIELD_RECENT_PID, " + "TABLE_KEY, " + "FIELD_PID, " + "RECENT01_PID, " + "RECENT02_PID, "
			+ "RECENT03_PID, " + "RECENT04_PID, " + "RECENT05_PID, " + "RECENT06_PID, " + "RECENT07_PID, "
			+ "RECENT08_PID, " + "RECENT09_PID, " + "RECENT10_PID, " + "RECENT11_PID, " + "RECENT12_PID, "
			+ "RECENT13_PID, " + "RECENT14_PID, " + "RECENT15_PID, " + "FIXED01_PID, " + "FIXED02_PID, "
			+ "FIXED03_PID, " + "FIXED04_PID, " + "FIXED05_PID FROM PUBLIC.FIELD_RECENTS";

	private static final String INSERT = "INSERT INTO PUBLIC.FIELD_RECENTS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "FIELD_RECENT_PID, " + "TABLE_KEY, " + "FIELD_PID, " + "RECENT01_PID, "
			+ "RECENT02_PID, " + "RECENT03_PID, " + "RECENT04_PID, " + "RECENT05_PID, " + "RECENT06_PID, "
			+ "RECENT07_PID, " + "RECENT08_PID, " + "RECENT09_PID, " + "RECENT10_PID, " + "RECENT11_PID, "
			+ "RECENT12_PID, " + "RECENT13_PID, " + "RECENT14_PID, " + "RECENT15_PID, " + "FIXED01_PID, "
			+ "FIXED02_PID, " + "FIXED03_PID, " + "FIXED04_PID, " + "FIXED05_PID) VALUES (?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.FIELD_RECENTSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "TABLE_KEY = ?, " + "FIELD_PID = ?, " + "RECENT01_PID = ?, " + "RECENT02_PID = ?, "
			+ "RECENT03_PID = ?, " + "RECENT04_PID = ?, " + "RECENT05_PID = ?, " + "RECENT06_PID = ?, "
			+ "RECENT07_PID = ?, " + "RECENT08_PID = ?, " + "RECENT09_PID = ?, " + "RECENT10_PID = ?, "
			+ "RECENT11_PID = ?, " + "RECENT12_PID = ?, " + "RECENT13_PID = ?, " + "RECENT14_PID = ?, "
			+ "RECENT15_PID = ?, " + "FIXED01_PID = ?, " + "FIXED02_PID = ?, " + "FIXED03_PID = ?, "
			+ "FIXED04_PID = ?, " + "FIXED05_PID = ? WHERE FIELD_RECENT_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.FIELD_RECENTS WHERE FIELD_RECENT_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.FIELD_RECENTS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int FieldRecentPid;
	private short TableKey;
	private short FieldPid;
	private int Recent01Pid;
	private int Recent02Pid;
	private int Recent03Pid;
	private int Recent04Pid;
	private int Recent05Pid;
	private int Recent06Pid;
	private int Recent07Pid;
	private int Recent08Pid;
	private int Recent09Pid;
	private int Recent10Pid;
	private int Recent11Pid;
	private int Recent12Pid;
	private int Recent13Pid;
	private int Recent14Pid;
	private int Recent15Pid;
	private int Fixed01Pid;
	private int Fixed02Pid;
	private int Fixed03Pid;
	private int Fixed04Pid;
	private int Fixed05Pid;
	private FieldRecents model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public FieldRecents() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param FieldRecentPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public FieldRecents(int FieldRecentPid) throws SQLException {
		super();
		this.FieldRecentPid = FieldRecentPid;
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
			model = new FieldRecents();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setFieldRecentPid(rs.getInt("FIELD_RECENT_PID"));
			model.setTableKey(rs.getShort("TABLE_KEY"));
			model.setFieldPid(rs.getShort("FIELD_PID"));
			model.setRecent01Pid(rs.getInt("RECENT01_PID"));
			model.setRecent02Pid(rs.getInt("RECENT02_PID"));
			model.setRecent03Pid(rs.getInt("RECENT03_PID"));
			model.setRecent04Pid(rs.getInt("RECENT04_PID"));
			model.setRecent05Pid(rs.getInt("RECENT05_PID"));
			model.setRecent06Pid(rs.getInt("RECENT06_PID"));
			model.setRecent07Pid(rs.getInt("RECENT07_PID"));
			model.setRecent08Pid(rs.getInt("RECENT08_PID"));
			model.setRecent09Pid(rs.getInt("RECENT09_PID"));
			model.setRecent10Pid(rs.getInt("RECENT10_PID"));
			model.setRecent11Pid(rs.getInt("RECENT11_PID"));
			model.setRecent12Pid(rs.getInt("RECENT12_PID"));
			model.setRecent13Pid(rs.getInt("RECENT13_PID"));
			model.setRecent14Pid(rs.getInt("RECENT14_PID"));
			model.setRecent15Pid(rs.getInt("RECENT15_PID"));
			model.setFixed01Pid(rs.getInt("FIXED01_PID"));
			model.setFixed02Pid(rs.getInt("FIXED02_PID"));
			model.setFixed03Pid(rs.getInt("FIXED03_PID"));
			model.setFixed04Pid(rs.getInt("FIXED04_PID"));
			model.setFixed05Pid(rs.getInt("FIXED05_PID"));
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
			model.setFieldRecentPid(rs.getInt("FIELD_RECENT_PID"));
			model.setTableKey(rs.getShort("TABLE_KEY"));
			model.setFieldPid(rs.getShort("FIELD_PID"));
			model.setRecent01Pid(rs.getInt("RECENT01_PID"));
			model.setRecent02Pid(rs.getInt("RECENT02_PID"));
			model.setRecent03Pid(rs.getInt("RECENT03_PID"));
			model.setRecent04Pid(rs.getInt("RECENT04_PID"));
			model.setRecent05Pid(rs.getInt("RECENT05_PID"));
			model.setRecent06Pid(rs.getInt("RECENT06_PID"));
			model.setRecent07Pid(rs.getInt("RECENT07_PID"));
			model.setRecent08Pid(rs.getInt("RECENT08_PID"));
			model.setRecent09Pid(rs.getInt("RECENT09_PID"));
			model.setRecent10Pid(rs.getInt("RECENT10_PID"));
			model.setRecent11Pid(rs.getInt("RECENT11_PID"));
			model.setRecent12Pid(rs.getInt("RECENT12_PID"));
			model.setRecent13Pid(rs.getInt("RECENT13_PID"));
			model.setRecent14Pid(rs.getInt("RECENT14_PID"));
			model.setRecent15Pid(rs.getInt("RECENT15_PID"));
			model.setFixed01Pid(rs.getInt("FIXED01_PID"));
			model.setFixed02Pid(rs.getInt("FIXED02_PID"));
			model.setFixed03Pid(rs.getInt("FIXED03_PID"));
			model.setFixed04Pid(rs.getInt("FIXED04_PID"));
			model.setFixed05Pid(rs.getInt("FIXED05_PID"));
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
	 * Get the FieldPid field.
	 *
	 * @return Contents of the FIELD_PID column
	 */
	public short getFieldPid() {
		return this.FieldPid;
	}

	/**
	 * Get the FieldRecentPid field.
	 *
	 * @return Contents of the FIELD_RECENT_PID column
	 */
	public int getFieldRecentPid() {
		return this.FieldRecentPid;
	}

	/**
	 * Get the Fixed01Pid field.
	 *
	 * @return Contents of the FIXED01_PID column
	 */
	public int getFixed01Pid() {
		return this.Fixed01Pid;
	}

	/**
	 * Get the Fixed02Pid field.
	 *
	 * @return Contents of the FIXED02_PID column
	 */
	public int getFixed02Pid() {
		return this.Fixed02Pid;
	}

	/**
	 * Get the Fixed03Pid field.
	 *
	 * @return Contents of the FIXED03_PID column
	 */
	public int getFixed03Pid() {
		return this.Fixed03Pid;
	}

	/**
	 * Get the Fixed04Pid field.
	 *
	 * @return Contents of the FIXED04_PID column
	 */
	public int getFixed04Pid() {
		return this.Fixed04Pid;
	}

	/**
	 * Get the Fixed05Pid field.
	 *
	 * @return Contents of the FIXED05_PID column
	 */
	public int getFixed05Pid() {
		return this.Fixed05Pid;
	}

	/**
	 * Get the Recent01Pid field.
	 *
	 * @return Contents of the RECENT01_PID column
	 */
	public int getRecent01Pid() {
		return this.Recent01Pid;
	}

	/**
	 * Get the Recent02Pid field.
	 *
	 * @return Contents of the RECENT02_PID column
	 */
	public int getRecent02Pid() {
		return this.Recent02Pid;
	}

	/**
	 * Get the Recent03Pid field.
	 *
	 * @return Contents of the RECENT03_PID column
	 */
	public int getRecent03Pid() {
		return this.Recent03Pid;
	}

	/**
	 * Get the Recent04Pid field.
	 *
	 * @return Contents of the RECENT04_PID column
	 */
	public int getRecent04Pid() {
		return this.Recent04Pid;
	}

	/**
	 * Get the Recent05Pid field.
	 *
	 * @return Contents of the RECENT05_PID column
	 */
	public int getRecent05Pid() {
		return this.Recent05Pid;
	}

	/**
	 * Get the Recent06Pid field.
	 *
	 * @return Contents of the RECENT06_PID column
	 */
	public int getRecent06Pid() {
		return this.Recent06Pid;
	}

	/**
	 * Get the Recent07Pid field.
	 *
	 * @return Contents of the RECENT07_PID column
	 */
	public int getRecent07Pid() {
		return this.Recent07Pid;
	}

	/**
	 * Get the Recent08Pid field.
	 *
	 * @return Contents of the RECENT08_PID column
	 */
	public int getRecent08Pid() {
		return this.Recent08Pid;
	}

	/**
	 * Get the Recent09Pid field.
	 *
	 * @return Contents of the RECENT09_PID column
	 */
	public int getRecent09Pid() {
		return this.Recent09Pid;
	}

	/**
	 * Get the Recent10Pid field.
	 *
	 * @return Contents of the RECENT10_PID column
	 */
	public int getRecent10Pid() {
		return this.Recent10Pid;
	}

	/**
	 * Get the Recent11Pid field.
	 *
	 * @return Contents of the RECENT11_PID column
	 */
	public int getRecent11Pid() {
		return this.Recent11Pid;
	}

	/**
	 * Get the Recent12Pid field.
	 *
	 * @return Contents of the RECENT12_PID column
	 */
	public int getRecent12Pid() {
		return this.Recent12Pid;
	}

	/**
	 * Get the Recent13Pid field.
	 *
	 * @return Contents of the RECENT13_PID column
	 */
	public int getRecent13Pid() {
		return this.Recent13Pid;
	}

	/**
	 * Get the Recent14Pid field.
	 *
	 * @return Contents of the RECENT14_PID column
	 */
	public int getRecent14Pid() {
		return this.Recent14Pid;
	}

	/**
	 * Get the Recent15Pid field.
	 *
	 * @return Contents of the RECENT15_PID column
	 */
	public int getRecent15Pid() {
		return this.Recent15Pid;
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
		((FieldRecents) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((FieldRecents) model).setSetKey(rs.getShort("SET_KEY"));
		((FieldRecents) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((FieldRecents) model).setFieldRecentPid(rs.getInt("FIELD_RECENT_PID"));
		((FieldRecents) model).setTableKey(rs.getShort("TABLE_KEY"));
		((FieldRecents) model).setFieldPid(rs.getShort("FIELD_PID"));
		((FieldRecents) model).setRecent01Pid(rs.getInt("RECENT01_PID"));
		((FieldRecents) model).setRecent02Pid(rs.getInt("RECENT02_PID"));
		((FieldRecents) model).setRecent03Pid(rs.getInt("RECENT03_PID"));
		((FieldRecents) model).setRecent04Pid(rs.getInt("RECENT04_PID"));
		((FieldRecents) model).setRecent05Pid(rs.getInt("RECENT05_PID"));
		((FieldRecents) model).setRecent06Pid(rs.getInt("RECENT06_PID"));
		((FieldRecents) model).setRecent07Pid(rs.getInt("RECENT07_PID"));
		((FieldRecents) model).setRecent08Pid(rs.getInt("RECENT08_PID"));
		((FieldRecents) model).setRecent09Pid(rs.getInt("RECENT09_PID"));
		((FieldRecents) model).setRecent10Pid(rs.getInt("RECENT10_PID"));
		((FieldRecents) model).setRecent11Pid(rs.getInt("RECENT11_PID"));
		((FieldRecents) model).setRecent12Pid(rs.getInt("RECENT12_PID"));
		((FieldRecents) model).setRecent13Pid(rs.getInt("RECENT13_PID"));
		((FieldRecents) model).setRecent14Pid(rs.getInt("RECENT14_PID"));
		((FieldRecents) model).setRecent15Pid(rs.getInt("RECENT15_PID"));
		((FieldRecents) model).setFixed01Pid(rs.getInt("FIXED01_PID"));
		((FieldRecents) model).setFixed02Pid(rs.getInt("FIXED02_PID"));
		((FieldRecents) model).setFixed03Pid(rs.getInt("FIXED03_PID"));
		((FieldRecents) model).setFixed04Pid(rs.getInt("FIXED04_PID"));
		((FieldRecents) model).setFixed05Pid(rs.getInt("FIXED05_PID"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((FieldRecents) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((FieldRecents) model).setSetKey(rs.getShort("SET_KEY"));
		((FieldRecents) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((FieldRecents) model).setFieldRecentPid(rs.getInt("FIELD_RECENT_PID"));
		((FieldRecents) model).setTableKey(rs.getShort("TABLE_KEY"));
		((FieldRecents) model).setFieldPid(rs.getShort("FIELD_PID"));
		((FieldRecents) model).setRecent01Pid(rs.getInt("RECENT01_PID"));
		((FieldRecents) model).setRecent02Pid(rs.getInt("RECENT02_PID"));
		((FieldRecents) model).setRecent03Pid(rs.getInt("RECENT03_PID"));
		((FieldRecents) model).setRecent04Pid(rs.getInt("RECENT04_PID"));
		((FieldRecents) model).setRecent05Pid(rs.getInt("RECENT05_PID"));
		((FieldRecents) model).setRecent06Pid(rs.getInt("RECENT06_PID"));
		((FieldRecents) model).setRecent07Pid(rs.getInt("RECENT07_PID"));
		((FieldRecents) model).setRecent08Pid(rs.getInt("RECENT08_PID"));
		((FieldRecents) model).setRecent09Pid(rs.getInt("RECENT09_PID"));
		((FieldRecents) model).setRecent10Pid(rs.getInt("RECENT10_PID"));
		((FieldRecents) model).setRecent11Pid(rs.getInt("RECENT11_PID"));
		((FieldRecents) model).setRecent12Pid(rs.getInt("RECENT12_PID"));
		((FieldRecents) model).setRecent13Pid(rs.getInt("RECENT13_PID"));
		((FieldRecents) model).setRecent14Pid(rs.getInt("RECENT14_PID"));
		((FieldRecents) model).setRecent15Pid(rs.getInt("RECENT15_PID"));
		((FieldRecents) model).setFixed01Pid(rs.getInt("FIXED01_PID"));
		((FieldRecents) model).setFixed02Pid(rs.getInt("FIXED02_PID"));
		((FieldRecents) model).setFixed03Pid(rs.getInt("FIXED03_PID"));
		((FieldRecents) model).setFixed04Pid(rs.getInt("FIXED04_PID"));
		((FieldRecents) model).setFixed05Pid(rs.getInt("FIXED05_PID"));
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
	 * Set the FieldPid field
	 *
	 * @param FieldPid
	 *            Contents of the FIELD_PID column
	 */
	public void setFieldPid(short FieldPid) {
		this.FieldPid = FieldPid;
	}

	/**
	 * Set the FieldRecentPid field
	 *
	 * @param FieldRecentPid
	 *            Contents of the FIELD_RECENT_PID column
	 */
	public void setFieldRecentPid(int FieldRecentPid) {
		this.FieldRecentPid = FieldRecentPid;
	}

	/**
	 * Set the Fixed01Pid field
	 *
	 * @param Fixed01Pid
	 *            Contents of the FIXED01_PID column
	 */
	public void setFixed01Pid(int Fixed01Pid) {
		this.Fixed01Pid = Fixed01Pid;
	}

	/**
	 * Set the Fixed02Pid field
	 *
	 * @param Fixed02Pid
	 *            Contents of the FIXED02_PID column
	 */
	public void setFixed02Pid(int Fixed02Pid) {
		this.Fixed02Pid = Fixed02Pid;
	}

	/**
	 * Set the Fixed03Pid field
	 *
	 * @param Fixed03Pid
	 *            Contents of the FIXED03_PID column
	 */
	public void setFixed03Pid(int Fixed03Pid) {
		this.Fixed03Pid = Fixed03Pid;
	}

	/**
	 * Set the Fixed04Pid field
	 *
	 * @param Fixed04Pid
	 *            Contents of the FIXED04_PID column
	 */
	public void setFixed04Pid(int Fixed04Pid) {
		this.Fixed04Pid = Fixed04Pid;
	}

	/**
	 * Set the Fixed05Pid field
	 *
	 * @param Fixed05Pid
	 *            Contents of the FIXED05_PID column
	 */
	public void setFixed05Pid(int Fixed05Pid) {
		this.Fixed05Pid = Fixed05Pid;
	}

	/**
	 * Set the Recent01Pid field
	 *
	 * @param Recent01Pid
	 *            Contents of the RECENT01_PID column
	 */
	public void setRecent01Pid(int Recent01Pid) {
		this.Recent01Pid = Recent01Pid;
	}

	/**
	 * Set the Recent02Pid field
	 *
	 * @param Recent02Pid
	 *            Contents of the RECENT02_PID column
	 */
	public void setRecent02Pid(int Recent02Pid) {
		this.Recent02Pid = Recent02Pid;
	}

	/**
	 * Set the Recent03Pid field
	 *
	 * @param Recent03Pid
	 *            Contents of the RECENT03_PID column
	 */
	public void setRecent03Pid(int Recent03Pid) {
		this.Recent03Pid = Recent03Pid;
	}

	/**
	 * Set the Recent04Pid field
	 *
	 * @param Recent04Pid
	 *            Contents of the RECENT04_PID column
	 */
	public void setRecent04Pid(int Recent04Pid) {
		this.Recent04Pid = Recent04Pid;
	}

	/**
	 * Set the Recent05Pid field
	 *
	 * @param Recent05Pid
	 *            Contents of the RECENT05_PID column
	 */
	public void setRecent05Pid(int Recent05Pid) {
		this.Recent05Pid = Recent05Pid;
	}

	/**
	 * Set the Recent06Pid field
	 *
	 * @param Recent06Pid
	 *            Contents of the RECENT06_PID column
	 */
	public void setRecent06Pid(int Recent06Pid) {
		this.Recent06Pid = Recent06Pid;
	}

	/**
	 * Set the Recent07Pid field
	 *
	 * @param Recent07Pid
	 *            Contents of the RECENT07_PID column
	 */
	public void setRecent07Pid(int Recent07Pid) {
		this.Recent07Pid = Recent07Pid;
	}

	/**
	 * Set the Recent08Pid field
	 *
	 * @param Recent08Pid
	 *            Contents of the RECENT08_PID column
	 */
	public void setRecent08Pid(int Recent08Pid) {
		this.Recent08Pid = Recent08Pid;
	}

	/**
	 * Set the Recent09Pid field
	 *
	 * @param Recent09Pid
	 *            Contents of the RECENT09_PID column
	 */
	public void setRecent09Pid(int Recent09Pid) {
		this.Recent09Pid = Recent09Pid;
	}

	/**
	 * Set the Recent10Pid field
	 *
	 * @param Recent10Pid
	 *            Contents of the RECENT10_PID column
	 */
	public void setRecent10Pid(int Recent10Pid) {
		this.Recent10Pid = Recent10Pid;
	}

	/**
	 * Set the Recent11Pid field
	 *
	 * @param Recent11Pid
	 *            Contents of the RECENT11_PID column
	 */
	public void setRecent11Pid(int Recent11Pid) {
		this.Recent11Pid = Recent11Pid;
	}

	/**
	 * Set the Recent12Pid field
	 *
	 * @param Recent12Pid
	 *            Contents of the RECENT12_PID column
	 */
	public void setRecent12Pid(int Recent12Pid) {
		this.Recent12Pid = Recent12Pid;
	}

	/**
	 * Set the Recent13Pid field
	 *
	 * @param Recent13Pid
	 *            Contents of the RECENT13_PID column
	 */
	public void setRecent13Pid(int Recent13Pid) {
		this.Recent13Pid = Recent13Pid;
	}

	/**
	 * Set the Recent14Pid field
	 *
	 * @param Recent14Pid
	 *            Contents of the RECENT14_PID column
	 */
	public void setRecent14Pid(int Recent14Pid) {
		this.Recent14Pid = Recent14Pid;
	}

	/**
	 * Set the Recent15Pid field
	 *
	 * @param Recent15Pid
	 *            Contents of the RECENT15_PID column
	 */
	public void setRecent15Pid(int Recent15Pid) {
		this.Recent15Pid = Recent15Pid;
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
