package org.historyresearchenvironment.dataaccess.models;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the DIGITALS database table.
 *
 * @version 2018-08-03
 * @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
 *
 */

public class Digitals extends AbstractHreDataModel {
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "DIGITAL_PID, "
			+ "IS_SYSTEM, " + "VISIBLE_ID, " + "SUB_TYPE_KEY, " + "BEST_NAME_PID, " + "BEST_CREATE_PID, "
			+ "BEST_DESTROY_PID, " + "BEST_IMAGE_PID, " + "SURETY, " + "IS_INTERNAL, " + "IS_BINARY, "
			+ "BINARY_CONTENT, " + "CHAR_CONTENT, " + "FILE_PATH, " + "PATH_IS_FULL, " + "ENCODING_KEY, "
			+ "IMAGE_WIDTH, " + "IMAGE_HEIGHT, " + "EDITED_COPY_PID, "
			+ "FLAGS FROM PUBLIC.DIGITALS WHERE DIGITAL_PID = ?";
	private static final String SELECTALL = "SELECT " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, " + "DIGITAL_PID, "
			+ "IS_SYSTEM, " + "VISIBLE_ID, " + "SUB_TYPE_KEY, " + "BEST_NAME_PID, " + "BEST_CREATE_PID, "
			+ "BEST_DESTROY_PID, " + "BEST_IMAGE_PID, " + "SURETY, " + "IS_INTERNAL, " + "IS_BINARY, "
			+ "BINARY_CONTENT, " + "CHAR_CONTENT, " + "FILE_PATH, " + "PATH_IS_FULL, " + "ENCODING_KEY, "
			+ "IMAGE_WIDTH, " + "IMAGE_HEIGHT, " + "EDITED_COPY_PID, " + "FLAGS FROM PUBLIC.DIGITALS";

	private static final String INSERT = "INSERT INTO PUBLIC.DIGITALS( " + "RECORD_NUM, " + "SET_KEY, " + "COMMIT_PID, "
			+ "DIGITAL_PID, " + "IS_SYSTEM, " + "VISIBLE_ID, " + "SUB_TYPE_KEY, " + "BEST_NAME_PID, "
			+ "BEST_CREATE_PID, " + "BEST_DESTROY_PID, " + "BEST_IMAGE_PID, " + "SURETY, " + "IS_INTERNAL, "
			+ "IS_BINARY, " + "BINARY_CONTENT, " + "CHAR_CONTENT, " + "FILE_PATH, " + "PATH_IS_FULL, "
			+ "ENCODING_KEY, " + "IMAGE_WIDTH, " + "IMAGE_HEIGHT, " + "EDITED_COPY_PID, " + "FLAGS) VALUES (?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, "
			+ "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?, " + "?)";

	private static final String UPDATE = "UPDATE PUBLIC.DIGITALSSET " + "RECORD_NUM = ?, " + "SET_KEY = ?, "
			+ "COMMIT_PID = ?, " + "IS_SYSTEM = ?, " + "VISIBLE_ID = ?, " + "SUB_TYPE_KEY = ?, " + "BEST_NAME_PID = ?, "
			+ "BEST_CREATE_PID = ?, " + "BEST_DESTROY_PID = ?, " + "BEST_IMAGE_PID = ?, " + "SURETY = ?, "
			+ "IS_INTERNAL = ?, " + "IS_BINARY = ?, " + "BINARY_CONTENT = ?, " + "CHAR_CONTENT = ?, "
			+ "FILE_PATH = ?, " + "PATH_IS_FULL = ?, " + "ENCODING_KEY = ?, " + "IMAGE_WIDTH = ?, "
			+ "IMAGE_HEIGHT = ?, " + "EDITED_COPY_PID = ?, " + "FLAGS = ? WHERE DIGITAL_PID = ?";

	private static final String DELETE = "DELETE FROM PUBLIC.DIGITALS WHERE DIGITAL_PID = ?";

	private static final String DELETEALL = "DELETE FROM PUBLIC.DIGITALS";

	private ArrayList<AbstractHreDataModel> modelList;

	private int RecordNum;
	private short SetKey;
	private int CommitPid;
	private int DigitalPid;
	private boolean IsSystem;
	private int VisibleId;
	private short SubTypeKey;
	private int BestNamePid;
	private int BestCreatePid;
	private int BestDestroyPid;
	private int BestImagePid;
	private String Surety;
	private boolean IsInternal;
	private boolean IsBinary;
	private Blob BinaryContent;
	private Clob CharContent;
	private String FilePath;
	private boolean PathIsFull;
	private short EncodingKey;
	private short ImageWidth;
	private short ImageHeight;
	private int EditedCopyPid;
	private byte[] Flags;
	private Digitals model;

	/**
	 * No-arg Constructor
	 *
	 * @throws SQLException
	 *             If database access has failed
	 */

