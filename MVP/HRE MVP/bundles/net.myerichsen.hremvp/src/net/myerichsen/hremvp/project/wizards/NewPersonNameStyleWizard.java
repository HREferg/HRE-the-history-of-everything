package net.myerichsen.hremvp.project.wizards;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.wizard.Wizard;

import net.myerichsen.hremvp.dbmodels.PersonNameMaps;
import net.myerichsen.hremvp.project.providers.DictionaryProvider;
import net.myerichsen.hremvp.project.providers.PersonNameStyleProvider;

/**
 * Wizard to add a person name style
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 9. jun. 2019
 *
 */
public class NewPersonNameStyleWizard extends Wizard {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;
	private final IEventBroker eventBroker;

	private NewPersonNameStyleWizardPage2 page2;
	private String styleName;
	private String namePartCount;
	private String isoCode;

	/**
	 * Constructor
	 *
	 * @param personNameStylePid
	 * @param context
	 */
	public NewPersonNameStyleWizard(IEclipseContext context) {
		setWindowTitle("Add a person name style");
		setForcePreviousAndNextButtons(true);
		this.context = context;
		eventBroker = context.get(IEventBroker.class);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	public void addBackPages() {
		page2 = new NewPersonNameStyleWizardPage2();
		addPage(page2);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	@Override
	public void addPages() {
		NewPersonNameStyleWizardPage1 page1 = new NewPersonNameStyleWizardPage1(context);
		addPage(page1);
	}

	/**
	 * @return the isoCode
	 */
	public String getIsoCode() {
		return isoCode;
	}

	/**
	 * @return the namePartCount
	 */
	public String getNamePartCount() {
		return namePartCount;
	}

	/**
	 * @return the styleName
	 */
	public String getStyleName() {
		return styleName;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.IWizard#canFinish()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean performFinish() {
		if ((styleName.length() == 0) || (namePartCount.length() == 0)
				|| (Integer.parseInt(namePartCount) == 0)) {
			return false;
		}

		// Get next label pid
		try {
			DictionaryProvider dp = new DictionaryProvider();
			int labelPid = dp.getNextLabelPid();

			// Insert a person name style
			PersonNameStyleProvider provider = new PersonNameStyleProvider();
			provider.setIsoCode(isoCode);
			provider.setLabelPid(labelPid);
			final int personNameStylePid = provider.insert();
			LOGGER.log(Level.INFO, "Inserted person name style {0}",
					personNameStylePid);
			eventBroker.post("MESSAGE",
					"Inserted person name style " + personNameStylePid);

			// Create a dictionary row for the name
			dp = new DictionaryProvider();
			dp.setIsoCode(isoCode);
			dp.setLabel(styleName);
			dp.setLabelPid(labelPid);
			dp.setLabelType("PERSONNAME");
			dp.insert();
			LOGGER.log(Level.INFO,
					"Inserted person name style \"{0}\" in dictionary",
					styleName);

			// Handle each table row in wizard page 2
			final List<List<String>> input = (List<List<String>>) page2
					.getTableViewer().getInput();
			PersonNameMaps map;

			for (int i = 0; i < input.size(); i++) {
				// Create a dictionary row
				dp = new DictionaryProvider();
				labelPid = dp.getNextLabelPid();

				dp.setIsoCode(isoCode);
				dp.setLabel(input.get(i).get(1));
				dp.setLabelPid(labelPid);
				dp.setLabelType("PERSONNAMEMAP");
				final int dictionaryPid = dp.insert();
				LOGGER.log(Level.INFO,
						"Inserted dictionary element {0}, {1}, {2}",
						new Object[] { dictionaryPid, input.get(i).get(2),
								input.get(i).get(3) });

				// Create a map row
				map = new PersonNameMaps();
				map.setLabelPid(labelPid);
				map.setNameStylePid(personNameStylePid);
				map.setPartNo(Integer.parseInt(input.get(i).get(0)));
				final int nameMapPid = map.insert();
				LOGGER.log(Level.INFO,
						"Inserted map element {0}, Part no. {1}, label pid {2}",
						new Object[] { nameMapPid, input.get(i).get(0),
								labelPid });
			}

			eventBroker.post(
					net.myerichsen.hremvp.Constants.PERSON_NAME_STYLE_PID_UPDATE_TOPIC,
					personNameStylePid);

			return true;

		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

		return false;
	}

	/**
	 * @param isoCode the isoCode to set
	 */
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	/**
	 * @param namePartCount the namePartCount to set
	 */
	public void setNamePartCount(String namePartCount) {
		this.namePartCount = namePartCount;
	}

	/**
	 * @param styleName the styleName to set
	 */
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

}
