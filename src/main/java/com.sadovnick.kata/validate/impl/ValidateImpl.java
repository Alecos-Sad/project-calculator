package com.sadovnick.kata.validate.impl;

import com.sadovnick.kata.type.CalcNumType;
import com.sadovnick.kata.exception.EmptyStringException;
import com.sadovnick.kata.exception.IllegalCharacterException;
import com.sadovnick.kata.exception.WrongInputException;
import com.sadovnick.kata.model.CalcNumber;
import com.sadovnick.kata.validate.Validate;

public class ValidateImpl implements Validate {

    @Override
    public String prepareString(String str) {
        if (str.isEmpty()) {
            throw new EmptyStringException();
        }
        return removeSpaces(str);
    }

    @Override
    public void checkForTwoNumbers(String[] strings) {
        if (strings.length != 2) {
            throw new WrongInputException();
        }
    }

    @Override
    public void illegalCharacter(CalcNumber calcNumber, CalcNumType calcNumType) {
        if (calcNumber.getType() != calcNumType) {
            throw new IllegalCharacterException();
        }
    }

    private String removeSpaces(String str) {
        return str.contains(" ") ? str.replace(" ", "") : str;
    }
}
