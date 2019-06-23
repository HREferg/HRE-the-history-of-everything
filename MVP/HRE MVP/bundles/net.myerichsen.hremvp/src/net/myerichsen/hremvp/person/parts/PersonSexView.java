package net.myerichsen.hremvp.person.parts;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.window.Window;
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

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.dialogs.DateDialog;
import net.myerichsen.hremvp.dialogs.DateNavigatorDialog;
import net.myerichsen.hremvp.person.providers.SexProvider;
import net.myerichsen.hremvp.person.wizards.NewPersonWizard;
import net.myerichsen.hremvp.project.providers.SexTypeProvider;
import net.myerichsen.hremvp.providers.HDateProvider;
import net.myerichsen.hremvp.providers.HREComboLabelProvider;

/**
 * Display all data for a sex
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 28. apr. 2019
 *
 */
public class PersonSexView {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private IEclipseContext context;

	private Text textId;
	private Text textFromDate;
	private Text textToDate;
	private Button btnPrimarySex;

	private SexProvider provider;
	private int sexPid;
	private int fromDatePid;
	private int toDatePid;
	protected NewPersonWizard wizard;
	private List<List<String>> lls;
	private Combo comboSex;

	/**
	 * Constructor
	 */
	public PersonSexView() {
		provider = new SexProvider();
	}

	/**
	 *
	 */
	private void browseFromDates() {
		final DateNavigatorDialog dialog = new DateNavigatorDialog(
				textFromDate.getShell(), context);
		if (dialog.open() == Window.OK) {
			try {
				fromDatePid = dialog.getHdatePid();
				final HDateProvider hdp = new HDateProvider();
				hdp.get(fromDatePid);
				textFromDate.setText(hdp.getDate().toString());
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
			}
		}
	}

	/**
	 *
	 */
	private void browseToDates() {
		final DateNavigatorDialog dialog = new DateNavigatorDialog(
				textToDate.getShell(), context);
		if (dialog.open() == Window.OK) {
			try {
				toDatePid = dialog.getHdatePid();
				final HDateProvider hdp = new HDateProvider();
				hdp.get(toDatePid);
				textToDate.setText(hdp.getDate().toString());
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
			}
		}
	}

	/**
	 *
	 */
	private void clearFromDate() {
		textFromDate.setText("");
		fromDatePid = 0;
	}

	/**
	 *
	 */
	private void clearToDate() {
		textToDate.setText("");
		toDatePid = 0;
	}

