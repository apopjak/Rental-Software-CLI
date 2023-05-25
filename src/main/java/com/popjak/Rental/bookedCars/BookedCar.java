package com.popjak.Rental.bookedCars;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "booked_car_data")
public class BookedCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "reg_num")
    private String regNum;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private String year;

    @Column(name = "kw")
    private String kw;

    @Column(name = "engine")
    private String engine;

    @Column(name = "price")
    private String price;

    public BookedCar(String regNum, String brand, String model, String year, String kw, String engine, String price) {
        this.regNum = regNum;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.kw = kw;
        this.engine = engine;
        this.price = price;
    }
}