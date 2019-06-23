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

import static com.hypotemoose.cal.constants.CalendarConstants.GregorianCalendarConstants.monthNames;
import static com.hypotemoose.cal.constants.CalendarConstants.GregorianCalendarConstants.weekDayNames;
import static com.hypotemoose.cal.util.AlmanacConverter.toGregorianCalendar;

import java.util.Calendar;
import java.util.Objects;

/**
 * A Gregorian Calendar Date.
 * <p>
 * The Gregorian Calendar is internationally the most widely used civil
 * calendar. It was named for Pope Gregory XIII who introduced it on October 15,
 * 1582. The calendar was a refinement to the Julian Calendar, with the
 * motivation of setting the Easter holiday to a specific date instead of the
 * spring equinox, which naturally drifted dates.
 * <p>
 * Each year is divided into 12 months, with a varied number of days per month.
 * To account for the drift in seasons, a leap year occurs which introduces an
 * additional day in February. These leap years happen every year that's
 * divisible by 4, except years that are divisible by 100 but not divisible by
 * 400. For example: 1700, 1800 and 1900 are NOT leap years, but 2000 is a leap
 * year.
 *
 * @author Chris Engelsma
 * @since 2015.11.05
 */
public final class GregorianCalendar extends Almanac {

	/**
	 *
	 */
	private static final long serialVersionUID = 182956764093971616L;
	public static final String CALENDAR_NAME = "Gregorian Calendar";
	public static final JulianDay EPOCH = new JulianDay(2299160.5);

	/**
	 * Constructs a Gregorian Calendar using today's date.
	 */
	public GregorianCalendar() {
		this(Calendar.getInstance());
	}

	/**
	 * Constructs a Gregorian Calendar from another Almanac.
	 *
	 * @param date another Almanac
	 */
	public GregorianCalendar(Almanac date) {
		this(toGregorianCalendar(date));
	}

