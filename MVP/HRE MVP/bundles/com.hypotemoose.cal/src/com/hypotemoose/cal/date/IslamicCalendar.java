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

import static com.hypotemoose.cal.constants.CalendarConstants.IslamicCalendarConstants.monthNames;
import static com.hypotemoose.cal.constants.CalendarConstants.IslamicCalendarConstants.weekDayNames;
import static com.hypotemoose.cal.util.AlmanacConverter.toIslamicCalendar;

import java.util.Calendar;
import java.util.Objects;

/**
 * An Islamic (Hijri) calendar date.
 * <p>
 * The Islamic, or Hijri calendar, is a lunar calendar currently used in many
 * Muslim countries and also used by Muslims to determine the proper days on
 * which to observing the annual fasting, to attend Hajj, and to celebrate other
 * Islamic holidays and festivals. The calendar consists of 12 months with a
 * year of 354 days. The lengths of the months are determined by the birth of a
 * new lunar cycle, which historically resulted in each month being 29 or 30
 * days depending on the visibility of the moon. However, certain sects and
 * groups now use a tabular Islamic calendar, in which odd-numbered months have
 * thirty days, and even months have 29.
 *
 * As of now, this only supports the tabular Islamic calendar.
 *
 * Leap years are determined differently depending on the location and religious
 * sect. The four used here include the following 30-year leap-year patterns:
 *
 * West Islamic (base-16): 2, 5, 7, 10, 13, 16, 18, 21, 24, 26, 29 East Islamic
 * (base-15): 2, 5, 7, 10, 13, 15, 18, 21, 24, 26, 29 Taiyabi Ismaili (Fatimid):
 * 2, 5, 8, 10, 13, 16, 19, 21, 24, 27, 29 Habash Al Hasib: 2, 5, 8, 11, 13, 16,
 * 19, 21, 24, 27, 30
 *
 * @author Chris Engelsma
 * @since 2016.05.22
 */
public class IslamicCalendar extends Almanac {

	/**
	 * The calendar type (astronomical versus civil). This determines the
	 * starting epoch.
	 */
	public enum CalendarType {
		CIVIL(0), ASTRONOMICAL(1);

		private final int value;

		private CalendarType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	/**
	 * The leap year rule.
	 */
	public enum LeapYearRule {
		WEST_ISLAMIC, EAST_ISLAMIC, TAIYABI_ISMAILI, HABASH_AL_HASIB
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -1012965259007700581L;

	public static final String CALENDAR_NAME = "Islamic Calendar";
	public static final JulianDay EPOCH = new JulianDay(1948439.5);

	private CalendarType calendarType;

	private LeapYearRule leapYearRule;

	/**
	 * Constructs an Islamic calendar.
	 */
	public IslamicCalendar() {
		this(new JulianDay());
	}

	/**
	 * Constructs an Islamic calendar. Note: This constructs a civil calendar
	 * with a base-16 leap year rule.
	 *
	 * @param a an Almanac.
	 */
	public IslamicCalendar(Almanac a) {
		this(toIslamicCalendar(a));
	}

	/**
	 * Constructs a new Islamic Calendar from a {@link java.util.Calendar}.
	 *
	 * @param cal a {@link java.util.Calendar}.
	 */
	public IslamicCalendar(Calendar cal) {
		this(new GregorianCalendar(cal));
	}

	/**
	 * Constructs an Islamic calendar. Note: This constructs a civil calendar
	 * using a base-16 leap year rule.
	 *
	 * @param year  a year
	 * @param month a month
	 * @param day   a day
	 */
	public IslamicCalendar(int year, int month, int day) {
		this(year, month, day, CalendarType.CIVIL);
	}

	/**
	 * Constructs an Islamic calendar. Note: This constructs a calendar using a
	 * base-16 leap year rule.
	 *
	 * @param year         a year
	 * @param month        a month
	 * @param day          a day
	 * @param calendarType a calendar type
	 */
	public IslamicCalendar(int year, int month, int day,
			CalendarType calendarType) {
		this(year, month, day, calendarType, LeapYearRule.WEST_ISLAMIC);
	}

