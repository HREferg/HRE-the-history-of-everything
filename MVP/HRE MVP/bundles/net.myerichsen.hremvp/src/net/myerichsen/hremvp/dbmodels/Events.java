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
 * The persistent class for the EVENTS database table
 *
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2019
 * @version 24. mar. 2019
 *
 */

public class Events {
	private static final String SELECT = "SELECT EVENT_PID, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, "
			+ "FROM_DATE_PID, TO_DATE_PID, "
			+ "EVENT_TYPE_PID FROM PUBLIC.EVENTS WHERE EVENT_PID = ?";
	private static final String SELECT_EVENT_TYPE_PID = "SELECT "
			+ "EVENT_PID, INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, "
			+ "FROM_DATE_PID, TO_DATE_PID, "
			+ "EVENT_TYPE_PID FROM PUBLIC.EVENTS WHERE EVENT_TYPE_PID = ? ORDER BY EVENT_PID";
	private static final String SELECTALL = "SELECT EVENT_PID, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, "
			+ "FROM_DATE_PID, TO_DATE_PID, "
			+ "EVENT_TYPE_PID FROM PUBLIC.EVENTS ORDER BY EVENT_PID";
	private static final String SELECTMAX = "SELECT MAX(EVENT_PID) FROM PUBLIC.EVENTS";
	private static final String INSERT = "INSERT INTO PUBLIC.EVENTS( "
			+ "EVENT_PID, INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, "
			+ "FROM_DATE_PID, TO_DATE_PID, EVENT_TYPE_PID) VALUES ("
			+ "?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 12, ?, ?, ?)";

	private static final String UPDATE = "UPDATE PUBLIC.EVENTS SET "
			+ "UPDATE_TSTMP = CURRENT_TIMESTAMP, FROM_DATE_PID = ?"
			+ ", TO_DATE_PID = ?, EVENT_TYPE_PID = ? WHERE EVENT_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.EVENTS WHERE EVENT_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.EVENTS";

	private List<Events> modelList;

	private PreparedStatement ps;

	private ResultSet rs;

	private Connection conn;

	private int EventPid;
	private Timestamp InsertTstmp;
	private Timestamp UpdateTstmp;
	private int TableId;
	private int FromDatePid;
	private int ToDatePid;
	private int EventTypePid;
	private Events model;

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

	public List<Events> get() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Events();
			model.setEventPid(rs.getInt("EVENT_PID"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setFromDatePid(rs.getInt("FROM_DATE_PID"));
			model.setToDatePid(rs.getInt("TO_DATE_PID"));
			model.setEventTypePid(rs.getInt("EVENT_TYPE_PID"));
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
			setEventPid(rs.getInt("EVENT_PID"));
			setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			setTableId(rs.getInt("TABLE_ID"));
			setFromDatePid(rs.getInt("FROM_DATE_PID"));
			setToDatePid(rs.getInt("TO_DATE_PID"));
			setEventTypePid(rs.getInt("EVENT_TYPE_PID"));
		} else {
			throw new MvpException("ID " + key + " not found");
		}
		conn.close();
	}

	/**
	 * Get the EventPid field.
	 *
	 * @return Contents of the EVENT_PID column
	 */
	public int getEventPid() {
		return EventPid;
	}

	/**
	 * Get the EventTypePid field.
	 *
	 * @return Contents of the EVENT_TYPE_PID column
	 */
	public int getEventTypePid() {
		return EventTypePid;
	}

	public List<Events> getFKEventTypePid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_EVENT_TYPE_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Events();
			model.setEventPid(rs.getInt("EVENT_PID"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setFromDatePid(rs.getInt("FROM_DATE_PID"));
			model.setToDatePid(rs.getInt("TO_DATE_PID"));
			model.setEventTypePid(rs.getInt("EVENT_TYPE_PID"));
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
		if (getFromDatePid() == 0) {
			ps.setNull(2, java.sql.Types.INTEGER);
		} else {
			ps.setInt(2, getFromDatePid());
		}
		if (getToDatePid() == 0) {
			ps.setNull(3, java.sql.Types.INTEGER);
		} else {
			ps.setInt(3, getToDatePid());
		}
		ps.setInt(4, getEventTypePid());
		ps.executeUpdate();
		conn.close();
		return maxPid;
	}

	/**
	 * Set the EventPid field
	 *
	 * @param EventPid Contents of the EVENT_PID column
	 */
	public void setEventPid(int EventPid) {
		this.EventPid = EventPid;
	}

	/**
	 * Set the EventTypePid field
	 *
	 * @param EventTypePid Contents of the EVENT_TYPE_PID column
	 */
	public void setEventTypePid(int EventTypePid) {
		this.EventTypePid = EventTypePid;
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
		if (getFromDatePid() == 0) {
			ps.setNull(1, java.sql.Types.INTEGER);
		} else {
			ps.setInt(1, getFromDatePid());
		}
		if (getToDatePid() == 0) {
			ps.setNull(2, java.sql.Types.INTEGER);
		} else {
			ps.setInt(2, getToDatePid());
		}
		ps.setInt(3, getEventTypePid());
		ps.setInt(4, getEventPid());
		ps.executeUpdate();
		conn.close();
	}

}
