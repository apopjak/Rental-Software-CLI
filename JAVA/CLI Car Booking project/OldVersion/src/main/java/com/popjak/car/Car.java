package com.popjak.car;

import java.util.Objects;

public class Car {
    private final String regNum;
    private final String carName;
    private final String year;
    private final String engineType;
    private final String powerInKw;
    private final int rentPerDay;

    public Car(String regNum, String carName, String year, String engineType, String powerInKw, String rentPerDay) {
        this.regNum = regNum;
        this.carName = carName;
        this.year = year;
        this.engineType = engineType;
        this.powerInKw = powerInKw;
        this.rentPerDay = Integer.parseInt(rentPerDay);
    }

    @Override
    public String toString() {
        return regNum +
                "," + carName +
                "," + year +
                "," + powerInKw +
                "," + engineType +
                "," + rentPerDay;
    }
    public String toDetailedString() {
        return regNum +
                ", " + carName +
                ", " + year +
                ", " + powerInKw + "kw, " +
                engineType +
                ", " + rentPerDay + "€ per day";
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

    public String getCarName() {
        return carName;
    }


    public String getYear() {
        return year;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getPowerInKw() {
        return powerInKw;
    }

    public int getRentPerDay() {
        return rentPerDay;
    }
}
