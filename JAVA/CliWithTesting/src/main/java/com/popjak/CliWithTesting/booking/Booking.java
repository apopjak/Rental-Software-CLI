package com.popjak.CliWithTesting.booking;

import jakarta.persistence.*;

import java.time.*;
import java.util.*;

@Entity
@Table(name = "bookind_data")

public class Booking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "booking_date")
    private final LocalDate bookingDate = LocalDate.now();

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "car_id")
    private String CarId;

    @Column(name = "user_id")
    private String UserId;

    public Booking() {
    }

    public Booking(String endDate, String carId, String userId) {
        this.endDate = endDate;
        CarId = carId;
        UserId = userId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "Id=" + Id +
                ", bookingDate=" + bookingDate +
                ", endDate='" + endDate + '\'' +
                ", CarId='" + CarId + '\'' +
                ", UserId='" + UserId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(Id, booking.Id) && Objects.equals(bookingDate, booking.bookingDate) && Objects.equals(endDate, booking.endDate) && Objects.equals(CarId, booking.CarId) && Objects.equals(UserId, booking.UserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, bookingDate, endDate, CarId, UserId);
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCarId() {
        return CarId;
    }

    public void setCarId(String carId) {
        CarId = carId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
