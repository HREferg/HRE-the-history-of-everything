package org.historyresearchenvironment.client.parts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.historyresearchenvironment.client.models.ProjectList;
import org.historyresearchenvironment.client.models.ProjectModel;
import org.historyresearchenvironment.dataaccess.HreH2ConnectionPool;
import org.osgi.service.prefs.BackingStoreException;

/**
 * Navigator part to display all tables in an HRE project.
 * 
 * @version 2018-07-23
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
@SuppressWarnings("restriction")
public class ProjectNavigator {
	private static IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.historyresearchenvironment");
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;
	@Inject
	private IEventBroker eventBroker;
	@Inject
	private MApplication application;

	@Inject
	private EModelService modelService;
	@Inject
	private EPartService partService;

	private Table table;

	/**
	 * Constructor
	 *
	 */
	public ProjectNavigator() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		final TableViewer tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				final ParameterizedCommand command = commandService
						.createCommand("org.historyresearchenvironment.client.command.projectproperties", null);
				handlerService.executeHandler(command);

				final int index = table.getSelectionIndex();
				eventBroker.post(org.historyresearchenvironment.client.HreConstants.SELECTION_INDEX_TOPIC, index);
				LOGGER.info("Project Navigator posted selection index " + index);
			}
		});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		final TableViewerColumn tableViewerColumnProjectName = new TableViewerColumn(tableViewer, SWT.NONE);
		final TableColumn tblclmnProjectName = tableViewerColumnProjectName.getColumn();
		tblclmnProjectName.setWidth(100);
		tblclmnProjectName.setText("Project Name");

		final int projectCount = preferences.getInt("projectcount", 1);
		String key;

		for (int i = 0; i < projectCount; i++) {
			final TableItem tableItem = new TableItem(table, SWT.NONE);
			key = new String("project." + i + ".name");
			tableItem.setText(preferences.get(key, "?"));
		}

		final Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem mntmOpen = new MenuItem(menu, SWT.NONE);
		mntmOpen.setToolTipText("Open selected project");
		mntmOpen.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 *
			 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events
			 * .SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				openSelectedProject(parent.getShell());
			}
		});
		mntmOpen.setText("Open selected");

		final MenuItem mntmOpenOther = new MenuItem(menu, SWT.NONE);
		mntmOpenOther.setToolTipText("Open other");
		mntmOpenOther.setText("Open other...");
		mntmOpenOther.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 *
			 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events
			 * .SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final ParameterizedCommand saveCommand = commandService.createCommand("org.eclipse.ui.file.open", null);
				handlerService.executeHandler(saveCommand);
			}
		});
		mntmOpenOther.setText("Open other...");

		final MenuItem mntmNew = new MenuItem(menu, SWT.NONE);
		mntmNew.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 *
			 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events
			 * .SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final ParameterizedCommand newCommand = commandService.createCommand("org.eclipse.ui.file.save", null);
				handlerService.executeHandler(newCommand);
			}
		});
		mntmNew.setText("New...");

		final MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
		mntmNewItem.setText("Backup...");

		final MenuItem mntmRestore = new MenuItem(menu, SWT.NONE);
		mntmRestore.setText("Restore...");

		final MenuItem mntmCopyAs = new MenuItem(menu, SWT.NONE);
		mntmCopyAs.setText("Copy as...");

		final MenuItem mntmRename = new MenuItem(menu, SWT.NONE);
		mntmRename.setText("Rename...");

		final MenuItem mntmDelete = new MenuItem(menu, SWT.NONE);
		mntmDelete.setText("Delete");

		new MenuItem(menu, SWT.SEPARATOR);

		final MenuItem mntmProperties = new MenuItem(menu, SWT.NONE);
		mntmProperties.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final ParameterizedCommand command = commandService
						.createCommand("org.historyresearchenvironment.client.command.projectproperties", null);
				handlerService.executeHandler(command);

				final int index = table.getSelectionIndex();
				eventBroker.post(org.historyresearchenvironment.client.HreConstants.SELECTION_INDEX_TOPIC, index);
				LOGGER.info("Project Navigator posted selection index " + index);
			}
		});
		mntmProperties.setToolTipText("Properties");
		mntmProperties.setText("Properties");
	}

	/**
	 * 
	 */
	@PreDestroy
	public void dispose() {
	}

	/**
	 * Open a table navigator with the current project database.
	 */
	protected void openSelectedProject(Shell shell) {
		Connection conn = null;

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

		// Find selected database
		final int index = table.getSelectionIndex();
		final ProjectModel model = ProjectList.getModel(index);
		final String dbName = model.getPath();

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

			// Set database name in title bar
			final MWindow window = (MWindow) modelService.find("org.historyresearchenvironment.client.window.main",
					application);
			window.setLabel("HRE v0.1 - " + dbName);

			// Open H2 Database Navigator
			final MPart h2dnPart = MBasicFactory.INSTANCE.createPart();
			h2dnPart.setLabel("Database Tables");
			h2dnPart.setContainerData("650");
			h2dnPart.setCloseable(true);
			h2dnPart.setVisible(true);
			h2dnPart.setContributionURI(
					"bundleclass://org.historyresearchenvironment.client/org.historyresearchenvironment.databaseadmin.parts.H2DatabaseNavigator");
			final List<MPartStack> stacks = modelService.findElements(application, null, MPartStack.class, null);
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

	/**
	 * 
	 */
	@Focus
	public void setFocus() {
	}
}
