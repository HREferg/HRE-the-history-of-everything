package net.myerichsen.hremvp.person.wizards;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.wizard.Wizard;

import net.myerichsen.hremvp.person.providers.PartnerProvider;

/**
 * Wizard to add an existing person as a partner
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 8. jun. 2019
 *
 */
public class NewPersonPartnerWizard extends Wizard {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;
	private final IEventBroker eventBroker;

	private NewPersonPartnerWizardPage1 page1;
	private final int personPid;

	/**
	 * Constructor
	 *
	 * @param personPid
	 * @param context
	 */
	public NewPersonPartnerWizard(int personPid, IEclipseContext context) {
		setWindowTitle("Add Partner");
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
		page1 = new NewPersonPartnerWizardPage1(context);
		addPage(page1);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		if (page1.getPartnerPid() != 0) {
			final PartnerProvider partnerProvider = new PartnerProvider();
			partnerProvider.setPartner1(personPid);
			final int partnerPid = page1.getPartnerPid();
			partnerProvider.setPartner2(partnerPid);
			partnerProvider.setPrimaryPartner(true);
			partnerProvider.setPartnerRolePid(page1.getPartnerRolePid());
			partnerProvider.setFromDatePid(page1.getPartnerFromDatePid());
			partnerProvider.setToDatePid(page1.getPartnerToDatePid());

			try {
				partnerProvider.insert();
				LOGGER.log(Level.INFO,
						"Inserted partner pid {0} for person {1}",
						new Object[] { partnerPid, personPid });
				eventBroker.post("MESSAGE", "Inserted partner pid " + partnerPid
						+ " for person " + personPid);
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
