package net.myerichsen.hremvp.person.parts;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
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

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.person.providers.SexProvider;
import net.myerichsen.hremvp.person.wizards.NewPersonSexWizard;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Display all sexes for a single person
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 23. apr. 2019
 */
@SuppressWarnings("restriction")
public class PersonSexesNavigator {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Inject
	private IEventBroker eventBroker;
	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;

	private TableViewer tableViewer;
	private SexProvider provider;
	private int personPid = 0;

	/**
	 * Constructor
	 *
	 */
	public PersonSexesNavigator() {
		try {
			provider = new SexProvider();
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 * Create contents of the view part
	 *
	 * @param parent The parent composite
	 */
	@PostConstruct
	public void createControls(Composite parent, IEclipseContext context) {
		parent.setLayout(new GridLayout(1, false));

		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		final Table table = tableViewer.getTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				openSexView();
			}
		});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));

		final TableViewerColumn tableViewerColumnId = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnSexId = tableViewerColumnId.getColumn();
		tblclmnSexId.setWidth(100);
		tblclmnSexId.setText("Sex Id");
		tableViewerColumnId.setLabelProvider(new HREColumnLabelProvider(0));

		final TableViewerColumn tableViewerColumnLabel = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnSex = tableViewerColumnLabel.getColumn();
		tblclmnSex.setWidth(97);
		tblclmnSex.setText("Sex");
		tableViewerColumnLabel.setLabelProvider(new HREColumnLabelProvider(3));

		final TableViewerColumn tableViewerColumnPrimary = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnSexPrimary = tableViewerColumnPrimary
				.getColumn();
		tblclmnSexPrimary.setWidth(83);
		tblclmnSexPrimary.setText("Primary");
		tableViewerColumnPrimary
				.setLabelProvider(new HREColumnLabelProvider(4));

		final TableViewerColumn tableViewerColumnFromDate = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnFrom = tableViewerColumnFromDate.getColumn();
		tblclmnFrom.setWidth(100);
		tblclmnFrom.setText("From");
		tableViewerColumnFromDate
				.setLabelProvider(new HREColumnLabelProvider(5));

		final TableViewerColumn tableViewerColumnToDate = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnTo = tableViewerColumnToDate.getColumn();
		tblclmnTo.setWidth(100);
		tblclmnTo.setText("To");
		tableViewerColumnToDate.setLabelProvider(new HREColumnLabelProvider(6));

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		try {
			tableViewer.setInput(provider.getStringList(personPid));
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}

		final Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final WizardDialog dialog = new WizardDialog(parent.getShell(),
						new NewPersonSexWizard(personPid, context));
				dialog.open();
			}
		});
		mntmNewItem.setText("Add a sex...");

		final MenuItem mntmRemoveSelectedSex = new MenuItem(menu, SWT.NONE);
		mntmRemoveSelectedSex.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeSex(parent.getShell());
			}
		});
		mntmRemoveSelectedSex.setText("Remove selected sex...");

	}

	/**
	 *
	 */
	protected void openSexView() {
		int sexPid = 0;

		final ParameterizedCommand command = commandService.createCommand(
				"net.myerichsen.hremvp.command.opensexview", null);
		handlerService.executeHandler(command);

		final TableItem[] selectedRows = tableViewer.getTable().getSelection();

		if (selectedRows.length > 0) {
			final TableItem selectedRow = selectedRows[0];
			sexPid = Integer.parseInt(selectedRow.getText(0));
		}

		LOGGER.log(Level.INFO, "Setting sex pid: {0}",
				Integer.toString(sexPid));
		eventBroker.post(Constants.SEX_PID_UPDATE_TOPIC, sexPid);
	}

	/**
	 * @param shell
	 */
	protected void removeSex(Shell shell) {
		final TableItem[] selection = tableViewer.getTable().getSelection();

		int sexPid = 0;
		String primaryName = null;
		if (selection.length > 0) {
			final TableItem item = selection[0];
			sexPid = Integer.parseInt(item.getText(0));
			primaryName = item.getText(1);
		}

		// Last chance to regret
		final MessageDialog dialog = new MessageDialog(shell,
				"Remove sex " + primaryName, null,
				"Are you sure that you will remove sex " + sexPid + ", "
						+ primaryName + "?",
				MessageDialog.CONFIRM, 0, "OK", "Cancel");

		if (dialog.open() == Window.CANCEL) {
			eventBroker.post("MESSAGE",
					"Removal of sex " + primaryName + " has been canceled");
			return;
		}

		try {
			provider.removeSex(sexPid);
			eventBroker.post("MESSAGE",
					"Sex " + primaryName + " has been removed");
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

	}

	/**
	 * @param personPid
	 */
	@Inject
	@Optional
	private void subscribePersonPidUpdateTopic(
			@UIEventTopic(Constants.PERSON_PID_UPDATE_TOPIC) int personPid) {
		LOGGER.log(Level.INFO, "Received person id {0}",
				Integer.toString(personPid));
		this.personPid = personPid;

		try {
			tableViewer.setInput(provider.getStringList(personPid));
			tableViewer.refresh();
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

}
