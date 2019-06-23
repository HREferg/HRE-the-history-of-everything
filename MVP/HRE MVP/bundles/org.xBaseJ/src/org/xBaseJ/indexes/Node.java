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
*/

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

import org.xBaseJ.DBF;
import org.xBaseJ.Util;
import org.xBaseJ.xBaseJException;



public class Node extends Object implements Cloneable
{

public RandomAccessFile nfile;
public int pos = 0;
public int keys_in_a_Node = 0;
public int keys_in_this_Node = 0;
public int key_expression_size = 0;
public int record_number = 0;
public char keyType = 'C';

public byte key_buffer[];

public int lower_level[];
public int key_record_number[];
public NodeKey key_expression[];

public Node prev = null;
public Node next = null;
public boolean branch = false;


public Object clone()
{
  try { return super.clone(); }
  catch (CloneNotSupportedException e) { return null; }
}

public  Node(RandomAccessFile file, int keys_in, int key_size, char keyType, int rn, boolean iBranch)
{
  nfile = file;
  keys_in_a_Node = keys_in;
  key_expression_size = key_size;
  keys_in_this_Node = 0;
  this.keyType = keyType;
  record_number = rn;
  branch = iBranch;

  key_buffer = new byte[key_size];
  key_expression = new NodeKey[keys_in+2];

  key_record_number = new int[keys_in+2];
  lower_level = new int[keys_in+2];

  for (int i = 0; i < keys_in; i++)
    {
       key_record_number[i] = 0;
       lower_level[i] = 0;
    }

  prev = null;
  next = null;

}


public void  set_pos(int ipos)
{
  pos = ipos;

}


public void set_key_expression_size(int l)
{
  key_expression_size = l;
}


public int pos_up()
{
  return ++pos;
}

public void set_record_number(int r) throws xBaseJException
{
 if (r == 0)
   throw new xBaseJException("Invalid record number in set");
  record_number = r;
}

public int get_record_number()
{
  return record_number;
}


public int pos_down()
{
  return --pos;
}


public int get_pos()
{
  return pos;
}


public void  set_key_record_number(int r)
{
  key_record_number[pos] = r;
}


public int get_key_record_number( )
{
  return key_record_number[pos];
}


public void   set_lower_level(int level)
{
  lower_level[pos]  = level;

}


public int get_lower_level( )
{
  return lower_level[pos];

}


public void   set_keys_in_this_Node(int c)
{
  keys_in_this_Node = c;
}


public int get_keys_in_this_Node( )
{
  return  keys_in_this_Node;
}


public void   set_key_value(NodeKey key)
{
  key_expression[pos] = key;
}

public void   set_key_value(String key)
{
  key_expression[pos] = new NodeKey(key);
}

public void   set_key_value(double key)
{
  key_expression[pos] = new NodeKey(new Double(key));
}


public NodeKey  get_key_value()
{
      return key_expression[pos];

}


public void read() throws IOException
{
 int i, j, k;
 long longrecn = record_number;
 nfile.seek(longrecn * 512);
 keys_in_this_Node = Util.x86(nfile.readInt());
 for (i=0; i < keys_in_a_Node; i++)
   {
    lower_level[i] = Util.x86(nfile.readInt());
    key_record_number[i] = Util.x86(nfile.readInt());
      if (keyType == 'N')
      {
        key_expression[i] =  new NodeKey(new Double(Double.longBitsToDouble(nfile.readLong())));
      }
    else
      {
       nfile.readFully(key_buffer, 0, key_expression_size);
       for (k=0; k < key_expression_size && key_buffer[k] != 0 ; k++) ;
       try {key_expression[i] = new NodeKey(new String(key_buffer, 0, k,DBF.encodedType));}
       catch (UnsupportedEncodingException UEE){ key_expression[i] = new NodeKey(new String(key_buffer, 0, k));}
    }
    j = key_expression_size % 4;
    if (j > 0) j = 4 - j;
    for (k=0; k < j; k++)
      nfile.readByte();
   } // for i

  if (lower_level[0] > 0) branch = true;
  else branch = false;

  lower_level[i] = Util.x86(nfile.readInt());


}

public void write() throws IOException,  xBaseJException
{

 int i, j, k, ll = 512;
  if (record_number == 0)
   throw new xBaseJException("Invalid record number in write");

 long longrecn = record_number;

 nfile.seek(longrecn * 512);

 nfile.writeInt(Util.x86(keys_in_this_Node));
 ll -= 4; // sizeof(int)
 for (i=0; i < keys_in_this_Node && i < keys_in_a_Node && key_expression[i] != null; i++)
   {
   if (key_expression[i] == null)
     throw new xBaseJException("Missing node key expression at " + i);
    if ((lower_level[0]==0) &&  (key_record_number[i]==0))
         throw new xBaseJException("Logic mismatch, both pointers are zero");
    nfile.writeInt(Util.x86(lower_level[i]));
    ll-=4;
    nfile.writeInt(Util.x86(key_record_number[i]));
    ll-=4;
     if (key_expression[i].getType() == 'N')
       { double d = key_expression[i].toDouble();
         nfile.writeLong(Double.doubleToLongBits(d));
       }
     if (key_expression[i].getType() == 'C')
         {
           int x;
           byte bytebuffer[];
           try {bytebuffer = key_expression[i].toString().getBytes(DBF.encodedType);}
           catch (UnsupportedEncodingException UEE){ bytebuffer = key_expression[i].toString().getBytes();}
           for (x = 0; x < bytebuffer.length; x++)
               key_buffer[x] = bytebuffer[x];
           for (; x < key_expression_size; x++)
               key_buffer[x] = 0;
            nfile.write(key_buffer, 0, key_expression_size);
         }
    ll -= key_expression_size; // sizeof(2 ints) and full key length to its 4 byte alignment
    j = key_expression_size % 4;
    if (j>0) j = 4 - j;  // 4 byte alignment
    key_buffer[0] = 0;
    for (k=0; k < j; k++) {
         nfile.write(key_buffer[0]);
         ll--;
         }
   } // for i
   if ((branch==true) && (lower_level[i] == 0))
         throw new xBaseJException("Logic mismatch, lower level pointer is zero");
  nfile.writeInt(Util.x86(lower_level[i]));
  ll -= 4; // sizeof(int)
  if (ll > 0) {
    // a Node is 512 bytes long;
    byte temp[] = new byte[ll];
    nfile.write(temp, 0, ll);
}


}


public void set_next(Node nxt)
{
  next =  nxt;
}

public void set_prev(Node prv)
{
  prev =  prv;
}

public Node get_next()
{
  return next;
}

public Node get_prev()
{
 return  prev;
}


public void set_prev_page(int t) throws xBaseJException
{ throw new xBaseJException("method not available"); }

public boolean isBranch() { return branch;}

}

