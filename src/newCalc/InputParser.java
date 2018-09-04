package newCalc;

public class InputParser {

	public Number parse(String[] inputArgs) {
		String joinedString = formatingJoinedString(inputArgs); // 1+2-3
		String[] tokensInParts = formatStringToStrArr(joinedString);
		TokenProcess tp = new TokenProcess();
		Number result = tp.parse(tokensInParts).getValue();
		return result;
	}

	String formatingJoinedString(String[] inputString) {
		StringBuilder builder = new StringBuilder();
		String joinedString = null;

		try {
			if (inputString != null) {
				for (String s : inputString) {
					builder.append(s);
				}
				joinedString = builder.toString();
				joinedString = String.join("", joinedString);
				//TODO
				joinedString = joinedString.replaceAll("\\s+", "");
			}
		} catch (Exception e) { //TODO
			System.err.println(e);
		}
		return joinedString;
	}

	String[] formatStringToStrArr(String joinedString) {
		//TODO
		String[] tokensInParts = joinedString.split("(?<=[-+*x/()])|(?=[-+*x/()])"); // {"1","+","2","-","3"}
		return tokensInParts;
	}
}
