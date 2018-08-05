package org.historyresearchenvironment.sample.parts;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.historyresearchenvironment.client.listeners.NumericVerifyListener;
import org.historyresearchenvironment.client.parts.AbstractHreGuiPart;
import org.historyresearchenvironment.sample.businesslogic.SampleBusinessLogic;
import org.historyresearchenvironment.sample.providers.SampleEditorProvider;

/**
 * View part for the sample.
 * 
 * @version 2018-08-05
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class SampleEditorView extends AbstractHreGuiPart {
	SampleEditorProvider provider;
	SampleBusinessLogic businessLogic;
	private Text textparamSetKey;
	private Text textDefltValue;
	private Text textparamListKey;

	/**
	 * Constructor
	 *
	 */
	public SampleEditorView() {
		provider = new SampleEditorProvider();
		businessLogic = new SampleBusinessLogic();
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(2, false));

		final Label lblNewLabel = new Label(parent, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblNewLabel.setText("Parameter Set Key");

		textparamSetKey = new Text(parent, SWT.BORDER);
		textparamSetKey.addVerifyListener(new NumericVerifyListener());
		textparamSetKey.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Label lblDefaultValue = new Label(parent, SWT.NONE);
		lblDefaultValue.setText("Default Value");

		textDefltValue = new Text(parent, SWT.BORDER);
		textDefltValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblParameterListKey = new Label(parent, SWT.NONE);
		lblParameterListKey.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblParameterListKey.setText("Parameter List Key");

		textparamListKey = new Text(parent, SWT.BORDER);
		textparamListKey.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		callBusinessLayer("GET", provider, businessLogic, "1");
	}

	/**
	 * 
	 */
	@PreDestroy
	public void dispose() {
	}

	/**
	 * 
	 */
	@Focus
	public void setFocus() {
	}

	/**
	 * @param key
	 */
	@Inject
	@Optional
	private void subscribeKeyUpdateTopic(
			@UIEventTopic(org.historyresearchenvironment.sample.client.Constants.PARAMETER_SET_KEY_UPDATE_TOPIC) String key) {
		LOGGER.info("Updating to " + key);
		callBusinessLayer("GET", provider, businessLogic, key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.historyresearchenvironment.client.parts.AbstractHreGuiPart#updateGui()
	 */
	@Override
	protected void updateGui() {
		textparamListKey.setText(Integer.toString(provider.getParamListKey()));
		textparamSetKey.setText(Integer.toString(provider.getParamSetKey()));
		textDefltValue.setText(provider.getDefltValue());
	}

}
