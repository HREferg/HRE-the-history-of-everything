package net.myerichsen.hremvp.project.servers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.json.JSONStringer;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.Dictionary;
import net.myerichsen.hremvp.dbmodels.PartnerRoles;

/**
 * Business logic interface for {@link net.myerichsen.hremvp.dbmodels.Events}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 9. jun. 2019
 *
 */
public class PartnerRoleServer implements IHREServer {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private int PartnerRolePid;
	private String abbreviation;

	private final PartnerRoles PartnerRole;

	/**
	 * Constructor
	 *
	 */
	public PartnerRoleServer() {
		PartnerRole = new PartnerRoles();
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
		PartnerRole.delete(key);
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
	 * Get all rows
	 *
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public List<PartnerRoles> get() throws SQLException {
		return PartnerRole.get();
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
		PartnerRole.get(key);
		setEventRolePid(PartnerRole.getPartnerRolePid());
		setAbbreviation(PartnerRole.getAbbreviation());
	}

	/**
	 * @return
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @return the eventRolePid
	 */
	public int getEventRolePid() {
		return PartnerRolePid;
	}

	/**
	 * @return
	 */
	public int getLabelPid() {
		return PartnerRole.getLabelPid();
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
		LOGGER.log(Level.FINE, "Target {0}", target);

		final String[] targetParts = target.split("/");
		final int targetSize = targetParts.length;

		final JSONStringer js = new JSONStringer();
		js.object();

		if (targetSize == 0) {
			js.key("persons");
			js.array();

			final List<List<String>> stringList = getStringList();

			for (final List<String> list : stringList) {
				js.object();
				js.key("pid");
				js.value(list.get(0));
				js.key("abbreviation");
				js.value(list.get(2));
				js.key("endpoint");
				js.value(request.getRequestURL() + list.get(0));
				js.endObject();
			}

			js.endArray();
			js.endObject();
			return js.toString();
		}

		if (targetSize == 2) {
			js.key("person");
			js.object();

			final List<String> stringList = getStringList(
					Integer.parseInt(targetParts[1])).get(0);

			js.key("pid");
			js.value(stringList.get(0));
			js.key("isocode");
			js.value(stringList.get(2));
			js.key("label");
			js.value(stringList.get(3));

			LOGGER.log(Level.FINE, "{0}", js);

			js.endObject();
		}

		js.endObject();
		return js.toString();
	}

	/**
	 * @return stringList A list of lists of event Role pids, label pids,
	 *         abbreviations, and default language labels
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		List<String> stringList;
		List<Dictionary> fkLabelPid;
		String label = "";

		final IPreferenceStore store = new ScopedPreferenceStore(
				InstanceScope.INSTANCE, "net.myerichsen.hremvp");
		final String guiLanguage = store.getString("GUILANGUAGE");
		final List<List<String>> lls = new ArrayList<>();
		final Dictionary dictionary = new Dictionary();

		final List<PartnerRoles> list = PartnerRole.get();

		for (final PartnerRoles st : list) {
			stringList = new ArrayList<>();
			stringList.add(Integer.toString(st.getPartnerRolePid()));
			stringList.add(Integer.toString(st.getLabelPid()));
			stringList.add(st.getAbbreviation());

			fkLabelPid = dictionary.getFKLabelPid(st.getLabelPid());

			for (final Dictionary d : fkLabelPid) {
				if (guiLanguage.equals(d.getIsoCode())) {
					label = d.getLabel();
				}
			}

			stringList.add(label);
			lls.add(stringList);
		}
		return lls;
	}

	/**
	 * @param partnerRolePid
	 * @return stringList A list of lists of partner role pids, label pids, iso
	 *         codes and language specific labels for a partner role
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList(int partnerRolePid)
			throws Exception {
		final List<List<String>> lls = new ArrayList<>();

		if (partnerRolePid == 0) {
			return lls;
		}

		this.PartnerRolePid = partnerRolePid;

		List<String> stringList;

		final Dictionary dictionary = new Dictionary();

		PartnerRoles aPartnerRole = new PartnerRoles();
		aPartnerRole.get(partnerRolePid);

		for (final Dictionary d : dictionary
				.getFKLabelPid(aPartnerRole.getLabelPid())) {
			stringList = new ArrayList<>();

			// Partner role pid
			stringList.add(Integer.toString(partnerRolePid));

			// Dictionary label pid
			stringList.add(Integer.toString(aPartnerRole.getLabelPid()));

			// Iso code
			stringList.add(d.getIsoCode());

			// Language specific label
			stringList.add(d.getLabel());

			lls.add(stringList);
		}
		return lls;

	}

	/**
	 * Insert a row
	 *
	 * @return int The persistent ID of the inserted row
	 *
	 * @throws Exception    An exception that provides information on a database
	 *                      access error or other errors
	 * @throws MvpException Application specific exception
	 */
	@Override
	public int insert() throws Exception {
		PartnerRole.setAbbreviation(abbreviation);
		final Dictionary dictionary = new Dictionary();
		PartnerRole.setLabelPid(dictionary.getNextLabelPid());
		return PartnerRole.insert();
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
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * @param eventRolePid the eventRolePid to set
	 */
	public void setEventRolePid(int eventRolePid) {
		PartnerRolePid = eventRolePid;
	}

	/**
	 * @param labelPid the labelPid to set
	 */
	public void setLabelPid(int labelPid) {
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
		PartnerRole.setPartnerRolePid(PartnerRolePid);
		PartnerRole.update();
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
