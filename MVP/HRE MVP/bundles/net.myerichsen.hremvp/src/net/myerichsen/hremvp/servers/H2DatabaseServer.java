package net.myerichsen.hremvp.servers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.HreH2ConnectionPool;
import net.myerichsen.hremvp.IHREServer;

/**
 * Serves H2 data to the database navigator
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 24. apr. 2019
 *
 */
public class H2DatabaseServer implements IHREServer {
	private static IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Constructor
	 *
	 */
	public H2DatabaseServer() {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#delete(int)
	 */
	@Override
	public void delete(int key) throws Exception {
		// TODO Auto-generated method stub

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
	 * @see net.myerichsen.hremvp.IHREProvider#get(int)
	 */
	@Override
	public void get(int key) throws Exception {
		// TODO Auto-generated method stub

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
	 * @see net.myerichsen.hremvp.IHREProvider#getStringList()
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		final Connection conn = HreH2ConnectionPool
				.getConnection(store.getString("DBNAME"));
		final String h2Version = store.getString("H2VERSION");
		LOGGER.log(Level.INFO, "Retrieved H2 version from preferences: {0}",
				h2Version.substring(0, 3));

		if (h2Version.substring(0, 3).equals("1.3")) {
			return prepareOldStatement(conn);

		} else {
			return prepareNewStatement(conn);
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#getStringList(int)
	 */
	@Override
	public List<List<String>> getStringList(int key) throws Exception {
		return new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#insert()
	 */
	@Override
	public int insert() throws Exception {
		// TODO Auto-generated method stub
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

	/**
	 * @param conn
	 * @return
	 * @throws SQLException
	 *
	 */
	private List<List<String>> prepareNewStatement(Connection conn)
			throws SQLException {
		final String SELECT = "SELECT TABLE_NAME, ROW_COUNT_ESTIMATE "
				+ "FROM INFORMATION_SCHEMA.TABLES "
				+ "WHERE TABLE_TYPE = 'TABLE' ORDER BY TABLE_NAME";

		final List<List<String>> lls = new ArrayList<>();
		List<String> stringList;

		final PreparedStatement ps = conn.prepareStatement(SELECT);
		final ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			stringList = new ArrayList<>();
			stringList.add(rs.getString(1));
			stringList.add(Long.toString(rs.getLong(2)));
			lls.add(stringList);
		}

		return lls;
	}

	/**
	 * @param conn
	 * @return
	 * @throws SQLException
	 *
	 */
	private List<List<String>> prepareOldStatement(Connection conn)
			throws SQLException {
		final String SELECTTABLES = "SELECT TABLE_NAME "
				+ "FROM INFORMATION_SCHEMA.TABLES "
				+ "WHERE TABLE_TYPE = 'TABLE' ORDER BY TABLE_NAME";
		final String SELECTROWCOUNT = "SELECT COUNT(*) FROM ";
		String tableName;
		PreparedStatement ps2;
		ResultSet rs2;
		Long rowCount;

		final List<List<String>> lls = new ArrayList<>();
		List<String> stringList;

		final PreparedStatement ps1 = conn.prepareStatement(SELECTTABLES);
		final ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {
			stringList = new ArrayList<>();
			tableName = rs1.getString(1);
			stringList.add(tableName);

			ps2 = conn.prepareStatement(SELECTROWCOUNT + tableName);
			rs2 = ps2.executeQuery();

			if (rs2.next()) {
				rowCount = rs2.getLong(1);
			} else {
				rowCount = 0L;
			}
			stringList.add(Long.toString(rowCount));
			lls.add(stringList);
		}
		return lls;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#update()
	 */
	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub

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