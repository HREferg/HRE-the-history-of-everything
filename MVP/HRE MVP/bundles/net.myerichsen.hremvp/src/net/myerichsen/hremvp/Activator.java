package net.myerichsen.hremvp;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.osgi.service.environment.EnvironmentInfo;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

/**
 * The activator class runs when the application starts and stops, Sets up the
 * logger. Starts and stops the Help System.
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 20. apr. 2019
 *
 */
public class Activator implements BundleActivator {
	/**
	 *
	 */
	private static final String PROJECT = "project.";
	private static BundleContext context;
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");
	private static final String HELPCLASSPATH = "plugins\\\\org.eclipse.help.base_4.2.400.v20181206-0815.jar";

	/**
	 * @return The bundle context
	 */
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.
	 * BundleContext)
	 */
	@Override
	public void start(BundleContext bundleContext) throws IOException {
		context = bundleContext;

		HreLogger.setup();

		LOGGER.log(Level.FINE, "HRE MVP v0.2 has been started");
		LOGGER.log(Level.FINE, "Command line arguments:");

		final ServiceReference<EnvironmentInfo> envRef = context
				.getServiceReference(EnvironmentInfo.class);
		final EnvironmentInfo envInfo = context.getService(envRef);
		final String[] args = envInfo.getCommandLineArgs();
		for (int i = 0; i < args.length; i++) {
			LOGGER.log(Level.FINE, "CLI {0}: {1}", new Object[] { i, args[i] });
		}

		// List properties to LOGGER
		LOGGER.log(Level.FINE, "--------------------------------------");
		LOGGER.log(Level.FINE, "Project preferences:");
		LOGGER.log(Level.FINE,
				"Project count: " + store.getString("projectcount"));
		final int i = Integer.parseInt(store.getString("projectcount"));

		for (int j = 1; j < (i + 1); j++) {
			LOGGER.log(Level.FINE, store.getString(PROJECT + j + ".name"));
			LOGGER.log(Level.FINE,
					store.getString(PROJECT + j + ".lastupdated"));
			LOGGER.log(Level.FINE, store.getString(PROJECT + j + ".summary"));
			LOGGER.log(Level.FINE,
					store.getString(PROJECT + j + ".localserver"));
			LOGGER.log(Level.FINE, store.getString(PROJECT + j + ".path"));
		}
		LOGGER.log(Level.FINE, "--------------------------------------");

		final String csMode = store.getString("CSMODE");
		LOGGER.log(Level.FINE, "Client/server mode {0}", csMode);
		LOGGER.log(Level.FINE, "HRE Absolute path: {0}",
				new File(".").getAbsolutePath());
		LOGGER.log(Level.FINE, "HRE Font: {0}", store.getString("HREFONT"));

		final int port = store.getInt("HELPSYSTEMPORT");
		final String command = "java -classpath " + HELPCLASSPATH
				+ " org.eclipse.help.standalone.Infocenter -command start -port "
				+ port + " -product net.myerichsen.hremvp.helpsystem -clean";

		try {
			LOGGER.log(Level.INFO, "Help System is being started at port {0}",
					port);
			final Process helpProcess = Runtime.getRuntime().exec(command);
			if (helpProcess.isAlive()) {
				LOGGER.log(Level.INFO, "Help system start command: {0}",
						command);
			} else {
				throw new MvpException("Could not start help system process");
			}
		} catch (final Exception e) {
			LOGGER.severe(e.getClass() + ": " + e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) {
		try {
			HreH2ConnectionPool.dispose();
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.getMessage());
		}

		final String command = "java -classpath " + HELPCLASSPATH
				+ " org.eclipse.help.standalone.Infocenter -command shutdown";

		try {
			Runtime.getRuntime().exec(command);
			LOGGER.log(Level.FINE, "Help System is being stopped");
		} catch (final Exception e) {
			LOGGER.severe(e.getClass() + ": " + e.getMessage());
		}

		context = null;
	}

}