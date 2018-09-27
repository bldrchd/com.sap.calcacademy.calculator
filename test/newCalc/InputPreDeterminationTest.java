package newCalc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InputPreDeterminationTest {

    @Test
    public void checkIfContainsLettersTest() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String[] inputToTest = { "22+ a/ 4* 156 -c 	/123 -4 - -3" };
        InputPreDetermination ipd = new InputPreDetermination();
        assertEquals(true, ipd.findLetters(inputToTest, "22+a4*156-x/123-4--3"));
    }

    @Test
    public void checkForRemovedWhiteSpacesTest() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputToTest = "22+ 3/ 5	+1 -\"1 -		-3\"";
        String expected = "22+3/5+1-\"1--3\"";
        InputPreDetermination ipd = new InputPreDetermination();
        assertEquals(expected, ipd.checkForWhiteSpaces(inputToTest));
    }

    @Test
    public void checkCorrectParenthesisCountTest() {
        System.out.println(" --- " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " --- ");
        String inputToTestCorrect = "22+ 3/ ( 5	+1 )-\"1 -		-3\"";
        String inputToTestNotCorrect = "22+ 3/ ( 5	+1 ))-\"1 -		-3\"";
        InputPreDetermination ipd = new InputPreDetermination();
        assertTrue(ipd.checkCorrectParenthesisCount(inputToTestCorrect));
        assertFalse(ipd.checkCorrectParenthesisCount(inputToTestNotCorrect));
    }
}
