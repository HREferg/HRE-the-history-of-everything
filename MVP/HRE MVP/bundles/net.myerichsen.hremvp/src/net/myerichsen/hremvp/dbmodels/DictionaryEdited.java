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
 * The persistent class for the DICTIONARY database table
 *
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2019
 * @version 24. feb. 2019
 *
 */

public class DictionaryEdited {
	private static final String SELECT = "SELECT DICTIONARY_PID, "
			+ "LABEL_PID, ISO_CODE, LABEL, INSERT_TSTMP, "
			+ "UPDATE_TSTMP, TABLE_ID, "
			+ "LABEL_TYPE FROM PUBLIC.DICTIONARY WHERE DICTIONARY_PID = ?";
	private static final String SELECT_ISO_CODE = "SELECT DICTIONARY_PID, "
			+ "LABEL_PID, ISO_CODE, LABEL, INSERT_TSTMP, "
			+ "UPDATE_TSTMP, TABLE_ID, "
			+ "LABEL_TYPE FROM PUBLIC.DICTIONARY WHERE ISO_CODE = ? ORDER BY DICTIONARY_PID";
	private static final String SELECTALL = "SELECT DICTIONARY_PID, "
			+ "LABEL_PID, ISO_CODE, LABEL, INSERT_TSTMP, "
			+ "UPDATE_TSTMP, TABLE_ID, "
			+ "LABEL_TYPE FROM PUBLIC.DICTIONARY ORDER BY DICTIONARY_PID";
	private static final String SELECTMAX = "SELECT MAX(DICTIONARY_PID) FROM PUBLIC.DICTIONARY";
	private static final String INSERT = "INSERT INTO PUBLIC.DICTIONARY( "
			+ "DICTIONARY_PID, LABEL_PID, ISO_CODE, LABEL, "
			+ "INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID, "
			+ "LABEL_TYPE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String UPDATE = "UPDATE PUBLIC.DICTIONARY SET "
			+ "LABEL_PID = ?, ISO_CODE = ?, LABEL = ?, "
			+ "INSERT_TSTMP = ?, UPDATE_TSTMP = ?, TABLE_ID = ?, "
			+ "LABEL_TYPE = ? WHERE DICTIONARY_PID = ?";

	private static final String SELECTMAXLABELPID = "SELECT MAX(LABEL_PID) FROM PUBLIC.DICTIONARY";

	private static final String DELETE = "DELETE FROM PUBLIC.DICTIONARY WHERE DICTIONARY_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.DICTIONARY";

	private static final String SELECT_LABEL_PID = "SELECT DICTIONARY_PID, LABEL_PID, ISO_CODE, LABEL, TABLE_ID "
			+ "FROM PUBLIC.DICTIONARY "
			+ "WHERE LABEL_PID = ? ORDER BY ISO_CODE";

	private List<DictionaryEdited> modelList;

	private PreparedStatement ps;

	private ResultSet rs;

	private Connection conn;

	private int DictionaryPid;
	private int LabelPid;
	private String IsoCode;
	private String Label;
	private Timestamp InsertTstmp;
	private Timestamp UpdateTstmp;
	private int TableId;
	private String LabelType;
	private DictionaryEdited model;

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

	public List<DictionaryEdited> get() throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new DictionaryEdited();
			model.setDictionaryPid(rs.getInt("DICTIONARY_PID"));
			model.setLabelPid(rs.getInt("LABEL_PID"));
			model.setIsoCode(rs.getString("ISO_CODE"));
			model.setLabel(rs.getString("LABEL"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setLabelType(rs.getString("LABEL_TYPE"));
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
			setDictionaryPid(rs.getInt("DICTIONARY_PID"));
			setLabelPid(rs.getInt("LABEL_PID"));
			setIsoCode(rs.getString("ISO_CODE"));
			setLabel(rs.getString("LABEL"));
			setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			setTableId(rs.getInt("TABLE_ID"));
			setLabelType(rs.getString("LABEL_TYPE"));
		} else {
			throw new MvpException("ID " + key + " not found");
		}
		conn.close();
	}

