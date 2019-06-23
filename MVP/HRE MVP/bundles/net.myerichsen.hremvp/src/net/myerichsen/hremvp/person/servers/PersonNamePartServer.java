package net.myerichsen.hremvp.person.servers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.Dictionary;
import net.myerichsen.hremvp.dbmodels.PersonNameMaps;
import net.myerichsen.hremvp.dbmodels.PersonNameParts;
import net.myerichsen.hremvp.dbmodels.PersonNames;

/**
 * Business logic interface for
 * {@link net.myerichsen.hremvp.dbmodels.PersonNameParts}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 12. apr. 2019
 */
public class PersonNamePartServer implements IHREServer {
	private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private int namePartPid;
	private int namePid;
	private String name;
	private String mapLabel;
	private String label;
	private int partNo;

	private final PersonNameParts part;

	/**
	 * Constructor
	 *
	 */
	public PersonNamePartServer() {
		part = new PersonNameParts();
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
		part.delete(key);
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
		Dictionary dictionary;

		part.get(key);
		setLabel(part.getLabel());
		setNamePartPid(part.getNamePartPid());
		setNamePid(part.getNamePid());
		setPartNo(part.getPartNo());

		// Get name
		final StringBuilder sb = new StringBuilder();
		final List<PersonNameParts> partList = new PersonNameParts()
				.getFKNamePid(namePid);

		for (final PersonNameParts PersonNameParts : partList) {
			if ((PersonNameParts.getNamePid() == namePid)
					|| (PersonNameParts.getLabel() != null)) {
				sb.append(PersonNameParts.getLabel() + " ");
			}
		}

		setName(sb.toString().trim());

		// Get map label
		setMapLabel("Label");
		final PersonNames pn = new PersonNames();
		pn.get(namePid);

		final PersonNameMaps map = new PersonNameMaps();
		final List<PersonNameMaps> mapList = map
				.getFKNameStylePid(pn.getNameStylePid());

		if (mapList.size() != partList.size()) {
			throw new MvpException("Map list size: " + mapList.size()
					+ ", part list size: " + partList.size());
		}

		for (int i = 0; i < mapList.size(); i++) {
			if (mapList.get(i).getPartNo() == partNo) {
				dictionary = new Dictionary();
				dictionary.getFKLabelPid(mapList.get(i).getLabelPid());
				setMapLabel(dictionary.getLabel());
				break;
			}
		}
	}

