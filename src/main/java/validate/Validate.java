package validate;

import enumic.CalcNumType;
import model.CalcNumber;

/**
 * Validation interface.
 *
 * @author SadovNick
 * @version 1.0
 */
public interface Validate {

    void emptyString(String romanNumber);

    void checkForTwoNumbers(String[] strings);

    void illegalCharacter(CalcNumber calcNumber, CalcNumType calcNumType);

}
