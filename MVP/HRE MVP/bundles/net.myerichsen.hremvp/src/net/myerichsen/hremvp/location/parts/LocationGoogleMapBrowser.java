package net.myerichsen.hremvp.location.parts;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.location.providers.LocationNameProvider;
import net.myerichsen.hremvp.location.providers.LocationProvider;

/**
 * Display location on Google Maps
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 18. nov. 2018
 *
 */
public class LocationGoogleMapBrowser {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private Text textLocationId;
	private Text textLocationName;
	private Browser browser;

	/**
	 * Constructor
	 *
	 */
	@Inject
	public LocationGoogleMapBrowser() {

	}

	/**
	 * Create widgets
	 *
	 * @param parent The parent composite
	 */
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(3, false));

		final Label lblNewLabel = new Label(parent, SWT.NONE);
		lblNewLabel.setText("Location");

		textLocationId = new Text(parent, SWT.BORDER);
		textLocationId.setEditable(false);
		textLocationId.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		textLocationName = new Text(parent, SWT.BORDER);
		textLocationName.setEditable(false);
		textLocationName.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		browser = new Browser(parent, SWT.NONE);
		final GridData gd_browser = new GridData(SWT.FILL, SWT.FILL, true, true,
				3, 1);
		gd_browser.heightHint = 260;
		browser.setLayoutData(gd_browser);
	}

	/**
	 * @param provider Location Provider
	 * @throws Exception
	 */
	@Inject
	@Optional
	private void subscribeLocationGoogleMapBrowserUpdateTopic(
			@UIEventTopic(Constants.LOCATION_GOOGLE_MAP_UPDATE_TOPIC) LocationProvider provider)
			throws Exception {
		textLocationId.setText(Integer.toString(provider.getLocationPid()));
		final LocationNameProvider lnp = new LocationNameProvider();
		textLocationName
				.setText(lnp.getPrimaryNameString(provider.getLocationPid()));
		LOGGER.log(Level.FINE, "Lat Long: " + provider.getxCoordinate() + ", "
				+ provider.getyCoordinate());
		browser.setUrl(
				"http://www.google.com/maps/@?api=1&map_action=map&center="
						+ provider.getxCoordinate() + ", "
						+ provider.getyCoordinate() + "&basemap=terrain");
	}
}