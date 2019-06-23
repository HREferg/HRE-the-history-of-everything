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
 *20110119  Joe McVerry (jrm)   Added static field type and CurrencyField class.
*/

import java.io.CharArrayWriter;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xBaseJ.fields.CharField;
import org.xBaseJ.fields.CurrencyField;
import org.xBaseJ.fields.DateField;
import org.xBaseJ.fields.Field;
import org.xBaseJ.fields.FloatField;
import org.xBaseJ.fields.LogicalField;
import org.xBaseJ.fields.MemoField;
import org.xBaseJ.fields.NumField;
import org.xBaseJ.fields.PictureField;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


public class XBASEXMLParser extends DefaultHandler {

	/** accepts on String parameter, filename to parse
	 */

	public static void main(String args[]) {
		new XBASEXMLParser().parse(args[0]);
	}
	//public org.xml.sax.Parser parser;
	/** SAX parser
	 */
	public SAXParserFactory parserFactory;
	public SAXParser parser;
	// Buffer for collecting data from
	// the "characters" SAX event.
	private CharArrayWriter contents = new CharArrayWriter();

	private int iLine = 0;
	private int iElement = 0;
	boolean recordProcessing = false;
	private DBF dbf;
	private String outputDBFname = null;
	private Field fld;
	private String fldName;
	private char fldType;

