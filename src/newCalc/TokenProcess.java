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

	public TokenProcess() {
		operatorStack = new TokenStack();
		valueStack = new TokenStack();
	}

	// public Token parse(ArrayList<Token> tokensArr) {
	public Token parse(String[] tokensInParts) {

		// Token[] tokens = new Token[tokensArr.size()];
		Token[] tokens = new Token[tokensInParts.length];

		for (int i = 0; i < tokens.length; i++) {
			tokens[i] = new Token(tokensInParts[i]);
			/*
			 * tokens[i] = new Token(tokensArr.get(i); }
			 */

			for (int index = 0; index < tokens.length; index++) {
				Token nextT = tokens[index];
				/*
				 * for (int index = 0; index < tokens.size(); index ++) { Token
				 * nextT = tokens.get(index);
				 */
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

			Token result = valueStack.top();
			valueStack.removeFromStack();
			if (!operatorStack.isEmpty() || !valueStack.isEmpty()) {
				System.err.println("Stacks are not empty");
			} else {
				return result;
			}
			return result;
		}
		return currentResult;
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
		/*
		 * if (valueStack.isEmpty()) { throw new EmptyStackException(); } else {
		 * A = valueStack.top(); valueStack.removeFromStack(); operand1 =
		 * A.getValue(); }
		 */
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
