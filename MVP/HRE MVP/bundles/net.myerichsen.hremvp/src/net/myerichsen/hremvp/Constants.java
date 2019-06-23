package net.myerichsen.hremvp;

/**
 * Constants used by database access and personEvent handling
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 4. apr. 2019
 *
 */
public class Constants {
	/**
	 * H2 Data types
	 */
	public static final int BIGINT = -5;

	public static final int BLOB = 2004;
	public static final int BOOLEAN = 16;
	public static final int CHAR = 1;
	public static final int CLOB = 2005;
	public static final int DATE = 91;
	public static final int DECIMAL = 3;
	public static final int DOUBLE = 8;
	public static final int INTEGER = 4;
	public static final int SMALLINT = 5;
	public static final int TIMESTAMP = 93;
	public static final int VARBINARY = -3;
	public static final int VARCHAR = 12;
	/**
	 * H2 Database table ids
	 */
	public static final int EVENTS_TABLE_ID = 123;

	// About Dialog Buttons
	public static final int LICENSES_ID = 1025;

	/**
	 * Eclipse events
	 */
	public static final String DATABASE_UPDATE_TOPIC = "DATABASE_UPDATE_TOPIC";
	public static final String EVENT_PID_UPDATE_TOPIC = "EVENT_PID_UPDATE_TOPIC";
	public static final String EVENT_ROLE_PID_UPDATE_TOPIC = "EVENT_ROLE_PID_UPDATE_TOPIC";
	public static final String EVENT_TYPE_PID_UPDATE_TOPIC = "EVENT_TYPE_PID_UPDATE_TOPIC";
	public static final String HDATE_PID_UPDATE_TOPIC = "HDATE_PID_UPDATE_TOPIC";
	public static final String KEY_UPDATE_TOPIC = "KEY_UPDATE_TOPIC";
	public static final String LABEL_PID_UPDATE_TOPIC = "LABEL_PID_UPDATE_TOPIC";
	public static final String LANGUAGE_PID_UPDATE_TOPIC = "LANGUAGE_PID_UPDATE_TOPIC";
	public static final String LOCATION_GOOGLE_MAP_UPDATE_TOPIC = "LOCATION_GOOGLE_MAP_UPDATE_TOPIC";
	public static final String LOCATION_NAME_MAP_PID_UPDATE_TOPIC = "LOCATION_NAME_MAP_PID_UPDATE_TOPIC";
	public static final String LOCATION_NAME_PART_PID_UPDATE_TOPIC = "LOCATION_NAME_PART_PID_UPDATE_TOPIC";
	public static final String LOCATION_NAME_PID_UPDATE_TOPIC = "LOCATION_NAME_PID_UPDATE_TOPIC";
	public static final String LOCATION_NAME_STYLE_PID_UPDATE_TOPIC = "LOCATION_NAME_STYLE_PID_UPDATE_TOPIC";
	public static final String LOCATION_PID_UPDATE_TOPIC = "LOCATION_PID_UPDATE_TOPIC";
	public static final String LOG_REFRESH_UPDATE_TOPIC = "LOG_REFRESH_UPDATE_TOPIC";
	public static final String PARENT_ROLE_PID_UPDATE_TOPIC = "PARENT_ROLE_PID_UPDATE_TOPIC";
	public static final String PARTNER_ROLE_PID_UPDATE_TOPIC = "PARTNER_ROLE_PID_UPDATE_TOPIC";
	public static final String PERSON_NAME_MAP_PID_UPDATE_TOPIC = "PERSON_NAME_MAP_PID_UPDATE_TOPIC";
	public static final String PERSON_NAME_PART_PID_UPDATE_TOPIC = "PERSON_NAME_PART_PID_UPDATE_TOPIC";
	public static final String PERSON_NAME_PID_UPDATE_TOPIC = "PERSON_NAME_PID_UPDATE_TOPIC";
	public static final String PERSON_NAME_STYLE_PID_UPDATE_TOPIC = "PERSON_NAME_STYLE_PID_UPDATE_TOPIC";
	public static final String PERSON_PID_UPDATE_TOPIC = "PERSON_PID_UPDATE_TOPIC";
	public static final String PROJECT_LIST_UPDATE_TOPIC = "PROJECT_LIST_UPDATE_TOPIC";
	public static final String PROJECT_PROPERTIES_UPDATE_TOPIC = "PROJECT_PROPERTIES_UPDATE_TOPIC";
	public static final String RECORDNUM_UPDATE_TOPIC = "RECORDNUM_UPDATE_TOPIC";
	public static final String SAMPLE_MODEL_UPDATE_TOPIC = "SAMPLE_MODEL_UPDATE_TOPIC";
	public static final String SELECTION_INDEX_TOPIC = "SELECTION_INDEX_TOPIC";
	public static final String SEX_PID_UPDATE_TOPIC = "SEX_PID_UPDATE_TOPIC";
	public static final String SEX_TYPE_PID_UPDATE_TOPIC = "SEX_TYPE_PID_UPDATE_TOPIC";
	public static final String TABLENAME_UPDATE_TOPIC = "TABLENAME_UPDATE_TOPIC";

	/**
	 * Constructor
	 *
	 */
	private Constants() {
		super();
	}

}
