package com.sap.calcacademy.calculator.calc;

import java.util.InputMismatchException;

import com.sap.calcacademy.calculator.exceptions.CalculationValidationException;

public class InputValidationAndTransformation {

    /**
     * Performs basic validation of user input for unacceptable symbols,
     * parenthesis count, letters, removes whitespaces
     * 
     * @param inputString
     *            User input
     * @return String that is validated for parenthesis count, no whitespace,
     *         additional symbols and letters.
     * @throws InputMismatchException
     *             when letters are found or parenthesis count is not equal
     * @throws IllegalArgumentException
     *             when unacceptable symbols are found
     */
    String validateAndTrimInput(String inputString) throws IllegalArgumentException {

        inputString = removeWhitespaces(inputString);
        if (!notFoundUnaceptableSymbols(inputString)) // TODO
            throw new IllegalArgumentException("Unacceptable Symbols Found.");
        try {
            if (correctParentheses(inputString)) {
                return inputString;
            }
        } catch (CalculationValidationException cve) {
            throw new CalculationValidationException(cve.getMessage(), cve.getCause());
        }
        return inputString;
    }

    /**
     * Checks for whitespaces and removes them if there are such
     */
    String removeWhitespaces(String inputString) {
        return inputString = inputString.replaceAll("\\s+", "");
    }

    /**
     * Counts the number of parentheses (should be equal)
     */
    boolean correctParentheses(String joinedString) {
        // TODO - algo to check correctness of parenthesis
        int count = 0;
        for (int i = 0; i <= joinedString.length() - 1; i++) {
            if (joinedString.charAt(0) == ')') {
                throw new CalculationValidationException("Input starts with closing parentheses \")\"");
            } else {
                if (joinedString.charAt(i) == '(') {
                    count++;
                } else if (joinedString.charAt(i) == ')') {
                    count--;
                }
            }
        }
        return (count == 0);
    }

    /**
     * Returns FALSE (remove ^ for true ) if there are no symbols, that are
     * different than + - / * ( ) . and digits
     */
    boolean notFoundUnaceptableSymbols(String joinedString) {
        return joinedString.matches("[0-9-\\+\\*\\/\\(\\)\\.]+");
    }
}
