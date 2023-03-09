package com.popjak.car;

import java.util.Objects;

public class Car {
    private final String spz;
    private final String brand;
    private final String model;
    private final int year;
    private final String engineType;
    private final String rentPerDay;

    public Car(String spz, String znacka, String model, int rocnik, String engineType, String najomNaDenCena) {
        this.spz = spz;
        this.brand = znacka;
        this.model = model;
        this.year = rocnik;
        this.engineType = engineType;
        this.rentPerDay = najomNaDenCena;
    }

    @Override
    public String toString() {
        return  spz +
                "," + brand +
                "," + model +
                "," + year +
                "," + engineType +
                "," + rentPerDay + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && engineType == car.engineType && Objects.equals(spz, car.spz) && Objects.equals(rentPerDay, car.rentPerDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, engineType, spz, rentPerDay);
    }



}
