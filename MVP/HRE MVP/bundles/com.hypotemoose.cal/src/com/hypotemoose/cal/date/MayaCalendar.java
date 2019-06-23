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

import static com.hypotemoose.cal.util.AlmanacConverter.toMayaCalendar;

import java.util.Objects;

/**
 * A date in the Maya calendar.
 * <p>
 * The Maya calendar is not one calendar per se, but rather a system of
 * calendars employed by pre-Columbian Mesoamerica. In many modern communities
 * in Guatemala and Mexico, this calendar is still used today.
 * <p>
 * The Maya calendar consists of several cycles (or counts) of different
 * lengths. The 260-day calendar, or <em>Tzolk'in</em>, was combined with the
 * 365-day calendar, or <em>Haab'</em> to form a synchronized cycle lasting for
 * 52 Haab' called the Calendar Round. To measure periods longer than this, the
 * Maya used the Long Count calendar.
 * <p>
 * The Long Count calendar is a vigesimal (base-20) and base-18 calendar.
 * Conversion between Maya count units are as follows: <code>
 * Long Count Unit  |  Long Count Period  | Days
 * 1 K'in           |                     | 1
 * 1 Uinal          | 20 K'in             | 20
 * 1 Tun            | 18 Uinal            | 360
 * 1 K'atun         | 20 Tun              | 7,200
 * 1 B'ak'tun       | 20 K'atun           | 144,000
 * 1 Piktun         | 20 B'ak'tun         | 2,880,000
 * 1 Kalabtun       | 20 Piktun           | 57,600,000
 * 1 K'inchiltun    | 20 Kalabtun         | 1,152,000,000
 * 1 Alautun        | 20 K'inchiltun      | 23,040,000,000
 * </code>
 * <p>
 * Note: It is a common misconception to use the term "Mayan" calendar, when
 * this term is actually an Indo-European invention. It is unlikely that this
 * would cause anyone to be upset, and in our contemporary vernacular these
 * words have become interchangeable.
 *
 * @author Chris Engelsma
 * @since 2015.08.24
 */
public class MayaCalendar extends Almanac {

	/**
	 *
	 */
	private static final long serialVersionUID = 785264680515567705L;
	public static final String CALENDAR_NAME = "Maya Calendar";
	public static final JulianDay EPOCH = new JulianDay(584282.5);
	private int _kin;
	private int _uinal;
	private int _tun;
	private int _katun;
	private int _baktun;

	/**
	 * Constructs a date in the Maya calendar. The calendar will default to
	 * today's date.
	 */
	public MayaCalendar() {
		this(new JulianDay());
	}

	/**
	 * Constructs a Maya calendar.
	 *
	 * @param a an Almanac.
	 */
	public MayaCalendar(Almanac a) {
		this(toMayaCalendar(a));
	}

	/**
	 * Constructs a Maya calendar.
	 *
	 * @param baktun a specified B'aktun.
	 * @param katun  a specified K'atun.
	 * @param tun    a specified Tun.
	 * @param uinal  a specified Uinal.
	 * @param kin    a specified K'in.
	 */
	public MayaCalendar(int baktun, int katun, int tun, int uinal, int kin) {
		super();
		_baktun = baktun;
		_katun = katun;
		_tun = tun;
		_uinal = uinal;
		_kin = kin;

		day = kin;
		month = uinal;
		year = tun;
	}

	/**
	 * Constructs a Maya calendar from another Maya calendar.
	 *
	 * @param cal a Maya calendar.
	 */
	public MayaCalendar(MayaCalendar cal) {
		this(cal.getBaktun(), cal.getKatun(), cal.getTun(), cal.getUinal(),
				cal.getKin());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof MayaCalendar)) {
			return false;
		}
		if (obj == this) {
			return true;
		}

		final MayaCalendar date = (MayaCalendar) obj;

		return (_kin == date.getKin()) && (_uinal == date.getUinal())
				&& (_tun == date.getTun()) && (_katun == date.getKatun())
				&& (_baktun == date.getBaktun());
	}

	/**
	 * Gets this B'aktun. A B'aktun is equal to 20 K'atun which is equal to
	 * 144,000 days.
	 *
	 * @return This B'aktun.
	 */
	public int getBaktun() {
		return _baktun;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date.
	 */
	@Override
	public String getDate() {
		return new String(_baktun + "." + _katun + "." + _tun + "." + _uinal
				+ "." + _kin);
	}

	/**
	 * Gets this K'atun. A K'atun is equal to 20 Tun, which is equal to 7,200
	 * days.
	 *
	 * @return This K'atun.
	 */
	public int getKatun() {
		return _katun;
	}

	/**
	 * Gets this K'in. The K'in is the smallest unit of Maya calendar time. It
	 * is equal to 1 day.
	 *
	 * @return This K'in.
	 */
	public int getKin() {
		return _kin;
	}

	@Override
	public String getName() {
		return CALENDAR_NAME;
	}

	/**
	 * Gets the number of days in a month (katun).
	 *
	 * @return the number of days in a month (katun).
	 */
	@Override
	public int getNumberOfDaysInMonth() {
		return 20;
	}

	/**
	 * Gets the number of days in a week. In the Maya calendar, there is no
	 * concept of a week, so the value returned is one.
	 *
	 * @return the number of days in a week.
	 */
	@Override
	public int getNumberOfDaysInWeek() {
		return 1;
	}

/////////////////////////////////////////////////////////////////////////////
// private

	/**
	 * Gets the number of months (katun) in a year (tun).
	 *
	 * @return the number of months (katun) in a year (tun).
	 */
	@Override
	public int getNumberOfMonthsInYear() {
		return 360;
	}

	/**
	 * Gets this Tun. A Tun is equal to 18 Uinal, which is equal to 360 days.
	 *
	 * @return This Tun.
	 */
	public int getTun() {
		return _tun;
	}

	/**
	 * Gets this Uinal. A Uinal is equal to 20 K'in, which is equal to 20 days.
	 *
	 * @return This Uinal.
	 */
	public int getUinal() {
		return _uinal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(_kin, _uinal, _tun, _katun, _baktun);
	}

	/**
	 * Sets this calendar.
	 *
	 * @param a an almanac.
	 */
	@Override
	public void set(Almanac a) {
		final MayaCalendar cal = toMayaCalendar(a);
		_kin = cal.getKin();
		_uinal = cal.getUinal();
		_tun = cal.getTun();
		_katun = cal.getKatun();
		_baktun = cal.getBaktun();
	}

	/**
	 * Sets this B'aktun
	 *
	 * @param baktun the B'aktun.
	 */
	public void setBaktun(int baktun) {
		_baktun = baktun;
	}

	/**
	 * Sets this K'atun
	 *
	 * @param katun the K'atun.
	 */
	public void setKatun(int katun) {
		_katun = katun;
	}

	/**
	 * Sets this K'in.
	 *
	 * @param kin the K'in.
	 */
	public void setKin(int kin) {
		_kin = kin;
	}

	/**
	 * Sets this Tun.
	 *
	 * @param tun the Tun.
	 */
	public void setTun(int tun) {
		_tun = tun;
	}

	/**
	 * Sets this Uinal.
	 *
	 * @param uinal the Uinal.
	 */
	public void setUinal(int uinal) {
		_uinal = uinal;
	}

	@Override
	public String toString() {
		return (CALENDAR_NAME + ": " + getDate());
	}
}
