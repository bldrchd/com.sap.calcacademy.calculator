package com.sap.calcacademy.calculator.calc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;

public class CalculatorAlgoTest {
    @Ignore
    @Test
    public void testNotNullCalculate() {
        String args = "1+ 2";
        CalculationAlgo calc = new CalculationAlgo();
        assertNotNull(calc.parentheses(args));
    }

    @Test
    public void testOverallOperations() {
        String args1 = "2+2", args2 = "2-2", args3 = "2*2", args4 = "2/2";
        CalculationAlgo calculator = new CalculationAlgo();
        assertEquals(4.0, Double.parseDouble(calculator.parentheses(args1)), 0.01);
        assertEquals(0.0, Double.parseDouble(calculator.parentheses(args2)), 0.01);
        assertEquals(4.0, Double.parseDouble(calculator.parentheses(args3)), 0.01);
        assertEquals(1.0, Double.parseDouble(calculator.parentheses(args4)), 0.01);
    }

    @Test
    public void testSimpleSum() {
        String args = "1+2";
        CalculationAlgo calc = new CalculationAlgo();
        assertEquals(3.0, Double.parseDouble(calc.parentheses(args)), 0.01);
    }

    @Test
    public void testSimpleSumWithParentheses() {
        String args = "(1+2)";
        CalculationAlgo calc = new CalculationAlgo();
        assertEquals(3.0, Double.parseDouble(calc.parentheses(args)), 0.01);
    }

    @Test
    public void testSimpleSumWithValuesAbove9() {
        String args = "(10+1)";
        CalculationAlgo calc = new CalculationAlgo();
        assertEquals(11.0, Double.parseDouble(calc.parentheses(args)), 0.01);
    }

}
