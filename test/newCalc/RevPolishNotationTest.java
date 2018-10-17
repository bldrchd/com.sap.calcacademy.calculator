package newCalc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RevPolishNotationTest {

    @Test
    public void testEvaluateRPN_ComplexOnlyPositive() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        // 22+(3/5)+1-1-(2-3)
        String[] postfixExpression = { "22.0", "3.0", "5.0", "/", "+", "1.0", "+", "1", "-", "2", "3", "-", "-" };
        Number expectedResult = 23.6;
        RevPolishNotation rpn = new RevPolishNotation();
        assertEquals(expectedResult, rpn.evaluateRPN(postfixExpression));
    }

    @Test
    public void testEvaluateRPN_ComplexWithNegatives() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        // 22+(3/5)+1-1-(-3)
        String[] postfixExpression = { "22.0", "3.0", "5.0", "/", "+", "1.0", "+", "1", "-", "-3", "-" };
        Number expectedResult = 25.6;
        RevPolishNotation rpn = new RevPolishNotation();
        assertEquals(expectedResult, rpn.evaluateRPN(postfixExpression));
    }

    @Test
    public void testEvaluateRPN_Simple() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String[] postfixExpression = { "2.0", "2.0", "+" };
        Number expectedResult = 4.0;
        RevPolishNotation rpn = new RevPolishNotation();
        assertEquals(expectedResult, rpn.evaluateRPN(postfixExpression));
    }

    @Test
    public void testEvaluateRPN_SimpleWithDivision() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        System.out.println("From: 2+2/3");
        String[] postfixExpression = { "2.0", "2.0", "3.0", "/", "+" };
        Number expectedResult = 2.6666666666666665;
        RevPolishNotation rpn = new RevPolishNotation();
        assertEquals(expectedResult, rpn.evaluateRPN(postfixExpression));
    }

    @Test
    public void testEvaluateRPN_SimpleWithDivisionAndParenthesis() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        System.out.println("From: (2+2)/3");
        String[] postfixExpression = { "2.0", "2.0", "+", "3.0", "/" };
        Number expectedResult = 1.3333333333333333;
        RevPolishNotation rpn = new RevPolishNotation();
        assertEquals(expectedResult, rpn.evaluateRPN(postfixExpression));
    }

    @Test
    public void testEvaluateRPN_SimpleDivision() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String[] postfixExpression = { "2.0", "3.0", "/" };
        Number expectedResult = 0.6666666666666666;
        RevPolishNotation rpn = new RevPolishNotation();
        assertEquals(expectedResult, rpn.evaluateRPN(postfixExpression));
    }

    @Test
    public void testEvaluateRPN_SimpleMultiply() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String[] postfixExpression = { "2.0", "3.0", "*" };
        Number expectedResult = 6.0;
        RevPolishNotation rpn = new RevPolishNotation();
        assertEquals(expectedResult, rpn.evaluateRPN(postfixExpression));
    }

    @Test
    public void testEvaluateRPN_SimpleSubtract() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        System.out.println("Test: 2-3= ");
        String[] postfixExpression = { "2.0", "3.0", "-" };
        Number expectedResult = -1.0;
        RevPolishNotation rpn = new RevPolishNotation();
        assertEquals(expectedResult, rpn.evaluateRPN(postfixExpression));
    }

    @Test
    public void testEvaluateRPN_SimpleNegative() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        System.out.println("Test: 1--3= ");
        String[] postfixExpression = { "1.0", "-3.0", "-" };
        Number expectedResult = 4.0;
        RevPolishNotation rpn = new RevPolishNotation();
        assertEquals(expectedResult, rpn.evaluateRPN(postfixExpression));
    }

    @Test
    public void testEvaluateRPN_SimpleTwoNegatives() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        System.out.println("Test: -5-6= ");
        String[] postfixExpression = { "-5.0", "6.0", "-" };
        Number expectedResult = -11.0;
        RevPolishNotation rpn = new RevPolishNotation();
        assertEquals(expectedResult, rpn.evaluateRPN(postfixExpression));
    }

    @Test
    public void testEvaluateRPN_SimpleStartingWithNegative() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        System.out.println("Test: -5+6= ");
        String[] postfixExpression = { "-5.0", "6.0", "+" };
        Number expectedResult = 1.0;
        RevPolishNotation rpn = new RevPolishNotation();
        assertEquals(expectedResult, rpn.evaluateRPN(postfixExpression));
    }

    @Test(expected = ArithmeticException.class)
    public void testEvaluateRPN_DivideByZero() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        System.out.println("Test: 3/0= ");
        String[] postfixExpression = { "3.0", "0.0", "/" };
        RevPolishNotation rpn = new RevPolishNotation();
        rpn.evaluateRPN(postfixExpression);
    }

    @Test
    public void testEvaluateRPN_StartingWithNegative() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        System.out.println("Test: -1+2= ");
        String[] postfixExpression = { "-1.0", "2.0", "+" };
        Number expectedResult = 1.0;
        RevPolishNotation rpn = new RevPolishNotation();
        assertEquals(expectedResult, rpn.evaluateRPN(postfixExpression));
    }
}
