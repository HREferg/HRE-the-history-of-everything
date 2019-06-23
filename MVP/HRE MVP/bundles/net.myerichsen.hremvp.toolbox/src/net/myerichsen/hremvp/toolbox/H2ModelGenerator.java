package net.myerichsen.hremvp.toolbox;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility to generate a Java model class representing an HRE H2 Table
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 28. apr. 2019
 *
 */

public class H2ModelGenerator {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final String COLUMNS = "SELECT COLUMN_NAME, TYPE_NAME, COLUMN_DEFAULT FROM INFORMATION_SCHEMA.COLUMNS "
			+ "WHERE TABLE_SCHEMA = 'PUBLIC' AND TABLE_NAME = ?";
	private static final String FOREIGNKEYS = "SELECT CL.COLUMN_NAME, CL.TYPE_NAME "
			+ "FROM INFORMATION_SCHEMA.COLUMNS AS CL, INFORMATION_SCHEMA.CONSTRAINTS AS CT "
			+ "WHERE CT.CONSTRAINT_TYPE = 'REFERENTIAL' AND CL.COLUMN_NAME = CT.COLUMN_LIST "
			+ "AND CL.TABLE_NAME = CT.TABLE_NAME AND CL.TABLE_NAME = ?";
	private static String databaseName;
	private static String tableName = "";
	private static String outputDirectory = "";
	private static List<String> fields;
	private static List<String> types;
	private static String primaryKey = "PRIMARY_KEY";
	private static String primaryKeyType = "void";
	private static PrintWriter writer;
	private static int tableId;

	/**
	 * Constructor
	 */
	public H2ModelGenerator() {
	}

	/**
	 * @param string
	 * @return
	 */
	private static String convertType(String string) {
		if (string.equals("BIGINT")) {
			return "long";
		}
		if (string.equals("BLOB")) {
			return "Blob";
		}
		if (string.equals("BOOLEAN")) {
			return "boolean";
		}
		if (string.equals("CHAR")) {
			return "String";
		}
		if (string.equals("CLOB")) {
			return "Clob";
		}
		if (string.equals("DATE")) {
			return "Date";
		}
		if (string.equals("DECIMAL")) {
			return "BigDecimal";
		}
		if (string.equals("DOUBLE")) {
			return "double";
		}
		if (string.equals("INTEGER")) {
			return "int";
		}
		if (string.equals("SMALLINT")) {
			return "short";
		}
		if (string.equals("TIMESTAMP")) {
			return "Timestamp";
		}
		if (string.equals("VARBINARY")) {
			return "byte[]";
		}
		if (string.equals("VARCHAR")) {
			return "String";
		}
		return null;
	}

