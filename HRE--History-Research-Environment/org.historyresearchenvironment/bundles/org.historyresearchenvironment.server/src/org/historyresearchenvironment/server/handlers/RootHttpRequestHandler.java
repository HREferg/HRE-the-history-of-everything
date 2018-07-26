package org.historyresearchenvironment.server.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;

/**
 * HTTP request handler for Jetty server
 * 
 * @version 2018-07-26
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class RootHttpRequestHandler implements Handler {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jetty.server.Handler#handle(java.lang.String,
	 * org.eclipse.jetty.server.Request, javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);

		LOGGER.info(target);

		PrintWriter out = response.getWriter();

		out.println("{");
		out.println("\"Method\": \"" + request.getMethod() + "\", ");
		out.println("\"Target\": \"" + target.substring(1) + "\"");
		out.println("}");
		baseRequest.setHandled(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jetty.util.component.LifeCycle#addLifeCycleListener(org.eclipse.
	 * jetty.util.component.LifeCycle.Listener)
	 */
	@Override
	public void addLifeCycleListener(Listener arg0) {

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
	 * @see org.eclipse.jetty.util.component.LifeCycle#removeLifeCycleListener(org.
	 * eclipse.jetty.util.component.LifeCycle.Listener)
	 */
	@Override
	public void removeLifeCycleListener(Listener arg0) {

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jetty.server.Handler#setServer(org.eclipse.jetty.server.Server)
	 */
	@Override
	public void setServer(Server server) {

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
	 * @see org.eclipse.jetty.server.Handler#destroy()
	 */
	@Override
	public void destroy() {

	}

}
