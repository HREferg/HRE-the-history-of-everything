package net.myerichsen.hremvp.person.wizards;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import net.myerichsen.hremvp.HreTypeLabelEditingSupport;
import net.myerichsen.hremvp.project.providers.PersonNameMapProvider;
import net.myerichsen.hremvp.providers.HREColumnLabelProvider;

/**
 * Person name parts wizard page
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 * @version 13. apr. 2019
 *
 */
public class NewPersonWizardPage3 extends WizardPage {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final PersonNameMapProvider provider;
	private List<List<String>> lls;
	private Table table;

	/**
	 * Constructor
	 *
	 */
	public NewPersonWizardPage3() {
		super("wizardPage");
		setTitle("Person Name Parts");
		setDescription("Enter each part of the name");
		provider = new PersonNameMapProvider();
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
		container.setLayout(new GridLayout(1, false));

		final TableViewer tableViewer = new TableViewer(container,
				SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		final TableViewerColumn tableViewerColumnId = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnId = tableViewerColumnId.getColumn();
		tblclmnId.setWidth(100);
		tblclmnId.setText("Part no.");
		tableViewerColumnId.setLabelProvider(new HREColumnLabelProvider(2));

		final TableViewerColumn tableViewerColumnLabel = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnLabel = tableViewerColumnLabel.getColumn();
		tblclmnLabel.setWidth(100);
		tblclmnLabel.setText("Label");
		tableViewerColumnLabel.setLabelProvider(new HREColumnLabelProvider(3));

		final TableViewerColumn tableViewerColumnValue = new TableViewerColumn(
				tableViewer, SWT.NONE);
		final TableColumn tblclmnValue = tableViewerColumnValue.getColumn();
		tblclmnValue.setWidth(300);
		tblclmnValue.setText("Value");
		tableViewerColumnValue.setEditingSupport(
				new HreTypeLabelEditingSupport(tableViewer, 5));
		tableViewerColumnValue.setLabelProvider(new HREColumnLabelProvider(5));

		HREColumnLabelProvider.addEditingSupport(tableViewer);

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		try {
			final NewPersonWizard wizard = (NewPersonWizard) getWizard();
			final int personNameStylePid = wizard.getPersonNameStylePid();
			lls = provider.getStringList(personNameStylePid);
			tableViewer.setInput(lls);
			setErrorMessage(null);
		} catch (final Exception e1) {
			LOGGER.log(Level.SEVERE, e1.toString(), e1);
			setErrorMessage(e1.getMessage());
		}
		setPageComplete(true);
	}

	/**
	 * @return the lls
	 */
	public List<List<String>> getLls() {
		return lls;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);

		if (visible) {
			table.setFocus();
		}
	}
}