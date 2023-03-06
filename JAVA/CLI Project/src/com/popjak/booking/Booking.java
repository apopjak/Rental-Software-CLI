package com.popjak.booking;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class Booking {
    private final int bookingiD;
    private final String date;

    public Booking() {
        Random random = new Random();
        this.bookingiD = random.nextInt(10000,99999);
        LocalDateTime local = LocalDateTime.now();
        this.date = local.getDayOfMonth() + "." + local.getMonthValue() + "." + local.getYear();
    }

    @Override
    public String toString() {
        return bookingiD +
                "," + date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return bookingiD == booking.bookingiD && Objects.equals(date, booking.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingiD, date);
    }
}