	/**
	 * Constructs a Gregrian Calendar using a {@link java.util.Calendar}.
	 *
	 * @param cal a {@link java.util.Calendar}.
	 */
	public GregorianCalendar(Calendar cal) {
		this(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
				cal.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * Constructs a Gregorian Calendar given another Gregorian Calendar.
	 *
	 * @param date A Gregorian Calendar.
	 */
	public GregorianCalendar(GregorianCalendar date) {
		this(date.getYear(), date.getMonth(), date.getDay());
	}

	/**
	 * Constructs a Gregorian Calendar from a given day, month and year.
	 *
	 * @param year  The year.
	 * @param month The month.
	 * @param day   The day.
	 */
	public GregorianCalendar(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * Returns today's date as a string. Convenience static method.
	 *
	 * @return today's date.
	 */
	public static String asToday() {
		return (new GregorianCalendar()).toString();
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
			days[i] = GregorianCalendar.getNumberOfDaysInMonth(year, i + 1);
		}
		return days;
	}

	/**
	 * Gets a month name.
	 *
	 * @param month the month number [1-12].
	 * @return the name of the month.
	 * @throws IndexOutOfBoundsException
	 */
	public static String getMonthName(int month)
			throws IndexOutOfBoundsException {
		return monthNames[month - 1];
	}

	/**
	 * Gets the total number of days in a given month and year.
	 *
	 * @param month the month.
	 * @param year  the year.
	 * @return the number of days in the month.
	 */
	public static int getNumberOfDaysInMonth(int year, int month) {
		if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
			return 30;
		}
		if (month == 2) {
			if (!GregorianCalendar.isLeapYear(year)) {
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
	 * @param year a given year.
	 * @return true, if is a leap year; false, otherwise.
	 */
	public static boolean isLeapYear(int year) {
		return GregorianCalendar.isLeapYear(year, true);
	}

	/**
	 * Determines whether a given year is a leap year. This method optionally
	 * determines whether the current date exists before or after the creation
	 * of the Gregorian calendar, and follows that calendar's leap year rule. As
	 * a result, there are "missing dates" (October 4 - 14, 1582).
	 *
	 * @param year         a given year.
	 * @param useProleptic true, if using a proleptic calendar; false,
	 *                     otherwise.
	 * @return true, if year is a leap year; false, otherwise.
	 */
	public static boolean isLeapYear(int year, boolean useProleptic) {
		final GregorianCalendar epoch = new GregorianCalendar(EPOCH);
		final GregorianCalendar date = new GregorianCalendar(year, 1, 1);

		if (useProleptic && datesAreChronological(date, epoch)) {
			return JulianCalendar.isLeapYear(year);
		}

		if ((Math.abs(year) % 4) == 0) {
			if ((Math.abs(year) % 400) == 0) {
				return true;
			}
			if ((Math.abs(year) % 100) == 0) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof GregorianCalendar)) {
			return false;
		}
		if (obj == this) {
			return true;
		}

		final GregorianCalendar date = (GregorianCalendar) obj;
		return (year == date.getYear()) && (month == date.getMonth())
				&& (day == date.getDay());
	}

	/**
	 * Gets the date.
	 *
	 * @return the date.
	 */
	@Override
	public String getDate() {
		return getMonthName() + " " + getDay() + ", " + getYear();
	}

	/**
	 * Gets an array of month-lengths for this year.
	 *
	 * @return an array[12] of month-lengths for this year.
	 */
	public int[] getDaysPerMonthInYear() {
		return GregorianCalendar.getDaysPerMonthInYear(getYear());
	}

	/**
	 * Gets the month name.
	 *
	 * @return the name of the month.
	 */
	public String getMonthName() {
		return GregorianCalendar.getMonthName(month);
	}

	/**
	 * Gets the months.
	 *
	 * @return the months.
	 */
	@Override
	public String[] getMonths() {
		return monthNames;
	}

	@Override
	public String getName() {
		return CALENDAR_NAME;
	}

	/**
	 * Gets the total number of days for this month and year.
	 *
	 * @return the number of days in this month and year.
	 */
	@Override
	public int getNumberOfDaysInMonth() {
		return GregorianCalendar.getNumberOfDaysInMonth(year, month);
	}

	/**
	 * Gets the total number of days in a given month for this year.
	 *
	 * @param month the month.
	 * @return the number of days in a month of this year.
	 */
	public int getNumberOfDaysInMonth(int month) {
		return GregorianCalendar.getNumberOfDaysInMonth(year, this.month);
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
	 * Gets the weekday name for this date.
	 *
	 * @return the weekday name.
	 */
	@Override
	public String getWeekDay() {
		return weekDayNames[getWeekDayNumber()];
	}

	/**
	 * Gets the weekdays.
	 *
	 * @return the weekdays.
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
	 * This method will assume that the leap year is proleptic, meaning it will
	 * back-project the Gregorian Calendar to before it was implemented, making
	 * it not historically accurate prior to October 15, 1582.
	 *
	 * @return true, if this is a leap year; false, otherwise.
	 */
	public boolean isLeapYear() {
		return GregorianCalendar.isLeapYear(year, true);
	}

	/**
	 * Determines whether this date's year is a leap year.
	 * <p>
	 * This method requires the user to specify whether to consider a proleptic
	 * calendar or not.
	 *
	 * @param useProleptic true, if making this calendar proleptic; false,
	 *                     otherwise.
	 * @return true, if this is a leap year; false, otherwise.
	 */
	public boolean isLeapYear(boolean useProleptic) {
		return GregorianCalendar.isLeapYear(year, useProleptic);
	}

	/**
	 * Sets this calendar.
	 *
	 * @param a an almanac.
	 */
	@Override
	public void set(Almanac a) {
		final GregorianCalendar cal = toGregorianCalendar(a);
		year = cal.getYear();
		month = cal.getMonth();
		day = cal.getDay();
	}

	@Override
	public String toString() {
		return CALENDAR_NAME + ": " + getDate();
	}
}
