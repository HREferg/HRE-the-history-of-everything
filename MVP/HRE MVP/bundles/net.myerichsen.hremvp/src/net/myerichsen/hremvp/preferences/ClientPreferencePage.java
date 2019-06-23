package net.myerichsen.hremvp.preferences;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FontFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.project.providers.LanguageProvider;
import net.myerichsen.hremvp.project.providers.LocationNameStyleProvider;
import net.myerichsen.hremvp.project.providers.PersonNameStyleProvider;

/**
 * Preference page for HRE MVP client
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 4. apr. 2019
 *
 */
public class ClientPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {
	private static final String STANDALONE = "STANDALONE";
	private static final String SERVER = "SERVER";
	private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private ComboFieldEditor comboFieldEditorCsMode;
	private ComboFieldEditor comboFieldEditorLogLevel;

	/**
	 * Constructor
	 *
	 */
	public ClientPreferencePage() {
		super(GRID);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors
	 * ()
	 */
	@Override
	protected void createFieldEditors() {
		final Composite composite = getFieldEditorParent();

		comboFieldEditorCsMode = new ComboFieldEditor("CSMODE",
				"Client/Server Mode",
				new String[][] { { STANDALONE, STANDALONE },
						{ "CLIENT", "CLIENT" }, { SERVER, SERVER } },
				composite);
		addField(comboFieldEditorCsMode);

		addField(new StringFieldEditor("LOGFILEPATH", "MVP Log File Path", -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, composite));
		comboFieldEditorLogLevel = new ComboFieldEditor("LOGLEVEL",
				"MVP Log Level",
				new String[][] { { "OFF", "OFF" }, { "SEVERE", "SEVERE" },
						{ "WARNING", "WARNING" }, { "INFO", "INFO" },
						{ "CONFIG", "CONFIG" }, { "FINE", "FINE" },
						{ "FINER", "FINER" }, { "FINEST", "FINEST" },
						{ "ALL", "ALL" } },
				composite);
		addField(comboFieldEditorLogLevel);

		final FontFieldEditor fontFieldEditor = new FontFieldEditor("HREFONT",
				"Font Selection", null, getFieldEditorParent());
		addField(fontFieldEditor);

		final StringFieldEditor updateSiteFieldEditor = new StringFieldEditor(
				"UPDATESITE", "HRE Update Site", -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE,
				getFieldEditorParent());
		addField(updateSiteFieldEditor);

		final IntegerFieldEditor helpportIntegerFieldEditor = new IntegerFieldEditor(
				"HELPSYSTEMPORT", "Port number for Help System",
				getFieldEditorParent());
		addField(helpportIntegerFieldEditor);

		final IntegerFieldEditor serverportIntegerFieldEditor = new IntegerFieldEditor(
				"SERVERPORT", "Port Number for local HRE Server",
				getFieldEditorParent());
		addField(serverportIntegerFieldEditor);

		final String[][] entryNamesAndValues = {
				{ "Not defined yet", "Not defined yet" } };

		try {
			final LanguageProvider languageProvider = new LanguageProvider();
			final List<List<String>> languageList = languageProvider
					.getStringList();

			final int llsSize = languageList.size();
			final String[][] doubleArray = new String[llsSize][2];

			for (int i = 0; i < llsSize; i++) {
				doubleArray[i][0] = languageList.get(i).get(2);
				doubleArray[i][1] = languageList.get(i).get(1);
			}

			final ComboFieldEditor comboGuiLanguage = new ComboFieldEditor(
					"GUILANGUAGE", "GUI Language", doubleArray,
					getFieldEditorParent());
			addField(comboGuiLanguage);
		} catch (final Exception e) {
			addField(new ComboFieldEditor("", "GUI Language",
					entryNamesAndValues, getFieldEditorParent()));
		}

		try {
			final PersonNameStyleProvider pnsp = new PersonNameStyleProvider();
			final List<List<String>> personNameStyleList = pnsp.getStringList();

			final int llsSize = personNameStyleList.size();
			final String[][] doubleArray = new String[llsSize][2];

			for (int i = 0; i < llsSize; i++) {
				doubleArray[i][0] = personNameStyleList.get(i).get(2);
				doubleArray[i][1] = personNameStyleList.get(i).get(1);
			}

			final ComboFieldEditor comboPersonNameStyle = new ComboFieldEditor(
					"DEFAULTPERSONNAMESTYLE", "Default Person Name Style",
					doubleArray, getFieldEditorParent());
			addField(comboPersonNameStyle);
		} catch (final Exception e) {
			addField(new ComboFieldEditor("", "Default Person Name Style",
					entryNamesAndValues, getFieldEditorParent()));
		}

		try {
			final LocationNameStyleProvider lnsp = new LocationNameStyleProvider();
			final List<List<String>> locationNameStyleList = lnsp
					.getStringList();

			final int llsSize = locationNameStyleList.size();
			final String[][] doubleArray = new String[llsSize][2];

			for (int i = 0; i < llsSize; i++) {
				doubleArray[i][0] = locationNameStyleList.get(i).get(2);
				doubleArray[i][1] = locationNameStyleList.get(i).get(1);
			}

			final ComboFieldEditor comboLocationNameStyle = new ComboFieldEditor(
					"DEFAULTLOCATIONNAMESTYLE", "Default Location Name Style",
					doubleArray, getFieldEditorParent());
			addField(comboLocationNameStyle);
		} catch (final Exception e) {
			addField(new ComboFieldEditor("", "Default Location Name Style",
					entryNamesAndValues, getFieldEditorParent()));
		}

		addField(new StringFieldEditor("GOOGLEAPIKEY", "Google API Key", -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE,
				getFieldEditorParent()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.jface.preference.FieldEditorPreferencePage#propertyChange(
	 * org. eclipse.jface.util.PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		final IPreferenceStore store = new ScopedPreferenceStore(
				InstanceScope.INSTANCE, "net.myerichsen.hremvp");

		super.propertyChange(event);

		if (event.getSource() == comboFieldEditorCsMode) {
			final String newValue = event.getNewValue().toString();

			if ((newValue.equals(STANDALONE)) || (newValue.equals(SERVER))) {
				final String dbName = store.getString("DBNAME");
				final String userId = store.getString("USERID");
				final String passWord = store.getString("PASSWORD");

				Connection conn = null;
				try {
					conn = DriverManager.getConnection("jdbc:h2:" + dbName,
							userId, passWord);
				} catch (final Exception e) {
					LOGGER.severe(e.getClass() + " " + e.getMessage());
				}
				LOGGER.log(Level.INFO, "Changed property "
						+ comboFieldEditorCsMode.getPreferenceName() + " from "
						+ event.getOldValue() + " to " + event.getNewValue());
				LOGGER.log(Level.INFO, "Database connection {0}", conn);
			}
		} else if (event.getSource() == comboFieldEditorLogLevel) {
			LOGGER.setLevel(Level.parse(event.getNewValue().toString()));

			LOGGER.log(Level.INFO, "Changed property "
					+ comboFieldEditorLogLevel.getPreferenceName() + " from "
					+ event.getOldValue() + " to " + event.getNewValue());
		}
	}

}
