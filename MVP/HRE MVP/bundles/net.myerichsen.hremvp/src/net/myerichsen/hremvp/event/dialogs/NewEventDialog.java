package net.myerichsen.hremvp.event.dialogs;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.dialogs.DateDialog;
import net.myerichsen.hremvp.dialogs.DateNavigatorDialog;
import net.myerichsen.hremvp.event.providers.EventProvider;
import net.myerichsen.hremvp.location.dialogs.LocationNavigatorDialog;
import net.myerichsen.hremvp.location.providers.LocationEventProvider;
import net.myerichsen.hremvp.location.providers.LocationProvider;
import net.myerichsen.hremvp.location.wizards.NewLocationWizard;
import net.myerichsen.hremvp.project.providers.EventRoleProvider;
import net.myerichsen.hremvp.project.providers.EventTypeProvider;
import net.myerichsen.hremvp.providers.HDateProvider;
import net.myerichsen.hremvp.providers.HREComboLabelProvider;

/**
 * Dialog to create a new person event
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 * @version 10. jun. 2019
 *
 */
public class NewEventDialog extends TitleAreaDialog {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Inject
	private IEventBroker eventBroker;
	private final IEclipseContext context;

	private Combo comboEventRole;
	private ComboViewer comboViewerEventRole;
	private Text textFromDate;
	private Text textToDate;
	private Text textLocation;

	private int eventNamePid = 0;
	private String role = "";
	private int fromDatePid = 0;
	private int toDatePid = 0;
	private int eventTypePid = 0;
	private String eventTypeLabel = "";
	private int eventRolePid = 0;
	private String eventRoleLabel = "";
	private int eventPid = 0;
	private String locationLabel = "";
	private int locationPid = 0;

	private List<List<String>> eventTypeStringList;
	private List<List<String>> eventRoleStringList;

	private final EventRoleProvider eventRoleProvider;

	/**
	 * Create the dialog.
	 *
	 * @param parentShell
	 */
	public NewEventDialog(Shell parentShell, IEclipseContext context) {
		super(parentShell);
		setHelpAvailable(false);
		this.context = context;
		eventRoleProvider = new EventRoleProvider();
	}

	/**
	 *
	 */
	private void browseFromDates() {
		final DateNavigatorDialog dialog = new DateNavigatorDialog(
				textFromDate.getShell(), context);
		if (dialog.open() == Window.OK) {
			try {
				fromDatePid = dialog.getHdatePid();
				final HDateProvider hdp = new HDateProvider();
				hdp.get(fromDatePid);
				textFromDate.setText(hdp.getDate().toString());
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
				eventBroker.post("MESSAGE", e1.getMessage());
			}
		}
	}

	/**
	 *
	 */
	private void browseLocations() {
		final LocationNavigatorDialog dialog = new LocationNavigatorDialog(
				textLocation.getShell());

		if (dialog.open() == Window.OK) {
			locationPid = dialog.getLocationPid();
			textLocation.setText(dialog.getLocationName());
		}
	}

	/**
	 *
	 */
	private void browseToDates() {
		final DateNavigatorDialog dialog = new DateNavigatorDialog(
				textToDate.getShell(), context);
		if (dialog.open() == Window.OK) {
			try {
				toDatePid = dialog.getHdatePid();
				final HDateProvider hdp = new HDateProvider();
				hdp.get(toDatePid);
				textToDate.setText(hdp.getDate().toString());
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
				eventBroker.post("MESSAGE", e1.getMessage());
			}
		}
	}

	/**
	 *
	 */
	private void clearFromDate() {
		textFromDate.setText("");
		fromDatePid = 0;
	}

	/**
	 *
	 */
	private void clearLocation() {
		textLocation.setText("");
		locationPid = 0;
	}

	/**
	 *
	 */
	private void clearToDate() {
		textToDate.setText("");
		toDatePid = 0;
	}

	/**
	 *
	 */
	protected void copyFromDateToNewToDate() {
		textToDate.setText(textFromDate.getText());
		toDatePid = fromDatePid;
	}