	/**
	 * Create contents of the view part
	 *
	 * @param parent The parent composite
	 */
	@PostConstruct
	public void createControls(Composite parent, IEclipseContext context) {
		this.context = context;
		parent.setLayout(new GridLayout(2, false));

		final Label lblId = new Label(parent, SWT.NONE);
		lblId.setText("Id");

		textId = new Text(parent, SWT.BORDER);
		textId.setEditable(false);
		textId.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Label lblSex = new Label(parent, SWT.NONE);
		lblSex.setText("Sex");

		final ComboViewer comboViewerSex = new ComboViewer(parent, SWT.NONE);
		comboSex = comboViewerSex.getCombo();
		comboViewerSex.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerSex.setLabelProvider(new HREComboLabelProvider(2));
		comboSex.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		try {
			lls = new SexTypeProvider().getStringList();
			comboViewerSex.setInput(lls);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}

		final Composite compositeFrom = new Composite(parent, SWT.BORDER);
		compositeFrom.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		compositeFrom.setLayout(new GridLayout(2, false));

		final Label lblFromDate = new Label(compositeFrom, SWT.NONE);
		lblFromDate.setText("From Date");

		textFromDate = new Text(compositeFrom, SWT.BORDER);
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
			@Override
			public void mouseDown(MouseEvent e) {
				getNewFromDate();
			}
		});
		btnNewFrom.setText("New");

		final Button btnBrowseFrom = new Button(compositeFromButtons, SWT.NONE);
		btnBrowseFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				browseFromDates();
			}
		});
		btnBrowseFrom.setText("Browse");

		final Button btnClearFrom = new Button(compositeFromButtons, SWT.NONE);
		btnClearFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				clearFromDate();
			}
		});
		btnClearFrom.setText("Clear");

		final Composite compositeTo = new Composite(parent, SWT.BORDER);
		compositeTo.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		compositeTo.setLayout(new GridLayout(2, false));

		final Label lblToDate = new Label(compositeTo, SWT.NONE);
		lblToDate.setText("To Date");

		textToDate = new Text(compositeTo, SWT.BORDER);
		textToDate.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textToDate.setEditable(false);

		final Composite compositeToButtons = new Composite(compositeTo,
				SWT.NONE);
		compositeToButtons.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		compositeToButtons.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button btnNewTo = new Button(compositeToButtons, SWT.NONE);
		btnNewTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				getNewToDate();
			}
		});
		btnNewTo.setText("New");

		final Button btnBrowseTo = new Button(compositeToButtons, SWT.NONE);
		btnBrowseTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				browseToDates();
			}
		});
		btnBrowseTo.setText("Browse");

		final Button btnClearTo = new Button(compositeToButtons, SWT.NONE);
		btnClearTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				clearToDate();
			}
		});
		btnClearTo.setText("Clear");

		btnPrimarySex = new Button(parent, SWT.CHECK);
		btnPrimarySex.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnPrimarySex.setSelection(true);
		btnPrimarySex.setText("Primary Sex");

		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(
				new GridData(SWT.RIGHT, SWT.CENTER, false, false, 3, 1));
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
	 * @return the fromDatePid
	 */
	public int getFromDatePid() {
		return fromDatePid;
	}

	/**
	 *
	 */
	private void getNewFromDate() {
		final DateDialog dialog = new DateDialog(textFromDate.getShell(),
				context);
		if (dialog.open() == Window.OK) {
			try {
				final HDateProvider hdp = new HDateProvider();
				hdp.setDate(dialog.getDate());
				hdp.setSortDate(dialog.getSortDate());
				hdp.setOriginalText(dialog.getOriginal());
				hdp.setSurety(dialog.getSurety());
				setFromDatePid(hdp.insert());
				textFromDate.setText(dialog.getDate().toString());
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
			}
		}
	}

	/**
	 *
	 */
	private void getNewToDate() {
		final DateDialog dialog = new DateDialog(textToDate.getShell(),
				context);
		if (dialog.open() == Window.OK) {
			try {
				final HDateProvider hdp = new HDateProvider();
				hdp.setDate(dialog.getDate());
				hdp.setSortDate(dialog.getSortDate());
				hdp.setOriginalText(dialog.getOriginal());
				hdp.setSurety(dialog.getSurety());
				setToDatePid(hdp.insert());
				textToDate.setText(dialog.getDate().toString());
			} catch (final Exception e1) {
				LOGGER.log(Level.SEVERE, e1.toString(), e1);
			}
		}
	}

	/**
	 * @return the toDatePid
	 */
	public int getToDatePid() {
		return toDatePid;
	}

	/**
	 * @param fromDatePid the fromDatePid to set
	 */
	public void setFromDatePid(int fromDatePid) {
		this.fromDatePid = fromDatePid;
	}

	/**
	 * @param toDatePid the toDatePid to set
	 */
	public void setToDatePid(int toDatePid) {
		this.toDatePid = toDatePid;
	}

	/**
	 * @param personPid
	 */
	@Inject
	@Optional
	private void subscribeSexPidUpdateTopic(
			@UIEventTopic(Constants.SEX_PID_UPDATE_TOPIC) int sexPid) {
		this.sexPid = sexPid;

		try {
			provider.get(sexPid);

			textId.setText(Integer.toString(sexPid));

			final HDateProvider hdp = new HDateProvider();
			fromDatePid = provider.getFromDatePid();
			if (fromDatePid == 0) {
				textFromDate.setText("");
			} else {
				hdp.get(fromDatePid);
				textFromDate.setText(hdp.getDate().toString());
			}

			toDatePid = provider.getToDatePid();
			if (toDatePid == 0) {
				textToDate.setText("");
			} else {
				hdp.get(toDatePid);
				textToDate.setText(hdp.getDate().toString());
			}

			btnPrimarySex.setSelection(provider.isPrimarySex());

			final List<List<String>> sexTypeList = new SexTypeProvider()
					.getStringList();
			int index = 0;

			for (int i = 0; i < sexTypeList.size(); i++) {
				if (sexTypeList.get(i).get(2)
						.equals(provider.getAbbreviation())) {
					index = i;
				}
			}
			comboSex.select(index);
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 *
	 */
	private void update() {
		try {
			provider = new SexProvider();
			provider.get(sexPid);
			provider.setFromDatePid(fromDatePid);
			provider.setToDatePid(toDatePid);
			provider.setPrimarySex(btnPrimarySex.getSelection());
			provider.setSexTypePid(Integer
					.parseInt(lls.get(comboSex.getSelectionIndex()).get(0)));
			provider.update();
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		provider.setFromDatePid(0);
	}
}