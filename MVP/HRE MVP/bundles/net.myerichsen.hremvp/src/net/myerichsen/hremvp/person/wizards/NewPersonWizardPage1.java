package net.myerichsen.hremvp.person.wizards;

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
import net.myerichsen.hremvp.project.providers.SexTypeProvider;
import net.myerichsen.hremvp.providers.HDateProvider;
import net.myerichsen.hremvp.providers.HREComboLabelProvider;

/**
 * Person static data wizard page
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 7. apr. 2019
 *
 */
public class NewPersonWizardPage1 extends WizardPage {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;
	private NewPersonWizard wizard;

	private Text textBirthDate;
	private Text textDeathDate;

	private List<List<String>> stringList;

	/**
	 * Constructor
	 *
	 * @param context
	 *
	 */
	public NewPersonWizardPage1(IEclipseContext context) {
		super("wizardPage");
		setTitle("New Person");
		setDescription(
				"Create a new person by entering static data for it. Dates are optional, but sex is mandatory.");
		this.context = context;
	}

	/**
	 *
	 */
	private void browseBirthDates() {
		final DateNavigatorDialog dialog = new DateNavigatorDialog(
				textBirthDate.getShell(), context);
		if (dialog.open() == Window.OK) {
			try {
				final int hdatePid = dialog.getHdatePid();
				final HDateProvider hdp = new HDateProvider();
				hdp.get(hdatePid);
				textBirthDate.setText(hdp.getDate().toString());
				wizard = (NewPersonWizard) getWizard();
				wizard.setBirthDatePid(hdatePid);
				setErrorMessage(null);
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
				setErrorMessage(e1.getMessage());
			}
		}
	}

	/**
	 *
	 */
	private void browseDeathDates() {
		final DateNavigatorDialog dialog = new DateNavigatorDialog(
				textDeathDate.getShell(), context);
		if (dialog.open() == Window.OK) {
			try {
				final int hdatePid = dialog.getHdatePid();
				final HDateProvider hdp = new HDateProvider();
				hdp.get(hdatePid);
				textDeathDate.setText(hdp.getDate().toString());
				wizard = (NewPersonWizard) getWizard();
				wizard.setDeathDatePid(hdatePid);
				setErrorMessage(null);
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
				setErrorMessage(e1.getMessage());
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

		final Label lblSex = new Label(container, SWT.NONE);
		lblSex.setText("Sex");

		final ComboViewer comboViewerSex = new ComboViewer(container, SWT.NONE);
		final Combo comboSex = comboViewerSex.getCombo();
		comboSex.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final int selectionIndex = comboSex.getSelectionIndex();
				wizard = (NewPersonWizard) getWizard();
				wizard.setSexTypePid(Integer
						.parseInt(stringList.get(selectionIndex).get(0)));
				setPageComplete(true);
			}
		});
		comboViewerSex.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerSex.setLabelProvider(new HREComboLabelProvider(2));
		comboSex.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		try {
			stringList = new SexTypeProvider().getStringList();
			comboViewerSex.setInput(stringList);
			setErrorMessage(null);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
			setErrorMessage(e1.getMessage());
		}

		final Composite compositeBirthDate = new Composite(container,
				SWT.BORDER);
		compositeBirthDate.setLayout(new GridLayout(2, false));
		compositeBirthDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		final Label lblBirthDate = new Label(compositeBirthDate, SWT.NONE);
		lblBirthDate.setText("Birth Date");

		textBirthDate = new Text(compositeBirthDate, SWT.BORDER);
		textBirthDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textBirthDate.setEditable(false);

		final Composite compositeBirthButtons = new Composite(
				compositeBirthDate, SWT.NONE);
		compositeBirthButtons.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		compositeBirthButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnNewBirth = new Button(compositeBirthButtons, SWT.NONE);
		btnNewBirth.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				getNewBirthDate();
			}
		});
		btnNewBirth.setText("New");

		final Button btnBrowseBirth = new Button(compositeBirthButtons,
				SWT.NONE);
		btnBrowseBirth.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				browseBirthDates();
			}
		});
		btnBrowseBirth.setText("Browse");

		final Button btnClearBirth = new Button(compositeBirthButtons,
				SWT.NONE);
		btnClearBirth.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				textBirthDate.setText("");
			}
		});
		btnClearBirth.setText("Clear");

		final Composite compositeDeathDate = new Composite(container,
				SWT.BORDER);
		compositeDeathDate.setLayout(new GridLayout(2, false));
		compositeDeathDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		final Label lblDeathDate = new Label(compositeDeathDate, SWT.NONE);
		lblDeathDate.setText("Death Date");

		textDeathDate = new Text(compositeDeathDate, SWT.BORDER);
		textDeathDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textDeathDate.setEditable(false);

		final Composite compositeDeathButtons = new Composite(
				compositeDeathDate, SWT.NONE);
		compositeDeathButtons.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		compositeDeathButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnNewDeath = new Button(compositeDeathButtons, SWT.NONE);
		btnNewDeath.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				getNewDeathDate();
			}
		});
		btnNewDeath.setText("New");

		final Button btnBrowseDeath = new Button(compositeDeathButtons,
				SWT.NONE);
		btnBrowseDeath.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				browseDeathDates();
			}
		});
		btnBrowseDeath.setText("Browse");

		final Button btnClearDeath = new Button(compositeDeathButtons,
				SWT.NONE);
		btnClearDeath.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				textDeathDate.setText("");
			}
		});
		btnClearDeath.setText("Clear");

		setPageComplete(false);
	}

	/**
	 *
	 */
	private void getNewBirthDate() {
		final DateDialog dialog = new DateDialog(textBirthDate.getShell(),
				context);
		if (dialog.open() == Window.OK) {
			try {
				final HDateProvider hdp = new HDateProvider();
				hdp.setDate(dialog.getDate());
				hdp.setSortDate(dialog.getSortDate());
				hdp.setOriginalText(dialog.getOriginal());
				hdp.setSurety(dialog.getSurety());
				wizard = (NewPersonWizard) getWizard();
				wizard.setBirthDatePid(hdp.insert());
				textBirthDate.setText(dialog.getDate().toString());
				setErrorMessage(null);
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
				setErrorMessage(e1.getMessage());
			}
		}
	}

	/**
	 *
	 */
	private void getNewDeathDate() {
		final DateDialog dialog = new DateDialog(textDeathDate.getShell(),
				context);
		if (dialog.open() == Window.OK) {
			try {
				final HDateProvider hdp = new HDateProvider();
				hdp.setDate(dialog.getDate());
				hdp.setSortDate(dialog.getSortDate());
				hdp.setOriginalText(dialog.getOriginal());
				hdp.setSurety(dialog.getSurety());
				wizard = (NewPersonWizard) getWizard();
				wizard.setDeathDatePid(hdp.insert());
				textDeathDate.setText(dialog.getDate().toString());
				setErrorMessage(null);
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
				setErrorMessage(e1.getMessage());
			}
		}
	}

}
