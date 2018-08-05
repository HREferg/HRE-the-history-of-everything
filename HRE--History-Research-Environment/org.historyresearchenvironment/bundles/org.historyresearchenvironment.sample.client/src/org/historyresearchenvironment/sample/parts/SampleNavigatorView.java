package org.historyresearchenvironment.sample.parts;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.historyresearchenvironment.client.parts.AbstractHreGuiPart;
import org.historyresearchenvironment.sample.providers.SampleEditorProvider;
import org.historyresearchenvironment.sample.providers.SampleNavigatorProvider;

/**
 * A navigator view part for the sample.
 * 
 * @version 2018-07-13
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
@SuppressWarnings("restriction")
public class SampleNavigatorView extends AbstractHreGuiPart {
	@Inject
	private IEventBroker eventBroker;
	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;

	private Table table;
	private SampleNavigatorProvider provider;
	private TableViewer tableViewer;
	private Composite parent;

	/**
	 * Constructor
	 *
	 */
	public SampleNavigatorView() {
		provider = new SampleNavigatorProvider();
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parentC
	 */
	@PostConstruct
	public void createControls(Composite parentC) {
		parent = parentC;
		parent.setLayout(new GridLayout(1, false));

		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setToolTipText("Double click an item to open it in the Sample Editor");
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnParameterSetKey = tableViewerColumn.getColumn();
		tblclmnParameterSetKey.setWidth(130);
		tblclmnParameterSetKey.setText("Parameter Set Key");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnParameterListKey = tableViewerColumn_2.getColumn();
		tblclmnParameterListKey.setWidth(126);
		tblclmnParameterListKey.setText("Parameter List Key");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnDefaultValue = tableViewerColumn_1.getColumn();
		tblclmnDefaultValue.setWidth(451);
		tblclmnDefaultValue.setText("Default Value");
		table.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDoubleClick(org.eclipse.swt.events.
			 * MouseEvent)
			 */
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				openSampleEditor();
			}
		});

		updateGui();
//		callBusinessLayer("GET", provider, businessLogic, "1");
	}

	/**
	 * 
	 */
	@PreDestroy
	public void dispose() {
	}

	/**
	 * 
	 */
	protected void openSampleEditor() {
		String paramSetKey = "0";

		// Open an editor
		final ParameterizedCommand command = commandService
				.createCommand("org.historyresearchenvironment.sample.client.command.sampleeditoropen", null);
		handlerService.executeHandler(command);
		LOGGER.info("Navigator opened editor");

		final TableItem[] selectedRows = table.getSelection();

		if (selectedRows.length > 0) {
			final TableItem selectedRow = selectedRows[0];
			paramSetKey = selectedRow.getText(0);
		}

		eventBroker.post(org.historyresearchenvironment.sample.client.Constants.PARAMETER_SET_KEY_UPDATE_TOPIC,
				paramSetKey);
		eventBroker.post(org.historyresearchenvironment.sample.client.Constants.PARAMETER_SET_KEY_UPDATE_TOPIC,
				paramSetKey);
		LOGGER.info("Navigator posted key " + paramSetKey);

		eventBroker.post("MESSAGE", "Sample editor has been opened");
	}

	/**
	 * 
	 */
	@Focus
	public void setFocus() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.historyresearchenvironment.client.parts.AbstractHreGuiPart#updateGui()
	 */
	@Override
	protected void updateGui() {
		try {
			provider = new SampleNavigatorProvider();

			List<SampleEditorProvider> rowList = provider.selectAll();

			table.removeAll();

			for (int i = 0; i < rowList.size(); i++) {
				TableItem item = new TableItem(table, SWT.NONE);
				SampleEditorProvider row = rowList.get(i);
				item.setText(0, Short.toString(row.getParamSetKey()));
				item.setText(1, Short.toString(row.getParamListKey()));
				item.setText(2, row.getDefltValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			eventBroker.post("MESSAGE", e.getMessage());
			LOGGER.severe(e.getMessage());
		}

	}
}
