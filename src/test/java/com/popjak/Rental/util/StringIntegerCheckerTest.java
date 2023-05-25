package com.popjak.Rental.util;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StringIntegerCheckerTest {

    @Test
    @DisplayName("Check if passed string is integer")
    void stringIntegerChecker() {
        assertEquals("5",StringIntegerChecker.stringIntegerChecker("5"));
    }

    @Test
    @DisplayName("Check if passed string is null that means it is not integer")
    void itShouldReturnNull() {
        assertNull(StringIntegerChecker.stringIntegerChecker("dasd"));
        assertNull(StringIntegerChecker.stringIntegerChecker(""));
    }
}