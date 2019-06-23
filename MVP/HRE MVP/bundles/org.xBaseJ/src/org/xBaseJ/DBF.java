package org.xBaseJ;
/**
 * xBaseJ - Java access to dBase files
 *<p>Copyright 1997-2014 - American Coders, LTD  - Raleigh NC USA
 *<p>All rights reserved
 *<p>Currently supports only dBase III format DBF, DBT and NDX files
 *<p>                        dBase IV format DBF, DBT, MDX and NDX files
*<p>American Coders, Ltd
*<br>P. O. Box 97462
*<br>Raleigh, NC  27615  USA
*<br>1-919-846-2014
*<br>http://www.americancoders.com
@author Joe McVerry, American Coders Ltd.
@Version 20140310
*
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library Lesser General Public
 * License along with this library; if not, write to the Free
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *  Change History
 *  Date      Developer                 Desc
 *  20091010  Roland Hughes (rth)   Fixed null pointer exception which
 *                                  happened when calling close() without
 *                                  any NDX files open.
 *
 *
 *  20091012  Roland Hughes  (rth)  renameTo() only works when the rename
 *                                  isn't occurring across partitions or
 *                                  physical devices.  Added copyTo() to
 *                                  copy just the DBF, not any associated
 *                                  memo file.
 *

 *  20110401  Joe McVerry (jrm)    Replaced instanceof call with static
 *                                 field test (eg isDateField());
 *                                 
 *                                 ID: 2972349 - use different naming
 *                                 functions for deleting temp files. 
 *                                 
 *  20110706  Joe McVerry (jrm)   delete and undelete method now use 
 *  					record locking instead of file locking.
 *  
 *  20110706  Joe McVerry (jrm)   The suffix of the temp file for DBF.pack() 
 *  					must be preceded by a ".". Otherwise it crashes in 
 *  					MDXFile.java:94 and others.  
 *  					tracker ID: 3335462
 *  
 *
 *  20110119  Joe McVerry (jrm)   Added static field type and CurrencyField class.
 *  
 *  20140310 Joe McVerry(jrm)  Change version numbering to use release date.
 *                             Corrected File and Record Lock mechanism.
 *                             Replaced database version attribute - was int now using Java enum type.
 *                             Now handles Clipper large Char fields (lengths > 256).
*/

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import org.xBaseJ.fields.CharField;
import org.xBaseJ.fields.CurrencyField;
import org.xBaseJ.fields.DateField;
import org.xBaseJ.fields.Field;
import org.xBaseJ.fields.FloatField;
import org.xBaseJ.fields.LogicalField;
import org.xBaseJ.fields.MemoField;
import org.xBaseJ.fields.NumField;
import org.xBaseJ.fields.PictureField;
import org.xBaseJ.indexes.Index;
import org.xBaseJ.indexes.MDX;
import org.xBaseJ.indexes.MDXFile;
import org.xBaseJ.indexes.NDX;


public class DBF extends Object {

	protected String dosname;
	protected int current_record = 0;
	protected short fldcount = 0;
	protected File ffile;
	public RandomAccessFile file;
	protected Vector<Field> fld_root;
	protected DBTFile dbtobj = null;
	protected byte delete_ind = (byte) ' ';


	protected DBFTypes version = DBFTypes.DBASEIII;
	protected byte l_update[] = new byte[3];
	protected int count = 0;
	protected short offset = 0;
	protected short lrecl = 0;
	protected byte incomplete_transaction = 0;
	protected byte encrypt_flag = 0;
	protected byte reserve[] = new byte[12];
	protected byte MDX_exist = 0;
	protected byte language = 0;
	protected byte reserve2[] = new byte[2];

	protected Index jNDX;
	protected Vector<Index> jNDXes;
	protected Vector<String> jNDXID;
	public MDXFile MDXfile = null;
	
	public static DBFTypes dbfType;
	 
	public static final byte NOTDELETED = (byte) ' ';
	public static final byte DELETED = 0x2a;

	public static final char READ_ONLY = 'r';
	public boolean readonly = false;

	public static final String xBaseJVersion = "20140310";

	public static final String version() { return xBaseJVersion;}

	public static String encodedType = "8859_1";

	public FileChannel channel = null;
	public FileLock filelock = null;
	public FileLock recordlock = null;
	public long fileLockWait = 5000; // milliseconds
	public ByteBuffer buffer;
	 

	/**
	 * creates a new DBF file or replaces an existing database file, w/o format assumes dbaseiii file format.
	 *
	 * @param DBFname          a new or existing database file, can be full or partial pathname
	 * @param destroy          delete existing dbf.
	 * @throws xBaseJException
	 *                                    File does exist and told not to destroy it.
	 * @throws xBaseJException
	 *                                    Told to destroy but operating system can not destroy
	 * @throws IOException
	 *                                    Java error caused by called methods
	 * @throws SecurityException
	 *                                    Java error caused by called methods, most likely trying to create on a remote system
	 */

	public DBF(String DBFname, boolean destroy)
		throws xBaseJException, IOException, SecurityException {
		createDBF(DBFname, DBFTypes.DBASEIII, destroy);
	}

	/**
	 * creates a new DBF file or replaces an existing database file.
	 *
	 *
	 * @param DBFname          a new or existing database file, can be full or partial pathname
	 * @param format             use class constants DBASEIII or DBASEIV
	 * @param destroy            permission to destroy an existing database file
	 * @throws xBaseJException
	 *                                    File does exist and told not to destroy it.
	 * @throws xBaseJException
	 *                                    Told to destroy but operating system can not destroy
	 * @throws IOException
	 *                                    Java error caused by called methods
	 * @throws SecurityException
	 *                                    Java error caused by called methods, most likely trying to create on a remote system
	 */

	public DBF(String DBFname, DBFTypes format, boolean destroy)
		throws xBaseJException, IOException, SecurityException {
		createDBF(DBFname, format, destroy);
	}

	/**
	 * creates an DBF object and opens existing database file in readonly mode.
	 *
	 * @param DBFname          an existing database file, can be full or partial pathname
	 * @param readOnly         see DBF.READ_ONLY
	 * @throws xBaseJException
	 *                                    Can not find database
	 * @throws xBaseJException
	 *                                    database not dbaseIII format
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public DBF(String DBFname, char readOnly)
		throws xBaseJException, IOException {
		if (readOnly != DBF.READ_ONLY)
			throw new xBaseJException(
				"Unknown readOnly indicator <" + readOnly + ">");
		readonly = true;
		openDBF(DBFname);
	}

	/**
	 * creates an DBF object and opens existing database file in read/write mode.
	 *
	 * @param DBFname          an existing database file, can be full or partial pathname
	 * @throws xBaseJException
	 *                                    Can not find database
	 * @throws xBaseJException
	 *                                    database not dbaseIII format
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public DBF(String DBFname) throws xBaseJException, IOException {

		readonly = false;
		openDBF(DBFname);
	}

	/**
	 * creates a new DBF file or replaces an existing database file, w/o format assumes dbaseiii file format.
	 *
	 * @param DBFname          a new or existing database file, can be full or partial pathname
	 * @param destroy          delete existing dbf.
	 * @throws xBaseJException
	 *                                    File does exist and told not to destroy it.
	 * @throws xBaseJException
	 *                                    Told to destroy but operating system can not destroy
	 * @throws IOException
	 *                                    Java error caused by called methods
	 * @throws SecurityException
	 *                                    Java error caused by called methods, most likely trying to create on a remote system
	 */

	public DBF(String DBFname, boolean destroy, String inEncodeType)
		throws xBaseJException, IOException, SecurityException {
		setEncodingType(inEncodeType);
		createDBF(DBFname, DBFTypes.DBASEIII, destroy);
	}

	/**
	 * creates a new DBF file or replaces an existing database file.
	 *
	 * @param DBFname          a new or existing database file, can be full or partial pathname
	 * @param format             use class constants DBASEIII or DBASEIV
	 * @param destroy            permission to destroy an existing database file
	 * @param inEncodeType	   file encoding value
	 * @throws xBaseJException
	 *                                    File does exist and told not to destroy it.
	 * @throws xBaseJException
	 *                                    Told to destroy but operating system can not destroy
	 * @throws IOException
	 *                                    Java error caused by called methods
	 * @throws SecurityException
	 *                                    Java error caused by called methods, most likely trying to create on a remote system
	 */

