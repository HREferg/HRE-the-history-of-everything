package net.myerichsen.hremvp.dbmodels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import net.myerichsen.hremvp.HreH2ConnectionPool;
import net.myerichsen.hremvp.MvpException;

/**
 * The persistent class for the PERSONS database table
 *
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2019
 * @version 3. mar. 2019
 *
 */

public class Persons {
	private static final String SELECT = "SELECT PERSON_PID, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, BIRTH_DATE_PID, "
			+ "DEATH_DATE_PID FROM PUBLIC.PERSONS WHERE PERSON_PID = ?";
	private static final String SELECT_BIRTH_DATE_PID = "SELECT "
			+ "PERSON_PID, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID, BIRTH_DATE_PID, "
			+ "DEATH_DATE_PID FROM PUBLIC.PERSONS WHERE BIRTH_DATE_PID = ? ORDER BY PERSON_PID";
	private static final String SELECT_DEATH_DATE_PID = "SELECT "
			+ "PERSON_PID, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID, BIRTH_DATE_PID, "
			+ "DEATH_DATE_PID FROM PUBLIC.PERSONS WHERE DEATH_DATE_PID = ? ORDER BY PERSON_PID";
	private static final String SELECTALL = "SELECT PERSON_PID, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, BIRTH_DATE_PID, "
			+ "DEATH_DATE_PID FROM PUBLIC.PERSONS ORDER BY PERSON_PID";
	private static final String SELECTMAX = "SELECT MAX(PERSON_PID) FROM PUBLIC.PERSONS";

	private static final String INSERT = "INSERT INTO PUBLIC.PERSONS( "
			+ "PERSON_PID, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID, BIRTH_DATE_PID, DEATH_DATE_PID) VALUES ("
			+ "?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 15, ?, ?)";

	private static final String UPDATE = "UPDATE PUBLIC.PERSONS SET "
			+ "UPDATE_TSTMP = CURRENT_TIMESTAMP, BIRTH_DATE_PID = ?, "
			+ "DEATH_DATE_PID = ? WHERE PERSON_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.PERSONS WHERE PERSON_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.PERSONS";

	private List<Persons> modelList;

	private PreparedStatement ps;

	private ResultSet rs;

	private Connection conn;

	private int PersonPid;
	private Timestamp InsertTstmp;
	private Timestamp UpdateTstmp;
	private int TableId;
	private int BirthDatePid;
	private int DeathDatePid;
	private Persons model;

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

	public List<Persons> get() throws SQLException {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Persons();
			model.setPersonPid(rs.getInt("PERSON_PID"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setBirthDatePid(rs.getInt("BIRTH_DATE_PID"));
			model.setDeathDatePid(rs.getInt("DEATH_DATE_PID"));
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
			setPersonPid(rs.getInt("PERSON_PID"));
			setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			setTableId(rs.getInt("TABLE_ID"));
			setBirthDatePid(rs.getInt("BIRTH_DATE_PID"));
			setDeathDatePid(rs.getInt("DEATH_DATE_PID"));
		} else {
			throw new MvpException("ID " + key + " not found");
		}
		conn.close();
	}

	/**
	 * Get the BirthDatePid field.
	 *
	 * @return Contents of the BIRTH_DATE_PID column
	 */
	public int getBirthDatePid() {
		return BirthDatePid;
	}

	/**
	 * Get the DeathDatePid field.
	 *
	 * @return Contents of the DEATH_DATE_PID column
	 */
	public int getDeathDatePid() {
		return DeathDatePid;
	}

	public List<Persons> getFKBirthDatePid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_BIRTH_DATE_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Persons();
			model.setPersonPid(rs.getInt("PERSON_PID"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setBirthDatePid(rs.getInt("BIRTH_DATE_PID"));
			model.setDeathDatePid(rs.getInt("DEATH_DATE_PID"));
			modelList.add(model);
		}
		conn.close();
		return modelList;
	}

	public List<Persons> getFKDeathDatePid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_DEATH_DATE_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Persons();
			model.setPersonPid(rs.getInt("PERSON_PID"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setBirthDatePid(rs.getInt("BIRTH_DATE_PID"));
			model.setDeathDatePid(rs.getInt("DEATH_DATE_PID"));
			modelList.add(model);
		}
		conn.close();
		return modelList;
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
	 * Get the TableId field.
	 *
	 * @return Contents of the TABLE_ID column
	 */
	public int getTableId() {
		return TableId;
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
		if (getBirthDatePid() == 0) {
			ps.setNull(2, java.sql.Types.INTEGER);
		} else {
			ps.setInt(2, getBirthDatePid());
		}
		if (getDeathDatePid() == 0) {
			ps.setNull(3, java.sql.Types.INTEGER);
		} else {
			ps.setInt(3, getDeathDatePid());
		}
		ps.executeUpdate();
		conn.close();
		return maxPid;
	}

	/**
	 * Set the BirthDatePid field
	 *
	 * @param BirthDatePid Contents of the BIRTH_DATE_PID column
	 */
	public void setBirthDatePid(int BirthDatePid) {
		this.BirthDatePid = BirthDatePid;
	}

	/**
	 * Set the DeathDatePid field
	 *
	 * @param DeathDatePid Contents of the DEATH_DATE_PID column
	 */
	public void setDeathDatePid(int DeathDatePid) {
		this.DeathDatePid = DeathDatePid;
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
	 * Set the TableId field
	 *
	 * @param TableId Contents of the TABLE_ID column
	 */
	public void setTableId(int TableId) {
		this.TableId = TableId;
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
		if (getBirthDatePid() == 0) {
			ps.setNull(1, java.sql.Types.INTEGER);
		} else {
			ps.setInt(1, getBirthDatePid());
		}
		if (getDeathDatePid() == 0) {
			ps.setNull(2, java.sql.Types.INTEGER);
		} else {
			ps.setInt(2, getDeathDatePid());
		}
		ps.setInt(3, getPersonPid());
		ps.executeUpdate();
		conn.close();
	}

}
