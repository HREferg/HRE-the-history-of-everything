package net.myerichsen.hremvp.handlers;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;

import net.myerichsen.hremvp.dialogs.DateDialog;

/**
 * Open the time dialog
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 7. nov. 2018
 *
 */
public class DateDialogHandler {
	/**
	 * @param shell   The parent shell
	 * @param context The Eclipse Context
	 */
	@Execute
	public void execute(Shell shell, IEclipseContext context) {
		final DateDialog dialog = new DateDialog(shell, context);
		dialog.open();
	}
}
