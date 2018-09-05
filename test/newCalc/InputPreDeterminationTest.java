package newCalc;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputPreDeterminationTest {

	@Test
	public void checkIfContainsLetters() {
		String[] inputToTest = { "22+ a/ 4* 156 -c 	/123 -4 - -3" };
		InputPreDetermination id = new InputPreDetermination();
		assertEquals(true, id.findLetters(inputToTest));
	}
	
	@Test
	public void checkForWhiteSpaces() {
		String inputToTest = "22+ 3/ 5	+1 -\"1 -		-3\"";
		InputPreDetermination id = new InputPreDetermination();
		assertEquals(true, id.checkForWhiteSpaces(inputToTest));
	}
	
	@Test
	public void checkForRemovedWhiteSpaces() {
		String inputToTest = "22+ 3/ 5	+1 -\"1 -		-3\"";
		String expected = "22+3/5+1-\"1--3\"";
		InputPreDetermination id = new InputPreDetermination();
		assertEquals(expected, id.removeWhiteSpaces(inputToTest));
	}
}
