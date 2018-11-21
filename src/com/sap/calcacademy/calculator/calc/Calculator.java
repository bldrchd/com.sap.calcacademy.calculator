package com.sap.calcacademy.calculator.calc;

import com.sap.calcacademy.calculator.exceptions.CalculationException;
import com.sap.calcacademy.calculator.exceptions.CalculationValidationException;

public class Calculator {

    private String validatedString = null;
    private String result = null;

    /**
     * Calculates expression from user input
     * 
     * @param inputString
     *            User input (expression) as String
     * @param validatedString
     *            the input string that passed the validation
     * @param result
     *            the calculated result from given expression
     * @return Result from the calculation
     * @throws CalculationValidationException
     *             if cannot validate the input or cannot create postfix
     *             expression
     * @throws ArithmeticException
     *             if cannot calculate the input
     */
    public Number calculate(String inputString) throws CalculationException, IllegalArgumentException, CalculationException {
        InputValidationAndTransformation ivat = new InputValidationAndTransformation();
        setValidatedString(ivat.validateAndTrimInput(inputString));

        CalculationAlgo ca = new CalculationAlgo();
        setResult(ca.startCalculating(validatedString));

        return Double.valueOf(getResult());
    }

    public String getValidatedString() {
        return validatedString;
    }

    private void setValidatedString(String validatedString) {
        this.validatedString = validatedString;
    }

    public String getResult() {
        return result;
    }

    private void setResult(String result) {
        this.result = result;
    }
}
