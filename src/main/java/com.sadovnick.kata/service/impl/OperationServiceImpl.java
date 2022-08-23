package com.sadovnick.kata.service.impl;

import com.sadovnick.kata.converter.Converter;
import com.sadovnick.kata.converter.impl.ConverterImpl;
import com.sadovnick.kata.type.CalcNumType;
import com.sadovnick.kata.exception.IllegalCharacterException;
import com.sadovnick.kata.exception.WrongInputException;
import com.sadovnick.kata.mathOperation.MathOperation;
import com.sadovnick.kata.mathOperation.impl.Addition;
import com.sadovnick.kata.mathOperation.impl.Division;
import com.sadovnick.kata.mathOperation.impl.Multiply;
import com.sadovnick.kata.mathOperation.impl.Subtraction;
import com.sadovnick.kata.model.CalcNumber;
import com.sadovnick.kata.service.OperationService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation {@link OperationService}
 *
 * @author SadovNick
 * @version 1.0
 * @see ConverterImpl
 */
public class OperationServiceImpl implements OperationService {

    private String operation;
    private final Converter converter;
    private final Map<String, MathOperation> mathOperationMap = new HashMap<>();

    public OperationServiceImpl() {
        this.converter = new ConverterImpl();
        initOperationMap();

    }

    /**
     * Method performs a simple mathematical calculation of two numbers.
     *
     * @param first     - first number.
     * @param second    - second number.
     * @param operation - mathematical operation sign.
     * @return - calculation result.
     */
    @Override
    public String calculation(CalcNumber first, CalcNumber second, String operation) {
        MathOperation mathOperation;
        if (mathOperationMap.containsKey(operation)) {
            mathOperation = mathOperationMap.get(operation);
        } else {
            throw new IllegalCharacterException();
        }
        int result = mathOperation.result(first.getValue(), second.getValue());

        return first.getType().equals(CalcNumType.ROMAN) ? converter.convertToRomanian(result) : String.valueOf(result);
    }

    /**
     * Method determines the mathematical sign of the operation in the string
     *
     * @param inputLine - a string in which you need to determine the sign of a mathematical operation.
     * @return - mathematical sign.
     */
    @Override
    public String catchOperation(Optional<String> inputLine) {
        if (inputLine.isPresent()) {
            Pattern pattern = Pattern.compile("[+*/\\-]");
            Matcher matcher = pattern.matcher(inputLine.get());
            while (matcher.find()) {
                operation = inputLine.get().substring(matcher.start(), matcher.end());
            }
            return operation;
        }
        throw new WrongInputException();
    }

    /**
     * Method fills in the map, where the key is a mathematical sign, the value is a mathematical operation.
     */
    private void initOperationMap() {
        mathOperationMap.put("+", new Addition());
        mathOperationMap.put("-", new Subtraction());
        mathOperationMap.put("*", new Multiply());
        mathOperationMap.put("/", new Division());
    }
}
