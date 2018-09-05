package newCalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputDetermination {
	
	String joinedString = null;
	
	public void preValidation(String[] inputArgs) {
		
		if (findLetters(inputArgs)){
			System.exit(1);
		} else if (checkForWhiteSpaces(joinedString)) {
			removeWhiteSpaces(joinedString);
		}
	}

	void removeWhiteSpaces(String joinedString) {

	}

	boolean findLetters(String[] inputArgs) {
		StringBuilder builder = new StringBuilder();

		if (inputArgs != null) {
			for (String s : inputArgs) {
				System.out.println(s);
				builder.append(s);
			}
			joinedString = builder.toString();
			System.out.println(joinedString);
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
		if (m2.find()){
			System.out.println("whitespaces found");
			return true;
		} else {
			return false;
		}
	}
}
