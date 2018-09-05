package newCalc;
@Deprecated
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
				System.out.println(joinedString);
			}
		} catch (NullPointerException npe) { // TODO - terminate
			System.err.println(npe);
		}
		return joinedString;
	}

	String[] formatStringToStrArr(String joinedString) {
		// TODO
		String[] tokensInParts = joinedString.split("(?<=[-+*x/()])|(?=[-+*x/()])"); // {"1","+","2","-","3"}
		for (int i = 0; i < tokensInParts.length; i++) {
			System.out.print(tokensInParts[i] + " ");
		}
		System.out.println();
		return tokensInParts;
	}
}
