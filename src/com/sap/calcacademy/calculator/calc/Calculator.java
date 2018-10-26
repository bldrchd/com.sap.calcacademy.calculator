package com.sap.calcacademy.calculator.calc;

import com.sap.calcacademy.calculator.exceptions.CalculationException;
import com.sap.calcacademy.calculator.exceptions.CalculationValidationException;

public class Calculator {

    /**
     * Calculates expression from user input
     * 
     * @param inputString
     *            User input (expression) as String
     * @param validatedString
     *            the input string that passed the validation
     * @return Result from the calculation
     * @throws CalculationValidationException
     *             if cannot validate the input or cannot create postfix
     *             expression
     * @throws ArithmeticException
     *             if cannot calculate the input
     */
    public Number calculate(String inputString) throws CalculationException {
        String validatedString;
        try {
            validatedString = validateInput(inputString);
        } catch (CalculationValidationException cve) {
            throw new CalculationValidationException(cve.getMessage(), cve.getCause());
        }
        String[] postfixExpression = null;
        PostfixExpression pe = new PostfixExpression();
        try {
            postfixExpression = pe.createPostfixExpression(validatedString);
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(iae.getMessage());
        }
        try {
            return new ReversePolishNotation().calculationWithRPN(postfixExpression);
        } catch (CalculationException ce) {
            throw new CalculationException(ce.getMessage());
        }
    }

    private String validateInput(String buildedInputString) throws CalculationValidationException {
        try {
            InputValidationAndTransformation ivat = new InputValidationAndTransformation();
            return ivat.validateAndTrimInput(buildedInputString);
        } catch (CalculationValidationException cve) {
            throw new CalculationValidationException(cve.getMessage(), cve.getCause()); // TODO
                                                                                        // fix
                                                                                        // expressions
        }
    }
}
