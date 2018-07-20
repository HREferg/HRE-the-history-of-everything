package org.historyresearchenvironment.sample.businesslogic;

import java.util.logging.Logger;

import org.historyresearchenvironment.sample.providers.SampleEditorProvider;
import org.historyresearchenvironment.server.ServerRequest;
import org.historyresearchenvironment.server.ServerResponse;
import org.historyresearchenvironment.server.businesslogic.AbstractHreBusinessLogic;

/**
 * @version 2018-07-19
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class SampleBusinessLogic extends AbstractHreBusinessLogic {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Constructor
	 *
	 */
	public SampleBusinessLogic() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.historyresearchenvironment.server.businesslogic.AbstractHreBusinessLogic#
	 * execute()
	 */
	@Override
	public ServerResponse execute(ServerRequest request) {
		ServerResponse response = null;

		LOGGER.info("Request provider: " + request.getProvider().getClass().getSimpleName() + ", Business Logic: "
				+ request.getBusinessLogic().getClass().getSimpleName());

		if (request.getProvider() instanceof SampleEditorProvider) {
			final SampleEditorProvider provider = (SampleEditorProvider) request.getProvider();
			final short paramSetKey = provider.getParamSetKey();
			provider.readFromDatabase(paramSetKey);
			response = new ServerResponse(provider, 0, "OK");
			LOGGER.info("Key: " + provider.getParamSetKey() + ", " + provider.getDefltValue());

			return response;
		}
		return response;
	}
}