package org.historyresearchenvironment.client.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

/**
 * Dialog to display licenses used by HRE.
 * 
 * @version 2018-07-04
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class HelpLicensesDialog extends Dialog {

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public HelpLicensesDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Licenses");
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite container = (Composite) super.createDialogArea(parent);

		final StyledText styledText = new StyledText(container, SWT.BORDER | SWT.WRAP);
		styledText.setDoubleClickEnabled(false);
		styledText.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		styledText.setAlwaysShowScrollBars(false);
		styledText.setEditable(false);
		styledText.setText(
				"The embedded database is H2, http://www.h2database.com.\r\nH2 is dual licensed and available under the MPL 2.0 (Mozilla Public License Version 2.0) or under the EPL 1.0 (Eclipse Public License).\r\n"
						+ "Preference code used from https://github.com/opcoach/e4preferences\r\nE4preferrences is licensed under the Eclipse Public License 1.0"
						+ "JSON code is used from https://github.com/stleary/JSON-java\r\nThe license includes this restriction: \"The software shall be used for good, not evil.\" If your conscience cannot live with that, then choose a different package.");
		styledText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		return container;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(553, 300);
	}

}
