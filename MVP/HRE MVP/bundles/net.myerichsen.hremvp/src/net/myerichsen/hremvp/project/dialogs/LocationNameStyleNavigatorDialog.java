package net.myerichsen.hremvp.project.dialogs;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import net.myerichsen.hremvp.project.providers.LocationNameStyleProvider;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Display all location name styles
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 * @version 23. apr. 2019
 *
 */
public class LocationNameStyleNavigatorDialog extends TitleAreaDialog {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Inject
	private IEventBroker eventBroker;
//	private final IPreferenceStore store = new ScopedPreferenceStore(
//			InstanceScope.INSTANCE, "net.myerichsen.hremvp");

	private LocationNameStyleProvider provider;

	private Table table;
	private int locationNameStylePid;

	/**
	 * Create the dialog
	 *
	 * @param parentShell
	 * @param context
	 */
	public LocationNameStyleNavigatorDialog(Shell parentShell) {
		super(parentShell);
		try {
			provider = new LocationNameStyleProvider();
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
	 * Create contents of the dialog.
	 *
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("Select location Name Style.");
		setTitle("location Name Styles");
		final Composite area = (Composite) super.createDialogArea(parent);
		final Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		final TableViewer tableViewer = new TableViewer(container,
				SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final TableItem[] items = table.getSelection();
				final TableItem selectedItem = items[0];
				setlocationNameStylePid(
						Integer.parseInt(selectedItem.getText(0)));
			}
		});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		final TableViewerColumn tableViewerColumnId = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnId = tableViewerColumnId.getColumn();
		tblclmnId.setWidth(100);
		tblclmnId.setText("ID");
		tableViewerColumnId.setLabelProvider(new HREColumnLabelProvider(0));

		final TableViewerColumn tableViewerColumnNameStyle = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnNameStyle = tableViewerColumnNameStyle
				.getColumn();
		tblclmnNameStyle.setWidth(100);
		tblclmnNameStyle.setText("Name Style");
		tableViewerColumnNameStyle
				.setLabelProvider(new HREColumnLabelProvider(1));

		final TableViewerColumn tableViewerColumnLanguage = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnLanguage = tableViewerColumnLanguage
				.getColumn();
		tblclmnLanguage.setWidth(100);
		tblclmnLanguage.setText("Language");
		tableViewerColumnLanguage
				.setLabelProvider(new HREColumnLabelProvider(2));

		final TableViewerColumn tableViewerColumnIsoCode = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnIsoCode = tableViewerColumnIsoCode.getColumn();
		tblclmnIsoCode.setWidth(100);
		tblclmnIsoCode.setText("ISO Code");
		tableViewerColumnIsoCode
				.setLabelProvider(new HREColumnLabelProvider(3));

//		final int defaultStyle = store.getInt("DEFAULTlocationNAMESTYLE");
//		int currentStyle;

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		try {
			tableViewer.setInput(provider.getStringList());
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}

		return area;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	/**
	 * @return the locationNameStylePid
	 */
	public int getlocationNameStylePid() {
		return locationNameStylePid;
	}

	/**
	 * @param locationNameStylePid the locationNameStylePid to set
	 */
	public void setlocationNameStylePid(int locationNameStylePid) {
		this.locationNameStylePid = locationNameStylePid;
	}

}
