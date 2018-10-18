package newCalc;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    String validateAndTrimInput(String inputString) throws IllegalArgumentException, InputMismatchException {

        if (findLetters(inputString))
            throw new InputMismatchException("Found Letters in input.");

        inputString = removeWhitespaces(inputString); // TODO - what is the
                                                      // better way to write it?

        if (!checkCorrectParenthesisCount(inputString))
            throw new InputMismatchException("Parenthesis count doesn't match.");

        if (!notFoundUnaceptableSymbols(inputString))
            throw new IllegalArgumentException("Unacceptable Symbols Found."); // TODO
                                                                               // -
                                                                               // is
                                                                               // findLetters()
                                                                               // needed
                                                                               // if
                                                                               // this
                                                                               // is
                                                                               // true?

        return inputString;
    }

    /**
     * Looking for letters in joinedString
     */
    boolean findLetters(String joinedString) {
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(joinedString);
        return m.find();
    }

    /**
     * Checks for whitespaces and removes them if there are such
     */
    String removeWhitespaces(String inputString) {
        // System.out.println(inputString);
        // Pattern p2 = Pattern.compile("\\s+");
        // Matcher m2 = p2.matcher(inputString);
        // if (m2.find()) {
        // }
        return inputString = inputString.replaceAll("\\s+", "");
    }

    /**
     * Counts the number of parenthesis (should be equal)
     */
    boolean checkCorrectParenthesisCount(String joinedString) {
        int count = 0;
        for (int i = 0; i <= joinedString.length() - 1; i++) {
            if (joinedString.charAt(i) == '(') {
                count++;
            } else if (joinedString.charAt(i) == ')') {
                count--;
            }
        }
        return (count == 0);
    }

    /**
     * Returns true if there are no symbols, that are different than + - / * ( )
     * . and digits
     */
    boolean notFoundUnaceptableSymbols(String joinedString) {
        return joinedString.matches("[0-9-\\+\\*\\/\\(\\)\\.]+");
    }
}
