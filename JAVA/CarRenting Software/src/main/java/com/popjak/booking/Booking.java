package com.popjak.booking;

import com.popjak.car.Car;
import com.popjak.user.User;

import java.time.LocalDateTime;
import java.util.Random;

public class Booking {
    private final Car car;
    private final User user;
    private final int bookingId;
    private final String date;

    public Booking(Car car, User user) {
        this.car = car;
        this.user = user;
        Random random = new Random();
        this.bookingId = random.nextInt(10000,99999);
        LocalDateTime local = LocalDateTime.now();
        this.date = local.getDayOfMonth() + "." + local.getMonthValue() + "." + local.getYear();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "car=" + car +
                ", user=" + user +
                ", bookingId=" + bookingId +
                ", date='" + date + '\'' +
                '}';
    }
    public String detailedString() {

        return "BookingID: "  + user.getUserid().substring(0, 6)
                + "-******, " + user.getName() + ", Car: " + car.getCarName() + " " + car.getYear() + ", " +
                car.getPowerInKw() + "kw, " + car.getEngineType() + ",   " + car.getRentPerDay() + " per day. Car booked date: " +
                getDate();
        // TODO detailed string
    }

    public Car getCar() {
        return car;
    }

    public User getUser() {
        return user;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getDate() {
        return date;
    }
}