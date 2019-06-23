package net.myerichsen.hremvp.location.parts;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.dialogs.DateDialog;
import net.myerichsen.hremvp.dialogs.DateNavigatorDialog;
import net.myerichsen.hremvp.location.providers.LocationProvider;
import net.myerichsen.hremvp.providers.HDateProvider;

/**
 * Display static data about a location
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 18. apr. 2019
 */
public class LocationView {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Inject
	private EPartService partService;
	@Inject
	private EModelService modelService;
	@Inject
	private MApplication application;
	@Inject
	private IEventBroker eventBroker;
	@Inject
	private IEclipseContext context;

	private Text textId;
	private Text textXCoordinate;
	private Text textYCoordinate;
	private Text textZCoordinate;
	private Button btnPrimaryLocation;

	private Text textFromDatePid;
	private Text textFromDate;
	private Text textFromOriginal;

	private Text textToDatePid;
	private Text textToDate;
	private Text textToOriginal;

	private final LocationProvider provider;

	/**
	 * Constructor
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 *
	 */
	public LocationView() throws Exception {
		provider = new LocationProvider();
	}

	/**
	 * Create contents of the view part
	 *
	 * @param parent The parent composite
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		final ScrolledComposite scrolledComposite = new ScrolledComposite(
				parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		final Composite composite_1 = new Composite(scrolledComposite,
				SWT.NONE);
		composite_1.setLayout(new GridLayout(3, false));

		final Label lblId = new Label(composite_1, SWT.NONE);
		lblId.setText("Location ID");

		textId = new Text(composite_1, SWT.BORDER);
		textId.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		btnPrimaryLocation = new Button(composite_1, SWT.CHECK);
		btnPrimaryLocation.setText("Primary Location");

		final Label lblXCoordinate = new Label(composite_1, SWT.NONE);
		lblXCoordinate.setText("X Coordinate");

		textXCoordinate = new Text(composite_1, SWT.BORDER);
		textXCoordinate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));

		final Label lblYCoordinate = new Label(composite_1, SWT.NONE);
		lblYCoordinate.setText("Y Coordinate");

		textYCoordinate = new Text(composite_1, SWT.BORDER);
		textYCoordinate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));

		final Label lblZCoordinate = new Label(composite_1, SWT.NONE);
		lblZCoordinate.setText("Z Coordinate");

		textZCoordinate = new Text(composite_1, SWT.BORDER);
		textZCoordinate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));

		final Label lblFromDate = new Label(composite_1, SWT.NONE);
		lblFromDate.setText("From Date ID");

		textFromDatePid = new Text(composite_1, SWT.BORDER);
		textFromDatePid.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		final Composite compositeFrom = new Composite(composite_1, SWT.NONE);
		compositeFrom.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnNewFrom = new Button(compositeFrom, SWT.NONE);
		btnNewFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				final DateDialog dialog = new DateDialog(
						textFromDate.getShell(), context);
				if (dialog.open() == Window.OK) {
					try {
						final HDateProvider hdp = new HDateProvider();
						hdp.setDate(dialog.getDate());
						hdp.setSortDate(dialog.getSortDate());
						hdp.setOriginalText(dialog.getOriginal());
						hdp.setSurety(dialog.getSurety());
						final int hdatePid = hdp.insert();
						textFromDatePid.setText(Integer.toString(hdatePid));
						textFromDate.setText(dialog.getDate().toString());
						textFromOriginal.setText(dialog.getOriginal());
					} catch (final Exception e1) {
						LOGGER.log(Level.SEVERE, e1.toString(), e1);
					}
				}
			}
		});
		btnNewFrom.setText("New");

		final Button btnBrowseFrom = new Button(compositeFrom, SWT.NONE);
		btnBrowseFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				final DateNavigatorDialog dialog = new DateNavigatorDialog(
						textFromDate.getShell(), context);
				if (dialog.open() == Window.OK) {
					try {
						final int hdatePid = dialog.getHdatePid();
						final HDateProvider hdp = new HDateProvider();
						hdp.get(hdatePid);
						textFromDatePid.setText(Integer.toString(hdatePid));
						textFromDate.setText(hdp.getDate().toString());
						textFromOriginal.setText(hdp.getOriginalText());
					} catch (final Exception e1) {
						LOGGER.log(Level.SEVERE, e1.toString(), e1);
					}
				}
			}
		});
		btnBrowseFrom.setText("Browse");

		final Button btnClearFrom = new Button(compositeFrom, SWT.NONE);
		btnClearFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				textFromDatePid.setText("");
				textFromDate.setText("");
				textFromOriginal.setText("");
			}
		});
		btnClearFrom.setText("Clear");

		textFromDate = new Text(composite_1, SWT.BORDER);
		textFromDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		textFromDate.setEditable(false);

		textFromOriginal = new Text(composite_1, SWT.BORDER);
		textFromOriginal.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		textFromOriginal.setEditable(false);

		final Label lblToDate = new Label(composite_1, SWT.NONE);
		lblToDate.setText("To Date ID");

		textToDatePid = new Text(composite_1, SWT.BORDER);
		textToDatePid.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		final Composite compositeTo = new Composite(composite_1, SWT.NONE);
		compositeTo.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnCopyFromTo = new Button(compositeTo, SWT.NONE);
		btnCopyFromTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				textToDatePid.setText(textFromDatePid.getText());
				textToDate.setText(textFromDate.getText());
				textToOriginal.setText(textFromOriginal.getText());
			}
		});
		btnCopyFromTo.setText("Copy From");

		final Button btnNewTo = new Button(compositeTo, SWT.NONE);
		btnNewTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				final DateDialog dialog = new DateDialog(textToDate.getShell(),
						context);
				if (dialog.open() == Window.OK) {
					try {
						final HDateProvider hdp = new HDateProvider();
						hdp.setDate(dialog.getDate());
						hdp.setSortDate(dialog.getSortDate());
						hdp.setOriginalText(dialog.getOriginal());
						hdp.setSurety(dialog.getSurety());
						final int hdatePid = hdp.insert();
						textToDatePid.setText(Integer.toString(hdatePid));
						textToDate.setText(dialog.getDate().toString());
						textToOriginal.setText(dialog.getOriginal());
					} catch (final Exception e1) {
						LOGGER.log(Level.SEVERE, e1.toString(), e1);
					}
				}
			}
		});
		btnNewTo.setText("New");

		final Button btnBrowseTo = new Button(compositeTo, SWT.NONE);
		btnBrowseTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				final DateNavigatorDialog dialog = new DateNavigatorDialog(
						textToDate.getShell(), context);
				if (dialog.open() == Window.OK) {
					try {
						final int hdatePid = dialog.getHdatePid();
						final HDateProvider hdp = new HDateProvider();
						hdp.get(hdatePid);
						textToDatePid.setText(Integer.toString(hdatePid));
						textToDate.setText(hdp.getDate().toString());
						textToOriginal.setText(hdp.getOriginalText());
					} catch (final Exception e1) {
						LOGGER.log(Level.SEVERE, e1.toString(), e1);
					}
				}
			}
		});
		btnBrowseTo.setText("Browse");

		final Button btnClearTo = new Button(compositeTo, SWT.NONE);
		btnClearTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				textToDatePid.setText("");
				textToDate.setText("");
				textToOriginal.setText("");
			}
		});
		btnClearTo.setText("Clear");

		textToDate = new Text(composite_1, SWT.BORDER);
		textToDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		textToDate.setEditable(false);

		textToOriginal = new Text(composite_1, SWT.BORDER);
		textToOriginal.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		textToOriginal.setEditable(false);

		scrolledComposite.setContent(composite_1);
		scrolledComposite
				.setMinSize(composite_1.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(
				new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button buttonUpdate = new Button(composite, SWT.NONE);
		buttonUpdate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				update();
			}
		});
		buttonUpdate.setText("Update");
	}

	/**
	 * @param key
	 */
	private void get(int key) {
		try {
			try {
				provider.get(key);
			} catch (final Exception e2) {
			}
			textId.setText(Integer.toString(key));

			final HDateProvider hdp = new HDateProvider();

			try {
				final int fromDatePid = provider.getFromDatePid();
				hdp.get(fromDatePid);
				textFromDatePid.setText(Integer.toString(fromDatePid));
				textFromDate.setText(hdp.getDate().toString());
				textFromOriginal.setText(hdp.getOriginalText());
			} catch (final Exception e1) {
			}
			try {
				final int toDatePid = provider.getToDatePid();
				hdp.get(toDatePid);
				textToDatePid.setText(Integer.toString(toDatePid));
				textToDate.setText(hdp.getDate().toString());
				textToOriginal.setText(hdp.getOriginalText());
			} catch (final Exception e) {
			}
			try {
				textXCoordinate.setText(provider.getxCoordinate().toString());
			} catch (final Exception e) {
			}
			try {
				textYCoordinate.setText(provider.getyCoordinate().toString());
			} catch (final Exception e) {
			}
			try {
				textZCoordinate.setText(provider.getzCoordinate().toString());
			} catch (final Exception e) {
			}
			btnPrimaryLocation.setSelection(provider.isPrimaryLocation());

			openGoogleMaps();

		} catch (final Exception e) {
			eventBroker.post("MESSAGE", e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 *
	 */
	private void openGoogleMaps() {
		final String contributionURI = "bundleclass://net.myerichsen.hremvp/net.myerichsen.hremvp.location.parts.LocationGoogleMapBrowser";

		final List<MPartStack> stacks = modelService.findElements(application,
				null, MPartStack.class, null);
		MPart part = MBasicFactory.INSTANCE.createPart();

		boolean found = false;

		for (final MPartStack mPartStack : stacks) {
			final List<MStackElement> a = mPartStack.getChildren();

			for (int i = 0; i < a.size(); i++) {
				part = (MPart) a.get(i);
				try {
					if (part.getContributionURI().equals(contributionURI)) {
						partService.showPart(part, PartState.ACTIVATE);
						found = true;
						break;
					}
				} catch (final Exception e) {
					LOGGER.log(Level.INFO, e.getMessage());
				}
			}
		}

		if (!found) {
			part.setLabel("Google Maps View");
			part.setCloseable(true);
			part.setVisible(true);
			part.setContributionURI(contributionURI);
			stacks.get(stacks.size() - 2).getChildren().add(part);
			partService.showPart(part, PartState.ACTIVATE);
		}

		eventBroker.post(Constants.LOCATION_GOOGLE_MAP_UPDATE_TOPIC, provider);
	}

	/**
	 *
	 */
	protected void openLocationNameView() {
		final String contributionURI = "bundleclass://net.myerichsen.hremvp/net.myerichsen.hremvp.location.parts.LocationNameNavigator";

		final List<MPartStack> stacks = modelService.findElements(application,
				null, MPartStack.class, null);
		MPart part = MBasicFactory.INSTANCE.createPart();

		boolean found = false;

		for (final MPartStack mPartStack : stacks) {
			final List<MStackElement> a = mPartStack.getChildren();

			for (int i = 0; i < a.size(); i++) {
				part = (MPart) a.get(i);
				if (part.getContributionURI().equals(contributionURI)) {
					partService.showPart(part, PartState.ACTIVATE);
					found = true;
					break;
				}
			}
		}

		if (!found) {
			part.setLabel("Location Name View");
			part.setCloseable(true);
			part.setVisible(true);
			part.setContributionURI(contributionURI);
			stacks.get(stacks.size() - 2).getChildren().add(part);
			partService.showPart(part, PartState.ACTIVATE);
		}

	}

	/**
	 * @param key
	 */
	@Inject
	@Optional
	private void subscribeLocationPidUpdateTopic(
			@UIEventTopic(Constants.LOCATION_PID_UPDATE_TOPIC) int key) {
		get(key);
	}

	/**
	 *
	 */
	protected void update() {
		try {
			if (textFromDatePid.getText().length() > 0) {
				provider.setFromDatePid(
						Integer.parseInt(textFromDatePid.getText()));
			}
			if (textToDatePid.getText().length() > 0) {
				provider.setToDatePid(
						Integer.parseInt(textToDatePid.getText()));
			}
			provider.setLocationPid(Integer.parseInt(textId.getText()));
			provider.setPrimaryLocation(btnPrimaryLocation.getSelection());
			provider.setxCoordinate(new BigDecimal(textXCoordinate.getText()));
			provider.setyCoordinate(new BigDecimal(textYCoordinate.getText()));
			provider.setzCoordinate(new BigDecimal(textZCoordinate.getText()));
			provider.update();
			eventBroker.post("MESSAGE",
					"Location Name " + textId.getText() + " has been updated");
		} catch (final Exception e) {
			eventBroker.post("MESSAGE", e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}
}
