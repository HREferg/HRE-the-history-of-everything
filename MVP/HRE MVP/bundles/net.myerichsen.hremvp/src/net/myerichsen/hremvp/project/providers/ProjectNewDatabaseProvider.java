package net.myerichsen.hremvp.project.providers;

import org.eclipse.swt.widgets.Shell;

import net.myerichsen.hremvp.project.servers.ProjectNewDatabaseServer;

/**
 * Create and open a new HRE project database
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 21. apr. 2019
 *
 */
public class ProjectNewDatabaseProvider {
	ProjectNewDatabaseServer server;

	/**
	 * Constructor
	 *
	 * @param shell
	 *
	 * @throws Exception
	 */
	public ProjectNewDatabaseProvider(Shell shell) {
		server = new ProjectNewDatabaseServer(shell);
	}

	/**
	 * Provide the data
	 *
	 * @param dbName
	 */
	public void provide(String dbName) {
		server.provide(dbName);
	}
}
