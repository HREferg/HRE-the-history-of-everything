package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the HDATE_MODIFIER_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class HdateModifierDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "HDATE_MODIFIER_DEFN_PID, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.HDATE_MODIFIER_DEFNS WHERE HDATE_MODIFIER_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "HDATE_MODIFIER_DEFN_PID, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.HDATE_MODIFIER_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.HDATE_MODIFIER_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "HDATE_MODIFIER_DEFN_PID, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.HDATE_MODIFIER_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE HDATE_MODIFIER_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.HDATE_MODIFIER_DEFNS WHERE HDATE_MODIFIER_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.HDATE_MODIFIER_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int HdateModifierDefnPid;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private HdateModifierDefns model;

	public HdateModifierDefns() throws SQLException {
	}

	public HdateModifierDefns(int HdateModifierDefnPid) throws SQLException {
		super();
		this.HdateModifierDefnPid = HdateModifierDefnPid;
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
			model = new HdateModifierDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setHdateModifierDefnPid(rs.getInt("HDATE_MODIFIER_DEFN_PID"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
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
			model.setHdateModifierDefnPid(rs.getInt("HDATE_MODIFIER_DEFN_PID"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
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

	public int getHdateModifierDefnPid() {
		return this.HdateModifierDefnPid;
	}

	public boolean getIsDefault() {
		return this.IsDefault;
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

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((HdateModifierDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((HdateModifierDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((HdateModifierDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((HdateModifierDefns) model).setHdateModifierDefnPid(rs.getInt("HDATE_MODIFIER_DEFN_PID"));
		((HdateModifierDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((HdateModifierDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((HdateModifierDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((HdateModifierDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((HdateModifierDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((HdateModifierDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((HdateModifierDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((HdateModifierDefns) model).setHdateModifierDefnPid(rs.getInt("HDATE_MODIFIER_DEFN_PID"));
		((HdateModifierDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((HdateModifierDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((HdateModifierDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((HdateModifierDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setHdateModifierDefnPid(int HdateModifierDefnPid) {
		this.HdateModifierDefnPid = HdateModifierDefnPid;
	}

	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
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

}
