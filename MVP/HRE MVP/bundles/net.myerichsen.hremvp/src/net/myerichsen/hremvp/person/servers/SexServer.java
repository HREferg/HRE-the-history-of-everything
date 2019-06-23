package net.myerichsen.hremvp.person.servers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.Dictionary;
import net.myerichsen.hremvp.dbmodels.Hdates;
import net.myerichsen.hremvp.dbmodels.SexTypes;
import net.myerichsen.hremvp.dbmodels.Sexes;

/**
 * Business logic interface for {@link net.myerichsen.hremvp.dbmodels.Sexes}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 23. apr. 2019
 *
 */
public class SexServer implements IHREServer {
	private static IPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "net.myerichsen.hremvp");

	private int sexesPid;
	private int personPid;
	private int sexTypePid;
	private int fromDatePid;
	private int toDatePid;
	private boolean primarySex;
	private String sexTypeLabel;
	private String abbreviation;
	private int languagePid;
	private String isocode;

	private final Sexes sex;
	private final SexTypes sexType;
	private Dictionary dictionary;

	/**
	 * Constructor
	 *
	 */
	public SexServer() {
		sex = new Sexes();
		sexType = new SexTypes();
		dictionary = new Dictionary();
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
		sex.delete(key);
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
		sex.get(key);
		setSexesPid(sex.getSexesPid());
		setPersonPid(sex.getPersonPid());
		setSexTypePid(sex.getSexTypePid());
		setPrimarySex(sex.isPrimarySex());
		setFromDatePid(sex.getFromDatePid());
		setToDatePid(sex.getToDatePid());
		sexType.get(sex.getSexTypePid());
		setAbbreviation(sexType.getAbbreviation());
		final int labelPid = sexType.getLabelPid();
		final List<Dictionary> fkLabelPid = new Dictionary()
				.getFKLabelPid(labelPid);
		dictionary = fkLabelPid.get(0);

		setSexTypeLabel(dictionary.getLabel());
		setIsocode(dictionary.getIsoCode());
	}

	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @return the fromDatePid
	 */
	public int getFromDatePid() {
		return fromDatePid;
	}

//	/**
//	 * @return the languageLabel
//	 */
//	public String getLanguageLabel() {
//		return languageLabel;
//	}

	/**
	 * @return the isocode
	 */
	public String getIsocode() {
		return isocode;
	}

	/**
	 * @return the languagePid
	 */
	public int getLanguagePid() {
		return languagePid;
	}

	/**
	 * @return the personPid
	 */
	public int getPersonPid() {
		return personPid;
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

	/**
	 * @return the sexesPid
	 */
	public int getSexesPid() {
		return sexesPid;
	}

	/**
	 * @return the sexTypeLabel
	 */
	public String getSexTypeLabel() {
		return sexTypeLabel;
	}

	/**
	 * @return the sexTypePid
	 */
	public int getSexTypePid() {
		return sexTypePid;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getStringList()
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getStringList(int)
	 */
	@Override
	public List<List<String>> getStringList(int key) throws Exception {
		int datePid;
		List<String> ls;
		String s;

		final SexTypes st = new SexTypes();
		final Hdates hdates = new Hdates();
		final List<List<String>> sexesList = new ArrayList<>();

		if (key == 0) {
			return sexesList;
		}

		for (final Sexes aSex : new Sexes().getFKPersonPid(key)) {
			ls = new ArrayList<>();
			ls.add(Integer.toString(aSex.getSexesPid()));
			ls.add(Integer.toString(aSex.getPersonPid()));
			sexTypePid = aSex.getSexTypePid();
			ls.add(Integer.toString(sexTypePid));

			st.get(sexTypePid);
			final List<Dictionary> fkLabelPid = dictionary
					.getFKLabelPid(st.getLabelPid());

			final String isoCode = store.getString("GUILANGUAGE");
			String label = "";

			for (final Dictionary d : fkLabelPid) {
				if (isoCode.equals(d.getIsoCode())) {
					label = d.getLabel();
					break;
				}
			}

			ls.add(label);

			ls.add(Boolean.toString(aSex.isPrimarySex()));
			s = "";
			datePid = aSex.getFromDatePid();
			if (datePid > 0) {
				hdates.get(datePid);
				s = hdates.getDate().toString();
			}
			ls.add(s);

			s = "";
			datePid = aSex.getToDatePid();
			if (datePid > 0) {

				hdates.get(datePid);
				s = hdates.getDate().toString();
			}
			ls.add(s);

			sexesList.add(ls);
		}

		return sexesList;
	}

	/**
	 * @return the toDatePid
	 */
	public int getToDatePid() {
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
		sex.setSexesPid(sexesPid);
		sex.setPersonPid(personPid);
		sex.setSexTypePid(sexTypePid);
		sex.setFromDatePid(fromDatePid);
		sex.setToDatePid(toDatePid);
		sex.setPrimarySex(primarySex);
		return sex.insert();
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
	 * @return the primarySex
	 */
	public boolean isPrimarySex() {
		return primarySex;
	}

//	/**
//	 * @param languageLabel the languageLabel to set
//	 */
//	public void setLanguageLabel(String languageLabel) {
//		this.languageLabel = languageLabel;
//	}

	/**
	 * @param sexPid
	 * @throws Exception
	 * @throws MvpException
	 */
	public void removeSex(int sexPid) throws Exception {
		sex.delete(sexPid);
	}

	/**
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * @param data.fromDatePid the fromDatePid to set
	 */
	public void setFromDatePid(int fromdate) {
		fromDatePid = fromdate;
	}

	/**
	 * @param isocode the isocode to set
	 */
	public void setIsocode(String isocode) {
		this.isocode = isocode;
	}

	/**
	 * @param languagePid the languagePid to set
	 */
	public void setLanguagePid(int languagePid) {
		this.languagePid = languagePid;
	}

	/**
	 * @param personPid the personPid to set
	 */
	public void setPersonPid(int personPid) {
		this.personPid = personPid;
	}

	/**
	 * @param primarySex the primarySex to set
	 */
	public void setPrimarySex(boolean primarySex) {
		this.primarySex = primarySex;
	}

	/**
	 * @param sexesPid the sexesPid to set
	 */
	public void setSexesPid(int sexesPid) {
		this.sexesPid = sexesPid;
	}

	/**
	 * @param sexTypeLabel the sexTypeLabel to set
	 */
	public void setSexTypeLabel(String sexTypeLabel) {
		this.sexTypeLabel = sexTypeLabel;
	}

	/**
	 * @param sexTypePid the sexTypePid to set
	 */
	public void setSexTypePid(int sexTypePid) {
		this.sexTypePid = sexTypePid;
	}

	/**
	 * @param data.toDatePid the toDatePid to set
	 */
	public void setToDatePid(int todate) {
		toDatePid = todate;
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
		sex.setSexesPid(sexesPid);
		sex.setPersonPid(personPid);
		sex.setSexTypePid(sexTypePid);
		sex.setFromDatePid(fromDatePid);
		sex.setToDatePid(toDatePid);
		sex.setPrimarySex(primarySex);
		sex.update();
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
