package net.myerichsen.hremvp.person.wizards;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.dialogs.DateDialog;
import net.myerichsen.hremvp.dialogs.DateNavigatorDialog;
import net.myerichsen.hremvp.location.dialogs.LocationNavigatorDialog;
import net.myerichsen.hremvp.location.wizards.NewLocationWizard;
import net.myerichsen.hremvp.project.providers.EventTypeProvider;
import net.myerichsen.hremvp.project.providers.LanguageProvider;
import net.myerichsen.hremvp.providers.HDateProvider;
import net.myerichsen.hremvp.providers.HREComboLabelProvider;

/**
 * Person events wizard page
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 * @version 8. jun. 2019
 *
 */
public class NewPersonEventWizardPage1 extends WizardPage {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	final IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");
	private final IEclipseContext context;

	private Text textFromDate;
	private Text textToDate;
	private Text textLocation;

	private int languagePid;
	private int eventTypePid;
	private String eventLabel;
	private int fromDatePid;
	private String fromDate;
	private int toDatePid;
	private String toDate;
	private int locationPid;
	private String location;

	private List<List<String>> languageList;
	private List<List<String>> eventTypeList;

	/**
	 * Constructor
	 *
	 * @param context
	 */
	public NewPersonEventWizardPage1(IEclipseContext context) {
		super("wizardPage");
		setTitle("Person Events");
		setDescription(
				"Add an event. Optionally add a location. More locations and more persons can be added later.\r\n");
		this.context = context;
	}

	/**
	 *
	 */
	private void browseFromDates() {
		final DateNavigatorDialog dialog = new DateNavigatorDialog(
				textFromDate.getShell(), context);
		if (dialog.open() == Window.OK) {
			try {
				final int hdatePid = dialog.getHdatePid();
				final HDateProvider hdp = new HDateProvider();
				hdp.get(hdatePid);
				textFromDate.setText(hdp.getDate().toString());
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
			}
		}
	}

	/**
	 *
	 */
	protected void browseLocations() {
		LOGGER.log(Level.INFO, "Browse locations");
		final LocationNavigatorDialog dialog = new LocationNavigatorDialog(
				textLocation.getShell());

		if (dialog.open() == Window.OK) {
			try {
				textLocation.setText(dialog.getLocationName());
				locationPid = dialog.getLocationPid();
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}
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
				final int hdatePid = dialog.getHdatePid();
				final HDateProvider hdp = new HDateProvider();
				hdp.get(hdatePid);
				textToDate.setText(hdp.getDate().toString());
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
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
	protected void clearLocation() {
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
	protected void copyFromTo() {
		textToDate.setText(textFromDate.getText());
		toDatePid = fromDatePid;
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(2, false));

		final Label lblLanguage = new Label(container, SWT.NONE);
		lblLanguage.setText("ISO Code");

		final ComboViewer comboViewerLanguage = new ComboViewer(container,
				SWT.NONE);
		final Combo comboLanguage = comboViewerLanguage.getCombo();
		comboLanguage.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final int selectionIndex = comboLanguage.getSelectionIndex();
				languagePid = Integer
						.parseInt(languageList.get(selectionIndex).get(0));
				LOGGER.log(Level.INFO, "Selection: " + languagePid);
			}
		});
		comboLanguage.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboViewerLanguage
				.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerLanguage.setLabelProvider(new HREComboLabelProvider(2));

		final Label lblEventType = new Label(container, SWT.NONE);
		lblEventType.setText("Event Type");

