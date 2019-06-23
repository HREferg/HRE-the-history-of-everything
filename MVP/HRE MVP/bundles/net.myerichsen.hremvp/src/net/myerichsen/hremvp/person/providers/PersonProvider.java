package net.myerichsen.hremvp.person.providers;

import java.util.List;

import net.myerichsen.hremvp.IHREProvider;
import net.myerichsen.hremvp.MvpException;
import net.myerichsen.hremvp.person.servers.PersonServer;

/**
 * Provides all data for a single person
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 23. apr. 2019
 *
 */
public class PersonProvider implements IHREProvider {
//	private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private int personPid;
	private int birthDatePid;
	private int deathDatePid;

	private final PersonServer server;

	/**
	 * Constructor
	 *
	 */
	public PersonProvider() {
		server = new PersonServer();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#delete(int)
	 */
	@Override
	public void delete(int key) throws Exception {
		server.delete(key);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#get(int)
	 */
	@Override
	public void get(int key) throws Exception {
		server.get(key);
		setBirthDatePid(server.getBirthDatePid());
		setDeathDatePid(server.getDeathDatePid());
		setPersonPid(key);
	}

//	public void getremote(int key) throws ClientProtocolException, IOException, MvpException {
//		StringBuilder sb = new StringBuilder();
//		String s = "";
//
//		CloseableHttpClient client = HttpClients.createDefault();
//		HttpGet request = new HttpGet("http://127.0.0.1:8000/mvp/v100/person/" + key);
//		CloseableHttpResponse response = client.execute(request);
//
//		StatusLine statusLine = response.getStatusLine();
//
//		if (statusLine.getStatusCode() != 200) {
//			throw new MvpException(statusLine.getReasonPhrase());
//		}
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//
//		while (null != (s = br.readLine())) {
//			sb.append(s);
//		}
//
//		br.close();
//		response.close();
//		client.close();
//
//		JSONObject jsonObject = new JSONObject(sb.toString());
//
//		LOGGER.log( Level.INFO, jsonObject.toString(2));
//
//		setPersonPid(jsonObject.getInt("personPid"));
//		setBirthDatePid(jsonObject.getString("birthDatePid"));
//		setDeathDatePid(jsonObject.getString("deathDatePid"));
//
//		setEventList(jsonObject.getJSONArray("eventList"));
//		setNameList(jsonObject.getNameList());
//		setParentList(jsonObject.getParentList());
//		setPartnerList(jsonObject.getPartnerList());
//		setSexesList(jsonObject.getSexesList());
//
//	}

	/**
	 * @return
	 * @throws Exception
	 */
	public List<List<String>> getAllNames() throws Exception {
		return server.getAllNames();
	}

	/**
	 * @param personId
	 * @param generations
	 * @return
	 * @throws Exception
	 */
	public List<List<String>> getAncestorList(int personId, int generations)
			throws Exception {
		return server.getAncestorList(personId, 0, generations);
	}

	/**
	 * @return the birthDatePid
	 */
	public int getBirthDatePid() {
		return server.getBirthDatePid();
	}

	/**
	 * @return the deathDatePid
	 */
	public int getDeathDatePid() {
		return server.getDeathDatePid();
	}

	/**
	 * @param key
	 * @param generations
	 * @return
	 * @throws Exception
	 * @throws MvpException
	 */
	public List<List<String>> getDescendantList(int key, int generations)
			throws Exception {
		return server.getDescendantList(key, 0, generations);
	}

	/**
	 * @return the nameList
	 */
	public List<List<String>> getNameList() {
		return server.getNameList();
	}

	/**
	 * @return List of lists of pid, primary name string, birth date and death
	 *         date
	 * @throws MvpException
	 * @throws Exception
	 */
	public List<List<String>> getPersonList() throws Exception {
		return server.getPersonList();
	}

	/**
	 * @return the personPid
	 */
	public int getPersonPid() {
		return personPid;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public String getPrimaryName() throws Exception {
		return server.getPrimaryName();
	}

	/**
	 * @return the siblingList
	 * @throws Exception
	 */
	public List<List<String>> getSiblingList(int personPid) throws Exception {
		return server.getSiblingList(personPid);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#getStringList()
	 */
	@Override
	public List<List<String>> getStringList() throws Exception {
		return server.getStringList();
	}

	/**
	 * @param key
	 * @return
	 * @throws MvpException
	 * @throws Exception
	 */
	@Override
	public List<List<String>> getStringList(int key) throws Exception {
		return server.getStringList(key);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.myerichsen.hremvp.IHREProvider#insert()
	 */
	@Override
	public int insert() throws Exception {
		server.setBirthDatePid(birthDatePid);
		server.setDeathDatePid(deathDatePid);
		server.setPersonPid(personPid);
		return server.insert();
	}

	/**
	 * @param parentPid
	 * @param childPid
	 * @throws MvpException
	 * @throws Exception
	 */
	public void removeChild(int parentPid, int childPid) throws Exception {
		server.removeChild(parentPid, childPid);
	}

	/**
	 * @param eventPid
	 * @throws Exception
	 */
	public void removeEvent(int eventPid) throws Exception {
		server.removeEvent(eventPid);
	}

	/**
	 * @param i
	 */
	public void setBirthDatePid(int i) {
		birthDatePid = i;
	}

	/**
	 * @param i the deathDatePid to set
	 */
	public void setDeathDatePid(int i) {
		deathDatePid = i;
	}

	/**
	 * @param personPid the personPid to set
	 */
	public void setPersonPid(int personPid) {
		this.personPid = personPid;
	}

	/**
	 * Update a row
	 *
	 * @throws Exception An exception that provides information on a database
	 *                   access error or other errors
	 */
	@Override
	public void update() throws Exception {
		server.setBirthDatePid(birthDatePid);
		server.setDeathDatePid(deathDatePid);
		server.setPersonPid(personPid);
		server.update();
	}
}
