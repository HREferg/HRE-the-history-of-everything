package net.myerichsen.hremvp.project.parts;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
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
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.project.providers.ParentRoleProvider;
import net.myerichsen.hremvp.project.wizards.NewParentRoleWizard;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Display all parent roles
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 9. jun. 2019
 */
@SuppressWarnings("restriction")
public class ParentRoleNavigator {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;
	@Inject
	private IEventBroker eventBroker;

	private ParentRoleProvider provider;
	private TableViewer tableViewer;
	private int ParentRolePid = 0;

	/**
	 * Constructor
	 *
	 */
	public ParentRoleNavigator() {
		provider = new ParentRoleProvider();
	}

	/**
	 * Create contents of the view part
	 *
	 * @param parent  The parent composite
	 * @param context
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
				openParentRoleView();
			}
		});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		final TableViewerColumn tableViewerColumnId = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnId = tableViewerColumnId.getColumn();
		tblclmnId.setWidth(80);
		tblclmnId.setText("Parent Role ID");
		tableViewerColumnId.setLabelProvider(new HREColumnLabelProvider(0));

		final TableViewerColumn tableViewerColumnLabelId = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnLabelId = tableViewerColumnLabelId.getColumn();
		tblclmnLabelId.setWidth(80);
		tblclmnLabelId.setText("Dictionary Label ID");
		tableViewerColumnLabelId
				.setLabelProvider(new HREColumnLabelProvider(1));

		final TableViewerColumn tableViewerColumnAbbrev = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnAbbreviation = tableViewerColumnAbbrev
				.getColumn();
		tblclmnAbbreviation.setWidth(100);
		tblclmnAbbreviation.setText("Abbreviation");
		tableViewerColumnAbbrev.setLabelProvider(new HREColumnLabelProvider(2));

		final TableViewerColumn tableViewerColumnLabel = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnLabel = tableViewerColumnLabel.getColumn();
		tblclmnLabel.setWidth(100);
		tblclmnLabel.setText("Parent Role");
		tableViewerColumnLabel.setLabelProvider(new HREColumnLabelProvider(3));

		final Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem mntmAddParentRole = new MenuItem(menu, SWT.NONE);
		mntmAddParentRole.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final WizardDialog dialog = new WizardDialog(parent.getShell(),
						new NewParentRoleWizard(context));
				dialog.open();
			}
		});
		mntmAddParentRole.setText("Add Parent role...");

		final MenuItem mntmDeleteSelectedParent = new MenuItem(menu, SWT.NONE);
		mntmDeleteSelectedParent.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				deleteParentRole(parent.getShell());
			}
		});
		mntmDeleteSelectedParent.setText("Delete selected Parent role...");

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		try {
			tableViewer.setInput(provider.getStringList());
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}
	}

	/**
	 * @param shell
	 */
	protected void deleteParentRole(Shell shell) {
		final TableItem[] selection = tableViewer.getTable().getSelection();

		String ParentRoleName = null;
		if (selection.length > 0) {
			final TableItem item = selection[0];
			ParentRolePid = Integer.parseInt(item.getText(0));
			ParentRoleName = item.getText(3);
		}

		// Last chance to regret
		final MessageDialog dialog = new MessageDialog(shell,
				"Delete Parent role " + ParentRoleName, null,
				"Are you sure that you will delete " + ParentRolePid + ", "
						+ ParentRoleName + "?",
				MessageDialog.CONFIRM, 0, "OK", "Cancel");

		if (dialog.open() == Window.CANCEL) {
			eventBroker.post("MESSAGE", "Delete of Parent role "
					+ ParentRoleName + " has been canceled");
			return;
		}

		try {
			provider = new ParentRoleProvider();
			provider.delete(ParentRolePid);
			eventBroker.post("MESSAGE",
					"Parent role " + ParentRoleName + " has been deleted");
			eventBroker.post(Constants.PARENT_ROLE_PID_UPDATE_TOPIC,
					ParentRolePid);
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

	}

	/**
	 *
	 */
	protected void openParentRoleView() {
		final ParameterizedCommand command = commandService.createCommand(
				"net.myerichsen.hremvp.command.openparentroleview", null);
		handlerService.executeHandler(command);

		final TableItem[] selectedRows = tableViewer.getTable().getSelection();

		if (selectedRows.length > 0) {
			final TableItem selectedRow = selectedRows[0];
			ParentRolePid = Integer.parseInt(selectedRow.getText(0));
			final List<String> ls = new ArrayList<>();
			ls.add(selectedRow.getText(0));
			ls.add(selectedRow.getText(1));
			ls.add(selectedRow.getText(2));
			ls.add(selectedRow.getText(3));

			LOGGER.log(Level.INFO,
					"Posting role id " + selectedRow.getText(0)
							+ ", dictionary id " + selectedRow.getText(1)
							+ ", abbreviation " + selectedRow.getText(2)
							+ ", label " + selectedRow.getText(3));
			eventBroker.post(Constants.LABEL_PID_UPDATE_TOPIC, ls);
		}

	}

	/**
	 * @param key
	 * @throws MvpException
	 */
	@Inject
	@Optional
	private void subscribeParentRolePidUpdateTopic(
			@UIEventTopic(Constants.PARENT_ROLE_PID_UPDATE_TOPIC) int ParentRolePid) {
		LOGGER.log(Level.FINE, "Received Parent Role id {0}", ParentRolePid);
		this.ParentRolePid = ParentRolePid;

		if (ParentRolePid > 0) {
			try {
				tableViewer.setInput(provider.getStringList());
				tableViewer.refresh();

				final TableItem[] items = tableViewer.getTable().getItems();
				final String item0 = Integer.toString(ParentRolePid);

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
