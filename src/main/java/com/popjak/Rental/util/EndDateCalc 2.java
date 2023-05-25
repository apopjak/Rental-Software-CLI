package com.popjak.Rental.util;

import java.time.*;

public class EndDateCalc {

    public static String endDateCalc(int days) {
        LocalDate endDate = LocalDate.now().plusDays(days);
        return endDate.getDayOfMonth() + "." + endDate.getMonth() + "." + endDate.getYear();
    }
}
