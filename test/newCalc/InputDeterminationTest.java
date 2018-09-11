package newCalc;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputDeterminationTest {

	@Test
	public void valueStackFillTest() {
		String inputString = "22+3/5+1-1--3";
		InputDetermination id = new InputDetermination();
		id.determinate(inputString);
		TokenStack actual = id.getValueStackContent();
		Token t1 = new Token(22), t2 = new Token(3), t3 = new Token(5), t4 = new Token(1), t5 = new Token(1),
				t6 = new Token(3);
		TokenStack expected = new TokenStack();
		expected.push(t1);
		expected.push(t2);
		expected.push(t3);
		expected.push(t4);
		expected.push(t5);
		expected.push(t6);
		assertTrue(expected.equals(actual));
	}

	@Test
	public void operatorStackFillTest() {
		String inputString = "22+3/5+1-1--3";
		InputDetermination id = new InputDetermination();
		id.determinate(inputString);
		TokenStack actual = id.getOperatorStackContent();
		Token t1 = new Token('+'), t2 = new Token('/'), t3 = new Token('+'), t4 = new Token('-'), t5 = new Token('-'),
				t6 = new Token('-');
		TokenStack expected = new TokenStack();
		expected.push(t1);
		expected.push(t2);
		expected.push(t3);
		expected.push(t4);
		expected.push(t5);
		expected.push(t6);
		assertTrue(expected.equals(actual));
	}
}
