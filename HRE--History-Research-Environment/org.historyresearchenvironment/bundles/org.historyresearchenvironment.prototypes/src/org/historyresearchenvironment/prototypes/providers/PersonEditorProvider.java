package org.historyresearchenvironment.prototypes.providers;

import java.sql.SQLException;

import org.historyresearchenvironment.dataaccess.models.Bios;
import org.historyresearchenvironment.dataaccess.models.LabelTrans;
import org.historyresearchenvironment.dataaccess.models.SexDefns;
import org.historyresearchenvironment.dataaccess.providers.AbstractHreProvider;

/**
 * @version 2018-08-08
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public class PersonEditorProvider extends AbstractHreProvider {
	private String biosType;
	private String personNo;
	private String[] name;
	private String sex;
	private int fatherNo;
	private int motherNo;

	/**
	 * Constructor
	 *
	 */
	public PersonEditorProvider() {
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
		 try {
			Bios bios = new Bios().get(i);
			
			int sex = bios.getSexKey();
			SexDefns sexDefns = new SexDefns().get(sex);
			LabelTrans sexLabelTrans = new LabelTrans().get(sexDefns.getSexDefnPid());
			String sexLabel = sexLabelTrans.getName();
			setSex(sexLabel);
			
//			int bestName = bios.getBestNamePid();
			
		} catch (SQLException e) {
			LOGGER.severe(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @return the personNo
	 */
	public String getPersonNo() {
		return personNo;
	}

	/**
	 * @param personNo the personNo to set
	 */
	public void setPersonNo(String personNo) {
		this.personNo = personNo;
	}

}
