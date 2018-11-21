package com.sap.calcacademy.calculator.calc;

import java.util.ArrayList;

import com.sap.calcacademy.calculator.exceptions.CalculationValidationException;

/**
 * Calculation of expression without generation of Postfix expression
 *
 */
public class CalculationAlgo { // TODO
    String token = "";
    ArrayList<String> expression = new ArrayList<String>();

    public String parentheses(String inputString) throws CalculationValidationException { // TODO
                                                                                          // runtime
                                                                                          // exception
        // CalculationAlgo check = new CalculationAlgo(); // TODO remove it
        boolean hasParentheses = inputString.contains(Character.toString('(')) || inputString.contains(Character.toString(')'));
        if (hasParentheses) {
            for (int i = 0; i < inputString.length(); i++) {
                if (Character.isDigit(i) && inputString.charAt(i + 1) == '(') {
                    throw new CalculationValidationException("Missing operator or operand between " + i + " and " + i + 1 + "(");
                }
                if (inputString.charAt(i) == ')') {
                    for (int j = i; j >= 0; j--) {
                        if (inputString.charAt(j) == '(') {
                            String subStr = inputString.substring(j + 1, i);
                            subStr = parentheses(subStr);// check.parentheses(subStr);
                            inputString = inputString.substring(0, j) + subStr + inputString.substring(i + 1);
                            j = i = 0;
                        }
                    }
                }
            }
            /*
             * if (inputString.contains(Character.toString('(')) ||
             * inputString.contains(Character.toString(')')) ||
             * inputString.contains(Character.toString('(')) ||
             * inputString.contains(Character.toString(')'))) { throw new
             * CalculationValidationException("Incorrect parentheses position."
             * ); }
             */
        }
        inputString = determinate(inputString);// check.determinate(inputString);
        return inputString;
    }

    private String determinate(String inputString) {
        System.out.println("determinate()" + inputString);
        ArrayList<String> stack = new ArrayList<String>();

        for (int i = inputString.length() - 1; i >= 0; i--) {
            char currentChar = inputString.charAt(i);
            System.out.println("currentChar: " + currentChar);
            char prevChar = 0;
            if (i > 0) {
                prevChar = inputString.charAt(i - 1);
                System.out.println("prevChar: " + prevChar);
            }
            if (Character.isDigit(currentChar)) { // what about numbers >9?
                token = currentChar + token;
                System.out.println("token: " + token);
                if (i == 0) {
                    collect();
                }
            } else {
                if (currentChar == '.') {
                    token = currentChar + token;
                } else if (currentChar == '-' && (i == 0 || !Character.isDigit(prevChar))) {
                    token = currentChar + token;
                    collect();
                } else {
                    collect();
                    token += currentChar; // why not token=
                    collect();
                    // currentChar?
                }
            }
        }
        expression = result(expression, "*", "/");
        expression = result(expression, "+", "-");
        return expression.get(0);
    }

    public void collect() {
        if (!token.equals("")) {
            expression.add(0, token);
            token = "";
            System.out.println(token + ": token");
        }
    }

    public ArrayList<String> result(ArrayList<String> values, String oper1, String oper2) {
        System.out.println("result" + values.toString() + "oper1: " + oper1 + " oper2: " + oper2);
        Double result = new Double(0);

        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(oper1) || values.get(i).equals(oper2)) {
                /*
                 * / Looks the expression if contains operator (oper1 or oper2),
                 * then calculates it
                 */
                Double operand1 = Double.valueOf(values.get(i - 1));
                Double operand2 = Double.valueOf(values.get(i + 1));
                switch (values.get(i)) {
                case "+":
                    result = (Double) new AddOperation().execute(operand1, operand2);
                    break;
                case "-":
                    result = (Double) new SubtractOperation().execute(operand1, operand2);
                    break;
                case "*":
                    result = (Double) new MultiplyOperation().execute(operand1, operand2);
                    break;
                case "/":
                    result = (Double) new DivideOperation().execute(operand1, operand2);
                    break;
                default:
                    break;
                }
                try {
                    values.set(i, result.toString());
                    values.remove(i + 1);
                    values.remove(i - 1);
                } catch (Exception ignored) {
                    // TODO out of bounds
                }
                System.out.println("result: " + result);
            }

            else {
                continue;
            }
            i = 0;
        }
        return values;
    }
}
