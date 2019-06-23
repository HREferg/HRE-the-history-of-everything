package net.myerichsen.hremvp.project.parts;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.wb.swt.ResourceManager;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.project.providers.MvpLogProvider;

/**
 * Display the application log
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 20. apr. 2019
 */
public class LogViewer {
	private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");
	private final String logAddress;
	private Table table;
	private final MvpLogProvider provider;
	private TableViewer tableViewer;

	/**
	 * Constructor
	 *
	 */
	public LogViewer() {
		provider = new MvpLogProvider();
		logAddress = store.getString("LOGFILEPATH") + "mvp-log.0.0.txt";
	}

	/**
	 * Create contents of the view part.
	 *
	 * @param parent The composite parent
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		final ToolBar toolBar = new ToolBar(parent, SWT.FLAT | SWT.RIGHT);
		toolBar.setLayoutData(
				new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

		final ToolItem toolItem = new ToolItem(toolBar, SWT.NONE);
		toolItem.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				refresh();
			}
		});
		toolItem.setImage(ResourceManager
				.getPluginImage("net.myerichsen.hremvp", "icons/refresh.png"));

		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		final Menu menu = new Menu(table);
		table.setMenu(menu);

		final MenuItem mntmRefresh = new MenuItem(menu, SWT.NONE);
		mntmRefresh.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				refresh();
			}
		});
		mntmRefresh.setText("Refresh");

		tableViewer.setContentProvider(provider);
		tableViewer.setInput(logAddress);
	}

	/**
	 *
	 */
	private void refresh() {
		tableViewer.setInput(logAddress);
		tableViewer.refresh();
		table.setTopIndex(table.getItemCount() - 1);
	}

	/**
	 * @param key
	 */
	@Inject
	@Optional
	private void subscribeLogRefreshUpdateTopic(
			@UIEventTopic(Constants.LOG_REFRESH_UPDATE_TOPIC) int i) {
		LOGGER.log(Level.FINE, "Update topic received");
		refresh();
	}
}
