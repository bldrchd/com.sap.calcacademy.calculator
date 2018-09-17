package newCalc;

import java.util.LinkedList;

public class RevPolishNotation {
	Number result;

	public void evaluateRPN(String[] postfixExpression) {
		LinkedList<Number> stack = new LinkedList<Number>();
		Double number = null;

		for (int i = 0; i <= postfixExpression.length - 1; i++) {
			String token = new String(postfixExpression[i]);

			try {
				number = Double.valueOf(token);
				System.out.println(number + " Number parsed");
				stack.push(number);
				continue;
			} catch (NumberFormatException nfe) {
			}
			
			Number operator1, operator2, result;
			switch (token) {
			case "+":
				operator1 = stack.pop();
				operator2 = stack.pop();
				result = new AddOperation().execute(operator1, operator2);
				System.out.println("Current result of " + operator1 +  " + " + operator2 + " = " + result);
				System.out.println(result);
				stack.push(result);
				break;
			case "-":
				operator1 = stack.pop();
				operator2 = stack.pop();
				result = new SubtractOperation().execute(operator1, operator2);
				System.out.println("Current result of " + operator1 + " - "+ operator2  + " = " + result);
				stack.push(result);
				break;
			case "*":
				operator1 = stack.pop();
				operator2 = stack.pop();
				result = new MultiplyOperation().execute(operator1, operator2);
				System.out.println("Current result of " + operator1 + " * "+ operator2 + " = " + result);
				stack.push(result);
				break;
			case "/":
				operator1 = stack.pop();
				operator2 = stack.pop();
				result = new DivideOperation().execute(operator1, operator2);
				System.out.println("Current result of " + operator1 + " / " + operator2 + " = "+ result);
				stack.push(result);
				break;
			default:
				System.out.println("Not operator");
				break;
			}
		}
		System.out.println("Result = " + stack.pop());
	}

	Number getResult() {
		return result;
	}
}
