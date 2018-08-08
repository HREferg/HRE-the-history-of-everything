package org.historyresearchenvironment.prototypes.businesslogic;

import org.historyresearchenvironment.prototypes.providers.PersonEditorProvider;
import org.historyresearchenvironment.server.ServerRequest;
import org.historyresearchenvironment.server.ServerResponse;
import org.historyresearchenvironment.server.businesslogic.AbstractHreBusinessLogic;

/**
 * @version 2018-08-08
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class PersonBusinessLogic extends AbstractHreBusinessLogic {

	/**
	 * Constructor
	 *
	 */
	public PersonBusinessLogic() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.historyresearchenvironment.server.businesslogic.AbstractHreBusinessLogic#
	 * execute(org.historyresearchenvironment.server.ServerRequest)
	 */
	@Override
	public ServerResponse execute(ServerRequest request) {
		ServerResponse response = null;

		LOGGER.info("Request provider: " + request.getProvider().getClass().getSimpleName() + ", Business Logic: "
				+ request.getBusinessLogic().getClass().getSimpleName());

		if (request.getProvider() instanceof PersonEditorProvider) {
			final PersonEditorProvider provider = (PersonEditorProvider) request.getProvider();
			final short key = Short.parseShort(provider.getKey());
			provider.readFromDatabase(key);
			response = new ServerResponse(provider, 0, "OK");
			LOGGER.info("Key: " + provider.getKey() + ", " + provider.getName());

			return response;
		}
		return response;
	}

}
