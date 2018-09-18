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
		System.out.println("From: 2+2/3");
		String[] postfixExpression = {"2.0","2.0","3.0","/","+"};
		Number expectedResult = 2.6666666666666665;
		RevPolishNotation rpn = new RevPolishNotation();
		rpn.evaluateRPN(postfixExpression);
		assertEquals(expectedResult, rpn.getResult());
	}
	@Test
	public void testEvaluateRPN_SimpleWithDivisionAndParenthesis() {
		System.out.println("From: (2+2)/3");
		String[] postfixExpression = {"2.0","2.0","+","3.0","/"};
		Number expectedResult = 1.3333333333333333;
		RevPolishNotation rpn = new RevPolishNotation();
		rpn.evaluateRPN(postfixExpression);
		assertEquals(expectedResult, rpn.getResult());
	}

}
