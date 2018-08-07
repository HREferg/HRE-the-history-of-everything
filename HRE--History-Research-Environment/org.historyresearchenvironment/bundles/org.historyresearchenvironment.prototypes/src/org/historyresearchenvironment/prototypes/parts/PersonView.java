package org.historyresearchenvironment.prototypes.parts;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.historyresearchenvironment.client.parts.AbstractHreGuiPart;
import org.historyresearchenvironment.prototypes.Constants;
import org.historyresearchenvironment.prototypes.businesslogic.PersonBusinessLogic;
import org.historyresearchenvironment.prototypes.providers.PersonViewProvider;

/**
 * Person view part.
 * 
 * @version 2018-08-07
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class PersonView extends AbstractHreGuiPart {
	private Text textBiosType;
	private Text textName1;
	private Text textName2;
	private Text textName3;
	private Label lblSex;
	private Combo comboSex;
	private ComboViewer comboViewer;
	private Label lblFatherNo;
	private Text textFatherNo;
	private Label lblMotherNo;
	private Text textMotherNo;
	private Composite composite;
	private Button btnOk;
	private PersonViewProvider provider;
	private PersonBusinessLogic businessLogic;

	public PersonView() {
		provider = new PersonViewProvider();
		businessLogic = new PersonBusinessLogic();
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(4, false));

		Label lblBiosType = new Label(parent, SWT.NONE);
		lblBiosType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblBiosType.setText("Bios Type");

		textBiosType = new Text(parent, SWT.BORDER);
		textBiosType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

		Label lblName = new Label(parent, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name");

		textName1 = new Text(parent, SWT.BORDER);
		textName1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		textName2 = new Text(parent, SWT.BORDER);
		textName2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		textName3 = new Text(parent, SWT.BORDER);
		textName3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		lblSex = new Label(parent, SWT.NONE);
		lblSex.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSex.setText("Sex");

		comboViewer = new ComboViewer(parent, SWT.NONE);
		comboSex = comboViewer.getCombo();
		comboSex.setItems(new String[] { "Male", "Female" });
		comboSex.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

		lblFatherNo = new Label(parent, SWT.NONE);
		lblFatherNo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFatherNo.setText("Father No.");

		textFatherNo = new Text(parent, SWT.BORDER);
		textFatherNo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

		lblMotherNo = new Label(parent, SWT.NONE);
		lblMotherNo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMotherNo.setText("Mother No.");

		textMotherNo = new Text(parent, SWT.BORDER);
		textMotherNo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

		btnOk = new Button(parent, SWT.NONE);
		btnOk.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 4, 1));
		btnOk.setText("OK");

		composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));
		composite.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 4, 1));

		callBusinessLayer("GET", provider, businessLogic, "1");
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
	}

	/**
	 * @param key
	 */
	@Inject
	@Optional
	private void subscribeKeyUpdateTopic(@UIEventTopic(Constants.PERSON_UPDATE_TOPIC) String key) {
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
		textBiosType.setText(provider.getBiosType());
	}
}