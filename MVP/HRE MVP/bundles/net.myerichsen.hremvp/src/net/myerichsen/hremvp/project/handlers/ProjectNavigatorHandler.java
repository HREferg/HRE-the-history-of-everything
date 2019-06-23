
package net.myerichsen.hremvp.project.handlers;

import java.util.List;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;

/**
 * Handler to open the project navigator.
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 24. feb. 2019
 *
 */
public class ProjectNavigatorHandler {
	private static final String contributionURI = "bundleclass://net.myerichsen.hremvp/net.myerichsen.hremvp.project.parts.ProjectNavigator";

	/**
	 * @param partService
	 * @param application
	 * @param modelService
	 */
	@Execute
	public void execute(EPartService partService, MApplication application,
			EModelService modelService) {
		final List<MPartStack> stacks = modelService.findElements(application,
				null, MPartStack.class, null);
		final MPart part = MBasicFactory.INSTANCE.createPart();

//		for (final MPartStack mPartStack : stacks) {
//			final List<MStackElement> a = mPartStack.getChildren();
//
//			for (int i = 0; i < a.size(); i++) {
//				part = (MPart) a.get(i);
//				if (part.getContributionURI().equals(contributionURI)) {
//					partService.showPart(part, PartState.ACTIVATE);
//					return;
//				}
//			}
//		}

		part.setLabel("Project Navigator");
		part.setContainerData("650");
		part.setCloseable(true);
		part.setVisible(true);
		part.setContributionURI(contributionURI);

		stacks.get(0).getChildren().add(part);
		partService.showPart(part, PartState.ACTIVATE);
	}

}