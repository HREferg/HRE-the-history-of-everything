package net.myerichsen.hremvp.project.parts;

import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.h2.tools.RunScript;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.HreH2ConnectionPool;
import net.myerichsen.hremvp.NavigatorFilter;
import net.myerichsen.hremvp.project.dialogs.ProjectNameSummaryDialog;
import net.myerichsen.hremvp.project.models.ProjectList;
import net.myerichsen.hremvp.project.models.ProjectModel;
import net.myerichsen.hremvp.project.providers.ProjectNewDatabaseProvider;
import net.myerichsen.hremvp.project.providers.ProjectProvider;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Navigator part to display and maintain all HRE projects
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 23. jun. 2019
 *
 */
public class ProjectNavigator {
	private static IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Inject
	private IEventBroker eventBroker;
	@Inject
	private EModelService modelService;
	@Inject
	private MApplication application;

	private ProjectProvider provider;
	private TableViewer tableViewer;
	private NavigatorFilter navigatorFilter;
	private Text textNameFilter;
	private int selectionIndex;

	/**
	 * Constructor
	 *
	 */
	public ProjectNavigator() {
		try {
			provider = new ProjectProvider();
			navigatorFilter = new NavigatorFilter(1);
		} catch (final Exception e) {
			eventBroker.post("MESSAGE", e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 * @param shell
	 */
	protected void backUpSelectedProject() {
		getSelectedProject();

		final ProjectModel model = ProjectList.getModel(selectionIndex);
		final String dbName = model.getName();

		try {
			provider.closeDbIfActive(dbName);

			String path = model.getPath();
			File file = new File(path + ".h2.db");
			if (!file.exists()) {
				file = new File(path + ".mv.db");
			}

			path = file.getParent();
			provider.backupUsingScript(dbName, path);

			LOGGER.log(Level.INFO,
					"Project database {0} has been backed up to {1}\\{2}.zip",
					new Object[] { dbName, path, dbName });
			eventBroker.post("MESSAGE",
					"Project database " + dbName + " has been backed up to "
							+ path + "\\" + dbName + ".zip");
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 * @param shell
	 */
	protected void copyProject(Shell shell) {
		final MessageDialog dialog = new MessageDialog(shell, "Copy As", null,
				"Not yet implemented", MessageDialog.INFORMATION, 0, "OK");
		dialog.open();
	}

	/**
	 * Create contents of the view part
	 *
	 * @param parent
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(2, false));

		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.addFilter(navigatorFilter);

		final Table table = tableViewer.getTable();
		table.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDoubleClick(org.eclipse.
			 * swt.events. MouseEvent)
			 */
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				postProjectPid();
			}
		});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		final GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true,
				2, 1);
		gd_table.widthHint = 394;
		table.setLayoutData(gd_table);

		final TableViewerColumn tableViewerColumnProjectId = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnProjectId = tableViewerColumnProjectId
				.getColumn();
		tblclmnProjectId.setWidth(100);
		tblclmnProjectId.setText("Project Id");
		tableViewerColumnProjectId
				.setLabelProvider(new HREColumnLabelProvider(0));

		final TableViewerColumn tableViewerColumnProjectName = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnProjectName = tableViewerColumnProjectName
				.getColumn();
		tblclmnProjectName.setWidth(100);
		tblclmnProjectName.setText("Project Name");
		tableViewerColumnProjectName
				.setLabelProvider(new HREColumnLabelProvider(1));

		final TableViewerColumn tableViewerColumnLocation = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnLocation = tableViewerColumnLocation
				.getColumn();
		tblclmnLocation.setWidth(100);
		tblclmnLocation.setText("Location");
		tableViewerColumnLocation
				.setLabelProvider(new HREColumnLabelProvider(2));

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		try {
			tableViewer.setInput(provider.getStringList());
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

		final Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem mntmNewProject = new MenuItem(menu, SWT.NONE);
		mntmNewProject.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				newProject(parent.getShell());
			}
		});
		mntmNewProject.setText("New project...");

		final MenuItem mntmOpenSelectedProject = new MenuItem(menu, SWT.NONE);
		mntmOpenSelectedProject.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				openSelectedProject();
			}
		});
		mntmOpenSelectedProject.setText("Open selected project");

		final MenuItem mntmOpenExistingProject = new MenuItem(menu, SWT.NONE);
		mntmOpenExistingProject.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				openExistingProject(parent.getShell());
			}
		});
		mntmOpenExistingProject.setText("Open existing project...");

		final MenuItem mntmBackUpSelected = new MenuItem(menu, SWT.NONE);
		mntmBackUpSelected.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				backUpSelectedProject();
			}
		});
		mntmBackUpSelected.setText("Back up selected project...");

		final MenuItem mntmRestoreAProject = new MenuItem(menu, SWT.NONE);
		mntmRestoreAProject.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				restoreProject(parent.getShell());
			}
		});
		mntmRestoreAProject.setText("Restore a project...");

		final MenuItem mntmCopyProjectAs = new MenuItem(menu, SWT.NONE);
		mntmCopyProjectAs.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				copyProject(parent.getShell());
			}
		});
		mntmCopyProjectAs.setText("Copy project as...");

		final MenuItem mntmRenameSelectedProject = new MenuItem(menu, SWT.NONE);
		mntmRenameSelectedProject.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				renameSelectedProject(parent.getShell());
			}
		});
		mntmRenameSelectedProject.setText("Rename selected project...");

		final MenuItem mntmDeleteSelectedProject = new MenuItem(menu, SWT.NONE);
		mntmDeleteSelectedProject.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				deleteSelectedProject(parent.getShell());
			}
		});
		mntmDeleteSelectedProject.setText("Delete selected project...");

		final Label lblNameFilter = new Label(parent, SWT.NONE);
		lblNameFilter.setText("Name Filter");

		textNameFilter = new Text(parent, SWT.BORDER);
		textNameFilter.addKeyListener(new KeyAdapter() {

			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.KeyAdapter#keyReleased(org.eclipse.swt.
			 * events.KeyEvent)
			 */
			@Override
			public void keyReleased(KeyEvent e) {
				navigatorFilter.setSearchText(textNameFilter.getText());
				tableViewer.refresh();
			}
		});

		textNameFilter.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}

	/**
	 *
	 */
	protected void deleteSelectedProject(Shell shell) {
		getSelectedProject();

		final ProjectModel model = ProjectList.getModel(selectionIndex);
		final String dbName = model.getName();

		// Last chance to regret
		final MessageDialog dialog = new MessageDialog(shell,
				"Delete Project " + dbName, null,
				"Are you sure that you will delete project " + dbName + "?",
				MessageDialog.CONFIRM, 0, "OK", "Cancel");

		if (dialog.open() == Window.CANCEL) {
			eventBroker.post("MESSAGE",
					"Deletion of project " + dbName + " has been canceled");
			return;
		}

		try {
			provider.closeDbIfActive(dbName);
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

		final String path = model.getPath().trim();
		String fullPath = path + ".h2.db";
		File file = new File(fullPath);
		boolean result = false;

		try {
			result = Files.deleteIfExists(file.toPath());
		} catch (final Exception e) {
			fullPath = path + ".mv.db";
			file = new File(fullPath);
			try {
				result = Files.deleteIfExists(file.toPath());
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
			}
		}

		if (result) {
			LOGGER.log(Level.INFO, "Existing database {0} has been deleted",
					fullPath);
		}

		final int projectCount = store.getInt("projectcount");

		String key;
		int index;

		for (int i = 1; i <= projectCount; i++) {
			key = "project." + i + ".path";
			if (store.contains(key)) {
				LOGGER.log(Level.INFO, "Path: {0}, key: {1}, value: {2}",
						new Object[] { path, key, store.getString(key) });

				if (path.equals(store.getString(key).trim())) {
					// Delete from preferences
					index = i;
					ProjectList.remove(index);
					LOGGER.log(Level.INFO, "Project {0} has been deleted",
							dbName);
					eventBroker.post("MESSAGE",
							"Project " + dbName + " has been deleted");
					eventBroker.post(Constants.PROJECT_LIST_UPDATE_TOPIC,
							index);
					break;
				}
			}
		}

	}

	/**
	 * @throws NumberFormatException
	 */
	private void getSelectedProject() {
		selectionIndex = tableViewer.getTable().getSelectionIndex();

		final TableItem[] selection = tableViewer.getTable().getSelection();

		if (selection.length > 0) {
			final TableItem item = selection[0];
//			Integer.parseInt(item.getText(0));
			item.getText(1);
		}
	}

	/**
	 * @param shell
	 */
	protected void newProject(Shell shell) {
		// Open file dialog
		final FileDialog dialog = new FileDialog(shell, SWT.SAVE);
		dialog.setText("Create new HRE Project");
		dialog.setFilterPath("./");
		final String[] extensions = { "*.h2.db", "*.mv.db", "*.*" };
		dialog.setFilterExtensions(extensions);
		dialog.open();

		final String shortName = dialog.getFileName();
		final String[] parts = shortName.split("\\.");
		final String path = dialog.getFilterPath();
		final String dbName = parts[0];

		try {
			// Create the new database
			LOGGER.log(Level.INFO, "New database name: {0}\\{1}",
					new Object[] { path, dbName });

			store.setValue("DBPATH", path);
			store.setValue("DBNAME", dbName);

			final ProjectNewDatabaseProvider pndprovider = new ProjectNewDatabaseProvider(
					shell);

			pndprovider.provide(dbName);

			provider.closeDbIfActive(dbName);

			final String h2Version = store.getString("H2VERSION");
			LOGGER.log(Level.INFO, "Retrieved H2 version from preferences: {0}",
					h2Version.substring(0, 3));

			provider.connectToNewDatabase(dbName, h2Version);

			// Open a dialog for summary
			final ProjectNameSummaryDialog pnsDialog = new ProjectNameSummaryDialog(
					shell);
			pnsDialog.open();

			// Update the HRE properties
			final LocalDateTime now = LocalDateTime.now();
			final ZonedDateTime zdt = now.atZone(ZoneId.systemDefault());
			final Date timestamp = Date.from(zdt.toInstant());
			final ProjectModel model = new ProjectModel(
					pnsDialog.getProjectName(), timestamp,
					pnsDialog.getProjectSummary(), "LOCAL",
					path + "\\" + dbName);

			LOGGER.log(Level.INFO, "New properties {0}, {1}, {2}, LOCAL {3}",
					new Object[] { pnsDialog.getProjectName(), timestamp,
							pnsDialog.getProjectSummary(), dbName });

			final int index = ProjectList.add(model);

			// Set database name in title bar
			final MWindow window = (MWindow) modelService
					.find("net.myerichsen.hremvp.window.main", application);
			window.setLabel("HRE MVP v0.2.2 - " + dbName);

//			openDatabaseNavigator();

			eventBroker.post(Constants.DATABASE_UPDATE_TOPIC, dbName);
			eventBroker.post(Constants.PROJECT_LIST_UPDATE_TOPIC, index);
			eventBroker.post(Constants.PROJECT_PROPERTIES_UPDATE_TOPIC, index);
			eventBroker.post("MESSAGE",
					"Project database " + dbName + " has been created");

			ProjectList.writePreferences();
		} catch (final Exception e1) {
			eventBroker.post("MESSAGE", e1.getMessage());
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}
	}

	/**
	 * @param shell
	 */
	protected void openExistingProject(Shell shell) {
		int index = 0;
		Connection conn = null;

		// Open file dialog
		final FileDialog dialog = new FileDialog(shell);
		final String[] extensions = { "*.h2.db", "*.mv.db", "*.*" };
		dialog.setFilterExtensions(extensions);
		dialog.open();

		final String shortName = dialog.getFileName();
		final String[] parts = shortName.split("\\.");
		final String path = dialog.getFilterPath();
		final String dbName = parts[0];

		try {
			provider.closeDbIfActive(dbName);

			store.setValue("DBPATH", path);
			store.setValue("DBNAME", dbName);

			conn = HreH2ConnectionPool.getConnection(dbName);

			if (conn != null) {
				final String h2Version = store.getString("H2VERSION");
				LOGGER.log(Level.INFO,
						"Retrieved H2 version from preferences: {0}",
						h2Version.substring(0, 3));
				PreparedStatement ps;

				if (h2Version.substring(0, 3).equals("1.3")) {
					ps = conn.prepareStatement(
							"SELECT TABLE_NAME, 0 FROM INFORMATION_SCHEMA.TABLES "
									+ "WHERE TABLE_TYPE = 'TABLE' ORDER BY TABLE_NAME");
				} else {
					ps = conn.prepareStatement(
							"SELECT TABLE_NAME, ROW_COUNT_ESTIMATE FROM INFORMATION_SCHEMA.TABLES "
									+ "WHERE TABLE_TYPE = 'TABLE' ORDER BY TABLE_NAME");
				}

				ps.executeQuery();
				conn.close();
			}

			final int projectCount = store.getInt("projectcount");
			String key;
			boolean alreadyRegistered = false;

			for (int i = 0; i < projectCount; i++) {
				key = "project." + i + ".path";
				if ((store.contains(key))
						&& (dbName.equals(store.getString(key)))) {
					alreadyRegistered = true;
					LOGGER.log(Level.INFO, "Project {0} already registered",
							dbName);
					break;
				}
			}

			if (!alreadyRegistered) {
				// Open a dialog for summary
				final ProjectNameSummaryDialog pnsDialog = new ProjectNameSummaryDialog(
						shell);
				pnsDialog.open();

				// Update the HRE properties
				File file = new File(dbName + ".h2.db");
				if (!file.exists()) {
					file = new File(dbName + ".mv.db");
				}
				final Date timestamp = new Date(file.lastModified());
				final ProjectModel model = new ProjectModel(
						pnsDialog.getProjectName(), timestamp,
						pnsDialog.getProjectSummary(), "LOCAL",
						path + "\\" + dbName);
				index = ProjectList.add(model);

				// Set database name in title bar
				final MWindow window = (MWindow) modelService
						.find("net.myerichsen.hremvp.window.main", application);
				window.setLabel("HRE v0.2 - " + dbName);
			}

//			openDatabaseNavigator();

			eventBroker.post(Constants.DATABASE_UPDATE_TOPIC, dbName);

			if (index > 0) {
				eventBroker.post(Constants.PROJECT_LIST_UPDATE_TOPIC, index);
				eventBroker.post(Constants.PROJECT_PROPERTIES_UPDATE_TOPIC,
						index);
			}

			eventBroker.post("MESSAGE",
					"Project database " + dbName + " has been opened");
		} catch (

		final Exception e1) {
			eventBroker.post("MESSAGE", e1.getMessage());
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}

	}

	/**
	 * @param shell
	 */
	protected void openSelectedProject() {
		Connection conn = null;

		try {
			provider.closeDbIfActive(store.getString("DBNAME"));

			getSelectedProject();

			final ProjectModel model = ProjectList.getModel(selectionIndex);
			final String dbName = model.getName();

			String path = model.getPath();
			File file = new File(path + ".h2.db");
			if (file.exists()) {
				path = file.getParent();
			} else {
				file = new File(path + ".mv.db");
				if (file.exists()) {
					path = file.getParent();
				}
			}

			store.setValue("DBNAME", dbName);
			store.setValue("DBPATH", path);

			conn = HreH2ConnectionPool.getConnection(dbName);

			if (conn != null) {
				final String h2Version = store.getString("H2VERSION");
				LOGGER.log(Level.INFO,
						"Retrieved H2 version from preferences: {0} ",
						h2Version.substring(0, 3));
				PreparedStatement ps;

				if (h2Version.substring(0, 3).equals("1.3")) {
					ps = conn.prepareStatement(
							"SELECT TABLE_NAME, 0 FROM INFORMATION_SCHEMA.TABLES "
									+ "WHERE TABLE_TYPE = 'TABLE' ORDER BY TABLE_NAME");
				} else {
					ps = conn.prepareStatement(
							"SELECT TABLE_NAME, ROW_COUNT_ESTIMATE FROM INFORMATION_SCHEMA.TABLES "
									+ "WHERE TABLE_TYPE = 'TABLE' ORDER BY TABLE_NAME");
				}

				ps.executeQuery();
				conn.close();
			}

			// Set database name in title bar
			final MWindow window = (MWindow) modelService
					.find("net.myerichsen.hremvp.window.main", application);
			window.setLabel("HRE MVP v0.2 - " + dbName);

//			openDatabaseNavigator();

			eventBroker.post(Constants.DATABASE_UPDATE_TOPIC, dbName);

			if (selectionIndex > 0) {
				eventBroker.post(Constants.PROJECT_LIST_UPDATE_TOPIC,
						selectionIndex + 1);
				eventBroker.post(Constants.PROJECT_PROPERTIES_UPDATE_TOPIC,
						selectionIndex + 1);
			}

			eventBroker.post("MESSAGE",
					"Project database " + dbName + " has been opened");
		} catch (final Exception e1) {
			eventBroker.post("MESSAGE", e1.getMessage());
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}

	}

	/**
	 *
	 */
	private void postProjectPid() {
		final int projectPid = tableViewer.getTable().getSelectionIndex() + 1;
		eventBroker.post(Constants.PROJECT_PROPERTIES_UPDATE_TOPIC, projectPid);
		eventBroker.post(Constants.DATABASE_UPDATE_TOPIC,
				store.getString("DBNAME"));
		LOGGER.log(Level.INFO, "Project Navigator posted selection index {0}",
				projectPid);
	}

	/**
	 *
	 */
	protected void renameSelectedProject(Shell shell) {
		final MessageDialog dialog = new MessageDialog(shell, "Rename", null,
				"Not yet implemented", MessageDialog.INFORMATION, 0, "OK");
		dialog.open();
	}

	/**
	 *
	 */
	protected void restoreProject(Shell shell) {
		int index = 0;

		// Open file dialog
		final FileDialog dialog = new FileDialog(shell, SWT.OPEN);
		dialog.setText("Restore an HRE Project");
		dialog.setFilterPath("./");
		final String[] extensions = { "*.zip", "*.*" };
		dialog.setFilterExtensions(extensions);
		dialog.open();

		final String shortName = dialog.getFileName();
		final String[] parts = shortName.split("\\.");
		final String path = dialog.getFilterPath();
		final String dbName = parts[0];

		try {
			provider.closeDbIfActive(dbName);
		} catch (final SQLException e1) {
			LOGGER.log(Level.INFO, e1.getMessage());
		}

		try {
			String fullPath = MessageFormat.format("{0}\\{1}.h2.db", path,
					dbName);
			File file = new File(fullPath);

			boolean result = false;

			result = Files.deleteIfExists(file.toPath());

			if (!result) {
				fullPath = MessageFormat.format("{0}\\{1}.mv.db", path, dbName);
				file = new File(fullPath);
				result = Files.deleteIfExists(file.toPath());
			}

			if (result) {
				LOGGER.log(Level.INFO, "Existing database {0} has been deleted",
						dbName);
			}

			final String[] bkp = { "-url", "jdbc:h2:" + path + "\\" + dbName,
					"-user", store.getString("USERID"), "-script",
					path + "\\" + dbName + ".zip", "-options", "compression",
					"zip" };
			RunScript.main(bkp);

			final int projectCount = store.getInt("projectcount");
			String key;
			boolean alreadyRegistered = false;

			for (int i = 0; i < projectCount; i++) {
				key = "project." + i + ".path";
				if ((store.contains(key))
						|| (dbName.equals(store.getString(key)))) {
					alreadyRegistered = true;
					LOGGER.log(Level.INFO, "Project {0} already registered",
							dbName);
					break;
				}
			}

			if (!alreadyRegistered) {
				// Open a dialog for summary
				final ProjectNameSummaryDialog pnsDialog = new ProjectNameSummaryDialog(
						shell);
				pnsDialog.open();

				// Update the HRE properties
				if (!file.exists()) {
					file = new File(dbName + ".mv.db");
				}
				final Date timestamp = new Date(file.lastModified());
				final ProjectModel model = new ProjectModel(
						pnsDialog.getProjectName(), timestamp,
						pnsDialog.getProjectSummary(), "LOCAL",
						path + "\\" + dbName);
				index = ProjectList.add(model);

				// Set database name in title bar
				final MWindow window = (MWindow) modelService
						.find("net.myerichsen.hremvp.window.main", application);
				window.setLabel("HRE v0.2 - " + dbName);
			}

//			openDatabaseNavigator();

			eventBroker.post(Constants.DATABASE_UPDATE_TOPIC, dbName);

			if (index > 0) {
				eventBroker.post(Constants.PROJECT_LIST_UPDATE_TOPIC, index);
				eventBroker.post(Constants.PROJECT_PROPERTIES_UPDATE_TOPIC,
						index);
			}

			LOGGER.log(Level.INFO,
					"Project database has been restored from {0}", shortName);
			eventBroker.post("MESSAGE",
					"Project database has been restored from " + shortName);
		} catch (

		final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

	}

	/**
	 * @param dbName
	 */
	@Inject
	@Optional
	private void subscribeProjectListUpdateTopic(
			@UIEventTopic(Constants.PROJECT_LIST_UPDATE_TOPIC) int key) {
		LOGGER.log(Level.INFO, "Received project index {0}", key);
		try {
			tableViewer.setInput(provider.getStringList());
			tableViewer.refresh();
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}
}