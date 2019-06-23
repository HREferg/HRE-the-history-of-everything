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
 *
 * 20140320  jrm new method getCalendar(Timezone ...)  
*/

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.xBaseJ.DBF;
import org.xBaseJ.Util;
import org.xBaseJ.xBaseJException;


public class DateField extends Field{

/**
	 *
	 */
	private static final long serialVersionUID = 1L;
 
public static final char type = 'D';


public Object clone() throws  CloneNotSupportedException
{
  DateField tField = (DateField) super.clone();
  tField.Name = Name;
  tField.Length = 8;
  return tField;
}

public  DateField(String iName, ByteBuffer inBuffer) throws xBaseJException
  {
  super();
  super.setField(iName,  8, inBuffer);
  }

/**
 * public method for creating a DateField object.  It is not associated with a database
 * but can be when used with some DBF methods.
 * @param iName the name of the field
 * @throws xBaseJException
 *                     exception caused in calling methods
 * @throws IOException
 *                     can not occur but defined for calling methods
 * @see Field
 *
*/

public DateField(String iName) throws IOException, xBaseJException
  {
  super();
  super.setField(iName,  8, null);
  put("");
  }

private DateField() throws xBaseJException
  {
  Length = 8;
  buffer = new byte[Length];
  put("");
  }


/**
 * return the character 'D' indicating a date field
*/
public char getType()
{
return type;
}

/**
 * sets field contents by a String parameter.
 * @param inValue String value to store - format CCYYMMDD
 * @throws xBaseJException
 *                    most likely a format error
*/
public void put(String inValue) throws xBaseJException
{

  int i;
  if (!Util.dontTrimFields())
	  inValue = inValue.trim();

  boolean allspaces = true;

  for (i = 0; i<inValue.length(); i++)
     {
        if (inValue.charAt(i) != ' ')
        allspaces=false;
      }

  byte blankbyte = (byte) ' ';
  if (inValue.length() == 0 || allspaces == true) {
      for (i = 0; i<8; i++) { buffer[i] = blankbyte; }
      return;
     }

  if (inValue.length() != 8)
     throw new xBaseJException("Invalid length for date Field");

  for (i = 0; i<8; i++) {
  if (Character.isDigit(inValue.charAt(i)) == false)          {
          throw new xBaseJException("Invalid format for date Field, " + inValue + " non numeric at position " + i);
          }
    }


  int yea= Integer.parseInt(inValue.substring(0, 4));
  int mo = Integer.parseInt(inValue.substring(4, 6));
  if (mo < 1 || mo > 12)
          throw new xBaseJException("Invalid format for date Field (month) " + inValue ) ;
  int da = Integer.parseInt(inValue.substring(6, 8));
  if (da < 1)
          throw new xBaseJException("Invalid format for date Field (day) " + inValue);

  int month[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
  if ( yea == 2000 ||
       ( ( (yea % 4) == 0) && ( (yea % 100) != 0) )
     )
       month[2]++;
  if (da > month[mo])
          throw new xBaseJException("Invalid format for date Field, number of days > days in month");

  super.put(inValue);

}

/**
 * sets field contents by a Java Date object.
 * @param inValue java.util.Date value to store
 * @throws xBaseJException
 *                    most likely a format error
*/
public void put(Date inValue) throws xBaseJException
{

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    super.put(sdf.format(inValue));


}

/**
 * sets field contents by a Java Calendar object.
 * @param inValue java.util.Calendare value to store
 * @throws xBaseJException
 *                    most likely a format error
*/
public void put(Calendar inValue) throws xBaseJException
{

   put(inValue.getTime());
}

/**
 * sets field contents by a long value
 * @param inValue long value to store - format CCYYMMDD
 * @throws xBaseJException
 *                    most likely a format error
*/
public void put(long inValue)  throws xBaseJException
{
     put(Long.toString(inValue));
}

/**
 * public method for comparing a DateField object.
 * @param compareThis the other DateField object to compare
 * @return negative if compareThis is larger, zero if equal, positive if smaller
 *
*/

public int compareTo(DateField compareThis)

{
   return get().compareTo(compareThis.get());
}

/**
 * public method for comparing a Java Calendar object.
 * @param compareThis the Date object to compare
 * @throws xBaseJException
 *                     exception caused in calling methods
 * @return negative if compareThis is larger, zero if equal, positive if smaller
 *
*/

public int compareTo(Calendar compareThis) throws xBaseJException
{
   DateField compareDateField= new DateField();
   compareDateField.put(compareThis);
   return compareTo(compareDateField);
}

/**
 * public method for returing the date field in a Java Calendar object.
 * @throws xBaseJException
 *                     exception caused in calling methods
 * @return a Calendaar object
 *
*/

public Calendar getCalendar() throws xBaseJException
{
Calendar getter = Calendar.getInstance();
getter.set(Calendar.HOUR_OF_DAY, 0);
getter.set(Calendar.MINUTE, 0);
getter.set(Calendar.SECOND,0);
getter.set(Calendar.MILLISECOND , 0);
getter.set(Calendar.YEAR, Integer.parseInt(get(Calendar.YEAR)));
getter.set(Calendar.MONTH, Integer.parseInt(get(Calendar.MONTH))-1);
getter.set(Calendar.DAY_OF_MONTH, Integer.parseInt(get(Calendar.DAY_OF_MONTH)));
return getter;
}


public Calendar getCalendar(java.util.TimeZone timeZone) throws xBaseJException
{
Calendar result = Calendar.getInstance(timeZone);
result.set(Calendar.HOUR_OF_DAY, 0);
result.set(Calendar.MINUTE, 0);
result.set(Calendar.SECOND,0);
result.set(Calendar.MILLISECOND , 0);
result.set(Calendar.YEAR, Integer.parseInt(get(Calendar.YEAR)));
result.set(Calendar.MONTH, Integer.parseInt(get(Calendar.MONTH))-1);
result.set(Calendar.DAY_OF_MONTH, Integer.parseInt(get(Calendar.DAY_OF_MONTH)));
return result;

}
/**
 * public method for getting individual field values
 * @param field id, use Calendar.YEAR, Calendar.MONTh, Calendar.DAY_OF_MONTH
 * @throws xBaseJException
 *                     exception caused in calling methods
 * @return String of fields value
 *
*/

public String get(int field) throws xBaseJException
{

switch (field)
 {
   case Calendar.YEAR:
        return new String(buffer, 0, 4);
   case Calendar.MONTH:
        return new String(buffer, 4, 2);
   case Calendar.DAY_OF_MONTH:
        return new String(buffer, 6, 2);
   default:
        throw new xBaseJException("Field type invalid");
  }
}

/**
 * public method for setting individual field values
 * @param field use Calendar.YEAR, Calendar.MONTh, Calendar.DAY_OF_MONTH
 * @param value - int value to set field
 * @throws xBaseJException
 *                     exception caused in calling methods
 * @return String of fields value
 *
*/
public void set(int field, int value) throws xBaseJException
{
NumberFormat numFormat;
numFormat = NumberFormat.getNumberInstance();
String setter;
byte byter[];

switch (field)
 {
   case Calendar.YEAR:
        numFormat.setMinimumIntegerDigits(4);
        numFormat.setMaximumIntegerDigits(4);
        setter = numFormat.format(value);
        try {byter = setter.getBytes(DBF.encodedType);}
        catch (UnsupportedEncodingException UEE){ byter = setter.getBytes();}
        buffer[0] = byter[0];
        buffer[1] = byter[1];
        buffer[2] = byter[2];
        buffer[3] = byter[3];
       break;
   case Calendar.MONTH:
        if (value < 1 || value > 12)
           throw new xBaseJException("Month value out of range");
        numFormat.setMinimumIntegerDigits(2);
        numFormat.setMaximumIntegerDigits(2);
        setter = numFormat.format(value);
        byter = setter.getBytes();
        buffer[4]= byter[0];
        buffer[5]= byter[1];
       break;
   case Calendar.DAY_OF_MONTH:
        if (value < 1 || value > 31)
           throw new xBaseJException("Day value out of range");
        numFormat.setMinimumIntegerDigits(2);
        numFormat.setMaximumIntegerDigits(2);
        setter = numFormat.format(value);
        byter = setter.getBytes();
        buffer[6]= byter[0];
        buffer[7]= byter[1];
       break;
   default:
        throw new xBaseJException("Field type invalid");
  }
}

}
