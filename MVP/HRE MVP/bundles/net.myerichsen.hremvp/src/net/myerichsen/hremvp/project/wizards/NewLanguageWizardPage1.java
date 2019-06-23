package net.myerichsen.hremvp.project.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * Wizard page to define a new language for HRE
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 9. jun. 2019
 *
 */
public class NewLanguageWizardPage1 extends WizardPage {
	private Text textIsoCode;
	private Text textLabel;

	public NewLanguageWizardPage1() {
		super("New Language Wizard Page 1");
		setTitle("Language");
		setDescription("Add a language to this HRE project");
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(2, false));

		final Label lblIsoCode = new Label(container, SWT.NONE);
		lblIsoCode.setText("ISO Code");

		textIsoCode = new Text(container, SWT.BORDER);
		textIsoCode.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Label lblLanguageName = new Label(container, SWT.NONE);
		lblLanguageName.setText("Language name");

		textLabel = new Text(container, SWT.BORDER);
		textLabel.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}

	/**
	 * @return the textIsoCode
	 */
	public Text getTextIsoCode() {
		return textIsoCode;
	}

	/**
	 * @return the textLabel
	 */
	public Text getTextLabel() {
		return textLabel;
	}
}
