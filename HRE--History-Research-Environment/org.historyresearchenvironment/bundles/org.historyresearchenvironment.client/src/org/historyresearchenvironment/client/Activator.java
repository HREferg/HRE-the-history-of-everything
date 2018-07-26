package org.historyresearchenvironment.client;

import java.io.File;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.osgi.service.environment.EnvironmentInfo;
import org.historyresearchenvironment.dataaccess.HreH2ConnectionPool;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * Eclipse plug-in life cycle control. Sets up the logger. Starts and stops the
 * Help System.
 * 
 * @version 2018-07-26
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class Activator implements BundleActivator {
	private static BundleContext context;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.historyresearchenvironment");
	private final static String HELPCLASSPATH = "plugins\\\\org.eclipse.help.base_4.2.153.v20180330-0640.jar";
	// "plugins\\\\org.eclipse.help.base_4.2.200.v20180611-0500.jar";

	/**
	 * @return The bundle context
	 */
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;

		HreLogger.setup();

		preferences.putInt("projectcount", preferences.getInt("projectcount", 1));
		preferences.put("project.0.name", preferences.get("project.0.name", "SAMPLE"));
		preferences.put("project.0.lastupdated", preferences.get("project.0.lastupdated", "2018-06-24 16:41:36"));
		preferences.put("project.0.summary", preferences.get("project.0.summary", "This is the default project"));
		preferences.put("project.0.localserver", preferences.get("project.0.localserver", "LOCAL"));
		preferences.put("project.0.path", preferences.get("project.0.path", "./SAMPLE"));
		preferences.flush();

		LOGGER.info("HRE v0.1 has been started");

		LOGGER.info("Command line arguments:");

		final ServiceReference<EnvironmentInfo> envRef = context.getServiceReference(EnvironmentInfo.class);
		final EnvironmentInfo envInfo = context.getService(envRef);
		final String[] args = envInfo.getCommandLineArgs();
		for (int i = 0; i < args.length; i++) {
			LOGGER.info("CLI " + i + ": " + args[i]);
		}

		final String csMode = preferences.get("CSMODE", "DIRECT");
		LOGGER.info("Client/server mode " + csMode);
		LOGGER.info("HRE Absolute path: " + new File(".").getAbsolutePath());
		LOGGER.info("HRE Font: "
				+ preferences.get("HREFONT", "1|Segoe UI|12.0|0|WINDOWS|1|-16|0|0|0|400|0|0|0|0|3|2|1|34|Segoe UI"));

		int port = preferences.getInt("HELPSYSTEMPORT", 8081);
		final String command = "java -classpath " + HELPCLASSPATH
				+ " org.eclipse.help.standalone.Infocenter -command start -port " + port
				+ " -product org.historyresearchenvironment.helpsystem -clean";

		try {
			LOGGER.info("Help System is being started at port " + port);
			Runtime.getRuntime().exec(command);
			LOGGER.info("Has been started: " + command);
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
	public void stop(BundleContext bundleContext) throws Exception {
		preferences.flush();
		HreH2ConnectionPool.dispose();

		final String command = "java -classpath " + HELPCLASSPATH
				+ " org.eclipse.help.standalone.Infocenter -command shutdown";

		try {
			Runtime.getRuntime().exec(command);
			LOGGER.info("Help System is being stopped");
		} catch (final Exception e) {
			LOGGER.severe(e.getClass() + ": " + e.getMessage());
		}

		Activator.context = null;
	}
}
