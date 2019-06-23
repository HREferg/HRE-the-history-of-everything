package net.myerichsen.hremvp.providers;

import java.util.List;

import org.eclipse.jface.viewers.IContentProvider;

import net.myerichsen.hremvp.IHREProvider;
import net.myerichsen.hremvp.servers.H2DatabaseServer;

/**
 * Provides H2 data to the database navigator
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 24. apr. 2019
 *
 */
public class H2DatabaseProvider implements IContentProvider, IHREProvider {
	private final H2DatabaseServer server;

	/**
	 * Constructor
	 *
	 * @throws Exception When failing
	 *
	 */
	public H2DatabaseProvider() {
		server = new H2DatabaseServer();
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
		server.get(key);
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
		return server.insert();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#update()
	 */
	@Override
	public void update() throws Exception {
		server.update();
	}
}