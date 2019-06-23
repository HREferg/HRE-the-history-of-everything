package net.myerichsen.hremvp.databaseadmin;

/**
 * Model for the table navigator
 *
 * @version 2018-05-19
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018-2019
 *
 */
public class H2TableModel {
	private String name;
	private String type;
	private int numericType;
	private Object value;
	private int precision;
	private int scale;

	/**
	 * Constructor
	 *
	 */
	public H2TableModel() {
		precision = 0;
		scale = 0;
	}

	/**
	 * Constructor
	 *
	 * @param name      Column name
	 * @param type      Column type
	 * @param value     Column value
	 * @param precision Column precision
	 * @param scale     Column scale
	 */
	public H2TableModel(String name, String type, String value, int precision,
			int scale) {
		super();
		this.name = name;
		this.type = type;
		this.value = value;
		this.precision = precision;
		this.scale = scale;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the numericType
	 */
	public int getNumericType() {
		return numericType;
	}

	/**
	 * @return the precision
	 */
	public int getPrecision() {
		return precision;
	}

	/**
	 * @return the scale
	 */
	public int getScale() {
		return scale;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param numericType the numericType to set
	 */
	public void setNumericType(int numericType) {
		this.numericType = numericType;
	}

	/**
	 * @param precision the precision to set
	 */
	public void setPrecision(int precision) {
		this.precision = precision;
	}

	/**
	 * @param scale the scale to set
	 */
	public void setScale(int scale) {
		this.scale = scale;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}