	public DBF(
		String DBFname,
		DBFTypes format,
		boolean destroy,
		String inEncodeType)
		throws xBaseJException, IOException, SecurityException {
		setEncodingType(inEncodeType);
		createDBF(DBFname, format, destroy);
	}

	/**
	 * creates an DBF object and opens existing database file in readonly mode.
	 *
	 * @param DBFname          an existing database file, can be full or partial pathname
	 * @param readOnly         see DBF.READ_ONLY
	 * @param inEncodeType	   file encoding value
	 * @throws xBaseJException
	 *                                    Can not find database
	 * @throws xBaseJException
	 *                                    database not dbaseIII format
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public DBF(String DBFname, char readOnly, String inEncodeType)
		throws xBaseJException, IOException {
		if (readOnly != DBF.READ_ONLY)
			throw new xBaseJException(
				"Unknown readOnly indicator <" + readOnly + ">");
		readonly = true;
		setEncodingType(inEncodeType);
		openDBF(DBFname);
	}

	/**
	 * creates an DBF object and opens existing database file in read/write mode.
	 *
	 * @param DBFname          an existing database file, can be full or partial pathname
	 * @param inEncodeType	   file encoding value
	 * @throws xBaseJException
	 *                                    Can not find database
	 * @throws xBaseJException
	 *                                    database not dbaseIII format
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public DBF(String DBFname, String inEncodeType)
		throws xBaseJException, IOException {

		readonly = false;
		setEncodingType(inEncodeType);
		openDBF(DBFname);
	}
	/**
	 * opens an existing database file.
	 *
	 * @param DBFname          an existing database file, can be full or partial pathname
	 * @throws xBaseJException
	 *                                    Can not find database
	 * @throws xBaseJException
	 *                                    database not dbaseIII format
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	protected void openDBF(String DBFname) throws IOException, xBaseJException {
		int i;
		jNDX = null;
		jNDXes = new Vector<Index>(1);
		jNDXID = new Vector<String>(1);

		ffile = new File(DBFname);
		if (!ffile.exists() || !ffile.isFile()) {
			throw new xBaseJException("Unknown database file " + DBFname);
		} /* endif */

		if (readonly)
			file = new RandomAccessFile(DBFname, "r");
		else
			file = new RandomAccessFile(DBFname, "rw");

		dosname = DBFname;
		// ffile.getAbsolutePath(); // getName();
		channel = file.getChannel();

		read_dbhead();

		buffer = ByteBuffer.allocateDirect(lrecl+1);

		fldcount = (short) ((offset - 1) / 32 - 1);

		if (( version != DBFTypes.DBASEIII)
              && ( version != DBFTypes.DBASEIII_WITH_MEMO)
   		      && ( version != DBFTypes.DBASEIV)
 			&& ( version != DBFTypes.DBASEIV_WITH_MEMO)
			&& ( version != DBFTypes.FOXPRO_WITH_MEMO)) {
			String mismatch = Util.getxBaseJProperty("ignoreVersionMismatch").toLowerCase();
			if (mismatch != null && (mismatch.compareTo("true") ==0 || mismatch.compareTo("yes") ==0))
				System.err.println("Wrong Version " +   version);
			  else
				throw new xBaseJException("Wrong Version " +  version);
			}

		if (version == DBFTypes.FOXPRO_WITH_MEMO)
			dbtobj = new DBT_fpt(this, readonly);
		else if (version == DBFTypes.DBASEIII_WITH_MEMO)
			dbtobj = new DBT_iii(this, readonly);
		else if (version == DBFTypes.DBASEIV_WITH_MEMO)
			dbtobj = new DBT_iv(this, readonly);

		fld_root = new Vector<Field>(new Long(fldcount).intValue());

		for (i = 0; i < fldcount; i++) {
			fld_root.addElement(read_Field_header());
		}

		if (MDX_exist == 1) {
			try {
				if (readonly)
					MDXfile = new MDXFile(dosname, this, 'r');
				else
					MDXfile = new MDXFile(dosname, this, ' ');
				for (i = 0; i < MDXfile.getAnchor().getIndexes(); i++)
					jNDXes.addElement(MDXfile.MDXes[i]);
			} catch (xBaseJException xbe) {
				String missing = Util.getxBaseJProperty("ignoreMissingMDX").toLowerCase();
				if (missing != null && (missing.compareTo("true") == 0 || missing.compareTo("yes")==0) )
			     MDX_exist = 0;
			    else  {
			    	System.err.println(xbe.getMessage());
			    	System.err.println("Processing continues without mdx file");
			    	MDX_exist = 0;
			      }
			  }
		}

		try {
			file.readByte();
			//temp = file.readByte();
		} catch (EOFException IOE) {
			; //nop some dbase clones don't use the last two bytes
		}

