package newCalc;

public class InputParser {

	public Number parse(String[] inputArgs) {
		String joinedString = formatingJoinedString(inputArgs); // 1+2-3
		String[] tokensInParts = formatStringToStrArr(joinedString);
		TokenProcess tp = new TokenProcess();
		Number result = tp.parse(tokensInParts).getValue();
		return result;
	}

	public static String formatingJoinedString(String[] inputString) {
		StringBuilder builder = new StringBuilder();
		String joinedString = null;

		try {
			if (inputString != null) {
				for (String s : inputString) {
					builder.append(s);
				}
				joinedString = builder.toString();
				joinedString = String.join("", joinedString);
				joinedString = joinedString.replaceAll("\\s+", "");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return joinedString;
	}

	public static String[] formatStringToStrArr(String joinedString) {
		String[] tokensInParts = joinedString.split("(?<=[-+*x/()])|(?=[-+*x/()])"); // {"1","+","2","-","3"}
		return tokensInParts;
	}
}
