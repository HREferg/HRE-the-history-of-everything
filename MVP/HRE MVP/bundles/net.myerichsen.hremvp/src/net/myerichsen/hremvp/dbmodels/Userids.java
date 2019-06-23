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
 * The persistent class for the USERIDS database table
 *
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2019
 * @version 24. feb. 2019
 *
 */

public class Userids {
	private static final String SELECT = "SELECT USERID_PID, "
			+ "PERSON_PID, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID FROM PUBLIC.USERIDS WHERE USERID_PID = ?";
	private static final String SELECT_PERSON_PID = "SELECT USERID_PID, "
			+ "PERSON_PID, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID FROM PUBLIC.USERIDS WHERE PERSON_PID = ? ORDER BY USERID_PID";
	private static final String SELECTALL = "SELECT USERID_PID, "
			+ "PERSON_PID, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID FROM PUBLIC.USERIDS ORDER BY USERID_PID";
	private static final String SELECTMAX = "SELECT MAX(USERID_PID) FROM PUBLIC.USERIDS";
	private static final String INSERT = "INSERT INTO PUBLIC.USERIDS( "
			+ "USERID_PID, PERSON_PID, INSERT_TSTMP, "
			+ "UPDATE_TSTMP, TABLE_ID) VALUES (?, ?, ?, ?, ?)";

	private static final String UPDATE = "UPDATE PUBLIC.USERIDS SET "
			+ "PERSON_PID = ?, INSERT_TSTMP = ?, UPDATE_TSTMP = ?, "
			+ "TABLE_ID = ? WHERE USERID_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.USERIDS WHERE USERID_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.USERIDS";

	private List<Userids> modelList;

	private PreparedStatement ps;

	private ResultSet rs;

	private Connection conn;

	private int UseridPid;
	private int PersonPid;
	private Timestamp InsertTstmp;
	private Timestamp UpdateTstmp;
	private int TableId;
	private Userids model;

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

	public List<Userids> get() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Userids();
			model.setUseridPid(rs.getInt("USERID_PID"));
			model.setPersonPid(rs.getInt("PERSON_PID"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
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
			setUseridPid(rs.getInt("USERID_PID"));
			setPersonPid(rs.getInt("PERSON_PID"));
			setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			setTableId(rs.getInt("TABLE_ID"));
		} else {
			throw new MvpException("ID " + key + " not found");
		}
		conn.close();
	}

	public List<Userids> getFKPersonPid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_PERSON_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Userids();
			model.setUseridPid(rs.getInt("USERID_PID"));
			model.setPersonPid(rs.getInt("PERSON_PID"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
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

	/**
	 * Get the UseridPid field.
	 *
	 * @return Contents of the USERID_PID column
	 */
	public int getUseridPid() {
		return UseridPid;
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
		ps.setTimestamp(3, getInsertTstmp());
		ps.setTimestamp(4, getUpdateTstmp());
		ps.setInt(5, getTableId());
		ps.executeUpdate();
		conn.close();
		return maxPid;
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

	/**
	 * Set the UseridPid field
	 *
	 * @param UseridPid Contents of the USERID_PID column
	 */
	public void setUseridPid(int UseridPid) {
		this.UseridPid = UseridPid;
	}

	public void update() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(UPDATE);
		ps.setInt(1, getPersonPid());
		ps.setTimestamp(2, getInsertTstmp());
		ps.setTimestamp(3, getUpdateTstmp());
		ps.setInt(4, getTableId());
		ps.setInt(5, getUseridPid());
		ps.executeUpdate();
		conn.close();
	}

}
