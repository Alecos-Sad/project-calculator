package mathOperation.impl;

import mathOperation.MathOperation;

/**
 * Multiplication class for two numbers.
 *
 * @author SadovNick
 * @version 1.0
 * @see MathOperation
 */
public class Multiply implements MathOperation {

    /**
     * The method multiply two numbers.
     *
     * @param first  - first term.
     * @param second - second term.
     * @return - the result of an multiply operation.
     */
    @Override
    public int result(int first, int second) {
        return first * second;
    }
}
