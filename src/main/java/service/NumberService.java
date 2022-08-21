package service;

import enumic.CalcNumType;
import model.CalcNumber;

/**
 * The interface provides methods for parsing numbers.
 *
 * @author SadovNick
 * @version 1.0
 */
public interface NumberService {

    CalcNumber parseNumber(String symbol);

    CalcNumber parseNumber(String symbol, CalcNumType calcNumType);
}