	/**
	 * @throws SQLException
	 * @throws IOException
	 * @throws Exception
	 */
	private static void createDatabaseOperations() throws SQLException {
		// delete()
		writer.println("public void delete() throws Exception {");
		writer.println("conn = HreH2ConnectionPool.getConnection();");
		writer.println("ps = conn.prepareStatement(DELETEALL);");
		writer.println("ps.executeUpdate();");
		writer.println("conn.close();");
		writer.println("}\r\n");

		// delete(key)
		writer.println("public void delete(" + primaryKeyType
				+ " key) throws Exception {");
		writer.println("conn = HreH2ConnectionPool.getConnection();");
		writer.println("ps = conn.prepareStatement(DELETE);");
		writer.println("ps.set" + toCamelCase(primaryKeyType) + "(1, key);");
		writer.println(
				"if (ps.executeUpdate() == 0) { conn.close(); throw new MvpException(\"ID \" + key + \" not found\"); }");
		writer.println("conn.close();");
		writer.println("}\r\n");

		// get()
		writer.println("public List<" + toCamelCase(tableName)
				+ "> get() throws Exception {");
		writer.println("conn = HreH2ConnectionPool.getConnection();");
		writer.println("ps = conn.prepareStatement(SELECTALL);");
		writer.println("rs = ps.executeQuery();");
		writer.println(
				"modelList = new ArrayList<" + toCamelCase(tableName) + ">();");
		writer.println("while (rs.next()) {");
		writer.println("model = new " + toCamelCase(tableName) + "();");

		for (int i = 0; i < fields.size(); i++) {
//			if (types.get(i).equalsIgnoreCase("LocalDate")) {
//				writer.println("model.set" + toCamelCase(fields.get(i))
//						+ "(rs.getObject(\"" + fields.get(i)
//						+ "\", LocalDate.class));");
//			} else {
			writer.println("model.set" + toCamelCase(fields.get(i)) + "(rs.get"
					+ toCamelCase(types.get(i)) + "(\"" + fields.get(i)
					+ "\"));");
//			}
		}

		writer.println("modelList.add(model);");
		writer.println("}");
		writer.println("conn.close();");
		writer.println("return modelList;");
		writer.println("}\r\n");

		// get(key)
		writer.println("public void get(" + primaryKeyType
				+ " key) throws Exception {");
		writer.println("conn = HreH2ConnectionPool.getConnection();");
		writer.println("ps = conn.prepareStatement(SELECT);");
		writer.println("ps.set" + toCamelCase(primaryKeyType) + "(1, key);");
		writer.println("rs = ps.executeQuery();");
		writer.println("if (rs.next()) {");

		for (int i = 0; i < fields.size(); i++) {
//			if (types.get(i).equalsIgnoreCase("LocalDate")) {
//				writer.println(
//						"set" + toCamelCase(fields.get(i)) + "(rs.getObject(\""
//								+ fields.get(i) + "\", LocalDate.class));");
//			} else {
			writer.println("set" + toCamelCase(fields.get(i)) + "(rs.get"
					+ toCamelCase(types.get(i)) + "(\"" + fields.get(i)
					+ "\"));");
//			}
		}

		writer.println(
				"} else { throw new MvpException(\"ID \" + key + \" not found\"); }");
		writer.println("conn.close();");
		writer.println("}\r\n");

		// getFK...()
		final String connectionName = "jdbc:h2:" + databaseName;
		final Connection conn = DriverManager.getConnection(connectionName,
				"sa", "");
		final PreparedStatement ps = conn.prepareStatement(FOREIGNKEYS);
		ps.setString(1, tableName);
		final ResultSet rs = ps.executeQuery();
		String columnName;
		String typeName;

		while (rs.next()) {
			columnName = rs.getString(1);
			typeName = convertType(rs.getString(2));

			writer.println("public List<" + toCamelCase(tableName) + "> getFK"
					+ toCamelCase(columnName) + "(" + typeName
					+ " key) throws Exception {");
			writer.println("conn = HreH2ConnectionPool.getConnection();");
			writer.println(
					"ps = conn.prepareStatement(SELECT_" + columnName + ");");
			writer.println("ps.set" + toCamelCase(typeName) + "(1, key);");
			writer.println("rs = ps.executeQuery();");
			writer.println("modelList = new ArrayList<" + toCamelCase(tableName)
					+ ">();");
			writer.println("while (rs.next()) {");
			writer.println("model = new " + toCamelCase(tableName) + "();");

			for (int i = 0; i < fields.size(); i++) {
//				if (types.get(i).equalsIgnoreCase("LocalDate")) {
//					writer.println("model.set" + toCamelCase(fields.get(i))
//							+ "(rs.getObject(\"" + fields.get(i)
//							+ "\", LocalDate.class));");
//				} else {
				writer.println("model.set" + toCamelCase(fields.get(i))
						+ "(rs.get" + toCamelCase(types.get(i)) + "(\""
						+ fields.get(i) + "\"));");
//				}
			}

			writer.println("modelList.add(model);");
			writer.println("}");
			writer.println("conn.close();");
			writer.println("return modelList;");
			writer.println("}\r\n");
		}

		// insert()
		writer.println("public int insert() throws Exception {");
		writer.println("int maxPid = 0;");
		writer.println("conn = HreH2ConnectionPool.getConnection();");
		writer.println("ps = conn.prepareStatement(SELECTMAX);");
		writer.println("rs = ps.executeQuery();");
		writer.println("if (rs.next()) { maxPid = rs.getInt(1); }");
		writer.println("maxPid++;\r\n");

		writer.println("ps = conn.prepareStatement(INSERT);");
		String type;

		String field;
		int index = 1;

		for (int i = 0; i < fields.size(); i++) {
			field = fields.get(i);
			if (field.equals(primaryKey)) {
				writer.println("ps.setInt(" + (index++) + ", maxPid);");
				continue;
			}

			if ((field.equals("INSERT_TSTMP")) || (field.equals("UPDATE_TSTMP"))
					|| (field.equals("TABLE_ID"))) {
				continue;
			}

			type = types.get(i);
			if (type.equalsIgnoreCase("Boolean")) {
				writer.println("ps.set" + toCamelCase(type) + "(" + (index++)
						+ ", is" + toCamelCase(field) + "());");
//			} else if (type.equalsIgnoreCase("LocalDate")) {
//				writer.println("ps.setObject(" + (index++) + ", get"
//						+ toCamelCase(field) + "());");
			} else {
				if (field.endsWith("DATE_PID")) {
					writer.println("if (get" + toCamelCase(field) + "() == 0)");
					writer.println("ps.setNull(" + (index)
							+ ", java.sql.Types.INTEGER);");
					writer.println("else");
				}
				writer.println("ps.set" + toCamelCase(type) + "(" + (index++)
						+ ", get" + toCamelCase(field) + "());");
			}
		}

		writer.println("ps.executeUpdate();");
		writer.println("conn.close();");
		writer.println("return maxPid;");
		writer.println("}\r\n");

		// update()
		writer.println("public void update() throws Exception {");
		writer.println("conn = HreH2ConnectionPool.getConnection();");
		writer.println("ps = conn.prepareStatement(UPDATE);");

		index = 1;

		for (int i = 0; i < fields.size(); i++) {
			field = fields.get(i);
			if ((field.equals(primaryKey)) || (field.equals("INSERT_TSTMP"))
					|| (field.equals("UPDATE_TSTMP"))
					|| (field.equals("TABLE_ID"))) {
				continue;
			}

			type = types.get(i);
			if (type.equalsIgnoreCase("Boolean")) {
				writer.println("ps.set" + toCamelCase(type) + "(" + index++
						+ ", is" + toCamelCase(field) + "());");
//			} else if (type.equalsIgnoreCase("LocalDate")) {
//				writer.println("ps.setObject(" + (index++) + ", get"
//						+ toCamelCase(field) + "());");
			} else {
				if (field.endsWith("DATE_PID")) {
					writer.println("if (get" + toCamelCase(field) + "() == 0)");
					writer.println("ps.setNull(" + index
							+ ", java.sql.Types.INTEGER);");
					writer.println("else");
				}
				writer.println("ps.set" + toCamelCase(type) + "(" + index++
						+ ", get" + toCamelCase(field) + "());");
			}
		}

		// Primary key
		writer.println("ps.setInt(" + index + ", get" + toCamelCase(primaryKey)
				+ "());");

		writer.println("ps.executeUpdate();");
		writer.println("conn.close();");
		writer.println("}\r\n");
	}

