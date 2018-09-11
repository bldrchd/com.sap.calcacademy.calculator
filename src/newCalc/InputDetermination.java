package newCalc;

public class InputDetermination {
	
	private StringBuilder sb = new StringBuilder();
	public static TokenStack operatorStack;
	public static TokenStack valueStack;

	void determinate(String inputString) {

		for (int i = 0; i <= inputString.length() - 1; ++i) {
			if (Character.isDigit(inputString.charAt(i))) {
				sb.append(inputString.charAt(i));
			} else if (!Character.isDigit(inputString.charAt(i)) || i == inputString.length()) {
				// get the value and empty the stack
				takeValueToStack();

				if (matchesOperatorSymbol(inputString.charAt(i))) {
					System.out.println(inputString.charAt(i));
					takeOperatorToStack(inputString.charAt(i));
				} else if (inputString.charAt(i) == '(') {
					// TODO - not exactly this task
					System.out.println("(");
					takeOperatorToStack(inputString.charAt(i));
				} else if (inputString.charAt(i) == ')') {
					System.out.println(")");
					takeOperatorToStack(inputString.charAt(i));
				} else {
					System.err.println("Error: found " + inputString.charAt(i) + " in the expression.");
				}
			} else {
				System.err.println("WTF");
			}
		}
		takeValueToStack();
	}

	void takeValueToStack() {
		if (sb.length() != 0) {
			Double digit;
			digit = Double.valueOf(sb.toString());
			System.out.println(digit.doubleValue());
			Token t = new Token(digit);
			valueStack.push(t);
			sb.setLength(0); // not safe
		}
	}

	void takeOperatorToStack(char ch) {
		Token operator = new Token(ch);
		operatorStack.push(operator);
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

	public TokenStack getValueStackContent() {
		return valueStack;
	}

	public TokenStack getOperatorStackContent() {
		return operatorStack;
	}
}
