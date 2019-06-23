package net.myerichsen.hremvp.project.wizards;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.listeners.NumericVerifyListener;
import net.myerichsen.hremvp.project.providers.LanguageProvider;
import net.myerichsen.hremvp.providers.HREComboLabelProvider;

/**
 * Add a person name style wizard page
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 7. jun. 2019
 *
 */
public class NewPersonNameStyleWizardPage1 extends WizardPage {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");
	private NewPersonNameStyleWizard wizard;
	private Text textStyleName;
	private Text textNamePartCount;
	private List<List<String>> stringList;
	private final LanguageProvider provider;
	private Combo comboLanguage;

	/**
	 * Constructor
	 *
	 * @param context The Eclipse context
	 */
	public NewPersonNameStyleWizardPage1(IEclipseContext context) {
		super("Person name style wizard page 1");
		setTitle("Person name style");
		setDescription("Add static data for a new person name style");
		provider = new LanguageProvider();
	}

	/**
	 *
	 */
	protected void checkCompletedPage() {
		final String styleName = textStyleName.getText();
		final String namePartCount = textNamePartCount.getText();

		if ((styleName.length() > 0) && (namePartCount.length() > 0)) {
			wizard = (NewPersonNameStyleWizard) getWizard();
			wizard.setStyleName(styleName);
			wizard.setNamePartCount(namePartCount);
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

		final Label lblLanguage = new Label(container, SWT.NONE);
		lblLanguage.setText("Language");

		final ComboViewer comboViewerLanguage = new ComboViewer(container,
				SWT.NONE);
		comboLanguage = comboViewerLanguage.getCombo();
		comboLanguage.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final int selectionIndex = comboLanguage.getSelectionIndex();
				wizard = (NewPersonNameStyleWizard) getWizard();
				wizard.setIsoCode(stringList.get(selectionIndex).get(1));
			}
		});

		comboViewerLanguage
				.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerLanguage.setLabelProvider(new HREComboLabelProvider(2));

		try {
			stringList = provider.getStringList();
			comboViewerLanguage.setInput(stringList);

			final int llsSize = stringList.size();
			final String g = store.getString("GUILANGUAGE");

			for (int i = 0; i < llsSize; i++) {
				if (g.equals(stringList.get(i).get(1))) {
					LOGGER.log(Level.INFO, "Selected language {0}, {1}",
							new Object[] { i, stringList.get(i).get(2) });
					comboLanguage.select(i);
					break;
				}
			}

		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

		comboLanguage.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

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
