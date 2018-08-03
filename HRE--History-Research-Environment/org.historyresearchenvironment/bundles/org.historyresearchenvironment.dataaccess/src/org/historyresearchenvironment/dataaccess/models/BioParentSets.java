package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the BIO_PARENT_SETS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class BioParentSets extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "BIO_PARENT_SET_PID, " + "IS_SYSTEM, " + "VISIBLE_ID, " + "BIO_SUB_TYPE_KEY, " + "OCCASN_SUB_TYPE_KEY, "
			+ "OCCASN_PID, " + "SPERM_PROVIDER_PID, " + "EGG_PROVIDER_PID, " + "MITO_PROVIDER_PID, "
			+ "UTERUS_PROVIDER_PID, " + "SOCIAL_PARENT1_PID, "
			+ "SOCIAL_PARENT2_PID FROM PUBLIC.BIO_PARENT_SETS WHERE BIO_PARENT_SET_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "BIO_PARENT_SET_PID, " + "IS_SYSTEM, " + "VISIBLE_ID, " + "BIO_SUB_TYPE_KEY, " + "OCCASN_SUB_TYPE_KEY, "
			+ "OCCASN_PID, " + "SPERM_PROVIDER_PID, " + "EGG_PROVIDER_PID, " + "MITO_PROVIDER_PID, "
			+ "UTERUS_PROVIDER_PID, " + "SOCIAL_PARENT1_PID, " + "SOCIAL_PARENT2_PID FROM PUBLIC.BIO_PARENT_SETS";

	private static final String INSERT = "INSERT INTO PUBLIC.BIO_PARENT_SETS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "BIO_PARENT_SET_PID, " + "IS_SYSTEM, " + "VISIBLE_ID, " + "BIO_SUB_TYPE_KEY, "
			+ "OCCASN_SUB_TYPE_KEY, " + "OCCASN_PID, " + "SPERM_PROVIDER_PID, " + "EGG_PROVIDER_PID, "
			+ "MITO_PROVIDER_PID, " + "UTERUS_PROVIDER_PID, " + "SOCIAL_PARENT1_PID, "
			+ "SOCIAL_PARENT2_PID) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.BIO_PARENT_SETSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "VISIBLE_ID = ?, " + "BIO_SUB_TYPE_KEY = ?, "
			+ "OCCASN_SUB_TYPE_KEY = ?, " + "OCCASN_PID = ?, " + "SPERM_PROVIDER_PID = ?, " + "EGG_PROVIDER_PID = ?, "
			+ "MITO_PROVIDER_PID = ?, " + "UTERUS_PROVIDER_PID = ?, " + "SOCIAL_PARENT1_PID = ?, "
			+ "SOCIAL_PARENT2_PID = ? WHERE BIO_PARENT_SET_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.BIO_PARENT_SETS WHERE BIO_PARENT_SET_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.BIO_PARENT_SETS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int BioParentSetPid;
	private boolean IsSystem;
	private int VisibleId;
	private short BioSubTypeKey;
	private short OccasnSubTypeKey;
	private int OccasnPid;
	private int SpermProviderPid;
	private int EggProviderPid;
	private int MitoProviderPid;
	private int UterusProviderPid;
	private int SocialParent1Pid;
	private int SocialParent2Pid;
	private BioParentSets model;

	public BioParentSets() throws SQLException {
	}

	public BioParentSets(int BioParentSetPid) throws SQLException {
		super();
		this.BioParentSetPid = BioParentSetPid;
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
			model = new BioParentSets();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setBioParentSetPid(rs.getInt("BIO_PARENT_SET_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setVisibleId(rs.getInt("VISIBLE_ID"));
			model.setBioSubTypeKey(rs.getShort("BIO_SUB_TYPE_KEY"));
			model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
			model.setOccasnPid(rs.getInt("OCCASN_PID"));
			model.setSpermProviderPid(rs.getInt("SPERM_PROVIDER_PID"));
			model.setEggProviderPid(rs.getInt("EGG_PROVIDER_PID"));
			model.setMitoProviderPid(rs.getInt("MITO_PROVIDER_PID"));
			model.setUterusProviderPid(rs.getInt("UTERUS_PROVIDER_PID"));
			model.setSocialParent1Pid(rs.getInt("SOCIAL_PARENT1_PID"));
			model.setSocialParent2Pid(rs.getInt("SOCIAL_PARENT2_PID"));
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
			model.setBioParentSetPid(rs.getInt("BIO_PARENT_SET_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setVisibleId(rs.getInt("VISIBLE_ID"));
			model.setBioSubTypeKey(rs.getShort("BIO_SUB_TYPE_KEY"));
			model.setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
			model.setOccasnPid(rs.getInt("OCCASN_PID"));
			model.setSpermProviderPid(rs.getInt("SPERM_PROVIDER_PID"));
			model.setEggProviderPid(rs.getInt("EGG_PROVIDER_PID"));
			model.setMitoProviderPid(rs.getInt("MITO_PROVIDER_PID"));
			model.setUterusProviderPid(rs.getInt("UTERUS_PROVIDER_PID"));
			model.setSocialParent1Pid(rs.getInt("SOCIAL_PARENT1_PID"));
			model.setSocialParent2Pid(rs.getInt("SOCIAL_PARENT2_PID"));
		}
		return this;
	}

	public int getBioParentSetPid() {
		return this.BioParentSetPid;
	}

	public short getBioSubTypeKey() {
		return this.BioSubTypeKey;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public int getEggProviderPid() {
		return this.EggProviderPid;
	}

	public boolean getIsSystem() {
		return this.IsSystem;
	}

	public int getMitoProviderPid() {
		return this.MitoProviderPid;
	}

	public int getOccasnPid() {
		return this.OccasnPid;
	}

	public short getOccasnSubTypeKey() {
		return this.OccasnSubTypeKey;
	}

	public int getRecordNum() {
		return this.RecordNum;
	}

	public short getSetKey() {
		return this.SetKey;
	}

	public int getSocialParent1Pid() {
		return this.SocialParent1Pid;
	}

	public int getSocialParent2Pid() {
		return this.SocialParent2Pid;
	}

	public int getSpermProviderPid() {
		return this.SpermProviderPid;
	}

	public int getUterusProviderPid() {
		return this.UterusProviderPid;
	}

	public int getVisibleId() {
		return this.VisibleId;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((BioParentSets) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((BioParentSets) model).setSetKey(rs.getShort("SET_KEY"));
		((BioParentSets) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((BioParentSets) model).setBioParentSetPid(rs.getInt("BIO_PARENT_SET_PID"));
		((BioParentSets) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((BioParentSets) model).setVisibleId(rs.getInt("VISIBLE_ID"));
		((BioParentSets) model).setBioSubTypeKey(rs.getShort("BIO_SUB_TYPE_KEY"));
		((BioParentSets) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
		((BioParentSets) model).setOccasnPid(rs.getInt("OCCASN_PID"));
		((BioParentSets) model).setSpermProviderPid(rs.getInt("SPERM_PROVIDER_PID"));
		((BioParentSets) model).setEggProviderPid(rs.getInt("EGG_PROVIDER_PID"));
		((BioParentSets) model).setMitoProviderPid(rs.getInt("MITO_PROVIDER_PID"));
		((BioParentSets) model).setUterusProviderPid(rs.getInt("UTERUS_PROVIDER_PID"));
		((BioParentSets) model).setSocialParent1Pid(rs.getInt("SOCIAL_PARENT1_PID"));
		((BioParentSets) model).setSocialParent2Pid(rs.getInt("SOCIAL_PARENT2_PID"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((BioParentSets) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((BioParentSets) model).setSetKey(rs.getShort("SET_KEY"));
		((BioParentSets) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((BioParentSets) model).setBioParentSetPid(rs.getInt("BIO_PARENT_SET_PID"));
		((BioParentSets) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((BioParentSets) model).setVisibleId(rs.getInt("VISIBLE_ID"));
		((BioParentSets) model).setBioSubTypeKey(rs.getShort("BIO_SUB_TYPE_KEY"));
		((BioParentSets) model).setOccasnSubTypeKey(rs.getShort("OCCASN_SUB_TYPE_KEY"));
		((BioParentSets) model).setOccasnPid(rs.getInt("OCCASN_PID"));
		((BioParentSets) model).setSpermProviderPid(rs.getInt("SPERM_PROVIDER_PID"));
		((BioParentSets) model).setEggProviderPid(rs.getInt("EGG_PROVIDER_PID"));
		((BioParentSets) model).setMitoProviderPid(rs.getInt("MITO_PROVIDER_PID"));
		((BioParentSets) model).setUterusProviderPid(rs.getInt("UTERUS_PROVIDER_PID"));
		((BioParentSets) model).setSocialParent1Pid(rs.getInt("SOCIAL_PARENT1_PID"));
		((BioParentSets) model).setSocialParent2Pid(rs.getInt("SOCIAL_PARENT2_PID"));
		ps.executeUpdate();
	}

	public void setBioParentSetPid(int BioParentSetPid) {
		this.BioParentSetPid = BioParentSetPid;
	}

	public void setBioSubTypeKey(short BioSubTypeKey) {
		this.BioSubTypeKey = BioSubTypeKey;
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setEggProviderPid(int EggProviderPid) {
		this.EggProviderPid = EggProviderPid;
	}

	public void setIsSystem(boolean IsSystem) {
		this.IsSystem = IsSystem;
	}

	public void setMitoProviderPid(int MitoProviderPid) {
		this.MitoProviderPid = MitoProviderPid;
	}

	public void setOccasnPid(int OccasnPid) {
		this.OccasnPid = OccasnPid;
	}

	public void setOccasnSubTypeKey(short OccasnSubTypeKey) {
		this.OccasnSubTypeKey = OccasnSubTypeKey;
	}

	public void setRecordNum(int RecordNum) {
		this.RecordNum = RecordNum;
	}

	public void setSetKey(short SetKey) {
		this.SetKey = SetKey;
	}

	public void setSocialParent1Pid(int SocialParent1Pid) {
		this.SocialParent1Pid = SocialParent1Pid;
	}

	public void setSocialParent2Pid(int SocialParent2Pid) {
		this.SocialParent2Pid = SocialParent2Pid;
	}

	public void setSpermProviderPid(int SpermProviderPid) {
		this.SpermProviderPid = SpermProviderPid;
	}

	public void setUterusProviderPid(int UterusProviderPid) {
		this.UterusProviderPid = UterusProviderPid;
	}

	public void setVisibleId(int VisibleId) {
		this.VisibleId = VisibleId;
	}

}
