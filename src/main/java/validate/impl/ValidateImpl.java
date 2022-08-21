package validate.impl;

import enumic.CalcNumType;
import exception.EmptyStringException;
import exception.IllegalCharacterException;
import exception.WrongInputException;
import model.CalcNumber;
import validate.Validate;

public class ValidateImpl implements Validate {

    @Override
    public void emptyString(String str) {
        try {
            if (str.isEmpty()) {
                throw new EmptyStringException();
            }
        } catch (EmptyStringException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void checkForTwoNumbers(String[] strings) {
        if (strings.length != 2) {
            throw new WrongInputException();
        }
    }

    @Override
    public void illegalCharacter(CalcNumber calcNumber, CalcNumType calcNumType) {
        try {
            if (calcNumber.getType() != calcNumType) {
                throw new IllegalCharacterException();
            }
        } catch (IllegalCharacterException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
