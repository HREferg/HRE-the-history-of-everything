package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the BIOS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class Bios extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
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

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int BioPid;
	private boolean IsSystem;
	private int VisibleId;
	private short SubTypeKey;
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
	private short SexKey;
	private short LivingKey;
	private short SpermProviderIssueOrder;
	private short EggProviderIssueOrder;
	private String Surety;
	private byte[] Flags;
	private Bios model;

	public Bios() throws SQLException {
	}

	public Bios(int BioPid) throws SQLException {
		super();
		this.BioPid = BioPid;
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
			model.setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
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
			model.setSexKey(rs.getShort("SEX_KEY"));
			model.setLivingKey(rs.getShort("LIVING_KEY"));
			model.setSpermProviderIssueOrder(rs.getShort("SPERM_PROVIDER_ISSUE_ORDER"));
			model.setEggProviderIssueOrder(rs.getShort("EGG_PROVIDER_ISSUE_ORDER"));
			model.setSurety(rs.getString("SURETY"));
			model.setFlags(rs.getBytes("FLAGS"));
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
			model.setBioPid(rs.getInt("BIO_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setVisibleId(rs.getInt("VISIBLE_ID"));
			model.setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
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
			model.setSexKey(rs.getShort("SEX_KEY"));
			model.setLivingKey(rs.getShort("LIVING_KEY"));
			model.setSpermProviderIssueOrder(rs.getShort("SPERM_PROVIDER_ISSUE_ORDER"));
			model.setEggProviderIssueOrder(rs.getShort("EGG_PROVIDER_ISSUE_ORDER"));
			model.setSurety(rs.getString("SURETY"));
			model.setFlags(rs.getBytes("FLAGS"));
		}
		return this;
	}

	public int getBestBioFemaleParentPid() {
		return this.BestBioFemaleParentPid;
	}

	public int getBestBioMaleParentPid() {
		return this.BestBioMaleParentPid;
	}

	public int getBestBirthPid() {
		return this.BestBirthPid;
	}

	public int getBestDeathPid() {
		return this.BestDeathPid;
	}

	public int getBestImagePid() {
		return this.BestImagePid;
	}

	public int getBestNamePid() {
		return this.BestNamePid;
	}

	public int getBestNonBioParent1Pid() {
		return this.BestNonBioParent1Pid;
	}

	public int getBestNonBioParent2Pid() {
		return this.BestNonBioParent2Pid;
	}

	public int getBioPid() {
		return this.BioPid;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public short getEggProviderIssueOrder() {
		return this.EggProviderIssueOrder;
	}

	public byte[] getFlags() {
		return this.Flags;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public short getLivingKey() {
		return this.LivingKey;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public short getSexKey() {
		return this.SexKey;
	}

	public short getSpermProviderIssueOrder() {
		return this.SpermProviderIssueOrder;
	}

	public short getSubTypeKey() {
		return this.SubTypeKey;
	}

	public String getSurety() {
		return this.Surety;
	}

	public boolean getUseBioFemaleParent() {
		return this.UseBioFemaleParent;
	}

	public boolean getUseBioMaleParent() {
		return this.UseBioMaleParent;
	}

	public int getVisibleId() {
		return this.VisibleId;
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
		((Bios) model).setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
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
		((Bios) model).setSexKey(rs.getShort("SEX_KEY"));
		((Bios) model).setLivingKey(rs.getShort("LIVING_KEY"));
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
		((Bios) model).setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
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
		((Bios) model).setSexKey(rs.getShort("SEX_KEY"));
		((Bios) model).setLivingKey(rs.getShort("LIVING_KEY"));
		((Bios) model).setSpermProviderIssueOrder(rs.getShort("SPERM_PROVIDER_ISSUE_ORDER"));
		((Bios) model).setEggProviderIssueOrder(rs.getShort("EGG_PROVIDER_ISSUE_ORDER"));
		((Bios) model).setSurety(rs.getString("SURETY"));
		((Bios) model).setFlags(rs.getBytes("FLAGS"));
		ps.executeUpdate();
	}

	public void setBestBioFemaleParentPid(int BestBioFemaleParentPid) {
		this.BestBioFemaleParentPid = BestBioFemaleParentPid;
	}

	public void setBestBioMaleParentPid(int BestBioMaleParentPid) {
		this.BestBioMaleParentPid = BestBioMaleParentPid;
	}

	public void setBestBirthPid(int BestBirthPid) {
		this.BestBirthPid = BestBirthPid;
	}

	public void setBestDeathPid(int BestDeathPid) {
		this.BestDeathPid = BestDeathPid;
	}

	public void setBestImagePid(int BestImagePid) {
		this.BestImagePid = BestImagePid;
	}

	public void setBestNamePid(int BestNamePid) {
		this.BestNamePid = BestNamePid;
	}

	public void setBestNonBioParent1Pid(int BestNonBioParent1Pid) {
		this.BestNonBioParent1Pid = BestNonBioParent1Pid;
	}

	public void setBestNonBioParent2Pid(int BestNonBioParent2Pid) {
		this.BestNonBioParent2Pid = BestNonBioParent2Pid;
	}

	public void setBioPid(int BioPid) {
		this.BioPid = BioPid;
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setEggProviderIssueOrder(short EggProviderIssueOrder) {
		this.EggProviderIssueOrder = EggProviderIssueOrder;
	}

	public void setFlags(byte[] Flags) {
		this.Flags = Flags;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setLivingKey(short LivingKey) {
		this.LivingKey = LivingKey;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setSexKey(short SexKey) {
		this.SexKey = SexKey;
	}

	public void setSpermProviderIssueOrder(short SpermProviderIssueOrder) {
		this.SpermProviderIssueOrder = SpermProviderIssueOrder;
	}

	public void setSubTypeKey(short SubTypeKey) {
		this.SubTypeKey = SubTypeKey;
	}

	public void setSurety(String Surety) {
		this.Surety = Surety;
	}

	public void setUseBioFemaleParent(boolean UseBioFemaleParent) {
		this.UseBioFemaleParent = UseBioFemaleParent;
	}

	public void setUseBioMaleParent(boolean UseBioMaleParent) {
		this.UseBioMaleParent = UseBioMaleParent;
	}

	public void setVisibleId(int VisibleId) {
		this.VisibleId = VisibleId;
	}

}
