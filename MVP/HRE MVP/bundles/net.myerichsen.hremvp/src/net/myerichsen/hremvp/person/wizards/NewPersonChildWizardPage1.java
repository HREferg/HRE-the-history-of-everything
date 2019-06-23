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
import net.myerichsen.hremvp.project.providers.ChildRoleProvider;
import net.myerichsen.hremvp.providers.HDateProvider;
import net.myerichsen.hremvp.providers.HREComboLabelProvider;

/**
 * Person child wizard page
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 * @version 9. jun. 2019
 *
 */
public class NewPersonChildWizardPage1 extends WizardPage {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;
	private final IEventBroker eventBroker;

	private Shell parentShell;

	private Text textChildPersonPid;
	private Text textChildName;
	private Text textChildBirthDate;
	private Text textChildDeathDate;

	private int childPid = 0;

//	private static final String childRole = "";
	private List<List<String>> childStringList;
	private int childRolePid;

	/**
	 * Constructor
	 *
	 * @param context
	 */
	public NewPersonChildWizardPage1(IEclipseContext context) {
		super("New Person Child Wizard Page 1");
		setTitle("Child");
		setDescription("Add a child to the person.");
		this.context = context;
		eventBroker = context.get(IEventBroker.class);
	}

	/**
	 *
	 */
	protected void browseChild() {
		final PersonNavigatorDialog dialog = new PersonNavigatorDialog(
				parentShell, context);
		if (dialog.open() == Window.OK) {
			try {
				childPid = dialog.getPersonPid();
				textChildPersonPid.setText(Integer.toString(childPid));
				textChildName.setText(dialog.getPersonName());
				textChildBirthDate.setText(dialog.getBirthDate());
				textChildDeathDate.setText(dialog.getDeathDate());
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
				eventBroker.post("MESSAGE", e.getMessage());
			}
		}
	}

	/**
	 *
	 */
	protected void clearChild() {
		childPid = 0;
		textChildPersonPid.setText("");
		textChildName.setText("");
		textChildBirthDate.setText("");
		textChildDeathDate.setText("");
	}

	@Override
	public void createControl(Composite parent) {
		parentShell = parent.getShell();
		final Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(3, false));

		final Label lblChild = new Label(container, SWT.NONE);
		lblChild.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblChild.setText("Child");

		textChildPersonPid = new Text(container, SWT.BORDER);
		textChildPersonPid.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Composite compositeChild = new Composite(container, SWT.NONE);
		compositeChild.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnUpdateChild = new Button(compositeChild, SWT.NONE);
		btnUpdateChild.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				updateChild();
			}
		});
		btnUpdateChild.setText("Update");

		final Button btnBrowseChild = new Button(compositeChild, SWT.NONE);
		btnBrowseChild.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				browseChild();
			}
		});
		btnBrowseChild.setText("Browse");

		final Button btnClearChild = new Button(compositeChild, SWT.NONE);
		btnClearChild.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				clearChild();
			}
		});
		btnClearChild.setText("Clear");

		textChildName = new Text(container, SWT.BORDER);
		textChildName.setEditable(false);
		textChildName.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		textChildBirthDate = new Text(container, SWT.BORDER);
		textChildBirthDate.setEditable(false);
		textChildBirthDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		textChildDeathDate = new Text(container, SWT.BORDER);
		textChildDeathDate.setEditable(false);
		textChildDeathDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		final Label lblChildRole = new Label(container, SWT.NONE);
		lblChildRole.setText("Child role");

		final ComboViewer comboViewerChildRole = new ComboViewer(container,
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
				childRolePid = Integer
						.parseInt(childStringList.get(selectionIndex).get(0));
			}
		});
		comboViewerChildRole
				.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerChildRole.setLabelProvider(new HREComboLabelProvider(3));

		try {
			childStringList = new ChildRoleProvider().getStringList();
			comboViewerChildRole.setInput(childStringList);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
			setErrorMessage(e1.getMessage());
		}
		comboChildRole.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

	}

	/**
	 * @return the childPid
	 */
	public int getChildPid() {
		return childPid;
	}

//	/**
//	 * @return the childRole
//	 */
//	public String getChildRole() {
//		return childRole;
//	}

	/**
	 * @return the childRolePid
	 */
	public int getChildRolePid() {
		return childRolePid;
	}

	/**
	 * @param childRolePid the childRolePid to set
	 */
	public void setChildRolePid(int childRolePid) {
		this.childRolePid = childRolePid;
	}

	/**
	 *
	 */
	protected void updateChild() {
		childPid = Integer.parseInt(textChildPersonPid.getText());
		PersonProvider provider;

		try {
			final HDateProvider dateProvider = new HDateProvider();
			provider = new PersonProvider();
			provider.get(childPid);
			textChildName.setText(provider.getPrimaryName());
			final int birthDatePid = provider.getBirthDatePid();
			if (birthDatePid > 0) {
				dateProvider.get(birthDatePid);
				textChildBirthDate.setText(dateProvider.getDate().toString());
			} else {
				textChildBirthDate.setText("");
			}
			final int deathDatePid = provider.getDeathDatePid();
			if (deathDatePid > 0) {
				dateProvider.get(deathDatePid);
				textChildDeathDate.setText(dateProvider.getDate().toString());
			} else {
				textChildDeathDate.setText("");
			}
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			eventBroker.post("MESSAGE", e.getMessage());
		}
	}
}