		final ComboViewer comboViewerEventType = new ComboViewer(container,
				SWT.NONE);
		final Combo comboEventType = comboViewerEventType.getCombo();
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
				eventTypePid = Integer
						.parseInt(eventTypeList.get(selectionIndex).get(0));
				LOGGER.log(Level.INFO, "Selection: " + eventTypePid);
			}
		});
		comboEventType.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboViewerEventType
				.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerEventType.setLabelProvider(new HREComboLabelProvider(3));

		final Composite compositeFrom = new Composite(container, SWT.BORDER);
		compositeFrom.setLayout(new GridLayout(2, false));
		compositeFrom.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		final Label lblFromDate = new Label(compositeFrom, SWT.NONE);
		lblFromDate.setText("From Date");

		textFromDate = new Text(compositeFrom, SWT.BORDER);
		textFromDate.setEditable(false);
		textFromDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Composite compositeFromButtons = new Composite(compositeFrom,
				SWT.NONE);
		compositeFromButtons.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		compositeFromButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnNewFrom = new Button(compositeFromButtons, SWT.NONE);
		btnNewFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				getNewFromDate();
			}
		});
		btnNewFrom.setText("New");

		final Button btnBrowseFrom = new Button(compositeFromButtons, SWT.NONE);
		btnBrowseFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				browseFromDates();
			}
		});
		btnBrowseFrom.setText("Browse");

		final Button btnClearFrom = new Button(compositeFromButtons, SWT.NONE);
		btnClearFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				clearFromDate();
			}
		});
		btnClearFrom.setText("Clear");

		final Composite compositeTo = new Composite(container, SWT.BORDER);
		compositeTo.setLayout(new GridLayout(2, false));
		compositeTo.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		final Label lblToDate = new Label(compositeTo, SWT.NONE);
		lblToDate.setText("To Date");

		textToDate = new Text(compositeTo, SWT.BORDER);
		textToDate.setEditable(false);
		textToDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Composite compositeToButtons = new Composite(compositeTo,
				SWT.NONE);
		compositeToButtons.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		compositeToButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button buttonCopyFromTo = new Button(compositeToButtons,
				SWT.NONE);
		buttonCopyFromTo.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				copyFromTo();
			}
		});
		buttonCopyFromTo.setText("Same date as above");

		final Button btnNewTo = new Button(compositeToButtons, SWT.NONE);
		btnNewTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				getNewToDate();
			}
		});
		btnNewTo.setText("New");

		final Button btnBrowseTo = new Button(compositeToButtons, SWT.NONE);
		btnBrowseTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				browseToDates();
			}
		});
		btnBrowseTo.setText("Browse");

		final Button btnClearTo = new Button(compositeToButtons, SWT.NONE);
		btnClearTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				clearToDate();
			}
		});
		btnClearTo.setText("Clear");

		final Composite compositeLocation = new Composite(container,
				SWT.BORDER);
		compositeLocation.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
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
		compositeLocationButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button buttonNewLocation = new Button(compositeLocationButtons,
				SWT.NONE);
		buttonNewLocation.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				getNewLocation();
			}
		});
		buttonNewLocation.setText("New");

		final Button buttonBrowseLocation = new Button(compositeLocationButtons,
				SWT.NONE);
		buttonBrowseLocation.addMouseListener(new MouseAdapter() {
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
		buttonBrowseLocation.setText("Browse");

		final Button buttonClearLocation = new Button(compositeLocationButtons,
				SWT.NONE);
		buttonClearLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				clearLocation();
			}
		});
		buttonClearLocation.setText("Clear");

		try {
			// Populate language combo box
			languageList = new LanguageProvider().getStringList();
			comboViewerLanguage.setInput(languageList);
			final String defaultLanguage = store.getString("GUILANGUAGE");

			for (int i = 0; i < languageList.size(); i++) {
				if (defaultLanguage.equals(languageList.get(i).get(1))) {
					comboLanguage.select(i);
					break;
				}
			}

		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}

		try {
			// Populate event type combo box
			eventTypeList = new EventTypeProvider().getStringList();
			comboViewerEventType.setInput(eventTypeList);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}
	}

	/**
	 * @return the eventLabel
	 */
	public String getEventLabel() {
		return eventLabel;
	}

	/**
	 * @return the eventTypePid
	 */
	public int getEventTypePid() {
		return eventTypePid;
	}

	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}

	/**
	 * @return the fromDatePid
	 */
	public int getFromDatePid() {
		return fromDatePid;
	}

	/**
	 * @return the languagePid
	 */
	public int getLanguagePid() {
		return languagePid;
	}

	/**
	 * @return
	 */
	public List<List<String>> getListOfLists() {
		return new ArrayList<>();
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @return the locationPid
	 */
	public int getLocationPid() {
		return locationPid;
	}

	/**
	 *
	 */
	private void getNewFromDate() {
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
	 *
	 */
	protected void getNewLocation() {
		final WizardDialog dialog = new WizardDialog(textLocation.getShell(),
				new NewLocationWizard(context));
		dialog.open();
	}

	/**
	 *
	 */
	private void getNewToDate() {
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
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}

	/**
	 * @return the toDatePid
	 */
	public int getToDatePid() {
		return toDatePid;
	}

}
