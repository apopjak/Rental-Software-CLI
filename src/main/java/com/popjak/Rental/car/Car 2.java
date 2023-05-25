package com.popjak.Rental.car;

import jakarta.persistence.*;

import java.util.*;

@Entity
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

    public Car() {
    }

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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(Id, car.Id) && Objects.equals(regNum, car.regNum) && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(year, car.year) && Objects.equals(kw, car.kw) && Objects.equals(engine, car.engine) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, regNum, brand, model, year, kw, engine, price);
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getKw() {
        return kw;
    }

    public void setKw(String kw) {
        this.kw = kw;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}