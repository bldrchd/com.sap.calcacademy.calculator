package newCalc;

import static org.junit.Assert.*;
import org.junit.Test;

public class RevPolishNotationTest {

	@Test
	public void testEvaluateRPN() { //TODO
		String[] postfixExpression = {"22.0","3.0","5.0","/","+","1.0","+","1","-","3","-","-"};
		Number expectedResult = 25.6;
		RevPolishNotation rpn = new RevPolishNotation();
		rpn.evaluateRPN(postfixExpression);
		assertEquals(expectedResult, rpn.getResult());
	}
	@Test
	public void testEvaluateRPN_Simple() {
		String[] postfixExpression = {"2.0","2.0","+"};
		Number expectedResult = 4.0;
		RevPolishNotation rpn = new RevPolishNotation();
		rpn.evaluateRPN(postfixExpression);
		assertEquals(expectedResult, rpn.getResult());
	}
	@Test
	public void testEvaluateRPN_SimpleWithDivision() { //TODO
		String[] postfixExpression = {"2.0","2.0","3.0","/","+"};
		Number expectedResult = 2.66666666667;
		RevPolishNotation rpn = new RevPolishNotation();
		rpn.evaluateRPN(postfixExpression);
		assertEquals(expectedResult, rpn.getResult());
	}

}
