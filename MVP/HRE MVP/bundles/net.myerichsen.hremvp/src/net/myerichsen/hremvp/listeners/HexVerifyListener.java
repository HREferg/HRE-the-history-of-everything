package net.myerichsen.hremvp.listeners;

import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;

/**
 * Limit input to valid hex characters
 *
 * @version 2018-05-19
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 *
 */
public class HexVerifyListener implements VerifyListener {
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.swt.events.VerifyListener#verifyText(org.eclipse.swt.events.
	 * VerifyEvent)
	 */
	@Override
	public void verifyText(VerifyEvent event) {
		final String text = event.text.toUpperCase();
		if (!text.matches("[0-9A-F]*")) {
			event.doit = false;
		}
		event.text = text;
	}
}