package newCalc;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputDeterminationTest {

	@Test
	public void checkIfContainsLetters() {
		String[] inputToTest = { "22+ a/ 4* 156 -c 	/123 -4 - -3" };
		InputDetermination id = new InputDetermination();
		assertEquals(true, id.findLetters(inputToTest));
	}
	
	@Test
	public void checkForWhiteSpaces() {
		String inputToTest = "22+ 3/ 5	+1 -\"1 -		-3\"";
		InputDetermination id = new InputDetermination();
		assertEquals(true, id.checkForWhiteSpaces(inputToTest));
	}
	
	@Test
	public void checkForRemovedWhiteSpaces() {
		String inputToTest = "22+ 3/ 5	+1 -\"1 -		-3\"";
		String expected = "22+3/5+1-\"1--3\"";
		InputDetermination id = new InputDetermination();
		assertEquals(expected, id.removeWhiteSpaces(inputToTest));
	}
}
