package com.sadovnick.kata.mathOperation.impl;

import com.sadovnick.kata.mathOperation.MathOperation;

/**
 * Subtraction class for two numbers.
 *
 * @author SadovNick
 * @version 1.0
 * @see MathOperation
 */
public class Subtraction implements MathOperation {

    /**
     * The method subtract two numbers.
     *
     * @param first  - first term.
     * @param second - second term.
     * @return - the result of an subtraction operation.
     */
    @Override
    public int result(int first, int second) {
        return first - second;
    }
}
