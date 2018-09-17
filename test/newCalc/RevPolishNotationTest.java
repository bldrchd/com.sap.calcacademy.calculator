package newCalc;

import static org.junit.Assert.*;
import org.junit.Test;

public class RevPolishNotationTest {

	@Test
	public void testEvaluateRPN() {
		String[] postfixExpression = {"22.0","3.0","5.0","/","+","1.0","+","1","-","3","-","-"};
		Number expectedResult = 25.6;
		RevPolishNotation rpn = new RevPolishNotation();
		rpn.evaluateRPN(postfixExpression);
		assertEquals(expectedResult, rpn.getResult());
	}

}