	/**
	 * Get the DictionaryPid field.
	 *
	 * @return Contents of the DICTIONARY_PID column
	 */
	public int getDictionaryPid() {
		return DictionaryPid;
	}

	public List<DictionaryEdited> getFKIsoCode(String key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_ISO_CODE);
		ps.setString(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new DictionaryEdited();
			model.setDictionaryPid(rs.getInt("DICTIONARY_PID"));
			model.setLabelPid(rs.getInt("LABEL_PID"));
			model.setIsoCode(rs.getString("ISO_CODE"));
			model.setLabel(rs.getString("LABEL"));
			model.setInsertTstmp(rs.getTimestamp("INSERT_TSTMP"));
			model.setUpdateTstmp(rs.getTimestamp("UPDATE_TSTMP"));
			model.setTableId(rs.getInt("TABLE_ID"));
			model.setLabelType(rs.getString("LABEL_TYPE"));
			modelList.add(model);
		}
		conn.close();
		return modelList;
	}

	public List<DictionaryEdited> getFKLabelPid(int key) throws Exception {
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECT_LABEL_PID);
		ps.setLong(1, key);
		rs = ps.executeQuery();
		modelList = new ArrayList<>();
		while (rs.next()) {
			model = new DictionaryEdited();
			model.setDictionaryPid(rs.getInt("DICTIONARY_PID"));
			model.setLabelPid(rs.getInt("LABEL_PID"));
			model.setIsoCode(rs.getString("ISO_CODE"));
			model.setLabel(rs.getString("LABEL"));
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
	 * Get the IsoCode field.
	 *
	 * @return Contents of the ISO_CODE column
	 */
	public String getIsoCode() {
		return IsoCode;
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
	 * Get the LabelPid field.
	 *
	 * @return Contents of the LABEL_PID column
	 */
	public int getLabelPid() {
		return LabelPid;
	}

	/**
	 * Get the LabelType field.
	 *
	 * @return Contents of the LABEL_TYPE column
	 */
	public String getLabelType() {
		return LabelType;
	}

	/**
	 * Returns the next label pid, but dows not create it
	 *
	 * @return
	 * @throws Exception
	 */
	public int getNextLabelPid() throws Exception {
		int maxLabelPid = 0;
		conn = HreH2ConnectionPool.getConnection();
		ps = conn.prepareStatement(SELECTMAXLABELPID);
		rs = ps.executeQuery();
		if (rs.next()) {
			maxLabelPid = rs.getInt(1);
		}
		maxLabelPid++;

		return maxLabelPid;
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
		ps.setInt(2, getLabelPid());
		ps.setString(3, getIsoCode());
		ps.setString(4, getLabel());
		ps.setTimestamp(5, getInsertTstmp());
		ps.setTimestamp(6, getUpdateTstmp());
		ps.setInt(7, getTableId());
		ps.setString(8, getLabelType());
		ps.executeUpdate();
		conn.close();
		return maxPid;
	}

	/**
	 * Set the DictionaryPid field
	 *
	 * @param DictionaryPid Contents of the DICTIONARY_PID column
	 */
	public void setDictionaryPid(int DictionaryPid) {
		this.DictionaryPid = DictionaryPid;
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
	 * Set the IsoCode field
	 *
	 * @param IsoCode Contents of the ISO_CODE column
	 */
	public void setIsoCode(String IsoCode) {
		this.IsoCode = IsoCode;
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
	 * Set the LabelPid field
	 *
	 * @param LabelPid Contents of the LABEL_PID column
	 */
	public void setLabelPid(int LabelPid) {
		this.LabelPid = LabelPid;
	}

	/**
	 * Set the LabelType field
	 *
	 * @param LabelType Contents of the LABEL_TYPE column
	 */
	public void setLabelType(String LabelType) {
		this.LabelType = LabelType;
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
		ps.setInt(1, getLabelPid());
		ps.setString(2, getIsoCode());
		ps.setString(3, getLabel());
		ps.setTimestamp(4, getInsertTstmp());
		ps.setTimestamp(5, getUpdateTstmp());
		ps.setInt(6, getTableId());
		ps.setString(7, getLabelType());
		ps.setInt(8, getDictionaryPid());
		ps.executeUpdate();
		conn.close();
	}

}
