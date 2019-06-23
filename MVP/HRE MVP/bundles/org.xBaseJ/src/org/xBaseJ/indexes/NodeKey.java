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


public class NodeKey
{
  char type = ' ';
  Object key;

  public NodeKey(Object keyIn)
   {

     if (keyIn instanceof String) type = 'C';
     else if (keyIn instanceof Double) type = 'N';
     else if (keyIn instanceof  NodeFloat) type = 'F';

     key = keyIn;

   }

  public char getType()
  {
    return type;
  }


  public String rebuildString(String inString)
  {
	  char a[] = new char[inString.length()];
	  for (int i = 0; i < inString.length(); i++)
	    {
			if (inString.charAt(i) == '_')
			  a[i] = 31;
			else
			  a[i] = inString.charAt(i);
		}

     return new String(a);
  }



  public int compareKey(NodeKey keyCompareTo) // throws new xBaseJException
  {
     int ret = 0;
     if (type != keyCompareTo.getType())
        return -1; // throw new xBaseJException("Node key types do not match");
     if (type == 'C')
        {String s = (String) key;
         s = rebuildString(s);
         String t = keyCompareTo.toString();
         t = rebuildString(t);
         return s.compareTo(t);
        }
     if (type == 'F')
        {NodeFloat nf = (NodeFloat) key;
         NodeFloat nft = (NodeFloat) keyCompareTo.key;
         return nf.compareTo(nft);
        }
     Double d = (Double) key;

     double d2 = d.doubleValue() - keyCompareTo.toDouble();
     if (d2 < 0.0) return -1;
     if (d2 > 0.0) return 1;
     return ret;
  }

  public int length()
  {
     if (type == 'C') return ((String) key).length();
     if (type == 'F') return 12;
     return 8;
  }


  public String toString()
  {
     return key.toString();
  }

  public double toDouble()
  {
     if (type == 'N')
       {
         Double d = (Double) key;
         return d.doubleValue();
       }
     return 0.0;
  }

  public NodeFloat toNodeFloat()
  {
     if (type == 'F')
       {
         NodeFloat f = (NodeFloat) key;
         return f;
       }
     return null;
  }



}
