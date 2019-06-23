package net.myerichsen.hremvp.person.wizards;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.wizard.Wizard;

import net.myerichsen.hremvp.person.providers.SexProvider;

/**
 * Wizard to add a sex to a person
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 28. apr. 2019
 *
 */
public class NewPersonSexWizard extends Wizard {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;
	private final IEventBroker eventBroker;

	private NewPersonSexWizardPage1 page1;
	private final int personPid;

	/**
	 * Constructor
	 *
	 * @param personPid
	 * @param context
	 */
	public NewPersonSexWizard(int personPid, IEclipseContext context) {
		setWindowTitle("Add a sex");
		setForcePreviousAndNextButtons(true);
		this.context = context;
		eventBroker = context.get(IEventBroker.class);
		this.personPid = personPid;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.Wizard#addPage(org.eclipse.jface.wizard.
	 * IWizardPage)
	 */
	@Override
	public void addPages() {
		page1 = new NewPersonSexWizardPage1(context);
		addPage(page1);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		final int sexTypePid = page1.getSexTypePid();

		if (sexTypePid > 0) {
			final SexProvider sexProvider = new SexProvider();
			sexProvider.setPersonPid(personPid);
			sexProvider.setSexTypePid(sexTypePid);
			sexProvider.setPrimarySex(page1.isPrimary());

			sexProvider.setFromDatePid(page1.getFromDatePid());
			sexProvider.setToDatePid(page1.getToDatePid());
			try {
				final int sexPid = sexProvider.insert();

				LOGGER.log(Level.INFO,
						"Inserted sex {0} for person {1} with {2} to {3}",
						new Object[] { sexPid, personPid,
								page1.getFromDatePid(), page1.getToDatePid() });

				eventBroker.post("MESSAGE",
						"Inserted sex " + sexPid + " for person " + personPid);
				eventBroker.post(
						net.myerichsen.hremvp.Constants.PERSON_PID_UPDATE_TOPIC,
						personPid);
				return true;
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}

		}
		return false;
	}

}
