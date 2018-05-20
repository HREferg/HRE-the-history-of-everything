package org.historyresearchenvironment.tmg.h2.models;

/**
 * The persistent class for the REPOSITORY database table.
 *
 * INSERT INTO REPOSITORY (DSID, NAME, RECMO, REF_ID, ABBREV, ADDRESS, RNOTE,
 * RPERNO, ISPICKED, TT ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,
 * ?, ?, )
 */
public class Repository {

	private int recno;

	private String abbrev;

	private int address;

	private int dsid;

	private String ispicked;

	private String name;

	private int refId;

	private String rnote;

	private int rperno;

	private String tt;

	public Repository() {
	}

	public String getAbbrev() {
		return this.abbrev;
	}

	public int getAddress() {
		return this.address;
	}

	public int getDsid() {
		return this.dsid;
	}

	public String getIspicked() {
		return this.ispicked;
	}

	public String getName() {
		return this.name;
	}

	public int getRecno() {
		return this.recno;
	}

	public int getRefId() {
		return this.refId;
	}

	public String getRnote() {
		return this.rnote;
	}

	public int getRperno() {
		return this.rperno;
	}

	public String getTt() {
		return this.tt;
	}

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public void setDsid(int dsid) {
		this.dsid = dsid;
	}

	public void setIspicked(String ispicked) {
		this.ispicked = ispicked;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRecno(int recno) {
		this.recno = recno;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	public void setRnote(String rnote) {
		this.rnote = rnote;
	}

	public void setRperno(int rperno) {
		this.rperno = rperno;
	}

	public void setTt(String tt) {
		this.tt = tt;
	}

}