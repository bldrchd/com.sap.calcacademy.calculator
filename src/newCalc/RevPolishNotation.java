package newCalc;

import java.util.LinkedList;

public class RevPolishNotation {
	Number result;

	public void evaluateRPN(String[] postfixExpression) {
		System.out.println("------------Calculation------------");
		for (int j=0; j<=postfixExpression.length-1; j++){
			System.out.print(postfixExpression[j]+" ");
		}
		System.out.println();
		LinkedList<Number> stack = new LinkedList<Number>();
		Double number = null;

		for (int i = 0; i <= postfixExpression.length - 1; i++) {
			String token = new String(postfixExpression[i]);

			try {
				number = Double.valueOf(token);
				stack.push(number);
				System.out.println("Stack: "+ stack.toString());
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
				System.out.println("Stack"+ stack.toString());
				break;
			case "-":
				operator2 = stack.pop();
				operator1 = stack.pop();
				result = new SubtractOperation().execute(operator1, operator2);
				System.out.println("Current result of " + operator1 + " - "+ operator2  + " = " + result);
				stack.push(result);
				System.out.println("Stack"+ stack.toString());
				break;
			case "*":
				operator1 = stack.pop();
				operator2 = stack.pop();
				result = new MultiplyOperation().execute(operator1, operator2);
				System.out.println("Current result of " + operator1 + " * "+ operator2 + " = " + result);
				stack.push(result);
				System.out.println("Stack"+ stack.toString());
				break;
			case "/":
				operator2 = stack.pop();
				operator1 = stack.pop();
				result = new DivideOperation().execute(operator1, operator2);
				System.out.println("Current result of " + operator2 + " / " + operator1 + " = "+ result);
				stack.push(result);
				System.out.println("Stack"+ stack.toString());
				break;
			default:
				System.out.println("Not operator");
				break;
			}
		}
		result = stack.pop();
		System.out.println("Result = " + result);
	}

	Number getResult() {
		return result;
	}
}
