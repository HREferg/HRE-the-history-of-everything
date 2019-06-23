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
 *  20110119  Joe McVerry (jrm)   Added static field type and CurrencyField class. 
*/

import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import org.xBaseJ.xBaseJException;


public class NumField extends Field{

/**
	 *
	 */
private static final long serialVersionUID = 1L;
private byte decPosition = 0;
static DecimalFormatSymbols dfs = new DecimalFormatSymbols();
static char decimalSeparator = dfs.getDecimalSeparator();
public static final char type = 'N';

public NumField() {super();}

public Object clone() throws  CloneNotSupportedException
{
  NumField tField = (NumField) super.clone();
  tField.Name = new String(Name);
  tField.Length = Length;
  tField.decPosition = decPosition;
  return tField;
}

public  NumField(String iName, int iLength, int idecPosition, ByteBuffer inBuffer)
throws xBaseJException
  {
  super();
  super.setField(iName, iLength, inBuffer);
  decPosition = (byte) idecPosition;
  put("");

  }

/**
 * public method for creating a numeric field object.  It is not associated with a database
 * but can be when used with some DBF methods.
 * @param iName the name of the field
 * @param iLength the length of Field. range is 1 to 19 bytes
 * @param inDecPosition the number of decimal positions range from 2 to 17 bytes. Relative to Length.
 * @throws xBaseJException
 *                     bad name, length or decimal positions specified
 * @throws IOException
 *                     can not occur but defined for calling methods
 * @see Field
 *
*/

public NumField(String iName, int iLength, int inDecPosition) throws xBaseJException, IOException
  {
  super();
  super.setField(iName, iLength, null);
  decPosition = (byte) inDecPosition;
  }


/**
 * return the character 'N' indicating a numeric field
*/
public char getType()
{
return type;
}

/**
 * @return int - the number of decimal positions
*/
public int getDecimalPositionCount()
{
    return (int) decPosition;
}


/**
 * public method for getting field value
 * @return String of field value
 *
*/

public String get()
{
int i;
char c;
String value = super.get();

if (value.trim().length() ==0) return "";

for (i=0; i<value.length(); i++)
  {
    c = value.charAt(i);
    if ( c != ' ')
       return value;
  }

StringBuffer format = new StringBuffer();

int decoffset = Length - decPosition - 1;
for (i = 0; i < (decoffset-1);  i++)
  format.append(' ');

if (decoffset > 0)
  format.append('0');

if (decPosition > 0)  {
  format.append(decimalSeparator);
  for (i=0; i<decPosition; i++)  format.append('0');
  }

return format.toString();
}

/**
 * sets the field contents.
 * @throws xBaseJException
 *                    most likely a format exception
 * @param inValue String
*/
public void put(String inValue) throws xBaseJException
  {


  try {  Double.valueOf(inValue); }
  catch  (NumberFormatException nfe) {super.put(""); return; }



  int worklen;

  if (Length > inValue.length()) worklen = Length;
  else worklen = inValue.length();

  char charArray[] = new char[Length];

  int i1, i2, i3, i4;

  for (i1=0; i1 < Length; i1++)  charArray[i1] = ' ';


  for (i1=0; i1<inValue.length(); i1++)
     {
      if (inValue.charAt(i1) == '-') break;
      if (inValue.charAt(i1) == decimalSeparator) break;
      if (inValue.charAt(i1) < '0') continue;
      if (inValue.charAt(i1) > '9') continue;
      break;
	 }

   boolean neg = false;

   if (inValue.charAt(i1) == '-') {
      neg = true;
      i1++;
    }

   char intForm[] = new char[worklen];
   int breaklen = decPosition == 0 ? worklen : worklen - 1; // if there is a decimal then leave room for it

   for (i2=0; i2<breaklen; i2++)
     {
      if (i1 >= inValue.length()) break;
      if (inValue.charAt(i1) < '0') break;
      if (inValue.charAt(i1) > '9') break;
      intForm[i2] = inValue.charAt(i1);
      i1++;
	 }

    if ( (i1 < inValue.length())  &&  (inValue.charAt(i1) == decimalSeparator) ) 
    	i1++;


    char decForm[] = new char[worklen];
    for (i3=0; i3 <breaklen; i3++)   decForm[i3] = '0';


    for (i3=0; i3 <breaklen; i3++)
	 {
       if (i1 >= inValue.length()) break;
       if (inValue.charAt(i1) < '0') break;
       if (inValue.charAt(i1) > '9') break;
       decForm[i3] = inValue.charAt(i1);
       i1++;
     }

    int startpos = Length-decPosition-1;

    if (decPosition > 0)
	 {
      charArray[startpos] = decimalSeparator;
      startpos--;
     }

    for (i4=startpos; i4>-1; i4--)
	   {
        i2--;
        if (i2 < 0) break;
        charArray[i4] = intForm[i2];
	   }


    if (neg)
	  {
      if (i4<0) charArray[0] = '-';
      else charArray[i4] = '-';
	  }



    if ( decPosition > 0 )
	  {
        startpos += 2;
        for (i4=1; i4<=decPosition; i4++)
		  {
            charArray[startpos] = decForm[i4-1];
	        startpos++;
		  }
      }


    
  super.put(new String(charArray).replace(decimalSeparator, '.'));

  }

/**
 * sets the field contents.
 * @param inValue long
 * @throws xBaseJException
 *                    most likely a format exception
*/
public void put(long inValue) throws xBaseJException
  {
   put (String.valueOf(inValue));
  }


/**
 * sets the field contents.
 * @param inValue int
 * @throws xBaseJException
 *                    most likely a format exception
*/
public void put(int inValue) throws xBaseJException
  {
   put (String.valueOf(inValue));
  }


/**
 * sets the field contents.
 * @param inValue float
 * @throws xBaseJException
 *                    most likely a format exception
*/
public void put(float inValue) throws xBaseJException
  {

	double toDouble = inValue;
	put(toDouble);
  }


/**
 * sets the field contents.
 * @param inValue double
 * @throws xBaseJException
 *                    most likely a format exception
*/
public void put(double inValue) throws xBaseJException
  {
    StringBuffer sb = new StringBuffer(getLength()+1);
    sb.append("#");
    for (int i = 0; i < getLength(); i++)
        sb.append("#");

    if (decPosition > 0)
    {
        int pos = getLength()-getDecimalPositionCount();
        sb.setCharAt(pos,decimalSeparator);

        for (pos++; pos < getLength()+1; pos++)
            sb.setCharAt(pos,'0');
    }

    DecimalFormat df = new DecimalFormat(sb.toString());
    String s = df.format(inValue).trim();
    put(s);
  }


}
