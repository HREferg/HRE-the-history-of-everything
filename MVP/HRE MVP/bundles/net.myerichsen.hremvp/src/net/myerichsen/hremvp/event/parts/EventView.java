package net.myerichsen.hremvp.event.parts;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.dialogs.DateDialog;
import net.myerichsen.hremvp.dialogs.DateNavigatorDialog;
import net.myerichsen.hremvp.event.providers.EventProvider;
import net.myerichsen.hremvp.providers.HDateProvider;

/**
 * Display all data about an event
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 10. jun. 2019
 */
public class EventView {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Inject
	private IEventBroker eventBroker;

	private Text textId;
	private Text textEventType;
	private Text textFromDate;
	private Text textToDate;

	private final EventProvider provider;
	private int eventPid = 0;
	private int fromDatePid = 0;
	private int toDatePid = 0;
	private int eventTypePid;

	/**
	 * Constructor
	 */
	public EventView() {
		provider = new EventProvider();
		LOGGER.log(Level.INFO, "Provider: {0}", provider.getClass().getName());
	}

	/**
	 * @param context
	 */
	private void browseFromDate(IEclipseContext context) {
		final DateNavigatorDialog dialog = new DateNavigatorDialog(
				textFromDate.getShell(), context);
		if (dialog.open() == Window.OK) {
			fromDatePid = dialog.getHdatePid();
			HDateProvider hdp;
			try {
				hdp = new HDateProvider();
				hdp.get(fromDatePid);
				textFromDate.setText(hdp.getDate().toString());
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
			}

		}
	}

	/**
	 * @param context
	 */
	private void browseToDate(IEclipseContext context) {
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
			}
		}
	}

	/**
	 *
	 */
	protected void clear() {
		textId.setText("");
		textEventType.setText("");
		textFromDate.setText("");
		textToDate.setText("");
		toDatePid = 0;
		fromDatePid = 0;
	}

	/**
	 * Create contents of the view part
	 *
	 * @param parent The parent composite
	 */
	@PostConstruct
	public void createControls(Composite parent, IEclipseContext context) {
		parent.setLayout(new GridLayout(1, false));

		final Composite compositeFields = new Composite(parent, SWT.NONE);
		compositeFields.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		compositeFields.setLayout(new GridLayout(2, false));

		final Label lblId = new Label(compositeFields, SWT.NONE);
		lblId.setText("Event ID");

		textId = new Text(compositeFields, SWT.BORDER);
		textId.setEditable(false);
		textId.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		final Label lblEventType = new Label(compositeFields, SWT.NONE);
		lblEventType.setText("Event Type");

		textEventType = new Text(compositeFields, SWT.BORDER);
		textEventType.setEditable(false);
		textEventType.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Composite compositeFromDate = new Composite(compositeFields,
				SWT.BORDER);
		compositeFromDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		compositeFromDate.setLayout(new GridLayout(2, false));

		final Label lblFromDate = new Label(compositeFromDate, SWT.NONE);
		lblFromDate.setText("From Date ID");

		textFromDate = new Text(compositeFromDate, SWT.BORDER);
		textFromDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textFromDate.setEditable(false);

		final Composite compositeFromButtons = new Composite(compositeFromDate,
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
				newFromDate(context);
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
				browseFromDate(context);
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
				textFromDate.setText("");
				fromDatePid = 0;
			}
		});
		btnClearFrom.setText("Clear");

		final Composite compositeToDate = new Composite(compositeFields,
				SWT.BORDER);
		compositeToDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		compositeToDate.setLayout(new GridLayout(2, false));

		final Label lblToDate = new Label(compositeToDate, SWT.NONE);
		lblToDate.setText("To Date ID");

		textToDate = new Text(compositeToDate, SWT.BORDER);
		textToDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textToDate.setEditable(false);

		final Composite compositeToButtons = new Composite(compositeToDate,
				SWT.NONE);
		compositeToButtons.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		compositeToButtons.setSize(211, 31);
		compositeToButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnCopyFromTo = new Button(compositeToButtons, SWT.NONE);
		btnCopyFromTo.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				textToDate.setText(textFromDate.getText());
				toDatePid = fromDatePid;
			}
		});
		btnCopyFromTo.setText("Copy From");

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
				newToDate(context);
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
			@Override
			public void mouseDown(MouseEvent e) {
				browseToDate(context);
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
				textToDate.setText("");
				toDatePid = 0;
			}
		});
		btnClearTo.setText("Clear");

		final Composite compositeButtons = new Composite(parent, SWT.NONE);
		compositeButtons.setLayoutData(
				new GridData(SWT.RIGHT, SWT.CENTER, false, false, 3, 1));
		compositeButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button buttonUpdate = new Button(compositeButtons, SWT.NONE);
		buttonUpdate.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				update();
			}
		});
		buttonUpdate.setText("Update");
	}

	/**
	 * @param key
	 */
	private void get(int key) {
		try {
			final List<String> eventStringList = provider.getStringList(key)
					.get(0);
			eventPid = Integer.parseInt(eventStringList.get(0));
			textId.setText(eventStringList.get(0));
			textFromDate.setText(eventStringList.get(1));
			textToDate.setText(eventStringList.get(2));
			eventTypePid = Integer.parseInt(eventStringList.get(3));
			textEventType.setText(eventStringList.get(4));
			fromDatePid = Integer.parseInt(eventStringList.get(5));
			toDatePid = Integer.parseInt(eventStringList.get(6));

			eventBroker.post("MESSAGE",
					"Event " + eventStringList.get(0) + " has been fetched");
		} catch (final Exception e) {
			clear();
			eventBroker.post("MESSAGE", e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 * @param context
	 */
	private void newFromDate(IEclipseContext context) {
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
			}
		}
	}

	/**
	 * @param context
	 */
	private void newToDate(IEclipseContext context) {
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
			}
		}
	}

	/**
	 * @param eventPid
	 */
	@Inject
	@Optional
	private void subscribeEventPidUpdateTopic(
			@UIEventTopic(Constants.EVENT_PID_UPDATE_TOPIC) int eventPid) {
		LOGGER.log(Level.INFO, "Received event pid {0}", eventPid);
		if (eventPid != 0) {
			this.eventPid = eventPid;
			get(eventPid);
		} else {
			eventBroker.post("MESSAGE",
					"No event has been added. Please check your input");
		}
	}

	/**
	 *
	 */
	protected void update() {
		LOGGER.log(Level.INFO, "Updating {0}, {1}, {2}, {3}", new Object[] {
				eventPid, eventTypePid, fromDatePid, toDatePid });
		try {
			provider.setEventPid(eventPid);
			provider.setEventTypePid(eventTypePid);
			provider.setFromDatePid(fromDatePid);
			provider.setToDatePid(toDatePid);
			provider.update();
			eventBroker.post("MESSAGE",
					"Event " + eventPid + " has been updated");
			eventBroker.post(Constants.EVENT_PID_UPDATE_TOPIC, eventPid);
		} catch (final Exception e) {
			eventBroker.post("MESSAGE", e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}
}