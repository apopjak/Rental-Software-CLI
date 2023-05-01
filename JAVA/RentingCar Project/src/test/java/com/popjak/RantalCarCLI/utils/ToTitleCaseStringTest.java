package com.popjak.RantalCarCLI.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ToTitleCaseStringTest {

    @Test
    void checkIfStringIsTitleCased() {
        // given
        String test1 = "andrej";
        String test2 = "aNDREJ";
        String test3 = "ANDREJ";
        String test4 = "an dre J";

        // when
        String result1 = ToTitleCaseString.titleCase(test1);
        String result2 = ToTitleCaseString.titleCase(test2);
        String result3 = ToTitleCaseString.titleCase(test3);
        String result4 = ToTitleCaseString.titleCase(test4);
        // then
        assertThat(result1).isEqualTo("Andrej");
        assertThat(result2).isEqualTo("Andrej");
        assertThat(result3).isEqualTo("Andrej");
        assertThat(result4).isEqualTo("An dre j");
    }
}