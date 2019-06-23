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
package com.hypotemoose.cal.constants;

/**
 * Religious and secular holidays.
 *
 * @author Chris Engelsma
 * @since 2015.11.06
 */
public enum Holiday {
	// Catholic
	ASH_WEDNESDAY(0), PALM_SUNDAY(1), HOLY_THURSDAY(2), GOOD_FRIDAY(3),
	EASTER(4), ASCENSION(5), PENTECOST(6), TRINITY_SUNDAY(7), ADVENT(8),

	// Islamic
	ASHURA(9), RAMADAN(10), EID_AL_FITR(11), EID_AL_ADHA(12),

	// Jewish
	PASSOVER(13), SHAVUOT(14), ROSH_HASHANAH(15), YOM_KIPPUR(16), SUKKOT(17),
	SHEMINI_ATZERET(18),

	// US Federal Holidays
	NEW_YEARS_DAY(20), MARTIN_LUTHER_KING(21), WASHINGTONS_BIRTHDAY(22),
	MEMORIAL_DAY(23), INDEPENDENCE_DAY(24), LABOR_DAY(25), COLUMBUS_DAY(26),
	VETERANS_DAY(27), THANKSGIVING(28), CHRISTMAS(29);

	private final int value;

	Holiday(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
