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
 * The persistent class for the LOCATION_NAMES database table
 *
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2019
 * @version 10. mar. 2019
 *
 */

public class LocationNames {
	private static final String SELECT = "SELECT LOCATION_NAME_PID, "
			+ "LOCATION_PID, PRIMARY_LOCATION_NAME, "
			+ "LOCATION_NAME_STYLE_PID, PREPOSITION, INSERT_TSTMP, "
			+ "UPDATE_TSTMP, TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.LOCATION_NAMES WHERE LOCATION_NAME_PID = ?";
	private static final String SELECT_LOCATION_PID = "SELECT "
			+ "LOCATION_NAME_PID, LOCATION_PID, "
			+ "PRIMARY_LOCATION_NAME, LOCATION_NAME_STYLE_PID, "
			+ "PREPOSITION, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.LOCATION_NAMES WHERE LOCATION_PID = ? ORDER BY LOCATION_NAME_PID";
	private static final String SELECT_LOCATION_NAME_STYLE_PID = "SELECT "
			+ "LOCATION_NAME_PID, LOCATION_PID, "
			+ "PRIMARY_LOCATION_NAME, LOCATION_NAME_STYLE_PID, "
			+ "PREPOSITION, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.LOCATION_NAMES WHERE LOCATION_NAME_STYLE_PID = ? ORDER BY LOCATION_NAME_PID";
	private static final String SELECT_FROM_DATE_PID = "SELECT "
			+ "LOCATION_NAME_PID, LOCATION_PID, "
			+ "PRIMARY_LOCATION_NAME, LOCATION_NAME_STYLE_PID, "
			+ "PREPOSITION, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.LOCATION_NAMES WHERE FROM_DATE_PID = ? ORDER BY LOCATION_NAME_PID";
	private static final String SELECT_TO_DATE_PID = "SELECT "
			+ "LOCATION_NAME_PID, LOCATION_PID, "
			+ "PRIMARY_LOCATION_NAME, LOCATION_NAME_STYLE_PID, "
			+ "PREPOSITION, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.LOCATION_NAMES WHERE TO_DATE_PID = ? ORDER BY LOCATION_NAME_PID";

	private static final String SELECTALL = "SELECT LOCATION_NAME_PID, "
			+ "LOCATION_PID, PRIMARY_LOCATION_NAME, "
			+ "LOCATION_NAME_STYLE_PID, PREPOSITION, INSERT_TSTMP, "
			+ "UPDATE_TSTMP, TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.LOCATION_NAMES ORDER BY LOCATION_NAME_PID";

	private static final String SELECTMAX = "SELECT MAX(LOCATION_NAME_PID) FROM PUBLIC.LOCATION_NAMES";

	private static final String INSERT = "INSERT INTO PUBLIC.LOCATION_NAMES( "
			+ "LOCATION_NAME_PID, LOCATION_PID, "
			+ "PRIMARY_LOCATION_NAME, LOCATION_NAME_STYLE_PID, "
			+ "PREPOSITION, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID, FROM_DATE_PID, TO_DATE_PID) VALUES (?, "
			+ "?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 8, ?, ?)";

	private static final String UPDATE = "UPDATE PUBLIC.LOCATION_NAMES SET "
			+ "LOCATION_PID = ?, PRIMARY_LOCATION_NAME = ?"
			+ ", LOCATION_NAME_STYLE_PID = ?, PREPOSITION = ?"
			+ ", UPDATE_TSTMP = CURRENT_TIMESTAMP, FROM_DATE_PID = ?"
			+ ", TO_DATE_PID = ? WHERE LOCATION_NAME_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.LOCATION_NAMES WHERE LOCATION_NAME_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.LOCATION_NAMES";

	private List<LocationNames> modelList;

	private PreparedStatement ps;

	private ResultSet rs;

	private Connection conn;

	private int LocationNamePid;
	private int LocationPid;
	private boolean PrimaryLocationName;
	private int LocationNameStylePid;
	private String Preposition;
	private Timestamp InsertTstmp;
	private Timestamp UpdateTstmp;
	private int TableId;
	private int FromDatePid;
	private int ToDatePid;
	private LocationNames model;

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

	public List<LocationNames> get() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new LocationNames();
			model.setLocationNamePid(rs.getInt("LOCATION_NAME_PID"));
			model.setLocationPid(rs.getInt("LOCATION_PID"));
			model.setPrimaryLocationName(
					rs.getBoolean("PRIMARY_LOCATION_NAME"));
			model.setLocationNameStylePid(rs.getInt("LOCATION_NAME_STYLE_PID"));
			model.setPreposition(rs.getString("PREPOSITION"));
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
			setLocationNamePid(rs.getInt("LOCATION_NAME_PID"));
			setLocationPid(rs.getInt("LOCATION_PID"));
			setPrimaryLocationName(rs.getBoolean("PRIMARY_LOCATION_NAME"));
			setLocationNameStylePid(rs.getInt("LOCATION_NAME_STYLE_PID"));
			setPreposition(rs.getString("PREPOSITION"));
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

