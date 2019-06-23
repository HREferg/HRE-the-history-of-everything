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
 * The persistent class for the SEX_TYPES database table
 *
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2019
 * @version 24. feb. 2019
 *
 */

public class SexTypes {
	private static final String SELECT = "SELECT SEX_TYPE_PID, "
			+ "ABBREVIATION, INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, "
			+ "LABEL_PID FROM PUBLIC.SEX_TYPES WHERE SEX_TYPE_PID = ?";
	private static final String SELECTALL = "SELECT SEX_TYPE_PID, "
			+ "ABBREVIATION, INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, "
			+ "LABEL_PID FROM PUBLIC.SEX_TYPES ORDER BY SEX_TYPE_PID";
	private static final String SELECTMAX = "SELECT MAX(SEX_TYPE_PID) FROM PUBLIC.SEX_TYPES";
	private static final String INSERT = "INSERT INTO PUBLIC.SEX_TYPES( "
			+ "SEX_TYPE_PID, ABBREVIATION, INSERT_TSTMP, "
			+ "UPDATE_TSTMP, TABLE_ID, LABEL_PID) VALUES (?, "
			+ "?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, ?)";
	private static final String UPDATE = "UPDATE PUBLIC.SEX_TYPES SET "
			+ "ABBREVIATION = ?, UPDATE_TSTMP = CURRENT_TIMESTAMP, "
			+ "LABEL_PID = ? WHERE SEX_TYPE_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SEX_TYPES WHERE SEX_TYPE_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SEX_TYPES";

	private List<SexTypes> modelList;

	private PreparedStatement ps;

	private ResultSet rs;

	private Connection conn;

	private int SexTypePid;
	private String Abbreviation;
	private Timestamp InsertTstmp;
	private Timestamp UpdateTstmp;
	private int TableId;
	private int LabelPid;
	private SexTypes model;

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

	public List<SexTypes> get() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new SexTypes();
			model.setSexTypePid(rs.getInt("SEX_TYPE_PID"));
			model.setAbbreviation(rs.getString("ABBREVIATION"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setLabelPid(rs.getInt("LABEL_PID"));
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
			setSexTypePid(rs.getInt("SEX_TYPE_PID"));
			setAbbreviation(rs.getString("ABBREVIATION"));
			setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			setTableId(rs.getInt("TABLE_ID"));
			setLabelPid(rs.getInt("LABEL_PID"));
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
	 * Get the SexTypePid field.
	 *
	 * @return Contents of the SEX_TYPE_PID column
	 */
	public int getSexTypePid() {
		return SexTypePid;
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
//		ps.setTimestamp(3, getInsertTstmp());
//		ps.setTimestamp(4, getUpdateTstmp());
//		ps.setInt(5, getTableId());
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
	 * Set the SexTypePid field
	 *
	 * @param SexTypePid Contents of the SEX_TYPE_PID column
	 */
	public void setSexTypePid(int SexTypePid) {
		this.SexTypePid = SexTypePid;
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
//		ps.setTimestamp(2, getInsertTstmp());
//		ps.setTimestamp(3, getUpdateTstmp());
//		ps.setInt(4, getTableId());
		ps.setInt(2, getLabelPid());
		ps.setInt(3, getSexTypePid());
		ps.executeUpdate();
		conn.close();
	}

}
