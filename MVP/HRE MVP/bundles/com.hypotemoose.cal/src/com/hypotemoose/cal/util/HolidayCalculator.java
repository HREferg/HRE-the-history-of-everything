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
package com.hypotemoose.cal.util;

import static com.hypotemoose.cal.astro.Meeus.equinox;
import static com.hypotemoose.cal.astro.Meeus.getMoonQuarters;

import com.hypotemoose.cal.astro.Season;
import com.hypotemoose.cal.constants.Holiday;
import com.hypotemoose.cal.date.GregorianCalendar;
import com.hypotemoose.cal.date.IslamicCalendar;
import com.hypotemoose.cal.date.JulianDay;

/**
 * A holiday calculator.
 *
 * @author Chris Engelsma
 * @since 2015.11.06
 */
public class HolidayCalculator {

	public static JulianDay get(Holiday holiday, int year) {
		JulianDay jday = new JulianDay();
		IslamicCalendar ic = null;

		switch (holiday) {
		case EASTER: // First Sunday after full moon on or after spring equinox
			jday = getEaster(year);
			break;

		case GOOD_FRIDAY: // Two days before Easter
			jday = get(Holiday.EASTER, year).minus(2);
			break;

		case HOLY_THURSDAY: // Three days before Easter
			jday = get(Holiday.EASTER, year).minus(3);
			break;

		case PALM_SUNDAY: // Sunday before Easter
			jday = get(Holiday.EASTER, year).minus(7);
			break;

		case ASH_WEDNESDAY: // 46 days before Easter.
			jday = get(Holiday.EASTER, year).minus(46);
			break;

		case ASCENSION: // 40 days after Easter.
			jday = get(Holiday.EASTER, year).plus(39);
			break;

		case PENTECOST: // 10 days after Ascension.
			jday = get(Holiday.ASCENSION, year).plus(10);
			break;

		case TRINITY_SUNDAY: // First Sunday after Pentecost
			jday = get(Holiday.PENTECOST, year);
			getFollowingWeekDay(0, jday);
			break;

		case ADVENT: // 4th Sunday before Christmas
			jday = get(Holiday.CHRISTMAS, year);
			getPrecedingWeekDay(0, jday);
			jday.minus(21);
			break;

		case ASHURA: // Fixed on 10 Muharram
			ic = new IslamicCalendar(new GregorianCalendar(year, 1, 1));
			ic.setMonth(1);
			ic.setDay(10);
			if ((new GregorianCalendar(ic)).getYear() < year) {
				ic.setYear(ic.getYear() + 1);
			}
			jday = new JulianDay(ic);
			break;

		case RAMADAN: // Fixed on 1 Ramadan
			ic = new IslamicCalendar(new GregorianCalendar(year, 1, 1));
			ic.setMonth(9);
			ic.setDay(1);
			if ((new GregorianCalendar(ic)).getYear() < year) {
				ic.setYear(ic.getYear() + 1);
			}
			jday = new JulianDay(ic);
			break;

		case EID_AL_FITR:
			ic = new IslamicCalendar(new GregorianCalendar(year, 1, 1));
			ic.setMonth(10);
			ic.setDay(1);
			if ((new GregorianCalendar(ic)).getYear() < year) {
				ic.setYear(ic.getYear() + 1);
			}
			jday = new JulianDay(ic);
			break;

		case EID_AL_ADHA:
			ic = new IslamicCalendar(new GregorianCalendar(year, 1, 1));
			ic.setMonth(12);
			ic.setDay(10);
			if ((new GregorianCalendar(ic)).getYear() < year) {
				ic.setYear(ic.getYear() + 1);
			}
			jday = new JulianDay(ic);
			break;

		case NEW_YEARS_DAY:
			jday = new JulianDay(new GregorianCalendar(year, 1, 1));
			break;

		case MARTIN_LUTHER_KING: // Third Monday in January
			jday = new JulianDay(new GregorianCalendar(year, 1, 1));
			getFollowingWeekDay(1, jday);
			getFollowingWeekDay(1, jday);
			getFollowingWeekDay(1, jday);
			break;

		case WASHINGTONS_BIRTHDAY: // Third Monday in February
			jday = new JulianDay(new GregorianCalendar(year, 2, 1));
			getFollowingWeekDay(1, jday);
			getFollowingWeekDay(1, jday);
			getFollowingWeekDay(1, jday);
			break;

		case MEMORIAL_DAY: // Last Monday in May.
			jday = new JulianDay(new GregorianCalendar(year, 6, 1));
			getPrecedingWeekDay(1, jday);
			break;

		case INDEPENDENCE_DAY: // July 4
			jday = new JulianDay(new GregorianCalendar(year, 7, 4));
			break;

		case LABOR_DAY: // First Monday in May.
			jday = new JulianDay(new GregorianCalendar(year, 9, 1));
			getFollowingWeekDay(1, jday);
			break;

		case COLUMBUS_DAY: // Second Monday in October
			jday = new JulianDay(new GregorianCalendar(year, 10, 1));
			getFollowingWeekDay(1, jday);
			getFollowingWeekDay(1, jday);
			break;

		case VETERANS_DAY: // November 11
			jday = new JulianDay(new GregorianCalendar(year, 11, 11));
			break;

		case THANKSGIVING: // Fourth Thursday in November
			jday = new JulianDay(new GregorianCalendar(year, 11, 1));
			getFollowingWeekDay(4, jday);
			getFollowingWeekDay(4, jday);
			getFollowingWeekDay(4, jday);
			getFollowingWeekDay(4, jday);
			break;

		case CHRISTMAS: // December 25
			jday = new JulianDay(new GregorianCalendar(year, 12, 25));
			break;

		default:
		}

		return jday;
	}

//////////////////////////////////////////////////////////////////////////////
// protected

	protected static JulianDay getEaster(int year) {
		final double eq = equinox(year, Season.SPRING);
		double full = eq;
		GregorianCalendar cal = new GregorianCalendar(new JulianDay(eq));
		int month = cal.getMonth();
		final int day = cal.getDay();
		while (full <= eq) {
			full = getMoonQuarters(year, month++, day)[2];
		}
		cal = new GregorianCalendar(new JulianDay(full));
		if (cal.getWeekDayNumber() == 0) {
			cal.nextDay();
		}
		while (cal.getWeekDayNumber() > 0) {
			cal.nextDay();
		}
		return new JulianDay(cal);
	}

	protected static JulianDay getFollowingWeekDay(int wd, JulianDay day) {
		if (day.getWeekDayNumber() == wd) {
			day.nextDay();
		}
		while (day.getWeekDayNumber() != wd) {
			day.nextDay();
		}
		return day;
	}

	protected static JulianDay getPrecedingWeekDay(int wd, JulianDay day) {
		if (day.getWeekDayNumber() == wd) {
			day.prevDay();
		}
		while (day.getWeekDayNumber() != wd) {
			day.prevDay();
		}
		return day;
	}

}
