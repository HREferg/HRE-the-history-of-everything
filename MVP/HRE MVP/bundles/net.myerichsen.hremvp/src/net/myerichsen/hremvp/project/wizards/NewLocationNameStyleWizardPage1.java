package net.myerichsen.hremvp.project.wizards;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.listeners.NumericVerifyListener;
import net.myerichsen.hremvp.project.providers.LanguageProvider;

/**
 * Add a location name style wizard page
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 22. apr. 2019
 *
 */
public class NewLocationNameStyleWizardPage1 extends WizardPage {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	final IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");
	private Combo comboIsoCode;
	private Text textStyleName;
	private Text textNamePartCount;
	private List<List<String>> languageList;

	/**
	 * Constructor
	 *
	 * @param context
	 */
	public NewLocationNameStyleWizardPage1() {
		super("location name style wizard Page 1");
		setTitle("location name style");
		setDescription("Add static data for a new location name style");
	}

	/**
	 *
	 */
	protected void checkCompletedPage() {
		final String styleName = textStyleName.getText();
		final String namePartCount = textNamePartCount.getText();

		if ((styleName.length() > 0) && (namePartCount.length() > 0)) {
			final NewLocationNameStyleWizard wizard = (NewLocationNameStyleWizard) getWizard();
			wizard.setStyleName(styleName);
			wizard.setNamePartCount(namePartCount);
			final int selectionIndex = comboIsoCode.getSelectionIndex();
			wizard.setIsoCode(languageList.get(selectionIndex).get(1));
			setPageComplete(true);
			wizard.addBackPages();
			wizard.getContainer().updateButtons();
		} else {
			setPageComplete(false);
		}
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(2, false));

		final Label lblIsoCode = new Label(container, SWT.NONE);
		lblIsoCode.setText("ISO Code");

		comboIsoCode = new Combo(container, SWT.BORDER);
		comboIsoCode.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final LanguageProvider languageProvider = new LanguageProvider();
		try {
			languageList = languageProvider.getStringList();

			final int llsSize = languageList.size();
			final String[] singleArray = new String[llsSize];
			final String g = store.getString("GUILANGUAGE");
			int index = 0;

			for (int i = 0; i < llsSize; i++) {
				singleArray[i] = languageList.get(i).get(2);
				if (g.equals(languageList.get(i).get(1))) {
					index = i;
				}
			}

			comboIsoCode.setItems(singleArray);
			comboIsoCode.select(index);
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

		final Label lblStyleName = new Label(container, SWT.NONE);
		lblStyleName.setText("Style name");

		textStyleName = new Text(container, SWT.BORDER);
		textStyleName.addModifyListener(e -> checkCompletedPage());
		textStyleName.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Label lblNumberOfName = new Label(container, SWT.NONE);
		lblNumberOfName.setText("Number of name parts");

		textNamePartCount = new Text(container, SWT.BORDER);
		textNamePartCount.addModifyListener(e -> checkCompletedPage());
		textNamePartCount.addVerifyListener(new NumericVerifyListener());
		textNamePartCount.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		setPageComplete(false);
	}
}
