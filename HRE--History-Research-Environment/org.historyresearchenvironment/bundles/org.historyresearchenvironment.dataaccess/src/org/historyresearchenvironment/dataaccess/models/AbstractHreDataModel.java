package org.historyresearchenvironment.dataaccess.models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.historyresearchenvironment.dataaccess.HreH2ConnectionPool;

/**
 * Abstract superclass for H2 data access models.
 * 
 * @version 2018-08-02
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public abstract class AbstractHreDataModel implements Serializable {
	private static final long serialVersionUID = 1L;
	protected final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	protected IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.historyresearchenvironment");
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected Connection conn;

	/**
	 * Constructor
	 *
	 * @throws SQLException
	 */
	public AbstractHreDataModel() throws SQLException {
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
	public abstract <E> List<AbstractHreDataModel> get() throws SQLException;

	/**
	 * Get a record.
	 * 
	 * @param key
	 * @return
	 * @throws SQLException
	 */
	public abstract AbstractHreDataModel get(int key) throws SQLException;

	/**
	 * Update a record.
	 * 
	 * @param model
	 * @throws SQLException
	 */
	public abstract void post(AbstractHreDataModel model) throws SQLException;

	/**
	 * Insert a record.
	 * 
	 * @param model
	 * @throws SQLException
	 */
	public abstract void put(AbstractHreDataModel model) throws SQLException;

}