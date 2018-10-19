package com.sap.calcacademy.calculator.calc;

public class MultiplyOperation implements Operation {

    @Override
    /**
     * Multiplying two Double values
     * 
     * @param oper1
     *            First operand
     * @param oper2
     *            Second operand
     * @return Result of the calculated multiplication
     */
    public Number execute(Number oper1, Number oper2) {

        return new Double(oper1.doubleValue() * oper2.doubleValue());
    }

    @Override
    public String toString() {
        return " * ";
    }
}
