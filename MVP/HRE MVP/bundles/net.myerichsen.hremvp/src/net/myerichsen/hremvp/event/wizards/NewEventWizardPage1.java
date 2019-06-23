package net.myerichsen.hremvp.event.wizards;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import net.myerichsen.hremvp.dialogs.DateDialog;
import net.myerichsen.hremvp.dialogs.DateNavigatorDialog;
import net.myerichsen.hremvp.project.providers.EventTypeProvider;
import net.myerichsen.hremvp.project.providers.LanguageProvider;
import net.myerichsen.hremvp.providers.HDateProvider;
import net.myerichsen.hremvp.providers.HREComboLabelProvider;

/**
 * Base location data wizard page
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 26. mar. 2019
 *
 */
public class NewEventWizardPage1 extends WizardPage {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;
	private NewEventWizard wizard;
	private List<List<String>> languageStringList;
	private List<List<String>> eventStringList;
	private ComboViewer comboViewerEventType;
	private ComboViewer comboViewerLanguage;

	/**
	 * Constructor
	 *
	 * @param context The Eclipse context
	 *
	 */
	public NewEventWizardPage1(IEclipseContext context) {
		super("wizardPage");
		setTitle("New Event");
		setDescription("Create a new event by entering static data for it\r\n");
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
//		container.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				if (comboViewerEventType.getSelection() == null) {
//					setErrorMessage("Please select an event type");
//				} else if (comboViewerLanguage.getSelection() == null) {
//					setErrorMessage("Please select a language");
//				} else {
//					setErrorMessage(null);
//				}
//			}
//		});

		setControl(container);
		final GridLayout gl_container = new GridLayout(2, false);
		container.setLayout(gl_container);

		final Label lblEventType = new Label(container, SWT.NONE);
		lblEventType.setText("Event Type");

		comboViewerEventType = new ComboViewer(container, SWT.NONE);
		final Combo comboEventType = comboViewerEventType.getCombo();
		comboEventType.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final int selectionIndex = comboEventType.getSelectionIndex();
				wizard = (NewEventWizard) getWizard();
				wizard.setEventTypePid(Integer
						.parseInt(eventStringList.get(selectionIndex).get(0)));
			}
		});
		comboViewerEventType
				.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerEventType.setLabelProvider(new HREComboLabelProvider(2));
		comboEventType.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		try {
			eventStringList = new EventTypeProvider().getStringList();
			comboViewerEventType.setInput(eventStringList);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
			setErrorMessage(e1.getMessage());
		}

		final Label lblLanguage = new Label(container, SWT.NONE);
		lblLanguage.setText("Language");

		comboViewerLanguage = new ComboViewer(container, SWT.NONE);
		final Combo comboLanguage = comboViewerLanguage.getCombo();
		comboLanguage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final int selectionIndex = comboLanguage.getSelectionIndex();
				wizard = (NewEventWizard) getWizard();
				wizard.setLocationPid(Integer.parseInt(
						languageStringList.get(selectionIndex).get(0)));
			}
		});
		comboViewerLanguage
				.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerLanguage.setLabelProvider(new HREComboLabelProvider(2));
		comboLanguage.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		try {
			languageStringList = new LanguageProvider().getStringList();
			comboViewerLanguage.setInput(languageStringList);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
			setErrorMessage(e1.getMessage());
		}

		final Composite compositeFrom = new Composite(container, SWT.BORDER);
		compositeFrom.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		compositeFrom.setLayout(new GridLayout(2, false));
		final Label lblFromDate = new Label(compositeFrom, SWT.NONE);
		lblFromDate.setText("From Date");

		final Text textFromDate = new Text(compositeFrom, SWT.BORDER);
		textFromDate.setEditable(false);
		textFromDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Composite compositeFromButtons = new Composite(compositeFrom,
				SWT.NONE);
		compositeFromButtons.setLayout(new RowLayout(SWT.HORIZONTAL));
		compositeFromButtons.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));

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
						wizard = (NewEventWizard) getWizard();
						wizard.setFromDatePid(hdp.insert());
						textFromDate.setText(dialog.getDate().toString());
					} catch (final Exception e1) {
						LOGGER.log(Level.SEVERE, e1.toString(), e1);
						setErrorMessage(e1.getMessage());
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
						wizard = (NewEventWizard) getWizard();
						wizard.setFromDatePid(hdatePid);
						textFromDate.setText(hdp.getDate().toString());
					} catch (final Exception e1) {
						LOGGER.log(Level.SEVERE, e1.toString(), e1);
						setErrorMessage(e1.getMessage());
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
				wizard = (NewEventWizard) getWizard();
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
		textToDate.setEditable(false);
		textToDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Composite compositeToButtons = new Composite(compositeTo,
				SWT.NONE);
		compositeToButtons.setLayout(new RowLayout(SWT.HORIZONTAL));
		compositeToButtons.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));

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
				wizard = (NewEventWizard) getWizard();
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
						wizard = (NewEventWizard) getWizard();
						wizard.setToDatePid(hdp.insert());
						textToDate.setText(dialog.getDate().toString());
					} catch (final Exception e1) {
						LOGGER.log(Level.SEVERE, e1.toString(), e1);
						setErrorMessage(e1.getMessage());
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
						wizard = (NewEventWizard) getWizard();
						wizard.setToDatePid(hdatePid);
						textToDate.setText(hdp.getDate().toString());
					} catch (final Exception e1) {
						LOGGER.log(Level.SEVERE, e1.toString(), e1);
						setErrorMessage(e1.getMessage());
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
				wizard = (NewEventWizard) getWizard();
				wizard.setToDatePid(0);
				textToDate.setText("");
			}
		});
		btnClearTo.setText("Clear");

	}

}
