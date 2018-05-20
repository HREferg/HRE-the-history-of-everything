package org.historyresearchenvironment.usergui.serverinterface;

import java.io.IOException;
import java.io.OutputStream;

import org.historyresearchenvironment.usergui.businesslogic.SomeBusinessLogic;
import org.historyresearchenvironment.usergui.providers.EventAssociatesProvider;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * @author Michael Erichsen, &copy; HRE Ltd.
 *
 */
class AssociatesModelHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange t) throws IOException {
		String s = t.getRequestURI().getPath();
		final String parts[] = s.split("/");

		EventAssociatesProvider model = new EventAssociatesProvider();
		s = parts[(parts.length - 1)];
		model.setId(Integer.parseInt(s));

		final ServerRequest request = new ServerRequest(t.getRequestMethod(), "eventassociates", model);
		final SomeBusinessLogic sbl = new SomeBusinessLogic(request);
		final ServerResponse response = sbl.doSomethingWithRequest();

		model = (EventAssociatesProvider) response.getProvider();

		s = model.writeJson(model.getClass().getName());

		final Headers headers = t.getResponseHeaders();
		headers.add("Content-Type", "application/json");
		t.sendResponseHeaders(200, s.length());

		final OutputStream os = t.getResponseBody();
		os.write(s.getBytes());
		os.close();
	}
}