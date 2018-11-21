package com.sap.calcacademy.calculator.calc.postfix;

import java.util.ArrayList;
import java.util.Stack;

public class PostfixExpression {

    private ArrayList<Object> expression = new ArrayList<>();
    private int valueSign = 1;

    /**
     * Determinate the inputString as a postfix expression
     * 
     * @param currentChar
     *            The concrete char from the inputString that is processed for
     *            determination
     * @param expression
     *            Stores the postfix expression during the process
     * @param inputString
     *            User input as a String
     * @param length
     *            The length of the inputString
     * @param operatorsStack
     *            Where operators are stored during the process
     * 
     * @param prevChar
     *            The previous char from the inputString that is processed for
     *            determination, when the index is grater than 0.
     * @param sb
     *            Buffer that stores numbers as chars before turning them to
     *            values for the expression
     * @param valueSign
     *            The sign that should be applied to number in the expression -
     *            1 for positive or -1 for negative.
     * @return Postfix expression as a String
     */
    public String[] createPostfixExpression(String inputString) throws NumberFormatException, IllegalArgumentException {
        Stack<Character> operatorsStack = new Stack<>();
        char currentChar;
        char prevChar = 0;
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = 0; i < inputString.length(); ++i) {
                System.out.println("E: " + expression);
                System.out.println("OpSt: " + operatorsStack);
                currentChar = inputString.charAt(i);

                if (i > 0) {
                    prevChar = inputString.charAt(i - 1);
                }

                if (currentCharIsDigit(currentChar)) {
                    sb.append(currentChar);
                    System.out.println(sb.toString());
                } else if (currentChar == '(') {
                    operatorsStack.push(currentChar);
                } else if (currentChar == ')') {
                    addValueToSB(sb);
                    while (!operatorsStack.isEmpty() && operatorsStack.peek() != '(') {
                        expression.add(operatorsStack.pop());
                        System.out.println(expression);
                    }
                    operatorsStack.pop();
                    System.out.println("OP Stack : " + operatorsStack);
                } else {
                    if (currentChar == '-') {
                        if (i < inputString.length() - 1) {
                            char nextChar = inputString.charAt(i + 1);
                            int length = inputString.length();
                            if (valueSignIsNegative(i, currentChar, prevChar, nextChar, length)) // TODO
                                continue;
                        } else {
                            throw new IllegalArgumentException("There is - in the end.");
                        }

                    }
                    addValueToSB(sb);
                    while (!operatorsStack.isEmpty() && ((precedenceOfSymbol(currentChar) <= precedenceOfSymbol(operatorsStack.peek())))) {
                        expression.add(operatorsStack.pop());
                    }
                    operatorsStack.push(currentChar);
                    System.out.println("OP Stack : " + operatorsStack);
                }
            }
            addValueToSB(sb);
            while (!operatorsStack.isEmpty()) {
                expression.add(operatorsStack.pop());
                System.out.println("Expr: " + expression);
            }
            System.out.println(expression);

            return buildFinalPostfixExpression();
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException(nfe.getMessage());
        }
    }

    /**
     * Check if the current char has a condition of a negative value
     * 
     * @param i
     *            Index from the main loop
     * @param currentChar
     *            Current character in the loop
     * @param prevChar
     *            Previous character in the loop
     * @param nextChar
     *            Next character in the loop
     * @param length
     *            Length of the input string
     * @return True if a negative value condition is found
     */

    private boolean valueSignIsNegative(int i, char currentChar, char prevChar, char nextChar, int length) {
        if ((i == 0) && Character.isDigit(nextChar)) {
            valueSign = -1;
            System.out.println(valueSign);
            return true;
        }
        if (i > 0 && (i <= length - 1) && precedenceOfSymbol(prevChar) > 0 && Character.isDigit(nextChar)) {
            valueSign = -1;
            return true;
        }
        if ((i > 0) && (prevChar == '(')) {
            valueSign = -1;
            return true;
        }
        return false;
    }

    /**
     * Returns true if the current char is digit
     */
    private boolean currentCharIsDigit(char currentChar) {
        return (Character.isDigit(currentChar) || (currentChar == '.'));
    }

    /**
     * Takes digit from String Builder, turns them into Double values with sign
     * and adds this value to the expression
     */
    private void addValueToSB(StringBuilder sb) throws NumberFormatException {
        try {
            if (sb.length() != 0) {
                expression.add(Double.parseDouble(sb.toString()) * valueSign);
                sb.setLength(0);
                valueSign = 1;
            }
            System.out.println("Expr: " + expression);
        } catch (NumberFormatException nfe) { // TODO - do I need this new
                                              // Exception?
            throw new NumberFormatException("Cannot parse to Double from StringBuilder.");
        }
    }

    /**
     * Returns Integer value for priority, that is used as precedence of symbols
     * of operators
     */
    private int precedenceOfSymbol(char ch) {
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

    /**
     * Creates final postfix expression as String array
     */
    private String[] buildFinalPostfixExpression() {
        final String[] postfixExpression = new String[expression.size()];
        for (int i = 0; i < expression.size(); i++) {
            if (expression.get(i) != null) {
                postfixExpression[i] = expression.get(i).toString();
            }
        }
        return postfixExpression;
    }
}
