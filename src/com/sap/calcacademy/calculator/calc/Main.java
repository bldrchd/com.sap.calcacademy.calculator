package com.sap.calcacademy.calculator.calc;

import com.sap.calcacademy.calculator.exceptions.NoArgumentsException;

public class Main {

    public static void main(String[] args) {
        try {
            String buildedString = buildString(args);
            Calculator c = new Calculator();
            System.out.println("MAIN RESULT: " + c.calculate(buildedString));
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        }
    }

    /**
     * Returns user input arguments as one string
     */
    private static String buildString(String[] inputArgs) throws NoArgumentsException {
        StringBuilder builder = new StringBuilder();
        if (inputArgs == null || inputArgs.length == 0) {
            throw new NoArgumentsException("There are no arguments.");
        }
        for (String s : inputArgs) {
            builder.append(s);
        }
        return builder.toString();
    }
}