	/**
	 * @throws IOException
	 *
	 */
	private static void createFields() {
		for (int i = 0; i < fields.size(); i++) {
			writer.println("private " + types.get(i) + " "
					+ toCamelCase(fields.get(i)) + ";");
		}
		writer.println("private " + toCamelCase(tableName) + " model;\r\n");
	}

	/**
	 * @throws IOException
	 *
	 */
	private static void createGetters() {
		String field;
		String type;

		for (int i = 0; i < fields.size(); i++) {
			field = toCamelCase(fields.get(i));

			writer.println("/**");
			writer.println("* Get the " + field + " field.");
			writer.println("*");
			writer.println(
					"* @return Contents of the " + fields.get(i) + " column");
			writer.println("*/");

			type = types.get(i);
			if (type.equalsIgnoreCase("Boolean")) {
				writer.println("public " + type + " is" + field + "() {");
			} else {
				writer.println("public " + type + " get" + field + "() {");
			}
			writer.println("return this." + field + ";");
			writer.println("}\r\n");
		}
	}

	/**
	 * @throws IOException
	 *
	 */
	private static void createHeader() {
		writer.println("package net.myerichsen.hremvp.dbmodels;\r\n");
		writer.println("import java.math.BigDecimal;");
		writer.println("import java.sql.Connection;");
		writer.println("import java.sql.LocalDate;");
		writer.println("import java.sql.PreparedStatement;");
		writer.println("import java.sql.ResultSet;");
		writer.println("import java.sql.Exception;");
		writer.println("import java.sql.Timestamp;");
		writer.println("import java.util.ArrayList;");
		writer.println("import java.util.List;");
		writer.println("import net.myerichsen.hremvp.HreH2ConnectionPool;");
		writer.println("import net.myerichsen.hremvp.MvpException;\r\n");

		writer.println("/**");
		writer.println("* The persistent class for the " + tableName
				+ " database table");
		writer.println("*");

		final DateFormat dateFormat = new SimpleDateFormat("dd. MMM yyyy");
		final DateFormat yearFormat = new SimpleDateFormat("yyyy");
		final Date date = new Date();

		writer.println(
				"* @author H2ModelGenerator, &copy; History Research Environment Ltd., "
						+ yearFormat.format(date));
		writer.println("* @version " + dateFormat.format(date));
		writer.println("*");
		writer.println("*/\r\n");
		writer.println("public class " + toCamelCase(tableName) + " {");
		writer.println(
				"private List<" + toCamelCase(tableName) + "> modelList;");
		writer.println("private PreparedStatement ps;");
		writer.println("private ResultSet rs;");
		writer.println("private Connection conn;");
	}

