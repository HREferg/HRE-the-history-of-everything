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
 * The persistent class for the PERSON_NAMES database table
 *
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2019
 * @version 3. mar. 2019
 *
 */

public class PersonNames {
	private static final String SELECT = "SELECT NAME_PID, "
			+ "PERSON_PID, PRIMARY_NAME, NAME_STYLE_PID, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.PERSON_NAMES WHERE NAME_PID = ?";
	private static final String SELECT_PERSON_PID = "SELECT NAME_PID, "
			+ "PERSON_PID, PRIMARY_NAME, NAME_STYLE_PID, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.PERSON_NAMES WHERE PERSON_PID = ? ORDER BY NAME_PID";
	private static final String SELECT_NAME_STYLE_PID = "SELECT NAME_PID, "
			+ "PERSON_PID, PRIMARY_NAME, NAME_STYLE_PID, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.PERSON_NAMES WHERE NAME_STYLE_PID = ? ORDER BY NAME_PID";
	private static final String SELECT_FROM_DATE_PID = "SELECT NAME_PID, "
			+ "PERSON_PID, PRIMARY_NAME, NAME_STYLE_PID, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.PERSON_NAMES WHERE FROM_DATE_PID = ? ORDER BY NAME_PID";
	private static final String SELECT_TO_DATE_PID = "SELECT NAME_PID, "
			+ "PERSON_PID, PRIMARY_NAME, NAME_STYLE_PID, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.PERSON_NAMES WHERE TO_DATE_PID = ? ORDER BY NAME_PID";

	private static final String SELECTALL = "SELECT NAME_PID, "
			+ "PERSON_PID, PRIMARY_NAME, NAME_STYLE_PID, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.PERSON_NAMES ORDER BY NAME_PID";

	private static final String SELECTMAX = "SELECT MAX(NAME_PID) FROM PUBLIC.PERSON_NAMES";

	private static final String INSERT = "INSERT INTO PUBLIC.PERSON_NAMES( "
			+ "NAME_PID, PERSON_PID, PRIMARY_NAME, "
			+ "NAME_STYLE_PID, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID, FROM_DATE_PID, TO_DATE_PID) VALUES (?, "
			+ "?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 10, ?, ?)";

	private static final String UPDATE = "UPDATE PUBLIC.PERSON_NAMES SET "
			+ "PERSON_PID = ?, PRIMARY_NAME = ?, NAME_STYLE_PID = ?, "
			+ "UPDATE_TSTMP = CURRENT_TIMESTAMP, "
			+ "FROM_DATE_PID = ?, TO_DATE_PID = ? WHERE NAME_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.PERSON_NAMES WHERE NAME_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.PERSON_NAMES";

	private List<PersonNames> modelList;

	private PreparedStatement ps;

	private ResultSet rs;

	private Connection conn;

	private int NamePid;
	private int PersonPid;
	private boolean PrimaryName;
	private int NameStylePid;
	private Timestamp InsertTstmp;
	private Timestamp UpdateTstmp;
	private int TableId;
	private int FromDatePid;
	private int ToDatePid;
	private PersonNames model;

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

	public List<PersonNames> get() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new PersonNames();
			model.setNamePid(rs.getInt("NAME_PID"));
			model.setPersonPid(rs.getInt("PERSON_PID"));
			model.setPrimaryName(rs.getBoolean("PRIMARY_NAME"));
			model.setNameStylePid(rs.getInt("NAME_STYLE_PID"));
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
			setNamePid(rs.getInt("NAME_PID"));
			setPersonPid(rs.getInt("PERSON_PID"));
			setPrimaryName(rs.getBoolean("PRIMARY_NAME"));
			setNameStylePid(rs.getInt("NAME_STYLE_PID"));
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

	public List<PersonNames> getFKFromDatePid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_FROM_DATE_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new PersonNames();
			model.setNamePid(rs.getInt("NAME_PID"));
			model.setPersonPid(rs.getInt("PERSON_PID"));
			model.setPrimaryName(rs.getBoolean("PRIMARY_NAME"));
			model.setNameStylePid(rs.getInt("NAME_STYLE_PID"));
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

	public List<PersonNames> getFKNameStylePid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_NAME_STYLE_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new PersonNames();
			model.setNamePid(rs.getInt("NAME_PID"));
			model.setPersonPid(rs.getInt("PERSON_PID"));
			model.setPrimaryName(rs.getBoolean("PRIMARY_NAME"));
			model.setNameStylePid(rs.getInt("NAME_STYLE_PID"));
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

	public List<PersonNames> getFKPersonPid(int key) throws SQLException {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_PERSON_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new PersonNames();
			model.setNamePid(rs.getInt("NAME_PID"));
			model.setPersonPid(rs.getInt("PERSON_PID"));
			model.setPrimaryName(rs.getBoolean("PRIMARY_NAME"));
			model.setNameStylePid(rs.getInt("NAME_STYLE_PID"));
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

	public List<PersonNames> getFKToDatePid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_TO_DATE_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new PersonNames();
			model.setNamePid(rs.getInt("NAME_PID"));
			model.setPersonPid(rs.getInt("PERSON_PID"));
			model.setPrimaryName(rs.getBoolean("PRIMARY_NAME"));
			model.setNameStylePid(rs.getInt("NAME_STYLE_PID"));
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
	 * Get the NamePid field.
	 *
	 * @return Contents of the NAME_PID column
	 */
	public int getNamePid() {
		return NamePid;
	}

	/**
	 * Get the NameStylePid field.
	 *
	 * @return Contents of the NAME_STYLE_PID column
	 */
	public int getNameStylePid() {
		return NameStylePid;
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
		ps.setBoolean(3, isPrimaryName());
		ps.setInt(4, getNameStylePid());
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
	 * Get the PrimaryName field.
	 *
	 * @return Contents of the PRIMARY_NAME column
	 */
	public boolean isPrimaryName() {
		return PrimaryName;
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
	 * Set the NamePid field
	 *
	 * @param NamePid Contents of the NAME_PID column
	 */
	public void setNamePid(int NamePid) {
		this.NamePid = NamePid;
	}

	/**
	 * Set the NameStylePid field
	 *
	 * @param NameStylePid Contents of the NAME_STYLE_PID column
	 */
	public void setNameStylePid(int NameStylePid) {
		this.NameStylePid = NameStylePid;
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
	 * Set the PrimaryName field
	 *
	 * @param PrimaryName Contents of the PRIMARY_NAME column
	 */
	public void setPrimaryName(boolean PrimaryName) {
		this.PrimaryName = PrimaryName;
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
		ps.setBoolean(2, isPrimaryName());
		ps.setInt(3, getNameStylePid());
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
		ps.setInt(6, getNamePid());
		ps.executeUpdate();
		conn.close();
	}

}
