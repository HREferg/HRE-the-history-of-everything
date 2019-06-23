package net.myerichsen.hremvp;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jetty.server.handler.ContextHandlerCollection;

/**
 * Singleton class encapsulating the ContextHandlerCollection of the embedded
 * Jetty server
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 1. okt. 2018
 *
 */
public class HreContextHandlerCollection {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static ContextHandlerCollection contexts;

	/**
	 * Exists only to defeat instantiation
	 */
	protected HreContextHandlerCollection() {
	}

	/**
	 * @return a context handler collection
	 */
	public static ContextHandlerCollection getContexts() {
		if (contexts == null) {
			contexts = new ContextHandlerCollection();
			LOGGER.log(Level.INFO, "HreContextHandlerCollection created");
		}
		return contexts;
	}
}
