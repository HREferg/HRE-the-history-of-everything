package org.historyresearchenvironment.sample.providers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.historyresearchenvironment.dataaccess.models.AbstractHreDataModel;
import org.historyresearchenvironment.dataaccess.models.SubstnParamNames;
import org.historyresearchenvironment.dataaccess.models.SubstnParamValues;
import org.historyresearchenvironment.dataaccess.providers.AbstractHreProvider;

/**
 * Provide H2 data to the sample navigator.
 * 
 * @version 2018-08-05
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class SampleNavigatorProvider extends AbstractHreProvider {
	private List<SampleEditorProvider> modelList;
	private SampleEditorProvider model;

	/**
	 * Constructor
	 *
	 */
	public SampleNavigatorProvider() {
		modelList = new ArrayList<SampleEditorProvider>();
		readFromDatabase();

	}

	/**
	 * @param defltValue
	 * @param paramListKey
	 * @param paramSetKey
	 */
	public void add(String defltValue, short paramListKey, short paramSetKey) {
		model = new SampleEditorProvider();
		model.setDefltValue(defltValue);
		model.setParamListKey(paramListKey);
		model.setParamSetKey(paramSetKey);

		if (modelList == null) {
			modelList = new ArrayList<SampleEditorProvider>();
		}
		modelList.add(model);
	}

	/**
	 * @return
	 */
	public int getCount() {
		return modelList.size();
	}

	/**
	 * @return the modelList
	 */
	public List<SampleEditorProvider> getModelList() {
		return modelList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.historyresearchenvironment.dataaccess.providers.AbstractHreProvider#
	 * readFromDatabase()
	 */
	@Override
	public void readFromDatabase() {
		SubstnParamNames row;
		short paramSetKey;
		SubstnParamValues spv;

		try {
			SubstnParamNames spn = new SubstnParamNames();
			List<AbstractHreDataModel> dataModelList = spn.get();

			for (Iterator<AbstractHreDataModel> iterator = dataModelList.iterator(); iterator.hasNext();) {
				row = (SubstnParamNames) iterator.next();
				LOGGER.info("Row: " + row.getParamSetKey() + ", " + row.getDefltValue());
				paramSetKey = row.getParamSetKey();
				spv = new SubstnParamValues().get(paramSetKey);

				model = new SampleEditorProvider();
				model.setParamSetKey(paramSetKey);
				model.setDefltValue(row.getDefltValue());
				model.setParamListKey(spv.getParamListKey());
				modelList.add(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.severe(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.historyresearchenvironment.dataaccess.providers.AbstractHreProvider#
	 * readFromDatabase(int)
	 */
	@Override
	public void readFromDatabase(int i) {
		LOGGER.info("Does nothing");

	}

	/**
	 * @return
	 */
	public List<SampleEditorProvider> selectAll() {
		return modelList;
	}

	/**
	 * @param modelList
	 *            the modelList to set
	 */
	public void setModelList(List<SampleEditorProvider> modelList) {
		this.modelList = modelList;
	}

}
