package net.myerichsen.hremvp.location.wizards;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
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

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.dialogs.DateDialog;
import net.myerichsen.hremvp.dialogs.DateNavigatorDialog;
import net.myerichsen.hremvp.project.providers.LocationNameStyleProvider;
import net.myerichsen.hremvp.providers.HDateProvider;
import net.myerichsen.hremvp.providers.HREComboLabelProvider;

/**
 * Location name wizard page 1
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 18. apr. 2019
 */
public class NewLocationWizardPage1 extends WizardPage {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");
	private final IEclipseContext context;
	private NewLocationWizard wizard;

	private List<List<String>> styleList;

	/**
	 * Constructor
	 *
	 * @param context The Eclipse Context
	 *
	 */
	public NewLocationWizardPage1(IEclipseContext context) {
		super("wizardPage");
		this.context = context;
		setTitle("Location Name");
		setDescription(
				"Add the name style, optionally time limitations for the name "
						+ "of the location, and a preposition for reporting use.\r\n\r\n");
	}

	/**
	 * @param textFromDate
	 */
	private void browseFromDate(final Text textFromDate) {
		final DateNavigatorDialog dialog = new DateNavigatorDialog(
				textFromDate.getShell(), context);
		if (dialog.open() == Window.OK) {
			try {
				final int hdatePid = dialog.getHdatePid();
				final HDateProvider hdp = new HDateProvider();
				hdp.get(hdatePid);
				wizard = (NewLocationWizard) getWizard();
				wizard.setNameFromDatePid(hdatePid);
				textFromDate.setText(hdp.getDate().toString());
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
			}
		}
	}

	/**
	 * @param textToDate
	 */
	private void browseToDate(final Text textToDate) {
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

		final Label lblLocationNameStyle = new Label(container, SWT.NONE);
		lblLocationNameStyle.setLayoutData(
				new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLocationNameStyle.setText("Location Name Style");

		final ComboViewer comboViewerLocationNameStyles = new ComboViewer(
				container, SWT.NONE);
		final Combo comboLocationNameStyles = comboViewerLocationNameStyles
				.getCombo();
		comboLocationNameStyles.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final int selectionIndex = comboLocationNameStyles
						.getSelectionIndex();
				wizard = (NewLocationWizard) getWizard();
				wizard.setLocationNameStylePid(
						Integer.parseInt(styleList.get(selectionIndex).get(0)));
				setPageComplete(true);
				wizard.addPage2();
				wizard.getContainer().updateButtons();
			}
		});
		comboLocationNameStyles.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboViewerLocationNameStyles
				.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerLocationNameStyles
				.setLabelProvider(new HREComboLabelProvider(2));
		comboLocationNameStyles.setToolTipText("Mandatory");

		try {
			// Populate location name style combo box
			styleList = new LocationNameStyleProvider().getStringList();
			comboViewerLocationNameStyles.setInput(styleList);
			final int llsSize = styleList.size();
			final String g = store.getString("DEFAULTLOCATIONNAMESTYLE");
			int index = 0;

			for (int i = 0; i < llsSize; i++) {
				if (g.equals(styleList.get(i).get(1))) {
					index = i;
				}
			}
			comboLocationNameStyles.select(index);

		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}

		final Composite compositeFrom = new Composite(container, SWT.BORDER);
		compositeFrom.setLayout(new GridLayout(2, false));
		compositeFrom.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

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
				newFromDate(textFromDate);
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
				browseFromDate(textFromDate);
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
				wizard.setNameFromDatePid(0);
				textFromDate.setText("");
			}
		});
		btnClearFrom.setText("Clear");

		final Composite compositeTo = new Composite(container, SWT.BORDER);
		compositeTo.setLayout(new GridLayout(2, false));
		compositeTo.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

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
				wizard.setNameFromDatePid(wizard.getToDatePid());
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
				newToDate(textToDate);
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
				browseToDate(textToDate);
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
				wizard.setNameToDatePid(0);
				textToDate.setText("");
			}
		});
		btnClearTo.setText("Clear");

		new Label(container, SWT.NONE);

		final Button btnPrimaryLocationName = new Button(container, SWT.CHECK);
		btnPrimaryLocationName.setSelection(true);
		btnPrimaryLocationName.setText("Primary Location Name");
		btnPrimaryLocationName.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
			}

			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.FocusListener#focusLost(org.eclipse.swt.
			 * events.FocusEvent)
			 */
			@Override
			public void focusLost(org.eclipse.swt.events.FocusEvent e) {
				wizard = (NewLocationWizard) getWizard();
				wizard.setIsPrimaryLocationName(
						btnPrimaryLocationName.getSelection());
			}

		});

		final Label lblPreposition = new Label(container, SWT.NONE);
		lblPreposition.setText("Preposition");

		final Text textPreposition = new Text(container, SWT.BORDER);
		textPreposition.setToolTipText("Optional. Used for reporting");
		textPreposition.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textPreposition.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				wizard = (NewLocationWizard) getWizard();
				wizard.setPreposition(textPreposition.getText());
			}
		});

		setPageComplete(false);
	}

	/**
	 * @param textFromDate
	 */
	private void newFromDate(final Text textFromDate) {
		final DateDialog dialog = new DateDialog(textFromDate.getShell(),
				context);
		if (dialog.open() == Window.OK) {
			try {
				final HDateProvider hdp = new HDateProvider();
				hdp.setDate(dialog.getDate());
				hdp.setSortDate(dialog.getSortDate());
				hdp.setOriginalText(dialog.getOriginal());
				hdp.setSurety(dialog.getSurety());
				wizard = (NewLocationWizard) getWizard();
				wizard.setNameFromDatePid(hdp.insert());
				textFromDate.setText(dialog.getDate().toString());
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
			}
		}
	}

	/**
	 * @param textToDate
	 */
	private void newToDate(final Text textToDate) {
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
				wizard.setNameToDatePid(hdp.insert());
				textToDate.setText(dialog.getDate().toString());
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
			}
		}
	}

//	/**
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public String getComboLocationNameStyle() {
//		IStructuredSelection structuredSelection = comboViewerLocationNameStyles
//				.getStructuredSelection();
//		List<String> ls = (List<String>) structuredSelection.getFirstElement();
//		return ls.get(0);
//	}

}