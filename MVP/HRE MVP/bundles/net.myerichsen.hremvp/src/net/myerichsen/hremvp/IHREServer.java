package net.myerichsen.hremvp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Interface defining the HRE business interface
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 * @version 24. apr. 2019
 *
 */
public interface IHREServer {
	/**
	 * Delete a row
	 *
	 * @param key The persistent id of the row
	 * @throws Exception
	 */
	void delete(int key) throws Exception;

	/**
	 * @param target
	 */
	void deleteRemote(String target);

	/**
	 * Get a row
	 *
	 * @param key The persistent id of the row
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 *
	 */
	void get(int key) throws Exception;

	/**
	 * @param request
	 * @param target
	 * @return
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	String getRemote(HttpServletRequest request, String target)
			throws Exception;

	/**
	 * Get a list of list of strings
	 *
	 * @return List A list of lists of strings
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 */
	List<List<String>> getStringList() throws Exception;

	/**
	 * Get a list of list of strings
	 *
	 * @param key The persistent id of the row
	 * @return List A list of lists of strings
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 */
	List<List<String>> getStringList(int key) throws Exception;

	/**
	 * Insert a row
	 *
	 * @return The Pid of the row
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	int insert() throws Exception;

	/**
	 * @param request
	 */
	void insertRemote(HttpServletRequest request);

	/**
	 * Update a row
	 *
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	void update() throws Exception;

	/**
	 * @param request
	 */
	void updateRemote(HttpServletRequest request);
}
