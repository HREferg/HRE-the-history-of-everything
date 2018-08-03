package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the DIGITAL_NAME_PARTS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class DigitalNameParts extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "DIGITAL_NAME_PART_PID, " + "IS_SYSTEM, " + "ELEMENT_TYPE_KEY, " + "SHARED, " + "LANG_CODE, "
			+ "TRANS FROM PUBLIC.DIGITAL_NAME_PARTS WHERE DIGITAL_NAME_PART_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "DIGITAL_NAME_PART_PID, " + "IS_SYSTEM, " + "ELEMENT_TYPE_KEY, " + "SHARED, " + "LANG_CODE, "
			+ "TRANS FROM PUBLIC.DIGITAL_NAME_PARTS";

	private static final String INSERT = "INSERT INTO PUBLIC.DIGITAL_NAME_PARTS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "DIGITAL_NAME_PART_PID, " + "IS_SYSTEM, " + "ELEMENT_TYPE_KEY, " + "SHARED, "
			+ "LANG_CODE, " + "TRANS) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.DIGITAL_NAME_PARTSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "ELEMENT_TYPE_KEY = ?, " + "SHARED = ?, " + "LANG_CODE = ?, "
			+ "TRANS = ? WHERE DIGITAL_NAME_PART_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.DIGITAL_NAME_PARTS WHERE DIGITAL_NAME_PART_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.DIGITAL_NAME_PARTS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int DigitalNamePartPid;
	private boolean IsSystem;
	private short ElementTypeKey;
	private int Shared;
	private String LangCode;
	private String Trans;
	private DigitalNameParts model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public DigitalNameParts() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param DigitalNamePartPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public DigitalNameParts(int DigitalNamePartPid) throws SQLException {
		super();
		this.DigitalNamePartPid = DigitalNamePartPid;
	}

	@Override
	public void delete() throws SQLException {
		ps = conn.prepareStatement(DELETEALL);
		ps.executeUpdate();
	}

	@Override
	public void delete(int key) throws SQLException {
		ps = conn.prepareStatement(DELETE);
		ps.setInt(1, key);
		ps.executeUpdate();
	}

	@Override
	public List<AbstractHreDataModel> get() throws SQLException {
		ps = conn.prepareStatement(SELECTALL);
		rs = ps.executeQuery();
		modelList = new ArrayList<AbstractHreDataModel>();
		while (rs.next()) {
			model = new DigitalNameParts();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setDigitalNamePartPid(rs.getInt("DIGITAL_NAME_PART_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
			model.setShared(rs.getInt("SHARED"));
			model.setLangCode(rs.getString("LANG_CODE"));
			model.setTrans(rs.getString("TRANS"));
			modelList.add(model);
		}
		return modelList;
	}

	@Override
	public AbstractHreDataModel get(int key) throws SQLException {
		ps = conn.prepareStatement(SELECT);
		ps.setInt(1, key);
		rs = ps.executeQuery();
		if (rs.next()) {
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setDigitalNamePartPid(rs.getInt("DIGITAL_NAME_PART_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
			model.setShared(rs.getInt("SHARED"));
			model.setLangCode(rs.getString("LANG_CODE"));
			model.setTrans(rs.getString("TRANS"));
		}
		return this;
	}

	/**
	 * Get the CommitPid field.
	 *
	 * @return Contents of the COMMIT_PID column
	 */
	public int getCommitPid() {
		return this.CommitPid;
	}

	/**
	 * Get the DigitalNamePartPid field.
	 *
	 * @return Contents of the DIGITAL_NAME_PART_PID column
	 */
	public int getDigitalNamePartPid() {
		return this.DigitalNamePartPid;
	}

	/**
	 * Get the ElementTypeKey field.
	 *
	 * @return Contents of the ELEMENT_TYPE_KEY column
	 */
	public short getElementTypeKey() {
		return this.ElementTypeKey;
	}

	/**
	 * Get the IsSystem field.
	 *
	 * @return Contents of the IS_SYSTEM column
	 */
	public boolean getIsSystem() {
		return this.IsSystem;
	}

	/**
	 * Get the LangCode field.
	 *
	 * @return Contents of the LANG_CODE column
	 */
	public String getLangCode() {
		return this.LangCode;
	}

	/**
	 * Get the RecordNum field.
	 *
	 * @return Contents of the RECORD_NUM column
	 */
	public int getRecordNum() {
		return this.RecordNum;
	}

	/**
	 * Get the SetKey field.
	 *
	 * @return Contents of the SET_KEY column
	 */
	public short getSetKey() {
		return this.SetKey;
	}

	/**
	 * Get the Shared field.
	 *
	 * @return Contents of the SHARED column
	 */
	public int getShared() {
		return this.Shared;
	}

	/**
	 * Get the Trans field.
	 *
	 * @return Contents of the TRANS column
	 */
	public String getTrans() {
		return this.Trans;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((DigitalNameParts) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((DigitalNameParts) model).setSetKey(rs.getShort("SET_KEY"));
		((DigitalNameParts) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((DigitalNameParts) model).setDigitalNamePartPid(rs.getInt("DIGITAL_NAME_PART_PID"));
		((DigitalNameParts) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((DigitalNameParts) model).setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
		((DigitalNameParts) model).setShared(rs.getInt("SHARED"));
		((DigitalNameParts) model).setLangCode(rs.getString("LANG_CODE"));
		((DigitalNameParts) model).setTrans(rs.getString("TRANS"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((DigitalNameParts) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((DigitalNameParts) model).setSetKey(rs.getShort("SET_KEY"));
		((DigitalNameParts) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((DigitalNameParts) model).setDigitalNamePartPid(rs.getInt("DIGITAL_NAME_PART_PID"));
		((DigitalNameParts) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((DigitalNameParts) model).setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
		((DigitalNameParts) model).setShared(rs.getInt("SHARED"));
		((DigitalNameParts) model).setLangCode(rs.getString("LANG_CODE"));
		((DigitalNameParts) model).setTrans(rs.getString("TRANS"));
		ps.executeUpdate();
	}

	/**
	 * Set the CommitPid field
	 *
	 * @param CommitPid
	 *            Contents of the COMMIT_PID column
	 */
	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	/**
	 * Set the DigitalNamePartPid field
	 *
	 * @param DigitalNamePartPid
	 *            Contents of the DIGITAL_NAME_PART_PID column
	 */
	public void setDigitalNamePartPid(int DigitalNamePartPid) {
		this.DigitalNamePartPid = DigitalNamePartPid;
	}

	/**
	 * Set the ElementTypeKey field
	 *
	 * @param ElementTypeKey
	 *            Contents of the ELEMENT_TYPE_KEY column
	 */
	public void setElementTypeKey(short ElementTypeKey) {
		this.ElementTypeKey = ElementTypeKey;
	}

	/**
	 * Set the IsSystem field
	 *
	 * @param IsSystem
	 *            Contents of the IS_SYSTEM column
	 */
	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	/**
	 * Set the LangCode field
	 *
	 * @param LangCode
	 *            Contents of the LANG_CODE column
	 */
	public void setLangCode(String LangCode) {
		this.LangCode = LangCode;
	}

	/**
	 * Set the RecordNum field
	 *
	 * @param RecordNum
	 *            Contents of the RECORD_NUM column
	 */
	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	/**
	 * Set the SetKey field
	 *
	 * @param SetKey
	 *            Contents of the SET_KEY column
	 */
	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	/**
	 * Set the Shared field
	 *
	 * @param Shared
	 *            Contents of the SHARED column
	 */
	public void setShared(int Shared) {
		this.Shared = Shared;
	}

	/**
	 * Set the Trans field
	 *
	 * @param Trans
	 *            Contents of the TRANS column
	 */
	public void setTrans(String Trans) {
		this.Trans = Trans;
	}

}
