package net.myerichsen.hremvp.listeners;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Text;

/**
 * Make sure that the number of characters is not bigger than MAX CHAR
 *
 * @version 2018-05-19
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 *
 */
public class LengthFocusListener implements FocusListener {
	int maxChar;

	/**
	 * Constructor
	 *
	 * @param maxChar Maximum length of character string
	 */
	public LengthFocusListener(int maxChar) {
		super();
		this.maxChar = maxChar;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.swt.events.FocusListener#focusGained(org.eclipse.swt.events.
	 * FocusEvent)
	 */
	@Override
	public void focusGained(FocusEvent e) {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.swt.events.FocusListener#focusLost(org.eclipse.swt.events.
	 * FocusEvent)
	 */
	@Override
	public void focusLost(FocusEvent e) {
		final Text text = (Text) e.widget;
		final int length = text.getCharCount();
		if (length > maxChar) {
			text.setText(text.getText().substring(0, maxChar));
		}
	}
}
