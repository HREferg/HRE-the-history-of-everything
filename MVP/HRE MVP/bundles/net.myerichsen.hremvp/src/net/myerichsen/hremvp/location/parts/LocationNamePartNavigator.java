package net.myerichsen.hremvp.location.parts;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.HreTypeLabelEditingSupport;
import net.myerichsen.hremvp.location.providers.LocationNamePartProvider;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Maintain all parts of a location name
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 18. apr. 2019
 */
public class LocationNamePartNavigator {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private LocationNamePartProvider provider;
	private TableViewer tableViewer;
	private int locationNamePid = 0;

	@Inject
	private IEventBroker eventBroker;

	/**
	 * Constructor
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 *
	 */
	public LocationNamePartNavigator() {
		provider = new LocationNamePartProvider();
	}

	/**
	 * Create contents of the view part
	 *
	 * @param parent The parent composite
	 * @throws Exception
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
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

		final TableViewerColumn tableViewerColumnPartNo = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnPartNo = tableViewerColumnPartNo.getColumn();
		tblclmnPartNo.setWidth(100);
		tblclmnPartNo.setText("Part no.");
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
		tableViewerColumnPart.setLabelProvider(new HREColumnLabelProvider(3));
		tableViewerColumnPart.setEditingSupport(
				new HreTypeLabelEditingSupport(tableViewer, 3));

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		try {
			tableViewer.setInput(provider.getStringList(locationNamePid));
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}

		HREColumnLabelProvider.addEditingSupport(tableViewer);

		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(
				new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button buttonUpdate = new Button(composite, SWT.NONE);
		buttonUpdate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLocationNamePart();
			}
		});
		buttonUpdate.setText("Update");

	}

	/**
	 * @param personPid
	 */
	@Inject
	@Optional
	private void subscribeLocationNamePidUpdateTopic(
			@UIEventTopic(Constants.LOCATION_NAME_PID_UPDATE_TOPIC) int locationNamePid) {
		LOGGER.log(Level.INFO, "Received location name id {0}",
				locationNamePid);

		if (locationNamePid == 0) {
			return;
		}

		this.locationNamePid = locationNamePid;

		try {
			tableViewer.setInput(provider.getStringList(locationNamePid));
			tableViewer.refresh();
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 *
	 */
	@SuppressWarnings("unchecked")
	private void updateLocationNamePart() {
		String string;

		try {
			final List<List<String>> locationNamePartList = provider
					.getStringList(locationNamePid);
			final List<List<String>> input = (List<List<String>>) tableViewer
					.getInput();

			for (int i = 0; i < input.size(); i++) {
				string = input.get(i).get(0);
				if ((string.equals(locationNamePartList.get(i).get(0)))
						&& (!input.get(i).get(3)
								.equals(locationNamePartList.get(i).get(3)))) {
					provider = new LocationNamePartProvider();
					provider.get(Integer.parseInt(string));
					provider.setLabel(input.get(i).get(3));
					provider.update();
				}

				eventBroker.post("MESSAGE", "Location name " + locationNamePid
						+ " has been updated");
			}
		} catch (

		final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

}
