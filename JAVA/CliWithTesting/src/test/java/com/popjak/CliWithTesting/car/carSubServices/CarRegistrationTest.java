package com.popjak.CliWithTesting.car.carSubServices;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CarRegistrationTest {
    // TEST of engineTypeChecker method
    // METHOD IS PRIVATE, MAKE IT PUBLIC BEFORE TESTING
    // TEST disabled when method private.

    @Test
    @Disabled
    @DisplayName("Check if engine type is correct")
    void itShouldReturnCorrectEngineType() {
        assertEquals("ELECTRIC",CarRegistration.engineTypeChecker("ele"));
        assertEquals("ELECTRIC",CarRegistration.engineTypeChecker("elec"));
        assertEquals("ELECTRIC",CarRegistration.engineTypeChecker("ELectric"));
        assertEquals("ELECTRIC",CarRegistration.engineTypeChecker("eLectric"));
        assertEquals("ELECTRIC",CarRegistration.engineTypeChecker("eLectric"));

        assertEquals("PETROL",CarRegistration.engineTypeChecker("Petrol"));
        assertEquals("PETROL",CarRegistration.engineTypeChecker("petr"));
        assertEquals("PETROL",CarRegistration.engineTypeChecker("PETROL"));

        assertEquals("HYBRID",CarRegistration.engineTypeChecker("hYb"));
        assertEquals("HYBRID",CarRegistration.engineTypeChecker("hybrid"));
        assertEquals("HYBRID",CarRegistration.engineTypeChecker("hybridw"));
    }

    @Test
    @Disabled
    @DisplayName("it should return null if incorrect input")
    void itShouldReturnNull() {
        assertNull(CarRegistration.engineTypeChecker(""));
        assertNull(CarRegistration.engineTypeChecker("dwa"));
        assertNull(CarRegistration.engineTypeChecker("23123"));

    }


}