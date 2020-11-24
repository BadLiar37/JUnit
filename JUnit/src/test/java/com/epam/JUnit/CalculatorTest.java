package com.epam.JUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    void sumTest() {
        double expectedValue = 9.4f;
        assertEquals(expectedValue, calculator.sum(4.4, 5), 0.1);
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
        double expectedValue = 20;
        assertEquals(calculator.multiplication(4, 5), expectedValue);
    }

    @Test
    void divisionTest() {
        double expectedValue = 1.6;
        assertEquals(expectedValue, calculator.division(8, 5));
    }

    @Test
    public void divideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.division(8, 0));
    }

    @Test
    void getSin() {
        assertEquals(calculator.getSin(Math.PI), 0, 0.1);
    }

    @Test
    void getCos() {
        assertEquals(calculator.getCos(Math.PI), 1, 0.1);
    }

    @Test
    void equalitySinAndCos() {
        assertTrue(calculator.getCos(Math.PI / 4) == calculator.getCos(Math.PI / 4));
    }


    @Test
    void getTan() {
        assertEquals(calculator.getTan(0), 0, 0.1);
    }

    @Test
    void equalitySinDivideCosWithTan() {
        assertTrue(calculator.getSin(0) / calculator.getCos(0) == calculator.getTan(0));
    }

    @Test
    void checkingTrigonometricIdentity() {
        assertTrue(calculator.getCos(Math.PI) * calculator.getCos(Math.PI) + calculator.getSin(Math.PI) * calculator.getSin(Math.PI) == 1);
    }

    @Test
    public void getNegativeSin() {
        assertDoesNotThrow(() -> calculator.getSin(-5));
    }
}