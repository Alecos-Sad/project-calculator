package com.sadovnick.kata.converter;

/**
 * Defines methods for converting Arabic and Roman numbers.
 *
 * @author SadovNick
 * @version 1.0
 */
public interface Converter {

    int convertToArabic(String romanNumber);

    String convertToRomanian(int arabicNumber);
}
