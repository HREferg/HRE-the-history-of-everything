package net.myerichsen.hremvp.project.wizards;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.wizard.Wizard;

import net.myerichsen.hremvp.project.providers.DictionaryProvider;
import net.myerichsen.hremvp.project.providers.EventTypeProvider;

/**
 * Wizard to add a event type
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 9. jun. 2019
 *
 */
public class NewEventTypeWizard extends Wizard {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEventBroker eventBroker;

	private NewEventTypeWizardPage1 page1;

	/**
	 * Constructor
	 *
	 * @param context
	 */
	public NewEventTypeWizard(IEclipseContext context) {
		setWindowTitle("Add an event type");
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
		page1 = new NewEventTypeWizardPage1();
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
				EventTypeProvider provider = new EventTypeProvider();
				provider.setAbbreviation(abbreviation);

				final int eventTypePid = provider.insert();
				LOGGER.log(Level.INFO, "Inserted event type {0}", eventTypePid);
				eventBroker.post("MESSAGE",
						"Inserted event type " + eventTypePid);

				final int labelPid = provider.getLabelPid();

				final List<List<String>> input = (List<List<String>>) page1
						.getTableViewer().getInput();

				for (int i = 0; i < input.size(); i++) {
					dp = new DictionaryProvider();
					dp.setIsoCode(input.get(i).get(2));
					dp.setLabel(input.get(i).get(3));
					dp.setLabelPid(labelPid);
					dp.setLabelType("EVENT");
					final int dictionaryPid = dp.insert();
					LOGGER.log(Level.INFO,
							"Inserted dictionary element {0}, {1}, {2}",
							new Object[] { dictionaryPid, input.get(i).get(2),
									input.get(i).get(3) });
				}

				eventBroker.post(
						net.myerichsen.hremvp.Constants.EVENT_TYPE_PID_UPDATE_TOPIC,
						eventTypePid);
				return true;
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}

		}

		return false;
	}

}
