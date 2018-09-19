package newCalc;

import java.util.ArrayList;

public class InputDetermination {

	private ArrayList<Character> operators = new ArrayList<Character>();
	private ArrayList<Object> expression = new ArrayList<Object>();
	private StringBuilder sb = new StringBuilder();
	private Double digit = 0.0;
	double valueSign = 1;

	void determinate(String inputString) {

		int countLeft = 0, countRight = 0;
		char nextCharAtIndex = 0;

		if (inputString.charAt(0) == ')') {
			System.out.println("ERR - starts with )");
			System.exit(1);
		}

		for (int i = 0; i <= inputString.length() - 1; ++i) {

			char charAtIndex = inputString.charAt(i);
			if (i < inputString.length() - 1) {
				nextCharAtIndex = inputString.charAt(i + 1);
			}
			boolean isPotentialCharacter = (!Character.isDigit(charAtIndex) || i != inputString.length());

			if (charAtIndex == '(') {
				countLeft++;
				operators.add(charAtIndex);
				System.out.println(operators.toString());
				continue;
			}
			
			if (Character.isDigit(charAtIndex)) { // &&
													// (!Character.isDigit(inputString.length()-1))
													// && !operators.isEmpty()
													// &&
				sb.append(charAtIndex);
			} else if (isPotentialCharacter) {

/*				if ((!Character.isDigit(nextCharAtIndex) || (i + 1) != inputString.length()) && nextCharAtIndex == '-'
						&& Character.isDigit(inputString.charAt(i + 2))) {
					 System.out.println("Negative :");
					valueSign = -1;
				}*/
				if (charAtIndex == '.') {
					doubleValueManipulation(inputString, i, charAtIndex, nextCharAtIndex);
				}
				addNumberFromBufferToExpression();
				addOperatorFromOStackToExpression();

				if (matchesOperatorSymbol(charAtIndex)) {
					if (valueSign == -1) {
						// System.out.println("skip record of -");
					} else {
						operators.add(charAtIndex);
						System.out.println(operators.toString());
					}
				}
			}
			
			if (charAtIndex == ')') {
					System.out.println(" Found )");
				countRight++;
				addNumberFromBufferToExpression();
					System.out.println(expression.toString());
				addOperatorFromOStackToExpression();
					System.out.println(operators.toString());
					System.out.println(expression.toString());
			}
		}

		addNumberFromBufferToExpression();
		if (countLeft == countRight) {
			if (!operators.isEmpty()) {
				addOperatorFromOStackToExpression();
			}
			buildFinalPostfixExpression();
		} else {
			System.err.println("Parenthesis count still not equal to proceed...");
		}
		buildFinalPostfixExpression();
	}

	void test() {
		while (operators.get(operators.size() - 1) != '(') {
			// addOperatorFromOStackToExpression();
			char topOperator = operators.get(operators.size() - 1);
			if (topOperator != '(') {
				expression.add(topOperator);
				System.out.println(topOperator + " to be moved in expression");
				System.out.println(expression.toString());
				System.out.println(operators.toString());
				operators.remove(operators.size() - 1);
				System.out.println(operators.toString());
				System.out.println(expression.toString());
			}
			if (!operators.isEmpty()) {
				test();
			}
		}
	}

	void doubleValueManipulation(String inputString, int i, char charAtIndex, char nextCharAtIndex) {
		if (!Character.isDigit(inputString.charAt(i - 1)) && matchesOperatorSymbol(inputString.charAt(i - 1))) { // e.g.:
																													// +.25
																													// ->
																													// +0.25
			sb.append(0 + charAtIndex);
		}
		if (!Character.isDigit(nextCharAtIndex) && Character.isDigit(inputString.charAt(i - 1))
				&& matchesOperatorSymbol(nextCharAtIndex)) { // e.g: 2.+1 ->
																// 2.0+1
			sb.append(0);
		}
	}

	void addNumberFromBufferToExpression() {
		if (sb.length() != 0) {
			try {
				digit = Double.valueOf(sb.toString());
				expression.add(valueSign * digit.doubleValue());
					System.out.println(expression.toString());
				sb.setLength(0);
			} catch (NumberFormatException nfe) {
				System.err.println("Cannot convert to Double");
			}
		}
	}

	void addOperatorFromOStackToExpression() {

		if (!operators.isEmpty()) {
			int indexOfLastItem = operators.size() - 1;
			char lastOperatorInStack = operators.get(operators.size()-1);
			
			if (lastOperatorInStack != '(') {
				System.out.println(lastOperatorInStack + " to be moved in expression");
				expression.add(lastOperatorInStack);
					System.out.println(expression.toString());
				operators.remove(indexOfLastItem);
					System.out.println(operators.toString());

				addOperatorFromOStackToExpression();

			} else if (lastOperatorInStack == '(' ) {
				operators.remove(indexOfLastItem);
					System.out.println("Removing : " + lastOperatorInStack);
					System.out.println(operators.toString());
					
				addOperatorFromOStackToExpression();
			} else if (operators.isEmpty()){ //not needed?
				System.out.println(operators.toString());
			}
		}
	}

	String[] buildFinalPostfixExpression() {

		String[] postfixExpression = new String[expression.size()];
		for (int i = 0; i < expression.size(); i++) {
			if (expression.get(i) != null) {
				postfixExpression[i] = expression.get(i).toString();
			}
		}
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
	 * just a try
	 * 
	 * if (Character.isDigit(charAtIndex)) { sb.append(charAtIndex); } else if
	 * (charAtIndex == ')' && !operators.isEmpty()) { test(); while
	 * (operators.get(operators.size()-1) != '(') {
	 * //addOperatorFromOStackToExpression(); char topOperator =
	 * operators.get(operators.size()-1); if (topOperator != '(') {
	 * expression.add(topOperator); System.out.println(topOperator +
	 * " to be moved in expression"); System.out.println(expression.toString());
	 * operators.remove(operators.size()-1); } } } else { while
	 * (!operators.isEmpty() ) {
	 * 
	 * } } addNumberFromBufferToExpression();
	 */
}
