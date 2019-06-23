package com.hypotemoose.cal.util;

import java.util.Arrays;

/**
 * Converts between Hebrew and standard (Arabic) years in short form, meaning
 * the thousands' place is omitted.
 */
public class HebrewYearGenerator {

  private static final String[] HEBREW_LETTERS = {
    "×ª", "×©", "×¨", "×§", "×¦", "×¤", "×¢", "×¡",
    "×Ÿ", "×ž", "×œ", "×›", "×™", "×˜", "×—",
    "×–", "×•", "×”", "×“", "×’", "×‘", "×�"
  };
  private static final String[] HEBREW_END_LETTERS = {
    "×¥", "×£", "× ", "×�", "×š"
  };
  private static final String GERSHAYIM = "×´";
  private static final String GERESH = "×³";

  private static int[] NUMBERS = {
    400, 300, 200, 100, 90,
    80, 70, 60, 50, 40, 30,
    20, 10, 9, 8, 7, 6,
    5, 4, 3, 2, 1
  };

  private static int[] ALTERNATE_ENDINGS = {
    90, 80, 50, 40, 20
  };

  public static String toHebrew(int number) {
    StringBuilder result = new StringBuilder();
    int lastValue = NUMBERS[0];
    while (number > 999) {
      number -= 1000;
    }
    for (int i = 0; i < NUMBERS.length; ++i) {
      while (number >= NUMBERS[i]) {
        result.append(HEBREW_LETTERS[i]);
        number -= NUMBERS[i];
        lastValue = NUMBERS[i];
      }
    }
    int len = result.length();
    if (len > 1) {
      result.insert(len - 1, GERSHAYIM);
    } else if (len == 1) {
      result.append(GERESH);
    }

    @SuppressWarnings("unlikely-arg-type")
	int index = Arrays.asList(ALTERNATE_ENDINGS).indexOf(lastValue);
    if (index > -1) {
      result.replace(result.length() - 1,
        result.length(),
        HEBREW_END_LETTERS[index]);
    }

    return result.toString();
  }
}
