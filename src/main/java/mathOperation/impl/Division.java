package mathOperation.impl;

import mathOperation.MathOperation;

/**
 * Division class for two numbers.
 *
 * @author SadovNick
 * @version 1.0
 * @see MathOperation
 */
public class Division implements MathOperation {

    /**
     * The method division two numbers.
     *
     * @param first  - first term.
     * @param second - second term.
     * @return - the result of an division operation.
     */
    @Override
    public int result(int first, int second) {
        return first / second;
    }
}
