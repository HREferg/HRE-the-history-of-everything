package net.myerichsen.hremvp.help.parts;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * Embedded browser for HRE Web Site.
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 14. apr. 2019
 *
 */
public class HelpHreWebsite {

	public HelpHreWebsite() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		final Browser browser = new Browser(parent, SWT.NONE);
		browser.setToolTipText("HRE Web Site");
		browser.setUrl("https://historyresearchenvironment.org/");
		browser.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	}

}
