package net.myerichsen.hremvp.project.servers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.json.JSONException;
import org.json.JSONStringer;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.Dictionary;
import net.myerichsen.hremvp.dbmodels.Languages;
import net.myerichsen.hremvp.dbmodels.SexTypes;

/**
 * Business logic interface for {@link net.myerichsen.hremvp.dbmodels.SexTypes}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 27. apr. 2019
 *
 */
public class SexTypeServer implements IHREServer {
	private static final Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	final IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");

	private int sexTypePid;
	private String abbreviation;
	private String label;
	private int languagePid;
	private String languageLabel;
	private final SexTypes sexType;

	/**
	 * Constructor
	 *
	 */
	public SexTypeServer() {
		sexType = new SexTypes();
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
		sexType.delete(key);
	}

	/**
	 * @param target The request target
	 * @throws MvpException Application specific exception
	 */
	@Override
	public void deleteRemote(String target) {
//		final String[] targetParts = target.split("/");
//		final int targetSize = targetParts.length;
//		delete(Integer.parseInt(targetParts[targetSize - 1]));
	}

	/**
	 * Get all rows
	 *
	 * @return
	 * @throws Exception
	 */
	public List<SexTypes> get() throws Exception {
		return sexType.get();
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
		sexType.get(key);
		setSexTypePid(sexType.getSexTypePid());
		setAbbreviation(sexType.getAbbreviation());
	}

	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return the labelPid
	 */
	public int getLabelPid() {
		return sexType.getLabelPid();
	}

	/**
	 * @return the languageLabel
	 */
	public String getLanguageLabel() {
		return languageLabel;
	}

	/**
	 * @return the languagePid
	 */
	public int getLanguagePid() {
		return languagePid;
	}

	/**
	 * Get a row remotely
	 *
	 * @param response Response
	 * @param target   Target
	 * @return js JSON String
	 * @throws Exception Any exception
	 *
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
			js.key("sextypes");
			js.array();

			final List<List<String>> stringList = getStringList();

			for (final List<String> list : stringList) {
				js.object();
				js.key("pid");
				js.value(list.get(0));
				js.key("abbreviation");
				js.value(list.get(2));
				js.key("label");
				js.value(list.get(3));
				js.key("endpoint");
				js.value(request.getRequestURL() + list.get(0));
				js.endObject();
			}

			js.endArray();
			js.endObject();
			return js.toString();
		}

		if (targetSize == 2) {
			js.key("sextype");
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
	 * @return the sexTypePid
	 */
	public int getSexTypePid() {
		return sexTypePid;
	}

	/**
	 * @return stringList A list of lists of pids, abbreviations and generic
	 *         labels
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		List<String> stringList;
		List<Dictionary> fkLabelPid;

		final String guiLanguage = store.getString("GUILANGUAGE");
		final List<List<String>> lls = new ArrayList<>();
		final Dictionary dictionary = new Dictionary();

		final List<SexTypes> list = sexType.get();

		for (final SexTypes st : list) {
			stringList = new ArrayList<>();
			stringList.add(Integer.toString(st.getSexTypePid()));
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
	 * @param labelPid
	 * @param abbreviation
	 * @return stringList A list of lists of sex type pids, label pids, iso
	 *         codes and generic labels
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList(int labelPid) throws Exception {
		final List<List<String>> lls = new ArrayList<>();

		if (labelPid == 0) {
			return lls;
		}

		String sexTypePidString = "1";
		final List<SexTypes> list = sexType.get();

		for (final SexTypes sexTypes : list) {
			if (sexTypes.getLabelPid() == labelPid) {
				sexTypePidString = Integer.toString(sexTypes.getSexTypePid());
			}
		}

		List<String> stringList;

		final Dictionary dictionary = new Dictionary();
		final List<Dictionary> fkLabelPid = dictionary.getFKLabelPid(labelPid);

		final Languages language = new Languages();

		for (final Languages l : language.get()) {
			stringList = new ArrayList<>();
			stringList.add(sexTypePidString);
			stringList.add(Integer.toString(labelPid));
			stringList.add(l.getIsocode());

			for (final Dictionary d : fkLabelPid) {
				if (l.getIsocode().equals(d.getIsoCode())) {
					label = d.getLabel();
					break;
				}
			}

			stringList.add(label);
			lls.add(stringList);
		}
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
		sexType.setAbbreviation(abbreviation);
		final Dictionary dictionary = new Dictionary();
		sexType.setLabelPid(dictionary.getNextLabelPid());
		return sexType.insert();
	}

	/**
	 * Insert a row remotely
	 *
	 * @param request HttpServletRequest
	 * @throws IOException   IOException
	 * @throws JSONException JSONException
	 */
	@Override
	public void insertRemote(HttpServletRequest request) {
//		final StringBuilder sb = new StringBuilder();
//		String s = "";
//		final BufferedReader br = request.getReader();
//
//		while (null != (s = br.readLine())) {
//			sb.append(s);
//		}
//
//		br.close();
//
//		final JSONObject jsonObject = new JSONObject(sb.toString());
//
//		LOGGER.log(Level.INFO, "{0}", jsonObject.toString(2));
//
//		setSexTypePid(jsonObject.getInt("sexTypePid"));
//		setAbbreviation(jsonObject.getString("abbreviation"));
//		setLabel(jsonObject.getString("label"));
//		setLanguagePid(jsonObject.getInt("languagePid"));
//		insert();
	}

	/**
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @param languageLabel the languageLabel to set
	 */
	public void setLanguageLabel(String languageLabel) {
		this.languageLabel = languageLabel;
	}

	/**
	 * @param languagePid the languagePid to set
	 */
	public void setLanguagePid(int languagePid) {
		this.languagePid = languagePid;
	}

	/**
	 * @param sexTypePid the sexTypePid to set
	 */
	public void setSexTypePid(int sexTypePid) {
		this.sexTypePid = sexTypePid;
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
		sexType.setSexTypePid(sexTypePid);
		sexType.setAbbreviation(abbreviation);
		sexType.update();
	}

	/**
	 * Update a row
	 *
	 * @param request HttpServletRequest
	 * @throws IOException   IOException
	 * @throws JSONException JSONException
	 * @throws MvpException  Application specific exception
	 */
	@Override
	public void updateRemote(HttpServletRequest request) {
//		final StringBuilder sb = new StringBuilder();
//		String s = "";
//		final BufferedReader br = request.getReader();
//
//		while (null != (s = br.readLine())) {
//			sb.append(s);
//		}
//
//		br.close();
//
//		final JSONObject jsonObject = new JSONObject(sb.toString());
//
//		LOGGER.log(Level.INFO, "{0}", jsonObject.toString(2));
//
//		setSexTypePid(jsonObject.getInt("sexTypePid"));
//		setAbbreviation(jsonObject.getString("abbreviation"));
//		setLabel(jsonObject.getString("label"));
//		setLanguagePid(jsonObject.getInt("languagePid"));
//		update();
	}
}
