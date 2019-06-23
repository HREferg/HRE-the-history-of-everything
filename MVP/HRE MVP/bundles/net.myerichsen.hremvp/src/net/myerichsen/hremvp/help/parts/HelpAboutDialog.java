package net.myerichsen.hremvp.help.parts;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

import net.myerichsen.hremvp.Constants;

/**
 * Dialog to display help about HRE.
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 6. jan. 2019
 *
 */
public class HelpAboutDialog extends Dialog {
	/**
	 * Constructor
	 *
	 * @param parentShell
	 */
	public HelpAboutDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("About HRE MVP");
	}

	/**
	 * Create contents of the button bar.
	 *
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.HELP_ID,
				IDialogConstants.HELP_LABEL, true);
		final Button button = createButton(parent, Constants.LICENSES_ID,
				"Licenses", true);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				final HelpLicensesDialog dialog = new HelpLicensesDialog(
						parent.getShell());
				dialog.open();
			}
		});
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
		container.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		container.setLayout(new GridLayout(2, false));

		final CLabel lblLogo = new CLabel(container, SWT.NONE);
		lblLogo.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		lblLogo.setImage(ResourceManager.getPluginImage("net.myerichsen.hremvp",
				"icons/HRE1.0Logo.png"));
		lblLogo.setText("");

		final StyledText styledText_1 = new StyledText(container, SWT.WRAP);
		styledText_1.setAlignment(SWT.CENTER);
		styledText_1.setDoubleClickEnabled(false);
		styledText_1.setEditable(false);
		styledText_1
				.setFont(SWTResourceManager.getFont("Calibri", 28, SWT.BOLD));
		styledText_1
				.setText("History Research Environment Minimum Viable Product");
		styledText_1.setLayoutData(
				new GridData(SWT.CENTER, SWT.FILL, true, false, 1, 1));

		final StyledText styledText_2 = new StyledText(container, SWT.NONE);
		styledText_2.setEnabled(false);
		styledText_2.setAlignment(SWT.CENTER);
		styledText_2.setDoubleClickEnabled(false);
		styledText_2.setEditable(false);
		styledText_2
				.setFont(SWTResourceManager.getFont("Calibri", 10, SWT.BOLD));
		styledText_2.setText("Release V0.2.2\r\nBuild Date 2019-01-06");
		styledText_2.setLayoutData(
				new GridData(SWT.CENTER, SWT.FILL, true, false, 1, 1));

		final StyledText styledText = new StyledText(container, SWT.WRAP);
		styledText.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		styledText.setAlwaysShowScrollBars(false);
		styledText.setEditable(false);
		styledText.setText(
				"History Research Environment (HRE) is a community project to create a free open source platform for recording a wide range of genealogical, historical and social research.");
		styledText.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		final StyledText styledText_3 = new StyledText(container, SWT.WRAP);
		styledText_3.setDoubleClickEnabled(false);
		styledText_3
				.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		styledText_3.setAlwaysShowScrollBars(false);
		styledText_3.setEditable(false);
		styledText_3.setText(
				"The development community is supported by a non-for-profit company, History Research Environment Limited, limited by Guarantee and registered under the laws of England and Wales.");
		styledText_3.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		final StyledText styledText_6 = new StyledText(container, SWT.WRAP);
		styledText_6.setDoubleClickEnabled(false);
		styledText_6
				.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		styledText_6.setAlwaysShowScrollBars(false);
		styledText_6.setEditable(false);
		styledText_6.setText(
				"All code developed by HRE is copyright to individual developers, and is released under the GNU Affero Public License (GNU AGPL), https://www.gnu.org/licenses/agpl-3.0.en.html. For further details, see http://hrewiki.org/index.php?title=Why_have_we_chosen_these_licences%3F.");
		styledText_6.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		final StyledText styledText_5 = new StyledText(container, SWT.WRAP);
		styledText_5.setDoubleClickEnabled(false);
		styledText_5
				.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		styledText_5.setAlwaysShowScrollBars(false);
		styledText_5.setEditable(false);
		styledText_5.setText(
				"Reuse of the HRE software is permitted only under the terms of the license. Using the HRE software or any derivative of the software to offer a service over the Internet is strictly prohibited.");
		styledText_5.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		final StyledText styledText_4 = new StyledText(container, SWT.WRAP);
		styledText_4.setDoubleClickEnabled(false);
		styledText_4
				.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		styledText_4.setAlwaysShowScrollBars(false);
		styledText_4.setEditable(false);
		styledText_4.setText(
				"Website: https://historyresearchenvironment.org/\r\nWiki: http://hrewiki.org");
		styledText_4.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		return container;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(560, 687);
	}
}
