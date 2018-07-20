package org.historyresearchenvironment.sample.client;

import java.util.logging.Logger;

import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.historyresearchenvironment.sample.server.handlers.SampleHttpRequestHandler;
import org.historyresearchenvironment.server.HreContextHandlerCollection;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @version 2018-07-18
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class Activator implements BundleActivator {
	protected final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static BundleContext context;

	/**
	 * @return
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
		ContextHandler context = new ContextHandler();
		context.setContextPath("/hre/v010/sample");
		context.setHandler(new SampleHttpRequestHandler());

		ContextHandlerCollection contexts = HreContextHandlerCollection.getContexts();
		contexts.addHandler(context);

		LOGGER.info("Context added: " + context.getContextPath());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}
}
