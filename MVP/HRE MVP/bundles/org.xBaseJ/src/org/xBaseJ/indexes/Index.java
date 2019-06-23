package org.xBaseJ.indexes;
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
 *  20091007  Roland Hughes (rth)   Made a patch to make date index work.
 *                                  The way things are, Date and Numeric
 *                                  will only work if they are keys by
 *                                  themselves.  If you need dates or
 *                                  numbers to be part of a segmented key
 *                                  you need to declare them as Character
 *                                  columns.
 *  20091007  joe mcverry (jrm)     Corrected error in checking date indexing.
 *                                  
 *  20110401  joe mcverry (jrm)     Moved unique_key check to before building a key.
 *                                  
 *                                  
*/

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Vector;

import org.xBaseJ.DBF;
import org.xBaseJ.Util;
import org.xBaseJ.xBaseJException;
import org.xBaseJ.fields.Field;


public abstract class Index
 {
public int top_Node;
public int next_available;
public int reserved_02;
public short key_length;
public short key_per_Node;
public char keyType;
public short key_entry_size;
public byte reserved_01;
public byte reserved_03;
public byte reserved_04;
public byte unique_key;
public byte key_definition[];

public Vector<Field> keyControl;
public NodeKey activeKey;
public int record; // the current key's record

public Node topNode = null;
public Node workNode;
public File file;
public RandomAccessFile nfile;
public FileChannel channel;
public ByteBuffer bytebuffer;
public String dosname;
public DBF database;

public String stringKey;

public static final int findFirstMatchingKey = -1;
public static final int findAnyKey = -2;
public static final int keyNotFound = -3;
public static final int foundMatchingKeyButNotRecord = -4;

public  boolean foundExact = false;

public Index()
{
    key_definition = new byte[488];
    keyControl = new Vector<Field>();
    dosname = new String("");
    activeKey = null;

}


public  boolean compareKey(String keyToCompare) throws   xBaseJException, IOException
{
  NodeKey tempKey;

  if (keyType == 'F')
     tempKey = new NodeKey(new NodeFloat(Double.valueOf(keyToCompare).doubleValue()));
  else
  if (keyType == 'N'){
     Double d = new Double(keyToCompare);
     tempKey = new NodeKey(d);
     }
  else
      tempKey = new NodeKey(keyToCompare);

   return (activeKey.compareKey(tempKey) == 0);

}

public  abstract int  add_entry(NodeKey key,  int recno) throws   xBaseJException, IOException;

public  int  add_entry(int recno) throws   xBaseJException, IOException
 {
   NodeKey newkey = build_key();
   return add_entry(newkey, recno);
 }


public  abstract int find_entry(NodeKey key) throws   xBaseJException, IOException;
public abstract  int find_entry(NodeKey key, int recno) throws   xBaseJException, IOException;

public  int find_entry(String key) throws   xBaseJException, IOException
{
  if (keyType == 'F')
     return find_entry(new NodeKey(new NodeFloat(Double.valueOf(key).doubleValue())));

  if (keyType == 'N')   {                   // 20091009_rth - begin 
     double d = 0.0;
     Field f;

     f = (Field) keyControl.elementAt(0);
     
     if (f.getType() == 'D') // 20091030_jrm - begin
             d =  Util.doubleDate(key); // 20091030_jrm - end
     else d =  Double.valueOf(key ).doubleValue() ;

                                            // 20091009_rth - end
     return find_entry(new NodeKey(new Double(d)));
     }

  return find_entry(new NodeKey(key));

}
public   int find_entry(String key, int recno) throws   xBaseJException, IOException
{

  if (keyType == 'F')
     record = find_entry( new NodeKey( new NodeFloat( Double.valueOf( key) .doubleValue())), recno);
  else if (keyType == 'N')
     record = find_entry(new NodeKey(new Double(key)), recno);
  else record = find_entry(new NodeKey(key), recno);

  return record;
}
public abstract  int get_next_key() throws   xBaseJException, IOException;
public abstract  int get_prev_key() throws   xBaseJException, IOException ;
public abstract void  del_entry(Node inNode) throws IOException, xBaseJException;
public abstract void  reIndex() throws   xBaseJException, IOException;

public void check_for_duplicates(int count) throws xBaseJException, IOException
{

   if (topNode == null)  // no index records yet
      return;

   if (unique_key == 0)
	      return;

   int ret = find_entry(build_key(), findFirstMatchingKey);

   if (ret == keyNotFound)
      return;

   if (count == findFirstMatchingKey)  // write request.
       if (ret == count)
          return;

   if (count > 0){  // update request sends a specific record number if it matches it's okay.
       if (ret == count)
         {
          return;
         }
      }

   if (ret > 0)
       throw new xBaseJException("Duplicate key error");
}

public String getName() { return dosname.trim(); }

public String getKeyFields() { return stringKey; }

public String buildKey() throws xBaseJException
{
   return build_key().toString();
}

public NodeKey build_key() throws xBaseJException
{

  NodeKey dataptr;
  int i;
  Field f;
  double doubleer = 0.0;
  switch (keyType)
   {
      case 'F':
        for (i = 0; i < keyControl.size(); i++)
         {
             f = (Field) keyControl.elementAt(i);
             if (f.get() == null);
             else if (f.get().length() == 0);
             else if (f.getType() == 'D')
                    doubleer +=  Util.doubleDate(f.get());
             else doubleer +=  Double.valueOf(f.get() ).doubleValue() ;
       }	   			/* endfor */
       dataptr = new NodeKey(new NodeFloat(doubleer));
        break;
 	  case 'N':
         for (i = 0; i < keyControl.size(); i++)
          {
              f = (Field) keyControl.elementAt(i);
              if (f.get() == null);
              else if (f.get().length() == 0);
              else if (f.getType() == 'D')
                     doubleer +=  Util.doubleDate(f.get());
              else doubleer +=  Double.valueOf(f.get() ).doubleValue() ;
        }	   			/* endfor */
        dataptr = new NodeKey(new Double(doubleer));
         break;
      default:
           StringBuffer sb = new StringBuffer();
           for (i = 0; i < keyControl.size(); i++)
                {
                  f = (Field) keyControl.elementAt(i);

                   sb.append(f.get());
                 }	/* endfor */
           dataptr = new NodeKey(new String(sb));
         break;
      }
  return dataptr;

}


public boolean  is_unique_key()
{
  return  (unique_key != 0);
}


public void  set_active_key(NodeKey key)
{
      activeKey = key;
}

public NodeKey get_active_key()
{
   return activeKey;
  }

public void  set_key_definition(String definition)
{
    byte kd[];
    try {kd = definition.getBytes(DBF.encodedType);}
    catch (UnsupportedEncodingException UEE){ kd = definition.getBytes();}
    for (int x=0; x<kd.length; x++)
      key_definition[x] = kd[x];
}


public  void  update(int recno) throws   xBaseJException, IOException
{
  NodeKey bkey = build_key();
  record = find_entry(activeKey, recno);
  if (record == recno)
    {  if (bkey.compareKey(activeKey) != 0)
         { del_entry(workNode);
           add_entry(recno);
         }
    }
  else
         add_entry(recno);
}



public void position_at_first() throws xBaseJException, IOException
{
  String startKey;
  if (keyType == 'N')
       startKey = new NodeKey(new Double(-1.78e308)).toString();
  else
  if (keyType == 'F')
       startKey = new NodeKey(new NodeFloat(-1.78e308)).toString();
  else
       startKey = new NodeKey(new String("\u0000")).toString();

  find_entry(startKey,  -1);
  workNode.set_pos(-1);

}


public void position_at_last() throws xBaseJException, IOException
{
  String startKey;
  if (keyType == 'N')
       startKey  = new NodeKey(new Double(1.78e308)).toString();
  else
  if (keyType == 'F')
       startKey = new NodeKey(new NodeFloat(1.78e308)).toString();
  else
      startKey = new NodeKey(new String("\uFFFF")).toString();

  find_entry(startKey,  -1);

}

/** return to return if the find_entry function found the exact key requested
 * @return boolean
*/


public boolean didFindFindExact() {return foundExact;}
}

