package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the GUI_ELEMENTS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class GuiElements extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "GUI_ELEMENT_PID, "
			+ "PLUGIN_KEY, " + "GUI_SCREEN_PID FROM PUBLIC.GUI_ELEMENTS WHERE GUI_ELEMENT_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "GUI_ELEMENT_PID, " + "PLUGIN_KEY, " + "GUI_SCREEN_PID FROM PUBLIC.GUI_ELEMENTS";

	private static final String INSERT = "INSERT INTO PUBLIC.GUI_ELEMENTS( " + "RECORD_NUM, " + "SET_KEY, "
			+ "COMMIT_PID, " + "GUI_ELEMENT_PID, " + "PLUGIN_KEY, " + "GUI_SCREEN_PID) VALUES (?, " + "?, " + "?, "
			+ "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.GUI_ELEMENTSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "PLUGIN_KEY = ?, " + "GUI_SCREEN_PID = ? WHERE GUI_ELEMENT_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.GUI_ELEMENTS WHERE GUI_ELEMENT_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.GUI_ELEMENTS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int GuiElementPid;
	private short PluginKey;
	private short GuiScreenPid;
	private GuiElements model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public GuiElements() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param GuiElementPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public GuiElements(int GuiElementPid) throws SQLException {
		super();
		this.GuiElementPid = GuiElementPid;
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
			model = new GuiElements();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setGuiElementPid(rs.getInt("GUI_ELEMENT_PID"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setGuiScreenPid(rs.getShort("GUI_SCREEN_PID"));
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
			model.setGuiElementPid(rs.getInt("GUI_ELEMENT_PID"));
			model.setPluginKey(rs.getShort("PLUGIN_KEY"));
			model.setGuiScreenPid(rs.getShort("GUI_SCREEN_PID"));
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
	 * Get the GuiElementPid field.
	 *
	 * @return Contents of the GUI_ELEMENT_PID column
	 */
	public int getGuiElementPid() {
		return this.GuiElementPid;
	}

	/**
	 * Get the GuiScreenPid field.
	 *
	 * @return Contents of the GUI_SCREEN_PID column
	 */
	public short getGuiScreenPid() {
		return this.GuiScreenPid;
	}

	/**
	 * Get the PluginKey field.
	 *
	 * @return Contents of the PLUGIN_KEY column
	 */
	public short getPluginKey() {
		return this.PluginKey;
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
		((GuiElements) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((GuiElements) model).setSetKey(rs.getShort("SET_KEY"));
		((GuiElements) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((GuiElements) model).setGuiElementPid(rs.getInt("GUI_ELEMENT_PID"));
		((GuiElements) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((GuiElements) model).setGuiScreenPid(rs.getShort("GUI_SCREEN_PID"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((GuiElements) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((GuiElements) model).setSetKey(rs.getShort("SET_KEY"));
		((GuiElements) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((GuiElements) model).setGuiElementPid(rs.getInt("GUI_ELEMENT_PID"));
		((GuiElements) model).setPluginKey(rs.getShort("PLUGIN_KEY"));
		((GuiElements) model).setGuiScreenPid(rs.getShort("GUI_SCREEN_PID"));
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
	 * Set the GuiElementPid field
	 *
	 * @param GuiElementPid
	 *            Contents of the GUI_ELEMENT_PID column
	 */
	public void setGuiElementPid(int GuiElementPid) {
		this.GuiElementPid = GuiElementPid;
	}

	/**
	 * Set the GuiScreenPid field
	 *
	 * @param GuiScreenPid
	 *            Contents of the GUI_SCREEN_PID column
	 */
	public void setGuiScreenPid(short GuiScreenPid) {
		this.GuiScreenPid = GuiScreenPid;
	}

	/**
	 * Set the PluginKey field
	 *
	 * @param PluginKey
	 *            Contents of the PLUGIN_KEY column
	 */
	public void setPluginKey(short PluginKey) {
		this.PluginKey = PluginKey;
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
