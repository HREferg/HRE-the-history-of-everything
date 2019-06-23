package net.myerichsen.hremvp.project.models;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.preference.IPreferenceStore;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

/**
 * Singleton class encapsulating a list of project model objects.
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 27. apr. 2019
 *
 */
public class ProjectList {
	@Inject
	private static IEventBroker eventBroker;

	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");
	private static List<ProjectModel> models;

	/**
	 * Exists only to defeat instantiation
	 */
	protected ProjectList() {
	}

	/**
	 * @param model
	 * @throws IOException
	 */
	public static int add(ProjectModel model) throws IOException {
		readPreferences();
		models.add(model);

		int count = store.getInt("projectcount");
		count++;

		store.setValue("project." + count + ".name", model.getName());
		final DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		store.setValue("project." + count + ".lastupdated",
				df.format(model.getLastEdited()));
		store.setValue("project." + count + ".summary", model.getSummary());
		store.setValue("project." + count + ".localserver",
				model.getLocalServer());
		store.setValue("project." + count + ".path", model.getPath());
		store.setValue("projectcount", count);
		((ScopedPreferenceStore) store).save();
		LOGGER.log(Level.INFO, "Added {0} as project {1}",
				new Object[] { model.getName(), count });
		return count;
	}

	/**
	 * @return
	 */
	public static List<ProjectModel> getAllModels() {
		readPreferences();
		return models;
	}

	/**
	 * @param index
	 * @return
	 */
	public static ProjectModel getModel(int index) {
		readPreferences();
		return models.get(index);
	}

	/**
	 * @param name
	 * @return
	 */
	public static ProjectModel getModel(String name) {
		readPreferences();

		for (final ProjectModel projectModel : models) {
			if (projectModel.getName().equals(name)) {
				return projectModel;
			}
		}
		return null;
	}

	/**
	 *
	 */
	private static void readPreferences() {
		String name;
		Date lastEdited;
		String summary;
		String localServer;
		String path;
		ProjectModel model;

		if (models == null) {
			models = new ArrayList<>();
		}

		final int projectCount = store.getInt("projectcount");

		try {
			for (int i = 1; i <= projectCount; i++) {
				name = store.getString("project." + i + ".name");

				final DateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				lastEdited = df.parse(
						store.getString("project." + i + ".lastupdated"));

				summary = store.getString("project." + i + ".summary");
				localServer = store.getString("project." + i + ".localserver");
				path = store.getString("project." + i + ".path");

				model = new ProjectModel(name, lastEdited, summary, localServer,
						path);
				models.add(model);
			}
		} catch (final ParseException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			eventBroker.post("MESSAGE", e.getMessage());
		}
	}

	/**
	 * Remove project from model and preferences
	 *
	 * @param index
	 * @param model
	 */
	public static void remove(int index) {
		final ProjectModel model = getModel(index);
		models.remove(model);

		int count = store.getInt("projectcount");

		for (int i = index; i < count; i++) {
			store.setValue("project." + i + ".name",
					store.getString("project." + (i + 1) + ".name"));
			store.setValue("project." + i + ".lastupdated",
					store.getString("project." + (i + 1) + ".lastupdated"));
			store.setValue("project." + i + ".summary",
					store.getString("project." + (i + 1) + ".summary"));
			store.setValue("project." + i + ".localserver",
					store.getString("project." + (i + 1) + ".localserver"));
			store.setValue("project." + i + ".path",
					store.getString("project." + (i + 1) + ".path"));
		}

		store.setToDefault("project." + count + ".name");
		store.setToDefault("project." + count + ".lastupdated");
		store.setToDefault("project." + count + ".summary");
		store.setToDefault("project." + count + ".localserver");
		store.setToDefault("project." + count + ".path");

		count--;
		store.setValue("projectcount", count);
		try {
			((ScopedPreferenceStore) store).save();
		} catch (final IOException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 * @return
	 */
	public static boolean verify() {
		for (final ProjectModel projectModel : models) {
			if (projectModel.getLocalServer().equalsIgnoreCase("LOCAL")) {
				final String path = projectModel.getPath();
				final File file = new File(path);
				if (!file.exists()) {
					LOGGER.log(Level.SEVERE, "File {0} does not exist",
							projectModel.getName());
					eventBroker.post("MESSAGE", "File " + projectModel.getName()
							+ " does not exist");
					return false;
				}
			}
		}
		return true;
	}

	/**
	 *
	 */
	public static void writePreferences() {
		String lastEditedString;

		final int projectCount = store.getInt("projectcount");

		LOGGER.log(Level.INFO, "Project preferences for {0} projects:\r\n",
				projectCount);

		try {
			for (int i = 1; i <= projectCount; i++) {
				LOGGER.log(Level.INFO, "Project {0}", i);
				LOGGER.log(Level.INFO, "project.{0}.name: {1}", new Object[] {
						i, store.getString("project.{0}.name") });

				lastEditedString = store
						.getString("project." + i + ".lastupdated");
				final DateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				LOGGER.log(Level.INFO, "project.{0}.lastEdited: {1}",
						new Object[] { i, df.parse(lastEditedString) });

				LOGGER.log(Level.INFO, "project.{0}.summary: {1}",
						new Object[] { i,
								store.getString("project." + i + ".summary") });
				LOGGER.log(Level.INFO, "project.{0}.localServer: {1}",
						new Object[] { i, store
								.getString("project." + i + ".localserver") });
				LOGGER.log(Level.INFO, "project.{0}.path: {1}\r\n",
						new Object[] { i,
								store.getString("project." + i + ".path") });

			}
		} catch (final ParseException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			eventBroker.post("MESSAGE", e.getMessage());
		}
	}
}