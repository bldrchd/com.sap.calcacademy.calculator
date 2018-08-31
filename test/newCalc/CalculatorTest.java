package newCalc;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test 
	public void testOverallCalculate(){
		String[] args = {"1+", "2"};
		Calculator calc = new Calculator();
		assertNotNull(calc.calculate(args));
	}
	@Test
	public void testInputParser_notNull(){
		String[] args = {"1+", "2"};
		InputParser ip = new InputParser();
		Expression exp = ip.parse(args);
		assertNotNull(exp);
	}
	
	@Test
	public void testOverallOperations(){
		String[] args1 = {"2+2"}, args2 = {"2-2"}, args3 = {"2*2"}, args4 = {"2/2"};
		Calculator calculator = new Calculator();
		assertEquals(4, calculator.calculate(args1));
		assertEquals(4, calculator.calculate(args2));
		assertEquals(0, calculator.calculate(args3));
		assertEquals(1, calculator.calculate(args4));
	}
	@Test
	public void testAddOperation(){
		Operation operation = new AddOperation();
	//public void testAddOperation(Operation operation){
		Number result = operation.execute(1, 2);
		assertEquals(3.0, result);
	}
	@Test
	public void testSubtractOperation(){
		SubtractOperation subtract = new SubtractOperation();
		assertEquals(3.0, subtract.execute(6, 3));
	}	
	@Test
	public void testMultiplyOperation(){
		MultiplyOperation multiply = new MultiplyOperation();
		assertEquals(18.0, multiply.execute(6, 3));
	}
	@Test
	public void testDivideOperation(){
		DivideOperation divide = new DivideOperation();
		Number result = divide.execute(6, 3);
		assertEquals(2.0, result);
		Number result1 = divide.execute(1, 2);
		assertEquals(0.5, result1);
	}
	
	@Test
	public void testExpression(){
		Number add = new AddOperation().execute(1, 2);
		assertTrue(add.equals(new AddOperation().execute(1, 2)));
		assertFalse(add.equals(new AddOperation().execute(2, 3)));
	}
	@Test
	public void testToken(){
		String operator = "+";
		Token t = new Token(operator);
		//System.out.println(t.operatorToString(t));
		assertTrue(t.operatorToString(t).equals(operator));
		Number operand1 = 1;
		Token t1 = new Token(operand1.doubleValue());
		assertTrue(t1.operandToDouble(t1).equals(operand1.doubleValue()));
		Token t2 = new Token("-");
		Number A = t2.evaluate(1, 2).execute();
		Number B = -1.0;
		assertEquals(B, A);
	}
	@Test
	public void testTokenStack_notEmpty(){
		TokenStack ts = new TokenStack();
		Token t1 = new Token(1);
		ts.push(t1);
		assertTrue(!ts.isEmpty());
	}
		
}
