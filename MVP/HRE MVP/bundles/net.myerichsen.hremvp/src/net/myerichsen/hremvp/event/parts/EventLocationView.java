package net.myerichsen.hremvp.event.parts;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
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
import net.myerichsen.hremvp.location.dialogs.LocationNavigatorDialog;
import net.myerichsen.hremvp.location.providers.LocationEventProvider;
import net.myerichsen.hremvp.location.providers.LocationNamePartProvider;
import net.myerichsen.hremvp.location.providers.LocationNameProvider;
import net.myerichsen.hremvp.location.providers.LocationProvider;
import net.myerichsen.hremvp.location.wizards.NewLocationWizard;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Display all locations for a single event
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 23. jun. 2019
 */
public class EventLocationView {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Inject
	private EPartService partService;
	@Inject
	private EModelService modelService;
	@Inject
	private MApplication application;
	@Inject
	private IEventBroker eventBroker;

	private TableViewer tableViewer;
	private final LocationEventProvider provider;
	private List<List<String>> lls;
	private int eventPid = 0;

	/**
	 * Constructor
	 *
	 */
	public EventLocationView() {
		provider = new LocationEventProvider();
		LOGGER.log(Level.INFO, "Provider: {0}", provider.getClass().getName());
	}

	/**
	 * @param shell
	 */
	protected void browseLocation(Shell shell) {
		final LocationNavigatorDialog dialog = new LocationNavigatorDialog(
				shell);
		if (dialog.open() == Window.OK) {
			try {
				final List<String> stringList = new ArrayList<>();
				final int locationPid = dialog.getLocationPid();
				stringList.add(Integer.toString(locationPid));
				stringList.add(dialog.getLocationName());
				lls.add(stringList);

				final LocationEventProvider lep = new LocationEventProvider();
				lep.setEventPid(eventPid);
				lep.setLocationPid(locationPid);
				lep.setPrimaryEvent(false);
				lep.setPrimaryLocation(false);
				lep.insert();

			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}
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
				openLocationView();
			}
		});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));

		final TableViewerColumn tableViewerColumnEventId = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnId = tableViewerColumnEventId.getColumn();
		tblclmnId.setWidth(100);
		tblclmnId.setText("ID");
		tableViewerColumnEventId
				.setLabelProvider(new HREColumnLabelProvider(0));

		final TableViewerColumn tableViewerColumnEventLabel = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnLocation = tableViewerColumnEventLabel
				.getColumn();
		tblclmnLocation.setWidth(300);
		tblclmnLocation.setText("Location");
		tableViewerColumnEventLabel
				.setLabelProvider(new HREColumnLabelProvider(1));

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());

		try {
			lls = provider.getLocationStringListByEvent(eventPid);
			tableViewer.setInput(lls);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}

		final Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem mntmAddNewLocation = new MenuItem(menu, SWT.NONE);
		mntmAddNewLocation.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				newEventLocation(parent, context);
			}
		});
		mntmAddNewLocation.setText("Add new location...");

		final MenuItem mntmAddExistingLocation = new MenuItem(menu, SWT.NONE);
		mntmAddExistingLocation.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				browseLocation(null);
			}
		});
		mntmAddExistingLocation.setText("Add existing location...");

		final MenuItem mntmDeleteSelectedLocation = new MenuItem(menu,
				SWT.NONE);
		mntmDeleteSelectedLocation.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				deleteLocation(parent.getShell());
			}
		});
		mntmDeleteSelectedLocation.setText("Delete selected location...");
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
			final LocationProvider lp = new LocationProvider();
			lp.delete(locationPid);

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
	 * @param parent
	 * @param context
	 */
	public void newEventLocation(Composite parent, IEclipseContext context) {
		final NewLocationWizard newLocationWizard = new NewLocationWizard(
				context);
		final WizardDialog dialog = new WizardDialog(parent.getShell(),
				newLocationWizard);
		if (dialog.open() == Window.OK) {
			try {
				final LocationEventProvider lep = new LocationEventProvider();
				lep.setEventPid(eventPid);
				lep.setLocationPid(newLocationWizard.getLocationPid());
				lep.setPrimaryEvent(false);
				lep.setPrimaryLocation(false);

				lep.insert();
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
			}
		}
	}

	/**
	 *
	 */
	protected void openLocationView() {
		final String contributionURI = "bundleclass://net.myerichsen.hremvp/net.myerichsen.hremvp.location.parts.LocationView";

		final List<MPartStack> stacks = modelService.findElements(application,
				null, MPartStack.class, null);
		MPart part = MBasicFactory.INSTANCE.createPart();

		boolean found = false;

		for (final MPartStack mPartStack : stacks) {
			final List<MStackElement> a = mPartStack.getChildren();

			for (int i = 0; i < a.size(); i++) {
				part = (MPart) a.get(i);
				if (part.getContributionURI().equals(contributionURI)) {
					partService.showPart(part, PartState.ACTIVATE);
					found = true;
					break;
				}
			}
		}

		if (!found) {
			part.setLabel("Location View");
			part.setCloseable(true);
			part.setVisible(true);
			part.setContributionURI(contributionURI);
			stacks.get(stacks.size() - 2).getChildren().add(part);
			partService.showPart(part, PartState.ACTIVATE);
		}

		String LocationPid = "0";

		final TableItem[] selectedRows = tableViewer.getTable().getSelection();

		if (selectedRows.length > 0) {
			final TableItem selectedRow = selectedRows[0];
			LocationPid = selectedRow.getText(0);
		}

		LOGGER.log(Level.INFO, "Setting location pid: {0}", LocationPid);
		eventBroker.post(Constants.LOCATION_PID_UPDATE_TOPIC,
				Integer.parseInt(LocationPid));

	}

	/**
	 * @param eventPid
	 */
	@Inject
	@Optional
	private void subscribeEventPidUpdateTopic(
			@UIEventTopic(Constants.EVENT_PID_UPDATE_TOPIC) int eventPid) {
		LOGGER.log(Level.INFO, "Received event pid {0}", eventPid);
		this.eventPid = eventPid;
		try {
			lls = provider.getLocationStringListByEvent(eventPid);
			tableViewer.setInput(lls);
			tableViewer.refresh();
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}

	}
}