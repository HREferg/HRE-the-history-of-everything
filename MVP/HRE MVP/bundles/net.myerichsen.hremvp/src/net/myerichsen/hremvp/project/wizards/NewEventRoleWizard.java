package net.myerichsen.hremvp.project.wizards;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.wizard.Wizard;

import net.myerichsen.hremvp.project.providers.DictionaryProvider;
import net.myerichsen.hremvp.project.providers.EventRoleProvider;

/**
 * Wizard to add an event role
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 9. jun. 2019
 *
 */
public class NewEventRoleWizard extends Wizard {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEventBroker eventBroker;

	private NewEventRoleWizardPage1 page1;
	private int eventTypePid = 0;

	/**
	 * Constructor
	 *
	 * @param eventRolePid
	 *
	 * @param context
	 */
	public NewEventRoleWizard(IEclipseContext context) {
		setWindowTitle("Add an event role");
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
		page1 = new NewEventRoleWizardPage1();
		addPage(page1);
	}

	/**
	 * @return the eventTypePid
	 */
	public int getEventTypePid() {
		return eventTypePid;
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
				EventRoleProvider provider = new EventRoleProvider();
				provider.setAbbreviation(abbreviation);
				provider.setEventTypePid(eventTypePid);

				final int eventRolePid = provider.insert();
				LOGGER.log(Level.INFO, "Inserted event role {0}", eventRolePid);
				eventBroker.post("MESSAGE",
						"Inserted event role " + eventRolePid);

				final int labelPid = provider.getLabelPid();

				final List<List<String>> input = (List<List<String>>) page1
						.getTableViewer().getInput();

				for (int i = 0; i < input.size(); i++) {
					dp = new DictionaryProvider();
					dp.setIsoCode(input.get(i).get(2));
					dp.setLabel(input.get(i).get(3));
					dp.setLabelPid(labelPid);
					dp.setLabelType("EVENTROLE");
					final int dictionaryPid = dp.insert();
					LOGGER.log(Level.INFO,
							"Inserted dictionary element {0}, {1}, {2}",
							new Object[] { dictionaryPid, input.get(i).get(2),
									input.get(i).get(3) });
				}

				eventBroker.post(
						net.myerichsen.hremvp.Constants.EVENT_ROLE_PID_UPDATE_TOPIC,
						eventRolePid);
				return true;
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}

		}

		return false;
	}

	/**
	 * @param parseInt
	 */
	public void setEventRolePid(int parseInt) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param eventTypePid the eventTypePid to set
	 */
	public void setEventTypePid(int eventTypePid) {
		this.eventTypePid = eventTypePid;
	}

}
