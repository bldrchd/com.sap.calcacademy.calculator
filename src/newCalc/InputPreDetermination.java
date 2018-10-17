package newCalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputPreDetermination {

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

    private String buildString(String[] inputArgs) {
        StringBuilder builder = new StringBuilder();
        if (inputArgs != null) {
            for (String s : inputArgs) {
                builder.append(s);
            }
        }
        return builder.toString();
    }

    boolean findLetters(String joinedString) {
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(joinedString);
        return m.find();
    }

    String checkForWhiteSpaces(String joinedString) {
        System.out.println(joinedString);
        Pattern p2 = Pattern.compile("\\s+");
        Matcher m2 = p2.matcher(joinedString);
        if (m2.find()) {
            joinedString = joinedString.replaceAll("\\s+", "");
        }
        return joinedString;
    }

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

    boolean notFoundUnaceptableSymbols(String joinedString) {
        // true when there is no matches
        return joinedString.matches("[0-9-\\+\\*\\/\\(\\)\\.]+");
    }
}
