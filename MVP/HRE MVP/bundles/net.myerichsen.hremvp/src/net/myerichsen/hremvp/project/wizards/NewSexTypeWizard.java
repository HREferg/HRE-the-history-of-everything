package net.myerichsen.hremvp.project.wizards;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.wizard.Wizard;

import net.myerichsen.hremvp.project.providers.DictionaryProvider;
import net.myerichsen.hremvp.project.providers.SexTypeProvider;

/**
 * Wizard to add a sex type
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 9. jun. 2019
 *
 */
public class NewSexTypeWizard extends Wizard {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEventBroker eventBroker;

	private NewSexTypeWizardPage1 page1;

	/**
	 * Constructor
	 *
	 * @param context
	 */
	public NewSexTypeWizard(IEclipseContext context) {
		setWindowTitle("Add a sex type");
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
		page1 = new NewSexTypeWizardPage1();
		addPage(page1);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean performFinish() {
		DictionaryProvider dp;
		final String abbreviation = page1.getTextAbbreviation().getText();

		if (!abbreviation.equals("")) {
			try {
				final SexTypeProvider provider = new SexTypeProvider();
				provider.setAbbreviation(abbreviation);

				final int sexTypePid = provider.insert();
				LOGGER.log(Level.INFO, "Inserted sex type {0}", sexTypePid);
				eventBroker.post("MESSAGE", "Inserted sex type " + sexTypePid);

				final int labelPid = provider.getLabelPid();

				final List<List<String>> input = (List<List<String>>) page1
						.getTableViewer().getInput();

				for (int i = 0; i < input.size(); i++) {
					dp = new DictionaryProvider();
					dp.setIsoCode(input.get(i).get(2));
					dp.setLabel(input.get(i).get(3));
					dp.setLabelPid(labelPid);
					dp.setLabelType("SEX");
					// FIXME SEVERE: org.h2.jdbc.JdbcSQLException: NULL not
					// allowed for column "LABEL"; SQL statement:
					// INSERT INTO PUBLIC.DICTIONARY( DICTIONARY_PID, LABEL_PID,
					// ISO_CODE, LABEL, INSERT_TSTMP, UPDATE_TSTMP, TABLE_ID,
					// LABEL_TYPE) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP,
					// CURRENT_TIMESTAMP, 6, ?) [23502-168]

					final int dictionaryPid = dp.insert();
					LOGGER.log(Level.INFO,
							"Inserted dictionary element {0}, {1}, {2}",
							new Object[] { dictionaryPid, input.get(i).get(2),
									input.get(i).get(3) });
				}

				eventBroker.post(
						net.myerichsen.hremvp.Constants.SEX_TYPE_PID_UPDATE_TOPIC,
						sexTypePid);
				return true;
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}

		}

		return false;
	}

}
