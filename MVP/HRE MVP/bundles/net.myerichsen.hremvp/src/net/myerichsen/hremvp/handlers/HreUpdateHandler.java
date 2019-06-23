package net.myerichsen.hremvp.handlers;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.operations.ProvisioningJob;
import org.eclipse.equinox.p2.operations.ProvisioningSession;
import org.eclipse.equinox.p2.operations.UpdateOperation;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

/**
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 22. apr. 2019
 *
 */
public class HreUpdateHandler {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");

	/**
	 * @param provisioningJob
	 * @param shell
	 * @param sync
	 * @param workbench
	 * @param monitor
	 */
	private void configureProvisioningJob(ProvisioningJob provisioningJob,
			Shell shell, UISynchronize sync, IWorkbench workbench,
			IProgressMonitor monitor) {
		LOGGER.log(Level.INFO, "Configure Provisioning job");
		final SubMonitor subMonitor = SubMonitor.convert(monitor, 25);
		subMonitor.beginTask("Configure Provisioning Job", 25);

		provisioningJob.addJobChangeListener(new JobChangeAdapter() {
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.core.runtime.jobs.JobChangeAdapter#done(org.eclipse.
			 * core.runtime.jobs.IJobChangeEvent)
			 */
			@Override
			public void done(IJobChangeEvent event) {
				if (event.getResult().isOK()) {
					sync.syncExec(() -> {
						final boolean restart = MessageDialog.openQuestion(
								shell, "Updates installed, restart?",
								"Updates for HRE have been installed from "
										+ store.getString("UPDATESITE")
										+ ". Do you want to restart?");
						if (restart) {
							PlatformUI.getWorkbench().restart();
						}

					});
				} else {
					sync.syncExec(() -> MessageDialog.openWarning(shell,
							"Update failed",
							"Update of HRE from "
									+ store.getString("UPDATESITE")
									+ " has failed"));
				}
				super.done(event);
			}
		});
		subMonitor.worked(25);
	}

	/**
	 * @param operation
	 * @param monitor
	 * @return
	 */
	private UpdateOperation configureUpdate(UpdateOperation operation,
			IProgressMonitor monitor) {
		final SubMonitor subMonitor = SubMonitor.convert(monitor, 25);
		subMonitor.beginTask("Configure Update", 25);
		LOGGER.log(Level.INFO, "Configure Update");

		URI uri = null;
		try {
			uri = new URI(store.getString("UPDATESITE"));
			LOGGER.log(Level.INFO, "URI: {0}", uri);
		} catch (final URISyntaxException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			return null;
		}

		operation.getProvisioningContext().setArtifactRepositories(uri);
		operation.getProvisioningContext().setMetadataRepositories(uri);
		subMonitor.worked(25);
		return operation;
	}

	/**
	 * @param agent
	 * @param shell
	 * @param sync
	 * @param workbench
	 */
	@Execute
	public void execute(IProvisioningAgent agent, Shell shell,
			UISynchronize sync, IWorkbench workbench) {
		LOGGER.log(Level.INFO, "Expected repository location: {0}",
				store.getString("UPDATESITE"));
		try {
			final ProgressMonitorDialog dialog = new ProgressMonitorDialog(
					shell);
			dialog.run(true, true, monitor -> {

				final SubMonitor subMonitor = SubMonitor.convert(monitor, 100);

				LOGGER.log(Level.INFO, "Check for updates");

				final ProvisioningSession session = new ProvisioningSession(
						agent);
				final UpdateOperation operation = new UpdateOperation(session);
				configureUpdate(operation, subMonitor.split(25, 0));

				final IStatus status = resolveModal(monitor, operation,
						subMonitor.split(25, 0));

				if (status
						.getCode() == UpdateOperation.STATUS_NOTHING_TO_UPDATE) {
					showMessage(shell, sync);
					return;
				}

				final ProvisioningJob provisioningJob = getProvisioningJob(
						monitor, operation, subMonitor.split(25, 0));

				if (provisioningJob == null) {
					LOGGER.log(Level.SEVERE,
							"Trying to update from the Eclipse IDE? Won't work!");
					return;
				}
				configureProvisioningJob(provisioningJob, shell, sync,
						workbench, subMonitor.split(25, 0));

				provisioningJob.schedule();
			});
		} catch (final InvocationTargetException | InterruptedException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 * @param monitor
	 * @param operation
	 * @param monitor2
	 * @return
	 */
	private ProvisioningJob getProvisioningJob(IProgressMonitor monitor,
			UpdateOperation operation, IProgressMonitor monitor2) {
		final SubMonitor subMonitor = SubMonitor.convert(monitor2, 25);
		subMonitor.beginTask("Get Provisioning Job", 25);
		LOGGER.log(Level.INFO, "Get Provisioning Job");
		final ProvisioningJob provisioningJob = operation
				.getProvisioningJob(monitor);
		subMonitor.worked(25);
		return provisioningJob;
	}

	/**
	 * @param monitor
	 * @param operation
	 * @param monitor2
	 * @return
	 */
	private IStatus resolveModal(IProgressMonitor monitor,
			UpdateOperation operation, IProgressMonitor monitor2) {
		final SubMonitor subMonitor = SubMonitor.convert(monitor2, 25);
		subMonitor.beginTask("Resolve Modal Operation", 25);
		LOGGER.log(Level.INFO, "Resolve Modal Operation");
		final IStatus status = operation.resolveModal(monitor);
		subMonitor.worked(25);
		return status;
	}

	/**
	 * @param parent
	 * @param sync
	 */
	private void showMessage(Shell parent, UISynchronize sync) {
		LOGGER.log(Level.INFO, "Show message: No updates found");
		sync.syncExec(() -> MessageDialog.openWarning(parent, "No update",
				"No updates for HRE have been found at "
						+ store.getString("UPDATESITE")));
	}
}
