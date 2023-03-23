package com.popjak;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ComparisonTest {
    Comparison comparison = new Comparison();

    @Test
    void isABiggerThanB() {
        assertTrue(comparison.aIsHigherThanB(15,5));
    }

    @Test
    void areTwoStringEqual() {
        assertTrue(comparison.twoStrings("Hey", "Hey"));
    }
}