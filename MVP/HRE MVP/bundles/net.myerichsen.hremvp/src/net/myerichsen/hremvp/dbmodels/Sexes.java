package net.myerichsen.hremvp.dbmodels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import net.myerichsen.hremvp.HreH2ConnectionPool;
import net.myerichsen.hremvp.MvpException;

/**
 * The persistent class for the SEXES database table
 *
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2019
 * @version 14. apr. 2019
 *
 */

public class Sexes {
	private static final String SELECT = "SELECT SEXES_PID, "
			+ "PERSON_PID, SEX_TYPE_PID, PRIMARY_SEX, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.SEXES WHERE SEXES_PID = ?";
	private static final String SELECT_PERSON_PID = "SELECT SEXES_PID, "
			+ "PERSON_PID, SEX_TYPE_PID, PRIMARY_SEX, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.SEXES WHERE PERSON_PID = ? ORDER BY SEXES_PID";
	private static final String SELECTALL = "SELECT SEXES_PID, "
			+ "PERSON_PID, SEX_TYPE_PID, PRIMARY_SEX, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.SEXES ORDER BY SEXES_PID";
	private static final String SELECTMAX = "SELECT MAX(SEXES_PID) FROM PUBLIC.SEXES";
	private static final String INSERT = "INSERT INTO PUBLIC.SEXES( "
			+ "SEXES_PID, PERSON_PID, SEX_TYPE_PID, "
			+ "PRIMARY_SEX, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID, FROM_DATE_PID, TO_DATE_PID) VALUES (?, "
			+ "?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 11, ?, ?)";

	private static final String UPDATE = "UPDATE PUBLIC.SEXES SET "
			+ "PERSON_PID = ?, SEX_TYPE_PID = ?, PRIMARY_SEX = ?, "
			+ "UPDATE_TSTMP = CURRENT_TIMESTAMP, "
			+ "FROM_DATE_PID = ?, TO_DATE_PID = ? WHERE SEXES_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SEXES WHERE SEXES_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SEXES";

	private List<Sexes> modelList;

	private PreparedStatement ps;

	private ResultSet rs;

	private Connection conn;

	private int SexesPid;
	private int PersonPid;
	private int SexTypePid;
	private boolean PrimarySex;
	private Timestamp InsertTstmp;
	private Timestamp UpdateTstmp;
	private int TableId;
	private int FromDatePid;
	private int ToDatePid;
	private Sexes model;

