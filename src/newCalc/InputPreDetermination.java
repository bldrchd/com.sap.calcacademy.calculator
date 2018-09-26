package newCalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputPreDetermination {

    public String preValidation(String[] inputArgs) {
        String joinedString = null;

        if (findLetters(inputArgs, joinedString)) {
            System.exit(1);
        } else if (checkForWhiteSpaces(joinedString)) {
            System.out.println(joinedString);
            joinedString = removeWhiteSpaces(joinedString);
            System.out.println(joinedString);
        }

        if (!checkCorrectParenthesisCount(joinedString)) {
            System.err.println("Count of parenthesis is not equal.");
            System.exit(1);
        }
        if (findUnaceptableSymbols(joinedString)) {
            System.exit(1);
        }
        return joinedString;
    }

    boolean findLetters(String[] inputArgs, String joinedString) {
        StringBuilder builder = new StringBuilder();

        if (inputArgs != null) {
            for (String s : inputArgs) {
                builder.append(s);
            }
            joinedString = builder.toString();
        }

        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(joinedString);
        return m.find();
    }

    boolean checkForWhiteSpaces(String joinedString) {
        Pattern p2 = Pattern.compile("\\s+");
        Matcher m2 = p2.matcher(joinedString);
        return m2.find();
    }

    String removeWhiteSpaces(String joinedString) {
        joinedString = joinedString.replaceAll("\\s+", "");
        System.out.println(joinedString);
        return joinedString;
    }

    boolean checkCorrectParenthesisCount(String finalString) {
        int count = 0;
        for (int i = 0; i <= finalString.length() - 1; i++) {
            if (finalString.charAt(i) == '(') {
                count++;
            } else if (finalString.charAt(i) == ')') {
                count--;
            }
        }
        return (count == 0);
    }

    boolean findUnaceptableSymbols(String finalString) {
        for (int i = 0; i < finalString.length(); i++) {
            if (finalString.charAt(i) == ',' || finalString.charAt(i) == '@' || finalString.charAt(i) == '^'
                    || finalString.charAt(i) == '%') {
                System.err.println("Unacceptable character found: " + finalString.charAt(i));
                return true;
            }
        }
        return false;
    }
}
