package com.sap.calcacademy.calculator.calc;

/**
 * An interface class that is used for arithmetic operations
 *
 */
public interface Operation {

    /**
     * @param oper1
     *            First operator
     * @param oper2
     *            Second operator
     */
    Number execute(Number oper1, Number oper2);
}
