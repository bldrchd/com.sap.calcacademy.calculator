package newCalc;

import java.util.ArrayList;
import java.util.Stack;

@Deprecated
public class InputDetermination {

    private ArrayList<Object> expression = new ArrayList<Object>();
    private StringBuilder sb = new StringBuilder();
    private Stack<Character> operatorsStack = new Stack<Character>();
    private int valueSign = 1;

    void determinate(String inputString) {

        if (inputString.charAt(0) == ')') {
            System.out.println("ERR - starts with )");
            System.exit(1);
        }
        char currentChar;
        int length = inputString.length();
        for (int i = 0; i < inputString.length(); ++i) {
            currentChar = inputString.charAt(i);

            if (Character.isDigit(currentChar)) { // TODO
                while ((i < length) && (Character.isDigit(inputString.charAt(i)) || inputString.charAt(i) == '.') && inputString.charAt(i + 1) != 0) {
                    sb.append(inputString.charAt(i++));
                    System.out.println(sb.toString());
                    if (i == length) {
                        break;
                    }
                }
                expression.add(Double.parseDouble(sb.toString()) * valueSign);
                sb.setLength(0);
                valueSign = 1;
                i--;
                // System.out.println(expression);

            } else if (currentChar == '-' && (i > 0 && precedenceOfSymbol(inputString.charAt(i - 1)) != -1) && Character.isDigit(inputString.charAt(i + 1))) {
                valueSign = -1;
            } else if (currentChar == '-' && (i == 0) && Character.isDigit(inputString.charAt(i + 1))) {
                valueSign = -1;
            } else if (currentChar == '-' && (i > 0) && Character.isDigit(inputString.charAt(i + 1)) && inputString.charAt(i - 1) == '-') {
                valueSign = 1;
            } else if (currentChar == '(') {
                operatorsStack.push(currentChar);
                // System.out.println(operatorsStack);
            } else if (currentChar == ')') {
                while (!operatorsStack.isEmpty() && operatorsStack.peek() != '(') {
                    expression.add(operatorsStack.pop());
                    // System.out.println(expression);
                }
                if (!operatorsStack.isEmpty() && operatorsStack.peek() != '(') {
                    System.err.println("Invalid Expression");
                } else {
                    operatorsStack.pop();
                    // System.out.println(operatorsStack);
                }
                // an operator is encountered
            } else {
                while (!operatorsStack.isEmpty() && (precedenceOfSymbol(currentChar) <= precedenceOfSymbol(operatorsStack.peek()))) {
                    expression.add(operatorsStack.pop());
                    // System.out.println(expression);
                }
                operatorsStack.push(currentChar);
                // System.out.println(operatorsStack);
            }
        }
        while (!operatorsStack.isEmpty()) {
            expression.add(operatorsStack.pop());
            // System.out.println(expression);
        }
        System.out.println(expression);
        buildFinalPostfixExpression();

    }

    void doubleValueManipulation(String inputString, int i, char charAtIndex, char nextCharAtIndex) {
        if (!Character.isDigit(inputString.charAt(i - 1)) && precedenceOfSymbol(inputString.charAt(i - 1)) > 0) { // e.g.:+.25->+0.25
            sb.append(0 + charAtIndex);
        }
        if (!Character.isDigit(nextCharAtIndex) && Character.isDigit(inputString.charAt(i - 1)) && precedenceOfSymbol(nextCharAtIndex) > 0) { // e.g:
                                                                                                                                              // 2.+1->2.0+1
            sb.append(0);
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
}
