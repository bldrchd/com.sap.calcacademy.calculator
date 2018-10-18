package newCalc;

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
    Number calculate(String inputString) {

        try {
            inputString = validateInput(inputString);
        } catch (InputMismatchException ime) {
            throw new IllegalArgumentException(ime.getMessage());
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(iae.getMessage());
        }
        String[] postfixExpression = null;
        Determination dt = new Determination();
        postfixExpression = dt.determinate(inputString);
        return new RevPolishNotation().evaluateRPN(postfixExpression);
    }

    private String validateInput(String buildedInputString) throws InputMismatchException, IllegalArgumentException {
        try {
            InputValidationAndTransformation ivatd = new InputValidationAndTransformation();
            return ivatd.validateAndTrimInput(buildedInputString); // TODO
        } catch (InputMismatchException ime) {
            throw new InputMismatchException("Found letters or parenthesis cound not equal.");
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Found unacceptable symbols.");
        }
    }
}
