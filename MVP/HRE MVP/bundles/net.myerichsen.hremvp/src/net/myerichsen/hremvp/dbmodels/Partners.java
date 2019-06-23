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
 * The persistent class for the PARTNERS database table
 *
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2019
 * @version 28. mar. 2019
 *
 */

public class Partners {
	private static final String SELECT = "SELECT PARTNER_PID, "
			+ "PARTNER1, PARTNER2, PRIMARY_PARTNER, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, "
			+ "FROM_DATE_PID, TO_DATE_PID, LANGUAGE_PID, "
			+ "PARTNER_ROLE_PID FROM PUBLIC.PARTNERS WHERE PARTNER_PID = ?";
	private static final String SELECT_PARTNER1 = "SELECT PARTNER_PID, "
			+ "PARTNER1, PARTNER2, PRIMARY_PARTNER, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, "
			+ "FROM_DATE_PID, TO_DATE_PID, LANGUAGE_PID, "
			+ "PARTNER_ROLE_PID FROM PUBLIC.PARTNERS WHERE PARTNER1 = ? ORDER BY PARTNER_PID";
	private static final String SELECT_PARTNER2 = "SELECT PARTNER_PID, "
			+ "PARTNER1, PARTNER2, PRIMARY_PARTNER, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, "
			+ "FROM_DATE_PID, TO_DATE_PID, LANGUAGE_PID, "
			+ "PARTNER_ROLE_PID FROM PUBLIC.PARTNERS WHERE PARTNER2 = ? ORDER BY PARTNER_PID";
	private static final String SELECT_FROM_DATE_PID = "SELECT "
			+ "PARTNER_PID, PARTNER1, PARTNER2, "
			+ "PRIMARY_PARTNER, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID, FROM_DATE_PID, TO_DATE_PID, LANGUAGE_PID, "
			+ "PARTNER_ROLE_PID FROM PUBLIC.PARTNERS WHERE FROM_DATE_PID = ? ORDER BY PARTNER_PID";
	private static final String SELECT_TO_DATE_PID = "SELECT PARTNER_PID, "
			+ "PARTNER1, PARTNER2, PRIMARY_PARTNER, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, "
			+ "FROM_DATE_PID, TO_DATE_PID, LANGUAGE_PID, "
			+ "PARTNER_ROLE_PID FROM PUBLIC.PARTNERS WHERE TO_DATE_PID = ? ORDER BY PARTNER_PID";

	private static final String SELECT_PARTNER_ROLE_PID = "SELECT "
			+ "PARTNER_PID, PARTNER1, PARTNER2, "
			+ "PRIMARY_PARTNER, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID, FROM_DATE_PID, TO_DATE_PID, LANGUAGE_PID, "
			+ "PARTNER_ROLE_PID FROM PUBLIC.PARTNERS WHERE PARTNER_ROLE_PID = ? ORDER BY PARTNER_PID";

	private static final String SELECTALL = "SELECT PARTNER_PID, "
			+ "PARTNER1, PARTNER2, PRIMARY_PARTNER, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, "
			+ "FROM_DATE_PID, TO_DATE_PID, LANGUAGE_PID, "
			+ "PARTNER_ROLE_PID FROM PUBLIC.PARTNERS ORDER BY PARTNER_PID";

	private static final String SELECTMAX = "SELECT MAX(PARTNER_PID) FROM PUBLIC.PARTNERS";

	private static final String INSERT = "INSERT INTO PUBLIC.PARTNERS( "
			+ "PARTNER_PID, PARTNER1, PARTNER2, "
			+ "PRIMARY_PARTNER, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID, FROM_DATE_PID, TO_DATE_PID, "
			+ "LANGUAGE_PID, PARTNER_ROLE_PID) VALUES (?, ?, "
			+ "?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 5, ?, ?, ?, ?)";

	private static final String UPDATE = "UPDATE PUBLIC.PARTNERS SET "
			+ "PARTNER1 = ?, PARTNER2 = ?, PRIMARY_PARTNER = ?"
			+ ", UPDATE_TSTMP = CURRENT_TIMESTAMP, FROM_DATE_PID = ?"
			+ ", TO_DATE_PID = ?, LANGUAGE_PID = ?"
			+ ", PARTNER_ROLE_PID = ? WHERE PARTNER_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.PARTNERS WHERE PARTNER_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.PARTNERS";

	private List<Partners> modelList;

