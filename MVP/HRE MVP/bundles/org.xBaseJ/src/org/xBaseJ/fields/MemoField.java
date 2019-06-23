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
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import org.xBaseJ.DBF;
import org.xBaseJ.DBTFile;
import org.xBaseJ.xBaseJException;

public class MemoField extends Field {

    /** 20110614 jrm - update read method 
	 *
	 */
    private static final long serialVersionUID = 1L;
    boolean foxPro = false;
    public static final char type = 'M';
    
    public MemoField() {
	super();
    }

    public MemoField(boolean inFoxPro) {
	super();
	foxPro = inFoxPro;
    }

    private DBTFile dbtobj;
    private int originalSize;
    private String value;
    private byte[] byteValue;

    public boolean isFoxPro() {
	return foxPro;
    }

    public void setDBTObj(DBTFile indbtobj) {
	dbtobj = indbtobj;

    }

    public Object clone() throws CloneNotSupportedException {
	try {
	    MemoField tField = new MemoField(Name, null, null);
	    return tField;
	} catch (xBaseJException e) {
	    return null;
	} catch (IOException e) {
	    return null;
	}
    }

    public MemoField(String Name, ByteBuffer inBuffer, DBTFile indbtobj)
	    throws xBaseJException, IOException {
	super();
	super.setField(Name, 10, inBuffer);
	dbtobj = indbtobj;
	value = new String("");
    }

    /**
     * public method for creating a memo field object. It is not associated with
     * a database but can be when used with some DBF methods.
     * 
     * @param iName
     *            the name of the field
     * @throws xBaseJException
     *             exception caused in calling methods
     * @throws IOException
     *             can not occur but defined for calling methods
     * @see Field
     * 
     */

    public MemoField(String iName) throws xBaseJException, IOException {
	super();
	super.setField(iName, 10, null);
	dbtobj = null;
	originalSize = 0;
	buffer = new byte[10];
	for (int i = 0; i < 10; i++)
	    buffer[i] = DBTFile.BYTEZERO;
	value = new String("");
    }

    /**
     * public method for creating a FoxPro memo field object. It is not
     * associated with a database but can be when used with some DBF methods.
     * 
     * @param iName
     *            the name of the field
     * @param inFoxPro
     *            - boolean
     * @exception xBaseJException
     *                exception caused in calling methods
     * @exception IOException
     *                can not occur but defined for calling methods
     * @see Field
     * 
     */

    public MemoField(String iName, boolean inFoxPro) throws xBaseJException,
	    IOException {
	super();
	super.setField(iName, 10, null);
	foxPro = inFoxPro;
	dbtobj = null;
	originalSize = 0;
	buffer = new byte[10];
	for (int i = 0; i < 10; i++)
	    buffer[i] = DBTFile.BYTEZERO;
	value = new String("");
    }

    /**
     * return the character 'M' indicating a memo field
     */
    public char getType() {
	return type;
    }

    /**
     * return the contents of the memo Field, variant of the field.get method
     */
    public String get() {
	String s = "";
	if (byteValue == null)
	    return "";
	try {
	    s = new String(byteValue, DBF.encodedType);
	} catch (UnsupportedEncodingException UEE) {
	    s = new String(byteValue);
	}
	int k;
	if (byteValue.length < 2)
	    return s;
	for (k = byteValue.length; k > -1 && byteValue[k - 1] == 0; k--)
	    ;
	return s.substring(0, k);
    }

    /**
     * return the contents of the memo Field via its original byte array
     * 
     * @return byte[] - if not set a null is returned.
     */
    public byte[] getBytes() {
	return byteValue;
    }

    public void read() throws IOException, xBaseJException {
	super.read();

	byteValue = dbtobj.readBytes(super.buffer);
	    value = "";
	    originalSize = 0;

	if (byteValue != null) {
	    value = new String(byteValue);
	    originalSize = value.length();
	}
    }

    /**
     * sets the contents of the memo Field, variant of the field.put method data
     * not written into DBF until an update or write is issued.
     * 
     * @param invalue
     *            value to set Field to.
     */
    public void put(String invalue) {
	value = new String(invalue);
	byteValue = value.getBytes();
    }

    /**
     * sets the contents of the memo Field, variant of the field.put method data
     * not written into DBF until an update or write is issued.
     * 
     * @param inBytes
     *            byte array value to set Field to.
     */
    public void put(byte inBytes[]) throws xBaseJException {
	byteValue = inBytes;
    }

    public void write() throws IOException, xBaseJException {
	super.buffer = dbtobj.write(value, originalSize, true, super.buffer);
	super.write();
    }

    public void update() throws IOException, xBaseJException {
	super.buffer = dbtobj.write(value, originalSize, false, super.buffer);
	super.write();
    }

	/**
	 * @return
	 */
	public int getOriginalSize() {
		// Added by Michael Erichsen
		return originalSize;
	}

}
