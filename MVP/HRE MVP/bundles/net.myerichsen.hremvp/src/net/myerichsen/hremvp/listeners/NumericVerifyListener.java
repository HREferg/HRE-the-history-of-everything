package net.myerichsen.hremvp.listeners;

import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Text;

/**
 * Verify that Text input is numeric
 *
 * @version 2018-04-21
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 *
 */
public class NumericVerifyListener implements VerifyListener {
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.swt.events.VerifyListener#verifyText(org.eclipse.swt.events.
	 * VerifyEvent)
	 */
	@Override
	public void verifyText(VerifyEvent e) {
		final Text text = (Text) e.getSource();

		// get old text and create new text by using the VerifyEvent.text
		final String oldS = text.getText();
		final String newS = oldS.substring(0, e.start) + e.text
				+ oldS.substring(e.end);

		boolean isFloat = true;
		try {
			Float.parseFloat(newS);
		} catch (final NumberFormatException ex) {
			isFloat = false;
		}

		if (!isFloat) {
			e.doit = false;
		}
	}
}