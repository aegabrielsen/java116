package tests;

import calculator.model.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCalculator {

    @Test
    public void testCalculator() {
        assertTrue(true);
    }


    @Test
    public void test1() {
        Calculator calc = new Calculator();
        assertEquals(0.0, calc.displayNumber(), 0.0002);
        calc.numberPressed(2);
        calc.numberPressed(4);
        assertEquals(24.0, calc.displayNumber(), 0.0002);
        calc.dividePressed();
        assertEquals(0.0, calc.displayNumber(), 0.0002);
        calc.numberPressed(2);
        assertEquals(2.0, calc.displayNumber(), 0.0002);
        calc.equalsPressed();
        assertEquals(12.0, calc.displayNumber(), 0.0002);
        calc.equalsPressed();
        assertEquals(6.0, calc.displayNumber(), 0.0002);
        calc.addPressed();
        assertEquals(0.0, calc.displayNumber(), 0.0002);
        calc.numberPressed(4);
        calc.decimalPressed();
        calc.numberPressed(4);
        assertEquals(4.4, calc.displayNumber(), 0.0002);
        calc.equalsPressed();
        assertEquals(10.4, calc.displayNumber(), 0.0002);
        calc.clearPressed();
        assertEquals(0.0, calc.displayNumber(), 0.0002);

    }

    @Test
    public void test2() {
        Calculator calc = new Calculator();
        calc.numberPressed(2);
        calc.decimalPressed();
        calc.decimalPressed();
        calc.decimalPressed();
        calc.decimalPressed();
        calc.numberPressed(2);
        calc.numberPressed(2);
        calc.numberPressed(2);
        assertEquals(2.222, calc.displayNumber(), 0.00002);
        calc.addPressed();
        calc.numberPressed(2);
        calc.decimalPressed();
        calc.numberPressed(2);
        calc.numberPressed(2);
        calc.numberPressed(2);
        calc.equalsPressed();
        assertEquals(4.444, calc.displayNumber(), 0.00002);
        calc.equalsPressed();
        assertEquals(6.666, calc.displayNumber(), 0.00002);
        calc.dividePressed();
        calc.numberPressed(2);
        calc.equalsPressed();
        assertEquals(3.333, calc.displayNumber(), 0.00002);
    }
}
