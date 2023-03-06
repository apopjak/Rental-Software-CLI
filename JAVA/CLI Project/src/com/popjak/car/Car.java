package com.popjak.car;

import java.util.Objects;
import java.util.Scanner;

public class Car {
    private String spz;
    private String znacka;
    private String model;
    private int rocnik;
    private String engineType;
    private String najomNaDenCena;

    public Car(String spz, String znacka, String model, int rocnik, String engineType, String najomNaDenCena) {
        this.spz = spz;
        this.znacka = znacka;
        this.model = model;
        this.rocnik = rocnik;
        this.engineType = engineType;
        this.najomNaDenCena = najomNaDenCena;
    }

    @Override
    public String toString() {
        return  spz +
                "," + znacka +
                "," + model +
                "," + rocnik +
                "," + engineType +
                "," + najomNaDenCena + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return rocnik == car.rocnik && Objects.equals(znacka, car.znacka) && Objects.equals(model, car.model) && engineType == car.engineType && Objects.equals(spz, car.spz) && Objects.equals(najomNaDenCena, car.najomNaDenCena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(znacka, model, rocnik, engineType, spz, najomNaDenCena);
    }

    public String getZnacka() {
        return znacka;
    }

    public void setZnacka(String znacka) {
        this.znacka = znacka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRocnik() {
        return rocnik;
    }

    public void setRocnik(int rocnik) {
        this.rocnik = rocnik;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getSpz() {
        return spz;
    }

    public void setSpz(String spz) {
        this.spz = spz;
    }

    public String getNajomNaDenCena() {
        return najomNaDenCena;
    }

    public void setNajomNaDenCena(String najomNaDenCena) {
        this.najomNaDenCena = najomNaDenCena;
    }
}
