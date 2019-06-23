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
 * The persistent class for the PARENTS database table
 *
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2019
 * @version 09. jun. 2019
 *
 */

public class Parents {
	private List<Parents> modelList;
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conn;
	private static final String SELECT = "SELECT PARENT_PID, CHILD, "
			+ "PARENT, PRIMARY_PARENT, INSERT_TSTMP, "
			+ "UPDATE_TSTMP, TABLE_ID, PARENT_ROLE_PID, "
			+ "CHILD_ROLE_PID FROM PUBLIC.PARENTS WHERE PARENT_PID = ?";

	private static final String SELECT_CHILD = "SELECT PARENT_PID, "
			+ "CHILD, PARENT, PRIMARY_PARENT, INSERT_TSTMP, "
			+ "UPDATE_TSTMP, TABLE_ID, PARENT_ROLE_PID, "
			+ "CHILD_ROLE_PID FROM PUBLIC.PARENTS WHERE CHILD = ? ORDER BY PARENT_PID";

	private static final String SELECT_PARENT = "SELECT PARENT_PID, "
			+ "CHILD, PARENT, PRIMARY_PARENT, INSERT_TSTMP, "
			+ "UPDATE_TSTMP, TABLE_ID, PARENT_ROLE_PID, "
			+ "CHILD_ROLE_PID FROM PUBLIC.PARENTS WHERE PARENT = ? ORDER BY PARENT_PID";

	private static final String SELECT_PARENT_ROLE_PID = "SELECT "
			+ "PARENT_PID, CHILD, PARENT, PRIMARY_PARENT, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, PARENT_ROLE_PID, "
			+ "CHILD_ROLE_PID FROM PUBLIC.PARENTS WHERE PARENT_ROLE_PID = ? ORDER BY PARENT_PID";

	private static final String SELECTALL = "SELECT PARENT_PID, "
			+ "CHILD, PARENT, PRIMARY_PARENT, INSERT_TSTMP, "
			+ "UPDATE_TSTMP, TABLE_ID, PARENT_ROLE_PID, "
			+ "CHILD_ROLE_PID FROM PUBLIC.PARENTS ORDER BY PARENT_PID";

	private static final String SELECTMAX = "SELECT MAX(PARENT_PID) FROM PUBLIC.PARENTS";

	private static final String INSERT = "INSERT INTO PUBLIC.PARENTS( "
			+ "PARENT_PID, CHILD, PARENT, PRIMARY_PARENT, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, "
			+ "PARENT_ROLE_PID, CHILD_ROLE_PID) VALUES (?, ?, "
			+ "?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 22, ?, ?)";

	private static final String UPDATE = "UPDATE PUBLIC.PARENTS SET "
			+ "CHILD = ?, PARENT = ?, PRIMARY_PARENT = ?"
			+ ", INSERT_TSTMP = ?, UPDATE_TSTMP = CURRENT_TIMESTAMP"
			+ ", TABLE_ID = ?, PARENT_ROLE_PID = ?"
			+ ", CHILD_ROLE_PID = ? WHERE PARENT_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.PARENTS WHERE PARENT_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.PARENTS";

	private int ParentPid;
	private int Child;
	private int Parent;
	private boolean PrimaryParent;
	private Timestamp InsertTstmp;
	private Timestamp UpdateTstmp;
	private int TableId;
	private int ParentRolePid;
	private int ChildRolePid;
	private Parents model;

	public void delete() throws SQLException {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(DELETEALL);
		ps.executeUpdate();
		conn.close();
	}

	public void delete(int key) throws SQLException, MvpException {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(DELETE);
		ps.setInt(1, key);
		if (ps.executeUpdate() == 0) {
			conn.close();
			throw new MvpException("ID " + key + " not found");
		}
		conn.close();
	}

