package com.popjak;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void isSubtractionCorrect() {
        Calculator calculator = new Calculator();
        assertEquals(-5,calculator.subtract(10,15));
        assertEquals(5,calculator.subtract(10,5));
    }
}