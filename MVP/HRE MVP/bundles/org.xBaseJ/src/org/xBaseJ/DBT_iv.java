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

import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class DBT_iv extends DBTFile
{

 static int LAST_IND = 0x8ffff;
 int blocks = 0;

public DBT_iv(DBF iDBF, boolean readOnly) throws IOException, xBaseJException
{
super(iDBF, readOnly, DBFTypes.DBASEIV_WITH_MEMO);
nextBlock = Util.x86(file.readInt());
file.skipBytes(16);
memoBlockSize = Util.x86(file.readInt());
}

public DBT_iv(DBF iDBF, String name, boolean destroy) throws IOException, xBaseJException
{
 super(iDBF, name, destroy, DBFTypes.DBASEIV_WITH_MEMO);
 nextBlock = 1;
 file.writeInt(Util.x86(nextBlock));
 for (int i = 0; i < 16; i++)
    file.writeByte(0);
 memoBlockSize = 512;
 file.writeInt(Util.x86(memoBlockSize));
}


public void setNextBlock() throws IOException
{

}


 public byte[] readBytes(byte[] input) throws IOException, xBaseJException
 {
 for (int i = 0; i < 10; i++)
 {
 if (input[i] == 0) input[i] = BYTESPACE;
 }
 String sPos = new String(input, 0, 10).trim();
 if (sPos.length()==0) return null;
 long lPos = Long.parseLong(sPos.trim());
 if (lPos == 0) return null;
 if (lPos * memoBlockSize>= file.length()) return null;

 file.seek(lPos * memoBlockSize);

  int orisize;


  orisize = 0;

  int lastind = Util.x86(file.readInt());

  if (lastind != LAST_IND)
    throw new xBaseJException("Unexpected encounter in read text file");

  int size = Util.x86(file.readInt());

  orisize = size - 8;


  byte work_buffer[] = new byte[orisize+1];
  file.read(work_buffer, 0, orisize);

  work_buffer[orisize] = (byte) '\0';

  return work_buffer;

}

public byte[] write(String value, int originalSize, boolean write, byte originalPos[]) throws IOException, xBaseJException
{

  int  pos, startPos;
  int nextavail=0, bytes_blocks_used, last_stop, next_stop, lastused = 0;
  int  length;
  boolean eof = false;
  boolean madebigger = false;

  if (value.length() == 0){
      byte breturn[] = {BYTESPACE, BYTESPACE, BYTESPACE, BYTESPACE, BYTESPACE, BYTESPACE, BYTESPACE, BYTESPACE, BYTESPACE, BYTESPACE};
      return breturn;
  }

  if ((originalSize == 0) && (value.length() > 0) )
    madebigger = true;
  else
  if (((value.length() / memoBlockSize) + 1) > ((originalSize / memoBlockSize) + 1) )
    madebigger = true;
  else
    madebigger = false;

  if (madebigger || write) {
    startPos = nextBlock;
    nextBlock += ((value.length()+2) / memoBlockSize) +1;
    lastused = 0;
  }
  else
 {
    String sPos;
    sPos = new String(originalPos, 0, 10);
    startPos = Integer.parseInt(sPos.trim());
    lastused = startPos;
  }				/* endif */

  length = value.length();

  length += 8;
  pos = (length / memoBlockSize) + 1;

  last_stop = next_stop = 0;
  while (true) {
     try {
     long longnextstop = next_stop;
     file.seek(longnextstop * memoBlockSize);
     nextavail = Util.x86(file.readInt());
     }
     catch (EOFException ioe)
      { eof = true;
        break;
      }

     if (nextavail == LAST_IND)
      throw new xBaseJException("Error while writing to memo file, unexpected encounter");

     bytes_blocks_used = Util.x86(file.readInt());

     if (pos <= bytes_blocks_used)
       {
		 long longnextstop = next_stop;
         file.seek( longnextstop * memoBlockSize);
         break;
        }
     last_stop = next_stop;
     next_stop = nextavail;
   }  /* endwhile */

  file.writeInt(Util.x86(LAST_IND));
  file.writeInt(Util.x86(length));

  length -= 8;
  byte buffer[];
  try {buffer = value.getBytes(DBF.encodedType);}
  catch (UnsupportedEncodingException UEE){ buffer = value.getBytes();}

  file.write(buffer, 0, length);

  if (eof || lastused == 0)
      nextavail += pos;

  if (eof) {
	 long longnextavail =  nextavail ;
     file.seek(longnextavail *  memoBlockSize - 1);
     file.write(0);
     }
  if (lastused == 0) { // writting a record don't update old record
     long longlaststop = last_stop;
     file.seek(longlaststop * memoBlockSize);
     file.writeInt(Util.x86(nextavail));
  } else {
	 long longlastused = lastused;
     file.seek(longlastused * memoBlockSize);
     file.writeInt(Util.x86(nextavail));
     bytes_blocks_used = Util.x86(file.readInt());
     file.seek(lastused * memoBlockSize + 4);
     bytes_blocks_used /= memoBlockSize;
     bytes_blocks_used++;
     file.writeInt(Util.x86(bytes_blocks_used));
     long longlaststop = last_stop;
     file.seek(longlaststop * memoBlockSize);
     file.writeInt(Util.x86(lastused));
  } /* endif */

  String returnString = new String(Long.toString(next_stop));

 byte ten[] = new byte[10];

 for (pos = 0; pos < (10 - returnString.length()); pos++)
   ten[pos] = BYTEZERO;

 byte b[];
 b = returnString.getBytes();
 for (int x = 0; x < b.length; x++, pos++)
   ten[pos] = b[x];


 return ten;
}





}

