package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the PROJECTS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class Projects extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "PROJECT_PID, "
			+ "COMMENCED FROM PUBLIC.PROJECTS WHERE PROJECT_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "PROJECT_PID, "
			+ "COMMENCED FROM PUBLIC.PROJECTS";

	private static final String INSERT = "INSERT INTO PUBLIC.PROJECTS( " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "PROJECT_PID, " + "COMMENCED) VALUES (?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.PROJECTSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "COMMENCED = ? WHERE PROJECT_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.PROJECTS WHERE PROJECT_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.PROJECTS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int ProjectPid;
	private Timestamp Commenced;
	private Projects model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public Projects() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param ProjectPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public Projects(int ProjectPid) throws SQLException {
		super();
		this.ProjectPid = ProjectPid;
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
			model = new Projects();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setProjectPid(rs.getInt("PROJECT_PID"));
			model.setCommenced(rs.getTimestamp("COMMENCED"));
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
			model.setProjectPid(rs.getInt("PROJECT_PID"));
			model.setCommenced(rs.getTimestamp("COMMENCED"));
		}
		return this;
	}

	/**
	 * Get the Commenced field.
	 *
	 * @return Contents of the COMMENCED column
	 */
	public Timestamp getCommenced() {
		return this.Commenced;
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
	 * Get the ProjectPid field.
	 *
	 * @return Contents of the PROJECT_PID column
	 */
	public int getProjectPid() {
		return this.ProjectPid;
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
		((Projects) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Projects) model).setSetKey(rs.getShort("SET_KEY"));
		((Projects) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Projects) model).setProjectPid(rs.getInt("PROJECT_PID"));
		((Projects) model).setCommenced(rs.getTimestamp("COMMENCED"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((Projects) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Projects) model).setSetKey(rs.getShort("SET_KEY"));
		((Projects) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Projects) model).setProjectPid(rs.getInt("PROJECT_PID"));
		((Projects) model).setCommenced(rs.getTimestamp("COMMENCED"));
		ps.executeUpdate();
	}

	/**
	 * Set the Commenced field
	 *
	 * @param Commenced
	 *            Contents of the COMMENCED column
	 */
	public void setCommenced(Timestamp Commenced) {
		this.Commenced = Commenced;
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
	 * Set the ProjectPid field
	 *
	 * @param ProjectPid
	 *            Contents of the PROJECT_PID column
	 */
	public void setProjectPid(int ProjectPid) {
		this.ProjectPid = ProjectPid;
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
