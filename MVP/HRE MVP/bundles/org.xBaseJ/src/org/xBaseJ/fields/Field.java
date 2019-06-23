package org.xBaseJ.fields;
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
 **  Change History
 *  Date      Developer                 Desc
 *  20120119  Joe McVerry   Added Currency Field
 *                                       Improved encoding logic for put(String) method
 *
 
*/


import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import org.xBaseJ.DBF;
import org.xBaseJ.Util;
import org.xBaseJ.xBaseJException;



public abstract class Field extends Object implements Cloneable,
Externalizable{

public String Name;
public int Length = 0;

public byte[] buffer;
public boolean Deleted;
public ByteBuffer bytebuffer;

public long myoffset;
public boolean isCharField() {return getType() == 'C';}
public boolean isDateField() {return getType() == 'D';}
public boolean isFloatField() {return getType() == 'F';}
public boolean isMemoField() {return getType() == 'M';}
public boolean isLogicalField() {return getType() == 'L';}
public boolean isNumField() {return getType() == 'N';}
public boolean isPictureField() {return getType() == 'P';}
public boolean isCurrencyFIeld() {return getType() == 'Y';}

    /** used by externalize methods
     * @param in ObjectInput stream
     * @throws IOException - most likely class changed since written
     * @throws ClassNotFoundException - only when dummy constructro not found
     */

    public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
    {
        Name = in.readUTF();
        Length = in.readInt();
        in.readFully(buffer);
        Deleted = in.readBoolean();
    }

    /** used by externalize methods
     * @param out ObjectOutput stream
     * @throws IOException Java.io error
     */

    public void writeExternal(ObjectOutput out)
    throws IOException
    {
        out.writeUTF(Name);
        out.writeInt(Length);
        out.write(buffer);
        out.writeBoolean(Deleted);
    }


public Object clone() throws  CloneNotSupportedException
{
  Field tField = (Field) super.clone();
  tField.Name = new String(Name);
  tField.Length = Length;
//  tField.buffer = buffer;
//  tField.bytebuffer = bytebuffer;
  return tField;
}

public static String otherValidCharacters = null;


private void validateName(String iName) throws xBaseJException
{

if (otherValidCharacters == null)
{
    try {
        otherValidCharacters = Util.getxBaseJProperty("otherValidCharactersInFieldNames");
    } catch (IOException e) {
        otherValidCharacters = "";
    }
    if (otherValidCharacters == null)
        otherValidCharacters = "";
}
if (iName == null) throw new xBaseJException("Missing field name");
if (iName.length() == 0) throw new xBaseJException("Missing field name");
if (iName.length() > 10) throw new xBaseJException("Invalid field name " + iName);

for (int i = 0; i < iName.length(); i++)
  {
   if (Character.isLetter(iName.charAt(i))) continue;
   if (Character.isDigit(iName.charAt(i))) continue;
   if (iName.charAt(i) == '_') continue;
   if (otherValidCharacters.indexOf(iName.charAt(i)) > -1) continue;

   throw new xBaseJException("Invalid field name " + iName + ", character invalid at " + i );
}

}

/**
 * creates a Field object.
 * not useful for the abstract Field class
 * @see CharField
 * @see DateField
 * @see LogicalField
 * @see MemoField
 * @see NumField
*/
public Field()
{
int tlength;

if (Length == 0)
  tlength = 1;
  else tlength = Length;

buffer = new byte[tlength];
buffer[0] = (byte) ' ';
}



public void setField(String iName, int iLength, ByteBuffer inbuffer) throws xBaseJException
  {

  Name = iName.trim();
  validateName(Name);
  Length = iLength;
  setBuffer(inbuffer);
//  buffer =  new byte[Length];

  }

public void setBuffer(ByteBuffer inBuffer)
{
  bytebuffer = inBuffer;
  setBufferSpace();
}

public void setBufferSpace()
{
	buffer =  new byte[Length];
}


/**
 * @return String contianing the field name
*/

public String getName()
  {
  return Name;
  }


/**
 * @return int - the field length
*/

public int getLength()
{
  return Length;
}

/**
 * @return char field type
*/
public abstract char getType();

/**
 * @return int - the number of decimal positions for numeric fields, zero returned otherwise
*/
public int getDecimalPositionCount()
{
  return 0;
}

public void read()
     throws IOException, xBaseJException
  {
    bytebuffer.get(buffer);
  }

/**
 * @return String field contents after any type of read.
 */
public String get()
  {
    int k;
    for (k=0; k < Length && buffer[k] != 0; k++) ;
    if (k == 0) // no data
		  return "";
	//if (k < Length) // found a trailing binary zero
	//  k--;

    String s;
    try {s = new String(buffer, 0, k,DBF.encodedType); }
    catch (UnsupportedEncodingException UEE){s = new String(buffer, 0, k); }
    return s;
  }

/**
 * returns the original byte array as stored in the file.
 * @return byte[] - may return a null if not set
*/
public byte[] getBytes()
  {
    return buffer;
  }

public void write()
     throws IOException, xBaseJException
  {
    bytebuffer.put(buffer);
  }

public void update()
     throws IOException, xBaseJException
  {
    bytebuffer.put(buffer);
  }

/**
 * set field contents, no database updates until a DBF update or write is issued
 * @param inValue value to set
 * @throws  xBaseJException
 *                     value length too long
 */

    public void put(String inValue) throws xBaseJException {
	byte b[];
	int i;
	try {
	    b = inValue.getBytes(DBF.encodedType);
	} catch (UnsupportedEncodingException UEE) {
	    b = inValue.getBytes();
	}

	if (b.length > Length)
	    throw new xBaseJException("Field length too long");

	i = Math.min(b.length, Length);

	for (i = 0; i < b.length; i++)
	    buffer[i] = b[i];

	byte fill;
	if (Util.fieldFilledWithSpaces())
	    fill = (byte) ' ';
	else
	    fill = 0;

	for (i = b.length; i < Length; i++)
	    buffer[i] = fill;

    }

/**
 * set field contents with binary data, no database updates until a DBF update or write is issued
 * if inValue is too short buffer is filled with binary zeros.
 * @param inValue byte array
 * @throws  xBaseJException
 *                     value length too long
 */

public void put(byte inValue[]) throws xBaseJException
  {
    int i;

    if (inValue.length > Length)
      throw new xBaseJException("Field length too long");

    for (i = 0; i < inValue.length; i++)
       buffer[i] = inValue[i];

    for (; i < Length; i++)
    	if (Util.fieldFilledWithSpaces())
    		buffer[i] = ' ';
    	else
    		buffer[i] = 0;

  }


 public String toString() {
	 return this.Name+"; "+this.getType()+"; "+this.getLength()+"; "+this.getDecimalPositionCount();
 }
}
