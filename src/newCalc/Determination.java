package newCalc;

import java.util.ArrayList;
import java.util.Stack;

public class Determination {
    private StringBuilder sb = new StringBuilder();
    private ArrayList<Object> expression = new ArrayList<Object>();
    private int valueSign = 1;

    void determinate(String inputString) {

        Stack<Character> operatorsStack = new Stack<Character>();

        if (inputString.charAt(0) == ')') {
            System.out.println("ERR - starts with )");
            System.exit(1);
        }

        char currentChar;
        char prevChar = 0;
        int length = inputString.length();

        for (int i = 0; i < inputString.length(); ++i) {
            System.out.println("E: " + expression);
            System.out.println("OpSt: " + operatorsStack);
            currentChar = inputString.charAt(i);

            if (i > 0) {
                prevChar = inputString.charAt(i - 1);
            }

            if (Character.isDigit(currentChar) || (inputString.charAt(i) == '.')) {
                sb.append(currentChar);
                System.out.println(sb.toString());
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
            }
            // an operator is encountered
            else {
                if (currentChar == '-') {
                    if ((i == 0) && Character.isDigit(inputString.charAt(i + 1))) {
                        System.out.println("Here1");
                        valueSign = -1;
                        System.out.println(valueSign);
                        continue;
                    }
                    if (i > 0 && (i <= length - 1) && precedenceOfSymbol(inputString.charAt(i - 1)) > 0 && Character.isDigit(inputString.charAt(i + 1))) {
                        System.out.println("Here3 ");
                        valueSign = -1;
                        continue;
                    }
                    if ((i > 0) && (prevChar == '(')) {
                        System.out.println("Here4");
                        valueSign = -1;
                        continue;
                    } else { // single -
                        addValueToSB();
                        while (!operatorsStack.isEmpty() && ((precedenceOfSymbol(currentChar) <= precedenceOfSymbol(operatorsStack.peek())))) {
                            expression.add(operatorsStack.pop());
                            System.out.println(expression);
                            System.out.println("OP Stack: " + operatorsStack);
                        }
                    }
                }
                addValueToSB();
                while (!operatorsStack.isEmpty() && ((precedenceOfSymbol(currentChar) <= precedenceOfSymbol(operatorsStack.peek())))) {
                    System.out.println(currentChar + "is " + (precedenceOfSymbol(currentChar) <= precedenceOfSymbol(operatorsStack.peek())) + "from " + operatorsStack.peek());
                    expression.add(operatorsStack.pop());
                    System.out.println("Added operator : ");
                    System.out.println(expression);
                    System.out.println("OP Stack: " + operatorsStack);
                }
                operatorsStack.push(currentChar);
                System.out.println("OP Stack : " + operatorsStack);
            }
        }
        addValueToSB();
        while (!operatorsStack.isEmpty()) {
            expression.add(operatorsStack.pop());
            System.out.println("Expr: " + expression);
        }
        System.out.println(expression);
    }

    void addValueToSB() {
        if (sb.length() != 0) {
            expression.add(Double.parseDouble(sb.toString()) * valueSign);
            sb.setLength(0);
            valueSign = 1;
        }
        System.out.println("Expr: " + expression);
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
