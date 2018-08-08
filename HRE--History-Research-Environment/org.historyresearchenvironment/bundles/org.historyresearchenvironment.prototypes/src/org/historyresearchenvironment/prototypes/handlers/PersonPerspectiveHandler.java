package org.historyresearchenvironment.prototypes.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

/**
 * Switch perspective to the Person feature.
 * 
 * @version 2018-08-08
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class PersonPerspectiveHandler {
	/**
	 * @param app
	 * @param partService
	 * @param modelService
	 */
	@Execute
	public void execute(MApplication app, EPartService partService, EModelService modelService) {
		partService.switchPerspective("org.historyresearchenvironment.prototypes.perspective.personperspective");
	}
}