	private PreparedStatement ps;

	private ResultSet rs;

	private Connection conn;

	private int PartnerPid;
	private int Partner1;
	private int Partner2;
	private boolean PrimaryPartner;
	private Timestamp InsertTstmp;
	private Timestamp UpdateTstmp;
	private int TableId;
	private int FromDatePid;
	private int ToDatePid;
	private int LanguagePid;
	private int PartnerRolePid;
	private Partners model;

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

	public List<Partners> get() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Partners();
			model.setPartnerPid(rs.getInt("PARTNER_PID"));
			model.setPartner1(rs.getInt("PARTNER1"));
			model.setPartner2(rs.getInt("PARTNER2"));
			model.setPrimaryPartner(rs.getBoolean("PRIMARY_PARTNER"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setFromDatePid(rs.getInt("FROM_DATE_PID"));
			model.setToDatePid(rs.getInt("TO_DATE_PID"));
			model.setLanguagePid(rs.getInt("LANGUAGE_PID"));
			model.setPartnerRolePid(rs.getInt("PARTNER_ROLE_PID"));
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
			setPartnerPid(rs.getInt("PARTNER_PID"));
			setPartner1(rs.getInt("PARTNER1"));
			setPartner2(rs.getInt("PARTNER2"));
			setPrimaryPartner(rs.getBoolean("PRIMARY_PARTNER"));
			setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			setTableId(rs.getInt("TABLE_ID"));
			setFromDatePid(rs.getInt("FROM_DATE_PID"));
			setToDatePid(rs.getInt("TO_DATE_PID"));
			setLanguagePid(rs.getInt("LANGUAGE_PID"));
			setPartnerRolePid(rs.getInt("PARTNER_ROLE_PID"));
		} else {
			throw new MvpException("ID " + key + " not found");
		}
		conn.close();
	}

	public List<Partners> getFKFromDatePid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_FROM_DATE_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Partners();
			model.setPartnerPid(rs.getInt("PARTNER_PID"));
			model.setPartner1(rs.getInt("PARTNER1"));
			model.setPartner2(rs.getInt("PARTNER2"));
			model.setPrimaryPartner(rs.getBoolean("PRIMARY_PARTNER"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setFromDatePid(rs.getInt("FROM_DATE_PID"));
			model.setToDatePid(rs.getInt("TO_DATE_PID"));
			model.setLanguagePid(rs.getInt("LANGUAGE_PID"));
			model.setPartnerRolePid(rs.getInt("PARTNER_ROLE_PID"));
			modelList.add(model);
		}
		conn.close();
		return modelList;
	}

	public List<Partners> getFKPartner1(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_PARTNER1);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Partners();
			model.setPartnerPid(rs.getInt("PARTNER_PID"));
			model.setPartner1(rs.getInt("PARTNER1"));
			model.setPartner2(rs.getInt("PARTNER2"));
			model.setPrimaryPartner(rs.getBoolean("PRIMARY_PARTNER"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setFromDatePid(rs.getInt("FROM_DATE_PID"));
			model.setToDatePid(rs.getInt("TO_DATE_PID"));
			model.setLanguagePid(rs.getInt("LANGUAGE_PID"));
			model.setPartnerRolePid(rs.getInt("PARTNER_ROLE_PID"));
			modelList.add(model);
		}
		conn.close();
		return modelList;
	}

	public List<Partners> getFKPartner2(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_PARTNER2);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Partners();
			model.setPartnerPid(rs.getInt("PARTNER_PID"));
			model.setPartner1(rs.getInt("PARTNER1"));
			model.setPartner2(rs.getInt("PARTNER2"));
			model.setPrimaryPartner(rs.getBoolean("PRIMARY_PARTNER"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setFromDatePid(rs.getInt("FROM_DATE_PID"));
			model.setToDatePid(rs.getInt("TO_DATE_PID"));
			model.setLanguagePid(rs.getInt("LANGUAGE_PID"));
			model.setPartnerRolePid(rs.getInt("PARTNER_ROLE_PID"));
			modelList.add(model);
		}
		conn.close();
		return modelList;
	}

