package org.historyresearchenvironment.toolbox;

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Utility to generate a Java model class representing an HRE H2 Table.
 * 
 * @version 2018-08-03
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */

// TODO Add Javadoc tags to setters and getters
public class H2ModelGenerator {
	private static final String COLUMNS = "SELECT COLUMN_NAME, TYPE_NAME FROM INFORMATION_SCHEMA.COLUMNS "
			+ "WHERE TABLE_SCHEMA = 'PUBLIC' AND TABLE_NAME = ?";
	private static String databaseName;
	private static String tableName = "";
	private static String outputDirectory = "";
	private static List<String> fields;
	private static List<String> types;
	private static String primaryKey = "PRIMARY_KEY";
	private static String primaryKeyType = "void";
	private static PrintWriter writer;

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
		if (string.equals("CLOB")) {
			return "Clob";
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
	 * @param primaryKey
	 * @throws IOException
	 */
	private static void createConstructors() throws IOException {
		writer.println("/**");
		writer.println("* No-arg Constructor");
		writer.println("*");
		writer.println("* @throws SQLException If database access has failed");
		writer.println("*/\r\n");

		final String pk = toCamelCase(primaryKey);
		writer.println("public " + toCamelCase(tableName) + "() throws SQLException {");
		writer.println("}\r\n");

		writer.println("/**");
		writer.println("* Constructor");
		writer.println("*");
		writer.println("* @param " + toCamelCase(primaryKey) + " Primary key");
		writer.println("* @throws SQLException If database access has failed");
		writer.println("*/\r\n");

		writer.println(
				"public " + toCamelCase(tableName) + "(" + primaryKeyType + " " + pk + ") throws SQLException {");
		writer.println("super();");
		writer.println("this." + pk + " = " + pk + ";");
		writer.println("}\r\n");
	}

	/**
	 * @param fields
	 * @param primaryKey
	 * @throws IOException
	 */
	private static void createDatabaseOperations() throws IOException {

		// delete()
		writer.println("@Override");
		writer.println("public void delete() throws SQLException {");
		writer.println("ps = conn.prepareStatement(DELETEALL);");
		writer.println("ps.executeUpdate();");
		writer.println("}\r\n");

		// delete(key)
		writer.println("@Override");
		writer.println("public void delete(" + primaryKeyType + " key) throws SQLException {");
		writer.println("ps = conn.prepareStatement(DELETE);");
		writer.println("ps.set" + toCamelCase(primaryKeyType) + "(1, key);");
		writer.println("ps.executeUpdate();");
		writer.println("}\r\n");

		// get()
		writer.println("@Override");
		writer.println("public List<AbstractHreDataModel> get() throws SQLException {");
		writer.println("ps = conn.prepareStatement(SELECTALL);");
		writer.println("rs = ps.executeQuery();");
		writer.println("modelList = new ArrayList<AbstractHreDataModel>();");
		writer.println("while (rs.next()) {");
		writer.println("model = new " + toCamelCase(tableName) + "();");

		for (int i = 0; i < fields.size(); i++) {
			writer.println("model.set" + toCamelCase(fields.get(i)) + "(rs.get" + toCamelCase(types.get(i)) + "(\""
					+ fields.get(i) + "\"));");
		}

		writer.println("modelList.add(model);");
		writer.println("}");
		writer.println("return modelList;");
		writer.println("}\r\n");

		// get(key)
		writer.println("@Override");
		writer.println("public AbstractHreDataModel get(" + primaryKeyType + " key) throws SQLException {");
		writer.println("ps = conn.prepareStatement(SELECT);");
		writer.println("ps.set" + toCamelCase(primaryKeyType) + "(1, (" + primaryKeyType + ") key);");
		writer.println("rs = ps.executeQuery();");
		writer.println("if (rs.next()) {");

		for (int i = 0; i < fields.size(); i++) {
			writer.println("model.set" + toCamelCase(fields.get(i)) + "(rs.get" + toCamelCase(types.get(i)) + "(\""
					+ fields.get(i) + "\"));");
		}

		writer.println("}");
		writer.println("return this;");
		writer.println("}\r\n");

		// post()
		writer.println("@Override");
		writer.println("public void post(AbstractHreDataModel model) throws SQLException {");
		writer.println("ps = conn.prepareStatement(INSERT);");

		for (int i = 0; i < fields.size(); i++) {
			writer.println("((" + toCamelCase(tableName) + ") model).set" + toCamelCase(fields.get(i)) + "(rs.get"
					+ toCamelCase(types.get(i)) + "(\"" + fields.get(i) + "\"));");
		}

		writer.println("ps.executeUpdate();");
		writer.println("}\r\n");

		// put()
		writer.println("@Override");
		writer.println("public void put(AbstractHreDataModel model) throws SQLException {");
		writer.println("ps = conn.prepareStatement(UPDATE);");

		for (int i = 0; i < fields.size(); i++) {
			writer.println("((" + toCamelCase(tableName) + ") model).set" + toCamelCase(fields.get(i)) + "(rs.get"
					+ toCamelCase(types.get(i)) + "(\"" + fields.get(i) + "\"));");
		}

		writer.println("ps.executeUpdate();");
		writer.println("}\r\n");
	}

	/**
	 * @throws IOException
	 * 
	 */
	private static void createFields() throws IOException {
		for (int i = 0; i < fields.size(); i++) {
			writer.println("private " + types.get(i) + " " + toCamelCase(fields.get(i)) + ";");
		}
		writer.println("private " + toCamelCase(tableName) + " model;\r\n");
	}

	/**
	 * @throws IOException
	 * 
	 */
	private static void createGetters() throws IOException {
		String field;
		String type;

		for (int i = 0; i < fields.size(); i++) {
			field = toCamelCase(fields.get(i));

			writer.println("/**");
			writer.println("* Get the " + field + " field.");
			writer.println("*");
			writer.println("* @return Contents of the " + fields.get(i) + " column");
			writer.println("*/");

			type = types.get(i);
			writer.println("public " + type + " get" + field + "() {");
			writer.println("return this." + field + ";");
			writer.println("}\r\n");
		}
	}

	/**
	 * @throws IOException
	 * 
	 */
	private static void createHeader() throws IOException {
		writer.println("package org.historyresearchenvironment.dataaccess.models;\r\n");
		writer.println("import java.sql.SQLException;");
		writer.println("import java.util.ArrayList;");
		writer.println("import java.util.List;\r\n");
		writer.println("/**");
		writer.println("* The persistent class for the " + tableName + " database table.");
		writer.println("*");

		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		final DateFormat yearFormat = new SimpleDateFormat("yyyy");
		final Date date = new Date();

		writer.println("* @version " + dateFormat.format(date));
		writer.println(
				"* @author H2ModelGenerator, &copy; History Research Environment Ltd., " + yearFormat.format(date));
		writer.println("*");
		writer.println("*/\r\n");
		writer.println("public class " + toCamelCase(tableName) + " extends AbstractHreDataModel {");
		writer.println("private static final long serialVersionUID = 1L;");
		writer.println("private ArrayList<AbstractHreDataModel> modelList;");
	}

	/**
	 * @throws IOException
	 * 
	 */
	private static void createSetters() throws IOException {
		String field;
		String type;

		for (int i = 0; i < fields.size(); i++) {
			field = toCamelCase(fields.get(i));

			writer.println("/**");
			writer.println("* Set the " + field + " field");
			writer.println("*");
			writer.println("* @param " + field + " Contents of the " + fields.get(i) + " column");
			writer.println("*/");

			type = types.get(i);
			writer.println("public void set" + field + "(" + type + " " + field + ") {");
			writer.println("this." + field + " = " + field + ";");
			writer.println("}\r\n");
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Usage: H2ModelGenerator <h2database> <tablename> <outputfile>");
			System.exit(16);
		}

		H2ModelGenerator generator = new H2ModelGenerator();
		databaseName = args[0];
		tableName = args[1].toUpperCase();
		outputDirectory = args[2];
		System.out.println(
				"Generating Model Class for table " + tableName + " in " + databaseName + " into " + outputDirectory);

		extracted(generator);
	}

	private static void extracted(H2ModelGenerator generator) {
		generator.generate();
	}

	/**
	 * @param init
	 * @return String in CamelCase
	 */
	private static String toCamelCase(final String init) {
		if (init == null) {
			return null;
		}

		if (init == "byte[]") {
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
	 * Constructor
	 */
	public H2ModelGenerator() {
	}

	/**
	 * @throws IOException
	 * 
	 */
	private static void createSql() throws IOException {
		System.out.println("Creating SQL statements");

		// SELECT
		writer.println("private static final String SELECT = \"SELECT \" +");

		for (int i = 0; i < (fields.size() - 1); i++) {
			writer.println("\"" + fields.get(i) + ", \" +");
		}

		writer.println("\"" + fields.get(fields.size() - 1) + " FROM PUBLIC." + tableName + " WHERE " + primaryKey
				+ " = ?\";\r\n");

		// SELECTALL
		writer.println("private static final String SELECTALL = \"SELECT \" +");

		for (int i = 0; i < (fields.size() - 1); i++) {
			writer.println("\"" + fields.get(i) + ", \" +  ");
		}

		writer.println("\"" + fields.get(fields.size() - 1) + " FROM PUBLIC." + tableName + "\";\r\n");

		// INSERT
		writer.println("private static final String INSERT = \"INSERT INTO PUBLIC." + tableName + "( \" +");

		for (int i = 0; i < (fields.size() - 1); i++) {
			writer.println("\"" + fields.get(i) + ", \" +     ");
		}

		writer.println("\"" + fields.get(fields.size() - 1) + ") VALUES (?, \" +");

		for (int i = 1; i < (fields.size() - 1); i++) {
			writer.println("\"?, \" +");
		}

		writer.println("\"?)\";\r\n");

		// UPDATE
		writer.println("private static final String UPDATE = \"UPDATE PUBLIC." + tableName + "SET \" +");

		String field;
		for (int i = 0; i < (fields.size() - 1); i++) {
			field = fields.get(i);
			if (field.equals(primaryKey)) {
				continue;
			}
			writer.println("\"" + field + " = ?, \" + ");
		}

		writer.println("\"" + fields.get(fields.size() - 1) + " = ? WHERE " + primaryKey + " = ?\";\r\n");

		// DELETE
		writer.println("private static final String DELETE = \"DELETE FROM PUBLIC." + tableName + " WHERE " + primaryKey
				+ " = ?\";\r\n");

		// DELETEALL
		writer.println("private static final String DELETEALL = \"DELETE FROM PUBLIC." + tableName + "\";\r\n");
	}

	/**
	 * 
	 */
	public void generate() {
		fields = new ArrayList<String>();
		types = new ArrayList<String>();
		final File outputFile = new File(outputDirectory + "/" + toCamelCase(tableName) + ".java");

		final boolean rc = outputFile.delete();

		if (rc) {
			System.out.println("File " + outputFile.getName() + " has been deleted");
		}

		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
			createHeader();

			final String connectionName = "jdbc:h2:" + databaseName;
			final Connection conn = DriverManager.getConnection(connectionName, "sa", "");

			final ResultSet pks = conn.getMetaData().getPrimaryKeys(null, null, tableName);

			if (pks.next()) {
				primaryKey = pks.getString(4);
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

				System.out.println("Column " + field + ", type " + type);

				if (field.equals(primaryKey)) {
					primaryKeyType = type;
				}
			}

			createSql();
			createFields();
			createConstructors();
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
			System.out.println("File " + outputFile.getName() + " has been generated");
		} catch (

		final SQLException | IOException e) {
			e.printStackTrace();
			System.exit(8);
		}
	}

	/**
	 * @param databaseName
	 *            the databaseName to set
	 */
	public void setDatabaseName(String databaseName) {
		H2ModelGenerator.databaseName = databaseName;
	}

	/**
	 * @param outputDirectory
	 *            the outputDirectory to set
	 */
	public void setOutputDirectory(String outputDirectory) {
		H2ModelGenerator.outputDirectory = outputDirectory;
	}

	/**
	 * @param tableName
	 *            the tableName to set
	 */
	public void setTableName(String tableName) {
		H2ModelGenerator.tableName = tableName;
	}
}