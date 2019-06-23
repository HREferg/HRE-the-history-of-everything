package net.myerichsen.hremvp.project.providers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.viewers.IStructuredContentProvider;

/**
 * Provides log entries to the log view
 *
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 * @version 18. apr. 2019
 */
public class MvpLogProvider implements IStructuredContentProvider {
	private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.
	 * lang. Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		LOGGER.log(Level.FINE, "MvpLogProvider invoked");
		final List<String> lines = new ArrayList<>();

		try {
			final File file = new File((String) inputElement);
			final BufferedReader br = new BufferedReader(new FileReader(file));

			String readLine = "";

			while ((readLine = br.readLine()) != null) {
				lines.add(readLine);
			}

			br.close();
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}

		return lines.toArray();
	}
}
