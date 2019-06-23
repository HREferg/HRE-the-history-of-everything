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

import static com.hypotemoose.cal.constants.CalendarConstants.FrenchRepublicanCalendarConstants.dayNames;
import static com.hypotemoose.cal.constants.CalendarConstants.FrenchRepublicanCalendarConstants.monthNames;
import static com.hypotemoose.cal.constants.CalendarConstants.FrenchRepublicanCalendarConstants.weekDayNames;
import static com.hypotemoose.cal.util.AlmanacConverter.toFrenchRepublicanCalendar;
import static com.hypotemoose.cal.util.RomanNumeralGenerator.itr;
import static com.hypotemoose.cal.util.RomanNumeralGenerator.toRoman;
import static com.hypotemoose.cal.util.Util.its;

import java.util.Calendar;
import java.util.Objects;

/**
 * A date in the French Republican Calendar.
 * <p>
 * The French Republican Calendar (FRC) was a calendar created and used during
 * the French Revolution. It was only used in practice for 12 years starting in
 * late 1793 until it was abolished by Napoleon Bonaparte as an effort to
 * reinstate the catholic church within France. This calendar was later picked
 * up, albeit briefly, during the Paris Commune of 1871.
 * <p>
 * Each year is divided into 12 months (mois), with each month being an equal 30
 * days long, divided out further into 3 weeks (décades) 10 days long. Every
 * year begins on the autumnal equinox as observed in Paris. The slight
 * variation in seaons required the use of 5-6 additional "Sans-culottides"
 * days. While the calendar was adopted on October 24, 1793 (3 Brumaire, An II),
 * the official epoch was set to September 22, 1792 (1 Vendemiaire, An I) to
 * commemorate the founding of the republic.
 * <p>
 * To further reduce the influence of the Church, a Rural Calendar was
 * introduced, naming each day of the year after various crops, minerals,
 * animals and work tools to reflect the changing of the seasons.
 *
 * @author Chris Engelsma
 * @since 2015.11.09
 */
public final class FrenchRepublicanCalendar extends Almanac {

	/**
	 *
	 */
	private static final long serialVersionUID = 4997128806578353363L;
	public static final String CALENDAR_NAME = "French Republican Calendar";
	public static final JulianDay EPOCH = new JulianDay(2375839.5);
	private int _week;

	/**
	 * Constructs a French Republican Calendar for today's date.
	 */
	public FrenchRepublicanCalendar() {
		this(new JulianDay());
	}

	/**
	 * Constructs a French Republican Calendar fromr a given Gregorian Calendar
	 * date.
	 *
	 * @param date a Gregorian Calendar Calendar.
	 */
	public FrenchRepublicanCalendar(Almanac date) {
		this(new JulianDay(date));
	}

	/**
	 * Constructs a new French Republican Calendar from a
	 * {@link java.util.Calendar}.
	 *
	 * @param cal a {@link java.util.Calendar}.
	 */
	public FrenchRepublicanCalendar(Calendar cal) {
		this(new GregorianCalendar(cal));
	}

	/**
	 * Constructs a French Republican date from another French Republican date.
	 *
	 * @param date a French Republican date.
	 */
	public FrenchRepublicanCalendar(FrenchRepublicanCalendar date) {
		this(date.getYear(), date.getMonth(), date.getWeek(), date.getDay());
	}

	/**
	 * Constructs a French Republican Calendar with given year, month and day.
	 *
	 * @param year  the year
	 * @param month the month
	 * @param day   the day
	 */
	public FrenchRepublicanCalendar(int year, int month, int day) {
		this(year, month, (day / 10) + 1, (day % 10));
	}

	/**
	 * Constructs a French Republican Calendar with given year, month, week and
	 * day.
	 *
	 * @param year  the year
	 * @param month the month
	 * @param week  the week
	 * @param day   the day
	 */
	public FrenchRepublicanCalendar(int year, int month, int week, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		_week = week;
	}

	/**
	 * Constructs a French Republican Calendar from a given Julian Day.
	 *
	 * @param jd a Julian Day.
	 */
	public FrenchRepublicanCalendar(JulianDay jd) {
		this(toFrenchRepublicanCalendar(jd));
	}

	/**
	 * Returns today's date as a string. Convenience static method.
	 *
	 * @return today's date.
	 */
	public static String asToday() {
		return (new FrenchRepublicanCalendar()).toString();
	}

	/**
	 * Gets a month name.
	 *
	 * @param month a month number [1-12].
	 * @return a month name
	 * @throws IndexOutOfBoundsException
	 */
	public static String getMonthName(int month)
			throws IndexOutOfBoundsException {
		return monthNames[month - 1];
	}

	/**
	 * Returns the number of days in a given month and year.
	 *
	 * @param month a month.
	 * @param year  a year.
	 * @return the number of days in the month and year.
	 */
	public static int getNumberOfDaysInMonth(int month, int year) {
		return (month == 13) ? (isLeapYear(year) ? 6 : 5) : 30;
	}

