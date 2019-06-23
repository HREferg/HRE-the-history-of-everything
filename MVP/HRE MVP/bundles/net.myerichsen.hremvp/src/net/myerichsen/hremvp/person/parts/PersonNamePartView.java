package net.myerichsen.hremvp.person.parts;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.HreTypeLabelEditingSupport;
import net.myerichsen.hremvp.dbmodels.Dictionary;
import net.myerichsen.hremvp.dialogs.DateDialog;
import net.myerichsen.hremvp.dialogs.DateNavigatorDialog;
import net.myerichsen.hremvp.person.providers.PersonNamePartProvider;
import net.myerichsen.hremvp.person.providers.PersonNameProvider;
import net.myerichsen.hremvp.project.providers.PersonNameStyleProvider;
import net.myerichsen.hremvp.providers.HDateProvider;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Display all data about a name
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 12. apr. 2019
 */
public class PersonNamePartView {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Inject
	private IEventBroker eventBroker;

	private Text textPersonNameStyle;
	private Text textFromDate;
	private Text textToDate;
	private Button btnPrimaryName;

	private TableViewer tableViewer;

	private int personNamePid = 0;
	private int fromDatePid;
	private int toDatePid;

	private final PersonNamePartProvider provider;

	private List<List<String>> lls;

	/**
	 * Constructor
	 *
	 */
	public PersonNamePartView() {
		provider = new PersonNamePartProvider();
	}

	/**
	 * @param context
	 *
	 */
	private void browseFromDates(IEclipseContext context) {
		final DateNavigatorDialog dialog = new DateNavigatorDialog(
				textFromDate.getShell(), context);
		if (dialog.open() == Window.OK) {
			try {
				fromDatePid = dialog.getHdatePid();
				final HDateProvider hdp = new HDateProvider();
				hdp.get(fromDatePid);
				textFromDate.setText(hdp.getDate().toString());
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}
		}
	}