	/**
	 * @throws IOException
	 *
	 */
	private static void createSetters() {
		String field;
		String type;

		for (int i = 0; i < fields.size(); i++) {
			field = toCamelCase(fields.get(i));

			writer.println("/**");
			writer.println("* Set the " + field + " field");
			writer.println("*");
			writer.println("* @param " + field + " Contents of the "
					+ fields.get(i) + " column");
			writer.println("*/");

			type = types.get(i);
			writer.println("public void set" + field + "(" + type + " " + field
					+ ") {");
			writer.println("this." + field + " = " + field + ";");
			writer.println("}\r\n");
		}
	}

	/**
	 * @throws SQLException
	 *
	 */
	private static void createSql() throws SQLException {
		// SELECT
		writer.println("private static final String SELECT = \"SELECT \" +");

		for (int i = 0; i < (fields.size() - 1); i++) {
			writer.println("\"" + fields.get(i) + ", \" +");
		}

		writer.println("\"" + fields.get(fields.size() - 1) + " FROM PUBLIC."
				+ tableName + " WHERE " + primaryKey + " = ?\";\r\n");

		// SELECT FOREIGN KEYS
		final String connectionName = "jdbc:h2:" + databaseName;
		final Connection conn = DriverManager.getConnection(connectionName,
				"sa", "");
		final PreparedStatement ps = conn.prepareStatement(FOREIGNKEYS);
		ps.setString(1, tableName);
		final ResultSet rs = ps.executeQuery();
		String columnName;

		while (rs.next()) {
			columnName = rs.getString(1);

			writer.println("private static final String SELECT_" + columnName
					+ " = \"SELECT \" +");

			for (int i = 0; i < (fields.size() - 1); i++) {
				writer.println("\"" + fields.get(i) + ", \" +  ");
			}
			writer.println("\"" + fields.get(fields.size() - 1)
					+ " FROM PUBLIC." + tableName + " WHERE " + columnName
					+ " = ? ORDER BY " + primaryKey + "\";\r\n");
		}

		// SELECTALL
		writer.println("private static final String SELECTALL = \"SELECT \" +");

		for (int i = 0; i < (fields.size() - 1); i++) {
			writer.println("\"" + fields.get(i) + ", \" +  ");
		}

		writer.println("\"" + fields.get(fields.size() - 1) + " FROM PUBLIC."
				+ tableName + " ORDER BY " + primaryKey + "\";\r\n");

		// SELECTMAX
		writer.println("private static final String SELECTMAX = \"SELECT MAX("
				+ primaryKey + ") FROM PUBLIC." + tableName + "\";\r\n");

		// INSERT
		writer.println(
				"private static final String INSERT = \"INSERT INTO PUBLIC."
						+ tableName + "( \" +");

		String field;

		for (int i = 0; i < (fields.size() - 1); i++) {
			writer.println("\"" + fields.get(i) + ", \" +     ");
		}

		writer.println("\"" + fields.get(fields.size() - 1) + ") VALUES (\" +");

		for (int i = 0; i < (fields.size() - 1); i++) {
			field = fields.get(i);
			if ((field.equals("INSERT_TSTMP"))
					|| (field.equals("UPDATE_TSTMP"))) {
				writer.println("\"CURRENT_TIMESTAMP, \" +");
			} else if (field.equals("TABLE_ID")) {
				writer.println("\"" + tableId + ", \" +");
			} else {
				writer.println("\"?, \" +");
			}
		}

		field = fields.get(fields.size() - 1);
		if ((field.equals("INSERT_TSTMP")) || (field.equals("UPDATE_TSTMP"))) {
			writer.println("\"CURRENT_TIMESTAMP)\";\r\n");
		} else if (field.equals("TABLE_ID")) {
			writer.println("\"" + tableId + ") \";\r\n");
		} else {
			writer.println("\"?)\";\r\n");
		}

		// UPDATE
		writer.println("private static final String UPDATE = \"UPDATE PUBLIC."
				+ tableName + " SET \" +");

		Boolean comma = true;

		// First column
		field = fields.get(0);
		if (field.equals(primaryKey)) {
			comma = false;
		} else if (field.equals("INSERT_TSTMP")) {
			comma = false;
		} else if (field.equals("UPDATE_TSTMP")) {
			writer.println("\"UPDATE_TSTMP = CURRENT_TIMESTAMP\" +");
		} else if (field.equals("TABLE_ID")) {
			comma = false;
		} else {
			writer.println("\"" + field + " = ?\" +");
		}

		// Middle columns
		for (int i = 1; i < (fields.size() - 1); i++) {
			field = fields.get(i);

			if (field.equals("UPDATE_TSTMP")) {
				if (comma) {
					writer.println("\", UPDATE_TSTMP = CURRENT_TIMESTAMP\" +");
				} else {
					writer.println("\"UPDATE_TSTMP = CURRENT_TIMESTAMP\" +");
					comma = true;
				}
			} else {
				if (comma) {
					writer.println("\", " + field + " = ?\" +");
				} else {
					writer.println("\"" + field + " = ?\" +");
					comma = true;
				}
			}

		}

		// Last column
		if (field.equals("INSERT_TSTMP")) {
			writer.println("\" WHERE " + primaryKey + " = ?\";\r\n");
		} else if (field.equals("UPDATE_TSTMP")) {
			writer.println("\" WHERE " + primaryKey + " = ?\";\r\n");
		} else if (field.equals("TABLE_ID")) {
			writer.println("\" WHERE " + primaryKey + " = ?\";\r\n");
		} else {
			writer.println("\", " + fields.get(fields.size() - 1)
					+ " = ? WHERE " + primaryKey + " = ?\";\r\n");

		}

		// DELETE
		writer.println(
				"private static final String DELETE = \"DELETE FROM PUBLIC."
						+ tableName + " WHERE " + primaryKey + " = ?\";\r\n");

		// DELETEALL
		writer.println(
				"private static final String DELETEALL = \"DELETE FROM PUBLIC."
						+ tableName + "\";\r\n");
	}

