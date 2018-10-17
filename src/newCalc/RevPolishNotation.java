package newCalc;

import java.util.LinkedList;

public class RevPolishNotation {

    private String token;

    Number evaluateRPN(String[] postfixExpression) {
        Number result;
        LinkedList<Number> stack = new LinkedList<Number>();
        System.out.println("------------Calculation------------");

        for (int j = 0; j <= postfixExpression.length - 1; j++) {
            System.out.print(postfixExpression[j] + " ");
        }
        System.out.println();

        Double number = null;

        for (int i = 0; i <= postfixExpression.length - 1; i++) {
            token = new String(postfixExpression[i]);

            try {
                number = Double.valueOf(token);
                stack.push(number);
                System.out.println("Stack: " + stack.toString());
                continue;
            } catch (NumberFormatException nfe) {
            }

            if (isOperator(token)) {
                Number operator1 = stack.pop();
                Number operator2 = stack.pop();
                switch (token) {
                case "+":
                    result = new AddOperation().execute(operator2, operator1);
                    stack.push(result);
                    System.out.println("Current result of " + operator2 + " + " + operator1 + " = " + result);
                    System.out.println("Stack: " + stack.toString());
                    break;
                case "-":
                    result = new SubtractOperation().execute(operator2, operator1);
                    stack.push(result);
                    System.out.println("Current result of " + operator2 + " - " + operator1 + " = " + result);
                    System.out.println("Stack: " + stack.toString());
                    break;
                case "*":
                    result = new MultiplyOperation().execute(operator2, operator1);
                    stack.push(result);
                    System.out.println("Current result of " + operator2 + " * " + operator1 + " = " + result);
                    System.out.println("Stack: " + stack.toString());
                    break;
                case "/":
                    result = new DivideOperation().execute(operator2, operator1);
                    stack.push(result);
                    System.out.println("Current result of " + operator2 + " / " + operator1 + " = " + result);
                    System.out.println("Stack: " + stack.toString());
                    break;
                default:
                    System.out.println("Not operator");
                    break;
                }
            }
        }
        result = stack.pop();
        System.out.println("Result = " + result);
        return result;
    }

    private boolean isOperator(String token) {
        return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }
}
