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
import org.eclipse.swt.custom.ScrolledComposite;
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
import net.myerichsen.hremvp.location.providers.LocationNamePartProvider;
import net.myerichsen.hremvp.location.providers.LocationNameProvider;
import net.myerichsen.hremvp.location.wizards.NewLocationNameWizard;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Display all names of a location
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 18. apr. 2019
 */
public class LocationNameNavigator {
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

	private final LocationNameProvider provider;
	private int locationPid = 0;

	/**
	 * Constructor
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 *
	 */
	public LocationNameNavigator() throws Exception {
		provider = new LocationNameProvider();
	}

	/**
	 * Create contents of the view part
	 *
	 * @param parent
	 * @param context
	 */
	@PostConstruct
	public void createControls(Composite parent, IEclipseContext context) {
		parent.setLayout(new GridLayout(1, false));

		final ScrolledComposite scrolledComposite = new ScrolledComposite(
				parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		final GridData gd_scrolledComposite = new GridData(SWT.FILL, SWT.FILL,
				true, true, 1, 1);
		gd_scrolledComposite.widthHint = 674;
		scrolledComposite.setLayoutData(gd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		final Composite composite_1 = new Composite(scrolledComposite,
				SWT.NONE);
		composite_1.setLayout(new GridLayout(2, false));

		tableViewer = new TableViewer(composite_1,
				SWT.BORDER | SWT.FULL_SELECTION);
		final Table table = tableViewer.getTable();
		table.setLayoutData(
				new GridData(SWT.LEFT, SWT.FILL, false, true, 2, 1));
		table.setToolTipText("Double click to edit name part");
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				openLocationNamePartsNavigator();
			}
		});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableViewerColumn tableViewerColumnId = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnId = tableViewerColumnId.getColumn();
		tblclmnId.setWidth(50);
		tblclmnId.setText("ID");
		tableViewerColumnId.setLabelProvider(new HREColumnLabelProvider(0));

		final TableViewerColumn tableViewerColumnName = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnName = tableViewerColumnName.getColumn();
		tblclmnName.setWidth(200);
		tblclmnName.setText("Name");
		tableViewerColumnName.setLabelProvider(new HREColumnLabelProvider(1));

		final TableViewerColumn tableViewerColumnPrimary = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnPrimary = tableViewerColumnPrimary.getColumn();
		tblclmnPrimary.setWidth(60);
		tblclmnPrimary.setText("Primary");
		tableViewerColumnPrimary
				.setLabelProvider(new HREColumnLabelProvider(2));

		final TableViewerColumn tableViewerColumnFrom = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnFrom = tableViewerColumnFrom.getColumn();
		tblclmnFrom.setWidth(100);
		tblclmnFrom.setText("From");
		tableViewerColumnFrom.setLabelProvider(new HREColumnLabelProvider(3));

		final TableViewerColumn tableViewerColumnTo = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnTo = tableViewerColumnTo.getColumn();
		tblclmnTo.setWidth(100);
		tblclmnTo.setText("To");
		tableViewerColumnTo.setLabelProvider(new HREColumnLabelProvider(4));

		final Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem mntmAddLocation = new MenuItem(menu, SWT.NONE);
		mntmAddLocation.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final WizardDialog dialog = new WizardDialog(parent.getShell(),
						new NewLocationNameWizard(locationPid, context));
				dialog.open();
			}
		});
		mntmAddLocation.setText("Add location name...");

		final MenuItem mntmDeleteSelectedLocation = new MenuItem(menu,
				SWT.NONE);
		mntmDeleteSelectedLocation.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				deleteLocationName(parent.getShell());
			}
		});
		mntmDeleteSelectedLocation.setText("Delete selected location name...");

		scrolledComposite.setContent(composite_1);
		scrolledComposite
				.setMinSize(composite_1.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		try {
			tableViewer.setInput(provider.getStringList(locationPid));
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
			eventBroker.post("MESSAGE", e1.getMessage());
		}
	}

	/**
	 * @param shell
	 */
	protected void deleteLocationName(Shell shell) {
		final TableItem[] selection = tableViewer.getTable().getSelection();

		int locationNamePid = 0;
		String primaryName = null;
		if (selection.length > 0) {
			final TableItem item = selection[0];
			locationNamePid = Integer.parseInt(item.getText(0));
			primaryName = item.getText(1);
		}

		// Last chance to regret
		final MessageDialog dialog = new MessageDialog(shell,
				"Delete location name " + primaryName, null,
				"Are you sure that you will delete location name "
						+ locationNamePid + ", " + primaryName + "?",
				MessageDialog.CONFIRM, 0, "OK", "Cancel");

		if (dialog.open() == Window.CANCEL) {
			eventBroker.post("MESSAGE", "Delete of location name " + primaryName
					+ " has been canceled");
			return;
		}

		try {
			final LocationNamePartProvider lnpp = new LocationNamePartProvider();
			final List<Integer> fkLocationNamePid = lnpp
					.getFKLocationNamePid(locationNamePid);

			for (final Integer integer : fkLocationNamePid) {
				lnpp.delete(integer);
			}

			final LocationNameProvider lnp = new LocationNameProvider();
			lnp.delete(locationNamePid);

			LOGGER.log(Level.INFO, "Location name {0} has been deleted",
					primaryName);
			eventBroker.post("MESSAGE",
					"Location name " + primaryName + " has been deleted");
			eventBroker.post(Constants.LOCATION_PID_UPDATE_TOPIC,
					locationNamePid);
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

	}

	/**
	 *
	 */
	protected void openLocationNamePartsNavigator() {
		final String contributionURI = "bundleclass://net.myerichsen.hremvp/net.myerichsen.hremvp.location.parts.LocationNamePartNavigator";

		final List<MPartStack> stacks = modelService.findElements(application,
				null, MPartStack.class, null);
		MPart part = MBasicFactory.INSTANCE.createPart();
		boolean found = false;

		for (final MPartStack mPartStack : stacks) {
			final List<MStackElement> a = mPartStack.getChildren();

			try {
				for (int i = 0; i < a.size(); i++) {
					part = (MPart) a.get(i);
					if (part.getContributionURI().equals(contributionURI)) {
						partService.showPart(part, PartState.ACTIVATE);
						found = true;
						break;
					}
				}
			} catch (final Exception e) {
				LOGGER.log(Level.INFO, e.getMessage());
			}
		}

		if (!found) {
			part.setLabel("Location Name Parts");
			part.setCloseable(true);
			part.setVisible(true);
			part.setContributionURI(contributionURI);
			stacks.get(stacks.size() - 2).getChildren().add(part);
			partService.showPart(part, PartState.ACTIVATE);
		}

		String locationNamePid = "0";

		final TableItem[] selectedRows = tableViewer.getTable().getSelection();

		if (selectedRows.length > 0) {
			final TableItem selectedRow = selectedRows[0];
			locationNamePid = selectedRow.getText(0);
		}

		LOGGER.log(Level.INFO, "Setting location name pid: {0}",
				locationNamePid);
		eventBroker.post(Constants.LOCATION_NAME_PID_UPDATE_TOPIC,
				Integer.parseInt(locationNamePid));
	}

	/**
	 * @param key
	 */
	@Inject
	@Optional
	private void subscribeLocationPidUpdateTopic(
			@UIEventTopic(Constants.LOCATION_PID_UPDATE_TOPIC) int locationPid) {
		this.locationPid = locationPid;
		LOGGER.log(Level.INFO, "Received {0}", locationPid);

		try {
			tableViewer.setInput(provider.getStringList(locationPid));
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		tableViewer.refresh();
	}
}