		current_record = 0;

	}

	public void finalize() throws Throwable {
		try {
			close();
		} catch (Exception e) {
			;
		}
	}

	protected void createDBF(String DBFname, DBFTypes format, boolean destroy)
		throws xBaseJException, IOException, SecurityException {
		jNDX = null;
		jNDXes = new Vector<Index>(1);
		jNDXID = new Vector<String>(1);
		ffile = new File(DBFname);

		if (format != DBFTypes.DBASEIII
			&& format != DBFTypes.DBASEIV
			&& format != DBFTypes.DBASEIII_WITH_MEMO
			&& format != DBFTypes.DBASEIV_WITH_MEMO
			&& format != DBFTypes.FOXPRO_WITH_MEMO)
			throw new xBaseJException("Invalid format specified");

		if (destroy == false)
			if (ffile.exists())
				throw new xBaseJException("File exists, can't destroy");

		if (destroy == true) {
			if (ffile.exists())
				if (ffile.delete() == false)
					throw new xBaseJException("Can't delete old DBF file");
					ffile = new File(DBFname);

		}


		FileOutputStream tFOS = new FileOutputStream(ffile);
		tFOS.close();

		file = new RandomAccessFile(DBFname, "rw");

		dosname = DBFname; //ffile.getAbsolutePath(); //getName();

		channel = file.getChannel();

		buffer = ByteBuffer.allocateDirect(lrecl+1);

		fld_root = new Vector<Field>(0);
		if (format == DBFTypes.DBASEIV ||
			     format == DBFTypes.DBASEIV_WITH_MEMO)
			     MDX_exist = 1;

		boolean memoExists =
			(format == DBFTypes.DBASEIII_WITH_MEMO
				|| format == DBFTypes.DBASEIV_WITH_MEMO
				|| format == DBFTypes.FOXPRO_WITH_MEMO);


		db_offset(format, memoExists);

		update_dbhead();
		file.writeByte(13);
		file.writeByte(26);

		if (MDX_exist == 1)
			MDXfile = new MDXFile(DBFname, this, destroy);

	}

	/**
	 * adds a new Field to a database
	 * @param aField  a predefined Field object
	 * @see Field
	 * @throws xBaseJException
	 *                                    org.xBaseJ error caused by called methods
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void addField(Field aField) throws xBaseJException, IOException {
		
		Field bField[] = new Field[1];
		bField[0] = aField;
		addField(bField);

	}

	
	/**
	 * adds an arrayList of new Fields to a database
	 * @param aField  an arrayList of  predefined Field object
	 * @see Field
	 * @throws xBaseJException
	 *                                    passed an empty array or other error
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void addField(ArrayList<Field> aField) throws xBaseJException, IOException {
		Field[] flds = new Field[aField.size()];
		for (int i = 0 ; i < flds.length; i++)
			flds[i] = aField.get(i);
		addField(flds);
	}
	/**
	 * adds an array of new Fields to a database
	 * @param aField  an array of  predefined Field object
	 * @see Field
	 * @throws xBaseJException
	 *                                    passed an empty array or other error
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void addField(Field aField[]) throws xBaseJException, IOException {
		if (aField.length == 0)
			throw new xBaseJException("No Fields in array to add");

		if ((version == DBFTypes.DBASEIII && MDX_exist == 0)
			|| (version == DBFTypes.DBASEIII_WITH_MEMO)) {
			if ((fldcount + aField.length) > 128)
				throw new xBaseJException(
					"Number of fields exceed limit of 128.  New Field count is "
						+ (fldcount + aField.length));
		} else {
			if ((fldcount + aField.length) > 255)
				throw new xBaseJException(
					"Number of fields exceed limit of 255.  New Field count is "
						+ (fldcount + aField.length));
		}

		int i, j;
		Field tField;
		boolean oldMemo = false;
		for (j = 0; j < aField.length; j++) {
			for (i = 1; i <= fldcount; i++) {
				tField = getField(i);
				if (tField.isMemoField()
					|| tField.isPictureField())
					oldMemo = true;
				if (aField[j].getName().equalsIgnoreCase(tField.getName()))
					throw new xBaseJException(
						"Field: " + aField[j].getName() + " already exists.");
			}
		}

		short newRecl = lrecl;
		boolean newMemo = false;

		for (j = 1; j <= aField.length; j++) {
			newRecl += aField[j - 1].getLength();

			if ((dbtobj == null)
				&& ((aField[j - 1] instanceof MemoField)
					|| (aField[j - 1] instanceof PictureField)))
				newMemo = true;
			if (aField[j - 1] instanceof PictureField)
				version = DBFTypes.FOXPRO_WITH_MEMO;
			else if (
				(aField[j - 1] instanceof MemoField)
					&& (((MemoField) aField[j - 1]).isFoxPro()))
				version = DBFTypes.FOXPRO_WITH_MEMO;
		}

        String ignoreDBFLength = Util.getxBaseJProperty("ignoreDBFLengthCheck");
        if (ignoreDBFLength != null && (ignoreDBFLength.toLowerCase().compareTo("true") ==0 || ignoreDBFLength.toLowerCase().compareTo("yes") ==0))
        	;
        else
		if (newRecl > 4000)
			throw new xBaseJException(
				"Record length of 4000 exceeded.  New calculated length is "
					+ newRecl);

		boolean createTemp = false;
		DBF tempDBF = null;
		String newName = "";
		//buffer = ByteBuffer.allocateDirect(newRecl+1);
		if (fldcount > 0)
			createTemp = true;

		if (createTemp) {

			File f = File.createTempFile("org.xBaseJ", ffile.getName());
			newName = f.getAbsolutePath();

			f.delete();

			DBFTypes format = version;
			if ((format == DBFTypes.DBASEIII) && (MDX_exist == 1))
				format = DBFTypes.DBASEIV;

			tempDBF = new DBF(newName, format, true);
			tempDBF.version =   format;
			tempDBF.MDX_exist = MDX_exist;

		}

		if (newMemo) {
			if (createTemp) {
				if ((version == DBFTypes.DBASEIII || version == DBFTypes.DBASEIII_WITH_MEMO)
					&& (MDX_exist == 0))
					tempDBF.dbtobj = new DBT_iii(this, newName, true);
				else if (version == DBFTypes.FOXPRO_WITH_MEMO)
					tempDBF.dbtobj = new DBT_fpt(this, newName, true);
				else
					tempDBF.dbtobj = new DBT_iv(this, newName, true);
			} else {
				if ((version == DBFTypes.DBASEIII || version == DBFTypes.DBASEIII_WITH_MEMO)
					&& (MDX_exist == 0))
					dbtobj = new DBT_iii(this, dosname, true);
				else if (version == DBFTypes.FOXPRO_WITH_MEMO)
					dbtobj = new DBT_fpt(this, dosname, true);
				else
					dbtobj = new DBT_iv(this, dosname, true);
			}
		} else if (createTemp && oldMemo) {
			if ((version == DBFTypes.DBASEIII || version == DBFTypes.DBASEIII_WITH_MEMO)
				&& (MDX_exist == 0))
				tempDBF.dbtobj = new DBT_iii(this, newName, true);
			else if (version == DBFTypes.FOXPRO_WITH_MEMO)
				tempDBF.dbtobj = new DBT_fpt(this, newName, true);
			else
				tempDBF.dbtobj = new DBT_iv(this, newName, true);
		}

		if (createTemp) {
			tempDBF.db_offset(version, newMemo || (dbtobj != null));
			tempDBF.update_dbhead();
			tempDBF.offset = offset;
			tempDBF.lrecl = newRecl;
			tempDBF.fldcount = fldcount;

			for (i = 1; i <= fldcount; i++) {
				try {
					tField = (Field) getField(i).clone();
				} catch (CloneNotSupportedException e) {

					throw new xBaseJException("Clone not supported logic error");
				}
				if (tField.isMemoField())
					 ((MemoField) tField).setDBTObj(tempDBF.dbtobj);
				if (tField.isPictureField())
					 ((PictureField) tField).setDBTObj(tempDBF.dbtobj);
				tField.setBuffer(tempDBF.buffer);
				tempDBF.fld_root.addElement(tField);
				tempDBF.write_Field_header(tField);
			}

			for (i = 0; i < aField.length; i++) {
				aField[i].setBuffer(tempDBF.buffer);
				tempDBF.fld_root.addElement(aField[i]);
				tempDBF.write_Field_header(aField[i]);
				tField = (Field) aField[i];
				if (tField.isMemoField())
					 ((MemoField) tField).setDBTObj(tempDBF.dbtobj);
				if (tField.isPictureField())
					 ((PictureField) tField).setDBTObj(tempDBF.dbtobj);

			}

			tempDBF.file.writeByte(13);
			tempDBF.file.writeByte(26);
			tempDBF.fldcount += aField.length;
			tempDBF.offset += (aField.length * 32);
		} else {
			lrecl = newRecl;
			int savefldcnt = fldcount;
			fldcount += aField.length;
			offset += (32 * aField.length);
			if (newMemo) {
				if (dbtobj instanceof DBT_iii)
					version = DBFTypes.DBASEIII_WITH_MEMO;
				else if (
					dbtobj instanceof DBT_iv)
					// if it's not dbase 3 format make it at least dbaseIV format.
					version = DBFTypes.DBASEIV_WITH_MEMO;
				else if (
					dbtobj instanceof DBT_fpt)
					// if it's not foxpro format make it at least dbaseIV format.
					version = DBFTypes.FOXPRO_WITH_MEMO;
			}
			channel = file.getChannel();
			buffer = ByteBuffer.allocateDirect(lrecl+1);

			update_dbhead();

			for (i = 1; i <= savefldcnt; i++) {
				tField = (Field) getField(i);
				if (tField.isMemoField())
					 ((MemoField) tField).setDBTObj(dbtobj);
				if (tField.isPictureField())
					 ((PictureField) tField).setDBTObj(tempDBF.dbtobj);
				write_Field_header(tField);
			}

			for (i = 0; i < aField.length; i++) {
				aField[i].setBuffer(buffer);
				tField = (Field) aField[i];
				if (tField.isMemoField())
					 ((MemoField) tField).setDBTObj(dbtobj);
				if (tField.isPictureField()) {
					((PictureField) tField).setDBTObj(dbtobj);
				}
				fld_root.addElement(aField[i]);
				write_Field_header(aField[i]);
			}
			file.writeByte(13);
			file.writeByte(26);
			return; // nothing left to do, no records to write
		}

		tempDBF.update_dbhead();
		tempDBF.close();
		tempDBF = new DBF(newName);

		for (j = 1; j <= count; j++) {
			Field old1;
			Field new1;
			gotoRecord(j);
			for (i = 1; i <= fldcount; i++) {
				old1 = getField(i);
				new1 = tempDBF.getField(i);
				new1.put(old1.get());
			}
			for (i = 0; i < aField.length; i++) {
				new1 = aField[i];
				new1.put("");
			}

			tempDBF.write();
		}

		tempDBF.update_dbhead();

		file.close();
		ffile.delete();

		if (dbtobj != null) {
			dbtobj.file.close();
			dbtobj.thefile.delete();
		}
		if (tempDBF.dbtobj != null) {
			tempDBF.dbtobj.file.close();
			if (newName != null && newName.length() > 4) {
				String tempMDXFilename = newName.substring(0, newName.length() - 4) +
				".mdx";
				File tempMDXFile = new File(tempMDXFilename);
				if (tempMDXFile.exists()) {
				tempMDXFile.deleteOnExit();
				}
			}
			tempDBF.dbtobj.rename(dosname);
			if ((version == DBFTypes.DBASEIII || version == DBFTypes.DBASEIII_WITH_MEMO)
			&& (MDX_exist == 0)) {
 				if (dosname.endsWith("dbf"))
 					dbtobj = new DBT_iii(this, readonly);
 				else
 					dbtobj = new DBT_iii(this, dosname,  true);
 			}
 			else if (version == DBFTypes.FOXPRO_WITH_MEMO) {
 				if (dosname.endsWith("dbf"))
 					dbtobj = new DBT_fpt(this, readonly);
 				else
 					dbtobj = new DBT_fpt(this, dosname, true);
 			}
 			else {
 				if (dosname.endsWith("dbf"))
 					dbtobj = new DBT_iv(this, readonly);
 				else
 					dbtobj = new DBT_iv(this, dosname,  true);

 			}
		}


		tempDBF.renameTo(dosname);
		buffer = ByteBuffer.allocateDirect(tempDBF.buffer.capacity());
		tempDBF = null;
		ffile = new File(dosname);
		file = new RandomAccessFile(dosname, "rw");
		channel = file.getChannel();

		for (i = 0; i < aField.length; i++) {
			aField[i].setBuffer(buffer);
			fld_root.addElement(aField[i]);
		}

		read_dbhead();

		fldcount = (short) ((offset - 1) / 32 - 1);

		for (i = 1; i <= fldcount; i++) {
			tField = (Field) getField(i);
			tField.setBuffer(buffer);
			if (tField.isMemoField())
				 ((MemoField) tField).setDBTObj(dbtobj);
			if (tField.isPictureField())
				 ((PictureField) tField).setDBTObj(dbtobj);
		}

	}

	public void renameTo(String newname) throws IOException {
		file.close();
		File n = new File(newname);
		boolean b = ffile.renameTo(n);          // 20091012_rth - begin
        if ( !b) {
            copyTo( newname);
            ffile.delete();
        }                                       // 20091012_rth - end
		dosname = newname;
	}

	/**
	 * sets the filelockwait timeout value in milliseconds
	 * <br> defaults to 5000 milliseconds
	 * <br> if negative value will not be set
	 * @param inLongWait long milliseconds
	 */
	public void setFileLockWait(long inLongWait) {
		if (inLongWait > -1)
			fileLockWait = inLongWait;
	}

	/** locks the entire database
	 * <br> will try 5 times within the fileLockTimeOut specified in
	 * org.xBaseJ.property fileLockTimeOut, default 5000 milliseconds (5 seconds)
	 * @throws IOException - related to java.nio.channels and filelocks
	 * @throws xBaseJException - file lock wait timed out,
	 * @since 2.1
	*/
	public void lock() throws IOException, xBaseJException {

		long thisWait = fileLockWait / 5;

		for (long waitloop = fileLockWait;
			waitloop > 0;
			waitloop -= thisWait) {
			try {
				filelock = channel.tryLock(0, ffile.length(), false);
			}
			catch (OverlappingFileLockException ofle) {
				;
			}


			if (filelock != null)
				return;

			synchronized (this) {
				try {
					wait(thisWait);
				} catch (InterruptedException ie) {
					;
				}
			} // sync

		}

		throw new xBaseJException("file lock wait timed out");

	}

	/** locks the current record, exclusively
	 * <br> will try 5 times within the fileLockTimeOut specified in
	 * org.xBaseJ.property fileLockTimeOut, default 5000 milliseconds (5 seconds)
	 * @throws IOException - related to java.nio.channels and filelocks
	 * @throws xBaseJException - file lock wait timed out,
	 * @since 2.1
	*/
	public void lockRecord() throws IOException, xBaseJException {

		lockRecord(getCurrentRecordNumber());
	}

	/** locks a particular record, exclusively
	 * <br> will try 5 times within the fileLockTimeOut specified in
	 * org.xBaseJ.property fileLockTimeOut, default 5000 milliseconds (5 seconds)
	 * @param recno record # to be locked
	 * @throws IOException - related to java.nio.channels and filelocks
	 * @throws xBaseJException - file lock wait timed out,
	*/
	public void lockRecord(int recno) throws IOException, xBaseJException {

		unlockRecord();
		long calcpos = (offset + (lrecl * (recno - 1)));

		long thisWait = fileLockWait / 5;

		for (long waitloop = fileLockWait;
			waitloop > 0;
			waitloop -= thisWait) {
			recordlock = channel.tryLock(calcpos, lrecl, false);
			if (recordlock != null)
				return;
			synchronized (this) {
				try {
					wait(thisWait);
				} catch (InterruptedException ie) {
					;
				}
			} // synch

		}

		throw new xBaseJException("file lock wait timed out");
	}

	/** unlocks the entire database
	 * @throws IOException - related to java.nio.channels and filelocks
	 * @since 2.1
	 */
	public void unlock() throws IOException {
		if (filelock != null)
			filelock.release();

		filelock = null;

	}

	/** unlocks the current locked record
	 * @throws IOException - related to java.nio.channels and filelocks
	 * @since 2.1
	 */
	public void unlockRecord() throws IOException {
		if (recordlock != null)
			recordlock.release();

		recordlock = null;

	}

	/**
	 * removes a Field from a database NOT FULLY IMPLEMENTED
	 * @param aField  a field in the database
	 * @see Field
	 * @throws xBaseJException
	 *                                    Field is not part of the database
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void dropField(Field aField) throws xBaseJException, IOException {
		int i;
		Field tField;
		for (i = 0; i < fldcount; i++) {
			tField = getField(i);
			if (aField.getName().equalsIgnoreCase(tField.getName()))
				break;
		}
		if (i > fldcount)
			throw new xBaseJException(
				"Field: " + aField.getName() + " does not exist.");
	}

	/**
	 * changes a Field in a database   NOT FULLY IMPLEMENTED
	 * @param oldField  a Field object
	 * @param newField  a Field object
	 * @see Field
	 * @throws xBaseJException
	 *                                    org.xBaseJ error caused by called methods
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public void changeField(Field oldField, Field newField)
		throws xBaseJException, IOException {
		int i, j;
		Field tField;
		for (i = 0; i < fldcount; i++) {
			tField = getField(i);
			if (oldField.getName().equalsIgnoreCase(tField.getName()))
				break;
		}
		if (i > fldcount)
			throw new xBaseJException(
				"Field: " + oldField.getName() + " does not exist.");

		for (j = 0; j < fldcount; j++) {
			tField = getField(j);
			if (newField.getName().equalsIgnoreCase(tField.getName())
				&& (j != i))
				throw new xBaseJException(
					"Field: " + newField.getName() + " already exists.");
		}

	}


	/**
	 * returns the number of fields in a database
	 */
	public int getFieldCount() {
		return fldcount;
	}

	/**
	 * returns the number of records in a database
	 * @throws xBaseJException
	 * @throws IOException
	 */

	public int getRecordCount()  {


		return count;
	}

	/**
	 * returns the current record number
	 */
	public int getCurrentRecordNumber() {
		return current_record;
	}

	/**
	 * returns the number of known index files and tags
	 */
	public int getIndexCount() {
		return jNDXes.size();
	}

	/**
	 * gets an Index object associated with the database.  This index does not become the primary
	 * index.  Written for the makeDBFBean application.  Position is relative to 1.
	 * @param  indexPosition
	 * @throws xBaseJException
	 *                                    index value incorrect
	 */
	public Index getIndex(int indexPosition) throws xBaseJException {
		if (indexPosition < 1)
			throw new xBaseJException("Index position too small");
		if (indexPosition > jNDXes.size())
			throw new xBaseJException("Index position too large");
		return (Index) jNDXes.elementAt(indexPosition - 1);

	}

	/**
	 * opens an Index file associated with the database.  This index becomes the primary
	 * index used in subsequent find methods.
	 * @param filename      an existing ndx file(can be full or partial pathname) or mdx tag
	 * @throws xBaseJException
	 *                                    org.xBaseJ Fields defined in index do not match fields in database
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public Index useIndex(String filename)
		throws xBaseJException, IOException {
		int i;
		Index NDXes;
		for (i = 1; i <= jNDXes.size(); i++) {
			NDXes = (Index) jNDXes.elementAt(i - 1);
			if (NDXes.getName().compareTo(filename) == 0) {
				jNDX = NDXes;
				return jNDX;
			}
		}
		if (readonly)
			jNDX = new NDX(filename, this, 'r');
		else
			jNDX = new NDX(filename, this, ' ');
		jNDXes.addElement(jNDX);
		return jNDX;
	}

	/**
	 * opens an Index file associated with the database
	 * @param filename      an existing Index file, can be full or partial pathname
	 * @param ID      a unique id to define Index at run-time.
	 * @throws xBaseJException
	 *                                    org.xBaseJ Fields defined in Index do not match Fields in database
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public Index useIndex(String filename, String ID)
		throws xBaseJException, IOException {
		useIndex(filename);
		jNDXID.addElement(ID);

		return useIndex(filename);
	}

	/**
	 * used to indicate the primary Index
	 * @param ndx  an Index object
	 * @throws xBaseJException
	 *                                    org.xBaseJ Index not opened or not part of the database
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public Index useIndex(Index ndx) throws xBaseJException, IOException {
		int i;
		Index NDXes;
		for (i = 1; i <= jNDXes.size(); i++) {
			NDXes = (Index) jNDXes.elementAt(i - 1);
			if (NDXes == ndx) {
				jNDX = NDXes;
				return NDXes;
			}
		}
		throw new xBaseJException("Unknown Index " + ndx.getName());

	}

	/**
	 * used to indicate the primary Index.
	 * @param ID String index name
	 * @throws xBaseJException
	 *                                    org.xBaseJ Index not opened or not part of the database
	 * @see DBF#useIndex(String,String)
	 */
	public Index useIndexByID(String ID) throws xBaseJException {
		int i;
		String NDXes;
		for (i = 1; i <= jNDXID.size(); i++) {
			NDXes = (String) jNDXID.elementAt(i - 1);
			if (NDXes.compareTo(ID) == 0) {
				jNDX = (Index) jNDXes.elementAt(i - 1);
				return (Index) jNDXes.elementAt(i - 1);
			}
		}
		throw new xBaseJException("Unknown Index " + ID);

	}

	/**
	 * associates all Index operations with an existing tag.
	 * @param tagname      an existing tag name in the production MDX file
	 * @throws xBaseJException
	 *                                    no MDX file
	 *                                    tagname not found
	 */
	public Index useTag(String tagname) throws xBaseJException {
		if (MDXfile == null)
			throw new xBaseJException("No MDX file associated with this database");
		jNDX = MDXfile.getMDX(tagname);
		return jNDX;
	}

	/**
	 * associates all Index operations with an existing tag.
	 * @param tagname      an existing tag name in the production MDX file
	 * @param ID      a unique id to define Index at run-time.
	 * @throws xBaseJException
	 *                                    no MDX file
	 *                                    tagname not found
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public Index useTag(String tagname, String ID)
		throws xBaseJException, IOException {
		useTag(tagname);
		jNDXID.addElement(ID);

		return useTag(tagname);
	}

	/**
	 * creates a new Index as a NDX file, assumes NDX file does not exist.
	 * @param filename      a new Index file name
	 * @param index          string identifying Fields used in Index
	 * @param unique         boolean to indicate if the key is always unique
	 * @throws xBaseJException
	 *                                    NDX file already exists
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public Index createIndex(String filename, String index, boolean unique)
		throws xBaseJException, IOException {
		return createIndex(filename, index, false, unique);
	}

	/**
	 * creates a new Index as a NDX file.
	 * @param filename      a new Index file name
	 * @param index          string identifying Fields used in Index
	 * @param destroy       permission to destory NDX if file exists
	 * @param unique         boolean to indicate if the key is always unique
	 * @throws xBaseJException
	 *                                    NDX file already exists
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public Index createIndex(
		String filename,
		String index,
		boolean destroy,
		boolean unique)
		throws xBaseJException, IOException {
		jNDX = new NDX(filename, index, this, destroy, unique);
		jNDXes.addElement(jNDX);
		return jNDX;
	}

	/**
	 * creates a tag in the MDX file.
	 * @param tagname      a non-existing tag name in the production MDX file
	 * @param tagIndex      string identifying Fields used in Index
	 * @param unique         boolean to indicate if the key is always unique
	 * @throws xBaseJException
	 *                                    no MDX file
	 *                                    tagname already exists
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public Index createTag(String tagname, String tagIndex, boolean unique)
		throws xBaseJException, IOException {
		if (MDXfile == null)
			throw new xBaseJException("No MDX file associated with this database");
		jNDX = MDXfile.createTag(tagname, tagIndex, unique);
		jNDXes.addElement(jNDX);
		return (MDX) jNDX;
	}

	/**
	 * used to find a record with an equal or greater string value.
	 * when done the record pointer and field contents will be changed.
	 * @param keyString  a search string
	 * @param lock boolean lock record indicator
	 * @return boolean indicating if the record found contains the exact key
	 * @throws xBaseJException
	 *                                    org.xBaseJ no Indexs opened with database
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public boolean find(String keyString, boolean lock)
		throws xBaseJException, IOException {
		if (jNDX == null)
			throw new xBaseJException("Index not defined");
		int r = jNDX.find_entry(keyString);
		if (r < 1)
			throw new xBaseJException("Record not found");

		if (lock)
			lockRecord(r);

		gotoRecord(r);

		return jNDX.compareKey(keyString);

	}
	/**
	 * used to find a record with an equal or greater string value.
	 * when done the record pointer and field contents will be changed.
	 * @param keyString  a search string
	 * @return boolean indicating if the record found contains the exact key
	 * @throws xBaseJException
	 *                                    org.xBaseJ no Indexs opened with database
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public boolean find(String keyString) throws xBaseJException, IOException {
		return find(keyString, false);
	}

	/**
	 * used to find a record with an equal and at the particular record.
	 * when done the record pointer and field contents will be changed.
	 * @param keyString  a search string
	 * @param recno - int record number
	 * @param lock - boolean lock record indicator
	 * @return boolean indicating if the record found contains the exact key
	 * @throws xBaseJException
	 *                                    org.xBaseJ Index not opened or not part of the database
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public boolean find(String keyString, int recno, boolean lock)
		throws xBaseJException, IOException {
		if (jNDX == null)
			throw new xBaseJException("Index not defined");

		int r = jNDX.find_entry(keyString, recno);
		if (r < 1)
			throw new xBaseJException("Record not found");

		if (lock)
			lockRecord();

		gotoRecord(r);

		return jNDX.compareKey(keyString);

	}
	/**
	 * used to find a record with an equal and at the particular record.
	 * when done the record pointer and field contents will be changed.
	 * @param keyString  a search string
	 * @return boolean indicating if the record found contains the exact key
	 * @throws xBaseJException
	 *                                    org.xBaseJ Index not opened or not part of the database
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public boolean find(String keyString, int recno)
		throws xBaseJException, IOException {

		return find(keyString, recno, false);

	}

	/**
	 * used to find a record with an equal string value.
	 * when done the record pointer and field contents will be changed only if the exact key is found.
	 * @param keyString  a search string
	 * @param lock - boolean lock record indiator
	 * @return boolean indicating if the record found contains the exact key
	 * @throws xBaseJException
	 *                                    org.xBaseJ no Indexs opened with database
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public boolean findExact(String keyString, boolean lock)
		throws xBaseJException, IOException {
		if (jNDX == null)
			throw new xBaseJException("Index not defined");
		int r = jNDX.find_entry(keyString);
		if (r < 1)
			return false;

		if (jNDX.didFindFindExact()) {
			if (lock)
				lockRecord();
			gotoRecord(r);
		}

		return jNDX.didFindFindExact();

	}

	/**
	 * used to find a record with an equal string value.
	 * when done the record pointer and field contents will be changed only if the exact key is found.
	 * @param keyString  a search string
	 * @return boolean indicating if the record found contains the exact key
	 * @throws xBaseJException
	 *                                    org.xBaseJ no Indexs opened with database
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public boolean findExact(String keyString)
		throws xBaseJException, IOException {
		return findExact(keyString, false);

	}

	/**
	 * used to get the next  record in the index list.
	 * when done the record pointer and field contents will be changed.
	 * @param lock - boolean lock record indicator
	 * @throws xBaseJException
	 *                                    org.xBaseJ Index not opened or not part of the database
	 *                                    eof - end of file
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void findNext(boolean lock) throws xBaseJException, IOException {
		if (jNDX == null)
			throw new xBaseJException("Index not defined");
		int r = jNDX.get_next_key();
		if (r == -1)
			throw new xBaseJException("End Of File");

		if (lock)
			lockRecord();
		gotoRecord(r);
	}

	/**
	 * used to get the next  record in the index list.
	 * when done the record pointer and field contents will be changed
	 * @throws xBaseJException
	 *                                    org.xBaseJ Index not opened or not part of the database
	 *                                    eof - end of file
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void findNext() throws xBaseJException, IOException {
		findNext(false);
	}

	/**
	 * used to get the previous record in the index list.
	 * when done the record pointer and field contents will be changed.
	 * @param lock boolean lock record indicator
	 * @throws xBaseJException
	 *                                    org.xBaseJ Index not opened or not part of the database
	 *                                    tof - top of file
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public void findPrev(boolean lock) throws xBaseJException, IOException {
		if (jNDX == null)
			throw new xBaseJException("Index not defined");
		int r = jNDX.get_prev_key();
		if (r == -1)
			throw new xBaseJException("Top Of File");

		if (lock)
			lockRecord();

		gotoRecord(r);

	}
	/**
	 * used to get the previous record in the index list.
	 * when done the record pointer and field contents will be changed.
	 * @throws xBaseJException
	 *                                    org.xBaseJ Index not opened or not part of the database
	 *                                    tof - top of file
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public void findPrev() throws xBaseJException, IOException {
		findPrev(false);
	}

	/**
	 * used to read the next record, after the current record pointer, in the database.
	 * when done the record pointer and field contents will be changed.
	 * @param lock - boolean lock record indicator
	 * @throws xBaseJException
	 *                                    usually the end of file condition
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public void read(boolean lock) throws xBaseJException, IOException {

		if (current_record == count)
			throw new xBaseJException("End Of File");

		current_record++;

		if (lock)
			lockRecord();

		gotoRecord(current_record);

	}

	/**
	 * used to read the next record, after the current record pointer, in the database.
	 * when done the record pointer and field contents will be changed.
	 * @throws xBaseJException
	 *                                    usually the end of file condition
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public void read() throws xBaseJException, IOException {
		read(false);

	}

	/**
	 * used to read the previous record, before the current record pointer, in the database.
	 * when done the record pointer and field contents will be changed.
	 * @param lock - boolean lock record indicator
	 * @throws xBaseJException
	 *                                    usually the top of file condition
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void readPrev(boolean lock) throws xBaseJException, IOException {

		if (current_record < 1)
			throw new xBaseJException("Top Of File");

		current_record--;
		if (lock)
			lockRecord();
		gotoRecord(current_record);

	}

	/**
	 * used to read the previous record, before the current record pointer, in the database.
	 * when done the record pointer and field contents will be changed.
	 * @throws xBaseJException
	 *                                    usually the top of file condition
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void readPrev() throws xBaseJException, IOException {
		readPrev(false);
	}

	/**
	 * used to read a record at a particular place in the database.
	 * when done the record pointer and field contents will be changed.
	 * @param recno the relative position of the record to read
	 * @param lock - boolean lock record indicator
	 * @throws xBaseJException
	 *                                    passed an negative number, 0 or value greater than the number of records in database
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void gotoRecord(int recno, boolean lock)
		throws xBaseJException, IOException {
		/** goes to a specific record in the database */
		int i;
		Field tField;
		if ((recno > count) || (recno < 1)) {
			throw new xBaseJException("Invalid Record Number " + recno);
		}
		current_record = recno;

		if (lock)
			lockRecord();

		seek(recno - 1);

		buffer.clear();

		channel.read(buffer);

		buffer.rewind();

		delete_ind = buffer.get();
		for (i = 0; i < fldcount; i++) {
			tField = (Field) fld_root.elementAt(i);
			tField.read();
		}

		Index NDXes;
		for (i = 1; i <= jNDXes.size(); i++) {
			NDXes = (Index) jNDXes.elementAt(i - 1);
			NDXes.set_active_key(NDXes.build_key());
		}

	}

	/**
	 * used to read a record at a particular place in the database.
	 * when done the record pointer and field contents will be changed.
	 * @param recno the relative position of the record to read
	 * @throws xBaseJException
	 *                                    passed an negative number, 0 or value greater than the number of records in database
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void gotoRecord(int recno) throws xBaseJException, IOException {
		/** goes to a specific record in the database */
		gotoRecord(recno, false);

	}

	/**
	 * used to position record pointer at the first record or index in the database.
	 * when done the record pointer will be changed.  NO RECORD IS READ.
	 * Your program should follow this with either a read (for non-index reads) or findNext (for index processing)
	 * @return String starting index
	 * @throws xBaseJException
	 *                                    most likely no records in database
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void startTop() throws xBaseJException, IOException {
		if (jNDX == null)
			current_record = 0;
		else
			jNDX.position_at_first();
	}

	/**
	 * used to position record pointer at the last record or index in the database.
	 * when done the record pointer will be changed. NO RECORD IS READ.
	 * Your program should follow this with either a read (for non-index reads) or findPrev (for index processing)
	 * @return String terminal index
	 * @throws xBaseJException
	 *                                    most likely no records in database
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void startBottom() throws xBaseJException, IOException {
		if (jNDX == null)
			current_record = count + 1;
		else
			jNDX.position_at_last();
	}

	/**
	 * used to write a new record in the database.
	 * when done the record pointer is at the end of the database.
	 * @param lock - boolean lock indicator - locks the entire file
	 * during the write process and then unlocks the file.
	 * @throws xBaseJException
	 *                                    any one of several errors
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public void write(boolean lock) throws xBaseJException, IOException {
		/** writes a new record in the database */
		int i;
		byte wb;
		Field tField;

		Index NDXes;
		for (i = 1; i <= jNDXes.size(); i++) {
			NDXes = (Index) jNDXes.elementAt(i - 1);
			NDXes.check_for_duplicates(Index.findFirstMatchingKey);
		}
		if (lock)
			lock();
		read_dbhead();

		seek(count);


		delete_ind = NOTDELETED;
		buffer.position(0);
		buffer.put(delete_ind);

		for (i = 0; i < fldcount; i++) {
			tField = (Field) fld_root.elementAt(i);
			tField.write();
		}


		buffer.position(0);
		channel.write(buffer);

		wb = 0x1a;
        file.writeByte(wb);


		if (MDX_exist != 1 && (version == DBFTypes.DBASEIII || version == DBFTypes.DBASEIII_WITH_MEMO)) {
			buffer.position(0);
			channel.write(buffer);
			wb = ' ';
			for (i = 0; i < lrecl; i++)
			    file.writeByte(wb);;
		}




		for (i = 1; i <= jNDXes.size(); i++) {
			NDXes = (Index) jNDXes.elementAt(i - 1);
			NDXes.add_entry((count + 1));
		}


		count++;
		update_dbhead();
		current_record = count;

		if (lock)
			unlock();

		unlockRecord();
	}

	/**
	 * used to write a new record in the database.
	 * when done the record pointer is at the end of the database.
	 * @throws xBaseJException
	 *                                    any one of several errors
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */
	public void write() throws xBaseJException, IOException {
		write(false);
	}

	/**
	 * updates the record at the current position.
	 * @param lock - boolean lock indicator - locks the entire file
	 * during the write process and then unlocks the file.
	 * Also record lock will be released, regardless of parameter value
	 * @throws xBaseJException
	 *                                    any one of several errors
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void update(boolean lock) throws xBaseJException, IOException {

		int i;
		Field tField;

		if ((current_record < 1) || (current_record > count)) {
			throw new xBaseJException("Invalid current record pointer");
		}

		if (lock)
			lock();

		seek(current_record - 1);

		buffer.position(0);
		buffer.put(delete_ind);

		Index NDXes;

		for (i = 1; i <= jNDXes.size(); i++) {
			NDXes = (Index) jNDXes.elementAt(i - 1);
			NDXes.check_for_duplicates(current_record);
		}

		for (i = 1;
			i <= jNDXes.size();
			i++) //  reposition record pointer and current key for index update
			{
			NDXes = (Index) jNDXes.elementAt(i - 1);
			NDXes.find_entry(NDXes.get_active_key(), current_record);
		}

		for (i = 0; i < fldcount; i++) {
			tField = (Field) fld_root.elementAt(i);
			if (tField.isMemoField())
				tField.update();
			else
				tField.write();
		}

		buffer.position(0);
		channel.write(buffer);

		for (i = 1; i <= jNDXes.size(); i++) {
			NDXes = (Index) jNDXes.elementAt(i - 1);
			NDXes.update(current_record);
		}

		if (lock)
			unlock();

		unlockRecord();

	}

	/**
	 * updates the record at the current position.
	 * @throws xBaseJException
	 *                                    any one of several errors
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void update() throws xBaseJException, IOException {
		update(false);
	}

	protected void seek(long recno) throws IOException {

		long calcpos = (offset + (lrecl * recno));
		file.seek(calcpos);
	}

	/**
	 * marks the current records as deleted.
	 * @throws xBaseJException
	 *                                    usually occurs when no record has been read
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void delete() throws IOException, xBaseJException {

	    lockRecord();
		seek(current_record-1);
		delete_ind = DELETED;

		file.writeByte(delete_ind);
		unlockRecord();

	}

	/**
	 * marks the current records as not deleted.
	 * @throws xBaseJException
	 *                                    usually occurs when no record has been read.
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void undelete() throws IOException, xBaseJException {

		lockRecord();
		seek(current_record-1);
		delete_ind = NOTDELETED;

		file.writeByte(delete_ind);
		unlockRecord();


	}
	/**
	 * closes the database.
	 * @throws IOException
	 *                                    Java error caused by called methods
	 */

	public void close() throws IOException {

		short i;

		if (dbtobj != null)
			dbtobj.close();

		Index NDXes;
		NDX n;

        if (jNDXes != null) {
		for (i = 1; i <= jNDXes.size(); i++) {
			NDXes = (Index) jNDXes.elementAt(i - 1);
			if (NDXes instanceof NDX) {
				n = (NDX) NDXes;
				n.close();
			}
		}
        }  // end test for null jNDXes  20091010_rth

		if (MDXfile != null)
			MDXfile.close();

		dbtobj = null;
		jNDXes = null;
		MDXfile = null;
		unlock();

		file.close();

	}

	/**
	 * returns a Field object by its relative position.
	 * @param i Field number
	 * @throws xBaseJException
	 *                                    usually occurs when Field number is less than 1 or greater than the number of fields
	 */

	public Field getField(int i)
		throws ArrayIndexOutOfBoundsException, xBaseJException {
		if ((i < 1) || (i > fldcount)) {
			throw new xBaseJException("Invalid Field number");
		}

		return (Field) fld_root.elementAt(i - 1);
	}

	/**
	 * returns a Field object by its name in the database.
	 * @param name Field name
	 * @throws xBaseJException
	 *                                    Field name is not correct
	 */

	public Field getField(String name)
		throws xBaseJException, ArrayIndexOutOfBoundsException {
		short i;
		Field tField;

		for (i = 0; i < fldcount; i++) {
			tField = (Field) fld_root.elementAt(i);
			if (name.toUpperCase().compareTo(tField.getName().toUpperCase())
				== 0) {
				return tField;
			}
		} /* endfor */

		throw new xBaseJException("Field not found " + name);
	}

	/**
	 * returns the full path name of the database
	 */

	public String getName() {
		return dosname;
	}

	/**
	 * returns true if record is marked for deletion
	 */

	public boolean deleted() {
		return (delete_ind == DELETED);
	}

	protected void db_offset(DBFTypes format, boolean memoPresent) {

		if (format == DBFTypes.FOXPRO_WITH_MEMO)
			if (memoPresent)
				version = DBFTypes.FOXPRO_WITH_MEMO;
			else
				version = DBFTypes.DBASEIV;
		else if (
			format == DBFTypes.DBASEIV_WITH_MEMO || format == DBFTypes.DBASEIV || MDX_exist == 1)
			if (memoPresent)
				version = DBFTypes.DBASEIV_WITH_MEMO;
			else
				version = DBFTypes.DBASEIII; //DBASEIV;
		else if (memoPresent)
			version = DBFTypes.DBASEIII_WITH_MEMO;
		else
			version = DBFTypes.DBASEIII;

		count = 0; /* number of records in file */
		offset = 33; /* length of the offset includes the \r at end */
		lrecl = 1; /* length of a record includes the delete byte */
		incomplete_transaction = 0;
		encrypt_flag = 0;
		language = 0;

		// flip it back

	}

	protected void read_dbhead() throws IOException {
		short currentrecord = 0; // not really used

		file.seek(0);
		byte fileVersion = file.readByte();
		if (fileVersion == DBFTypes.DBASEIII.getValue())
			  version = DBFTypes.DBASEIII;
		else
			if (fileVersion == DBFTypes.DBASEIII_WITH_MEMO.getValue())
				  version = DBFTypes.DBASEIII_WITH_MEMO;
			else
				if (fileVersion == DBFTypes.DBASEIV.getValue())
					  version = DBFTypes.DBASEIV;
				else
					if (fileVersion == DBFTypes.DBASEIV_WITH_MEMO.getValue())
						  version = DBFTypes.DBASEIV_WITH_MEMO;
					else
						if (fileVersion == DBFTypes.FOXPRO_WITH_MEMO.getValue())
							  version = DBFTypes.FOXPRO_WITH_MEMO;
						else
							version = DBFTypes.DBASEIII;
		 
		file.read(l_update, 0, 3);

		count = Util.x86(file.readInt());
		offset = Util.x86(file.readShort());
		lrecl = Util.x86(file.readShort());

		currentrecord = Util.x86(file.readShort());
		current_record = Util.x86(currentrecord);

		incomplete_transaction = file.readByte();
		encrypt_flag = file.readByte();
		file.read(reserve, 0, 12);
		MDX_exist = file.readByte();
		language = file.readByte();
		file.read(reserve2, 0, 2);

	}

	public void update_dbhead() throws IOException {
		if (readonly)
			return;
		short currentrecord = 0;

		file.seek(0);

		Calendar d = Calendar.getInstance();

		if (d.get(Calendar.YEAR) < 2000)
			l_update[0] = (byte) (d.get(Calendar.YEAR) - 1900);
		else
			l_update[0] = (byte) (d.get(Calendar.YEAR) - 2000);

		l_update[1] = (byte) (d.get(Calendar.MONTH) + 1);
		l_update[2] = (byte) (d.get(Calendar.DAY_OF_MONTH));

		file.writeByte(version.getValue());
		file.write(l_update, 0, 3);
		file.writeInt(Util.x86(count));
		file.writeShort(Util.x86(offset));
		file.writeShort(Util.x86(lrecl));
		file.writeShort(Util.x86(currentrecord));

		file.write(incomplete_transaction);
		file.write(encrypt_flag);
		file.write(reserve, 0, 12);
		file.write(MDX_exist);
		file.write(language);
		file.write(reserve2, 0, 2);

	}

	protected Field read_Field_header() throws IOException, xBaseJException {

		Field tField;
		int i;
		byte[] byter = new byte[15];
		String name;
		char type;
		byte length;
		int iLength;
		int decpoint;

		file.readFully(byter, 0, 11);
		for (i = 0; i < 12 && byter[i] != 0; i++);
		try {
			name = new String(byter, 0, i, DBF.encodedType);
		} catch (UnsupportedEncodingException UEE) {
			name = new String(byter, 0, i);
		}

		type = (char) file.readByte();

		file.readFully(byter, 0, 4);

		length = file.readByte();
		if (length > 0)
			iLength = (int) length;
		else
			iLength = 256 + (int) length;
		decpoint = file.readByte();
		
		file.readFully(byter, 0, 14);

		switch (type) {
			case CharField.type:
				if (decpoint > 0)
					iLength += decpoint * 256;
				tField = new CharField(name, iLength, buffer);
				break;
			case DateField.type :
				tField = new DateField(name, buffer);
				break;
			case FloatField.type :
				tField = new FloatField(name, iLength, decpoint, buffer);
				break;
			case LogicalField.type :
				tField = new LogicalField(name, buffer);
				break;
			case MemoField.type:
				tField = new MemoField(name, buffer, dbtobj);
				break;
			case NumField.type :
				tField = new NumField(name, iLength, decpoint, buffer);
				break;
			case PictureField.type :
				tField = new PictureField(name, buffer, dbtobj);
				break;
			case CurrencyField.type :
				tField = new CurrencyField(name, buffer);
				break;
			default :
				throw new xBaseJException("Unknown Field type '"+type+"' for " + name);
		} /* endswitch */

		return tField;
	}

	protected void write_Field_header(Field tField)
		throws IOException, xBaseJException {

		byte[] byter = new byte[15];

		int nameLength = tField.getName().length();
		int i = 0;
		byte b[];
		try {
			b = tField.getName().toUpperCase().getBytes(DBF.encodedType);
		} catch (UnsupportedEncodingException UEE) {
			b = tField.getName().toUpperCase().getBytes();
		}
		for (int x = 0; x < b.length; x++)
			byter[x] = b[x];

		file.write(byter, 0, nameLength);

		for (i = 0; i < 14; i++)
			byter[i] = 0;

		file.writeByte(0);
		if (nameLength < 10)
			file.write(byter, 0, 10 - nameLength);

		file.writeByte((int) tField.getType());

		file.write(byter, 0, 4);

		if (tField.isCharField()&&tField.getLength()>256) {
			file.writeByte((int) tField.getLength() % 256);
			file.writeByte((int) tField.getLength() / 256);
		}
		else {
		file.writeByte((int) tField.getLength());
		file.writeByte(tField.getDecimalPositionCount());
		}

		if (version == DBFTypes.DBASEIII || version == DBFTypes.DBASEIII_WITH_MEMO)
			byter[2] = 1;

		file.write(byter, 0, 14);

	}

	public void setVersion(DBFTypes b) {
		version =  b;
	}

	/**
	 * packs a DBF by removing deleted records and memo fields.
	 * @throws xBaseJException
	 *                                    File does exist and told not to destroy it.
	 * @throws xBaseJException
	 *                                    Told to destroy but operating system can not destroy
	 * @throws IOException
	 *                                    Java error caused by called methods
	 * @throws CloneNotSupportedException
	 *                                    Java error caused by called methods
	 */

	public void pack()
		throws
			xBaseJException,
			IOException,
			SecurityException,
			CloneNotSupportedException {
		Field Fields[] = new Field[fldcount];

		int i, j;
		for (i = 1; i <= fldcount; i++) {
			Fields[i - 1] = (Field) getField(i).clone();
		}

		String parent = ffile.getParent();
		if (parent == null)
			parent = ".";

		File f = File.createTempFile("tempxbase", "tmp");
 		String tempname = f.getAbsolutePath();

		DBF tempDBF = new DBF(tempname, version, true);

	    tempDBF.reserve = reserve;
	    tempDBF.language  = language;
	    tempDBF.reserve2 = reserve2;

		tempDBF.MDX_exist = MDX_exist;
		tempDBF.addField(Fields);

		Field t, p;
		for (i = 1; i <= count; i++) {
			gotoRecord(i);
			if (deleted()) {
				continue;
			}
			tempDBF.buffer.position(1);
			for (j = 1; j <= fldcount; j++) {
				t = tempDBF.getField(j);
				p = getField(j);
				t.put(p.get());
			}
			tempDBF.write();
		}

		file.close();
		ffile.delete();
		tempDBF.renameTo(dosname);

		if (dbtobj != null) {
			dbtobj.file.close();
			dbtobj.thefile.delete();
		}

		if (tempDBF.dbtobj != null) {
			//   tempDBF.dbtobj.file.close();
			tempDBF.dbtobj.rename(dosname);
			dbtobj = tempDBF.dbtobj;
			Field tField;
			MemoField mField;
			for (i = 1; i <= fldcount; i++) {
				tField = getField(i);
				if (tField.isMemoField()) {
					mField = (MemoField) tField;
					mField.setDBTObj(dbtobj);
				}
			}
		}

		ffile = new File(dosname);

		file = new RandomAccessFile(dosname, "rw");

		channel = file.getChannel();

		read_dbhead();

		for (i = 1; i <= fldcount; i++)
			getField(i).setBuffer(buffer);

		Index NDXes;

		if (MDXfile != null)
			MDXfile.reIndex();

		if (jNDXes.size() == 0) {
			current_record = 0;
		} else {
			for (i = 1; i <= jNDXes.size(); i++) {
				NDXes = (Index) jNDXes.elementAt(i - 1);
				NDXes.reIndex();

			}
			NDXes = (Index) jNDXes.elementAt(0);
			if (count > 0)
				startTop();
		}

	}

	/** returns the dbase version field.
	 * @return DBFType
	 */

	public DBFTypes getVersion() {
		return version;
	}

	/** sets the character encoding variable.
	  * <br>  do this prior to opening any dbfs.
	  * @param inType encoding type, default is "8859_1" could use "CP850" others
	  */

	public static void setEncodingType(String inType) {
		encodedType = inType;
	}

	/** gets the character encoding string value.
	  * @return String "8859_1", "CP850", ..
	  */

	public static String getEncodingType() {
		return encodedType;
	}

	/** generates an xml string representation using xbase.dtd
	 * @param inFileName - String
	 * @return File, file is closed when returned.
	 */

	public File getXML(String inFileName) throws IOException, xBaseJException {

		File file = new File(inFileName);
		if (file.exists())
			file.delete();
		FileOutputStream fos = new FileOutputStream(file);
		PrintWriter pw = new PrintWriter(fos, true);
		getXML(pw);
		return file;

	}

	/** generates an xml string representation using xbase.dtd
	 * @param pw - PrinterWriter
	 */
	public void getXML(PrintWriter pw)throws IOException, xBaseJException  {
		pw.println("<?xml version=\"1.0\"?>");
		pw.println("<!-- org.xBaseJ release " + xBaseJVersion + "-->");
		pw.println("<!-- http://www.americancoders.com-->");
		pw.println("<!DOCTYPE dbf SYSTEM \"xbase.dtd\">");
		int i;
		pw.println(
			"<dbf name=\""
				+ Util.normalize(getName())
				+ "\" encoding=\""
				+ getEncodingType()
				+ "\">");
		Field fld;
		for (i = 1; i <= getFieldCount(); i++) {
			fld = getField(i);
			pw.print("  <field name=\"" + fld.getName() + "\"");
			pw.print(" type=\"" + fld.getType() + "\"");
			if ((fld.getType() == 'C')
				|| (fld.getType() == 'N')
				|| (fld.getType() == 'F'))
				pw.print(" length=\"" + fld.getLength() + "\"");
			if ((fld.getType() == 'N') || (fld.getType() == 'F'))
				pw.print(
					" decimalPos=\"" + fld.getDecimalPositionCount() + "\"");
			pw.println("/>");

		}
		int j;
		for (j = 1; j <= getRecordCount(); j++) {
			gotoRecord(j);
			pw.print("  <record");
			if (deleted())
				pw.print(" deleted=\"Y\"");
			pw.println(">");
			for (i = 1; i <= getFieldCount(); i++) {
				fld = getField(i);
				pw.print("    <field name=\"" + fld.getName() + "\">");
				pw.print(Util.normalize(fld.get()));
				pw.println("</field>");
			}
			pw.println("  </record>");
		}
		pw.println("</dbf>");
		pw.close();


	}

    //  20091012_rth
    //      Added this method to get around problem with renameTo().
    //      When temporary file is on different device than original
    //      database rename fails.
    //      Java never provided a universal interface for system level file
    //      copy.
    public void copyTo(String newname) throws IOException {
        @SuppressWarnings("resource")
		FileChannel srcChannel = new FileInputStream(dosname).getChannel();
        @SuppressWarnings("resource")
		FileChannel dstChannel = new FileOutputStream(newname).getChannel();

        // Copy file contents from source to destination
        dstChannel.transferFrom(srcChannel, 0, srcChannel.size());

        // Close the channels
        srcChannel.close();
        dstChannel.close();

    }  // end copyTo method
}
