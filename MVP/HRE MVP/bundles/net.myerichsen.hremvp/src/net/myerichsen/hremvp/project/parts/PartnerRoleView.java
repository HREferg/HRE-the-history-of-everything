package net.myerichsen.hremvp.project.parts;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import net.myerichsen.hremvp.Constants;
import net.myerichsen.hremvp.HreTypeLabelEditingSupport;
import net.myerichsen.hremvp.project.providers.DictionaryProvider;
import net.myerichsen.hremvp.project.providers.PartnerRoleProvider;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Display a partner role with all language labels
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 9. jun. 2019
 *
 */

public class PartnerRoleView {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Inject
	private IEventBroker eventBroker;
	private Text textAbbreviation;
	private TableViewer tableViewer;
	private final PartnerRoleProvider provider;
	private int PartnerRolePid = 0;
	private int labelPid = 0;

	/**
	 * Constructor
	 *
	 */
	public PartnerRoleView() {
		provider = new PartnerRoleProvider();
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(4, false));

		final Label lblAbbreviation = new Label(parent, SWT.NONE);
		lblAbbreviation.setText("Abbreviation");

		textAbbreviation = new Text(parent, SWT.BORDER);
		textAbbreviation.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		final Table table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));

		final TableViewerColumn tableViewerColumnId = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnId = tableViewerColumnId.getColumn();
		tblclmnId.setWidth(80);
		tblclmnId.setText("Partner Role Id");
		tableViewerColumnId.setLabelProvider(new HREColumnLabelProvider(0));

		final TableViewerColumn tableViewerColumnLabelId = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnILabelId = tableViewerColumnLabelId
				.getColumn();
		tblclmnILabelId.setWidth(80);
		tblclmnILabelId.setText("Dictionary label Id");
		tableViewerColumnLabelId
				.setLabelProvider(new HREColumnLabelProvider(1));

		final TableViewerColumn tableViewerColumnIsoCode = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnIsoCode = tableViewerColumnIsoCode.getColumn();
		tblclmnIsoCode.setWidth(80);
		tblclmnIsoCode.setText("ISO Code");
		tableViewerColumnIsoCode
				.setLabelProvider(new HREColumnLabelProvider(2));

		final TableViewerColumn tableViewerColumnLabel = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnLabel = tableViewerColumnLabel.getColumn();
		tblclmnLabel.setWidth(394);
		tblclmnLabel.setText("Partner label");
		tableViewerColumnLabel.setEditingSupport(
				new HreTypeLabelEditingSupport(tableViewer, 3));
		tableViewerColumnLabel.setLabelProvider(new HREColumnLabelProvider(3));

		HREColumnLabelProvider.addEditingSupport(tableViewer);

		try {
			provider.get();
			tableViewer.setContentProvider(ArrayContentProvider.getInstance());
			tableViewer.setInput(provider.getStringList(PartnerRolePid));
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
		}

		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));
		composite.setLayoutData(
				new GridData(SWT.RIGHT, SWT.CENTER, false, false, 4, 1));

		final Button btnUpdate = new Button(composite, SWT.NONE);
		btnUpdate.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.
			 * events.MouseEvent)
			 */
			@Override
			public void mouseDown(MouseEvent e) {
				updatePartnerRole();
			}
		});
		btnUpdate.setText("Update");

	}

	/**
	 * @param ls A list of Partner role pid, Partner type pid, dictionary pid
	 *           and abbreviation
	 *
	 */
	@Inject
	@Optional
	private void subscribeLabelPidUpdateTopic(
			@UIEventTopic(Constants.LABEL_PID_UPDATE_TOPIC) List<String> ls) {

		try {
			provider.get();
			final String PartnerRolePidString = ls.get(0);
			PartnerRolePid = Integer.parseInt(PartnerRolePidString);
			textAbbreviation.setText(ls.get(3));

			provider.get(PartnerRolePid);
			labelPid = provider.getLabelPid();
			tableViewer.setInput(provider.getStringList(PartnerRolePid));
			tableViewer.refresh();
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 *
	 */
	@SuppressWarnings("unchecked")
	protected void updatePartnerRole() {
		if (textAbbreviation.getText().isEmpty()) {
			eventBroker.post("MESSAGE", "Abbreviation must not be empty");
			textAbbreviation.setFocus();
			return;
		}

		try {
			final List<List<String>> PartnerRoleList = provider
					.getStringList(labelPid);

			PartnerRolePid = Integer.parseInt(PartnerRoleList.get(0).get(0));
			labelPid = Integer.parseInt(PartnerRoleList.get(0).get(1));

			provider.get(PartnerRolePid);
			provider.setAbbreviation(textAbbreviation.getText());
			provider.update();
			LOGGER.log(Level.INFO, "Partner pid {0} has been updated",
					PartnerRolePid);

			DictionaryProvider dp = new DictionaryProvider();
			final List<List<String>> stringList = dp.getStringList(labelPid);

			final List<List<String>> input = (List<List<String>>) tableViewer
					.getInput();

			for (int i = 0; i < input.size(); i++) {
				for (final List<String> existingElement : stringList) {
					LOGGER.log(Level.INFO,
							input.get(i).get(2) + ", " + input.get(i).get(3)
									+ " - " + existingElement.get(0) + ", "
									+ existingElement.get(1) + ", "
									+ existingElement.get(2));

					if (input.get(i).get(2).equals(existingElement.get(0))) {
						if ((!input.get(i).get(3)
								.equals(existingElement.get(1)))) {
							dp = new DictionaryProvider();
							dp.setDictionaryPid(
									Integer.parseInt(existingElement.get(2)));
							dp.setIsoCode(input.get(i).get(2));
							dp.setLabel(input.get(i).get(3));
							dp.setLabelPid(provider.getLabelPid());
							dp.setLabelType("PartnerROLE");
							dp.update();
							LOGGER.log(Level.INFO,
									"Updated dictionary element "
											+ input.get(i).get(0) + ", "
											+ input.get(i).get(1) + ", "
											+ input.get(i).get(2) + ", "
											+ input.get(i).get(3));
						}
						break;
					}
				}
			}
			eventBroker.post("MESSAGE",
					"Partner Role " + PartnerRolePid + " has been updated");
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

}
