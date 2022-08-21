package mathOperation.impl;

import mathOperation.MathOperation;

/**
 * Addition class for two numbers.
 *
 * @author SadovNick
 * @version 1.0
 * @see MathOperation
 */
public class Addition implements MathOperation {

    /**
     * The method adds two numbers.
     *
     * @param first  - first term.
     * @param second - second term.
     * @return - the result of an addition operation.
     */
    @Override
    public int result(int first, int second) {
        return first + second;
    }
}
