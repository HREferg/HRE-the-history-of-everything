package net.myerichsen.hremvp.help.parts;

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
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 6. jan. 2019
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
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
	}

	/**
	 * Create contents of the dialog.
	 *
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite container = (Composite) super.createDialogArea(parent);

		final StyledText styledText = new StyledText(container,
				SWT.BORDER | SWT.WRAP);
		styledText.setDoubleClickEnabled(false);
		styledText.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		styledText.setAlwaysShowScrollBars(false);
		styledText.setEditable(false);
		styledText.setText(
				"HRE MVP is built as an Eclipse Rich Client Application, licensed under the Eclipse Public License, http://www.eclipse.org/legal/epl-2.0/\r\n\r\n"
						+ "The embedded database is H2, http://www.h2database.com, original author is Thomas Mueller.\r\n"
						+ "H2 is dual licensed and available under the MPL 2.0 "
						+ "(Mozilla Public License Version 2.0) or under the EPL 1.0 (Eclipse Public License).\r\n\r\n"
						+ "Preference code by Olivier Prouvost is used from https://github.com/opcoach/e4preferences\r\nIt is licensed under the Eclipse Public License 1.0\r\n\r\n"
						+ "JSON code by Sean Leary is used from https://github.com/stleary/JSON-java\r\n"
						+ "The license includes this restriction: \"The software shall be used for good, not evil.\"\r\n\r\n"
						+ "Almanac Conversion code by Chris Engelsma is used from https://github.com/chrisengelsma/almanac-converter.\r\n"
						+ "It is licensed under the Apache License 2.0");
		styledText.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		return container;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(553, 455);
	}

}
