package newCalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputPreDetermination {

	String joinedString = null;

	public String preValidation(String[] inputArgs) {
		String finalString = null;
		if (findLetters(inputArgs)) {
			System.exit(1);
		} else if (checkForWhiteSpaces(joinedString)) {
			System.out.println(joinedString);
			finalString = removeWhiteSpaces(joinedString);
			System.out.println(finalString);
		}
		if (!checkCorrectParenthesisCount(finalString)) {
			System.err.println("Count of parenthesis is not equal.");
			System.exit(1);
			// } else if ((findUnaceptableSymbols(finalString)){
			//
		} else {
			return finalString;
		}
		return null;
	}

	boolean findLetters(String[] inputArgs) {
		StringBuilder builder = new StringBuilder();

		if (inputArgs != null) {
			for (String s : inputArgs) {
				builder.append(s);
			}
			joinedString = builder.toString();
		}

		Pattern p = Pattern.compile("[a-zA-Z]");
		Matcher m = p.matcher(joinedString);

		if (m.find()) {
			System.err.println("Matched letters in expression");
			return true;
		} else {
			return false;
		}
	}

	boolean checkForWhiteSpaces(String joinedString) {
		Pattern p2 = Pattern.compile("\\s+");
		Matcher m2 = p2.matcher(joinedString);
		if (m2.find()) {
			// System.out.println("whitespaces found");
			return true;
		} else {
			return false;
		}
	}

	String removeWhiteSpaces(String joinedString) {
		joinedString = joinedString.replaceAll("\\s+", "");
		/*
		 * Or this works also: StringBuilder strB = new StringBuilder(); for
		 * (int i = 0; i < joinedString.length(); i++){ if
		 * (!Character.isWhitespace(joinedString.charAt(i))){
		 * 
		 * strB.append(joinedString.charAt(i)); } } String newString =
		 * strB.toString(); System.out.println(newString);
		 */
		return joinedString;
	}

	boolean checkCorrectParenthesisCount(String finalString) {
		int countLeft = 0, countRight = 0;
		for (int i = 0; i < finalString.length(); i++) {
			if (String.valueOf(i).contains("(")) {
				countLeft++;
			} else if (String.valueOf(i).contains(")")) {
				countRight++;
			}
		}
		if (countLeft == countRight) {
			return true;
		} else {
			return false;
		}
	}

	boolean findUnaceptableSymbols(String finalString) {
		for (int i = 0; i < finalString.length(); i++) {
			// if String.valueOf(i).contains(!)
		}
		return false;
	}
}
