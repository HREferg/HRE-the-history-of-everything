package net.myerichsen.hremvp.person.wizards;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import net.myerichsen.hremvp.event.dialogs.NewEventDialog;
import net.myerichsen.hremvp.event.providers.EventProvider;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Person events wizard page.
 * <p>
 * It calls class NewEventDialog to create one or more events for the new
 * person. When focus is lost from the table, it returns a list of events to the
 * wizard, which then creates a Person Event for each event.
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 * @version 22. apr. 2019
 *
 */
public class NewPersonWizardPage5 extends WizardPage {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;

	private NewPersonWizard wizard;
	private List<List<String>> lls;
	private TableViewer tableViewer;
	private EventProvider provider;

	/**
	 * Constructor
	 *
	 * @param context
	 */
	public NewPersonWizardPage5(IEclipseContext context) {
		super("wizardPage");
		setTitle("Person Events");
		setDescription(
				"Add events for the new person. More events can be added later.");
		this.context = context;
		lls = new ArrayList<>();
		try {
			provider = new EventProvider();
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

	}

	/**
	 *
	 */
	protected void addEvent() {
		final NewEventDialog dialog = new NewEventDialog(getShell(), context);

		if (dialog.open() == Window.OK) {
			try {
				final List<String> eventStringList = dialog
						.getEventStringList();
				lls.add(eventStringList);
				wizard = (NewPersonWizard) getWizard();
				wizard.setEventList(lls);

				// Display in view
				final TableItem item = new TableItem(tableViewer.getTable(),
						SWT.NONE);
				item.setText(0, eventStringList.get(0));
				item.setText(1, eventStringList.get(2));
				item.setText(2, eventStringList.get(4));
				item.setText(3, eventStringList.get(6));
				item.setText(4, eventStringList.get(8));
				setErrorMessage(null);
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
				setErrorMessage(e.getMessage());
			}

		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.
	 * widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(2, false));

		tableViewer = new TableViewer(container,
				SWT.BORDER | SWT.FULL_SELECTION);
		final Table table = tableViewer.getTable();
		table.addFocusListener(new FocusAdapter() {

			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.
			 * events.FocusEvent)
			 */
			@Override
			public void focusLost(FocusEvent e) {
				final TableItem[] tableItems = table.getItems();
				Boolean found = false;
				final List<String> stringList = new ArrayList<>();

				for (int i = 0; i < tableItems.length; i++) {
					final String text = tableItems[i].getText(4);
					stringList.add(text);

					if (text.length() > 0) {
						lls.get(i).set(4, text);
						found = true;
					}
				}

				if (found) {
					wizard = (NewPersonWizard) getWizard();
//					wizard.setPersonNamePartList(stringList);
					wizard.setEventList(lls);
					setPageComplete(true);
				}

			}
		});

		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		final TableViewerColumn tableViewerColumnId = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnEventId = tableViewerColumnId.getColumn();
		tblclmnEventId.setWidth(100);
		tblclmnEventId.setText("Event Id");
		tableViewerColumnId.setLabelProvider(new HREColumnLabelProvider(0));

		final TableViewerColumn tableViewerColumnLabel = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnEventLabel = tableViewerColumnLabel
				.getColumn();
		tblclmnEventLabel.setWidth(100);
		tblclmnEventLabel.setText("Event");
		tableViewerColumnLabel.setLabelProvider(new HREColumnLabelProvider(1));

		final TableViewerColumn tableViewerColumnRole = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnEventRole = tableViewerColumnRole.getColumn();
		tblclmnEventRole.setWidth(100);
		tblclmnEventRole.setText("Role in Event");
		tableViewerColumnRole.setLabelProvider(new HREColumnLabelProvider(2));

		final TableViewerColumn tableViewerColumnFromDate = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnFromDate = tableViewerColumnFromDate
				.getColumn();
		tblclmnFromDate.setWidth(100);
		tblclmnFromDate.setText("From Date");
		tableViewerColumnFromDate
				.setLabelProvider(new HREColumnLabelProvider(3));

		final TableViewerColumn tableViewerColumnToDate = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnToDate = tableViewerColumnToDate.getColumn();
		tblclmnToDate.setWidth(100);
		tblclmnToDate.setText("To Date");
		tableViewerColumnToDate.setLabelProvider(new HREColumnLabelProvider(4));

		HREColumnLabelProvider.addEditingSupport(tableViewer);

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		try {
			wizard = (NewPersonWizard) getWizard();
			lls = provider.getStringList(wizard.getPersonPid());
			tableViewer.setInput(lls);
			setErrorMessage(null);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
			setErrorMessage(e1.getMessage());
		}

		final Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem mntmNewEvent = new MenuItem(menu, SWT.NONE);
		mntmNewEvent.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				addEvent();
			}
		});
		mntmNewEvent.setText("New Event...");

		final MenuItem mntmDeleteSelectedEvent = new MenuItem(menu, SWT.NONE);
		mntmDeleteSelectedEvent.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				deleteSelectedEvent();
			}
		});
		mntmDeleteSelectedEvent.setText("Delete selected Event");

	}

	/**
	 *
	 */
	protected void deleteSelectedEvent() {
		final int selectionIndex = tableViewer.getTable().getSelectionIndex();
		tableViewer.getTable().remove(selectionIndex);
		lls.remove(selectionIndex);
		wizard = (NewPersonWizard) getWizard();
		wizard.setEventList(lls);
	}

}
