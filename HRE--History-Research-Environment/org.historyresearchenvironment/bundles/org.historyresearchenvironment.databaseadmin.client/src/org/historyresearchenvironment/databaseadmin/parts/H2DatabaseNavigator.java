package org.historyresearchenvironment.databaseadmin.parts;

import java.sql.SQLException;
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
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.historyresearchenvironment.databaseadmin.dataaccess.models.H2DatabaseModel;
import org.historyresearchenvironment.databaseadmin.dataaccess.providers.H2DatabaseProvider;

/**
 * Create a view part with all tables in the database
 * 
 * @version 2018-07-23
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
@SuppressWarnings("restriction")
public class H2DatabaseNavigator {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;

	@Inject
	private IEventBroker eventBroker;
	// @Inject
	// private EModelService modelService;
	// @Inject
	// private MApplication application;
	private final IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.historyresearchenvironment");
	private Table table;
	private String dbName;

	/**
	 * Constructor
	 *
	 */
	public H2DatabaseNavigator() {
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 *            Shell
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		LOGGER.info("Creating controls");
		parent.setLayout(new GridLayout(1, false));

		final TableViewer tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				final TableItem[] selectedRows = table.getSelection();
				final TableItem selectedRow = selectedRows[0];
				final String tableName = selectedRow.getText(0);

				final ParameterizedCommand command = commandService.createCommand(
						"org.historyresearchenvironment.databaseadmin.client.command.tablenavigatoropen", null);
				handlerService.executeHandler(command);
				eventBroker.post(org.historyresearchenvironment.client.HreConstants.TABLENAME_UPDATE_TOPIC, tableName);
				eventBroker.post("MESSAGE", tableName + " has been opened");
			}
		});
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		final TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		final TableColumn tblclmnTableName = tableViewerColumn.getColumn();
		tblclmnTableName.setWidth(405);
		tblclmnTableName.setText("Table Name");

		final TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		final TableColumn tblclmnRowCount = tableViewerColumn_1.getColumn();
		tblclmnRowCount.setWidth(70);
		tblclmnRowCount.setText("Row Count");

		updateGui();
	}

	/**
	 * 
	 */
	@PreDestroy
	public void dispose() {
	}

	/**
	 * 
	 */
	@Focus
	public void setFocus() {
	}

	/**
	 * @param data.tableName
	 */
	@Inject
	@Optional
	private void subscribeDatabaseNameUpdateTopic(
			@UIEventTopic(org.historyresearchenvironment.client.HreConstants.DATABASE_UPDATE_TOPIC) String dbName2) {
		this.dbName = dbName2;
		LOGGER.info(dbName2);
		updateGui();
	}

	/**
	 * 
	 */
	private void updateGui() {
		if ((dbName == null) || (dbName == "")) {
			dbName = preferences.get("DBNAME", "./SAMPLE");
		}

		// final MWindow window = (MWindow) modelService
		// .find("org.historyresearchenvironment.client.window.main", application);
		// window.setLabel("HRE v0.1 - " + dbName);
		table.removeAll();

		H2DatabaseProvider provider;
		try {
			provider = new H2DatabaseProvider();

			final List<H2DatabaseModel> modelList = provider.getModelList();
			H2DatabaseModel model;

			for (int i = 0; i < modelList.size(); i++) {
				model = modelList.get(i);
				final TableItem item = new TableItem(table, SWT.NONE);
				item.setText(0, model.getTableName());
				item.setText(1, Long.toString(model.getRowCount()));
			}
		} catch (final SQLException e) {
			eventBroker.post("MESSAGE", e.getMessage());
			LOGGER.severe(e.getMessage());
		}
	}
}