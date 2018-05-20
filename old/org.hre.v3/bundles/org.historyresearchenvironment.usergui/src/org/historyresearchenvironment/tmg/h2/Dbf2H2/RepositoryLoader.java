package org.historyresearchenvironment.tmg.h2.Dbf2H2;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

/**
 * @author Michael Erichsen, &copy; HRE Ltd. Erichsen
 *
 */
public class RepositoryLoader {
	private static final String type = TmgTypes.REPOSITORY;

	private static final String TABLE = "REPOSITORY";
	private static final String INSERT = "(DSID, NAME, RECNO, REF_ID, ABBREV, "
			+ "ADDRESS, RNOTE, RPERNO,  ISPICKED, TT ) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String dbName;
	private final String project;

	/**
	 * @param dbName
	 * @param userid
	 * @param password
	 * @param project
	 */
	public RepositoryLoader(String dbName, String project, IProgressMonitor monitor) {
		super();
		this.dbName = dbName;
		this.project = project;
		final SubMonitor subMonitor = SubMonitor.convert(monitor, 1);
		subMonitor.beginTask("Loading tables", 1);
		subMonitor.subTask("Loading " + TABLE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */

	public void run() {
		final TableLoader ld = new TableLoader(project, type, TABLE, INSERT, dbName);
		ld.run();

	}
}