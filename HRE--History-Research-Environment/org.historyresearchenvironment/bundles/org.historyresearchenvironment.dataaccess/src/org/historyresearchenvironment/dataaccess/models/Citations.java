package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the CITATIONS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class Citations extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "CITATION_PID, "
			+ "IS_SYSTEM, " + "CITN_TYPE_KEY, " + "CITING_PID, " + "SOURCE_SUB_TYPE_KEY, " + "SOURCE_PID, "
			+ "MEMO_SET_PID, " + "SURETY, " + "FLAGS FROM PUBLIC.CITATIONS WHERE CITATION_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "CITATION_PID, "
			+ "IS_SYSTEM, " + "CITN_TYPE_KEY, " + "CITING_PID, " + "SOURCE_SUB_TYPE_KEY, " + "SOURCE_PID, "
			+ "MEMO_SET_PID, " + "SURETY, " + "FLAGS FROM PUBLIC.CITATIONS";

	private static final String INSERT = "INSERT INTO PUBLIC.CITATIONS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "CITATION_PID, " + "IS_SYSTEM, " + "CITN_TYPE_KEY, " + "CITING_PID, "
			+ "SOURCE_SUB_TYPE_KEY, " + "SOURCE_PID, " + "MEMO_SET_PID, " + "SURETY, " + "FLAGS) VALUES (?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.CITATIONSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "CITN_TYPE_KEY = ?, " + "CITING_PID = ?, "
			+ "SOURCE_SUB_TYPE_KEY = ?, " + "SOURCE_PID = ?, " + "MEMO_SET_PID = ?, " + "SURETY = ?, "
			+ "FLAGS = ? WHERE CITATION_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.CITATIONS WHERE CITATION_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.CITATIONS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int CitationPid;
	private boolean IsSystem;
	private short CitnTypeKey;
	private int CitingPid;
	private short SourceSubTypeKey;
	private int SourcePid;
	private int MemoSetPid;
	private String Surety;
	private String Flags;
	private Citations model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public Citations() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param CitationPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public Citations(int CitationPid) throws SQLException {
		super();
		this.CitationPid = CitationPid;
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
			model = new Citations();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setCitationPid(rs.getInt("CITATION_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setCitnTypeKey(rs.getShort("CITN_TYPE_KEY"));
			model.setCitingPid(rs.getInt("CITING_PID"));
			model.setSourceSubTypeKey(rs.getShort("SOURCE_SUB_TYPE_KEY"));
			model.setSourcePid(rs.getInt("SOURCE_PID"));
			model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
			model.setSurety(rs.getString("SURETY"));
			model.setFlags(rs.getString("FLAGS"));
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
			model.setCitationPid(rs.getInt("CITATION_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setCitnTypeKey(rs.getShort("CITN_TYPE_KEY"));
			model.setCitingPid(rs.getInt("CITING_PID"));
			model.setSourceSubTypeKey(rs.getShort("SOURCE_SUB_TYPE_KEY"));
			model.setSourcePid(rs.getInt("SOURCE_PID"));
			model.setMemoSetPid(rs.getInt("MEMO_SET_PID"));
			model.setSurety(rs.getString("SURETY"));
			model.setFlags(rs.getString("FLAGS"));
		}
		return this;
	}

	/**
	 * Get the CitationPid field.
	 *
	 * @return Contents of the CITATION_PID column
	 */
	public int getCitationPid() {
		return this.CitationPid;
	}

	/**
	 * Get the CitingPid field.
	 *
	 * @return Contents of the CITING_PID column
	 */
	public int getCitingPid() {
		return this.CitingPid;
	}

	/**
	 * Get the CitnTypeKey field.
	 *
	 * @return Contents of the CITN_TYPE_KEY column
	 */
	public short getCitnTypeKey() {
		return this.CitnTypeKey;
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
	 * Get the Flags field.
	 *
	 * @return Contents of the FLAGS column
	 */
	public String getFlags() {
		return this.Flags;
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
	 * Get the MemoSetPid field.
	 *
	 * @return Contents of the MEMO_SET_PID column
	 */
	public int getMemoSetPid() {
		return this.MemoSetPid;
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

	/**
	 * Get the SourcePid field.
	 *
	 * @return Contents of the SOURCE_PID column
	 */
	public int getSourcePid() {
		return this.SourcePid;
	}

	/**
	 * Get the SourceSubTypeKey field.
	 *
	 * @return Contents of the SOURCE_SUB_TYPE_KEY column
	 */
	public short getSourceSubTypeKey() {
		return this.SourceSubTypeKey;
	}

	/**
	 * Get the Surety field.
	 *
	 * @return Contents of the SURETY column
	 */
	public String getSurety() {
		return this.Surety;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((Citations) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Citations) model).setSetKey(rs.getShort("SET_KEY"));
		((Citations) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Citations) model).setCitationPid(rs.getInt("CITATION_PID"));
		((Citations) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((Citations) model).setCitnTypeKey(rs.getShort("CITN_TYPE_KEY"));
		((Citations) model).setCitingPid(rs.getInt("CITING_PID"));
		((Citations) model).setSourceSubTypeKey(rs.getShort("SOURCE_SUB_TYPE_KEY"));
		((Citations) model).setSourcePid(rs.getInt("SOURCE_PID"));
		((Citations) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
		((Citations) model).setSurety(rs.getString("SURETY"));
		((Citations) model).setFlags(rs.getString("FLAGS"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((Citations) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Citations) model).setSetKey(rs.getShort("SET_KEY"));
		((Citations) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Citations) model).setCitationPid(rs.getInt("CITATION_PID"));
		((Citations) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((Citations) model).setCitnTypeKey(rs.getShort("CITN_TYPE_KEY"));
		((Citations) model).setCitingPid(rs.getInt("CITING_PID"));
		((Citations) model).setSourceSubTypeKey(rs.getShort("SOURCE_SUB_TYPE_KEY"));
		((Citations) model).setSourcePid(rs.getInt("SOURCE_PID"));
		((Citations) model).setMemoSetPid(rs.getInt("MEMO_SET_PID"));
		((Citations) model).setSurety(rs.getString("SURETY"));
		((Citations) model).setFlags(rs.getString("FLAGS"));
		ps.executeUpdate();
	}

	/**
	 * Set the CitationPid field
	 *
	 * @param CitationPid
	 *            Contents of the CITATION_PID column
	 */
	public void setCitationPid(int CitationPid) {
		this.CitationPid = CitationPid;
	}

	/**
	 * Set the CitingPid field
	 *
	 * @param CitingPid
	 *            Contents of the CITING_PID column
	 */
	public void setCitingPid(int CitingPid) {
		this.CitingPid = CitingPid;
	}

	/**
	 * Set the CitnTypeKey field
	 *
	 * @param CitnTypeKey
	 *            Contents of the CITN_TYPE_KEY column
	 */
	public void setCitnTypeKey(short CitnTypeKey) {
		this.CitnTypeKey = CitnTypeKey;
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
	 * Set the Flags field
	 *
	 * @param Flags
	 *            Contents of the FLAGS column
	 */
	public void setFlags(String Flags) {
		this.Flags = Flags;
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
	 * Set the MemoSetPid field
	 *
	 * @param MemoSetPid
	 *            Contents of the MEMO_SET_PID column
	 */
	public void setMemoSetPid(int MemoSetPid) {
		this.MemoSetPid = MemoSetPid;
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

	/**
	 * Set the SourcePid field
	 *
	 * @param SourcePid
	 *            Contents of the SOURCE_PID column
	 */
	public void setSourcePid(int SourcePid) {
		this.SourcePid = SourcePid;
	}

	/**
	 * Set the SourceSubTypeKey field
	 *
	 * @param SourceSubTypeKey
	 *            Contents of the SOURCE_SUB_TYPE_KEY column
	 */
	public void setSourceSubTypeKey(short SourceSubTypeKey) {
		this.SourceSubTypeKey = SourceSubTypeKey;
	}

	/**
	 * Set the Surety field
	 *
	 * @param Surety
	 *            Contents of the SURETY column
	 */
	public void setSurety(String Surety) {
		this.Surety = Surety;
	}

}
