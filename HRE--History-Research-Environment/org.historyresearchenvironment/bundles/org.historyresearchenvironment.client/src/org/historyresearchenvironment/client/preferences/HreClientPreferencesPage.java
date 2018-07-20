package org.historyresearchenvironment.client.preferences;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FontFieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Composite;
import org.historyresearchenvironment.dataaccess.HreH2ConnectionPool;
import org.osgi.service.prefs.Preferences;

/**
 * General client preferences page.
 * 
 * @version 2018-07-20
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class HreClientPreferencesPage extends FieldEditorPreferencePage {
	private final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private ComboFieldEditor comboFieldEditorCsMode;
	private ComboFieldEditor comboFieldEditorLogLevel;
	private FontFieldEditor fontFieldEditor;
	private StringFieldEditor updateSiteFieldEditor;
	private IntegerFieldEditor helpportIntegerFieldEditor;
	private IntegerFieldEditor serverportIntegerFieldEditor;
	private ComboFieldEditor comboFieldEditorH2TraceLevel;
	private DirectoryFieldEditor logfileDirectoryEditor;

	/**
	 * Constructor
	 * 
	 * @wbp.parser.constructor
	 *
	 */
	public HreClientPreferencesPage() {
		super(GRID);
	}

	/**
	 * Constructor
	 *
	 * @param style
	 */
	public HreClientPreferencesPage(int style) {
		super(style);
	}

	/**
	 * Constructor
	 *
	 * @param title
	 * @param image
	 * @param style
	 */
	public HreClientPreferencesPage(String title, ImageDescriptor image, int style) {
		super(title, image, style);
	}

	/**
	 * Constructor
	 *
	 * @param title
	 * @param style
	 */
	public HreClientPreferencesPage(String title, int style) {
		super(title, style);
	}

	@Override
	protected void createFieldEditors() {
		comboFieldEditorCsMode = new ComboFieldEditor("CSMODE", "Client/Server Mode", new String[][] {
				{ "DIRECT (Not using TCP/IP)", "DIRECT" }, { "SERVER (Call using TCP/IP)", "SERVER" } },
				getFieldEditorParent());

		addField(comboFieldEditorCsMode);

		final Composite composite = getFieldEditorParent();
		final StringFieldEditor stringFieldEditorUserid = new StringFieldEditor("USERID", "H2 User Id", -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, composite);
		stringFieldEditorUserid.getTextControl(composite).setText("sa");
		addField(stringFieldEditorUserid);

		final StringFieldEditor stringFieldEditorPassword = new StringFieldEditor("PASSWORD", "H2 Password", -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent());
		stringFieldEditorPassword.getTextControl(getFieldEditorParent()).setEchoChar('*');
		addField(stringFieldEditorPassword);

		comboFieldEditorH2TraceLevel = new ComboFieldEditor("H2TRACELEVEL", "H2 Trace Level",
				new String[][] { { "OFF", "OFF" }, { "ERROR", "ERROR" }, { "INFO", "INFO" }, { "DEBUG", "DEBUG" } },
				getFieldEditorParent());
		addField(comboFieldEditorH2TraceLevel);

		comboFieldEditorLogLevel = new ComboFieldEditor("LOGLEVEL", "Application Log Level",
				new String[][] { { "OFF", "OFF" }, { "SEVERE", "SEVERE" }, { "WARNING", "WARNING" }, { "INFO", "INFO" },
						{ "CONFIG", "CONFIG" }, { "FINE", "FINE" }, { "FINER", "FINER" }, { "FINEST", "FINEST" },
						{ "ALL", "ALL" } },
				getFieldEditorParent());
		addField(comboFieldEditorLogLevel);

		logfileDirectoryEditor = new DirectoryFieldEditor("LOGFILEPATH", "Application Log File Directory",
				getFieldEditorParent());
		addField(logfileDirectoryEditor);

		fontFieldEditor = new FontFieldEditor("HREFONT", "Font Selection", null, getFieldEditorParent());
		addField(fontFieldEditor);

		updateSiteFieldEditor = new StringFieldEditor("UPDATESITE", "HRE Update Site", -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent());
		addField(updateSiteFieldEditor);

		helpportIntegerFieldEditor = new IntegerFieldEditor("HELPSYSTEMPORT", "Port number for Help System",
				getFieldEditorParent());
		addField(helpportIntegerFieldEditor);

		serverportIntegerFieldEditor = new IntegerFieldEditor("SERVERPORT", "Port Number for local HRE Server",
				getFieldEditorParent());
		addField(serverportIntegerFieldEditor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.preference.FieldEditorPreferencePage#propertyChange(org.
	 * eclipse.jface.util.PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);

		LOGGER.info(
				"Changed property: " + event.getSource() + ", " + event.getOldValue() + " to " + event.getNewValue());
		final Preferences iep = InstanceScope.INSTANCE.getNode("org.historyresearchenvironment");

		if (event.getSource() == comboFieldEditorCsMode) {
			final String newValue = event.getNewValue().toString();
			iep.put("CSMODE", newValue);

			LOGGER.info("New Value: " + newValue + ", From preferences: " + iep.get("CSMODE", "?"));

			if ((newValue.equals("DIRECT")) || (newValue.equals("SERVER"))) {

				final String dbName = iep.get("DBNAME", "./SAMPLE");
				final String userId = iep.get("USERID", "sa");
				final String passWord = iep.get("PASSWORD", "");

				Connection conn = null;
				try {
					conn = DriverManager.getConnection("jdbc:h2:" + dbName, userId, passWord);
				} catch (final Exception e) {
					LOGGER.severe(e.getClass() + " " + e.getMessage());
				}
				LOGGER.info("Database connection " + conn);
			}
		} else if (event.getSource() == comboFieldEditorLogLevel) {
			final String levelName = event.getNewValue().toString();

			if (levelName.equals("OFF")) {
				LOGGER.setLevel(Level.OFF);
			} else if (levelName.equals("SEVERE")) {
				LOGGER.setLevel(Level.SEVERE);
			} else if (levelName.equals("WARNING")) {
				LOGGER.setLevel(Level.WARNING);
			} else if (levelName.equals("CONFIG")) {
				LOGGER.setLevel(Level.CONFIG);
			} else if (levelName.equals("FINE")) {
				LOGGER.setLevel(Level.FINE);
			} else if (levelName.equals("FINER")) {
				LOGGER.setLevel(Level.FINER);
			} else if (levelName.equals("FINEST")) {
				LOGGER.setLevel(Level.FINEST);
			} else if (levelName.equals("ALL")) {
				LOGGER.setLevel(Level.ALL);
			} else {
				LOGGER.setLevel(Level.INFO);
			}

			LOGGER.info("Log level " + levelName);
		} else if (event.getSource() == comboFieldEditorH2TraceLevel) {
			int h2TraceLevel = 2;
			final String levelName = event.getNewValue().toString();

			if (levelName.equals("OFF")) {
				h2TraceLevel = 0;
			} else if (levelName.equals("ERROR")) {
				h2TraceLevel = 1;
			} else {
				h2TraceLevel = 3;
			}

			try {
				final Connection conn = HreH2ConnectionPool.getConnection();
				PreparedStatement prep = conn.prepareStatement("SET TRACE_LEVEL_SYSTEM_OUT ?");
				prep.setInt(1, h2TraceLevel);
				prep.executeUpdate();
				prep = conn.prepareStatement("SET TRACE_LEVEL_FILE ?");
				prep.setInt(1, h2TraceLevel);
				prep.executeUpdate();
				prep.close();
				conn.close();
			} catch (final SQLException e) {
				LOGGER.severe(e.getMessage() + ", " + e.getErrorCode() + ", " + e.getSQLState());
			}

			LOGGER.info("H2 trace level: " + h2TraceLevel);
		}
	}
}
