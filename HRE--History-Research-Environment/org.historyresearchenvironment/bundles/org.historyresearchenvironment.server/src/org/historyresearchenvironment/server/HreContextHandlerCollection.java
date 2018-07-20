package org.historyresearchenvironment.server;

import java.util.logging.Logger;

import org.eclipse.jetty.server.handler.ContextHandlerCollection;

/**
 * Singleton class encapsulating the ContextHandlerCollection of the embedded
 * Jetty server.
 * 
 * @version 2018-07-17
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class HreContextHandlerCollection {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static ContextHandlerCollection contexts;

	/**
	 * @return a context handler collection
	 */
	public static ContextHandlerCollection getContexts() {
		if (contexts == null) {
			contexts = new ContextHandlerCollection();
			LOGGER.info("HreContextHandlerCollection created");
		}
		return contexts;
	}

	/**
	 * Exists only to defeat instantiation
	 */
	protected HreContextHandlerCollection() {
	}
}
