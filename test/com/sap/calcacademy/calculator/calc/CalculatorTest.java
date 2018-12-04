package com.sap.calcacademy.calculator.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testOverallCalculate() {
        String args = "1+ 2";
        Calculator calc = new Calculator();
        assertEquals(3.0, calc.calculate(args));
        assertEquals(10.1, calc.calculate("10+0.1"));
    }

    @Test
    public void testOverallOperations() {
        String args1 = "2+2", args2 = "2-2", args3 = "2*2", args4 = "2/2";
        Calculator calculator = new Calculator();
        assertEquals(4.0, calculator.calculate(args1));
        assertEquals(0.0, calculator.calculate(args2));
        assertEquals(4.0, calculator.calculate(args3));
        assertEquals(1.0, calculator.calculate(args4));
    }

    /*
     * @Ignore
     * 
     * @Test public void testAddOperation() { Operation operation = new
     * AddOperation(); Number result = operation.execute(1, 2);
     * assertEquals(3.0, result); }
     * 
     * @Ignore
     * 
     * @Test public void testSubtractOperation() { SubtractOperation subtract =
     * new SubtractOperation(); assertEquals(3.0, subtract.execute(6, 3)); }
     * 
     * @Ignore
     * 
     * @Test public void testMultiplyOperation() { MultiplyOperation multiply =
     * new MultiplyOperation(); assertEquals(18.0, multiply.execute(6, 3)); }
     * 
     * @Ignore
     * 
     * @Test public void testDivideOperation() { DivideOperation divide = new
     * DivideOperation(); Number result = divide.execute(6, 3);
     * assertEquals(2.0, result); Number result1 = divide.execute(1, 2);
     * assertEquals(0.5, result1); }
     * 
     * @Ignore
     * 
     * @Test public void testExpression() { Number add = new
     * AddOperation().execute(1, 2); assertTrue(add.equals(new
     * AddOperation().execute(1, 2))); assertFalse(add.equals(new
     * AddOperation().execute(2, 3))); }
     */

    @Test
    public void testOverallOperations_Extended() {
        String args1 = "3+5-(12+1)", args2 = "2*7+15-9-(1-3)", args3 = "1/3+1/2", args4 = "1/2-1/4*2";
        Calculator calculator = new Calculator();
        assertEquals(-5.0, calculator.calculate(args1));
        assertEquals(22.0, calculator.calculate(args2));
        assertEquals(0.8333333333333333, calculator.calculate(args3));
        assertEquals(0.0, calculator.calculate(args4));
    }

    @Test
    public void testOverallOperations_doubleValues() {
        String args1 = "0.3+0.7", args2 = "14/0.123*2", args5 = "0.25*-1.5";
        Calculator calculator = new Calculator();
        assertEquals(1.0, calculator.calculate(args1));
        assertEquals(227.64227642276424, calculator.calculate(args2));
        assertEquals(-0.375, calculator.calculate(args5));
    }
}
