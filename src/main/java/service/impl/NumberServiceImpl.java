package service.impl;

import converter.Converter;
import converter.impl.ConverterImpl;
import enumic.CalcNumType;
import model.CalcNumber;
import service.NumberService;
import validate.Validate;
import validate.impl.ValidateImpl;

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
     * @param symbol - symbol to parse.
     * @return - number object with value and type.
     */
    @Override
    public CalcNumber parseNumber(String symbol) {
        int value;
        try {
            value = Integer.parseInt(symbol);
            calcNumType = CalcNumType.ARABIC;
        } catch (NumberFormatException exception) {
            value = converter.convertToArabic(symbol);
            calcNumType = CalcNumType.ROMAN;
        }
        return new CalcNumber(value, calcNumType);
    }

    /**
     * The method parses the character and converts it to the Arabic system with type assignment,
     * but additionally compares types.
     *
     * @param symbol      - symbol to parse.
     * @param calcNumType - system type (Roman or Arabic).
     * @return - number object with value and type.
     */
    @Override
    public CalcNumber parseNumber(String symbol, CalcNumType calcNumType) {
        CalcNumber calcNumber = parseNumber(symbol);
        validate.illegalCharacter(calcNumber, calcNumType);
        return calcNumber;
    }
}