	/**
	 * Create contents of the button bar.
	 *
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		final Button button = createButton(parent, IDialogConstants.OK_ID,
				IDialogConstants.OK_LABEL, true);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				createEvent();
			}
		});
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Create contents of the dialog.
	 *
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("Select an event type and create the new event.");
		setTitle("New Event");
		final Composite area = (Composite) super.createDialogArea(parent);
		final Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		final Composite compositeEventType = new Composite(container,
				SWT.BORDER);
		compositeEventType.setLayout(new GridLayout(2, false));
		compositeEventType.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		final Label lblEventType = new Label(compositeEventType, SWT.NONE);
		lblEventType.setLayoutData(
				new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblEventType.setText("Event Type");

		final ComboViewer comboViewerEventType = new ComboViewer(
				compositeEventType, SWT.NONE);
		final Combo comboEventType = comboViewerEventType.getCombo();
		comboEventType.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		comboEventType.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final int selectionIndex = comboEventType.getSelectionIndex();
				eventTypePid = Integer.parseInt(
						eventTypeStringList.get(selectionIndex).get(0));
				eventTypeLabel = eventTypeStringList.get(selectionIndex).get(2);

				try {
					eventRoleStringList = eventRoleProvider
							.getEventTypeStringList(eventTypePid);

					comboViewerEventRole.setInput(eventRoleStringList);
				} catch (final Exception e1) {
					LOGGER.log(Level.SEVERE, e1.toString(), e1);
					eventBroker.post("MESSAGE", e1.getMessage());
				}
			}
		});
		comboViewerEventType
				.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerEventType.setLabelProvider(new HREComboLabelProvider(2));

		try {
			eventTypeStringList = new EventTypeProvider().getStringList();
			comboViewerEventType.setInput(eventTypeStringList);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
			eventBroker.post("MESSAGE", e1.getMessage());
		}

		final Composite compositeRole = new Composite(container, SWT.BORDER);
		compositeRole.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		compositeRole.setLayout(new GridLayout(2, false));

		final Label lblRole = new Label(compositeRole, SWT.NONE);
		lblRole.setText("Role");

		comboViewerEventRole = new ComboViewer(compositeRole, SWT.NONE);
		comboEventRole = comboViewerEventRole.getCombo();
		comboEventRole.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		comboEventRole.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final int selectionIndex = comboEventRole.getSelectionIndex();
				eventRolePid = Integer.parseInt(
						eventRoleStringList.get(selectionIndex).get(0));
				eventRoleLabel = eventRoleStringList.get(selectionIndex).get(2);
			}
		});
		comboViewerEventRole
				.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerEventRole.setLabelProvider(new HREComboLabelProvider(2));

		try {
			eventRoleStringList = new EventRoleProvider().getStringList();
			comboViewerEventRole.setInput(eventRoleStringList);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
			eventBroker.post("MESSAGE", e1.getMessage());
		}

		final Label lblFromDate = new Label(compositeRole, SWT.NONE);
		lblFromDate.setText("From Date");

		textFromDate = new Text(compositeRole, SWT.BORDER);
		textFromDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textFromDate.setEditable(false);

		final Composite compositeFromButtons = new Composite(compositeRole,
				SWT.NONE);
		compositeFromButtons.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		compositeFromButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnNewFrom = new Button(compositeFromButtons, SWT.NONE);
		btnNewFrom.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				newFromDate();
			}
		});
		btnNewFrom.setText("New");

		final Button btnBrowseFrom = new Button(compositeFromButtons, SWT.NONE);
		btnBrowseFrom.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				browseFromDates();
			}
		});
		btnBrowseFrom.setText("Browse");

		final Button btnClearFrom = new Button(compositeFromButtons, SWT.NONE);
		btnClearFrom.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				clearFromDate();
			}
		});
		btnClearFrom.setText("Clear");

		final Label lblToDate = new Label(compositeRole, SWT.NONE);
		lblToDate.setText("To Date");

		textToDate = new Text(compositeRole, SWT.BORDER);
		textToDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textToDate.setEditable(false);

		final Composite compositeToButtons = new Composite(compositeRole,
				SWT.NONE);
		compositeToButtons.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		compositeToButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnCopyDates = new Button(compositeToButtons, SWT.NONE);
		btnCopyDates.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				copyFromDateToNewToDate();
			}
		});
		btnCopyDates.setText("Copy From Date");

		final Button btnNewTo = new Button(compositeToButtons, SWT.NONE);
		btnNewTo.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				newToDate();
			}
		});
		btnNewTo.setText("New");

		final Button btnBrowseTo = new Button(compositeToButtons, SWT.NONE);
		btnBrowseTo.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				browseToDates();
			}
		});
		btnBrowseTo.setText("Browse");

		final Button btnClearTo = new Button(compositeToButtons, SWT.NONE);
		btnClearTo.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				clearToDate();
			}
		});
		btnClearTo.setText("Clear");

		final Composite compositeLocation = new Composite(container,
				SWT.BORDER);
		compositeLocation.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		compositeLocation.setLayout(new GridLayout(2, false));

		final Label lblLocation = new Label(compositeLocation, SWT.NONE);
		lblLocation.setBounds(0, 0, 55, 15);
		lblLocation.setText("Location");

		textLocation = new Text(compositeLocation, SWT.BORDER);
		textLocation.setEditable(false);
		textLocation.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Composite compositeLocationButtons = new Composite(
				compositeLocation, SWT.NONE);
		compositeLocationButtons.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		compositeLocationButtons.setBounds(0, 0, 64, 64);
		compositeLocationButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnNewLocation = new Button(compositeLocationButtons,
				SWT.NONE);
		btnNewLocation.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				newLocation();
			}
		});
		btnNewLocation.setText("New");

		final Button btnBrowseLocation = new Button(compositeLocationButtons,
				SWT.NONE);
		btnBrowseLocation.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				browseLocations();
			}
		});
		btnBrowseLocation.setText("Browse");

		final Button btnClearLocation = new Button(compositeLocationButtons,
				SWT.NONE);
		btnClearLocation.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				clearLocation();
			}
		});
		btnClearLocation.setText("Clear");

		return area;
	}

	/**
	 *
	 */
	protected void createEvent() {
		try {
			final EventProvider provider = new EventProvider();
			provider.setFromDatePid(fromDatePid);
			provider.setToDatePid(toDatePid);
			provider.setEventTypePid(eventTypePid);
			eventPid = provider.insert();

			LOGGER.log(Level.INFO, "Created event {0}", eventPid);

			final LocationEventProvider lep = new LocationEventProvider();
			lep.setEventPid(eventPid);
			lep.setLocationPid(locationPid);
			lep.setPrimaryEvent(true);
			lep.setPrimaryLocation(true);
			int locationEventsPid = lep.insert();

			LOGGER.log(Level.INFO, "Inserted location event {0}",
					locationEventsPid);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
			eventBroker.post("MESSAGE", e1.getMessage());
		}

	}