	public List<LocationNames> getFKFromDatePid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_FROM_DATE_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new LocationNames();
			model.setLocationNamePid(rs.getInt("LOCATION_NAME_PID"));
			model.setLocationPid(rs.getInt("LOCATION_PID"));
			model.setPrimaryLocationName(
					rs.getBoolean("PRIMARY_LOCATION_NAME"));
			model.setLocationNameStylePid(rs.getInt("LOCATION_NAME_STYLE_PID"));
			model.setPreposition(rs.getString("PREPOSITION"));
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

	public List<LocationNames> getFKLocationNameStylePid(int key)
			throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_LOCATION_NAME_STYLE_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new LocationNames();
			model.setLocationNamePid(rs.getInt("LOCATION_NAME_PID"));
			model.setLocationPid(rs.getInt("LOCATION_PID"));
			model.setPrimaryLocationName(
					rs.getBoolean("PRIMARY_LOCATION_NAME"));
			model.setLocationNameStylePid(rs.getInt("LOCATION_NAME_STYLE_PID"));
			model.setPreposition(rs.getString("PREPOSITION"));
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

	public List<LocationNames> getFKLocationPid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_LOCATION_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new LocationNames();
			model.setLocationNamePid(rs.getInt("LOCATION_NAME_PID"));
			model.setLocationPid(rs.getInt("LOCATION_PID"));
			model.setPrimaryLocationName(
					rs.getBoolean("PRIMARY_LOCATION_NAME"));
			model.setLocationNameStylePid(rs.getInt("LOCATION_NAME_STYLE_PID"));
			model.setPreposition(rs.getString("PREPOSITION"));
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

	public List<LocationNames> getFKToDatePid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_TO_DATE_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new LocationNames();
			model.setLocationNamePid(rs.getInt("LOCATION_NAME_PID"));
			model.setLocationPid(rs.getInt("LOCATION_PID"));
			model.setPrimaryLocationName(
					rs.getBoolean("PRIMARY_LOCATION_NAME"));
			model.setLocationNameStylePid(rs.getInt("LOCATION_NAME_STYLE_PID"));
			model.setPreposition(rs.getString("PREPOSITION"));
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
	 * Get the LocationNamePid field.
	 *
	 * @return Contents of the LOCATION_NAME_PID column
	 */
	public int getLocationNamePid() {
		return LocationNamePid;
	}

	/**
	 * Get the LocationNameStylePid field.
	 *
	 * @return Contents of the LOCATION_NAME_STYLE_PID column
	 */
	public int getLocationNameStylePid() {
		return LocationNameStylePid;
	}

	/**
	 * Get the LocationPid field.
	 *
	 * @return Contents of the LOCATION_PID column
	 */
	public int getLocationPid() {
		return LocationPid;
	}

	/**
	 * Get the Preposition field.
	 *
	 * @return Contents of the PREPOSITION column
	 */
	public String getPreposition() {
		return Preposition;
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
		ps.setInt(2, getLocationPid());
		ps.setBoolean(3, isPrimaryLocationName());
		ps.setInt(4, getLocationNameStylePid());
		ps.setString(5, getPreposition());
		if (getFromDatePid() == 0) {
			ps.setNull(6, java.sql.Types.INTEGER);
		} else {
			ps.setInt(6, getFromDatePid());
		}
		if (getToDatePid() == 0) {
			ps.setNull(7, java.sql.Types.INTEGER);
		} else {
			ps.setInt(7, getToDatePid());
		}
		ps.executeUpdate();
		conn.close();
		return maxPid;
	}

	/**
	 * Get the PrimaryLocationName field.
	 *
	 * @return Contents of the PRIMARY_LOCATION_NAME column
	 */
	public boolean isPrimaryLocationName() {
		return PrimaryLocationName;
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
	 * Set the LocationNamePid field
	 *
	 * @param LocationNamePid Contents of the LOCATION_NAME_PID column
	 */
	public void setLocationNamePid(int LocationNamePid) {
		this.LocationNamePid = LocationNamePid;
	}

	/**
	 * Set the LocationNameStylePid field
	 *
	 * @param LocationNameStylePid Contents of the LOCATION_NAME_STYLE_PID
	 *                             column
	 */
	public void setLocationNameStylePid(int LocationNameStylePid) {
		this.LocationNameStylePid = LocationNameStylePid;
	}

	/**
	 * Set the LocationPid field
	 *
	 * @param LocationPid Contents of the LOCATION_PID column
	 */
	public void setLocationPid(int LocationPid) {
		this.LocationPid = LocationPid;
	}

	/**
	 * Set the Preposition field
	 *
	 * @param Preposition Contents of the PREPOSITION column
	 */
	public void setPreposition(String Preposition) {
		this.Preposition = Preposition;
	}

	/**
	 * Set the PrimaryLocationName field
	 *
	 * @param PrimaryLocationName Contents of the PRIMARY_LOCATION_NAME column
	 */
	public void setPrimaryLocationName(boolean PrimaryLocationName) {
		this.PrimaryLocationName = PrimaryLocationName;
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
		ps.setInt(1, getLocationPid());
		ps.setBoolean(2, isPrimaryLocationName());
		ps.setInt(3, getLocationNameStylePid());
		ps.setString(4, getPreposition());
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
		ps.setInt(7, getLocationNamePid());
		ps.executeUpdate();
		conn.close();
	}

}
