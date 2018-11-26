package com.sap.calcacademy.calculator.calc.postfix;

import com.sap.calcacademy.calculator.exceptions.CalculationException;

public class DivideOperation implements Operation {

    @Override
    /**
     * Divide two Double values
     * 
     * @param oper1
     *            First operand
     * @param oper2
     *            Second operand
     * @return Result of the calculated division
     * @throw Arithmetic Exception if the is an attempt to divide by 0
     */
    public Number execute(Number oper2, Number oper1) throws CalculationException {
        if (oper1.toString().equals("0.0")) {
            throw new ArithmeticException("Can not divide by 0");
        } else {
            return new Double(oper2.doubleValue() / oper1.doubleValue());
        }
    }

    @Override
    public String toString() {
        return " / ";
    }

}
