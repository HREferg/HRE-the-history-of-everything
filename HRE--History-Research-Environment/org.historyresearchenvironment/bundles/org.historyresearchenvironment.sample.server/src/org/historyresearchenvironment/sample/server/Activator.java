package org.historyresearchenvironment.sample.server;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @version 2018-07-18
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class Activator implements BundleActivator {

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
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
