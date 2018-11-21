package com.sap.calcacademy.calculator.calc.postfix;

import java.util.LinkedList;

import com.sap.calcacademy.calculator.calc.AddOperation;
import com.sap.calcacademy.calculator.calc.DivideOperation;
import com.sap.calcacademy.calculator.calc.MultiplyOperation;
import com.sap.calcacademy.calculator.calc.SubtractOperation;
import com.sap.calcacademy.calculator.exceptions.CalculationException;

public class ReversePolishNotation {
    /**
     * Applying Reverse Polish Notation to calculate the final result of the
     * user's expression
     * 
     * @param number
     *            Stores parsed number from the postfix expression
     * @param token
     *            Each member of the postfix expression - either be number or
     *            operator
     * @param postfixExpression
     *            The expression that is calculated
     * @param stack
     *            Stores the current result from the calculation
     * @return The calculated result as Number
     */
    public Number calculationWithRPN(String[] postfixExpression) throws CalculationException, IllegalArgumentException, ArithmeticException {
        String token;
        Number result;
        LinkedList<Number> stack = new LinkedList<Number>();

        System.out.println("------------Calculation------------");

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
                // TODO - Extract Parameter Object?
                try {
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
                } catch (CalculationException ce) {
                    throw new CalculationException(ce.getMessage(), ce.getCause());
                }
            }
        }
        result = stack.pop();
        System.out.println("Result = " + result);
        return result;
    }

    /**
     * Check if the current token from postfix expression is an operator
     * 
     * @param token
     *            Current token from the postfix expression
     * @return True of there is a match for operator
     */
    private boolean isOperator(String token) {
        return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }
}
