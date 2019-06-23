package net.myerichsen.hremvp.project.servers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.h2.tools.Script;
import org.json.JSONStringer;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.HreH2ConnectionPool;
import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;

/**
 * Business logic interface for HRE Projects
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 7. maj 2019
 *
 */
public class ProjectServer implements IHREServer {
	private static final String NAME = ".name";
	private static final String PROJECT = "project.";
	private static IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private int projectId = 0;
	private String projectName = "";

	/**
	 * @param dbName
	 * @param path
	 * @throws SQLException
	 */
	public void backupUsingScript(final String dbName, String path)
			throws SQLException {
		final String[] bkp = { "-url", "jdbc:h2:" + path + "\\" + dbName,
				"-user", store.getString("USERID"), "-password",
				store.getString("PASSWORD"), "-script",
				path + "\\" + dbName + ".zip", "-options", "compression",
				"zip" };
		Script.main(bkp);
	}

	/**
	 * @param dbName
	 * @throws SQLException
	 */
	public void closeDbIfActive(final String dbName) throws SQLException {
		final String activeName = store.getString("DBNAME");

		if (activeName.equals(dbName)) {
			Connection conn = null;

			conn = HreH2ConnectionPool.getConnection();

			if (conn != null) {
				conn.createStatement().execute("SHUTDOWN");
				conn.close();
				LOGGER.log(Level.FINE, "Existing database {0} has been closed",
						dbName);

				try {
					HreH2ConnectionPool.dispose();
				} catch (final Exception e) {
					LOGGER.log(Level.FINE, "No connection pool to dispose");
				}
			}
		}
	}

	/**
	 * @param dbName
	 * @param h2Version
	 * @throws SQLException
	 */
	public void connectToNewDatabase(final String dbName,
			final String h2Version) throws SQLException {
		final Connection conn = HreH2ConnectionPool.getConnection(dbName);
		PreparedStatement ps;

		if (h2Version.substring(0, 3).equals("1.3")) {
			ps = conn.prepareStatement(
					"SELECT TABLE_NAME, 0 FROM INFORMATION_SCHEMA.TABLES "
							+ "WHERE TABLE_TYPE = 'TABLE' ORDER BY TABLE_NAME");
		} else {
			ps = conn.prepareStatement(
					"SELECT TABLE_NAME, ROW_COUNT_ESTIMATE FROM INFORMATION_SCHEMA.TABLES "
							+ "WHERE TABLE_TYPE = 'TABLE' ORDER BY TABLE_NAME");
		}

		ps.executeQuery();
		conn.close();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#delete(int)
	 */
	@Override
	public void delete(int key) throws Exception {

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
	 * @see net.myerichsen.hremvp.IHREServer#get(int)
	 */
	@Override
	public void get(int key) throws Exception {
		projectId = key;
		final String propKey = PROJECT + key + NAME;
		projectName = store.getString(propKey);
	}

	/**
	 * @param key
	 * @return
	 * @throws Exception
	 * @throws MvpException
	 */
	public List<String> getElement(int key) throws Exception {
		get(key);
		final List<String> element = new ArrayList<>();
		element.add(Integer.toString(projectId));
		element.add(projectName);
		return element;
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
		LOGGER.log(Level.FINE, "Target {0}", target);

		final String[] targetParts = target.split("/");
		final int targetSize = targetParts.length;

		final JSONStringer js = new JSONStringer();
		js.object();

		if (targetSize == 0) {
			js.key("projects");
			js.array();

			final List<List<String>> stringList = getStringList();

			for (final List<String> list : stringList) {
				js.object();
				js.key("pid");
				js.value(list.get(0));
				js.key("name");
				js.value(list.get(1));
				js.key("LOCAL/REMOTE");
				js.value(list.get(2));
				js.key("endpoint");
				js.value(request.getRequestURL() + list.get(0));
				js.endObject();
			}

			js.endArray();
			js.endObject();
			return js.toString();
		}

		final int pid = Integer.parseInt(targetParts[1]);
		final List<List<String>> stringList = getStringList(pid);

		js.key("project");
		js.object();

		for (int i = 0; i < 4; i++) {
			js.key(stringList.get(i).get(0));
			js.value(stringList.get(i).get(1));
		}

		js.endObject();
		js.endObject();

		LOGGER.log(Level.INFO, "JSON String: {0}", js);

		return js.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getStringList()
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		final List<List<String>> lls = new ArrayList<>();
		List<String> ls;
		final int projectCount = store.getInt("projectcount");
		String key;

		for (int i = 1; i <= projectCount; i++) {
			ls = new ArrayList<>();
			ls.add(Integer.toString(i));
			key = PROJECT + i + NAME;
			ls.add(store.getString(key));
			key = PROJECT + i + ".localserver";
			ls.add(store.getString(key));

			LOGGER.log(Level.INFO, "Found Name: " + store.getString(key));
			lls.add(ls);
		}

		return lls;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getStringList(int)
	 */
	@Override
	public List<List<String>> getStringList(int key) throws Exception {
		String keyString;
		List<String> ls;

		final List<List<String>> lls = new ArrayList<>();

		if (key == 0) {
			return lls;
		}

		final String[] labelArray = { "Project Name", "Last Edited", "Summary",
				"Local/Server", "Path" };

		for (int i = 0; i < labelArray.length; i++) {
			ls = new ArrayList<>();

			ls.add(labelArray[i]);

			switch (i) {
			case 0:
				keyString = PROJECT + key + NAME;
				ls.add(store.getString(keyString));
				break;
			case 1:
				keyString = PROJECT + key + ".lastupdated";
				ls.add(store.getString(keyString));
				break;
			case 2:
				keyString = PROJECT + key + ".summary";
				ls.add(store.getString(keyString));
				break;
			case 3:
				keyString = PROJECT + key + ".localserver";
				ls.add(store.getString(keyString));
				break;
			case 4:
				keyString = PROJECT + key + ".path";
				ls.add(store.getString(keyString));
				break;
			default:
				LOGGER.log(Level.SEVERE, "Invalid index: {0}", i);
				break;
			}

			lls.add(ls);
		}
		return lls;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#insert()
	 */
	@Override
	public int insert() throws Exception {
		return 0;
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

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#update()
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