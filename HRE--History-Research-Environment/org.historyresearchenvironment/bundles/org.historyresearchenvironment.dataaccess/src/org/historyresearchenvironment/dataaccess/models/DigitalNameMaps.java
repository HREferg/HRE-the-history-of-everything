package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the DIGITAL_NAME_MAPS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class DigitalNameMaps extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "DIGITAL_NAME_MAP_PID, " + "IS_SYSTEM, " + "PARENT_NAME_PID, " + "PARENT_SUB_TYPE_KEY, "
			+ "ELEMENT_TYPE_KEY, " + "SHARED, "
			+ "INFERRED_SHARED FROM PUBLIC.DIGITAL_NAME_MAPS WHERE DIGITAL_NAME_MAP_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "DIGITAL_NAME_MAP_PID, " + "IS_SYSTEM, " + "PARENT_NAME_PID, " + "PARENT_SUB_TYPE_KEY, "
			+ "ELEMENT_TYPE_KEY, " + "SHARED, " + "INFERRED_SHARED FROM PUBLIC.DIGITAL_NAME_MAPS";

	private static final String INSERT = "INSERT INTO PUBLIC.DIGITAL_NAME_MAPS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "DIGITAL_NAME_MAP_PID, " + "IS_SYSTEM, " + "PARENT_NAME_PID, " + "PARENT_SUB_TYPE_KEY, "
			+ "ELEMENT_TYPE_KEY, " + "SHARED, " + "INFERRED_SHARED) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.DIGITAL_NAME_MAPSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PARENT_NAME_PID = ?, " + "PARENT_SUB_TYPE_KEY = ?, "
			+ "ELEMENT_TYPE_KEY = ?, " + "SHARED = ?, " + "INFERRED_SHARED = ? WHERE DIGITAL_NAME_MAP_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.DIGITAL_NAME_MAPS WHERE DIGITAL_NAME_MAP_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.DIGITAL_NAME_MAPS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int DigitalNameMapPid;
	private boolean IsSystem;
	private int ParentNamePid;
	private short ParentSubTypeKey;
	private int ElementTypeKey;
	private int Shared;
	private int InferredShared;
	private DigitalNameMaps model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public DigitalNameMaps() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param DigitalNameMapPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public DigitalNameMaps(int DigitalNameMapPid) throws SQLException {
		super();
		this.DigitalNameMapPid = DigitalNameMapPid;
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
			model = new DigitalNameMaps();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setDigitalNameMapPid(rs.getInt("DIGITAL_NAME_MAP_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentNamePid(rs.getInt("PARENT_NAME_PID"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setElementTypeKey(rs.getInt("ELEMENT_TYPE_KEY"));
			model.setShared(rs.getInt("SHARED"));
			model.setInferredShared(rs.getInt("INFERRED_SHARED"));
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
			model.setDigitalNameMapPid(rs.getInt("DIGITAL_NAME_MAP_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentNamePid(rs.getInt("PARENT_NAME_PID"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setElementTypeKey(rs.getInt("ELEMENT_TYPE_KEY"));
			model.setShared(rs.getInt("SHARED"));
			model.setInferredShared(rs.getInt("INFERRED_SHARED"));
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
	 * Get the DigitalNameMapPid field.
	 *
	 * @return Contents of the DIGITAL_NAME_MAP_PID column
	 */
	public int getDigitalNameMapPid() {
		return this.DigitalNameMapPid;
	}

	/**
	 * Get the ElementTypeKey field.
	 *
	 * @return Contents of the ELEMENT_TYPE_KEY column
	 */
	public int getElementTypeKey() {
		return this.ElementTypeKey;
	}

	/**
	 * Get the InferredShared field.
	 *
	 * @return Contents of the INFERRED_SHARED column
	 */
	public int getInferredShared() {
		return this.InferredShared;
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
	 * Get the ParentNamePid field.
	 *
	 * @return Contents of the PARENT_NAME_PID column
	 */
	public int getParentNamePid() {
		return this.ParentNamePid;
	}

	/**
	 * Get the ParentSubTypeKey field.
	 *
	 * @return Contents of the PARENT_SUB_TYPE_KEY column
	 */
	public short getParentSubTypeKey() {
		return this.ParentSubTypeKey;
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

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((DigitalNameMaps) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((DigitalNameMaps) model).setSetKey(rs.getShort("SET_KEY"));
		((DigitalNameMaps) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((DigitalNameMaps) model).setDigitalNameMapPid(rs.getInt("DIGITAL_NAME_MAP_PID"));
		((DigitalNameMaps) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((DigitalNameMaps) model).setParentNamePid(rs.getInt("PARENT_NAME_PID"));
		((DigitalNameMaps) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((DigitalNameMaps) model).setElementTypeKey(rs.getInt("ELEMENT_TYPE_KEY"));
		((DigitalNameMaps) model).setShared(rs.getInt("SHARED"));
		((DigitalNameMaps) model).setInferredShared(rs.getInt("INFERRED_SHARED"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((DigitalNameMaps) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((DigitalNameMaps) model).setSetKey(rs.getShort("SET_KEY"));
		((DigitalNameMaps) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((DigitalNameMaps) model).setDigitalNameMapPid(rs.getInt("DIGITAL_NAME_MAP_PID"));
		((DigitalNameMaps) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((DigitalNameMaps) model).setParentNamePid(rs.getInt("PARENT_NAME_PID"));
		((DigitalNameMaps) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((DigitalNameMaps) model).setElementTypeKey(rs.getInt("ELEMENT_TYPE_KEY"));
		((DigitalNameMaps) model).setShared(rs.getInt("SHARED"));
		((DigitalNameMaps) model).setInferredShared(rs.getInt("INFERRED_SHARED"));
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
	 * Set the DigitalNameMapPid field
	 *
	 * @param DigitalNameMapPid
	 *            Contents of the DIGITAL_NAME_MAP_PID column
	 */
	public void setDigitalNameMapPid(int DigitalNameMapPid) {
		this.DigitalNameMapPid = DigitalNameMapPid;
	}

	/**
	 * Set the ElementTypeKey field
	 *
	 * @param ElementTypeKey
	 *            Contents of the ELEMENT_TYPE_KEY column
	 */
	public void setElementTypeKey(int ElementTypeKey) {
		this.ElementTypeKey = ElementTypeKey;
	}

	/**
	 * Set the InferredShared field
	 *
	 * @param InferredShared
	 *            Contents of the INFERRED_SHARED column
	 */
	public void setInferredShared(int InferredShared) {
		this.InferredShared = InferredShared;
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
	 * Set the ParentNamePid field
	 *
	 * @param ParentNamePid
	 *            Contents of the PARENT_NAME_PID column
	 */
	public void setParentNamePid(int ParentNamePid) {
		this.ParentNamePid = ParentNamePid;
	}

	/**
	 * Set the ParentSubTypeKey field
	 *
	 * @param ParentSubTypeKey
	 *            Contents of the PARENT_SUB_TYPE_KEY column
	 */
	public void setParentSubTypeKey(short ParentSubTypeKey) {
		this.ParentSubTypeKey = ParentSubTypeKey;
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

}
