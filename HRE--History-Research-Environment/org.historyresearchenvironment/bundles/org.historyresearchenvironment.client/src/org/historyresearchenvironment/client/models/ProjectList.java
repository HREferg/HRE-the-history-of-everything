package org.historyresearchenvironment.client.models;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.osgi.service.prefs.BackingStoreException;

/**
 * Singleton class encapsulating a list of project model objects.
 * 
 * @version 2018-07-23
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class ProjectList {
	@Inject
	private static IEventBroker eventBroker;

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.historyresearchenvironment");
	private static List<ProjectModel> models;

	/**
	 * @param model
	 */
	public static void add(ProjectModel model) {
		try {
			readPreferences();
			models.add(model);

			int count = preferences.getInt("projectcount", 1);

			preferences.put("project." + count + ".name", model.getName());
			final DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			preferences.put("project." + count + ".lastupdated", df.format(model.getLastEdited()));
			preferences.put("project." + count + ".summary", model.getSummary());
			preferences.put("project." + count + ".localserver", model.getLocalServer());
			preferences.put("project." + count + ".path", model.getPath());
			count++;
			preferences.putInt("projectcount", count);
			preferences.flush();
		} catch (final BackingStoreException e) {
			LOGGER.severe(e.getMessage());
			eventBroker.post("MESSAGE", e.getMessage());
		}
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
		String key;
		String lastEditedString;
		String name;
		Date lastEdited;
		String summary;
		String localServer;
		String path;
		ProjectModel model;

		if (models == null) {
			models = new ArrayList<ProjectModel>();
		}

		final int projectCount = preferences.getInt("projectcount", 1);

		try {
			for (int i = 0; i < projectCount; i++) {
				key = new String("project." + i + ".name");
				name = preferences.get(key, "?");

				key = new String("project." + i + ".lastupdated");
				lastEditedString = preferences.get(key, "?");
				final DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				lastEdited = df.parse(lastEditedString);

				key = new String("project." + i + ".summary");
				summary = preferences.get(key, "?");

				key = new String("project." + i + ".localserver");
				localServer = preferences.get(key, "?");

				key = new String("project." + i + ".path");
				path = preferences.get(key, "?");

				model = new ProjectModel(name, lastEdited, summary, localServer, path);
				models.add(model);
			}
		} catch (final ParseException e) {
			LOGGER.severe(e.getMessage());
			eventBroker.post("MESSAGE", e.getMessage());
		}
	}

	/**
	 * @param model
	 */
	public static void remove(ProjectModel model) {
		try {
			readPreferences();
			models.remove(model);
			preferences.flush();
		} catch (final BackingStoreException e) {
			LOGGER.severe(e.getMessage());
			eventBroker.post("MESSAGE", e.getMessage());
		}
	}

	public static boolean verify() {
		for (final ProjectModel projectModel : models) {
			if (projectModel.getLocalServer().equalsIgnoreCase("LOCAL")) {
				final String path = projectModel.getPath();
				final File file = new File(path);
				if (file.exists() == false) {
					LOGGER.severe("File " + projectModel.getName() + " does not exist");
					eventBroker.post("MESSAGE", "File " + projectModel.getName() + " does not exist");
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Exists only to defeat instantiation
	 */
	protected ProjectList() {
	}
}
