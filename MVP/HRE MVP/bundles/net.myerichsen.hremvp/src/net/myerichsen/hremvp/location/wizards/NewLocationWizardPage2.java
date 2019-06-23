package net.myerichsen.hremvp.location.wizards;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.json.JSONArray;
import org.json.JSONObject;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.HreTypeLabelEditingSupport;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.project.providers.LocationNameMapProvider;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Location name parts wizard page 2
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 15. jun. 2019
 *
 */
public class NewLocationWizardPage2 extends WizardPage {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	final IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");
	NewLocationWizard wizard;

	private Text textGoogleApiKey;
	private final IEclipseContext context;
	private final LocationNameMapProvider provider;
	private TableViewer tableViewer;
	private Text textCoordinates;

	/**
	 * Constructor
	 *
	 * @param context The Eclipse Context
	 *
	 */
	public NewLocationWizardPage2(IEclipseContext context) {
		super("wizardPage");
		LOGGER.log(Level.INFO, "Wizard page 2");
		this.context = context;
		setTitle("Location Name Parts");
		setDescription(
				"Enter the parts of the location name. Get coordinates from Google.");
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
		LOGGER.log(Level.INFO, "Create controls");
		final Composite container = new Composite(parent, SWT.NONE);
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
				final List<String> stringList = new ArrayList<>();
				final TableItem[] items = tableViewer.getTable().getItems();

				for (final TableItem tableItem : items) {
					String text = tableItem.getText(4);

					if (text.length() == 0) {
						text = "";
					}

					stringList.add(text);
				}

				wizard = (NewLocationWizard) getWizard();
				wizard.setLocationNamePartList(stringList);
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

		final Label lblGoogleMapsKey = new Label(container, SWT.NONE);
		lblGoogleMapsKey.setText("Google API Key");

		textGoogleApiKey = new Text(container, SWT.BORDER | SWT.PASSWORD);
		textGoogleApiKey.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textGoogleApiKey.setText(store.getString("GOOGLEAPIKEY"));

		final Button btnGetCoordinatesFrom = new Button(container, SWT.NONE);
		btnGetCoordinatesFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				for (final TableItem item : tableViewer.getTable().getItems()) {
					if (item.getText(4).length() > 0) {
						setPageComplete(true);
					}
				}
				geocode();
			}
		});
		btnGetCoordinatesFrom.setText("Get coordinates from Google");

		textCoordinates = new Text(container, SWT.BORDER);
		textCoordinates.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textCoordinates.setEditable(false);

		setControl(container);

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		try {
			wizard = (NewLocationWizard) getWizard();
			final int locationNameStylePid = wizard.getLocationNameStylePid();
			final List<List<String>> stringList = provider
					.getStringList(locationNameStylePid);
			tableViewer.setInput(stringList);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}

		setPageComplete(true);
	}

	/**
	 *
	 */
	protected void geocode() {
		final IEventBroker eventBroker = context.get(IEventBroker.class);
		boolean valid = false;
		StringBuilder sb = new StringBuilder();
		String locationPart;

		for (final TableItem item : tableViewer.getTable().getItems()) {
			locationPart = item.getText(4);
			if (locationPart.length() > 0) {
				valid = true;
				sb.append(locationPart + " ");
			}
		}

		if (valid) {
			setPageComplete(true);
			wizard = (NewLocationWizard) getWizard();
			wizard.addBackPages();
			wizard.getContainer().updateButtons();
		}
		if (textGoogleApiKey.getText().length() == 0) {
			textGoogleApiKey.setFocus();
			eventBroker.post("MESSAGE", "Please insert Google Map Key");
			return;
		}

		if (!valid) {
			tableViewer.getTable().select(0);
			eventBroker.post("MESSAGE", "Please enter a location name");
			return;
		}

		locationPart = sb.toString().trim().replace(' ', '+');

		try {
			final CloseableHttpClient client = HttpClients.createDefault();
			final String requestString = "https://maps.googleapis.com/maps/api/geocode/json?address="
					+ locationPart + "&key="
					+ textGoogleApiKey.getText().trim();
			final HttpGet request = new HttpGet(requestString);

			final CloseableHttpResponse response = client.execute(request);

			final StatusLine statusLine = response.getStatusLine();

			if (statusLine.getStatusCode() != 200) {
				throw new MvpException(statusLine.getReasonPhrase());
			}

			final BufferedReader br = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));

			String s;
			sb = new StringBuilder();

			while (null != (s = br.readLine())) {
				sb.append(s);
			}

			br.close();
			response.close();
			client.close();

			final JSONObject jsonObject = new JSONObject(sb.toString());

			LOGGER.log(Level.FINE, "{0}", jsonObject.toString(2));

			final String status = jsonObject.getString("status");

			if (!status.equals("OK")) {
				throw new MvpException(
						status + ", " + jsonObject.getString("error_message"));
			}

			final JSONArray results = jsonObject.getJSONArray("results");
			final JSONObject result0 = results.getJSONObject(0);
			final JSONObject geometry = result0.getJSONObject("geometry");
			final JSONObject location = geometry.getJSONObject("location");
			final double lat = location.getDouble("lat");
			final double lng = location.getDouble("lng");
			LOGGER.log(Level.FINE, "Lat {0}, lng {1}",
					new Object[] { lat, lng });
			textCoordinates.setText("Lat " + lat + ", lng " + lng);

			wizard.setxCoordinate(lat);
			wizard.setyCoordinate(lng);
			wizard.addBackPages();
			wizard.getContainer().updateButtons();
			wizard.setLocationName(result0.getString("formatted_address"));
			eventBroker.post("MESSAGE",
					"Geocoded address " + result0.getString("formatted_address")
							+ " as lat " + lat + ", lng " + lng);
		} catch (final Exception e) {
			LOGGER.severe(e.getCause() + ": " + e.getMessage());
			eventBroker.post("MESSAGE", e.getCause() + ": " + e.getMessage());
		}
	}

}
