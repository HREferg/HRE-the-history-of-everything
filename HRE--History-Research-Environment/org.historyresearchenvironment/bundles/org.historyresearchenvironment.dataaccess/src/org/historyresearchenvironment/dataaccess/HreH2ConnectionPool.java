package org.historyresearchenvironment.dataaccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.h2.jdbcx.JdbcConnectionPool;
import org.osgi.service.prefs.BackingStoreException;

/**
 * Singleton class that instantiates a JDBC Connection Pool and returns a
 * connection to it.
 * 
 * @version 2018-07-26
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class HreH2ConnectionPool {
	private static JdbcConnectionPool connectionPool = null;
	private static IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.historyresearchenvironment");
	private static int h2TraceLevel = preferences.getInt("H2TRACELEVEL", 1);
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Dispose connection pool and recreate to create a new data base.
	 * 
	 * @param dbName
	 *            Name of the database
	 * @throws BackingStoreException
	 *             Error in preferences file access
	 */
	public static void createNew(String dbName) throws BackingStoreException {
		connectionPool.dispose();
		final String jdbcUrl = "jdbc:h2:" + dbName + ";TRACE_LEVEL_FILE=" + h2TraceLevel + ";TRACE_LEVEL_SYSTEM_OUT="
				+ h2TraceLevel;
		LOGGER.info("JDBC URL: " + jdbcUrl);
		connectionPool = JdbcConnectionPool.create(jdbcUrl, "sa", "");
		LOGGER.info("Connection pool has been created");
		connectionPool.setMaxConnections(500);
		preferences.put("DBNAME", dbName);
		LOGGER.info("Preferences dbname set to " + dbName);
		preferences.flush();
		LOGGER.info("Preferences has been flushed");
	}

	/**
	 * Dispose the connection pool.
	 */
	public static void dispose() {
		if (connectionPool != null) {
			connectionPool.dispose();
		}
		connectionPool = null;
	}

	/**
	 * @return A JDBC connection
	 * @throws SQLException
	 *             When failing
	 */
	public static Connection getConnection() throws SQLException {
		final String dbName = preferences.get("DBNAME", "./SAMPLE");

		if (connectionPool == null) {
			final String jdbcUrl = "jdbc:h2:" + dbName + ";IFEXISTS=TRUE;TRACE_LEVEL_FILE=" + h2TraceLevel
					+ ";TRACE_LEVEL_SYSTEM_OUT=" + h2TraceLevel;
			LOGGER.info("JDBC URL: " + jdbcUrl);
			connectionPool = JdbcConnectionPool.create(jdbcUrl, preferences.get("USERID", "sa"),
					preferences.get("PASSWORD", ""));
			connectionPool.setMaxConnections(500);
		}

		LOGGER.info("Reusing connection pool");
		return connectionPool.getConnection();
	}

	/**
	 * Get a JDBCconnection
	 * 
	 * @param dbName
	 *            Name of database
	 * @return A JDBC Connection
	 * @throws SQLException
	 *             When failing
	 */
	public static Connection getConnection(String dbName) throws SQLException {
		final String jdbcUrl = "jdbc:h2:" + dbName + ";IFEXISTS=TRUE;TRACE_LEVEL_FILE=" + h2TraceLevel
				+ ";TRACE_LEVEL_SYSTEM_OUT=" + h2TraceLevel;
		LOGGER.info("JDBC URL: " + jdbcUrl);
		connectionPool = JdbcConnectionPool.create(jdbcUrl, "sa", "");
		connectionPool.setMaxConnections(500);
		LOGGER.info("Connection pool has been created");

		return connectionPool.getConnection();
	}

	/**
	 * Exists only to defeat instantiation
	 */
	protected HreH2ConnectionPool() {
	}
}