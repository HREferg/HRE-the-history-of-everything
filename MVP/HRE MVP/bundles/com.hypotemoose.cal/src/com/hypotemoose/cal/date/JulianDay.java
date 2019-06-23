/*****************************************************************************
 * Copyright 2015 Chris Engelsma
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *****************************************************************************/
package com.hypotemoose.cal.date;

import static com.hypotemoose.cal.util.AlmanacConverter.toJulianDay;

import java.util.Calendar;
import java.util.Objects;

/**
 * A Julian Day.
 * <p>
 * The Julian Day is the continuous count of days since the beginning of the
 * Julian Period used primarily by astronomers. The Julian Period is a
 * chronological interval of 7980 years beginning in 4713 BC, and has been used
 * since 1583 to convert between different calendars. The next Julian Period
 * begins in the year 3268 AD.
 *
 * @author Chris Engelsma
 * @since 2015.08.07
 */
public final class JulianDay extends Almanac {

	/**
	 *
	 */
	private static final long serialVersionUID = 7324467741111586189L;
	public static final String CALENDAR_NAME = "Julian Day";
	public static JulianDay EPOCH = new JulianDay(2400000.5);
	private double _jday;

	/**
	 * Constructs a Julian Day that is set to today's date.
	 */
	public JulianDay() {
		this(new GregorianCalendar());
	}

	/**
	 * Constructs a Julian Day using a provided Gregorian Date.
	 *
	 * @param date A Gregorian Date.
	 */
	public JulianDay(Almanac date) {
		this(toJulianDay(date));
	}

	/**
	 * Constructs a Julian Day from {@link java.util.Calendar}.
	 *
	 * @param cal a {@link java.util.Calendar}.
	 */
	public JulianDay(Calendar cal) {
		this(new GregorianCalendar(cal));
	}

	/**
	 * Constructs a Julian Day. Day number is set to a given value.
	 *
	 * @param jd A Julian Day.
	 */
	public JulianDay(double jd) {
		_jday = jd;
	}

	/**
	 * Constructs a Julian Day from a given integer. Note: Day will be set to
	 * midnight.
	 *
	 * @param jd A Julian Day.
	 */
	public JulianDay(int jd) {
		this((double) jd);
	}

	/**
	 * Constructs a Julian Day. Day number is set using a given Julian Day.
	 *
	 * @param jd A Julian Day.
	 */
	public JulianDay(JulianDay jd) {
		this(jd.getValue());
	}

	/**
	 * Returns today's date as a string. Convenience static method.
	 *
	 * @return today's date.
	 */
	public static String asToday() {
		return (new JulianDay()).toString();
	}

	/**
	 * Returns this Julian Day set to midnight.
	 *
	 * @return This Julian Day at midnight.
	 */
	public JulianDay atMidnight() {
		return new JulianDay(Math.floor(_jday - 0.5) + 0.5);
	}

	/**
	 * Returns this Julian Day set to noon.
	 *
	 * @return This Julian Day at noon.
	 */
	public JulianDay atNoon() {
		return new JulianDay(Math.ceil(_jday - 0.5));
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof JulianDay)) {
			return false;
		}
		if (obj == this) {
			return true;
		}

		final JulianDay date = (JulianDay) obj;
		return _jday == date.getValue();
	}

	/**
	 * Gets the date.
	 *
	 * @return the date.
	 */
	@Override
	public String getDate() {
		return Double.toString(getValue());
	}

	/**
	 * Gets the Modified Julian Day (MJD). The Modified Julian Day is an
	 * adjusted version of the Julian Day by setting the Epoch to midnight,
	 * November 17, 1858.
	 *
	 * @return The Modified Julian Day.
	 */
	public double getModified() {
		return _jday - EPOCH.getValue();
	}

	/**
	 * Gets the calendar name.
	 *
	 * @return the calendar name.
	 */
	@Override
	public String getName() {
		return CALENDAR_NAME;
	}

	/**
	 * Gets the number of days in a month. Note: Overloaded function; only
	 * returns one for this calendar.
	 *
	 * @return the number of days in a month.
	 */
	@Override
	public int getNumberOfDaysInMonth() {
		return 1;
	}

	/**
	 * Gets the number of days in a week. Note: Overloaded function; only
	 * returns one for this calendar.
	 *
	 * @return the number of days in a week.
	 */
	@Override
	public int getNumberOfDaysInWeek() {
		return 7;
	}

	/**
	 * Gets the number of months in the year. Note: Overloaded function; only
	 * returns one for this calendar.
	 *
	 * @return the number of months in a year.
	 */
	@Override
	public int getNumberOfMonthsInYear() {
		return 12;
	}

	/**
	 * Gets this day as a double.
	 *
	 * @return this day.
	 */
	public double getValue() {
		return _jday;
	}

	@Override
	public int hashCode() {
		return Objects.hash(_jday);
	}

	/**
	 * Subtracts days from this Julian day.
	 *
	 * @param days number of days to subtract.
	 * @return n days before this day.
	 */
	public JulianDay minus(int days) {
		_jday -= days;
		return this;
	}

	/**
	 * Sets this calendar to the next day.
	 */
	@Override
	public void nextDay() {
		_jday += 1;
	}

	/**
	 * Adds days to this Julian day.
	 *
	 * @param days number of days to add.
	 * @return n days after this day.
	 */
	public JulianDay plus(int days) {
		_jday += days;
		return this;
	}

	/**
	 * Sets this calendar to the previous day.
	 */
	@Override
	public void prevDay() {
		_jday -= 1;
	}

	/**
	 * Sets this calendar.
	 *
	 * @param a an almanac.
	 */
	@Override
	public void set(Almanac a) {
		final JulianDay cal = toJulianDay(a);
		_jday = cal.getValue();
	}

	/**
	 * Sets this Julian Day to midnight.
	 */
	public void setToMidnight() {
		_jday = (atMidnight()).getValue();
	}

	/**
	 * Sets this Julian Day to noon.
	 */
	public void setToNoon() {
		_jday = (atNoon()).getValue();
	}

	@Override
	public String toString() {
		return CALENDAR_NAME + ": " + getDate();
	}

}