	/**
	 * Constructs an Islamic calendar.
	 *
	 * @param year         a year
	 * @param month        a month
	 * @param day          a day
	 * @param calendarType a calendar type
	 * @param leapYearRule a leap year rule
	 */
	public IslamicCalendar(int year, int month, int day,
			CalendarType calendarType, LeapYearRule leapYearRule) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.calendarType = calendarType;
		this.leapYearRule = leapYearRule;
	}

	/**
	 * Constructs an Islamic calendar.
	 *
	 * @param year         a year
	 * @param month        a month
	 * @param day          a day
	 * @param leapYearRule a leap year rule.
	 */
	public IslamicCalendar(int year, int month, int day,
			LeapYearRule leapYearRule) {
		this(year, month, day, CalendarType.CIVIL, leapYearRule);
	}

	/**
	 * Constructs an Islamic calendar.
	 *
	 * @param date an Islamic date.
	 */
	public IslamicCalendar(IslamicCalendar date) {
		this(date.getYear(), date.getMonth(), date.getDay(),
				date.getCalendarType(), date.getLeapYearRule());
	}

	/**
	 * Gets the number of days for each month in a year. Note: this method
	 * employs a base-16 leap year rule.
	 *
	 * @param year a year
	 * @return an array[12] of month lengths
	 */
	public static int[] getDaysPerMonthInYear(int year) {
		return getDaysPerMonthInYear(year, LeapYearRule.WEST_ISLAMIC);
	}

	/**
	 * Gets the number of days for each month in a year.
	 *
	 * @param year         a year
	 * @param leapYearRule a leap year rule
	 * @return an array[12] of month lengths
	 */
	public static int[] getDaysPerMonthInYear(int year,
			LeapYearRule leapYearRule) {
		final int[] days = new int[12];
		for (int i = 0; i < 12; ++i) {
			days[i] = getNumberOfDaysInMonthInYear(i + 1, year, leapYearRule);
		}
		return days;
	}

	/**
	 * Gets the name of a given month.
	 *
	 * @param month the month number [1 - 12].
	 * @throws IndexOutOfBoundsException
	 * @return the name of the month.
	 */
	public static String getMonthName(int month)
			throws IndexOutOfBoundsException {
		return IslamicCalendar.getMonthNames()[month - 1];
	}

	/**
	 * Gets the names of the months.
	 *
	 * @return the names of the months.
	 */
	public static String[] getMonthNames() {
		return monthNames;
	}

	/**
	 * Gets the number of days in a given month. Note: this method will employ
	 * the base-16 leap year rule.
	 *
	 * @param month a month
	 * @param year  a year
	 * @return the number of days in the month
	 */
	public static int getNumberOfDaysInMonthInYear(int month, int year) {
		return getNumberOfDaysInMonthInYear(month, year,
				LeapYearRule.WEST_ISLAMIC);
	}

	/**
	 * Gets the number of days in a given month.
	 *
	 * @param month        a month
	 * @param year         a year
	 * @param leapYearRule a leap year rule
	 * @return the number of days in a month
	 */
	public static int getNumberOfDaysInMonthInYear(int month, int year,
			LeapYearRule leapYearRule) {
		if (((month % 2) != 0)
				|| ((month == 12) && isLeapYear(year, leapYearRule))) {
			return 30;
		}
		return 29;
	}

	/**
	 * Gets the number of days in a year. Note: this method employs a base-16
	 * leap year rule.
	 *
	 * @param year a year
	 * @return the number of days in a year
	 */
	public static int getNumberOfDaysInYear(int year) {
		return getNumberOfDaysInYear(year, LeapYearRule.WEST_ISLAMIC);
	}

	/**
	 * Gets the number of days in a year.
	 *
	 * @param year         a year
	 * @param leapYearRule a leap year rule
	 * @return the number of days in the year
	 */
	public static int getNumberOfDaysInYear(int year,
			LeapYearRule leapYearRule) {
		int sum = 0;
		final int[] days = getDaysPerMonthInYear(year, leapYearRule);
		for (int i = 0; i < 12; ++i) {
			sum += days[i];
		}
		return sum;
	}

