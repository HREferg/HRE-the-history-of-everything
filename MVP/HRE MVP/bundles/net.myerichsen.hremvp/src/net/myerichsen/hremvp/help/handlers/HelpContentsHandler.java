
package net.myerichsen.hremvp.help.handlers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.help.internal.base.BaseHelpSystem;
import org.eclipse.jface.preference.IPreferenceStore;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

/**
 * Handler to open the help system in an external browser.
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 7. jan. 2019
 *
 */
@SuppressWarnings("restriction")
public class HelpContentsHandler {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");

	/**
	 *
	 */
	@Execute
	public void execute() {
		try {
			BaseHelpSystem.ensureWebappRunning();
			final String helpURL = "http://127.0.0.1:"
					+ store.getInt("HELPSYSTEMPORT") + "/help/index.jsp";

			BaseHelpSystem.getHelpBrowser(true).displayURL(helpURL);
			LOGGER.log(Level.INFO, "Browser pointing at {0}", helpURL);
		} catch (final Exception e) {
			LOGGER.severe(e.getClass() + ": " + e.getMessage());
		}
	}

}