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

import static com.hypotemoose.cal.constants.CalendarConstants.JulianCalendarConstants.monthNames;
import static com.hypotemoose.cal.constants.CalendarConstants.JulianCalendarConstants.weekDayNames;
import static com.hypotemoose.cal.util.AlmanacConverter.toJulianCalendar;

import java.util.Calendar;
import java.util.Objects;

/**
 * A date in the Julian calendar.
 *
 * @author Chris Engelsma.
 * @since 2015.10.02
 */
public final class JulianCalendar extends Almanac {

	/**
	 *
	 */
	private static final long serialVersionUID = 5899242194536474531L;
	public static final String CALENDAR_NAME = "Julian Calendar";
	public static final JulianDay EPOCH = new JulianDay(2299160.5);

	/**
	 * Constructs a Julian date using today's date.
	 */
	public JulianCalendar() {
		this(new JulianDay());
	}

	/**
	 * Constructs a Julian date from another Almanac.
	 *
	 * @param date another Almanac
	 */
	public JulianCalendar(Almanac date) {
		this(toJulianCalendar(date));
	}

	/**
	 * Constructs a Julian Calendar using a {@link java.util.Calendar}.
	 *
	 * @param cal a {@link java.util.Calendar}.
	 */
	public JulianCalendar(Calendar cal) {
		this(new GregorianCalendar(cal));
	}

	/**
	 * Constructs a Julian date from a given day, month and year.
	 *
	 * @param year  The year.
	 * @param month The month.
	 * @param day   The day.
	 */
	public JulianCalendar(int year, int month, int day) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * Constructs a Julian date given another Julian date.
	 *
	 * @param date A Julian date.
	 */
	public JulianCalendar(JulianCalendar date) {
		this(date.getYear(), date.getMonth(), date.getDay());
	}

	/**
	 * Returns today's date as a string. Convenience static method.
	 *
	 * @return today's date.
	 */
	public static String asToday() {
		return (new JulianCalendar()).toString();
	}

	/**
	 * Gets an array of month-lengths for a given year.
	 *
	 * @param year a year.
	 * @return an array[12] of month-lengths for a given year.
	 */
	public static int[] getDaysPerMonthInYear(int year) {
		final int[] days = new int[12];
		for (int i = 0; i < 12; ++i) {
			days[i] = JulianCalendar.getNumberOfDaysInMonth(i + 1, year);
		}
		return days;
	}

	/**
	 * Gets a month name.
	 *
	 * @param month the month number [1 - 12].
	 * @return the name of the month.
	 * @throws IndexOutOfBoundsException
	 */
	public static String getMonthName(int month)
			throws IndexOutOfBoundsException {
		return JulianCalendar.getMonthName(month, false);
	}

	/**
	 * Gets a month name.
	 *
	 * @param month the month number [1 - 12].
	 * @param latin true, if using the latin month name; false for English.
	 * @return the name of the month.
	 * @throws IndexOutOfBoundsException
	 */
	public static String getMonthName(int month, boolean latin)
			throws IndexOutOfBoundsException {
		final int l = (latin) ? 1 : 0;
		return monthNames[(2 * (month - 1)) + l];
	}

	/**
	 * Gets the names of the months.
	 *
	 * @param latin true, if desired month names be in latin; false, otherwise.
	 * @return the list of months.
	 */
	public static String[] getMonthNames(boolean latin) {
		final String[] m = new String[12];
		final int lat = (latin) ? 1 : 0;
		for (int i = 0; i < 12; ++i) {
			m[i] = monthNames[(2 * i) + lat];
		}
		return m;
	}

	/**
	 * Gets the total number of days in a given month and year.
	 *
	 * @param month the month.
	 * @param year  the year.
	 * @return the number of days in the month.
	 */
	public static int getNumberOfDaysInMonth(int month, int year) {
		if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
			return 30;
		}
		if (month == 2) {
			if (!JulianCalendar.isLeapYear(year)) {
				return 28;
			} else {
				return 29;
			}
		}
		return 31;
	}

	/**
	 * Determines whether a given year is a leap year.
	 *
	 * A year is considered a leap year in the Julian calendar if it is
	 * divisible by four.
	 *
	 * @param year a given year.
	 * @return true, if is a leap year; false, otherwise.
	 */
	public static boolean isLeapYear(int year) {
		return ((year % 4) == 0);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof JulianCalendar)) {
			return false;
		}
		if (obj == this) {
			return true;
		}

		final JulianCalendar date = (JulianCalendar) obj;

		return (year == date.getYear()) && (month == date.getMonth())
				&& (day == date.getDay());
	}

	/**
	 * Gets the date.
	 */
	@Override
	public String getDate() {
		return new String(getMonthName() + " " + getDay() + ", " + getYear());
	}

	/**
	 * Gets an array of month-lengths for this year.
	 *
	 * @return an array[12] of month-lengths for this year.
	 */
	public int[] getDaysPerMonthInYear() {
		return JulianCalendar.getDaysPerMonthInYear(getYear());
	}

	/**
	 * Gets the month name for this date.
	 *
	 * @return the name of the month.
	 */
	public String getMonthName() {
		return JulianCalendar.getMonthName(month);
	}

	/**
	 * Gets the month names.
	 *
	 * @return the month names.
	 */
	@Override
	public String[] getMonths() {
		return JulianCalendar.getMonthNames(false);
	}

	@Override
	public String getName() {
		return CALENDAR_NAME;
	}

	/**
	 * Gets the number of days for this month and year.
	 *
	 * @return the number of days for this month and year.
	 */
	@Override
	public int getNumberOfDaysInMonth() {
		return JulianCalendar.getNumberOfDaysInMonth(getMonth(), getYear());
	}

	/**
	 * Gets the number of days in a week.
	 *
	 * @return the number of days in a week.
	 */
	@Override
	public int getNumberOfDaysInWeek() {
		return 7;
	}

	/**
	 * Gets the number of months in a year.
	 *
	 * @return the number of months in a year.
	 */
	@Override
	public int getNumberOfMonthsInYear() {
		return 12;
	}

	/**
	 * Gets the weekday name.
	 *
	 * @return weekday.
	 */
	@Override
	public String getWeekDay() {
		return weekDayNames[getWeekDayNumber()];
	}

	/**
	 * Gets the names of the weekdays.
	 *
	 * @return an array[7] of the weekdays.
	 */
	@Override
	public String[] getWeekDays() {
		return weekDayNames;
	}

	@Override
	public int hashCode() {
		return Objects.hash(year, month, day);
	}

	/**
	 * Determines whether this date's year is a leap year.
	 * <p>
	 * This method determines whether the the current date exists during the
	 * Julian calendar or the Gregorian Calendar. The only difference between
	 * the two is that for the Gregorian Calendar leap years must be evenly
	 * divisible by 4, unless the year is divisible by 100 - with the exception
	 * of years evenly divisble by 400.
	 *
	 * @return true, if this is a leap year; false, otherwise.
	 */
	public boolean isLeapYear() {
		return JulianCalendar.isLeapYear(year);
	}

/////////////////////////////////////////////////////////////////////////////
// private

	/**
	 * Sets this calendar.
	 *
	 * @param a an almanac.
	 */
	@Override
	public void set(Almanac a) {
		final JulianCalendar cal = toJulianCalendar(a);
		year = cal.getYear();
		month = cal.getMonth();
		day = cal.getDay();
	}

	/**
	 * Prints this date with a simple pre-defined format.
	 */
	@Override
	public String toString() {
		return (CALENDAR_NAME + ": " + getDate());
	}

}
