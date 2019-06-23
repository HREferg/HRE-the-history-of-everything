package net.myerichsen.hremvp.help.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;

import net.myerichsen.hremvp.help.parts.HelpAboutDialog;

/**
 * Handler to display the Help About dialog.
 *
 * @version 2018-06-09
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 *
 */
public class HelpAboutHandler {
	/**
	 * @param shell
	 */
	@Execute
	public void execute(Shell shell) {
		final HelpAboutDialog dialog = new HelpAboutDialog(shell);
		dialog.open();
	}
}
