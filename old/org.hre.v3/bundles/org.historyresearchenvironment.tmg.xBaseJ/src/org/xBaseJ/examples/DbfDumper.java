package org.xBaseJ.examples;

import org.xBaseJ.DBF;
import org.xBaseJ.fields.Field;

/**
 * Reads and prints all columns, all rows of the specified file.
 * 
 * @author clott
 *
 */
public class DbfDumper {

	public static void main(String args[]) {

		if (args.length != 1) {
			System.err.println("Usage: DbfDumper file.dbf");
			return;
		}

		try {
			DBF dbf = new DBF(args[0], DBF.READ_ONLY);

			System.out.println("Record count: " + dbf.getRecordCount()
					+ "\nField count: " + dbf.getFieldCount());

			// Fields index from 1
			for (int f = 1; f <= dbf.getFieldCount(); ++f) {
				Field fld = dbf.getField(f);
				System.out.println("Field " + f + ": " + fld.getName()
						+ ", type=" + fld.getType() + ", len="
						+ fld.getLength());
			}

			System.out.println("----------------------------");

			for (int i = 0; i <= dbf.getRecordCount(); i++) {
				dbf.read();
				System.out.println("\nRecord " + i);
				for (int f = 1; f <= dbf.getFieldCount(); ++f) {
					Field fld = dbf.getField(f);
					System.out.println("Field " + f + ": " + fld.getName()
							+ "= >" + fld.get() + "<");
				}
				System.out.println("----------------------------");
			}

			dbf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
