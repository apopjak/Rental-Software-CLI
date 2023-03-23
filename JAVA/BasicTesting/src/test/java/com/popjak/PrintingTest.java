package com.popjak;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrintingTest {
    @Test
    void isPrintedTextCorrect() {
        // given
        String text = "I love cats";
        // when
        Printing printing = new Printing();
        // Then
        assertEquals(text,printing.printText());
    }
}