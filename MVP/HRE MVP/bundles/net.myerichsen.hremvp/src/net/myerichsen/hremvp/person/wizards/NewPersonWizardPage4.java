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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import net.myerichsen.hremvp.dialogs.DateDialog;
import net.myerichsen.hremvp.dialogs.DateNavigatorDialog;
import net.myerichsen.hremvp.person.dialogs.PersonNavigatorDialog;
import net.myerichsen.hremvp.person.providers.PersonProvider;
import net.myerichsen.hremvp.project.providers.ParentRoleProvider;
import net.myerichsen.hremvp.project.providers.PartnerRoleProvider;
import net.myerichsen.hremvp.providers.HDateProvider;
import net.myerichsen.hremvp.providers.HREComboLabelProvider;

/**
 * Person parents, partner and child wizard page
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 * @version 31. mar. 2019
 *
 */
public class NewPersonWizardPage4 extends WizardPage {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;
	private NewPersonWizard wizard;

	private Shell parentShell;

	private Text textFatherPersonPid;
	private Text textFatherName;
	private Text textFatherBirthDate;
	private Text textFatherDeathDate;

	private Text textMotherPersonPid;
	private Text textMotherName;
	private Text textMotherBirthDate;
	private Text textMotherDeathDate;

	private Text textChildPersonPid;
	private Text textChildName;
	private Text textChildBirthDate;
	private Text textChildDeathDate;

	private Text textPartnerPersonPid;
	private Text textPartnerName;
	private Text textPartnerBirthDate;
	private Text textPartnerDeathDate;
	private Text textPartnershipStartDate;
	private Text textPartnershipEndDate;

	private List<List<String>> fatherStringList;
	private List<List<String>> motherStringList;
	private List<List<String>> childStringList;
	private List<List<String>> partnerStringList;

	/**
	 * Constructor
	 *
	 * @param context
	 */
	public NewPersonWizardPage4(IEclipseContext context) {
		super("New Person Wizard Page 4");
		setTitle("Person Primary Parents and Partner");
		setDescription(
				"Add primary parents, partner and child for the new person. More parents and partners can be added later.");
		this.context = context;
	}

	/**
	 *
	 */
	protected void browseChild() {
		final PersonNavigatorDialog dialog = new PersonNavigatorDialog(
				parentShell, context);
		if (dialog.open() == Window.OK) {
			try {
				final int childPid = dialog.getPersonPid();
				textChildPersonPid.setText(Integer.toString(childPid));
				textChildName.setText(dialog.getPersonName());
				textChildBirthDate.setText(dialog.getBirthDate());
				textChildDeathDate.setText(dialog.getDeathDate());
				wizard = (NewPersonWizard) getWizard();
				wizard.setChildPid(childPid);
				setErrorMessage(null);
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
				setErrorMessage(e.getMessage());
			}
		}
	}

	/**
	 *
	 */
	protected void browseFather() {
		final PersonNavigatorDialog dialog = new PersonNavigatorDialog(
				parentShell, context);
		if (dialog.open() == Window.OK) {
			try {
				final int fatherPid = dialog.getPersonPid();
				textFatherPersonPid.setText(Integer.toString(fatherPid));
				textFatherName.setText(dialog.getPersonName());
				textFatherBirthDate.setText(dialog.getBirthDate());
				textFatherDeathDate.setText(dialog.getDeathDate());
				wizard = (NewPersonWizard) getWizard();
				wizard.setFatherPid(fatherPid);
				setErrorMessage(null);
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
				setErrorMessage(e.getMessage());
			}
		}
	}

	/**
	 *
	 */
	protected void browseMother() {
		final PersonNavigatorDialog dialog = new PersonNavigatorDialog(
				parentShell, context);
		if (dialog.open() == Window.OK) {
			try {
				final int motherPid = dialog.getPersonPid();
				textMotherPersonPid.setText(Integer.toString(motherPid));
				textMotherName.setText(dialog.getPersonName());
				textMotherBirthDate.setText(dialog.getBirthDate());
				textMotherDeathDate.setText(dialog.getDeathDate());
				wizard = (NewPersonWizard) getWizard();
				wizard.setMotherPid(motherPid);
				setErrorMessage(null);
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
				setErrorMessage(e.getMessage());
			}
		}
	}

