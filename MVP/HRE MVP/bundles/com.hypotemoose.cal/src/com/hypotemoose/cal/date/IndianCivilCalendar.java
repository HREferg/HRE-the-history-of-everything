/*****************************************************************************
 * Copyright 2017 Chris Engelsma
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

import static com.hypotemoose.cal.constants.CalendarConstants.IndianCivilCalendarConstants.monthNames;
import static com.hypotemoose.cal.util.AlmanacConverter.toIndianCivilCalendar;

import java.util.Calendar;
import java.util.Objects;

import com.hypotemoose.cal.constants.CalendarConstants;

/**
 * An Indian Civil Calendar.
 * <p>
 * While a plethora of calendars exist in India, the government adopted an
 * official calendar in 1957 to be used for civil purposes. The calendar is
 * comprised of 12 months. The first month, Chaitra, contains 30 days in a
 * normal year and 31 days in a leap year, followed by five 30-day months and
 * then six 31-day months. Leap years occur in the same year as a Gregorian
 * year, so the two calendars are remain synchronized.
 *
 * The calendar begins counting from the start of the Saka era, which occurs on
 * March 22, 79 in the Gregorian calendar.
 *
 * @author Chris Engelsma
 * @since 2017.08.03
 */
public class IndianCivilCalendar extends Almanac {

	/**
	 *
	 */
	private static final long serialVersionUID = 4045737840665086075L;
	public static final String CALENDAR_NAME = "Indian Civil Calendar";
	public static final JulianDay EPOCH = new JulianDay(1749994.5);

	/**
	 * Constructs a new Indian Civil Calendar for today's date.
	 */
	public IndianCivilCalendar() {
		this(new JulianDay());
	}

	/**
	 * Constructs a new Indian Civil Calendar from another Almanac.
	 *
	 * @param a an almanac.
	 */
	public IndianCivilCalendar(Almanac a) {
		this(toIndianCivilCalendar(a));
	}

	/**
	 * Constructs a new Indian Civil Calendar using a
	 * {@link java.util.Calendar}.
	 *
	 * @param cal a calendar.
	 */
	public IndianCivilCalendar(Calendar cal) {
		this(new GregorianCalendar(cal));
	}

	/**
	 * Constructs a new Indian Civil Calendar from another Indian Civil
	 * Calendar.
	 *
	 * @param date a calendar.
	 */
	public IndianCivilCalendar(IndianCivilCalendar date) {
		this(date.getYear(), date.getMonth(), date.getDay());
	}

	/**
	 * Constructs a new Indian Civil calendar.
	 *
	 * @param year  a year.
	 * @param month a month [1 - 12].
	 * @param day   a day.
	 */
	public IndianCivilCalendar(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
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
	 * Determines if a given Indian Civil year is a leap year.
	 *
	 * @param year a year in the Indian Civil Calendar.
	 * @return true, if is a leap year; false, otherwise.
	 */
	public static boolean isLeapYear(int year) {
		return GregorianCalendar.isLeapYear(year + 78, false);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IndianCivilCalendar)) {
			return false;
		}
		if (obj == this) {
			return true;
		}

		final IndianCivilCalendar date = (IndianCivilCalendar) obj;
		return (day == date.getDay()) && (month == date.getMonth())
				&& (year == date.getYear());
	}

	@Override
	public String getDate() {
		return getDay() + " " + getMonthName() + ", " + getYear();
	}

	/**
	 * Gets the name of this calendar's month.
	 *
	 * @return the name of this calendar's month.
	 */
	public String getMonthName() {
		return IndianCivilCalendar.getMonthName(month);
	}

	/**
	 * Gets the months
	 *
	 * @return the months.
	 */
	@Override
	public String[] getMonths() {
		return CalendarConstants.IndianCivilCalendarConstants.monthNames;
	}

	@Override
	public String getName() {
		return CALENDAR_NAME;
	}

	@Override
	public int getNumberOfDaysInMonth() {
		if (month == 1) {
			return this.isLeapYear() ? 31 : 30;
		}
		return (month >= 7) ? 30 : 31;
	}

	@Override
	public int getNumberOfDaysInWeek() {
		return 7;
	}

	@Override
	public int getNumberOfMonthsInYear() {
		return 12;
	}

	@Override
	public int hashCode() {
		return Objects.hash(year, month, day);
	}

	/**
	 * Determines if this calendar falls in a leap year.
	 *
	 * @return true, if this calendar falls in a leap year; false, otherwise.
	 */
	public boolean isLeapYear() {
		return isLeapYear(year);
	}

	@Override
	public void set(Almanac a) {
		final IndianCivilCalendar cal = toIndianCivilCalendar(a);
		year = cal.getYear();
		month = cal.getMonth();
		day = cal.getDay();
	}

}
