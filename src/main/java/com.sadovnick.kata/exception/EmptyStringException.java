package com.sadovnick.kata.exception;

/**
 * Exception class when an empty string is encountered.
 *
 * @author SadovNick
 * @version 1.0
 */
public class EmptyStringException extends RuntimeException {

    public EmptyStringException() {
        this("An empty string does not define a Roman numeral");
    }

    private EmptyStringException(String message) {
        super(message);
    }
}
