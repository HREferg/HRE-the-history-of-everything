package net.myerichsen.hremvp.listeners;

import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Text;

/**
 * Verify valid formated date
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 6. nov. 2018
 *
 */
public class DateVerifyListener implements VerifyListener {
	@Override
	public void verifyText(VerifyEvent e) {
		final Text text = (Text) e.getSource();

		if (text.getText().matches("[0-9\\+\\-]*")) {
			e.doit = true;
		} else {
			e.doit = false;
		}
	}
}