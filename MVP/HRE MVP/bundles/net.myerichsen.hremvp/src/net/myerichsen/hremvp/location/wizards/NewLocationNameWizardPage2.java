package net.myerichsen.hremvp.location.wizards;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.HreTypeLabelEditingSupport;
import net.myerichsen.hremvp.project.providers.LocationNameMapProvider;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * New location name wizard page 2
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 17. apr. 2019
 *
 */
public class NewLocationNameWizardPage2 extends WizardPage {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	final IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");
	private NewLocationNameWizard wizard;

	private final LocationNameMapProvider provider;
	private List<List<String>> lls;

	/**
	 * Constructor
	 *
	 * @param context The Eclipse Context
	 *
	 */
	public NewLocationNameWizardPage2(IEclipseContext context) {
		super("wizardPage");
		setTitle("Location Name Parts");
		setDescription("Enter the parts of the location name.");
		wizard = (NewLocationNameWizard) getWizard();
		provider = new LocationNameMapProvider();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.
	 * widgets. Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));

		final TableViewer tableViewer = new TableViewer(container,
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
					wizard.setLocationNamePartList(stringList);
					setPageComplete(true);
				}

			}
		});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		final TableViewerColumn tableViewerColumnMapPid = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnMapPid = tableViewerColumnMapPid.getColumn();
		tblclmnMapPid.setWidth(70);
		tblclmnMapPid.setText("Map Pid");
		tableViewerColumnMapPid.setLabelProvider(new HREColumnLabelProvider(0));

		final TableViewerColumn tableViewerColumnLabelPid = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnLabelPid = tableViewerColumnLabelPid
				.getColumn();
		tblclmnLabelPid.setWidth(70);
		tblclmnLabelPid.setText("Label Pid");
		tableViewerColumnLabelPid
				.setLabelProvider(new HREColumnLabelProvider(1));

		final TableViewerColumn tableViewerColumnPartNo = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnPartNo = tableViewerColumnPartNo.getColumn();
		tblclmnPartNo.setWidth(70);
		tblclmnPartNo.setText("Part no.");
		tableViewerColumnPartNo.setLabelProvider(new HREColumnLabelProvider(2));

		final TableViewerColumn tableViewerColumnMapLabel = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnMapLabel = tableViewerColumnMapLabel
				.getColumn();
		tblclmnMapLabel.setWidth(200);
		tblclmnMapLabel.setText("Map Label");
		tableViewerColumnMapLabel
				.setLabelProvider(new HREColumnLabelProvider(3));

		final TableViewerColumn tableViewerColumnPartLabel = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnPartLabel = tableViewerColumnPartLabel
				.getColumn();
		tblclmnPartLabel.setWidth(200);
		tblclmnPartLabel.setText("Part Label");
		tableViewerColumnPartLabel.setEditingSupport(
				new HreTypeLabelEditingSupport(tableViewer, 4));
		tableViewerColumnPartLabel
				.setLabelProvider(new HREColumnLabelProvider(4));

		HREColumnLabelProvider.addEditingSupport(tableViewer);

		setControl(container);

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		try {
			wizard = (NewLocationNameWizard) getWizard();
			final int locationNameStylePid = wizard.getLocationNameStylePid();
			lls = provider.getStringList(locationNameStylePid);
			tableViewer.setInput(lls);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}

		setPageComplete(true);
	}

}
