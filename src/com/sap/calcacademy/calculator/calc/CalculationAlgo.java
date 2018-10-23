package com.sap.calcacademy.calculator.calc;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.sap.calcacademy.calculator.exceptions.CalculationValidationException;

/**
 * Calculation of expression without generation of Postfix expression
 *
 */
public class CalculationAlgo {
    String token = "";
    ArrayList<String> expression = new ArrayList<String>();

    public String parentheses(String inputString) throws CalculationValidationException {
        CalculationAlgo check = new CalculationAlgo();
        boolean hasParentheses = inputString.contains(Character.toString('(')) || inputString.contains(Character.toString(')'));
        while (hasParentheses) {
            for (int i = 0; i < inputString.length(); i++) {
                if (Character.isDigit(i) && inputString.charAt(i + 1) == '(') {
                    throw new CalculationValidationException("Missing operator or operand between " + i + " and " + i + 1 + "(");
                }
                if (inputString.charAt(i) == ')') {
                    for (int j = i; j >= i; j--) {
                        if (inputString.charAt(j) == '(') {
                            String subStr = inputString.substring(j + 1, i);
                            subStr = check.parentheses(subStr);
                            inputString = inputString.substring(0, j) + subStr + inputString.substring(i + 1);
                            j = i = 0;
                        }
                    }
                }
            }
            if (inputString.contains(Character.toString('(')) || inputString.contains(Character.toString(')')) || inputString.contains(Character.toString('('))
                    || inputString.contains(Character.toString(')'))) {
                throw new CalculationValidationException("Incorrect parentheses position.");
            }
        }
        inputString = check.determinate(inputString);
        return inputString;
    }

    private String determinate(String inputString) {
        ArrayList<String> stack = new ArrayList<String>();

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
        }
    }

    public ArrayList<String> result(ArrayList<String> values, String oper1, String oper2) {
        Double result = new Double(0);

        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(oper1) || values.get(i).equals(oper2)) {
                switch (values.get(i)) {
                case "+":
                    result = (Double) new AddOperation().execute(Double.valueOf(values.get(i - 1)), Double.valueOf(values.get(i + 1)));
                case "-":
                    result = (Double) new SubtractOperation().execute(Double.valueOf(values.get(i - 1)), Double.valueOf(values.get(i + 1)));
                case "*":
                    result = (Double) new MultiplyOperation().execute(Double.valueOf(values.get(i - 1)), Double.valueOf(values.get(i + 1)));
                case "/":
                    result = (Double) new DivideOperation().execute(Double.valueOf(values.get(i - 1)), Double.valueOf(values.get(i + 1)));
                }
                try {
                    values.set(i, result.toString());
                    values.remove(i + 1);
                    values.remove(i - 1);
                } catch (Exception ignored) {
                    // TODO out of bounds
                }
            } else {
                continue;
            }
            i = 0;
        }
        return values;
    }

    @Test
    public void calculateTest() {
        String inputString = "(2 + 2)";
        Number expectedResult = 4;
        assertEquals(expectedResult, parentheses(inputString));
    }
}
