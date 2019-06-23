package net.myerichsen.hremvp.listeners;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/**
 * Limit IP Address fields to legal characters
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 11. dec. 2018
 *
 */
public class IpAddressListener implements Listener {

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.
	 * Event)
	 */
	@Override
	public void handleEvent(Event event) {
		final Text text = (Text) event.widget;
		final String string = text.getText() + event.text;

		final String pattern = "^[0-9\\.]*$";
		event.doit = string.matches(pattern);
	}

}