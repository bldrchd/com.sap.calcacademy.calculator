package newCalc;

import java.util.LinkedList;

public class RevPolishNotation {
	Number result;
	String token;
	LinkedList<Number> stack = new LinkedList<Number>();
//	LinkedList<String> operators = new LinkedList<String>();

	public void evaluateRPN(String[] postfixExpression) {
		System.out.println("------------Calculation------------");
		
		for (int j=0; j<=postfixExpression.length-1; j++){
			System.out.print(postfixExpression[j]+" ");
		}
		System.out.println();

		Double number = null;

		for (int i = 0; i <= postfixExpression.length - 1; i++) {
			token = new String(postfixExpression[i]);

			try {
				number = Double.valueOf(token);
				stack.push(number);
				System.out.println("Stack: "+ stack.toString());
				continue;
			} catch (NumberFormatException nfe) {}
			
			if (isOperator(token)){
				Number operator1 = stack.pop();
				Number operator2 = stack.pop();
				switch (token) {
				case "+": 
					result = new AddOperation().execute(operator2, operator1);
					stack.push(result);
					System.out.println("Current result of " + operator2 + " + "+ operator1  + " = " + result);
					System.out.println("Stack: "+ stack.toString());
					break;
				case "-":
					result = new SubtractOperation().execute(operator2, operator1);
					stack.push(result);
					System.out.println("Current result of " + operator2 + " - "+ operator1  + " = " + result);
					System.out.println("Stack: "+ stack.toString());
					break;
				case "*":
					result = new MultiplyOperation().execute(operator2, operator1);
					stack.push(result);
					System.out.println("Current result of " + operator2 + " * "+ operator1 + " = " + result);
					System.out.println("Stack: "+ stack.toString());
					break;
				case "/":
					result = new DivideOperation().execute(operator2, operator1);
					stack.push(result);
					System.out.println("Current result of " + operator2 + " / " + operator1 + " = "+ result);
					System.out.println("Stack: "+ stack.toString());
					break;
				default:
					System.out.println("Not operator");
					break;
				}
			}
		}
		result = stack.pop();
		System.out.println("Result = " + result);
	}

	Number getResult() {
		return result;
	}
	void calculate() {
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
			operator1 = stack.pop();
			operator2 = stack.pop();
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
	boolean hasPrecedence(String oper1, String oper2) {
		if (oper1.equals("*") || oper1.equals("/") && (oper2.equals("+") || oper2.equals("-"))){
			return false;
		} else {
			return false;	
		}
	}
	boolean isOperator(String token) {
		switch (token) {
		case "+":
			return true;
		case "-":
			return true;
		case "*":
			return true;
		case "/":
			return true;
		default:
			return false;
		}
	}
}
