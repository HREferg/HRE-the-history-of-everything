package org.historyresearchenvironment.client.parts;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

/**
 * Status line field
 * 
 * @version 2018-06-07
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class StatusToolControl {
	@Inject
	IEventBroker eventBroker;

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private Text textStatus;

	/**
	 * Create the message text field
	 * 
	 * @param parent
	 *            Shell
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		textStatus = new Text(parent, SWT.NONE);
		textStatus.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridData gd_textStatus = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_textStatus.heightHint = 24;
		gd_textStatus.widthHint = 1920;
		textStatus.setLayoutData(gd_textStatus);
		textStatus.setEditable(false);
		textStatus.setText("");
	}

	/**
	 * @param s
	 *            Message string
	 */
	@Inject
	@Optional
	public void messageHandler(@UIEventTopic("MESSAGE") String s) {
		setMessage(s);
		LOGGER.info(s);
	}

	/**
	 * @param s
	 *            Message string
	 */
	public void setMessage(String s) {
		if (s != null) {
			textStatus.setText(s);
		}
	}
}