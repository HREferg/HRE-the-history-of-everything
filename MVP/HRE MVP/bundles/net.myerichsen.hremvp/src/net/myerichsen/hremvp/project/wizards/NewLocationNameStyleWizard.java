package net.myerichsen.hremvp.project.wizards;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.wizard.Wizard;

import net.myerichsen.hremvp.dbmodels.LocationNameMaps;
import net.myerichsen.hremvp.project.providers.DictionaryProvider;
import net.myerichsen.hremvp.project.providers.LocationNameStyleProvider;

/**
 * Wizard to add a location name style
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 22. apr. 2019
 *
 */
public class NewLocationNameStyleWizard extends Wizard {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEventBroker eventBroker;

	private NewLocationNameStyleWizardPage2 page2;
	private String styleName;
	private String namePartCount;
	private String isoCode;

	/**
	 * Constructor
	 *
	 * @param context
	 */
	public NewLocationNameStyleWizard(IEclipseContext context) {
		setWindowTitle("Add a location name style");
		setForcePreviousAndNextButtons(true);
		eventBroker = context.get(IEventBroker.class);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	public void addBackPages() {
		page2 = new NewLocationNameStyleWizardPage2();
		addPage(page2);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	@Override
	public void addPages() {
		final NewLocationNameStyleWizardPage1 page1 = new NewLocationNameStyleWizardPage1();
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

			// Insert a location name style
			final LocationNameStyleProvider provider = new LocationNameStyleProvider();
			provider.setIsoCode(isoCode);
			provider.setLabelPid(labelPid);
			final int locationNameStylePid = provider.insert();
			LOGGER.log(Level.INFO, "Inserted location name style {0}",
					locationNameStylePid);
			eventBroker.post("MESSAGE",
					"Inserted location name style " + locationNameStylePid);

			// Create a dictionary row for the name
			dp = new DictionaryProvider();
			dp.setIsoCode(isoCode);
			dp.setLabel(styleName);
			dp.setLabelPid(labelPid);
			dp.setLabelType("LOCATIONNAME");
			dp.insert();
			LOGGER.log(Level.INFO,
					"Inserted location name style \"{0}\" in dictionary",
					styleName);

			// Handle each table row in wizard page 2
			final List<List<String>> input = (List<List<String>>) page2
					.getTableViewer().getInput();
			LocationNameMaps map;

			for (int i = 0; i < input.size(); i++) {
				// Create a dictionary row
				dp = new DictionaryProvider();
				labelPid = dp.getNextLabelPid();

				dp.setIsoCode(isoCode);
				dp.setLabel(input.get(i).get(1));
				dp.setLabelPid(labelPid);
				dp.setLabelType("LOCATIONNAMEMAP");
				final int dictionaryPid = dp.insert();
				LOGGER.log(Level.INFO,
						"Inserted dictionary element {0}, {1}, \"{2}\", {3}",
						new Object[] { dictionaryPid, isoCode,
								input.get(i).get(1), labelPid });
				// Create a map row
				map = new LocationNameMaps();
				map.setLabelPid(labelPid);
				map.setLocationNameStylePid(locationNameStylePid);
				map.setPartNo(Integer.parseInt(input.get(i).get(0)));
				final int nameMapPid = map.insert();
				LOGGER.log(Level.INFO,
						"Inserted map element {0}, Part no. {1}, label pid {2}",
						new Object[] { nameMapPid, input.get(i).get(0),
								labelPid });
			}

			eventBroker.post(
					net.myerichsen.hremvp.Constants.LOCATION_NAME_STYLE_PID_UPDATE_TOPIC,
					locationNameStylePid);

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
