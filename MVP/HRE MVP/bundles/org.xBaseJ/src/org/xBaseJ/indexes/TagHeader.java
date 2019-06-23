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



public class TagHeader{


RandomAccessFile nfile;

long pos;

  int top_Node = 0;        /* page number of Index root            */
  int pagesused = 0;        /* pages used by the Index              */
  byte flags;
 /* int:3;*/
 /* int desc:1; */           /* 1 if DESCENDING, or 0                */
 /* int Fieldtag:1; */       /* 1 if tag is a Field, or 0            */
 /* int:1; */
 /* int unique_key_bit:1; */           /* 1 if Index is UNIQUE, or 0           */
 /* int:1; */
  byte keyType;    /* C, D or N for key type               */
  byte sql;        /* 1 if optimized for SQL, or 0         */
  byte resrvd3;
  short key_length;        /* length of key in bytes               */
  short key_per_Node;        /* maximum Nodes in a block             */
  short notused; /* put in, key per Node should be LONG but */
                  /* cset realigns at wrong place */
  short key_entry_size;        /* length of an Index record in bytes   */
  short changes;        /* change counter for optimization      */
  byte resrvd4;
  byte unique_key;        /* 40h if UNIQUE, or 0                  */
  byte key_definition[] = new byte[101];    /* the key expression itself            */
  byte for_expression[] = new byte[101];
  byte resrvd5[] = new byte[14];
  int unknown[] = new int[4];

  public MDXFile mfile;
  public String NDXString;




public TagHeader(MDXFile ifile, short ipos) throws IOException
{
mfile = ifile;
nfile = ifile.raFile;
setPos(ipos);
read();
}

public TagHeader(MDXFile ifile, short ipos, short len, char type, boolean unique) throws IOException
{
mfile = ifile;
nfile = ifile.raFile;
setPos(ipos);
//don 't know why these are used so..
resrvd3 = 27;
flags |= 8;
flags |= (byte) (unique ? 2 : 0);
changes = 2;


unique_key = 1;
  //db_unique_idx;


keyType = (byte) type;
key_entry_size = (short) (len + 4);
key_length = len;
key_per_Node = (short) (mfile.anchor.get_blockbytes( ) - (16));
key_per_Node /= key_entry_size;


unknown[1] = 0x10000;

unknown[2] = mfile.anchor.get_nextavailable( );
ifile.anchor.update_nextavailable( );

unknown[3] = top_Node;


write();

}

public void reset(RandomAccessFile ifile)
{
nfile = ifile;
}


public void setPos(short ipos)
{

pos = ipos;
pos *=512;

}

public void  read() throws IOException
{
  nfile.seek(pos);
  top_Node = nfile.readInt();
  pagesused = nfile.readInt();
  flags = nfile.readByte();
  keyType = nfile.readByte();
  sql = nfile.readByte();
  resrvd3 = nfile.readByte();
  key_length = nfile.readShort();
  key_per_Node = nfile.readShort();
  notused = nfile.readShort();
  key_entry_size = nfile.readShort();
  changes = nfile.readShort();
  resrvd4 = nfile.readByte();
  unique_key = nfile.readByte();
  nfile.read(key_definition, 0,101);
  nfile.read(for_expression, 0, 101);
  nfile.read(resrvd5, 0, 14);
  unknown[0] = nfile.readInt();
  unknown[1] = nfile.readInt();
  unknown[2] = nfile.readInt();
  unknown[3] = nfile.readInt();
  redo_numbers();
  int i;
  for (i=0; i< 101; i++)
   {
     if (key_definition[i] == 0)
       {
        break;
       }
   }
  try {NDXString = new String(key_definition,0,i, DBF.encodedType);}
  catch (UnsupportedEncodingException UEE){ NDXString = new String(key_definition,0,i);}

}


void  write() throws IOException
{
  unknown[3] = top_Node;
  redo_numbers();
  nfile.seek(pos);
  nfile.writeInt(top_Node);
  nfile.writeInt(pagesused);
  nfile.writeByte(flags);
  nfile.writeByte(keyType);
  nfile.writeByte(sql);
  nfile.writeByte(resrvd3);
  nfile.writeShort(key_length);
  nfile.writeShort(key_per_Node);
  nfile.writeShort(notused);
  nfile.writeShort(key_entry_size);
  nfile.writeShort(changes);
  nfile.writeByte(resrvd4);
  nfile.writeByte(unique_key);
  nfile.write(key_definition, 0 , 101);
  nfile.write(for_expression, 0, 101);
  nfile.write(resrvd5, 0 , 14);
  nfile.writeInt(unknown[0]);
  nfile.writeInt(unknown[1]);
  nfile.writeInt(unknown[2]);
  nfile.writeInt(unknown[3]);
  redo_numbers();
}

void redo_numbers()
{
   top_Node=Util.x86(top_Node);
   pagesused=Util.x86(pagesused);
   key_length=Util.x86(key_length);
   key_per_Node=Util.x86(key_per_Node);
   notused=Util.x86(notused);
   key_entry_size=Util.x86(key_entry_size);
   changes=Util.x86(changes);
   unknown[0]=Util.x86(unknown[0]);
   unknown[1]=Util.x86(unknown[1]);
   unknown[2]=Util.x86(unknown[2]);
   unknown[3]=Util.x86(unknown[3]);
}

}
