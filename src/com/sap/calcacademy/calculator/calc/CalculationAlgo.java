package com.sap.calcacademy.calculator.calc;

import java.util.ArrayList;

import com.sap.calcacademy.calculator.exceptions.CalculationValidationException;

/**
 * Calculation of expression without generation of Postfix expression
 *
 */
public class CalculationAlgo {
    String token = "";
    ArrayList<String> expression = new ArrayList<>();

    public String startCalculating(String inputString) throws CalculationValidationException {
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
                            subStr = startCalculating(subStr);
                            inputString = inputString.substring(0, j) + subStr + inputString.substring(i + 1);
                            j = i = 0;
                        }
                    }
                }
            }
        }
        return determinate(inputString);
    }

    private String determinate(String inputString) {
        for (int i = inputString.length() - 1; i >= 0; i--) {
            char currentChar = inputString.charAt(i);
            char prevChar = 0;
            if (i > 0) {
                prevChar = inputString.charAt(i - 1);
            }
            if (Character.isDigit(currentChar)) {
                token = currentChar + token;
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
                    token += currentChar;
                    collect();
                }
            }
        }
        expression = result(expression, "*", "/");
        expression = result(expression, "+", "-");
        return expression.get(0);
    }

    private void collect() {
        if (!token.equals("")) {
            expression.add(0, token);
            token = "";
        }
    }

    private ArrayList<String> result(ArrayList<String> values, String oper1, String oper2) {
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
                values.set(i, result.toString());
                values.remove(i + 1);
                values.remove(i - 1);
            }

            else {
                continue;
            }
            i = 0;
        }
        return values;
    }
}
