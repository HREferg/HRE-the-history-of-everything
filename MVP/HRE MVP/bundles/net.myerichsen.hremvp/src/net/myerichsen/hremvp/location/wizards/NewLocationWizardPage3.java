package net.myerichsen.hremvp.location.wizards;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import net.myerichsen.hremvp.dialogs.DateDialog;
import net.myerichsen.hremvp.dialogs.DateNavigatorDialog;
import net.myerichsen.hremvp.listeners.DoubleListener;
import net.myerichsen.hremvp.providers.HDateProvider;

/**
 * Base location data wizard page 3
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 18. mar. 2019
 *
 */
public class NewLocationWizardPage3 extends WizardPage {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;
	private NewLocationWizard wizard;

	/**
	 * Constructor
	 *
	 * @param context
	 *
	 */
	public NewLocationWizardPage3(IEclipseContext context) {
		super("wizardPage");
		setTitle("New Location");
		setDescription(
				"Enter optional time limitation for the location. Coordinates can have been set by Google.");
		this.context = context;
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

		setControl(container);
		container.setLayout(new GridLayout(2, false));

		final Composite compositeFrom = new Composite(container, SWT.BORDER);
		compositeFrom.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		compositeFrom.setLayout(new GridLayout(2, false));

		final Label lblFromDate = new Label(compositeFrom, SWT.NONE);
		lblFromDate.setText("From Date");

		final Text textFromDate = new Text(compositeFrom, SWT.BORDER);
		textFromDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textFromDate.setEditable(false);

		final Composite compositeFromButtons = new Composite(compositeFrom,
				SWT.NONE);
		compositeFromButtons.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		compositeFromButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnNewFrom = new Button(compositeFromButtons, SWT.NONE);
		btnNewFrom.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
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
						wizard = (NewLocationWizard) getWizard();
						wizard.setFromDatePid(hdp.insert());
						textFromDate.setText(dialog.getDate().toString());
					} catch (final Exception e1) {
						LOGGER.log(Level.SEVERE, e1.toString(), e1);
					}
				}
			}
		});
		btnNewFrom.setText("New");

		final Button btnBrowseFrom = new Button(compositeFromButtons, SWT.NONE);
		btnBrowseFrom.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				final DateNavigatorDialog dialog = new DateNavigatorDialog(
						textFromDate.getShell(), context);
				if (dialog.open() == Window.OK) {
					try {
						final int hdatePid = dialog.getHdatePid();
						final HDateProvider hdp = new HDateProvider();
						hdp.get(hdatePid);
						wizard = (NewLocationWizard) getWizard();
						wizard.setFromDatePid(hdatePid);
						textFromDate.setText(hdp.getDate().toString());
					} catch (final Exception e1) {
						LOGGER.log(Level.SEVERE, e1.toString(), e1);
					}
				}
			}
		});
		btnBrowseFrom.setText("Browse");

		final Button btnClearFrom = new Button(compositeFromButtons, SWT.NONE);
		btnClearFrom.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				wizard = (NewLocationWizard) getWizard();
				wizard.setFromDatePid(0);
				textFromDate.setText("");
			}
		});
		btnClearFrom.setText("Clear");

		final Composite compositeTo = new Composite(container, SWT.BORDER);
		compositeTo.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		compositeTo.setLayout(new GridLayout(2, false));

		final Label lblToDate = new Label(compositeTo, SWT.NONE);
		lblToDate.setText("To Date");

		final Text textToDate = new Text(compositeTo, SWT.BORDER);
		textToDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textToDate.setEditable(false);

		final Composite compositeToButtons = new Composite(compositeTo,
				SWT.NONE);
		compositeToButtons.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		compositeToButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnCopyFromTo = new Button(compositeToButtons, SWT.NONE);
		btnCopyFromTo.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				wizard = (NewLocationWizard) getWizard();
				wizard.setToDatePid(wizard.getFromDatePid());
				textToDate.setText(textFromDate.getText());
			}
		});
		btnCopyFromTo.setText("Copy From");

		final Button btnNewTo = new Button(compositeToButtons, SWT.NONE);
		btnNewTo.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
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
						wizard = (NewLocationWizard) getWizard();
						wizard.setToDatePid(hdp.insert());
						textToDate.setText(dialog.getDate().toString());
					} catch (final Exception e1) {
						LOGGER.log(Level.SEVERE, e1.toString(), e1);
					}
				}
			}
		});
		btnNewTo.setText("New");

		final Button btnBrowseTo = new Button(compositeToButtons, SWT.NONE);
		btnBrowseTo.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				final DateNavigatorDialog dialog = new DateNavigatorDialog(
						textToDate.getShell(), context);
				if (dialog.open() == Window.OK) {
					try {
						final int hdatePid = dialog.getHdatePid();
						final HDateProvider hdp = new HDateProvider();
						hdp.get(hdatePid);
						wizard = (NewLocationWizard) getWizard();
						wizard.setToDatePid(hdatePid);
						textToDate.setText(hdp.getDate().toString());
					} catch (final Exception e1) {
						LOGGER.log(Level.SEVERE, e1.toString(), e1);
					}
				}
			}
		});
		btnBrowseTo.setText("Browse");

		final Button btnClearTo = new Button(compositeToButtons, SWT.NONE);
		btnClearTo.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				wizard = (NewLocationWizard) getWizard();
				wizard.setToDatePid(0);
				textToDate.setText("");
			}
		});
		btnClearTo.setText("Clear");

		final Label lblXCoordinate = new Label(container, SWT.NONE);
		lblXCoordinate.setText("X Coordinate");

		wizard = (NewLocationWizard) getWizard();

		final Text textXCoordinate = new Text(container, SWT.BORDER);
		textXCoordinate.addModifyListener(e -> {
			wizard = (NewLocationWizard) getWizard();
			wizard.setxCoordinate(Double.valueOf(textXCoordinate.getText()));
		});
		textXCoordinate.setText(Double.toString(wizard.getxCoordinate()));
		textXCoordinate.setToolTipText("Latitude (-180 to 180)");
		textXCoordinate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textXCoordinate.addListener(SWT.Verify, new DoubleListener());
		textXCoordinate.setText(Double.toString(wizard.getxCoordinate()));

		final Label lblYCoordinate = new Label(container, SWT.NONE);
		lblYCoordinate.setText("Y Coordinate");

		final Text textYCoordinate = new Text(container, SWT.BORDER);
		textYCoordinate.addModifyListener(e -> {
			wizard = (NewLocationWizard) getWizard();
			wizard.setyCoordinate(Double.valueOf(textYCoordinate.getText()));
		});
		textYCoordinate.setText(Double.toString(wizard.getyCoordinate()));
		textYCoordinate.setToolTipText("Longitude (-90 to 90)");
		textYCoordinate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textYCoordinate.addListener(SWT.Verify, new DoubleListener());
		textYCoordinate.setText(Double.toString(wizard.getyCoordinate()));

		final Label lblZCoordinate = new Label(container, SWT.NONE);
		lblZCoordinate.setText("Z Coordinate");

		final Text textZCoordinate = new Text(container, SWT.BORDER);
		textZCoordinate.addModifyListener(e -> {
			wizard = (NewLocationWizard) getWizard();
			wizard.setzCoordinate(Double.valueOf(textZCoordinate.getText()));
		});
		textZCoordinate.setText(Double.toString(wizard.getzCoordinate()));
		textZCoordinate.setToolTipText("Elevation above sea level in meters");
		textZCoordinate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textZCoordinate.addListener(SWT.Verify, new DoubleListener());

		new Label(container, SWT.NONE);

		final Button btnCheckButtonPrimary = new Button(container, SWT.CHECK);
		btnCheckButtonPrimary.addFocusListener(new FocusAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.
			 * events.FocusEvent)
			 */
			@Override
			public void focusLost(FocusEvent e) {
				wizard = (NewLocationWizard) getWizard();
				wizard.setIsPrimaryLocationName(
						btnCheckButtonPrimary.getSelection());
			}
		});
		btnCheckButtonPrimary.setToolTipText("Default");
		btnCheckButtonPrimary.setSelection(true);
		btnCheckButtonPrimary.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnCheckButtonPrimary.setText("Primary Location");
	}

}
