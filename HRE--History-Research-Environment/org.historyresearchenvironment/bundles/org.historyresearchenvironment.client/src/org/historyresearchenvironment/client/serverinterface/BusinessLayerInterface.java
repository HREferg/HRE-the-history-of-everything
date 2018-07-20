package org.historyresearchenvironment.client.serverinterface;

import org.historyresearchenvironment.server.ServerRequest;
import org.historyresearchenvironment.server.ServerResponse;

/**
 * Abstract superclass for business layer interfaces.
 * 
 * @version 2018-07-19
 * @author Michael Erichsen, &copy; History Research Environment Ltd.
 *
 */
public interface BusinessLayerInterface {

	/**
	 * @param request
	 * @return
	 */
	public abstract ServerResponse callBusinessLayer(ServerRequest request);
}
