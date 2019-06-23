package net.myerichsen.hremvp.dbmodels;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import net.myerichsen.hremvp.HreH2ConnectionPool;
import net.myerichsen.hremvp.MvpException;

/**
 * The persistent class for the LOCATIONS database table
 *
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2019
 * @version 10. mar. 2019
 *
 */

public class Locations {
	private static final String SELECT = "SELECT LOCATION_PID, "
			+ "PRIMARY_LOCATION, X_COORDINATE, Y_COORDINATE, "
			+ "Z_COORDINATE, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.LOCATIONS WHERE LOCATION_PID = ?";
	private static final String SELECT_FROM_DATE_PID = "SELECT "
			+ "LOCATION_PID, PRIMARY_LOCATION, X_COORDINATE, "
			+ "Y_COORDINATE, Z_COORDINATE, INSERT_TSTMP, "
			+ "UPDATE_TSTMP, TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.LOCATIONS WHERE FROM_DATE_PID = ? ORDER BY LOCATION_PID";
	private static final String SELECT_TO_DATE_PID = "SELECT "
			+ "LOCATION_PID, PRIMARY_LOCATION, X_COORDINATE, "
			+ "Y_COORDINATE, Z_COORDINATE, INSERT_TSTMP, "
			+ "UPDATE_TSTMP, TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.LOCATIONS WHERE TO_DATE_PID = ? ORDER BY LOCATION_PID";
	private static final String SELECTALL = "SELECT LOCATION_PID, "
			+ "PRIMARY_LOCATION, X_COORDINATE, Y_COORDINATE, "
			+ "Z_COORDINATE, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID FROM PUBLIC.LOCATIONS ORDER BY LOCATION_PID";
	private static final String SELECTMAX = "SELECT MAX(LOCATION_PID) FROM PUBLIC.LOCATIONS";

	private static final String INSERT = "INSERT INTO PUBLIC.LOCATIONS( "
			+ "LOCATION_PID, PRIMARY_LOCATION, X_COORDINATE, "
			+ "Y_COORDINATE, Z_COORDINATE, INSERT_TSTMP, "
			+ "UPDATE_TSTMP, TABLE_ID, FROM_DATE_PID, "
			+ "TO_DATE_PID) VALUES (?, ?, ?, ?, ?, "
			+ "CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 9, ?, ?)";

	private static final String UPDATE = "UPDATE PUBLIC.LOCATIONS SET "
			+ "PRIMARY_LOCATION = ?, X_COORDINATE = ?"
			+ ", Y_COORDINATE = ?, Z_COORDINATE = ?"
			+ ", UPDATE_TSTMP = CURRENT_TIMESTAMP, FROM_DATE_PID = ?"
			+ ", TO_DATE_PID = ? WHERE LOCATION_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.LOCATIONS WHERE LOCATION_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.LOCATIONS";

	private List<Locations> modelList;

	private PreparedStatement ps;

	private ResultSet rs;

	private Connection conn;

	private int LocationPid;
	private boolean PrimaryLocation;
	private BigDecimal XCoordinate;
	private BigDecimal YCoordinate;
	private BigDecimal ZCoordinate;
	private Timestamp InsertTstmp;
	private Timestamp UpdateTstmp;
	private int TableId;
	private int FromDatePid;
	private int ToDatePid;
	private Locations model;

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

	public List<Locations> get() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Locations();
			model.setLocationPid(rs.getInt("LOCATION_PID"));
			model.setPrimaryLocation(rs.getBoolean("PRIMARY_LOCATION"));
			model.setXCoordinate(rs.getBigDecimal("X_COORDINATE"));
			model.setYCoordinate(rs.getBigDecimal("Y_COORDINATE"));
			model.setZCoordinate(rs.getBigDecimal("Z_COORDINATE"));
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
			setLocationPid(rs.getInt("LOCATION_PID"));
			setPrimaryLocation(rs.getBoolean("PRIMARY_LOCATION"));
			setXCoordinate(rs.getBigDecimal("X_COORDINATE"));
			setYCoordinate(rs.getBigDecimal("Y_COORDINATE"));
			setZCoordinate(rs.getBigDecimal("Z_COORDINATE"));
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

