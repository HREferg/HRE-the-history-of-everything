package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the OCCASN_NAME_MAPS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class OccasnNameMaps extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_NAME_MAP_PID, " + "IS_SYSTEM, " + "PARENT_NAME_PID, " + "PARENT_SUB_TYPE_KEY, "
			+ "ELEMENT_TYPE_KEY, " + "SHARED, "
			+ "INFERRED_SHARED FROM PUBLIC.OCCASN_NAME_MAPS WHERE OCCASN_NAME_MAP_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "OCCASN_NAME_MAP_PID, " + "IS_SYSTEM, " + "PARENT_NAME_PID, " + "PARENT_SUB_TYPE_KEY, "
			+ "ELEMENT_TYPE_KEY, " + "SHARED, " + "INFERRED_SHARED FROM PUBLIC.OCCASN_NAME_MAPS";

	private static final String INSERT = "INSERT INTO PUBLIC.OCCASN_NAME_MAPS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "OCCASN_NAME_MAP_PID, " + "IS_SYSTEM, " + "PARENT_NAME_PID, " + "PARENT_SUB_TYPE_KEY, "
			+ "ELEMENT_TYPE_KEY, " + "SHARED, " + "INFERRED_SHARED) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.OCCASN_NAME_MAPSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PARENT_NAME_PID = ?, " + "PARENT_SUB_TYPE_KEY = ?, "
			+ "ELEMENT_TYPE_KEY = ?, " + "SHARED = ?, " + "INFERRED_SHARED = ? WHERE OCCASN_NAME_MAP_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.OCCASN_NAME_MAPS WHERE OCCASN_NAME_MAP_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.OCCASN_NAME_MAPS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int OccasnNameMapPid;
	private boolean IsSystem;
	private int ParentNamePid;
	private short ParentSubTypeKey;
	private short ElementTypeKey;
	private int Shared;
	private int InferredShared;
	private OccasnNameMaps model;

	public OccasnNameMaps() throws SQLException {
	}

	public OccasnNameMaps(int OccasnNameMapPid) throws SQLException {
		super();
		this.OccasnNameMapPid = OccasnNameMapPid;
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
			model = new OccasnNameMaps();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setOccasnNameMapPid(rs.getInt("OCCASN_NAME_MAP_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentNamePid(rs.getInt("PARENT_NAME_PID"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
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
			model.setOccasnNameMapPid(rs.getInt("OCCASN_NAME_MAP_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentNamePid(rs.getInt("PARENT_NAME_PID"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
			model.setShared(rs.getInt("SHARED"));
			model.setInferredShared(rs.getInt("INFERRED_SHARED"));
		}
		return this;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public short getElementTypeKey() {
		return this.ElementTypeKey;
	}

	public int getInferredShared() {
		return this.InferredShared;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public int getOccasnNameMapPid() {
		return this.OccasnNameMapPid;
	}

	public int getParentNamePid() {
		return this.ParentNamePid;
	}

	public short getParentSubTypeKey() {
		return this.ParentSubTypeKey;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public int getShared() {
		return this.Shared;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((OccasnNameMaps) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((OccasnNameMaps) model).setSetKey(rs.getShort("SET_KEY"));
		((OccasnNameMaps) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((OccasnNameMaps) model).setOccasnNameMapPid(rs.getInt("OCCASN_NAME_MAP_PID"));
		((OccasnNameMaps) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((OccasnNameMaps) model).setParentNamePid(rs.getInt("PARENT_NAME_PID"));
		((OccasnNameMaps) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((OccasnNameMaps) model).setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
		((OccasnNameMaps) model).setShared(rs.getInt("SHARED"));
		((OccasnNameMaps) model).setInferredShared(rs.getInt("INFERRED_SHARED"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((OccasnNameMaps) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((OccasnNameMaps) model).setSetKey(rs.getShort("SET_KEY"));
		((OccasnNameMaps) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((OccasnNameMaps) model).setOccasnNameMapPid(rs.getInt("OCCASN_NAME_MAP_PID"));
		((OccasnNameMaps) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((OccasnNameMaps) model).setParentNamePid(rs.getInt("PARENT_NAME_PID"));
		((OccasnNameMaps) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((OccasnNameMaps) model).setElementTypeKey(rs.getShort("ELEMENT_TYPE_KEY"));
		((OccasnNameMaps) model).setShared(rs.getInt("SHARED"));
		((OccasnNameMaps) model).setInferredShared(rs.getInt("INFERRED_SHARED"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setElementTypeKey(short ElementTypeKey) {
		this.ElementTypeKey = ElementTypeKey;
	}

	public void setInferredShared(int InferredShared) {
		this.InferredShared = InferredShared;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setOccasnNameMapPid(int OccasnNameMapPid) {
		this.OccasnNameMapPid = OccasnNameMapPid;
	}

	public void setParentNamePid(int ParentNamePid) {
		this.ParentNamePid = ParentNamePid;
	}

	public void setParentSubTypeKey(short ParentSubTypeKey) {
		this.ParentSubTypeKey = ParentSubTypeKey;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setShared(int Shared) {
		this.Shared = Shared;
	}

}