	/**
	 * Determines if a given year is a leap year. Note: This method employs the
	 * base 16 leap year rule.
	 *
	 * @param year a year.
	 * @return true, if a leap year; false, otherwise.
	 */
	public static boolean isLeapYear(int year) {
		return isLeapYear(year, LeapYearRule.WEST_ISLAMIC);
	}

	/**
	 * Determines if a given year is a leap year with a provided leap year rule.
	 *
	 * @param year         a year
	 * @param leapYearRule a leap year rule.
	 * @return true, if a leap year; false, otherwise.
	 */
	public static boolean isLeapYear(int year, LeapYearRule leapYearRule) {
		int shift = 14; // Default is WEST_ISLAMIC
		switch (leapYearRule) {
		case HABASH_AL_HASIB:
			shift = 9;
			break;
		case TAIYABI_ISMAILI:
			shift = 11;
			break;
		case EAST_ISLAMIC:
			shift = 15;
			break;
		default:
			break;
		}
		return ((((year * 11) + shift) % 30) < 11);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IslamicCalendar)) {
			return false;
		}
		if (obj == this) {
			return true;
		}

		final IslamicCalendar date = (IslamicCalendar) obj;
		return (day == date.getDay()) && (month == date.getMonth())
				&& (year == date.getYear())
				&& (calendarType == date.getCalendarType())
				&& (leapYearRule == date.getLeapYearRule());
	}

	/**
	 * Gets the calendar type.
	 *
	 * @return the calendar type
	 */
	public CalendarType getCalendarType() {
		return calendarType;
	}

	/**
	 * Gets the date as a string.
	 *
	 * @return the date as a string.
	 */
	@Override
	public String getDate() {
		return getDay() + " " + getMonthName() + ", " + getYear();
	}

	/**
	 * Gets the number of days for each month in this year.
	 *
	 * @return an array[12] of day counts per month
	 */
	public int[] getDaysPerMonthInYear() {
		return IslamicCalendar.getDaysPerMonthInYear(year, leapYearRule);
	}

	/**
	 * Gets the leap year rule.
	 *
	 * @return the leap year rule.
	 */
	public LeapYearRule getLeapYearRule() {
		return leapYearRule;
	}

	/**
	 * Gets this month's name.
	 *
	 * @return this month's name.
	 */
	public String getMonthName() {
		return monthNames[month - 1];
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
	 * Gets the number of days in this month.
	 *
	 * @return the number of days in this month.
	 */
	@Override
	public int getNumberOfDaysInMonth() {
		return IslamicCalendar.getNumberOfDaysInMonthInYear(getMonth(),
				getYear());
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
	 * @return the weekday.
	 */
	@Override
	public String getWeekDay() {
		return weekDayNames[getWeekDayNumber()];
	}

	/**
	 * Gets the days of the week.
	 *
	 * @return an array[7] of the weekday names.
	 */
	@Override
	public String[] getWeekDays() {
		return weekDayNames;
	}

	@Override
	public int hashCode() {
		return Objects.hash(year, month, day, calendarType, leapYearRule);
	}

	/**
	 * Determines if this year is a leap year.
	 *
	 * @return true, if a leap year; false, otherwise.
	 */
	public boolean isLeapYear() {
		return IslamicCalendar.isLeapYear(year, leapYearRule);
	}

	/**
	 * Sets this calendar.
	 *
	 * @param a an almanac.
	 */
	@Override
	public void set(Almanac a) {
		final IslamicCalendar cal = toIslamicCalendar(a);
		year = cal.getYear();
		month = cal.getMonth();
		day = cal.getDay();
	}

	/**
	 * Sets the calendar type.
	 *
	 * @param calendarType a calendar type
	 */
	public void setCalendarType(CalendarType calendarType) {
		this.calendarType = calendarType;
	}

	/**
	 * Sets the leap year rule.
	 *
	 * @param leapYearRule a leap year rule.
	 */
	public void setLeapYearRule(LeapYearRule leapYearRule) {
		if (this.leapYearRule != leapYearRule) {
		}
		this.leapYearRule = leapYearRule;
	}

	@Override
	public String toString() {
		return CALENDAR_NAME + ": " + getDate();

	}

}