	/**
	 *
	 */
	private void browseToDates(IEclipseContext context) {
		final DateNavigatorDialog dialog = new DateNavigatorDialog(
				textToDate.getShell(), context);
		if (dialog.open() == Window.OK) {
			try {
				toDatePid = dialog.getHdatePid();
				final HDateProvider hdp = new HDateProvider();
				hdp.get(toDatePid);
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
	private void clearToDate() {
		textToDate.setText("");
		toDatePid = 0;
	}

	/**
	 * Create contents of the view part
	 *
	 * @param parent The parent composite
	 */
	@PostConstruct
	public void createControls(Composite parent, IEclipseContext context) {
		parent.setLayout(new GridLayout(2, false));

		final Label lblPersonNameStyle = new Label(parent, SWT.NONE);
		lblPersonNameStyle.setText("Person Name Style");

		textPersonNameStyle = new Text(parent, SWT.BORDER);
		textPersonNameStyle.setEditable(false);
		textPersonNameStyle.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Composite compositeFrom = new Composite(parent, SWT.BORDER);
		compositeFrom.setLayout(new GridLayout(2, false));
		compositeFrom.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		final Label lblFromDate = new Label(compositeFrom, SWT.NONE);
		lblFromDate.setText("From Date");

		textFromDate = new Text(compositeFrom, SWT.BORDER);
		textFromDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textFromDate.setEditable(false);

		final Composite compositeButtonsFrom = new Composite(compositeFrom,
				SWT.NONE);
		compositeButtonsFrom.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		compositeButtonsFrom.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnNewFrom = new Button(compositeButtonsFrom, SWT.NONE);
		btnNewFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				getNewFromDate(context);
			}
		});
		btnNewFrom.setText("New");

		final Button btnBrowseFrom = new Button(compositeButtonsFrom, SWT.NONE);
		btnBrowseFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				browseFromDates(context);
			}
		});
		btnBrowseFrom.setText("Browse");

		final Button btnClearFrom = new Button(compositeButtonsFrom, SWT.NONE);
		btnClearFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				clearFromDate();
			}
		});
		btnClearFrom.setText("Clear");

		final Composite compositeTo = new Composite(parent, SWT.BORDER);
		compositeTo.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		compositeTo.setLayout(new GridLayout(2, false));

		final Label lblToDate = new Label(compositeTo, SWT.NONE);
		lblToDate.setText("To Date");

		textToDate = new Text(compositeTo, SWT.BORDER);
		textToDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textToDate.setEditable(false);

		final Composite compositeButtonsTo = new Composite(compositeTo,
				SWT.NONE);
		compositeButtonsTo.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		compositeButtonsTo.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnNewTo = new Button(compositeButtonsTo, SWT.NONE);
		btnNewTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				getNewToDate(context);
			}
		});
		btnNewTo.setText("New");

		final Button btnBrowseTo = new Button(compositeButtonsTo, SWT.NONE);
		btnBrowseTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				browseToDates(context);
			}
		});
		btnBrowseTo.setText("Browse");

		final Button btnClearTo = new Button(compositeButtonsTo, SWT.NONE);
		btnClearTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				clearToDate();
			}
		});
		btnClearTo.setText("Clear");

		btnPrimaryName = new Button(parent, SWT.CHECK);
		btnPrimaryName.setText("Primary Name");
		new Label(parent, SWT.NONE);

		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		final Table tablePersonNameParts = tableViewer.getTable();
		tablePersonNameParts.setLinesVisible(true);
		tablePersonNameParts.setHeaderVisible(true);
		tablePersonNameParts.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		final TableViewerColumn tableViewerColumnId = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnId = tableViewerColumnId.getColumn();
		tblclmnId.setWidth(100);
		tblclmnId.setText("ID");
		tableViewerColumnId.setLabelProvider(new HREColumnLabelProvider(0));

		final TableViewerColumn tableViewerColumnPartNo = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnPartno = tableViewerColumnPartNo.getColumn();
		tblclmnPartno.setWidth(100);
		tblclmnPartno.setText("Part no.");
		tableViewerColumnPartNo.setLabelProvider(new HREColumnLabelProvider(1));

		final TableViewerColumn tableViewerColumnMap = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnLabelFromMap = tableViewerColumnMap
				.getColumn();
		tblclmnLabelFromMap.setWidth(100);
		tblclmnLabelFromMap.setText("Label from Map");
		tableViewerColumnMap.setLabelProvider(new HREColumnLabelProvider(2));

		final TableViewerColumn tableViewerColumnPart = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnValueFromPart = tableViewerColumnPart
				.getColumn();
		tblclmnValueFromPart.setWidth(100);
		tblclmnValueFromPart.setText("Value from Part");
		tableViewerColumnPart.setEditingSupport(
				new HreTypeLabelEditingSupport(tableViewer, 3));
		tableViewerColumnPart.setLabelProvider(new HREColumnLabelProvider(3));

		HREColumnLabelProvider.addEditingSupport(tableViewer);

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		try {
			lls = provider.getStringList(personNamePid);
			tableViewer.setInput(lls);
		} catch (final Exception e2) {
			LOGGER.log(Level.SEVERE, e2.toString(), e2);
		}

		final Composite compositeButtons = new Composite(parent, SWT.NONE);
		compositeButtons.setLayoutData(
				new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));

		final Button buttonUpdate = new Button(compositeButtons, SWT.NONE);
		buttonUpdate.setSize(50, 25);
		buttonUpdate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				LOGGER.log(Level.INFO, "Update");
				update();
			}
		});
		buttonUpdate.setText("Update");

	}

	/**
	 * @param context
	 *
	 */
	private void getNewFromDate(IEclipseContext context) {
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
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}
		}
	}

	/**
	 * @param context
	 *
	 */
	private void getNewToDate(IEclipseContext context) {
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
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}
		}
	}

	/**
	 * @param personPid
	 */
	@Inject
	@Optional
	private void subscribeNamePidUpdateTopic(
			@UIEventTopic(Constants.PERSON_NAME_PID_UPDATE_TOPIC) int personNamePid) {
		LOGGER.log(Level.FINE, "Received name id {0}",
				Integer.toString(personNamePid));

		if (personNamePid == 0) {
			return;
		}

		this.personNamePid = personNamePid;

		try {
			final PersonNameProvider pnp = new PersonNameProvider();
			pnp.get(personNamePid);

			final PersonNameStyleProvider pnsp = new PersonNameStyleProvider();
			pnsp.get(pnp.getNameStylePid());

			final Dictionary dictionary = new Dictionary();
			final List<Dictionary> fkLabelPid = dictionary
					.getFKLabelPid(pnsp.getLabelPid());
			textPersonNameStyle.setText(fkLabelPid.get(0).getLabel());

			final int fromDatePid2 = pnp.getFromDatePid();

			if (fromDatePid2 > 0) {
				final HDateProvider hdp = new HDateProvider();
				hdp.get(fromDatePid2);
				textFromDate.setText(hdp.getDate().toString());
			} else {
				textFromDate.setText("");
			}

			final int toDatePid2 = pnp.getToDatePid();

			if (toDatePid2 > 0) {
				final HDateProvider hdp = new HDateProvider();
				hdp.get(toDatePid2);
				textToDate.setText(hdp.getDate().toString());
			} else {
				textToDate.setText("");
			}

			btnPrimaryName.setSelection(pnp.isPrimaryName());
			lls = provider.getStringList(personNamePid);
			tableViewer.setInput(lls);
			tableViewer.refresh();
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 *
	 */
	@SuppressWarnings("unchecked")
	private void update() {
		try {
			final List<List<String>> input = (List<List<String>>) tableViewer
					.getInput();

			for (int i = 0; i < input.size(); i++) {
				provider.get(Integer.parseInt(input.get(i).get(0)));

				LOGGER.log(Level.FINE,
						"Input item {0}: Name part pid {1}, part no {2}, {3}, {4}, {5}",
						new Object[] { i, input.get(i).get(0),
								input.get(i).get(1), input.get(i).get(2),
								input.get(i).get(3), provider.getLabel() });

				final String string = input.get(i).get(3);
				if (!string.equals(provider.getLabel())) {
					provider.setLabel(string);
					provider.update();
				}

				LOGGER.log(Level.INFO, "Updated name part {0}: {1}",
						new Object[] { input.get(i).get(0), string });
				eventBroker.post(Constants.PERSON_PID_UPDATE_TOPIC, 1);
			}
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}
}
