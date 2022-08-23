package com.sadovnick.kata.service.impl;

import com.sadovnick.kata.converter.Converter;
import com.sadovnick.kata.converter.impl.ConverterImpl;
import com.sadovnick.kata.type.CalcNumType;
import com.sadovnick.kata.model.CalcNumber;
import com.sadovnick.kata.service.NumberService;
import com.sadovnick.kata.validate.Validate;
import com.sadovnick.kata.validate.impl.ValidateImpl;

/**
 * implementation {@link NumberService}
 *
 * @author SadovNick
 * @version 1.0
 * @see ConverterImpl
 * @see CalcNumType
 * @see NumberService
 */
public class NumberServiceImpl implements NumberService {

    private final Converter converter;
    private CalcNumType calcNumType;
    private final Validate validate;

    public NumberServiceImpl() {
        this.converter = new ConverterImpl();
        this.validate = new ValidateImpl();

    }

    /**
     * The method parses the character and converts it to the Arabic system with type assignment.
     *
     * @param str - symbol to parse.
     * @return - number object with value and type.
     */
    @Override
    public CalcNumber parseNumber(String str) {
        int value;
        if ((str.replaceAll("[0123456789]", "")).length() == 0) {
            value = Integer.parseInt(str);
            calcNumType = CalcNumType.ARABIC;
        } else {
            value = converter.convertToArabic(str);
            calcNumType = CalcNumType.ROMAN;
        }
        return new CalcNumber(value, calcNumType);
    }

    /**
     * The method parses the character and converts it to the Arabic system with type assignment,
     * but additionally compares types.
     *
     * @param str         - str to parse.
     * @param calcNumType - system type (Roman or Arabic).
     * @return - number object with value and type.
     */
    @Override
    public CalcNumber parseNumber(String str, CalcNumType calcNumType) {
        CalcNumber calcNumber = parseNumber(str);
        validate.illegalCharacter(calcNumber, calcNumType);
        return calcNumber;
    }
}
