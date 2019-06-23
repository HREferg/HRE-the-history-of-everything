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
import java.io.UnsupportedEncodingException;

import org.xBaseJ.DBF;
import org.xBaseJ.Util;
import org.xBaseJ.xBaseJException;


public class MNode extends Node
{
int prev_page = 0;
MDXFile mfile;


public  MNode(MDXFile file, int keys_in, int key_size, char keyType, int rn, boolean iBranch)
{
   super(file.raFile, keys_in, key_size, keyType, rn, iBranch);
   mfile = file;
}

public void read() throws IOException
{
 int i, j, k;
 long longrecn =  record_number;
  nfile.seek(longrecn * 512);
  keys_in_this_Node = Util.x86(nfile.readInt());
  prev_page = Util.x86(nfile.readInt());
  if (prev_page == 0)
     branch = false;
  else
     branch = true;

  byte b[] = new byte[12];
  for (i=0; i < keys_in_a_Node; i++)
   {
    key_record_number[i] = Util.x86(nfile.readInt());

    if (keyType == 'F')
      {
        nfile.read(b);
        if (i<keys_in_this_Node)
            key_expression[i] =  new NodeKey(new NodeFloat(b));
        else
            key_expression[i] =  new NodeKey(new NodeFloat(0.0));
      }
    else
    if (keyType == 'N')
      {
        key_expression[i] =  new NodeKey(new Double(Double.longBitsToDouble(nfile.readLong())));
      }
    else
      {
        nfile.readFully(key_buffer, 0, key_expression_size);
        for (k=0; k < key_expression_size && key_buffer[k] != 0 ; k++) ;
        try {key_expression[i] = new NodeKey(new String(key_buffer, 0, k, DBF.encodedType));}
        catch (UnsupportedEncodingException UEE){ key_expression[i] = new NodeKey(new String(key_buffer, 0, k));}
       }


    j = key_expression_size % 4;
    if (j > 0) j = 4 - j;
    for (k=0; k < j; k++)
        nfile.readByte();
   } // for i

key_record_number[i] = Util.x86(nfile.readInt());

if (key_record_number[keys_in_this_Node] > 0) branch = true;
else branch = false;



}



public void write() throws IOException, xBaseJException
{
 int i, j, k, ll;
 long longrecn = record_number;
 nfile.seek(longrecn * 512);
 ll = mfile.anchor.get_blockbytes();

 nfile.writeInt(Util.x86(keys_in_this_Node));
 ll -= 4; // sizeof(int)
 nfile.writeInt(Util.x86(prev_page));
 ll -= 4; // sizeof(int)
   for (i=0; i < keys_in_a_Node && key_expression[i] != null; i++)
   {
   if (key_expression[i] == null)
     throw new xBaseJException("Missing Node Key expression at " + i);
    if ((branch && (i <= keys_in_this_Node)) || (!branch && (i<keys_in_this_Node)))
       nfile.writeInt(Util.x86(key_record_number[i]));
    else
       nfile.writeInt(0);
    ll -= 4;
    j = 0;
    ll -= key_expression_size;
    if (key_expression[i].getType() == 'F')
         {
         nfile.write(key_expression[i].toNodeFloat().getValue());
         }
    else
    if (key_expression[i].getType() == 'N')
         {
         double d = key_expression[i].toDouble();
         nfile.writeLong(Double.doubleToLongBits(d));
         }
    else
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
           j = key_expression_size % 4;
           if (j>0) j = 4 - j;
     }
    key_buffer[0] = 0;
    for (k=0; k < j; k++)
      nfile.write(key_buffer[0]);
    ll -= j; // sizeof(ints) and full key length to its 4 byte alignment
   } // for i

if (branch)
  nfile.writeInt(Util.x86(key_record_number[i]));
else
  nfile.writeInt(0);
ll -= 4; // sizeof(int)
// a Node is 512 bytes long;
if (ll > 0) {
  byte temp[] = new byte[ll];
  nfile.write(temp, 0, ll);
}

}

public void   set_lower_level(int level)
{
  if (branch) {
      key_record_number[pos] = level;
   }
}


public int get_lower_level( )
{
  if (branch)
      return key_record_number[pos];
  else return 0;

}



public int get_prev_page()
{
      return prev_page;
}

public void   set_prev_page(int pp)
{
   prev_page = pp;
}

}
