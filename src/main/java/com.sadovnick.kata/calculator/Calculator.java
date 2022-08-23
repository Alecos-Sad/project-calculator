package com.sadovnick.kata.calculator;

import com.sadovnick.kata.exception.WrongInputException;
import com.sadovnick.kata.model.CalcNumber;
import com.sadovnick.kata.service.NumberService;
import com.sadovnick.kata.service.OperationService;
import com.sadovnick.kata.service.impl.NumberServiceImpl;
import com.sadovnick.kata.service.impl.OperationServiceImpl;
import com.sadovnick.kata.validate.Validate;
import com.sadovnick.kata.validate.impl.ValidateImpl;

import java.util.Optional;
import java.util.Scanner;

/**
 * Main class to run the calculator.
 *
 * @author SadovNick
 * @version 1.0
 * @see OperationServiceImpl
 * @see NumberServiceImpl
 */
public class Calculator {

    private final OperationService operationService;
    private final NumberService numberService;
    private final Validate validate;

    public Calculator() {
        this.operationService = new OperationServiceImpl();
        this.numberService = new NumberServiceImpl();
        this.validate = new ValidateImpl();
    }

    /**
     * Method displays a primitive start menu.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an operation with two numbers (only Arabic or only Roman)");
        System.out.println("Allowed operations |+ - / *|");
        System.out.println("Example: 2+3 or II*IV");
        System.out.println("'ex' for EXIT ");
        while (true) {
            System.out.println("Enter: ");
            String enterLine = scanner.nextLine();

            if (enterLine.equals("ex")) {
                break;
            }
            if (operation(validate.prepareString(enterLine))) {
                break;
            }
        }
        scanner.close();
    }

    /**
     * Start method conducting basic operations.
     *
     * @param enterLine - a string with a mathematical expression entered by the user.
     * @return boolean.
     */
    private boolean operation(String enterLine) {
        try {
            String[] digits = enterLine.split("[+-/*]");
            String operation = operationService.catchOperation(Optional.of(enterLine));
            validate.checkForTwoNumbers(digits);
            CalcNumber firstCalcNumber = numberService.parseNumber(digits[0]);
            CalcNumber secondCalcNumber = numberService.parseNumber(digits[1], firstCalcNumber.getType());
            String result = operationService.calculation(firstCalcNumber, secondCalcNumber, operation);
            System.out.println("GET result: " + result);
        } catch (WrongInputException exception) {
            System.out.println(exception.getMessage());
            return true;
        }
        return false;
    }
}

