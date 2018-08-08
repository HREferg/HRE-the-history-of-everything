
package org.historyresearchenvironment.prototypes.parts;

import javax.annotation.PostConstruct;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

/**
 * @version 2018-08-08
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class PersonNavigatorView {
	private Text txtDummyField;

	/**
	 * @param parent
	 */
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(2, false));

		Label lblPersonNavigator = new Label(parent, SWT.NONE);
		lblPersonNavigator.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPersonNavigator.setText("Person Navigator");

		txtDummyField = new Text(parent, SWT.BORDER);
		txtDummyField.setText("Dummy field");
		txtDummyField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

	}

}