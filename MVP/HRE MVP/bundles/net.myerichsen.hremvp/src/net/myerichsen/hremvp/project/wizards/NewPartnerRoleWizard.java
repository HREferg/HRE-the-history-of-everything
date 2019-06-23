package net.myerichsen.hremvp.project.wizards;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.wizard.Wizard;

import net.myerichsen.hremvp.project.providers.DictionaryProvider;
import net.myerichsen.hremvp.project.providers.PartnerRoleProvider;

/**
 * Wizard to add an Partner role
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 9. jun. 2019
 *
 */
public class NewPartnerRoleWizard extends Wizard {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEventBroker eventBroker;

	private NewPartnerRoleWizardPage1 page1;

	/**
	 * Constructor
	 *
	 * @param context
	 */
	public NewPartnerRoleWizard(IEclipseContext context) {
		setWindowTitle("Add an Partner role");
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
		page1 = new NewPartnerRoleWizardPage1();
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
				PartnerRoleProvider provider = new PartnerRoleProvider();
				provider.setAbbreviation(abbreviation);

				final int PartnerRolePid = provider.insert();
				LOGGER.log(Level.INFO, "Inserted Partner role {0}",
						PartnerRolePid);
				eventBroker.post("MESSAGE",
						"Inserted Partner role " + PartnerRolePid);

				final int labelPid = provider.getLabelPid();

				final List<List<String>> input = (List<List<String>>) page1
						.getTableViewer().getInput();

				for (int i = 0; i < input.size(); i++) {
					dp = new DictionaryProvider();
					dp.setIsoCode(input.get(i).get(2));
					dp.setLabel(input.get(i).get(3));
					dp.setLabelPid(labelPid);
					dp.setLabelType("PartnerROLE");
					final int dictionaryPid = dp.insert();
					LOGGER.log(Level.INFO,
							"Inserted dictionary element {0}, {1}, {2}",
							new Object[] { dictionaryPid, input.get(i).get(2),
									input.get(i).get(3) });
				}

				eventBroker.post(
						net.myerichsen.hremvp.Constants.PARTNER_ROLE_PID_UPDATE_TOPIC,
						PartnerRolePid);
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
	public void setPartnerRolePid(int parseInt) {
		// TODO Auto-generated method stub

	}

}
