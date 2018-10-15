package newCalc;

import java.util.ArrayList;
import java.util.Stack;

public class Determination {
    private ArrayList<Object> expression = new ArrayList<Object>();

    void deteminate(String inputString) {
        StringBuilder sb = new StringBuilder();
        int valueSign = 1;
        Stack<Character> operatorsStack = new Stack<Character>();

        if (inputString.charAt(0) == ')') {
            System.out.println("ERR - starts with )");
            System.exit(1);
        }

        char currentChar;
        int length = inputString.length();

        for (int i = 0; i < inputString.length(); ++i) {
            currentChar = inputString.charAt(i);

            if (Character.isDigit(currentChar) || (inputString.charAt(i) == '.')) {
                sb.append(currentChar);
                System.out.println(sb.toString());
            } else if (currentChar == '-') {
                if (i > 0 && (i <= length - 1) && precedenceOfSymbol(inputString.charAt(i - 1)) != -1 && Character.isDigit(inputString.charAt(i + 1))) {
                    valueSign = -1;
                }
                if ((i == 0) && Character.isDigit(inputString.charAt(i + 1))) {
                    valueSign = -1;
                }
                if ((i > 0) && Character.isDigit(inputString.charAt(i + 1)) && inputString.charAt(i - 1) == '-') {
                    valueSign = 1;
                }
            } else if (currentChar == '(') {
                operatorsStack.push(currentChar);
            } else if (currentChar == ')') {
                expression.add(Double.parseDouble(sb.toString()) * valueSign);
                sb.setLength(0);
                valueSign = 1;
                while (!operatorsStack.isEmpty() && operatorsStack.peek() != '(') {
                    expression.add(operatorsStack.pop());
                    System.out.println(expression);
                }
                if (!operatorsStack.isEmpty() && operatorsStack.peek() != '(') {
                    System.err.println("Invalid Expression");
                } else {
                    operatorsStack.pop();
                    System.out.println(operatorsStack);
                }
                // an operator is encountered
            } else {
                while (!operatorsStack.isEmpty() && (precedenceOfSymbol(currentChar) <= precedenceOfSymbol(operatorsStack.peek()))) {
                    expression.add(operatorsStack.pop());
                    System.out.println(expression);
                }
                operatorsStack.push(currentChar);
                System.out.println(operatorsStack);
            }
        }
        while (!operatorsStack.isEmpty()) {
            expression.add(operatorsStack.pop());
            System.out.println(expression);
        }
        System.out.println(expression);
    }

    int precedenceOfSymbol(char ch) {
        switch (ch) {
        case '+':
            return 1;
        case '-':
            return 1;
        case '*':
            return 2;
        case '/':
            return 2;
        case '(':
            return 0;
        case ')':
            return -1;
        default:
            return -1;
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
}
