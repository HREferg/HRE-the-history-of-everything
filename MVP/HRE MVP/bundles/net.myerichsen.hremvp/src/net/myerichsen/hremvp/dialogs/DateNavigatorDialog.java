package net.myerichsen.hremvp.dialogs;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import net.myerichsen.hremvp.NavigatorFilter;
import net.myerichsen.hremvp.providers.HDateProvider;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Display all historical dates
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 15. apr. 2019
 *
 */
public class DateNavigatorDialog extends TitleAreaDialog {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;
	private final IEventBroker eventBroker;

	private HDateProvider provider;
	private int hdatePid;
	private NavigatorFilter navigatorFilter;
	private Text textDateFilter;
	private TableViewer tableViewer;

	/**
	 * Create the dialog.
	 *
	 * @param parentShell
	 * @param context
	 */
	public DateNavigatorDialog(Shell parentShell, IEclipseContext context) {
		super(parentShell);
		this.context = context;
		eventBroker = context.get(IEventBroker.class);
		try {
			provider = new HDateProvider();
			navigatorFilter = new NavigatorFilter(1);
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			eventBroker.post("MESSAGE", e.getMessage());
		}
	}

	/**
	 * Create contents of the button bar.
	 *
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Create contents of the dialog
	 *
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("Select a date. View details by double clicking");
		setTitle("Dates");
		final Composite area = (Composite) super.createDialogArea(parent);
		final Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		final GridData gd_container = new GridData(GridData.FILL_BOTH);
		gd_container.grabExcessHorizontalSpace = false;
		container.setLayoutData(gd_container);

		tableViewer = new TableViewer(container,
				SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.addFilter(navigatorFilter);

		final Table table = tableViewer.getTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				openDateDialog(table.getShell());
			}
		});
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final TableItem[] items = table.getSelection();
				final TableItem selectedItem = items[0];
				setHdatePid(Integer.parseInt(selectedItem.getText(0)));
			}
		});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		final TableViewerColumn tableViewerColumnId = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnId = tableViewerColumnId.getColumn();
		tblclmnId.setWidth(100);
		tblclmnId.setText("ID");
		tableViewerColumnId.setLabelProvider(new HREColumnLabelProvider(0));

		final TableViewerColumn tableViewerColumnStoredDate = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnStoredDate = tableViewerColumnStoredDate
				.getColumn();
		tblclmnStoredDate.setWidth(100);
		tblclmnStoredDate.setText("Stored Date");
		tableViewerColumnStoredDate
				.setLabelProvider(new HREColumnLabelProvider(1));

		final TableViewerColumn tableViewerColumnOriginalInputFormat = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnOriginalInputFormat = tableViewerColumnOriginalInputFormat
				.getColumn();
		tblclmnOriginalInputFormat.setWidth(240);
		tblclmnOriginalInputFormat.setText("Original Input Format");
		tableViewerColumnOriginalInputFormat
				.setLabelProvider(new HREColumnLabelProvider(2));

		final Label lblDateFilter = new Label(container, SWT.NONE);
		lblDateFilter.setText("Date Filter");

		textDateFilter = new Text(container, SWT.BORDER);
		textDateFilter.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				navigatorFilter.setSearchText(textDateFilter.getText());
				LOGGER.log(Level.FINE,
						"Filter string: " + textDateFilter.getText());
				tableViewer.refresh();
			}
		});

		textDateFilter.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		try {
			tableViewer.setInput(provider.get());
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}

		return area;
	}

	/**
	 * @return the hdatePid
	 */
	public int getHdatePid() {
		return hdatePid;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(477, 464);
	}

	/**
	 * @param shell
	 * @param       data.context
	 *
	 */
	protected void openDateDialog(Shell shell) {
		final TableItem[] items = tableViewer.getTable().getSelection();
		final TableItem selectedItem = items[0];
		setHdatePid(Integer.parseInt(selectedItem.getText(0)));
		final DateDialog dateDialog = new DateDialog(shell, context, hdatePid);
		dateDialog.open();
	}

	/**
	 * @param hdatePid the hdatePid to set
	 */
	public void setHdatePid(int hdatePid) {
		this.hdatePid = hdatePid;
	}
}