package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the LIST_OBJECTS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class ListObjects extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "LIST_OBJECT_PID, "
			+ "IS_SYSTEM, " + "PARENT_OBJ_SET_KEY, " + "USE_ORDER, " + "OBJECT_ALIAS, " + "USE_ALIAS_LABEL, "
			+ "MARGIN_LABEL, " + "LABEL_STYLE_KEY, " + "CELL_STYLE_KEY, " + "CELL_MIN_WIDTH, " + "CELL_MIN_HEIGHT, "
			+ "CELL_NOW_WIDTH, " + "CELL_NOW_HEIGHT, " + "ACCENT_KEY, "
			+ "ACCENT_ALIAS FROM PUBLIC.LIST_OBJECTS WHERE LIST_OBJECT_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "LIST_OBJECT_PID, " + "IS_SYSTEM, " + "PARENT_OBJ_SET_KEY, " + "USE_ORDER, " + "OBJECT_ALIAS, "
			+ "USE_ALIAS_LABEL, " + "MARGIN_LABEL, " + "LABEL_STYLE_KEY, " + "CELL_STYLE_KEY, " + "CELL_MIN_WIDTH, "
			+ "CELL_MIN_HEIGHT, " + "CELL_NOW_WIDTH, " + "CELL_NOW_HEIGHT, " + "ACCENT_KEY, "
			+ "ACCENT_ALIAS FROM PUBLIC.LIST_OBJECTS";

	private static final String INSERT = "INSERT INTO PUBLIC.LIST_OBJECTS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "LIST_OBJECT_PID, " + "IS_SYSTEM, " + "PARENT_OBJ_SET_KEY, " + "USE_ORDER, "
			+ "OBJECT_ALIAS, " + "USE_ALIAS_LABEL, " + "MARGIN_LABEL, " + "LABEL_STYLE_KEY, " + "CELL_STYLE_KEY, "
			+ "CELL_MIN_WIDTH, " + "CELL_MIN_HEIGHT, " + "CELL_NOW_WIDTH, " + "CELL_NOW_HEIGHT, " + "ACCENT_KEY, "
			+ "ACCENT_ALIAS) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.LIST_OBJECTSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PARENT_OBJ_SET_KEY = ?, " + "USE_ORDER = ?, "
			+ "OBJECT_ALIAS = ?, " + "USE_ALIAS_LABEL = ?, " + "MARGIN_LABEL = ?, " + "LABEL_STYLE_KEY = ?, "
			+ "CELL_STYLE_KEY = ?, " + "CELL_MIN_WIDTH = ?, " + "CELL_MIN_HEIGHT = ?, " + "CELL_NOW_WIDTH = ?, "
			+ "CELL_NOW_HEIGHT = ?, " + "ACCENT_KEY = ?, " + "ACCENT_ALIAS = ? WHERE LIST_OBJECT_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.LIST_OBJECTS WHERE LIST_OBJECT_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.LIST_OBJECTS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int ListObjectPid;
	private boolean IsSystem;
	private short ParentObjSetKey;
	private short UseOrder;
	private String ObjectAlias;
	private boolean UseAliasLabel;
	private String MarginLabel;
	private short LabelStyleKey;
	private short CellStyleKey;
	private short CellMinWidth;
	private short CellMinHeight;
	private short CellNowWidth;
	private short CellNowHeight;
	private short AccentKey;
	private String AccentAlias;
	private ListObjects model;

	public ListObjects() throws SQLException {
	}

	public ListObjects(int ListObjectPid) throws SQLException {
		super();
		this.ListObjectPid = ListObjectPid;
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
			model = new ListObjects();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setListObjectPid(rs.getInt("LIST_OBJECT_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentObjSetKey(rs.getShort("PARENT_OBJ_SET_KEY"));
			model.setUseOrder(rs.getShort("USE_ORDER"));
			model.setObjectAlias(rs.getString("OBJECT_ALIAS"));
			model.setUseAliasLabel(rs.getBoolean("USE_ALIAS_LABEL"));
			model.setMarginLabel(rs.getString("MARGIN_LABEL"));
			model.setLabelStyleKey(rs.getShort("LABEL_STYLE_KEY"));
			model.setCellStyleKey(rs.getShort("CELL_STYLE_KEY"));
			model.setCellMinWidth(rs.getShort("CELL_MIN_WIDTH"));
			model.setCellMinHeight(rs.getShort("CELL_MIN_HEIGHT"));
			model.setCellNowWidth(rs.getShort("CELL_NOW_WIDTH"));
			model.setCellNowHeight(rs.getShort("CELL_NOW_HEIGHT"));
			model.setAccentKey(rs.getShort("ACCENT_KEY"));
			model.setAccentAlias(rs.getString("ACCENT_ALIAS"));
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
			model.setListObjectPid(rs.getInt("LIST_OBJECT_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentObjSetKey(rs.getShort("PARENT_OBJ_SET_KEY"));
			model.setUseOrder(rs.getShort("USE_ORDER"));
			model.setObjectAlias(rs.getString("OBJECT_ALIAS"));
			model.setUseAliasLabel(rs.getBoolean("USE_ALIAS_LABEL"));
			model.setMarginLabel(rs.getString("MARGIN_LABEL"));
			model.setLabelStyleKey(rs.getShort("LABEL_STYLE_KEY"));
			model.setCellStyleKey(rs.getShort("CELL_STYLE_KEY"));
			model.setCellMinWidth(rs.getShort("CELL_MIN_WIDTH"));
			model.setCellMinHeight(rs.getShort("CELL_MIN_HEIGHT"));
			model.setCellNowWidth(rs.getShort("CELL_NOW_WIDTH"));
			model.setCellNowHeight(rs.getShort("CELL_NOW_HEIGHT"));
			model.setAccentKey(rs.getShort("ACCENT_KEY"));
			model.setAccentAlias(rs.getString("ACCENT_ALIAS"));
		}
		return this;
	}

	public String getAccentAlias() {
		return this.AccentAlias;
	}

	public short getAccentKey() {
		return this.AccentKey;
	}

	public short getCellMinHeight() {
		return this.CellMinHeight;
	}

	public short getCellMinWidth() {
		return this.CellMinWidth;
	}

	public short getCellNowHeight() {
		return this.CellNowHeight;
	}

	public short getCellNowWidth() {
		return this.CellNowWidth;
	}

	public short getCellStyleKey() {
		return this.CellStyleKey;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public short getLabelStyleKey() {
		return this.LabelStyleKey;
	}

	public int getListObjectPid() {
		return this.ListObjectPid;
	}

	public String getMarginLabel() {
		return this.MarginLabel;
	}

	public String getObjectAlias() {
		return this.ObjectAlias;
	}

	public short getParentObjSetKey() {
		return this.ParentObjSetKey;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public boolean getUseAliasLabel() {
		return this.UseAliasLabel;
	}

	public short getUseOrder() {
		return this.UseOrder;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((ListObjects) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((ListObjects) model).setSetKey(rs.getShort("SET_KEY"));
		((ListObjects) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((ListObjects) model).setListObjectPid(rs.getInt("LIST_OBJECT_PID"));
		((ListObjects) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((ListObjects) model).setParentObjSetKey(rs.getShort("PARENT_OBJ_SET_KEY"));
		((ListObjects) model).setUseOrder(rs.getShort("USE_ORDER"));
		((ListObjects) model).setObjectAlias(rs.getString("OBJECT_ALIAS"));
		((ListObjects) model).setUseAliasLabel(rs.getBoolean("USE_ALIAS_LABEL"));
		((ListObjects) model).setMarginLabel(rs.getString("MARGIN_LABEL"));
		((ListObjects) model).setLabelStyleKey(rs.getShort("LABEL_STYLE_KEY"));
		((ListObjects) model).setCellStyleKey(rs.getShort("CELL_STYLE_KEY"));
		((ListObjects) model).setCellMinWidth(rs.getShort("CELL_MIN_WIDTH"));
		((ListObjects) model).setCellMinHeight(rs.getShort("CELL_MIN_HEIGHT"));
		((ListObjects) model).setCellNowWidth(rs.getShort("CELL_NOW_WIDTH"));
		((ListObjects) model).setCellNowHeight(rs.getShort("CELL_NOW_HEIGHT"));
		((ListObjects) model).setAccentKey(rs.getShort("ACCENT_KEY"));
		((ListObjects) model).setAccentAlias(rs.getString("ACCENT_ALIAS"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((ListObjects) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((ListObjects) model).setSetKey(rs.getShort("SET_KEY"));
		((ListObjects) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((ListObjects) model).setListObjectPid(rs.getInt("LIST_OBJECT_PID"));
		((ListObjects) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((ListObjects) model).setParentObjSetKey(rs.getShort("PARENT_OBJ_SET_KEY"));
		((ListObjects) model).setUseOrder(rs.getShort("USE_ORDER"));
		((ListObjects) model).setObjectAlias(rs.getString("OBJECT_ALIAS"));
		((ListObjects) model).setUseAliasLabel(rs.getBoolean("USE_ALIAS_LABEL"));
		((ListObjects) model).setMarginLabel(rs.getString("MARGIN_LABEL"));
		((ListObjects) model).setLabelStyleKey(rs.getShort("LABEL_STYLE_KEY"));
		((ListObjects) model).setCellStyleKey(rs.getShort("CELL_STYLE_KEY"));
		((ListObjects) model).setCellMinWidth(rs.getShort("CELL_MIN_WIDTH"));
		((ListObjects) model).setCellMinHeight(rs.getShort("CELL_MIN_HEIGHT"));
		((ListObjects) model).setCellNowWidth(rs.getShort("CELL_NOW_WIDTH"));
		((ListObjects) model).setCellNowHeight(rs.getShort("CELL_NOW_HEIGHT"));
		((ListObjects) model).setAccentKey(rs.getShort("ACCENT_KEY"));
		((ListObjects) model).setAccentAlias(rs.getString("ACCENT_ALIAS"));
		ps.executeUpdate();
	}

	public void setAccentAlias(String AccentAlias) {
		this.AccentAlias = AccentAlias;
	}

	public void setAccentKey(short AccentKey) {
		this.AccentKey = AccentKey;
	}

	public void setCellMinHeight(short CellMinHeight) {
		this.CellMinHeight = CellMinHeight;
	}

	public void setCellMinWidth(short CellMinWidth) {
		this.CellMinWidth = CellMinWidth;
	}

	public void setCellNowHeight(short CellNowHeight) {
		this.CellNowHeight = CellNowHeight;
	}

	public void setCellNowWidth(short CellNowWidth) {
		this.CellNowWidth = CellNowWidth;
	}

	public void setCellStyleKey(short CellStyleKey) {
		this.CellStyleKey = CellStyleKey;
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setLabelStyleKey(short LabelStyleKey) {
		this.LabelStyleKey = LabelStyleKey;
	}

	public void setListObjectPid(int ListObjectPid) {
		this.ListObjectPid = ListObjectPid;
	}

	public void setMarginLabel(String MarginLabel) {
		this.MarginLabel = MarginLabel;
	}

	public void setObjectAlias(String ObjectAlias) {
		this.ObjectAlias = ObjectAlias;
	}

	public void setParentObjSetKey(short ParentObjSetKey) {
		this.ParentObjSetKey = ParentObjSetKey;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setUseAliasLabel(boolean UseAliasLabel) {
		this.UseAliasLabel = UseAliasLabel;
	}

	public void setUseOrder(short UseOrder) {
		this.UseOrder = UseOrder;
	}

}
