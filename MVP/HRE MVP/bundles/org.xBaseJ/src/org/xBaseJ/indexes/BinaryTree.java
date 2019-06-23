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



public class BinaryTree extends Object
{
private BinaryTree lesser;
private BinaryTree greater;
private BinaryTree above;
private NodeKey key;
private int where;

NodeKey getKey()
{
return key;
}

int getWhere()
{
return where;
}

private void setLesser(BinaryTree inTree)
{
lesser = inTree;
}

private void setGreater(BinaryTree inTree)
{
greater = inTree;
}

public BinaryTree(NodeKey inkey, int inWhere, BinaryTree top)
{
above = null;
lesser = null;
greater = null;
key = inkey;
where = inWhere;

if (top != null) {
  above = top.findPos(key);
  if (above.getKey().compareKey(inkey) > 0) above.setLesser(this);
  else above.setGreater(this);
 }


}

private BinaryTree findPos(NodeKey inkey)
{

if (key.compareKey(inkey) > 0)
   if (lesser == null) return this;
   else return(lesser.findPos(inkey));
else
   if (greater == null) return this;
return(greater.findPos(inkey));
}

public BinaryTree getLeast()
{
  if (lesser != null) {
     return (lesser.getLeast());
     }
  return this;
}

public BinaryTree getNext()
{
  if (greater == null)
       if (above == null) return null;
       else return above.goingUp(key);
  return greater.getLeast();
}

private BinaryTree goingUp(NodeKey inKey)
{
  if (key.compareKey(inKey) <= 0)
     if (above == null) return null;
     else return above.goingUp(key);
  return this;
}


}
