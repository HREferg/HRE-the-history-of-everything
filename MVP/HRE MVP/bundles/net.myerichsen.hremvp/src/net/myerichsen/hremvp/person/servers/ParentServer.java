package net.myerichsen.hremvp.person.servers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.Dictionary;
import net.myerichsen.hremvp.dbmodels.ParentRoles;
import net.myerichsen.hremvp.dbmodels.Parents;

/**
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 * @version 9. jun. 2019
 *
 */
public class ParentServer implements IHREServer {
	private int ParentPid;
	private int Child;
	private int Parent;
	private int ParentRolePid;
	private int ChildRolePid;
	private boolean PrimaryParent;

	private final Parents parentRelation;

	/**
	 * Constructor
	 *
	 */
	public ParentServer() {
		parentRelation = new Parents();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.servers.IHREServer#delete(int)
	 */
	@Override
	public void delete(int key) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#deleteRemote(java.lang.String)
	 */
	@Override
	public void deleteRemote(String target) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.servers.IHREServer#get(int)
	 */
	@Override
	public void get(int key) throws Exception {

	}

	/**
	 * @return the child
	 */
	public int getChild() {
		return Child;
	}

	/**
	 * @param personPid
	 * @return
	 */
	public List<List<String>> getChildrenList(int key) throws Exception {
		List<String> ls;

		final PersonNameServer pns = new PersonNameServer();
		final List<List<String>> childrenList = new ArrayList<>();

		for (final Parents parent : new Parents().getFKParent(key)) {
			ls = new ArrayList<>();
			final int pid = parent.getChild();
			ls.add(Integer.toString(pid));

			ls.add(pns.getPrimaryNameString(pid));

			childrenList.add(ls);
		}

		return childrenList;
	}

	/**
	 * @return the childRolePid
	 */
	public int getChildRolePid() {
		return ChildRolePid;
	}

	/**
	 * @return the parent
	 */
	public int getParent() {
		return Parent;
	}

	/**
	 * @return the parentPid
	 */
	public int getParentPid() {
		return ParentPid;
	}

	/**
	 * @return the parentRolePid
	 */
	public int getParentRolePid() {
		return ParentRolePid;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getRemote(javax.servlet.http.
	 * HttpServletResponse, java.lang.String)
	 */
	@Override
	public String getRemote(HttpServletRequest request, String target)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getStringList()
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		return new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getStringList(int)
	 */
	@Override
	public List<List<String>> getStringList(int key) throws Exception {
		final List<List<String>> lls = new ArrayList<>();

		if (key == 0) {
			return lls;
		}

		List<String> ls;
		int parentPid;
		final PersonNameServer pns = new PersonNameServer();
		final ParentRoles role = new ParentRoles();
		final Dictionary dictionary = new Dictionary();

		for (final Parents aParent : new Parents().getFKChild(key)) {
			ls = new ArrayList<>();
			parentPid = aParent.getParent();
			ls.add(Integer.toString(parentPid));
			ls.add(pns.getPrimaryNameString(parentPid));

			role.get(aParent.getParentRolePid());
			dictionary.getFKLabelPid(role.getLabelPid());
			ls.add(dictionary.getLabel());

			ls.add(Boolean.toString(aParent.isPrimaryParent()));

			role.get(aParent.getChildRolePid());
			dictionary.getFKLabelPid(role.getLabelPid());
			ls.add(dictionary.getLabel());

			lls.add(ls);
		}
		return lls;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.servers.IHREServer#insert()
	 */
	@Override
	public int insert() throws Exception {
		parentRelation.setChild(Child);
		parentRelation.setParent(Parent);
		parentRelation.setParentRolePid(getParentRolePid());
		parentRelation.setChildRolePid(ChildRolePid);
		parentRelation.setPrimaryParent(PrimaryParent);
		return parentRelation.insert();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#insertRemote(javax.servlet.http.
	 * HttpServletRequest)
	 */
	@Override
	public void insertRemote(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the primaryParent
	 */
	public boolean isPrimaryParent() {
		return PrimaryParent;
	}

	/**
	 * @param personPid
	 * @param parentPid
	 * @throws Exception
	 * @throws MvpException
	 */
	public void removeParent(int parentPid) throws Exception {
		for (final Parents p : parentRelation.getFKChild(parentPid)) {
			if (p.getParent() == parentPid) {
				parentRelation.delete(p.getParentPid());
			}
		}
	}

	/**
	 * @param child the child to set
	 */
	public void setChild(int child) {
		Child = child;
	}

	/**
	 * @param childRolePid the childRolePid to set
	 */
	public void setChildRolePid(int childRolePid) {
		ChildRolePid = childRolePid;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(int parent) {
		Parent = parent;
	}

	/**
	 * @param parentPid the parentPid to set
	 */
	public void setParentPid(int parentPid) {
		ParentPid = parentPid;
	}

	/**
	 * @param parentRolePid the parentRolePid to set
	 */
	public void setParentRolePid(int parentRolePid) {
		ParentRolePid = parentRolePid;
	}

	/**
	 * @param primaryParent the primaryParent to set
	 */
	public void setPrimaryParent(boolean primaryParent) {
		PrimaryParent = primaryParent;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.servers.IHREServer#update()
	 */
	@Override
	public void update() throws Exception {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#updateRemote(javax.servlet.http.
	 * HttpServletRequest)
	 */
	@Override
	public void updateRemote(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}
}
