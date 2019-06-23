package net.myerichsen.hremvp.person.servers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.Dictionary;
import net.myerichsen.hremvp.dbmodels.Hdates;
import net.myerichsen.hremvp.dbmodels.PersonNameMaps;
import net.myerichsen.hremvp.dbmodels.PersonNameParts;
import net.myerichsen.hremvp.dbmodels.PersonNameStyles;
import net.myerichsen.hremvp.dbmodels.PersonNames;

/**
 * Business logic interface for {@link net.myerichsen.hremvp.dbmodels.Names}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 23. apr. 2019
 *
 */
//Use LocalDate
public class PersonNameServer implements IHREServer {
	private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private int namePid;
	private int personPid;
	private int nameType;
	private String nameTypeLabel;
	private int fromDatePid;
	private int toDatePid;
	private boolean primaryName;
	private int nameStylePid;
	private List<List<String>> lls;

	private PersonNames name;

	/**
	 * Constructor
	 *
	 */
	public PersonNameServer() {
		name = new PersonNames();
		lls = new ArrayList<>();
	}

	/**
	 * Delete a row
	 *
	 * @param key The persistent ID of the row
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 *
	 */
	@Override
	public void delete(int key) throws Exception {
		final PersonNameParts part = new PersonNameParts();
		part.getFKNamePid(key);

		for (final PersonNameParts np : part.getFKNamePid(key)) {
			np.delete(np.getNamePartPid());
		}

		name.delete(key);
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
	 *
	 */
	@Override
	public void get(int key) throws Exception {
		final Dictionary dictionary = new Dictionary();

		name.get(key);
		setNamePid(key);
		setPersonPid(name.getPersonPid());
		setFromDatePid(name.getFromDatePid());
		setToDatePid(name.getToDatePid());
		setPrimaryName(name.isPrimaryName());
		setNameStylePid(name.getNameStylePid());

		final PersonNameStyles ns = new PersonNameStyles();
		ns.get(name.getNameStylePid());
		dictionary.get(ns.getLabelPid());
		setNameTypeLabel(dictionary.getLabel());

		PersonNameMaps map;
		PersonNameParts part;
		List<PersonNameMaps> mapList;
		List<PersonNameParts> partList;
		List<String> ls;

		lls.clear();

		map = new PersonNameMaps();
		mapList = map.getFKNameStylePid(name.getNameStylePid());

		part = new PersonNameParts();
		partList = part.getFKNamePid(key);

		for (int i = 0; i < partList.size(); i++) {
			ls = new ArrayList<>();
			ls.add(Integer.toString(partList.get(i).getNamePartPid()));
			dictionary.getFKLabelPid(mapList.get(i).getLabelPid());
			ls.add(dictionary.getLabel());
			lls.add(ls);
		}
	}

	/**
	 * @return the fromDate
	 */
	public int getFromDate() {
		return fromDatePid;
	}

	/**
	 * @return the stringList
	 */
	public List<List<String>> getNameList() {
		return lls;
	}

	/**
	 * @return the namePid
	 */
	public int getNamePid() {
		return namePid;
	}

	/**
	 * Get a string of name parts for each name
	 *
	 * @return sa An array of names
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 */
	public String[] getNameStrings() throws Exception {
		StringBuilder sb;

		personPid = name.getPersonPid();
		final List<PersonNames> nameList = new PersonNames()
				.getFKPersonPid(personPid);

		final String[] sa = new String[nameList.size()];

		for (int i = 0; i < nameList.size(); i++) {
			sb = new StringBuilder();
			name = nameList.get(i);
			LOGGER.log(Level.FINE, "Name " + name.getNamePid() + ", person "
					+ name.getPersonPid());
			final List<PersonNameParts> npl = new PersonNameParts()
					.getFKNamePid(name.getNamePid());

			LOGGER.log(Level.FINE, "List size {0}",
					Integer.toString(npl.size()));
			// Concatenate non-null name parts
			for (final PersonNameParts PersonNameParts : npl) {
				LOGGER.log(Level.FINE,
						"Name part " + PersonNameParts.getNamePartPid()
								+ ", name " + PersonNameParts.getNamePid());
				if ((PersonNameParts.getNamePid() == name.getNamePid())
						|| (PersonNameParts.getLabel() != null)) {
					sb.append(PersonNameParts.getLabel().trim() + " ");
					LOGGER.log(Level.FINE,
							"Part " + PersonNameParts.getLabel());
				}
			}
			sa[i] = sb.toString();
			LOGGER.log(Level.FINE, "SB {0}", sb);
		}

		return sa;

	}

	/**
	 * @return the nameStylePid
	 */
	public int getNameStylePid() {
		return nameStylePid;
	}

	/**
	 * @return the nameType
	 */
	public int getNameType() {
		return nameType;
	}

	/**
	 * @return the nameTypeLabel
	 */
	public String getNameTypeLabel() {
		return nameTypeLabel;
	}

	/**
	 * @return the personPid
	 */
	public int getPersonPid() {
		return personPid;
	}

	/**
	 * Get a string of the name parts for the primary name of a person
	 *
	 * @param personPid The persistent PID of the person
	 * @return s The name
	 * @throws Exception
	 */
	public String getPrimaryNameString(int personPid) throws Exception {
		final StringBuilder sb = new StringBuilder();

		final List<PersonNames> nameList = new PersonNames()
				.getFKPersonPid(personPid);

		for (int i = 0; i < nameList.size(); i++) {
			name = nameList.get(i);

			if (name.isPrimaryName()) {
				final List<PersonNameParts> npl = new PersonNameParts()
						.getFKNamePid(name.getNamePid());

				// Concatenate non-null name parts
				for (final PersonNameParts PersonNameParts : npl) {
					if ((PersonNameParts.getNamePid() == name.getNamePid())
							|| (PersonNameParts.getLabel() != null)) {
						sb.append(PersonNameParts.getLabel().trim() + " ");
					}
				}
				break;
			}
		}

		return sb.toString().trim();

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getRemote(javax.servlet.http.
	 * HttpServletrequest, java.lang.String)
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
	 * Get a list of all names for the person
	 *
	 * @param key
	 * @return
	 * @throws MvpException
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList(int key) throws Exception {
		final List<List<String>> personNameList = new ArrayList<>();
		List<String> stringList;

		if (key == 0) {
			stringList = new ArrayList<>();
			stringList.add("0");
			stringList.add("");
			stringList.add("");
			stringList.add("");
			stringList.add("false");
			personNameList.add(stringList);
			return personNameList;
		}

		final PersonNames aName = new PersonNames();
		StringBuilder sb;

		for (final PersonNames names : aName.getFKPersonPid(key)) {
			stringList = new ArrayList<>();

			namePid = names.getNamePid();
			stringList.add(Integer.toString(namePid));

			sb = new StringBuilder();
			final PersonNameParts part = new PersonNameParts();

			for (final PersonNameParts namePart : part.getFKNamePid(namePid)) {
				sb.append(namePart.getLabel() + " ");
			}
			stringList.add(sb.toString().trim());

			final Hdates date = new Hdates();

			int datePid = names.getFromDatePid();

			if (datePid == 0) {
				stringList.add("");
			} else {
				date.get(datePid);
				stringList.add(date.getDate().toString());
			}

			datePid = names.getToDatePid();

			if (datePid == 0) {
				stringList.add("");
			} else {
				date.get(datePid);
				stringList.add(date.getDate().toString());
			}

			stringList.add(Boolean.toString(aName.isPrimaryName()));

			personNameList.add(stringList);
		}

		return personNameList;
	}

	/**
	 * @return the toDatePid
	 */
	public int getToDate() {
		return toDatePid;
	}

	/**
	 * Insert a row
	 *
	 * @return
	 *
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public int insert() throws Exception {
		name.setPersonPid(personPid);
		name.setFromDatePid(fromDatePid);
		name.setToDatePid(toDatePid);
		name.setPrimaryName(primaryName);
		name.setNameStylePid(nameStylePid);
		return name.insert();
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
	 * @return the primaryName
	 */
	public boolean isPrimaryName() {
		return primaryName;
	}

	/**
	 * @param i the fromDate to set
	 */
	public void setFromDatePid(int i) {
		fromDatePid = i;
	}

	/**
	 * @param stringList the stringList to set
	 */
	public void setNameList(List<List<String>> nameList) {
		lls = nameList;
	}

	/**
	 * @param namePid the namePid to set
	 */
	public void setNamePid(int namePid) {
		this.namePid = namePid;
	}

	/**
	 * @param nameStylePid the nameStylePid to set
	 */
	public void setNameStylePid(int nameStylePid) {
		this.nameStylePid = nameStylePid;
	}

	/**
	 * @param nameType the nameType to set
	 */
	public void setNameType(int nameType) {
		this.nameType = nameType;
	}

	/**
	 * @param nameTypeLabel the nameTypeLabel to set
	 */
	public void setNameTypeLabel(String nameTypeLabel) {
		this.nameTypeLabel = nameTypeLabel;
	}

	/**
	 * @param personPid the personPid to set
	 */
	public void setPersonPid(int personPid) {
		this.personPid = personPid;
	}

	/**
	 * @param primaryName the primaryName to set
	 */
	public void setPrimaryName(boolean primaryName) {
		this.primaryName = primaryName;
	}

	/**
	 * @param data.toDatePid the toDatePid to set
	 */
	public void setToDatePid(int toDate) {
		toDatePid = toDate;
	}

	/**
	 * Update a row
	 *
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public void update() throws Exception {
		name.setNamePid(namePid);
		name.setPersonPid(personPid);
		name.setFromDatePid(fromDatePid);
		name.setToDatePid(toDatePid);
		name.setPrimaryName(primaryName);
		name.setNameStylePid(nameStylePid);
		name.update();
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
