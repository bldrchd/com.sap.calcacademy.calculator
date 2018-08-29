package newCalc;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	
	@Test 
	public void testInputString(){
		Calculator calc = new Calculator();
		assertNotNull(calc.calculate("1+1"));
	}
	@Test
	public void testInputParser(){
		InputParser ip = new InputParser();
		Expression exp = ip.parse("2+2");
		assertNotNull(exp);
	}
	
	@Test
	public void testOperations(){
		Calculator calculator = new Calculator();
		assertEquals(4, calculator.calculate("2+2"));
		assertEquals(4, calculator.calculate("2*2"));
		assertEquals(0, calculator.calculate("2-2"));
		assertEquals(1, calculator.calculate("2/2"));
	}
	@Test
	public void testAddOperation(Operation operation){
		Number result = operation.execute(1, 2);
		assertEquals(3, result);
	}
	@Test
	public void testSubtractOperation(){
		SubtractOperation subtract = new SubtractOperation();
		assertEquals(3, subtract.execute(6, 3));
	}	
	@Test
	public void testMultiplyOperation(){
		MultiplyOperation multiply = new MultiplyOperation();
		assertEquals(3, multiply.execute(6, 3));
	}
	@Test
	public void testDivideOperation(){
		DivideOperation divide = new DivideOperation();
		Number result = divide.execute(6, 3);
		assertEquals(2, result);
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
		assertTrue(operator.equals(t));
		Number operand1 = 1, operand2= 2;
		assertEquals(3, t.evaluate(operand1, operand2));
		Token t2 = new Token("-");
		assertEquals(-1, t2.evaluate(operand1, operand2));
	}
	@Test
	public void testTokenStack(){
		TokenStack ts = new TokenStack();
		Token t1 = new Token(1);
		Token t2 = new Token(2);
		ts.push(t1);
		ts.push(t2);
		assertTrue(!ts.isEmpty());
		assertEquals(2, ts.top());
		assertEquals(1, ts.toString()); //?
	}
		
}
