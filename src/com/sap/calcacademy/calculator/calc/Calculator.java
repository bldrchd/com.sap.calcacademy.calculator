package com.sap.calcacademy.calculator.calc;

import java.util.InputMismatchException;

import com.sap.calcacademy.calculator.exceptions.CalculationException;
import com.sap.calcacademy.calculator.exceptions.CalculationValidationException;

public class Calculator {

    /**
     * Calculates expression from user input
     * 
     * @param inputString
     *            User input (expression) as String @param string User input
     *            converted to String @return Result from the calculation and 0
     *            if no input is available @throws
     */
    Number calculate(String inputString) throws CalculationException {
        String validatedString;
        try {
            validatedString = validateInput(inputString);
        } catch (CalculationValidationException iae) {
            throw new CalculationValidationException(iae.getMessage(), iae.getCause());
        }
        String[] postfixExpression = null;
        PostfixExpression pe = new PostfixExpression();
        try {
            postfixExpression = pe.createPostfixExpression(validatedString);

        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(iae.getMessage()); // TODO will
                                                                  // this work?
        }
        try {
            return new ReversePolishNotation().calculationWithRPN(postfixExpression);
        } catch (ArithmeticException ae) {
            throw new ArithmeticException(ae.getMessage());
        }
    }

    private String validateInput(String buildedInputString) throws InputMismatchException, IllegalArgumentException {
        try {
            InputValidationAndTransformation ivat = new InputValidationAndTransformation();
            return ivat.validateAndTrimInput(buildedInputString);
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(iae.getMessage(), iae.getCause());
        }
    }
}
