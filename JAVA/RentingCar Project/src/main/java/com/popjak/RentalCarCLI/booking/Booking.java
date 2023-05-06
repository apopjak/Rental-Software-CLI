package com.popjak.RentalCarCLI.booking;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "booking_data")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "car_reg_num")
    private Integer carRegNum;

    public Booking() {
    }

    public Booking(Integer userId, Integer carRegNum) {
        this.userId = userId;
        this.carRegNum = carRegNum;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "Id=" + Id +
                ", userId=" + userId +
                ", carRegNum=" + carRegNum +
                '}';
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCarRegNum() {
        return carRegNum;
    }

    public void setCarRegNum(Integer carRegNum) {
        this.carRegNum = carRegNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(Id, booking.Id) && Objects.equals(userId, booking.userId) && Objects.equals(carRegNum, booking.carRegNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, userId, carRegNum);
    }
}
