package net.myerichsen.hremvp.person.providers;

import java.util.List;

import net.myerichsen.hremvp.IHREProvider;
import net.myerichsen.hremvp.person.servers.ParentServer;

/**
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 9. jun. 2019
 *
 */
public class ParentProvider implements IHREProvider {
	private int ParentPid;
	private int Child;
	private int Parent;
	private int ParentRolePid;
	private int ChildRolePid;
	private boolean PrimaryParent;

	private final ParentServer server;

	/**
	 * Constructor
	 *
	 * @param server
	 */
	public ParentProvider() {
		server = new ParentServer();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#delete(int)
	 */
	@Override
	public void delete(int key) throws Exception {
		server.delete(key);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#get(int)
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
	 * @throws Exception
	 */
	public List<List<String>> getChildrenList(int personPid) throws Exception {
		return server.getChildrenList(personPid);
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
	 * @see net.myerichsen.hremvp.IHREProvider#getStringList()
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		return server.getStringList();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#getStringList(int)
	 */
	@Override
	public List<List<String>> getStringList(int key) throws Exception {
		return server.getStringList(key);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#insert()
	 */
	@Override
	public int insert() throws Exception {
		server.setChild(Child);
		server.setParent(Parent);
		server.setParentRolePid(getParentRolePid());
		server.setChildRolePid(getChildRolePid());
		server.setPrimaryParent(PrimaryParent);
		return server.insert();
	}

	/**
	 * @return the primaryParent
	 */
	public boolean isPrimaryParent() {
		return PrimaryParent;
	}

	/**
	 * @param key
	 * @throws Exception
	 */
	public void removeParent(int key) throws Exception {
		server.removeParent(key);

	}

	/**
	 * @param child the child to set
	 */
	public void setChild(int child) {
		Child = child;
	}

	/**
	 * @param childRolePid
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
	 * @see net.myerichsen.hremvp.IHREProvider#update()
	 */
	@Override
	public void update() throws Exception {

	}
}