	/**
	 *
	 */
	protected void browsePartner() {
		final PersonNavigatorDialog dialog = new PersonNavigatorDialog(
				parentShell, context);
		if (dialog.open() == Window.OK) {
			try {
				final int partnerPid = dialog.getPersonPid();
				textPartnerPersonPid.setText(Integer.toString(partnerPid));
				textPartnerName.setText(dialog.getPersonName());
				textPartnerBirthDate.setText(dialog.getBirthDate());
				textPartnerDeathDate.setText(dialog.getDeathDate());
				wizard = (NewPersonWizard) getWizard();
				wizard.setPartnerPid(partnerPid);
				setErrorMessage(null);
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
				setErrorMessage(e.getMessage());
			}
		}
	}

	/**
	 *
	 */
	protected void browsePartnerEnd() {
		final DateNavigatorDialog dialog = new DateNavigatorDialog(
				textPartnershipEndDate.getShell(), context);
		if (dialog.open() == Window.OK) {
			try {
				final int partnerToDatePid = dialog.getHdatePid();
				final HDateProvider hdp = new HDateProvider();
				hdp.get(partnerToDatePid);
				textPartnershipEndDate.setText(hdp.getDate().toString());
				wizard = (NewPersonWizard) getWizard();
				wizard.setPartnerToDatePid(partnerToDatePid);
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
	protected void browsePartnerStart() {
		final DateNavigatorDialog dialog = new DateNavigatorDialog(
				textPartnershipStartDate.getShell(), context);
		if (dialog.open() == Window.OK) {
			try {
				final int partnerFromDatePid = dialog.getHdatePid();
				final HDateProvider hdp = new HDateProvider();
				hdp.get(partnerFromDatePid);
				textPartnershipStartDate.setText(hdp.getDate().toString());
				wizard = (NewPersonWizard) getWizard();
				wizard.setPartnerFromDatePid(partnerFromDatePid);
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
	protected void clearChild() {
		wizard = (NewPersonWizard) getWizard();
		wizard.setChildPid(0);
		textChildPersonPid.setText("");
		textChildName.setText("");
		textChildBirthDate.setText("");
		textChildDeathDate.setText("");
		setErrorMessage(null);
	}

	/**
	 *
	 */
	protected void clearFather() {
		wizard = (NewPersonWizard) getWizard();
		wizard.setFatherPid(0);
		textFatherPersonPid.setText("");
		textFatherName.setText("");
		textFatherBirthDate.setText("");
		textFatherDeathDate.setText("");
		setErrorMessage(null);
	}

	/**
	 *
	 */
	protected void clearMother() {
		wizard = (NewPersonWizard) getWizard();
		wizard.setMotherPid(0);
		textMotherPersonPid.setText("");
		textMotherName.setText("");
		textMotherBirthDate.setText("");
		textMotherDeathDate.setText("");
		setErrorMessage(null);
	}

	/**
	 *
	 */
	protected void clearPartner() {
		wizard = (NewPersonWizard) getWizard();
		wizard.setPartnerPid(0);
		textPartnerPersonPid.setText("");
		textPartnerName.setText("");
		textPartnerBirthDate.setText("");
		textPartnerDeathDate.setText("");
		setErrorMessage(null);
	}

	/**
	 *
	 */
	protected void clearPartnerEnd() {
		wizard = (NewPersonWizard) getWizard();
		wizard.setPartnerToDatePid(0);
		textPartnershipEndDate.setText("");
		setErrorMessage(null);
	}

	/**
	 *
	 */
	protected void clearPartnerStart() {
		textPartnershipStartDate.setText("");
		wizard = (NewPersonWizard) getWizard();
		wizard.setPartnerFromDatePid(0);
		setErrorMessage(null);
	}

	@Override
	public void createControl(Composite parent) {
		parentShell = parent.getShell();
		final Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(1, false));

		final Composite compositeFather = new Composite(container, SWT.BORDER);
		compositeFather.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		compositeFather.setLayout(new GridLayout(3, false));

		final Label lblFather = new Label(compositeFather, SWT.NONE);
		lblFather.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblFather.setText("Father");

		textFatherPersonPid = new Text(compositeFather, SWT.BORDER);
		textFatherPersonPid.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		final Composite compositeFatherButtons = new Composite(compositeFather,
				SWT.NONE);
		compositeFatherButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnUpdateFather = new Button(compositeFatherButtons,
				SWT.NONE);
		btnUpdateFather.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				updateFather();
			}
		});
		btnUpdateFather.setText("Update");

		final Button btnBrowseFather = new Button(compositeFatherButtons,
				SWT.NONE);
		btnBrowseFather.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				browseFather();
			}
		});
		btnBrowseFather.setText("Browse");

