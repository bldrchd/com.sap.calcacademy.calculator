package newCalc;

//import java.util.ArrayList;
import java.util.EmptyStackException;

public class TokenProcess {
	private TokenStack operatorStack;
	private TokenStack valueStack;

	int UNKNOWN = -1;
	int NUMBER = 0;
	int OPERATOR = 1;
	int LEFT_PARENTHESIS = 2;
	int RIGHT_PARENTHESIS = 3;

	Operation operation;
	Number operand1;
	Number operand2;
	char operator;

	Token t = new Token();
	Expression expression = null;
	Token currentResult = null;
	Token result = new Token();

	public TokenProcess() {
		operatorStack = new TokenStack();
		valueStack = new TokenStack();
	}

	public Number parse(String[] postfixExpression) {

		Token[] tokens = new Token[postfixExpression.length];

		for (int i = 0; i < tokens.length; i++) {
			tokens[i] = new Token(postfixExpression[i]);

			for (int index = 0; index < tokens.length; index++) {
				Token nextT = tokens[index];
				if (nextT.getType() == NUMBER) {
					valueStack.push(nextT);
				} else if (nextT.getType() == OPERATOR) {
					if (operatorStack.isEmpty() || nextT.getPrio() > operatorStack.top().getPrio()) {
						operatorStack.push(nextT);
					} else {
						while (!operatorStack.isEmpty() && nextT.getPrio() <= operatorStack.top().getPrio()) {
							operator = operatorStack.top().getOperator();
							pushResultToValueStack();
						}
					}
				} else if (nextT.getType() == LEFT_PARENTHESIS) {
					operatorStack.push(nextT);
				} else if (nextT.getType() == RIGHT_PARENTHESIS) {
					while (!operatorStack.isEmpty() && (operatorStack.top().getType() == OPERATOR)) {
						operator = operatorStack.top().getOperator();
						pushResultToValueStack();
					}
					if (!operatorStack.isEmpty() && (operatorStack.top().getType() == LEFT_PARENTHESIS)) {

						pushResultToValueStack();
					} else {
						throw new IllegalArgumentException("No enouth Brackets");
					}
				}
			}

			while (!operatorStack.isEmpty() && operatorStack.top().getType() == OPERATOR) {
				operator = operatorStack.top().getOperator();
				pushResultToValueStack();
			}

			result = valueStack.top();
			valueStack.removeFromStack();
			if (!operatorStack.isEmpty() || !valueStack.isEmpty()) {
				System.err.println("Stacks are not empty");
			} else {
				return result.getValue();
			}
			return result.getValue();
		}
		return result.getValue();
	}

	Number collectValuesToValueStack() {
		Token A = null;
		Number operand;
		// Token B = null;
		if (valueStack.isEmpty()) {
			throw new EmptyStackException(); // is it ok to throw an exception
												// when there are no values?
		} else {
			A = valueStack.top();
			valueStack.removeFromStack();
			operand = A.getValue();
		}
		return operand;
	}

	void pushResultToValueStack() {
		operatorStack.removeFromStack();
		operand1 = collectValuesToValueStack();
		operand2 = collectValuesToValueStack();
		expression = t.evaluate(operator, operand1, operand2);
		currentResult = new Token(expression.execute().doubleValue());
		valueStack.push(currentResult);
	}
}
