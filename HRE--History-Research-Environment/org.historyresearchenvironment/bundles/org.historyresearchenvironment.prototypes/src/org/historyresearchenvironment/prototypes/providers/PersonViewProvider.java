package org.historyresearchenvironment.prototypes.providers;

import org.historyresearchenvironment.dataaccess.providers.AbstractHreProvider;

/**
 * @version 2018-08-06
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class PersonViewProvider extends AbstractHreProvider {
	private String biosType;
	private String[] name;
	private String sex;
	private int fatherNo;
	private int motherNo;

	/**
	 * Constructor
	 *
	 */
	public PersonViewProvider() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the biosType
	 */
	public String getBiosType() {
		return biosType;
	}

	/**
	 * @return the name
	 */
	public String[] getName() {
		return name;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @return the fatherNo
	 */
	public int getFatherNo() {
		return fatherNo;
	}

	/**
	 * @return the motherNo
	 */
	public int getMotherNo() {
		return motherNo;
	}

	/**
	 * @param biosType
	 *            the biosType to set
	 */
	public void setBiosType(String biosType) {
		this.biosType = biosType;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String[] name) {
		this.name = name;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @param fatherNo
	 *            the fatherNo to set
	 */
	public void setFatherNo(int fatherNo) {
		this.fatherNo = fatherNo;
	}

	/**
	 * @param motherNo
	 *            the motherNo to set
	 */
	public void setMotherNo(int motherNo) {
		this.motherNo = motherNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.historyresearchenvironment.dataaccess.providers.AbstractHreProvider#
	 * readFromDatabase()
	 */
	@Override
	public void readFromDatabase() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.historyresearchenvironment.dataaccess.providers.AbstractHreProvider#
	 * readFromDatabase(int)
	 */
	@Override
	public void readFromDatabase(int i) {
		// Instantiate an model object for each table
		// Bios bios = new Bios().get(key);
	}

}
