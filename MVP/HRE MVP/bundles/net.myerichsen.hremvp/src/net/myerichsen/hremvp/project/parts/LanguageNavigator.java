package net.myerichsen.hremvp.project.parts;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

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
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.NavigatorFilter;
import net.myerichsen.hremvp.project.providers.LanguageProvider;
import net.myerichsen.hremvp.project.wizards.NewLanguageWizard;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Display all data about languages used in HRE
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 18. apr. 2019
 *
 */
public class LanguageNavigator {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Inject
	private IEventBroker eventBroker;

	private TableViewer tableViewer;
	private LanguageProvider provider;
	private NavigatorFilter navigatorFilter;

	/**
	 * Constructor
	 *
	 */
	public LanguageNavigator() {
		try {
			provider = new LanguageProvider();
			navigatorFilter = new NavigatorFilter(1);
		} catch (final Exception e) {
			eventBroker.post("MESSAGE", e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 * Create contents of the view part
	 */
	@PostConstruct
	public void createControls(Composite parent, IEclipseContext context) {
		parent.setLayout(new GridLayout(2, false));

		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.addFilter(navigatorFilter);

		final Table table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		final TableViewerColumn tableViewerColumnId = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnId = tableViewerColumnId.getColumn();
		tblclmnId.setWidth(100);
		tblclmnId.setText("ID");
		tableViewerColumnId.setLabelProvider(new HREColumnLabelProvider(0));

		final TableViewerColumn tableViewerColumnIsoCode = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnIsoCode = tableViewerColumnIsoCode.getColumn();
		tblclmnIsoCode.setWidth(100);
		tblclmnIsoCode.setText("ISO Code");
		tableViewerColumnIsoCode
				.setLabelProvider(new HREColumnLabelProvider(1));

		final TableViewerColumn tableViewerColumnLabel = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnName = tableViewerColumnLabel.getColumn();
		tblclmnName.setWidth(100);
		tblclmnName.setText("Name");
		tableViewerColumnLabel.setLabelProvider(new HREColumnLabelProvider(2));

		final Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem mntmAddLanguage = new MenuItem(menu, SWT.NONE);
		mntmAddLanguage.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final WizardDialog dialog = new WizardDialog(parent.getShell(),
						new NewLanguageWizard(context));
				dialog.open();
			}
		});
		mntmAddLanguage.setText("Add Language...");

		final MenuItem mntmDeleteSelectedLanguage = new MenuItem(menu,
				SWT.NONE);
		mntmDeleteSelectedLanguage.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				deleteLanguage(parent.getShell());
			}
		});
		mntmDeleteSelectedLanguage.setText("Delete selected Language...");

		final Label lblNameFilter = new Label(parent, SWT.NONE);
		lblNameFilter.setText("ISO Code Filter");

		final Text textNameFilter = new Text(parent, SWT.BORDER);
		textNameFilter.addKeyListener(new KeyAdapter() {

			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.KeyAdapter#keyReleased(org.eclipse.swt.
			 * events.KeyEvent)
			 */
			@Override
			public void keyReleased(KeyEvent e) {
				navigatorFilter.setSearchText(textNameFilter.getText());
				tableViewer.refresh();
			}
		});

		textNameFilter.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

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
	protected void deleteLanguage(Shell shell) {
		final TableItem[] selection = tableViewer.getTable().getSelection();

		int languagePid = 0;
		String primaryName = null;
		if (selection.length > 0) {
			final TableItem item = selection[0];
			languagePid = Integer.parseInt(item.getText(0));
			primaryName = item.getText(1);
		}

		// Last chance to regret
		final MessageDialog dialog = new MessageDialog(shell,
				"Delete Language " + primaryName, null,
				"Are you sure that you will delete language " + languagePid
						+ ", " + primaryName + "?",
				MessageDialog.CONFIRM, 0, "OK", "Cancel");

		if (dialog.open() == Window.CANCEL) {
			eventBroker.post("MESSAGE", "Deletion of language " + primaryName
					+ " has been canceled");
			return;
		}

		try {
			provider = new LanguageProvider();
			provider.delete(languagePid);

			LOGGER.log(Level.INFO, "Language {0} has been deleted",
					primaryName);
			eventBroker.post("MESSAGE",
					"Language " + primaryName + " has been deleted");
			eventBroker.post(Constants.LANGUAGE_PID_UPDATE_TOPIC, 0);
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

	}

	/**
	 * @param languagePid
	 */
	@Inject
	@Optional
	private void subscribeLanguagePidUpdateTopic(
			@UIEventTopic(Constants.LANGUAGE_PID_UPDATE_TOPIC) int languagePid) {
		LOGGER.log(Level.FINE, "Received language id {0}",
				Integer.toString(languagePid));
		try {
			tableViewer.setInput(provider.getStringList());
			tableViewer.refresh();

			if (languagePid > 0) {
				final TableItem[] items = tableViewer.getTable().getItems();
				final String item0 = Integer.toString(languagePid);

				for (int i = 0; i < items.length; i++) {
					if (item0.equals(items[i].getText(0))) {
						tableViewer.getTable().setSelection(i);
						break;
					}
				}
			}
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}
}
