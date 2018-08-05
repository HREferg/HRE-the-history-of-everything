package org.historyresearchenvironment.sample.providers;

import java.sql.SQLException;

import org.historyresearchenvironment.dataaccess.models.SubstnParamNames;
import org.historyresearchenvironment.dataaccess.models.SubstnParamValues;
import org.historyresearchenvironment.dataaccess.providers.AbstractHreProvider;

/**
 * @version 2018-08-03
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class SampleEditorProvider extends AbstractHreProvider {
	public String defltValue;
	public short paramListKey;
	public short paramSetKey;

	/**
	 * Constructor
	 * 
	 */
	public SampleEditorProvider() {
		super();
	}

	/**
	 * @return the defltValue
	 */
	public String getDefltValue() {
		return defltValue;
	}

	/**
	 * @return the paramListKey
	 */
	public short getParamListKey() {
		return paramListKey;
	}

	/**
	 * @return the paramSetKey
	 */
	public short getParamSetKey() {
		return paramSetKey;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.historyresearchenvironment.dataaccess.providers.AbstractHreProvider#
	 * readFromDatabase(int)
	 */
	@Override
	public void readFromDatabase(int paramSetKey) {
		try {
			this.paramSetKey = (short) paramSetKey;
			final SubstnParamNames spn = new SubstnParamNames().get(paramSetKey);
			final SubstnParamValues spv = new SubstnParamValues().get(paramSetKey);

			defltValue = spn.getDefltValue();
			paramListKey = spv.getParamListKey();

			LOGGER.info("Read " + paramSetKey + ", " + paramListKey + "," + defltValue + " from database");

		} catch (final Exception e) {
			e.printStackTrace();
			LOGGER.severe(e.getMessage());
		}

		try {
			conn.close();
		} catch (final SQLException e) {
			e.printStackTrace();
			LOGGER.severe(e.getClass() + ": " + e.getMessage() + " at line " + e.getStackTrace()[0].getLineNumber());
		}
	}

	/**
	 * @param defltValue
	 *            the defltValue to set
	 */
	public void setDefltValue(String defltValue) {
		this.defltValue = defltValue;
	}

	/**
	 * @param paramListKey
	 *            the paramListKey to set
	 */
	public void setParamListKey(short paramListKey) {
		this.paramListKey = paramListKey;
	}

	/**
	 * @param paramSetKey
	 *            the paramSetKey to set
	 */
	public void setParamSetKey(short paramSetKey) {
		this.paramSetKey = paramSetKey;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.historyresearchenvironment.dataaccess.providers.AbstractHreProvider#
	 * readFromDatabase()
	 */
	@Override
	public void readFromDatabase() {
		LOGGER.info("Does nothing");
	}
}