		final Button btnClearFather = new Button(compositeFatherButtons,
				SWT.NONE);
		btnClearFather.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				clearFather();
			}
		});
		btnClearFather.setText("Clear");

		textFatherName = new Text(compositeFather, SWT.BORDER);
		textFatherName.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textFatherName.setEditable(false);

		textFatherBirthDate = new Text(compositeFather, SWT.BORDER);
		textFatherBirthDate.setEditable(false);

		textFatherDeathDate = new Text(compositeFather, SWT.BORDER);
		textFatherDeathDate.setEditable(false);

		final Label lblFatherRole = new Label(compositeFather, SWT.NONE);
		lblFatherRole.setText("Father role");

		final ComboViewer comboViewerFatherRole = new ComboViewer(
				compositeFather, SWT.NONE);
		final Combo comboFatherRole = comboViewerFatherRole.getCombo();
		comboFatherRole.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final int selectionIndex = comboFatherRole.getSelectionIndex();
				wizard = (NewPersonWizard) getWizard();
				wizard.setFatherRolePid(Integer
						.parseInt(fatherStringList.get(selectionIndex).get(0)));
			}
		});
		comboViewerFatherRole
				.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerFatherRole.setLabelProvider(new HREComboLabelProvider(3));
		comboFatherRole.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		try {
			fatherStringList = new ParentRoleProvider().getStringList();
			comboViewerFatherRole.setInput(fatherStringList);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
			setErrorMessage(e1.getMessage());
		}

		final Composite compositeMother = new Composite(container, SWT.NONE);
		compositeMother.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		compositeMother.setLayout(new GridLayout(3, false));

		final Label lblMother = new Label(compositeMother, SWT.NONE);
		lblMother.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblMother.setText("Mother");

		textMotherPersonPid = new Text(compositeMother, SWT.BORDER);
		textMotherPersonPid.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		final Composite compositeMotherButtons = new Composite(compositeMother,
				SWT.NONE);
		compositeMotherButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnUpdateMother = new Button(compositeMotherButtons,
				SWT.NONE);
		btnUpdateMother.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				updateMother();
			}
		});
		btnUpdateMother.setText("Update");

		final Button btnBrowseMother = new Button(compositeMotherButtons,
				SWT.NONE);
		btnBrowseMother.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				browseMother();
			}
		});
		btnBrowseMother.setText("Browse");

		final Button btnClearMother = new Button(compositeMotherButtons,
				SWT.NONE);
		btnClearMother.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				clearMother();
			}
		});
		btnClearMother.setText("Clear");

		textMotherName = new Text(compositeMother, SWT.BORDER);
		textMotherName.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textMotherName.setEditable(false);

		textMotherBirthDate = new Text(compositeMother, SWT.BORDER);
		textMotherBirthDate.setEditable(false);

		textMotherDeathDate = new Text(compositeMother, SWT.BORDER);
		textMotherDeathDate.setEditable(false);

		final Label lblMotherRole = new Label(compositeMother, SWT.NONE);
		lblMotherRole.setText("Mother role");

		final ComboViewer comboViewerMotherRole = new ComboViewer(
				compositeMother, SWT.NONE);
		final Combo comboMotherRole = comboViewerMotherRole.getCombo();
		comboMotherRole.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final int selectionIndex = comboMotherRole.getSelectionIndex();
				wizard = (NewPersonWizard) getWizard();
				wizard.setMotherRolePid(Integer
						.parseInt(motherStringList.get(selectionIndex).get(0)));
			}
		});
		comboViewerMotherRole
				.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerMotherRole.setLabelProvider(new HREComboLabelProvider(3));

		try {
			motherStringList = new ParentRoleProvider().getStringList();
			comboViewerMotherRole.setInput(motherStringList);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
			setErrorMessage(e1.getMessage());
		}
		comboMotherRole.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		final Composite compositeChild = new Composite(container, SWT.NONE);
		compositeChild.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		compositeChild.setLayout(new GridLayout(3, false));

		final Label lblChild = new Label(compositeChild, SWT.NONE);
		lblChild.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblChild.setText("Child");

		textChildPersonPid = new Text(compositeChild, SWT.BORDER);
		textChildPersonPid.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		final Composite compositeChildButtons = new Composite(compositeChild,
				SWT.NONE);
		compositeChildButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnUpdateChild = new Button(compositeChildButtons,
				SWT.NONE);
		btnUpdateChild.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				updateChild();
			}
		});
		btnUpdateChild.setText("Update");

		final Button btnBrowseChild = new Button(compositeChildButtons,
				SWT.NONE);
		btnBrowseChild.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				browseChild();
			}
		});
		btnBrowseChild.setText("Browse");

		final Button btnClearChild = new Button(compositeChildButtons,
				SWT.NONE);
		btnClearChild.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				clearChild();
			}
		});
		btnClearChild.setText("Clear");

		textChildName = new Text(compositeChild, SWT.BORDER);
		textChildName.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textChildName.setEditable(false);

		textChildBirthDate = new Text(compositeChild, SWT.BORDER);
		textChildBirthDate.setEditable(false);

		textChildDeathDate = new Text(compositeChild, SWT.BORDER);
		textChildDeathDate.setEditable(false);

		final Label lblChildRole = new Label(compositeChild, SWT.NONE);
		lblChildRole.setText("Child role");

		final ComboViewer comboViewerChildRole = new ComboViewer(compositeChild,
				SWT.NONE);
		final Combo comboChildRole = comboViewerChildRole.getCombo();
		comboChildRole.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final int selectionIndex = comboChildRole.getSelectionIndex();
				wizard = (NewPersonWizard) getWizard();
				wizard.setChildRolePid(Integer
						.parseInt(childStringList.get(selectionIndex).get(0)));
			}
		});
		comboViewerChildRole
				.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerChildRole.setLabelProvider(new HREComboLabelProvider(3));

		try {
			childStringList = new ParentRoleProvider().getStringList();
			comboViewerChildRole.setInput(childStringList);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
			setErrorMessage(e1.getMessage());
		}
		comboChildRole.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		final Composite compositePartner = new Composite(container, SWT.BORDER);
		compositePartner.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		compositePartner.setLayout(new GridLayout(3, false));

		final Label lblPartner = new Label(compositePartner, SWT.NONE);
		lblPartner
				.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblPartner.setText("Partner");

		textPartnerPersonPid = new Text(compositePartner, SWT.BORDER);

		final Composite compositePartnerStartButtons = new Composite(
				compositePartner, SWT.NONE);
		compositePartnerStartButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnUpdatePartnerStart = new Button(
				compositePartnerStartButtons, SWT.NONE);
		btnUpdatePartnerStart.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				updatePartner();
			}
		});
		btnUpdatePartnerStart.setText("Update");

		final Button btnBrowsePartner = new Button(compositePartnerStartButtons,
				SWT.NONE);
		btnBrowsePartner.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				browsePartner();
			}
		});
		btnBrowsePartner.setText("Browse");

		final Button btnClearPartner = new Button(compositePartnerStartButtons,
				SWT.NONE);
		btnClearPartner.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				clearPartner();
			}
		});
		btnClearPartner.setText("Clear");

		textPartnerName = new Text(compositePartner, SWT.BORDER);
		textPartnerName.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textPartnerName.setEditable(false);

		textPartnerBirthDate = new Text(compositePartner, SWT.BORDER);
		textPartnerBirthDate.setEditable(false);

		textPartnerDeathDate = new Text(compositePartner, SWT.BORDER);
		textPartnerDeathDate.setEditable(false);

		final Label lblStartOfPartnership = new Label(compositePartner,
				SWT.NONE);
		lblStartOfPartnership.setText("Start of partnership");

		textPartnershipStartDate = new Text(compositePartner, SWT.BORDER);
		textPartnershipStartDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		textPartnershipStartDate.setEditable(false);

		final Composite compositePartnerStart = new Composite(compositePartner,
				SWT.NONE);
		compositePartnerStart.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button buttonNewPartnerStart = new Button(compositePartnerStart,
				SWT.NONE);
		buttonNewPartnerStart.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				newPartnerStart();
			}
		});
		buttonNewPartnerStart.setText("New");

		final Button buttonBrowsePartnerStart = new Button(
				compositePartnerStart, SWT.NONE);
		buttonBrowsePartnerStart.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				browsePartnerStart();
			}
		});
		buttonBrowsePartnerStart.setText("Browse");

		final Button buttonClearPartnerStart = new Button(compositePartnerStart,
				SWT.NONE);
		buttonClearPartnerStart.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				clearPartnerStart();
			}
		});
		buttonClearPartnerStart.setText("Clear");

		final Label lblEndOfPartnership = new Label(compositePartner, SWT.NONE);
		lblEndOfPartnership.setText("End of partnership");

		textPartnershipEndDate = new Text(compositePartner, SWT.BORDER);
		textPartnershipEndDate.setEditable(false);
		textPartnershipEndDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Composite compositePartnerEndButtons = new Composite(
				compositePartner, SWT.NONE);
		compositePartnerEndButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button buttonNewPartnerEnd = new Button(
				compositePartnerEndButtons, SWT.NONE);
		buttonNewPartnerEnd.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				newPartnerEnd();
			}
		});
		buttonNewPartnerEnd.setText("New");

		final Button buttonBrowsePartnerEnd = new Button(
				compositePartnerEndButtons, SWT.NONE);
		buttonBrowsePartnerEnd.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				browsePartnerEnd();
			}
		});
		buttonBrowsePartnerEnd.setText("Browse");

		final Button buttonClearBrowserEnd = new Button(
				compositePartnerEndButtons, SWT.NONE);
		buttonClearBrowserEnd.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				clearPartnerEnd();
			}
		});
		buttonClearBrowserEnd.setText("Clear");

		final Label lblPartnerRole = new Label(compositePartner, SWT.NONE);
		lblPartnerRole.setText("Partner role");

		final ComboViewer comboViewerPartnerRole = new ComboViewer(
				compositePartner, SWT.NONE);
		final Combo comboPartnerRole = comboViewerPartnerRole.getCombo();
		comboPartnerRole.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final int selectionIndex = comboPartnerRole.getSelectionIndex();
				wizard = (NewPersonWizard) getWizard();
				wizard.setPartnerRolePid(Integer.parseInt(
						partnerStringList.get(selectionIndex).get(0)));
			}
		});
		comboViewerPartnerRole
				.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerPartnerRole.setLabelProvider(new HREComboLabelProvider(3));

		try {
			partnerStringList = new PartnerRoleProvider().getStringList();
			comboViewerPartnerRole.setInput(partnerStringList);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
			setErrorMessage(e1.getMessage());
		}
		comboPartnerRole.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

	}

	/**
	 *
	 */
	protected void newPartnerEnd() {
		final DateDialog dialog = new DateDialog(
				textPartnershipEndDate.getShell(), context);
		if (dialog.open() == Window.OK) {
			try {
				final HDateProvider hdp = new HDateProvider();
				hdp.setDate(dialog.getDate());
				hdp.setSortDate(dialog.getSortDate());
				hdp.setOriginalText(dialog.getOriginal());
				hdp.setSurety(dialog.getSurety());
				wizard = (NewPersonWizard) getWizard();
				wizard.setPartnerToDatePid(hdp.insert());
				textPartnershipEndDate.setText(dialog.getDate().toString());
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
	protected void newPartnerStart() {
		final DateDialog dialog = new DateDialog(
				textPartnershipStartDate.getShell(), context);
		if (dialog.open() == Window.OK) {
			try {
				final HDateProvider hdp = new HDateProvider();
				hdp.setDate(dialog.getDate());
				hdp.setSortDate(dialog.getSortDate());
				hdp.setOriginalText(dialog.getOriginal());
				hdp.setSurety(dialog.getSurety());
				wizard = (NewPersonWizard) getWizard();
				wizard.setPartnerFromDatePid(hdp.insert());
				textPartnershipStartDate.setText(dialog.getDate().toString());
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
	protected void updateChild() {
		final int childPid = Integer.parseInt(textChildPersonPid.getText());
		PersonProvider provider;

		try {
			final HDateProvider dateProvider = new HDateProvider();
			provider = new PersonProvider();
			provider.get(childPid);
			textChildName.setText(provider.getPrimaryName());
			dateProvider.get(provider.getBirthDatePid());
			textChildBirthDate.setText(dateProvider.getDate().toString());
			dateProvider.get(provider.getDeathDatePid());
			textChildDeathDate.setText(dateProvider.getDate().toString());
			wizard = (NewPersonWizard) getWizard();
			wizard.setChildPid(childPid);
			setErrorMessage(null);
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			setErrorMessage(e.getMessage());
		}
	}

	/**
	 *
	 */
	protected void updateFather() {
		final int fatherPid = Integer.parseInt(textFatherPersonPid.getText());
		PersonProvider provider;

		try {
			final HDateProvider dateProvider = new HDateProvider();
			provider = new PersonProvider();
			provider.get(fatherPid);
			textFatherName.setText(provider.getPrimaryName());
			dateProvider.get(provider.getBirthDatePid());
			textFatherBirthDate.setText(dateProvider.getDate().toString());
			dateProvider.get(provider.getDeathDatePid());
			textFatherDeathDate.setText(dateProvider.getDate().toString());
			wizard = (NewPersonWizard) getWizard();
			wizard.setFatherPid(fatherPid);
			setErrorMessage(null);
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			setErrorMessage(e.getMessage());
		}
	}

	/**
	 *
	 */
	protected void updateMother() {
		final int motherPid = Integer.parseInt(textMotherPersonPid.getText());
		PersonProvider provider;

		try {
			final HDateProvider dateProvider = new HDateProvider();
			provider = new PersonProvider();
			provider.get(motherPid);
			textMotherName.setText(provider.getPrimaryName());
			dateProvider.get(provider.getBirthDatePid());
			textMotherBirthDate.setText(dateProvider.getDate().toString());
			dateProvider.get(provider.getDeathDatePid());
			textMotherDeathDate.setText(dateProvider.getDate().toString());
			wizard = (NewPersonWizard) getWizard();
			wizard.setMotherPid(motherPid);
			setErrorMessage(null);
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			setErrorMessage(e.getMessage());
		}
	}

	/**
	 *
	 */
	protected void updatePartner() {
		final int partnerPid = Integer.parseInt(textPartnerPersonPid.getText());
		PersonProvider provider;

		try {
			final HDateProvider dateProvider = new HDateProvider();
			provider = new PersonProvider();
			provider.get(partnerPid);
			textPartnerName.setText(provider.getPrimaryName());
			dateProvider.get(provider.getBirthDatePid());
			textPartnerBirthDate.setText(dateProvider.getDate().toString());
			dateProvider.get(provider.getDeathDatePid());
			textPartnerDeathDate.setText(dateProvider.getDate().toString());
			wizard = (NewPersonWizard) getWizard();
			wizard.setPartnerPid(partnerPid);
			setErrorMessage(null);
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			setErrorMessage(e.getMessage());
		}
	}
}
