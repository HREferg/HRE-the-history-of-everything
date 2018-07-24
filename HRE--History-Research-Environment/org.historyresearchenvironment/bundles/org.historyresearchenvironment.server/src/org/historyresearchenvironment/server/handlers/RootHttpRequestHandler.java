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
import org.eclipse.jetty.util.component.*;

/**
 * HTTP request handler for Jetty server
 * 
 * @version 2018-07-19
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
@SuppressWarnings("unused")
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

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.util.component.LifeCycle#addLifeCycleListener(org.eclipse.jetty.util.component.LifeCycle.Listener)
	 */
	@Override
	public void addLifeCycleListener(Listener arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.util.component.LifeCycle#isFailed()
	 */
	@Override
	public boolean isFailed() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.util.component.LifeCycle#isRunning()
	 */
	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.util.component.LifeCycle#isStarted()
	 */
	@Override
	public boolean isStarted() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.util.component.LifeCycle#isStarting()
	 */
	@Override
	public boolean isStarting() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.util.component.LifeCycle#isStopped()
	 */
	@Override
	public boolean isStopped() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.util.component.LifeCycle#isStopping()
	 */
	@Override
	public boolean isStopping() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.util.component.LifeCycle#removeLifeCycleListener(org.eclipse.jetty.util.component.LifeCycle.Listener)
	 */
	@Override
	public void removeLifeCycleListener(Listener arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.util.component.LifeCycle#start()
	 */
	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.util.component.LifeCycle#stop()
	 */
	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.server.Handler#setServer(org.eclipse.jetty.server.Server)
	 */
	@Override
	public void setServer(Server server) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.server.Handler#getServer()
	 */
	@Override
	public Server getServer() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.server.Handler#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
