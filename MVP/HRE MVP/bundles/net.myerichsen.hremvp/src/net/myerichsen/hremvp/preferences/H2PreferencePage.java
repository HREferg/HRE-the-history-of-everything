package net.myerichsen.hremvp.preferences;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import net.myerichsen.hremvp.HreH2ConnectionPool;

/**
 * Preference page for H2 databse
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 11. apr. 2019
 *
 */
public class H2PreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {
	private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private ComboFieldEditor comboFieldEditorH2TraceLevel;

	/**
	 * Constructor
	 *
	 */
	public H2PreferencePage() {
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
		addField(new DirectoryFieldEditor("DBPATH", "H2 Database Path",
				composite));
		addField(new StringFieldEditor("DBNAME", "H2 Database Name", -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, composite));
		addField(new StringFieldEditor("USERID", "H2 Userid", -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, composite));
		addField(new StringFieldEditor("PASSWORD", "H2 Password", -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, composite));
		comboFieldEditorH2TraceLevel = new ComboFieldEditor("H2TRACELEVEL",
				"H2 Trace Level", new String[][] { { "OFF", "0" },
						{ "ERROR", "1" }, { "INFO", "2" }, { "DEBUG", "3" } },
				composite);
		addField(comboFieldEditorH2TraceLevel);
		final StringFieldEditor h2versionStringFieldEditor = new StringFieldEditor(
				"H2VERSION", "H2 Version", -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, composite);
		h2versionStringFieldEditor.getTextControl(composite).setEditable(false);
		addField(h2versionStringFieldEditor);
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
		super.propertyChange(event);

		if (event.getSource() == comboFieldEditorH2TraceLevel) {
			int h2TraceLevel;

			h2TraceLevel = Integer.parseInt(event.getNewValue().toString());

			try {
				final Connection conn = HreH2ConnectionPool.getConnection();
				PreparedStatement prep = conn
						.prepareStatement("SET TRACE_LEVEL_SYSTEM_OUT ?");
				prep.setInt(1, h2TraceLevel);
				prep.executeUpdate();
				prep = conn.prepareStatement("SET TRACE_LEVEL_FILE ?");
				prep.setInt(1, h2TraceLevel);
				prep.executeUpdate();
				prep.close();
				conn.close();
			} catch (final SQLException e) {
				LOGGER.severe(e.getMessage() + ", " + e.getErrorCode() + ", "
						+ e.getSQLState());
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}

			LOGGER.log(Level.INFO,
					"Changed property "
							+ comboFieldEditorH2TraceLevel.getPreferenceName()
							+ " from " + event.getOldValue() + " to "
							+ event.getNewValue());
		}
	}
}
