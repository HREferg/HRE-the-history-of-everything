package org.historyresearchenvironment.client.handlers;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.historyresearchenvironment.client.dialogs.ProjectNameSummaryDialog;
import org.historyresearchenvironment.client.models.ProjectList;
import org.historyresearchenvironment.client.models.ProjectModel;
import org.historyresearchenvironment.dataaccess.HreH2ConnectionPool;
import org.osgi.service.prefs.BackingStoreException;

/**
 * Open an existing project.
 * 
 * @version 2018-07-23
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class ProjectOpenHandler {
	@Inject
	private static IEventBroker eventBroker;

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Select a database and open it
	 * 
	 * @param partService
	 * @param application
	 * @param modelService
	 * @param shell
	 * @throws SQLException
	 * @throws BackingStoreException
	 */
	@Execute
	public void execute(EPartService partService, MApplication application, EModelService modelService, Shell shell) {
		final IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.historyresearchenvironment");
		Connection conn = null;

		// Open file dialog
		final FileDialog dialog = new FileDialog(shell);
		final String[] extensions = { "*.h2.db", "*.mv.db", "*.*" };
		dialog.setFilterExtensions(extensions);
		dialog.open();

		final String shortName = dialog.getFileName();
		final String[] parts = shortName.split("\\.");
		final String dbName = dialog.getFilterPath() + "\\" + parts[0];

		// Disconnect from any currently connected database
		try {
			conn = HreH2ConnectionPool.getConnection();

			if (conn != null) {
				conn.createStatement().execute("SHUTDOWN");
				conn.close();
				conn = null;
				HreH2ConnectionPool.dispose();
			}
		} catch (final Exception e1) {
			eventBroker.post("MESSAGE", e1.getMessage());
			LOGGER.severe(e1.getMessage());
		}

		try {
			preferences.put("DBNAME", dbName);
			preferences.flush();
		} catch (final BackingStoreException e) {
			LOGGER.severe(e.getMessage());
			e.printStackTrace();
		}

		try {
			conn = HreH2ConnectionPool.getConnection(dbName);

			if (conn != null) {
				// Not valid before H2 V1.4
				// final PreparedStatement ps = conn
				// .prepareStatement("SELECT TABLE_NAME, ROW_COUNT_ESTIMATE FROM
				// INFORMATION_SCHEMA.TABLES "
				// + "WHERE TABLE_TYPE = 'TABLE' ORDER BY TABLE_NAME");
				final PreparedStatement ps = conn
						.prepareStatement("SELECT TABLE_NAME, 0 FROM INFORMATION_SCHEMA.TABLES "
								+ "WHERE TABLE_TYPE = 'TABLE' ORDER BY TABLE_NAME");
				ps.executeQuery();
				conn.close();
			}

			// Check if project is registered
			final int projectCount = preferences.getInt("projectcount", 0);
			final String[] keylist = preferences.keys();
			String key;
			boolean alreadyRegistered = false;

			for (int i = 0; i < projectCount; i++) {
				key = keylist[i];
				if ((key.startsWith("project.")) && (key.endsWith(".path"))) {
					if (dbName.equals(preferences.get(key, "?"))) {
						alreadyRegistered = true;
						break;
					}
				}
			}

			if (!alreadyRegistered) {
				// Open a dialog for summary
				final ProjectNameSummaryDialog pnsDialog = new ProjectNameSummaryDialog(shell);
				pnsDialog.open();

				// Update the HRE properties
				File file = new File(dbName + ".h2.db");
				if (file.exists() == false) {
					file = new File(dbName + ".mv.db");
				}
				final Date timestamp = new Date(file.lastModified());
				final ProjectModel model = new ProjectModel(pnsDialog.getProjectName(), timestamp,
						pnsDialog.getProjectSummary(), "LOCAL", dbName);
				ProjectList.add(model);

				// Set database name in title bar
				final MWindow window = (MWindow) modelService.find("org.historyresearchenvironment.client.window.main",
						application);
				window.setLabel("HRE v0.1 - " + dbName);
			}

			// Open Project Navigator
			final MPart pnPart = MBasicFactory.INSTANCE.createPart();
			pnPart.setLabel("Projects");
			pnPart.setContainerData("650");
			pnPart.setCloseable(true);
			pnPart.setVisible(true);
			pnPart.setContributionURI(
					"bundleclass://org.historyresearchenvironment.client/org.historyresearchenvironment.client.parts.ProjectNavigator");
			final List<MPartStack> stacks = modelService.findElements(application, null, MPartStack.class, null);
			stacks.get(0).getChildren().add(pnPart);
			partService.showPart(pnPart, PartState.ACTIVATE);

			// Open H2 Database Navigator
			final MPart h2dnPart = MBasicFactory.INSTANCE.createPart();
			h2dnPart.setLabel("Database Tables");
			h2dnPart.setContainerData("650");
			h2dnPart.setCloseable(true);
			h2dnPart.setVisible(true);
			h2dnPart.setContributionURI(
					"bundleclass://org.historyresearchenvironment.client/org.historyresearchenvironment.databaseadmin.parts.H2DatabaseNavigator");
			stacks.get(stacks.size() - 2).getChildren().add(h2dnPart);
			partService.showPart(h2dnPart, PartState.ACTIVATE);

			eventBroker.post(org.historyresearchenvironment.client.HreConstants.DATABASE_UPDATE_TOPIC, dbName);
			eventBroker.post("MESSAGE", "Project database " + dbName + " has been opened");
		} catch (final Exception e1) {
			eventBroker.post("MESSAGE", e1.getMessage());
			LOGGER.severe(e1.getMessage());
			e1.printStackTrace();
		}
	}
}
