package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SUBSTN_SYNTAX_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SubstnSyntaxDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSTN_SYNTAX_DEFN_PID, " + "ENCLOSES_MARKUP, " + "INTERNAL_BEGIN_MARK, " + "VISIBLE_BEGIN_MARK, "
			+ "INTERNAL_END_MARK, " + "VISIBLE_END_MARK, " + "INTERNAL_BEGIN_TRUE, " + "VISIBLE_BEGIN_TRUE, "
			+ "INTERNAL_END_TRUE, " + "VISIBLE_END_TRUE, " + "INTERNAL_DIVIDER_MARK, " + "VISIBLE_DIVIDER_MARK, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "SHOW FROM PUBLIC.SUBSTN_SYNTAX_DEFNS WHERE SUBSTN_SYNTAX_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSTN_SYNTAX_DEFN_PID, " + "ENCLOSES_MARKUP, " + "INTERNAL_BEGIN_MARK, " + "VISIBLE_BEGIN_MARK, "
			+ "INTERNAL_END_MARK, " + "VISIBLE_END_MARK, " + "INTERNAL_BEGIN_TRUE, " + "VISIBLE_BEGIN_TRUE, "
			+ "INTERNAL_END_TRUE, " + "VISIBLE_END_TRUE, " + "INTERNAL_DIVIDER_MARK, " + "VISIBLE_DIVIDER_MARK, "
			+ "REMINDER_KEY, " + "DISPLAY_ORDER, " + "SHOW FROM PUBLIC.SUBSTN_SYNTAX_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.SUBSTN_SYNTAX_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SUBSTN_SYNTAX_DEFN_PID, " + "ENCLOSES_MARKUP, " + "INTERNAL_BEGIN_MARK, "
			+ "VISIBLE_BEGIN_MARK, " + "INTERNAL_END_MARK, " + "VISIBLE_END_MARK, " + "INTERNAL_BEGIN_TRUE, "
			+ "VISIBLE_BEGIN_TRUE, " + "INTERNAL_END_TRUE, " + "VISIBLE_END_TRUE, " + "INTERNAL_DIVIDER_MARK, "
			+ "VISIBLE_DIVIDER_MARK, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "SHOW) VALUES (?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SUBSTN_SYNTAX_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "ENCLOSES_MARKUP = ?, " + "INTERNAL_BEGIN_MARK = ?, " + "VISIBLE_BEGIN_MARK = ?, "
			+ "INTERNAL_END_MARK = ?, " + "VISIBLE_END_MARK = ?, " + "INTERNAL_BEGIN_TRUE = ?, "
			+ "VISIBLE_BEGIN_TRUE = ?, " + "INTERNAL_END_TRUE = ?, " + "VISIBLE_END_TRUE = ?, "
			+ "INTERNAL_DIVIDER_MARK = ?, " + "VISIBLE_DIVIDER_MARK = ?, " + "REMINDER_KEY = ?, "
			+ "DISPLAY_ORDER = ?, " + "SHOW = ? WHERE SUBSTN_SYNTAX_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SUBSTN_SYNTAX_DEFNS WHERE SUBSTN_SYNTAX_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSTN_SYNTAX_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SubstnSyntaxDefnPid;
	private boolean EnclosesMarkup;
	private String InternalBeginMark;
	private String VisibleBeginMark;
	private String InternalEndMark;
	private String VisibleEndMark;
	private String InternalBeginTrue;
	private String VisibleBeginTrue;
	private String InternalEndTrue;
	private String VisibleEndTrue;
	private String InternalDividerMark;
	private String VisibleDividerMark;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean Show;
	private SubstnSyntaxDefns model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SubstnSyntaxDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param SubstnSyntaxDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SubstnSyntaxDefns(int SubstnSyntaxDefnPid) throws SQLException {
		super();
		this.SubstnSyntaxDefnPid = SubstnSyntaxDefnPid;
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
			model = new SubstnSyntaxDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSubstnSyntaxDefnPid(rs.getInt("SUBSTN_SYNTAX_DEFN_PID"));
			model.setEnclosesMarkup(rs.getBoolean("ENCLOSES_MARKUP"));
			model.setInternalBeginMark(rs.getString("INTERNAL_BEGIN_MARK"));
			model.setVisibleBeginMark(rs.getString("VISIBLE_BEGIN_MARK"));
			model.setInternalEndMark(rs.getString("INTERNAL_END_MARK"));
			model.setVisibleEndMark(rs.getString("VISIBLE_END_MARK"));
			model.setInternalBeginTrue(rs.getString("INTERNAL_BEGIN_TRUE"));
			model.setVisibleBeginTrue(rs.getString("VISIBLE_BEGIN_TRUE"));
			model.setInternalEndTrue(rs.getString("INTERNAL_END_TRUE"));
			model.setVisibleEndTrue(rs.getString("VISIBLE_END_TRUE"));
			model.setInternalDividerMark(rs.getString("INTERNAL_DIVIDER_MARK"));
			model.setVisibleDividerMark(rs.getString("VISIBLE_DIVIDER_MARK"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
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
			model.setSubstnSyntaxDefnPid(rs.getInt("SUBSTN_SYNTAX_DEFN_PID"));
			model.setEnclosesMarkup(rs.getBoolean("ENCLOSES_MARKUP"));
			model.setInternalBeginMark(rs.getString("INTERNAL_BEGIN_MARK"));
			model.setVisibleBeginMark(rs.getString("VISIBLE_BEGIN_MARK"));
			model.setInternalEndMark(rs.getString("INTERNAL_END_MARK"));
			model.setVisibleEndMark(rs.getString("VISIBLE_END_MARK"));
			model.setInternalBeginTrue(rs.getString("INTERNAL_BEGIN_TRUE"));
			model.setVisibleBeginTrue(rs.getString("VISIBLE_BEGIN_TRUE"));
			model.setInternalEndTrue(rs.getString("INTERNAL_END_TRUE"));
			model.setVisibleEndTrue(rs.getString("VISIBLE_END_TRUE"));
			model.setInternalDividerMark(rs.getString("INTERNAL_DIVIDER_MARK"));
			model.setVisibleDividerMark(rs.getString("VISIBLE_DIVIDER_MARK"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setShow(rs.getBoolean("SHOW"));
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
	 * Get the DisplayOrder field.
	 *
	 * @return Contents of the DISPLAY_ORDER column
	 */
	public short getDisplayOrder() {
		return this.DisplayOrder;
	}

	/**
	 * Get the EnclosesMarkup field.
	 *
	 * @return Contents of the ENCLOSES_MARKUP column
	 */
	public boolean getEnclosesMarkup() {
		return this.EnclosesMarkup;
	}

	/**
	 * Get the InternalBeginMark field.
	 *
	 * @return Contents of the INTERNAL_BEGIN_MARK column
	 */
	public String getInternalBeginMark() {
		return this.InternalBeginMark;
	}

	/**
	 * Get the InternalBeginTrue field.
	 *
	 * @return Contents of the INTERNAL_BEGIN_TRUE column
	 */
	public String getInternalBeginTrue() {
		return this.InternalBeginTrue;
	}

	/**
	 * Get the InternalDividerMark field.
	 *
	 * @return Contents of the INTERNAL_DIVIDER_MARK column
	 */
	public String getInternalDividerMark() {
		return this.InternalDividerMark;
	}

	/**
	 * Get the InternalEndMark field.
	 *
	 * @return Contents of the INTERNAL_END_MARK column
	 */
	public String getInternalEndMark() {
		return this.InternalEndMark;
	}

	/**
	 * Get the InternalEndTrue field.
	 *
	 * @return Contents of the INTERNAL_END_TRUE column
	 */
	public String getInternalEndTrue() {
		return this.InternalEndTrue;
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
	 * Get the SubstnSyntaxDefnPid field.
	 *
	 * @return Contents of the SUBSTN_SYNTAX_DEFN_PID column
	 */
	public int getSubstnSyntaxDefnPid() {
		return this.SubstnSyntaxDefnPid;
	}

	/**
	 * Get the VisibleBeginMark field.
	 *
	 * @return Contents of the VISIBLE_BEGIN_MARK column
	 */
	public String getVisibleBeginMark() {
		return this.VisibleBeginMark;
	}

	/**
	 * Get the VisibleBeginTrue field.
	 *
	 * @return Contents of the VISIBLE_BEGIN_TRUE column
	 */
	public String getVisibleBeginTrue() {
		return this.VisibleBeginTrue;
	}

	/**
	 * Get the VisibleDividerMark field.
	 *
	 * @return Contents of the VISIBLE_DIVIDER_MARK column
	 */
	public String getVisibleDividerMark() {
		return this.VisibleDividerMark;
	}

	/**
	 * Get the VisibleEndMark field.
	 *
	 * @return Contents of the VISIBLE_END_MARK column
	 */
	public String getVisibleEndMark() {
		return this.VisibleEndMark;
	}

	/**
	 * Get the VisibleEndTrue field.
	 *
	 * @return Contents of the VISIBLE_END_TRUE column
	 */
	public String getVisibleEndTrue() {
		return this.VisibleEndTrue;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((SubstnSyntaxDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubstnSyntaxDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubstnSyntaxDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubstnSyntaxDefns) model).setSubstnSyntaxDefnPid(rs.getInt("SUBSTN_SYNTAX_DEFN_PID"));
		((SubstnSyntaxDefns) model).setEnclosesMarkup(rs.getBoolean("ENCLOSES_MARKUP"));
		((SubstnSyntaxDefns) model).setInternalBeginMark(rs.getString("INTERNAL_BEGIN_MARK"));
		((SubstnSyntaxDefns) model).setVisibleBeginMark(rs.getString("VISIBLE_BEGIN_MARK"));
		((SubstnSyntaxDefns) model).setInternalEndMark(rs.getString("INTERNAL_END_MARK"));
		((SubstnSyntaxDefns) model).setVisibleEndMark(rs.getString("VISIBLE_END_MARK"));
		((SubstnSyntaxDefns) model).setInternalBeginTrue(rs.getString("INTERNAL_BEGIN_TRUE"));
		((SubstnSyntaxDefns) model).setVisibleBeginTrue(rs.getString("VISIBLE_BEGIN_TRUE"));
		((SubstnSyntaxDefns) model).setInternalEndTrue(rs.getString("INTERNAL_END_TRUE"));
		((SubstnSyntaxDefns) model).setVisibleEndTrue(rs.getString("VISIBLE_END_TRUE"));
		((SubstnSyntaxDefns) model).setInternalDividerMark(rs.getString("INTERNAL_DIVIDER_MARK"));
		((SubstnSyntaxDefns) model).setVisibleDividerMark(rs.getString("VISIBLE_DIVIDER_MARK"));
		((SubstnSyntaxDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubstnSyntaxDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubstnSyntaxDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SubstnSyntaxDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubstnSyntaxDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubstnSyntaxDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubstnSyntaxDefns) model).setSubstnSyntaxDefnPid(rs.getInt("SUBSTN_SYNTAX_DEFN_PID"));
		((SubstnSyntaxDefns) model).setEnclosesMarkup(rs.getBoolean("ENCLOSES_MARKUP"));
		((SubstnSyntaxDefns) model).setInternalBeginMark(rs.getString("INTERNAL_BEGIN_MARK"));
		((SubstnSyntaxDefns) model).setVisibleBeginMark(rs.getString("VISIBLE_BEGIN_MARK"));
		((SubstnSyntaxDefns) model).setInternalEndMark(rs.getString("INTERNAL_END_MARK"));
		((SubstnSyntaxDefns) model).setVisibleEndMark(rs.getString("VISIBLE_END_MARK"));
		((SubstnSyntaxDefns) model).setInternalBeginTrue(rs.getString("INTERNAL_BEGIN_TRUE"));
		((SubstnSyntaxDefns) model).setVisibleBeginTrue(rs.getString("VISIBLE_BEGIN_TRUE"));
		((SubstnSyntaxDefns) model).setInternalEndTrue(rs.getString("INTERNAL_END_TRUE"));
		((SubstnSyntaxDefns) model).setVisibleEndTrue(rs.getString("VISIBLE_END_TRUE"));
		((SubstnSyntaxDefns) model).setInternalDividerMark(rs.getString("INTERNAL_DIVIDER_MARK"));
		((SubstnSyntaxDefns) model).setVisibleDividerMark(rs.getString("VISIBLE_DIVIDER_MARK"));
		((SubstnSyntaxDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubstnSyntaxDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubstnSyntaxDefns) model).setShow(rs.getBoolean("SHOW"));
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
	 * Set the DisplayOrder field
	 *
	 * @param DisplayOrder
	 *            Contents of the DISPLAY_ORDER column
	 */
	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	/**
	 * Set the EnclosesMarkup field
	 *
	 * @param EnclosesMarkup
	 *            Contents of the ENCLOSES_MARKUP column
	 */
	public void setEnclosesMarkup(boolean EnclosesMarkup) {
		this.EnclosesMarkup = EnclosesMarkup;
	}

	/**
	 * Set the InternalBeginMark field
	 *
	 * @param InternalBeginMark
	 *            Contents of the INTERNAL_BEGIN_MARK column
	 */
	public void setInternalBeginMark(String InternalBeginMark) {
		this.InternalBeginMark = InternalBeginMark;
	}

	/**
	 * Set the InternalBeginTrue field
	 *
	 * @param InternalBeginTrue
	 *            Contents of the INTERNAL_BEGIN_TRUE column
	 */
	public void setInternalBeginTrue(String InternalBeginTrue) {
		this.InternalBeginTrue = InternalBeginTrue;
	}

	/**
	 * Set the InternalDividerMark field
	 *
	 * @param InternalDividerMark
	 *            Contents of the INTERNAL_DIVIDER_MARK column
	 */
	public void setInternalDividerMark(String InternalDividerMark) {
		this.InternalDividerMark = InternalDividerMark;
	}

	/**
	 * Set the InternalEndMark field
	 *
	 * @param InternalEndMark
	 *            Contents of the INTERNAL_END_MARK column
	 */
	public void setInternalEndMark(String InternalEndMark) {
		this.InternalEndMark = InternalEndMark;
	}

	/**
	 * Set the InternalEndTrue field
	 *
	 * @param InternalEndTrue
	 *            Contents of the INTERNAL_END_TRUE column
	 */
	public void setInternalEndTrue(String InternalEndTrue) {
		this.InternalEndTrue = InternalEndTrue;
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
	 * Set the SubstnSyntaxDefnPid field
	 *
	 * @param SubstnSyntaxDefnPid
	 *            Contents of the SUBSTN_SYNTAX_DEFN_PID column
	 */
	public void setSubstnSyntaxDefnPid(int SubstnSyntaxDefnPid) {
		this.SubstnSyntaxDefnPid = SubstnSyntaxDefnPid;
	}

	/**
	 * Set the VisibleBeginMark field
	 *
	 * @param VisibleBeginMark
	 *            Contents of the VISIBLE_BEGIN_MARK column
	 */
	public void setVisibleBeginMark(String VisibleBeginMark) {
		this.VisibleBeginMark = VisibleBeginMark;
	}

	/**
	 * Set the VisibleBeginTrue field
	 *
	 * @param VisibleBeginTrue
	 *            Contents of the VISIBLE_BEGIN_TRUE column
	 */
	public void setVisibleBeginTrue(String VisibleBeginTrue) {
		this.VisibleBeginTrue = VisibleBeginTrue;
	}

	/**
	 * Set the VisibleDividerMark field
	 *
	 * @param VisibleDividerMark
	 *            Contents of the VISIBLE_DIVIDER_MARK column
	 */
	public void setVisibleDividerMark(String VisibleDividerMark) {
		this.VisibleDividerMark = VisibleDividerMark;
	}

	/**
	 * Set the VisibleEndMark field
	 *
	 * @param VisibleEndMark
	 *            Contents of the VISIBLE_END_MARK column
	 */
	public void setVisibleEndMark(String VisibleEndMark) {
		this.VisibleEndMark = VisibleEndMark;
	}

	/**
	 * Set the VisibleEndTrue field
	 *
	 * @param VisibleEndTrue
	 *            Contents of the VISIBLE_END_TRUE column
	 */
	public void setVisibleEndTrue(String VisibleEndTrue) {
		this.VisibleEndTrue = VisibleEndTrue;
	}

}
