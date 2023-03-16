package com.popjak;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicMethodsTest {
    BasicMethods basicMethods = new BasicMethods();
    @Test
    void isTextConvertedToUpperCase() {
        assertEquals("HELLO", basicMethods.toUpperCaseTextConverter("hello"));
        assertEquals("HELLO", basicMethods.toUpperCaseTextConverter("hElLo"));
    }
    @Test
    void isTextConvertedToTitleCase() {
        assertEquals("Andrej",basicMethods.toTitleCaseTextConverter("andrej"));
        assertEquals("Andrej",basicMethods.toTitleCaseTextConverter("anDreJ"));
    }

}