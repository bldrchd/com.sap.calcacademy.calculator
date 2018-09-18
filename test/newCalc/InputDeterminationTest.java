package newCalc;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputDeterminationTest {

	@Test
	public void expectedPostfixExpressionTest() { //TODO
		String inputString = "22+(3/5)+1-1-(-3)";
		InputDetermination id = new InputDetermination();
		id.determinate(inputString);
		String[] postfixExpression_Actual = id.buildFinalPostfixExpression();
		String[] postfixExpression_Expected = {"22.0","3.0","5.0","/","+","1.0","+","1","-","3","-","-"};
		for (int i = 0; i<=postfixExpression_Actual.length-1; i++) {
			assertTrue(postfixExpression_Expected[i].equals(postfixExpression_Actual[i])); 
		}
	}
	@Test
	public void expectedPostfixExpression_SimpleTest() {
		String inputString = "2+2";
		InputDetermination id = new InputDetermination();
		id.determinate(inputString);
		String[] postfixExpression_Actual = id.buildFinalPostfixExpression();
		String[] postfixExpression_Expected = {"2.0","2.0","+"};
		for (int i = 0; i<=postfixExpression_Actual.length-1; i++) {
			assertTrue(postfixExpression_Expected[i].equals(postfixExpression_Actual[i])); 
		}
	}
	@Test
	public void expectedPostfixExpression_SimpleWithDivisionTest() {
		String inputString = "2+2/3";
		InputDetermination id = new InputDetermination();
		id.determinate(inputString);
		String[] postfixExpression_Actual = id.buildFinalPostfixExpression();
		String[] postfixExpression_Expected = {"2.0","2.0","3.0","/","+"};
		for (int i = 0; i<=postfixExpression_Actual.length-1; i++) {
			assertTrue(postfixExpression_Expected[i].equals(postfixExpression_Actual[i])); 
		}
	}
	@Test
	public void expectedPostfixExpression_SimpleWithDivisionAndParenthesisTest() {
		String inputString = "(2+2)/3";
		InputDetermination id = new InputDetermination();
		id.determinate(inputString);
		String[] postfixExpression_Actual = id.buildFinalPostfixExpression();
		String[] postfixExpression_Expected = {"2.0","2.0","+","3.0","/"};
		for (int i = 0; i<=postfixExpression_Actual.length-1; i++) {
			assertTrue(postfixExpression_Expected[i].equals(postfixExpression_Actual[i])); 
		}
	}
}
