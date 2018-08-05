package org.historyresearchenvironment.toolbox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads the H2 catalog and calls H2ModelGenerator for each table.
 * 
 * @see H2ModelGenerator
 * @version 2018-08-02
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class H2ModelBatchjob {
	private static final String TABLES = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES "
			+ "WHERE TABLE_SCHEMA = 'PUBLIC'";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: H2ModelBatchjob <h2database> <outputdirectory>");
			System.exit(16);
		}

		final String databaseName = args[0];
		final String outputDirectory = args[1];

		List<String> tableNames = new ArrayList<String>();

		// Fetch all table names from Database catalog
		try {
			final String connectionName = "jdbc:h2:" + databaseName;
			final Connection conn = DriverManager.getConnection(connectionName, "sa", "");
			final PreparedStatement ps = conn.prepareStatement(TABLES);
			final ResultSet rs = ps.executeQuery();

			String name;
			while (rs.next()) {
				name = rs.getString(1);
				// System.out.println("Found table " + name);
				tableNames.add(name);
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(16);
		}

		// Call H2ModelGenerator for each table name
		for (String tableName : tableNames) {
			System.out.println("Generating " + tableName + " in " + databaseName + " to " + outputDirectory);

			H2ModelGenerator generator;
			try {
				generator = null;
				generator = new H2ModelGenerator();
				generator.setDatabaseName(databaseName);
				generator.setTableName(tableName);
				generator.setOutputDirectory(outputDirectory);
				extracted(generator);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void extracted(H2ModelGenerator generator) {
		generator.generate();
	}

}
