package com.sadovnick.kata.converter.impl;

import com.sadovnick.kata.converter.Converter;

import java.util.Map;
import java.util.TreeMap;

/**
 * This implementation converts Arabic and Roman system numbers.
 *
 * @author SadovNick
 * @version 1.0
 * @see Converter
 */

public class ConverterImpl implements Converter {

    private final TreeMap<Integer, String> numbersMap;

    public ConverterImpl() {
        this.numbersMap = initMap();
    }

    /**
     * Method converts from roman system to arabic.
     *
     * @param roman - string representation of a Roman numeral.
     * @return - Arabic number.
     */
    @Override
    public int convertToArabic(String roman) {
        int i = 0;
        int arabic = 0;
        while (i < roman.length()) {
            char letter = roman.charAt(i);
            int number = convertLetterToNumber(letter);
            i++;
            if (i == roman.length()) {
                arabic += number;
            } else {
                int nextNumber = convertLetterToNumber(roman.charAt(i));
                if (nextNumber > number) {
                    arabic += (nextNumber - number);
                    i++;
                } else {
                    arabic += number;
                }
            }
        }
        return arabic;
    }

    /**
     * Method converts from arabic system to romanian.
     *
     * @param arabicNumber - arabic numeral representation.
     * @return - string representation of a Roman numeral.
     */
    @Override
    public String convertToRomanian(int arabicNumber) {
        int floorKey = numbersMap.floorKey(arabicNumber);
        if (arabicNumber == floorKey) {
            return numbersMap.get(arabicNumber);
        }
        return numbersMap.get(floorKey) + convertToRomanian(arabicNumber - floorKey);
    }

    /**
     * The method converts the symbolic representation of the singular to the Roman numeral system.
     *
     * @param letter - string representation of a Roman numeral.
     * @return - Arabic number.
     */
    private int convertLetterToNumber(char letter) {
        int result = -1;
        for (Map.Entry<Integer, String> entry : numbersMap.entrySet()) {
            if (entry.getValue().equals(String.valueOf(letter))) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }

    /**
     * Map initialization with key-value,
     * where the key is the Arabic ratio of the Roman numeral, which is the value.
     *
     * @return - map where key-value is Arabic-Roman numerals
     */
    private TreeMap<Integer, String> initMap() {
        TreeMap<Integer, String> romanNumberMap = new TreeMap<>();
        romanNumberMap.put(1, "I");
        romanNumberMap.put(4, "IV");
        romanNumberMap.put(5, "V");
        romanNumberMap.put(9, "IX");
        romanNumberMap.put(10, "X");
        romanNumberMap.put(40, "XL");
        romanNumberMap.put(50, "L");
        romanNumberMap.put(90, "XC");
        romanNumberMap.put(100, "C");
        romanNumberMap.put(500, "D");
        romanNumberMap.put(1000, "M");
        return romanNumberMap;
    }
}
