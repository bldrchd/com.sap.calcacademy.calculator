package com.sap.calcacademy.calculator.calc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.calcacademy.calculator.exceptions.CalculationValidationException;

public class InputValidationAndTransformationTest {
    InputValidationAndTransformation ivat;

    @Test
    public void checkForRemovedWhiteSpacesTest() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputToTest = "22+ 3/ 5	+1 -\"1 -		-3\"";
        String expected = "22+3/5+1-\"1--3\"";
        ivat = new InputValidationAndTransformation();
        assertEquals(expected, ivat.removeWhitespaces(inputToTest));
    }

    @Test(expected = CalculationValidationException.class)
    public void checkCorrectParenthesisCountTest() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputToTestCorrect = "22+ 3/ ( 5	+1 )-\"1 -		-3\"";
        String inputToTestNotCorrect = "22+ 3/ ( 5	+1 ))-\"1 -		-3\"";
        ivat = new InputValidationAndTransformation();
        assertTrue(ivat.correctParentheses(inputToTestCorrect));
        ivat.correctParentheses(inputToTestNotCorrect);
    }

    @Test
    public void overallPreValidationTest() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputToTest = "22 + 3/ (5     +1   ) -1 - ( -3)";
        String expected = "22+3/(5+1)-1-(-3)";
        ivat = new InputValidationAndTransformation();
        assertEquals(expected, ivat.validateAndTrimInput(inputToTest));
        System.out.println(ivat.validateAndTrimInput(inputToTest));
    }

    @Test
    public void foundLettersTest() { // TODO - are the following tests correct?
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        Throwable t = null;
        String inputToTest = "22 + 3/ s(5  a   +1   )& -1 - ( -3)";
        ivat = new InputValidationAndTransformation();
        try {
            ivat.validateAndTrimInput(inputToTest);
        } catch (RuntimeException re) {
            t = re;
        }
        assertTrue(t instanceof CalculationValidationException);
    }

    public @Rule ExpectedException thrown = ExpectedException.none();

    @Test
    public void notCorrectParenthesesTest() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        thrown.expect(CalculationValidationException.class);
        String inputToTest = "22 + 3/ )5     +1    -1 - ( -3)";
        ivat = new InputValidationAndTransformation();
        ivat.validateAndTrimInput(inputToTest);
    }

    @Test(expected = CalculationValidationException.class)
    public void emptyParenthesesTest() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputToTest = "22 + 3/ ()5     +1    -1 - ( -3)";
        ivat = new InputValidationAndTransformation();
        ivat.validateAndTrimInput(inputToTest);
    }

    @Test(expected = CalculationValidationException.class)
    public void tooManyClosingParenthesesTest() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputToTest = "22 + 3/ ()5 )    +1    -1 - ( -3)";
        ivat = new InputValidationAndTransformation();
        ivat.validateAndTrimInput(inputToTest);
    }

}
