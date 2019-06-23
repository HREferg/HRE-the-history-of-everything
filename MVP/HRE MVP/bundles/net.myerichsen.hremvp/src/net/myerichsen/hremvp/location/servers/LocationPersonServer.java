package net.myerichsen.hremvp.location.servers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.myerichsen.hremvp.IHREServer;
import net.myerichsen.hremvp.dbmodels.LocationEvents;
import net.myerichsen.hremvp.dbmodels.PersonEvents;
import net.myerichsen.hremvp.person.servers.PersonNameServer;

/**
 * Business logic interface for persons for locations
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 7. maj 2019
 *
 */
public class LocationPersonServer implements IHREServer {
//	private static final Logger LOGGER = Logger
//			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final LocationEvents leLink;
	private final PersonEvents peLink;

	/**
	 * Constructor
	 *
	 */
	public LocationPersonServer() {
		leLink = new LocationEvents();
		peLink = new PersonEvents();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#delete(int)
	 */
	@Override
	public void delete(int key) throws Exception {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

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
		return "";
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

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#getStringList(int)
	 */
	@Override
	public List<List<String>> getStringList(int locationPid) throws Exception {
		final List<List<String>> lls = new ArrayList<>();

		if (locationPid == 0) {
			return lls;
		}

		List<String> stringList;
		int eventPid;
		List<PersonEvents> peList;
		int personPid;
		PersonNameServer ns;

		for (final LocationEvents eventLink : leLink
				.getFKLocationPid(locationPid)) {
			stringList = new ArrayList<>();
			eventPid = eventLink.getEventPid();
			peList = peLink.getFKEventPid(eventPid);

			for (final PersonEvents personLink : peList) {
				personPid = personLink.getPersonPid();
				ns = new PersonNameServer();

				stringList.add(Integer.toString(personPid));
				stringList.add(ns.getPrimaryNameString(personPid));
				lls.add(stringList);

			}
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
		// TODO Auto-generated method stub
		return 0;
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

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREServer#update()
	 */
	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub

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
