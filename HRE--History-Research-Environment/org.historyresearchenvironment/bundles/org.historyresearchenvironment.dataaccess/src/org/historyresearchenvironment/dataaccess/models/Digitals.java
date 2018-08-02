package org.historyresearchenvironment.dataaccess.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* The persistent class for the DIGITALS database table.
*
* @version 2018-08-02
* @author H2ModelGenerator, &copy; History Research Environment Ltd., 2018
*
*/

public class Digitals extends AbstractHreDataModel {
private static final long serialVersionUID = 1L;
private ArrayList<AbstractHreDataModel> modelList;
private static final String SELECT = "SELECT " +
"RECORD_NUM, " +
"SET_KEY, " +
"COMMIT_PID, " +
"DIGITAL_PID, " +
"IS_SYSTEM, " +
"VISIBLE_ID, " +
"SUB_TYPE_KEY, " +
"BEST_NAME_PID, " +
"BEST_CREATE_PID, " +
"BEST_DESTROY_PID, " +
"BEST_IMAGE_PID, " +
"SURETY, " +
"IS_INTERNAL, " +
"IS_BINARY, " +
"BINARY_CONTENT, " +
"CHAR_CONTENT, " +
"FILE_PATH, " +
"PATH_IS_FULL, " +
"ENCODING_KEY, " +
"IMAGE_WIDTH, " +
"IMAGE_HEIGHT, " +
"EDITED_COPY_PID, " +
"FLAGS FROM PUBLIC.DIGITALS WHERE DIGITAL_PID = ?";

private static final String SELECTALL = "SELECT " +
"RECORD_NUM, " +  
"SET_KEY, " +  
"COMMIT_PID, " +  
"DIGITAL_PID, " +  
"IS_SYSTEM, " +  
"VISIBLE_ID, " +  
"SUB_TYPE_KEY, " +  
"BEST_NAME_PID, " +  
"BEST_CREATE_PID, " +  
"BEST_DESTROY_PID, " +  
"BEST_IMAGE_PID, " +  
"SURETY, " +  
"IS_INTERNAL, " +  
"IS_BINARY, " +  
"BINARY_CONTENT, " +  
"CHAR_CONTENT, " +  
"FILE_PATH, " +  
"PATH_IS_FULL, " +  
"ENCODING_KEY, " +  
"IMAGE_WIDTH, " +  
"IMAGE_HEIGHT, " +  
"EDITED_COPY_PID, " +  
"FLAGS FROM PUBLIC.DIGITALS";

private static final String INSERT = "INSERT INTO PUBLIC.DIGITALS( " +
"RECORD_NUM, " +     
"SET_KEY, " +     
"COMMIT_PID, " +     
"DIGITAL_PID, " +     
"IS_SYSTEM, " +     
"VISIBLE_ID, " +     
"SUB_TYPE_KEY, " +     
"BEST_NAME_PID, " +     
"BEST_CREATE_PID, " +     
"BEST_DESTROY_PID, " +     
"BEST_IMAGE_PID, " +     
"SURETY, " +     
"IS_INTERNAL, " +     
"IS_BINARY, " +     
"BINARY_CONTENT, " +     
"CHAR_CONTENT, " +     
"FILE_PATH, " +     
"PATH_IS_FULL, " +     
"ENCODING_KEY, " +     
"IMAGE_WIDTH, " +     
"IMAGE_HEIGHT, " +     
"EDITED_COPY_PID, " +     
"FLAGS) VALUES (?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?)";

private static final String UPDATE = "UPDATE PUBLIC.DIGITALSSET " +
"RECORD_NUM = ?, " + 
"SET_KEY = ?, " + 
"COMMIT_PID = ?, " + 
"IS_SYSTEM = ?, " + 
"VISIBLE_ID = ?, " + 
"SUB_TYPE_KEY = ?, " + 
"BEST_NAME_PID = ?, " + 
"BEST_CREATE_PID = ?, " + 
"BEST_DESTROY_PID = ?, " + 
"BEST_IMAGE_PID = ?, " + 
"SURETY = ?, " + 
"IS_INTERNAL = ?, " + 
"IS_BINARY = ?, " + 
"BINARY_CONTENT = ?, " + 
"CHAR_CONTENT = ?, " + 
"FILE_PATH = ?, " + 
"PATH_IS_FULL = ?, " + 
"ENCODING_KEY = ?, " + 
"IMAGE_WIDTH = ?, " + 
"IMAGE_HEIGHT = ?, " + 
"EDITED_COPY_PID = ?, " + 
"FLAGS = ? WHERE DIGITAL_PID = ?";

private static final String DELETE = "DELETE FROM PUBLIC.DIGITALS WHERE DIGITAL_PID = ?";

private static final String DELETEALL = "DELETE FROM PUBLIC.DIGITALS";

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
private blob BinaryContent;
private clob CharContent;
private String FilePath;
private boolean PathIsFull;
private short EncodingKey;
private short ImageWidth;
private short ImageHeight;
private int EditedCopyPid;
private byte[] Flags;
private Digitals model;

public Digitals() throws SQLException {
}


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
ps.setInt(1, (int) key);
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

public int getRecordNum() {
return this.RecordNum;
}

public short getSetKey() {
return this.SetKey;
}

public int getCommitPid() {
return this.CommitPid;
}

public int getDigitalPid() {
return this.DigitalPid;
}

public boolean getIsSystem() {
return this.IsSystem;
}

public int getVisibleId() {
return this.VisibleId;
}

public short getSubTypeKey() {
return this.SubTypeKey;
}

public int getBestNamePid() {
return this.BestNamePid;
}

public int getBestCreatePid() {
return this.BestCreatePid;
}

public int getBestDestroyPid() {
return this.BestDestroyPid;
}

public int getBestImagePid() {
return this.BestImagePid;
}

public String getSurety() {
return this.Surety;
}

public boolean getIsInternal() {
return this.IsInternal;
}

public boolean getIsBinary() {
return this.IsBinary;
}

public blob getBinaryContent() {
return this.BinaryContent;
}

public clob getCharContent() {
return this.CharContent;
}

public String getFilePath() {
return this.FilePath;
}

public boolean getPathIsFull() {
return this.PathIsFull;
}

public short getEncodingKey() {
return this.EncodingKey;
}

public short getImageWidth() {
return this.ImageWidth;
}

public short getImageHeight() {
return this.ImageHeight;
}

public int getEditedCopyPid() {
return this.EditedCopyPid;
}

public byte[] getFlags() {
return this.Flags;
}

public void setRecordNum(int RecordNum) {
this.RecordNum = RecordNum;
}

public void setSetKey(short SetKey) {
this.SetKey = SetKey;
}

public void setCommitPid(int CommitPid) {
this.CommitPid = CommitPid;
}

public void setDigitalPid(int DigitalPid) {
this.DigitalPid = DigitalPid;
}

public void setIsSystem(boolean IsSystem) {
this.IsSystem = IsSystem;
}

public void setVisibleId(int VisibleId) {
this.VisibleId = VisibleId;
}

public void setSubTypeKey(short SubTypeKey) {
this.SubTypeKey = SubTypeKey;
}

public void setBestNamePid(int BestNamePid) {
this.BestNamePid = BestNamePid;
}

public void setBestCreatePid(int BestCreatePid) {
this.BestCreatePid = BestCreatePid;
}

public void setBestDestroyPid(int BestDestroyPid) {
this.BestDestroyPid = BestDestroyPid;
}

public void setBestImagePid(int BestImagePid) {
this.BestImagePid = BestImagePid;
}

public void setSurety(String Surety) {
this.Surety = Surety;
}

public void setIsInternal(boolean IsInternal) {
this.IsInternal = IsInternal;
}

public void setIsBinary(boolean IsBinary) {
this.IsBinary = IsBinary;
}

public void setBinaryContent(blob BinaryContent) {
this.BinaryContent = BinaryContent;
}

public void setCharContent(clob CharContent) {
this.CharContent = CharContent;
}

public void setFilePath(String FilePath) {
this.FilePath = FilePath;
}

public void setPathIsFull(boolean PathIsFull) {
this.PathIsFull = PathIsFull;
}

public void setEncodingKey(short EncodingKey) {
this.EncodingKey = EncodingKey;
}

public void setImageWidth(short ImageWidth) {
this.ImageWidth = ImageWidth;
}

public void setImageHeight(short ImageHeight) {
this.ImageHeight = ImageHeight;
}

public void setEditedCopyPid(int EditedCopyPid) {
this.EditedCopyPid = EditedCopyPid;
}

public void setFlags(byte[] Flags) {
this.Flags = Flags;
}

}

