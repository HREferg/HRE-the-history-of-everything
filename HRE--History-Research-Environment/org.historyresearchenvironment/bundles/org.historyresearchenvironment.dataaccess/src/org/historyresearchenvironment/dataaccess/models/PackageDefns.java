package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the PACKAGE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class PackageDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "PACKAGE_DEFN_PID, " + "IS_NATIVE, " + "VERSON_NAME, " + "PARENT_SCHEMA_KEY, " + "REMINDER_KEY, "
			+ "IS_MAIN_PCKG, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.PACKAGE_DEFNS WHERE PACKAGE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "PACKAGE_DEFN_PID, " + "IS_NATIVE, " + "VERSON_NAME, " + "PARENT_SCHEMA_KEY, " + "REMINDER_KEY, "
			+ "IS_MAIN_PCKG, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.PACKAGE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.PACKAGE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "PACKAGE_DEFN_PID, " + "IS_NATIVE, " + "VERSON_NAME, " + "PARENT_SCHEMA_KEY, "
			+ "REMINDER_KEY, " + "IS_MAIN_PCKG, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.PACKAGE_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_NATIVE = ?, " + "VERSON_NAME = ?, " + "PARENT_SCHEMA_KEY = ?, "
			+ "REMINDER_KEY = ?, " + "IS_MAIN_PCKG = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE PACKAGE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.PACKAGE_DEFNS WHERE PACKAGE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.PACKAGE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int PackageDefnPid;
	private boolean IsNative;
	private String VersonName;
	private short ParentSchemaKey;
	private short ReminderKey;
	private boolean IsMainPckg;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private PackageDefns model;

	public PackageDefns() throws SQLException {
	}

	public PackageDefns(int PackageDefnPid) throws SQLException {
		super();
		this.PackageDefnPid = PackageDefnPid;
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
			model = new PackageDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setPackageDefnPid(rs.getInt("PACKAGE_DEFN_PID"));
			model.setIsNative(rs.getBoolean("IS_NATIVE"));
			model.setVersonName(rs.getString("VERSON_NAME"));
			model.setParentSchemaKey(rs.getShort("PARENT_SCHEMA_KEY"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setIsMainPckg(rs.getBoolean("IS_MAIN_PCKG"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
			model.setShow(rs.getBoolean("SHOW"));
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
			model.setPackageDefnPid(rs.getInt("PACKAGE_DEFN_PID"));
			model.setIsNative(rs.getBoolean("IS_NATIVE"));
			model.setVersonName(rs.getString("VERSON_NAME"));
			model.setParentSchemaKey(rs.getShort("PARENT_SCHEMA_KEY"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setIsMainPckg(rs.getBoolean("IS_MAIN_PCKG"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
			model.setShow(rs.getBoolean("SHOW"));
		}
		return this;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public short getDisplayOrder() {
		return this.DisplayOrder;
	}

	public boolean getIsDefault() {
		return this.IsDefault;
	}

	public boolean getIsMainPckg() {
		return this.IsMainPckg;
	}

	public boolean getIsNative() {
		return this.IsNative;
	}

	public int getPackageDefnPid() {
		return this.PackageDefnPid;
	}

	public short getParentSchemaKey() {
		return this.ParentSchemaKey;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getReminderKey() {
		return this.ReminderKey;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public boolean getShow() {
		return this.Show;
	}

	public String getVersonName() {
		return this.VersonName;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((PackageDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((PackageDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((PackageDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((PackageDefns) model).setPackageDefnPid(rs.getInt("PACKAGE_DEFN_PID"));
		((PackageDefns) model).setIsNative(rs.getBoolean("IS_NATIVE"));
		((PackageDefns) model).setVersonName(rs.getString("VERSON_NAME"));
		((PackageDefns) model).setParentSchemaKey(rs.getShort("PARENT_SCHEMA_KEY"));
		((PackageDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((PackageDefns) model).setIsMainPckg(rs.getBoolean("IS_MAIN_PCKG"));
		((PackageDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((PackageDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((PackageDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((PackageDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((PackageDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((PackageDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((PackageDefns) model).setPackageDefnPid(rs.getInt("PACKAGE_DEFN_PID"));
		((PackageDefns) model).setIsNative(rs.getBoolean("IS_NATIVE"));
		((PackageDefns) model).setVersonName(rs.getString("VERSON_NAME"));
		((PackageDefns) model).setParentSchemaKey(rs.getShort("PARENT_SCHEMA_KEY"));
		((PackageDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((PackageDefns) model).setIsMainPckg(rs.getBoolean("IS_MAIN_PCKG"));
		((PackageDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((PackageDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((PackageDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
	}

	public void setIsMainPckg(boolean IsMainPckg) {
		this.IsMainPckg = IsMainPckg;
	}

	public void setIsNative(boolean IsNative) {
		this.IsNative = IsNative;
	}

	public void setPackageDefnPid(int PackageDefnPid) {
		this.PackageDefnPid = PackageDefnPid;
	}

	public void setParentSchemaKey(short ParentSchemaKey) {
		this.ParentSchemaKey = ParentSchemaKey;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setReminderKey(short ReminderKey) {
		this.ReminderKey = ReminderKey;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setShow(boolean Show) {
		this.Show = Show;
	}

	public void setVersonName(String VersonName) {
		this.VersonName = VersonName;
	}

}
