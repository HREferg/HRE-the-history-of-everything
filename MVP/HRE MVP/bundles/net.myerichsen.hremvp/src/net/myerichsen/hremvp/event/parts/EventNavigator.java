package net.myerichsen.hremvp.event.parts;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

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
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.NavigatorFilter;
import net.myerichsen.hremvp.event.providers.EventProvider;
import net.myerichsen.hremvp.event.wizards.NewEventWizard;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Display all events
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 23. jun. 2019
 *
 */
public class EventNavigator {
	private static final String MESSAGE = "MESSAGE";

	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Inject
	private IEventBroker eventBroker;

	private final EventProvider provider;
	private final NavigatorFilter nameFilter;
	private final NavigatorFilter fromDateFilter;
	private TableViewer tableViewer;

	/**
	 * Constructor
	 *
	 */
	public EventNavigator() {
		provider = new EventProvider();
		nameFilter = new NavigatorFilter(4);
		fromDateFilter = new NavigatorFilter(1);
	}

	/**
	 * Create contents of the view part
	 *
	 * @param parent  The parent composite
	 * @param context The Eclipse context
	 */
	@PostConstruct
	public void createControls(Composite parent, IEclipseContext context) {
		parent.setLayout(new GridLayout(1, false));

		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.addFilter(nameFilter);
		tableViewer.addFilter(fromDateFilter);

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
				postEventPid();
			}
		});
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		final TableViewerColumn tableViewerColumnID = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnId = tableViewerColumnID.getColumn();
		tblclmnId.setWidth(50);
		tblclmnId.setText("Event ID");
		tableViewerColumnID.setLabelProvider(new HREColumnLabelProvider(0));

		final TableViewerColumn tableViewerColumnFromDate = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnFromDate = tableViewerColumnFromDate
				.getColumn();
		tblclmnFromDate.setWidth(100);
		tblclmnFromDate.setText("From Date");
		tableViewerColumnFromDate
				.setLabelProvider(new HREColumnLabelProvider(1));

		final TableViewerColumn tableViewerColumnToDate = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnToDate = tableViewerColumnToDate.getColumn();
		tblclmnToDate.setWidth(100);
		tblclmnToDate.setText("To Date");
		tableViewerColumnToDate.setLabelProvider(new HREColumnLabelProvider(2));

		final TableViewerColumn tableViewerColumnAbbreviation = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnAbbreviation = tableViewerColumnAbbreviation
				.getColumn();
		tblclmnAbbreviation.setWidth(100);
		tblclmnAbbreviation.setText("Abbreviation");
		tableViewerColumnAbbreviation
				.setLabelProvider(new HREColumnLabelProvider(4));

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());

		try {
			tableViewer.setInput(provider.getStringList());
		} catch (final Exception e1) {
			LOGGER.log(Level.FINE, e1.getMessage());
		}

		final Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem mntmAddevent = new MenuItem(menu, SWT.NONE);
		mntmAddevent.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final WizardDialog dialog = new WizardDialog(parent.getShell(),
						new NewEventWizard(context));
				dialog.open();
			}
		});
		mntmAddevent.setText("Add event...");

		final MenuItem mntmDeleteSelectedevent = new MenuItem(menu, SWT.NONE);
		mntmDeleteSelectedevent.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				deleteEvent(parent.getShell());
			}
		});
		mntmDeleteSelectedevent.setText("Delete selected event...");

		final Label lblNameFilter = new Label(parent, SWT.NONE);
		lblNameFilter.setText("Abbreviation Filter");

		final Text textNameFilter = new Text(parent, SWT.BORDER);
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
				nameFilter.setSearchText(textNameFilter.getText());
				LOGGER.log(Level.FINE, "Name filter string: {0}",
						textNameFilter.getText());
				tableViewer.refresh();
			}
		});

		textNameFilter.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Label lblFromDateFilter = new Label(parent, SWT.NONE);
		lblFromDateFilter.setText("From Date Filter");

		final Text textFromDateFilter = new Text(parent, SWT.BORDER);
		textFromDateFilter.addKeyListener(new KeyAdapter() {

			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.KeyAdapter#keyReleased(org.eclipse.swt.
			 * events.KeyEvent)
			 */
			@Override
			public void keyReleased(KeyEvent e) {
				fromDateFilter.setSearchText(textFromDateFilter.getText());
				LOGGER.log(Level.FINE, "Date filter string: {0}",
						textFromDateFilter.getText());
				tableViewer.refresh();
			}
		});
		textFromDateFilter.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

	}

	/**
	 *
	 */
	protected void deleteEvent(Shell shell) {
		final TableItem[] selection = tableViewer.getTable().getSelection();

		int eventPid = 0;
		String primaryName = null;
		if (selection.length > 0) {
			final TableItem item = selection[0];
			eventPid = Integer.parseInt(item.getText(0));
			primaryName = item.getText(1);
		}

		// Last chance to regret
		final MessageDialog dialog = new MessageDialog(shell,
				"Delete event " + primaryName, null,
				"Are you sure that you will delete event " + eventPid + ", "
						+ primaryName + "?",
				MessageDialog.CONFIRM, 0, "OK", "Cancel");

		if (dialog.open() == Window.CANCEL) {
			eventBroker.post(MESSAGE,
					"Deletion of event " + primaryName + " has been canceled");
			return;
		}

		try {
			final EventProvider ep = new EventProvider();
			ep.delete(eventPid);

			LOGGER.log(Level.FINE, "Event {0} has been deleted", primaryName);
			eventBroker.post(MESSAGE,
					"event " + primaryName + " has been deleted");
			eventBroker.post(Constants.EVENT_PID_UPDATE_TOPIC, eventPid);
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 * @param eventPid
	 */
	@Inject
	@Optional
	private void subscribeEventPidUpdateTopic(
			@UIEventTopic(Constants.EVENT_PID_UPDATE_TOPIC) int eventPid) {
		LOGGER.log(Level.INFO, "Received event id {0}", eventPid);

		if (eventPid > 0) {
			try {
				tableViewer.setInput(provider.getStringList());
				tableViewer.refresh();

				final TableItem[] items = tableViewer.getTable().getItems();
				final String item0 = Integer.toString(eventPid);

				for (int i = 0; i < items.length; i++) {
					if (item0.equals(items[i].getText(0))) {
						tableViewer.getTable().setSelection(i);
						break;
					}
				}
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}
		}
	}

	/**
	 */
	private void postEventPid() {
		int eventPid = 0;

		final TableItem[] selectedRows = tableViewer.getTable().getSelection();

		if (selectedRows.length > 0) {
			final TableItem selectedRow = selectedRows[0];
			eventPid = Integer.parseInt(selectedRow.getText(0));
		}

		eventBroker.post(net.myerichsen.hremvp.Constants.EVENT_PID_UPDATE_TOPIC,
				eventPid);
		LOGGER.log(Level.FINE, "Event Pid: {0}", eventPid);
	}
}
