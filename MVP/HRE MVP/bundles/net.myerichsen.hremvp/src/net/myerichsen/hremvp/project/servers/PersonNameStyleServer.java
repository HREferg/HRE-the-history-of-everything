package net.myerichsen.hremvp.project.servers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONStringer;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.Dictionary;
import net.myerichsen.hremvp.dbmodels.PersonNameStyles;

/**
 * Business logic interface for
 * {@link net.myerichsen.hremvp.dbmodels.NameStyles}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 7. maj 2019
 *
 */
public class PersonNameStyleServer implements IHREServer {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private int NameStylePid;
	private String IsoCode;
	private int LabelPid;

	private final PersonNameStyles style;

	/**
	 * Constructor
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 *
	 */
	public PersonNameStyleServer() {
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
		style.delete(key);
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
	 * @return
	 * @throws Exception
	 */
	public List<PersonNameStyles> get() throws Exception {
		return style.get();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#get(int)
	 */
	@Override
	public void get(int key) throws Exception {
		style.get(key);
		setIsoCode(style.getIsoCode());
		setLabelPid(style.getLabelPid());
	}

	/**
	 * @return the isoCode
	 */
	public String getIsoCode() {
		return IsoCode;
	}

	/**
	 * @return the labelPid
	 */
	public int getLabelPid() {
		return LabelPid;
	}

	/**
	 * @return the nameStylePid
	 */
	public int getNameStylePid() {
		return NameStylePid;
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
		LOGGER.log(Level.FINE, "Target {0}", target);

		final String[] targetParts = target.split("/");
		final int targetSize = targetParts.length;

		final JSONStringer js = new JSONStringer();
		js.object();

		if (targetSize == 0) {
			js.key("languages");
			js.array();

			final List<List<String>> stringList = getStringList();

			for (final List<String> list : stringList) {
				js.object();
				js.key("pid");
				js.value(list.get(0));
				js.key("name");
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
			js.key("language");
			js.object();

			final List<String> stringList = getStringList(
					Integer.parseInt(targetParts[1])).get(0);

			js.key("pid");
			js.value(stringList.get(0));
			js.key("isocode");
			js.value(stringList.get(1));
			js.key("label");
			js.value(stringList.get(2));

			LOGGER.log(Level.FINE, "{0}", js);

			js.endObject();
		}

		js.endObject();
		return js.toString();

	}

	/**
	 * @return List A list of lists of style id, iso code and style name
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		final List<List<String>> lls = new ArrayList<>();
		List<String> stringList;
		final Dictionary dictionary = new Dictionary();

		final List<PersonNameStyles> list = get();

		for (final PersonNameStyles pns : list) {
			stringList = new ArrayList<>();
			stringList.add(Integer.toString(pns.getNameStylePid()));
			stringList.add(pns.getIsoCode());
			LabelPid = pns.getLabelPid();
			final List<Dictionary> fkLabelPid = dictionary
					.getFKLabelPid(LabelPid);
			stringList.add(fkLabelPid.get(0).getLabel());
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
		final List<List<String>> lls = new ArrayList<>();

		if (key == 0) {
			return lls;
		}

		List<String> stringList;
		final Dictionary dictionary = new Dictionary();

		style.get(key);
		stringList = new ArrayList<>();
		stringList.add(Integer.toString(style.getNameStylePid()));
		stringList.add(style.getIsoCode());
		LabelPid = style.getLabelPid();
		final List<Dictionary> fkLabelPid = dictionary.getFKLabelPid(LabelPid);
		stringList.add(fkLabelPid.get(0).getLabel());
		lls.add(stringList);
		return lls;

	}

	/**
	 * Insert a row
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 */
	@Override
	public int insert() throws Exception {
		style.setNameStylePid(NameStylePid);
		style.setIsoCode(IsoCode);
		style.setLabelPid(LabelPid);
		return style.insert();
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
	 * @param isoCode the isoCode to set
	 */
	public void setIsoCode(String isoCode) {
		IsoCode = isoCode;
	}

	/**
	 * @param labelPid the labelPid to set
	 */
	public void setLabelPid(int labelPid) {
		LabelPid = labelPid;
	}

	/**
	 * @param nameStylePid the nameStylePid to set
	 */
	public void setNameStylePid(int nameStylePid) {
		NameStylePid = nameStylePid;
	}

	/**
	 * Update a row
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 */
	@Override
	public void update() throws Exception {
		style.setNameStylePid(NameStylePid);
		style.setIsoCode(IsoCode);
		style.setLabelPid(LabelPid);
		style.update();
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
