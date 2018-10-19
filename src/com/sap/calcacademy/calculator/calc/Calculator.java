package com.sap.calcacademy.calculator.calc;

import java.util.InputMismatchException;

public class Calculator {

    /**
     * Calculates expression from user input
     * 
     * @param buildedInputString
     *            User input (expression) as String @param string User input
     *            converted to String @return Result from the calculation and 0
     *            if no input is available @throws
     */
    Number calculate(String inputString) throws IllegalArgumentException, InputMismatchException, ArithmeticException { // Runtime
                                                                                                                        // Exception,
                                                                                                                        // or
                                                                                                                        // just
                                                                                                                        // IllegalArgument?

        try {
            inputString = validateInput(inputString); // TODO is that correct
                                                      // way?
        } catch (InputMismatchException ime) {
            throw new IllegalArgumentException(ime.getMessage());
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(iae.getMessage());
        }
        String[] postfixExpression = null;
        PostfixExpression pe = new PostfixExpression();
        try {
            postfixExpression = pe.createPostfixExpression(inputString);

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
            return ivat.validateAndTrimInput(buildedInputString); // TODO
        } catch (InputMismatchException ime) {
            throw new InputMismatchException("Found letters or parenthesis cound not equal.");
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Found unacceptable symbols.");
        }
    }
}