	/**
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public List<PersonNameParts> getFKNamePid(int key) throws Exception {
		return part.getFKNamePid(key);
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return the mapLabel
	 */
	public String getMapLabel() {
		return mapLabel;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the namePartPid
	 */
	public int getNamePartPid() {
		return namePartPid;
	}

	/**
	 * @return the namePid
	 */
	public int getNamePid() {
		return namePid;
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
		List<String> stringList;
		final List<List<String>> lls = new ArrayList<>();

		final Dictionary dictionary = new Dictionary();
		final PersonNames pn = new PersonNames();
		pn.get();

		int labelPid = 0;

		final PersonNameMaps map = new PersonNameMaps();
		List<PersonNameMaps> mapList;

		final List<PersonNameParts> list = part.get();
		PersonNameParts pnp;

		for (int i = 0; i < list.size(); i++) {
			pnp = list.get(i);
			stringList = new ArrayList<>();
			stringList.add(Integer.toString(pnp.getNamePartPid()));
			LOGGER.log(Level.FINE, "Name part pid: {0}", stringList.get(0));

			partNo = pnp.getPartNo();
			LOGGER.log(Level.FINE, "Part no: {0}", Integer.toString(partNo));

			pn.get(pnp.getNamePid());
			LOGGER.log(Level.FINE, "Name pid: {0}",
					Integer.toString(pnp.getNamePid()));
			mapList = map.getFKNameStylePid(pn.getNameStylePid());
			LOGGER.log(Level.FINE, "Map list size: {0}",
					Integer.toString(mapList.size()));

			for (int j = 0; j < mapList.size(); j++) {
				if (mapList.get(j).getPartNo() == partNo) {
					labelPid = mapList.get(j).getLabelPid();
					mapLabel = dictionary.getFKLabelPid(labelPid).get(0)
							.getLabel();
					break;
				}
			}

			stringList.add(mapLabel);
			LOGGER.log(Level.FINE, "Map label: {0}", stringList.get(1));
			stringList.add(pnp.getLabel());
			LOGGER.log(Level.FINE, "Name part label: {0}", stringList.get(2));
			lls.add(stringList);
		}

		return lls;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getStringList(int)
	 */
	@Override
	public List<List<String>> getStringList(int key) throws Exception {
		List<String> stringList;
		final List<List<String>> lls = new ArrayList<>();

		if (key == 0) {
			return lls;
		}

		final Dictionary dictionary = new Dictionary();
		final PersonNames pn = new PersonNames();
		pn.get(key);

		int labelPid = 0;
		List<Dictionary> fkLabelPid;

		final List<PersonNameMaps> lnm = new PersonNameMaps()
				.getFKNameStylePid(pn.getNameStylePid());

		final List<PersonNameParts> lnp = part.getFKNamePid(key);

		for (int i = 0; i < lnp.size(); i++) {
			stringList = new ArrayList<>();
			stringList.add(Integer.toString(lnp.get(i).getNamePartPid()));
			stringList.add(Integer.toString(lnp.get(i).getPartNo()));

			labelPid = lnm.get(i).getLabelPid();
			fkLabelPid = dictionary.getFKLabelPid(labelPid);
			stringList.add(fkLabelPid.get(0).getLabel());
			stringList.add(lnp.get(i).getLabel());
			lls.add(stringList);
		}

		return lls;

	}

	/**
	 * Insert a row. Checks if a matching part number exists in
	 * {@link net.myerichsen.hremvp.dbmodels.PersonNameMaps}
	 *
	 * @return
	 *
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public int insert() throws Exception {
		part.setLabel(label);
		part.setNamePartPid(namePartPid);
		part.setNamePid(namePid);
		part.setPartNo(partNo);

		// Check if matching map part no exists
		final PersonNames pn = new PersonNames();
		pn.get(namePid);

//		final PersonNameMaps map = new PersonNameMaps();
//		final List<PersonNameMaps> mapList = map.getFKNameStylePid(name.getNameStylePid());
//		Boolean found = false;
//
//		for (int i = 0; i < mapList.size(); i++) {
//			if (mapList.get(i).getPartNo() == partNo) {
//				found = true;
//				break;
//			}
//		}
//
//		if (!found) {
//			throw new MvpException("Part number " + partNo + " does not exist in matching name map");
//		}

		return part.insert();
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
	 * @param mapLabel the mapLabel to set
	 */
	public void setMapLabel(String mapLabel) {
		this.mapLabel = mapLabel;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param namePartPid the namePartPid to set
	 */
	public void setNamePartPid(int namePartPid) {
		this.namePartPid = namePartPid;
	}

	/**
	 * @param namePid the namePid to set
	 */
	public void setNamePid(int namePid) {
		this.namePid = namePid;
	}

	/**
	 * @param partNo the partNo to set
	 */
	public void setPartNo(int partNo) {
		this.partNo = partNo;
	}

	/**
	 * Update a row. Checks if a matching part number exists in
	 * {@link net.myerichsen.hremvp.dbmodels.PersonNameMaps}
	 *
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public void update() throws Exception {
		part.setLabel(label);
		part.setNamePartPid(namePartPid);
		part.setNamePid(namePid);
		part.setPartNo(partNo);

		// Check if matching map part no exists
		final PersonNames pn = new PersonNames();
		pn.get(namePid);

		final PersonNameMaps map = new PersonNameMaps();
		final List<PersonNameMaps> mapList = map
				.getFKNameStylePid(pn.getNameStylePid());
		Boolean found = false;

		for (int i = 0; i < mapList.size(); i++) {
			if (mapList.get(i).getPartNo() == partNo) {
				found = true;
				break;
			}
		}

		if (!found) {
			throw new MvpException("Part number " + partNo
					+ " does not exist in matching name map");
		}
		part.update();
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