package net.myerichsen.hremvp.listeners;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/**
 * Limit SMALLINT fields to legal values
 *
 * @version 2018-05-24
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 *
 */
public class SmallIntListener implements Listener {
	@Override
	public void handleEvent(Event event) {
		final Text text = (Text) event.widget;
		final String string = text.getText() + event.text;

		try {
			Short.parseShort(string);
		} catch (final NumberFormatException e) {
			event.doit = false;
		}
	}
}