	public List<Partners> getFKPartnerRolePid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_PARTNER_ROLE_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Partners();
			model.setPartnerPid(rs.getInt("PARTNER_PID"));
			model.setPartner1(rs.getInt("PARTNER1"));
			model.setPartner2(rs.getInt("PARTNER2"));
			model.setPrimaryPartner(rs.getBoolean("PRIMARY_PARTNER"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setFromDatePid(rs.getInt("FROM_DATE_PID"));
			model.setToDatePid(rs.getInt("TO_DATE_PID"));
			model.setLanguagePid(rs.getInt("LANGUAGE_PID"));
			model.setPartnerRolePid(rs.getInt("PARTNER_ROLE_PID"));
			modelList.add(model);
		}
		conn.close();
		return modelList;
	}

	public List<Partners> getFKToDatePid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_TO_DATE_PID);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Partners();
			model.setPartnerPid(rs.getInt("PARTNER_PID"));
			model.setPartner1(rs.getInt("PARTNER1"));
			model.setPartner2(rs.getInt("PARTNER2"));
			model.setPrimaryPartner(rs.getBoolean("PRIMARY_PARTNER"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setFromDatePid(rs.getInt("FROM_DATE_PID"));
			model.setToDatePid(rs.getInt("TO_DATE_PID"));
			model.setLanguagePid(rs.getInt("LANGUAGE_PID"));
			model.setPartnerRolePid(rs.getInt("PARTNER_ROLE_PID"));
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
	 * Get the LanguagePid field.
	 *
	 * @return Contents of the LANGUAGE_PID column
	 */
	public int getLanguagePid() {
		return LanguagePid;
	}

	/**
	 * Get the Partner1 field.
	 *
	 * @return Contents of the PARTNER1 column
	 */
	public int getPartner1() {
		return Partner1;
	}

	/**
	 * Get the Partner2 field.
	 *
	 * @return Contents of the PARTNER2 column
	 */
	public int getPartner2() {
		return Partner2;
	}

	/**
	 * Get the PartnerPid field.
	 *
	 * @return Contents of the PARTNER_PID column
	 */
	public int getPartnerPid() {
		return PartnerPid;
	}

	/**
	 * Get the PartnerRolePid field.
	 *
	 * @return Contents of the PARTNER_ROLE_PID column
	 */
	public int getPartnerRolePid() {
		return PartnerRolePid;
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
		ps.setInt(2, getPartner1());
		ps.setInt(3, getPartner2());
		ps.setBoolean(4, isPrimaryPartner());
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
		ps.setInt(7, getLanguagePid());
		ps.setInt(8, getPartnerRolePid());
		ps.executeUpdate();
		conn.close();
		return maxPid;
	}

	/**
	 * Get the PrimaryPartner field.
	 *
	 * @return Contents of the PRIMARY_PARTNER column
	 */
	public boolean isPrimaryPartner() {
		return PrimaryPartner;
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
	 * Set the LanguagePid field
	 *
	 * @param LanguagePid Contents of the LANGUAGE_PID column
	 */
	public void setLanguagePid(int LanguagePid) {
		this.LanguagePid = LanguagePid;
	}

	/**
	 * Set the Partner1 field
	 *
	 * @param Partner1 Contents of the PARTNER1 column
	 */
	public void setPartner1(int Partner1) {
		this.Partner1 = Partner1;
	}

	/**
	 * Set the Partner2 field
	 *
	 * @param Partner2 Contents of the PARTNER2 column
	 */
	public void setPartner2(int Partner2) {
		this.Partner2 = Partner2;
	}

	/**
	 * Set the PartnerPid field
	 *
	 * @param PartnerPid Contents of the PARTNER_PID column
	 */
	public void setPartnerPid(int PartnerPid) {
		this.PartnerPid = PartnerPid;
	}

	/**
	 * Set the PartnerRolePid field
	 *
	 * @param PartnerRolePid Contents of the PARTNER_ROLE_PID column
	 */
	public void setPartnerRolePid(int PartnerRolePid) {
		this.PartnerRolePid = PartnerRolePid;
	}

	/**
	 * Set the PrimaryPartner field
	 *
	 * @param PrimaryPartner Contents of the PRIMARY_PARTNER column
	 */
	public void setPrimaryPartner(boolean PrimaryPartner) {
		this.PrimaryPartner = PrimaryPartner;
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
		ps.setInt(1, getPartner1());
		ps.setInt(2, getPartner2());
		ps.setBoolean(3, isPrimaryPartner());
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
		ps.setInt(6, getLanguagePid());
		ps.setInt(7, getPartnerRolePid());
		ps.setInt(8, getPartnerPid());
		ps.executeUpdate();
		conn.close();
	}

}
