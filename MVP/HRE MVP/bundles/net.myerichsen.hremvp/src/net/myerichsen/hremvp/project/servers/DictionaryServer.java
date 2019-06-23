package net.myerichsen.hremvp.project.servers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.Dictionary;

/**
 * Business logic interface for
 * {@link net.myerichsen.hremvp.dbmodels.Dictionary}
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 7. maj 2019
 *
 */
public class DictionaryServer implements IHREServer {
	private int DictionaryPid;
	private int LabelPid;
	private String IsoCode;
	private String Label;
	private String LabelType;

	private final Dictionary dictionary;

	/**
	 * Constructor
	 *
	 */
	public DictionaryServer() {
		dictionary = new Dictionary();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#delete(int)
	 */
	@Override
	public void delete(int key) throws Exception {
		dictionary.delete(key);
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

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#get(int)
	 */
	@Override
	public void get(int key) throws Exception {
		dictionary.get(key);
		setIsoCode(dictionary.getIsoCode());
		setLabel(dictionary.getLabel());
		setLabelPid(dictionary.getLabelPid());
		setLabelType(dictionary.getLabelType());
	}

	/**
	 * @return the dictionaryPid
	 */
	public int getDictionaryPid() {
		return DictionaryPid;
	}

	/**
	 * @return the isoCode
	 */
	public String getIsoCode() {
		return IsoCode;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return Label;
	}

	/**
	 * @return the labelPid
	 */
	public int getLabelPid() {
		return LabelPid;
	}

	/**
	 * @return the labelType
	 */
	public String getLabelType() {
		return LabelType;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public int getNextLabelPid() throws Exception {
		return dictionary.getNextLabelPid();
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
	 * @param labelPid
	 * @return List A list of lists of iso code, label text and dictionary pid
	 * @throws Exception
	 * @throws MvpException
	 */
	@Override
	public List<List<String>> getStringList(int labelPid) throws Exception {
		final List<List<String>> lls = new ArrayList<>();

		if (labelPid == 0) {
			return lls;
		}

		List<String> stringList;

		final List<Dictionary> fkLabelPid = dictionary.getFKLabelPid(labelPid);
		for (final Dictionary d : fkLabelPid) {
			stringList = new ArrayList<>();
			stringList.add(d.getIsoCode());
			stringList.add(d.getLabel());
			stringList.add(Integer.toString(d.getDictionaryPid()));
			lls.add(stringList);
		}
		return lls;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#insert()
	 */
	@Override
	public int insert() throws Exception {
		dictionary.setIsoCode(IsoCode);
		dictionary.setLabel(Label);
		dictionary.setLabelPid(LabelPid);
		dictionary.setLabelType(LabelType);
		return dictionary.insert();
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
	 * @param dictionaryPid the dictionaryPid to set
	 */
	public void setDictionaryPid(int dictionaryPid) {
		DictionaryPid = dictionaryPid;
	}

	/**
	 * @param isoCode the isoCode to set
	 */
	public void setIsoCode(String isoCode) {
		IsoCode = isoCode;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		Label = label;
	}

	/**
	 * @param labelPid the labelPid to set
	 */
	public void setLabelPid(int labelPid) {
		LabelPid = labelPid;
	}

	/**
	 * @param labelType the labelType to set
	 */
	public void setLabelType(String labelType) {
		LabelType = labelType;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#update()
	 */
	@Override
	public void update() throws Exception {
		dictionary.setDictionaryPid(DictionaryPid);
		dictionary.setIsoCode(IsoCode);
		dictionary.setLabel(Label);
		dictionary.setLabelPid(LabelPid);
		dictionary.setLabelType(LabelType);
		dictionary.update();
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