	public List<Locations> getFKFromDatePid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_FROM_DATE_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Locations();
			model.setLocationPid(rs.getInt("LOCATION_PID"));
			model.setPrimaryLocation(rs.getBoolean("PRIMARY_LOCATION"));
			model.setXCoordinate(rs.getBigDecimal("X_COORDINATE"));
			model.setYCoordinate(rs.getBigDecimal("Y_COORDINATE"));
			model.setZCoordinate(rs.getBigDecimal("Z_COORDINATE"));
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

	public List<Locations> getFKToDatePid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_TO_DATE_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Locations();
			model.setLocationPid(rs.getInt("LOCATION_PID"));
			model.setPrimaryLocation(rs.getBoolean("PRIMARY_LOCATION"));
			model.setXCoordinate(rs.getBigDecimal("X_COORDINATE"));
			model.setYCoordinate(rs.getBigDecimal("Y_COORDINATE"));
			model.setZCoordinate(rs.getBigDecimal("Z_COORDINATE"));
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
	 * Get the LocationPid field.
	 *
	 * @return Contents of the LOCATION_PID column
	 */
	public int getLocationPid() {
		return LocationPid;
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

	/**
	 * Get the XCoordinate field.
	 *
	 * @return Contents of the X_COORDINATE column
	 */
	public BigDecimal getXCoordinate() {
		return XCoordinate;
	}

	/**
	 * Get the YCoordinate field.
	 *
	 * @return Contents of the Y_COORDINATE column
	 */
	public BigDecimal getYCoordinate() {
		return YCoordinate;
	}

	/**
	 * Get the ZCoordinate field.
	 *
	 * @return Contents of the Z_COORDINATE column
	 */
	public BigDecimal getZCoordinate() {
		return ZCoordinate;
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
		ps.setBoolean(2, isPrimaryLocation());
		ps.setBigDecimal(3, getXCoordinate());
		ps.setBigDecimal(4, getYCoordinate());
		ps.setBigDecimal(5, getZCoordinate());
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
	 * Get the PrimaryLocation field.
	 *
	 * @return Contents of the PRIMARY_LOCATION column
	 */
	public boolean isPrimaryLocation() {
		return PrimaryLocation;
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
	 * Set the LocationPid field
	 *
	 * @param LocationPid Contents of the LOCATION_PID column
	 */
	public void setLocationPid(int LocationPid) {
		this.LocationPid = LocationPid;
	}

	/**
	 * Set the PrimaryLocation field
	 *
	 * @param PrimaryLocation Contents of the PRIMARY_LOCATION column
	 */
	public void setPrimaryLocation(boolean PrimaryLocation) {
		this.PrimaryLocation = PrimaryLocation;
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

	/**
	 * Set the XCoordinate field
	 *
	 * @param XCoordinate Contents of the X_COORDINATE column
	 */
	public void setXCoordinate(BigDecimal XCoordinate) {
		this.XCoordinate = XCoordinate;
	}

	/**
	 * Set the YCoordinate field
	 *
	 * @param YCoordinate Contents of the Y_COORDINATE column
	 */
	public void setYCoordinate(BigDecimal YCoordinate) {
		this.YCoordinate = YCoordinate;
	}

	/**
	 * Set the ZCoordinate field
	 *
	 * @param ZCoordinate Contents of the Z_COORDINATE column
	 */
	public void setZCoordinate(BigDecimal ZCoordinate) {
		this.ZCoordinate = ZCoordinate;
	}

	public void update() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(UPDATE);
		ps.setBoolean(1, isPrimaryLocation());
		ps.setBigDecimal(2, getXCoordinate());
		ps.setBigDecimal(3, getYCoordinate());
		ps.setBigDecimal(4, getZCoordinate());
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
		ps.setInt(7, getLocationPid());
		ps.executeUpdate();
		conn.close();
	}

}
