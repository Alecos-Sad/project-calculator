package com.sadovnick.kata.exception;

/**
 * Exception class when an invalid character is encountered.
 *
 * @author SadovNick
 * @version 1.0
 */
public class IllegalCharacterException extends RuntimeException {

    public IllegalCharacterException() {
        this("Illegal character in numeral but get result))");
    }

    private IllegalCharacterException(String message) {
        super(message);
    }
}
