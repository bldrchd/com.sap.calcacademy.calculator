package newCalc;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputDeterminationTest {

	@Test
	public void valueStackFillTest() {
		String inputString = "22+(3/5)+1-1-(-3)";
		InputDetermination id = new InputDetermination();
		id.determinate(inputString);
		String[] postfixExpression_Actual = id.buildFinalPostfixExpression();
		String[] postfixExpression_Expected = {"22.0","3.0","5.0","/","1.0","1.0","-3.0","-","-","+","+"};
		for (int i = 0; i<=postfixExpression_Actual.length-1; i++) {
			assertTrue(postfixExpression_Expected[i].equals(postfixExpression_Actual[i])); 
		}
	}

/*	@Test
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
	}*/
}
