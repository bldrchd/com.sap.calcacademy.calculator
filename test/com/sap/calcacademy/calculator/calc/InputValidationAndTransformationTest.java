package com.sap.calcacademy.calculator.calc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.calcacademy.calculator.exceptions.CalculationValidationException;

public class InputValidationAndTransformationTest {

    /*
     * @Test public void checkIfContainsLettersTest() { System.out.println(
     * " --- " + new Object() { }.getClass().getEnclosingMethod().getName() +
     * " --- "); InputValidationAndTransformation ivat = new
     * InputValidationAndTransformation(); assertEquals(true,
     * ivat.findLetters("22+a4*156-x/123-4--3")); }
     */
    @Test
    public void checkForRemovedWhiteSpacesTest() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputToTest = "22+ 3/ 5	+1 -\"1 -		-3\"";
        String expected = "22+3/5+1-\"1--3\"";
        InputValidationAndTransformation ipd = new InputValidationAndTransformation();
        assertEquals(expected, ipd.removeWhitespaces(inputToTest));
    }

    @Test
    public void checkCorrectParenthesisCountTest() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputToTestCorrect = "22+ 3/ ( 5	+1 )-\"1 -		-3\"";
        String inputToTestNotCorrect = "22+ 3/ ( 5	+1 ))-\"1 -		-3\"";
        InputValidationAndTransformation ipd = new InputValidationAndTransformation();
        assertTrue(ipd.correctParentheses(inputToTestCorrect));
        assertFalse(ipd.correctParentheses(inputToTestNotCorrect));
    }

    @Test
    public void overallPreValidationTest() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        // String[] inputToTest = { "22", "+", " ", "3", "/", " (", "5 ", " ",
        // "+1", " ", " ", ")", "-", "1", "-", " ", "(", " -3)" };
        String inputToTest = "22 + 3/ (5     +1   ) -1 - ( -3)";
        String expected = "22+3/(5+1)-1-(-3)";
        InputValidationAndTransformation ipd = new InputValidationAndTransformation();
        assertEquals(expected, ipd.validateAndTrimInput(inputToTest));
        System.out.println(ipd.validateAndTrimInput(inputToTest));
    }

    public @Rule ExpectedException thrown = ExpectedException.none();

    @Test
    public void notCorrectParenthesesTest() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        thrown.expect(CalculationValidationException.class);
        String inputToTest = "22 + 3/ )5     +1    -1 - ( -3)";
        InputValidationAndTransformation ivat = new InputValidationAndTransformation();
        ivat.validateAndTrimInput(inputToTest);
    }

}
