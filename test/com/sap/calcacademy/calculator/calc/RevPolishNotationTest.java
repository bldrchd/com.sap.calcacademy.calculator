package com.sap.calcacademy.calculator.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.calcacademy.calculator.calc.ReversePolishNotation;

public class RevPolishNotationTest {

    @Test
    public void testcalculationWithRPN_ComplexOnlyPositive() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        // 22+(3/5)+1-1-(2-3)
        String[] postfixExpression = { "22.0", "3.0", "5.0", "/", "+", "1.0", "+", "1", "-", "2", "3", "-", "-" };
        Number expectedResult = 23.6;
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(expectedResult, rpn.calculationWithRPN(postfixExpression));
    }

    @Test
    public void testcalculationWithRPN_ComplexWithNegatives() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        // 22+(3/5)+1-1-(-3)
        String[] postfixExpression = { "22.0", "3.0", "5.0", "/", "+", "1.0", "+", "1", "-", "-3", "-" };
        Number expectedResult = 25.6;
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(expectedResult, rpn.calculationWithRPN(postfixExpression));
    }

    @Test
    public void testcalculationWithRPN_Simple() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String[] postfixExpression = { "2.0", "2.0", "+" };
        Number expectedResult = 4.0;
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(expectedResult, rpn.calculationWithRPN(postfixExpression));
    }

    @Test
    public void testcalculationWithRPN_SimpleWithDivision() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        System.out.println("From: 2+2/3");
        String[] postfixExpression = { "2.0", "2.0", "3.0", "/", "+" };
        Number expectedResult = 2.6666666666666665;
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(expectedResult, rpn.calculationWithRPN(postfixExpression));
    }

    @Test
    public void testcalculationWithRPN_SimpleWithDivisionAndParenthesis() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        System.out.println("From: (2+2)/3");
        String[] postfixExpression = { "2.0", "2.0", "+", "3.0", "/" };
        Number expectedResult = 1.3333333333333333;
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(expectedResult, rpn.calculationWithRPN(postfixExpression));
    }

    @Test
    public void testcalculationWithRPN_SimpleDivision() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String[] postfixExpression = { "2.0", "3.0", "/" };
        Number expectedResult = 0.6666666666666666;
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(expectedResult, rpn.calculationWithRPN(postfixExpression));
    }

    @Test
    public void testcalculationWithRPN_SimpleMultiply() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String[] postfixExpression = { "2.0", "3.0", "*" };
        Number expectedResult = 6.0;
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(expectedResult, rpn.calculationWithRPN(postfixExpression));
    }

    @Test
    public void testcalculationWithRPN_SimpleSubtract() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        System.out.println("Test: 2-3= ");
        String[] postfixExpression = { "2.0", "3.0", "-" };
        Number expectedResult = -1.0;
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(expectedResult, rpn.calculationWithRPN(postfixExpression));
    }

    @Test
    public void testcalculationWithRPN_SimpleNegative() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        System.out.println("Test: 1--3= ");
        String[] postfixExpression = { "1.0", "-3.0", "-" };
        Number expectedResult = 4.0;
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(expectedResult, rpn.calculationWithRPN(postfixExpression));
    }

    @Test
    public void testcalculationWithRPN_SimpleTwoNegatives() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        System.out.println("Test: -5-6= ");
        String[] postfixExpression = { "-5.0", "6.0", "-" };
        Number expectedResult = -11.0;
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(expectedResult, rpn.calculationWithRPN(postfixExpression));
    }

    @Test
    public void testcalculationWithRPN_SimpleStartingWithNegative() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        System.out.println("Test: -5+6= ");
        String[] postfixExpression = { "-5.0", "6.0", "+" };
        Number expectedResult = 1.0;
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(expectedResult, rpn.calculationWithRPN(postfixExpression));
    }

    @Test(expected = ArithmeticException.class)
    public void testcalculationWithRPN_DivideByZero() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        System.out.println("Test: 3/0= ");
        String[] postfixExpression = { "3.0", "0.0", "/" };
        ReversePolishNotation rpn = new ReversePolishNotation();
        rpn.calculationWithRPN(postfixExpression);
    }

    @Test
    public void testcalculationWithRPN_StartingWithNegative() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        System.out.println("Test: -1+2= ");
        String[] postfixExpression = { "-1.0", "2.0", "+" };
        Number expectedResult = 1.0;
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(expectedResult, rpn.calculationWithRPN(postfixExpression));
    }
}
