package com.sap.calcacademy.calculator.calc;

public class Main {

    public static void main(String[] args) {
        try {
            String buildedString = buildString(args);
            Calculator c = new Calculator();
            System.out.println("MAIN RESULT: " + c.calculate(buildedString));
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            System.out.println(iae.getCause()); // TODO - Why getCause() is null
                                                // ?

        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
        }
    }

    /**
     * Returns user input arguments as one string
     */
    // TODO - ? The static here (because main is also static)
    private static String buildString(String[] inputArgs) throws IllegalArgumentException, NullPointerException {
        StringBuilder builder = new StringBuilder();
        if (inputArgs == null) {
            throw new NullPointerException("Argumets are null.");
        }
        if (inputArgs.length == 0) {
            throw new IllegalArgumentException("There are no arguments.");
        }
        for (String s : inputArgs) {
            builder.append(s);
        }
        return builder.toString();
    }
}