	public void delete() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(DELETEALL);
		ps.executeUpdate();
		conn.close();
	}

	public void delete(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(DELETE);
		ps.setInt(1, key);
		if (ps.executeUpdate() == 0) {
			conn.close();
			throw new MvpException("ID " + key + " not found");
		}
		conn.close();
	}

	public List<Sexes> get() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Sexes();
			model.setSexesPid(rs.getInt("SEXES_PID"));
			model.setPersonPid(rs.getInt("PERSON_PID"));
			model.setSexTypePid(rs.getInt("SEX_TYPE_PID"));
			model.setPrimarySex(rs.getBoolean("PRIMARY_SEX"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setFromDatePid(rs.getInt("FROM_DATE_PID"));
			model.setToDatePid(rs.getInt("TO_DATE_PID"));
			modelList.add(model);
		}
		conn.close();
		return modelList;
	}

	public void get(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		if (rs.next()) {
			setSexesPid(rs.getInt("SEXES_PID"));
			setPersonPid(rs.getInt("PERSON_PID"));
			setSexTypePid(rs.getInt("SEX_TYPE_PID"));
			setPrimarySex(rs.getBoolean("PRIMARY_SEX"));
			setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			setTableId(rs.getInt("TABLE_ID"));
			setFromDatePid(rs.getInt("FROM_DATE_PID"));
			setToDatePid(rs.getInt("TO_DATE_PID"));
		} else {
			throw new MvpException("ID " + key + " not found");
		}
		conn.close();
	}

	public List<Sexes> getFKPersonPid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_PERSON_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Sexes();
			model.setSexesPid(rs.getInt("SEXES_PID"));
			model.setPersonPid(rs.getInt("PERSON_PID"));
			model.setSexTypePid(rs.getInt("SEX_TYPE_PID"));
			model.setPrimarySex(rs.getBoolean("PRIMARY_SEX"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setFromDatePid(rs.getInt("FROM_DATE_PID"));
			model.setToDatePid(rs.getInt("TO_DATE_PID"));
			modelList.add(model);
		}
		conn.close();
		return modelList;
	}

	/**
	 * Get the FromDatePid field.
	 *
	 * @return Contents of the FROM_DATE_PID column
	 */
	public int getFromDatePid() {
		return FromDatePid;
	}

	/**
	 * Get the InsertTstmp field.
	 *
	 * @return Contents of the INSERT_TSTMP column
	 */
	public Timestamp getInsertTstmp() {
		return InsertTstmp;
	}

	/**
	 * Get the PersonPid field.
	 *
	 * @return Contents of the PERSON_PID column
	 */
	public int getPersonPid() {
		return PersonPid;
	}

	/**
	 * Get the SexesPid field.
	 *
	 * @return Contents of the SEXES_PID column
	 */
	public int getSexesPid() {
		return SexesPid;
	}

	/**
	 * Get the SexTypePid field.
	 *
	 * @return Contents of the SEX_TYPE_PID column
	 */
	public int getSexTypePid() {
		return SexTypePid;
	}

	/**
	 * Get the TableId field.
	 *
	 * @return Contents of the TABLE_ID column
	 */
	public int getTableId() {
		return TableId;
	}

	/**
	 * Get the ToDatePid field.
	 *
	 * @return Contents of the TO_DATE_PID column
	 */
	public int getToDatePid() {
		return ToDatePid;
	}

	/**
	 * Get the UpdateTstmp field.
	 *
	 * @return Contents of the UPDATE_TSTMP column
	 */
	public Timestamp getUpdateTstmp() {
		return UpdateTstmp;
	}

	public int insert() throws Exception {
		int maxPid = 0;
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTMAX);
		rs = ps.executeQuery();
		if (rs.next()) {
			maxPid = rs.getInt(1);
		}
		maxPid++;

		ps = conn.prepareStatement(INSERT);
		ps.setInt(1, maxPid);
		ps.setInt(2, getPersonPid());
		ps.setInt(3, getSexTypePid());
		ps.setBoolean(4, isPrimarySex());
		if (getFromDatePid() == 0) {
			ps.setNull(5, java.sql.Types.INTEGER);
		} else {
			ps.setInt(5, getFromDatePid());
		}
		if (getToDatePid() == 0) {
			ps.setNull(6, java.sql.Types.INTEGER);
		} else {
			ps.setInt(6, getToDatePid());
		}
		ps.executeUpdate();
		conn.close();
		return maxPid;
	}

	/**
	 * Get the PrimarySex field.
	 *
	 * @return Contents of the PRIMARY_SEX column
	 */
	public boolean isPrimarySex() {
		return PrimarySex;
	}

	/**
	 * Set the FromDatePid field
	 *
	 * @param FromDatePid Contents of the FROM_DATE_PID column
	 */
	public void setFromDatePid(int FromDatePid) {
		this.FromDatePid = FromDatePid;
	}

	/**
	 * Set the InsertTstmp field
	 *
	 * @param InsertTstmp Contents of the INSERT_TSTMP column
	 */
	public void setInsertTstmp(Timestamp InsertTstmp) {
		this.InsertTstmp = InsertTstmp;
	}

	/**
	 * Set the PersonPid field
	 *
	 * @param PersonPid Contents of the PERSON_PID column
	 */
	public void setPersonPid(int PersonPid) {
		this.PersonPid = PersonPid;
	}

	/**
	 * Set the PrimarySex field
	 *
	 * @param PrimarySex Contents of the PRIMARY_SEX column
	 */
	public void setPrimarySex(boolean PrimarySex) {
		this.PrimarySex = PrimarySex;
	}

	/**
	 * Set the SexesPid field
	 *
	 * @param SexesPid Contents of the SEXES_PID column
	 */
	public void setSexesPid(int SexesPid) {
		this.SexesPid = SexesPid;
	}

	/**
	 * Set the SexTypePid field
	 *
	 * @param SexTypePid Contents of the SEX_TYPE_PID column
	 */
	public void setSexTypePid(int SexTypePid) {
		this.SexTypePid = SexTypePid;
	}

	/**
	 * Set the TableId field
	 *
	 * @param TableId Contents of the TABLE_ID column
	 */
	public void setTableId(int TableId) {
		this.TableId = TableId;
	}

	/**
	 * Set the ToDatePid field
	 *
	 * @param ToDatePid Contents of the TO_DATE_PID column
	 */
	public void setToDatePid(int ToDatePid) {
		this.ToDatePid = ToDatePid;
	}

	/**
	 * Set the UpdateTstmp field
	 *
	 * @param UpdateTstmp Contents of the UPDATE_TSTMP column
	 */
	public void setUpdateTstmp(Timestamp UpdateTstmp) {
		this.UpdateTstmp = UpdateTstmp;
	}

	public void update() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(UPDATE);
		ps.setInt(1, getPersonPid());
		ps.setInt(2, getSexTypePid());
		ps.setBoolean(3, isPrimarySex());
		if (getFromDatePid() == 0) {
			ps.setNull(4, java.sql.Types.INTEGER);
		} else {
			ps.setInt(4, getFromDatePid());
		}
		if (getToDatePid() == 0) {
			ps.setNull(5, java.sql.Types.INTEGER);
		} else {
			ps.setInt(5, getToDatePid());
		}
		ps.setInt(6, getSexesPid());
		ps.executeUpdate();
		conn.close();
	}

}
