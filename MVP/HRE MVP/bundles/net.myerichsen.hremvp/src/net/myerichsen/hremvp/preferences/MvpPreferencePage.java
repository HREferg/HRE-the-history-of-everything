package net.myerichsen.hremvp.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

/**
 * Root preferences page for MVP
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 17. okt. 2018
 *
 */
public class MvpPreferencePage extends PreferencePage {
	/**
	 * Constructor
	 *
	 */
	public MvpPreferencePage() {
		setTitle("MVP Preferences");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.
	 * swt. widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(
				new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 2));
		composite.setLayout(new GridLayout(1, false));
		final Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(
				new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		label.setText("See sub-pages for settings.");

		final Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayoutData(
				new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		return null;
	}

}