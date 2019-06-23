package net.myerichsen.hremvp.person.providers;

import java.util.List;

import net.myerichsen.hremvp.IHREProvider;
import net.myerichsen.hremvp.person.servers.PartnerServer;

/**
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 * @version 23. apr. 2019
 *
 */
public class PartnerProvider implements IHREProvider {
	private int PartnerPid;
	private int Partner1;
	private int Partner2;
	private boolean PrimaryPartner;
	private int PartnerRolePid;
	private int FromDatePid;
	private int ToDatePid;

	private final PartnerServer server;

	/**
	 * Constructor
	 *
	 */
	public PartnerProvider() {
		server = new PartnerServer();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#delete(int)
	 */
	@Override
	public void delete(int key) throws Exception {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#get(int)
	 */
	@Override
	public void get(int key) throws Exception {

	}

	/**
	 * @return the fromDatePid
	 */
	public int getFromDatePid() {
		return FromDatePid;
	}

	/**
	 * @return the partner1
	 */
	public int getPartner1() {
		return Partner1;
	}

	/**
	 * @return the partner2
	 */
	public int getPartner2() {
		return Partner2;
	}

	/**
	 * @return the partnerPid
	 */
	public int getPartnerPid() {
		return PartnerPid;
	}

	/**
	 * @return the partnerRolePid
	 */
	public int getPartnerRolePid() {
		return PartnerRolePid;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#getStringList()
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#getStringList(int)
	 */
	@Override
	public List<List<String>> getStringList(int key) throws Exception {
		return server.getStringList(key);
	}

	/**
	 * @return the toDatePid
	 */
	public int getToDatePid() {
		return ToDatePid;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#insert()
	 */
	@Override
	public int insert() throws Exception {
		server.setPartner1(Partner1);
		server.setPartner2(Partner2);
		server.setPrimaryPartner(PrimaryPartner);
		server.setPartnerRolePid(PartnerRolePid);
		server.setFromDatePid(FromDatePid);
		server.setToDatePid(ToDatePid);
		return server.insert();
	}

	/**
	 * @return the primaryPartner
	 */
	public boolean isPrimaryPartner() {
		return PrimaryPartner;
	}

	/**
	 * @param personPid
	 * @param partnerPid2
	 * @throws Exception
	 */
	public void removePartner(int personPid, int partnerPid2) throws Exception {
		server.removePartner(personPid, partnerPid2);
	}

	/**
	 * @param fromDatePid the fromDatePid to set
	 */
	public void setFromDatePid(int fromDatePid) {
		FromDatePid = fromDatePid;
	}

	/**
	 * @param partner1 the partner1 to set
	 */
	public void setPartner1(int partner1) {
		Partner1 = partner1;
	}

	/**
	 * @param partner2 the partner2 to set
	 */
	public void setPartner2(int partner2) {
		Partner2 = partner2;
	}

	/**
	 * @param partnerPid the partnerPid to set
	 */
	public void setPartnerPid(int partnerPid) {
		PartnerPid = partnerPid;
	}

	/**
	 * @param partnerRolePid the partnerRolePid to set
	 */
	public void setPartnerRolePid(int partnerRolePid) {
		PartnerRolePid = partnerRolePid;
	}

	/**
	 * @param primaryPartner the primaryPartner to set
	 */
	public void setPrimaryPartner(boolean primaryPartner) {
		PrimaryPartner = primaryPartner;
	}

	/**
	 * @param toDatePid the toDatePid to set
	 */
	public void setToDatePid(int toDatePid) {
		ToDatePid = toDatePid;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#update()
	 */
	@Override
	public void update() throws Exception {

	}
}
