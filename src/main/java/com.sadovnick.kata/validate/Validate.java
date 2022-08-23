package com.sadovnick.kata.validate;

import com.sadovnick.kata.type.CalcNumType;
import com.sadovnick.kata.model.CalcNumber;

/**
 * Validation interface.
 *
 * @author SadovNick
 * @version 1.0
 */
public interface Validate {

    String prepareString(String romanNumber);

    void checkForTwoNumbers(String[] strings);

    void illegalCharacter(CalcNumber calcNumber, CalcNumType calcNumType);

}
