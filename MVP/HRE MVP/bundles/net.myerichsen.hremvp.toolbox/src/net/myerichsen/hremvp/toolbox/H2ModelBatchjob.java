package net.myerichsen.hremvp.toolbox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Reads the H2 catalog and calls H2ModelGenerator for each table.
 *
 * @see H2ModelGenerator
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 28. apr. 2019
 *
 */
public class H2ModelBatchjob {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final String TABLES = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES "
			+ "WHERE TABLE_SCHEMA = 'PUBLIC'";

	private static void extracted(H2ModelGenerator generator) {
		generator.generate();
	}

	/**
	 * @param args Usage: H2ModelBatchjob h2database outputdirectory
	 */
	public static void main(String[] args) {
		if (args.length < 2) {
			LOGGER.log(Level.WARNING,
					"Usage: H2ModelBatchjob <h2database> <outputdirectory>");
			System.exit(16);
		}

		final String databaseName = args[0];
		final String outputDirectory = args[1];

		List<String> tableNames = new ArrayList<>();

		// Fetch all table names from Database catalog
		try {
			final String connectionName = "jdbc:h2:" + databaseName;
			final Connection conn = DriverManager.getConnection(connectionName,
					"sa", "");
			final PreparedStatement ps = conn.prepareStatement(TABLES);
			final ResultSet rs = ps.executeQuery();

			String name;
			while (rs.next()) {
				name = rs.getString(1);
				LOGGER.log(Level.FINE, "Found table {0}", name);
				tableNames.add(name);
			}

			conn.close();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			System.exit(16);
		}

		// Call H2ModelGenerator for each table name
		for (String tableName : tableNames) {
			LOGGER.log(Level.INFO, "Generating {0} in {1} to {2}",
					new Object[] { tableName, databaseName, outputDirectory });

			H2ModelGenerator generator;
			try {
				generator = new H2ModelGenerator();
				generator.setDatabaseName(databaseName);
				generator.setTableName(tableName);
				generator.setOutputDirectory(outputDirectory);
				extracted(generator);
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}
		}
	}

}
