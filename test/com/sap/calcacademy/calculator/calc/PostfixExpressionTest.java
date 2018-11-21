package com.sap.calcacademy.calculator.calc;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sap.calcacademy.calculator.calc.postfix.PostfixExpression;

public class PostfixExpressionTest {
    @Test
    public void expectedPostfixExpressionTest_Complex() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputString = "22+(3/5)+1-1-(-3)";
        PostfixExpression dt = new PostfixExpression();
        String[] postfixExpression_Actual = dt.createPostfixExpression(inputString);
        String[] postfixExpression_Expected = { "22.0", "3.0", "5.0", "/", "+", "1.0", "+", "1.0", "-", "-3.0", "-" };
        for (int i = 0; i <= postfixExpression_Actual.length - 1; i++) {
            assertTrue(postfixExpression_Expected[i].equals(postfixExpression_Actual[i]));
        }
    }

    @Test
    public void expectedPostfixExpression_SimpleTest() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputString = "2+2";
        PostfixExpression pe = new PostfixExpression();
        String[] postfixExpression_Actual = pe.createPostfixExpression(inputString);
        String[] postfixExpression_Expected = { "2.0", "2.0", "+" };
        for (int i = 0; i <= postfixExpression_Actual.length - 1; i++) {
            assertTrue(postfixExpression_Expected[i].equals(postfixExpression_Actual[i]));
        }
    }

    @Test
    public void expectedPostfixExpression_SimpleWithDivisionTest() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputString = "2+2/3";
        PostfixExpression pe = new PostfixExpression();
        String[] postfixExpression_Actual = pe.createPostfixExpression(inputString);
        String[] postfixExpression_Expected = { "2.0", "2.0", "3.0", "/", "+" };
        for (int i = 0; i <= postfixExpression_Actual.length - 1; i++) {
            assertTrue(postfixExpression_Expected[i].equals(postfixExpression_Actual[i]));
        }
    }

    @Test
    public void expectedPostfixExpression_SimpleWithDivisionAndParenthesisTest() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputString = "(2+2)/3";
        PostfixExpression pe = new PostfixExpression();
        String[] postfixExpression_Actual = pe.createPostfixExpression(inputString);
        String[] postfixExpression_Expected = { "2.0", "2.0", "+", "3.0", "/" };
        for (int i = 0; i <= postfixExpression_Actual.length - 1; i++) {
            assertTrue(postfixExpression_Expected[i].equals(postfixExpression_Actual[i]));
        }
    }

    @Test
    public void expectedPostfixExpression_OrderOfOperators() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputString = "1*2+3";
        PostfixExpression pe = new PostfixExpression();
        String[] postfixExpression_Actual = pe.createPostfixExpression(inputString);
        String[] postfixExpression_Expected = { "1.0", "2.0", "*", "3.0", "+" };
        for (int i = 0; i <= postfixExpression_Actual.length - 1; i++) {
            assertTrue(postfixExpression_Expected[i].equals(postfixExpression_Actual[i]));
        }
    }

    @Test
    public void expectedPostfixExpression_OrderOfOperatorsPrecedence() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputString = "1+2*3";
        PostfixExpression pe = new PostfixExpression();
        String[] postfixExpression_Actual = pe.createPostfixExpression(inputString);
        String[] postfixExpression_Expected = { "1.0", "2.0", "3.0", "*", "+" };
        for (int i = 0; i <= postfixExpression_Actual.length - 1; i++) {
            assertTrue(postfixExpression_Expected[i].equals(postfixExpression_Actual[i]));
        }
    }

    @Test
    public void expectedPostfixExpression_SimpleNegative() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputString = "1--3";
        PostfixExpression pe = new PostfixExpression();
        String[] postfixExpression_Actual = pe.createPostfixExpression(inputString);
        String[] postfixExpression_Expected = { "1.0", "-3.0", "-" };
        for (int i = 0; i <= postfixExpression_Actual.length - 1; i++) {
            assertTrue(postfixExpression_Expected[i].equals(postfixExpression_Actual[i]));
        }
    }

    @Test
    public void exprectedPostfixExpression_StartWithNegative() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputString = "-1+2";
        PostfixExpression pe = new PostfixExpression();
        String[] postfixExpression_Actual = pe.createPostfixExpression(inputString);
        String[] postfixExpression_Expected = { "-1.0", "2.0", "+" };
        for (int i = 0; i <= postfixExpression_Actual.length - 1; i++) {
            assertTrue(postfixExpression_Expected[i].equals(postfixExpression_Actual[i]));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void exprectedPostfixExpression_IncorrectOperatorInTheEnd() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputString = "-1+2-";
        PostfixExpression pe = new PostfixExpression();
        pe.createPostfixExpression(inputString);
    }
}
