package com.epam.JUnit;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Before
    public void setUp() {
        Calculator calculatorSetUp = new Calculator();
    }

    @Test
    void sumTest() {
        Calculator calculator = new Calculator();
        double actualValue = calculator.sum(4.4, 5);
        double expectedValue = 9.4f;
        assertEquals(expectedValue, actualValue, 0.1);
    }

    public static Object[][] sumTestData() {
        return new Object[][]{
                {2, 2, 4},
                {10, 1, 11},
                {1000000, -1000000, 0}
        };
    }

    @ParameterizedTest
    @MethodSource("sumTestData")
    public void dataProviderTest(double firstoperand, double secondoperand, double expectedSum) {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(expectedSum, calculator.sum(firstoperand, secondoperand));
    }

    @Test
    void subtractTest() {
        Calculator calculatorOne = new Calculator();
        Calculator calculatorSecond = new Calculator();
        assertEquals(calculatorSecond.subtract(5.5, 1.5), calculatorOne.subtract(8, 4));

    }

    @Test
    void multiplicationTest() {
        Calculator calculator = new Calculator();
        double actualValue = calculator.multiplication(4, 5);
        double expectedValue = 20;
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void divisionTest() {
        Calculator calculator = new Calculator();
        double actualValue = calculator.division(8, 5);
        double expectedValue = 1.6;
        assertEquals(expectedValue, actualValue);
    }


    @Test
    public void divideByZero() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> calculator.division(8, 0));
    }

    @Test
    void getSin() {
        Calculator calculator = new Calculator();
        assertEquals(calculator.getSin(Math.PI), 0, 0.1);
    }

    @Test
    void getCos() {
        Calculator calculator = new Calculator();
        assertEquals(calculator.getCos(Math.PI), 1, 0.1);
    }

    @Test
    void equalitySinAndCos() {
        Calculator calculator = new Calculator();
        assertTrue(calculator.getCos(Math.PI / 4) == calculator.getCos(Math.PI / 4));
    }


    @Test
    void getTan() {
        Calculator calculator = new Calculator();
        assertEquals(calculator.getTan(0), 0, 0.1);
    }

    @Test
    void equalitySinDivideCosWithTan() {
        Calculator calculator = new Calculator();
        assertTrue(calculator.getSin(0) / calculator.getCos(0) == calculator.getTan(0));
    }

    @Test
    void checkingTrigonometricIdentity() {
        Calculator calculator = new Calculator();
        assertTrue(calculator.getCos(Math.PI) * calculator.getCos(Math.PI) + calculator.getSin(Math.PI) * calculator.getSin(Math.PI) == 1);
    }

    @Test
    public void getNegativeSin() {
        Calculator calculator = new Calculator();
        assertDoesNotThrow(() -> calculator.getSin(-5));
    }

}