	/**
	 * @return the eventNamePid
	 */
	public int getEventNamePid() {
		return eventNamePid;
	}

	/**
	 * @return the eventPid
	 */
	public int getEventPid() {
		return eventPid;
	}

	/**
	 * @return the eventRolePid
	 */
	public int getEventRolePid() {
		return eventRolePid;
	}

	/**
	 * @return The eventStringList with eventNamePid, nameLabel, role,
	 *         fromDatePid, FromDate, toDatePid, toDate
	 */
	public List<String> getEventStringList() {
		HDateProvider hdateProvider;

		final List<String> eventStringList = new ArrayList<>();

		eventStringList.add(Integer.toString(eventPid));
		eventStringList.add(Integer.toString(eventNamePid));
		eventStringList.add(eventTypeLabel);
		eventStringList.add(Integer.toString(eventRolePid));
		eventStringList.add(eventRoleLabel);

		if (fromDatePid != 0) {
			eventStringList.add(Integer.toString(fromDatePid));
			try {
				hdateProvider = new HDateProvider();
				hdateProvider.get(fromDatePid);
				eventStringList.add(hdateProvider.getDate().toString());
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
				eventBroker.post("MESSAGE", e.getMessage());
				eventStringList.add("");
			}
		} else {
			eventStringList.add("0");
			eventStringList.add("");
		}

		if (toDatePid != 0) {
			eventStringList.add(Integer.toString(toDatePid));
			try {
				hdateProvider = new HDateProvider();
				hdateProvider.get(toDatePid);
				eventStringList.add(hdateProvider.getDate().toString());
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
				eventBroker.post("MESSAGE", e.getMessage());
				eventStringList.add("");
			}
		} else {
			eventStringList.add("0");
			eventStringList.add("");
		}

		return eventStringList;
	}

