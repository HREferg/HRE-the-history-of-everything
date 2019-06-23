package net.myerichsen.hremvp.event.wizards;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
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

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.person.dialogs.PersonNavigatorDialog;
import net.myerichsen.hremvp.person.providers.PersonProvider;
import net.myerichsen.hremvp.person.wizards.NewPersonWizard;
import net.myerichsen.hremvp.project.providers.EventRoleProvider;
import net.myerichsen.hremvp.providers.HREComboLabelProvider;

/**
 * Wizard page to add a person to an event
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 21. apr. 2019
 *
 */
public class NewEventWizardPage3 extends WizardPage {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final IEclipseContext context;
	private NewEventWizard wizard;
	private Text textPerson;
	private List<List<String>> stringList;

	/**
	 * Constructor
	 *
	 * @param context The Eclipse context
	 */
	public NewEventWizardPage3(IEclipseContext context) {
		super("wizardPage");
		setTitle("New Event");
		setDescription(
				"Enter an optional person for the event. More can be added later");
		this.context = context;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.
	 * widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(1, false));

		final Composite compositePerson = new Composite(container, SWT.BORDER);
		final GridData gd_compositePerson = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_compositePerson.widthHint = 559;
		compositePerson.setLayoutData(gd_compositePerson);
		compositePerson.setLayout(new GridLayout(2, false));

		final Label lblPerson = new Label(compositePerson, SWT.NONE);
		lblPerson.setText("Person");

		textPerson = new Text(compositePerson, SWT.BORDER);
		textPerson.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textPerson.setEditable(false);

		final Composite compositePersonButtons = new Composite(compositePerson,
				SWT.NONE);
		compositePersonButtons.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		compositePersonButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnNewPerson = new Button(compositePersonButtons,
				SWT.NONE);
		btnNewPerson.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				final WizardDialog dialog = new WizardDialog(parent.getShell(),
						new NewPersonWizard(context));
				dialog.open();
			}
		});
		btnNewPerson.setText("New");

		final Button btnBrowsePerson = new Button(compositePersonButtons,
				SWT.NONE);
		btnBrowsePerson.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				final PersonNavigatorDialog dialog = new PersonNavigatorDialog(
						getShell(), context);

				if (dialog.open() == Window.OK) {
					final int personPid = dialog.getPersonPid();
					wizard = (NewEventWizard) getWizard();
					wizard.setPersonPid(personPid);
					textPerson.setText(dialog.getPersonName());
					setErrorMessage(null);
				}
			}
		});
		btnBrowsePerson.setText("Browse");

		final Button btnClearPerson = new Button(compositePersonButtons,
				SWT.NONE);
		btnClearPerson.addMouseListener(new MouseAdapter() {
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
				wizard.setPersonPid(0);
				textPerson.setText("");
				setErrorMessage(null);
			}
		});
		btnClearPerson.setText("Clear");

		final Composite compositeRole = new Composite(container, SWT.BORDER);
		compositeRole.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		compositeRole.setLayout(new GridLayout(2, false));

		final Label label = new Label(compositeRole, SWT.NONE);
		label.setText("Event Role");

		final ComboViewer comboViewerRole = new ComboViewer(compositeRole,
				SWT.NONE);
		final Combo comboRole = comboViewerRole.getCombo();
		comboRole.addSelectionListener(new SelectionAdapter() {
			/**
			 * @param e
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				final int selectionIndex = comboRole.getSelectionIndex();
				wizard = (NewEventWizard) getWizard();
				wizard.setEventRolePid(Integer
						.parseInt(stringList.get(selectionIndex).get(0)));
			}
		});
		comboViewerRole.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerRole.setLabelProvider(new HREComboLabelProvider(2));
		comboRole.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Button btnPrimaryperson = new Button(container, SWT.CHECK);
		btnPrimaryperson.addFocusListener(new FocusAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.
			 * events.FocusEvent)
			 */
			@Override
			public void focusLost(FocusEvent e) {
				wizard = (NewEventWizard) getWizard();
				wizard.setPrimaryPerson(btnPrimaryperson.getSelection());
			}
		});
		btnPrimaryperson.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnPrimaryperson.setSelection(true);
		btnPrimaryperson.setText("Primary Person");

		final Button btnPrimaryPersonEvent = new Button(container, SWT.CHECK);
		btnPrimaryPersonEvent.addFocusListener(new FocusAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.
			 * events.FocusEvent)
			 */
			@Override
			public void focusLost(FocusEvent e) {
				wizard = (NewEventWizard) getWizard();
				wizard.setIsPrimaryPersonEvent(
						btnPrimaryPersonEvent.getSelection());
			}
		});
		btnPrimaryPersonEvent.setSelection(true);
		btnPrimaryPersonEvent.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnPrimaryPersonEvent.setText("Primary Event");

		try {
			// A list of lists of event role pids, label pids, abbreviations,
			// generic labels and event type pids
			stringList = new EventRoleProvider().getStringList();
			comboViewerRole.setInput(stringList);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}
	}

	/**
	 * @param personPid
	 */
	@Inject
	@Optional
	private void subscribePersonPidUpdateTopic(
			@UIEventTopic(Constants.PERSON_PID_UPDATE_TOPIC) int personPid) {
		LOGGER.log(Level.FINE, "Received person id {0}", personPid);

		if (personPid > 0) {
			try {
				wizard = (NewEventWizard) getWizard();
				wizard.setPersonPid(personPid);
				final PersonProvider provider = new PersonProvider();
				provider.get(personPid);
				textPerson.setText(provider.getPrimaryName());
			} catch (final Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}
		}
	}
}
