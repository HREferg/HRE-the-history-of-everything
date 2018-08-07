package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the BIOS database table.
 *
 * @version 2018-08-06
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class Bios extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private ArrayList<AbstractHreDataModel> modelList;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "BIO_PID, "
			+ "IS_SYSTEM, " + "VISIBLE_ID, " + "SUB_TYPE_KEY, " + "BEST_NAME_PID, " + "BEST_BIRTH_PID, "
			+ "BEST_DEATH_PID, " + "BEST_BIO_MALE_PARENT_PID, " + "BEST_BIO_FEMALE_PARENT_PID, "
			+ "USE_BIO_MALE_PARENT, " + "USE_BIO_FEMALE_PARENT, " + "BEST_NON_BIO_PARENT1_PID, "
			+ "BEST_NON_BIO_PARENT2_PID, " + "BEST_IMAGE_PID, " + "SEX_KEY, " + "LIVING_KEY, "
			+ "SPERM_PROVIDER_ISSUE_ORDER, " + "EGG_PROVIDER_ISSUE_ORDER, " + "SURETY, "
			+ "FLAGS FROM PUBLIC.BIOS WHERE BIO_PID = ?";

	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "BIO_PID, "
			+ "IS_SYSTEM, " + "VISIBLE_ID, " + "SUB_TYPE_KEY, " + "BEST_NAME_PID, " + "BEST_BIRTH_PID, "
			+ "BEST_DEATH_PID, " + "BEST_BIO_MALE_PARENT_PID, " + "BEST_BIO_FEMALE_PARENT_PID, "
			+ "USE_BIO_MALE_PARENT, " + "USE_BIO_FEMALE_PARENT, " + "BEST_NON_BIO_PARENT1_PID, "
			+ "BEST_NON_BIO_PARENT2_PID, " + "BEST_IMAGE_PID, " + "SEX_KEY, " + "LIVING_KEY, "
			+ "SPERM_PROVIDER_ISSUE_ORDER, " + "EGG_PROVIDER_ISSUE_ORDER, " + "SURETY, " + "FLAGS FROM PUBLIC.BIOS";

	private static final String INSERT = "INSERT INTO PUBLIC.BIOS( " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "BIO_PID, " + "IS_SYSTEM, " + "VISIBLE_ID, " + "SUB_TYPE_KEY, " + "BEST_NAME_PID, " + "BEST_BIRTH_PID, "
			+ "BEST_DEATH_PID, " + "BEST_BIO_MALE_PARENT_PID, " + "BEST_BIO_FEMALE_PARENT_PID, "
			+ "USE_BIO_MALE_PARENT, " + "USE_BIO_FEMALE_PARENT, " + "BEST_NON_BIO_PARENT1_PID, "
			+ "BEST_NON_BIO_PARENT2_PID, " + "BEST_IMAGE_PID, " + "SEX_KEY, " + "LIVING_KEY, "
			+ "SPERM_PROVIDER_ISSUE_ORDER, " + "EGG_PROVIDER_ISSUE_ORDER, " + "SURETY, " + "FLAGS) VALUES (?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.BIOSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "VISIBLE_ID = ?, " + "SUB_TYPE_KEY = ?, " + "BEST_NAME_PID = ?, "
			+ "BEST_BIRTH_PID = ?, " + "BEST_DEATH_PID = ?, " + "BEST_BIO_MALE_PARENT_PID = ?, "
			+ "BEST_BIO_FEMALE_PARENT_PID = ?, " + "USE_BIO_MALE_PARENT = ?, " + "USE_BIO_FEMALE_PARENT = ?, "
			+ "BEST_NON_BIO_PARENT1_PID = ?, " + "BEST_NON_BIO_PARENT2_PID = ?, " + "BEST_IMAGE_PID = ?, "
			+ "SEX_KEY = ?, " + "LIVING_KEY = ?, " + "SPERM_PROVIDER_ISSUE_ORDER = ?, "
			+ "EGG_PROVIDER_ISSUE_ORDER = ?, " + "SURETY = ?, " + "FLAGS = ? WHERE BIO_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.BIOS WHERE BIO_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.BIOS";

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int BioPid;
	private boolean IsSystem;
	private int VisibleId;
	private int SubTypeKey;
	private int BestNamePid;
	private int BestBirthPid;
	private int BestDeathPid;
	private int BestBioMaleParentPid;
	private int BestBioFemaleParentPid;
	private boolean UseBioMaleParent;
	private boolean UseBioFemaleParent;
	private int BestNonBioParent1Pid;
	private int BestNonBioParent2Pid;
	private int BestImagePid;
	private int SexKey;
	private int LivingKey;
	private short SpermProviderIssueOrder;
	private short EggProviderIssueOrder;
	private String Surety;
	private byte[] Flags;
	private Bios model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public Bios() throws SQLException {
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
			model = new Bios();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setBioPid(rs.getInt("BIO_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setVisibleId(rs.getInt("VISIBLE_ID"));
			model.setSubTypeKey(rs.getInt("SUB_TYPE_KEY"));
			model.setBestNamePid(rs.getInt("BEST_NAME_PID"));
			model.setBestBirthPid(rs.getInt("BEST_BIRTH_PID"));
			model.setBestDeathPid(rs.getInt("BEST_DEATH_PID"));
			model.setBestBioMaleParentPid(rs.getInt("BEST_BIO_MALE_PARENT_PID"));
			model.setBestBioFemaleParentPid(rs.getInt("BEST_BIO_FEMALE_PARENT_PID"));
			model.setUseBioMaleParent(rs.getBoolean("USE_BIO_MALE_PARENT"));
			model.setUseBioFemaleParent(rs.getBoolean("USE_BIO_FEMALE_PARENT"));
			model.setBestNonBioParent1Pid(rs.getInt("BEST_NON_BIO_PARENT1_PID"));
			model.setBestNonBioParent2Pid(rs.getInt("BEST_NON_BIO_PARENT2_PID"));
			model.setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
			model.setSexKey(rs.getInt("SEX_KEY"));
			model.setLivingKey(rs.getInt("LIVING_KEY"));
			model.setSpermProviderIssueOrder(rs.getShort("SPERM_PROVIDER_ISSUE_ORDER"));
			model.setEggProviderIssueOrder(rs.getShort("EGG_PROVIDER_ISSUE_ORDER"));
			model.setSurety(rs.getString("SURETY"));
			model.setFlags(rs.getBytes("FLAGS"));
			modelList.add(model);
		}
		return modelList;
	}

	@Override
	public Bios get(int key) throws SQLException {
		model = new Bios();
		ps = conn.prepareStatement(SELECT);
		ps.setInt(1, (int) key);
		rs = ps.executeQuery();
		if (rs.next()) {
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setBioPid(rs.getInt("BIO_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setVisibleId(rs.getInt("VISIBLE_ID"));
			model.setSubTypeKey(rs.getInt("SUB_TYPE_KEY"));
			model.setBestNamePid(rs.getInt("BEST_NAME_PID"));
			model.setBestBirthPid(rs.getInt("BEST_BIRTH_PID"));
			model.setBestDeathPid(rs.getInt("BEST_DEATH_PID"));
			model.setBestBioMaleParentPid(rs.getInt("BEST_BIO_MALE_PARENT_PID"));
			model.setBestBioFemaleParentPid(rs.getInt("BEST_BIO_FEMALE_PARENT_PID"));
			model.setUseBioMaleParent(rs.getBoolean("USE_BIO_MALE_PARENT"));
			model.setUseBioFemaleParent(rs.getBoolean("USE_BIO_FEMALE_PARENT"));
			model.setBestNonBioParent1Pid(rs.getInt("BEST_NON_BIO_PARENT1_PID"));
			model.setBestNonBioParent2Pid(rs.getInt("BEST_NON_BIO_PARENT2_PID"));
			model.setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
			model.setSexKey(rs.getInt("SEX_KEY"));
			model.setLivingKey(rs.getInt("LIVING_KEY"));
			model.setSpermProviderIssueOrder(rs.getShort("SPERM_PROVIDER_ISSUE_ORDER"));
			model.setEggProviderIssueOrder(rs.getShort("EGG_PROVIDER_ISSUE_ORDER"));
			model.setSurety(rs.getString("SURETY"));
			model.setFlags(rs.getBytes("FLAGS"));
		}
		return model;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((Bios) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Bios) model).setSetKey(rs.getShort("SET_KEY"));
		((Bios) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Bios) model).setBioPid(rs.getInt("BIO_PID"));
		((Bios) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((Bios) model).setVisibleId(rs.getInt("VISIBLE_ID"));
		((Bios) model).setSubTypeKey(rs.getInt("SUB_TYPE_KEY"));
		((Bios) model).setBestNamePid(rs.getInt("BEST_NAME_PID"));
		((Bios) model).setBestBirthPid(rs.getInt("BEST_BIRTH_PID"));
		((Bios) model).setBestDeathPid(rs.getInt("BEST_DEATH_PID"));
		((Bios) model).setBestBioMaleParentPid(rs.getInt("BEST_BIO_MALE_PARENT_PID"));
		((Bios) model).setBestBioFemaleParentPid(rs.getInt("BEST_BIO_FEMALE_PARENT_PID"));
		((Bios) model).setUseBioMaleParent(rs.getBoolean("USE_BIO_MALE_PARENT"));
		((Bios) model).setUseBioFemaleParent(rs.getBoolean("USE_BIO_FEMALE_PARENT"));
		((Bios) model).setBestNonBioParent1Pid(rs.getInt("BEST_NON_BIO_PARENT1_PID"));
		((Bios) model).setBestNonBioParent2Pid(rs.getInt("BEST_NON_BIO_PARENT2_PID"));
		((Bios) model).setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
		((Bios) model).setSexKey(rs.getInt("SEX_KEY"));
		((Bios) model).setLivingKey(rs.getInt("LIVING_KEY"));
		((Bios) model).setSpermProviderIssueOrder(rs.getShort("SPERM_PROVIDER_ISSUE_ORDER"));
		((Bios) model).setEggProviderIssueOrder(rs.getShort("EGG_PROVIDER_ISSUE_ORDER"));
		((Bios) model).setSurety(rs.getString("SURETY"));
		((Bios) model).setFlags(rs.getBytes("FLAGS"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((Bios) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Bios) model).setSetKey(rs.getShort("SET_KEY"));
		((Bios) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Bios) model).setBioPid(rs.getInt("BIO_PID"));
		((Bios) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((Bios) model).setVisibleId(rs.getInt("VISIBLE_ID"));
		((Bios) model).setSubTypeKey(rs.getInt("SUB_TYPE_KEY"));
		((Bios) model).setBestNamePid(rs.getInt("BEST_NAME_PID"));
		((Bios) model).setBestBirthPid(rs.getInt("BEST_BIRTH_PID"));
		((Bios) model).setBestDeathPid(rs.getInt("BEST_DEATH_PID"));
		((Bios) model).setBestBioMaleParentPid(rs.getInt("BEST_BIO_MALE_PARENT_PID"));
		((Bios) model).setBestBioFemaleParentPid(rs.getInt("BEST_BIO_FEMALE_PARENT_PID"));
		((Bios) model).setUseBioMaleParent(rs.getBoolean("USE_BIO_MALE_PARENT"));
		((Bios) model).setUseBioFemaleParent(rs.getBoolean("USE_BIO_FEMALE_PARENT"));
		((Bios) model).setBestNonBioParent1Pid(rs.getInt("BEST_NON_BIO_PARENT1_PID"));
		((Bios) model).setBestNonBioParent2Pid(rs.getInt("BEST_NON_BIO_PARENT2_PID"));
		((Bios) model).setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
		((Bios) model).setSexKey(rs.getInt("SEX_KEY"));
		((Bios) model).setLivingKey(rs.getInt("LIVING_KEY"));
		((Bios) model).setSpermProviderIssueOrder(rs.getShort("SPERM_PROVIDER_ISSUE_ORDER"));
		((Bios) model).setEggProviderIssueOrder(rs.getShort("EGG_PROVIDER_ISSUE_ORDER"));
		((Bios) model).setSurety(rs.getString("SURETY"));
		((Bios) model).setFlags(rs.getBytes("FLAGS"));
		ps.executeUpdate();
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
	 * Get the CommitPid field.
	 *
	 * @return Contents of the COMMIT_PID column
	 */
	public int getCommitPid() {
		return this.CommitPid;
	}

	/**
	 * Get the BioPid field.
	 *
	 * @return Contents of the BIO_PID column
	 */
	public int getBioPid() {
		return this.BioPid;
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
	 * Get the VisibleId field.
	 *
	 * @return Contents of the VISIBLE_ID column
	 */
	public int getVisibleId() {
		return this.VisibleId;
	}

	/**
	 * Get the SubTypeKey field.
	 *
	 * @return Contents of the SUB_TYPE_KEY column
	 */
	public int getSubTypeKey() {
		return this.SubTypeKey;
	}

	/**
	 * Get the BestNamePid field.
	 *
	 * @return Contents of the BEST_NAME_PID column
	 */
	public int getBestNamePid() {
		return this.BestNamePid;
	}

	/**
	 * Get the BestBirthPid field.
	 *
	 * @return Contents of the BEST_BIRTH_PID column
	 */
	public int getBestBirthPid() {
		return this.BestBirthPid;
	}

	/**
	 * Get the BestDeathPid field.
	 *
	 * @return Contents of the BEST_DEATH_PID column
	 */
	public int getBestDeathPid() {
		return this.BestDeathPid;
	}

	/**
	 * Get the BestBioMaleParentPid field.
	 *
	 * @return Contents of the BEST_BIO_MALE_PARENT_PID column
	 */
	public int getBestBioMaleParentPid() {
		return this.BestBioMaleParentPid;
	}

	/**
	 * Get the BestBioFemaleParentPid field.
	 *
	 * @return Contents of the BEST_BIO_FEMALE_PARENT_PID column
	 */
	public int getBestBioFemaleParentPid() {
		return this.BestBioFemaleParentPid;
	}

	/**
	 * Get the UseBioMaleParent field.
	 *
	 * @return Contents of the USE_BIO_MALE_PARENT column
	 */
	public boolean getUseBioMaleParent() {
		return this.UseBioMaleParent;
	}

	/**
	 * Get the UseBioFemaleParent field.
	 *
	 * @return Contents of the USE_BIO_FEMALE_PARENT column
	 */
	public boolean getUseBioFemaleParent() {
		return this.UseBioFemaleParent;
	}

	/**
	 * Get the BestNonBioParent1Pid field.
	 *
	 * @return Contents of the BEST_NON_BIO_PARENT1_PID column
	 */
	public int getBestNonBioParent1Pid() {
		return this.BestNonBioParent1Pid;
	}

	/**
	 * Get the BestNonBioParent2Pid field.
	 *
	 * @return Contents of the BEST_NON_BIO_PARENT2_PID column
	 */
	public int getBestNonBioParent2Pid() {
		return this.BestNonBioParent2Pid;
	}

	/**
	 * Get the BestImagePid field.
	 *
	 * @return Contents of the BEST_IMAGE_PID column
	 */
	public int getBestImagePid() {
		return this.BestImagePid;
	}

	/**
	 * Get the SexKey field.
	 *
	 * @return Contents of the SEX_KEY column
	 */
	public int getSexKey() {
		return this.SexKey;
	}

	/**
	 * Get the LivingKey field.
	 *
	 * @return Contents of the LIVING_KEY column
	 */
	public int getLivingKey() {
		return this.LivingKey;
	}

	/**
	 * Get the SpermProviderIssueOrder field.
	 *
	 * @return Contents of the SPERM_PROVIDER_ISSUE_ORDER column
	 */
	public short getSpermProviderIssueOrder() {
		return this.SpermProviderIssueOrder;
	}

	/**
	 * Get the EggProviderIssueOrder field.
	 *
	 * @return Contents of the EGG_PROVIDER_ISSUE_ORDER column
	 */
	public short getEggProviderIssueOrder() {
		return this.EggProviderIssueOrder;
	}

	/**
	 * Get the Surety field.
	 *
	 * @return Contents of the SURETY column
	 */
	public String getSurety() {
		return this.Surety;
	}

	/**
	 * Get the Flags field.
	 *
	 * @return Contents of the FLAGS column
	 */
	public byte[] getFlags() {
		return this.Flags;
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
	 * Set the CommitPid field
	 *
	 * @param CommitPid
	 *            Contents of the COMMIT_PID column
	 */
	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	/**
	 * Set the BioPid field
	 *
	 * @param BioPid
	 *            Contents of the BIO_PID column
	 */
	public void setBioPid(int BioPid) {
		this.BioPid = BioPid;
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
	 * Set the VisibleId field
	 *
	 * @param VisibleId
	 *            Contents of the VISIBLE_ID column
	 */
	public void setVisibleId(int VisibleId) {
		this.VisibleId = VisibleId;
	}

	/**
	 * Set the SubTypeKey field
	 *
	 * @param SubTypeKey
	 *            Contents of the SUB_TYPE_KEY column
	 */
	public void setSubTypeKey(int SubTypeKey) {
		this.SubTypeKey = SubTypeKey;
	}

	/**
	 * Set the BestNamePid field
	 *
	 * @param BestNamePid
	 *            Contents of the BEST_NAME_PID column
	 */
	public void setBestNamePid(int BestNamePid) {
		this.BestNamePid = BestNamePid;
	}

	/**
	 * Set the BestBirthPid field
	 *
	 * @param BestBirthPid
	 *            Contents of the BEST_BIRTH_PID column
	 */
	public void setBestBirthPid(int BestBirthPid) {
		this.BestBirthPid = BestBirthPid;
	}

	/**
	 * Set the BestDeathPid field
	 *
	 * @param BestDeathPid
	 *            Contents of the BEST_DEATH_PID column
	 */
	public void setBestDeathPid(int BestDeathPid) {
		this.BestDeathPid = BestDeathPid;
	}

	/**
	 * Set the BestBioMaleParentPid field
	 *
	 * @param BestBioMaleParentPid
	 *            Contents of the BEST_BIO_MALE_PARENT_PID column
	 */
	public void setBestBioMaleParentPid(int BestBioMaleParentPid) {
		this.BestBioMaleParentPid = BestBioMaleParentPid;
	}

	/**
	 * Set the BestBioFemaleParentPid field
	 *
	 * @param BestBioFemaleParentPid
	 *            Contents of the BEST_BIO_FEMALE_PARENT_PID column
	 */
	public void setBestBioFemaleParentPid(int BestBioFemaleParentPid) {
		this.BestBioFemaleParentPid = BestBioFemaleParentPid;
	}

	/**
	 * Set the UseBioMaleParent field
	 *
	 * @param UseBioMaleParent
	 *            Contents of the USE_BIO_MALE_PARENT column
	 */
	public void setUseBioMaleParent(boolean UseBioMaleParent) {
		this.UseBioMaleParent = UseBioMaleParent;
	}

	/**
	 * Set the UseBioFemaleParent field
	 *
	 * @param UseBioFemaleParent
	 *            Contents of the USE_BIO_FEMALE_PARENT column
	 */
	public void setUseBioFemaleParent(boolean UseBioFemaleParent) {
		this.UseBioFemaleParent = UseBioFemaleParent;
	}

	/**
	 * Set the BestNonBioParent1Pid field
	 *
	 * @param BestNonBioParent1Pid
	 *            Contents of the BEST_NON_BIO_PARENT1_PID column
	 */
	public void setBestNonBioParent1Pid(int BestNonBioParent1Pid) {
		this.BestNonBioParent1Pid = BestNonBioParent1Pid;
	}

	/**
	 * Set the BestNonBioParent2Pid field
	 *
	 * @param BestNonBioParent2Pid
	 *            Contents of the BEST_NON_BIO_PARENT2_PID column
	 */
	public void setBestNonBioParent2Pid(int BestNonBioParent2Pid) {
		this.BestNonBioParent2Pid = BestNonBioParent2Pid;
	}

	/**
	 * Set the BestImagePid field
	 *
	 * @param BestImagePid
	 *            Contents of the BEST_IMAGE_PID column
	 */
	public void setBestImagePid(int BestImagePid) {
		this.BestImagePid = BestImagePid;
	}

	/**
	 * Set the SexKey field
	 *
	 * @param SexKey
	 *            Contents of the SEX_KEY column
	 */
	public void setSexKey(int SexKey) {
		this.SexKey = SexKey;
	}

	/**
	 * Set the LivingKey field
	 *
	 * @param LivingKey
	 *            Contents of the LIVING_KEY column
	 */
	public void setLivingKey(int LivingKey) {
		this.LivingKey = LivingKey;
	}

	/**
	 * Set the SpermProviderIssueOrder field
	 *
	 * @param SpermProviderIssueOrder
	 *            Contents of the SPERM_PROVIDER_ISSUE_ORDER column
	 */
	public void setSpermProviderIssueOrder(short SpermProviderIssueOrder) {
		this.SpermProviderIssueOrder = SpermProviderIssueOrder;
	}

	/**
	 * Set the EggProviderIssueOrder field
	 *
	 * @param EggProviderIssueOrder
	 *            Contents of the EGG_PROVIDER_ISSUE_ORDER column
	 */
	public void setEggProviderIssueOrder(short EggProviderIssueOrder) {
		this.EggProviderIssueOrder = EggProviderIssueOrder;
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

	/**
	 * Set the Flags field
	 *
	 * @param Flags
	 *            Contents of the FLAGS column
	 */
	public void setFlags(byte[] Flags) {
		this.Flags = Flags;
	}

}
