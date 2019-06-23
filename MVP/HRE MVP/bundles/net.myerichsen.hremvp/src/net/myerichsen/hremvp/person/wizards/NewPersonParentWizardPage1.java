package net.myerichsen.hremvp.person.wizards;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
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

import net.myerichsen.hremvp.person.dialogs.PersonNavigatorDialog;
import net.myerichsen.hremvp.person.providers.PersonProvider;
import net.myerichsen.hremvp.project.providers.ParentRoleProvider;
import net.myerichsen.hremvp.providers.HDateProvider;
import net.myerichsen.hremvp.providers.HREComboLabelProvider;

/**
 * Person parent wizard page
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 * @version 8. jun. 2019
 *
 */
public class NewPersonParentWizardPage1 extends WizardPage {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;
	private final IEventBroker eventBroker;

	private Shell parentShell;

	private Text textParentPersonPid;
	private Text textParentName;
	private Text textParentBirthDate;
	private Text textParentDeathDate;

	private int parentPid = 0;

	private static final String parentRole = "";
	private List<List<String>> parentStringList;
	private int parentRolePid;

	/**
	 * Constructor
	 *
	 * @param context
	 */
	public NewPersonParentWizardPage1(IEclipseContext context) {
		super("New Person Parent Wizard Page 1");
		setTitle("Parent");
		setDescription("Add a parent to the person.");
		this.context = context;
		eventBroker = context.get(IEventBroker.class);
	}

	/**
	 *
	 */
	protected void browseParent() {
		final PersonNavigatorDialog dialog = new PersonNavigatorDialog(
				parentShell, context);
		if (dialog.open() == Window.OK) {
			try {
				parentPid = dialog.getPersonPid();
				textParentPersonPid.setText(Integer.toString(parentPid));
				textParentName.setText(dialog.getPersonName());
				textParentBirthDate.setText(dialog.getBirthDate());
				textParentDeathDate.setText(dialog.getDeathDate());
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
				eventBroker.post("MESSAGE", e.getMessage());
			}
		}
	}

	/**
	 *
	 */
	protected void clearParent() {
		parentPid = 0;
		textParentPersonPid.setText("");
		textParentName.setText("");
		textParentBirthDate.setText("");
		textParentDeathDate.setText("");
	}

	@Override
	public void createControl(Composite parent) {
		parentShell = parent.getShell();
		final Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(3, false));

		final Label lblParent = new Label(container, SWT.NONE);
		lblParent.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblParent.setText("Parent");

		textParentPersonPid = new Text(container, SWT.BORDER);
		textParentPersonPid.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Composite compositeParent = new Composite(container, SWT.NONE);
		compositeParent.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnUpdateParent = new Button(compositeParent, SWT.NONE);
		btnUpdateParent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				updateParent();
			}
		});
		btnUpdateParent.setText("Update");

		final Button btnBrowseParent = new Button(compositeParent, SWT.NONE);
		btnBrowseParent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				browseParent();
			}
		});
		btnBrowseParent.setText("Browse");

		final Button btnClearParent = new Button(compositeParent, SWT.NONE);
		btnClearParent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				clearParent();
			}
		});
		btnClearParent.setText("Clear");

		textParentName = new Text(container, SWT.BORDER);
		textParentName.setEditable(false);
		textParentName.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		textParentBirthDate = new Text(container, SWT.BORDER);
		textParentBirthDate.setEditable(false);
		textParentBirthDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		textParentDeathDate = new Text(container, SWT.BORDER);
		textParentDeathDate.setEditable(false);
		textParentDeathDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		final Label lblParentRole = new Label(container, SWT.NONE);
		lblParentRole.setText("Parent role");

		final ComboViewer comboViewerParentRole = new ComboViewer(container,
				SWT.NONE);
		final Combo comboParentRole = comboViewerParentRole.getCombo();
		comboParentRole.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final int selectionIndex = comboParentRole.getSelectionIndex();
				parentRolePid = Integer
						.parseInt(parentStringList.get(selectionIndex).get(0));
			}
		});
		comboViewerParentRole
				.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerParentRole.setLabelProvider(new HREComboLabelProvider(3));

		try {
			parentStringList = new ParentRoleProvider().getStringList();
			comboViewerParentRole.setInput(parentStringList);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
			setErrorMessage(e1.getMessage());
		}
		comboParentRole.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

	}

	/**
	 * @return the parentPid
	 */
	public int getParentPid() {
		return parentPid;
	}

	/**
	 * @return the parentRole
	 */
	public String getParentRole() {
		return parentRole;
	}

	/**
	 * @return the parentRolePid
	 */
	public int getParentRolePid() {
		return parentRolePid;
	}

	/**
	 * @param parentRolePid the parentRolePid to set
	 */
	public void setParentRolePid(int parentRolePid) {
		this.parentRolePid = parentRolePid;
	}

	/**
	 *
	 */
	protected void updateParent() {
		parentPid = Integer.parseInt(textParentPersonPid.getText());
		PersonProvider provider;

		try {
			final HDateProvider dateProvider = new HDateProvider();
			provider = new PersonProvider();
			provider.get(parentPid);
			textParentName.setText(provider.getPrimaryName());
			final int birthDatePid = provider.getBirthDatePid();
			if (birthDatePid > 0) {
				dateProvider.get(birthDatePid);
				textParentBirthDate.setText(dateProvider.getDate().toString());
			} else {
				textParentBirthDate.setText("");
			}
			final int deathDatePid = provider.getDeathDatePid();
			if (deathDatePid > 0) {
				dateProvider.get(deathDatePid);
				textParentDeathDate.setText(dateProvider.getDate().toString());
			} else {
				textParentDeathDate.setText("");
			}
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			eventBroker.post("MESSAGE", e.getMessage());
		}
	}
}