	/**
	 * @return the eventTypePid
	 */
	public int getEventTypePid() {
		return eventTypePid;
	}

	/**
	 * @return the fromDatePid
	 */
	public int getFromDatePid() {
		return fromDatePid;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(373, 455);
	}

	/**
	 * @return the locationLabel
	 */
	public String getLocationLabel() {
		return locationLabel;
	}

	/**
	 * @return the locationPid
	 */
	public int getLocationPid() {
		return locationPid;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @return the toDatePid
	 */
	public int getToDatePid() {
		return toDatePid;
	}

	/**
	 *
	 */
	private void newFromDate() {
		final DateDialog dialog = new DateDialog(textFromDate.getShell(),
				context);
		if (dialog.open() == Window.OK) {
			try {
				final HDateProvider hdp = new HDateProvider();
				hdp.setDate(dialog.getDate());
				hdp.setSortDate(dialog.getSortDate());
				hdp.setOriginalText(dialog.getOriginal());
				hdp.setSurety(dialog.getSurety());
				fromDatePid = hdp.insert();
				textFromDate.setText(dialog.getDate().toString());
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
				eventBroker.post("MESSAGE", e1.getMessage());
			}
		}
	}

	/**
	 *
	 */
	private void newLocation() {
		final NewLocationWizard newLocationWizard = new NewLocationWizard(
				context);
		final WizardDialog dialog = new WizardDialog(textLocation.getShell(),
				newLocationWizard);
		if (dialog.open() == Window.OK) {
			locationPid = newLocationWizard.getLocationPid();

			String text = "";
			LocationProvider lp;

			try {
				lp = new LocationProvider();
				lp.get(locationPid);
				text = lp.getPrimaryName();
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}

			textLocation.setText(text);
		}
	}

	/**
	 *
	 */
	private void newToDate() {
		final DateDialog dialog = new DateDialog(textToDate.getShell(),
				context);
		if (dialog.open() == Window.OK) {
			try {
				final HDateProvider hdp = new HDateProvider();
				hdp.setDate(dialog.getDate());
				hdp.setSortDate(dialog.getSortDate());
				hdp.setOriginalText(dialog.getOriginal());
				hdp.setSurety(dialog.getSurety());
				toDatePid = hdp.insert();
				textToDate.setText(dialog.getDate().toString());
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
				eventBroker.post("MESSAGE", e1.getMessage());
			}
		}
	}

	/**
	 * @param eventNamePid the eventNamePid to set
	 */
	public void setEventNamePid(int eventNamePid) {
		this.eventNamePid = eventNamePid;
	}

	/**
	 * @param eventPid the eventPid to set
	 */
	public void setEventPid(int eventPid) {
		this.eventPid = eventPid;
	}

	/**
	 * @param eventRolePid the eventRolePid to set
	 */
	public void setEventRolePid(int eventRolePid) {
		this.eventRolePid = eventRolePid;
	}

	/**
	 * @param eventTypePid the eventTypePid to set
	 */
	public void setEventTypePid(int eventTypePid) {
		this.eventTypePid = eventTypePid;
	}

	/**
	 * @param fromDatePid the fromDatePid to set
	 */
	public void setFromDatePid(int fromDatePid) {
		this.fromDatePid = fromDatePid;
	}

	/**
	 * @param locationLabel the locationLabel to set
	 */
	public void setLocationLabel(String locationLabel) {
		this.locationLabel = locationLabel;
	}

	/**
	 * @param locationPid the locationPid to set
	 */
	public void setLocationPid(int locationPid) {
		this.locationPid = locationPid;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @param toDatePid the toDatePid to set
	 */
	public void setToDatePid(int toDatePid) {
		this.toDatePid = toDatePid;
	}

	@Inject
	@Optional
	private void subscribeLocationPidUpdateTopic(
			@UIEventTopic(Constants.LOCATION_PID_UPDATE_TOPIC) int locationPid) {
		LOGGER.log(Level.INFO, "Received location pid {0}", locationPid);
		this.locationPid = locationPid;
		textLocation.setText("Location pid: " + locationPid);
	}
}
