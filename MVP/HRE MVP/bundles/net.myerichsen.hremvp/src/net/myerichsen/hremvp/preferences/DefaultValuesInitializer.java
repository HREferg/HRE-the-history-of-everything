package net.myerichsen.hremvp.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

/**
 * Default values initializer
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 23. jun. 2019
 *
 */
public class DefaultValuesInitializer extends AbstractPreferenceInitializer {

	/**
	 * Constructor
	 *
	 */
	public DefaultValuesInitializer() {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
	 * initializeDefaultPreferences()
	 */
	@Override
	public void initializeDefaultPreferences() {
		final IPreferenceStore store = new ScopedPreferenceStore(
				InstanceScope.INSTANCE, "net.myerichsen.hremvp");

		// MVP
		store.setDefault("CSMODE", "STANDALONE");
		store.setDefault("LOGLEVEL", "INFO");
		store.setDefault("LOGFILEPATH", ".");
		store.setDefault("GUILANGUAGE", "ENUS");
		store.setDefault("HELPSYSTEMPORT", "8081");
		store.setDefault("HREFONT",
				"1|Segoe UI|12.0|0|WINDOWS|1|-16|0|0|0|400|0|0|0|0|3|2|1|34|Segoe UI");
		store.setDefault("TLS", "true");
		store.setDefault("UPDATESITE",
				"http://www.myerichsen.net/HRE/repository");
		store.setDefault("WEBSITELIST", "https://www.google.dk/search?oq=");
		store.setDefault("DEFAULTPERSONNAMESTYLE", "1");
		store.setDefault("DEFAULTLOCATIONNAMESTYLE", "1");
		store.setDefault("TREEGENERATIONS", 5);
		store.setDefault("GOOGLEAPIKEY", "");

		// H2
		store.setDefault("H2TRACELEVEL", "1");
		store.setDefault("DBPATH", ".");
		store.setDefault("DBNAME", "SAMPLE");
		store.setDefault("USERID", "sa");
		store.setDefault("PASSWORD", "");
		store.setDefault("H2VERSION", "1.3.168");

		// Jetty
		store.setDefault("SERVERADDRESS", "127.0.0.1");
		store.setDefault("SERVERROOT", "mvp/v100");
		store.setDefault("SERVERPORT", 8000);
		store.setDefault("JETTYLOGLEVEL", "INFO");
		store.setDefault("SERVERLIST", "127.0.0.1:8000");

		store.setDefault("projectcount", "0");
	}
}
