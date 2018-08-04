package org.historyresearchenvironment.databaseadmin.dataaccess.providers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.viewers.IContentProvider;
import org.historyresearchenvironment.dataaccess.HreH2ConnectionPool;
import org.historyresearchenvironment.databaseadmin.dataaccess.models.H2DatabaseModel;

/**
 * Provides H2 data to the database navigator
 * 
 * @ @version 2018-08-04
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class H2DatabaseProvider implements IContentProvider {
	private IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.historyresearchenvironment");
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private Connection conn = null;

	private static final String SELECT13 = "SELECT TABLE_NAME, 0 FROM INFORMATION_SCHEMA.TABLES "
			+ "WHERE TABLE_TYPE = 'TABLE' ORDER BY TABLE_NAME";
	private static final String SELECT = "SELECT TABLE_NAME, ROW_COUNT_ESTIMATE FROM INFORMATION_SCHEMA.TABLES "
			+ "WHERE TABLE_TYPE = 'TABLE' ORDER BY TABLE_NAME";
	private final List<H2DatabaseModel> modelList = new ArrayList<H2DatabaseModel>();
	private H2DatabaseModel model;

	/**
	 * Constructor
	 * 
	 * @throws SQLException
	 *             When failing
	 *
	 */
	public H2DatabaseProvider() throws SQLException {
		conn = HreH2ConnectionPool.getConnection();
		final String dbName = preferences.get("DBNAME", "./SAMPLE");

		LOGGER.info("Database name: " + dbName);

		conn = HreH2ConnectionPool.getConnection(dbName);
		PreparedStatement ps;
		String h2Version = preferences.get("H2VERSION", "1.3.168");
		LOGGER.info("Retrieved H2 version from preferences: " + h2Version.substring(0, 3));

		if (h2Version.substring(0, 3).equals("1.3")) {
			ps = conn.prepareStatement(SELECT13);
		} else {
			ps = conn.prepareStatement(SELECT);
		}

		final ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			model = new H2DatabaseModel(rs.getString(1), rs.getLong(2));
			modelList.add(model);
		}
	}

	/**
	 * @return the modelList
	 */
	public List<H2DatabaseModel> getModelList() {
		return modelList;
	}
}