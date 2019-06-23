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
 * The persistent class for the LANGUAGES database table
 *
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2019
 * @version 10. mar. 2019
 *
 */

public class Languages {
	private static final String SELECT = "SELECT LANGUAGE_PID, "
			+ "ISOCODE, LABEL, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID FROM PUBLIC.LANGUAGES WHERE LANGUAGE_PID = ?";
	private static final String SELECTALL = "SELECT LANGUAGE_PID, "
			+ "ISOCODE, LABEL, INSERT_TSTMP, UPDATE_TSTMP, "
			+ "TABLE_ID FROM PUBLIC.LANGUAGES ORDER BY LANGUAGE_PID";
	private static final String SELECTMAX = "SELECT MAX(LANGUAGE_PID) FROM PUBLIC.LANGUAGES";
	private static final String INSERT = "INSERT INTO PUBLIC.LANGUAGES( "
			+ "LANGUAGE_PID, ISOCODE, LABEL, INSERT_TSTMP, "
			+ "UPDATE_TSTMP, TABLE_ID) VALUES (?, ?, ?, "
			+ "CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 7) ";
	private static final String UPDATE = "UPDATE PUBLIC.LANGUAGES SET "
			+ "ISOCODE = ?, LABEL = ?"
			+ ", UPDATE_TSTMP = CURRENT_TIMESTAMP WHERE LANGUAGE_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.LANGUAGES WHERE LANGUAGE_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.LANGUAGES";

	private List<Languages> modelList;

	private PreparedStatement ps;

	private ResultSet rs;

	private Connection conn;

	private int LanguagePid;
	private String Isocode;
	private String Label;
	private Timestamp InsertTstmp;
	private Timestamp UpdateTstmp;
	private int TableId;
	private Languages model;

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

	public List<Languages> get() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new Languages();
			model.setLanguagePid(rs.getInt("LANGUAGE_PID"));
			model.setIsocode(rs.getString("ISOCODE"));
			model.setLabel(rs.getString("LABEL"));
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
			setLanguagePid(rs.getInt("LANGUAGE_PID"));
			setIsocode(rs.getString("ISOCODE"));
			setLabel(rs.getString("LABEL"));
			setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			setTableId(rs.getInt("TABLE_ID"));
		} else {
			throw new MvpException("ID " + key + " not found");
		}
		conn.close();
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
	 * Get the Isocode field.
	 *
	 * @return Contents of the ISOCODE column
	 */
	public String getIsocode() {
		return Isocode;
	}

	/**
	 * Get the Label field.
	 *
	 * @return Contents of the LABEL column
	 */
	public String getLabel() {
		return Label;
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
		ps.setString(2, getIsocode());
		ps.setString(3, getLabel());
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
	 * Set the Isocode field
	 *
	 * @param Isocode Contents of the ISOCODE column
	 */
	public void setIsocode(String Isocode) {
		this.Isocode = Isocode;
	}

	/**
	 * Set the Label field
	 *
	 * @param Label Contents of the LABEL column
	 */
	public void setLabel(String Label) {
		this.Label = Label;
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
		ps.setString(1, getIsocode());
		ps.setString(2, getLabel());
		ps.setInt(3, getLanguagePid());
		ps.executeUpdate();
		conn.close();
	}

}
