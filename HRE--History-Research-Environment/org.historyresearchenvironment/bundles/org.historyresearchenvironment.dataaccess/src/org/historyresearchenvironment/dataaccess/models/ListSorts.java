package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the LIST_SORTS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class ListSorts extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "LIST_SORT_PID, "
			+ "IS_SYSTEM, " + "PARENT_SORT_SET_KEY, " + "USE_ORDER, " + "SORT_ALIAS, " + "SORT_HIGH_LAST, "
			+ "EMPTY_SORT_HIGH FROM PUBLIC.LIST_SORTS WHERE LIST_SORT_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "LIST_SORT_PID, " + "IS_SYSTEM, " + "PARENT_SORT_SET_KEY, " + "USE_ORDER, " + "SORT_ALIAS, "
			+ "SORT_HIGH_LAST, " + "EMPTY_SORT_HIGH FROM PUBLIC.LIST_SORTS";

	private static final String INSERT = "INSERT INTO PUBLIC.LIST_SORTS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "LIST_SORT_PID, " + "IS_SYSTEM, " + "PARENT_SORT_SET_KEY, " + "USE_ORDER, "
			+ "SORT_ALIAS, " + "SORT_HIGH_LAST, " + "EMPTY_SORT_HIGH) VALUES (?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.LIST_SORTSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PARENT_SORT_SET_KEY = ?, " + "USE_ORDER = ?, "
			+ "SORT_ALIAS = ?, " + "SORT_HIGH_LAST = ?, " + "EMPTY_SORT_HIGH = ? WHERE LIST_SORT_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.LIST_SORTS WHERE LIST_SORT_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.LIST_SORTS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int ListSortPid;
	private boolean IsSystem;
	private short ParentSortSetKey;
	private short UseOrder;
	private String SortAlias;
	private boolean SortHighLast;
	private boolean EmptySortHigh;
	private ListSorts model;

	public ListSorts() throws SQLException {
	}

	public ListSorts(int ListSortPid) throws SQLException {
		super();
		this.ListSortPid = ListSortPid;
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
			model = new ListSorts();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setListSortPid(rs.getInt("LIST_SORT_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentSortSetKey(rs.getShort("PARENT_SORT_SET_KEY"));
			model.setUseOrder(rs.getShort("USE_ORDER"));
			model.setSortAlias(rs.getString("SORT_ALIAS"));
			model.setSortHighLast(rs.getBoolean("SORT_HIGH_LAST"));
			model.setEmptySortHigh(rs.getBoolean("EMPTY_SORT_HIGH"));
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
			model.setListSortPid(rs.getInt("LIST_SORT_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentSortSetKey(rs.getShort("PARENT_SORT_SET_KEY"));
			model.setUseOrder(rs.getShort("USE_ORDER"));
			model.setSortAlias(rs.getString("SORT_ALIAS"));
			model.setSortHighLast(rs.getBoolean("SORT_HIGH_LAST"));
			model.setEmptySortHigh(rs.getBoolean("EMPTY_SORT_HIGH"));
		}
		return this;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public boolean getEmptySortHigh() {
		return this.EmptySortHigh;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public int getListSortPid() {
		return this.ListSortPid;
	}

	public short getParentSortSetKey() {
		return this.ParentSortSetKey;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public String getSortAlias() {
		return this.SortAlias;
	}

	public boolean getSortHighLast() {
		return this.SortHighLast;
	}

	public short getUseOrder() {
		return this.UseOrder;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((ListSorts) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((ListSorts) model).setSetKey(rs.getShort("SET_KEY"));
		((ListSorts) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((ListSorts) model).setListSortPid(rs.getInt("LIST_SORT_PID"));
		((ListSorts) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((ListSorts) model).setParentSortSetKey(rs.getShort("PARENT_SORT_SET_KEY"));
		((ListSorts) model).setUseOrder(rs.getShort("USE_ORDER"));
		((ListSorts) model).setSortAlias(rs.getString("SORT_ALIAS"));
		((ListSorts) model).setSortHighLast(rs.getBoolean("SORT_HIGH_LAST"));
		((ListSorts) model).setEmptySortHigh(rs.getBoolean("EMPTY_SORT_HIGH"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((ListSorts) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((ListSorts) model).setSetKey(rs.getShort("SET_KEY"));
		((ListSorts) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((ListSorts) model).setListSortPid(rs.getInt("LIST_SORT_PID"));
		((ListSorts) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((ListSorts) model).setParentSortSetKey(rs.getShort("PARENT_SORT_SET_KEY"));
		((ListSorts) model).setUseOrder(rs.getShort("USE_ORDER"));
		((ListSorts) model).setSortAlias(rs.getString("SORT_ALIAS"));
		((ListSorts) model).setSortHighLast(rs.getBoolean("SORT_HIGH_LAST"));
		((ListSorts) model).setEmptySortHigh(rs.getBoolean("EMPTY_SORT_HIGH"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setEmptySortHigh(boolean EmptySortHigh) {
		this.EmptySortHigh = EmptySortHigh;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setListSortPid(int ListSortPid) {
		this.ListSortPid = ListSortPid;
	}

	public void setParentSortSetKey(short ParentSortSetKey) {
		this.ParentSortSetKey = ParentSortSetKey;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setSortAlias(String SortAlias) {
		this.SortAlias = SortAlias;
	}

	public void setSortHighLast(boolean SortHighLast) {
		this.SortHighLast = SortHighLast;
	}

	public void setUseOrder(short UseOrder) {
		this.UseOrder = UseOrder;
	}

}
