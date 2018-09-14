package newCalc;

import java.util.ArrayList;

public class InputDetermination {

	private ArrayList<Object> operators = new ArrayList<Object>();
	private ArrayList<Object> expression = new ArrayList<Object>();
	private StringBuilder sb = new StringBuilder();
	private Double digit = 0.0;
	double valueSign = 1;

	void determinate(String inputString) {

		int countLeft = 0, countRight = 0;

		if (inputString.charAt(0) == ')') {
			System.out.println("ERR - starts with )");
			System.exit(1);
		}

		for (int i = 0; i <= inputString.length() - 1; ++i) {

			char charAtIndex = inputString.charAt(i);
			char nextCharAtIndex = inputString.charAt(i + 1);
			boolean isPotentialCharacter = (!Character.isDigit(charAtIndex) || i != inputString.length());

			if (charAtIndex != ')') {
				if (charAtIndex == '(') {
					countLeft++;
				}
				if (Character.isDigit(charAtIndex)) {
					sb.append(charAtIndex);
				} else if (isPotentialCharacter) {
					if (!Character.isDigit(nextCharAtIndex)
							|| i + 1 != inputString.length() && nextCharAtIndex == '-') {
						valueSign = -1;
					}
					if (charAtIndex == '.') { // , - not allowed?
						if (!Character.isDigit(inputString.charAt(i - 1))
								&& matchesOperatorSymbol(inputString.charAt(i - 1))) {
							sb.append(0 + charAtIndex);
						}
						sb.append(charAtIndex);
						if (!Character.isDigit(nextCharAtIndex) && Character.isDigit(inputString.charAt(i - 1))
								&& matchesOperatorSymbol(nextCharAtIndex)) { // e.g: 2.+1 -> 2.0+1
							sb.append(0);
						}
					}
					addValueToSB();
					if (matchesOperatorSymbol(charAtIndex)) {
						System.out.println(charAtIndex);
						operators.add(charAtIndex);
					}
				}
			} else if (charAtIndex == ')') { // TODO check empty
				countRight++;
				addValueToSB();
				if (!operators.isEmpty()) {
					String operatorToString;
					int lastItem = operators.lastIndexOf(operators);
					operatorToString = (String) operators.get(lastItem);
					operators.remove(lastItem);
					expression.add(operatorToString);
				}
			}

			if (i == inputString.length()) { // not needed check?
				addValueToSB();
			}
		}

		if (countLeft == countRight) {
			while (!operators.isEmpty()) {
				addOperatorToString();
			}
			buildFinalPostfixExpression();
		} else {
			System.err.println("Parenthesis count not equal");
		}
	}

	void addValueToSB() {
		if (sb.length() != 0) {
			try {
				digit = Double.valueOf(sb.toString());
				System.out.println(valueSign * digit.doubleValue());
				expression.add(valueSign * digit.doubleValue());
				sb.setLength(0);
			} catch (NumberFormatException nfe) {
				System.err.println("Cannot convert to Double");
			}
		}
	}

	void addOperatorToString() {
		if (!operators.isEmpty()) {
			String operatorToString; // =
										// String.valueOf(operators.top().getOperator());
			int lastItem = operators.lastIndexOf(operators);
			operatorToString = (String) operators.get(lastItem);
			operators.remove(lastItem);
			expression.add(operatorToString);

			/*
			 * String operatorToString =
			 * String.valueOf(operators.top().getOperator());
			 * operators.removeFromStack(); expression.add(operatorToString);
			 */
		}
	}

	String[] buildFinalPostfixExpression() {

		String[] postfixExpression = new String[expression.size()];
		for (int i = 0; i <= expression.size(); i++) {
			postfixExpression[i] = expression.get(i).toString();
		}
		// String postfixExpression = st.toString(); // TODO check
		System.out.println(postfixExpression);
		return postfixExpression;
	}

	boolean matchesOperatorSymbol(char oper) {
		switch (oper) {
		case '+':
			return true;
		case '-':
			return true;
		case '*':
			return true;
		case '/':
			return true;
		}
		return false;
	}

	/*
	 * void createTokenForDigit() { if (sb.length() != 0) { Double digit; digit
	 * = Double.valueOf(sb.toString()); System.out.println(digit.doubleValue());
	 * Token t_digit = new Token(digit); expression.add(digit.toString()); //
	 * TODO check value sb.setLength(0); } }
	 */

	/*
	 * void takeValueToStack() { // transform to array of tokens and then
	 * analyze // to stacks? if (sb.length() != 0) { Double digit; digit =
	 * Double.valueOf(sb.toString()); System.out.println(digit.doubleValue());
	 * Token t = new Token(digit); valueStack.push(t); sb.setLength(0); // not
	 * safe } }
	 */

	/*
	 * void takeOperatorToStack(char ch) { Token operator = new Token(ch);
	 * operatorStack.push(operator); }
	 */

	/*
	 * public TokenStack getValueStackContent() { return valueStack; }
	 */

	/*
	 * public TokenStack getOperatorStackContent() { return operatorStack; }
	 */
}
