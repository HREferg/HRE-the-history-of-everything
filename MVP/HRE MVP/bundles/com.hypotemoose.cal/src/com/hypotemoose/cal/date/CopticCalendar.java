package com.hypotemoose.cal.date;

/**
 * The Coptic calendar.
 *
 * @author Chris Engelsma
 * @since 2017.08.03
 */
public class CopticCalendar extends Almanac {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static final String CALENDAR_NAME = "Coptic Calendar";
	public static final JulianDay EPOCH = new JulianDay(2299160.5);

	@Override
	public String getDate() {
		return null;
	}

	@Override
	public String getName() {
		return CALENDAR_NAME;
	}

	@Override
	public int getNumberOfDaysInMonth() {
		return 0;
	}

	@Override
	public int getNumberOfDaysInWeek() {
		return 0;
	}

	@Override
	public int getNumberOfMonthsInYear() {
		return 13;
	}

	@Override
	public void set(Almanac a) {

	}
}
