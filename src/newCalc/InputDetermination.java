package newCalc;

import java.util.ArrayList;

public class InputDetermination {

	private TokenStack operators = new TokenStack();
	private ArrayList<Object> expression = new ArrayList<Object>();

	void determinate(String inputString) {
		StringBuilder sb = new StringBuilder();
		int countLeft = 0, countRight = 0;
		Double digit = 0.0;

		if (inputString.charAt(0) == ')') {
			System.out.println("ERR - starts with )");
			System.exit(1);
		}

		for (int i = 0; i <= inputString.length()-1; ++i) {
			char charAtIndex = inputString.charAt(i);

			if (charAtIndex != ')') {
				if (charAtIndex == '(') {
					countLeft++;
				}
				if (Character.isDigit(charAtIndex)) {
					sb.append(charAtIndex);
				} else if (!Character.isDigit(charAtIndex) || i != inputString.length()) {
					if (charAtIndex == '.' ) { // , - not allowed?
						if (!Character.isDigit(inputString.charAt(i-1))) {
							sb.append(0+charAtIndex);
						}
						sb.append(charAtIndex);
						if (!Character.isDigit(inputString.charAt(i+1)) && Character.isDigit(inputString.charAt(i-1))) { //  e.g. 2.
							sb.append(0);
						}
					}
					// DIGIT
					if (sb.length() != 0) {
						try {
							digit = Double.valueOf(sb.toString());
							System.out.println(digit.doubleValue());
							expression.add(digit.doubleValue());
							sb.setLength(0);
						} catch (NumberFormatException nfe) {
							System.err.println("Cannot convert to Double"); // not
																			// an
																			// error
						}
					} /*
						 * else { System.err.println("Empty builder"); }
						 */
					// OPERATOR
					if (matchesOperatorSymbol(charAtIndex)) {
						System.out.println(charAtIndex);
						Token operator = new Token(charAtIndex);
						operators.push(operator);
					} /*
						 * else { System.err.println("Found " + charAtIndex +
						 * " in the expression."); //not an error }
						 */
				} /*
					 * else { System.err.println("WTF"); }
					 */
			} else if (charAtIndex == ')') { // TODO check empty
				countRight++;
				if (!operators.isEmpty()) {
					String operatorToString = String.valueOf(operators.top().getOperator());
					expression.add(operatorToString);
				}
			}
			
			if (i == inputString.length()) { // not needed check?
				// addValueToExpressionString
				if (sb.length() != 0) {
					try {
						digit = Double.valueOf(sb.toString());
						System.out.println(digit.doubleValue());
						expression.add(digit.toString());
						sb.setLength(0);
					} catch (NumberFormatException nfe) {
						System.err.println("Cannot convert to Double");
					}
				} /*
					 * else { System.err.println("Empty builder"); }
					 */
			}
		}

		if (countLeft == countRight) {
			addOperatorToString();
			buildFinalPostfixExpression();
		} else {
			System.err.println("Parenthesis count not equal");
		}
	}

	void addValueToExpressionString() {
		// TODO
	}

	void addOperatorToString() {
		if (!operators.isEmpty()) {
			String operatorToString = String.valueOf(operators.top().getOperator());
			expression.add(operatorToString);
		}
	}

	String[] buildFinalPostfixExpression() {

		String[] postfixExpression = new String[expression.size()];
		for (int i = 0; i <= expression.size(); i++) {
			postfixExpression[i] = expression.get(i).toString();
		}
		//String postfixExpression = st.toString(); // TODO check
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
