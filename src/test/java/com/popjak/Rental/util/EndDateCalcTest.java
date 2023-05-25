package com.popjak.Rental.util;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EndDateCalcTest {


    @Test
    @DisplayName("Check if EndDate is calculated correctly")
    void itShouldCalculateEndDate() {
        assertEquals(EndDateCalc.endDateCalc(5),"29.MAY.2023");
    }


    @Test
    @DisplayName("Check if EndDate is calculated correctly")
    void itShouldNotCalculateEndDate() {
        assertNotEquals(EndDateCalc.endDateCalc(2),"29.MAY.2023");
    }

}