	public Digitals() throws SQLException {
	}

	/**
	 * Constructor
	 *
	 * @param DigitalPid
	 *            Primary key
	 * @throws SQLException
	 *             If database access has failed
	 */

	public Digitals(int DigitalPid) throws SQLException {
		super();
		this.DigitalPid = DigitalPid;
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
			model = new Digitals();
			model.setRecordNum(rs.getInt("RECORD_NUM"));
			model.setSetKey(rs.getShort("SET_KEY"));
			model.setCommitPid(rs.getInt("COMMIT_PID"));
			model.setDigitalPid(rs.getInt("DIGITAL_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setVisibleId(rs.getInt("VISIBLE_ID"));
			model.setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
			model.setBestNamePid(rs.getInt("BEST_NAME_PID"));
			model.setBestCreatePid(rs.getInt("BEST_CREATE_PID"));
			model.setBestDestroyPid(rs.getInt("BEST_DESTROY_PID"));
			model.setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
			model.setSurety(rs.getString("SURETY"));
			model.setIsInternal(rs.getBoolean("IS_INTERNAL"));
			model.setIsBinary(rs.getBoolean("IS_BINARY"));
			model.setBinaryContent(rs.getBlob("BINARY_CONTENT"));
			model.setCharContent(rs.getClob("CHAR_CONTENT"));
			model.setFilePath(rs.getString("FILE_PATH"));
			model.setPathIsFull(rs.getBoolean("PATH_IS_FULL"));
			model.setEncodingKey(rs.getShort("ENCODING_KEY"));
			model.setImageWidth(rs.getShort("IMAGE_WIDTH"));
			model.setImageHeight(rs.getShort("IMAGE_HEIGHT"));
			model.setEditedCopyPid(rs.getInt("EDITED_COPY_PID"));
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
			model.setDigitalPid(rs.getInt("DIGITAL_PID"));
			model.setIsSystem(rs.getBoolean("IS_SYSTEM"));
			model.setVisibleId(rs.getInt("VISIBLE_ID"));
			model.setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
			model.setBestNamePid(rs.getInt("BEST_NAME_PID"));
			model.setBestCreatePid(rs.getInt("BEST_CREATE_PID"));
			model.setBestDestroyPid(rs.getInt("BEST_DESTROY_PID"));
			model.setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
			model.setSurety(rs.getString("SURETY"));
			model.setIsInternal(rs.getBoolean("IS_INTERNAL"));
			model.setIsBinary(rs.getBoolean("IS_BINARY"));
			model.setBinaryContent(rs.getBlob("BINARY_CONTENT"));
			model.setCharContent(rs.getClob("CHAR_CONTENT"));
			model.setFilePath(rs.getString("FILE_PATH"));
			model.setPathIsFull(rs.getBoolean("PATH_IS_FULL"));
			model.setEncodingKey(rs.getShort("ENCODING_KEY"));
			model.setImageWidth(rs.getShort("IMAGE_WIDTH"));
			model.setImageHeight(rs.getShort("IMAGE_HEIGHT"));
			model.setEditedCopyPid(rs.getInt("EDITED_COPY_PID"));
			model.setFlags(rs.getBytes("FLAGS"));
		}
		return this;
	}

	/**
	 * Get the BestCreatePid field.
	 *
	 * @return Contents of the BEST_CREATE_PID column
	 */
	public int getBestCreatePid() {
		return this.BestCreatePid;
	}

	/**
	 * Get the BestDestroyPid field.
	 *
	 * @return Contents of the BEST_DESTROY_PID column
	 */
	public int getBestDestroyPid() {
		return this.BestDestroyPid;
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
	 * Get the BestNamePid field.
	 *
	 * @return Contents of the BEST_NAME_PID column
	 */
	public int getBestNamePid() {
		return this.BestNamePid;
	}

	/**
	 * Get the BinaryContent field.
	 *
	 * @return Contents of the BINARY_CONTENT column
	 */
	public Blob getBinaryContent() {
		return this.BinaryContent;
	}

	/**
	 * Get the CharContent field.
	 *
	 * @return Contents of the CHAR_CONTENT column
	 */
	public Clob getCharContent() {
		return this.CharContent;
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
	 * Get the DigitalPid field.
	 *
	 * @return Contents of the DIGITAL_PID column
	 */
	public int getDigitalPid() {
		return this.DigitalPid;
	}

	/**
	 * Get the EditedCopyPid field.
	 *
	 * @return Contents of the EDITED_COPY_PID column
	 */
	public int getEditedCopyPid() {
		return this.EditedCopyPid;
	}

	/**
	 * Get the EncodingKey field.
	 *
	 * @return Contents of the ENCODING_KEY column
	 */
	public short getEncodingKey() {
		return this.EncodingKey;
	}

	/**
	 * Get the FilePath field.
	 *
	 * @return Contents of the FILE_PATH column
	 */
	public String getFilePath() {
		return this.FilePath;
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
	 * Get the ImageHeight field.
	 *
	 * @return Contents of the IMAGE_HEIGHT column
	 */
	public short getImageHeight() {
		return this.ImageHeight;
	}

	/**
	 * Get the ImageWidth field.
	 *
	 * @return Contents of the IMAGE_WIDTH column
	 */
	public short getImageWidth() {
		return this.ImageWidth;
	}

	/**
	 * Get the IsBinary field.
	 *
	 * @return Contents of the IS_BINARY column
	 */
	public boolean getIsBinary() {
		return this.IsBinary;
	}

	/**
	 * Get the IsInternal field.
	 *
	 * @return Contents of the IS_INTERNAL column
	 */
	public boolean getIsInternal() {
		return this.IsInternal;
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
	 * Get the PathIsFull field.
	 *
	 * @return Contents of the PATH_IS_FULL column
	 */
	public boolean getPathIsFull() {
		return this.PathIsFull;
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
	 * Get the SubTypeKey field.
	 *
	 * @return Contents of the SUB_TYPE_KEY column
	 */
	public short getSubTypeKey() {
		return this.SubTypeKey;
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
	 * Get the VisibleId field.
	 *
	 * @return Contents of the VISIBLE_ID column
	 */
	public int getVisibleId() {
		return this.VisibleId;
	}

	@Override
	public void post(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(INSERT);
		((Digitals) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Digitals) model).setSetKey(rs.getShort("SET_KEY"));
		((Digitals) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Digitals) model).setDigitalPid(rs.getInt("DIGITAL_PID"));
		((Digitals) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((Digitals) model).setVisibleId(rs.getInt("VISIBLE_ID"));
		((Digitals) model).setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
		((Digitals) model).setBestNamePid(rs.getInt("BEST_NAME_PID"));
		((Digitals) model).setBestCreatePid(rs.getInt("BEST_CREATE_PID"));
		((Digitals) model).setBestDestroyPid(rs.getInt("BEST_DESTROY_PID"));
		((Digitals) model).setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
		((Digitals) model).setSurety(rs.getString("SURETY"));
		((Digitals) model).setIsInternal(rs.getBoolean("IS_INTERNAL"));
		((Digitals) model).setIsBinary(rs.getBoolean("IS_BINARY"));
		((Digitals) model).setBinaryContent(rs.getBlob("BINARY_CONTENT"));
		((Digitals) model).setCharContent(rs.getClob("CHAR_CONTENT"));
		((Digitals) model).setFilePath(rs.getString("FILE_PATH"));
		((Digitals) model).setPathIsFull(rs.getBoolean("PATH_IS_FULL"));
		((Digitals) model).setEncodingKey(rs.getShort("ENCODING_KEY"));
		((Digitals) model).setImageWidth(rs.getShort("IMAGE_WIDTH"));
		((Digitals) model).setImageHeight(rs.getShort("IMAGE_HEIGHT"));
		((Digitals) model).setEditedCopyPid(rs.getInt("EDITED_COPY_PID"));
		((Digitals) model).setFlags(rs.getBytes("FLAGS"));
		ps.executeUpdate();
	}

	@Override
	public void put(AbstractHreDataModel model) throws SQLException {
		ps = conn.prepareStatement(UPDATE);
		((Digitals) model).setRecordNum(rs.getInt("RECORD_NUM"));
		((Digitals) model).setSetKey(rs.getShort("SET_KEY"));
		((Digitals) model).setCommitPid(rs.getInt("COMMIT_PID"));
		((Digitals) model).setDigitalPid(rs.getInt("DIGITAL_PID"));
		((Digitals) model).setIsSystem(rs.getBoolean("IS_SYSTEM"));
		((Digitals) model).setVisibleId(rs.getInt("VISIBLE_ID"));
		((Digitals) model).setSubTypeKey(rs.getShort("SUB_TYPE_KEY"));
		((Digitals) model).setBestNamePid(rs.getInt("BEST_NAME_PID"));
		((Digitals) model).setBestCreatePid(rs.getInt("BEST_CREATE_PID"));
		((Digitals) model).setBestDestroyPid(rs.getInt("BEST_DESTROY_PID"));
		((Digitals) model).setBestImagePid(rs.getInt("BEST_IMAGE_PID"));
		((Digitals) model).setSurety(rs.getString("SURETY"));
		((Digitals) model).setIsInternal(rs.getBoolean("IS_INTERNAL"));
		((Digitals) model).setIsBinary(rs.getBoolean("IS_BINARY"));
		((Digitals) model).setBinaryContent(rs.getBlob("BINARY_CONTENT"));
		((Digitals) model).setCharContent(rs.getClob("CHAR_CONTENT"));
		((Digitals) model).setFilePath(rs.getString("FILE_PATH"));
		((Digitals) model).setPathIsFull(rs.getBoolean("PATH_IS_FULL"));
		((Digitals) model).setEncodingKey(rs.getShort("ENCODING_KEY"));
		((Digitals) model).setImageWidth(rs.getShort("IMAGE_WIDTH"));
		((Digitals) model).setImageHeight(rs.getShort("IMAGE_HEIGHT"));
		((Digitals) model).setEditedCopyPid(rs.getInt("EDITED_COPY_PID"));
		((Digitals) model).setFlags(rs.getBytes("FLAGS"));
		ps.executeUpdate();
	}

	/**
	 * Set the BestCreatePid field
	 *
	 * @param BestCreatePid
	 *            Contents of the BEST_CREATE_PID column
	 */
	public void setBestCreatePid(int BestCreatePid) {
		this.BestCreatePid = BestCreatePid;
	}

	/**
	 * Set the BestDestroyPid field
	 *
	 * @param BestDestroyPid
	 *            Contents of the BEST_DESTROY_PID column
	 */
	public void setBestDestroyPid(int BestDestroyPid) {
		this.BestDestroyPid = BestDestroyPid;
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
	 * Set the BestNamePid field
	 *
	 * @param BestNamePid
	 *            Contents of the BEST_NAME_PID column
	 */
	public void setBestNamePid(int BestNamePid) {
		this.BestNamePid = BestNamePid;
	}

	/**
	 * Set the BinaryContent field
	 *
	 * @param BinaryContent
	 *            Contents of the BINARY_CONTENT column
	 */
	public void setBinaryContent(Blob BinaryContent) {
		this.BinaryContent = BinaryContent;
	}

	/**
	 * Set the CharContent field
	 *
	 * @param CharContent
	 *            Contents of the CHAR_CONTENT column
	 */
	public void setCharContent(Clob CharContent) {
		this.CharContent = CharContent;
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
	 * Set the DigitalPid field
	 *
	 * @param DigitalPid
	 *            Contents of the DIGITAL_PID column
	 */
	public void setDigitalPid(int DigitalPid) {
		this.DigitalPid = DigitalPid;
	}

	/**
	 * Set the EditedCopyPid field
	 *
	 * @param EditedCopyPid
	 *            Contents of the EDITED_COPY_PID column
	 */
	public void setEditedCopyPid(int EditedCopyPid) {
		this.EditedCopyPid = EditedCopyPid;
	}

	/**
	 * Set the EncodingKey field
	 *
	 * @param EncodingKey
	 *            Contents of the ENCODING_KEY column
	 */
	public void setEncodingKey(short EncodingKey) {
		this.EncodingKey = EncodingKey;
	}

	/**
	 * Set the FilePath field
	 *
	 * @param FilePath
	 *            Contents of the FILE_PATH column
	 */
	public void setFilePath(String FilePath) {
		this.FilePath = FilePath;
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

	/**
	 * Set the ImageHeight field
	 *
	 * @param ImageHeight
	 *            Contents of the IMAGE_HEIGHT column
	 */
	public void setImageHeight(short ImageHeight) {
		this.ImageHeight = ImageHeight;
	}

	/**
	 * Set the ImageWidth field
	 *
	 * @param ImageWidth
	 *            Contents of the IMAGE_WIDTH column
	 */
	public void setImageWidth(short ImageWidth) {
		this.ImageWidth = ImageWidth;
	}

	/**
	 * Set the IsBinary field
	 *
	 * @param IsBinary
	 *            Contents of the IS_BINARY column
	 */
	public void setIsBinary(boolean IsBinary) {
		this.IsBinary = IsBinary;
	}

	/**
	 * Set the IsInternal field
	 *
	 * @param IsInternal
	 *            Contents of the IS_INTERNAL column
	 */
	public void setIsInternal(boolean IsInternal) {
		this.IsInternal = IsInternal;
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
	 * Set the PathIsFull field
	 *
	 * @param PathIsFull
	 *            Contents of the PATH_IS_FULL column
	 */
	public void setPathIsFull(boolean PathIsFull) {
		this.PathIsFull = PathIsFull;
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
	 * Set the SubTypeKey field
	 *
	 * @param SubTypeKey
	 *            Contents of the SUB_TYPE_KEY column
	 */
	public void setSubTypeKey(short SubTypeKey) {
		this.SubTypeKey = SubTypeKey;
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
	 * Set the VisibleId field
	 *
	 * @param VisibleId
	 *            Contents of the VISIBLE_ID column
	 */
	public void setVisibleId(int VisibleId) {
		this.VisibleId = VisibleId;
	}

}
