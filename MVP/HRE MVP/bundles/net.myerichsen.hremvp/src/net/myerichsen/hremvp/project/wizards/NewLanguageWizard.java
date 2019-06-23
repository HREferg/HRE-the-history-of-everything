package net.myerichsen.hremvp.project.wizards;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.wizard.Wizard;

import net.myerichsen.hremvp.project.providers.LanguageProvider;

/**
 * Wizard to add a language for HRE
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 9. jun. 2019
 *
 */
public class NewLanguageWizard extends Wizard {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEventBroker eventBroker;

	private NewLanguageWizardPage1 page1;

	/**
	 * Constructor
	 *
	 * @param context
	 */
	public NewLanguageWizard(IEclipseContext context) {
		setWindowTitle("Add a language");
		setForcePreviousAndNextButtons(true);
		eventBroker = context.get(IEventBroker.class);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.Wizard#addPage(org.eclipse.jface.wizard.
	 * IWizardPage)
	 */
	@Override
	public void addPages() {
		page1 = new NewLanguageWizardPage1();
		addPage(page1);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		final String isoCode = page1.getTextIsoCode().getText();
		final String label = page1.getTextLabel().getText();

		if ((!isoCode.equals("")) && (!label.equals(""))) {
			LanguageProvider provider = new LanguageProvider();
			provider.setIsocode(isoCode);
			provider.setLabel(label);
			try {
				final int languagePid = provider.insert();
				LOGGER.log(Level.INFO, "Inserted language pid {0}, {1}",
						new Object[] { languagePid, label });
				eventBroker.post("MESSAGE",
						"Inserted language pid " + languagePid + ", " + label);
				eventBroker.post(
						net.myerichsen.hremvp.Constants.LANGUAGE_PID_UPDATE_TOPIC,
						languagePid);
				return true;
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}

		}
		return false;
	}

}
