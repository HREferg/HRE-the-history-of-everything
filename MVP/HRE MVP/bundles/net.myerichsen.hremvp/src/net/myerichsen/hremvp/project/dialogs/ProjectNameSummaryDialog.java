package net.myerichsen.hremvp.project.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Dialog to be called by the new project process.
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 21. jan. 2019
 *
 */
public class ProjectNameSummaryDialog extends TitleAreaDialog {
	private Text textProjectName;
	private String projectName;
	private String projectSummary;
	private StyledText styledTextProjectSummary;

	/**
	 * Create the dialog.
	 *
	 * @param parentShell
	 */
	public ProjectNameSummaryDialog(Shell parentShell) {
		super(parentShell);
		setHelpAvailable(false);
	}

	/**
	 * Create contents of the button bar.
	 *
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		final Button button = createButton(parent, IDialogConstants.OK_ID,
				IDialogConstants.OK_LABEL, true);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				projectName = textProjectName.getText();
				projectSummary = styledTextProjectSummary.getText();
			}
		});
	}

	/**
	 * Create contents of the dialog.
	 *
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("Please enter the name and the summary of the new project");
		setTitle("Project Name and Summary");
		final Composite area = (Composite) super.createDialogArea(parent);
		final Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		final Label lblProjectName = new Label(container, SWT.NONE);
		lblProjectName.setText("Project Name");

		textProjectName = new Text(container, SWT.BORDER);
		textProjectName.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Label lblProjectSummary = new Label(container, SWT.NONE);
		lblProjectSummary.setLayoutData(
				new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblProjectSummary.setText("Project Summary");

		styledTextProjectSummary = new StyledText(container, SWT.BORDER);
		styledTextProjectSummary.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		return area;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @return the projectSummary
	 */
	public String getProjectSummary() {
		return projectSummary;
	}

	/**
	 * @return the textProjectName
	 */
	public Text getTextProjectName() {
		return textProjectName;
	}

	/**
	 * @param textProjectName the textProjectName to set
	 */
	public void setTextProjectName(Text textProjectName) {
		this.textProjectName = textProjectName;
	}

}
