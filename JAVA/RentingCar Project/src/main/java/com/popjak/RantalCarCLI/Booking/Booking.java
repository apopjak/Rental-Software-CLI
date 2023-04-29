package com.popjak.RantalCarCLI.Booking;

import jakarta.persistence.*;

@Entity
@Table(name = "booking_data")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    




}
