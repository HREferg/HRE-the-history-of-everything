package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the CITN_TYPE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class CitnTypeDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "CITN_TYPE_DEFN_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, " + "VIEW_DATA_SCRIPT_PID, "
			+ "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, " + "DELETE_DATA_SCRIPT_GROUP_KEY, "
			+ "DELETE_DATA_SCRIPT_PID, " + "CITING_TYPE_KEY, " + "CITING_SUB_TYPE_KEY, " + "GEDCOM_TAG, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.CITN_TYPE_DEFNS WHERE CITN_TYPE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "CITN_TYPE_DEFN_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, " + "VIEW_DATA_SCRIPT_PID, "
			+ "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, " + "DELETE_DATA_SCRIPT_GROUP_KEY, "
			+ "DELETE_DATA_SCRIPT_PID, " + "CITING_TYPE_KEY, " + "CITING_SUB_TYPE_KEY, " + "GEDCOM_TAG, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, " + "SHOW FROM PUBLIC.CITN_TYPE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.CITN_TYPE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "CITN_TYPE_DEFN_PID, " + "IS_SYSTEM, " + "VIEW_DATA_SCRIPT_GROUP_KEY, "
			+ "VIEW_DATA_SCRIPT_PID, " + "MODIFY_DATA_SCRIPT_GROUP_KEY, " + "MODIFY_DATA_SCRIPT_PID, "
			+ "DELETE_DATA_SCRIPT_GROUP_KEY, " + "DELETE_DATA_SCRIPT_PID, " + "CITING_TYPE_KEY, "
			+ "CITING_SUB_TYPE_KEY, " + "GEDCOM_TAG, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.CITN_TYPE_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "VIEW_DATA_SCRIPT_GROUP_KEY = ?, " + "VIEW_DATA_SCRIPT_PID = ?, "
			+ "MODIFY_DATA_SCRIPT_GROUP_KEY = ?, " + "MODIFY_DATA_SCRIPT_PID = ?, "
			+ "DELETE_DATA_SCRIPT_GROUP_KEY = ?, " + "DELETE_DATA_SCRIPT_PID = ?, " + "CITING_TYPE_KEY = ?, "
			+ "CITING_SUB_TYPE_KEY = ?, " + "GEDCOM_TAG = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, "
			+ "IS_DEFAULT = ?, " + "SHOW = ? WHERE CITN_TYPE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.CITN_TYPE_DEFNS WHERE CITN_TYPE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.CITN_TYPE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int CitnTypeDefnPid;
	private boolean IsSystem;
	private short ViewDataScriptGroupKey;
	private int ViewDataScriptPid;
	private short ModifyDataScriptGroupKey;
	private int ModifyDataScriptPid;
	private short DeleteDataScriptGroupKey;
	private int DeleteDataScriptPid;
	private short CitingTypeKey;
	private short CitingSubTypeKey;
	private String GedcomTag;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private CitnTypeDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public CitnTypeDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param CitnTypeDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public CitnTypeDefns(int CitnTypeDefnPid) throws SQLException {
		super();
		this.CitnTypeDefnPid = CitnTypeDefnPid;
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
			model = new CitnTypeDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setCitnTypeDefnPid(rs.getInt("CITN_TYPE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
			model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
			model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
			model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
			model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
			model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
			model.setCitingTypeKey(rs.getShort("CITING_TYPE_KEY"));
			model.setCitingSubTypeKey(rs.getShort("CITING_SUB_TYPE_KEY"));
			model.setGedcomTag(rs.getString("GEDCOM_TAG"));
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
			model.setCitnTypeDefnPid(rs.getInt("CITN_TYPE_DEFN_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
			model.setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
			model.setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
			model.setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
			model.setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
			model.setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
			model.setCitingTypeKey(rs.getShort("CITING_TYPE_KEY"));
			model.setCitingSubTypeKey(rs.getShort("CITING_SUB_TYPE_KEY"));
			model.setGedcomTag(rs.getString("GEDCOM_TAG"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
			model.setShow(rs.getBoolean("SHOW"));
		}
		return this;
	}

	/**
	 * Get the CitingSubTypeKey field.
	 *
	 * @return Contents of the CITING_SUB_TYPE_KEY column
	 */
	public short getCitingSubTypeKey() {
		return this.CitingSubTypeKey;
	}

	/**
	 * Get the CitingTypeKey field.
	 *
	 * @return Contents of the CITING_TYPE_KEY column
	 */
	public short getCitingTypeKey() {
		return this.CitingTypeKey;
	}

	/**
	 * Get the CitnTypeDefnPid field.
	 *
	 * @return Contents of the CITN_TYPE_DEFN_PID column
	 */
	public int getCitnTypeDefnPid() {
		return this.CitnTypeDefnPid;
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
	 * Get the DeleteDataScriptGroupKey field.
	 *
	 * @return Contents of the DELETE_DATA_SCRIPT_GROUP_KEY column
	 */
	public short getDeleteDataScriptGroupKey() {
		return this.DeleteDataScriptGroupKey;
	}

	/**
	 * Get the DeleteDataScriptPid field.
	 *
	 * @return Contents of the DELETE_DATA_SCRIPT_PID column
	 */
	public int getDeleteDataScriptPid() {
		return this.DeleteDataScriptPid;
	}

	/**
	 * Get the DisplayOrder field.
	 *
	 * @return Contents of the DISPLAY_ORDER column
	 */
	public short getDisplayOrder() {
		return this.DisplayOrder;
	}

	/**
	 * Get the GedcomTag field.
	 *
	 * @return Contents of the GEDCOM_TAG column
	 */
	public String getGedcomTag() {
		return this.GedcomTag;
	}

	/**
	 * Get the IsDefault field.
	 *
	 * @return Contents of the IS_DEFAULT column
	 */
	public boolean getIsDefault() {
		return this.IsDefault;
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
	 * Get the ModifyDataScriptGroupKey field.
	 *
	 * @return Contents of the MODIFY_DATA_SCRIPT_GROUP_KEY column
	 */
	public short getModifyDataScriptGroupKey() {
		return this.ModifyDataScriptGroupKey;
	}

	/**
	 * Get the ModifyDataScriptPid field.
	 *
	 * @return Contents of the MODIFY_DATA_SCRIPT_PID column
	 */
	public int getModifyDataScriptPid() {
		return this.ModifyDataScriptPid;
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
	 * Get the ReminderKey field.
	 *
	 * @return Contents of the REMINDER_KEY column
	 */
	public short getReminderKey() {
		return this.ReminderKey;
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
	 * Get the Show field.
	 *
	 * @return Contents of the SHOW column
	 */
	public boolean getShow() {
		return this.Show;
	}

	/**
	 * Get the ViewDataScriptGroupKey field.
	 *
	 * @return Contents of the VIEW_DATA_SCRIPT_GROUP_KEY column
	 */
	public short getViewDataScriptGroupKey() {
		return this.ViewDataScriptGroupKey;
	}

	/**
	 * Get the ViewDataScriptPid field.
	 *
	 * @return Contents of the VIEW_DATA_SCRIPT_PID column
	 */
	public int getViewDataScriptPid() {
		return this.ViewDataScriptPid;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((CitnTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((CitnTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((CitnTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((CitnTypeDefns) model).setCitnTypeDefnPid(rs.getInt("CITN_TYPE_DEFN_PID"));
		((CitnTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((CitnTypeDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
		((CitnTypeDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
		((CitnTypeDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
		((CitnTypeDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
		((CitnTypeDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
		((CitnTypeDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
		((CitnTypeDefns) model).setCitingTypeKey(rs.getShort("CITING_TYPE_KEY"));
		((CitnTypeDefns) model).setCitingSubTypeKey(rs.getShort("CITING_SUB_TYPE_KEY"));
		((CitnTypeDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
		((CitnTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((CitnTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((CitnTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((CitnTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((CitnTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((CitnTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((CitnTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((CitnTypeDefns) model).setCitnTypeDefnPid(rs.getInt("CITN_TYPE_DEFN_PID"));
		((CitnTypeDefns) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((CitnTypeDefns) model).setViewDataScriptGroupKey(rs.getShort("VIEW_DATA_SCRIPT_GROUP_KEY"));
		((CitnTypeDefns) model).setViewDataScriptPid(rs.getInt("VIEW_DATA_SCRIPT_PID"));
		((CitnTypeDefns) model).setModifyDataScriptGroupKey(rs.getShort("MODIFY_DATA_SCRIPT_GROUP_KEY"));
		((CitnTypeDefns) model).setModifyDataScriptPid(rs.getInt("MODIFY_DATA_SCRIPT_PID"));
		((CitnTypeDefns) model).setDeleteDataScriptGroupKey(rs.getShort("DELETE_DATA_SCRIPT_GROUP_KEY"));
		((CitnTypeDefns) model).setDeleteDataScriptPid(rs.getInt("DELETE_DATA_SCRIPT_PID"));
		((CitnTypeDefns) model).setCitingTypeKey(rs.getShort("CITING_TYPE_KEY"));
		((CitnTypeDefns) model).setCitingSubTypeKey(rs.getShort("CITING_SUB_TYPE_KEY"));
		((CitnTypeDefns) model).setGedcomTag(rs.getString("GEDCOM_TAG"));
		((CitnTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((CitnTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((CitnTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((CitnTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	/**
	 * Set the CitingSubTypeKey field
	 *
	 * @param CitingSubTypeKey
	 *            Contents of the CITING_SUB_TYPE_KEY column
	 */
	public void setCitingSubTypeKey(short CitingSubTypeKey) {
		this.CitingSubTypeKey = CitingSubTypeKey;
	}

	/**
	 * Set the CitingTypeKey field
	 *
	 * @param CitingTypeKey
	 *            Contents of the CITING_TYPE_KEY column
	 */
	public void setCitingTypeKey(short CitingTypeKey) {
		this.CitingTypeKey = CitingTypeKey;
	}

	/**
	 * Set the CitnTypeDefnPid field
	 *
	 * @param CitnTypeDefnPid
	 *            Contents of the CITN_TYPE_DEFN_PID column
	 */
	public void setCitnTypeDefnPid(int CitnTypeDefnPid) {
		this.CitnTypeDefnPid = CitnTypeDefnPid;
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
	 * Set the DeleteDataScriptGroupKey field
	 *
	 * @param DeleteDataScriptGroupKey
	 *            Contents of the DELETE_DATA_SCRIPT_GROUP_KEY column
	 */
	public void setDeleteDataScriptGroupKey(short DeleteDataScriptGroupKey) {
		this.DeleteDataScriptGroupKey = DeleteDataScriptGroupKey;
	}

	/**
	 * Set the DeleteDataScriptPid field
	 *
	 * @param DeleteDataScriptPid
	 *            Contents of the DELETE_DATA_SCRIPT_PID column
	 */
	public void setDeleteDataScriptPid(int DeleteDataScriptPid) {
		this.DeleteDataScriptPid = DeleteDataScriptPid;
	}

	/**
	 * Set the DisplayOrder field
	 *
	 * @param DisplayOrder
	 *            Contents of the DISPLAY_ORDER column
	 */
	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	/**
	 * Set the GedcomTag field
	 *
	 * @param GedcomTag
	 *            Contents of the GEDCOM_TAG column
	 */
	public void setGedcomTag(String GedcomTag) {
		this.GedcomTag = GedcomTag;
	}

	/**
	 * Set the IsDefault field
	 *
	 * @param IsDefault
	 *            Contents of the IS_DEFAULT column
	 */
	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
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
	 * Set the ModifyDataScriptGroupKey field
	 *
	 * @param ModifyDataScriptGroupKey
	 *            Contents of the MODIFY_DATA_SCRIPT_GROUP_KEY column
	 */
	public void setModifyDataScriptGroupKey(short ModifyDataScriptGroupKey) {
		this.ModifyDataScriptGroupKey = ModifyDataScriptGroupKey;
	}

	/**
	 * Set the ModifyDataScriptPid field
	 *
	 * @param ModifyDataScriptPid
	 *            Contents of the MODIFY_DATA_SCRIPT_PID column
	 */
	public void setModifyDataScriptPid(int ModifyDataScriptPid) {
		this.ModifyDataScriptPid = ModifyDataScriptPid;
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
	 * Set the ReminderKey field
	 *
	 * @param ReminderKey
	 *            Contents of the REMINDER_KEY column
	 */
	public void setReminderKey(short ReminderKey) {
		this.ReminderKey = ReminderKey;
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
	 * Set the Show field
	 *
	 * @param Show
	 *            Contents of the SHOW column
	 */
	public void setShow(boolean Show) {
		this.Show = Show;
	}

	/**
	 * Set the ViewDataScriptGroupKey field
	 *
	 * @param ViewDataScriptGroupKey
	 *            Contents of the VIEW_DATA_SCRIPT_GROUP_KEY column
	 */
	public void setViewDataScriptGroupKey(short ViewDataScriptGroupKey) {
		this.ViewDataScriptGroupKey = ViewDataScriptGroupKey;
	}

	/**
	 * Set the ViewDataScriptPid field
	 *
	 * @param ViewDataScriptPid
	 *            Contents of the VIEW_DATA_SCRIPT_PID column
	 */
	public void setViewDataScriptPid(int ViewDataScriptPid) {
		this.ViewDataScriptPid = ViewDataScriptPid;
	}

}
