package com.popjak.booking;

import java.time.LocalDateTime;
import java.util.Random;

public class Booking {

    private final int bookingId;
    private final String date;

    public Booking() {
        Random random = new Random();
        this.bookingId = random.nextInt(10000,99999);
        LocalDateTime local = LocalDateTime.now();
        this.date = local.getDayOfMonth() + "." + local.getMonthValue() + "." + local.getYear();
    }

    @Override
    public String toString() {
        return "," + bookingId +
                "," + date;
    }
}
