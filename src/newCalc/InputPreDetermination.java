package newCalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputPreDetermination {

    /**
     * Performs basic validation of user input for unacceptable symbols,
     * parenthesis count, letters, removes whitespaces
     * 
     * @param inputArgs
     *            User input
     * @return joinedString Validated, cleaned and concatenated user input
     */
    String preValidation(String[] inputArgs) {

        String joinedString = buildString(inputArgs);

        if (findLetters(joinedString)) {
            System.exit(1);
        }
        joinedString = checkForWhiteSpaces(joinedString);

        if (!checkCorrectParenthesisCount(joinedString)) {
            System.err.println("Count of parenthesis is not equal.");
            System.exit(1);
        }
        if (notFoundUnaceptableSymbols(joinedString)) {
            return joinedString;
        } else {
            System.out.println("Matched");
            System.exit(1);
        }
        return joinedString;
    }

    /**
     * Returns user input arguments as one string
     */
    private String buildString(String[] inputArgs) {
        StringBuilder builder = new StringBuilder();
        if (inputArgs != null) {
            for (String s : inputArgs) {
                builder.append(s);
            }
        }
        return builder.toString();
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
    String checkForWhiteSpaces(String joinedString) {
        System.out.println(joinedString);
        Pattern p2 = Pattern.compile("\\s+");
        Matcher m2 = p2.matcher(joinedString);
        if (m2.find()) {
            joinedString = joinedString.replaceAll("\\s+", "");
        }
        return joinedString;
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
        // true when there is no matches
        return joinedString.matches("[0-9-\\+\\*\\/\\(\\)\\.]+");
    }
}
