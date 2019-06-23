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
*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;


public abstract class DBTFile extends Object
{
 public RandomAccessFile file;
 public boolean open;
 public File thefile;
 public int memoBlockSize = 512;
 public int nextBlock;
 public DBF database;
 public static final byte BYTEZERO = (byte) '0';
 public static final byte BYTESPACE = (byte) ' ';

 public String extension = "dbt";

public void rename(String name) throws IOException
{

String tname = new String(name.substring(0,name.length()-1) + "t");
file.close();
File nfile = new File(tname);
nfile.delete();
thefile.renameTo(nfile);
thefile = nfile;
file = new RandomAccessFile(tname, "rw");
}


public DBTFile(DBF iDBF, boolean readonly, DBFTypes foxproWithMemo) throws IOException, xBaseJException, IOException
 {
    database = iDBF;
    String name = iDBF.getName();

   String tname;
   String ext = Util.getxBaseJProperty("memoFileExtension");
   if (ext.length()>0) {
	 tname = new String(name.substring(0,name.length()-3) + ext);
     extension = ext;
   }
   else
   if (foxproWithMemo == DBFTypes.FOXPRO_WITH_MEMO) {
	extension = "fpt";
    tname = new String(name.substring(0,name.length()-3) + extension);
    thefile = new File(tname);
    if (!thefile.exists() || !thefile.isFile())
      {
         throw new xBaseJException("Can't find Memo Text file "+ tname);
      }                                /* endif */
   }
   else {
   tname = new String(name.substring(0,name.length()-3) + extension);

   thefile = new File(tname);
   if (!thefile.exists() || !thefile.isFile())
     {
	    String dtname = new String(name.substring(0,name.length()-3) + "fpt");
	    thefile = new File(dtname);
	    if (!thefile.exists() || !thefile.isFile())
	      {
	         throw new xBaseJException("Can't find Memo Text file "+ dtname);
	      }
	    else {
	    	//type = DBF.FOXPRO_WITH_MEMO;
	    	tname = dtname;
	    }

     }
   }/* endif */
   if (readonly)
      file = new RandomAccessFile(tname, "r");
   else
      file = new RandomAccessFile(tname, "rw");
   setNextBlock();

 }

public DBTFile(DBF iDBF, String name, boolean destroy, DBFTypes type) throws IOException, xBaseJException
 {

  database = iDBF;

  String tname;
  String ext = Util.getxBaseJProperty("memoFileExtension");
  if (ext.length()>0) {
    extension = ext;
  }
  else
  if (type == DBFTypes.FOXPRO_WITH_MEMO) // foxpro
	  extension = "fpt";

  tname = new String(name.substring(0,name.length()-3) + extension);

  thefile = new File(tname);

  if (destroy == false)
    if (thefile.exists())
    throw new xBaseJException("Memeo Text File exists, can't destroy");

  if (destroy)
    if (thefile.exists())
       if (thefile.delete() == false)
            throw new xBaseJException("Can't delete old Memo Text file");


  FileOutputStream tFOS = new FileOutputStream(thefile);
  tFOS.close();

  file = new RandomAccessFile(thefile,"rw");

  setNextBlock();


 }


public abstract void setNextBlock() throws IOException;

public abstract byte[] readBytes(byte[] input) throws IOException, xBaseJException;

public abstract byte[] write(String value, int originalSize, boolean write, byte originalPos[]) throws IOException, xBaseJException;

public void seek(int pos) throws IOException
{
  long lpos = pos;
  file.seek(lpos);
}

public void close()
   throws IOException
 {
   open = false;
   file.close();

 }
}


