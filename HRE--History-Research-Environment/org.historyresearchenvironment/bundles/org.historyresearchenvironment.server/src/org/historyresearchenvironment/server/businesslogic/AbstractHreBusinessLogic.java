package org.historyresearchenvironment.server.businesslogic;

import java.util.logging.Logger;

import org.historyresearchenvironment.server.ServerRequest;
import org.historyresearchenvironment.server.ServerResponse;

/**
 * @version 2018-08-08
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public abstract class AbstractHreBusinessLogic {
	protected final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	/**
	 * @param request
	 * @return
	 */
	public abstract ServerResponse execute(ServerRequest request);
}
