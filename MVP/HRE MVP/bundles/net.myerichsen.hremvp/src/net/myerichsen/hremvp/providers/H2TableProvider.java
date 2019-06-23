package net.myerichsen.hremvp.providers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IContentProvider;

import net.myerichsen.hremvp.IHREProvider;
import net.myerichsen.hremvp.databaseadmin.H2TableModel;
import net.myerichsen.hremvp.servers.H2TableServer;

/**
 * Provide H2 data to the table navigator and the table editor
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 31. maj 2019
 *
 */
public class H2TableProvider implements IContentProvider, IHREProvider {
	private final H2TableServer server;

	/**
	 * Constructor
	 *
	 * @param tableName Name of H2 table
	 * @throws SQLException An exception that provides information on a database
	 *                      access error or other errors
	 *
	 */
	public H2TableProvider(String tableName) throws SQLException {
		server = new H2TableServer(tableName);
	}

	/**
	 * Delete a row in the H2 table
	 *
	 * @param recordNum Key field
	 * @throws SQLException An exception that provides information on a database
	 *                      access error or other errors
	 */
	@Override
	public void delete(int recordNum) throws SQLException {
		server.delete(recordNum);
	}

	/**
	 * Delete all rows in the H2 table
	 *
	 * @throws SQLException An exception that provides information on a database
	 *                      access error or other errors
	 */
	public void deleteAll() throws SQLException {
		server.deleteAll();
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

	/**
	 * Get the count of columns in the H2 table
	 *
	 * @return The count
	 */
	public int getCount() {
		return server.getCount();
	}

	/**
	 * Get a list of models, each with column name, type, and optional value
	 *
	 * @return A list of columns
	 */
	public List<H2TableModel> getModelList() {
		return server.getModelList();
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
		return new ArrayList<>();
	}

	/**
	 * Import a CSV file into the H2 table
	 *
	 * @param fileName Name of the CSV file
	 * @return Number of rows imported
	 * @throws SQLException An exception that provides information on a database
	 *                      access error or other errors
	 */
	public int importCsv(String fileName) throws SQLException {
		return server.importCsv(fileName);
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

	/**
	 * Insert a row into the H2 table
	 *
	 * @param columns Number of columns in the row
	 * @throws SQLException An exception that provides information on a database
	 *                      access error or other errors
	 */
	public void insert(List<H2TableModel> columns) throws SQLException {
		server.insert(columns);
	}

	/**
	 * Insert multiple rows into the H2 table
	 *
	 * @param rows Number of rows inserted
	 * @throws SQLException An exception that provides information on a database
	 *                      access error or other errors
	 */
	public void insertSet(List<List<H2TableModel>> rows) throws SQLException {
		for (int i = 0; i < rows.size(); i++) {
			insert(rows.get(i));
		}
	}

	/**
	 * Select a single row from the H2 table
	 *
	 * @param recordNum Key field
	 * @return List of rows
	 * @throws SQLException An exception that provides information on a database
	 *                      access error or other errors
	 */
	public List<Object> select(int recordNum) throws SQLException {
		return server.select(recordNum);
	}

	/**
	 * Select all rows from the H2 table
	 *
	 * @return A list of rows
	 * @throws SQLException An exception that provides information on a database
	 *                      access error or other errors
	 */
	public List<List<Object>> selectAll() throws SQLException {
		return server.selectAll();
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

	/**
	 * Update a row in the H2 table
	 *
	 * @param columns A list of field values
	 *
	 * @throws SQLException An exception that provides information on a database
	 *                      access error or other errors
	 */
	public void update(List<H2TableModel> columns) throws SQLException {
		server.update(columns);
	}
}