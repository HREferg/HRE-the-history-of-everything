package net.myerichsen.hremvp.project.models;

import java.util.Date;

/**
 * Model object encapsulating properties of a project.
 *
 * @version 2018-06-11
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 *
 */
public class ProjectModel {
	private String name;
	private Date lastEdited;
	private String summary;
	private String localServer;
	private String path;

	/**
	 * Constructor
	 *
	 * @param name
	 * @param lastEdited
	 * @param summary
	 * @param localServer
	 * @param path
	 */
	public ProjectModel(String name, Date lastEdited, String summary,
			String localServer, String path) {
		super();
		this.name = name;
		this.lastEdited = lastEdited;
		this.summary = summary;
		this.localServer = localServer;
		this.path = path;
	}

	/**
	 * @return the lastEdited
	 */
	public Date getLastEdited() {
		return lastEdited;
	}

	/**
	 * @return the localServer
	 */
	public String getLocalServer() {
		return localServer;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param lastEdited the lastEdited to set
	 */
	public void setLastEdited(Date lastEdited) {
		this.lastEdited = lastEdited;
	}

	/**
	 * @param localServer the localServer to set
	 */
	public void setLocalServer(String localServer) {
		this.localServer = localServer;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
}