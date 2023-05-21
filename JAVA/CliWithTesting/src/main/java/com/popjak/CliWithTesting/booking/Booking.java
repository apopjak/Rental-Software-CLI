package com.popjak.CliWithTesting.booking;

import jakarta.persistence.*;

import java.time.*;
import java.time.format.*;
import java.util.*;

@Entity
@Table(name = "booking_data")

public class Booking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "booking_start_date")
    private LocalDate bookingDate;

    @Column(name = "booking_end_date")
    private LocalDate bookingEndDate;

    @Column(name = "reg_num")
    private String regNum;

    @Column(name = "user_email")
    private String userEmail;



    public Booking() {
    }

    public Booking(Integer bookingEndDate, String regNum, String userEmail) {
        this.bookingDate = LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        this.bookingEndDate = this.bookingDate.plusDays(bookingEndDate);
        this.regNum = regNum;
        this.userEmail = userEmail;
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

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getBookingEndDate() {
        return bookingEndDate;
    }

    public void setBookingEndDate(LocalDate bookingEndDate) {
        this.bookingEndDate = bookingEndDate;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "Id=" + Id +
                ", bookingDate=" + bookingDate +
                ", bookingEndDate=" + bookingEndDate +
                ", regNum='" + regNum + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(Id, booking.Id) && Objects.equals(bookingDate, booking.bookingDate) && Objects.equals(bookingEndDate, booking.bookingEndDate) && Objects.equals(regNum, booking.regNum) && Objects.equals(userEmail, booking.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, bookingDate, bookingEndDate, regNum, userEmail);
    }
}
