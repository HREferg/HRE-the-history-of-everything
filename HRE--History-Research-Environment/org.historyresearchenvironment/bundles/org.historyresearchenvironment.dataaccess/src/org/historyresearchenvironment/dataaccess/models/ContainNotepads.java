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

	public ContainNotepads() throws SQLException {
	}

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

	public int getCommitPid() {
		return this.CommitPid;
	}

	public int getContainNotepadPid() {
		return this.ContainNotepadPid;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public String getNotepad() {
		return this.Notepad;
	}

	public short getNotepadDefnKey() {
		return this.NotepadDefnKey;
	}

	public int getParentPid() {
		return this.ParentPid;
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

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setContainNotepadPid(int ContainNotepadPid) {
		this.ContainNotepadPid = ContainNotepadPid;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setNotepad(String Notepad) {
		this.Notepad = Notepad;
	}

	public void setNotepadDefnKey(short NotepadDefnKey) {
		this.NotepadDefnKey = NotepadDefnKey;
	}

	public void setParentPid(int ParentPid) {
		this.ParentPid = ParentPid;
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

}
