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
		char nextCharAtIndex = 0;

		if (inputString.charAt(0) == ')') {
			System.out.println("ERR - starts with )");
			System.exit(1);
		}

		for (int i = 0; i <= inputString.length()-1; ++i) {

			char charAtIndex = inputString.charAt(i);
			if (i < inputString.length() - 1) {
				nextCharAtIndex = inputString.charAt(i + 1);
			}
			boolean isPotentialCharacter = (!Character.isDigit(charAtIndex) || i != inputString.length());

			if (charAtIndex != ')') {
				if (charAtIndex == '(') {
					//System.out.println("(");
					countLeft++;
					operators.add(charAtIndex);
					System.out.println(operators.toString());
					continue;
				}
				if (Character.isDigit(charAtIndex)) {
					sb.append(charAtIndex);

				} else if (isPotentialCharacter) {

					if ((!Character.isDigit(nextCharAtIndex) || (i + 1) != inputString.length())
							&& nextCharAtIndex == '-' && Character.isDigit(inputString.charAt(i + 2))) {
					//	System.out.println("Negative :");
						valueSign = -1;
					}
					if (charAtIndex == '.') {
						if (!Character.isDigit(inputString.charAt(i - 1))
								&& matchesOperatorSymbol(inputString.charAt(i - 1))) { // e.g.: +.25 -> +0.25
							sb.append(0 + charAtIndex);
						}
						if (!Character.isDigit(nextCharAtIndex) && Character.isDigit(inputString.charAt(i - 1))
								&& matchesOperatorSymbol(nextCharAtIndex)) { // e.g: 2.+1 -> 2.0+1
							sb.append(0);
						}
					}

					addValueToSB();
					if (matchesOperatorSymbol(charAtIndex)) {
						if (valueSign == -1) {
					//		System.out.println("skip record of -");
						} else {
					//		System.out.println(charAtIndex);
							operators.add(charAtIndex);
							System.out.println(operators.toString());
						}
					}
				}
			} else if (charAtIndex == ')') {
				System.out.println(")");
				countRight++;
				addValueToSB();
				System.out.println(expression.toString());
				addOperatorToString();
				/*do {
					addOperatorToString();
				} while (operators.get(operators.size() - 1).toString() != "(");*/
				
				/*while (operators.get(operators.size() - 1).toString() != "(") {
					addOperatorToString();
				} 
				if (operators.get(operators.size() - 1).toString() == "("){
					System.out.println("remove one (");
					operators.remove(operators.size()-1);
				}*/
				System.out.println(operators.toString());
				System.out.println(expression.toString());
			}
		}
		
		addValueToSB();
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
			//	System.out.println(valueSign * digit.doubleValue());
				expression.add(valueSign * digit.doubleValue());
				System.out.println(expression.toString());
				sb.setLength(0);
			} catch (NumberFormatException nfe) {
				System.err.println("Cannot convert to Double");
			}
		}
	}

	void addOperatorToString() {
		if (!operators.isEmpty()) {
			String operatorToString;
			
			int indexOfLastItem = operators.size() - 1;
			operatorToString = operators.get(indexOfLastItem).toString();
			if (!operatorToString.equals("(")) {
				System.out.println(operatorToString + " - to be moved in expression");
				expression.add(operatorToString);
				System.out.println(expression.toString());
				operators.remove(indexOfLastItem);
				addOperatorToString();
			} else if (operatorToString.equals("(")){
				operators.remove(indexOfLastItem);
				System.out.println("Removing : " + operatorToString);
			} else {}
		}
	}

	String[] buildFinalPostfixExpression() {

		String[] postfixExpression = new String[expression.size()];
		for (int i = 0; i < expression.size() ; i++) {
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
}
