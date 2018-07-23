package org.historyresearchenvironment.server.handlers;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.historyresearchenvironment.server.HreContextHandlerCollection;

/**
 * Start the embedded Jetty server. Creates a ContextHandlerCollection that
 * other features can add contexts and handlers to.
 * 
 * @version 2018-07-23
 * @author Michael Erichsen, &copy; History Research Environment Ltd.
 *
 */
public class ProjectStartEmbeddedServerHandler {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.historyresearchenvironment");
	@Inject
	private IEventBroker eventBroker;

	/**
	 * Start embedded Jetty server
	 */
	@Execute
	public void execute() {
		Runnable runnable = new Runnable() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {

				Server server = new Server(preferences.getInt("SERVERPORT", 8000));

				try {
					server.getConnectors()[0].getConnectionFactory(HttpConnectionFactory.class);

					ContextHandler context = new ContextHandler();
					context.setContextPath("/");
					context.setHandler(new RootHttpRequestHandler());

					ContextHandlerCollection contexts = HreContextHandlerCollection.getContexts();
					contexts.addHandler(context);

					Handler[] handlerList = contexts.getHandlers();

					for (Handler handler : handlerList) {
						LOGGER.info("Server handler: " + ((ContextHandler) handler).getContextPath());
					}

					server.setHandler(contexts);
					server.setStopAtShutdown(true);
					server.start();

					LOGGER.info("The server is running at " + server.getURI());
					eventBroker.post("MESSAGE", "The server is running at " + server.getURI());

					// server.join();
				} catch (Exception e) {
					e.printStackTrace();
					LOGGER.severe(
							e.getClass() + ": " + e.getMessage() + " at line " + e.getStackTrace()[0].getLineNumber());
				}
			}
		};
		new Thread(runnable).start();
	}
}