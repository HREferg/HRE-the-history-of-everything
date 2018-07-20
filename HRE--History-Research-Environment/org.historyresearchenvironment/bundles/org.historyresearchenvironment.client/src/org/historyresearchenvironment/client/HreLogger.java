package org.historyresearchenvironment.client;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.Preferences;

/**
 * Set up logger using the path from the preferences and the file name format
 * "hre-log.%u.%g.txt".
 * 
 * @version 2018-06-24
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class HreLogger {
	private static Preferences preferences = InstanceScope.INSTANCE.getNode("org.historyresearchenvironment");
	static private FileHandler handler;

	/**
	 * @throws IOException
	 *             When log file access fails
	 */
	static public void setup() throws IOException {
		final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

		final String levelName = preferences.get("LOGLEVEL", "INFO");

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

		String logFilePath = preferences.get("LOGFILEPATH", ".");

		if (logFilePath.endsWith(";")) {
			logFilePath = logFilePath.substring(0, logFilePath.length() - 1);
		}

		handler = new FileHandler(logFilePath + "hre-log.%u.%g.txt", 1024 * 1024, 10, true);
		handler.setFormatter(new SimpleFormatter());
		LOGGER.addHandler(handler);

		LOGGER.info("Log file path: " + logFilePath);
	}
}