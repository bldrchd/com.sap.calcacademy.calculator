package newCalc;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputPreDeterminationTest {

	@Test
	public void checkIfContainsLettersTest() {
		String[] inputToTest = { "22+ a/ 4* 156 -c 	/123 -4 - -3" };
		InputPreDetermination ipd = new InputPreDetermination();
		assertEquals(true, ipd.findLetters(inputToTest));
	}

	@Test
	public void checkForWhiteSpacesTest() {
		String inputToTest = "22+ 3/ 5	+1 -\"1 -		-3\"";
		InputPreDetermination ipd = new InputPreDetermination();
		assertEquals(true, ipd.checkForWhiteSpaces(inputToTest));
	}

	@Test
	public void checkForRemovedWhiteSpacesTest() {
		String inputToTest = "22+ 3/ 5	+1 -\"1 -		-3\"";
		String expected = "22+3/5+1-\"1--3\"";
		InputPreDetermination ipd = new InputPreDetermination();
		assertEquals(expected, ipd.removeWhiteSpaces(inputToTest));
	}

	@Test
	public void checkCorrectParenthesisCountTest() {
		String inputToTestCorrect = "22+ 3/ ( 5	+1 )-\"1 -		-3\"";
		String inputToTestNotCorrect = "22+ 3/ ( 5	+1 ))-\"1 -		-3\"";
		InputPreDetermination ipd = new InputPreDetermination();
		assertTrue(ipd.checkCorrectParenthesisCount(inputToTestCorrect));
		assertFalse(ipd.checkCorrectParenthesisCount(inputToTestNotCorrect));
	}
}
