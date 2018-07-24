package org.historyresearchenvironment.client.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

/**
 * @version 2018-07-24
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
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
		final IPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"org.historyresearchenvironment");

		store.setDefault("CSMODE", "DIRECT");
		store.setDefault("DBDRIVER", "org.h2.Driver");
		store.setDefault("DBNAME", ".SAMPLE");
		store.setDefault("GUILANGUAGE", "ENGLISH");
		store.setDefault("H2TRACELEVEL", "INFO");
		store.setDefault("HELPSYSTEMPORT", "8081");
		store.setDefault("HREFONT", "1|Segoe UI|12.0|0|WINDOWS|1|-16|0|0|0|400|0|0|0|0|3|2|1|34|Segoe UI");
		store.setDefault("LOGFILEPATH", ".");
		store.setDefault("LOGLEVEL", "INFO");
		store.setDefault("PASSWORD", "");
		store.setDefault("SERVERADDRESS", "127.0.0.1:8000");
		store.setDefault("SERVERPORT", "8000");
		store.setDefault("TLS", "true");
		store.setDefault("USERID", "sa");
		store.setDefault("UPDATESITE", "http://www.myerichsen.net/HRERepository");
		store.setDefault("projectcount", "1");
		store.setDefault("project.0.name", "SAMPLE");
		store.setDefault("project.0.lastupdated", "2018-06-24 16:41:36");
		store.setDefault("project.0.summary", "This is the Default project");
		store.setDefault("project.0.localserver", "LOCAL");
		store.setDefault("project.0.path", ".SAMPLE");

	}
}