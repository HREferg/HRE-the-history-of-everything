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
 * The persistent class for the PARENT_ROLES database table
 *
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2019
 * @version 28. mar. 2019
 *
 */

public class ParentRoles {
	private static final String SELECT = "SELECT PARENT_ROLE_PID, "
			+ "ABBREVIATION, LABEL_PID, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID FROM PUBLIC.PARENT_ROLES WHERE PARENT_ROLE_PID = ?";
	private static final String SELECTALL = "SELECT PARENT_ROLE_PID, "
			+ "ABBREVIATION, LABEL_PID, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID FROM PUBLIC.PARENT_ROLES ORDER BY PARENT_ROLE_PID";
	private static final String SELECTMAX = "SELECT MAX(PARENT_ROLE_PID) FROM PUBLIC.PARENT_ROLES";
	private static final String INSERT = "INSERT INTO PUBLIC.PARENT_ROLES( "
			+ "PARENT_ROLE_PID, ABBREVIATION, LABEL_PID, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID) VALUES (?, "
			+ "?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 27) ";
	private static final String UPDATE = "UPDATE PUBLIC.PARENT_ROLES SET "
			+ "ABBREVIATION = ?, LABEL_PID = ?"
			+ ", UPDATE_TSTMP = CURRENT_TIMESTAMP"
			+ " WHERE PARENT_ROLE_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.PARENT_ROLES WHERE PARENT_ROLE_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.PARENT_ROLES";

	private List<ParentRoles> modelList;

	private PreparedStatement ps;

	private ResultSet rs;

	private Connection conn;

	private int ParentRolePid;
	private String Abbreviation;
	private int LabelPid;
	private Timestamp InsertTstmp;
	private Timestamp UpdateTstmp;
	private int TableId;
	private ParentRoles model;

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

	public List<ParentRoles> get() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new ParentRoles();
			model.setParentRolePid(rs.getInt("PARENT_ROLE_PID"));
			model.setAbbreviation(rs.getString("ABBREVIATION"));
			model.setLabelPid(rs.getInt("LABEL_PID"));
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
			setParentRolePid(rs.getInt("PARENT_ROLE_PID"));
			setAbbreviation(rs.getString("ABBREVIATION"));
			setLabelPid(rs.getInt("LABEL_PID"));
			setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			setTableId(rs.getInt("TABLE_ID"));
		} else {
			throw new MvpException("ID " + key + " not found");
		}
		conn.close();
	}

	/**
	 * Get the Abbreviation field.
	 *
	 * @return Contents of the ABBREVIATION column
	 */
	public String getAbbreviation() {
		return Abbreviation;
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
	 * Get the LabelPid field.
	 *
	 * @return Contents of the LABEL_PID column
	 */
	public int getLabelPid() {
		return LabelPid;
	}

	/**
	 * Get the ParentRolePid field.
	 *
	 * @return Contents of the PARENT_ROLE_PID column
	 */
	public int getParentRolePid() {
		return ParentRolePid;
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
		ps.setString(2, getAbbreviation());
		ps.setInt(3, getLabelPid());
		ps.executeUpdate();
		conn.close();
		return maxPid;
	}

	/**
	 * Set the Abbreviation field
	 *
	 * @param Abbreviation Contents of the ABBREVIATION column
	 */
	public void setAbbreviation(String Abbreviation) {
		this.Abbreviation = Abbreviation;
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
	 * Set the LabelPid field
	 *
	 * @param LabelPid Contents of the LABEL_PID column
	 */
	public void setLabelPid(int LabelPid) {
		this.LabelPid = LabelPid;
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
		ps.setString(1, getAbbreviation());
		ps.setInt(2, getLabelPid());
		ps.setInt(3, getParentRolePid());
		ps.executeUpdate();
		conn.close();
	}

}
