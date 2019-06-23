package net.myerichsen.hremvp.databaseadmin;

/**
 * Model for the H2DatabaseNavigator
 *
 * @version 2018-05-24
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 *
 */
public class H2DatabaseModel {
	private String tableName;
	private long rowCount;

	/**
	 * Constructor
	 *
	 */
	public H2DatabaseModel() {
	}

	/**
	 * Constructor
	 *
	 * @param tableName Name of H2 table
	 * @param rowCount  Nyumber of rows in the table
	 */
	public H2DatabaseModel(String tableName, long rowCount) {
		super();
		this.tableName = tableName;
		this.rowCount = rowCount;
	}

	/**
	 * @return the rowCount
	 */
	public long getRowCount() {
		return rowCount;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param rowCount the rowCount to set
	 */
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
