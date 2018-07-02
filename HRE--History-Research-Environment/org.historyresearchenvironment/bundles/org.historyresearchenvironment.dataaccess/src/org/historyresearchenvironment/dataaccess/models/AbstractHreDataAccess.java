package org.historyresearchenvironment.dataaccess.models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.historyresearchenvironment.dataaccess.HreH2ConnectionPool;
import org.osgi.service.prefs.Preferences;

/**
 * Abstract superclass for H2 data access models.
 * 
 * @version 2018-06-30
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public abstract class AbstractHreDataAccess implements Serializable {
	private static final long serialVersionUID = 1L;
	protected final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	protected Preferences preferences = InstanceScope.INSTANCE.getNode("org.historyresearchenvironment");
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected Connection conn;

	/**
	 * Constructor
	 *
	 * @throws SQLException
	 */
	public AbstractHreDataAccess() throws SQLException {
		conn = HreH2ConnectionPool.getConnection();
	}

	/**
	 * Delete all records in the table.
	 * 
	 * @throws SQLException
	 */
	public abstract void delete() throws SQLException;

	/**
	 * Delete a record.
	 * 
	 * @param key
	 * @throws SQLException
	 */
	public abstract void delete(int key) throws SQLException;

	/**
	 * Get all records.
	 * 
	 * @param <E>
	 * 
	 * @return
	 * @throws SQLException
	 */
	public abstract <E> ArrayList<E> get() throws SQLException;

	/**
	 * Get a record.
	 * 
	 * @param key
	 * @return
	 * @throws SQLException
	 */
	public abstract AbstractHreDataAccess get(int key) throws SQLException;

	/**
	 * Update a record.
	 * 
	 * @param model
	 * @throws SQLException
	 */
	public abstract void post(AbstractHreDataAccess model) throws SQLException;

	/**
	 * Insert a record.
	 * 
	 * @param model
	 * @throws SQLException
	 */
	public abstract void put(AbstractHreDataAccess model) throws SQLException;

}