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

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public SubsetTypeDefns() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param SubsetTypeDefnPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

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

	/**
	 * Get the AncestorGens field.
	 *
	 * @return Contents of the ANCESTOR_GENS column
	 */
	public short getAncestorGens() {
		return this.AncestorGens;
	}

	/**
	 * Get the BioFlagState field.
	 *
	 * @return Contents of the BIO_FLAG_STATE column
	 */
	public short getBioFlagState() {
		return this.BioFlagState;
	}

	/**
	 * Get the BioFocusPid field.
	 *
	 * @return Contents of the BIO_FOCUS_PID column
	 */
	public int getBioFocusPid() {
		return this.BioFocusPid;
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
	 * Get the DescendantGens field.
	 *
	 * @return Contents of the DESCENDANT_GENS column
	 */
	public short getDescendantGens() {
		return this.DescendantGens;
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
	 * Get the ExcludeMixedSexLinks field.
	 *
	 * @return Contents of the EXCLUDE_MIXED_SEX_LINKS column
	 */
	public boolean getExcludeMixedSexLinks() {
		return this.ExcludeMixedSexLinks;
	}

	/**
	 * Get the ExcludeNonGeneticLinks field.
	 *
	 * @return Contents of the EXCLUDE_NON_GENETIC_LINKS column
	 */
	public boolean getExcludeNonGeneticLinks() {
		return this.ExcludeNonGeneticLinks;
	}

	/**
	 * Get the Focus1SubTypeKey field.
	 *
	 * @return Contents of the FOCUS1_SUB_TYPE_KEY column
	 */
	public short getFocus1SubTypeKey() {
		return this.Focus1SubTypeKey;
	}

	/**
	 * Get the Focus1TypeKey field.
	 *
	 * @return Contents of the FOCUS1_TYPE_KEY column
	 */
	public short getFocus1TypeKey() {
		return this.Focus1TypeKey;
	}

	/**
	 * Get the Focus2SubTypeKey field.
	 *
	 * @return Contents of the FOCUS2_SUB_TYPE_KEY column
	 */
	public short getFocus2SubTypeKey() {
		return this.Focus2SubTypeKey;
	}

	/**
	 * Get the Focus2TypeKey field.
	 *
	 * @return Contents of the FOCUS2_TYPE_KEY column
	 */
	public short getFocus2TypeKey() {
		return this.Focus2TypeKey;
	}

	/**
	 * Get the IsAll field.
	 *
	 * @return Contents of the IS_ALL column
	 */
	public boolean getIsAll() {
		return this.IsAll;
	}

	/**
	 * Get the IsBioNetwork field.
	 *
	 * @return Contents of the IS_BIO_NETWORK column
	 */
	public boolean getIsBioNetwork() {
		return this.IsBioNetwork;
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
	 * Get the IsMixed field.
	 *
	 * @return Contents of the IS_MIXED column
	 */
	public boolean getIsMixed() {
		return this.IsMixed;
	}

	/**
	 * Get the IsSingle field.
	 *
	 * @return Contents of the IS_SINGLE column
	 */
	public boolean getIsSingle() {
		return this.IsSingle;
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
	 * Get the SubsetTypeDefnPid field.
	 *
	 * @return Contents of the SUBSET_TYPE_DEFN_PID column
	 */
	public int getSubsetTypeDefnPid() {
		return this.SubsetTypeDefnPid;
	}

	/**
	 * Get the UseBioFlag field.
	 *
	 * @return Contents of the USE_BIO_FLAG column
	 */
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

	/**
	 * Set the AncestorGens field
	 *
	 * @param AncestorGens
	 *            Contents of the ANCESTOR_GENS column
	 */
	public void setAncestorGens(short AncestorGens) {
		this.AncestorGens = AncestorGens;
	}

	/**
	 * Set the BioFlagState field
	 *
	 * @param BioFlagState
	 *            Contents of the BIO_FLAG_STATE column
	 */
	public void setBioFlagState(short BioFlagState) {
		this.BioFlagState = BioFlagState;
	}

	/**
	 * Set the BioFocusPid field
	 *
	 * @param BioFocusPid
	 *            Contents of the BIO_FOCUS_PID column
	 */
	public void setBioFocusPid(int BioFocusPid) {
		this.BioFocusPid = BioFocusPid;
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
	 * Set the DescendantGens field
	 *
	 * @param DescendantGens
	 *            Contents of the DESCENDANT_GENS column
	 */
	public void setDescendantGens(short DescendantGens) {
		this.DescendantGens = DescendantGens;
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
	 * Set the ExcludeMixedSexLinks field
	 *
	 * @param ExcludeMixedSexLinks
	 *            Contents of the EXCLUDE_MIXED_SEX_LINKS column
	 */
	public void setExcludeMixedSexLinks(boolean ExcludeMixedSexLinks) {
		this.ExcludeMixedSexLinks = ExcludeMixedSexLinks;
	}

	/**
	 * Set the ExcludeNonGeneticLinks field
	 *
	 * @param ExcludeNonGeneticLinks
	 *            Contents of the EXCLUDE_NON_GENETIC_LINKS column
	 */
	public void setExcludeNonGeneticLinks(boolean ExcludeNonGeneticLinks) {
		this.ExcludeNonGeneticLinks = ExcludeNonGeneticLinks;
	}

	/**
	 * Set the Focus1SubTypeKey field
	 *
	 * @param Focus1SubTypeKey
	 *            Contents of the FOCUS1_SUB_TYPE_KEY column
	 */
	public void setFocus1SubTypeKey(short Focus1SubTypeKey) {
		this.Focus1SubTypeKey = Focus1SubTypeKey;
	}

	/**
	 * Set the Focus1TypeKey field
	 *
	 * @param Focus1TypeKey
	 *            Contents of the FOCUS1_TYPE_KEY column
	 */
	public void setFocus1TypeKey(short Focus1TypeKey) {
		this.Focus1TypeKey = Focus1TypeKey;
	}

	/**
	 * Set the Focus2SubTypeKey field
	 *
	 * @param Focus2SubTypeKey
	 *            Contents of the FOCUS2_SUB_TYPE_KEY column
	 */
	public void setFocus2SubTypeKey(short Focus2SubTypeKey) {
		this.Focus2SubTypeKey = Focus2SubTypeKey;
	}

	/**
	 * Set the Focus2TypeKey field
	 *
	 * @param Focus2TypeKey
	 *            Contents of the FOCUS2_TYPE_KEY column
	 */
	public void setFocus2TypeKey(short Focus2TypeKey) {
		this.Focus2TypeKey = Focus2TypeKey;
	}

	/**
	 * Set the IsAll field
	 *
	 * @param IsAll
	 *            Contents of the IS_ALL column
	 */
	public void setIsAll(boolean IsAll) {
		this.IsAll = IsAll;
	}

	/**
	 * Set the IsBioNetwork field
	 *
	 * @param IsBioNetwork
	 *            Contents of the IS_BIO_NETWORK column
	 */
	public void setIsBioNetwork(boolean IsBioNetwork) {
		this.IsBioNetwork = IsBioNetwork;
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
	 * Set the IsMixed field
	 *
	 * @param IsMixed
	 *            Contents of the IS_MIXED column
	 */
	public void setIsMixed(boolean IsMixed) {
		this.IsMixed = IsMixed;
	}

	/**
	 * Set the IsSingle field
	 *
	 * @param IsSingle
	 *            Contents of the IS_SINGLE column
	 */
	public void setIsSingle(boolean IsSingle) {
		this.IsSingle = IsSingle;
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
	 * Set the SubsetTypeDefnPid field
	 *
	 * @param SubsetTypeDefnPid
	 *            Contents of the SUBSET_TYPE_DEFN_PID column
	 */
	public void setSubsetTypeDefnPid(int SubsetTypeDefnPid) {
		this.SubsetTypeDefnPid = SubsetTypeDefnPid;
	}

	/**
	 * Set the UseBioFlag field
	 *
	 * @param UseBioFlag
	 *            Contents of the USE_BIO_FLAG column
	 */
	public void setUseBioFlag(int UseBioFlag) {
		this.UseBioFlag = UseBioFlag;
	}

}
