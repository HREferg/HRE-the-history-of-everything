package org.xBaseJ.fields;

import org.xBaseJ.xBaseJException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
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
* User: Dmitry Berezovsky (corvis)
* Date: 1/9/12
* Time: 12:25 AM
* 
* 20110119  Joe McVerry (jrm)   Added static field type and CurrencyField class.
*/
public class CurrencyField extends Field{

    
    public static final char type = 'Y';
    
    public  CurrencyField(String iName, ByteBuffer inBuffer) throws xBaseJException
    {
        super();
        setField(iName,8, inBuffer);
      }
       
    public  CurrencyField(String iName) throws xBaseJException
    {
        super();
        setField(iName,8, null);
      }
       
   

  public char getType() {
    return type;
  }

  public String get(){
    BigDecimal val = currencyFromByteArray(super.getBytes());
    return new String(val.toString());
  }

  public void put(BigDecimal value) throws xBaseJException {
    super.put(currencyToByteArray(value));
  }

  private final BigDecimal currencyFromByteArray(byte[] bytes) {
    long d =
      (long)(bytes[7])      << 56 | 
      /* long cast needed or shift done modulo 32 */
      (long)(bytes[6]&0xff) << 48 |
      (long)(bytes[5]&0xff) << 40 |
      (long)(bytes[4]&0xff) << 32 |
      (long)(bytes[3]&0xff) << 24 |
      (long)(bytes[2]&0xff) << 16 |
      (long)(bytes[1]&0xff) <<  8 |
      (long)(bytes[0]&0xff);
    return new BigDecimal(BigInteger.valueOf(d),4);
  }

  private final byte[] currencyToByteArray(BigDecimal currencyValue)
   {
     byte[] bytes = new byte[8];
     long v = currencyValue.multiply(new BigDecimal(10000L)).longValue();
      bytes[0] = (byte) v;
      bytes[1] = (byte)(v >> 8);
      bytes[2] = (byte)(v >> 16);
      bytes[3] = (byte)(v >> 24);
      bytes[4] = (byte)(v >> 32);
      bytes[5] = (byte)(v >> 40);
      bytes[6] = (byte)(v >> 48);
      bytes[7] = (byte)(v >> 56);
      return bytes;
   }

}