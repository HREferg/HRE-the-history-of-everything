package net.myerichsen.hremvp.person.wizards;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.wizard.Wizard;

import net.myerichsen.hremvp.person.providers.ParentProvider;

/**
 * Wizard to add an existing person as a parent
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 8. jun. 2019
 *
 */
public class NewPersonParentWizard extends Wizard {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;
	private final IEventBroker eventBroker;

	private NewPersonParentWizardPage1 page1;
	private final int childPid;

	/**
	 * Constructor
	 *
	 * @param childPid
	 * @param context  The Eclipse Context
	 *
	 */
	public NewPersonParentWizard(int childPid, IEclipseContext context) {
		setWindowTitle("Add Parent");
		setForcePreviousAndNextButtons(true);
		this.context = context;
		eventBroker = context.get(IEventBroker.class);
		this.childPid = childPid;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.Wizard#addPage(org.eclipse.jface.wizard.
	 * IWizardPage)
	 */
	@Override
	public void addPages() {
		page1 = new NewPersonParentWizardPage1(context);
		addPage(page1);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		if (page1.getParentPid() != 0) {
			final ParentProvider parentProvider = new ParentProvider();
			parentProvider.setChild(childPid);
			int parentPid = page1.getParentPid();
			parentProvider.setParent(parentPid);
			parentProvider.setParentRolePid(page1.getParentRolePid());
			parentProvider.setPrimaryParent(true);

			try {
				parentPid = parentProvider.insert();
				LOGGER.log(Level.INFO, "Inserted Parent pid {0} for child {1}",
						new Object[] { parentPid, childPid });

				eventBroker.post("MESSAGE", "Inserted Parent pid " + parentPid
						+ " for parent " + childPid);
				eventBroker.post(
						net.myerichsen.hremvp.Constants.PERSON_PID_UPDATE_TOPIC,
						childPid);
				return true;
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}

		}
		return false;
	}

}