	/**
	 * @param generator
	 */
	private static void extracted(H2ModelGenerator generator) {
		generator.generate();
	}

	/**
	 * @param args Usage: H2ModelGenerator h2database tablename outputfile
	 */
	public static void main(String[] args) {
		if (args.length < 3) {
			LOGGER.log(Level.SEVERE,
					"Usage: H2ModelGenerator <h2database> <tablename> <outputfile>");
			System.exit(16);
		}

		final H2ModelGenerator generator = new H2ModelGenerator();
		databaseName = args[0];
		tableName = args[1].toUpperCase();
		outputDirectory = args[2];
		LOGGER.log(Level.INFO,
				"Generating Model Class for table {0} in {1} into {2}",
				new Object[] { tableName, databaseName, outputDirectory });

		extracted(generator);
	}

	/**
	 * @param init
	 * @return String in CamelCase
	 */
	private static String toCamelCase(final String init) {
		if (init == null) {
			return null;
		}

		if (init.equals("byte[]")) {
			return "Bytes";
		}

		final StringBuilder ret = new StringBuilder(init.length());

		for (final String word : init.split("_")) {
			if (!word.isEmpty()) {
				ret.append(word.substring(0, 1).toUpperCase());
				ret.append(word.substring(1).toLowerCase());
			}
		}

		return ret.toString();
	}

