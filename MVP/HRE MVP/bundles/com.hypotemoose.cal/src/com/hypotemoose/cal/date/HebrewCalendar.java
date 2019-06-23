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

import static com.hypotemoose.cal.constants.CalendarConstants.HebrewCalendarConstants.monthNames;
import static com.hypotemoose.cal.constants.CalendarConstants.HebrewCalendarConstants.weekDayNames;
import static com.hypotemoose.cal.util.AlmanacConverter.toHebrewCalendar;
import static com.hypotemoose.cal.util.AlmanacConverter.toJulianDay;

import java.util.Calendar;
import java.util.Objects;

/**
 * A Hebrew Calendar Date.
 * <p>
 * The Hebrew (Jewish) calendar is a calendar used predominantly for Jewish
 * religious observances. It determines the dates for Jewish holidays and the
 * appropriate public reading of Torah portions. In Israel, it is used for
 * religious purposes, provides a time frame for agriculture and is an official
 * calendar used for civil purposes.
 * <p>
 *
 * @author Chris Engelsma
 * @since 2015.12.13
 */
public class HebrewCalendar extends Almanac {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static final String CALENDAR_NAME = "Hebrew Calendar";
	public static final JulianDay EPOCH = new JulianDay(347995.5);

	/**
	 * Constructs a Hebrew Calendar using today's date.
	 */
	public HebrewCalendar() {
		this(Calendar.getInstance());
	}

	/**
	 * Constructs a Hebrew Calendar from another Almanac.
	 *
	 * @param a another Almanac
	 */
	public HebrewCalendar(Almanac a) {
		this(toHebrewCalendar(a));
	}

	/**
	 * Constructs a new Hebrew Calendar from a {@link java.util.Calendar}.
	 *
	 * @param cal a java util calendar.
	 */
	public HebrewCalendar(Calendar cal) {
		this(new GregorianCalendar(cal));
	}

	/**
	 * Constructs a Hebrew Calendar given another Hebrew Calendar.
	 *
	 * @param date A Hebrew Calendar.
	 */
	public HebrewCalendar(HebrewCalendar date) {
		this(date.getYear(), date.getMonth(), date.getDay());
	}

	/**
	 * Constructs a Hebrew Calendar from a given day, month and year.
	 *
	 * @param year  a year.
	 * @param month a month.
	 * @param day   a day.
	 */
	public HebrewCalendar(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * Gets an array of month-lengths for a given year.
	 *
	 * @param year a year.
	 * @return an array of month-lengths for a given year.
	 */
	public static int[] getDaysPerMonthInYear(int year) {
		final int n = HebrewCalendar.getNumberOfMonthsInYear(year);
		final int[] days = new int[n];
		for (int i = 0; i < n; ++i) {
			days[i] = HebrewCalendar.getNumberOfDaysInMonth(year, i + 1);
		}
		return days;
	}

	/**
	 * Gets the name of a given month.
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
	 * Gets the total number of days for a given month and year.
	 *
	 * @param year  a month.
	 * @param month a month (Starting at 1).
	 * @return the number of days in a given month and year.
	 */
	public static int getNumberOfDaysInMonth(int year, int month) {

		// Fixed 29-day months.
		if ((month == 2) || (month == 4) || (month == 6) || (month == 10)
				|| (month == 13)) {
			return 29;
		}

		// Adar has 29 days on non-leap years.
		if ((month == 12) && !HebrewCalendar.isLeapYear(year)) {
			return 29;
		}

		// Heshvan (8) and Kislev (9) depend on length of the year
		if ((month == 8) && !((getNumberOfDaysInYear(year) % 10) == 5)) {
			return 29;
		}
		if ((month == 9) && ((getNumberOfDaysInYear(year) % 10) == 3)) {
			return 29;
		}

		return 30;
	}

	public static int getNumberOfDaysInYear(int year) {
		final HebrewCalendar now = new HebrewCalendar(year, 7, 1);
		final HebrewCalendar next = new HebrewCalendar(year + 1, 7, 1);
		final JulianDay jnow = toJulianDay(now);
		final JulianDay jnext = toJulianDay(next);
		final int num = (int) (jnext.getValue() - jnow.getValue());
		return num;
	}

	/**
	 * Gets the number of months in a year.
	 *
	 * @param year a year.
	 * @return the number of months in the given year.
	 */
	public static int getNumberOfMonthsInYear(int year) {
		return HebrewCalendar.isLeapYear(year) ? 13 : 12;
	}

	/**
	 * Determines whether a given year is a leap year.
	 *
	 * @param year the year.
	 * @return true, if a leap year; false, otherwise.
	 */
	public static boolean isLeapYear(int year) {
		final int val = ((7 * year) + 1) % 19;
		return (val < 7);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof HebrewCalendar)) {
			return false;
		}
		if (obj == this) {
			return true;
		}

		final HebrewCalendar date = (HebrewCalendar) obj;

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
		return getDay() + " " + getMonthName() + ", " + getYear();
	}

	/**
	 * Gets an array of month-lengths for this year.
	 *
	 * @return an array of month-lengths for this year.
	 */
	public int[] getDaysPerMonthInYear() {
		return HebrewCalendar.getDaysPerMonthInYear(getYear());
	}

	/**
	 * Gets the name of this month.
	 *
	 * @return the name of this month.
	 */
	public String getMonthName() {
		return HebrewCalendar.getMonthName(month);
	}

	/**
	 * Gets the months
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
		return HebrewCalendar.getNumberOfDaysInMonth(year, month);
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
		return HebrewCalendar.getNumberOfMonthsInYear(year);
	}

	/**
	 * Gets the weekday name.
	 *
	 * @return the weekday.
	 */
	@Override
	public String getWeekDay() {
		return weekDayNames[getWeekDayNumber()];
	}

	@Override
	public int hashCode() {
		return Objects.hash(year, month, day);
	}

	/**
	 * Determines whether this year is a leap year.
	 *
	 * @return true, if a leap year; false, otherwise.
	 */
	public boolean isLeapYear() {
		return HebrewCalendar.isLeapYear(year);
	}

	@Override
	public void nextDay() {
		if (day == getNumberOfDaysInMonth()) {
			if (month == getNumberOfMonthsInYear()) {
				month = 1;
			} else {
				month++;
				if (month == 7) {
					year++;
				}
			}
			day = 1;
		} else {
			day++;
		}
	}

	/**
	 * Sets this calendar.
	 *
	 * @param a an almanac.
	 */
	@Override
	public void set(Almanac a) {
		final HebrewCalendar cal = toHebrewCalendar(a);
		set(cal.getYear(), cal.getMonth(), cal.getDay());
	}

	/**
	 * Sets this calendar.
	 *
	 * @param year  a year.
	 * @param month a month.
	 * @param day   a day.
	 */
	public void set(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public String toString() {
		return CALENDAR_NAME + ": " + getDate();
	}
}
