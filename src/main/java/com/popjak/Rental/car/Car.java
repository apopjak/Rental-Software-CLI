package com.popjak.Rental.car;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "car_data")
public class Car {

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

    public Car(String regNum, String brand, String model, String year, String kw, String engine, String price) {
        this.regNum = regNum;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.kw = kw;
        this.engine = engine;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "ID: " + Id + " | " + brand + " " + model  + ", " +
                "year: " + year + ", " +
                "power: " + kw + "kw, " +
                "engine: " + engine + ", " +
                "regNumber: " + regNum  + ", " +
                "rent per day: " + price + "€";
    }


    public String registrationString() {
        return  "==================================\n"+ brand + " " + model  + "\n" +
                "year: " + year + "\n" +
                "power: " + kw + "kw, \n" +
                "engine: " + engine + "\n" +
                "regNumber: " + regNum  + "\n" +
                "rent per day: " + price + "€\n==================================";
    }
}