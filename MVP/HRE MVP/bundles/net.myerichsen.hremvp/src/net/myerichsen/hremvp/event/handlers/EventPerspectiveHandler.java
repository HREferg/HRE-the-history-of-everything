package net.myerichsen.hremvp.event.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

/**
 * Switch perspective to event perspective
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 27. mar. 2019
 *
 */
public class EventPerspectiveHandler {
	/**
	 * @param app          The Eclipse application
	 * @param partService  The Eclipse parts service
	 * @param modelService The Eclipse model service
	 */
	@Execute
	public void execute(MApplication app, EPartService partService,
			EModelService modelService) {
		partService.switchPerspective(
				"net.myerichsen.hremvp.perspective.eventperspective");
	}
}