	/**
	 * Determines if a given year is a leap year. A leap year is determined by
	 * the day of the autumnal solstice.
	 *
	 * @param year a year.
	 * @return true, if a leap year; false, otherwise.
	 */
	public static boolean isLeapYear(int year) {
		final JulianDay jday1 = new JulianDay(
				new FrenchRepublicanCalendar(year, 1, 1));
		final JulianDay jday2 = new JulianDay(
				new FrenchRepublicanCalendar(year + 1, 1, 1));
		final int val1 = (int) jday1.atNoon().getValue();
		final int val2 = (int) jday2.atNoon().getValue();
		return ((val2 - val1) > 365);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof FrenchRepublicanCalendar)) {
			return false;
		}
		if (obj == this) {
			return true;
		}

		final FrenchRepublicanCalendar date = (FrenchRepublicanCalendar) obj;

		return (year == date.getYear()) && (month == date.getMonth())
				&& (day == date.getDay(false)) && (_week == date.getWeek());
	}

	/**
	 * Gets the date as a string.
	 *
	 * @return the date as a string.
	 */
	@Override
	public String getDate() {
		return (year >= 1)
				? getDay(true) + " " + getMonthName() + ", "
						+ toRoman(getYear())
				: "";
	}

	/**
	 * Gets the day number.
	 *
	 * @param longForm true, if using long form (no decades); false, otherwise.
	 * @return the day.
	 */
	public int getDay(boolean longForm) {
		if (longForm) {
			return ((_week - 1) * 10) + day;
		} else {
			return day;
		}
	}

	/**
	 * Gets the Rural calendar name of the day.
	 *
	 * @return the Rural calendar name of the day.
	 */
	public String getDayName() {
		final int iday = getDay(true);
		return dayNames[month - 1][iday - 1];
	}

	/**
	 * Gets the month name.
	 *
	 * @return the month name
	 */
	public String getMonthName() {
		return getMonthName(month);
	}

	/**
	 * Gets the month names.
	 *
	 * @return the month names.
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
	 * Gets the number of days in this month and year.
	 *
	 * @return the number of days in this month and year.
	 */
	@Override
	public int getNumberOfDaysInMonth() {
		return FrenchRepublicanCalendar.getNumberOfDaysInMonth(month, year);
	}

	/**
	 * Gets the number of days in a given month for this year.
	 *
	 * @param month a month in this year.
	 * @return the number of days in a month of this year.
	 */
	public int getNumberOfDaysInMonth(int month) {
		return FrenchRepublicanCalendar.getNumberOfDaysInMonth(month, year);
	}

	/**
	 * Gets the number of days in a week.
	 *
	 * @return the number of days in a week.
	 */
	@Override
	public int getNumberOfDaysInWeek() {
		return 10;
	}

	/**
	 * Gets the number of months in the year.
	 *
	 * @return the number of months in the year.
	 */
	@Override
	public int getNumberOfMonthsInYear() {
		return 13;
	}

	/**
	 * Gets the 10-day week (décade).
	 *
	 * @return the décade.
	 */
	public int getWeek() {
		return _week;
	}

	/**
	 * Gets the weekday name.
	 *
	 * @return the weekday.
	 */
	@Override
	public String getWeekDay() {
		return (year >= 1) ? weekDayNames[getDay(false) - 1] : "";
	}

	/**
	 * Gets the days of the week.
	 *
	 * @return the days of the week.
	 */
	@Override
	public String[] getWeekDays() {
		return weekDayNames;
	}

	@Override
	public int hashCode() {
		return Objects.hash(year, month, _week, day);
	}

	/**
	 * Determines if this year is a leap year.
	 *
	 * @return true, if a leap year; false, otherwise.
	 */
	public boolean isLeapYear() {
		return FrenchRepublicanCalendar.isLeapYear(year);
	}

	/**
	 * Sets this date to the next day.
	 */
	@Override
	public void nextDay() {
		day = getDay(true);
		super.nextDay();
		_week = (day / 10) + 1;
		day = (day % 10);
	}

	/**
	 * Sets this date to the previous day.
	 */
	@Override
	public void prevDay() {
		day = getDay(true);
		super.prevDay();
		_week = (day / 10) + 1;
		day = (day % 10);
	}

	/**
	 * Prints this date in long form.
	 */
	public void printLong() {
		String out = "French Republican Calendar: ";
		out += "Année " + its(getYear()) + " de la République\n";
		out += "  Mois de " + getMonthName() + "\n";
		out += "  Décade " + itr(getWeek());
		out += " Jour " + itr(getDay(false));
		out += " - \"" + getDayName() + "\"";
		System.out.println(out);
	}

	/**
	 * Sets this calendar.
	 *
	 * @param a an almanac.
	 */
	@Override
	public void set(Almanac a) {
		final FrenchRepublicanCalendar cal = toFrenchRepublicanCalendar(a);
		year = cal.getYear();
		month = cal.getMonth();
		day = cal.getDay();
		_week = cal.getWeek();
	}

	/**
	 * Sets the day.
	 *
	 * @param day the day.
	 */
	@Override
	public void setDay(int day) {
		this.day = (day % 10);
		_week = (day / 10) + 1;
	}

	@Override
	public String toString() {
		return CALENDAR_NAME + ": " + getDate();
	}

}