	public List<Parents> get() throws SQLException {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Parents();
			model.setParentPid(rs.getInt("PARENT_PID"));
			model.setChild(rs.getInt("CHILD"));
			model.setParent(rs.getInt("PARENT"));
			model.setPrimaryParent(rs.getBoolean("PRIMARY_PARENT"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setParentRolePid(rs.getInt("PARENT_ROLE_PID"));
			model.setChildRolePid(rs.getInt("CHILD_ROLE_PID"));
			modelList.add(model);
		}
		conn.close();
		return modelList;
	}

	public void get(int key) throws SQLException, MvpException {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		if (rs.next()) {
			setParentPid(rs.getInt("PARENT_PID"));
			setChild(rs.getInt("CHILD"));
			setParent(rs.getInt("PARENT"));
			setPrimaryParent(rs.getBoolean("PRIMARY_PARENT"));
			setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			setTableId(rs.getInt("TABLE_ID"));
			setParentRolePid(rs.getInt("PARENT_ROLE_PID"));
			setChildRolePid(rs.getInt("CHILD_ROLE_PID"));
		} else {
			throw new MvpException("ID " + key + " not found");
		}
		conn.close();
	}

	public List<Parents> getFKChild(int key) throws SQLException {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_CHILD);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Parents();
			model.setParentPid(rs.getInt("PARENT_PID"));
			model.setChild(rs.getInt("CHILD"));
			model.setParent(rs.getInt("PARENT"));
			model.setPrimaryParent(rs.getBoolean("PRIMARY_PARENT"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setParentRolePid(rs.getInt("PARENT_ROLE_PID"));
			model.setChildRolePid(rs.getInt("CHILD_ROLE_PID"));
			modelList.add(model);
		}
		conn.close();
		return modelList;
	}

	public List<Parents> getFKParent(int key) throws SQLException {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_PARENT);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Parents();
			model.setParentPid(rs.getInt("PARENT_PID"));
			model.setChild(rs.getInt("CHILD"));
			model.setParent(rs.getInt("PARENT"));
			model.setPrimaryParent(rs.getBoolean("PRIMARY_PARENT"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setParentRolePid(rs.getInt("PARENT_ROLE_PID"));
			model.setChildRolePid(rs.getInt("CHILD_ROLE_PID"));
			modelList.add(model);
		}
		conn.close();
		return modelList;
	}

	public List<Parents> getFKParentRolePid(int key) throws SQLException {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_PARENT_ROLE_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Parents();
			model.setParentPid(rs.getInt("PARENT_PID"));
			model.setChild(rs.getInt("CHILD"));
			model.setParent(rs.getInt("PARENT"));
			model.setPrimaryParent(rs.getBoolean("PRIMARY_PARENT"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setParentRolePid(rs.getInt("PARENT_ROLE_PID"));
			model.setChildRolePid(rs.getInt("CHILD_ROLE_PID"));
			modelList.add(model);
		}
		conn.close();
		return modelList;
	}

	public int insert() throws SQLException {
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
		ps.setInt(2, getChild());
		ps.setInt(3, getParent());
		ps.setBoolean(4, isPrimaryParent());
		ps.setInt(5, getParentRolePid());
		ps.setInt(6, getChildRolePid());
		ps.executeUpdate();
		conn.close();
		return maxPid;
	}

	public void update() throws SQLException {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(UPDATE);
		ps.setInt(1, getChild());
		ps.setInt(2, getParent());
		ps.setBoolean(3, isPrimaryParent());
		ps.setInt(4, getParentRolePid());
		ps.setInt(5, getChildRolePid());
		ps.setInt(6, getParentPid());
		ps.executeUpdate();
		conn.close();
	}

	/**
	 * Get the ParentPid field.
	 *
	 * @return Contents of the PARENT_PID column
	 */
	public int getParentPid() {
		return this.ParentPid;
	}

	/**
	 * Get the Child field.
	 *
	 * @return Contents of the CHILD column
	 */
	public int getChild() {
		return this.Child;
	}

	/**
	 * Get the Parent field.
	 *
	 * @return Contents of the PARENT column
	 */
	public int getParent() {
		return this.Parent;
	}

	/**
	 * Get the PrimaryParent field.
	 *
	 * @return Contents of the PRIMARY_PARENT column
	 */
	public boolean isPrimaryParent() {
		return this.PrimaryParent;
	}

	/**
	 * Get the InsertTstmp field.
	 *
	 * @return Contents of the INSERT_TSTMP column
	 */
	public Timestamp getInsertTstmp() {
		return this.InsertTstmp;
	}

	/**
	 * Get the UpdateTstmp field.
	 *
	 * @return Contents of the UPDATE_TSTMP column
	 */
	public Timestamp getUpdateTstmp() {
		return this.UpdateTstmp;
	}

	/**
	 * Get the TableId field.
	 *
	 * @return Contents of the TABLE_ID column
	 */
	public int getTableId() {
		return this.TableId;
	}

	/**
	 * Get the ParentRolePid field.
	 *
	 * @return Contents of the PARENT_ROLE_PID column
	 */
	public int getParentRolePid() {
		return this.ParentRolePid;
	}

	/**
	 * Get the ChildRolePid field.
	 *
	 * @return Contents of the CHILD_ROLE_PID column
	 */
	public int getChildRolePid() {
		return this.ChildRolePid;
	}

	/**
	 * Set the ParentPid field
	 *
	 * @param ParentPid Contents of the PARENT_PID column
	 */
	public void setParentPid(int ParentPid) {
		this.ParentPid = ParentPid;
	}

	/**
	 * Set the Child field
	 *
	 * @param Child Contents of the CHILD column
	 */
	public void setChild(int Child) {
		this.Child = Child;
	}

	/**
	 * Set the Parent field
	 *
	 * @param Parent Contents of the PARENT column
	 */
	public void setParent(int Parent) {
		this.Parent = Parent;
	}

	/**
	 * Set the PrimaryParent field
	 *
	 * @param PrimaryParent Contents of the PRIMARY_PARENT column
	 */
	public void setPrimaryParent(boolean PrimaryParent) {
		this.PrimaryParent = PrimaryParent;
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
	 * Set the UpdateTstmp field
	 *
	 * @param UpdateTstmp Contents of the UPDATE_TSTMP column
	 */
	public void setUpdateTstmp(Timestamp UpdateTstmp) {
		this.UpdateTstmp = UpdateTstmp;
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
	 * Set the ParentRolePid field
	 *
	 * @param ParentRolePid Contents of the PARENT_ROLE_PID column
	 */
	public void setParentRolePid(int ParentRolePid) {
		this.ParentRolePid = ParentRolePid;
	}

	/**
	 * Set the ChildRolePid field
	 *
	 * @param ChildRolePid Contents of the CHILD_ROLE_PID column
	 */
	public void setChildRolePid(int ChildRolePid) {
		this.ChildRolePid = ChildRolePid;
	}

}
