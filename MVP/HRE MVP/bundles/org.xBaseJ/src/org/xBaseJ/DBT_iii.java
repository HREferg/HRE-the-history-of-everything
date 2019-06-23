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

import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class DBT_iii extends DBTFile
{

public DBT_iii(DBF iDBF, boolean readOnly) throws IOException, xBaseJException
{
super(iDBF, readOnly, DBFTypes.DBASEIII_WITH_MEMO);
}

public DBT_iii(DBF iDBF, String name, boolean destroy) throws IOException, xBaseJException
{
 super(iDBF, name, destroy, DBFTypes.DBASEIII_WITH_MEMO);
}

public void setNextBlock() throws IOException
{

    if (file.length() == 0){

       file.writeInt(Util.x86(1));
       nextBlock = 1;
       file.seek(511);
       file.writeByte(0);
      }
    else{
       nextBlock = Util.x86(file.readInt());
       }

 }


public byte[] readBytes(byte[] input) throws IOException, xBaseJException
{

 byte[] bTemp = new byte[513];
 boolean work = true;
 boolean onefound = false;
 byte[] bTemp2 = null;
 byte[] bTemp3 = null;
 int workLength = 0;

 for (int i = 0; i < 10; i++)
   {
    if (input[i] >= BYTEZERO && input[i] <= '9')
      break;
   input[i] = BYTEZERO;
   }

 String sPos;
 sPos = new String(input, 0, 10);
 long lPos = Long.parseLong(sPos);
 if (lPos == 0) return null;
 file.seek(lPos * memoBlockSize);
 int i;

 do
   {
      file.read(bTemp, 0, memoBlockSize);
      for (i = 0; i < memoBlockSize; i++)
           {
             if  (bTemp[i] == 0x1a)
              {
                if (onefound == true) {
                 work = false;
                 bTemp[i] = 0;
                 i--;
                 break;
                }
                work = false;
                onefound = true;
                break;
              }
             else if  (bTemp[i] == 0x00)
              {
                if (onefound == true) {
                 work = false;
                 break;
                }
                onefound = false;
              }
              else onefound = false;
           }
	   if (workLength > 0)
	     {
		  bTemp3 = new byte[workLength];
		  System.arraycopy(bTemp2, 0, bTemp3, 0, workLength);
		 }
	   bTemp2 = new byte[workLength+i];
	   if (workLength > 0)
          System.arraycopy(bTemp3, 0, bTemp2, 0, workLength);
           System.arraycopy(bTemp, 0, bTemp2, workLength, i);
          workLength+=i;

      if (workLength> file.length())
    	  throw new xBaseJException("error reading dtb file, reading exceeds length of file");
    }
  while (work);
 return bTemp2;
}

public byte[] write(String value, int originalSize, boolean write, byte originalPos[]) throws IOException, xBaseJException
{
  boolean madebigger;
  long startPos;
  int pos;
  byte buffer[] = new byte[512];

 if (value.length() == 0){
      byte breturn[] = {BYTEZERO, BYTEZERO, BYTEZERO, BYTEZERO, BYTEZERO, BYTEZERO, BYTEZERO, BYTEZERO, BYTEZERO, BYTEZERO};
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
  }
  else
  {
   String sPos;
   sPos = new String(originalPos, 0, 10);
   startPos = Long.parseLong(sPos);
  }				/* endif */


  file.seek(startPos * memoBlockSize);

  for (pos = 0;
       pos < value.length();
       pos+= memoBlockSize)
  {
     byte b[];
     if ((pos+memoBlockSize) > value.length())
	   {
		 try { b = value.substring(pos, value.length()).getBytes(DBF.encodedType); }
         catch (UnsupportedEncodingException UEE){ b = value.substring(pos, value.length()).getBytes();}
	   }
     else
	   {
            try { b = value.substring(pos, (pos+memoBlockSize)).getBytes(DBF.encodedType); }
            catch (UnsupportedEncodingException UEE){ b = value.substring(pos, (pos+memoBlockSize)).getBytes();}
	   }

     for (int x=0; x < b.length; x++)
       buffer[x] = b[x];

     file.write(buffer, 0, 512);
  }				/* endfor */

  file.seek((startPos * memoBlockSize)+value.length());
  file.writeByte(26);
  file.writeByte(26);

if (madebigger || write)
 {
   file.seek((memoBlockSize * nextBlock)  - 1);
   file.writeByte(26);
   file.seek(0);
   file.writeInt(Util.x86(nextBlock));
 }

 String returnString = new String(Long.toString(startPos));

 byte ten[] = new byte[10];
 byte newTen[] = new byte[10];
 newTen = returnString.getBytes();

 for (pos = 0; pos < (10 - returnString.length()); pos++)
   ten[pos] = BYTEZERO;

 for (int x=0; pos<10; pos++,x++)
   ten[pos] = newTen[x];

 return ten;
}

}


