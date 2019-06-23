package net.myerichsen.hremvp.location.parts;

import java.util.List;
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
import net.myerichsen.hremvp.location.providers.LocationEventProvider;
import net.myerichsen.hremvp.location.providers.LocationNamePartProvider;
import net.myerichsen.hremvp.location.providers.LocationNameProvider;
import net.myerichsen.hremvp.location.providers.LocationProvider;
import net.myerichsen.hremvp.location.wizards.NewLocationWizard;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Display all locations
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 23. jun. 2019
 *
 */
public class LocationNavigator {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Inject
	private IEventBroker eventBroker;

	private LocationProvider provider;
	private TableViewer tableViewer;
	private NavigatorFilter navigatorFilter;

	/**
	 * Constructor
	 *
	 */
	public LocationNavigator() {
		try {
			provider = new LocationProvider();
			navigatorFilter = new NavigatorFilter(1);
		} catch (final Exception e) {
			eventBroker.post("MESSAGE", e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 * Create contents of the view part
	 *
	 * @param parent  The parent composite
	 * @param context The Eclipse context
	 */
	@PostConstruct
	public void createControls(Composite parent, IEclipseContext context) {
		parent.setLayout(new GridLayout(2, false));

		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		final Table table = tableViewer.getTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				postLocationPid();
			}
		});

		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		final TableViewerColumn tableViewerColumnId = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnId = tableViewerColumnId.getColumn();
		tblclmnId.setWidth(50);
		tblclmnId.setText("ID");
		tableViewerColumnId.setLabelProvider(new HREColumnLabelProvider(0));

		final TableViewerColumn tableViewerColumnName = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnPrimaryLocationName = tableViewerColumnName
				.getColumn();
		tblclmnPrimaryLocationName.setWidth(400);
		tblclmnPrimaryLocationName.setText("Primary Location Name");
		tableViewerColumnName.setLabelProvider(new HREColumnLabelProvider(1));

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		try {
			tableViewer.setInput(provider.getStringList());
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
			eventBroker.post("MESSAGE", e1.getMessage());
		}

		final Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem mntmAddLocation = new MenuItem(menu, SWT.NONE);
		mntmAddLocation.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final WizardDialog dialog = new WizardDialog(parent.getShell(),
						new NewLocationWizard(context));
				dialog.open();
			}
		});
		mntmAddLocation.setText("Add location...");

		final MenuItem mntmDeleteSelectedLocation = new MenuItem(menu,
				SWT.NONE);
		mntmDeleteSelectedLocation.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				deleteLocation(parent.getShell());
			}
		});
		mntmDeleteSelectedLocation.setText("Delete selected location...");

		final Label lblNameFilter = new Label(parent, SWT.NONE);
		lblNameFilter.setText("Name Filter");

		final Text textNameFilter = new Text(parent, SWT.BORDER);
		textNameFilter.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				navigatorFilter.setSearchText(textNameFilter.getText());
				LOGGER.log(Level.FINE, "Filter string: {0}",
						textNameFilter.getText());
				tableViewer.refresh();
			}
		});

		textNameFilter.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}

	/**
	 * @param shell
	 */
	protected void deleteLocation(Shell shell) {
		final TableItem[] selection = tableViewer.getTable().getSelection();

		int locationPid = 0;
		String primaryName = null;
		if (selection.length > 0) {
			final TableItem item = selection[0];
			locationPid = Integer.parseInt(item.getText(0));
			primaryName = item.getText(1);
		}

		// Last chance to regret
		final MessageDialog dialog = new MessageDialog(shell,
				"Delete location " + primaryName, null,
				"Are you sure that you will delete location " + locationPid
						+ ", " + primaryName + "?",
				MessageDialog.CONFIRM, 0, "OK", "Cancel");

		if (dialog.open() == Window.CANCEL) {
			eventBroker.post("MESSAGE",
					"Delete of location " + primaryName + " has been canceled");
			return;
		}

		try {
			// Delete all location events for location
			final LocationEventProvider lep = new LocationEventProvider();
			lep.deleteAllEventLinksForLocation(locationPid);

			// Delete all location name parts
			final LocationNameProvider lnp = new LocationNameProvider();
			final List<Integer> locationNamePidList = lnp
					.getFKLocationPid(locationPid);

			final LocationNamePartProvider lnpp = new LocationNamePartProvider();
			for (int i = 0; i < locationNamePidList.size(); i++) {
				lnpp.deleteAllNamePartsForLocationName(
						locationNamePidList.get(i));
			}

			// Delete all location names for location
			lnp.deleteAllNamesForLocation(locationPid);

			// Delete location
			provider = new LocationProvider();
			provider.delete(locationPid);

			LOGGER.log(Level.INFO, "Location {0} has been deleted",
					primaryName);
			eventBroker.post("MESSAGE",
					"Location " + primaryName + " has been deleted");
			eventBroker.post(Constants.LOCATION_PID_UPDATE_TOPIC, locationPid);
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 *
	 */
	protected void postLocationPid() {
		int locationPid = 0;

		// Post location pid
		final TableItem[] selectedRows = tableViewer.getTable().getSelection();

		if (selectedRows.length > 0) {
			final TableItem selectedRow = selectedRows[0];
			locationPid = Integer.parseInt(selectedRow.getText(0));
		}

		eventBroker.post(
				net.myerichsen.hremvp.Constants.LOCATION_PID_UPDATE_TOPIC,
				locationPid);
		LOGGER.log(Level.INFO, "Location Pid: {0}", locationPid);
	}

	/**
	 * @param personPid
	 */
	@Inject
	@Optional
	private void subscribeLocationPidUpdateTopic(
			@UIEventTopic(Constants.LOCATION_PID_UPDATE_TOPIC) int locationPid) {
		LOGGER.log(Level.FINE, "Received person id {0}", locationPid);

		if (locationPid > 0) {
			try {
				tableViewer.setInput(provider.getStringList());
				tableViewer.refresh();

				final TableItem[] items = tableViewer.getTable().getItems();
				final String item0 = Integer.toString(locationPid);

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