	/**
	 * constructor, sets up SAX parser,
	 * turns off validation, turns on namespaces,
	 * sets up content handler and error handler as this object.
	 * sax exceptions go to System.err
	 */
	public XBASEXMLParser() {
		try {
		        parserFactory = SAXParserFactory.newInstance(); 
			parserFactory.setFeature("http://xml.org/sax/features/namespaces", false);
			parserFactory.setFeature("http://xml.org/sax/features/validation", true);
			parser = parserFactory.newSAXParser();
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/** makes the SAX2 parser call
	 * @param inXMLFile String of filename to parse
	 */
	public void parse(String inXMLFile) {
		try {
			 parser.parse( new File(inXMLFile), this );

			
		} /* endtry */
		catch (Exception e1) {
			e1.printStackTrace();

		} /* endcatch */

	}

	/** makes the SAX2 parser call
	 * @param inXMLFile String of filename to parse
	 * @param outDBFName rename dbf file
	 */
	public void parse(String inXMLFile, String outDBFName) {
		try {
		       outputDBFname = outDBFName;
			 parser.parse( new File(inXMLFile), this );

			
		} /* endtry */
		catch (Exception e1) {
			e1.printStackTrace();

		} /* endcatch */

	}

	/** method called for each xml element found.
	 * <br> process logic
	 * <ul>
	 * <li> based on the name of the element found
	 * <li> for each pull appropriate attributes and construct object
	 * <li> if owned by another class, and all are except for Standard, add it to its parents object
	 * </ul>
	 * @param uri URI of incoming file
	 * @param localName String of element's local name
	 * @param rawName String of element's raw name
	 * @param attributes Vector of the elements attributes
	 * @throws SAXException many possible exceptions
	 */
	public void startElement(
		java.lang.String uri,
		java.lang.String localName,
		java.lang.String rawName,
		Attributes attributes)
		throws SAXException {



		iElement++;

		contents.reset();

		try {

			if (rawName.compareTo("dbf") == 0) {
				String dbfName;
				if (outputDBFname == null)
				     dbfName= attributes.getValue("name");
				else
				    dbfName = outputDBFname;
				String dbfEncoding = attributes.getValue("encoding");
				if (dbfEncoding.length() == 0)
					dbf = new DBF(dbfName, true);
				else
					dbf = new DBF(dbfName, true, dbfEncoding);
			} else if (rawName.compareTo("field") == 0) {
				fldName = attributes.getValue("name");
				int fl, dp;
				if (recordProcessing == false) {
					fldType = attributes.getValue("type").charAt(0);
					switch (fldType) {
						case 'C' :
							fl =
								Integer.parseInt(attributes.getValue("length"));
							dbf.addField(new CharField(fldName, fl));
							break;
						case 'D' :
							dbf.addField(new DateField(fldName));
							break;
						case 'F' :
							fl =
								Integer.parseInt(attributes.getValue("length"));
							dp =
								Integer.parseInt(
									attributes.getValue("decimalPos"));
							dbf.addField(new FloatField(fldName, fl, dp));
							break;
						case 'N' :
							fl =
								Integer.parseInt(attributes.getValue("length"));
							dp =
								Integer.parseInt(
									attributes.getValue("decimalPos"));
							dbf.addField(new NumField(fldName, fl, dp));
							break;
						case 'L' :
							dbf.addField(new LogicalField(fldName));
							break;
						case 'M' :
							dbf.addField(new MemoField(fldName));
							break;
						case 'P' :
							dbf.addField(new PictureField(fldName));
							break;
						case '$' :
							dbf.addField(new CurrencyField(fldName));
							break;

					}
				} else {
					fld = dbf.getField(fldName);
				}
			} else if (rawName.compareTo("record") == 0) {
				recordProcessing = true;
			} else
				System.err.println(
					"Logic error: Unknown element name \""
						+ rawName
						+ "\" found at element position "
						+ iElement
						+ " line: "
						+ iLine);
		} catch (xBaseJException xbe) {
			throw new SAXException("org.xBaseJ error: " + xbe.getMessage());
		} catch (IOException ioe) {
			throw new SAXException("java.IOExcpetion: " + ioe.getMessage());
		}
	}

	/** catches the element's value
	 * @param ch char array of the current element value contents
	 * @param start int start position within the array
	 * @param length int of characters found so far
	 * @throws SAXException many possible
	 */
	public void characters(char ch[], int start, int length)
		throws SAXException {
		contents.write(ch, start, length);
	}

	/** Method called by the SAX parser at the </
	 * @param uri URI of incoming file
	 * @param localName String of element's local name
	 * @param rawName String of element's raw name
	 * @throws SAXException many possible
	 */
	public void endElement(
		java.lang.String uri,
		java.lang.String localName,
		java.lang.String rawName)
		throws SAXException {

		String data = contents.toString();

		try {

			if (rawName.compareTo("dbf") == 0) {
				;
			} else if (rawName.compareTo("field") == 0) {
				if (recordProcessing == false);
				else
					fld.put(data);

			} else if (rawName.compareTo("record") == 0) {
				dbf.write();
			}
		} catch (xBaseJException xbe) {
			throw new SAXException("org.xBaseJ error: " + xbe.getMessage());
		} catch (IOException ioe) {
			throw new SAXException("java.IOExcpetion: " + ioe.getMessage());
		}
	}

	/** I use this to keep track of line #s
	 * @param ch char array of found whitespaces
	 * @param start int start position in array
	 * @param length int length of what's been found
	 */
	public void ignorableWhitespace(char[] ch, int start, int length) {
		for (int i = start; i < start + length; i++)
			if (ch[i] == '\n')
				iLine++;
	}

	/** catches warning SAXParseExceptions
	 * this code sends exception to stdio and allows public classto continue
	 * @param e SaxException object
	 * @throws SAXException exception
	 */
	public void warning(SAXParseException e) throws SAXException {
		System.err.println(
			"Warning at (file "
				+ e.getSystemId()
				+ ", line "
				+ e.getLineNumber()
				+ ", char "
				+ e.getColumnNumber()
				+ "): "
				+ e.getMessage());
	}

	/** catches error SAXParseExceptions
	 * this code causes exception to continue
	 * @param e SaxException object
	 * @throws SAXException thrown
	 */
	public void error(SAXParseException e) throws SAXException {
		throw new SAXException(
			"Error at (file "
				+ e.getSystemId()
				+ ", line "
				+ e.getLineNumber()
				+ ", char "
				+ e.getColumnNumber()
				+ "): "
				+ e.getMessage());
	}

	/** catches fatal SAXParseExceptions
	 * this code causes exception to continue
	 * @param e SAXException object
	 * @throws SAXException thrown
	 */
	public void fatalError(SAXParseException e) throws SAXException {
		throw new SAXException(
			"Fatal Error at (file "
				+ e.getSystemId()
				+ ", line "
				+ e.getLineNumber()
				+ ", char "
				+ e.getColumnNumber()
				+ "): "
				+ e.getMessage());
	}

}
