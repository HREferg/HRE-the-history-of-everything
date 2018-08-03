package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the CONTAIN_NOTEPADS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class ContainNotepads extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "CONTAIN_NOTEPAD_PID, " + "IS_SYSTEM, " + "PARENT_PID, " + "PARENT_SUB_TYPE_KEY, " + "NOTEPAD_DEFN_KEY, "
			+ "NOTEPAD FROM PUBLIC.CONTAIN_NOTEPADS WHERE CONTAIN_NOTEPAD_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "CONTAIN_NOTEPAD_PID, " + "IS_SYSTEM, " + "PARENT_PID, " + "PARENT_SUB_TYPE_KEY, " + "NOTEPAD_DEFN_KEY, "
			+ "NOTEPAD FROM PUBLIC.CONTAIN_NOTEPADS";

	private static final String INSERT = "INSERT INTO PUBLIC.CONTAIN_NOTEPADS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "CONTAIN_NOTEPAD_PID, " + "IS_SYSTEM, " + "PARENT_PID, " + "PARENT_SUB_TYPE_KEY, "
			+ "NOTEPAD_DEFN_KEY, " + "NOTEPAD) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?)";

	private static final String UPDATE = "UPDATE PUBLIC.CONTAIN_NOTEPADSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "PARENT_PID = ?, " + "PARENT_SUB_TYPE_KEY = ?, "
			+ "NOTEPAD_DEFN_KEY = ?, " + "NOTEPAD = ? WHERE CONTAIN_NOTEPAD_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.CONTAIN_NOTEPADS WHERE CONTAIN_NOTEPAD_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.CONTAIN_NOTEPADS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int ContainNotepadPid;
	private boolean IsSystem;
	private int ParentPid;
	private short ParentSubTypeKey;
	private short NotepadDefnKey;
	private String Notepad;
	private ContainNotepads model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public ContainNotepads() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param ContainNotepadPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public ContainNotepads(int ContainNotepadPid) throws SQLException {
		super();
		this.ContainNotepadPid = ContainNotepadPid;
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
			model = new ContainNotepads();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setContainNotepadPid(rs.getInt("CONTAIN_NOTEPAD_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentPid(rs.getInt("PARENT_PID"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setNotepadDefnKey(rs.getShort("NOTEPAD_DEFN_KEY"));
			model.setNotepad(rs.getString("NOTEPAD"));
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
			model.setContainNotepadPid(rs.getInt("CONTAIN_NOTEPAD_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setParentPid(rs.getInt("PARENT_PID"));
			model.setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
			model.setNotepadDefnKey(rs.getShort("NOTEPAD_DEFN_KEY"));
			model.setNotepad(rs.getString("NOTEPAD"));
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
	 * Get the ContainNotepadPid field.
	 *
	 * @return Contents of the CONTAIN_NOTEPAD_PID column
	 */
	public int getContainNotepadPid() {
		return this.ContainNotepadPid;
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
	 * Get the Notepad field.
	 *
	 * @return Contents of the NOTEPAD column
	 */
	public String getNotepad() {
		return this.Notepad;
	}

	/**
	 * Get the NotepadDefnKey field.
	 *
	 * @return Contents of the NOTEPAD_DEFN_KEY column
	 */
	public short getNotepadDefnKey() {
		return this.NotepadDefnKey;
	}

	/**
	 * Get the ParentPid field.
	 *
	 * @return Contents of the PARENT_PID column
	 */
	public int getParentPid() {
		return this.ParentPid;
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

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((ContainNotepads) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((ContainNotepads) model).setSetKey(rs.getShort("SET_KEY"));
		((ContainNotepads) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((ContainNotepads) model).setContainNotepadPid(rs.getInt("CONTAIN_NOTEPAD_PID"));
		((ContainNotepads) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((ContainNotepads) model).setParentPid(rs.getInt("PARENT_PID"));
		((ContainNotepads) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((ContainNotepads) model).setNotepadDefnKey(rs.getShort("NOTEPAD_DEFN_KEY"));
		((ContainNotepads) model).setNotepad(rs.getString("NOTEPAD"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((ContainNotepads) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((ContainNotepads) model).setSetKey(rs.getShort("SET_KEY"));
		((ContainNotepads) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((ContainNotepads) model).setContainNotepadPid(rs.getInt("CONTAIN_NOTEPAD_PID"));
		((ContainNotepads) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((ContainNotepads) model).setParentPid(rs.getInt("PARENT_PID"));
		((ContainNotepads) model).setParentSubTypeKey(rs.getShort("PARENT_SUB_TYPE_KEY"));
		((ContainNotepads) model).setNotepadDefnKey(rs.getShort("NOTEPAD_DEFN_KEY"));
		((ContainNotepads) model).setNotepad(rs.getString("NOTEPAD"));
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
	 * Set the ContainNotepadPid field
	 *
	 * @param ContainNotepadPid
	 *            Contents of the CONTAIN_NOTEPAD_PID column
	 */
	public void setContainNotepadPid(int ContainNotepadPid) {
		this.ContainNotepadPid = ContainNotepadPid;
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
	 * Set the Notepad field
	 *
	 * @param Notepad
	 *            Contents of the NOTEPAD column
	 */
	public void setNotepad(String Notepad) {
		this.Notepad = Notepad;
	}

	/**
	 * Set the NotepadDefnKey field
	 *
	 * @param NotepadDefnKey
	 *            Contents of the NOTEPAD_DEFN_KEY column
	 */
	public void setNotepadDefnKey(short NotepadDefnKey) {
		this.NotepadDefnKey = NotepadDefnKey;
	}

	/**
	 * Set the ParentPid field
	 *
	 * @param ParentPid
	 *            Contents of the PARENT_PID column
	 */
	public void setParentPid(int ParentPid) {
		this.ParentPid = ParentPid;
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

}
