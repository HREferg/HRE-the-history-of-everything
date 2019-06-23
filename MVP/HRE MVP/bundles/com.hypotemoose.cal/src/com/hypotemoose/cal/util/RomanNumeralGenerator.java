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

/**
 * A Roman Numeral Generator.
 * <p>
 * The numeric system used in ancient Rome, roman numerals employs combinations
 * of letters from the Latin alphabet to signify values. After the 14th century,
 * Roman numerals began to be replaced in most contexts by Arabic numbers.
 *
 * @author Chris Engelsma
 * @since 2015.09.22
 */
public final class RomanNumeralGenerator {

	private static int[] _numbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10,
			9, 5, 4, 1 };
	private static String[] _letters = { "M", "CM", "D", "CD", "C", "XC", "L",
			"XL", "X", "IX", "V", "IV", "I" };

	/**
	 * Converts an Arabic number to a Roman numeral.
	 * <p>
	 * Short-hand method call.
	 *
	 * @param arabic an Arabic number.
	 * @return a Roman numeral.
	 */
	public static String itr(int arabic) {
		return toRoman(arabic);
	}

	private static int ltn(char letter) {
		switch (letter) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			throw new NumberFormatException(
					"\"" + letter + "\" not an acceptable roman numeral");
		}
	}

/////////////////////////////////////////////////////////////////////////////
// private

	/**
	 * Converts a Roman numeral to an Arabic number.
	 * <p>
	 * Short-hand method call.
	 *
	 * @param roman a Roman numeral.
	 * @return an Arabic number.
	 */
	public static int rti(String roman) {
		return toArabic(roman);
	}

	/**
	 * Converts a Roman numeral to an Arabic number.
	 *
	 * @param roman a Roman numeral.
	 * @return an Arabic number.
	 */
	public static int toArabic(String roman) {
		int arabic = 0;
		int i = 0;
		if (roman.length() == 0) {
			throw new NumberFormatException(
					"Roman numeral string can't be empty");
		}
		roman = roman.toUpperCase();
		while (i < roman.length()) {
			final char letter = roman.charAt(i);
			final int number = ltn(letter);
			i++;
			if (i == roman.length()) {
				arabic += number;
			} else {
				final int next = ltn(roman.charAt(i));
				if (next > number) {
					arabic += (next - number);
					i++;
				} else {
					arabic += number;
				}
			}
		}

		return arabic;
	}

	/**
	 * Converts an Arabic number to a Roman numeral.
	 *
	 * @param arabic Arabic number.
	 * @return a Roman numeral.
	 */
	public static String toRoman(int arabic) {
		String roman = "";

		/*
		 * The concept of zero and negative numbers wasn't realized until the
		 * arabic number system much later in history.
		 */
		if (arabic < 1) {
			throw new NumberFormatException("Roman numeral must be positive");
		}

		/*
		 * Roman Numerals starting at 4000 have a horizontal line above the
		 * first numeral denoting "x 1000", and there's no easy way to show that
		 * here.
		 */
		if (arabic > 3999) {
			throw new NumberFormatException("Value must be 3999 or less");
		}

		for (int i = 0; i < _numbers.length; ++i) {
			while (arabic >= _numbers[i]) {
				roman += _letters[i];
				arabic -= _numbers[i];
			}
		}
		return roman;
	}

}
