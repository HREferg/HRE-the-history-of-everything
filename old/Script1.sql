--<ScriptOptions statementTerminator=";"/>

ALTER TABLE EXHIBIT DROP CONSTRAINT EXHIBIT_PK;

DROP INDEX EXHIBIT_IDEXHIBIT_IDX;

DROP INDEX PRIMARY_KEY_DC;

DROP TABLE EXHIBIT;

CREATE TABLE EXHIBIT (
		IDEXHIBIT INTEGER NOT NULL,
		IDREF INTEGER,
		RLTYPE CHAR(1),
		RLNUM INTEGER,
		XNAME CHAR(30),
		VFILENAME CHAR(4),
		IFILENAME VARCHAR(32672),
		AFILENAME VARCHAR(32672),
		TFILENAME VARCHAR(32672),
		REFERENCE CHAR(25),
		TEXT VARCHAR(32672),
		IMAGE VARCHAR(326720),
		AUDIO VARCHAR(32672),
		DESCRIPT VARCHAR(32672),
		RLPER1 INTEGER NOT NULL,
		RLPER2 INTEGER,
		RLGTYPE INTEGER,
		OLE_OBJECT VARCHAR(32672),
		XPRIMARY CHAR(1),
		VIDEO VARCHAR(32672),
		PROPERTY VARCHAR(32672),
		DSID INTEGER NOT NULL,
		TT CHAR(1),
		ID_PERSON INTEGER,
		RECNO INTEGER,
		ID_EVENT INTEGER,
		ID_SOURCE INTEGER,
		ID_REPOS INTEGER,
		THUMB VARCHAR(32672),
		ID_CIT INTEGER,
		ID_PLACE INTEGER,
		CAPTION VARCHAR(32672),
		SORTEXH INTEGER,
		IMAGEFORE VARCHAR(32672),
		IMAGEBACK VARCHAR(32672),
		TRANSPAR DECIMAL(5 , 0)
	);

CREATE UNIQUE INDEX EXHIBIT_IDEXHIBIT_IDX ON EXHIBIT (IDEXHIBIT ASC);

CREATE UNIQUE INDEX PRIMARY_KEY_DC ON EXHIBIT (IDEXHIBIT ASC);

ALTER TABLE EXHIBIT ADD CONSTRAINT EXHIBIT_PK PRIMARY KEY (IDEXHIBIT);

