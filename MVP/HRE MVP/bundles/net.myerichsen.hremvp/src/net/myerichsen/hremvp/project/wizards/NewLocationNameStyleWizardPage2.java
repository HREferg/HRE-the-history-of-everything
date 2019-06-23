package net.myerichsen.hremvp.project.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import net.myerichsen.hremvp.HreTypeLabelEditingSupport;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Add a location name style wizard page
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 9. jun. 2019
 *
 */
public class NewLocationNameStyleWizardPage2 extends WizardPage {
//	private static final Logger LOGGER = Logger
//			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private TableViewer tableViewer;
	private List<List<String>> lls;

	/**
	 * Constructor
	 */
	public NewLocationNameStyleWizardPage2() {
		super("Location name style wizard Page 2");
		setTitle("Location name style");
		setDescription("Add parts of a new location name style");
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(2, false));

		final NewLocationNameStyleWizard wizard = (NewLocationNameStyleWizard) getWizard();
		final String namePartCount = wizard.getNamePartCount();
		lls = new ArrayList<>();

		for (int i = 0; i < Integer.parseInt(namePartCount); i++) {
			final List<String> stringList = new ArrayList<>();
			stringList.add(Integer.toString(i + 1));
			stringList.add("");
			lls.add(stringList);
		}

		final Label lblIsoCode = new Label(container, SWT.NONE);
		lblIsoCode.setText("ISO Code");

		final Text textIsoCode = new Text(container, SWT.BORDER);
		textIsoCode.setEditable(false);
		textIsoCode.setText(wizard.getIsoCode());
		textIsoCode.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Label lblStyleName = new Label(container, SWT.NONE);
		lblStyleName.setText("Style name");

		final Text textStyleName = new Text(container, SWT.BORDER);
		textStyleName.setEditable(false);
		textStyleName.setText(wizard.getStyleName());
		textStyleName.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Label lblNumberOfName = new Label(container, SWT.NONE);
		lblNumberOfName.setText("Number of name parts");

		final Text textNamePartCount = new Text(container, SWT.BORDER);
		textNamePartCount.setEditable(false);
		textNamePartCount.setText(namePartCount);
		textNamePartCount.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		tableViewer = new TableViewer(container,
				SWT.BORDER | SWT.FULL_SELECTION);
		final Table table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		final TableViewerColumn tableViewerColumnPartNo = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnPartNo = tableViewerColumnPartNo.getColumn();
		tblclmnPartNo.setWidth(100);
		tblclmnPartNo.setText("Part no.");
		tableViewerColumnPartNo.setLabelProvider(new HREColumnLabelProvider(0));

		final TableViewerColumn tableViewerColumnPartName = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnPartName = tableViewerColumnPartName
				.getColumn();
		tblclmnPartName.setWidth(334);
		tblclmnPartName.setText("Part name");
		tableViewerColumnPartName.setEditingSupport(
				new HreTypeLabelEditingSupport(tableViewer, 1));
		tableViewerColumnPartName
				.setLabelProvider(new HREColumnLabelProvider(1));

		HREColumnLabelProvider.addEditingSupport(tableViewer);

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setInput(lls);
	}

	/**
	 * @return the lls
	 */
	public List<List<String>> getLls() {
		return lls;
	}

	/**
	 * @return the tableViewer
	 */
	public TableViewer getTableViewer() {
		return tableViewer;
	}

}