	/**
	 *
	 */
	public void generate() {
		fields = new ArrayList<>();
		types = new ArrayList<>();
		final File outputFile = new File(MessageFormat.format("{0}/{1}.java",
				outputDirectory, toCamelCase(tableName)));

		try {
			writer = new PrintWriter(
					new BufferedWriter(new FileWriter(outputFile)));
			createHeader();

			final String connectionName = "jdbc:h2:" + databaseName;
			final Connection conn = DriverManager.getConnection(connectionName,
					"sa", "");

			final ResultSet pks = conn.getMetaData().getPrimaryKeys(null, null,
					tableName);

			if (pks.next()) {
				primaryKey = pks.getString(4);
				LOGGER.log(Level.FINE, "Primary key: {0}", pks.getString(4));
			}

			final PreparedStatement ps = conn.prepareStatement(COLUMNS);
			ps.setString(1, tableName);
			final ResultSet rs = ps.executeQuery();
			String field;
			String type;

			while (rs.next()) {

				field = rs.getString(1);
				fields.add(field);
				type = convertType(rs.getString(2));
				types.add(type);

				if (field.equals(primaryKey)) {
					primaryKeyType = type;
				} else if (field.equals("TABLE_ID")) {
					tableId = rs.getInt(3);
					LOGGER.log(Level.FINE,
							"Field: {0}, type: {1}, default: {2}",
							new Object[] { field, type, tableId });
				}
			}

			createSql();
			createFields();
			// createConstructors();
			createDatabaseOperations();
			createGetters();
			createSetters();

			writer.println("}\r\n");
			writer.flush();
			writer.close();
			writer = null;
			conn.close();
			fields = null;
			types = null;
		} catch (

		final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			System.exit(8);
		}
	}

	/**
	 * @param databaseName the databaseName to set
	 */
	public void setDatabaseName(String databaseName) {
		H2ModelGenerator.databaseName = databaseName;
	}

	/**
	 * @param outputDirectory the outputDirectory to set
	 */
	public void setOutputDirectory(String outputDirectory) {
		H2ModelGenerator.outputDirectory = outputDirectory;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		H2ModelGenerator.tableName = tableName;
	}
}