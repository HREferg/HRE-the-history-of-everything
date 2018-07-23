package org.historyresearchenvironment.client.handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.historyresearchenvironment.client.dialogs.ProjectNameSummaryDialog;
import org.historyresearchenvironment.client.models.ProjectList;
import org.historyresearchenvironment.client.models.ProjectModel;
import org.historyresearchenvironment.dataaccess.HreH2ConnectionPool;
import org.historyresearchenvironment.dataaccess.providers.NewDatabaseProvider;
import org.osgi.service.prefs.BackingStoreException;

/**
 * Create a new HRE project database.
 * 
 * @version 2018-07-23
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class ProjectNewHandler {
	@Inject
	private static IEventBroker eventBroker;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Inject
	MApplication application;

	@Inject
	EModelService modelService;
	private final IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.historyresearchenvironment");
	private NewDatabaseProvider provider;

	/**
	 * Create a new database and open it
	 * 
	 * @param shell
	 *            The application shell
	 * @throws SQLException
	 *             When failing
	 */
	@Execute
	public void execute(EPartService partService, Shell shell) throws SQLException {
		// Open file dialog
		final FileDialog dialog = new FileDialog(shell, SWT.SAVE);
		dialog.setText("Create new HRE Project");
		dialog.setFilterPath("./");
		final String[] extensions = { "*.h2.db", "*.mv.db", "*.*" };
		dialog.setFilterExtensions(extensions);
		dialog.open();

		final String shortName = dialog.getFileName();
		final String[] parts = shortName.split("\\.");
		final String dbName = dialog.getFilterPath() + "\\" + parts[0];

		try {
			// Create the new database
			LOGGER.info("New database name: " + dbName);
			provider = new NewDatabaseProvider();

			provider.provide(dbName);

			// Disconnect from any currently connected database
			Connection conn = null;

			conn = HreH2ConnectionPool.getConnection();

			if (conn != null) {
				conn.createStatement().execute("SHUTDOWN");
				conn.close();
				HreH2ConnectionPool.dispose();
			}

			try {
				preferences.put("DBNAME", dbName);
				preferences.flush();
			} catch (final BackingStoreException e) {
				LOGGER.severe(e.getMessage());
				e.printStackTrace();
			}

			// Connect to the new database
			conn = HreH2ConnectionPool.getConnection(dbName);
			// Not valid before H2 V1.4
			// final PreparedStatement ps = conn
			// .prepareStatement("SELECT TABLE_NAME, ROW_COUNT_ESTIMATE FROM
			// INFORMATION_SCHEMA.TABLES "
			// + "WHERE TABLE_TYPE = 'TABLE' ORDER BY TABLE_NAME");
			final PreparedStatement ps = conn.prepareStatement("SELECT TABLE_NAME, 0 FROM INFORMATION_SCHEMA.TABLES "
					+ "WHERE TABLE_TYPE = 'TABLE' ORDER BY TABLE_NAME");
			ps.executeQuery();
			conn.close();

			// Open a dialog for summary
			final ProjectNameSummaryDialog pnsDialog = new ProjectNameSummaryDialog(shell);
			pnsDialog.open();

			// Update the HRE properties
			final LocalDateTime now = LocalDateTime.now();
			final ZonedDateTime zdt = now.atZone(ZoneId.systemDefault());
			final Date timestamp = Date.from(zdt.toInstant());
			final ProjectModel model = new ProjectModel(pnsDialog.getProjectName(), timestamp,
					pnsDialog.getProjectSummary(), "LOCAL", dbName);
			ProjectList.add(model);

			// Set database name in title bar
			final MWindow window = (MWindow) modelService.find("org.historyresearchenvironment.client.window.main",
					application);
			window.setLabel("HRE v0.1 - " + dbName);

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
					"bundleclass://org.historyresearchenvironment.databaseadmin.client/org.historyresearchenvironment.databaseadmin.parts.H2DatabaseNavigator");
			stacks.get(stacks.size() - 2).getChildren().add(h2dnPart);
			partService.showPart(h2dnPart, PartState.ACTIVATE);

			eventBroker.post(org.historyresearchenvironment.client.HreConstants.DATABASE_UPDATE_TOPIC, dbName);
			eventBroker.post("MESSAGE", "Project database " + dbName + " has been created");
		} catch (final Exception e1) {
			eventBroker.post("MESSAGE", e1.getMessage());
			LOGGER.severe(e1.getMessage());
			e1.printStackTrace();
		}

	}
}