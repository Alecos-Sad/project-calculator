package com.sadovnick.kata.exception;

/**
 * Exception class on invalid value input
 */
public class WrongInputException extends RuntimeException {

    public WrongInputException() {
        this("Wrong input!");
    }

    private WrongInputException(String message) {
        super(message);
    }
}
