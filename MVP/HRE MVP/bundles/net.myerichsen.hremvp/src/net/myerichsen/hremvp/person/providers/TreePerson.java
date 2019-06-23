package net.myerichsen.hremvp.person.providers;

import java.util.ArrayList;
import java.util.List;

/**
 * A person displayed in a TreeViewer
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 13. feb. 2019
 *
 */
public class TreePerson {
	private List<TreePerson> descendantList;
	private List<TreePerson> ancestorList;
	private int personPid;
	private int childPid;
	private int parentPid;
	private String Name;

	/**
	 * Constructor for ancestor tree
	 *
	 * @param sPersonPid
	 * @param parentpid
	 * @param sChildPid
	 * @param name
	 */
	public TreePerson(String sPersonPid, int parentpid, String sChildPid,
			String name) {
		super();
		personPid = Integer.parseInt(sPersonPid);
		parentPid = 0;
		childPid = Integer.parseInt(sChildPid);
		Name = name;
		descendantList = new ArrayList<>();
		ancestorList = new ArrayList<>();
	}

	/**
	 * Constructor for descendant tree
	 *
	 * @param sPersonPid
	 * @param sParentpid
	 * @param childPid
	 * @param name
	 */
	public TreePerson(String sPersonPid, String sParentpid, int childPid,
			String name) {
		super();
		personPid = Integer.parseInt(sPersonPid);
		parentPid = Integer.parseInt(sParentpid);
		this.childPid = 0;
		Name = name;
		descendantList = new ArrayList<>();
		ancestorList = new ArrayList<>();
	}

	/**
	 * @param child
	 */
	public void addChild(TreePerson child) {
		descendantList.add(child);
	}

	/**
	 * @param parent
	 */
	public void addParent(TreePerson parent) {
		ancestorList.add(parent);
	}

	/**
	 * @return the ancestorList
	 */
	public List<TreePerson> getAncestorList() {
		return ancestorList;
	}

	/**
	 * @return the childPid
	 */
	public int getChildPid() {
		return childPid;
	}

	/**
	 * @return the descendantList
	 */
	public List<TreePerson> getDescendantList() {
		return descendantList;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @return the parentPid
	 */
	public int getParentPid() {
		return parentPid;
	}

	/**
	 * @return the personPid
	 */
	public int getPersonPid() {
		return personPid;
	}

	/**
	 * @param ancestorList the ancestorList to set
	 */
	public void setAncestorList(List<TreePerson> ancestorList) {
		this.ancestorList = ancestorList;
	}

	/**
	 * @param childPid the childPid to set
	 */
	public void setChildPid(int childPid) {
		this.childPid = childPid;
	}

	/**
	 * @param descendantList the descendantList to set
	 */
	public void setDescendantList(List<TreePerson> descendantList) {
		this.descendantList = descendantList;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @param parentPid the parentPid to set
	 */
	public void setParentPid(int parentPid) {
		this.parentPid = parentPid;
	}

	/**
	 * @param personPid the personPid to set
	 */
	public void setPersonPid(int personPid) {
		this.personPid = personPid;
	}
}
