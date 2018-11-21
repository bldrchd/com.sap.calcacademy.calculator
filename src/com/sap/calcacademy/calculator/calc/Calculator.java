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
    public Number calculate(String inputString) throws CalculationException, IllegalArgumentException, CalculationException {
        InputValidationAndTransformation ivat = new InputValidationAndTransformation();
        String validatedString = ivat.validateAndTrimInput(inputString);

        PostfixExpression pe = new PostfixExpression();
        String[] postfixExpression = pe.createPostfixExpression(validatedString);

        return new ReversePolishNotation().calculationWithRPN(postfixExpression);
    }
}
