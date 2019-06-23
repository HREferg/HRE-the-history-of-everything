package net.myerichsen.hremvp.project.providers;

import java.sql.SQLException;
import java.util.List;

import net.myerichsen.hremvp.IHREProvider;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.project.servers.ProjectServer;

/**
 * Provides all registered projects
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 27. apr. 2019
 *
 */
public class ProjectProvider implements IHREProvider {
//	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	ProjectServer server;

	/**
	 * Constructor
	 *
	 */
	public ProjectProvider() {
		server = new ProjectServer();
	}

	/**
	 * @param dbName
	 * @param path
	 * @throws SQLException
	 */
	public void backupUsingScript(String dbName, String path)
			throws SQLException {
		server.backupUsingScript(dbName, path);
	}

	/**
	 * @param dbName
	 * @throws SQLException
	 */
	public void closeDbIfActive(String dbName) throws SQLException {
		server.closeDbIfActive(dbName);
	}

	/**
	 * @param dbName
	 * @param h2Version
	 * @throws SQLException
	 */
	public void connectToNewDatabase(String dbName, String h2Version)
			throws SQLException {
		server.connectToNewDatabase(dbName, h2Version);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#delete(int)
	 */
	@Override
	public void delete(int key) throws Exception {

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
	 * @param key
	 * @return
	 * @throws Exception
	 * @throws MvpException
	 */
	public List<String> getElement(int key) throws Exception {
		return server.getElement(key);
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
		return 0;
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
