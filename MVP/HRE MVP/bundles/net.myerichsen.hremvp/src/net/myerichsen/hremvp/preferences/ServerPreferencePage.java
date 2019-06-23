package net.myerichsen.hremvp.preferences;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.ListEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.dialogs.ServerListDialog;

/**
 * Preference page for the embedded Jetty server
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 6. jan. 2019
 *
 */
public class ServerPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {
	private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private FieldEditor comboFieldEditorJettyLogLevel;

	/**
	 * Constructor
	 *
	 */
	public ServerPreferencePage() {
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

		addField(new StringFieldEditor("SERVERADDRESS", "Server Address", -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, composite));
		addField(new StringFieldEditor("SERVERROOT", "Server Root", -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, composite));
		final IntegerFieldEditor integerFieldEditor = new IntegerFieldEditor(
				"SERVERPORT", "Server Port", composite);
		integerFieldEditor.setTextLimit(5);
		addField(integerFieldEditor);
		comboFieldEditorJettyLogLevel = new ComboFieldEditor("JETTYLOGLEVEL",
				"Jetty Log Level",
				new String[][] { { "OFF", "OFF" }, { "DEBUG", "DEBUG" },
						{ "INFO", "INFO" }, { "WARN", "WARN" },
						{ "ALL", "ALL" } },
				composite);
		addField(comboFieldEditorJettyLogLevel);

		final BooleanFieldEditor booleanFieldEditorTls = new BooleanFieldEditor(
				"TLS", "Secure Connection", BooleanFieldEditor.DEFAULT,
				composite);
		addField(booleanFieldEditorTls);

		addField(new ListEditor("SERVERLIST", "Server addresses and ports",
				getFieldEditorParent()) {

			@Override
			protected String createList(String[] items) {
				final StringBuilder sb = new StringBuilder();

				for (final String string : items) {
					sb.append(string + "¤");
				}

				return sb.toString();
			}

			@Override
			protected String getNewInputObject() {
				final ServerListDialog dialog = new ServerListDialog(
						getFieldEditorParent().getShell());

				final int a = dialog.open();

				if (a == Window.OK) {
					return dialog.getAddress() + ":" + dialog.getPort();
				}

				return null;
			}

			@Override
			protected String[] parseString(String stringList) {
				return stringList.split("¤");
			}
		});
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
		new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"net.myerichsen.hremvp");

		super.propertyChange(event);

		LOGGER.log(Level.INFO, "Changed property: " + event.getProperty() + ", "
				+ event.getOldValue() + " to " + event.getNewValue());

		if (event.getSource() == comboFieldEditorJettyLogLevel) {
			LOGGER.log(Level.INFO,
					"Changed property "
							+ comboFieldEditorJettyLogLevel.getPreferenceName()
							+ " from " + event.getOldValue() + " to "
							+ event.getNewValue());
			System.setProperty("org.eclipse.jetty.LEVEL",
					event.getNewValue().toString());
		}
	}
}
