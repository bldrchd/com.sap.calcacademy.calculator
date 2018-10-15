package newCalc;

import java.util.ArrayList;
import java.util.Stack;

public class Determination {
    private StringBuilder sb = new StringBuilder();
    private ArrayList<Object> expression = new ArrayList<Object>();
    private int valueSign = 1;

    void deteminate(String inputString) {

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
            } else if (currentChar == '-') { // negative chars
                if (i > 0 && (i <= length - 1) && precedenceOfSymbol(inputString.charAt(i - 1)) != -1 && Character.isDigit(inputString.charAt(i + 1))) {
                    valueSign = -1;
                    // addValueToSB();
                }
                if ((i == 0) && Character.isDigit(inputString.charAt(i + 1))) {
                    valueSign = -1;
                    // addValueToSB();
                }
                if ((i > 0) && Character.isDigit(inputString.charAt(i + 1)) && inputString.charAt(i - 1) == '-') {
                    valueSign = 1;
                    // addValueToSB();
                }
            } else if (currentChar == '(') {
                operatorsStack.push(currentChar);
            } else if (currentChar == ')') {
                addValueToSB();
                while (!operatorsStack.isEmpty() && operatorsStack.peek() != '(') {
                    expression.add(operatorsStack.pop());
                    System.out.println(expression);
                }
                if (!operatorsStack.isEmpty() && operatorsStack.peek() != '(') {
                    System.err.println("Invalid Expression");
                } else {
                    operatorsStack.pop();
                    System.out.println("OP Stack : " + operatorsStack);
                }
                // an operator is encountered
            } else {
                addValueToSB();
                while (!operatorsStack.isEmpty() && (precedenceOfSymbol(currentChar) <= precedenceOfSymbol(operatorsStack.peek()))) {
                    expression.add(operatorsStack.pop());
                    System.out.println(expression);
                }
                operatorsStack.push(currentChar);
                System.out.println("OP Stack : " + operatorsStack);
            }
        }
        addValueToSB();
        while (!operatorsStack.isEmpty()) {
            expression.add(operatorsStack.pop());
            System.out.println(expression);
        }
        System.out.println(expression);
    }

    void addValueToSB() {
        if (sb.length() != 0) {
            expression.add(Double.parseDouble(sb.toString()) * valueSign);
            sb.setLength(0);
            valueSign = 1;
        }
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
