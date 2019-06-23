package net.myerichsen.hremvp.person.wizards;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.wizard.Wizard;

import net.myerichsen.hremvp.person.providers.ParentProvider;

/**
 * Wizard to add an existing person as a child
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 8. jun. 2019
 *
 */
public class NewPersonChildWizard extends Wizard {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;
	private final IEventBroker eventBroker;

	private NewPersonChildWizardPage1 page1;
	private final int personPid;

	/**
	 * Constructor
	 *
	 * @param personPid
	 * @param context
	 */
	public NewPersonChildWizard(int personPid, IEclipseContext context) {
		setWindowTitle("Add a child");
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
		page1 = new NewPersonChildWizardPage1(context);
		addPage(page1);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		if (page1.getChildPid() != 0) {
			final ParentProvider parentProvider = new ParentProvider();
			parentProvider.setParent(personPid);
			final int childPid = page1.getChildPid();
			parentProvider.setChild(childPid);
			parentProvider.setChildRolePid(page1.getChildRolePid());
			parentProvider.setPrimaryParent(true);

			try {
				parentProvider.insert();
				LOGGER.log(Level.INFO, "Inserted child pid {0} for parent {1}",
						new Object[] { childPid, personPid });
				eventBroker.post("MESSAGE", "Inserted child pid " + childPid
						+ " for parent " + personPid);
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
