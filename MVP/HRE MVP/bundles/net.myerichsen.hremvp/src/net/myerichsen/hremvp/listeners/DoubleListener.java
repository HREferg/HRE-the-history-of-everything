package net.myerichsen.hremvp.listeners;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/**
 * Limit DOUBLE fields to legal values
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 22. okt. 2018
 *
 */
public class DoubleListener implements Listener {
	@Override
	public void handleEvent(Event event) {
		final Text text = (Text) event.widget;
		final String string = text.getText() + event.text;

		try {
			Double.parseDouble(string);
		} catch (final NumberFormatException e) {
			event.doit = false;
		}
	}
}