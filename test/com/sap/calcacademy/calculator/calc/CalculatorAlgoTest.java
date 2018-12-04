package com.sap.calcacademy.calculator.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorAlgoTest {

    @Test
    public void testNegativeWithParentheses() {
        String args2 = "2+(-2)";
        CalculationAlgo calculator = new CalculationAlgo();
        assertEquals(0.0, Double.parseDouble(calculator.startCalculating(args2)), 0.01);
    }

    @Test
    public void testOverallOperations() {
        String args1 = "2+2", args2 = "2-2", args3 = "2*2", args4 = "2/2";
        CalculationAlgo calculator = new CalculationAlgo();
        assertEquals(4.0, Double.parseDouble(calculator.startCalculating(args1)), 0.01);
        assertEquals(0.0, Double.parseDouble(calculator.startCalculating(args2)), 0.01);
        assertEquals(4.0, Double.parseDouble(calculator.startCalculating(args3)), 0.01);
        assertEquals(1.0, Double.parseDouble(calculator.startCalculating(args4)), 0.01);
    }

    @Test
    public void testSimpleSum() {
        String args = "1+2";
        CalculationAlgo calc = new CalculationAlgo();
        assertEquals(3.0, Double.parseDouble(calc.startCalculating(args)), 0.01);
    }

    @Test
    public void testSimpleSumWithParentheses() {
        String args = "(1+2)";
        CalculationAlgo calc = new CalculationAlgo();
        assertEquals(3.0, Double.parseDouble(calc.startCalculating(args)), 0.01);
    }

    @Test
    public void testSimpleSumWithValuesAbove9() {
        String args = "(10+1)";
        CalculationAlgo calc = new CalculationAlgo();
        assertEquals(11.0, Double.parseDouble(calc.startCalculating(args)), 0.01);
    }

    @Test
    public void testCustomStrings() {
        Double result;
        CalculationAlgo calc = new CalculationAlgo();

        result = Double.parseDouble(calc.startCalculating("9/3/3"));
        assertEquals(1.0, result, 0.01);
        result = Double.parseDouble(calc.startCalculating("4*(5*(3*(4+1)))"));
        assertEquals(300.0, result, 0.01);
        result = Double.parseDouble(calc.startCalculating("(-4-1)*3"));
        assertEquals(-15.0, result, 0.01);

        result = Double.parseDouble(calc.startCalculating("(-4-1)*3+2*(1+1)"));
        assertEquals(-11.0, result, 0.01);

        result = Double.parseDouble(calc.startCalculating("-4*(3+1)+2"));
        assertEquals(-14.0, result, 0.01);

        result = Double.parseDouble(calc.startCalculating("2*(1+2)-4"));
        assertEquals(2.0, result, 0.01);

        result = Double.parseDouble(calc.startCalculating("((4-1)*2+3*(1-1))"));
        assertEquals(6.0, result, 0.01);

        result = Double.parseDouble(calc.startCalculating("2+(-2)"));
        assertEquals(0.0, result, 0.01);

    }
}
