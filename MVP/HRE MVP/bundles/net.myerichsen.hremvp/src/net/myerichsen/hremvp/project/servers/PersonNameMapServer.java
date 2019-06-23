package net.myerichsen.hremvp.project.servers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.Dictionary;
import net.myerichsen.hremvp.dbmodels.PersonNameMaps;
import net.myerichsen.hremvp.dbmodels.PersonNameStyles;

/**
 * Business logic interface for
 * {@link net.myerichsen.hremvp.dbmodels.PersonNameMaps}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 7. maj 2019
 */
public class PersonNameMapServer implements IHREServer {
	// private static Logger LOGGER =
	// Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private int nameMapPid;
	private String label;
	private int partNo;
	private int nameStylePid;
	private String styleLabel;

	private final PersonNameMaps map;
	private final PersonNameStyles style;

	/**
	 * Constructor
	 *
	 */
	public PersonNameMapServer() {
		map = new PersonNameMaps();
		style = new PersonNameStyles();
	}

	/**
	 * Delete a row
	 *
	 * @param key The persistent ID of the row
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public void delete(int key) throws Exception {
		map.delete(key);
	}

	/**
	 * @param personNameStylePid
	 * @throws MvpException
	 * @throws Exception
	 */
	public void deletePersonNameStylePid(int personNameStylePid)
			throws Exception {
		final List<PersonNameMaps> fkNameStylePid = map
				.getFKNameStylePid(personNameStylePid);

		for (final PersonNameMaps personNameMaps : fkNameStylePid) {
			delete(personNameMaps.getNameMapPid());
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#deleteRemote(java.lang.String)
	 */
	@Override
	public void deleteRemote(String target) {
		// TODO Auto-generated method stub

	}

	/**
	 * Get a row
	 *
	 * @param key The persistent id of the row
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public void get(int key) throws Exception {
		map.get(key);
		setLabel("map.getLabelPid()");
		setNameMapPid(map.getNameMapPid());
		setNameStylePid(map.getNameStylePid());
		setPartNo(map.getPartNo());

		style.get(getNameStylePid());
		setStyleLabel("style.getLabelPid()");
	}

	/**
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public List<PersonNameMaps> getFKNameStylePid(int key) throws Exception {
		return map.getFKNameStylePid(key);
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return the nameMapPid
	 */
	public int getNameMapPid() {
		return nameMapPid;
	}

	/**
	 * @return the nameStylePid
	 */
	public int getNameStylePid() {
		return nameStylePid;
	}

	/**
	 * @return the partNo
	 */
	public int getPartNo() {
		return partNo;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getRemote(javax.servlet.http.
	 * HttpServletResponse, java.lang.String)
	 */
	@Override
	public String getRemote(HttpServletRequest request, String target)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getStringList()
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		return new ArrayList<>();
	}

	/**
	 * @param key
	 * @return List A list of lists of name map pid, label pid, part no, label,
	 *         dictionary pid and a blank
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList(int key) throws Exception {
		final List<List<String>> lls = new ArrayList<>();

		if (key == 0) {
			return lls;
		}

		List<String> stringList;

		final List<PersonNameMaps> fkNameStylePid = map.getFKNameStylePid(key);

		for (final PersonNameMaps personNameMaps : fkNameStylePid) {
			stringList = new ArrayList<>();
			stringList.add(Integer.toString(personNameMaps.getNameMapPid()));
			final int labelPid = personNameMaps.getLabelPid();
			stringList.add(Integer.toString(labelPid));
			stringList.add(Integer.toString(personNameMaps.getPartNo()));

			final Dictionary dictionary = new Dictionary();
			final List<Dictionary> fkLabelPid = dictionary
					.getFKLabelPid(labelPid);
			stringList.add(fkLabelPid.get(0).getLabel());
			stringList.add(
					Integer.toString(fkLabelPid.get(0).getDictionaryPid()));
			stringList.add("");
			lls.add(stringList);
		}

		return lls;
	}

	/**
	 * @return the styleLabel
	 */
	public String getStyleLabel() {
		return styleLabel;
	}

	/**
	 * Insert a row
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors.
	 *
	 */
	@Override
	public int insert() throws Exception {
		map.setLabelPid(0);
		map.setNameMapPid(nameMapPid);
		map.setNameStylePid(nameStylePid);
		map.setPartNo(partNo);
		return map.insert();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#insertRemote(javax.servlet.http.
	 * HttpServletRequest)
	 */
	@Override
	public void insertRemote(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @param nameMapPid the nameMapPid to set
	 */
	public void setNameMapPid(int nameMapPid) {
		this.nameMapPid = nameMapPid;
	}

	/**
	 * @param nameStylePid the nameStylePid to set
	 */
	public void setNameStylePid(int nameStylePid) {
		this.nameStylePid = nameStylePid;
	}

	/**
	 * @param partNo the partNo to set
	 */
	public void setPartNo(int partNo) {
		this.partNo = partNo;
	}

	/**
	 * @param styleLabel the styleLabel to set
	 */
	public void setStyleLabel(String styleLabel) {
		this.styleLabel = styleLabel;
	}

	/**
	 * Update a row
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors.
	 *
	 */
	@Override
	public void update() throws Exception {
		map.setLabelPid(0);
		map.setNameMapPid(nameMapPid);
		map.setNameStylePid(nameStylePid);
		map.setPartNo(partNo);
		map.update();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#updateRemote(javax.servlet.http.
	 * HttpServletRequest)
	 */
	@Override
	public void updateRemote(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

}
