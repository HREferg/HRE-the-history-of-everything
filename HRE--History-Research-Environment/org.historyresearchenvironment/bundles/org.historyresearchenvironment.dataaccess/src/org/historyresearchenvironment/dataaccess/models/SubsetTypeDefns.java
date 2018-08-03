package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the SUBSET_TYPE_DEFNS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class SubsetTypeDefns extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSET_TYPE_DEFN_PID, " + "FOCUS1_TYPE_KEY, " + "FOCUS1_SUB_TYPE_KEY, " + "IS_ALL, " + "IS_SINGLE, "
			+ "FOCUS2_TYPE_KEY, " + "FOCUS2_SUB_TYPE_KEY, " + "IS_MIXED, " + "IS_BIO_NETWORK, " + "BIO_FOCUS_PID, "
			+ "ANCESTOR_GENS, " + "DESCENDANT_GENS, " + "EXCLUDE_NON_GENETIC_LINKS, " + "EXCLUDE_MIXED_SEX_LINKS, "
			+ "USE_BIO_FLAG, " + "BIO_FLAG_STATE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.SUBSET_TYPE_DEFNS WHERE SUBSET_TYPE_DEFN_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "SUBSET_TYPE_DEFN_PID, " + "FOCUS1_TYPE_KEY, " + "FOCUS1_SUB_TYPE_KEY, " + "IS_ALL, " + "IS_SINGLE, "
			+ "FOCUS2_TYPE_KEY, " + "FOCUS2_SUB_TYPE_KEY, " + "IS_MIXED, " + "IS_BIO_NETWORK, " + "BIO_FOCUS_PID, "
			+ "ANCESTOR_GENS, " + "DESCENDANT_GENS, " + "EXCLUDE_NON_GENETIC_LINKS, " + "EXCLUDE_MIXED_SEX_LINKS, "
			+ "USE_BIO_FLAG, " + "BIO_FLAG_STATE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, " + "IS_DEFAULT, "
			+ "SHOW FROM PUBLIC.SUBSET_TYPE_DEFNS";

	private static final String INSERT = "INSERT INTO PUBLIC.SUBSET_TYPE_DEFNS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "SUBSET_TYPE_DEFN_PID, " + "FOCUS1_TYPE_KEY, " + "FOCUS1_SUB_TYPE_KEY, " + "IS_ALL, "
			+ "IS_SINGLE, " + "FOCUS2_TYPE_KEY, " + "FOCUS2_SUB_TYPE_KEY, " + "IS_MIXED, " + "IS_BIO_NETWORK, "
			+ "BIO_FOCUS_PID, " + "ANCESTOR_GENS, " + "DESCENDANT_GENS, " + "EXCLUDE_NON_GENETIC_LINKS, "
			+ "EXCLUDE_MIXED_SEX_LINKS, " + "USE_BIO_FLAG, " + "BIO_FLAG_STATE, " + "REMINDER_KEY, " + "DISPLAY_ORDER, "
			+ "IS_DEFAULT, " + "SHOW) VALUES (?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?)";

	private static final String UPDATE = "UPDATE PUBLIC.SUBSET_TYPE_DEFNSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "FOCUS1_TYPE_KEY = ?, " + "FOCUS1_SUB_TYPE_KEY = ?, " + "IS_ALL = ?, "
			+ "IS_SINGLE = ?, " + "FOCUS2_TYPE_KEY = ?, " + "FOCUS2_SUB_TYPE_KEY = ?, " + "IS_MIXED = ?, "
			+ "IS_BIO_NETWORK = ?, " + "BIO_FOCUS_PID = ?, " + "ANCESTOR_GENS = ?, " + "DESCENDANT_GENS = ?, "
			+ "EXCLUDE_NON_GENETIC_LINKS = ?, " + "EXCLUDE_MIXED_SEX_LINKS = ?, " + "USE_BIO_FLAG = ?, "
			+ "BIO_FLAG_STATE = ?, " + "REMINDER_KEY = ?, " + "DISPLAY_ORDER = ?, " + "IS_DEFAULT = ?, "
			+ "SHOW = ? WHERE SUBSET_TYPE_DEFN_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.SUBSET_TYPE_DEFNS WHERE SUBSET_TYPE_DEFN_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.SUBSET_TYPE_DEFNS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int SubsetTypeDefnPid;
	private short Focus1TypeKey;
	private short Focus1SubTypeKey;
	private boolean IsAll;
	private boolean IsSingle;
	private short Focus2TypeKey;
	private short Focus2SubTypeKey;
	private boolean IsMixed;
	private boolean IsBioNetwork;
	private int BioFocusPid;
	private short AncestorGens;
	private short DescendantGens;
	private boolean ExcludeNonGeneticLinks;
	private boolean ExcludeMixedSexLinks;
	private int UseBioFlag;
	private short BioFlagState;
	private short ReminderKey;
	private short DisplayOrder;
	private boolean IsDefault;
	private boolean Show;
	private SubsetTypeDefns model;

	public SubsetTypeDefns() throws SQLException {
	}

	public SubsetTypeDefns(int SubsetTypeDefnPid) throws SQLException {
		super();
		this.SubsetTypeDefnPid = SubsetTypeDefnPid;
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
			model = new SubsetTypeDefns();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setSubsetTypeDefnPid(rs.getInt("SUBSET_TYPE_DEFN_PID"));
			model.setFocus1TypeKey(rs.getShort("FOCUS1_TYPE_KEY"));
			model.setFocus1SubTypeKey(rs.getShort("FOCUS1_SUB_TYPE_KEY"));
			model.setIsAll(rs.getBoolean("IS_ALL"));
			model.setIsSingle(rs.getBoolean("IS_SINGLE"));
			model.setFocus2TypeKey(rs.getShort("FOCUS2_TYPE_KEY"));
			model.setFocus2SubTypeKey(rs.getShort("FOCUS2_SUB_TYPE_KEY"));
			model.setIsMixed(rs.getBoolean("IS_MIXED"));
			model.setIsBioNetwork(rs.getBoolean("IS_BIO_NETWORK"));
			model.setBioFocusPid(rs.getInt("BIO_FOCUS_PID"));
			model.setAncestorGens(rs.getShort("ANCESTOR_GENS"));
			model.setDescendantGens(rs.getShort("DESCENDANT_GENS"));
			model.setExcludeNonGeneticLinks(rs.getBoolean("EXCLUDE_NON_GENETIC_LINKS"));
			model.setExcludeMixedSexLinks(rs.getBoolean("EXCLUDE_MIXED_SEX_LINKS"));
			model.setUseBioFlag(rs.getInt("USE_BIO_FLAG"));
			model.setBioFlagState(rs.getShort("BIO_FLAG_STATE"));
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
			model.setSubsetTypeDefnPid(rs.getInt("SUBSET_TYPE_DEFN_PID"));
			model.setFocus1TypeKey(rs.getShort("FOCUS1_TYPE_KEY"));
			model.setFocus1SubTypeKey(rs.getShort("FOCUS1_SUB_TYPE_KEY"));
			model.setIsAll(rs.getBoolean("IS_ALL"));
			model.setIsSingle(rs.getBoolean("IS_SINGLE"));
			model.setFocus2TypeKey(rs.getShort("FOCUS2_TYPE_KEY"));
			model.setFocus2SubTypeKey(rs.getShort("FOCUS2_SUB_TYPE_KEY"));
			model.setIsMixed(rs.getBoolean("IS_MIXED"));
			model.setIsBioNetwork(rs.getBoolean("IS_BIO_NETWORK"));
			model.setBioFocusPid(rs.getInt("BIO_FOCUS_PID"));
			model.setAncestorGens(rs.getShort("ANCESTOR_GENS"));
			model.setDescendantGens(rs.getShort("DESCENDANT_GENS"));
			model.setExcludeNonGeneticLinks(rs.getBoolean("EXCLUDE_NON_GENETIC_LINKS"));
			model.setExcludeMixedSexLinks(rs.getBoolean("EXCLUDE_MIXED_SEX_LINKS"));
			model.setUseBioFlag(rs.getInt("USE_BIO_FLAG"));
			model.setBioFlagState(rs.getShort("BIO_FLAG_STATE"));
			model.setReminderKey(rs.getShort("REMINDER_KEY"));
			model.setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
			model.setIsDefault(rs.getBoolean("IS_DEFAULT"));
			model.setShow(rs.getBoolean("SHOW"));
		}
		return this;
	}

	public short getAncestorGens() {
		return this.AncestorGens;
	}

	public short getBioFlagState() {
		return this.BioFlagState;
	}

	public int getBioFocusPid() {
		return this.BioFocusPid;
	}

	public int getCommitPid() {
		return this.CommitPid;
	}

	public short getDescendantGens() {
		return this.DescendantGens;
	}

	public short getDisplayOrder() {
		return this.DisplayOrder;
	}

	public boolean getExcludeMixedSexLinks() {
		return this.ExcludeMixedSexLinks;
	}

	public boolean getExcludeNonGeneticLinks() {
		return this.ExcludeNonGeneticLinks;
	}

	public short getFocus1SubTypeKey() {
		return this.Focus1SubTypeKey;
	}

	public short getFocus1TypeKey() {
		return this.Focus1TypeKey;
	}

	public short getFocus2SubTypeKey() {
		return this.Focus2SubTypeKey;
	}

	public short getFocus2TypeKey() {
		return this.Focus2TypeKey;
	}

	public boolean getIsAll() {
		return this.IsAll;
	}

	public boolean getIsBioNetwork() {
		return this.IsBioNetwork;
	}

	public boolean getIsDefault() {
		return this.IsDefault;
	}

	public boolean getIsMixed() {
		return this.IsMixed;
	}

	public boolean getIsSingle() {
		return this.IsSingle;
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

	public int getSubsetTypeDefnPid() {
		return this.SubsetTypeDefnPid;
	}

	public int getUseBioFlag() {
		return this.UseBioFlag;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((SubsetTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubsetTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubsetTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubsetTypeDefns) model).setSubsetTypeDefnPid(rs.getInt("SUBSET_TYPE_DEFN_PID"));
		((SubsetTypeDefns) model).setFocus1TypeKey(rs.getShort("FOCUS1_TYPE_KEY"));
		((SubsetTypeDefns) model).setFocus1SubTypeKey(rs.getShort("FOCUS1_SUB_TYPE_KEY"));
		((SubsetTypeDefns) model).setIsAll(rs.getBoolean("IS_ALL"));
		((SubsetTypeDefns) model).setIsSingle(rs.getBoolean("IS_SINGLE"));
		((SubsetTypeDefns) model).setFocus2TypeKey(rs.getShort("FOCUS2_TYPE_KEY"));
		((SubsetTypeDefns) model).setFocus2SubTypeKey(rs.getShort("FOCUS2_SUB_TYPE_KEY"));
		((SubsetTypeDefns) model).setIsMixed(rs.getBoolean("IS_MIXED"));
		((SubsetTypeDefns) model).setIsBioNetwork(rs.getBoolean("IS_BIO_NETWORK"));
		((SubsetTypeDefns) model).setBioFocusPid(rs.getInt("BIO_FOCUS_PID"));
		((SubsetTypeDefns) model).setAncestorGens(rs.getShort("ANCESTOR_GENS"));
		((SubsetTypeDefns) model).setDescendantGens(rs.getShort("DESCENDANT_GENS"));
		((SubsetTypeDefns) model).setExcludeNonGeneticLinks(rs.getBoolean("EXCLUDE_NON_GENETIC_LINKS"));
		((SubsetTypeDefns) model).setExcludeMixedSexLinks(rs.getBoolean("EXCLUDE_MIXED_SEX_LINKS"));
		((SubsetTypeDefns) model).setUseBioFlag(rs.getInt("USE_BIO_FLAG"));
		((SubsetTypeDefns) model).setBioFlagState(rs.getShort("BIO_FLAG_STATE"));
		((SubsetTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubsetTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubsetTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((SubsetTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((SubsetTypeDefns) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((SubsetTypeDefns) model).setSetKey(rs.getShort("SET_KEY"));
		((SubsetTypeDefns) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((SubsetTypeDefns) model).setSubsetTypeDefnPid(rs.getInt("SUBSET_TYPE_DEFN_PID"));
		((SubsetTypeDefns) model).setFocus1TypeKey(rs.getShort("FOCUS1_TYPE_KEY"));
		((SubsetTypeDefns) model).setFocus1SubTypeKey(rs.getShort("FOCUS1_SUB_TYPE_KEY"));
		((SubsetTypeDefns) model).setIsAll(rs.getBoolean("IS_ALL"));
		((SubsetTypeDefns) model).setIsSingle(rs.getBoolean("IS_SINGLE"));
		((SubsetTypeDefns) model).setFocus2TypeKey(rs.getShort("FOCUS2_TYPE_KEY"));
		((SubsetTypeDefns) model).setFocus2SubTypeKey(rs.getShort("FOCUS2_SUB_TYPE_KEY"));
		((SubsetTypeDefns) model).setIsMixed(rs.getBoolean("IS_MIXED"));
		((SubsetTypeDefns) model).setIsBioNetwork(rs.getBoolean("IS_BIO_NETWORK"));
		((SubsetTypeDefns) model).setBioFocusPid(rs.getInt("BIO_FOCUS_PID"));
		((SubsetTypeDefns) model).setAncestorGens(rs.getShort("ANCESTOR_GENS"));
		((SubsetTypeDefns) model).setDescendantGens(rs.getShort("DESCENDANT_GENS"));
		((SubsetTypeDefns) model).setExcludeNonGeneticLinks(rs.getBoolean("EXCLUDE_NON_GENETIC_LINKS"));
		((SubsetTypeDefns) model).setExcludeMixedSexLinks(rs.getBoolean("EXCLUDE_MIXED_SEX_LINKS"));
		((SubsetTypeDefns) model).setUseBioFlag(rs.getInt("USE_BIO_FLAG"));
		((SubsetTypeDefns) model).setBioFlagState(rs.getShort("BIO_FLAG_STATE"));
		((SubsetTypeDefns) model).setReminderKey(rs.getShort("REMINDER_KEY"));
		((SubsetTypeDefns) model).setDisplayOrder(rs.getShort("DISPLAY_ORDER"));
		((SubsetTypeDefns) model).setIsDefault(rs.getBoolean("IS_DEFAULT"));
		((SubsetTypeDefns) model).setShow(rs.getBoolean("SHOW"));
		ps.executeUpdate();
	}

	public void setAncestorGens(short AncestorGens) {
		this.AncestorGens = AncestorGens;
	}

	public void setBioFlagState(short BioFlagState) {
		this.BioFlagState = BioFlagState;
	}

	public void setBioFocusPid(int BioFocusPid) {
		this.BioFocusPid = BioFocusPid;
	}

	public void setCommitPid(int CommitPid) {
		this.CommitPid = CommitPid;
	}

	public void setDescendantGens(short DescendantGens) {
		this.DescendantGens = DescendantGens;
	}

	public void setDisplayOrder(short DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}

	public void setExcludeMixedSexLinks(boolean ExcludeMixedSexLinks) {
		this.ExcludeMixedSexLinks = ExcludeMixedSexLinks;
	}

	public void setExcludeNonGeneticLinks(boolean ExcludeNonGeneticLinks) {
		this.ExcludeNonGeneticLinks = ExcludeNonGeneticLinks;
	}

	public void setFocus1SubTypeKey(short Focus1SubTypeKey) {
		this.Focus1SubTypeKey = Focus1SubTypeKey;
	}

	public void setFocus1TypeKey(short Focus1TypeKey) {
		this.Focus1TypeKey = Focus1TypeKey;
	}

	public void setFocus2SubTypeKey(short Focus2SubTypeKey) {
		this.Focus2SubTypeKey = Focus2SubTypeKey;
	}

	public void setFocus2TypeKey(short Focus2TypeKey) {
		this.Focus2TypeKey = Focus2TypeKey;
	}

	public void setIsAll(boolean IsAll) {
		this.IsAll = IsAll;
	}

	public void setIsBioNetwork(boolean IsBioNetwork) {
		this.IsBioNetwork = IsBioNetwork;
	}

	public void setIsDefault(boolean IsDefault) {
		this.IsDefault = IsDefault;
	}

	public void setIsMixed(boolean IsMixed) {
		this.IsMixed = IsMixed;
	}

	public void setIsSingle(boolean IsSingle) {
		this.IsSingle = IsSingle;
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

	public void setSubsetTypeDefnPid(int SubsetTypeDefnPid) {
		this.SubsetTypeDefnPid = SubsetTypeDefnPid;
	}

	public void setUseBioFlag(int UseBioFlag) {
		this.UseBioFlag = UseBioFlag;
	}

}
