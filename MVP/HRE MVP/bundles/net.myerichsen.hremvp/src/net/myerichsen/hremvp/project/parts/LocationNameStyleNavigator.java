package net.myerichsen.hremvp.project.parts;

import java.util.ArrayList;
import java.util.List;
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
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.project.providers.LocationNameMapProvider;
import net.myerichsen.hremvp.project.providers.LocationNameStyleProvider;
import net.myerichsen.hremvp.project.wizards.NewLocationNameStyleWizard;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Display all location name styles
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 20. apr. 2019
 *
 */
@SuppressWarnings("restriction")
public class LocationNameStyleNavigator {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;
	@Inject
	private IEventBroker eventBroker;

	private LocationNameStyleProvider provider;
	private int locationNameStylePid;

	private TableViewer tableViewer;

	public LocationNameStyleNavigator() {
		try {
			provider = new LocationNameStyleProvider();
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent, IEclipseContext context) {
		parent.setLayout(new GridLayout(1, false));

		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		final Table table = tableViewer.getTable();
		table.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDoubleClick(org.eclipse.
			 * swt.events.MouseEvent)
			 */
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				openLocationNameStyleView();
			}
		});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		final TableViewerColumn tableViewerColumnStyleId = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnStyleId = tableViewerColumnStyleId.getColumn();
		tblclmnStyleId.setWidth(80);
		tblclmnStyleId.setText("Style Id");
		tableViewerColumnStyleId
				.setLabelProvider(new HREColumnLabelProvider(0));

		final TableViewerColumn tableViewerColumnIsoCode = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnIsoCode = tableViewerColumnIsoCode.getColumn();
		tblclmnIsoCode.setWidth(80);
		tblclmnIsoCode.setText("ISO Code");
		tableViewerColumnIsoCode
				.setLabelProvider(new HREColumnLabelProvider(1));

		final TableViewerColumn tableViewerColumnStyleName = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnStyleName = tableViewerColumnStyleName
				.getColumn();
		tblclmnStyleName.setWidth(300);
		tblclmnStyleName.setText("Style Name");
		tableViewerColumnStyleName
				.setLabelProvider(new HREColumnLabelProvider(2));

		final Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem mntmAddNameStyle = new MenuItem(menu, SWT.NONE);
		mntmAddNameStyle.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final WizardDialog dialog = new WizardDialog(parent.getShell(),
						new NewLocationNameStyleWizard(context));
				dialog.open();
			}
		});
		mntmAddNameStyle.setText("Add name style...");

		final MenuItem mntmDeleteSelectedName = new MenuItem(menu, SWT.NONE);
		mntmDeleteSelectedName.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				deleteLocationNameStyle(parent.getShell());
			}
		});
		mntmDeleteSelectedName.setText("Delete selected name style...");

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		try {
			tableViewer.setInput(provider.getStringList());
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.getMessage());
		}
	}

	/**
	 * @param shell
	 */
	protected void deleteLocationNameStyle(Shell shell) {
		final TableItem[] selection = tableViewer.getTable().getSelection();

		String locationNameStyleName = null;
		if (selection.length > 0) {
			final TableItem item = selection[0];
			locationNameStylePid = Integer.parseInt(item.getText(0));
			locationNameStyleName = item.getText(2);
		}

		// Last chance to regret
		final MessageDialog dialog = new MessageDialog(shell,
				"Delete location name style " + locationNameStyleName, null,
				"Are you sure that you will delete " + locationNameStylePid
						+ ", " + locationNameStyleName + "?",
				MessageDialog.CONFIRM, 0, "OK", "Cancel");

		if (dialog.open() == Window.CANCEL) {
			eventBroker.post("MESSAGE", "Delete of location name style "
					+ locationNameStyleName + " has been canceled");
			return;
		}

		try {
			final LocationNameMapProvider lnmp = new LocationNameMapProvider();
			lnmp.deleteLocationNameStylePid(locationNameStylePid);
			LOGGER.log(Level.INFO, "Location name map(s) has been deleted");

			provider = new LocationNameStyleProvider();
			provider.delete(locationNameStylePid);
			eventBroker.post("MESSAGE", "Location name style "
					+ locationNameStyleName + " has been deleted");
			eventBroker.post(Constants.LOCATION_NAME_STYLE_PID_UPDATE_TOPIC,
					locationNameStylePid);
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

	}

	/**
	 *
	 */
	protected void openLocationNameStyleView() {
		final ParameterizedCommand command = commandService.createCommand(
				"net.myerichsen.hremvp.command.openlocationnamestyleview",
				null);
		handlerService.executeHandler(command);

		final TableItem[] selectedRows = tableViewer.getTable().getSelection();

		if (selectedRows.length > 0) {
			final TableItem selectedRow = selectedRows[0];
			locationNameStylePid = Integer.parseInt(selectedRow.getText(0));
			final List<String> ls = new ArrayList<>();
			ls.add(selectedRow.getText(0));
			ls.add(selectedRow.getText(1));
			ls.add(selectedRow.getText(2));

			LOGGER.log(Level.INFO,
					"Posting style id " + selectedRow.getText(0) + ", iso code "
							+ selectedRow.getText(1) + ", label "
							+ selectedRow.getText(2));
			eventBroker.post(Constants.LABEL_PID_UPDATE_TOPIC, ls);
		}

	}

	/**
	 * @param key
	 * @throws MvpException
	 */
	@Inject
	@Optional
	private void subscribelocationNameStylePidUpdateTopic(
			@UIEventTopic(Constants.LOCATION_NAME_STYLE_PID_UPDATE_TOPIC) int locationNameStylePid) {
		LOGGER.log(Level.FINE, "Received location name style id {0}",
				locationNameStylePid);
		this.locationNameStylePid = locationNameStylePid;

		if (locationNameStylePid > 0) {
			try {
				tableViewer.setInput(provider.getStringList());
				tableViewer.refresh();

				final TableItem[] items = tableViewer.getTable().getItems();
				final String item0 = Integer.toString(locationNameStylePid);

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

}
