package com.popjak.car;

import java.math.BigDecimal;
import java.util.Objects;

public class Car {
    private String regNum;
    private String carName;
    private String year;
    private EngineType engineType;
    private BigDecimal rentPerDay;

    public Car(String regNum, String carName, String year, EngineType engineType, BigDecimal rentPerDay) {
        this.regNum = regNum;
        this.carName = carName;
        this.year = year;
        this.engineType = engineType;
        this.rentPerDay = rentPerDay;
    }

    @Override
    public String toString() {
        return regNum.toUpperCase() + "," +
                carName.toUpperCase() + "," +
                year.toUpperCase() + "," +
                engineType + "," +
                rentPerDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(regNum, car.regNum) && Objects.equals(carName, car.carName) && Objects.equals(year, car.year) && engineType == car.engineType && Objects.equals(rentPerDay, car.rentPerDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNum, carName, year, engineType, rentPerDay);
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public BigDecimal getRentPerDay() {
        return rentPerDay;
    }

    public void setRentPerDay(BigDecimal rentPerDay) {
        this.rentPerDay = rentPerDay;
    }
}
