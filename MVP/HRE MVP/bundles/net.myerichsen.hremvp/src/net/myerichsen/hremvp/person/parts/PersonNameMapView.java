package net.myerichsen.hremvp.person.parts;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.swt.SWT;
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
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.listeners.NumericVerifyListener;
import net.myerichsen.hremvp.project.providers.PersonNameMapProvider;

/**
 * Display all data about a name map
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 18. apr. 2019
 *
 */
public class PersonNameMapView {
	/**
	 *
	 */
	private static final String MESSAGE = "MESSAGE";
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

	private Text textId;
	private Text textStyleId;
	private Text textStyle;
	private Text textPartNo;
	private Text textLabel;

	private final PersonNameMapProvider provider;

	/**
	 * Constructor
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors.
	 */
	public PersonNameMapView() {
		provider = new PersonNameMapProvider();
	}

	/**
	 *
	 */
	protected void clear() {
		textId.setText("0");
		textStyleId.setText("0");
		textStyle.setText("");
		textPartNo.setText("0");
		textLabel.setText("");
	}

	/**
	 *
	 */
	protected void close() {
		final List<MPartStack> stacks = modelService.findElements(application,
				null, MPartStack.class, null);
		final MPart part = (MPart) stacks.get(stacks.size() - 2)
				.getSelectedElement();
		partService.hidePart(part, true);
	}

	/**
	 * Create contents of the view part
	 *
	 * @param parent The parent composite.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(3, false));

		final Label lblId = new Label(parent, SWT.NONE);
		lblId.setText("ID");

		textId = new Text(parent, SWT.BORDER);
		textId.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textId.addVerifyListener(new NumericVerifyListener());

		new Label(parent, SWT.NONE);

		final Label lblStyle = new Label(parent, SWT.NONE);
		lblStyle.setLayoutData(
				new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblStyle.setText("Style");

		textStyleId = new Text(parent, SWT.BORDER);
		textStyleId.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textStyleId.addVerifyListener(new NumericVerifyListener());

		textStyle = new Text(parent, SWT.BORDER);
		textStyle.setEditable(false);
		textStyle.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Label lblPartNo = new Label(parent, SWT.NONE);
		lblPartNo.setText("Part no.");

		textPartNo = new Text(parent, SWT.BORDER);
		textPartNo.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textPartNo.addVerifyListener(new NumericVerifyListener());

		new Label(parent, SWT.NONE);

		final Label lblLabel = new Label(parent, SWT.NONE);
		lblLabel.setText("Label");

		textLabel = new Text(parent, SWT.BORDER);
		textLabel.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));

		final Button buttonSelect = new Button(composite, SWT.NONE);
		buttonSelect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				get();
			}
		});
		buttonSelect.setText("Select");

		final Button buttonInsert = new Button(composite, SWT.NONE);
		buttonInsert.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insert();
			}
		});
		buttonInsert.setText("Insert");

		final Button buttonUpdate = new Button(composite, SWT.NONE);
		buttonUpdate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				update();
			}
		});
		buttonUpdate.setText("Update");

		final Button buttonDelete = new Button(composite, SWT.NONE);
		buttonDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				delete();
			}
		});
		buttonDelete.setText("Delete");

		final Button buttonClear = new Button(composite, SWT.NONE);
		buttonClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clear();
			}
		});
		buttonClear.setText("Clear");

		final Button buttonClose = new Button(composite, SWT.NONE);
		buttonClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		buttonClose.setText("Close");
	}

	/**
	 * @throws MvpException
	 * @throws NumberFormatException
	 *
	 */
	protected void delete() {
		try {
			provider.delete(Integer.parseInt(textId.getText()));
			eventBroker.post(MESSAGE,
					"Name Map " + textId.getText() + " has been deleted");
			clear();
		} catch (final Exception e) {
			eventBroker.post(MESSAGE, e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
			eventBroker.post(MESSAGE, e.getMessage());
		}
	}

	/**
	 *
	 */
	private void get() {
		get(Integer.parseInt(textId.getText()));
	}

	/**
	 * @param key
	 */
	private void get(int key) {
		try {
			provider.get(key);

			textId.setText(Integer.toString(provider.getNameMapPid()));
			textStyleId.setText(Integer.toString(provider.getNameStylePid()));
			textStyle.setText(provider.getStyleLabel());
			textPartNo.setText(Integer.toString(provider.getPartNo()));
			textLabel.setText(provider.getLabel());
			eventBroker.post(MESSAGE,
					"Name Map " + textId.getText() + " has been fetched");
		} catch (final Exception e) {
			clear();
			eventBroker.post(MESSAGE, e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
			eventBroker.post(MESSAGE, e.getMessage());
		}
	}

	/**
	 *
	 */
	protected void insert() {
		try {
			provider.setLabel(textLabel.getText());
			provider.setNameMapPid(Integer.parseInt(textId.getText()));
			provider.setNameStylePid(Integer.parseInt(textStyleId.getText()));
			provider.setPartNo(Integer.parseInt(textPartNo.getText()));
			provider.insert();
			eventBroker.post(MESSAGE,
					"Name Map " + textId.getText() + " has been inserted");
		} catch (final Exception e) {
			eventBroker.post(MESSAGE, e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
			eventBroker.post(MESSAGE, e.getMessage());
		}
	}

	/**
	 * @param nameMapPid
	 * @throws Exception
	 */
	@Inject
	@Optional
	private void subscribeNameMapUpdateTopic(
			@UIEventTopic(Constants.PERSON_NAME_MAP_PID_UPDATE_TOPIC) int nameMapPid) {
		get(nameMapPid);
	}

	/**
	 *
	 */
	protected void update() {
		try {
			provider.setLabel(textLabel.getText());
			provider.setNameMapPid(Integer.parseInt(textId.getText()));
			provider.setNameStylePid(Integer.parseInt(textStyleId.getText()));
			provider.setPartNo(Integer.parseInt(textPartNo.getText()));
			provider.update();
			eventBroker.post(MESSAGE,
					"Name Map " + textId.getText() + " has been updated");
		} catch (final Exception e) {
			eventBroker.post(MESSAGE, e.getMessage());
			LOGGER.log(Level.SEVERE, e.toString(), e);
			eventBroker.post(MESSAGE, e.getMessage());
		}
	}
}
