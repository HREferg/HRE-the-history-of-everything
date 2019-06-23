package net.myerichsen.hremvp.requesthandlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.json.JSONStringer;

import net.myerichsen.hremvp.HreContextHandlerCollection;

/**
 * HTTP root request handler. Any invalid request will return a list of valid
 * endpoints
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 26. apr. 2019
 *
 */
public class RootHttpRequestHandler implements Handler {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jetty.util.component.LifeCycle#addLifeCycleListener(org.
	 * eclipse. jetty.util.component.LifeCycle.Listener)
	 */
	@Override
	public void addLifeCycleListener(Listener arg0) {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jetty.server.Handler#destroy()
	 */
	@Override
	public void destroy() {
	}

	/**
	 * @param request
	 * @param target
	 * @return
	 */
	private String getRemote(HttpServletRequest request, String target) {
		final JSONStringer js = new JSONStringer();
		js.object();

		js.key("validendpoints");
		js.array();

		for (final Handler handler : HreContextHandlerCollection.getContexts()
				.getHandlers()) {
			js.object();
			js.key("endpoint");

			final String[] strings = request.getProtocol().split("/");

			js.value(strings[0] + "://" + request.getLocalName() + ":"
					+ request.getLocalPort()
					+ ((ContextHandler) handler).getContextPath());

			js.endObject();
		}

		js.endArray();

		js.endObject();

		return js.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jetty.server.Handler#getServer()
	 */
	@Override
	public Server getServer() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jetty.server.Handler#handle(java.lang.String,
	 * org.eclipse.jetty.server.Request, javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);

		final PrintWriter out = response.getWriter();
		out.print(getRemote(request, target));
		out.close();

		baseRequest.setHandled(true);

		LOGGER.log(Level.INFO, "{0} {1}",
				new Object[] { request.getMethod(), target.substring(1) });
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jetty.util.component.LifeCycle#isFailed()
	 */
	@Override
	public boolean isFailed() {

		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jetty.util.component.LifeCycle#isRunning()
	 */
	@Override
	public boolean isRunning() {

		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jetty.util.component.LifeCycle#isStarted()
	 */
	@Override
	public boolean isStarted() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jetty.util.component.LifeCycle#isStarting()
	 */
	@Override
	public boolean isStarting() {

		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jetty.util.component.LifeCycle#isStopped()
	 */
	@Override
	public boolean isStopped() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jetty.util.component.LifeCycle#isStopping()
	 */
	@Override
	public boolean isStopping() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.jetty.util.component.LifeCycle#removeLifeCycleListener(org.
	 * eclipse.jetty.util.component.LifeCycle.Listener)
	 */
	@Override
	public void removeLifeCycleListener(Listener arg0) {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jetty.server.Handler#setServer(org.eclipse.jetty.server.
	 * Server)
	 */
	@Override
	public void setServer(Server server) {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jetty.util.component.LifeCycle#start()
	 */
	@Override
	public void start() throws Exception {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jetty.util.component.LifeCycle#stop()
	 */
	@Override
	public void stop() throws Exception {
	}
}