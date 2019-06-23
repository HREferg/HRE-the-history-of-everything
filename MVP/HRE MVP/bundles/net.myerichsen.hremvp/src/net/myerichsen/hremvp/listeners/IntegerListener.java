package net.myerichsen.hremvp.listeners;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/**
 * Limit INTEGER fields to legal values
 *
 * @version 2018-05-21
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 *
 */
public class IntegerListener implements Listener {
	@Override
	public void handleEvent(Event event) {
		final Text text = (Text) event.widget;
		final String string = text.getText() + event.text;

		try {
			Integer.parseInt(string);
		} catch (final NumberFormatException e) {
			event.doit = false;
		}
	}
}