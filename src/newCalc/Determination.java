package newCalc;

import java.util.ArrayList;
import java.util.Stack;

public class Determination {

    private StringBuilder sb = new StringBuilder();
    private ArrayList<Object> expression = new ArrayList<Object>();
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
    String[] determinate(String inputString) {
        Stack<Character> operatorsStack = new Stack<Character>();
        char currentChar;
        char prevChar = 0;
        int length = inputString.length();

        if (inputString.charAt(0) == ')') {
            System.err.println("ERR - starts with )");
            System.exit(1);
        }

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
            } else {
                if (currentChar == '-') {
                    if ((i == 0) && Character.isDigit(inputString.charAt(i + 1))) {
                        valueSign = -1;
                        System.out.println(valueSign);
                        continue;
                    }
                    if (i > 0 && (i <= length - 1) && precedenceOfSymbol(prevChar) > 0 && Character.isDigit(inputString.charAt(i + 1))) {
                        valueSign = -1;
                        continue;
                    }
                    if ((i > 0) && (prevChar == '(')) {
                        valueSign = -1;
                        continue;
                    } else { // single - //TODO (Consider if needed to be here
                             // or manipulated as the others operators)
                        addValueToSB();
                        while (!operatorsStack.isEmpty() && ((precedenceOfSymbol(currentChar) <= precedenceOfSymbol(operatorsStack.peek())))) {
                            expression.add(operatorsStack.pop());
                        }
                    }
                }
                addValueToSB();
                while (!operatorsStack.isEmpty() && ((precedenceOfSymbol(currentChar) <= precedenceOfSymbol(operatorsStack.peek())))) {
                    expression.add(operatorsStack.pop());
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

        // TODO (Consider if buildFinalPostfixExpression() is better to be
        // called here and returned to Calculator class than called from
        // Calc.class

        return buildFinalPostfixExpression();
    }

    /**
     * Takes digit from String Builder, turns them into Double values with sign
     * and adds this value to the expression
     */
    private void addValueToSB() {
        if (sb.length() != 0) {
            expression.add(Double.parseDouble(sb.toString()) * valueSign);
            sb.setLength(0);
            valueSign = 1;
        }
        System.out.println("Expr: " + expression);
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
        String[] postfixExpression = new String[expression.size()];
        for (int i = 0; i < expression.size(); i++) {
            if (expression.get(i) != null) {
                postfixExpression[i] = expression.get(i).toString();
            }
        }
        return postfixExpression;
    }
}
