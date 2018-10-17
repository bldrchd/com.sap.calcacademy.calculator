package newCalc;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DeterminationTest {
    @Test
    public void expectedPostfixExpressionTest_Complex() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputString = "22+(3/5)+1-1-(-3)";
        Determination dt = new Determination();
        String[] postfixExpression_Actual = dt.determinate(inputString);
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
        Determination id = new Determination();
        String[] postfixExpression_Actual = id.determinate(inputString);
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
        Determination id = new Determination();
        String[] postfixExpression_Actual = id.determinate(inputString);
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
        Determination id = new Determination();
        String[] postfixExpression_Actual = id.determinate(inputString);
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
        Determination id = new Determination();
        String[] postfixExpression_Actual = id.determinate(inputString);
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
        Determination id = new Determination();
        String[] postfixExpression_Actual = id.determinate(inputString);
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
        Determination id = new Determination();
        String[] postfixExpression_Actual = id.determinate(inputString);
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
        Determination id = new Determination();
        String[] postfixExpression_Actual = id.determinate(inputString);
        String[] postfixExpression_Expected = { "-1.0", "2.0", "+" };
        for (int i = 0; i <= postfixExpression_Actual.length - 1; i++) {
            assertTrue(postfixExpression_Expected[i].equals(postfixExpression_Actual[i]));
        }
    }
}
