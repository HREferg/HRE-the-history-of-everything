package net.myerichsen.hremvp.person.servers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.dbmodels.Dictionary;
import net.myerichsen.hremvp.dbmodels.PartnerRoles;
import net.myerichsen.hremvp.dbmodels.Partners;

/**
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 * @version 7. maj 2019
 *
 */
public class PartnerServer implements IHREServer {
	private int PartnerPid;
	private int Partner1;
	private int Partner2;
	private boolean PrimaryPartner;
	private int PartnerRolePid;
	private int FromDatePid;
	private int ToDatePid;

	private final Partners partnerRelation;

	/**
	 * Constructor
	 *
	 */
	public PartnerServer() {
		partnerRelation = new Partners();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.servers.IHREServer#delete(int)
	 */
	@Override
	public void delete(int key) throws Exception {

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
	 * @see net.myerichsen.hremvp.servers.IHREServer#get(int)
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
		final List<List<String>> lls = new ArrayList<>();

		if (key == 0) {
			return lls;
		}

		List<String> ls;
		final PartnerRoles role2 = new PartnerRoles();
		final Dictionary dictionary = new Dictionary();
		final PersonNameServer pns = new PersonNameServer();

		final List<Partners> lpa = new Partners().getFKPartner1(key);
		lpa.addAll(new Partners().getFKPartner2(key));

		for (final Partners partner : lpa) {
			ls = new ArrayList<>();

			if (partner.getPartner1() == key) {
				ls.add(Integer.toString(partner.getPartner2()));
				ls.add(pns.getPrimaryNameString(partner.getPartner2()));
			} else {
				ls.add(Integer.toString(partner.getPartner1()));
				ls.add(pns.getPrimaryNameString(partner.getPartner1()));
			}

			role2.get(partner.getPartnerRolePid());
			dictionary.getFKLabelPid(role2.getLabelPid());
			ls.add(dictionary.getLabel());

			ls.add(Boolean.toString(partner.isPrimaryPartner()));

			lls.add(ls);
		}

		return lls;
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
	 * @see net.myerichsen.hremvp.servers.IHREServer#insert()
	 */
	@Override
	public int insert() throws Exception {

		partnerRelation.setPartner1(Partner1);
		partnerRelation.setPartner2(Partner2);
		partnerRelation.setPrimaryPartner(PrimaryPartner);
		partnerRelation.setPartnerRolePid(PartnerRolePid);
		partnerRelation.setFromDatePid(FromDatePid);
		partnerRelation.setToDatePid(ToDatePid);
		return partnerRelation.insert();
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
	 * @return the primaryPartner
	 */
	public boolean isPrimaryPartner() {
		return PrimaryPartner;
	}

	/**
	 * @param personPid
	 * @param partnerPid
	 * @throws Exception
	 * @throws MvpException
	 */
	public void removePartner(int personPid, int partnerPid) throws Exception {
		final Partners partner = new Partners();

		for (final Partners p : partner.getFKPartner1(personPid)) {
			if (p.getPartner2() == partnerPid) {
				partner.delete(p.getPartnerPid());
			}
		}

		for (final Partners p : partner.getFKPartner2(personPid)) {
			if (p.getPartner1() == partnerPid) {
				partner.delete(p.getPartnerPid());
			}
		}
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
	 * @see net.myerichsen.hremvp.servers.IHREServer#update()
	 */
	@Override
	public void update() throws Exception {

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
